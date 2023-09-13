package com.googlecode.mp4parser.boxes.cenc;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.UUIDConverter;
import java.nio.ByteBuffer;
import java.util.UUID;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public class ProtectionSystemSpecificHeaderBox extends AbstractFullBox {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static byte[] OMA2_SYSTEM_ID = null;
    public static byte[] PLAYREADY_SYSTEM_ID = null;
    public static final String TYPE = "pssh";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public byte[] content;
    public byte[] systemId;

    static {
        ajc$preClinit();
        OMA2_SYSTEM_ID = UUIDConverter.convert(UUID.fromString("A2B55680-6F43-11E0-9A3F-0002A5D5C51B"));
        PLAYREADY_SYSTEM_ID = UUIDConverter.convert(UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95"));
    }

    public ProtectionSystemSpecificHeaderBox() {
        super(TYPE);
    }

    public byte[] getContent() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.content;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return this.content.length + 24;
    }

    public byte[] getSystemId() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.systemId;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("ProtectionSystemSpecificHeaderBox.java", ProtectionSystemSpecificHeaderBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSystemId", "com.googlecode.mp4parser.boxes.cenc.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 38);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSystemId", "com.googlecode.mp4parser.boxes.cenc.ProtectionSystemSpecificHeaderBox", "[B", "systemId", "", "void"), 42);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getContent", "com.googlecode.mp4parser.boxes.cenc.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 47);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setContent", "com.googlecode.mp4parser.boxes.cenc.ProtectionSystemSpecificHeaderBox", "[B", "content", "", "void"), 51);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte[] bArr = new byte[16];
        this.systemId = bArr;
        byteBuffer.get(bArr);
        IsoTypeReader.readUInt32(byteBuffer);
        byte[] bArr2 = new byte[byteBuffer.remaining()];
        this.content = bArr2;
        byteBuffer.get(bArr2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.systemId, 0, 16);
        IsoTypeWriter.writeUInt32(byteBuffer, this.content.length);
        byteBuffer.put(this.content);
    }

    public void setContent(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, bArr));
        this.content = bArr;
    }

    public void setSystemId(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, bArr));
        this.systemId = bArr;
    }
}
