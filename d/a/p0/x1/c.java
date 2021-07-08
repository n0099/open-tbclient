package d.a.p0.x1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes8.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f66192a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f66193b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f66194c = f66193b + f66192a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f66195d = f66194c + f66192a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f66196e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f66197f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f66198g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f66195d);
        sb.append(f66192a);
        f66196e = sb.toString();
        f66197f = f66193b + f66192a + ".tieba_video_monitor_log";
        f66198g = f66197f + f66192a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f66198g);
        sb2.append(f66192a);
        sb2.toString();
    }
}
