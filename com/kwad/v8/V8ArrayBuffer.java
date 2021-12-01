package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes2.dex */
public class V8ArrayBuffer extends V8Value {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer byteBuffer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8ArrayBuffer(V8 v8, int i2) {
        super(v8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((V8) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i2));
        ByteBuffer createV8ArrayBufferBackingStore = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.objectHandle, i2);
        this.byteBuffer = createV8ArrayBufferBackingStore;
        createV8ArrayBufferBackingStore.order(ByteOrder.nativeOrder());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, byteBuffer};
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
        byteBuffer = byteBuffer == null ? ByteBuffer.allocateDirect(0) : byteBuffer;
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        }
        initialize(v8.getV8RuntimePtr(), byteBuffer);
        this.byteBuffer = byteBuffer;
        byteBuffer.order(ByteOrder.nativeOrder());
    }

    public final byte[] array() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public final int arrayOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.arrayOffset();
        }
        return invokeV.intValue;
    }

    public final int capacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.capacity();
        }
        return invokeV.intValue;
    }

    public final V8ArrayBuffer clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.clear();
            return this;
        }
        return (V8ArrayBuffer) invokeV.objValue;
    }

    public V8ArrayBuffer compact() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.compact();
            return this;
        }
        return (V8ArrayBuffer) invokeV.objValue;
    }

    @Override // com.kwad.v8.V8Value
    public V8Value createTwin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new V8ArrayBuffer(this.v8, this.byteBuffer) : (V8Value) invokeV.objValue;
    }

    public int doubleLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.asDoubleBuffer().limit();
        }
        return invokeV.intValue;
    }

    public final V8ArrayBuffer flip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.flip();
            return this;
        }
        return (V8ArrayBuffer) invokeV.objValue;
    }

    public int floatLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.asFloatBuffer().limit();
        }
        return invokeV.intValue;
    }

    public byte get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.get();
        }
        return invokeV.byteValue;
    }

    public byte get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.get(i2);
        }
        return invokeI.byteValue;
    }

    public V8ArrayBuffer get(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bArr)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.get(bArr);
            return this;
        }
        return (V8ArrayBuffer) invokeL.objValue;
    }

    public V8ArrayBuffer get(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, bArr, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.get(bArr, i2, i3);
            return this;
        }
        return (V8ArrayBuffer) invokeLII.objValue;
    }

    public char getChar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getChar();
        }
        return invokeV.charValue;
    }

    public char getChar(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getChar(i2);
        }
        return invokeI.charValue;
    }

    public double getDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getDouble();
        }
        return invokeV.doubleValue;
    }

    public double getDouble(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getDouble(i2);
        }
        return invokeI.doubleValue;
    }

    public float getFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getFloat();
        }
        return invokeV.floatValue;
    }

    public float getFloat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getFloat(i2);
        }
        return invokeI.floatValue;
    }

    public int getInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getInt();
        }
        return invokeV.intValue;
    }

    public int getInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getInt(i2);
        }
        return invokeI.intValue;
    }

    public long getLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getLong();
        }
        return invokeV.longValue;
    }

    public long getLong(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getLong(i2);
        }
        return invokeI.longValue;
    }

    public short getShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getShort();
        }
        return invokeV.shortValue;
    }

    public short getShort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.getShort(i2);
        }
        return invokeI.shortValue;
    }

    public final boolean hasArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.hasArray();
        }
        return invokeV.booleanValue;
    }

    public final boolean hasRemaining() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.hasRemaining();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.v8.V8Value
    public void initialize(long j2, Object obj) {
        long initNewV8ArrayBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048603, this, j2, obj) == null) {
            this.v8.checkThread();
            if (obj instanceof ByteBuffer) {
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                int limit = byteBuffer.limit();
                V8 v8 = this.v8;
                initNewV8ArrayBuffer = v8.initNewV8ArrayBuffer(v8.getV8RuntimePtr(), byteBuffer, limit);
            } else {
                int intValue = ((Integer) obj).intValue();
                V8 v82 = this.v8;
                initNewV8ArrayBuffer = v82.initNewV8ArrayBuffer(v82.getV8RuntimePtr(), intValue);
            }
            this.objectHandle = initNewV8ArrayBuffer;
            this.released = false;
            addObjectReference(this.objectHandle);
        }
    }

    public int intLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.asIntBuffer().limit();
        }
        return invokeV.intValue;
    }

    public boolean isDirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.isDirect();
        }
        return invokeV.booleanValue;
    }

    public boolean isReadOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.isReadOnly();
        }
        return invokeV.booleanValue;
    }

    public int limit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.limit();
        }
        return invokeV.intValue;
    }

    public final V8ArrayBuffer limit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.limit(i2);
            return this;
        }
        return (V8ArrayBuffer) invokeI.objValue;
    }

    public final V8ArrayBuffer mark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.mark();
            return this;
        }
        return (V8ArrayBuffer) invokeV.objValue;
    }

    public final V8ArrayBuffer order(ByteOrder byteOrder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, byteOrder)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.order(byteOrder);
            return this;
        }
        return (V8ArrayBuffer) invokeL.objValue;
    }

    public final ByteOrder order() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.order();
        }
        return (ByteOrder) invokeV.objValue;
    }

    public final int position() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.position();
        }
        return invokeV.intValue;
    }

    public final V8ArrayBuffer position(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.position(i2);
            return this;
        }
        return (V8ArrayBuffer) invokeI.objValue;
    }

    public V8ArrayBuffer put(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048614, this, b2)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.put(b2);
            return this;
        }
        return (V8ArrayBuffer) invokeB.objValue;
    }

    public V8ArrayBuffer put(int i2, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.put(i2, b2);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer put(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, byteBuffer)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.put(byteBuffer);
            return this;
        }
        return (V8ArrayBuffer) invokeL.objValue;
    }

    public final V8ArrayBuffer put(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, bArr)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.put(bArr);
            return this;
        }
        return (V8ArrayBuffer) invokeL.objValue;
    }

    public V8ArrayBuffer put(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048618, this, bArr, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.put(bArr, i2, i3);
            return this;
        }
        return (V8ArrayBuffer) invokeLII.objValue;
    }

    public V8ArrayBuffer putChar(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putChar(c2);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer putChar(int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putChar(i2, c2);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer putDouble(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{Double.valueOf(d2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putDouble(d2);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer putDouble(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putDouble(i2, d2);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer putFloat(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048623, this, f2)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putFloat(f2);
            return this;
        }
        return (V8ArrayBuffer) invokeF.objValue;
    }

    public V8ArrayBuffer putFloat(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putFloat(i2, f2);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer putInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putInt(i2);
            return this;
        }
        return (V8ArrayBuffer) invokeI.objValue;
    }

    public V8ArrayBuffer putInt(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048626, this, i2, i3)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.asIntBuffer().put(i2, i3);
            return this;
        }
        return (V8ArrayBuffer) invokeII.objValue;
    }

    public V8ArrayBuffer putLong(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putLong(i2, j2);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer putLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048628, this, j2)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putLong(j2);
            return this;
        }
        return (V8ArrayBuffer) invokeJ.objValue;
    }

    public V8ArrayBuffer putShort(int i2, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i2), Short.valueOf(s)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putShort(i2, s);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public V8ArrayBuffer putShort(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Short.valueOf(s)})) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.putShort(s);
            return this;
        }
        return (V8ArrayBuffer) invokeCommon.objValue;
    }

    public final int remaining() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.remaining();
        }
        return invokeV.intValue;
    }

    public final V8ArrayBuffer reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.reset();
            return this;
        }
        return (V8ArrayBuffer) invokeV.objValue;
    }

    public final V8ArrayBuffer rewind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.byteBuffer.rewind();
            return this;
        }
        return (V8ArrayBuffer) invokeV.objValue;
    }

    public int shortLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return this.byteBuffer.asShortBuffer().limit();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.v8.V8Value
    public V8ArrayBuffer twin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            this.v8.checkThread();
            checkReleased();
            return (V8ArrayBuffer) super.twin();
        }
        return (V8ArrayBuffer) invokeV.objValue;
    }
}
