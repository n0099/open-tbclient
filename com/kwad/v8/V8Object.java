package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class V8Object extends V8Value {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class Undefined extends V8Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Undefined() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.v8.V8Object
        public V8Object add(String str, double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d2)})) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeCommon.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object add(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLI.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, v8Value)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object add(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object add(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLZ.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object addUndefined(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Value, com.kwad.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.kwad.v8.V8Object
        public boolean contains(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.v8.V8Value
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? (obj instanceof V8Object) && ((V8Object) obj).isUndefined() : invokeL.booleanValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }

        @Override // com.kwad.v8.V8Object
        public double executeDoubleFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.doubleValue;
        }

        @Override // com.kwad.v8.V8Object
        public Object executeFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public int executeIntegerFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.intValue;
        }

        @Override // com.kwad.v8.V8Object
        public Object executeJSFunction(String str, Object... objArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, objArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public String executeStringFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public void executeVoidFunction(String str, V8Array v8Array) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, str, v8Array) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // com.kwad.v8.V8Object
        public V8Array getArray(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public boolean getBoolean(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.v8.V8Object
        public double getDouble(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.doubleValue;
        }

        @Override // com.kwad.v8.V8Object
        public int getInteger(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.intValue;
        }

        @Override // com.kwad.v8.V8Object
        public String[] getKeys() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String[]) invokeV.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object getObject(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Value
        public V8 getRuntime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8) invokeV.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public String getString(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public int getType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.intValue;
        }

        @Override // com.kwad.v8.V8Value
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN : invokeV.intValue;
        }

        @Override // com.kwad.v8.V8Value
        public boolean isReleased() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.v8.V8Value
        public boolean isUndefined() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, javaCallback, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, javaVoidCallback, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{obj, str, str2, clsArr, Boolean.valueOf(z)})) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeCommon.objValue;
        }

        @Override // com.kwad.v8.V8Value, com.kwad.v8.Releasable
        @Deprecated
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            }
        }

        @Override // com.kwad.v8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, v8Object)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? SessionMonitorEngine.PUBLIC_DATA_UNDIFNED : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.v8.V8Object, com.kwad.v8.V8Value
        public Undefined twin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (Undefined) super.twin() : (Undefined) invokeV.objValue;
        }
    }

    public V8Object() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public V8Object(V8 v8) {
        this(v8, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((V8) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8Object(V8 v8, Object obj) {
        super(v8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((V8) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (v8 != null) {
            this.v8.checkThread();
            initialize(this.v8.getV8RuntimePtr(), obj);
        }
    }

    private void checkKey(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, str) == null) && str == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    public V8Object add(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.add(v8.getV8RuntimePtr(), this.objectHandle, str, d2);
            return this;
        }
        return (V8Object) invokeCommon.objValue;
    }

    public V8Object add(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.add(v8.getV8RuntimePtr(), this.objectHandle, str, i);
            return this;
        }
        return (V8Object) invokeLI.objValue;
    }

    public V8Object add(String str, V8Value v8Value) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, v8Value)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Value);
            if (v8Value == null) {
                V8 v8 = this.v8;
                v8.addNull(v8.getV8RuntimePtr(), this.objectHandle, str);
            } else if (v8Value.equals(V8.getUndefined())) {
                V8 v82 = this.v8;
                v82.addUndefined(v82.getV8RuntimePtr(), this.objectHandle, str);
            } else {
                V8 v83 = this.v8;
                v83.addObject(v83.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
            }
            return this;
        }
        return (V8Object) invokeLL.objValue;
    }

    public V8Object add(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (str2 == null) {
                V8 v8 = this.v8;
                v8.addNull(v8.getV8RuntimePtr(), this.objectHandle, str);
            } else if (str2.equals(V8.getUndefined())) {
                V8 v82 = this.v8;
                v82.addUndefined(v82.getV8RuntimePtr(), this.objectHandle, str);
            } else {
                V8 v83 = this.v8;
                v83.add(v83.getV8RuntimePtr(), this.objectHandle, str, str2);
            }
            return this;
        }
        return (V8Object) invokeLL.objValue;
    }

    public V8Object add(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.add(v8.getV8RuntimePtr(), this.objectHandle, str, z);
            return this;
        }
        return (V8Object) invokeLZ.objValue;
    }

    public V8Object addNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.addNull(v8.getV8RuntimePtr(), this.objectHandle, str);
            return this;
        }
        return (V8Object) invokeL.objValue;
    }

    public V8Object addUndefined(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.addUndefined(v8.getV8RuntimePtr(), this.objectHandle, str);
            return this;
        }
        return (V8Object) invokeL.objValue;
    }

    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            return v8.contains(v8.getV8RuntimePtr(), this.objectHandle, str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.v8.V8Value
    public V8Value createTwin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new V8Object(this.v8) : (V8Value) invokeV.objValue;
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            Object executeFunction = v8.executeFunction(v8.getV8RuntimePtr(), 5, this.objectHandle, str, handle);
            if (executeFunction instanceof V8Array) {
                return (V8Array) executeFunction;
            }
            throw new V8ResultUndefined();
        }
        return (V8Array) invokeLL.objValue;
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            return v8.executeBooleanFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
        }
        return invokeLL.booleanValue;
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            return v8.executeDoubleFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
        }
        return invokeLL.doubleValue;
    }

    public Object executeFunction(String str, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            return v8.executeFunction(v8.getV8RuntimePtr(), 0, this.objectHandle, str, handle);
        }
        return invokeLL.objValue;
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            return v8.executeIntegerFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
        }
        return invokeLL.intValue;
    }

    public Object executeJSFunction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? executeFunction(str, null) : invokeL.objValue;
    }

    public Object executeJSFunction(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, objArr)) == null) {
            if (objArr == null) {
                return executeFunction(str, null);
            }
            V8Array v8Array = new V8Array(this.v8.getRuntime());
            try {
                for (Object obj : objArr) {
                    if (obj == null) {
                        v8Array.pushNull();
                    } else if (obj instanceof V8Value) {
                        v8Array.push((V8Value) obj);
                    } else {
                        if (!(obj instanceof Integer) && !(obj instanceof Double)) {
                            if (obj instanceof Long) {
                                v8Array.push(((Long) obj).doubleValue());
                            } else if (obj instanceof Float) {
                                v8Array.push(((Float) obj).floatValue());
                            } else if (!(obj instanceof Boolean)) {
                                if (!(obj instanceof String)) {
                                    throw new IllegalArgumentException("Unsupported Object of type: " + obj.getClass());
                                }
                                v8Array.push((String) obj);
                            }
                        }
                        v8Array.push(obj);
                    }
                }
                return executeFunction(str, v8Array);
            } finally {
                v8Array.close();
            }
        }
        return invokeLL.objValue;
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            Object executeFunction = v8.executeFunction(v8.getV8RuntimePtr(), 6, this.objectHandle, str, handle);
            if (executeFunction instanceof V8Object) {
                return (V8Object) executeFunction;
            }
            throw new V8ResultUndefined();
        }
        return (V8Object) invokeLL.objValue;
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            return v8.executeStringFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
        }
        return (String) invokeLL.objValue;
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, v8Array) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Array);
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            V8 v8 = this.v8;
            v8.executeVoidFunction(v8.getV8RuntimePtr(), this.objectHandle, str, handle);
        }
    }

    public Object get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            return v8.get(v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        }
        return invokeL.objValue;
    }

    public V8Array getArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            Object obj = v8.get(v8.getV8RuntimePtr(), 5, this.objectHandle, str);
            if (obj == null || (obj instanceof V8Array)) {
                return (V8Array) obj;
            }
            throw new V8ResultUndefined();
        }
        return (V8Array) invokeL.objValue;
    }

    public boolean getBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            return v8.getBoolean(v8.getV8RuntimePtr(), this.objectHandle, str);
        }
        return invokeL.booleanValue;
    }

    public double getDouble(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            return v8.getDouble(v8.getV8RuntimePtr(), this.objectHandle, str);
        }
        return invokeL.doubleValue;
    }

    public int getInteger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            return v8.getInteger(v8.getV8RuntimePtr(), this.objectHandle, str);
        }
        return invokeL.intValue;
    }

    public String[] getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.getKeys(v8.getV8RuntimePtr(), this.objectHandle);
        }
        return (String[]) invokeV.objValue;
    }

    public V8Object getObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            Object obj = v8.get(v8.getV8RuntimePtr(), 6, this.objectHandle, str);
            if (obj == null || (obj instanceof V8Object)) {
                return (V8Object) obj;
            }
            throw new V8ResultUndefined();
        }
        return (V8Object) invokeL.objValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            return v8.getString(v8.getV8RuntimePtr(), this.objectHandle, str);
        }
        return (String) invokeL.objValue;
    }

    public int getType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            checkKey(str);
            V8 v8 = this.v8;
            return v8.getType(v8.getV8RuntimePtr(), this.objectHandle, str);
        }
        return invokeL.intValue;
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, javaCallback, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.registerCallback(javaCallback, getHandle(), str);
            return this;
        }
        return (V8Object) invokeLL.objValue;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, javaVoidCallback, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.registerVoidCallback(javaVoidCallback, getHandle(), str);
            return this;
        }
        return (V8Object) invokeLL.objValue;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048606, this, obj, str, str2, clsArr)) == null) ? registerJavaMethod(obj, str, str2, clsArr, false) : (V8Object) invokeLLLL.objValue;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{obj, str, str2, clsArr, Boolean.valueOf(z)})) == null) {
            this.v8.checkThread();
            checkReleased();
            try {
                Method method = obj.getClass().getMethod(str, clsArr);
                method.setAccessible(true);
                this.v8.registerCallback(obj, method, getHandle(), str2, z);
                return this;
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(e2);
            } catch (SecurityException e3) {
                throw new IllegalStateException(e3);
            }
        }
        return (V8Object) invokeCommon.objValue;
    }

    public V8Object setPrototype(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, v8Object)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.setPrototype(v8.getV8RuntimePtr(), this.objectHandle, v8Object.getHandle());
            return this;
        }
        return (V8Object) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (isReleased() || this.v8.isReleased()) {
                return "[Object released]";
            }
            this.v8.checkThread();
            V8 v8 = this.v8;
            return v8.toString(v8.getV8RuntimePtr(), getHandle());
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.v8.V8Value
    public V8Object twin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (V8Object) super.twin() : (V8Object) invokeV.objValue;
    }
}
