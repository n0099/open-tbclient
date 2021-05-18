package d.a.i0.a.k2.g;

import android.content.SharedPreferences;
import android.util.Log;
import d.a.i0.a.k;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f43067g = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f43068f;

    public a(String str) {
        super(str);
        this.f43068f = new HashSet();
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return l(str) ? super.getBoolean(str, z) : e(str, z);
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return l(str) ? super.getFloat(str, f2) : f(str, f2);
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return l(str) ? super.getInt(str, i2) : g(str, i2);
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return l(str) ? super.getLong(str, j) : h(str, j);
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return l(str) ? super.getString(str, str2) : j(str, str2);
    }

    public boolean l(String str) {
        return this.f43068f.contains(str);
    }

    public final void m() {
        if (f43067g) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            Log.i("IpcReadOnlySP", illegalAccessException.toString());
            illegalAccessException.printStackTrace();
        }
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (!k() && !l(str)) {
            m();
        } else {
            super.putBoolean(str, z);
        }
        return this;
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (!k() && !l(str)) {
            m();
        } else {
            super.putFloat(str, f2);
        }
        return this;
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        if (!k() && !l(str)) {
            m();
        } else {
            super.putInt(str, i2);
        }
        return this;
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (!k() && !l(str)) {
            m();
        } else {
            super.putLong(str, j);
        }
        return this;
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (!k() && !l(str)) {
            m();
        } else {
            super.putString(str, str2);
        }
        return this;
    }

    @Override // d.a.i0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (!k() && !l(str)) {
            m();
        } else {
            super.putStringSet(str, set);
        }
        return this;
    }

    @Override // d.a.i0.a.k2.g.g, d.a.i0.t.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (k()) {
            super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            m();
        }
    }

    @Override // d.a.i0.a.k2.g.b, d.a.i0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (!k() && !l(str)) {
            m();
        } else {
            super.remove(str);
        }
        return this;
    }

    @Override // d.a.i0.a.k2.g.g, d.a.i0.t.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (k()) {
            super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            m();
        }
    }
}
