package com.google.gson.internal.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class UnsafeReflectionAccessor extends ReflectionAccessor {
    public static /* synthetic */ Interceptable $ic;
    public static Class unsafeClass;
    public transient /* synthetic */ FieldHolder $fh;
    public final Field overrideField;
    public final Object theUnsafe;

    public UnsafeReflectionAccessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.theUnsafe = getUnsafeInstance();
        this.overrideField = getOverrideField();
    }

    public static Field getOverrideField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return AccessibleObject.class.getDeclaredField("override");
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
        return (Field) invokeV.objValue;
    }

    public static Object getUnsafeInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                Class<?> cls = Class.forName("sun.misc.Unsafe");
                unsafeClass = cls;
                Field declaredField = cls.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return declaredField.get(null);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, accessibleObject) == null) || makeAccessibleWithUnsafe(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }

    public boolean makeAccessibleWithUnsafe(AccessibleObject accessibleObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accessibleObject)) == null) {
            if (this.theUnsafe != null && this.overrideField != null) {
                try {
                    unsafeClass.getMethod(SharedPreferenceManager.OPERATION_PUT_BOOLEAN, Object.class, Long.TYPE, Boolean.TYPE).invoke(this.theUnsafe, accessibleObject, Long.valueOf(((Long) unsafeClass.getMethod("objectFieldOffset", Field.class).invoke(this.theUnsafe, this.overrideField)).longValue()), Boolean.TRUE);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
