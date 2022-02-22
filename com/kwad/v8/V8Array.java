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
/* loaded from: classes4.dex */
public class V8Array extends V8Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class Undefined extends V8Array {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Undefined() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public V8Object add(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
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
        public int executeIntegerFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.intValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public String executeStringFunction(String str, V8Array v8Array) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, v8Array)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public void executeVoidFunction(String str, V8Array v8Array) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, str, v8Array) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // com.kwad.v8.V8Array
        public Object get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeI.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Array getArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeI.objValue;
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

        @Override // com.kwad.v8.V8Array
        public boolean getBoolean(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeI.booleanValue;
        }

        @Override // com.kwad.v8.V8Object
        public boolean getBoolean(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getBooleans(int i2, int i3, boolean[] zArr) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048597, this, i2, i3, zArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeIIL.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public boolean[] getBooleans(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i2, i3)) == null) {
                throw new UnsupportedOperationException();
            }
            return (boolean[]) invokeII.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public byte getByte(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeI.byteValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getBytes(int i2, int i3, byte[] bArr) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048600, this, i2, i3, bArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeIIL.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public byte[] getBytes(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048601, this, i2, i3)) == null) {
                throw new UnsupportedOperationException();
            }
            return (byte[]) invokeII.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public double getDouble(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeI.doubleValue;
        }

        @Override // com.kwad.v8.V8Object
        public double getDouble(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.doubleValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getDoubles(int i2, int i3, double[] dArr) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048604, this, i2, i3, dArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeIIL.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public double[] getDoubles(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i2, i3)) == null) {
                throw new UnsupportedOperationException();
            }
            return (double[]) invokeII.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getInteger(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeI.intValue;
        }

        @Override // com.kwad.v8.V8Object
        public int getInteger(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getIntegers(int i2, int i3, int[] iArr) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048608, this, i2, i3, iArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeIIL.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public int[] getIntegers(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048609, this, i2, i3)) == null) {
                throw new UnsupportedOperationException();
            }
            return (int[]) invokeII.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public String[] getKeys() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String[]) invokeV.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Object getObject(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeI.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object getObject(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Value
        public V8 getRuntime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8) invokeV.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public String getString(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String) invokeI.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public String getString(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getStrings(int i2, int i3, String[] strArr) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048616, this, i2, i3, strArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeIIL.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public String[] getStrings(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048617, this, i2, i3)) == null) {
                throw new UnsupportedOperationException();
            }
            return (String[]) invokeII.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeI.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public int getType(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048620, this, i2, i3)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeII.intValue;
        }

        @Override // com.kwad.v8.V8Object
        public int getType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.intValue;
        }

        @Override // com.kwad.v8.V8Value
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN : invokeV.intValue;
        }

        @Override // com.kwad.v8.V8Value
        public boolean isReleased() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.v8.V8Value
        public boolean isUndefined() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.v8.V8Array
        public int length() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.intValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Array push(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Double.valueOf(d2)})) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeCommon.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Array push(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeI.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Array push(V8Value v8Value) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, v8Value)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Array push(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Array push(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeZ.objValue;
        }

        @Override // com.kwad.v8.V8Array
        public V8Array pushUndefined() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Array) invokeV.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048632, this, javaCallback, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, javaVoidCallback, str)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeLL.objValue;
        }

        @Override // com.kwad.v8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048634, this, new Object[]{obj, str, str2, clsArr, Boolean.valueOf(z)})) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeCommon.objValue;
        }

        @Override // com.kwad.v8.V8Value, com.kwad.v8.Releasable
        @Deprecated
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            }
        }

        @Override // com.kwad.v8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, v8Object)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V8Object) invokeL.objValue;
        }

        @Override // com.kwad.v8.V8Array, com.kwad.v8.V8Object
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? SessionMonitorEngine.PUBLIC_DATA_UNDIFNED : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.v8.V8Array, com.kwad.v8.V8Object, com.kwad.v8.V8Value
        public Undefined twin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? (Undefined) super.twin() : (Undefined) invokeV.objValue;
        }
    }

    public V8Array() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8Array(V8 v8) {
        super(v8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((V8) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        v8.checkThread();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8Array(V8 v8, Object obj) {
        super(v8, obj);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((V8) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.v8.V8Object, com.kwad.v8.V8Value
    public V8Value createTwin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new V8Array(this.v8) : (V8Value) invokeV.objValue;
    }

    public Object get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGet(v8.getV8RuntimePtr(), 6, this.objectHandle, i2);
        }
        return invokeI.objValue;
    }

    public V8Array getArray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            Object arrayGet = v8.arrayGet(v8.getV8RuntimePtr(), 5, this.objectHandle, i2);
            if (arrayGet == null || (arrayGet instanceof V8Array)) {
                return (V8Array) arrayGet;
            }
            throw new V8ResultUndefined();
        }
        return (V8Array) invokeI.objValue;
    }

    public boolean getBoolean(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetBoolean(v8.getV8RuntimePtr(), getHandle(), i2);
        }
        return invokeI.booleanValue;
    }

    public int getBooleans(int i2, int i3, boolean[] zArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i2, i3, zArr)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (i3 <= zArr.length) {
                V8 v8 = this.v8;
                return v8.arrayGetBooleans(v8.getV8RuntimePtr(), getHandle(), i2, i3, zArr);
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeIIL.intValue;
    }

    public boolean[] getBooleans(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetBooleans(v8.getV8RuntimePtr(), getHandle(), i2, i3);
        }
        return (boolean[]) invokeII.objValue;
    }

    public byte getByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetByte(v8.getV8RuntimePtr(), getHandle(), i2);
        }
        return invokeI.byteValue;
    }

    public int getBytes(int i2, int i3, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048583, this, i2, i3, bArr)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (i3 <= bArr.length) {
                V8 v8 = this.v8;
                return v8.arrayGetBytes(v8.getV8RuntimePtr(), getHandle(), i2, i3, bArr);
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeIIL.intValue;
    }

    public byte[] getBytes(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetBytes(v8.getV8RuntimePtr(), getHandle(), i2, i3);
        }
        return (byte[]) invokeII.objValue;
    }

    public double getDouble(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetDouble(v8.getV8RuntimePtr(), getHandle(), i2);
        }
        return invokeI.doubleValue;
    }

    public int getDoubles(int i2, int i3, double[] dArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, dArr)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (i3 <= dArr.length) {
                V8 v8 = this.v8;
                return v8.arrayGetDoubles(v8.getV8RuntimePtr(), getHandle(), i2, i3, dArr);
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeIIL.intValue;
    }

    public double[] getDoubles(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetDoubles(v8.getV8RuntimePtr(), getHandle(), i2, i3);
        }
        return (double[]) invokeII.objValue;
    }

    public int getInteger(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetInteger(v8.getV8RuntimePtr(), getHandle(), i2);
        }
        return invokeI.intValue;
    }

    public int getIntegers(int i2, int i3, int[] iArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048589, this, i2, i3, iArr)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (i3 <= iArr.length) {
                V8 v8 = this.v8;
                return v8.arrayGetIntegers(v8.getV8RuntimePtr(), getHandle(), i2, i3, iArr);
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeIIL.intValue;
    }

    public int[] getIntegers(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetIntegers(v8.getV8RuntimePtr(), getHandle(), i2, i3);
        }
        return (int[]) invokeII.objValue;
    }

    public V8Object getObject(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            Object arrayGet = v8.arrayGet(v8.getV8RuntimePtr(), 6, this.objectHandle, i2);
            if (arrayGet == null || (arrayGet instanceof V8Object)) {
                return (V8Object) arrayGet;
            }
            throw new V8ResultUndefined();
        }
        return (V8Object) invokeI.objValue;
    }

    public String getString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetString(v8.getV8RuntimePtr(), getHandle(), i2);
        }
        return (String) invokeI.objValue;
    }

    public int getStrings(int i2, int i3, String[] strArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048593, this, i2, i3, strArr)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (i3 <= strArr.length) {
                V8 v8 = this.v8;
                return v8.arrayGetStrings(v8.getV8RuntimePtr(), getHandle(), i2, i3, strArr);
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeIIL.intValue;
    }

    public String[] getStrings(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetStrings(v8.getV8RuntimePtr(), getHandle(), i2, i3);
        }
        return (String[]) invokeII.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.getArrayType(v8.getV8RuntimePtr(), getHandle());
        }
        return invokeV.intValue;
    }

    public int getType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.getType(v8.getV8RuntimePtr(), getHandle(), i2);
        }
        return invokeI.intValue;
    }

    public int getType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.getType(v8.getV8RuntimePtr(), getHandle(), i2, i3);
        }
        return invokeII.intValue;
    }

    @Override // com.kwad.v8.V8Value
    public void initialize(long j2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048598, this, j2, obj) == null) {
            long initNewV8Array = this.v8.initNewV8Array(j2);
            this.released = false;
            addObjectReference(initNewV8Array);
        }
    }

    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.arrayGetSize(v8.getV8RuntimePtr(), getHandle());
        }
        return invokeV.intValue;
    }

    public V8Array push(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Double.valueOf(d2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.addArrayDoubleItem(v8.getV8RuntimePtr(), getHandle(), d2);
            return this;
        }
        return (V8Array) invokeCommon.objValue;
    }

    public V8Array push(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.addArrayIntItem(v8.getV8RuntimePtr(), getHandle(), i2);
            return this;
        }
        return (V8Array) invokeI.objValue;
    }

    public V8Array push(V8Value v8Value) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, v8Value)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Value);
            if (v8Value == null) {
                V8 v8 = this.v8;
                v8.addArrayNullItem(v8.getV8RuntimePtr(), getHandle());
            } else if (v8Value.equals(V8.getUndefined())) {
                V8 v82 = this.v8;
                v82.addArrayUndefinedItem(v82.getV8RuntimePtr(), getHandle());
            } else {
                V8 v83 = this.v8;
                v83.addArrayObjectItem(v83.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
            }
            return this;
        }
        return (V8Array) invokeL.objValue;
    }

    public V8Array push(Object obj) {
        InterceptResult invokeL;
        V8 v8;
        long v8RuntimePtr;
        long handle;
        double doubleValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            this.v8.checkThread();
            checkReleased();
            boolean z = obj instanceof V8Value;
            if (z) {
                this.v8.checkRuntime((V8Value) obj);
            }
            if (obj == null) {
                V8 v82 = this.v8;
                v82.addArrayNullItem(v82.getV8RuntimePtr(), getHandle());
            } else if (obj.equals(V8.getUndefined())) {
                V8 v83 = this.v8;
                v83.addArrayUndefinedItem(v83.getV8RuntimePtr(), getHandle());
            } else {
                if (obj instanceof Double) {
                    v8 = this.v8;
                    v8RuntimePtr = v8.getV8RuntimePtr();
                    handle = getHandle();
                    doubleValue = ((Double) obj).doubleValue();
                } else if (obj instanceof Integer) {
                    V8 v84 = this.v8;
                    v84.addArrayIntItem(v84.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    v8 = this.v8;
                    v8RuntimePtr = v8.getV8RuntimePtr();
                    handle = getHandle();
                    doubleValue = ((Float) obj).doubleValue();
                } else if (obj instanceof Number) {
                    v8 = this.v8;
                    v8RuntimePtr = v8.getV8RuntimePtr();
                    handle = getHandle();
                    doubleValue = ((Number) obj).doubleValue();
                } else if (obj instanceof Boolean) {
                    V8 v85 = this.v8;
                    v85.addArrayBooleanItem(v85.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
                } else if (obj instanceof String) {
                    V8 v86 = this.v8;
                    v86.addArrayStringItem(v86.getV8RuntimePtr(), getHandle(), (String) obj);
                } else if (!z) {
                    throw new IllegalArgumentException();
                } else {
                    V8 v87 = this.v8;
                    v87.addArrayObjectItem(v87.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
                }
                v8.addArrayDoubleItem(v8RuntimePtr, handle, doubleValue);
            }
            return this;
        }
        return (V8Array) invokeL.objValue;
    }

    public V8Array push(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (str == null) {
                V8 v8 = this.v8;
                v8.addArrayNullItem(v8.getV8RuntimePtr(), getHandle());
            } else if (str.equals(V8.getUndefined())) {
                V8 v82 = this.v8;
                v82.addArrayUndefinedItem(v82.getV8RuntimePtr(), getHandle());
            } else {
                V8 v83 = this.v8;
                v83.addArrayStringItem(v83.getV8RuntimePtr(), getHandle(), str);
            }
            return this;
        }
        return (V8Array) invokeL.objValue;
    }

    public V8Array push(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.addArrayBooleanItem(v8.getV8RuntimePtr(), getHandle(), z);
            return this;
        }
        return (V8Array) invokeZ.objValue;
    }

    public V8Array pushNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.addArrayNullItem(v8.getV8RuntimePtr(), getHandle());
            return this;
        }
        return (V8Array) invokeV.objValue;
    }

    public V8Array pushUndefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            v8.addArrayUndefinedItem(v8.getV8RuntimePtr(), getHandle());
            return this;
        }
        return (V8Array) invokeV.objValue;
    }

    @Override // com.kwad.v8.V8Object
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.released || this.v8.isReleased()) ? "[Array released]" : super.toString() : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.v8.V8Object, com.kwad.v8.V8Value
    public V8Array twin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (V8Array) super.twin() : (V8Array) invokeV.objValue;
    }
}
