package d.b.i0.s1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f60144a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f60145b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f60146c = f60145b + f60144a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f60147d = f60146c + f60144a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f60148e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f60149f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f60150g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f60147d);
        sb.append(f60144a);
        f60148e = sb.toString();
        f60149f = f60145b + f60144a + ".tieba_video_monitor_log";
        f60150g = f60149f + f60144a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f60150g);
        sb2.append(f60144a);
        sb2.toString();
    }
}
