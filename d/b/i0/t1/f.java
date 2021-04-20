package d.b.i0.t1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f62565a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f62566b = Environment.getExternalStorageDirectory() + f62565a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f62567c = f62566b + f62565a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f62568d = f62567c + f62565a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f62569e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f62568d);
        sb.append(f62565a);
        f62569e = sb.toString();
    }
}
