package d.a.m0.a.h0.c.b;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45738c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f45739d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f45740a = false;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f45741b = new HashMap<>();

    public static a a() {
        if (f45739d == null) {
            synchronized (a.class) {
                if (f45739d == null) {
                    f45739d = new a();
                }
            }
        }
        return f45739d;
    }

    public boolean b() {
        return this.f45740a;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = this.f45741b;
        if (hashMap != null && hashMap.containsKey(str) && currentTimeMillis - this.f45741b.get(str).longValue() <= 18000000) {
            if (f45738c) {
                Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
                return true;
            }
            return true;
        }
        if (f45738c) {
            HashMap<String, Long> hashMap2 = this.f45741b;
            if (hashMap2 != null && hashMap2.containsKey(str)) {
                Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.f45741b.get(str) + " ，id = " + str);
            } else {
                Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
            }
        }
        return false;
    }
}
