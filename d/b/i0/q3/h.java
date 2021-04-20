package d.b.i0.q3;
/* loaded from: classes5.dex */
public class h {
    public static void a() {
        d.b.h0.r.d0.b.j().v("key_video_guide_count", d.b.h0.r.d0.b.j().k("key_video_guide_count", 0) + 1);
    }

    public static void b() {
        d.b.h0.r.d0.b.j().v("key_no_behavior_count", d.b.h0.r.d0.b.j().k("key_no_behavior_count", 0) + 1);
    }

    public static void c() {
        d.b.h0.r.d0.b.j().v("key_no_behavior_count", 0);
    }

    public static boolean d() {
        return d.b.h0.r.d0.b.j().k("key_video_guide_count", 0) < d.b.h0.r.d0.b.j().k("key_video_guide_max_count", 0) && d.b.h0.r.d0.b.j().k("key_no_behavior_count", 0) >= 2;
    }
}
