package d.b.i0.t1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f62558a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f62559b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f62560c = f62559b + f62558a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f62561d = f62560c + f62558a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f62562e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f62563f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f62564g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f62561d);
        sb.append(f62558a);
        f62562e = sb.toString();
        f62563f = f62559b + f62558a + ".tieba_video_monitor_log";
        f62564g = f62563f + f62558a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f62564g);
        sb2.append(f62558a);
        sb2.toString();
    }
}
