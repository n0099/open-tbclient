package com.coremedia.iso.boxes;

import com.alibaba.fastjson.asm.Opcodes;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class HandlerBox extends AbstractFullBox {
    public static final String TYPE = "hdlr";
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_5 = null;
    public static final Map<String, String> readableTypes;

    /* renamed from: a  reason: collision with root package name */
    public long f30497a;

    /* renamed from: b  reason: collision with root package name */
    public long f30498b;

    /* renamed from: c  reason: collision with root package name */
    public long f30499c;
    public String handlerType;
    public String name;
    public long shouldBeZeroButAppleWritesHereSomeValue;
    public boolean zeroTerm;

    static {
        ajc$preClinit();
        HashMap hashMap = new HashMap();
        hashMap.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mdir", "Apple Meta Data iTunes Reader");
        hashMap.put("mp7b", "MPEG-7 binary XML");
        hashMap.put("mp7t", "MPEG-7 XML");
        hashMap.put("vide", "Video Track");
        hashMap.put("soun", "Sound Track");
        hashMap.put(TrackReferenceTypeBox.TYPE1, "Hint Track");
        hashMap.put("appl", "Apple specific");
        hashMap.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        readableTypes = Collections.unmodifiableMap(hashMap);
    }

    public HandlerBox() {
        super(TYPE);
        this.name = null;
        this.zeroTerm = true;
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("HandlerBox.java", HandlerBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "name", "", "void"), 87);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), Opcodes.FCMPL);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.shouldBeZeroButAppleWritesHereSomeValue = IsoTypeReader.readUInt32(byteBuffer);
        this.handlerType = IsoTypeReader.read4cc(byteBuffer);
        this.f30497a = IsoTypeReader.readUInt32(byteBuffer);
        this.f30498b = IsoTypeReader.readUInt32(byteBuffer);
        this.f30499c = IsoTypeReader.readUInt32(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            String readString = IsoTypeReader.readString(byteBuffer, byteBuffer.remaining());
            this.name = readString;
            if (readString.endsWith("\u0000")) {
                String str = this.name;
                this.name = str.substring(0, str.length() - 1);
                this.zeroTerm = true;
                return;
            }
            this.zeroTerm = false;
            return;
        }
        this.zeroTerm = false;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.shouldBeZeroButAppleWritesHereSomeValue);
        byteBuffer.put(IsoFile.fourCCtoBytes(this.handlerType));
        IsoTypeWriter.writeUInt32(byteBuffer, this.f30497a);
        IsoTypeWriter.writeUInt32(byteBuffer, this.f30498b);
        IsoTypeWriter.writeUInt32(byteBuffer, this.f30499c);
        String str = this.name;
        if (str != null) {
            byteBuffer.put(Utf8.convert(str));
        }
        if (this.zeroTerm) {
            byteBuffer.put((byte) 0);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        int utf8StringLengthInBytes;
        if (this.zeroTerm) {
            utf8StringLengthInBytes = Utf8.utf8StringLengthInBytes(this.name) + 25;
        } else {
            utf8StringLengthInBytes = Utf8.utf8StringLengthInBytes(this.name) + 24;
        }
        return utf8StringLengthInBytes;
    }

    public String getHandlerType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.handlerType;
    }

    public String getHumanReadableTrackType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return readableTypes.get(this.handlerType) != null ? readableTypes.get(this.handlerType) : "Unknown Handler Type";
    }

    public String getName() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.name;
    }

    public void setHandlerType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, str));
        this.handlerType = str;
    }

    public void setName(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.name = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return "HandlerBox[handlerType=" + getHandlerType() + ";name=" + getName() + "]";
    }
}
