package d.a.h0.q.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f47597a;

    public c(Context context) {
        if (context != null) {
            this.f47597a = context;
            return;
        }
        throw new RuntimeException("context can not be null");
    }

    @Override // d.a.h0.q.c.b
    public boolean a() {
        return TextUtils.isEmpty(get());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.q.c.b
    /* renamed from: b */
    public String get() {
        return PreferenceManager.getDefaultSharedPreferences(this.f47597a).getString("uuid_identity", null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.q.c.b
    /* renamed from: c */
    public void put(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f47597a).edit();
        edit.putString("uuid_identity", str);
        edit.apply();
    }
}
