package d.b.i0.s1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f60143a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f60144b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f60145c = f60144b + f60143a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f60146d = f60145c + f60143a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f60147e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f60148f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f60149g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f60146d);
        sb.append(f60143a);
        f60147e = sb.toString();
        f60148f = f60144b + f60143a + ".tieba_video_monitor_log";
        f60149g = f60148f + f60143a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f60149g);
        sb2.append(f60143a);
        sb2.toString();
    }
}
