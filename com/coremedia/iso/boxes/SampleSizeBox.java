package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes20.dex */
public class SampleSizeBox extends AbstractFullBox {
    public static final String TYPE = "stsz";
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_6 = null;
    int sampleCount;
    private long sampleSize;
    private long[] sampleSizes;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleSizeBox.java", SampleSizeBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", "index", "", "long"), 59);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", FieldUtil.TYPE_STRING), 119);
    }

    public SampleSizeBox() {
        super(TYPE);
        this.sampleSizes = new long[0];
    }

    public long getSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.sampleSize;
    }

    public void setSampleSize(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.gL(j)));
        this.sampleSize = j;
    }

    public long getSampleSizeAtIndex(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, org.aspectj.a.a.a.LD(i)));
        return this.sampleSize > 0 ? this.sampleSize : this.sampleSizes[i];
    }

    public long getSampleCount() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.sampleSize > 0 ? this.sampleCount : this.sampleSizes.length;
    }

    public long[] getSampleSizes() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.sampleSizes;
    }

    public void setSampleSizes(long[] jArr) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, jArr));
        this.sampleSizes = jArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (this.sampleSize == 0 ? this.sampleSizes.length * 4 : 0) + 12;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.sampleSize = IsoTypeReader.readUInt32(byteBuffer);
        this.sampleCount = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        if (this.sampleSize == 0) {
            this.sampleSizes = new long[this.sampleCount];
            for (int i = 0; i < this.sampleCount; i++) {
                this.sampleSizes[i] = IsoTypeReader.readUInt32(byteBuffer);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleSize);
        if (this.sampleSize == 0) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.sampleSizes.length);
            for (long j : this.sampleSizes) {
                IsoTypeWriter.writeUInt32(byteBuffer, j);
            }
            return;
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleCount);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return "SampleSizeBox[sampleSize=" + getSampleSize() + ";sampleCount=" + getSampleCount() + "]";
    }
}
