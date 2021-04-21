package com.googlecode.mp4parser.boxes.piff;

import androidx.exifinterface.media.ExifInterface;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public class TfrfBox extends AbstractFullBox {
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_2 = null;
    public List<Entry> entries;

    /* loaded from: classes6.dex */
    public class Entry {
        public long fragmentAbsoluteDuration;
        public long fragmentAbsoluteTime;

        public Entry() {
        }

        public long getFragmentAbsoluteDuration() {
            return this.fragmentAbsoluteDuration;
        }

        public long getFragmentAbsoluteTime() {
            return this.fragmentAbsoluteTime;
        }

        public String toString() {
            return "Entry{fragmentAbsoluteTime=" + this.fragmentAbsoluteTime + ", fragmentAbsoluteDuration=" + this.fragmentAbsoluteDuration + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public TfrfBox() {
        super("uuid");
        this.entries = new ArrayList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TfrfBox.java", TfrfBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getFragmentCount", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "long"), 91);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.util.List"), 95);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.lang.String"), 100);
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

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
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
    public long getContentSize() {
        return (this.entries.size() * (getVersion() == 1 ? 16 : 8)) + 5;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.entries;
    }

    public long getFragmentCount() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries.size();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getUserType() {
        return new byte[]{-44, ByteCompanionObject.MIN_VALUE, 126, -14, ExifInterface.MARKER_SOF10, 57, 70, -107, -114, 84, 38, ExifInterface.MARKER_SOF11, -98, 70, -89, -97};
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "TfrfBox{entries=" + this.entries + '}';
    }
}
