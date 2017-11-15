package com.coremedia.iso.boxes;

import com.baidu.sapi2.SapiSafeFacade;
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
/* loaded from: classes2.dex */
public class SampleAuxiliaryInformationOffsetsBox extends AbstractFullBox {
    public static final String TYPE = "saio";
    private static final /* synthetic */ a.InterfaceC0169a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0169a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0169a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0169a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0169a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0169a ajc$tjp_5 = null;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private List<Long> offsets;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleAuxiliaryInformationOffsetsBox.java", SampleAuxiliaryInformationOffsetsBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), SapiSafeFacade.SAPIWEBVIEW_REG);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 113);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 117);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 121);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getOffsets", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.util.List"), 125);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setOffsets", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "java.util.List", "offsets", "", "void"), 129);
    }

    public SampleAuxiliaryInformationOffsetsBox() {
        super(TYPE);
        this.offsets = new LinkedList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return ((getFlags() & 1) == 1 ? 8 : 0) + (getVersion() == 0 ? this.offsets.size() * 4 : this.offsets.size() * 8) + 8;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoType));
            byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoTypeParameter));
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.offsets.size());
        for (Long l : this.offsets) {
            if (getVersion() == 0) {
                IsoTypeWriter.writeUInt32(byteBuffer, l.longValue());
            } else {
                IsoTypeWriter.writeUInt64(byteBuffer, l.longValue());
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.auxInfoType = IsoTypeReader.read4cc(byteBuffer);
            this.auxInfoTypeParameter = IsoTypeReader.read4cc(byteBuffer);
        }
        int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.offsets.clear();
        for (int i = 0; i < l2i; i++) {
            if (getVersion() == 0) {
                this.offsets.add(Long.valueOf(IsoTypeReader.readUInt32(byteBuffer)));
            } else {
                this.offsets.add(Long.valueOf(IsoTypeReader.readUInt64(byteBuffer)));
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

    public List<Long> getOffsets() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.offsets;
    }

    public void setOffsets(List<Long> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, list));
        this.offsets = list;
    }
}
