package d.b.b;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a0 {

    /* renamed from: d  reason: collision with root package name */
    public static int f64239d;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, z> f64240e = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final i f64241a;

    /* renamed from: b  reason: collision with root package name */
    public final j f64242b;

    /* renamed from: c  reason: collision with root package name */
    public final a f64243c;

    /* loaded from: classes5.dex */
    public static class a extends SQLiteOpenHelper {
        public a(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i2) {
            super(context, str, cursorFactory, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (z zVar : a0.f64240e.values()) {
                    String j = zVar.j();
                    if (j != null) {
                        sQLiteDatabase.execSQL(j);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            } catch (Exception e2) {
                r0.b(e2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            onUpgrade(sQLiteDatabase, i2, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            r0.e("onUpgrade, " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<z> it = a0.f64240e.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().k());
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            } catch (Exception e2) {
                r0.b(e2);
            }
            onCreate(sQLiteDatabase);
        }
    }

    static {
        r0 = "SELECT * FROM " + i0.s + " WHERE event_name =?  AND monitor_status=?";
        String str = "UPDATE " + i0.s + " SET monitor_num =? WHERE event_name =? AND monitor_status =?";
        String str2 = "SELECT * FROM " + i0.s + " WHERE date<? ORDER BY local_time_ms LIMIT ?";
        String str3 = "DELETE FROM " + i0.s + " WHERE local_time_ms <= ?";
        h(new h0());
        h(new b0());
        h(new d0(null, false, null));
        h(new f0());
        h(new j0());
        h(new g0());
        h(new c0("", new JSONObject()));
        h(new i0());
    }

    public a0(Application application, j jVar, i iVar) {
        this.f64243c = new a(application, "bd_embed_tea_agent.db", null, 29);
        this.f64242b = jVar;
        this.f64241a = iVar;
    }

    public static void h(z zVar) {
        f64240e.put(zVar.k(), zVar);
    }

    public final int a(z[] zVarArr, int i2, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr) {
        int i3 = 0;
        while (i3 < i2) {
            jSONArrayArr[i3] = null;
            i3++;
        }
        int i4 = 200;
        while (i4 > 0 && i3 < zVarArr.length) {
            jSONArrayArr[i3] = f(sQLiteDatabase, zVarArr[i3], str, i4);
            i4 -= jSONArrayArr[i3].length();
            if (i4 > 0) {
                i3++;
            }
        }
        return i3;
    }

    public final String b(long j, int i2) {
        return "UPDATE pack SET _fail=" + i2 + " WHERE local_time_ms=" + j;
    }

    public final String c(z zVar, String str, int i2) {
        return "SELECT * FROM " + zVar.k() + " WHERE " + ETAG.KEY_STATISTICS_SEESIONID + "='" + str + "' ORDER BY local_time_ms LIMIT " + i2;
    }

    public final String d(z zVar, String str, long j) {
        return "DELETE FROM " + zVar.k() + " WHERE " + ETAG.KEY_STATISTICS_SEESIONID + "='" + str + "' AND local_time_ms<=" + j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        d.b.b.r0.a("queryPack, " + r0.size() + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + r0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
        if (r3 != null) goto L13;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<g0> e() {
        Cursor cursor;
        ArrayList<g0> arrayList = new ArrayList<>();
        g0 g0Var = (g0) f64240e.get("pack");
        try {
            cursor = this.f64243c.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2", null);
            while (cursor.moveToNext()) {
                try {
                    g0Var = (g0) g0Var.clone();
                    g0Var.a(cursor);
                    arrayList.add(g0Var);
                } catch (Throwable th) {
                    th = th;
                    try {
                        r0.b(th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public final JSONArray f(SQLiteDatabase sQLiteDatabase, z zVar, String str, int i2) {
        Cursor cursor;
        long j;
        JSONArray jSONArray = new JSONArray();
        long j2 = 0;
        try {
            cursor = sQLiteDatabase.rawQuery(c(zVar, str, i2), null);
            j = 0;
            while (cursor.moveToNext()) {
                try {
                    zVar.a(cursor);
                    if (r0.f64363b) {
                        r0.a("queryEvnetInner, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + zVar, null);
                    }
                    jSONArray.put(zVar.m());
                    if (zVar.f64413e > j) {
                        j = zVar.f64413e;
                    }
                } catch (Throwable th) {
                    th = th;
                    j2 = j;
                    try {
                        r0.b(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        j = j2;
                        r0.a("queryEvent, " + zVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONArray.length() + StringUtil.ARRAY_ELEMENT_SEPARATOR + j, null);
                        return jSONArray;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (j > 0) {
                sQLiteDatabase.execSQL(d(zVar, str, j));
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        r0.a("queryEvent, " + zVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONArray.length() + StringUtil.ARRAY_ELEMENT_SEPARATOR + j, null);
        return jSONArray;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r8 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
        if (r3.length() <= 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r6 <= 1000) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
        r6 = 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
        r13.m = r6;
        r13.f64415g = r12.f64415g;
        r13.f64413e = r12.f64413e;
        r13.n = (r12.f64413e + r6) / 1000;
        r13.f64414f = d.b.b.e2.a(r11.f64241a);
        r13.f64417i = r12.f64417i;
        r13.j = r12.j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
        if (d.b.b.r0.f64363b == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
        d.b.b.r0.a("queryPage, " + r13 + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + r3.length(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b9, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONArray g(f0 f0Var, j0 j0Var, h0 h0Var, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        boolean z = false;
        String[] strArr = {f0Var.f64415g};
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM page WHERE session_id=? LIMIT 500", strArr);
            while (cursor.moveToNext()) {
                try {
                    h0Var.a(cursor);
                    if (r0.f64363b) {
                        r0.a("queryPageInner, " + strArr + StringUtil.ARRAY_ELEMENT_SEPARATOR + h0Var, null);
                    }
                    if (h0Var.p()) {
                        jSONArray.put(h0Var.m());
                    } else {
                        j += h0Var.m;
                    }
                    z = true;
                } catch (Throwable th) {
                    th = th;
                    try {
                        r0.b(th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (z) {
                sQLiteDatabase.execSQL("DELETE FROM page WHERE session_id=?", strArr);
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public final void i(g0 g0Var, HashMap<String, Integer> hashMap, boolean z) {
    }

    public void j(@NonNull ArrayList<z> arrayList) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        r0.a("save, " + arrayList.toString(), null);
        try {
            try {
                sQLiteDatabase = this.f64243c.getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator<z> it = arrayList.iterator();
                    ContentValues contentValues = null;
                    while (it.hasNext()) {
                        z next = it.next();
                        String k = next.k();
                        contentValues = next.g(contentValues);
                        sQLiteDatabase.insert(k, null, contentValues);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        f64239d += arrayList.size();
                        r0.b(th);
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        return;
                    } catch (Throwable th3) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable th4) {
                                r0.b(th4);
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th5) {
                r0.b(th5);
                return;
            }
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.endTransaction();
        }
    }

    public void k(ArrayList<g0> arrayList, ArrayList<g0> arrayList2) {
        r0.a("setResult, " + arrayList + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList2, null);
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        HashMap<String, Integer> hashMap5 = new HashMap<>();
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).n == 0) {
                    i(arrayList.get(i2), hashMap, true);
                } else {
                    i(arrayList.get(i2), hashMap4, false);
                }
            }
        }
        Iterator<g0> it = arrayList2.iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            int i3 = next.n;
            if (i3 == 0) {
                HashMap<String, Integer> hashMap6 = (HashMap) hashMap2.get(Integer.valueOf(next.o));
                if (hashMap6 == null) {
                    hashMap6 = new HashMap<>();
                    hashMap2.put(Integer.valueOf(next.o), hashMap6);
                }
                i(next, hashMap6, false);
            } else if (i3 + 1 > 5) {
                i(next, hashMap3, false);
                arrayList.add(next);
                it.remove();
            } else {
                i(next, hashMap5, false);
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.f64243c.getWritableDatabase();
            writableDatabase.beginTransaction();
            Iterator<g0> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                writableDatabase.execSQL("DELETE FROM pack WHERE local_time_ms=?", new String[]{String.valueOf(it2.next().f64413e)});
            }
            Iterator<g0> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                g0 next2 = it3.next();
                long j = next2.f64413e;
                int i4 = next2.n + 1;
                next2.n = i4;
                writableDatabase.execSQL(b(j, i4));
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
        } catch (Exception e2) {
            r0.b(e2);
        }
    }

    public final boolean l(f0 f0Var, boolean z) {
        return !f0Var.p && z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:12|13|(7:(3:111|112|(22:114|16|17|18|(2:20|21)(1:110)|22|23|(2:25|26)(1:109)|27|28|(5:94|95|96|97|98)(2:30|31)|32|(3:34|(1:36)(1:38)|37)|39|40|41|42|43|(6:46|(2:53|54)|55|56|54|44)|57|58|59))|42|43|(1:44)|57|58|59)|15|16|17|18|(0)(0)|22|23|(0)(0)|27|28|(0)(0)|32|(0)|39|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0214, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0215, code lost:
        r8 = r43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0218, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0219, code lost:
        r8 = r43;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0293 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0280 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9 A[Catch: all -> 0x00af, Exception -> 0x00b5, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Exception -> 0x00b5, all -> 0x00af, blocks: (B:13:0x009f, B:26:0x00d9, B:32:0x00e6), top: B:147:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6 A[Catch: all -> 0x00af, Exception -> 0x00b5, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Exception -> 0x00b5, all -> 0x00af, blocks: (B:13:0x009f, B:26:0x00d9, B:32:0x00e6), top: B:147:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0183 A[Catch: all -> 0x0141, Exception -> 0x0143, TRY_ENTER, TryCatch #20 {Exception -> 0x0143, all -> 0x0141, blocks: (B:40:0x013d, B:56:0x0183, B:60:0x0196), top: B:139:0x013d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bc A[Catch: all -> 0x0251, Exception -> 0x0253, TryCatch #14 {Exception -> 0x0253, all -> 0x0251, blocks: (B:63:0x01b4, B:66:0x01bc, B:68:0x01d4, B:70:0x01d8, B:74:0x01e2, B:84:0x022a, B:85:0x023d), top: B:151:0x01b4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(JSONObject jSONObject) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        Throwable th2;
        Cursor cursor;
        JSONObject jSONObject2;
        JSONArray g2;
        SQLiteDatabase sQLiteDatabase2;
        ContentValues contentValues;
        z[] zVarArr;
        g0 g0Var;
        String str;
        h0 h0Var;
        j0 j0Var;
        int i2;
        f0 f0Var = (f0) f64240e.get("launch");
        j0 j0Var2 = (j0) f64240e.get("terminate");
        h0 h0Var2 = (h0) f64240e.get("page");
        d0 d0Var = (d0) f64240e.get("eventv3");
        b0 b0Var = (b0) f64240e.get("event");
        c0 c0Var = (c0) f64240e.get("event_misc");
        String str2 = "pack";
        g0 g0Var2 = (g0) f64240e.get("pack");
        ContentValues contentValues2 = new ContentValues();
        Cursor cursor2 = null;
        try {
            SQLiteDatabase writableDatabase = this.f64243c.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM launch ORDER BY local_time_ms DESC LIMIT 5", null);
                ContentValues contentValues3 = contentValues2;
                long j = Long.MIN_VALUE;
                long j2 = Long.MAX_VALUE;
                JSONObject jSONObject3 = jSONObject;
                while (true) {
                    try {
                        String str3 = str2;
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        f0Var.a(rawQuery);
                        if (TextUtils.equals(f0Var.f64415g, x1.h())) {
                            str2 = str3;
                        } else {
                            try {
                                if (TextUtils.equals(f0Var.n, this.f64242b.m())) {
                                    try {
                                        if (f0Var.m == this.f64242b.l()) {
                                            jSONObject2 = jSONObject3;
                                            h0 h0Var3 = h0Var2;
                                            long j3 = f0Var.f64413e >= j2 ? f0Var.f64413e : j2;
                                            long j4 = f0Var.f64413e <= j ? f0Var.f64413e : j;
                                            g2 = g(f0Var, j0Var2, h0Var3, writableDatabase);
                                            z[] zVarArr2 = {b0Var, d0Var, c0Var};
                                            JSONArray[] jSONArrayArr = new JSONArray[3];
                                            int a2 = a(zVarArr2, 0, writableDatabase, f0Var.f64415g, jSONArrayArr);
                                            if (g2.length() <= 0) {
                                                try {
                                                    long j5 = f0Var.f64413e;
                                                    JSONArray jSONArray = jSONArrayArr[0];
                                                    JSONArray jSONArray2 = jSONArrayArr[1];
                                                    JSONArray jSONArray3 = jSONArrayArr[2];
                                                    contentValues = contentValues3;
                                                    sQLiteDatabase2 = writableDatabase;
                                                    cursor = rawQuery;
                                                    zVarArr = zVarArr2;
                                                    g0Var = g0Var2;
                                                    str = str3;
                                                    h0Var = h0Var3;
                                                    j0Var = j0Var2;
                                                    try {
                                                        g0Var2.p(j5, jSONObject2, null, j0Var2, g2, jSONArray, jSONArray2, jSONArray3);
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        cursor2 = cursor;
                                                        sQLiteDatabase = sQLiteDatabase2;
                                                        try {
                                                            r0.b(e);
                                                            if (cursor2 != null) {
                                                                cursor2.close();
                                                            }
                                                            if (sQLiteDatabase != null) {
                                                                try {
                                                                    sQLiteDatabase.endTransaction();
                                                                } catch (Exception e3) {
                                                                    r0.b(e3);
                                                                }
                                                            }
                                                            return false;
                                                        } catch (Throwable th3) {
                                                            th2 = th3;
                                                            th = th2;
                                                            if (cursor2 != null) {
                                                                cursor2.close();
                                                            }
                                                            if (sQLiteDatabase != null) {
                                                                try {
                                                                    sQLiteDatabase.endTransaction();
                                                                } catch (Exception e4) {
                                                                    r0.b(e4);
                                                                }
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        th = th;
                                                        cursor2 = cursor;
                                                        sQLiteDatabase = sQLiteDatabase2;
                                                        if (cursor2 != null) {
                                                        }
                                                        if (sQLiteDatabase != null) {
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    sQLiteDatabase2 = writableDatabase;
                                                    cursor = rawQuery;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    sQLiteDatabase2 = writableDatabase;
                                                    cursor = rawQuery;
                                                }
                                            } else {
                                                contentValues = contentValues3;
                                                sQLiteDatabase2 = writableDatabase;
                                                cursor = rawQuery;
                                                zVarArr = zVarArr2;
                                                g0Var = g0Var2;
                                                h0Var = h0Var3;
                                                j0Var = j0Var2;
                                                str = str3;
                                                f0Var.o = true;
                                                g0Var.p(f0Var.f64413e, jSONObject2, f0Var, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                                            }
                                            if (r0.f64363b) {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("packer launch, ");
                                                sb.append(g2.length() <= 0);
                                                sb.append(", sid:");
                                                sb.append(f0Var.f64415g);
                                                r0.a(sb.toString(), null);
                                            }
                                            ContentValues g3 = g0Var.g(contentValues);
                                            sQLiteDatabase = sQLiteDatabase2;
                                            String str4 = str;
                                            String str5 = null;
                                            sQLiteDatabase.insert(str4, null, g3);
                                            ContentValues contentValues4 = g3;
                                            i2 = a2;
                                            while (i2 < 3) {
                                                g0 g0Var3 = g0Var;
                                                String str6 = str5;
                                                i2 = a(zVarArr, i2, sQLiteDatabase, f0Var.f64415g, jSONArrayArr);
                                                if (jSONArrayArr[0] == null && jSONArrayArr[1] == null && jSONArrayArr[2] == null) {
                                                    g0Var = g0Var3;
                                                    str5 = str6;
                                                }
                                                g0Var3.p(f0Var.f64413e, jSONObject2, null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                                                contentValues4 = g0Var3.g(contentValues4);
                                                sQLiteDatabase.insert(str4, str6, contentValues4);
                                                g0Var = g0Var3;
                                                str5 = str6;
                                            }
                                            g0Var2 = g0Var;
                                            str2 = str4;
                                            jSONObject3 = jSONObject2;
                                            j2 = j3;
                                            j = j4;
                                            h0Var2 = h0Var;
                                            j0Var2 = j0Var;
                                            writableDatabase = sQLiteDatabase;
                                            contentValues3 = contentValues4;
                                            rawQuery = cursor;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        sQLiteDatabase = writableDatabase;
                                        cursor2 = rawQuery;
                                        r0.b(e);
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        return false;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        sQLiteDatabase = writableDatabase;
                                        cursor2 = rawQuery;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                }
                                sQLiteDatabase.insert(str4, null, g3);
                                ContentValues contentValues42 = g3;
                                i2 = a2;
                                while (i2 < 3) {
                                }
                                g0Var2 = g0Var;
                                str2 = str4;
                                jSONObject3 = jSONObject2;
                                j2 = j3;
                                j = j4;
                                h0Var2 = h0Var;
                                j0Var2 = j0Var;
                                writableDatabase = sQLiteDatabase;
                                contentValues3 = contentValues42;
                                rawQuery = cursor;
                            } catch (Exception e7) {
                                e = e7;
                                cursor2 = cursor;
                                r0.b(e);
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                return false;
                            } catch (Throwable th7) {
                                th = th7;
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                            JSONObject jSONObject4 = new JSONObject();
                            s0.g(jSONObject4, jSONObject3);
                            jSONObject4.put("app_version", f0Var.n);
                            jSONObject4.put("version_code", f0Var.m);
                            jSONObject2 = jSONObject4;
                            h0 h0Var32 = h0Var2;
                            if (f0Var.f64413e >= j2) {
                            }
                            if (f0Var.f64413e <= j) {
                            }
                            g2 = g(f0Var, j0Var2, h0Var32, writableDatabase);
                            z[] zVarArr22 = {b0Var, d0Var, c0Var};
                            JSONArray[] jSONArrayArr2 = new JSONArray[3];
                            int a22 = a(zVarArr22, 0, writableDatabase, f0Var.f64415g, jSONArrayArr2);
                            if (g2.length() <= 0) {
                            }
                            if (r0.f64363b) {
                            }
                            ContentValues g32 = g0Var.g(contentValues);
                            sQLiteDatabase = sQLiteDatabase2;
                            String str42 = str;
                            String str52 = null;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        sQLiteDatabase = writableDatabase;
                        cursor = rawQuery;
                    } catch (Throwable th8) {
                        th = th8;
                        sQLiteDatabase = writableDatabase;
                        cursor = rawQuery;
                    }
                }
                sQLiteDatabase = writableDatabase;
                cursor = rawQuery;
                if (j2 != Long.MAX_VALUE && j != Long.MIN_VALUE) {
                    sQLiteDatabase.execSQL("DELETE FROM launch WHERE local_time_ms>=? AND local_time_ms<=?", new String[]{String.valueOf(j2), String.valueOf(j)});
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e9) {
                        r0.b(e9);
                    }
                }
                return true;
            } catch (Exception e10) {
                e = e10;
                sQLiteDatabase = writableDatabase;
            } catch (Throwable th9) {
                th2 = th9;
                sQLiteDatabase = writableDatabase;
                th = th2;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            sQLiteDatabase = null;
            cursor2 = null;
        } catch (Throwable th10) {
            th = th10;
            sQLiteDatabase = null;
            cursor2 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0090, code lost:
        if (r5[2].length() <= 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x012b, code lost:
        if (r5[0].length() <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x006e, code lost:
        if (r5[0].length() <= 0) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(JSONObject jSONObject, f0 f0Var, boolean z) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        z[] zVarArr;
        String str;
        ContentValues contentValues;
        SQLiteDatabase sQLiteDatabase2;
        int i2;
        g0 g0Var;
        String str2;
        g0 g0Var2;
        String str3;
        String str4;
        long currentTimeMillis;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        d0 d0Var = (d0) f64240e.get("eventv3");
        b0 b0Var = (b0) f64240e.get("event");
        c0 c0Var = (c0) f64240e.get("event_misc");
        g0 g0Var3 = (g0) f64240e.get("pack");
        ContentValues contentValues2 = new ContentValues();
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
            SQLiteDatabase writableDatabase = this.f64243c.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                z[] zVarArr2 = {b0Var, d0Var, c0Var};
                JSONArray[] jSONArrayArr = new JSONArray[3];
                char c2 = 1;
                int a2 = a(zVarArr2, 0, writableDatabase, f0Var.f64415g, jSONArrayArr);
                if (jSONArrayArr[0] != null) {
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        sQLiteDatabase3 = writableDatabase;
                        try {
                            r0.b(e);
                            if (sQLiteDatabase3 != null) {
                                try {
                                    sQLiteDatabase3.endTransaction();
                                } catch (Exception e3) {
                                    r0.b(e3);
                                }
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            if (sQLiteDatabase3 != null) {
                                try {
                                    sQLiteDatabase3.endTransaction();
                                } catch (Exception e4) {
                                    r0.b(e4);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        sQLiteDatabase3 = writableDatabase;
                        if (sQLiteDatabase3 != null) {
                        }
                        throw th;
                    }
                }
                try {
                    try {
                        if (jSONArrayArr[1] == null || jSONArrayArr[1].length() <= 0) {
                            if (jSONArrayArr[2] != null) {
                            }
                            if (!l(f0Var, z)) {
                                zVarArr = zVarArr2;
                                sQLiteDatabase2 = writableDatabase;
                                str2 = null;
                                g0Var = g0Var3;
                                str = "pack";
                                i2 = a2;
                                contentValues = contentValues2;
                                while (i2 < 3) {
                                    try {
                                        String str5 = str2;
                                        g0 g0Var4 = g0Var;
                                        SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
                                        try {
                                            i2 = a(zVarArr, i2, sQLiteDatabase2, f0Var.f64415g, jSONArrayArr);
                                            if (jSONArrayArr[0] != null) {
                                                try {
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    sQLiteDatabase3 = sQLiteDatabase4;
                                                    r0.b(e);
                                                    if (sQLiteDatabase3 != null) {
                                                    }
                                                    return false;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    sQLiteDatabase3 = sQLiteDatabase4;
                                                    if (sQLiteDatabase3 != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            sQLiteDatabase = sQLiteDatabase4;
                                            sQLiteDatabase3 = sQLiteDatabase;
                                            r0.b(e);
                                            if (sQLiteDatabase3 != null) {
                                            }
                                            return false;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            sQLiteDatabase = sQLiteDatabase4;
                                            th = th;
                                            sQLiteDatabase3 = sQLiteDatabase;
                                            if (sQLiteDatabase3 != null) {
                                            }
                                            throw th;
                                        }
                                        try {
                                            if (jSONArrayArr[c2] == null || jSONArrayArr[c2].length() <= 0) {
                                                g0Var2 = g0Var4;
                                                sQLiteDatabase = sQLiteDatabase4;
                                                str4 = str5;
                                                str3 = str;
                                                str = str3;
                                                g0Var = g0Var2;
                                                sQLiteDatabase2 = sQLiteDatabase;
                                                c2 = 1;
                                                str2 = str4;
                                            }
                                            g0Var4.p(currentTimeMillis, jSONObject, null, null, null, jSONArray, jSONArray2, jSONArrayArr[2]);
                                            contentValues = g0Var2.g(contentValues);
                                            sQLiteDatabase.insert(str3, str4, contentValues);
                                            str = str3;
                                            g0Var = g0Var2;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            c2 = 1;
                                            str2 = str4;
                                        } catch (Exception e7) {
                                            e = e7;
                                            sQLiteDatabase3 = sQLiteDatabase;
                                            r0.b(e);
                                            if (sQLiteDatabase3 != null) {
                                            }
                                            return false;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th = th;
                                            sQLiteDatabase3 = sQLiteDatabase;
                                            if (sQLiteDatabase3 != null) {
                                            }
                                            throw th;
                                        }
                                        currentTimeMillis = System.currentTimeMillis();
                                        jSONArray = jSONArrayArr[0];
                                        jSONArray2 = jSONArrayArr[c2];
                                        g0Var2 = g0Var4;
                                        sQLiteDatabase = sQLiteDatabase4;
                                        str4 = str5;
                                        str3 = str;
                                    } catch (Exception e8) {
                                        e = e8;
                                        sQLiteDatabase = sQLiteDatabase2;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        sQLiteDatabase = sQLiteDatabase2;
                                    }
                                }
                                sQLiteDatabase = sQLiteDatabase2;
                                sQLiteDatabase.setTransactionSuccessful();
                                if (sQLiteDatabase == null) {
                                    try {
                                        sQLiteDatabase.endTransaction();
                                        return true;
                                    } catch (Exception e9) {
                                        r0.b(e9);
                                        return true;
                                    }
                                }
                                return true;
                            }
                        }
                        g0Var3.p(System.currentTimeMillis(), jSONObject, l(f0Var, z) ? f0Var : null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                        ContentValues g2 = g0Var.g(contentValues2);
                        str = "pack";
                        sQLiteDatabase2.insert(str, null, g2);
                        if (r0.f64363b && l(f0Var, z)) {
                            r0.a("send launch, " + f0Var.f64415g + ", hadUI:" + z, null);
                        }
                        f0Var.p = true;
                        i2 = a2;
                        contentValues = g2;
                        while (i2 < 3) {
                        }
                        sQLiteDatabase = sQLiteDatabase2;
                        sQLiteDatabase.setTransactionSuccessful();
                        if (sQLiteDatabase == null) {
                        }
                    } catch (Exception e10) {
                        e = e10;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        r0.b(e);
                        if (sQLiteDatabase3 != null) {
                        }
                        return false;
                    } catch (Throwable th8) {
                        th = th8;
                        th = th;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        if (sQLiteDatabase3 != null) {
                        }
                        throw th;
                    }
                    zVarArr = zVarArr2;
                    sQLiteDatabase2 = writableDatabase;
                    str2 = null;
                    g0Var = g0Var3;
                } catch (Exception e11) {
                    e = e11;
                    sQLiteDatabase2 = writableDatabase;
                } catch (Throwable th9) {
                    th = th9;
                    sQLiteDatabase2 = writableDatabase;
                }
            } catch (Exception e12) {
                e = e12;
                sQLiteDatabase = writableDatabase;
            } catch (Throwable th10) {
                th = th10;
                sQLiteDatabase = writableDatabase;
            }
        } catch (Exception e13) {
            e = e13;
        } catch (Throwable th11) {
            th = th11;
            th = th;
            if (sQLiteDatabase3 != null) {
            }
            throw th;
        }
    }
}
