package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class TemporalLevelEntry extends GroupEntry {
    public static final String TYPE = "tele";
    public boolean levelIndependentlyDecodable;
    public short reserved;

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        int i;
        ByteBuffer allocate = ByteBuffer.allocate(1);
        if (this.levelIndependentlyDecodable) {
            i = 128;
        } else {
            i = 0;
        }
        allocate.put((byte) i);
        allocate.rewind();
        return allocate;
    }

    public int hashCode() {
        return ((this.levelIndependentlyDecodable ? 1 : 0) * 31) + this.reserved;
    }

    public boolean isLevelIndependentlyDecodable() {
        return this.levelIndependentlyDecodable;
    }

    public String toString() {
        return "TemporalLevelEntry{levelIndependentlyDecodable=" + this.levelIndependentlyDecodable + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TemporalLevelEntry.class != obj.getClass()) {
            return false;
        }
        TemporalLevelEntry temporalLevelEntry = (TemporalLevelEntry) obj;
        if (this.levelIndependentlyDecodable == temporalLevelEntry.levelIndependentlyDecodable && this.reserved == temporalLevelEntry.reserved) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        boolean z;
        if ((byteBuffer.get() & 128) == 128) {
            z = true;
        } else {
            z = false;
        }
        this.levelIndependentlyDecodable = z;
    }

    public void setLevelIndependentlyDecodable(boolean z) {
        this.levelIndependentlyDecodable = z;
    }
}
