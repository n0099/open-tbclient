package d.r.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.util.TbEnum;
import java.lang.ref.SoftReference;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static SoftReference<e> f71551d;

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.f.a f71552a;

    /* renamed from: b  reason: collision with root package name */
    public String f71553b;

    /* renamed from: c  reason: collision with root package name */
    public Context f71554c;

    public e(Context context, String str) {
        d.r.b.g.a.b();
        this.f71552a = new d.r.b.f.a(context, str);
        this.f71553b = str;
        this.f71554c = context;
    }

    public static e b(Context context, String str) {
        e eVar;
        if (context != null && str != null) {
            SoftReference<e> softReference = f71551d;
            e eVar2 = softReference == null ? null : softReference.get();
            if (eVar2 == null || !str.equals(eVar2.f71553b)) {
                synchronized (e.class) {
                    eVar = new e(context, str);
                    f71551d = new SoftReference<>(eVar);
                }
                return eVar;
            }
            return eVar2;
        }
        throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
    }

    public final void a(Activity activity, b bVar) {
        this.f71552a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, bVar);
    }

    public final void c(int i2, int i3, Intent intent, b bVar) {
        this.f71552a.d(i2, i3, intent, bVar);
    }
}
