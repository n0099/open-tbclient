package d.a.h0.a.a2.g;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class g implements d.a.h0.p.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final d.a.h0.p.b f41261a;

    public g(String str, boolean z) {
        this.f41261a = d.a.h0.a.w0.a.Z().a(d.a.h0.a.w0.a.c(), str, z);
    }

    @Override // d.a.h0.p.b
    public Set<String> a() {
        return this.f41261a.a();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f41261a.apply();
    }

    @Override // d.a.h0.p.b
    public boolean b() {
        return this.f41261a.b();
    }

    @Override // d.a.h0.p.b
    @NonNull
    public File c() {
        return this.f41261a.c();
    }

    public SharedPreferences.Editor clear() {
        return this.f41261a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f41261a.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f41261a.contains(str);
    }

    @Override // d.a.h0.p.b
    public long d() {
        return this.f41261a.d();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f41261a.edit();
    }

    @Override // d.a.h0.p.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.f41261a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f41261a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f41261a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return this.f41261a.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f41261a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f41261a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f41261a.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.f41261a.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        return this.f41261a.putFloat(str, f2);
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        return this.f41261a.putInt(str, i2);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.f41261a.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.f41261a.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.f41261a.putStringSet(str, set);
    }

    @Override // d.a.h0.p.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f41261a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.f41261a.remove(str);
    }

    @Override // d.a.h0.p.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f41261a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str) {
        this(str, true);
    }
}
