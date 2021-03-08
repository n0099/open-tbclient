package com.googlecode.mp4parser.boxes.apple;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public abstract class Utf8AppleDataBox extends AppleDataBox {
    private static final /* synthetic */ a.InterfaceC1292a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1292a ajc$tjp_1 = null;
    String value;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("Utf8AppleDataBox.java", Utf8AppleDataBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "", "", "", FieldUtil.TYPE_STRING), 21);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", FieldUtil.TYPE_STRING, "value", "", "void"), 25);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Utf8AppleDataBox(String str) {
        super(str, 1);
    }

    public String getValue() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.value;
    }

    public void setValue(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.value = str;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    @DoNotParseDetail
    public byte[] writeData() {
        return Utf8.convert(this.value);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return this.value.getBytes(Charset.forName("UTF-8")).length;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        this.value = IsoTypeReader.readString(byteBuffer, byteBuffer.remaining());
    }
}
