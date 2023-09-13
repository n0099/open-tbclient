package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class CencSampleEncryptionInformationGroupEntry extends GroupEntry {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "seig";
    public int isEncrypted;
    public byte ivSize;
    public byte[] kid = new byte[16];

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(20);
        IsoTypeWriter.writeUInt24(allocate, this.isEncrypted);
        IsoTypeWriter.writeUInt8(allocate, this.ivSize);
        allocate.put(this.kid);
        allocate.rewind();
        return allocate;
    }

    public int getEncrypted() {
        return this.isEncrypted;
    }

    public byte getIvSize() {
        return this.ivSize;
    }

    public byte[] getKid() {
        return this.kid;
    }

    public int hashCode() {
        int i;
        int i2 = ((this.isEncrypted * 31) + this.ivSize) * 31;
        byte[] bArr = this.kid;
        if (bArr != null) {
            i = Arrays.hashCode(bArr);
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public String toString() {
        return "CencSampleEncryptionInformationGroupEntry{isEncrypted=" + this.isEncrypted + ", ivSize=" + ((int) this.ivSize) + ", kid=" + Hex.encodeHex(this.kid) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CencSampleEncryptionInformationGroupEntry.class != obj.getClass()) {
            return false;
        }
        CencSampleEncryptionInformationGroupEntry cencSampleEncryptionInformationGroupEntry = (CencSampleEncryptionInformationGroupEntry) obj;
        if (this.isEncrypted == cencSampleEncryptionInformationGroupEntry.isEncrypted && this.ivSize == cencSampleEncryptionInformationGroupEntry.ivSize && Arrays.equals(this.kid, cencSampleEncryptionInformationGroupEntry.kid)) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        this.isEncrypted = IsoTypeReader.readUInt24(byteBuffer);
        this.ivSize = (byte) IsoTypeReader.readUInt8(byteBuffer);
        byte[] bArr = new byte[16];
        this.kid = bArr;
        byteBuffer.get(bArr);
    }

    public void setEncrypted(int i) {
        this.isEncrypted = i;
    }

    public void setIvSize(byte b) {
        this.ivSize = b;
    }

    public void setKid(byte[] bArr) {
        this.kid = bArr;
    }
}
