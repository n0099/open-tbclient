package com.coremedia.iso.boxes.mdat;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class MediaDataBox implements Box {
    public static Logger LOG = Logger.getLogger(MediaDataBox.class.getName());
    public static final String TYPE = "mdat";
    public DataSource dataSource;
    public boolean largeBox = false;
    public long offset;
    public Container parent;
    public long size;

    public static void transfer(DataSource dataSource, long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        long j3 = 0;
        while (j3 < j2) {
            j3 += dataSource.transferTo(j + j3, Math.min(67076096L, j2 - j3), writableByteChannel);
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        transfer(this.dataSource, this.offset, this.size, writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        return this.offset;
    }

    @Override // com.coremedia.iso.boxes.Box
    public Container getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        return this.size;
    }

    @Override // com.coremedia.iso.boxes.Box
    public String getType() {
        return TYPE;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.offset = dataSource.position() - byteBuffer.remaining();
        this.dataSource = dataSource;
        this.size = byteBuffer.remaining() + j;
        dataSource.position(dataSource.position() + j);
    }

    @Override // com.coremedia.iso.boxes.Box
    public void setParent(Container container) {
        this.parent = container;
    }

    public String toString() {
        return "MediaDataBox{size=" + this.size + '}';
    }
}
