package d.a.n0.u1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61322a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61323b = Environment.getExternalStorageDirectory() + f61322a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f61324c = f61323b + f61322a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f61325d = f61324c + f61322a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61326e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f61325d);
        sb.append(f61322a);
        f61326e = sb.toString();
    }
}
