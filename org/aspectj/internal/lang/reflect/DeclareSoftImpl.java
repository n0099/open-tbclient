package org.aspectj.internal.lang.reflect;

import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.DeclareSoft;
import org.aspectj.lang.reflect.PointcutExpression;
/* loaded from: classes9.dex */
public class DeclareSoftImpl implements DeclareSoft {
    public AjType<?> declaringType;
    public AjType<?> exceptionType;
    public String missingTypeName;
    public PointcutExpression pointcut;

    public DeclareSoftImpl(AjType<?> ajType, String str, String str2) {
        this.declaringType = ajType;
        this.pointcut = new PointcutExpressionImpl(str);
        try {
            this.exceptionType = AjTypeSystem.getAjType(Class.forName(str2, false, ajType.getJavaClass().getClassLoader()));
        } catch (ClassNotFoundException unused) {
            this.missingTypeName = str2;
        }
    }

    @Override // org.aspectj.lang.reflect.DeclareSoft
    public AjType getDeclaringType() {
        return this.declaringType;
    }

    @Override // org.aspectj.lang.reflect.DeclareSoft
    public PointcutExpression getPointcutExpression() {
        return this.pointcut;
    }

    @Override // org.aspectj.lang.reflect.DeclareSoft
    public AjType getSoftenedExceptionType() throws ClassNotFoundException {
        if (this.missingTypeName == null) {
            return this.exceptionType;
        }
        throw new ClassNotFoundException(this.missingTypeName);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare soft : ");
        String str = this.missingTypeName;
        if (str != null) {
            stringBuffer.append(this.exceptionType.getName());
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append(ZeusCrashHandler.NAME_SEPERATOR);
        stringBuffer.append(getPointcutExpression().asString());
        return stringBuffer.toString();
    }
}
