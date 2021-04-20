package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class Utf8AppleDataBox extends AppleDataBox {
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public String value;

    static {
        ajc$preClinit();
    }

    public Utf8AppleDataBox(String str) {
        super(str, 1);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("Utf8AppleDataBox.java", Utf8AppleDataBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "", "", "", "java.lang.String"), 21);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "java.lang.String", "value", "", "void"), 25);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public int getDataLength() {
        return this.value.getBytes(Charset.forName("UTF-8")).length;
    }

    public String getValue() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.value;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void parseData(ByteBuffer byteBuffer) {
        this.value = IsoTypeReader.readString(byteBuffer, byteBuffer.remaining());
    }

    public void setValue(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.value = str;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    @DoNotParseDetail
    public byte[] writeData() {
        return Utf8.convert(this.value);
    }
}
