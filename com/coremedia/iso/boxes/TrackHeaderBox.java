package com.coremedia.iso.boxes;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Matrix;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.Date;
/* loaded from: classes6.dex */
public class TrackHeaderBox extends AbstractFullBox {
    public static final String TYPE = "tkhd";
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_10 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_11 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_12 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_13 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_14 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_15 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_16 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_17 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_18 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_19 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_20 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_21 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_22 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_23 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_24 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_25 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_26 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_27 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_28 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_29 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_8 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_9 = null;
    public int alternateGroup;
    public Date creationTime;
    public long duration;
    public double height;
    public int layer;
    public Matrix matrix;
    public Date modificationTime;
    public long trackId;
    public float volume;
    public double width;

    static {
        ajc$preClinit();
    }

    public TrackHeaderBox() {
        super(TYPE);
        this.matrix = Matrix.ROTATE_0;
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackHeaderBox.java", TrackHeaderBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 60);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 64);
        ajc$tjp_10 = bVar.g("method-execution", bVar.f("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 138);
        ajc$tjp_11 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 166);
        ajc$tjp_12 = bVar.g("method-execution", bVar.f("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 192);
        ajc$tjp_13 = bVar.g("method-execution", bVar.f("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), Opcodes.IFNONNULL);
        ajc$tjp_14 = bVar.g("method-execution", bVar.f("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 207);
        ajc$tjp_15 = bVar.g("method-execution", bVar.f("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), 211);
        ajc$tjp_16 = bVar.g("method-execution", bVar.f("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 218);
        ajc$tjp_17 = bVar.g("method-execution", bVar.f("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 222);
        ajc$tjp_18 = bVar.g("method-execution", bVar.f("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), Constants.METHOD_MEDIA_NOTIFY);
        ajc$tjp_19 = bVar.g("method-execution", bVar.f("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), RtcConstants.METHOD_IM_RTC_MSG);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 68);
        ajc$tjp_20 = bVar.g("method-execution", bVar.f("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 234);
        ajc$tjp_21 = bVar.g("method-execution", bVar.f("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 238);
        ajc$tjp_22 = bVar.g("method-execution", bVar.f("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK);
        ajc$tjp_23 = bVar.g("method-execution", bVar.f("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), GDiffPatcher.DATA_USHORT);
        ajc$tjp_24 = bVar.g("method-execution", bVar.f("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), GDiffPatcher.COPY_USHORT_INT);
        ajc$tjp_25 = bVar.g("method-execution", bVar.f("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 255);
        ajc$tjp_26 = bVar.g("method-execution", bVar.f("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", SapiOptions.KEY_CACHE_ENABLED, "", "void"), 259);
        ajc$tjp_27 = bVar.g("method-execution", bVar.f("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 267);
        ajc$tjp_28 = bVar.g("method-execution", bVar.f("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 275);
        ajc$tjp_29 = bVar.g("method-execution", bVar.f("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 283);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 72);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 76);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 80);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 84);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 88);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 92);
        ajc$tjp_9 = bVar.g("method-execution", bVar.f("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 96);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.creationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
            this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
            this.trackId = IsoTypeReader.readUInt32(byteBuffer);
            IsoTypeReader.readUInt32(byteBuffer);
            this.duration = IsoTypeReader.readUInt64(byteBuffer);
        } else {
            this.creationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
            this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
            this.trackId = IsoTypeReader.readUInt32(byteBuffer);
            IsoTypeReader.readUInt32(byteBuffer);
            this.duration = IsoTypeReader.readUInt32(byteBuffer);
        }
        IsoTypeReader.readUInt32(byteBuffer);
        IsoTypeReader.readUInt32(byteBuffer);
        this.layer = IsoTypeReader.readUInt16(byteBuffer);
        this.alternateGroup = IsoTypeReader.readUInt16(byteBuffer);
        this.volume = IsoTypeReader.readFixedPoint88(byteBuffer);
        IsoTypeReader.readUInt16(byteBuffer);
        this.matrix = Matrix.fromByteBuffer(byteBuffer);
        this.width = IsoTypeReader.readFixedPoint1616(byteBuffer);
        this.height = IsoTypeReader.readFixedPoint1616(byteBuffer);
    }

    public int getAlternateGroup() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.alternateGroup;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, byteBuffer));
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.creationTime));
            IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.modificationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
            IsoTypeWriter.writeUInt32(byteBuffer, 0L);
            IsoTypeWriter.writeUInt64(byteBuffer, this.duration);
        } else {
            IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.creationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.modificationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
            IsoTypeWriter.writeUInt32(byteBuffer, 0L);
            IsoTypeWriter.writeUInt32(byteBuffer, this.duration);
        }
        IsoTypeWriter.writeUInt32(byteBuffer, 0L);
        IsoTypeWriter.writeUInt32(byteBuffer, 0L);
        IsoTypeWriter.writeUInt16(byteBuffer, this.layer);
        IsoTypeWriter.writeUInt16(byteBuffer, this.alternateGroup);
        IsoTypeWriter.writeFixedPoint88(byteBuffer, this.volume);
        IsoTypeWriter.writeUInt16(byteBuffer, 0);
        this.matrix.getContent(byteBuffer);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.width);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.height);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return (getVersion() == 1 ? 36L : 24L) + 60;
    }

    public Date getCreationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.creationTime;
    }

    public long getDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.duration;
    }

    public double getHeight() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_9, this, this));
        return this.height;
    }

    public int getLayer() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.layer;
    }

    public Matrix getMatrix() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.matrix;
    }

    public Date getModificationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.trackId;
    }

    public float getVolume() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.volume;
    }

    public double getWidth() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.width;
    }

    public boolean isEnabled() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_22, this, this));
        return (getFlags() & 1) > 0;
    }

    public boolean isInMovie() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_23, this, this));
        return (getFlags() & 2) > 0;
    }

    public boolean isInPoster() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_25, this, this));
        return (getFlags() & 8) > 0;
    }

    public boolean isInPreview() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_24, this, this));
        return (getFlags() & 4) > 0;
    }

    public void setAlternateGroup(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, g.a.b.a.a.e(i2)));
        this.alternateGroup = i2;
    }

    public void setCreationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, date));
        this.creationTime = date;
        if (DateHelper.convert(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setDuration(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, g.a.b.a.a.f(j)));
        this.duration = j;
        if (j >= 4294967296L) {
            setFlags(1);
        }
    }

    public void setEnabled(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_26, this, this, g.a.b.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & (-2));
        }
    }

