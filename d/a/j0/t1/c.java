package d.a.j0.t1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61184a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61185b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f61186c = f61185b + f61184a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f61187d = f61186c + f61184a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61188e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f61189f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f61190g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f61187d);
        sb.append(f61184a);
        f61188e = sb.toString();
        f61189f = f61185b + f61184a + ".tieba_video_monitor_log";
        f61190g = f61189f + f61184a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f61190g);
        sb2.append(f61184a);
        sb2.toString();
    }
}
