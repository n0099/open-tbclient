package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public abstract class AbstractBoxParser implements BoxParser {
    public static Logger LOG = Logger.getLogger(AbstractBoxParser.class.getName());
    public ThreadLocal<ByteBuffer> header = new a(this);

    /* loaded from: classes6.dex */
    public class a extends ThreadLocal<ByteBuffer> {
        public a(AbstractBoxParser abstractBoxParser) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ByteBuffer initialValue() {
            return ByteBuffer.allocate(32);
        }
    }

    public abstract Box createBox(String str, byte[] bArr, String str2);

    @Override // com.coremedia.iso.BoxParser
    public Box parseBox(DataSource dataSource, Container container) throws IOException {
        long j;
        long j2;
        this.header.get().rewind().limit(8);
        int i2 = 0;
        do {
            i2 += dataSource.read(this.header.get());
            if (i2 == 8) {
                this.header.get().rewind();
                long readUInt32 = IsoTypeReader.readUInt32(this.header.get());
                byte[] bArr = null;
                if (readUInt32 < 8 && readUInt32 > 1) {
                    Logger logger = LOG;
                    logger.severe("Plausibility check failed: size < 8 (size = " + readUInt32 + "). Stop parsing!");
                    return null;
                }
                String read4cc = IsoTypeReader.read4cc(this.header.get());
                if (readUInt32 == 1) {
                    this.header.get().limit(16);
                    dataSource.read(this.header.get());
                    this.header.get().position(8);
                    j = IsoTypeReader.readUInt64(this.header.get()) - 16;
                } else if (readUInt32 == 0) {
                    dataSource.size();
                    dataSource.position();
                    StringBuilder sb = new StringBuilder("'");
                    sb.append(read4cc);
                    sb.append("' with '");
                    sb.append(container instanceof Box ? ((Box) container).getType() : "IsoFile");
                    sb.append("' as parent has length == 0. That's not supported");
                    throw new RuntimeException(sb.toString());
                } else {
                    j = readUInt32 - 8;
                }
                if ("uuid".equals(read4cc)) {
                    this.header.get().limit(this.header.get().limit() + 16);
                    dataSource.read(this.header.get());
                    byte[] bArr2 = new byte[16];
                    for (int position = this.header.get().position() - 16; position < this.header.get().position(); position++) {
                        bArr2[position - (this.header.get().position() - 16)] = this.header.get().get(position);
                    }
                    j2 = j - 16;
                    bArr = bArr2;
                } else {
                    j2 = j;
                }
                Box createBox = createBox(read4cc, bArr, container instanceof Box ? ((Box) container).getType() : "");
                createBox.setParent(container);
                this.header.get().rewind();
                createBox.parse(dataSource, this.header.get(), j2, this);
                return createBox;
            }
        } while (i2 >= 0);
        throw new EOFException();
    }
}
