package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MMSharedPreferences implements SharedPreferences {
    private final ContentResolver i;
    private final String[] columns = {"_id", "key", "type", "value"};
    private final HashMap<String, Object> j = new HashMap<>();
    private REditor k = null;

    /* loaded from: classes.dex */
    class REditor implements SharedPreferences.Editor {
        private ContentResolver i;
        private Map<String, Object> l = new HashMap();
        private Set<String> m = new HashSet();
        private boolean n = false;

        public REditor(ContentResolver contentResolver) {
            this.i = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.n = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            ContentValues contentValues = new ContentValues();
            if (this.n) {
                this.i.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, null, null);
                this.n = false;
            }
            Iterator<String> it = this.m.iterator();
            while (it.hasNext()) {
                this.i.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, "key = ?", new String[]{it.next()});
            }
            for (Map.Entry<String, Object> entry : this.l.entrySet()) {
                if (MMPluginProviderConstants.Resolver.unresolveObj(contentValues, entry.getValue())) {
                    this.i.update(MMPluginProviderConstants.SharedPref.CONTENT_URI, contentValues, "key = ?", new String[]{entry.getKey()});
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.l.put(str, Boolean.valueOf(z));
            this.m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.l.put(str, Float.valueOf(f));
            this.m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.l.put(str, Integer.valueOf(i));
            this.m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.l.put(str, Long.valueOf(j));
            this.m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.l.put(str, str2);
            this.m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.m.add(str);
            return this;
        }
    }

    public MMSharedPreferences(Context context) {
        this.i = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.i.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.columns, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object resolveObj = query.moveToFirst() ? MMPluginProviderConstants.Resolver.resolveObj(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return resolveObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.k == null) {
            this.k = new REditor(this.i);
        }
        return this.k;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            Cursor query = this.i.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.columns, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.j.put(query.getString(columnIndex), MMPluginProviderConstants.Resolver.resolveObj(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.j;
        } catch (Exception e) {
            e.printStackTrace();
            return this.j;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f : ((Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
