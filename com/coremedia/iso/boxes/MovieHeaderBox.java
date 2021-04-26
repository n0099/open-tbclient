package com.coremedia.iso.boxes;

import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.facebook.imageutils.JfifUtil;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Matrix;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.Date;
/* loaded from: classes6.dex */
public class MovieHeaderBox extends AbstractFullBox {
    public static final String TYPE = "mvhd";
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
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_8 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_9 = null;
    public Date creationTime;
    public int currentTime;
    public long duration;
    public Matrix matrix;
    public Date modificationTime;
    public long nextTrackId;
    public int posterTime;
    public int previewDuration;
    public int previewTime;
    public double rate;
    public int selectionDuration;
    public int selectionTime;
    public long timescale;
    public float volume;

    static {
        ajc$preClinit();
    }

    public MovieHeaderBox() {
        super(TYPE);
        this.rate = 1.0d;
        this.volume = 1.0f;
        this.matrix = Matrix.ROTATE_0;
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("MovieHeaderBox.java", MovieHeaderBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 63);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 67);
        ajc$tjp_10 = bVar.g("method-execution", bVar.f("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        ajc$tjp_11 = bVar.g("method-execution", bVar.f("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 211);
        ajc$tjp_12 = bVar.g("method-execution", bVar.f("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), JfifUtil.MARKER_RST7);
        ajc$tjp_13 = bVar.g("method-execution", bVar.f("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        ajc$tjp_14 = bVar.g("method-execution", bVar.f("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), Constants.METHOD_MEDIA_NOTIFY);
        ajc$tjp_15 = bVar.g("method-execution", bVar.f("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), RtcConstants.METHOD_IM_RTC_MSG);
        ajc$tjp_16 = bVar.g("method-execution", bVar.f("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 234);
        ajc$tjp_17 = bVar.g("method-execution", bVar.f("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 238);
        ajc$tjp_18 = bVar.g("method-execution", bVar.f("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), BaseActivity.DIALOG_LOADING);
        ajc$tjp_19 = bVar.g("method-execution", bVar.f("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 246);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 71);
        ajc$tjp_20 = bVar.g("method-execution", bVar.f("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 250);
        ajc$tjp_21 = bVar.g("method-execution", bVar.f("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 254);
        ajc$tjp_22 = bVar.g("method-execution", bVar.f("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 258);
        ajc$tjp_23 = bVar.g("method-execution", bVar.f("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), PlayerEvent.PLAY_LOADING_END);
        ajc$tjp_24 = bVar.g("method-execution", bVar.f("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        ajc$tjp_25 = bVar.g("method-execution", bVar.f("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 270);
        ajc$tjp_26 = bVar.g("method-execution", bVar.f("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        ajc$tjp_27 = bVar.g("method-execution", bVar.f("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        ajc$tjp_28 = bVar.g("method-execution", bVar.f("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 282);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 75);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 83);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 91);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 139);
        ajc$tjp_9 = bVar.g("method-execution", bVar.f("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), DownloadConstants.STATUS_WAITING_FOR_NETWORK);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.creationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
            this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
            this.timescale = IsoTypeReader.readUInt32(byteBuffer);
            this.duration = IsoTypeReader.readUInt64(byteBuffer);
        } else {
            this.creationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
            this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
            this.timescale = IsoTypeReader.readUInt32(byteBuffer);
            this.duration = IsoTypeReader.readUInt32(byteBuffer);
        }
        this.rate = IsoTypeReader.readFixedPoint1616(byteBuffer);
        this.volume = IsoTypeReader.readFixedPoint88(byteBuffer);
        IsoTypeReader.readUInt16(byteBuffer);
        IsoTypeReader.readUInt32(byteBuffer);
        IsoTypeReader.readUInt32(byteBuffer);
        this.matrix = Matrix.fromByteBuffer(byteBuffer);
        this.previewTime = byteBuffer.getInt();
        this.previewDuration = byteBuffer.getInt();
        this.posterTime = byteBuffer.getInt();
        this.selectionTime = byteBuffer.getInt();
        this.selectionDuration = byteBuffer.getInt();
        this.currentTime = byteBuffer.getInt();
        this.nextTrackId = IsoTypeReader.readUInt32(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.creationTime));
            IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.modificationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
            IsoTypeWriter.writeUInt64(byteBuffer, this.duration);
        } else {
            IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.creationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.modificationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
            IsoTypeWriter.writeUInt32(byteBuffer, this.duration);
        }
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.rate);
        IsoTypeWriter.writeFixedPoint88(byteBuffer, this.volume);
        IsoTypeWriter.writeUInt16(byteBuffer, 0);
        IsoTypeWriter.writeUInt32(byteBuffer, 0L);
        IsoTypeWriter.writeUInt32(byteBuffer, 0L);
        this.matrix.getContent(byteBuffer);
        byteBuffer.putInt(this.previewTime);
        byteBuffer.putInt(this.previewDuration);
        byteBuffer.putInt(this.posterTime);
        byteBuffer.putInt(this.selectionTime);
        byteBuffer.putInt(this.selectionDuration);
        byteBuffer.putInt(this.currentTime);
        IsoTypeWriter.writeUInt32(byteBuffer, this.nextTrackId);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return (getVersion() == 1 ? 32L : 20L) + 80;
    }

    public Date getCreationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.creationTime;
    }

    public int getCurrentTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_27, this, this));
        return this.currentTime;
    }

    public long getDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.duration;
    }

    public Matrix getMatrix() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.matrix;
    }

    public Date getModificationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    public long getNextTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.nextTrackId;
    }

    public int getPosterTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_21, this, this));
        return this.posterTime;
    }

    public int getPreviewDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_19, this, this));
        return this.previewDuration;
    }

    public int getPreviewTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_17, this, this));
        return this.previewTime;
    }

    public double getRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.rate;
    }

    public int getSelectionDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_25, this, this));
        return this.selectionDuration;
    }

    public int getSelectionTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_23, this, this));
        return this.selectionTime;
    }

