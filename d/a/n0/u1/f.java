package d.a.n0.u1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f65035a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f65036b = Environment.getExternalStorageDirectory() + f65035a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f65037c = f65036b + f65035a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f65038d = f65037c + f65035a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f65039e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f65038d);
        sb.append(f65035a);
        f65039e = sb.toString();
    }
}
