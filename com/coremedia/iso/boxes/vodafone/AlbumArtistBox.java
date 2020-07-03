package com.coremedia.iso.boxes.vodafone;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes7.dex */
public class AlbumArtistBox extends AbstractFullBox {
    public static final String TYPE = "albr";
    private static final /* synthetic */ a.InterfaceC0908a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0908a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0908a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0908a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0908a ajc$tjp_4 = null;
    private String albumArtist;
    private String language;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AlbumArtistBox.java", AlbumArtistBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", FieldUtil.TYPE_STRING), 42);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", FieldUtil.TYPE_STRING), 46);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "setLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", FieldUtil.TYPE_STRING, IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "void"), 50);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", FieldUtil.TYPE_STRING, "albumArtist", "", "void"), 54);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", FieldUtil.TYPE_STRING), 76);
    }

    public AlbumArtistBox() {
        super(TYPE);
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.language;
    }

    public String getAlbumArtist() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.albumArtist;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, str));
        this.language = str;
    }

    public void setAlbumArtist(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        this.albumArtist = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.albumArtist) + 6 + 1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.albumArtist = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.albumArtist));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return "AlbumArtistBox[language=" + getLanguage() + ";albumArtist=" + getAlbumArtist() + "]";
    }
}
