package com.coremedia.iso.boxes;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class SyncSampleBox extends AbstractFullBox {
    public static final String TYPE = "stss";
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_2 = null;
    public long[] sampleNumber;

    static {
        ajc$preClinit();
    }

    public SyncSampleBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SyncSampleBox.java", SyncSampleBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.sampleNumber = new long[l2i];
        for (int i2 = 0; i2 < l2i; i2++) {
            this.sampleNumber[i2] = IsoTypeReader.readUInt32(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleNumber.length);
        for (long j : this.sampleNumber) {
            IsoTypeWriter.writeUInt32(byteBuffer, j);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return (this.sampleNumber.length * 4) + 8;
    }

    public long[] getSampleNumber() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.sampleNumber;
    }

    public void setSampleNumber(long[] jArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, jArr));
        this.sampleNumber = jArr;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return "SyncSampleBox[entryCount=" + this.sampleNumber.length + PreferencesUtil.RIGHT_MOUNT;
    }
}
