package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class V8TypedArray extends V8Array {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class V8ArrayData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public V8ArrayBuffer buffer;
        public int offset;
        public int size;
        public int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8ArrayBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.buffer = v8ArrayBuffer;
            this.offset = i;
            this.size = i2;
            this.type = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8TypedArray(V8 v8) {
        super(v8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((V8) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8TypedArray(V8 v8, V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
        super(v8, new V8ArrayData(v8ArrayBuffer, i2, i3, i));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, v8ArrayBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((V8) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, v8ArrayData) == null) {
            checkOffset(v8ArrayData);
            checkSize(v8ArrayData);
        }
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, v8ArrayData) == null) || v8ArrayData.offset % getStructureSize(v8ArrayData.type) == 0) {
            return;
        }
        throw new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, v8ArrayData) == null) {
            if (v8ArrayData.size < 0) {
                throw new IllegalStateException("RangeError: Invalid typed array length");
            }
            if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset > v8ArrayData.buffer.limit()) {
                throw new IllegalStateException("RangeError: Invalid typed array length");
            }
        }
    }

    private long createTypedArray(long j, V8ArrayData v8ArrayData) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65541, this, j, v8ArrayData)) == null) {
            int i = v8ArrayData.type;
            if (i != 1) {
                if (i != 2) {
                    if (i != 9) {
                        switch (i) {
                            case 11:
                                return this.v8.initNewV8UInt8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 12:
                                return this.v8.initNewV8UInt8ClampedArray(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 13:
                                return this.v8.initNewV8Int16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 14:
                                return this.v8.initNewV8UInt16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 15:
                                return this.v8.initNewV8UInt32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 16:
                                return this.v8.initNewV8Float32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            default:
                                throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(v8ArrayData.type));
                        }
                    }
                    return this.v8.initNewV8Int8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                }
                return this.v8.initNewV8Float64Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            }
            return this.v8.initNewV8Int32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        }
        return invokeJL.longValue;
    }

    public static int getStructureSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 9) {
                        switch (i) {
                            case 11:
                            case 12:
                                break;
                            case 13:
                            case 14:
                                return 2;
                            case 15:
                            case 16:
                                return 4;
                            default:
                                throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(i));
                        }
                    }
                    return 1;
                }
                return 8;
            }
            return 4;
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.v8.V8Array, com.kwad.v8.V8Object, com.kwad.v8.V8Value
    public V8Value createTwin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return new V8TypedArray(this.v8);
        }
        return (V8Value) invokeV.objValue;
    }

    @Override // com.kwad.v8.V8Array
    public Object get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.v8.checkThread();
            checkReleased();
            int type = getType();
            if (type != 1 && type != 2) {
                if (type != 9) {
                    switch (type) {
                        case 11:
                            return Short.valueOf((short) (((Number) super.get(i)).shortValue() & 255));
                        case 12:
                            return Short.valueOf((short) (((Number) super.get(i)).byteValue() & 255));
                        case 13:
                            return Short.valueOf(((Number) super.get(i)).shortValue());
                        case 14:
                            return Integer.valueOf(((Integer) super.get(i)).intValue() & 65535);
                        case 15:
                            return Long.valueOf((-1) & ((Number) super.get(i)).longValue());
                        case 16:
                            return Float.valueOf(((Number) super.get(i)).floatValue());
                        default:
                            return null;
                    }
                }
                return Byte.valueOf(((Number) super.get(i)).byteValue());
            }
            return super.get(i);
        }
        return invokeI.objValue;
    }

    public V8ArrayBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (V8ArrayBuffer) get("buffer") : (V8ArrayBuffer) invokeV.objValue;
    }

    @Override // com.kwad.v8.V8Array, com.kwad.v8.V8Value
    public void initialize(long j, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, obj) == null) {
            this.v8.checkThread();
            if (obj == null) {
                super.initialize(j, obj);
                return;
            }
            V8ArrayData v8ArrayData = (V8ArrayData) obj;
            checkArrayProperties(v8ArrayData);
            long createTypedArray = createTypedArray(j, v8ArrayData);
            this.released = false;
            addObjectReference(createTypedArray);
        }
    }
}
