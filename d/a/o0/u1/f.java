package d.a.o0.u1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f65160a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f65161b = Environment.getExternalStorageDirectory() + f65160a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f65162c = f65161b + f65160a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f65163d = f65162c + f65160a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f65164e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f65163d);
        sb.append(f65160a);
        f65164e = sb.toString();
    }
}
