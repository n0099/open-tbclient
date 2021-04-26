package com.googlecode.mp4parser;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.FullBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public abstract class FullContainerBox extends AbstractContainerBox implements FullBox {
    public static Logger LOG = Logger.getLogger(FullContainerBox.class.getName());
    public int flags;
    public int version;

    public FullContainerBox(String str) {
        super(str);
    }

    @Override // com.googlecode.mp4parser.BasicContainer, com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        return getBoxes(cls, false);
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public int getFlags() {
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public ByteBuffer getHeader() {
        ByteBuffer wrap;
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

    @Override // com.coremedia.iso.boxes.FullBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        dataSource.read(allocate);
        parseVersionAndFlags((ByteBuffer) allocate.rewind());
        super.parse(dataSource, byteBuffer, j, boxParser);
    }

    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = IsoTypeReader.readUInt8(byteBuffer);
        this.flags = IsoTypeReader.readUInt24(byteBuffer);
        return 4L;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setFlags(int i2) {
        this.flags = i2;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setVersion(int i2) {
        this.version = i2;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        return String.valueOf(FullContainerBox.class.getSimpleName()) + "[childBoxes]";
    }

    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt8(byteBuffer, this.version);
        IsoTypeWriter.writeUInt24(byteBuffer, this.flags);
    }
}
