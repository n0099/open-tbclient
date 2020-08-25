package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class VisualRandomAccessEntry extends GroupEntry {
    public static final String TYPE = "rap ";
    private short numLeadingSamples;
    private boolean numLeadingSamplesKnown;

    public boolean isNumLeadingSamplesKnown() {
        return this.numLeadingSamplesKnown;
    }

    public void setNumLeadingSamplesKnown(boolean z) {
        this.numLeadingSamplesKnown = z;
    }

    public short getNumLeadingSamples() {
        return this.numLeadingSamples;
    }

    public void setNumLeadingSamples(short s) {
        this.numLeadingSamples = s;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        this.numLeadingSamplesKnown = (b & 128) == 128;
        this.numLeadingSamples = (short) (b & Byte.MAX_VALUE);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) ((this.numLeadingSamplesKnown ? 128 : 0) | (this.numLeadingSamples & 127)));
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VisualRandomAccessEntry visualRandomAccessEntry = (VisualRandomAccessEntry) obj;
        return this.numLeadingSamples == visualRandomAccessEntry.numLeadingSamples && this.numLeadingSamplesKnown == visualRandomAccessEntry.numLeadingSamplesKnown;
    }

    public int hashCode() {
        return ((this.numLeadingSamplesKnown ? 1 : 0) * 31) + this.numLeadingSamples;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VisualRandomAccessEntry");
        sb.append("{numLeadingSamplesKnown=").append(this.numLeadingSamplesKnown);
        sb.append(", numLeadingSamples=").append((int) this.numLeadingSamples);
        sb.append('}');
        return sb.toString();
    }
}
