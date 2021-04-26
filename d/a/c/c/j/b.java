package d.a.c.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f39499d;

    /* renamed from: c  reason: collision with root package name */
    public e f39500c;

    public b() {
        this.f39500c = null;
        this.f39502a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f39500c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f39503b = 3;
    }

    public static b d() {
        if (f39499d == null) {
            synchronized (b.class) {
                if (f39499d == null) {
                    f39499d = new b();
                }
            }
        }
        return f39499d;
    }

    public e c() {
        return this.f39500c;
    }
}
