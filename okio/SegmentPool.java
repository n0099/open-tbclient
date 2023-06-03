package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public final class SegmentPool {
    public static final long MAX_SIZE = 65536;
    public static long byteCount;
    @Nullable
    public static Segment next;

    public static Segment take() {
        synchronized (SegmentPool.class) {
            if (next != null) {
                Segment segment = next;
                next = segment.next;
                segment.next = null;
                byteCount -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return segment;
            }
            return new Segment();
        }
    }

    public static void recycle(Segment segment) {
        if (segment.next == null && segment.prev == null) {
            if (segment.shared) {
                return;
            }
            synchronized (SegmentPool.class) {
                if (byteCount + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                    return;
                }
                byteCount += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                segment.next = next;
                segment.limit = 0;
                segment.pos = 0;
                next = segment;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
