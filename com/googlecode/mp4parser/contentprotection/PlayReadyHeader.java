package com.googlecode.mp4parser.contentprotection;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.apache.commons.base.CharEncoding;
/* loaded from: classes6.dex */
public class PlayReadyHeader extends ProtectionSpecificHeader {
    public static UUID PROTECTION_SYSTEM_ID = UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95");
    public long length;
    public List<PlayReadyRecord> records;

    /* loaded from: classes6.dex */
    public static abstract class PlayReadyRecord {
        public int type;

        /* loaded from: classes6.dex */
        public static class DefaulPlayReadyRecord extends PlayReadyRecord {
            public ByteBuffer value;

            public DefaulPlayReadyRecord(int i2) {
                super(i2);
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                return this.value;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                this.value = byteBuffer.duplicate();
            }
        }

        /* loaded from: classes6.dex */
        public static class EmeddedLicenseStore extends PlayReadyRecord {
            public ByteBuffer value;

            public EmeddedLicenseStore() {
                super(3);
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                return this.value;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                this.value = byteBuffer.duplicate();
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public String toString() {
                return "EmeddedLicenseStore{length=" + getValue().limit() + '}';
            }
        }

        /* loaded from: classes6.dex */
        public static class RMHeader extends PlayReadyRecord {
            public String header;

            public RMHeader() {
                super(1);
            }

            public String getHeader() {
                return this.header;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                try {
                    return ByteBuffer.wrap(this.header.getBytes(CharEncoding.UTF_16LE));
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException(e2);
                }
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                try {
                    byte[] bArr = new byte[byteBuffer.slice().limit()];
                    byteBuffer.get(bArr);
                    this.header = new String(bArr, CharEncoding.UTF_16LE);
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException(e2);
                }
            }

            public void setHeader(String str) {
                this.header = str;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public String toString() {
                return "RMHeader{length=" + getValue().limit() + ", header='" + this.header + "'}";
            }
        }

        public PlayReadyRecord(int i2) {
            this.type = i2;
        }

        public static List<PlayReadyRecord> createFor(ByteBuffer byteBuffer, int i2) {
            PlayReadyRecord rMHeader;
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                int readUInt16BE = IsoTypeReader.readUInt16BE(byteBuffer);
                int readUInt16BE2 = IsoTypeReader.readUInt16BE(byteBuffer);
                if (readUInt16BE == 1) {
                    rMHeader = new RMHeader();
                } else if (readUInt16BE == 2) {
                    rMHeader = new DefaulPlayReadyRecord(2);
                } else if (readUInt16BE != 3) {
                    rMHeader = new DefaulPlayReadyRecord(readUInt16BE);
                } else {
                    rMHeader = new EmeddedLicenseStore();
                }
                rMHeader.parse((ByteBuffer) byteBuffer.slice().limit(readUInt16BE2));
                byteBuffer.position(byteBuffer.position() + readUInt16BE2);
                arrayList.add(rMHeader);
            }
            return arrayList;
        }

        public abstract ByteBuffer getValue();

        public abstract void parse(ByteBuffer byteBuffer);

        public String toString() {
            return "PlayReadyRecord{type=" + this.type + ", length=" + getValue().limit() + '}';
        }
    }

    static {
        ProtectionSpecificHeader.uuidRegistry.put(PROTECTION_SYSTEM_ID, PlayReadyHeader.class);
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public ByteBuffer getData() {
        int i2 = 6;
        for (PlayReadyRecord playReadyRecord : this.records) {
            i2 = i2 + 4 + playReadyRecord.getValue().rewind().limit();
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        IsoTypeWriter.writeUInt32BE(allocate, i2);
        IsoTypeWriter.writeUInt16BE(allocate, this.records.size());
        for (PlayReadyRecord playReadyRecord2 : this.records) {
            IsoTypeWriter.writeUInt16BE(allocate, playReadyRecord2.type);
            IsoTypeWriter.writeUInt16BE(allocate, playReadyRecord2.getValue().limit());
            allocate.put(playReadyRecord2.getValue());
        }
        return allocate;
    }

    public List<PlayReadyRecord> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public UUID getSystemId() {
        return PROTECTION_SYSTEM_ID;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public void parse(ByteBuffer byteBuffer) {
        this.length = IsoTypeReader.readUInt32BE(byteBuffer);
        this.records = PlayReadyRecord.createFor(byteBuffer, IsoTypeReader.readUInt16BE(byteBuffer));
    }

    public void setRecords(List<PlayReadyRecord> list) {
        this.records = list;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public String toString() {
        return "PlayReadyHeader{length=" + this.length + ", recordCount=" + this.records.size() + ", records=" + this.records + '}';
    }
}
