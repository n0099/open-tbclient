package com.google.common.base;

import b.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public State f63135e;

    /* renamed from: f  reason: collision with root package name */
    public T f63136f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State DONE;
        public static final State FAILED;
        public static final State NOT_READY;
        public static final State READY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(61469288, "Lcom/google/common/base/AbstractIterator$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(61469288, "Lcom/google/common/base/AbstractIterator$State;");
                    return;
                }
            }
            READY = new State("READY", 0);
            NOT_READY = new State("NOT_READY", 1);
            DONE = new State(AdDownloadApkUtils.DL_STATUS_DONE, 2);
            State state = new State("FAILED", 3);
            FAILED = state;
            $VALUES = new State[]{READY, NOT_READY, DONE, state};
        }

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63137a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267518600, "Lcom/google/common/base/AbstractIterator$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267518600, "Lcom/google/common/base/AbstractIterator$a;");
                    return;
                }
            }
            int[] iArr = new int[State.values().length];
            f63137a = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63137a[State.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AbstractIterator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63135e = State.NOT_READY;
    }

    public abstract T a();

    public final T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f63135e = State.DONE;
            return null;
        }
        return (T) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f63135e = State.FAILED;
            this.f63136f = a();
            if (this.f63135e != State.DONE) {
                this.f63135e = State.READY;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n.w(this.f63135e != State.FAILED);
            int i2 = a.f63137a[this.f63135e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return c();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Iterator
    public final T next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (hasNext()) {
                this.f63135e = State.NOT_READY;
                T t = this.f63136f;
                this.f63136f = null;
                return t;
            }
            throw new NoSuchElementException();
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Iterator
    public final void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            throw new UnsupportedOperationException();
        }
    }
}
