package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes8.dex */
public class VideoMediaHeaderBox extends AbstractMediaHeaderBox {
    public static final String TYPE = "vmhd";
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0982a ajc$tjp_4 = null;
    private int graphicsmode;
    private int[] opcolor;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("VideoMediaHeaderBox.java", VideoMediaHeaderBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", FieldUtil.TYPE_STRING), 71);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    public VideoMediaHeaderBox() {
        super(TYPE);
        this.graphicsmode = 0;
        this.opcolor = new int[3];
        setFlags(1);
    }

    public int getGraphicsmode() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.graphicsmode;
    }

    public int[] getOpcolor() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.opcolor;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.graphicsmode = IsoTypeReader.readUInt16(byteBuffer);
        this.opcolor = new int[3];
        for (int i = 0; i < 3; i++) {
            this.opcolor[i] = IsoTypeReader.readUInt16(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt16(byteBuffer, this.graphicsmode);
        for (int i : this.opcolor) {
            IsoTypeWriter.writeUInt16(byteBuffer, i);
        }
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return "VideoMediaHeaderBox[graphicsmode=" + getGraphicsmode() + ";opcolor0=" + getOpcolor()[0] + ";opcolor1=" + getOpcolor()[1] + ";opcolor2=" + getOpcolor()[2] + "]";
    }

    public void setOpcolor(int[] iArr) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, iArr));
        this.opcolor = iArr;
    }

    public void setGraphicsmode(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, org.aspectj.a.a.a.Og(i)));
        this.graphicsmode = i;
    }
}
