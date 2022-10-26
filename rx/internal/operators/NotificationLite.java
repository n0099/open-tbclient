package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.yx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes9.dex */
public final class NotificationLite {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public final class OnErrorSentinel implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3;
        public transient /* synthetic */ FieldHolder $fh;
        public final Throwable e;

        public OnErrorSentinel(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = th;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Notification=>Error:" + this.e;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(361255245, "Lrx/internal/operators/NotificationLite;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(361255245, "Lrx/internal/operators/NotificationLite;");
                return;
            }
        }
        a = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 1;
            public transient /* synthetic */ FieldHolder $fh;

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? "Notification=>Completed" : (String) invokeV.objValue;
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
        b = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2;
            public transient /* synthetic */ FieldHolder $fh;

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? "Notification=>NULL" : (String) invokeV.objValue;
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
    }

    public static Object b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return invokeV.objValue;
    }

    public static boolean a(yx9 yx9Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, yx9Var, obj)) == null) {
            if (obj == a) {
                yx9Var.onCompleted();
                return true;
            } else if (obj == b) {
                yx9Var.onNext(null);
                return false;
            } else if (obj != null) {
                if (obj.getClass() == OnErrorSentinel.class) {
                    yx9Var.onError(((OnErrorSentinel) obj).e);
                    return true;
                }
                yx9Var.onNext(obj);
                return false;
            } else {
                throw new IllegalArgumentException("The lite notification can not be null");
            }
        }
        return invokeLL.booleanValue;
    }

    public static Object c(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            return new OnErrorSentinel(th);
        }
        return invokeL.objValue;
    }

    public static Throwable d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            return ((OnErrorSentinel) obj).e;
        }
        return (Throwable) invokeL.objValue;
    }

    public static Object e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
            if (obj == b) {
                return null;
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public static boolean f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
            if (obj == a) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            return obj instanceof OnErrorSentinel;
        }
        return invokeL.booleanValue;
    }

    public static Object h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            if (obj == null) {
                return b;
            }
            return obj;
        }
        return invokeL.objValue;
    }
}
