package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class TrackReferenceTypeBox extends AbstractBox {
    public static final String TYPE1 = "hint";
    public static final String TYPE2 = "cdsc";
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0205a ajc$tjp_1 = null;
    private long[] trackIds;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackReferenceTypeBox.java", TrackReferenceTypeBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getTrackIds", "com.coremedia.iso.boxes.TrackReferenceTypeBox", "", "", "", "[J"), 40);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.TrackReferenceTypeBox", "", "", "", "java.lang.String"), 65);
    }

    public TrackReferenceTypeBox(String str) {
        super(str);
    }

    public long[] getTrackIds() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.trackIds;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining() / 4;
        this.trackIds = new long[remaining];
        for (int i = 0; i < remaining; i++) {
            this.trackIds[i] = IsoTypeReader.readUInt32(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        for (long j : this.trackIds) {
            IsoTypeWriter.writeUInt32(byteBuffer, j);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.trackIds.length * 4;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("TrackReferenceTypeBox[type=").append(getType());
        for (int i = 0; i < this.trackIds.length; i++) {
            sb.append(";trackId");
            sb.append(i);
            sb.append("=");
            sb.append(this.trackIds[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
