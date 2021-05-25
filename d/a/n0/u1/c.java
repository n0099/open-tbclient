package d.a.n0.u1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61315a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61316b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f61317c = f61316b + f61315a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f61318d = f61317c + f61315a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61319e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f61320f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f61321g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f61318d);
        sb.append(f61315a);
        f61319e = sb.toString();
        f61320f = f61316b + f61315a + ".tieba_video_monitor_log";
        f61321g = f61320f + f61315a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f61321g);
        sb2.append(f61315a);
        sb2.toString();
    }
}
