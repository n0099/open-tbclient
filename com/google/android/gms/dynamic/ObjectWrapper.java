package com.google.android.gms.dynamic;

import android.os.IBinder;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.repackage.an9;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class ObjectWrapper<T> extends IObjectWrapper.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T zza;

    public ObjectWrapper(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = t;
    }

    @NonNull
    public static <T> T unwrap(@NonNull IObjectWrapper iObjectWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iObjectWrapper)) == null) {
            if (iObjectWrapper instanceof ObjectWrapper) {
                return ((ObjectWrapper) iObjectWrapper).zza;
            }
            IBinder asBinder = iObjectWrapper.asBinder();
            Field[] declaredFields = asBinder.getClass().getDeclaredFields();
            Field field = null;
            int i = 0;
            for (Field field2 : declaredFields) {
                if (!field2.isSynthetic()) {
                    i++;
                    field = field2;
                }
            }
            if (i == 1) {
                an9.d(field);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                    try {
                        return (T) field.get(asBinder);
                    } catch (IllegalAccessException e) {
                        throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
                    } catch (NullPointerException e2) {
                        throw new IllegalArgumentException("Binder object is null.", e2);
                    }
                }
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public static <T> IObjectWrapper wrap(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) ? new ObjectWrapper(t) : (IObjectWrapper) invokeL.objValue;
    }
}
