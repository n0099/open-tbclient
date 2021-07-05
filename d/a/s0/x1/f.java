package d.a.s0.x1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes9.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f69411a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f69412b = Environment.getExternalStorageDirectory() + f69411a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f69413c = f69412b + f69411a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f69414d = f69413c + f69411a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f69415e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f69414d);
        sb.append(f69411a);
        f69415e = sb.toString();
    }
}
