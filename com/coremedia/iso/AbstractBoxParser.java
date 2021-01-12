package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public abstract class AbstractBoxParser implements BoxParser {
    private static Logger LOG = Logger.getLogger(AbstractBoxParser.class.getName());
    ThreadLocal<ByteBuffer> header = new ThreadLocal<ByteBuffer>() { // from class: com.coremedia.iso.AbstractBoxParser.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: epd */
        public ByteBuffer initialValue() {
            return ByteBuffer.allocate(32);
        }
    };

    public abstract Box createBox(String str, byte[] bArr, String str2);

    @Override // com.coremedia.iso.BoxParser
    public Box parseBox(DataSource dataSource, Container container) throws IOException {
        long j;
        long j2;
        byte[] bArr;
        this.header.get().rewind().limit(8);
        int i = 0;
        while (true) {
            i = dataSource.read(this.header.get()) + i;
            if (i != 8) {
                if (i < 0) {
                    throw new EOFException();
                }
            } else {
                this.header.get().rewind();
                long readUInt32 = IsoTypeReader.readUInt32(this.header.get());
                if (readUInt32 < 8 && readUInt32 > 1) {
                    LOG.severe("Plausibility check failed: size < 8 (size = " + readUInt32 + "). Stop parsing!");
                    return null;
                }
                String read4cc = IsoTypeReader.read4cc(this.header.get());
                byte[] bArr2 = null;
                if (readUInt32 == 1) {
                    this.header.get().limit(16);
                    dataSource.read(this.header.get());
                    this.header.get().position(8);
                    j = IsoTypeReader.readUInt64(this.header.get()) - 16;
                } else if (readUInt32 == 0) {
                    long size = ((dataSource.size() - dataSource.position()) - 8) - 8;
                    throw new RuntimeException("'" + read4cc + "' with '" + (container instanceof Box ? ((Box) container).getType() : "IsoFile") + "' as parent has length == 0. That's not supported");
                } else {
                    j = readUInt32 - 8;
                }
                if ("uuid".equals(read4cc)) {
                    this.header.get().limit(this.header.get().limit() + 16);
                    dataSource.read(this.header.get());
                    byte[] bArr3 = new byte[16];
                    int position = this.header.get().position() - 16;
                    while (true) {
                        int i2 = position;
                        if (i2 >= this.header.get().position()) {
                            break;
                        }
                        bArr3[i2 - (this.header.get().position() - 16)] = this.header.get().get(i2);
                        position = i2 + 1;
                    }
                    j2 = j - 16;
                    bArr = bArr3;
                } else {
                    j2 = j;
                    bArr = bArr2;
                }
                Box createBox = createBox(read4cc, bArr, container instanceof Box ? ((Box) container).getType() : "");
                createBox.setParent(container);
                this.header.get().rewind();
                createBox.parse(dataSource, this.header.get(), j2, this);
                return createBox;
            }
        }
    }
}
