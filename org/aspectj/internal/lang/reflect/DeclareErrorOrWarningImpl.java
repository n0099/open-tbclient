package org.aspectj.internal.lang.reflect;

import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.PointcutExpression;
/* loaded from: classes2.dex */
public class DeclareErrorOrWarningImpl implements DeclareErrorOrWarning {
    public AjType declaringType;
    public boolean isError;
    public String msg;
    public PointcutExpression pc;

    public DeclareErrorOrWarningImpl(String str, String str2, boolean z, AjType ajType) {
        this.pc = new PointcutExpressionImpl(str);
        this.msg = str2;
        this.isError = z;
        this.declaringType = ajType;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public AjType getDeclaringType() {
        return this.declaringType;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public String getMessage() {
        return this.msg;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public PointcutExpression getPointcutExpression() {
        return this.pc;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public boolean isError() {
        return this.isError;
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare ");
        if (isError()) {
            str = "error : ";
        } else {
            str = "warning : ";
        }
        stringBuffer.append(str);
        stringBuffer.append(getPointcutExpression().asString());
        stringBuffer.append(ZeusCrashHandler.NAME_SEPERATOR);
        stringBuffer.append("\"");
        stringBuffer.append(getMessage());
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
