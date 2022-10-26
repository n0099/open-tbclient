package com.coremedia.iso.boxes.sampleentry;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes7.dex */
public class Ovc1VisualSampleEntryImpl extends AbstractSampleEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "ovc1";
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] vc1Content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ovc1VisualSampleEntryImpl() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vc1Content = new byte[0];
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = 16;
            if (!this.largeBox && this.vc1Content.length + 16 < 4294967296L) {
                i = 8;
            }
            return i + this.vc1Content.length + 8;
        }
        return invokeV.longValue;
    }

    public byte[] getVc1Content() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.vc1Content;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.position(6);
            IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            writableByteChannel.write(ByteBuffer.wrap(this.vc1Content));
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(j));
            dataSource.read(allocate);
            allocate.position(6);
            this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
            byte[] bArr = new byte[allocate.remaining()];
            this.vc1Content = bArr;
            allocate.get(bArr);
        }
    }

    public void setVc1Content(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            this.vc1Content = bArr;
        }
    }
}
