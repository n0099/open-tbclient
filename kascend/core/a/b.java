package kascend.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class b extends a {
    private final String orG;
    private final String orH;

    public b(Context context) {
        super(context);
        this.orG = "com_kascend_prefs";
        this.orH = "key_device";
    }

    @Override // kascend.core.a.a
    public String getDS() {
        return this.context.getSharedPreferences("com_kascend_prefs", 0).getString("key_device", "");
    }

    @Override // kascend.core.a.a
    public void We(String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.context.getSharedPreferences("com_kascend_prefs", 0).edit();
            edit.putString("key_device", str);
            edit.apply();
        }
    }
}
