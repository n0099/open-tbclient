package d.b.g0.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class i implements b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f49728a;

    /* renamed from: b  reason: collision with root package name */
    public String f49729b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f49730c = AppRuntime.getAppContext();

    public i(String str) {
        String str2 = (TextUtils.isEmpty(str) || str.indexOf(File.separatorChar) >= 0) ? "default" : str;
        this.f49729b = str2;
        if ("default".equals(str2)) {
            this.f49728a = PreferenceManager.getDefaultSharedPreferences(this.f49730c);
            this.f49729b = this.f49730c.getPackageName() + "_preferences";
            return;
        }
        this.f49728a = this.f49730c.getSharedPreferences(str, 0);
    }

    public static File e(@NonNull Context context, @NonNull String str) {
        String str2 = context.getApplicationInfo().dataDir;
        return new File(str2, "shared_prefs/" + str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
    }

    @Override // d.b.g0.p.b
    public Set<String> a() {
        return this.f49728a.getAll().keySet();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        edit().apply();
    }

    @Override // d.b.g0.p.b
    public long b() {
        return d().length();
    }

    @Override // d.b.g0.p.b
    public boolean c() {
        return false;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.f49728a.edit().clear().apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return edit().commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f49728a.contains(str);
    }

    @Override // d.b.g0.p.b
    @NonNull
    public File d() {
        return e(this.f49730c, this.f49729b);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f49728a.edit();
    }

    @Override // d.b.g0.p.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f49728a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f49728a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f49728a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.f49728a.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f49728a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, @Nullable String str2) {
        return this.f49728a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f49728a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        this.f49728a.edit().putBoolean(str, z).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        this.f49728a.edit().putFloat(str, f2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        this.f49728a.edit().putInt(str, i).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        this.f49728a.edit().putLong(str, j).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        this.f49728a.edit().putString(str, str2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        this.f49728a.edit().putStringSet(str, set).apply();
        return this;
    }

    @Override // d.b.g0.p.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f49728a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        this.f49728a.edit().remove(str).apply();
        return this;
    }

    @Override // d.b.g0.p.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f49728a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
