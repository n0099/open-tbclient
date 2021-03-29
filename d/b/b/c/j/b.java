package d.b.b.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f41569d;

    /* renamed from: c  reason: collision with root package name */
    public e f41570c;

    public b() {
        this.f41570c = null;
        this.f41572a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f41570c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f41573b = 3;
    }

    public static b d() {
        if (f41569d == null) {
            synchronized (b.class) {
                if (f41569d == null) {
                    f41569d = new b();
                }
            }
        }
        return f41569d;
    }

    public e c() {
        return this.f41570c;
    }
}
