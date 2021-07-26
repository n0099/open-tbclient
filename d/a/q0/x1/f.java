package d.a.q0.x1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes8.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f66875a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f66876b = Environment.getExternalStorageDirectory() + f66875a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f66877c = f66876b + f66875a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f66878d = f66877c + f66875a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f66879e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f66878d);
        sb.append(f66875a);
        f66879e = sb.toString();
    }
}
