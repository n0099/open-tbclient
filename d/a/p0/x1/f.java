package d.a.p0.x1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes8.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f66199a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f66200b = Environment.getExternalStorageDirectory() + f66199a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f66201c = f66200b + f66199a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f66202d = f66201c + f66199a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f66203e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f66202d);
        sb.append(f66199a);
        f66203e = sb.toString();
    }
}
