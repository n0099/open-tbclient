package d.b.i0.s1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f60150a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f60151b = Environment.getExternalStorageDirectory() + f60150a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f60152c = f60151b + f60150a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f60153d = f60152c + f60150a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f60154e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f60153d);
        sb.append(f60150a);
        f60154e = sb.toString();
    }
}
