package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ProgressiveDownloadInformationBox extends AbstractFullBox {
    public static final String TYPE = "pdin";
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_2 = null;
    public List<Entry> entries;

    /* loaded from: classes6.dex */
    public static class Entry {
        public long initialDelay;
        public long rate;

        public Entry(long j, long j2) {
            this.rate = j;
            this.initialDelay = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Entry.class != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.initialDelay == entry.initialDelay && this.rate == entry.rate;
        }

        public long getInitialDelay() {
            return this.initialDelay;
        }

        public long getRate() {
            return this.rate;
        }

        public int hashCode() {
            long j = this.rate;
            long j2 = this.initialDelay;
            return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public void setInitialDelay(long j) {
            this.initialDelay = j;
        }

        public void setRate(long j) {
            this.rate = j;
        }

        public String toString() {
            return "Entry{rate=" + this.rate + ", initialDelay=" + this.initialDelay + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public ProgressiveDownloadInformationBox() {
        super(TYPE);
        this.entries = Collections.emptyList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ProgressiveDownloadInformationBox.java", ProgressiveDownloadInformationBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.util.List"), 38);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "java.util.List", "entries", "", "void"), 42);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.lang.String"), 112);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.entries = new LinkedList();
        while (byteBuffer.remaining() >= 8) {
            this.entries.add(new Entry(IsoTypeReader.readUInt32(byteBuffer), IsoTypeReader.readUInt32(byteBuffer)));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry entry : this.entries) {
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getRate());
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getInitialDelay());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return (this.entries.size() * 8) + 4;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "ProgressiveDownloadInfoBox{entries=" + this.entries + '}';
    }
}
