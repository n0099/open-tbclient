package d.b.c.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f42066d;

    /* renamed from: c  reason: collision with root package name */
    public e f42067c;

    public b() {
        this.f42067c = null;
        this.f42069a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f42067c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f42070b = 3;
    }

    public static b d() {
        if (f42066d == null) {
            synchronized (b.class) {
                if (f42066d == null) {
                    f42066d = new b();
                }
            }
        }
        return f42066d;
    }

    public e c() {
        return this.f42067c;
    }
}
