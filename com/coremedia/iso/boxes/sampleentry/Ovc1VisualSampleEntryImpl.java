package com.coremedia.iso.boxes.sampleentry;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes8.dex */
public class Ovc1VisualSampleEntryImpl extends AbstractSampleEntry {
    public static final String TYPE = "ovc1";
    private byte[] vc1Content;

    public Ovc1VisualSampleEntryImpl() {
        super(TYPE);
        this.vc1Content = new byte[0];
    }

    public byte[] getVc1Content() {
        return this.vc1Content;
    }

    public void setVc1Content(byte[] bArr) {
        this.vc1Content = bArr;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(j));
        dataSource.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
        this.vc1Content = new byte[allocate.remaining()];
        allocate.get(this.vc1Content);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writableByteChannel.write(ByteBuffer.wrap(this.vc1Content));
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        return ((this.largeBox || ((long) (this.vc1Content.length + 16)) >= AccountConstants.TYPE_MODIFY_EXT_FIELDS) ? 16 : 8) + this.vc1Content.length + 8;
    }
}
