package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class CencSampleEncryptionInformationGroupEntry extends GroupEntry {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TYPE = "seig";
    private int isEncrypted;
    private byte ivSize;
    private byte[] kid = new byte[16];

    static {
        $assertionsDisabled = !CencSampleEncryptionInformationGroupEntry.class.desiredAssertionStatus();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        this.isEncrypted = IsoTypeReader.readUInt24(byteBuffer);
        this.ivSize = (byte) IsoTypeReader.readUInt8(byteBuffer);
        this.kid = new byte[16];
        byteBuffer.get(this.kid);
    }

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

    public void setEncrypted(int i) {
        this.isEncrypted = i;
    }

    public byte getIvSize() {
        return this.ivSize;
    }

    public void setIvSize(byte b) {
        this.ivSize = b;
    }

    public byte[] getKid() {
        return this.kid;
    }

    public void setKid(byte[] bArr) {
        if (!$assertionsDisabled && bArr.length != 16) {
            throw new AssertionError();
        }
        this.kid = bArr;
    }

    public String toString() {
        return "CencSampleEncryptionInformationGroupEntry{isEncrypted=" + this.isEncrypted + ", ivSize=" + ((int) this.ivSize) + ", kid=" + Hex.encodeHex(this.kid) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CencSampleEncryptionInformationGroupEntry cencSampleEncryptionInformationGroupEntry = (CencSampleEncryptionInformationGroupEntry) obj;
        return this.isEncrypted == cencSampleEncryptionInformationGroupEntry.isEncrypted && this.ivSize == cencSampleEncryptionInformationGroupEntry.ivSize && Arrays.equals(this.kid, cencSampleEncryptionInformationGroupEntry.kid);
    }

    public int hashCode() {
        return (this.kid != null ? Arrays.hashCode(this.kid) : 0) + (((this.isEncrypted * 31) + this.ivSize) * 31);
    }
}
