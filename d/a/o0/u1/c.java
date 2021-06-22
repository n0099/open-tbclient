package d.a.o0.u1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f65153a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f65154b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f65155c = f65154b + f65153a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f65156d = f65155c + f65153a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f65157e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f65158f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f65159g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f65156d);
        sb.append(f65153a);
        f65157e = sb.toString();
        f65158f = f65154b + f65153a + ".tieba_video_monitor_log";
        f65159g = f65158f + f65153a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f65159g);
        sb2.append(f65153a);
        sb2.toString();
    }
}
