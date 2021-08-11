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
/* loaded from: classes2.dex */
public class JoinPointImpl implements ProceedingJoinPoint {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object _this;
    public AroundClosure arc;
    public Object[] args;
    public JoinPoint.StaticPart staticPart;
    public Object target;

    /* loaded from: classes2.dex */
    public static class EnclosingStaticPartImpl extends StaticPartImpl implements JoinPoint.EnclosingStaticPart {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnclosingStaticPartImpl(int i2, String str, Signature signature, SourceLocation sourceLocation) {
            super(i2, str, signature, sourceLocation);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, signature, sourceLocation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Signature) objArr2[2], (SourceLocation) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public JoinPointImpl(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {staticPart, obj, obj2, objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.staticPart.getKind() : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Signature getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.staticPart.getSignature() : (Signature) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public SourceLocation getSourceLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.staticPart.getSourceLocation() : (SourceLocation) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public JoinPoint.StaticPart getStaticPart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.staticPart : (JoinPoint.StaticPart) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.target : invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object getThis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this._this : invokeV.objValue;
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

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public void set$AroundClosure(AroundClosure aroundClosure) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aroundClosure) == null) {
            this.arc = aroundClosure;
        }
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toLongString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.staticPart.toLongString() : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toShortString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.staticPart.toShortString() : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.staticPart.toString() : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public Object proceed(Object[] objArr) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr)) == null) {
            AroundClosure aroundClosure = this.arc;
            if (aroundClosure == null) {
                return null;
            }
            int flags = aroundClosure.getFlags();
            int i2 = 1048576 & flags;
            int i3 = 1;
            boolean z = (65536 & flags) != 0;
            int i4 = (flags & 4096) != 0 ? 1 : 0;
            int i5 = (flags & 256) != 0 ? 1 : 0;
            boolean z2 = (flags & 16) != 0;
            boolean z3 = (flags & 1) != 0;
            Object[] state = this.arc.getState();
            int i6 = i4 + 0 + ((!z2 || z) ? 0 : 1);
            if (i4 == 0 || i5 == 0) {
                i3 = 0;
            } else {
                state[0] = objArr[0];
            }
            if (z2 && z3) {
                if (z) {
                    i3 = i5 + 1;
                    state[0] = objArr[i5];
                } else {
                    i3 = i4 + 1;
                    state[i4] = objArr[i4];
                }
            }
            for (int i7 = i3; i7 < objArr.length; i7++) {
                state[(i7 - i3) + i6] = objArr[i7];
            }
            return this.arc.run(state);
        }
        return invokeL.objValue;
    }

    /* loaded from: classes2.dex */
    public static class StaticPartImpl implements JoinPoint.StaticPart {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        public String kind;
        public Signature signature;
        public SourceLocation sourceLocation;

        public StaticPartImpl(int i2, String str, Signature signature, SourceLocation sourceLocation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, signature, sourceLocation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.kind = str;
            this.signature = signature;
            this.sourceLocation = sourceLocation;
            this.id = i2;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.intValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public String getKind() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.kind : (String) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public Signature getSignature() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.signature : (Signature) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public SourceLocation getSourceLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sourceLocation : (SourceLocation) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toLongString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? toString(StringMaker.longStringMaker) : (String) invokeV.objValue;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toShortString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? toString(StringMaker.shortStringMaker) : (String) invokeV.objValue;
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

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? toString(StringMaker.middleStringMaker) : (String) invokeV.objValue;
        }
    }
}
