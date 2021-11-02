package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class BitWriterBuffer {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer buffer;
    public int initialPos;
    public int position;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-836872793, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/BitWriterBuffer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-836872793, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/BitWriterBuffer;");
        }
    }

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.position = 0;
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public void writeBits(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int i4 = this.position;
            int i5 = 8 - (i4 % 8);
            if (i3 <= i5) {
                int i6 = this.buffer.get(this.initialPos + (i4 / 8));
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = i6 + (i2 << (i5 - i3));
                ByteBuffer byteBuffer = this.buffer;
                int i8 = this.initialPos + (this.position / 8);
                if (i7 > 127) {
                    i7 -= 256;
                }
                byteBuffer.put(i8, (byte) i7);
                this.position += i3;
            } else {
                int i9 = i3 - i5;
                writeBits(i2 >> i9, i5);
                writeBits(i2 & ((1 << i9) - 1), i9);
            }
            ByteBuffer byteBuffer2 = this.buffer;
            int i10 = this.initialPos;
            int i11 = this.position;
            byteBuffer2.position(i10 + (i11 / 8) + (i11 % 8 <= 0 ? 0 : 1));
        }
    }
}
