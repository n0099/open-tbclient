package d.a.q0.x1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes8.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f66868a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f66869b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f66870c = f66869b + f66868a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f66871d = f66870c + f66868a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f66872e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f66873f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f66874g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f66871d);
        sb.append(f66868a);
        f66872e = sb.toString();
        f66873f = f66869b + f66868a + ".tieba_video_monitor_log";
        f66874g = f66873f + f66868a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f66874g);
        sb2.append(f66868a);
        sb2.toString();
    }
}