    public void setHeight(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_21, this, this, g.a.b.a.a.c(d2)));
        this.height = d2;
    }

    public void setInMovie(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_27, this, this, g.a.b.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & (-3));
        }
    }

    public void setInPoster(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_29, this, this, g.a.b.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 8);
        } else {
            setFlags(getFlags() & (-9));
        }
    }

    public void setInPreview(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_28, this, this, g.a.b.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 4);
        } else {
            setFlags(getFlags() & (-5));
        }
    }

    public void setLayer(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_16, this, this, g.a.b.a.a.e(i2)));
        this.layer = i2;
    }

    public void setMatrix(Matrix matrix) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, matrix));
        this.matrix = matrix;
    }

    public void setModificationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, date));
        this.modificationTime = date;
        if (DateHelper.convert(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setTrackId(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_14, this, this, g.a.b.a.a.f(j)));
        this.trackId = j;
    }

    public void setVolume(float f2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_18, this, this, g.a.b.a.a.d(f2)));
        this.volume = f2;
    }

    public void setWidth(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_20, this, this, g.a.b.a.a.c(d2)));
        this.width = d2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_11, this, this));
        return "TrackHeaderBox[creationTime=" + getCreationTime() + ";modificationTime=" + getModificationTime() + ";trackId=" + getTrackId() + ";duration=" + getDuration() + ";layer=" + getLayer() + ";alternateGroup=" + getAlternateGroup() + ";volume=" + getVolume() + ";matrix=" + this.matrix + ";" + BigImageLoaderProc.NCDN_PER + getWidth() + ";height=" + getHeight() + "]";
    }
}
