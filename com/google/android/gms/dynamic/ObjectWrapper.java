package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public final class ObjectWrapper extends IObjectWrapper.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object zza;

    public ObjectWrapper(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = obj;
    }

    public static IObjectWrapper wrap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            return new ObjectWrapper(obj);
        }
        return (IObjectWrapper) invokeL.objValue;
    }

    public static Object unwrap(IObjectWrapper iObjectWrapper) {
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
                Preconditions.checkNotNull(field);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                    try {
                        return field.get(asBinder);
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
        return invokeL.objValue;
    }
}
