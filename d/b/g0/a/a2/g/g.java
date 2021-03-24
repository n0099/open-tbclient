package d.b.g0.a.a2.g;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class g implements d.b.g0.p.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final d.b.g0.p.b f43269a;

    public g(String str, boolean z) {
        this.f43269a = d.b.g0.a.w0.a.Z().a(d.b.g0.a.w0.a.c(), str, z);
    }

    @Override // d.b.g0.p.b
    public Set<String> a() {
        return this.f43269a.a();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f43269a.apply();
    }

    @Override // d.b.g0.p.b
    public long b() {
        return this.f43269a.b();
    }

    @Override // d.b.g0.p.b
    public boolean c() {
        return this.f43269a.c();
    }

    public SharedPreferences.Editor clear() {
        return this.f43269a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f43269a.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f43269a.contains(str);
    }

    @Override // d.b.g0.p.b
    @NonNull
    public File d() {
        return this.f43269a.d();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f43269a.edit();
    }

    @Override // d.b.g0.p.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.f43269a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f43269a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f43269a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.f43269a.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f43269a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f43269a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f43269a.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.f43269a.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        return this.f43269a.putFloat(str, f2);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.f43269a.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.f43269a.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.f43269a.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.f43269a.putStringSet(str, set);
    }

    @Override // d.b.g0.p.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43269a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.f43269a.remove(str);
    }

    @Override // d.b.g0.p.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43269a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str) {
        this(str, true);
    }
}
