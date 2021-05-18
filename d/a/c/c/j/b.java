package d.a.c.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f38744d;

    /* renamed from: c  reason: collision with root package name */
    public e f38745c;

    public b() {
        this.f38745c = null;
        this.f38747a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f38745c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f38748b = 3;
    }

    public static b d() {
        if (f38744d == null) {
            synchronized (b.class) {
                if (f38744d == null) {
                    f38744d = new b();
                }
            }
        }
        return f38744d;
    }

    public e c() {
        return this.f38745c;
    }
}
