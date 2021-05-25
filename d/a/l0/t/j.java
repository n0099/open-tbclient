package d.a.l0.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.KVStorageRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Map;
import java.util.Set;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public class j implements b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f48495a;

    /* renamed from: b  reason: collision with root package name */
    public String f48496b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f48497c = AppRuntime.getAppContext();

    public j(String str) {
        String str2 = (TextUtils.isEmpty(str) || str.indexOf(File.separatorChar) >= 0) ? "default" : str;
        this.f48496b = str2;
        if ("default".equals(str2)) {
            this.f48495a = PreferenceManager.getDefaultSharedPreferences(this.f48497c);
            this.f48496b = this.f48497c.getPackageName() + "_preferences";
            return;
        }
        this.f48495a = KVStorageFactory.getSharedPreferences(str, 0);
    }

    public static String e() {
        String kVStoragePath = KVStorageRuntime.getKVStorageControl().getKVStoragePath();
        return kVStoragePath == null ? "" : kVStoragePath;
    }

    public static File f(@NonNull Context context, @NonNull String str) {
        String str2 = context.getApplicationInfo().dataDir;
        return new File(str2, "shared_prefs/" + str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
    }

    @Override // d.a.l0.t.b
    public Set<String> a() {
        return this.f48495a.getAll().keySet();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        edit().apply();
    }

    @Override // d.a.l0.t.b
    public boolean b() {
        return false;
    }

    @Override // d.a.l0.t.b
    @NonNull
    public File c() {
        return f(this.f48497c, this.f48496b);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.f48495a.edit().clear().apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return edit().commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f48495a.contains(str);
    }

    @Override // d.a.l0.t.b
    public long d() {
        return c().length();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f48495a.edit();
    }

    @Override // d.a.l0.t.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f48495a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f48495a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f48495a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return this.f48495a.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f48495a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, @Nullable String str2) {
        return this.f48495a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f48495a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        this.f48495a.edit().putBoolean(str, z).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        this.f48495a.edit().putFloat(str, f2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        this.f48495a.edit().putInt(str, i2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        this.f48495a.edit().putLong(str, j).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        this.f48495a.edit().putString(str, str2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        this.f48495a.edit().putStringSet(str, set).apply();
        return this;
    }

    @Override // d.a.l0.t.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f48495a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        this.f48495a.edit().remove(str).apply();
        return this;
    }

    @Override // d.a.l0.t.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f48495a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
