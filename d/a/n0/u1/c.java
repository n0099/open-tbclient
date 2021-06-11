package d.a.n0.u1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f65028a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f65029b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f65030c = f65029b + f65028a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f65031d = f65030c + f65028a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f65032e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f65033f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f65034g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f65031d);
        sb.append(f65028a);
        f65032e = sb.toString();
        f65033f = f65029b + f65028a + ".tieba_video_monitor_log";
        f65034g = f65033f + f65028a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f65034g);
        sb2.append(f65028a);
        sb2.toString();
    }
}
