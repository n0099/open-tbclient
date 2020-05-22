package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class HintMediaHeaderBox extends AbstractMediaHeaderBox {
    public static final String TYPE = "hmhd";
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_4 = null;
    private long avgBitrate;
    private int avgPduSize;
    private long maxBitrate;
    private int maxPduSize;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("HintMediaHeaderBox.java", HintMediaHeaderBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getMaxPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 42);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getAvgPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 46);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getMaxBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 50);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getAvgBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 54);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", FieldUtil.TYPE_STRING), 84);
    }

    public HintMediaHeaderBox() {
        super(TYPE);
    }

    public int getMaxPduSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.maxPduSize;
    }

    public int getAvgPduSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.avgPduSize;
    }

    public long getMaxBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.maxBitrate;
    }

    public long getAvgBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.avgBitrate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 20L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxPduSize = IsoTypeReader.readUInt16(byteBuffer);
        this.avgPduSize = IsoTypeReader.readUInt16(byteBuffer);
        this.maxBitrate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitrate = IsoTypeReader.readUInt32(byteBuffer);
        IsoTypeReader.readUInt32(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt16(byteBuffer, this.maxPduSize);
        IsoTypeWriter.writeUInt16(byteBuffer, this.avgPduSize);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitrate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitrate);
        IsoTypeWriter.writeUInt32(byteBuffer, 0L);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return "HintMediaHeaderBox{maxPduSize=" + this.maxPduSize + ", avgPduSize=" + this.avgPduSize + ", maxBitrate=" + this.maxBitrate + ", avgBitrate=" + this.avgBitrate + '}';
    }
}
