package com.coremedia.iso.boxes;

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
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class FreeBox implements Box {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "free";
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer data;
    public long offset;
    public Container parent;
    public List<Box> replacers;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1106873952, "Lcom/coremedia/iso/boxes/FreeBox;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1106873952, "Lcom/coremedia/iso/boxes/FreeBox;");
        }
    }

    public FreeBox() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.replacers = new LinkedList();
        this.data = ByteBuffer.wrap(new byte[0]);
    }

    public void addAndReplace(Box box) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, box) == null) {
            this.data.position(CastUtils.l2i(box.getSize()));
            this.data = this.data.slice();
            this.replacers.add(box);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || FreeBox.class != obj.getClass()) {
                return false;
            }
            FreeBox freeBox = (FreeBox) obj;
            return getData() == null ? freeBox.getData() == null : getData().equals(freeBox.getData());
        }
        return invokeL.booleanValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writableByteChannel) == null) {
            for (Box box : this.replacers) {
                box.getBox(writableByteChannel);
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            IsoTypeWriter.writeUInt32(allocate, this.data.limit() + 8);
            allocate.put("free".getBytes());
            allocate.rewind();
            writableByteChannel.write(allocate);
            allocate.rewind();
            this.data.rewind();
            writableByteChannel.write(this.data);
            this.data.rewind();
        }
    }

    public ByteBuffer getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer != null) {
                return (ByteBuffer) byteBuffer.duplicate().rewind();
            }
            return null;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.offset : invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public Container getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parent : (Container) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j = 8;
            for (Box box : this.replacers) {
                j += box.getSize();
            }
            return j + this.data.limit();
        }
        return invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "free" : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer != null) {
                return byteBuffer.hashCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            this.offset = dataSource.position() - byteBuffer.remaining();
            if (j > 1048576) {
                this.data = dataSource.map(dataSource.position(), j);
                dataSource.position(dataSource.position() + j);
                return;
            }
            ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(j));
            this.data = allocate;
            dataSource.read(allocate);
        }
    }

    public void setData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, byteBuffer) == null) {
            this.data = byteBuffer;
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public void setParent(Container container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, container) == null) {
            this.parent = container;
        }
    }

    public FreeBox(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.replacers = new LinkedList();
        this.data = ByteBuffer.allocate(i2);
    }
}
