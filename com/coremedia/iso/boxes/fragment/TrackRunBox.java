package com.coremedia.iso.boxes.fragment;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class TrackRunBox extends AbstractFullBox {
    public static final String TYPE = "trun";
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_9 = null;
    private int dataOffset;
    private List<Entry> entries;
    private SampleFlags firstSampleFlags;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackRunBox.java", TrackRunBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.util.List"), 57);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "int", "dataOffset", "", "void"), 120);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "setDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", NotifyType.VIBRATE, "", "void"), 271);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "setSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", NotifyType.VIBRATE, "", "void"), 279);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "setSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", NotifyType.VIBRATE, "", "void"), 287);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "setSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", NotifyType.VIBRATE, "", "void"), 296);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "setSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", NotifyType.VIBRATE, "", "void"), HttpStatus.SC_NOT_MODIFIED);
        ajc$tjp_15 = bVar.a("method-execution", bVar.b("1", "getDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "int"), 313);
        ajc$tjp_16 = bVar.a("method-execution", bVar.b("1", "getFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 317);
        ajc$tjp_17 = bVar.a("method-execution", bVar.b("1", "setFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "firstSampleFlags", "", "void"), 321);
        ajc$tjp_18 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.lang.String"), 331);
        ajc$tjp_19 = bVar.a("method-execution", bVar.b("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "java.util.List", "entries", "", "void"), 346);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getSampleCompositionTimeOffsets", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "[J"), 129);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getSampleCount", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "long"), 242);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "isDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 246);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "isFirstSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "isSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 255);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "isSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 259);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "isSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 263);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "isSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 267);
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.entries;
    }

    /* loaded from: classes2.dex */
    public static class Entry {
        private long sampleCompositionTimeOffset;
        private long sampleDuration;
        private SampleFlags sampleFlags;
        private long sampleSize;

        public Entry() {
        }

        public Entry(long j, long j2, SampleFlags sampleFlags, int i) {
            this.sampleDuration = j;
            this.sampleSize = j2;
            this.sampleFlags = sampleFlags;
            this.sampleCompositionTimeOffset = i;
        }

        public long getSampleDuration() {
            return this.sampleDuration;
        }

        public long getSampleSize() {
            return this.sampleSize;
        }

        public SampleFlags getSampleFlags() {
            return this.sampleFlags;
        }

        public long getSampleCompositionTimeOffset() {
            return this.sampleCompositionTimeOffset;
        }

        public void setSampleDuration(long j) {
            this.sampleDuration = j;
        }

        public void setSampleSize(long j) {
            this.sampleSize = j;
        }

        public void setSampleFlags(SampleFlags sampleFlags) {
            this.sampleFlags = sampleFlags;
        }

        public void setSampleCompositionTimeOffset(int i) {
            this.sampleCompositionTimeOffset = i;
        }

        public String toString() {
            return "Entry{sampleDuration=" + this.sampleDuration + ", sampleSize=" + this.sampleSize + ", sampleFlags=" + this.sampleFlags + ", sampleCompositionTimeOffset=" + this.sampleCompositionTimeOffset + '}';
        }
    }

    public void setDataOffset(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.zt(i)));
        if (i == -1) {
            setFlags(getFlags() & 16777214);
        } else {
            setFlags(getFlags() | 1);
        }
        this.dataOffset = i;
    }

    public long[] getSampleCompositionTimeOffsets() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        if (isSampleCompositionTimeOffsetPresent()) {
            long[] jArr = new long[this.entries.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jArr.length) {
                    return jArr;
                }
                jArr[i2] = this.entries.get(i2).getSampleCompositionTimeOffset();
                i = i2 + 1;
            }
        } else {
            return null;
        }
    }

    public TrackRunBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long j = 8;
        int flags = getFlags();
        if ((flags & 1) == 1) {
            j = 8 + 4;
        }
        long j2 = (flags & 4) == 4 ? j + 4 : j;
        long j3 = 0;
        if ((flags & 256) == 256) {
            j3 = 0 + 4;
        }
        if ((flags & 512) == 512) {
            j3 += 4;
        }
        if ((flags & 1024) == 1024) {
            j3 += 4;
        }
        if ((flags & 2048) == 2048) {
            j3 += 4;
        }
        return (j3 * this.entries.size()) + j2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        int flags = getFlags();
        if ((flags & 1) == 1) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.dataOffset);
        }
        if ((flags & 4) == 4) {
            this.firstSampleFlags.getContent(byteBuffer);
        }
        for (Entry entry : this.entries) {
            if ((flags & 256) == 256) {
                IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleDuration);
            }
            if ((flags & 512) == 512) {
                IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleSize);
            }
            if ((flags & 1024) == 1024) {
                entry.sampleFlags.getContent(byteBuffer);
            }
            if ((flags & 2048) == 2048) {
                if (getVersion() == 0) {
                    IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleCompositionTimeOffset);
                } else {
                    byteBuffer.putInt((int) entry.sampleCompositionTimeOffset);
                }
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.dataOffset = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        } else {
            this.dataOffset = -1;
        }
        if ((getFlags() & 4) == 4) {
            this.firstSampleFlags = new SampleFlags(byteBuffer);
        }
        for (int i = 0; i < readUInt32; i++) {
            Entry entry = new Entry();
            if ((getFlags() & 256) == 256) {
                entry.sampleDuration = IsoTypeReader.readUInt32(byteBuffer);
            }
            if ((getFlags() & 512) == 512) {
                entry.sampleSize = IsoTypeReader.readUInt32(byteBuffer);
            }
            if ((getFlags() & 1024) == 1024) {
                entry.sampleFlags = new SampleFlags(byteBuffer);
            }
            if ((getFlags() & 2048) == 2048) {
                if (getVersion() == 0) {
                    entry.sampleCompositionTimeOffset = IsoTypeReader.readUInt32(byteBuffer);
                } else {
                    entry.sampleCompositionTimeOffset = byteBuffer.getInt();
                }
            }
            this.entries.add(entry);
        }
    }

    public long getSampleCount() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.entries.size();
    }

    public boolean isDataOffsetPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return (getFlags() & 1) == 1;
    }

    public boolean isFirstSampleFlagsPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return (getFlags() & 4) == 4;
    }

    public boolean isSampleSizePresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return (getFlags() & 512) == 512;
    }

    public boolean isSampleDurationPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return (getFlags() & 256) == 256;
    }

    public boolean isSampleFlagsPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return (getFlags() & 1024) == 1024;
    }

    public boolean isSampleCompositionTimeOffsetPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this));
        return (getFlags() & 2048) == 2048;
    }

    public void setDataOffsetPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this, org.aspectj.a.a.a.ok(z)));
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & 16777214);
        }
    }

    public void setSampleSizePresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this, org.aspectj.a.a.a.ok(z)));
        if (z) {
            setFlags(getFlags() | 512);
        } else {
            setFlags(getFlags() & 16776703);
        }
    }

    public void setSampleDurationPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this, org.aspectj.a.a.a.ok(z)));
        if (z) {
            setFlags(getFlags() | 256);
        } else {
            setFlags(getFlags() & 16776959);
        }
    }

    public void setSampleFlagsPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, org.aspectj.a.a.a.ok(z)));
        if (z) {
            setFlags(getFlags() | 1024);
        } else {
            setFlags(getFlags() & 16776191);
        }
    }

    public void setSampleCompositionTimeOffsetPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this, org.aspectj.a.a.a.ok(z)));
        if (z) {
            setFlags(getFlags() | 2048);
        } else {
            setFlags(getFlags() & 16775167);
        }
    }

    public int getDataOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this));
        return this.dataOffset;
    }

    public SampleFlags getFirstSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this));
        return this.firstSampleFlags;
    }

    public void setFirstSampleFlags(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_17, this, this, sampleFlags));
        if (sampleFlags == null) {
            setFlags(getFlags() & 16777211);
        } else {
            setFlags(getFlags() | 4);
        }
        this.firstSampleFlags = sampleFlags;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_18, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("TrackRunBox");
        sb.append("{sampleCount=").append(this.entries.size());
        sb.append(", dataOffset=").append(this.dataOffset);
        sb.append(", dataOffsetPresent=").append(isDataOffsetPresent());
        sb.append(", sampleSizePresent=").append(isSampleSizePresent());
        sb.append(", sampleDurationPresent=").append(isSampleDurationPresent());
        sb.append(", sampleFlagsPresentPresent=").append(isSampleFlagsPresent());
        sb.append(", sampleCompositionTimeOffsetPresent=").append(isSampleCompositionTimeOffsetPresent());
        sb.append(", firstSampleFlags=").append(this.firstSampleFlags);
        sb.append('}');
        return sb.toString();
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_19, this, this, list));
        this.entries = list;
    }
}
