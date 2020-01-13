package kascend.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public class b extends a {
    private final String nAM;
    private final String nAN;

    public b(Context context) {
        super(context);
        this.nAM = "com_kascend_prefs";
        this.nAN = "key_device";
    }

    @Override // kascend.core.a.a
    public String getDS() {
        return this.context.getSharedPreferences("com_kascend_prefs", 0).getString("key_device", "");
    }

    @Override // kascend.core.a.a
    public void RR(String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.context.getSharedPreferences("com_kascend_prefs", 0).edit();
            edit.putString("key_device", str);
            edit.apply();
        }
    }
}
