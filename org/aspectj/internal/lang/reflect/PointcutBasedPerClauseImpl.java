package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.reflect.PerClauseKind;
import org.aspectj.lang.reflect.PointcutBasedPerClause;
import org.aspectj.lang.reflect.PointcutExpression;
/* loaded from: classes9.dex */
public class PointcutBasedPerClauseImpl extends PerClauseImpl implements PointcutBasedPerClause {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PointcutExpression pointcutExpression;

    /* renamed from: org.aspectj.internal.lang.reflect.PointcutBasedPerClauseImpl$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$aspectj$lang$reflect$PerClauseKind;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1922924846, "Lorg/aspectj/internal/lang/reflect/PointcutBasedPerClauseImpl$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1922924846, "Lorg/aspectj/internal/lang/reflect/PointcutBasedPerClauseImpl$1;");
                    return;
                }
            }
            int[] iArr = new int[PerClauseKind.values().length];
            $SwitchMap$org$aspectj$lang$reflect$PerClauseKind = iArr;
            try {
                iArr[PerClauseKind.PERCFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$PerClauseKind[PerClauseKind.PERCFLOWBELOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$PerClauseKind[PerClauseKind.PERTARGET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$PerClauseKind[PerClauseKind.PERTHIS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointcutBasedPerClauseImpl(PerClauseKind perClauseKind, String str) {
        super(perClauseKind);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {perClauseKind, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((PerClauseKind) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pointcutExpression = new PointcutExpressionImpl(str);
    }

    @Override // org.aspectj.lang.reflect.PointcutBasedPerClause
    public PointcutExpression getPointcutExpression() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.pointcutExpression;
        }
        return (PointcutExpression) invokeV.objValue;
    }

    @Override // org.aspectj.internal.lang.reflect.PerClauseImpl
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$PerClauseKind[getKind().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            stringBuffer.append("perthis(");
                        }
                    } else {
                        stringBuffer.append("pertarget(");
                    }
                } else {
                    stringBuffer.append("percflowbelow(");
                }
            } else {
                stringBuffer.append("percflow(");
            }
            stringBuffer.append(this.pointcutExpression.asString());
            stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
