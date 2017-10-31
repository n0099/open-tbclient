package com.coremedia.iso.boxes;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.sapi2.SapiSafeFacade;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class AlbumBox extends AbstractFullBox {
    public static final String TYPE = "albm";
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0166a ajc$tjp_6 = null;
    private String albumTitle;
    private String language;
    private int trackNumber;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AlbumBox.java", AlbumBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getLanguage", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 51);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getAlbumTitle", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 55);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getTrackNumber", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "int"), 59);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setLanguage", "com.coremedia.iso.boxes.AlbumBox", "java.lang.String", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "void"), 63);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "setAlbumTitle", "com.coremedia.iso.boxes.AlbumBox", "java.lang.String", "albumTitle", "", "void"), 67);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setTrackNumber", "com.coremedia.iso.boxes.AlbumBox", "int", "trackNumber", "", "void"), 71);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), SapiSafeFacade.SAPIWEBVIEW_FINISH);
    }

    public AlbumBox() {
        super(TYPE);
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.language;
    }

    public String getAlbumTitle() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.albumTitle;
    }

    public int getTrackNumber() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.trackNumber;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        this.language = str;
    }

    public void setAlbumTitle(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, str));
        this.albumTitle = str;
    }

    public void setTrackNumber(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.xj(i)));
        this.trackNumber = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (this.trackNumber == -1 ? 0 : 1) + Utf8.utf8StringLengthInBytes(this.albumTitle) + 6 + 1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.albumTitle = IsoTypeReader.readString(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.trackNumber = IsoTypeReader.readUInt8(byteBuffer);
        } else {
            this.trackNumber = -1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.albumTitle));
        byteBuffer.put((byte) 0);
        if (this.trackNumber != -1) {
            IsoTypeWriter.writeUInt8(byteBuffer, this.trackNumber);
        }
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("AlbumBox[language=").append(getLanguage()).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("albumTitle=").append(getAlbumTitle());
        if (this.trackNumber >= 0) {
            sb.append(";trackNumber=").append(getTrackNumber());
        }
        sb.append("]");
        return sb.toString();
    }
}
