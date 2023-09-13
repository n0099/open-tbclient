package com.googlecode.mp4parser.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public abstract class AbstractSampleEncryptionBox extends AbstractFullBox {
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public int algorithmId;
    public List<CencSampleAuxiliaryDataFormat> entries;
    public int ivSize;
    public byte[] kid;

    static {
        ajc$preClinit();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        long j;
        Iterator<CencSampleAuxiliaryDataFormat> it;
        if (isOverrideTrackEncryptionBoxParameters()) {
            j = 8 + this.kid.length;
        } else {
            j = 4;
        }
        long j2 = j + 4;
        while (this.entries.iterator().hasNext()) {
            j2 += it.next().getSize();
        }
        return j2;
    }

    public List<CencSampleAuxiliaryDataFormat> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
        return this.entries;
    }

    public int getOffsetToFirstIV() {
        int i;
        int i2;
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        if (getSize() > 4294967296L) {
            i = 16;
        } else {
            i = 8;
        }
        if (isOverrideTrackEncryptionBoxParameters()) {
            i2 = this.kid.length + 4;
        } else {
            i2 = 0;
        }
        return i + i2 + 4;
    }

    public int hashCode() {
        int i;
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        int i2 = ((this.algorithmId * 31) + this.ivSize) * 31;
        byte[] bArr = this.kid;
        int i3 = 0;
        if (bArr != null) {
            i = Arrays.hashCode(bArr);
        } else {
            i = 0;
        }
        int i4 = (i2 + i) * 31;
        List<CencSampleAuxiliaryDataFormat> list = this.entries;
        if (list != null) {
            i3 = list.hashCode();
        }
        return i4 + i3;
    }

    @DoNotParseDetail
    public boolean isOverrideTrackEncryptionBoxParameters() {
        if ((getFlags() & 1) > 0) {
            return true;
        }
        return false;
    }

    @DoNotParseDetail
    public boolean isSubSampleEncryption() {
        if ((getFlags() & 2) > 0) {
            return true;
        }
        return false;
    }

    public AbstractSampleEncryptionBox(String str) {
        super(str);
        this.algorithmId = -1;
        this.ivSize = -1;
        this.kid = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        this.entries = new LinkedList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        super.getBox(writableByteChannel);
    }

    public void setEntries(List<CencSampleAuxiliaryDataFormat> list) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this, list));
        this.entries = list;
    }

    @DoNotParseDetail
    public void setSubSampleEncryption(boolean z) {
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & 16777213);
        }
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 33);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 92);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 96);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 164);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", TTDownloadField.TT_HASHCODE, "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 191);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
    }

    private List<CencSampleAuxiliaryDataFormat> parseEntries(ByteBuffer byteBuffer, long j, int i) {
        LinkedList linkedList = new LinkedList();
        while (true) {
            long j2 = j - 1;
            if (j <= 0) {
                return linkedList;
            }
            try {
                CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
                byte[] bArr = new byte[i];
                cencSampleAuxiliaryDataFormat.iv = bArr;
                byteBuffer.get(bArr);
                if ((getFlags() & 2) > 0) {
                    int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
                    cencSampleAuxiliaryDataFormat.pairs = new LinkedList();
                    while (true) {
                        int i2 = readUInt16 - 1;
                        if (readUInt16 <= 0) {
                            break;
                        }
                        cencSampleAuxiliaryDataFormat.pairs.add(cencSampleAuxiliaryDataFormat.createPair(IsoTypeReader.readUInt16(byteBuffer), IsoTypeReader.readUInt32(byteBuffer)));
                        readUInt16 = i2;
                    }
                }
                linkedList.add(cencSampleAuxiliaryDataFormat);
                j = j2;
            } catch (BufferUnderflowException unused) {
                return null;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) > 0) {
            this.algorithmId = IsoTypeReader.readUInt24(byteBuffer);
            this.ivSize = IsoTypeReader.readUInt8(byteBuffer);
            byte[] bArr = new byte[16];
            this.kid = bArr;
            byteBuffer.get(bArr);
        }
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        List<CencSampleAuxiliaryDataFormat> parseEntries = parseEntries(duplicate, readUInt32, 8);
        this.entries = parseEntries;
        if (parseEntries == null) {
            this.entries = parseEntries(duplicate2, readUInt32, 16);
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate2.remaining());
        } else {
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate.remaining());
        }
        if (this.entries != null) {
            return;
        }
        throw new RuntimeException("Cannot parse SampleEncryptionBox");
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (isOverrideTrackEncryptionBoxParameters()) {
            IsoTypeWriter.writeUInt24(byteBuffer, this.algorithmId);
            IsoTypeWriter.writeUInt8(byteBuffer, this.ivSize);
            byteBuffer.put(this.kid);
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
            byte[] bArr = cencSampleAuxiliaryDataFormat.iv;
            if (bArr.length != 8 && bArr.length != 16) {
                throw new RuntimeException("IV must be either 8 or 16 bytes");
            }
            byteBuffer.put(cencSampleAuxiliaryDataFormat.iv);
            if (isSubSampleEncryption()) {
                IsoTypeWriter.writeUInt16(byteBuffer, cencSampleAuxiliaryDataFormat.pairs.size());
                for (CencSampleAuxiliaryDataFormat.Pair pair : cencSampleAuxiliaryDataFormat.pairs) {
                    IsoTypeWriter.writeUInt16(byteBuffer, pair.clear);
                    IsoTypeWriter.writeUInt32(byteBuffer, pair.encrypted);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractSampleEncryptionBox abstractSampleEncryptionBox = (AbstractSampleEncryptionBox) obj;
        if (this.algorithmId != abstractSampleEncryptionBox.algorithmId || this.ivSize != abstractSampleEncryptionBox.ivSize) {
            return false;
        }
        List<CencSampleAuxiliaryDataFormat> list = this.entries;
        if (list == null ? abstractSampleEncryptionBox.entries != null : !list.equals(abstractSampleEncryptionBox.entries)) {
            return false;
        }
        if (Arrays.equals(this.kid, abstractSampleEncryptionBox.kid)) {
            return true;
        }
        return false;
    }

    public List<Short> getEntrySizes() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
        ArrayList arrayList = new ArrayList(this.entries.size());
        for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
            short length = (short) cencSampleAuxiliaryDataFormat.iv.length;
            if (isSubSampleEncryption()) {
                length = (short) (((short) (length + 2)) + (cencSampleAuxiliaryDataFormat.pairs.size() * 6));
            }
            arrayList.add(Short.valueOf(length));
        }
        return arrayList;
    }
}
