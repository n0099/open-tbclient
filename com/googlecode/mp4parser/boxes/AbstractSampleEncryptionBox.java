package com.googlecode.mp4parser.boxes;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.mobstat.Config;
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
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public abstract class AbstractSampleEncryptionBox extends AbstractFullBox {
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_5 = null;
    protected int algorithmId;
    List<CencSampleAuxiliaryDataFormat> entries;
    protected int ivSize;
    protected byte[] kid;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 33);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 92);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 96);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", Config.OS, "", "boolean"), 164);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 191);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), Opcodes.IFNONNULL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSampleEncryptionBox(String str) {
        super(str);
        this.algorithmId = -1;
        this.ivSize = -1;
        this.kid = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        this.entries = new LinkedList();
    }

    public int getOffsetToFirstIV() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return (getSize() > 4294967296L ? 16 : 8) + (isOverrideTrackEncryptionBoxParameters() ? this.kid.length + 4 : 0) + 4;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) > 0) {
            this.algorithmId = IsoTypeReader.readUInt24(byteBuffer);
            this.ivSize = IsoTypeReader.readUInt8(byteBuffer);
            this.kid = new byte[16];
            byteBuffer.get(this.kid);
        }
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        this.entries = parseEntries(duplicate, readUInt32, 8);
        if (this.entries == null) {
            this.entries = parseEntries(duplicate2, readUInt32, 16);
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate2.remaining());
        } else {
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate.remaining());
        }
        if (this.entries == null) {
            throw new RuntimeException("Cannot parse SampleEncryptionBox");
        }
    }

    private List<CencSampleAuxiliaryDataFormat> parseEntries(ByteBuffer byteBuffer, long j, int i) {
        LinkedList linkedList = new LinkedList();
        while (true) {
            long j2 = j - 1;
            if (j > 0) {
                try {
                    CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
                    cencSampleAuxiliaryDataFormat.iv = new byte[i];
                    byteBuffer.get(cencSampleAuxiliaryDataFormat.iv);
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
                } catch (BufferUnderflowException e) {
                    return null;
                }
            } else {
                return linkedList;
            }
        }
    }

    public List<CencSampleAuxiliaryDataFormat> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.entries;
    }

    public void setEntries(List<CencSampleAuxiliaryDataFormat> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, list));
        this.entries = list;
    }

    @DoNotParseDetail
    public boolean isSubSampleEncryption() {
        return (getFlags() & 2) > 0;
    }

    @DoNotParseDetail
    protected boolean isOverrideTrackEncryptionBoxParameters() {
        return (getFlags() & 1) > 0;
    }

    @DoNotParseDetail
    public void setSubSampleEncryption(boolean z) {
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & 16777213);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (isOverrideTrackEncryptionBoxParameters()) {
            IsoTypeWriter.writeUInt24(byteBuffer, this.algorithmId);
            IsoTypeWriter.writeUInt8(byteBuffer, this.ivSize);
            byteBuffer.put(this.kid);
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
            if (cencSampleAuxiliaryDataFormat.iv.length != 8 && cencSampleAuxiliaryDataFormat.iv.length != 16) {
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

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long length = (isOverrideTrackEncryptionBoxParameters() ? 4 + 4 + this.kid.length : 4L) + 4;
        Iterator<CencSampleAuxiliaryDataFormat> it = this.entries.iterator();
        while (true) {
            long j = length;
            if (it.hasNext()) {
                length = it.next().getSize() + j;
            } else {
                return j;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        super.getBox(writableByteChannel);
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractSampleEncryptionBox abstractSampleEncryptionBox = (AbstractSampleEncryptionBox) obj;
        if (this.algorithmId == abstractSampleEncryptionBox.algorithmId && this.ivSize == abstractSampleEncryptionBox.ivSize) {
            if (this.entries == null ? abstractSampleEncryptionBox.entries != null : !this.entries.equals(abstractSampleEncryptionBox.entries)) {
                return false;
            }
            return Arrays.equals(this.kid, abstractSampleEncryptionBox.kid);
        }
        return false;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return (((this.kid != null ? Arrays.hashCode(this.kid) : 0) + (((this.algorithmId * 31) + this.ivSize) * 31)) * 31) + (this.entries != null ? this.entries.hashCode() : 0);
    }

    public List<Short> getEntrySizes() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        ArrayList arrayList = new ArrayList(this.entries.size());
        for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
            short length = (short) cencSampleAuxiliaryDataFormat.iv.length;
            arrayList.add(Short.valueOf(isSubSampleEncryption() ? (short) ((cencSampleAuxiliaryDataFormat.pairs.size() * 6) + ((short) (length + 2))) : length));
        }
        return arrayList;
    }
}
