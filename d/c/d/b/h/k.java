package d.c.d.b.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import d.c.d.b.m;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f65871a;

    public k(Context context) {
        this.f65871a = context.getSharedPreferences("npth", 0);
    }

    public String a() {
        String f2 = m.a().f();
        return (TextUtils.isEmpty(f2) || "0".equals(f2)) ? this.f65871a.getString(Constants.KEY_DEVICE_ID, "0") : f2;
    }

    public void b(String str) {
        this.f65871a.edit().putString(Constants.KEY_DEVICE_ID, str).apply();
    }
}
