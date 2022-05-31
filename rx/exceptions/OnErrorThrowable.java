package rx.exceptions;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.az9;
import com.repackage.cv9;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class OnErrorThrowable extends RuntimeException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -569558213262703934L;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean hasValue;
    public final Object value;

    /* loaded from: classes8.dex */
    public static class OnNextValue extends RuntimeException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3454462756050397899L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object value;

        /* loaded from: classes8.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public static final Set<Class<?>> a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1853026974, "Lrx/exceptions/OnErrorThrowable$OnNextValue$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1853026974, "Lrx/exceptions/OnErrorThrowable$OnNextValue$a;");
                        return;
                    }
                }
                a = a();
            }

            public static Set<Class<?>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(Boolean.class);
                    hashSet.add(Character.class);
                    hashSet.add(Byte.class);
                    hashSet.add(Short.class);
                    hashSet.add(Integer.class);
                    hashSet.add(Long.class);
                    hashSet.add(Float.class);
                    hashSet.add(Double.class);
                    return hashSet;
                }
                return (Set) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + renderValue(obj));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th) {
                    obj = th.getMessage();
                }
            }
            this.value = obj;
        }

        public static String renderValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
                if (obj == null) {
                    return StringUtil.NULL_STRING;
                }
                if (a.a.contains(obj.getClass())) {
                    return obj.toString();
                }
                if (obj instanceof String) {
                    return (String) obj;
                }
                if (obj instanceof Enum) {
                    return ((Enum) obj).name();
                }
                String b = az9.c().b().b(obj);
                if (b != null) {
                    return b;
                }
                return obj.getClass().getName() + ".class";
            }
            return (String) invokeL.objValue;
        }

        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnErrorThrowable(Throwable th) {
        super(th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {th};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Throwable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, th, obj)) == null) {
            if (th == null) {
                th = new NullPointerException();
            }
            Throwable b = cv9.b(th);
            if ((b instanceof OnNextValue) && ((OnNextValue) b).getValue() == obj) {
                return th;
            }
            cv9.a(th, new OnNextValue(obj));
            return th;
        }
        return (Throwable) invokeLL.objValue;
    }

    public static OnErrorThrowable from(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            if (th == null) {
                th = new NullPointerException();
            }
            Throwable b = cv9.b(th);
            if (b instanceof OnNextValue) {
                return new OnErrorThrowable(th, ((OnNextValue) b).getValue());
            }
            return new OnErrorThrowable(th);
        }
        return (OnErrorThrowable) invokeL.objValue;
    }

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.objValue;
    }

    public boolean isValueNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.hasValue : invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnErrorThrowable(Throwable th, Object obj) {
        super(th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {th, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Throwable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hasValue = true;
        if (!(obj instanceof Serializable)) {
            try {
                obj = String.valueOf(obj);
            } catch (Throwable th2) {
                obj = th2.getMessage();
            }
        }
        this.value = obj;
    }
}
