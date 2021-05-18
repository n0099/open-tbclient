package d.a.i0.a.h0.c.b;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41780c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f41781d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41782a = false;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f41783b = new HashMap<>();

    public static a a() {
        if (f41781d == null) {
            synchronized (a.class) {
                if (f41781d == null) {
                    f41781d = new a();
                }
            }
        }
        return f41781d;
    }

    public boolean b() {
        return this.f41782a;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = this.f41783b;
        if (hashMap != null && hashMap.containsKey(str) && currentTimeMillis - this.f41783b.get(str).longValue() <= 18000000) {
            if (f41780c) {
                Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
                return true;
            }
            return true;
        }
        if (f41780c) {
            HashMap<String, Long> hashMap2 = this.f41783b;
            if (hashMap2 != null && hashMap2.containsKey(str)) {
                Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.f41783b.get(str) + " ，id = " + str);
            } else {
                Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
            }
        }
        return false;
    }
}
