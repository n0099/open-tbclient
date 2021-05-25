package d.a.c.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f38408d;

    /* renamed from: c  reason: collision with root package name */
    public e f38409c;

    public b() {
        this.f38409c = null;
        this.f38411a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f38409c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f38412b = 3;
    }

    public static b d() {
        if (f38408d == null) {
            synchronized (b.class) {
                if (f38408d == null) {
                    f38408d = new b();
                }
            }
        }
        return f38408d;
    }

    public e c() {
        return this.f38409c;
    }
}
