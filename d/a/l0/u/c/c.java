package d.a.l0.u.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f52177a;

    public c(Context context) {
        this.f52177a = context.getApplicationContext();
    }

    @Override // d.a.l0.u.c.b
    public boolean a() {
        return TextUtils.isEmpty(get());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.u.c.b
    /* renamed from: b */
    public String get() {
        return PreferenceManager.getDefaultSharedPreferences(this.f52177a).getString("uuid_identity", null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.u.c.b
    /* renamed from: c */
    public void put(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f52177a).edit();
        edit.putString("uuid_identity", str);
        edit.apply();
    }
}
