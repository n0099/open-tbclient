package com.coremedia.iso.boxes;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Matrix;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes11.dex */
public class MovieHeaderBox extends AbstractFullBox {
    public static final String TYPE = "mvhd";
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_22 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_23 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_24 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_25 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_26 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_27 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_28 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_9 = null;
    private Date creationTime;
    private int currentTime;
    private long duration;
    private Matrix matrix;
    private Date modificationTime;
    private long nextTrackId;
    private int posterTime;
    private int previewDuration;
    private int previewTime;
    private double rate;
    private int selectionDuration;
    private int selectionTime;
    private long timescale;
    private float volume;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("MovieHeaderBox.java", MovieHeaderBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", FieldUtil.TYPE_DATE), 63);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", FieldUtil.TYPE_DATE), 67);
        ajc$tjp_10 = bVar.a("method-execution", bVar.d("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", FieldUtil.TYPE_DATE, "modificationTime", "", "void"), 203);
        ajc$tjp_11 = bVar.a("method-execution", bVar.d("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 211);
        ajc$tjp_12 = bVar.a("method-execution", bVar.d("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 215);
        ajc$tjp_13 = bVar.a("method-execution", bVar.d("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        ajc$tjp_14 = bVar.a("method-execution", bVar.d("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), Constants.METHOD_MEDIA_NOTIFY);
        ajc$tjp_15 = bVar.a("method-execution", bVar.d("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), RtcConstants.METHOD_IM_RTC_MSG);
        ajc$tjp_16 = bVar.a("method-execution", bVar.d("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 234);
        ajc$tjp_17 = bVar.a("method-execution", bVar.d("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 238);
        ajc$tjp_18 = bVar.a("method-execution", bVar.d("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), BaseActivity.DIALOG_LOADING);
        ajc$tjp_19 = bVar.a("method-execution", bVar.d("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 246);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 71);
        ajc$tjp_20 = bVar.a("method-execution", bVar.d("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 250);
        ajc$tjp_21 = bVar.a("method-execution", bVar.d("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), GDiffPatcher.COPY_INT_INT);
        ajc$tjp_22 = bVar.a("method-execution", bVar.d("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 258);
        ajc$tjp_23 = bVar.a("method-execution", bVar.d("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 262);
        ajc$tjp_24 = bVar.a("method-execution", bVar.d("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        ajc$tjp_25 = bVar.a("method-execution", bVar.d("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 270);
        ajc$tjp_26 = bVar.a("method-execution", bVar.d("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        ajc$tjp_27 = bVar.a("method-execution", bVar.d("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        ajc$tjp_28 = bVar.a("method-execution", bVar.d("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 282);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 75);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 83);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        ajc$tjp_7 = bVar.a("method-execution", bVar.d("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 91);
        ajc$tjp_8 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", FieldUtil.TYPE_STRING), 139);
        ajc$tjp_9 = bVar.a("method-execution", bVar.d("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", FieldUtil.TYPE_DATE, "creationTime", "", "void"), DownloadConstants.STATUS_WAITING_FOR_NETWORK);
    }

    public MovieHeaderBox() {
        super(TYPE);
        this.rate = 1.0d;
        this.volume = 1.0f;
        this.matrix = Matrix.ROTATE_0;
    }

    public Date getCreationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.creationTime;
    }

    public Date getModificationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    public long getTimescale() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.timescale;
    }

    public long getDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.duration;
    }

    public double getRate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.rate;
    }

    public float getVolume() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return this.volume;
    }

    public Matrix getMatrix() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.matrix;
    }

    public long getNextTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return this.nextTrackId;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (getVersion() == 1 ? 4 + 28 : 4 + 16) + 80;
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

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("MovieHeaderBox[");
        sb.append("creationTime=").append(getCreationTime());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("modificationTime=").append(getModificationTime());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("timescale=").append(getTimescale());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("duration=").append(getDuration());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("rate=").append(getRate());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("volume=").append(getVolume());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("matrix=").append(this.matrix);
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("nextTrackId=").append(getNextTrackId());
        sb.append("]");
        return sb.toString();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
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

    public void setCreationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, date));
        this.creationTime = date;
        if (DateHelper.convert(date) >= AccountConstants.TYPE_MODIFY_EXT_FIELDS) {
            setVersion(1);
        }
    }

    public void setModificationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this, date));
        this.modificationTime = date;
        if (DateHelper.convert(date) >= AccountConstants.TYPE_MODIFY_EXT_FIELDS) {
            setVersion(1);
        }
    }

    public void setTimescale(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this, org.aspectj.a.a.a.hW(j)));
        this.timescale = j;
    }

    public void setDuration(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this, org.aspectj.a.a.a.hW(j)));
        this.duration = j;
        if (j >= AccountConstants.TYPE_MODIFY_EXT_FIELDS) {
            setVersion(1);
        }
    }

    public void setRate(double d) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, org.aspectj.a.a.a.P(d)));
        this.rate = d;
    }

    public void setVolume(float f) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this, org.aspectj.a.a.a.bx(f)));
        this.volume = f;
    }

    public void setMatrix(Matrix matrix) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this, matrix));
        this.matrix = matrix;
    }

    public void setNextTrackId(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this, org.aspectj.a.a.a.hW(j)));
        this.nextTrackId = j;
    }

    public int getPreviewTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_17, this, this));
        return this.previewTime;
    }

    public void setPreviewTime(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_18, this, this, org.aspectj.a.a.a.Ri(i)));
        this.previewTime = i;
    }

    public int getPreviewDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_19, this, this));
        return this.previewDuration;
    }

    public void setPreviewDuration(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_20, this, this, org.aspectj.a.a.a.Ri(i)));
        this.previewDuration = i;
    }

    public int getPosterTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_21, this, this));
        return this.posterTime;
    }

    public void setPosterTime(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_22, this, this, org.aspectj.a.a.a.Ri(i)));
        this.posterTime = i;
    }

    public int getSelectionTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_23, this, this));
        return this.selectionTime;
    }

    public void setSelectionTime(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_24, this, this, org.aspectj.a.a.a.Ri(i)));
        this.selectionTime = i;
    }

    public int getSelectionDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_25, this, this));
        return this.selectionDuration;
    }

    public void setSelectionDuration(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_26, this, this, org.aspectj.a.a.a.Ri(i)));
        this.selectionDuration = i;
    }

    public int getCurrentTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_27, this, this));
        return this.currentTime;
    }

    public void setCurrentTime(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_28, this, this, org.aspectj.a.a.a.Ri(i)));
        this.currentTime = i;
    }
}
