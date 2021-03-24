package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class RollRecoveryEntry extends GroupEntry {
    public static final String TYPE = "roll";
    public short rollDistance;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && RollRecoveryEntry.class == obj.getClass() && this.rollDistance == ((RollRecoveryEntry) obj).rollDistance;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort(this.rollDistance);
        allocate.rewind();
        return allocate;
    }

    public short getRollDistance() {
        return this.rollDistance;
    }

    public int hashCode() {
        return this.rollDistance;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        this.rollDistance = byteBuffer.getShort();
    }

    public void setRollDistance(short s) {
        this.rollDistance = s;
    }
}
