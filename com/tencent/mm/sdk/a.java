package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.baidu.android.imsdk.IMConstants;
import com.tencent.mm.sdk.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class a implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f7940a;
    private final String[] b = {IMConstants.MSG_ROW_ID, "key", "type", "value"};
    private final HashMap<String, Object> c = new HashMap<>();
    private SharedPreferences$EditorC1254a d = null;

    /* renamed from: com.tencent.mm.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class SharedPreferences$EditorC1254a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private ContentResolver f7941a;
        private Map<String, Object> e = new HashMap();
        private Set<String> f = new HashSet();
        private boolean g = false;

        public SharedPreferences$EditorC1254a(ContentResolver contentResolver) {
            this.f7941a = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.g = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            int i;
            boolean z;
            ContentValues contentValues = new ContentValues();
            if (this.g) {
                this.f7941a.delete(a.b.CONTENT_URI, null, null);
                this.g = false;
            }
            Iterator<String> it = this.f.iterator();
            while (it.hasNext()) {
                this.f7941a.delete(a.b.CONTENT_URI, "key = ?", new String[]{it.next()});
            }
            for (Map.Entry<String, Object> entry : this.e.entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                    i = 0;
                } else if (value instanceof Integer) {
                    i = 1;
                } else if (value instanceof Long) {
                    i = 2;
                } else if (value instanceof String) {
                    i = 3;
                } else if (value instanceof Boolean) {
                    i = 4;
                } else if (value instanceof Float) {
                    i = 5;
                } else if (value instanceof Double) {
                    i = 6;
                } else {
                    com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + value.getClass().toString());
                    i = 0;
                }
                if (i == 0) {
                    z = false;
                } else {
                    contentValues.put("type", Integer.valueOf(i));
                    contentValues.put("value", value.toString());
                    z = true;
                }
                if (z) {
                    this.f7941a.update(a.b.CONTENT_URI, contentValues, "key = ?", new String[]{entry.getKey()});
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.e.put(str, Boolean.valueOf(z));
            this.f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            this.e.put(str, Float.valueOf(f));
            this.f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            this.e.put(str, Integer.valueOf(i));
            this.f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            this.e.put(str, Long.valueOf(j));
            this.f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            this.e.put(str, str2);
            this.f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            this.f.add(str);
            return this;
        }
    }

    public a(Context context) {
        this.f7940a = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.f7940a.query(a.b.CONTENT_URI, this.b, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object a2 = query.moveToFirst() ? a.C1258a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return a2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        if (this.d == null) {
            this.d = new SharedPreferences$EditorC1254a(this.f7940a);
        }
        return this.d;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        try {
            Cursor query = this.f7940a.query(a.b.CONTENT_URI, this.b, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.c.put(query.getString(columnIndex), a.C1258a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.c;
        } catch (Exception e) {
            e.printStackTrace();
            return this.c;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f : ((Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
