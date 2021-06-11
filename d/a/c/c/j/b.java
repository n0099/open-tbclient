package d.a.c.c.j;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static b f42061d;

    /* renamed from: c  reason: collision with root package name */
    public e f42062c;

    public b() {
        this.f42062c = null;
        this.f42064a = new e(28000, TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000);
        this.f42062c = new e(TbConfig.POST_IMAGE_HIGHT_LIMIT, 10000, 5000);
        this.f42065b = 3;
    }

    public static b d() {
        if (f42061d == null) {
            synchronized (b.class) {
                if (f42061d == null) {
                    f42061d = new b();
                }
            }
        }
        return f42061d;
    }

    public e c() {
        return this.f42062c;
    }
}
