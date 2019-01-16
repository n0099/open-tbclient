package com.coremedia.iso.boxes.fragment;

import com.baidu.location.BDLocation;
import com.baidu.searchbox.ng.ai.apps.animator.AiAppsLoadingAnimator;
import com.baidu.tbadk.BaseActivity;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public class TrackFragmentHeaderBox extends AbstractFullBox {
    public static final String TYPE = "tfhd";
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_9 = null;
    private long baseDataOffset;
    private boolean defaultBaseIsMoof;
    private long defaultSampleDuration;
    private SampleFlags defaultSampleFlags;
    private long defaultSampleSize;
    private boolean durationIsEmpty;
    private long sampleDescriptionIndex;
    private long trackId;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "hasBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 126);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "hasSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 130);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 166);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "isDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 170);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "isDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 174);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "trackId", "", "void"), 178);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "setBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), 182);
        ajc$tjp_15 = bVar.a("method-execution", bVar.b("1", "setSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 191);
        ajc$tjp_16 = bVar.a("method-execution", bVar.b("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), 200);
        ajc$tjp_17 = bVar.a("method-execution", bVar.b("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), 205);
        ajc$tjp_18 = bVar.a("method-execution", bVar.b("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 210);
        ajc$tjp_19 = bVar.a("method-execution", bVar.b("1", "setDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), 215);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "hasDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 134);
        ajc$tjp_20 = bVar.a("method-execution", bVar.b("1", "setDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), AiAppsLoadingAnimator.ICON_ANIMATOR_DURATION);
        ajc$tjp_21 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 226);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "hasDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 138);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "hasDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 142);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 146);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "getSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 154);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 158);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), BDLocation.TypeServerDecryptError);
    }

    public TrackFragmentHeaderBox() {
        super(TYPE);
        this.baseDataOffset = -1L;
        this.defaultSampleDuration = -1L;
        this.defaultSampleSize = -1L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int flags = getFlags();
        long j = (flags & 1) == 1 ? 8 + 8 : 8L;
        if ((flags & 2) == 2) {
            j += 4;
        }
        if ((flags & 8) == 8) {
            j += 4;
        }
        if ((flags & 16) == 16) {
            j += 4;
        }
        if ((flags & 32) == 32) {
            return j + 4;
        }
        return j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
        if ((getFlags() & 1) == 1) {
            IsoTypeWriter.writeUInt64(byteBuffer, getBaseDataOffset());
        }
        if ((getFlags() & 2) == 2) {
            IsoTypeWriter.writeUInt32(byteBuffer, getSampleDescriptionIndex());
        }
        if ((getFlags() & 8) == 8) {
            IsoTypeWriter.writeUInt32(byteBuffer, getDefaultSampleDuration());
        }
        if ((getFlags() & 16) == 16) {
            IsoTypeWriter.writeUInt32(byteBuffer, getDefaultSampleSize());
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags.getContent(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.readUInt32(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.baseDataOffset = IsoTypeReader.readUInt64(byteBuffer);
        }
        if ((getFlags() & 2) == 2) {
            this.sampleDescriptionIndex = IsoTypeReader.readUInt32(byteBuffer);
        }
        if ((getFlags() & 8) == 8) {
            this.defaultSampleDuration = IsoTypeReader.readUInt32(byteBuffer);
        }
        if ((getFlags() & 16) == 16) {
            this.defaultSampleSize = IsoTypeReader.readUInt32(byteBuffer);
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags = new SampleFlags(byteBuffer);
        }
        if ((getFlags() & 65536) == 65536) {
            this.durationIsEmpty = true;
        }
        if ((getFlags() & 131072) == 131072) {
            this.defaultBaseIsMoof = true;
        }
    }

    public boolean hasBaseDataOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return (getFlags() & 1) != 0;
    }

    public boolean hasSampleDescriptionIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return (getFlags() & 2) != 0;
    }

    public boolean hasDefaultSampleDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return (getFlags() & 8) != 0;
    }

    public boolean hasDefaultSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return (getFlags() & 16) != 0;
    }

    public boolean hasDefaultSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return (getFlags() & 32) != 0;
    }

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return this.trackId;
    }

    public long getBaseDataOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.baseDataOffset;
    }

    public long getSampleDescriptionIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return this.sampleDescriptionIndex;
    }

    public long getDefaultSampleDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.defaultSampleDuration;
    }

    public long getDefaultSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this));
        return this.defaultSampleSize;
    }

    public SampleFlags getDefaultSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this));
        return this.defaultSampleFlags;
    }

    public boolean isDurationIsEmpty() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this));
        return this.durationIsEmpty;
    }

    public boolean isDefaultBaseIsMoof() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this));
        return this.defaultBaseIsMoof;
    }

    public void setTrackId(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, org.aspectj.a.a.a.dE(j)));
        this.trackId = j;
    }

    public void setBaseDataOffset(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this, org.aspectj.a.a.a.dE(j)));
        if (j == -1) {
            setFlags(getFlags() & 2147483646);
        } else {
            setFlags(getFlags() | 1);
        }
        this.baseDataOffset = j;
    }

    public void setSampleDescriptionIndex(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this, org.aspectj.a.a.a.dE(j)));
        if (j == -1) {
            setFlags(getFlags() & 2147483645);
        } else {
            setFlags(getFlags() | 2);
        }
        this.sampleDescriptionIndex = j;
    }

    public void setDefaultSampleDuration(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this, org.aspectj.a.a.a.dE(j)));
        setFlags(getFlags() | 8);
        this.defaultSampleDuration = j;
    }

    public void setDefaultSampleSize(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_17, this, this, org.aspectj.a.a.a.dE(j)));
        setFlags(getFlags() | 16);
        this.defaultSampleSize = j;
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_18, this, this, sampleFlags));
        setFlags(getFlags() | 32);
        this.defaultSampleFlags = sampleFlags;
    }

    public void setDurationIsEmpty(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_19, this, this, org.aspectj.a.a.a.pl(z)));
        setFlags(getFlags() | 65536);
        this.durationIsEmpty = z;
    }

    public void setDefaultBaseIsMoof(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_20, this, this, org.aspectj.a.a.a.pl(z)));
        setFlags(getFlags() | 131072);
        this.defaultBaseIsMoof = z;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_21, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("TrackFragmentHeaderBox");
        sb.append("{trackId=").append(this.trackId);
        sb.append(", baseDataOffset=").append(this.baseDataOffset);
        sb.append(", sampleDescriptionIndex=").append(this.sampleDescriptionIndex);
        sb.append(", defaultSampleDuration=").append(this.defaultSampleDuration);
        sb.append(", defaultSampleSize=").append(this.defaultSampleSize);
        sb.append(", defaultSampleFlags=").append(this.defaultSampleFlags);
        sb.append(", durationIsEmpty=").append(this.durationIsEmpty);
        sb.append(", defaultBaseIsMoof=").append(this.defaultBaseIsMoof);
        sb.append('}');
        return sb.toString();
    }
}
