package org.aspectj.runtime.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.runtime.internal.AroundClosure;
/* loaded from: classes9.dex */
public class JoinPointImpl implements ProceedingJoinPoint {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object _this;
    public AroundClosure arc;
    public Object[] args;
    public JoinPoint.StaticPart staticPart;
    public Object target;

    /* loaded from: classes9.dex */
    public static class EnclosingStaticPartImpl extends StaticPartImpl implements JoinPoint.EnclosingStaticPart {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnclosingStaticPartImpl(int i, String str, Signature signature, SourceLocation sourceLocation) {
            super(i, str, signature, sourceLocation);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, signature, sourceLocation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Signature) objArr2[2], (SourceLocation) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class StaticPartImpl implements JoinPoint.StaticPart {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        public String kind;
        public Signature signature;
        public SourceLocation sourceLocation;

        public StaticPartImpl(int i, String str, Signature signature, SourceLocation sourceLocation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, signature, sourceLocation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.kind = str;
            this.signature = signature;
            this.sourceLocation = sourceLocation;
            this.id = i;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.id;
            }
            return invokeV.intValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public String getKind() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.kind;
            }
            return (String) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public Signature getSignature() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.signature;
            }
            return (Signature) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public SourceLocation getSourceLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.sourceLocation;
            }
            return (SourceLocation) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toLongString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return toString(StringMaker.longStringMaker);
            }
            return (String) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toShortString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return toString(StringMaker.shortStringMaker);
            }
            return (String) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return toString(StringMaker.middleStringMaker);
            }
            return (String) invokeV.objValue;
        }

        public String toString(StringMaker stringMaker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, stringMaker)) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(stringMaker.makeKindName(getKind()));
                stringBuffer.append("(");
                stringBuffer.append(((SignatureImpl) getSignature()).toString(stringMaker));
                stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
                return stringBuffer.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    public JoinPointImpl(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {staticPart, obj, obj2, objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.staticPart = staticPart;
        this._this = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object[] getArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.args == null) {
                this.args = new Object[0];
            }
            Object[] objArr = this.args;
            Object[] objArr2 = new Object[objArr.length];
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            return objArr2;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public String getKind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.staticPart.getKind();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Signature getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.staticPart.getSignature();
        }
        return (Signature) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public SourceLocation getSourceLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.staticPart.getSourceLocation();
        }
        return (SourceLocation) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public JoinPoint.StaticPart getStaticPart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.staticPart;
        }
        return (JoinPoint.StaticPart) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.target;
        }
        return invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object getThis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this._this;
        }
        return invokeV.objValue;
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public Object proceed() throws Throwable {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AroundClosure aroundClosure = this.arc;
            if (aroundClosure == null) {
                return null;
            }
            return aroundClosure.run(aroundClosure.getState());
        }
        return invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toLongString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.staticPart.toLongString();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toShortString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.staticPart.toShortString();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.staticPart.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public Object proceed(Object[] objArr) throws Throwable {
        InterceptResult invokeL;
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr)) == null) {
            AroundClosure aroundClosure = this.arc;
            if (aroundClosure == null) {
                return null;
            }
            int flags = aroundClosure.getFlags();
            int i4 = 1048576 & flags;
            int i5 = 1;
            if ((65536 & flags) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((flags & 4096) != 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((flags & 256) != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if ((flags & 16) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((flags & 1) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object[] state = this.arc.getState();
            int i6 = i + 0;
            if (z2 && !z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i7 = i6 + i3;
            if (i != 0 && i2 != 0) {
                state[0] = objArr[0];
            } else {
                i5 = 0;
            }
            if (z2 && z3) {
                if (z) {
                    i5 = i2 + 1;
                    state[0] = objArr[i2];
                } else {
                    i5 = i + 1;
                    state[i] = objArr[i];
                }
            }
            for (int i8 = i5; i8 < objArr.length; i8++) {
                state[(i8 - i5) + i7] = objArr[i8];
            }
            return this.arc.run(state);
        }
        return invokeL.objValue;
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public void set$AroundClosure(AroundClosure aroundClosure) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aroundClosure) == null) {
            this.arc = aroundClosure;
        }
    }
}
