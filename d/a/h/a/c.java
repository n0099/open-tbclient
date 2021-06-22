package d.a.h.a;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class c implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public String f43686a;

    /* renamed from: b  reason: collision with root package name */
    public b f43687b;

    /* renamed from: c  reason: collision with root package name */
    public e f43688c;

    /* loaded from: classes.dex */
    public class b implements SharedPreferences.Editor {
        public b() {
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            c.this.f43688c.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            c.this.f43688c.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return c.this.f43688c.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            c.this.f43688c.putBoolean(str, z);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            c.this.f43688c.putFloat(str, f2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i2) {
            c.this.f43688c.putInt(str, i2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            c.this.f43688c.putLong(str, j);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            c.this.f43688c.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            c.this.f43688c.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            c.this.f43688c.remove(str);
            return this;
        }
    }

    public c(String str) {
        this.f43686a = str;
        this.f43688c = e.f(str);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f43688c.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.f43687b == null) {
            this.f43687b = new b();
        }
        return this.f43687b;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f43688c.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f43688c.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return this.f43688c.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return this.f43688c.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f43688c.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f43688c.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f43688c.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43688c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43688c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
