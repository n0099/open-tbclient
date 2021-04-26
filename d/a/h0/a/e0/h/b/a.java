package d.a.h0.a.e0.h.b;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41920c = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static a f41921d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41922a = false;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f41923b = new HashMap<>();

    public static a a() {
        if (f41921d == null) {
            synchronized (a.class) {
                if (f41921d == null) {
                    f41921d = new a();
                }
            }
        }
        return f41921d;
    }

    public boolean b() {
        return this.f41922a;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = this.f41923b;
        if (hashMap != null && hashMap.containsKey(str) && currentTimeMillis - this.f41923b.get(str).longValue() <= 18000000) {
            if (f41920c) {
                Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
                return true;
            }
            return true;
        }
        if (f41920c) {
            HashMap<String, Long> hashMap2 = this.f41923b;
            if (hashMap2 != null && hashMap2.containsKey(str)) {
                Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.f41923b.get(str) + " ，id = " + str);
            } else {
                Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
            }
        }
        return false;
    }
}
