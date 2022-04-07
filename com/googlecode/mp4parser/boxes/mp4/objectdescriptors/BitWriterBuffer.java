package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.position = 0;
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public void writeBits(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            int i3 = this.position;
            int i4 = 8 - (i3 % 8);
            if (i2 <= i4) {
                int i5 = this.buffer.get(this.initialPos + (i3 / 8));
                if (i5 < 0) {
                    i5 += 256;
                }
                int i6 = i5 + (i << (i4 - i2));
                ByteBuffer byteBuffer = this.buffer;
                int i7 = this.initialPos + (this.position / 8);
                if (i6 > 127) {
                    i6 -= 256;
                }
                byteBuffer.put(i7, (byte) i6);
                this.position += i2;
            } else {
                int i8 = i2 - i4;
                writeBits(i >> i8, i4);
                writeBits(i & ((1 << i8) - 1), i8);
            }
            ByteBuffer byteBuffer2 = this.buffer;
            int i9 = this.initialPos;
            int i10 = this.position;
            byteBuffer2.position(i9 + (i10 / 8) + (i10 % 8 <= 0 ? 0 : 1));
        }
    }
}
