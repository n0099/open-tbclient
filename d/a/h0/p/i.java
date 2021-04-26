package d.a.h0.p;

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
    public final SharedPreferences f47589a;

    /* renamed from: b  reason: collision with root package name */
    public String f47590b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f47591c = AppRuntime.getAppContext();

    public i(String str) {
        String str2 = (TextUtils.isEmpty(str) || str.indexOf(File.separatorChar) >= 0) ? "default" : str;
        this.f47590b = str2;
        if ("default".equals(str2)) {
            this.f47589a = PreferenceManager.getDefaultSharedPreferences(this.f47591c);
            this.f47590b = this.f47591c.getPackageName() + "_preferences";
            return;
        }
        this.f47589a = this.f47591c.getSharedPreferences(str, 0);
    }

    public static File e(@NonNull Context context, @NonNull String str) {
        String str2 = context.getApplicationInfo().dataDir;
        return new File(str2, "shared_prefs/" + str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
    }

    @Override // d.a.h0.p.b
    public Set<String> a() {
        return this.f47589a.getAll().keySet();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        edit().apply();
    }

    @Override // d.a.h0.p.b
    public boolean b() {
        return false;
    }

    @Override // d.a.h0.p.b
    @NonNull
    public File c() {
        return e(this.f47591c, this.f47590b);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.f47589a.edit().clear().apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return edit().commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f47589a.contains(str);
    }

    @Override // d.a.h0.p.b
    public long d() {
        return c().length();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f47589a.edit();
    }

    @Override // d.a.h0.p.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f47589a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f47589a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f47589a.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return this.f47589a.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f47589a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, @Nullable String str2) {
        return this.f47589a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f47589a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        this.f47589a.edit().putBoolean(str, z).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        this.f47589a.edit().putFloat(str, f2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        this.f47589a.edit().putInt(str, i2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        this.f47589a.edit().putLong(str, j).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        this.f47589a.edit().putString(str, str2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        this.f47589a.edit().putStringSet(str, set).apply();
        return this;
    }

    @Override // d.a.h0.p.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f47589a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        this.f47589a.edit().remove(str).apply();
        return this;
    }

    @Override // d.a.h0.p.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f47589a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
