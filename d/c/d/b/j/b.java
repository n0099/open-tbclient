package d.c.d.b.j;

import android.os.Handler;
import android.text.TextUtils;
import d.c.d.b.l;
import d.c.d.b.m;
/* loaded from: classes5.dex */
public class b extends a {
    public b(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String f2 = m.a().f();
        if (!TextUtils.isEmpty(f2) && !"0".equals(f2)) {
            m.d().b(f2);
            l.k.a("[DeviceIdTask] did is " + f2);
            return;
        }
        b(d());
        l.k.a("[DeviceIdTask] did is null, continue check.");
    }
}
