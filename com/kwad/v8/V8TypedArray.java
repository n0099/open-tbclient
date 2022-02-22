package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class V8TypedArray extends V8Array {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class V8ArrayData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public V8ArrayBuffer buffer;
        public int offset;
        public int size;
        public int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8ArrayBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.buffer = v8ArrayBuffer;
            this.offset = i2;
            this.size = i3;
            this.type = i4;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((V8) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8TypedArray(V8 v8, V8ArrayBuffer v8ArrayBuffer, int i2, int i3, int i4) {
        super(v8, new V8ArrayData(v8ArrayBuffer, i3, i4, i2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, v8ArrayBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
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

    private long createTypedArray(long j2, V8ArrayData v8ArrayData) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65541, this, j2, v8ArrayData)) == null) {
            int i2 = v8ArrayData.type;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 9) {
                        switch (i2) {
                            case 11:
                                return this.v8.initNewV8UInt8Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 12:
                                return this.v8.initNewV8UInt8ClampedArray(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 13:
                                return this.v8.initNewV8Int16Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 14:
                                return this.v8.initNewV8UInt16Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 15:
                                return this.v8.initNewV8UInt32Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            case 16:
                                return this.v8.initNewV8Float32Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                            default:
                                throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(v8ArrayData.type));
                        }
                    }
                    return this.v8.initNewV8Int8Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                }
                return this.v8.initNewV8Float64Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            }
            return this.v8.initNewV8Int32Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        }
        return invokeJL.longValue;
    }

    public static int getStructureSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 9) {
                        switch (i2) {
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
                                throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(i2));
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
    public Object get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            int type = getType();
            if (type != 1 && type != 2) {
                if (type != 9) {
                    switch (type) {
                        case 11:
                            return Short.valueOf((short) (((Number) super.get(i2)).shortValue() & 255));
                        case 12:
                            return Short.valueOf((short) (((Number) super.get(i2)).byteValue() & 255));
                        case 13:
                            return Short.valueOf(((Number) super.get(i2)).shortValue());
                        case 14:
                            return Integer.valueOf(((Integer) super.get(i2)).intValue() & 65535);
                        case 15:
                            return Long.valueOf((-1) & ((Number) super.get(i2)).longValue());
                        case 16:
                            return Float.valueOf(((Number) super.get(i2)).floatValue());
                        default:
                            return null;
                    }
                }
                return Byte.valueOf(((Number) super.get(i2)).byteValue());
            }
            return super.get(i2);
        }
        return invokeI.objValue;
    }

    public V8ArrayBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (V8ArrayBuffer) get("buffer") : (V8ArrayBuffer) invokeV.objValue;
    }

    @Override // com.kwad.v8.V8Array, com.kwad.v8.V8Value
    public void initialize(long j2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j2, obj) == null) {
            this.v8.checkThread();
            if (obj == null) {
                super.initialize(j2, obj);
                return;
            }
            V8ArrayData v8ArrayData = (V8ArrayData) obj;
            checkArrayProperties(v8ArrayData);
            long createTypedArray = createTypedArray(j2, v8ArrayData);
            this.released = false;
            addObjectReference(createTypedArray);
        }
    }
}
