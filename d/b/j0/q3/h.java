package d.b.j0.q3;
/* loaded from: classes5.dex */
public class h {
    public static void a() {
        d.b.i0.r.d0.b.j().v("key_video_guide_count", d.b.i0.r.d0.b.j().k("key_video_guide_count", 0) + 1);
    }

    public static void b() {
        d.b.i0.r.d0.b.j().v("key_no_behavior_count", d.b.i0.r.d0.b.j().k("key_no_behavior_count", 0) + 1);
    }

    public static void c() {
        d.b.i0.r.d0.b.j().v("key_no_behavior_count", 0);
    }

    public static boolean d() {
        return d.b.i0.r.d0.b.j().k("key_video_guide_count", 0) < d.b.i0.r.d0.b.j().k("key_video_guide_max_count", 0) && d.b.i0.r.d0.b.j().k("key_no_behavior_count", 0) >= 2;
    }
}
