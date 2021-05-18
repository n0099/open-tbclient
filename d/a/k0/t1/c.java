package d.a.k0.t1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61908a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61909b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f61910c = f61909b + f61908a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f61911d = f61910c + f61908a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61912e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f61913f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f61914g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f61911d);
        sb.append(f61908a);
        f61912e = sb.toString();
        f61913f = f61909b + f61908a + ".tieba_video_monitor_log";
        f61914g = f61913f + f61908a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f61914g);
        sb2.append(f61908a);
        sb2.toString();
    }
}
