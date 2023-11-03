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
/* loaded from: classes10.dex */
public abstract class AbstractBox implements Box {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Logger LOG = Logger.getLogger(AbstractBox.class);
    public ByteBuffer content;
    public long contentStartPosition;
    public DataSource dataSource;
    public long offset;
    public Container parent;
    public String type;
    public byte[] userType;
    public long memMapSize = -1;
    public ByteBuffer deadBytes = null;
    public boolean isRead = true;
    public boolean isParsed = true;

    public abstract void _parseDetails(ByteBuffer byteBuffer);

    public abstract void getContent(ByteBuffer byteBuffer);

    public abstract long getContentSize();

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        return this.offset;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public Container getParent() {
        return this.parent;
    }

    @DoNotParseDetail
    public String getPath() {
        return Path.createPath(this);
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

    public boolean isParsed() {
        return this.isParsed;
    }

    public AbstractBox(String str) {
        this.type = str;
    }

    public void setDeadBytes(ByteBuffer byteBuffer) {
        this.deadBytes = byteBuffer;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public void setParent(Container container) {
        this.parent = container;
    }

    public AbstractBox(String str, byte[] bArr) {
        this.type = str;
        this.userType = bArr;
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

    private boolean isSmallBox() {
        int i;
        int i2;
        if ("uuid".equals(getType())) {
            i = 24;
        } else {
            i = 8;
        }
        if (this.isRead) {
            if (this.isParsed) {
                long contentSize = getContentSize();
                ByteBuffer byteBuffer = this.deadBytes;
                if (byteBuffer != null) {
                    i2 = byteBuffer.limit();
                } else {
                    i2 = 0;
                }
                if (contentSize + i2 + i < 4294967296L) {
                    return true;
                }
                return false;
            } else if (this.content.limit() + i < 4294967296L) {
                return true;
            } else {
                return false;
            }
        } else if (this.memMapSize + i < 4294967296L) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        long j;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (this.isRead) {
            if (this.isParsed) {
                j = getContentSize();
            } else {
                ByteBuffer byteBuffer = this.content;
                if (byteBuffer != null) {
                    i3 = byteBuffer.limit();
                } else {
                    i3 = 0;
                }
                j = i3;
            }
        } else {
            j = this.memMapSize;
        }
        if (j >= 4294967288L) {
            i = 8;
        } else {
            i = 0;
        }
        int i5 = i + 8;
        if ("uuid".equals(getType())) {
            i2 = 16;
        } else {
            i2 = 0;
        }
        long j2 = j + i5 + i2;
        ByteBuffer byteBuffer2 = this.deadBytes;
        if (byteBuffer2 != null) {
            i4 = byteBuffer2.limit();
        }
        return j2 + i4;
    }

    private synchronized void readContent() {
        if (!this.isRead) {
            try {
                Logger logger = LOG;
                logger.logDebug("mem mapping " + getType());
                this.content = this.dataSource.map(this.contentStartPosition, this.memMapSize);
                this.isRead = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final synchronized void parseDetails() {
        readContent();
        Logger logger = LOG;
        logger.logDebug("parsing details of " + getType());
        if (this.content != null) {
            ByteBuffer byteBuffer = this.content;
            this.isParsed = true;
            byteBuffer.rewind();
            _parseDetails(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.deadBytes = byteBuffer.slice();
            }
            this.content = null;
        }
    }

    private boolean verify(ByteBuffer byteBuffer) {
        int i;
        long contentSize = getContentSize();
        ByteBuffer byteBuffer2 = this.deadBytes;
        if (byteBuffer2 != null) {
            i = byteBuffer2.limit();
        } else {
            i = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(contentSize + i));
        getContent(allocate);
        ByteBuffer byteBuffer3 = this.deadBytes;
        if (byteBuffer3 != null) {
            byteBuffer3.rewind();
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
            if (b != b2) {
                LOG.logError(String.format("%s: buffers differ at %d: %2X/%2X", getType(), Integer.valueOf(limit), Byte.valueOf(b), Byte.valueOf(b2)));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[allocate.remaining()];
                byteBuffer.get(bArr);
                allocate.get(bArr2);
                System.err.println("original      : " + Hex.encodeHex(bArr, 4));
                System.err.println("reconstructed : " + Hex.encodeHex(bArr2, 4));
                return false;
            }
            limit--;
            limit2--;
        }
        return true;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        int i = 8;
        int i2 = 0;
        int i3 = 16;
        if (this.isRead) {
            if (this.isParsed) {
                ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(getSize()));
                getHeader(allocate);
                getContent(allocate);
                ByteBuffer byteBuffer = this.deadBytes;
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    while (this.deadBytes.remaining() > 0) {
                        allocate.put(this.deadBytes);
                    }
                }
                writableByteChannel.write((ByteBuffer) allocate.rewind());
                return;
            }
            if (!isSmallBox()) {
                i = 16;
            }
            if (!"uuid".equals(getType())) {
                i3 = 0;
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i + i3);
            getHeader(allocate2);
            writableByteChannel.write((ByteBuffer) allocate2.rewind());
            writableByteChannel.write((ByteBuffer) this.content.position(0));
            return;
        }
        if (!isSmallBox()) {
            i = 16;
        }
        if ("uuid".equals(getType())) {
            i2 = 16;
        }
        ByteBuffer allocate3 = ByteBuffer.allocate(i + i2);
        getHeader(allocate3);
        writableByteChannel.write((ByteBuffer) allocate3.rewind());
        this.dataSource.transferTo(this.contentStartPosition, this.memMapSize, writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        long position = dataSource.position();
        this.contentStartPosition = position;
        this.offset = position - byteBuffer.remaining();
        this.memMapSize = j;
        this.dataSource = dataSource;
        dataSource.position(dataSource.position() + j);
        this.isRead = false;
        this.isParsed = false;
    }
}
