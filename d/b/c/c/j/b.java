package d.b.c.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f42306d;

    /* renamed from: c  reason: collision with root package name */
    public e f42307c;

    public b() {
        this.f42307c = null;
        this.f42309a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f42307c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f42310b = 3;
    }

    public static b d() {
        if (f42306d == null) {
            synchronized (b.class) {
                if (f42306d == null) {
                    f42306d = new b();
                }
            }
        }
        return f42306d;
    }

    public e c() {
        return this.f42307c;
    }
}
