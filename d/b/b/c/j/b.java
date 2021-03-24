package d.b.b.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f41568d;

    /* renamed from: c  reason: collision with root package name */
    public e f41569c;

    public b() {
        this.f41569c = null;
        this.f41571a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f41569c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f41572b = 3;
    }

    public static b d() {
        if (f41568d == null) {
            synchronized (b.class) {
                if (f41568d == null) {
                    f41568d = new b();
                }
            }
        }
        return f41568d;
    }

    public e c() {
        return this.f41569c;
    }
}
