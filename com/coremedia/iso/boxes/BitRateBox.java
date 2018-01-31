package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public final class BitRateBox extends AbstractBox {
    public static final String TYPE = "btrt";
    private static final /* synthetic */ a.InterfaceC0206a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0206a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0206a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0206a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0206a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0206a ajc$tjp_5 = null;
    private long avgBitrate;
    private long bufferSizeDb;
    private long maxBitrate;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("BitRateBox.java", BitRateBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getBufferSizeDb", "com.coremedia.iso.boxes.BitRateBox", "", "", "", "long"), 74);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setBufferSizeDb", "com.coremedia.iso.boxes.BitRateBox", "long", "bufferSizeDb", "", "void"), 82);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getMaxBitrate", "com.coremedia.iso.boxes.BitRateBox", "", "", "", "long"), 90);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setMaxBitrate", "com.coremedia.iso.boxes.BitRateBox", "long", "maxBitrate", "", "void"), 98);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getAvgBitrate", "com.coremedia.iso.boxes.BitRateBox", "", "", "", "long"), 106);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setAvgBitrate", "com.coremedia.iso.boxes.BitRateBox", "long", "avgBitrate", "", "void"), 114);
    }

    public BitRateBox() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.bufferSizeDb = IsoTypeReader.readUInt32(byteBuffer);
        this.maxBitrate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitrate = IsoTypeReader.readUInt32(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, this.bufferSizeDb);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitrate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitrate);
    }

    public long getBufferSizeDb() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.bufferSizeDb;
    }

    public void setBufferSizeDb(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.dY(j)));
        this.bufferSizeDb = j;
    }

    public long getMaxBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.maxBitrate;
    }

    public void setMaxBitrate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.dY(j)));
        this.maxBitrate = j;
    }

    public long getAvgBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.avgBitrate;
    }

    public void setAvgBitrate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.dY(j)));
        this.avgBitrate = j;
    }
}
