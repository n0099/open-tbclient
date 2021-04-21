package d.b.h0.a.a2.g;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class g implements d.b.h0.p.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final d.b.h0.p.b f43991a;

    public g(String str, boolean z) {
        this.f43991a = d.b.h0.a.w0.a.Z().a(d.b.h0.a.w0.a.c(), str, z);
    }

    @Override // d.b.h0.p.b
    public Set<String> a() {
        return this.f43991a.a();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f43991a.apply();
    }

    @Override // d.b.h0.p.b
    public long b() {
        return this.f43991a.b();
    }

    @Override // d.b.h0.p.b
    public boolean c() {
        return this.f43991a.c();
    }

    public SharedPreferences.Editor clear() {
        return this.f43991a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f43991a.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f43991a.contains(str);
    }

    @Override // d.b.h0.p.b
    @NonNull
    public File d() {
        return this.f43991a.d();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f43991a.edit();
    }

    @Override // d.b.h0.p.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.f43991a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f43991a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f43991a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.f43991a.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f43991a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f43991a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f43991a.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.f43991a.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        return this.f43991a.putFloat(str, f2);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.f43991a.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.f43991a.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.f43991a.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.f43991a.putStringSet(str, set);
    }

    @Override // d.b.h0.p.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43991a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.f43991a.remove(str);
    }

    @Override // d.b.h0.p.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43991a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str) {
        this(str, true);
    }
}
