package com.googlecode.mp4parser.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.baidu.mobstat.Config;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.UUID;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes8.dex */
public abstract class AbstractTrackEncryptionBox extends AbstractFullBox {
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_7 = null;
    int defaultAlgorithmId;
    int defaultIvSize;
    byte[] default_KID;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AbstractTrackEncryptionBox.java", AbstractTrackEncryptionBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getDefaultAlgorithmId", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 24);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setDefaultAlgorithmId", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "int", "defaultAlgorithmId", "", "void"), 28);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getDefaultIvSize", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 32);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setDefaultIvSize", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "int", "defaultIvSize", "", "void"), 36);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "getDefault_KID", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", FieldUtil.TYPE_STRING), 40);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "setDefault_KID", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "[B", "default_KID", "", "void"), 46);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "equals", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "java.lang.Object", Config.OS, "", "boolean"), 73);
        ajc$tjp_7 = bVar.a("method-execution", bVar.d("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 87);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrackEncryptionBox(String str) {
        super(str);
    }

    public int getDefaultAlgorithmId() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.defaultAlgorithmId;
    }

    public void setDefaultAlgorithmId(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.Og(i)));
        this.defaultAlgorithmId = i;
    }

    public int getDefaultIvSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.defaultIvSize;
    }

    public void setDefaultIvSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.Og(i)));
        this.defaultIvSize = i;
    }

    public String getDefault_KID() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        ByteBuffer wrap = ByteBuffer.wrap(this.default_KID);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new UUID(wrap.getLong(), wrap.getLong()).toString();
    }

    public void setDefault_KID(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, bArr));
        this.default_KID = bArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.defaultAlgorithmId = IsoTypeReader.readUInt24(byteBuffer);
        this.defaultIvSize = IsoTypeReader.readUInt8(byteBuffer);
        this.default_KID = new byte[16];
        byteBuffer.get(this.default_KID);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt24(byteBuffer, this.defaultAlgorithmId);
        IsoTypeWriter.writeUInt8(byteBuffer, this.defaultIvSize);
        byteBuffer.put(this.default_KID);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 24L;
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractTrackEncryptionBox abstractTrackEncryptionBox = (AbstractTrackEncryptionBox) obj;
        return this.defaultAlgorithmId == abstractTrackEncryptionBox.defaultAlgorithmId && this.defaultIvSize == abstractTrackEncryptionBox.defaultIvSize && Arrays.equals(this.default_KID, abstractTrackEncryptionBox.default_KID);
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return (this.default_KID != null ? Arrays.hashCode(this.default_KID) : 0) + (((this.defaultAlgorithmId * 31) + this.defaultIvSize) * 31);
    }
}
