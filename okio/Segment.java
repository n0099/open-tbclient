package okio;

import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public final class Segment {
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public void compact() {
        Segment segment = this.prev;
        if (segment != this) {
            if (segment.owner) {
                int i2 = this.limit - this.pos;
                if (i2 > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                    return;
                }
                writeTo(this.prev, i2);
                pop();
                SegmentPool.recycle(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Nullable
    public Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        segment2.next = this.next;
        this.next.prev = segment2;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public Segment split(int i2) {
        Segment take;
        if (i2 > 0 && i2 <= this.limit - this.pos) {
            if (i2 >= 1024) {
                take = sharedCopy();
            } else {
                take = SegmentPool.take();
                System.arraycopy(this.data, this.pos, take.data, 0, i2);
            }
            take.limit = take.pos + i2;
            this.pos += i2;
            this.prev.push(take);
            return take;
        }
        throw new IllegalArgumentException();
    }

    public Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public void writeTo(Segment segment, int i2) {
        if (segment.owner) {
            int i3 = segment.limit;
            if (i3 + i2 > 8192) {
                if (!segment.shared) {
                    int i4 = segment.pos;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = segment.data;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.data, this.pos, segment.data, segment.limit, i2);
            segment.limit += i2;
            this.pos += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public Segment(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.data = bArr;
        this.pos = i2;
        this.limit = i3;
        this.shared = z;
        this.owner = z2;
    }
}
