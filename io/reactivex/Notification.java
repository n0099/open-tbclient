package io.reactivex;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
/* loaded from: classes9.dex */
public final class Notification<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Notification<Object> COMPLETE;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-507708797, "Lio/reactivex/Notification;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-507708797, "Lio/reactivex/Notification;");
                return;
            }
        }
        COMPLETE = new Notification<>(null);
    }

    @NonNull
    public static <T> Notification<T> createOnComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (Notification<T>) COMPLETE;
        }
        return (Notification) invokeV.objValue;
    }

    @Nullable
    public Throwable getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.value;
            if (NotificationLite.isError(obj)) {
                return NotificationLite.getError(obj);
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    @Nullable
    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object obj = this.value;
            if (obj != null && !NotificationLite.isError(obj)) {
                return (T) this.value;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object obj = this.value;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isOnComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.value == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOnError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return NotificationLite.isError(this.value);
        }
        return invokeV.booleanValue;
    }

    public boolean isOnNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object obj = this.value;
            if (obj != null && !NotificationLite.isError(obj)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Notification(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = obj;
    }

    @NonNull
    public static <T> Notification<T> createOnError(@NonNull Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            ObjectHelper.requireNonNull(th, "error is null");
            return new Notification<>(NotificationLite.error(th));
        }
        return (Notification) invokeL.objValue;
    }

    @NonNull
    public static <T> Notification<T> createOnNext(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            ObjectHelper.requireNonNull(t, "value is null");
            return new Notification<>(t);
        }
        return (Notification) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof Notification) {
                return ObjectHelper.equals(this.value, ((Notification) obj).value);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object obj = this.value;
            if (obj == null) {
                return "OnCompleteNotification";
            }
            if (NotificationLite.isError(obj)) {
                return "OnErrorNotification[" + NotificationLite.getError(obj) + PreferencesUtil.RIGHT_MOUNT;
            }
            return "OnNextNotification[" + this.value + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
