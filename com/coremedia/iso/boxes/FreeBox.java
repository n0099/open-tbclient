package com.coremedia.iso.boxes;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class FreeBox implements Box {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TYPE = "free";
    ByteBuffer data;
    private long offset;
    private Container parent;
    List<Box> replacers;

    static {
        $assertionsDisabled = !FreeBox.class.desiredAssertionStatus();
    }

    public FreeBox() {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.wrap(new byte[0]);
    }

    public FreeBox(int i) {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.allocate(i);
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        return this.offset;
    }

    public ByteBuffer getData() {
        if (this.data != null) {
            return (ByteBuffer) this.data.duplicate().rewind();
        }
        return null;
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
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

    @Override // com.coremedia.iso.boxes.Box
    public Container getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void setParent(Container container) {
        this.parent = container;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        long j = 8;
        Iterator<Box> it = this.replacers.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = it.next().getSize() + j2;
            } else {
                return this.data.limit() + j2;
            }
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public String getType() {
        return "free";
    }

    @Override // com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.offset = dataSource.position() - byteBuffer.remaining();
        if (j > 1048576) {
            this.data = dataSource.map(dataSource.position(), j);
            dataSource.position(dataSource.position() + j);
        } else if (!$assertionsDisabled && j >= 2147483647L) {
            throw new AssertionError();
        } else {
            this.data = ByteBuffer.allocate(CastUtils.l2i(j));
            dataSource.read(this.data);
        }
    }

    public void addAndReplace(Box box) {
        this.data.position(CastUtils.l2i(box.getSize()));
        this.data = this.data.slice();
        this.replacers.add(box);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FreeBox freeBox = (FreeBox) obj;
        if (getData() != null) {
            if (getData().equals(freeBox.getData())) {
                return true;
            }
        } else if (freeBox.getData() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.data != null) {
            return this.data.hashCode();
        }
        return 0;
    }
}
