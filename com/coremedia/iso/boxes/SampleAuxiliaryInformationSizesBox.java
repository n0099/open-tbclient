package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class SampleAuxiliaryInformationSizesBox extends AbstractFullBox {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "saiz";
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_10 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_8 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_9 = null;
    public String auxInfoType;
    public String auxInfoTypeParameter;
    public int defaultSampleInfoSize;
    public int sampleCount;
    public List<Short> sampleInfoSizes;

    static {
        ajc$preClinit();
    }

    public SampleAuxiliaryInformationSizesBox() {
        super(TYPE);
        this.sampleInfoSizes = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleAuxiliaryInformationSizesBox.java", SampleAuxiliaryInformationSizesBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 98);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 102);
        ajc$tjp_10 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 106);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 110);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getDefaultSampleInfoSize", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 114);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setDefaultSampleInfoSize", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 118);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getSampleInfoSizes", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "java.util.List"), Constants.METHOD_IM_FRIEND_GROUP_QUERY);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "setSampleInfoSizes", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "java.util.List", "sampleInfoSizes", "", "void"), 127);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "getSampleCount", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER);
        ajc$tjp_9 = bVar.g("method-execution", bVar.f("1", "setSampleCount", "com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 135);
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
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.auxInfoType;
    }

    public String getAuxInfoTypeParameter() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.auxInfoTypeParameter;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
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
    public long getContentSize() {
        return ((getFlags() & 1) == 1 ? 12 : 4) + 5 + (this.defaultSampleInfoSize == 0 ? this.sampleInfoSizes.size() : 0);
    }

    public int getDefaultSampleInfoSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.defaultSampleInfoSize;
    }

    public int getSampleCount() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.sampleCount;
    }

    public List<Short> getSampleInfoSizes() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.sampleInfoSizes;
    }

    public void setAuxInfoType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.auxInfoType = str;
    }

    public void setAuxInfoTypeParameter(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.auxInfoTypeParameter = str;
    }

    public void setDefaultSampleInfoSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, g.a.b.a.a.e(i)));
        this.defaultSampleInfoSize = i;
    }

    public void setSampleCount(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, g.a.b.a.a.e(i)));
        this.sampleCount = i;
    }

    public void setSampleInfoSizes(List<Short> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, list));
        this.sampleInfoSizes = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return "SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=" + this.defaultSampleInfoSize + ", sampleCount=" + this.sampleCount + ", auxInfoType='" + this.auxInfoType + "', auxInfoTypeParameter='" + this.auxInfoTypeParameter + "'}";
    }
}
