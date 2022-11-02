package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.annotation.Annotation;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareAnnotation;
import org.aspectj.lang.reflect.SignaturePattern;
import org.aspectj.lang.reflect.TypePattern;
/* loaded from: classes9.dex */
public class DeclareAnnotationImpl implements DeclareAnnotation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String annText;
    public AjType<?> declaringType;
    public DeclareAnnotation.Kind kind;
    public SignaturePattern signaturePattern;
    public Annotation theAnnotation;
    public TypePattern typePattern;

    /* renamed from: org.aspectj.internal.lang.reflect.DeclareAnnotationImpl$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1107077002, "Lorg/aspectj/internal/lang/reflect/DeclareAnnotationImpl$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1107077002, "Lorg/aspectj/internal/lang/reflect/DeclareAnnotationImpl$1;");
                    return;
                }
            }
            int[] iArr = new int[DeclareAnnotation.Kind.values().length];
            $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind = iArr;
            try {
                iArr[DeclareAnnotation.Kind.Type.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[DeclareAnnotation.Kind.Method.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[DeclareAnnotation.Kind.Field.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[DeclareAnnotation.Kind.Constructor.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DeclareAnnotationImpl(AjType<?> ajType, String str, String str2, Annotation annotation, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajType, str, str2, annotation, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.declaringType = ajType;
        if (str.equals("at_type")) {
            this.kind = DeclareAnnotation.Kind.Type;
        } else if (str.equals("at_field")) {
            this.kind = DeclareAnnotation.Kind.Field;
        } else if (str.equals("at_method")) {
            this.kind = DeclareAnnotation.Kind.Method;
        } else if (str.equals("at_constructor")) {
            this.kind = DeclareAnnotation.Kind.Constructor;
        } else {
            throw new IllegalStateException("Unknown declare annotation kind: " + str);
        }
        if (this.kind == DeclareAnnotation.Kind.Type) {
            this.typePattern = new TypePatternImpl(str2);
        } else {
            this.signaturePattern = new SignaturePatternImpl(str2);
        }
        this.theAnnotation = annotation;
        this.annText = str3;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public Annotation getAnnotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.theAnnotation;
        }
        return (Annotation) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public String getAnnotationAsText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.annText;
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public AjType<?> getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.declaringType;
        }
        return (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public DeclareAnnotation.Kind getKind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.kind;
        }
        return (DeclareAnnotation.Kind) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public SignaturePattern getSignaturePattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.signaturePattern;
        }
        return (SignaturePattern) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public TypePattern getTypePattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.typePattern;
        }
        return (TypePattern) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("declare @");
            int i = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[getKind().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            stringBuffer.append("constructor : ");
                            stringBuffer.append(getSignaturePattern().asString());
                        }
                    } else {
                        stringBuffer.append("field : ");
                        stringBuffer.append(getSignaturePattern().asString());
                    }
                } else {
                    stringBuffer.append("method : ");
                    stringBuffer.append(getSignaturePattern().asString());
                }
            } else {
                stringBuffer.append("type : ");
                stringBuffer.append(getTypePattern().asString());
            }
            stringBuffer.append(ZeusCrashHandler.NAME_SEPERATOR);
            stringBuffer.append(getAnnotationAsText());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
