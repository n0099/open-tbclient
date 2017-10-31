package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class SoundMediaHeaderBox extends AbstractMediaHeaderBox {
    public static final String TYPE = "smhd";
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_1 = null;
    private float balance;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SoundMediaHeaderBox.java", SoundMediaHeaderBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getBalance", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "float"), 36);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    public SoundMediaHeaderBox() {
        super(TYPE);
    }

    public float getBalance() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.balance;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 8L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.balance = IsoTypeReader.readFixedPoint88(byteBuffer);
        IsoTypeReader.readUInt16(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeFixedPoint88(byteBuffer, this.balance);
        IsoTypeWriter.writeUInt16(byteBuffer, 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return "SoundMediaHeaderBox[balance=" + getBalance() + "]";
    }
}
