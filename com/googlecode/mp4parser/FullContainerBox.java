package com.googlecode.mp4parser;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.FullBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public abstract class FullContainerBox extends AbstractContainerBox implements FullBox {
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public int flags;
    public int version;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1455296052, "Lcom/googlecode/mp4parser/FullContainerBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1455296052, "Lcom/googlecode/mp4parser/FullContainerBox;");
                return;
            }
        }
        LOG = Logger.getLogger(FullContainerBox.class.getName());
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.flags;
        }
        return invokeV.intValue;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.version;
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return String.valueOf(FullContainerBox.class.getSimpleName()) + "[childBoxes]";
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullContainerBox(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.googlecode.mp4parser.BasicContainer, com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            return getBoxes(cls, false);
        }
        return (List) invokeL.objValue;
    }

    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteBuffer)) == null) {
            this.version = IsoTypeReader.readUInt8(byteBuffer);
            this.flags = IsoTypeReader.readUInt24(byteBuffer);
            return 4L;
        }
        return invokeL.longValue;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.flags = i;
        }
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.version = i;
        }
    }

    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            IsoTypeWriter.writeUInt8(byteBuffer, this.version);
            IsoTypeWriter.writeUInt24(byteBuffer, this.flags);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public ByteBuffer getHeader() {
        InterceptResult invokeV;
        ByteBuffer wrap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.largeBox && getSize() < 4294967296L) {
                byte[] bArr = new byte[12];
                bArr[4] = this.type.getBytes()[0];
                bArr[5] = this.type.getBytes()[1];
                bArr[6] = this.type.getBytes()[2];
                bArr[7] = this.type.getBytes()[3];
                wrap = ByteBuffer.wrap(bArr);
                IsoTypeWriter.writeUInt32(wrap, getSize());
                wrap.position(8);
                writeVersionAndFlags(wrap);
            } else {
                byte[] bArr2 = new byte[20];
                bArr2[3] = 1;
                bArr2[4] = this.type.getBytes()[0];
                bArr2[5] = this.type.getBytes()[1];
                bArr2[6] = this.type.getBytes()[2];
                bArr2[7] = this.type.getBytes()[3];
                wrap = ByteBuffer.wrap(bArr2);
                wrap.position(8);
                IsoTypeWriter.writeUInt64(wrap, getSize());
                writeVersionAndFlags(wrap);
            }
            wrap.rewind();
            return wrap;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            dataSource.read(allocate);
            parseVersionAndFlags((ByteBuffer) allocate.rewind());
            super.parse(dataSource, byteBuffer, j, boxParser);
        }
    }
}
