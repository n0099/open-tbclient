package com.google.vr.dynamite.client;

import android.os.IBinder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.vr.dynamite.client.IObjectWrapper;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public final class ObjectWrapper<T> extends IObjectWrapper.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T wrappedObject;

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
        this.wrappedObject = t;
    }

    public static <T> IObjectWrapper a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) {
            return new ObjectWrapper(t);
        }
        return (IObjectWrapper) invokeL.objValue;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, iObjectWrapper, cls)) == null) {
            if (iObjectWrapper == null) {
                return null;
            }
            if (iObjectWrapper instanceof ObjectWrapper) {
                return ((ObjectWrapper) iObjectWrapper).wrappedObject;
            }
            IBinder asBinder = iObjectWrapper.asBinder();
            Field[] declaredFields = asBinder.getClass().getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            Field field = null;
            while (true) {
                if (i >= length) {
                    break;
                }
                Field field2 = declaredFields[i];
                if (!field2.isSynthetic()) {
                    if (field != null) {
                        field = null;
                        break;
                    }
                    field = field2;
                }
                i++;
            }
            if (field != null) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                    try {
                        Object obj = field.get(asBinder);
                        if (obj == null) {
                            return null;
                        }
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                        throw new IllegalArgumentException("remoteBinder is the wrong class.");
                    } catch (IllegalAccessException e) {
                        throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
                    } catch (IllegalArgumentException e2) {
                        throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
                    } catch (NullPointerException e3) {
                        throw new IllegalArgumentException("Binder object is null.", e3);
                    }
                }
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        return (T) invokeLL.objValue;
    }
}
