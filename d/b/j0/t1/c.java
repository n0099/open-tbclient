package d.b.j0.t1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f62979a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f62980b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f62981c = f62980b + f62979a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f62982d = f62981c + f62979a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f62983e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f62984f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f62985g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f62982d);
        sb.append(f62979a);
        f62983e = sb.toString();
        f62984f = f62980b + f62979a + ".tieba_video_monitor_log";
        f62985g = f62984f + f62979a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f62985g);
        sb2.append(f62979a);
        sb2.toString();
    }
}
