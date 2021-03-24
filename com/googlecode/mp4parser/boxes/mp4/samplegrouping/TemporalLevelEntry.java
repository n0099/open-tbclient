package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public class TemporalLevelEntry extends GroupEntry {
    public static final String TYPE = "tele";
    public boolean levelIndependentlyDecodable;
    public short reserved;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TemporalLevelEntry.class != obj.getClass()) {
            return false;
        }
        TemporalLevelEntry temporalLevelEntry = (TemporalLevelEntry) obj;
        return this.levelIndependentlyDecodable == temporalLevelEntry.levelIndependentlyDecodable && this.reserved == temporalLevelEntry.reserved;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) (this.levelIndependentlyDecodable ? 128 : 0));
        allocate.rewind();
        return allocate;
    }

    public int hashCode() {
        return ((this.levelIndependentlyDecodable ? 1 : 0) * 31) + this.reserved;
    }

    public boolean isLevelIndependentlyDecodable() {
        return this.levelIndependentlyDecodable;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        this.levelIndependentlyDecodable = (byteBuffer.get() & ByteCompanionObject.MIN_VALUE) == 128;
    }

    public void setLevelIndependentlyDecodable(boolean z) {
        this.levelIndependentlyDecodable = z;
    }

    public String toString() {
        return "TemporalLevelEntry{levelIndependentlyDecodable=" + this.levelIndependentlyDecodable + '}';
    }
}
