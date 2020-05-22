package com.coremedia.iso.boxes.fragment;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class TrackExtendsBox extends AbstractFullBox {
    public static final String TYPE = "trex";
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0888a ajc$tjp_9 = null;
    private long defaultSampleDescriptionIndex;
    private long defaultSampleDuration;
    private SampleFlags defaultSampleFlags;
    private long defaultSampleSize;
    private long trackId;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackExtendsBox.java", TrackExtendsBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 72);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 76);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 112);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 80);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 84);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 88);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleFlagsStr", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", FieldUtil.TYPE_STRING), 92);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "trackId", "", "void"), 96);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleDescriptionIndex", "", "void"), 100);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleDuration", "", "void"), 104);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleSize", "", "void"), 108);
    }

    public TrackExtendsBox() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 24L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
        IsoTypeWriter.writeUInt32(byteBuffer, this.defaultSampleDescriptionIndex);
        IsoTypeWriter.writeUInt32(byteBuffer, this.defaultSampleDuration);
        IsoTypeWriter.writeUInt32(byteBuffer, this.defaultSampleSize);
        this.defaultSampleFlags.getContent(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleDescriptionIndex = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleDuration = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleSize = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleFlags = new SampleFlags(byteBuffer);
    }

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.trackId;
    }

    public long getDefaultSampleDescriptionIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.defaultSampleDescriptionIndex;
    }

    public long getDefaultSampleDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.defaultSampleDuration;
    }

    public long getDefaultSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.defaultSampleSize;
    }

    public SampleFlags getDefaultSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.defaultSampleFlags;
    }

    public String getDefaultSampleFlagsStr() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return this.defaultSampleFlags.toString();
    }

    public void setTrackId(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this, org.aspectj.a.a.a.gt(j)));
        this.trackId = j;
    }

    public void setDefaultSampleDescriptionIndex(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.gt(j)));
        this.defaultSampleDescriptionIndex = j;
    }

    public void setDefaultSampleDuration(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this, org.aspectj.a.a.a.gt(j)));
        this.defaultSampleDuration = j;
    }

    public void setDefaultSampleSize(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, org.aspectj.a.a.a.gt(j)));
        this.defaultSampleSize = j;
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this, sampleFlags));
        this.defaultSampleFlags = sampleFlags;
    }
}
