package com.googlecode.mp4parser.boxes.piff;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class TfrfBox extends AbstractFullBox {
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_2 = null;
    public List<Entry> entries;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TfrfBox.java", TfrfBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getFragmentCount", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "long"), 91);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "getEntries", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.util.List"), 95);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "toString", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", FieldUtil.TYPE_STRING), 100);
    }

    public TfrfBox() {
        super("uuid");
        this.entries = new ArrayList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getUserType() {
        return new byte[]{-44, Byte.MIN_VALUE, 126, -14, -54, 57, 70, -107, -114, 84, 38, -53, -98, 70, -89, -97};
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return ((getVersion() == 1 ? 16 : 8) * this.entries.size()) + 5;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt8(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            if (getVersion() == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, entry.fragmentAbsoluteTime);
                IsoTypeWriter.writeUInt64(byteBuffer, entry.fragmentAbsoluteDuration);
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, entry.fragmentAbsoluteTime);
                IsoTypeWriter.writeUInt32(byteBuffer, entry.fragmentAbsoluteDuration);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        for (int i = 0; i < readUInt8; i++) {
            Entry entry = new Entry();
            if (getVersion() == 1) {
                entry.fragmentAbsoluteTime = IsoTypeReader.readUInt64(byteBuffer);
                entry.fragmentAbsoluteDuration = IsoTypeReader.readUInt64(byteBuffer);
            } else {
                entry.fragmentAbsoluteTime = IsoTypeReader.readUInt32(byteBuffer);
                entry.fragmentAbsoluteDuration = IsoTypeReader.readUInt32(byteBuffer);
            }
            this.entries.add(entry);
        }
    }

    public long getFragmentCount() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.entries.size();
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.entries;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("TfrfBox");
        sb.append("{entries=").append(this.entries);
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes7.dex */
    public class Entry {
        long fragmentAbsoluteDuration;
        long fragmentAbsoluteTime;

        public Entry() {
        }

        public long getFragmentAbsoluteTime() {
            return this.fragmentAbsoluteTime;
        }

        public long getFragmentAbsoluteDuration() {
            return this.fragmentAbsoluteDuration;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Entry");
            sb.append("{fragmentAbsoluteTime=").append(this.fragmentAbsoluteTime);
            sb.append(", fragmentAbsoluteDuration=").append(this.fragmentAbsoluteDuration);
            sb.append('}');
            return sb.toString();
        }
    }
}
