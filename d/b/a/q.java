package d.b.a;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static int f68840d;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, p> f68841e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final y1 f68842a;

    /* renamed from: b  reason: collision with root package name */
    public final z1 f68843b;

    /* renamed from: c  reason: collision with root package name */
    public final a f68844c;

    /* loaded from: classes8.dex */
    public static class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i2) {
            super(context, str, cursorFactory, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, cursorFactory, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.beginTransaction();
                    for (p pVar : q.f68841e.values()) {
                        String j = pVar.j();
                        if (j != null) {
                            sQLiteDatabase.execSQL(j);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    h0.b(e2);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                onUpgrade(sQLiteDatabase, i2, i3);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i2, i3) == null) {
                h0.e("onUpgrade, " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3, null);
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator<p> it = q.f68841e.values().iterator();
                    while (it.hasNext()) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().k());
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    h0.b(e2);
                }
                onCreate(sQLiteDatabase);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-125210564, "Ld/b/a/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-125210564, "Ld/b/a/q;");
                return;
            }
        }
        String str = "SELECT * FROM " + x.s + " WHERE event_name =?  AND monitor_status=?";
        String str2 = "UPDATE " + x.s + " SET monitor_num =? WHERE event_name =? AND monitor_status =?";
        String str3 = "SELECT * FROM " + x.s + " WHERE date<? ORDER BY local_time_ms LIMIT ?";
        String str4 = "DELETE FROM " + x.s + " WHERE local_time_ms <= ?";
        f68841e = new HashMap<>();
        h(new w());
        h(new r());
        h(new t(null, false, null));
        h(new u());
        h(new y());
        h(new v());
        h(new s("", new JSONObject()));
        h(new x());
    }

    public q(Application application, z1 z1Var, y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application, z1Var, y1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68844c = new a(application, "bd_embed_tea_agent.db", null, 29);
        this.f68843b = z1Var;
        this.f68842a = y1Var;
    }

    public static void h(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pVar) == null) {
            f68841e.put(pVar.k(), pVar);
        }
    }

    public final int a(p[] pVarArr, int i2, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{pVarArr, Integer.valueOf(i2), sQLiteDatabase, str, jSONArrayArr})) == null) {
            int i3 = 0;
            while (i3 < i2) {
                jSONArrayArr[i3] = null;
                i3++;
            }
            int i4 = 200;
            while (i4 > 0 && i3 < pVarArr.length) {
                jSONArrayArr[i3] = f(sQLiteDatabase, pVarArr[i3], str, i4);
                i4 -= jSONArrayArr[i3].length();
                if (i4 > 0) {
                    i3++;
                }
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public final String b(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            return "UPDATE pack SET _fail=" + i2 + " WHERE local_time_ms=" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public final String c(p pVar, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, pVar, str, i2)) == null) {
            return "SELECT * FROM " + pVar.k() + " WHERE session_id='" + str + "' ORDER BY local_time_ms LIMIT " + i2;
        }
        return (String) invokeLLI.objValue;
    }

    public final String d(p pVar, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{pVar, str, Long.valueOf(j)})) == null) {
            return "DELETE FROM " + pVar.k() + " WHERE session_id='" + str + "' AND local_time_ms<=" + j;
        }
        return (String) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r3 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        d.b.a.h0.a("queryPack, " + r0.size() + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + r0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
        return r0;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<v> e() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return (ArrayList) invokeV.objValue;
        }
        ArrayList<v> arrayList = new ArrayList<>();
        v vVar = (v) f68841e.get("pack");
        try {
            cursor = this.f68844c.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2", null);
            while (cursor.moveToNext()) {
                try {
                    vVar = (v) vVar.clone();
                    vVar.a(cursor);
                    arrayList.add(vVar);
                } catch (Throwable th) {
                    th = th;
                    try {
                        h0.b(th);
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

    public final JSONArray f(SQLiteDatabase sQLiteDatabase, p pVar, String str, int i2) {
        InterceptResult invokeLLLI;
        Cursor cursor;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048581, this, sQLiteDatabase, pVar, str, i2)) == null) {
            JSONArray jSONArray = new JSONArray();
            long j2 = 0;
            try {
                cursor = sQLiteDatabase.rawQuery(c(pVar, str, i2), null);
                j = 0;
                while (cursor.moveToNext()) {
                    try {
                        pVar.a(cursor);
                        if (h0.f68780b) {
                            h0.a("queryEvnetInner, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + pVar, null);
                        }
                        jSONArray.put(pVar.m());
                        if (pVar.f68823e > j) {
                            j = pVar.f68823e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        j2 = j;
                        try {
                            h0.b(th);
                            if (cursor != null) {
                                cursor.close();
                            }
                            j = j2;
                            h0.a("queryEvent, " + pVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONArray.length() + StringUtil.ARRAY_ELEMENT_SEPARATOR + j, null);
                            return jSONArray;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (j > 0) {
                    sQLiteDatabase.execSQL(d(pVar, str, j));
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            h0.a("queryEvent, " + pVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONArray.length() + StringUtil.ARRAY_ELEMENT_SEPARATOR + j, null);
            return jSONArray;
        }
        return (JSONArray) invokeLLLI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
        if (r8 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (r3.length() <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        if (r6 <= 1000) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
        r6 = 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
        r13.m = r6;
        r13.f68825g = r12.f68825g;
        r13.f68823e = r12.f68823e;
        r13.n = (r12.f68823e + r6) / 1000;
        r13.f68824f = d.b.a.p1.a(r11.f68842a);
        r13.f68827i = r12.f68827i;
        r13.j = r12.j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
        if (d.b.a.h0.f68780b == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009f, code lost:
        d.b.a.h0.a("queryPage, " + r13 + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + r3.length(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bd, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONArray g(u uVar, y yVar, w wVar, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(1048582, this, uVar, yVar, wVar, sQLiteDatabase)) != null) {
            return (JSONArray) invokeLLLL.objValue;
        }
        boolean z = false;
        String[] strArr = {uVar.f68825g};
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM page WHERE session_id=? LIMIT 500", strArr);
            while (cursor.moveToNext()) {
                try {
                    wVar.a(cursor);
                    if (h0.f68780b) {
                        h0.a("queryPageInner, " + strArr + StringUtil.ARRAY_ELEMENT_SEPARATOR + wVar, null);
                    }
                    if (wVar.p()) {
                        jSONArray.put(wVar.m());
                    } else {
                        j += wVar.m;
                    }
                    z = true;
                } catch (Throwable th) {
                    th = th;
                    try {
                        h0.b(th);
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

    public final void i(v vVar, HashMap<String, Integer> hashMap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, vVar, hashMap, z) == null) {
        }
    }

    public void j(@NonNull ArrayList<p> arrayList) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            h0.a("save, " + arrayList.toString(), null);
            try {
                try {
                    sQLiteDatabase = this.f68844c.getWritableDatabase();
                    try {
                        sQLiteDatabase.beginTransaction();
                        Iterator<p> it = arrayList.iterator();
                        ContentValues contentValues = null;
                        while (it.hasNext()) {
                            p next = it.next();
                            String k = next.k();
                            contentValues = next.g(contentValues);
                            sQLiteDatabase.insert(k, null, contentValues);
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            f68840d += arrayList.size();
                            h0.b(th);
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            return;
                        } catch (Throwable th3) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Throwable th4) {
                                    h0.b(th4);
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th5) {
                    h0.b(th5);
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
    }

    public void k(ArrayList<v> arrayList, ArrayList<v> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, arrayList, arrayList2) == null) {
            h0.a("setResult, " + arrayList + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList2, null);
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
            Iterator<v> it = arrayList2.iterator();
            while (it.hasNext()) {
                v next = it.next();
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
                SQLiteDatabase writableDatabase = this.f68844c.getWritableDatabase();
                writableDatabase.beginTransaction();
                Iterator<v> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    writableDatabase.execSQL("DELETE FROM pack WHERE local_time_ms=?", new String[]{String.valueOf(it2.next().f68823e)});
                }
                Iterator<v> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    v next2 = it3.next();
                    long j = next2.f68823e;
                    int i4 = next2.n + 1;
                    next2.n = i4;
                    writableDatabase.execSQL(b(j, i4));
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
            } catch (Exception e2) {
                h0.b(e2);
            }
        }
    }

    public final boolean l(u uVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, uVar, z)) == null) ? !uVar.p && z : invokeLZ.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0297 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0284 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd A[Catch: all -> 0x00b3, Exception -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x00b9, all -> 0x00b3, blocks: (B:15:0x00a3, B:28:0x00dd, B:34:0x00ea), top: B:155:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea A[Catch: all -> 0x00b3, Exception -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x00b9, all -> 0x00b3, blocks: (B:15:0x00a3, B:28:0x00dd, B:34:0x00ea), top: B:155:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0187 A[Catch: all -> 0x0145, Exception -> 0x0147, TRY_ENTER, TryCatch #19 {Exception -> 0x0147, all -> 0x0145, blocks: (B:42:0x0141, B:58:0x0187, B:62:0x019a), top: B:147:0x0141 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c0 A[Catch: all -> 0x0255, Exception -> 0x0257, TryCatch #18 {Exception -> 0x0257, all -> 0x0255, blocks: (B:65:0x01b8, B:68:0x01c0, B:70:0x01d8, B:72:0x01dc, B:76:0x01e6, B:86:0x022e, B:87:0x0241), top: B:149:0x01b8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        Throwable th2;
        Cursor cursor;
        JSONObject jSONObject2;
        JSONArray g2;
        SQLiteDatabase sQLiteDatabase2;
        ContentValues contentValues;
        p[] pVarArr;
        v vVar;
        String str;
        w wVar;
        y yVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048587, this, jSONObject)) != null) {
            return invokeL.booleanValue;
        }
        u uVar = (u) f68841e.get("launch");
        y yVar2 = (y) f68841e.get("terminate");
        w wVar2 = (w) f68841e.get("page");
        t tVar = (t) f68841e.get("eventv3");
        r rVar = (r) f68841e.get("event");
        s sVar = (s) f68841e.get("event_misc");
        String str2 = "pack";
        v vVar2 = (v) f68841e.get("pack");
        ContentValues contentValues2 = new ContentValues();
        Cursor cursor2 = null;
        try {
            SQLiteDatabase writableDatabase = this.f68844c.getWritableDatabase();
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
                        uVar.a(rawQuery);
                        if (TextUtils.equals(uVar.f68825g, j1.l())) {
                            str2 = str3;
                        } else {
                            try {
                                try {
                                    if (TextUtils.equals(uVar.n, this.f68843b.p())) {
                                        try {
                                            if (uVar.m == this.f68843b.n()) {
                                                jSONObject2 = jSONObject3;
                                                w wVar3 = wVar2;
                                                long j3 = uVar.f68823e >= j2 ? uVar.f68823e : j2;
                                                long j4 = uVar.f68823e <= j ? uVar.f68823e : j;
                                                g2 = g(uVar, yVar2, wVar3, writableDatabase);
                                                p[] pVarArr2 = {rVar, tVar, sVar};
                                                JSONArray[] jSONArrayArr = new JSONArray[3];
                                                int a2 = a(pVarArr2, 0, writableDatabase, uVar.f68825g, jSONArrayArr);
                                                if (g2.length() <= 0) {
                                                    try {
                                                        long j5 = uVar.f68823e;
                                                        JSONArray jSONArray = jSONArrayArr[0];
                                                        JSONArray jSONArray2 = jSONArrayArr[1];
                                                        JSONArray jSONArray3 = jSONArrayArr[2];
                                                        contentValues = contentValues3;
                                                        sQLiteDatabase2 = writableDatabase;
                                                        cursor = rawQuery;
                                                        pVarArr = pVarArr2;
                                                        vVar = vVar2;
                                                        str = str3;
                                                        wVar = wVar3;
                                                        yVar = yVar2;
                                                        try {
                                                            vVar2.p(j5, jSONObject2, null, yVar2, g2, jSONArray, jSONArray2, jSONArray3);
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            cursor2 = cursor;
                                                            sQLiteDatabase = sQLiteDatabase2;
                                                            try {
                                                                h0.b(e);
                                                                if (cursor2 != null) {
                                                                    cursor2.close();
                                                                }
                                                                if (sQLiteDatabase != null) {
                                                                    try {
                                                                        sQLiteDatabase.endTransaction();
                                                                    } catch (Exception e3) {
                                                                        h0.b(e3);
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
                                                                        h0.b(e4);
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
                                                    pVarArr = pVarArr2;
                                                    vVar = vVar2;
                                                    wVar = wVar3;
                                                    yVar = yVar2;
                                                    str = str3;
                                                    uVar.o = true;
                                                    vVar.p(uVar.f68823e, jSONObject2, uVar, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                                                }
                                                if (h0.f68780b) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("packer launch, ");
                                                    sb.append(g2.length() <= 0);
                                                    sb.append(", sid:");
                                                    sb.append(uVar.f68825g);
                                                    h0.a(sb.toString(), null);
                                                }
                                                ContentValues g3 = vVar.g(contentValues);
                                                sQLiteDatabase = sQLiteDatabase2;
                                                String str4 = str;
                                                String str5 = null;
                                                sQLiteDatabase.insert(str4, null, g3);
                                                ContentValues contentValues4 = g3;
                                                i2 = a2;
                                                while (i2 < 3) {
                                                    v vVar3 = vVar;
                                                    String str6 = str5;
                                                    i2 = a(pVarArr, i2, sQLiteDatabase, uVar.f68825g, jSONArrayArr);
                                                    if (jSONArrayArr[0] == null && jSONArrayArr[1] == null && jSONArrayArr[2] == null) {
                                                        vVar = vVar3;
                                                        str5 = str6;
                                                    }
                                                    vVar3.p(uVar.f68823e, jSONObject2, null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                                                    contentValues4 = vVar3.g(contentValues4);
                                                    sQLiteDatabase.insert(str4, str6, contentValues4);
                                                    vVar = vVar3;
                                                    str5 = str6;
                                                }
                                                vVar2 = vVar;
                                                str2 = str4;
                                                jSONObject3 = jSONObject2;
                                                j2 = j3;
                                                j = j4;
                                                wVar2 = wVar;
                                                yVar2 = yVar;
                                                writableDatabase = sQLiteDatabase;
                                                contentValues3 = contentValues4;
                                                rawQuery = cursor;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            sQLiteDatabase = writableDatabase;
                                            cursor2 = rawQuery;
                                            h0.b(e);
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
                                    vVar2 = vVar;
                                    str2 = str4;
                                    jSONObject3 = jSONObject2;
                                    j2 = j3;
                                    j = j4;
                                    wVar2 = wVar;
                                    yVar2 = yVar;
                                    writableDatabase = sQLiteDatabase;
                                    contentValues3 = contentValues42;
                                    rawQuery = cursor;
                                } catch (Exception e7) {
                                    e = e7;
                                    cursor2 = cursor;
                                    h0.b(e);
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
                                ContentValues g32 = vVar.g(contentValues);
                                sQLiteDatabase = sQLiteDatabase2;
                                String str42 = str;
                                String str52 = null;
                            } catch (Exception e8) {
                                e = e8;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor2 = cursor;
                                h0.b(e);
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                return false;
                            } catch (Throwable th8) {
                                th = th8;
                                sQLiteDatabase = sQLiteDatabase2;
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                            JSONObject jSONObject4 = new JSONObject();
                            i0.h(jSONObject4, jSONObject3);
                            jSONObject4.put("app_version", uVar.n);
                            jSONObject4.put("version_code", uVar.m);
                            jSONObject2 = jSONObject4;
                            w wVar32 = wVar2;
                            if (uVar.f68823e >= j2) {
                            }
                            if (uVar.f68823e <= j) {
                            }
                            g2 = g(uVar, yVar2, wVar32, writableDatabase);
                            p[] pVarArr22 = {rVar, tVar, sVar};
                            JSONArray[] jSONArrayArr2 = new JSONArray[3];
                            int a22 = a(pVarArr22, 0, writableDatabase, uVar.f68825g, jSONArrayArr2);
                            if (g2.length() <= 0) {
                            }
                            if (h0.f68780b) {
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        sQLiteDatabase = writableDatabase;
                        cursor = rawQuery;
                    } catch (Throwable th9) {
                        th = th9;
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
                    } catch (Exception e10) {
                        h0.b(e10);
                    }
                }
                return true;
            } catch (Exception e11) {
                e = e11;
                sQLiteDatabase = writableDatabase;
            } catch (Throwable th10) {
                th2 = th10;
                sQLiteDatabase = writableDatabase;
                th = th2;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            sQLiteDatabase = null;
            cursor2 = null;
        } catch (Throwable th11) {
            th = th11;
            sQLiteDatabase = null;
            cursor2 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
        if (r5[2].length() <= 0) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012f, code lost:
        if (r5[0].length() <= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0072, code lost:
        if (r5[0].length() <= 0) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(JSONObject jSONObject, u uVar, boolean z) {
        InterceptResult invokeLLZ;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        p[] pVarArr;
        String str;
        ContentValues contentValues;
        SQLiteDatabase sQLiteDatabase2;
        int i2;
        v vVar;
        String str2;
        String str3;
        v vVar2;
        SQLiteDatabase sQLiteDatabase3;
        v vVar3;
        String str4;
        String str5;
        long currentTimeMillis;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(1048588, this, jSONObject, uVar, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        t tVar = (t) f68841e.get("eventv3");
        r rVar = (r) f68841e.get("event");
        s sVar = (s) f68841e.get("event_misc");
        v vVar4 = (v) f68841e.get("pack");
        ContentValues contentValues2 = new ContentValues();
        SQLiteDatabase sQLiteDatabase4 = null;
        try {
            SQLiteDatabase writableDatabase = this.f68844c.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                p[] pVarArr2 = {rVar, tVar, sVar};
                JSONArray[] jSONArrayArr = new JSONArray[3];
                char c2 = 1;
                int a2 = a(pVarArr2, 0, writableDatabase, uVar.f68825g, jSONArrayArr);
                if (jSONArrayArr[0] != null) {
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        sQLiteDatabase4 = writableDatabase;
                        try {
                            h0.b(e);
                            if (sQLiteDatabase4 != null) {
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            if (sQLiteDatabase4 != null) {
                                try {
                                    sQLiteDatabase4.endTransaction();
                                } catch (Exception e3) {
                                    h0.b(e3);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        sQLiteDatabase4 = writableDatabase;
                        if (sQLiteDatabase4 != null) {
                        }
                        throw th;
                    }
                }
                try {
                    try {
                        if (jSONArrayArr[1] == null || jSONArrayArr[1].length() <= 0) {
                            if (jSONArrayArr[2] != null) {
                            }
                            if (!l(uVar, z)) {
                                pVarArr = pVarArr2;
                                sQLiteDatabase2 = writableDatabase;
                                str2 = null;
                                vVar = vVar4;
                                str = "pack";
                                i2 = a2;
                                contentValues = contentValues2;
                                while (i2 < 3) {
                                    try {
                                        str3 = str2;
                                        vVar2 = vVar;
                                        sQLiteDatabase3 = sQLiteDatabase2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        sQLiteDatabase = sQLiteDatabase2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        sQLiteDatabase = sQLiteDatabase2;
                                    }
                                    try {
                                        i2 = a(pVarArr, i2, sQLiteDatabase2, uVar.f68825g, jSONArrayArr);
                                        if (jSONArrayArr[0] != null) {
                                            try {
                                            } catch (Exception e5) {
                                                e = e5;
                                                sQLiteDatabase4 = sQLiteDatabase3;
                                                h0.b(e);
                                                if (sQLiteDatabase4 != null) {
                                                    try {
                                                        sQLiteDatabase4.endTransaction();
                                                    } catch (Exception e6) {
                                                        h0.b(e6);
                                                    }
                                                }
                                                return false;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                sQLiteDatabase4 = sQLiteDatabase3;
                                                if (sQLiteDatabase4 != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                        try {
                                            if (jSONArrayArr[c2] == null || jSONArrayArr[c2].length() <= 0) {
                                                vVar3 = vVar2;
                                                sQLiteDatabase = sQLiteDatabase3;
                                                str5 = str3;
                                                str4 = str;
                                                str = str4;
                                                vVar = vVar3;
                                                sQLiteDatabase2 = sQLiteDatabase;
                                                c2 = 1;
                                                str2 = str5;
                                            }
                                            vVar2.p(currentTimeMillis, jSONObject, null, null, null, jSONArray, jSONArray2, jSONArrayArr[2]);
                                            contentValues = vVar3.g(contentValues);
                                            sQLiteDatabase.insert(str4, str5, contentValues);
                                            str = str4;
                                            vVar = vVar3;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            c2 = 1;
                                            str2 = str5;
                                        } catch (Exception e7) {
                                            e = e7;
                                            sQLiteDatabase4 = sQLiteDatabase;
                                            h0.b(e);
                                            if (sQLiteDatabase4 != null) {
                                            }
                                            return false;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th = th;
                                            sQLiteDatabase4 = sQLiteDatabase;
                                            if (sQLiteDatabase4 != null) {
                                            }
                                            throw th;
                                        }
                                        currentTimeMillis = System.currentTimeMillis();
                                        jSONArray = jSONArrayArr[0];
                                        jSONArray2 = jSONArrayArr[c2];
                                        vVar3 = vVar2;
                                        sQLiteDatabase = sQLiteDatabase3;
                                        str5 = str3;
                                        str4 = str;
                                    } catch (Exception e8) {
                                        e = e8;
                                        sQLiteDatabase = sQLiteDatabase3;
                                        sQLiteDatabase4 = sQLiteDatabase;
                                        h0.b(e);
                                        if (sQLiteDatabase4 != null) {
                                        }
                                        return false;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        sQLiteDatabase = sQLiteDatabase3;
                                        th = th;
                                        sQLiteDatabase4 = sQLiteDatabase;
                                        if (sQLiteDatabase4 != null) {
                                        }
                                        throw th;
                                    }
                                }
                                sQLiteDatabase = sQLiteDatabase2;
                                sQLiteDatabase.setTransactionSuccessful();
                                if (sQLiteDatabase == null) {
                                    try {
                                        sQLiteDatabase.endTransaction();
                                        return true;
                                    } catch (Exception e9) {
                                        h0.b(e9);
                                        return true;
                                    }
                                }
                                return true;
                            }
                        }
                        vVar4.p(System.currentTimeMillis(), jSONObject, l(uVar, z) ? uVar : null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                        ContentValues g2 = vVar.g(contentValues2);
                        str = "pack";
                        sQLiteDatabase2.insert(str, null, g2);
                        if (h0.f68780b && l(uVar, z)) {
                            h0.a("send launch, " + uVar.f68825g + ", hadUI:" + z, null);
                        }
                        uVar.p = true;
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
                        sQLiteDatabase4 = sQLiteDatabase2;
                        h0.b(e);
                        if (sQLiteDatabase4 != null) {
                        }
                        return false;
                    } catch (Throwable th8) {
                        th = th8;
                        th = th;
                        sQLiteDatabase4 = sQLiteDatabase2;
                        if (sQLiteDatabase4 != null) {
                        }
                        throw th;
                    }
                    pVarArr = pVarArr2;
                    sQLiteDatabase2 = writableDatabase;
                    str2 = null;
                    vVar = vVar4;
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
            if (sQLiteDatabase4 != null) {
            }
            throw th;
        }
    }
}
