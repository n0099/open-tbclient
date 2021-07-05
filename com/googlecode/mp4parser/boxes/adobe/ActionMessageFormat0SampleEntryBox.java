package com.googlecode.mp4parser.boxes.adobe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes7.dex */
public class ActionMessageFormat0SampleEntryBox extends AbstractSampleEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "amf0";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionMessageFormat0SampleEntryBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
            writeContainer(writableByteChannel);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long containerSize = getContainerSize() + 8;
            return containerSize + ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8);
        }
        return invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            dataSource.read(allocate);
            allocate.position(6);
            this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
            parseContainer(dataSource, j - 8, boxParser);
        }
    }
}
