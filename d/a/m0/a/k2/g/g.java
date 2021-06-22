package d.a.m0.a.k2.g;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class g implements d.a.m0.t.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final d.a.m0.t.b f47059a;

    public g(String str, boolean z) {
        this.f47059a = d.a.m0.a.k2.h.d.j().k(d.a.m0.a.c1.a.b(), str, z);
    }

    @Override // d.a.m0.t.b
    public Set<String> a() {
        return this.f47059a.a();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f47059a.apply();
    }

    @Override // d.a.m0.t.b
    public boolean b() {
        return this.f47059a.b();
    }

    @Override // d.a.m0.t.b
    @NonNull
    public File c() {
        return this.f47059a.c();
    }

    public SharedPreferences.Editor clear() {
        return this.f47059a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f47059a.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f47059a.contains(str);
    }

    @Override // d.a.m0.t.b
    public long d() {
        return this.f47059a.d();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f47059a.edit();
    }

    @Override // d.a.m0.t.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.f47059a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f47059a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f47059a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return this.f47059a.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f47059a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f47059a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f47059a.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.f47059a.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        return this.f47059a.putFloat(str, f2);
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        return this.f47059a.putInt(str, i2);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.f47059a.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.f47059a.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.f47059a.putStringSet(str, set);
    }

    @Override // d.a.m0.t.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f47059a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.f47059a.remove(str);
    }

    @Override // d.a.m0.t.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f47059a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str) {
        this(str, true);
    }
}
