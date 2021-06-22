package d.a.c.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f42164d;

    /* renamed from: c  reason: collision with root package name */
    public e f42165c;

    public b() {
        this.f42165c = null;
        this.f42167a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f42165c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f42168b = 3;
    }

    public static b d() {
        if (f42164d == null) {
            synchronized (b.class) {
                if (f42164d == null) {
                    f42164d = new b();
                }
            }
        }
        return f42164d;
    }

    public e c() {
        return this.f42165c;
    }
}
