package d.a.s0.x1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes9.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f69404a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f69405b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f69406c = f69405b + f69404a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f69407d = f69406c + f69404a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f69408e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f69409f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f69410g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f69407d);
        sb.append(f69404a);
        f69408e = sb.toString();
        f69409f = f69405b + f69404a + ".tieba_video_monitor_log";
        f69410g = f69409f + f69404a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f69410g);
        sb2.append(f69404a);
        sb2.toString();
    }
}
