package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.sdk.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class a implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f36302a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f36303b = {"_id", "key", "type", "value"};

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Object> f36304c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences$EditorC0460a f36305d = null;

    /* renamed from: com.tencent.mm.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class SharedPreferences$EditorC0460a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public ContentResolver f36306a;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f36307e = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        public Set<String> f36308f = new HashSet();

        /* renamed from: g  reason: collision with root package name */
        public boolean f36309g = false;

        public SharedPreferences$EditorC0460a(ContentResolver contentResolver) {
            this.f36306a = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f36309g = true;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x003f A[SYNTHETIC] */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean commit() {
            String str;
            int i2;
            boolean z;
            ContentValues contentValues = new ContentValues();
            if (this.f36309g) {
                this.f36306a.delete(a.b.CONTENT_URI, null, null);
                this.f36309g = false;
            }
            Iterator<String> it = this.f36308f.iterator();
            while (it.hasNext()) {
                this.f36306a.delete(a.b.CONTENT_URI, "key = ?", new String[]{it.next()});
            }
            for (Map.Entry<String, Object> entry : this.f36307e.entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    str = "unresolve failed, null value";
                } else {
                    if (value instanceof Integer) {
                        i2 = 1;
                    } else if (value instanceof Long) {
                        i2 = 2;
                    } else if (value instanceof String) {
                        i2 = 3;
                    } else if (value instanceof Boolean) {
                        i2 = 4;
                    } else if (value instanceof Float) {
                        i2 = 5;
                    } else if (value instanceof Double) {
                        i2 = 6;
                    } else {
                        str = "unresolve failed, unknown type=" + value.getClass().toString();
                    }
                    if (i2 != 0) {
                        z = false;
                    } else {
                        contentValues.put("type", Integer.valueOf(i2));
                        contentValues.put("value", value.toString());
                        z = true;
                    }
                    if (!z) {
                        this.f36306a.update(a.b.CONTENT_URI, contentValues, "key = ?", new String[]{entry.getKey()});
                    }
                }
                com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", str);
                i2 = 0;
                if (i2 != 0) {
                }
                if (!z) {
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f36307e.put(str, Boolean.valueOf(z));
            this.f36308f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f2) {
            this.f36307e.put(str, Float.valueOf(f2));
            this.f36308f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i2) {
            this.f36307e.put(str, Integer.valueOf(i2));
            this.f36308f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            this.f36307e.put(str, Long.valueOf(j));
            this.f36308f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            this.f36307e.put(str, str2);
            this.f36308f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            this.f36308f.add(str);
            return this;
        }
    }

    public a(Context context) {
        this.f36302a = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.f36302a.query(a.b.CONTENT_URI, this.f36303b, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object a2 = query.moveToFirst() ? a.C0464a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        if (this.f36305d == null) {
            this.f36305d = new SharedPreferences$EditorC0460a(this.f36302a);
        }
        return this.f36305d;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        try {
            Cursor query = this.f36302a.query(a.b.CONTENT_URI, this.f36303b, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.f36304c.put(query.getString(columnIndex), a.C0464a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.f36304c;
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f36304c;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f2 : ((Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i2 : ((Integer) value).intValue();
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
