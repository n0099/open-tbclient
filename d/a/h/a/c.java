package d.a.h.a;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class c implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public String f40256a;

    /* renamed from: b  reason: collision with root package name */
    public b f40257b;

    /* renamed from: c  reason: collision with root package name */
    public e f40258c;

    /* loaded from: classes.dex */
    public class b implements SharedPreferences.Editor {
        public b() {
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            c.this.f40258c.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            c.this.f40258c.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return c.this.f40258c.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            c.this.f40258c.putBoolean(str, z);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            c.this.f40258c.putFloat(str, f2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i2) {
            c.this.f40258c.putInt(str, i2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            c.this.f40258c.putLong(str, j);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            c.this.f40258c.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            c.this.f40258c.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            c.this.f40258c.remove(str);
            return this;
        }
    }

    public c(String str) {
        this.f40256a = str;
        this.f40258c = e.f(str);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f40258c.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.f40257b == null) {
            this.f40257b = new b();
        }
        return this.f40257b;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f40258c.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f40258c.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f40258c.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return this.f40258c.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f40258c.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f40258c.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f40258c.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f40258c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f40258c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
