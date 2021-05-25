package d.a.l0.a.k2.g;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class g implements d.a.l0.t.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final d.a.l0.t.b f43275a;

    public g(String str, boolean z) {
        this.f43275a = d.a.l0.a.k2.h.d.j().k(d.a.l0.a.c1.a.b(), str, z);
    }

    @Override // d.a.l0.t.b
    public Set<String> a() {
        return this.f43275a.a();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f43275a.apply();
    }

    @Override // d.a.l0.t.b
    public boolean b() {
        return this.f43275a.b();
    }

    @Override // d.a.l0.t.b
    @NonNull
    public File c() {
        return this.f43275a.c();
    }

    public SharedPreferences.Editor clear() {
        return this.f43275a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f43275a.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f43275a.contains(str);
    }

    @Override // d.a.l0.t.b
    public long d() {
        return this.f43275a.d();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f43275a.edit();
    }

    @Override // d.a.l0.t.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.f43275a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f43275a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f43275a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return this.f43275a.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f43275a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f43275a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f43275a.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.f43275a.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        return this.f43275a.putFloat(str, f2);
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        return this.f43275a.putInt(str, i2);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.f43275a.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.f43275a.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.f43275a.putStringSet(str, set);
    }

    @Override // d.a.l0.t.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43275a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.f43275a.remove(str);
    }

    @Override // d.a.l0.t.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43275a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str) {
        this(str, true);
    }
}
