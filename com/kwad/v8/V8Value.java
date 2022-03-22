package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class V8Value implements Releasable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOOLEAN = 3;
    public static final int BYTE = 9;
    public static final int DOUBLE = 2;
    public static final int FLOAT_32_ARRAY = 16;
    public static final int FLOAT_64_ARRAY = 2;
    public static final int INTEGER = 1;
    public static final int INT_16_ARRAY = 13;
    public static final int INT_32_ARRAY = 1;
    public static final int INT_8_ARRAY = 9;
    public static final int NULL = 0;
    public static final int STRING = 4;
    public static final int UNDEFINED = 99;
    public static final int UNKNOWN = 0;
    public static final int UNSIGNED_INT_16_ARRAY = 14;
    public static final int UNSIGNED_INT_32_ARRAY = 15;
    public static final int UNSIGNED_INT_8_ARRAY = 11;
    public static final int UNSIGNED_INT_8_CLAMPED_ARRAY = 12;
    public static final int V8_ARRAY = 5;
    public static final int V8_ARRAY_BUFFER = 10;
    public static final int V8_FUNCTION = 7;
    public static final int V8_OBJECT = 6;
    public static final int V8_TYPED_ARRAY = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public long objectHandle;
    public boolean released;
    public V8 v8;

    public V8Value() {
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
        this.released = true;
    }

    public V8Value(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.released = true;
        this.v8 = v8 == null ? (V8) this : v8;
    }

    @Deprecated
    public static String getStringRepresentaion(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? getStringRepresentation(i) : (String) invokeI.objValue;
    }

    public static String getStringRepresentation(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != 99) {
                switch (i) {
                    case 0:
                        return "Null";
                    case 1:
                        return "Integer";
                    case 2:
                        return "Double";
                    case 3:
                        return "Boolean";
                    case 4:
                        return "String";
                    case 5:
                        return "V8Array";
                    case 6:
                        return "V8Object";
                    case 7:
                        return "V8Function";
                    case 8:
                        return "V8TypedArray";
                    case 9:
                        return "Byte";
                    case 10:
                        return "V8ArrayBuffer";
                    case 11:
                        return "UInt8Array";
                    case 12:
                        return "UInt8ClampedArray";
                    case 13:
                        return "Int16Array";
                    case 14:
                        return "UInt16Array";
                    case 15:
                        return "UInt32Array";
                    case 16:
                        return "Float32Array";
                    default:
                        throw new IllegalArgumentException("Invalid V8 type: " + i);
                }
            }
            return "Undefined";
        }
        return (String) invokeI.objValue;
    }

    public void addObjectReference(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.objectHandle = j;
            try {
                this.v8.addObjRef(this);
            } catch (Error e2) {
                release();
                throw e2;
            } catch (RuntimeException e3) {
                release();
                throw e3;
            }
        }
    }

    public void checkReleased() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.released) {
            throw new IllegalStateException("Object released");
        }
    }

    public V8Value clearWeak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.v8.checkThread();
            this.v8.checkReleased();
            this.v8.v8WeakReferences.remove(Long.valueOf(getHandle()));
            V8 v8 = this.v8;
            v8.clearWeak(v8.getV8RuntimePtr(), getHandle());
            return this;
        }
        return (V8Value) invokeV.objValue;
    }

    @Override // com.kwad.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.v8.checkThread();
            if (this.released) {
                return;
            }
            try {
                this.v8.releaseObjRef(this);
            } finally {
                this.released = true;
                V8 v8 = this.v8;
                v8.release(v8.getV8RuntimePtr(), this.objectHandle);
            }
        }
    }

    public abstract V8Value createTwin();

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? strictEquals(obj) : invokeL.booleanValue;
    }

    public String getConstructorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.v8.checkThread();
            this.v8.checkReleased();
            V8 v8 = this.v8;
            return v8.getConstructorName(v8.getV8RuntimePtr(), this.objectHandle);
        }
        return (String) invokeV.objValue;
    }

    public long getHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            checkReleased();
            return this.objectHandle;
        }
        return invokeV.longValue;
    }

    public V8 getRuntime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v8 : (V8) invokeV.objValue;
    }

    public int getV8Type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (isUndefined()) {
                return 99;
            }
            this.v8.checkThread();
            this.v8.checkReleased();
            V8 v8 = this.v8;
            return v8.getType(v8.getV8RuntimePtr(), this.objectHandle);
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            V8 v8 = this.v8;
            return v8.identityHash(v8.getV8RuntimePtr(), getHandle());
        }
        return invokeV.intValue;
    }

    public void initialize(long j, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048587, this, j, obj) == null) {
            long initNewV8Object = this.v8.initNewV8Object(j);
            this.released = false;
            addObjectReference(initNewV8Object);
        }
    }

    public boolean isReleased() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.released : invokeV.booleanValue;
    }

    public boolean isUndefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isWeak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.v8.checkThread();
            this.v8.checkReleased();
            V8 v8 = this.v8;
            return v8.isWeak(v8.getV8RuntimePtr(), getHandle());
        }
        return invokeV.booleanValue;
    }

    public boolean jsEquals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (obj == this) {
                return true;
            }
            if (obj != null && (obj instanceof V8Value)) {
                if (isUndefined() && ((V8Value) obj).isUndefined()) {
                    return true;
                }
                V8Value v8Value = (V8Value) obj;
                if (v8Value.isUndefined()) {
                    return false;
                }
                V8 v8 = this.v8;
                return v8.equals(v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.v8.Releasable
    @Deprecated
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            close();
        }
    }

    public V8Value setWeak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.v8.checkThread();
            this.v8.checkReleased();
            this.v8.v8WeakReferences.put(Long.valueOf(getHandle()), this);
            V8 v8 = this.v8;
            v8.setWeak(v8.getV8RuntimePtr(), getHandle());
            return this;
        }
        return (V8Value) invokeV.objValue;
    }

    public boolean strictEquals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            this.v8.checkThread();
            checkReleased();
            if (obj == this) {
                return true;
            }
            if (obj != null && (obj instanceof V8Value)) {
                if (isUndefined() && ((V8Value) obj).isUndefined()) {
                    return true;
                }
                V8Value v8Value = (V8Value) obj;
                if (v8Value.isUndefined()) {
                    return false;
                }
                V8 v8 = this.v8;
                return v8.strictEquals(v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public V8Value twin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (isUndefined()) {
                return this;
            }
            this.v8.checkThread();
            this.v8.checkReleased();
            V8Value createTwin = createTwin();
            this.v8.createTwin(this, createTwin);
            return createTwin;
        }
        return (V8Value) invokeV.objValue;
    }
}
