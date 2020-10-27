package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes11.dex */
public class SampleAuxiliaryInformationSizesBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TYPE = "saiz";
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC1069a ajc$tjp_9 = null;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private int defaultSampleInfoSize;
    private int sampleCount;
    private List<Short> sampleInfoSizes;

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleAuxiliaryInformationSizesBox.java", SampleAuxiliaryInformationSizesBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", FieldUtil.TYPE_STRING), 98);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", FieldUtil.TYPE_STRING, "auxInfoType", "", "void"), 102);
        ajc$tjp_10 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", FieldUtil.TYPE_STRING), 140);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", FieldUtil.TYPE_STRING), 106);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", FieldUtil.TYPE_STRING, "auxInfoTypeParameter", "", "void"), 110);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "getDefaultSampleInfoSize", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 114);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "setDefaultSampleInfoSize", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 118);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "getSampleInfoSizes", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "java.util.List"), Constants.METHOD_IM_FRIEND_GROUP_QUERY);
        ajc$tjp_7 = bVar.a("method-execution", bVar.d("1", "setSampleInfoSizes", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "java.util.List", "sampleInfoSizes", "", "void"), 127);
        ajc$tjp_8 = bVar.a("method-execution", bVar.d("1", "getSampleCount", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER);
        ajc$tjp_9 = bVar.a("method-execution", bVar.d("1", "setSampleCount", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 135);
    }

    static {
        ajc$preClinit();
        $assertionsDisabled = !SampleAuxiliaryInformationSizesBox.class.desiredAssertionStatus();
    }

    public SampleAuxiliaryInformationSizesBox() {
        super(TYPE);
        this.sampleInfoSizes = new LinkedList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int i = 4;
        if ((getFlags() & 1) == 1) {
            i = 12;
        }
        return (this.defaultSampleInfoSize == 0 ? this.sampleInfoSizes.size() : 0) + i + 5;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoType));
            byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoTypeParameter));
        }
        IsoTypeWriter.writeUInt8(byteBuffer, this.defaultSampleInfoSize);
        if (this.defaultSampleInfoSize == 0) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.sampleInfoSizes.size());
            for (Short sh : this.sampleInfoSizes) {
                IsoTypeWriter.writeUInt8(byteBuffer, sh.shortValue());
            }
            return;
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleCount);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.auxInfoType = IsoTypeReader.read4cc(byteBuffer);
            this.auxInfoTypeParameter = IsoTypeReader.read4cc(byteBuffer);
        }
        this.defaultSampleInfoSize = (short) IsoTypeReader.readUInt8(byteBuffer);
        this.sampleCount = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.sampleInfoSizes.clear();
        if (this.defaultSampleInfoSize == 0) {
            for (int i = 0; i < this.sampleCount; i++) {
                this.sampleInfoSizes.add(Short.valueOf((short) IsoTypeReader.readUInt8(byteBuffer)));
            }
        }
    }

    public String getAuxInfoType() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.auxInfoType;
    }

    public void setAuxInfoType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.auxInfoType = str;
    }

    public String getAuxInfoTypeParameter() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.auxInfoTypeParameter;
    }

    public void setAuxInfoTypeParameter(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        this.auxInfoTypeParameter = str;
    }

    public int getDefaultSampleInfoSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.defaultSampleInfoSize;
    }

    public void setDefaultSampleInfoSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.Ri(i)));
        if (!$assertionsDisabled && i > 255) {
            throw new AssertionError();
        }
        this.defaultSampleInfoSize = i;
    }

    public List<Short> getSampleInfoSizes() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.sampleInfoSizes;
    }

    public void setSampleInfoSizes(List<Short> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, list));
        this.sampleInfoSizes = list;
    }

    public int getSampleCount() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.sampleCount;
    }

    public void setSampleCount(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, org.aspectj.a.a.a.Ri(i)));
        this.sampleCount = i;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this));
        return "SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=" + this.defaultSampleInfoSize + ", sampleCount=" + this.sampleCount + ", auxInfoType='" + this.auxInfoType + "', auxInfoTypeParameter='" + this.auxInfoTypeParameter + "'}";
    }
}
