package d.b.j0.t1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f62986a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f62987b = Environment.getExternalStorageDirectory() + f62986a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f62988c = f62987b + f62986a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f62989d = f62988c + f62986a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f62990e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f62989d);
        sb.append(f62986a);
        f62990e = sb.toString();
    }
}
