package io.qase.plugin.codeparsing.visitor;

import io.qase.plugin.codeparsing.CodeParsingConstants;
import io.qase.plugin.codeparsing.model.AnnotationInfo;
import io.qase.plugin.codeparsing.model.MethodInfo;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class MethodInfoVisitor extends MethodVisitor {

    private final MethodInfo methodInfo;

    public MethodInfoVisitor(MethodInfo methodInfo) {
        super(CodeParsingConstants.ASM_API_VERSION);
        this.methodInfo = methodInfo;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationInfo annotationInfo = new AnnotationInfo();
        annotationInfo.setAnnotationClassCanonicalName(Type.getType(desc).getClassName());
        methodInfo.addAnnotatedWith(annotationInfo);
        return new AnnotationInfoVisitor(annotationInfo);
    }
}
