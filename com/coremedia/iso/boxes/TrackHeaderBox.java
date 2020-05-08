package com.coremedia.iso.boxes;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Matrix;
import java.nio.ByteBuffer;
import java.util.Date;
import org.apache.http.HttpStatus;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class TrackHeaderBox extends AbstractFullBox {
    public static final String TYPE = "tkhd";
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_22 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_23 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_24 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_25 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_26 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_27 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_28 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_29 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0826a ajc$tjp_9 = null;
    private int alternateGroup;
    private Date creationTime;
    private long duration;
    private double height;
    private int layer;
    private Matrix matrix;
    private Date modificationTime;
    private long trackId;
    private float volume;
    private double width;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackHeaderBox.java", TrackHeaderBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", FieldUtil.TYPE_DATE), 60);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", FieldUtil.TYPE_DATE), 64);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 138);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", FieldUtil.TYPE_STRING), Opcodes.IF_ACMPNE);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", FieldUtil.TYPE_DATE, "creationTime", "", "void"), 192);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", FieldUtil.TYPE_DATE, "modificationTime", "", "void"), Opcodes.IFNONNULL);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), HttpStatus.SC_MULTI_STATUS);
        ajc$tjp_15 = bVar.a("method-execution", bVar.b("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), 211);
        ajc$tjp_16 = bVar.a("method-execution", bVar.b("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 218);
        ajc$tjp_17 = bVar.a("method-execution", bVar.b("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 222);
        ajc$tjp_18 = bVar.a("method-execution", bVar.b("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), Constants.METHOD_MEDIA_NOTIFY);
        ajc$tjp_19 = bVar.a("method-execution", bVar.b("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 230);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 68);
        ajc$tjp_20 = bVar.a("method-execution", bVar.b("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 234);
        ajc$tjp_21 = bVar.a("method-execution", bVar.b("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 238);
        ajc$tjp_22 = bVar.a("method-execution", bVar.b("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 243);
        ajc$tjp_23 = bVar.a("method-execution", bVar.b("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 247);
        ajc$tjp_24 = bVar.a("method-execution", bVar.b("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 251);
        ajc$tjp_25 = bVar.a("method-execution", bVar.b("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 255);
        ajc$tjp_26 = bVar.a("method-execution", bVar.b("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 259);
        ajc$tjp_27 = bVar.a("method-execution", bVar.b("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 267);
        ajc$tjp_28 = bVar.a("method-execution", bVar.b("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 275);
        ajc$tjp_29 = bVar.a("method-execution", bVar.b("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 283);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 72);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 76);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 80);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 84);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 88);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 92);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 96);
    }

    public TrackHeaderBox() {
        super(TYPE);
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

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.trackId;
    }

    public long getDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.duration;
    }

    public int getLayer() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.layer;
    }

    public int getAlternateGroup() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return this.alternateGroup;
    }

    public float getVolume() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.volume;
    }

    public Matrix getMatrix() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return this.matrix;
    }

    public double getWidth() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.width;
    }

    public double getHeight() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this));
        return this.height;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (getVersion() == 1 ? 4 + 32 : 4 + 20) + 60;
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

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this, byteBuffer));
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

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("TrackHeaderBox[");
        sb.append("creationTime=").append(getCreationTime());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("modificationTime=").append(getModificationTime());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("trackId=").append(getTrackId());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("duration=").append(getDuration());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("layer=").append(getLayer());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("alternateGroup=").append(getAlternateGroup());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("volume=").append(getVolume());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("matrix=").append(this.matrix);
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("width=").append(getWidth());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("height=").append(getHeight());
        sb.append("]");
        return sb.toString();
    }

    public void setCreationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this, date));
        this.creationTime = date;
        if (DateHelper.convert(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setModificationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, date));
        this.modificationTime = date;
        if (DateHelper.convert(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setTrackId(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this, org.aspectj.a.a.a.gs(j)));
        this.trackId = j;
    }

    public void setDuration(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this, org.aspectj.a.a.a.gs(j)));
        this.duration = j;
        if (j >= 4294967296L) {
            setFlags(1);
        }
    }

    public void setLayer(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this, org.aspectj.a.a.a.Jp(i)));
        this.layer = i;
    }

    public void setAlternateGroup(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_17, this, this, org.aspectj.a.a.a.Jp(i)));
        this.alternateGroup = i;
    }

    public void setVolume(float f) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_18, this, this, org.aspectj.a.a.a.aQ(f)));
        this.volume = f;
    }

    public void setMatrix(Matrix matrix) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_19, this, this, matrix));
        this.matrix = matrix;
    }

    public void setWidth(double d) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_20, this, this, org.aspectj.a.a.a.D(d)));
        this.width = d;
    }

    public void setHeight(double d) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_21, this, this, org.aspectj.a.a.a.D(d)));
        this.height = d;
    }

    public boolean isEnabled() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_22, this, this));
        return (getFlags() & 1) > 0;
    }

    public boolean isInMovie() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_23, this, this));
        return (getFlags() & 2) > 0;
    }

    public boolean isInPreview() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_24, this, this));
        return (getFlags() & 4) > 0;
    }

    public boolean isInPoster() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_25, this, this));
        return (getFlags() & 8) > 0;
    }

    public void setEnabled(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_26, this, this, org.aspectj.a.a.a.wG(z)));
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & (-2));
        }
    }

    public void setInMovie(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_27, this, this, org.aspectj.a.a.a.wG(z)));
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & (-3));
        }
    }

    public void setInPreview(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_28, this, this, org.aspectj.a.a.a.wG(z)));
        if (z) {
            setFlags(getFlags() | 4);
        } else {
            setFlags(getFlags() & (-5));
        }
    }

    public void setInPoster(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_29, this, this, org.aspectj.a.a.a.wG(z)));
        if (z) {
            setFlags(getFlags() | 8);
        } else {
            setFlags(getFlags() & (-9));
        }
    }
}
