package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class RecordingYearBox extends AbstractFullBox {
    public static final String TYPE = "yrrc";
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public int recordingYear;

    static {
        ajc$preClinit();
    }

    public RecordingYearBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("RecordingYearBox.java", RecordingYearBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getRecordingYear", "com.coremedia.iso.boxes.RecordingYearBox", "", "", "", "int"), 42);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setRecordingYear", "com.coremedia.iso.boxes.RecordingYearBox", "int", "recordingYear", "", "void"), 46);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.recordingYear = IsoTypeReader.readUInt16(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt16(byteBuffer, this.recordingYear);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 6L;
    }

    public int getRecordingYear() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.recordingYear;
    }

    public void setRecordingYear(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.e(i)));
        this.recordingYear = i;
    }
}
