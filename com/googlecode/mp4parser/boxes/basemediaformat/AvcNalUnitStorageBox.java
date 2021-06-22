package com.googlecode.mp4parser.boxes.basemediaformat;

import com.coremedia.iso.boxes.h264.AvcConfigurationBox;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes6.dex */
public class AvcNalUnitStorageBox extends AbstractBox {
    public static final String TYPE = "avcn";
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_7 = null;
    public AvcConfigurationBox.AVCDecoderConfigurationRecord avcDecoderConfigurationRecord;

    static {
        ajc$preClinit();
    }

    public AvcNalUnitStorageBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AvcNalUnitStorageBox.java", AvcNalUnitStorageBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getAvcDecoderConfigurationRecord", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "com.coremedia.iso.boxes.h264.AvcConfigurationBox$AVCDecoderConfigurationRecord"), 43);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getLengthSizeMinusOne", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "int"), 48);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getSPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 52);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getPPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 56);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getSequenceParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 60);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getSequenceParameterSetExtsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 64);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getPictureParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 68);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "toString", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.lang.String"), 88);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AvcConfigurationBox.AVCDecoderConfigurationRecord(byteBuffer);
    }

    public AvcConfigurationBox.AVCDecoderConfigurationRecord getAvcDecoderConfigurationRecord() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.avcDecoderConfigurationRecord;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord.getContent(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return this.avcDecoderConfigurationRecord.getContentSize();
    }

    public int getLengthSizeMinusOne() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public String[] getPPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.avcDecoderConfigurationRecord.getPPS();
    }

    public List<String> getPictureParameterSetsAsStrings() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.avcDecoderConfigurationRecord.getPictureParameterSetsAsStrings();
    }

    public String[] getSPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.avcDecoderConfigurationRecord.getSPS();
    }

    public List<String> getSequenceParameterSetExtsAsStrings() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.avcDecoderConfigurationRecord.getSequenceParameterSetExtsAsStrings();
    }

    public List<String> getSequenceParameterSetsAsStrings() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.avcDecoderConfigurationRecord.getSequenceParameterSetsAsStrings();
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return "AvcNalUnitStorageBox{SPS=" + this.avcDecoderConfigurationRecord.getSequenceParameterSetsAsStrings() + ",PPS=" + this.avcDecoderConfigurationRecord.getPictureParameterSetsAsStrings() + ",lengthSize=" + (this.avcDecoderConfigurationRecord.lengthSizeMinusOne + 1) + '}';
    }

    public AvcNalUnitStorageBox(AvcConfigurationBox avcConfigurationBox) {
        super(TYPE);
        this.avcDecoderConfigurationRecord = avcConfigurationBox.getavcDecoderConfigurationRecord();
    }
}
