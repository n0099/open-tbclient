package d.b.i0.s1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f60151a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f60152b = Environment.getExternalStorageDirectory() + f60151a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f60153c = f60152b + f60151a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f60154d = f60153c + f60151a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f60155e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f60154d);
        sb.append(f60151a);
        f60155e = sb.toString();
    }
}
