package d.a.j0.t1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61191a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61192b = Environment.getExternalStorageDirectory() + f61191a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f61193c = f61192b + f61191a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f61194d = f61193c + f61191a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61195e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f61194d);
        sb.append(f61191a);
        f61195e = sb.toString();
    }
}
