package d.b.h.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class e implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, e> f49832e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Context f49833a = b.a().getBaseContext();

    /* renamed from: b  reason: collision with root package name */
    public String f49834b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f49835c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f49836d;

    public e(String str) {
        this.f49834b = str;
        if (TextUtils.isEmpty(str)) {
            this.f49834b = this.f49833a.getPackageName() + "_preferences";
        }
        this.f49836d = new ConcurrentHashMap<>();
        g();
    }

    public static synchronized e f(String str) {
        synchronized (e.class) {
            if (TextUtils.isEmpty(str)) {
                str = b.a().getPackageName() + "_preferences";
            }
            if (f49832e.containsKey(str)) {
                return f49832e.get(str);
            }
            e eVar = new e(str);
            f49832e.put(str, eVar);
            return eVar;
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        e();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.f49835c.clear();
        f.e(this.f49834b);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        e();
        f.g();
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (this.f49835c.containsKey(str)) {
            return true;
        }
        return this.f49833a.getSharedPreferences(this.f49834b, 0).contains(str);
    }

    public final void e() {
        synchronized (this) {
            Log.d("BdPreferenceImpl", "modified size: " + this.f49836d.size());
            for (Map.Entry<String, Object> entry : this.f49836d.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Log.d("BdPreferenceImpl", "modified. key: " + key + " value: " + value);
                if (key != null) {
                    if (value != null && value != this) {
                        if (this.f49835c.containsKey(key)) {
                            Object obj = this.f49835c.get(key);
                            Log.d("BdPreferenceImpl", "cache. key: " + key + " value: " + obj);
                            if (obj != null && obj.equals(value)) {
                            }
                        }
                        this.f49835c.put(key, value);
                        Log.d("BdPreferenceImpl", "write to file. key: " + key + " value: " + value);
                        f.c(this.f49834b, key, value);
                    }
                    this.f49835c.remove(key);
                    f.c(this.f49834b, key, null);
                }
            }
            this.f49836d.clear();
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public final void g() {
        this.f49835c = new ConcurrentHashMap<>();
        Map<String, ?> all = this.f49833a.getSharedPreferences(this.f49834b, 0).getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    this.f49835c.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f49835c;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        if (this.f49835c.containsKey(str)) {
            return ((Boolean) this.f49835c.get(str)).booleanValue();
        }
        return this.f49833a.getSharedPreferences(this.f49834b, 0).getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        if (this.f49835c.containsKey(str)) {
            return ((Float) this.f49835c.get(str)).floatValue();
        }
        return this.f49833a.getSharedPreferences(this.f49834b, 0).getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.f49835c.containsKey(str)) {
            return ((Integer) this.f49835c.get(str)).intValue();
        }
        return this.f49833a.getSharedPreferences(this.f49834b, 0).getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f49835c.containsKey(str)) {
            return ((Long) this.f49835c.get(str)).longValue();
        }
        return this.f49833a.getSharedPreferences(this.f49834b, 0).getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f49835c.containsKey(str)) {
            return (String) this.f49835c.get(str);
        }
        return this.f49833a.getSharedPreferences(this.f49834b, 0).getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        if (this.f49835c.containsKey(str)) {
            return (Set) this.f49835c.get(str);
        }
        return this.f49833a.getSharedPreferences(this.f49834b, 0).getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (str == null) {
            return this;
        }
        this.f49836d.put(str, Boolean.valueOf(z));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (str == null) {
            return this;
        }
        this.f49836d.put(str, Float.valueOf(f2));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (str == null) {
            return this;
        }
        this.f49836d.put(str, Integer.valueOf(i));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (str == null) {
            return this;
        }
        this.f49836d.put(str, Long.valueOf(j));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (str == null) {
            return this;
        }
        if (str2 == null) {
            remove(str);
        } else {
            this.f49836d.put(str, str2);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (str == null) {
            return this;
        }
        if (set == null) {
            remove(str);
        } else {
            this.f49836d.put(str, set);
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f49833a.getSharedPreferences(this.f49834b, 0).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (str == null) {
            return this;
        }
        this.f49835c.remove(str);
        f.c(this.f49834b, str, null);
        return this;
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f49833a.getSharedPreferences(this.f49834b, 0).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
