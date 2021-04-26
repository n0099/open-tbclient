package com.coremedia.iso.boxes;

import androidx.core.app.NotificationCompat;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AuthorBox extends AbstractFullBox {
    public static final String TYPE = "auth";
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_4 = null;
    public String author;
    public String language;

    static {
        ajc$preClinit();
    }

    public AuthorBox() {
        super("auth");
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AuthorBox.java", AuthorBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getLanguage", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 51);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getAuthor", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 60);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "setLanguage", "com.coremedia.iso.boxes.AuthorBox", "java.lang.String", "language", "", "void"), 64);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setAuthor", "com.coremedia.iso.boxes.AuthorBox", "java.lang.String", NotificationCompat.CarExtender.KEY_AUTHOR, "", "void"), 68);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 92);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.author = IsoTypeReader.readString(byteBuffer);
    }

    public String getAuthor() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.author;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.author));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.author) + 7;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.language;
    }

    public void setAuthor(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.author = str;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, str));
        this.language = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return "AuthorBox[language=" + getLanguage() + ";author=" + getAuthor() + "]";
    }
}