    public long getTimescale() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.timescale;
    }

    public float getVolume() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.volume;
    }

    public void setCreationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, date));
        this.creationTime = date;
        if (DateHelper.convert(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setCurrentTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_28, this, this, g.a.b.a.a.e(i2)));
        this.currentTime = i2;
    }

    public void setDuration(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, g.a.b.a.a.f(j)));
        this.duration = j;
        if (j >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setMatrix(Matrix matrix) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, matrix));
        this.matrix = matrix;
    }

    public void setModificationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, date));
        this.modificationTime = date;
        if (DateHelper.convert(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setNextTrackId(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_16, this, this, g.a.b.a.a.f(j)));
        this.nextTrackId = j;
    }

    public void setPosterTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_22, this, this, g.a.b.a.a.e(i2)));
        this.posterTime = i2;
    }

    public void setPreviewDuration(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_20, this, this, g.a.b.a.a.e(i2)));
        this.previewDuration = i2;
    }

    public void setPreviewTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_18, this, this, g.a.b.a.a.e(i2)));
        this.previewTime = i2;
    }

    public void setRate(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, g.a.b.a.a.c(d2)));
        this.rate = d2;
    }

    public void setSelectionDuration(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_26, this, this, g.a.b.a.a.e(i2)));
        this.selectionDuration = i2;
    }

    public void setSelectionTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_24, this, this, g.a.b.a.a.e(i2)));
        this.selectionTime = i2;
    }

    public void setTimescale(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, g.a.b.a.a.f(j)));
        this.timescale = j;
    }

    public void setVolume(float f2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_14, this, this, g.a.b.a.a.d(f2)));
        this.volume = f2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return "MovieHeaderBox[creationTime=" + getCreationTime() + ";modificationTime=" + getModificationTime() + ";timescale=" + getTimescale() + ";duration=" + getDuration() + ";rate=" + getRate() + ";volume=" + getVolume() + ";matrix=" + this.matrix + ";nextTrackId=" + getNextTrackId() + "]";
    }
}
