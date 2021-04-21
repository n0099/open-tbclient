package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class BitRateBox extends AbstractBox {
    public static final String TYPE = "btrt";
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_5 = null;
    public long avgBitrate;
    public long bufferSizeDb;
    public long maxBitrate;

    static {
        ajc$preClinit();
    }

    public BitRateBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("BitRateBox.java", BitRateBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getBufferSizeDb", "com.coremedia.iso.boxes.BitRateBox", "", "", "", "long"), 74);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setBufferSizeDb", "com.coremedia.iso.boxes.BitRateBox", "long", "bufferSizeDb", "", "void"), 82);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getMaxBitrate", "com.coremedia.iso.boxes.BitRateBox", "", "", "", "long"), 90);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setMaxBitrate", "com.coremedia.iso.boxes.BitRateBox", "long", "maxBitrate", "", "void"), 98);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getAvgBitrate", "com.coremedia.iso.boxes.BitRateBox", "", "", "", "long"), 106);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setAvgBitrate", "com.coremedia.iso.boxes.BitRateBox", "long", "avgBitrate", "", "void"), 114);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.bufferSizeDb = IsoTypeReader.readUInt32(byteBuffer);
        this.maxBitrate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitrate = IsoTypeReader.readUInt32(byteBuffer);
    }

    public long getAvgBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.avgBitrate;
    }

    public long getBufferSizeDb() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.bufferSizeDb;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, this.bufferSizeDb);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitrate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitrate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 12L;
    }

    public long getMaxBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.maxBitrate;
    }

    public void setAvgBitrate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, g.a.b.a.a.f(j)));
        this.avgBitrate = j;
    }

    public void setBufferSizeDb(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.f(j)));
        this.bufferSizeDb = j;
    }

    public void setMaxBitrate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, g.a.b.a.a.f(j)));
        this.maxBitrate = j;
    }
}
