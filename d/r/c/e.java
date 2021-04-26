package d.r.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.util.TbEnum;
import java.lang.ref.SoftReference;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static SoftReference<e> f67462d;

    /* renamed from: a  reason: collision with root package name */
    public d.r.c.f.a f67463a;

    /* renamed from: b  reason: collision with root package name */
    public String f67464b;

    /* renamed from: c  reason: collision with root package name */
    public Context f67465c;

    public e(Context context, String str) {
        d.r.c.g.a.b();
        this.f67463a = new d.r.c.f.a(context, str);
        this.f67464b = str;
        this.f67465c = context;
    }

    public static e b(Context context, String str) {
        e eVar;
        if (context != null && str != null) {
            SoftReference<e> softReference = f67462d;
            e eVar2 = softReference == null ? null : softReference.get();
            if (eVar2 == null || !str.equals(eVar2.f67464b)) {
                synchronized (e.class) {
                    eVar = new e(context, str);
                    f67462d = new SoftReference<>(eVar);
                }
                return eVar;
            }
            return eVar2;
        }
        throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
    }

    public final void a(Activity activity, b bVar) {
        this.f67463a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, bVar);
    }

    public final void c(int i2, int i3, Intent intent, b bVar) {
        this.f67463a.d(i2, i3, intent, bVar);
    }
}
