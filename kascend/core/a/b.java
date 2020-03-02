package kascend.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public class b extends a {
    private final String nBv;
    private final String nBw;

    public b(Context context) {
        super(context);
        this.nBv = "com_kascend_prefs";
        this.nBw = "key_device";
    }

    @Override // kascend.core.a.a
    public String getDS() {
        return this.context.getSharedPreferences("com_kascend_prefs", 0).getString("key_device", "");
    }

    @Override // kascend.core.a.a
    public void Sc(String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.context.getSharedPreferences("com_kascend_prefs", 0).edit();
            edit.putString("key_device", str);
            edit.apply();
        }
    }
}
