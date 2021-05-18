package d.a.k0.t1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61915a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61916b = Environment.getExternalStorageDirectory() + f61915a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f61917c = f61916b + f61915a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f61918d = f61917c + f61915a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61919e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f61918d);
        sb.append(f61915a);
        f61919e = sb.toString();
    }
}
