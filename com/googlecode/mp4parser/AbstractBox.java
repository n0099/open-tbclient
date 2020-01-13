package com.googlecode.mp4parser;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Logger;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes5.dex */
public abstract class AbstractBox implements Box {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Logger LOG;
    private ByteBuffer content;
    long contentStartPosition;
    DataSource dataSource;
    long offset;
    private Container parent;
    protected String type;
    private byte[] userType;
    long memMapSize = -1;
    private ByteBuffer deadBytes = null;
    boolean isRead = true;
    boolean isParsed = true;

    protected abstract void _parseDetails(ByteBuffer byteBuffer);

    protected abstract void getContent(ByteBuffer byteBuffer);

    protected abstract long getContentSize();

    static {
        $assertionsDisabled = !AbstractBox.class.desiredAssertionStatus();
        LOG = Logger.getLogger(AbstractBox.class);
    }

    private synchronized void readContent() {
        if (!this.isRead) {
            try {
                LOG.logDebug("mem mapping " + getType());
                this.content = this.dataSource.map(this.contentStartPosition, this.memMapSize);
                this.isRead = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        return this.offset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBox(String str) {
        this.type = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBox(String str, byte[] bArr) {
        this.type = str;
        this.userType = bArr;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.contentStartPosition = dataSource.position();
        this.offset = this.contentStartPosition - byteBuffer.remaining();
        this.memMapSize = j;
        this.dataSource = dataSource;
        dataSource.position(dataSource.position() + j);
        this.isRead = false;
        this.isParsed = false;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        if (this.isRead) {
            if (this.isParsed) {
                ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(getSize()));
                getHeader(allocate);
                getContent(allocate);
                if (this.deadBytes != null) {
                    this.deadBytes.rewind();
                    while (this.deadBytes.remaining() > 0) {
                        allocate.put(this.deadBytes);
                    }
                }
                writableByteChannel.write((ByteBuffer) allocate.rewind());
                return;
            }
            ByteBuffer allocate2 = ByteBuffer.allocate((isSmallBox() ? 8 : 16) + ("uuid".equals(getType()) ? 16 : 0));
            getHeader(allocate2);
            writableByteChannel.write((ByteBuffer) allocate2.rewind());
            writableByteChannel.write((ByteBuffer) this.content.position(0));
            return;
        }
        ByteBuffer allocate3 = ByteBuffer.allocate((isSmallBox() ? 8 : 16) + ("uuid".equals(getType()) ? 16 : 0));
        getHeader(allocate3);
        writableByteChannel.write((ByteBuffer) allocate3.rewind());
        this.dataSource.transferTo(this.contentStartPosition, this.memMapSize, writableByteChannel);
    }

    public final synchronized void parseDetails() {
        readContent();
        LOG.logDebug("parsing details of " + getType());
        if (this.content != null) {
            ByteBuffer byteBuffer = this.content;
            this.isParsed = true;
            byteBuffer.rewind();
            _parseDetails(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.deadBytes = byteBuffer.slice();
            }
            this.content = null;
            if (!$assertionsDisabled && !verify(byteBuffer)) {
                throw new AssertionError();
            }
        }
    }

    protected void setDeadBytes(ByteBuffer byteBuffer) {
        this.deadBytes = byteBuffer;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        long j;
        if (!this.isRead) {
            j = this.memMapSize;
        } else if (this.isParsed) {
            j = getContentSize();
        } else {
            j = this.content != null ? this.content.limit() : 0;
        }
        return (this.deadBytes != null ? this.deadBytes.limit() : 0) + j + ("uuid".equals(getType()) ? 16 : 0) + (j >= 4294967288L ? 8 : 0) + 8;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public String getType() {
        return this.type;
    }

    @DoNotParseDetail
    public byte[] getUserType() {
        return this.userType;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public Container getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public void setParent(Container container) {
        this.parent = container;
    }

    public boolean isParsed() {
        return this.isParsed;
    }

    private boolean verify(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(getContentSize() + (this.deadBytes != null ? this.deadBytes.limit() : 0)));
        getContent(allocate);
        if (this.deadBytes != null) {
            this.deadBytes.rewind();
            while (this.deadBytes.remaining() > 0) {
                allocate.put(this.deadBytes);
            }
        }
        byteBuffer.rewind();
        allocate.rewind();
        if (byteBuffer.remaining() != allocate.remaining()) {
            System.err.print(String.valueOf(getType()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
            LOG.logError(String.valueOf(getType()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
            return false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 1;
        int limit2 = allocate.limit() - 1;
        while (limit >= position) {
            byte b = byteBuffer.get(limit);
            byte b2 = allocate.get(limit2);
            if (b == b2) {
                limit--;
                limit2--;
            } else {
                LOG.logError(String.format("%s: buffers differ at %d: %2X/%2X", getType(), Integer.valueOf(limit), Byte.valueOf(b), Byte.valueOf(b2)));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[allocate.remaining()];
                byteBuffer.get(bArr);
                allocate.get(bArr2);
                System.err.println("original      : " + Hex.encodeHex(bArr, 4));
                System.err.println("reconstructed : " + Hex.encodeHex(bArr2, 4));
                return false;
            }
        }
        return true;
    }

    private boolean isSmallBox() {
        int i = 8;
        if ("uuid".equals(getType())) {
            i = 24;
        }
        if (!this.isRead) {
            return this.memMapSize + ((long) i) < 4294967296L;
        } else if (this.isParsed) {
            return (getContentSize() + ((long) (this.deadBytes != null ? this.deadBytes.limit() : 0))) + ((long) i) < 4294967296L;
        } else {
            return ((long) (i + this.content.limit())) < 4294967296L;
        }
    }

    private void getHeader(ByteBuffer byteBuffer) {
        if (isSmallBox()) {
            IsoTypeWriter.writeUInt32(byteBuffer, getSize());
            byteBuffer.put(IsoFile.fourCCtoBytes(getType()));
        } else {
            IsoTypeWriter.writeUInt32(byteBuffer, 1L);
            byteBuffer.put(IsoFile.fourCCtoBytes(getType()));
            IsoTypeWriter.writeUInt64(byteBuffer, getSize());
        }
        if ("uuid".equals(getType())) {
            byteBuffer.put(getUserType());
        }
    }

    @DoNotParseDetail
    public String getPath() {
        return Path.createPath(this);
    }
}
