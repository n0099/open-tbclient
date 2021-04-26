package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f7a;

    /* renamed from: a  reason: collision with other field name */
    public b f9a;

    /* renamed from: a  reason: collision with other field name */
    public d f10a;

    /* renamed from: a  reason: collision with other field name */
    public String f11a;

    /* renamed from: b  reason: collision with root package name */
    public String f36963b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36964c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36965d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36966e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36967f;
    public Context mContext;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f36962a = null;

    /* renamed from: a  reason: collision with other field name */
    public b.a f8a = null;

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0177 A[Catch: Exception -> 0x0183, TRY_LEAVE, TryCatch #3 {Exception -> 0x0183, blocks: (B:78:0x0173, B:80:0x0177), top: B:92:0x0173 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(Context context, String str, String str2, boolean z, boolean z2) {
        long j;
        long j2;
        boolean z3;
        SharedPreferences sharedPreferences;
        this.f11a = "";
        this.f36963b = "";
        this.f36964c = false;
        this.f36965d = false;
        this.f36966e = false;
        String str3 = null;
        this.f7a = null;
        this.f9a = null;
        this.mContext = null;
        this.f10a = null;
        this.f36967f = false;
        this.f36964c = z;
        this.f36967f = z2;
        this.f11a = str2;
        this.f36963b = str;
        this.mContext = context;
        if (context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
            this.f7a = sharedPreferences2;
            j = sharedPreferences2.getLong("t", 0L);
        } else {
            j = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (f.isEmpty(str3)) {
            this.f36966e = false;
            this.f36965d = false;
        } else if (str3.equals("mounted")) {
            this.f36966e = true;
            this.f36965d = true;
        } else if (str3.equals("mounted_ro")) {
            this.f36965d = true;
            this.f36966e = false;
        } else {
            this.f36966e = false;
            this.f36965d = false;
        }
        try {
            if ((this.f36965d || this.f36966e) && context != null && !f.isEmpty(str)) {
                d a2 = a(str);
                this.f10a = a2;
                if (a2 != null) {
                    try {
                        b a3 = a2.a(str2, 0);
                        this.f9a = a3;
                        j2 = a3.getLong("t", 0L);
                    } catch (Exception unused) {
                    }
                    if (z2) {
                        long j3 = this.f7a.getLong("t2", 0L);
                        try {
                            j2 = this.f9a.getLong("t2", 0L);
                            int i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                            if (i2 < 0 && j3 > 0) {
                                a(this.f7a, this.f9a);
                                this.f9a = this.f10a.a(str2, 0);
                            } else if (i2 <= 0 || j2 <= 0) {
                                int i3 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
                                if (i3 == 0 && j2 > 0) {
                                    a(this.f9a, this.f7a);
                                    this.f7a = context.getSharedPreferences(str2, 0);
                                } else if (j2 == 0 && i3 > 0) {
                                    a(this.f7a, this.f9a);
                                    this.f9a = this.f10a.a(str2, 0);
                                } else if (i2 == 0) {
                                    a(this.f7a, this.f9a);
                                    this.f9a = this.f10a.a(str2, 0);
                                }
                            } else {
                                a(this.f9a, this.f7a);
                                this.f7a = context.getSharedPreferences(str2, 0);
                            }
                        } catch (Exception unused2) {
                        }
                        j = j3;
                    } else {
                        int i4 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i4 > 0) {
                            a(this.f7a, this.f9a);
                            this.f9a = this.f10a.a(str2, 0);
                        } else if (i4 >= 0) {
                            if (i4 == 0) {
                                a(this.f7a, this.f9a);
                                this.f9a = this.f10a.a(str2, 0);
                            }
                            if (j == j2 || (j == 0 && j2 == 0)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                z3 = this.f36967f;
                                if (z3 || (z3 && j == 0 && j2 == 0)) {
                                    sharedPreferences = this.f7a;
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putLong("t2", currentTimeMillis);
                                        edit.commit();
                                    }
                                    if (this.f9a != null) {
                                        b.a a4 = this.f9a.a();
                                        a4.a("t2", currentTimeMillis);
                                        a4.commit();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            a(this.f9a, this.f7a);
                            this.f7a = context.getSharedPreferences(str2, 0);
                        }
                    }
                    if (j == j2) {
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    z3 = this.f36967f;
                    if (z3) {
                    }
                    sharedPreferences = this.f7a;
                    if (sharedPreferences != null) {
                    }
                    if (this.f9a != null) {
                    }
                }
            }
            if (this.f9a != null) {
            }
        } catch (Exception unused3) {
            return;
        }
        j2 = 0;
        if (j == j2) {
        }
        long currentTimeMillis22 = System.currentTimeMillis();
        z3 = this.f36967f;
        if (z3) {
        }
        sharedPreferences = this.f7a;
        if (sharedPreferences != null) {
        }
    }

    private d a(String str) {
        File m47a = m47a(str);
        if (m47a != null) {
            d dVar = new d(m47a.getAbsolutePath());
            this.f10a = dVar;
            return dVar;
        }
        return null;
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m48b() {
        b bVar = this.f9a;
        if (bVar != null) {
            boolean m46a = bVar.m46a();
            if (!m46a) {
                commit();
            }
            return m46a;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(4:3|(1:7)|8|(9:10|11|(1:15)|16|17|18|19|(4:21|(2:23|(2:25|(3:27|(1:29)(1:31)|30))(2:32|(1:36)))|37|(3:43|44|(1:46)))|49))|54|11|(2:13|15)|16|17|18|19|(0)|49) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean commit() {
        boolean z;
        String str;
        Context context;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.f36962a;
        if (editor != null) {
            if (!this.f36967f && this.f7a != null) {
                editor.putLong("t", currentTimeMillis);
            }
            if (!this.f36962a.commit()) {
                z = false;
                if (this.f7a != null && (context = this.mContext) != null) {
                    this.f7a = context.getSharedPreferences(this.f11a, 0);
                }
                str = null;
                str = Environment.getExternalStorageState();
                if (!f.isEmpty(str)) {
                    if (str.equals("mounted")) {
                        if (this.f9a == null) {
                            d a2 = a(this.f36963b);
                            if (a2 != null) {
                                b a3 = a2.a(this.f11a, 0);
                                this.f9a = a3;
                                if (!this.f36967f) {
                                    a(this.f7a, a3);
                                } else {
                                    a(a3, this.f7a);
                                }
                                this.f8a = this.f9a.a();
                            }
                        } else {
                            b.a aVar = this.f8a;
                            if (aVar != null && !aVar.commit()) {
                                z = false;
                            }
                        }
                    }
                    if (str.equals("mounted") || (str.equals("mounted_ro") && this.f9a != null)) {
                        try {
                            if (this.f10a != null) {
                                this.f9a = this.f10a.a(this.f11a, 0);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                return z;
            }
        }
        z = true;
        if (this.f7a != null) {
            this.f7a = context.getSharedPreferences(this.f11a, 0);
        }
        str = null;
        str = Environment.getExternalStorageState();
        if (!f.isEmpty(str)) {
        }
        return z;
    }

    public String getString(String str) {
        m48b();
        SharedPreferences sharedPreferences = this.f7a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!f.isEmpty(string)) {
                return string;
            }
        }
        b bVar = this.f9a;
        return bVar != null ? bVar.getString(str, "") : "";
    }

    public void putString(String str, String str2) {
        if (f.isEmpty(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f36962a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f8a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) {
        if (f.isEmpty(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f36962a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f8a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m47a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f36962a == null && (sharedPreferences = this.f7a) != null) {
            this.f36962a = sharedPreferences.edit();
        }
        if (this.f36966e && this.f8a == null && (bVar = this.f9a) != null) {
            this.f8a = bVar.a();
        }
        m48b();
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        if (sharedPreferences == null || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        a2.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                a2.a(key, (String) value);
            } else if (value instanceof Integer) {
                a2.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                a2.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                a2.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                a2.a(key, ((Boolean) value).booleanValue());
            }
        }
        a2.commit();
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.clear();
        for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        edit.commit();
    }
}
