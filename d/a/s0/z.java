package d.a.s0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class z extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f68155e;

    /* renamed from: f  reason: collision with root package name */
    public static z f68156f;

    /* renamed from: g  reason: collision with root package name */
    public static ReentrantLock f68157g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f68158a;

    /* renamed from: b  reason: collision with root package name */
    public b f68159b;

    /* renamed from: c  reason: collision with root package name */
    public Context f68160c;

    /* renamed from: d  reason: collision with root package name */
    public ReentrantReadWriteLock f68161d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457472114, "Ld/a/s0/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-457472114, "Ld/a/s0/z;");
                return;
            }
        }
        f68155e = AppConfig.isDebug();
        f68156f = null;
        f68157g = new ReentrantLock();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 7);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68161d = new ReentrantReadWriteLock(true);
        this.f68159b = new b(context);
        this.f68160c = context;
    }

    public static z D(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f68156f == null) {
                f68157g.lock();
                if (f68156f == null) {
                    f68156f = new z(context);
                }
                f68157g.unlock();
            }
            return f68156f;
        }
        return (z) invokeL.objValue;
    }

    public final void A(ArrayList<q> arrayList, i0 i0Var) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, arrayList, i0Var) == null) {
            String str4 = "begintime";
            String str5 = " , ";
            String str6 = "eventid";
            this.f68161d.readLock().lock();
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    try {
                        Iterator<q> it = arrayList.iterator();
                        Cursor cursor = null;
                        while (it.hasNext()) {
                            q next = it.next();
                            if (next.f() >= 0) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("id", next.g());
                                jSONObject.put("starttime", Long.toString(next.a()));
                                jSONObject.put("endtime", Long.toString(next.d()));
                                jSONObject.put("type", "1");
                                g m = g.m();
                                jSONObject.put(Constant.IS_REAL, m.z(next.g()) ? "1" : "0");
                                String l = m.l(next.g());
                                if (!TextUtils.isEmpty(l) && !TextUtils.equals(l, "0")) {
                                    jSONObject.put("gflow", l);
                                }
                                if (!TextUtils.isEmpty(next.c())) {
                                    jSONObject.put("content", next.c());
                                }
                                if (!TextUtils.isEmpty(next.e())) {
                                    jSONObject.put("abtest", next.e());
                                    i0Var.q("1");
                                }
                                if (!TextUtils.isEmpty(next.b())) {
                                    jSONObject.put("c", next.b());
                                }
                                if (next.j() != null) {
                                    jSONObject.put("part", next.j());
                                }
                                if (next.l()) {
                                    jSONObject.put("of", "1");
                                }
                                jSONObject.put(Constant.ID_TYPE, m.r(next.g()));
                                JSONArray jSONArray = new JSONArray();
                                StringBuilder sb = new StringBuilder(256);
                                sb.append("SELECT ");
                                sb.append(str6);
                                sb.append(str5);
                                sb.append(str4);
                                sb.append(str5);
                                sb.append("content");
                                sb.append(" FROM ");
                                sb.append("event");
                                sb.append(" WHERE ");
                                sb.append("flowhandle");
                                sb.append(" = ");
                                sb.append(next.f());
                                try {
                                    cursor = readableDatabase.rawQuery(sb.toString(), null);
                                    if (cursor == null || cursor.getCount() <= 0) {
                                        str = str4;
                                        str2 = str5;
                                        str3 = str6;
                                    } else {
                                        cursor.moveToFirst();
                                        int columnIndex = cursor.getColumnIndex(str6);
                                        int columnIndex2 = cursor.getColumnIndex(str4);
                                        int columnIndex3 = cursor.getColumnIndex("content");
                                        str = str4;
                                        while (true) {
                                            JSONObject jSONObject2 = new JSONObject();
                                            str2 = str5;
                                            jSONObject2.put("id", cursor.getString(columnIndex));
                                            str3 = str6;
                                            jSONObject2.put("timestamp", Long.toString(cursor.getLong(columnIndex2)));
                                            jSONObject2.put("content", cursor.getString(columnIndex3));
                                            jSONArray.put(jSONObject2);
                                            if (!cursor.moveToNext()) {
                                                break;
                                            }
                                            str5 = str2;
                                            str6 = str3;
                                        }
                                        jSONObject.put("eventlist", jSONArray);
                                    }
                                    Closeables.closeSafely(cursor);
                                    i0Var.a(jSONObject);
                                } finally {
                                }
                            } else {
                                str = str4;
                                str2 = str5;
                                str3 = str6;
                            }
                            str4 = str;
                            str5 = str2;
                            str6 = str3;
                        }
                    } catch (RuntimeException e2) {
                        if (f68155e) {
                            e2.printStackTrace();
                        }
                    } catch (JSONException unused) {
                        if (f68155e) {
                            Log.d("UBCDatabaseHelper", "json exception:");
                        }
                    }
                } catch (SQLException e3) {
                    if (f68155e) {
                        e3.printStackTrace();
                    }
                    this.f68159b.h(e3);
                }
            } finally {
                this.f68161d.readLock().unlock();
            }
        }
    }

    public final String B(ArrayList<j> arrayList, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, z)) == null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                j jVar = arrayList.get(i3);
                if (z && !"0".equals(jVar.b())) {
                    if (i2 > 0) {
                        sb.append(",");
                    } else {
                        i2++;
                    }
                    sb.append(jVar.a());
                } else if (!z && "0".equals(jVar.b())) {
                    if (i2 > 0) {
                        sb.append(",");
                    } else {
                        i2++;
                    }
                    sb.append(jVar.a());
                }
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public final String C(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(arrayList.get(i2));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public int E(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, i0Var)) == null) {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * FROM ");
            sb.append("event");
            sb.append(" WHERE ");
            sb.append("flowhandle");
            sb.append(" = ");
            sb.append(-1);
            sb.append(" AND ");
            sb.append("reallog");
            sb.append(" = \"1\"");
            return x(sb.toString(), i0Var);
        }
        return invokeL.intValue;
    }

    public p F(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f68161d.readLock().lock();
            p pVar = null;
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT state , reserve1 FROM file WHERE filename=\"" + str + "\"", null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    pVar = new p(str, cursor.getString(cursor.getColumnIndex("state")), cursor.isNull(cursor.getColumnIndex("reserve1")) ? "" : cursor.getString(cursor.getColumnIndex("reserve1")));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                if (f68155e) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                return pVar;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Cursor) null);
                        throw th;
                    }
                    Closeables.closeSafely(cursor);
                } catch (SQLException e4) {
                    if (f68155e) {
                        e4.printStackTrace();
                    }
                    this.f68159b.h(e4);
                }
                return pVar;
            } finally {
                this.f68161d.readLock().unlock();
            }
        }
        return (p) invokeL.objValue;
    }

    public void G(SparseArray<ArrayList> sparseArray) {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sparseArray) == null) {
            this.f68161d.readLock().lock();
            try {
                try {
                    readableDatabase = getReadableDatabase();
                    cursor = null;
                } catch (SQLException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                    this.f68159b.h(e2);
                }
                try {
                    try {
                        cursor = readableDatabase.rawQuery("SELECT eventid , type , cycle FROM config WHERE " + SetImageWatermarkTypeReqMsg.SWITCH + "=\"1\" AND (reallog = \"0\" OR reallog = \"\")", null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("eventid");
                            int columnIndex2 = cursor.getColumnIndex("type");
                            int columnIndex3 = cursor.getColumnIndex("cycle");
                            do {
                                String string = cursor.getString(columnIndex);
                                String string2 = cursor.getString(columnIndex2);
                                int i2 = cursor.getInt(columnIndex3);
                                if (i2 != 0) {
                                    if (i2 < 6) {
                                        i2 = 6;
                                    } else if (i2 > 720) {
                                        i2 = 720;
                                    }
                                }
                                if (string != null) {
                                    ArrayList arrayList = sparseArray.get(i2);
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                        sparseArray.put(i2, arrayList);
                                    }
                                    arrayList.add(new j(string, string2));
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (RuntimeException e3) {
                        if (f68155e) {
                            e3.printStackTrace();
                        }
                    }
                } finally {
                    Closeables.closeSafely(cursor);
                }
            } finally {
                this.f68161d.readLock().unlock();
            }
        }
    }

    public void H(f fVar) {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        f fVar2;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            z zVar = this;
            zVar.f68161d.readLock().lock();
            try {
                try {
                    readableDatabase = getReadableDatabase();
                    cursor = null;
                } catch (SQLException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    try {
                        cursor = readableDatabase.rawQuery("SELECT * FROM config", null);
                        if (fVar == null) {
                            try {
                                fVar2 = new f();
                            } catch (Throwable th2) {
                                th = th2;
                                Closeables.closeSafely(cursor);
                                throw th;
                            }
                        } else {
                            fVar2 = fVar;
                        }
                    } catch (RuntimeException e3) {
                        e = e3;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (SQLException e4) {
                e = e4;
                zVar = this;
                if (f68155e) {
                    e.printStackTrace();
                }
                zVar.f68159b.h(e);
                zVar.f68161d.readLock().unlock();
            } catch (Throwable th4) {
                th = th4;
                zVar = this;
                zVar.f68161d.readLock().unlock();
                throw th;
            }
            if (cursor != null) {
                try {
                } catch (RuntimeException e5) {
                    e = e5;
                } catch (Throwable th5) {
                    th = th5;
                    zVar = this;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    while (true) {
                        String string = cursor.getString(cursor.getColumnIndex("eventid"));
                        String string2 = cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH));
                        int i2 = cursor.getInt(cursor.getColumnIndex("sample"));
                        String string3 = cursor.getString(cursor.getColumnIndex("reserve1"));
                        String string4 = cursor.getString(cursor.getColumnIndex("reserve2"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("cycle"));
                        int i4 = cursor.getInt(cursor.getColumnIndex("uploadrule"));
                        int i5 = cursor.getInt(cursor.getColumnIndex("recordrule"));
                        String string5 = cursor.getString(cursor.getColumnIndex("extend"));
                        String string6 = cursor.getString(cursor.getColumnIndex("reallog"));
                        cursor2 = cursor;
                        if (TextUtils.equals(string2, "0")) {
                            try {
                                fVar2.f68077a.add(string);
                            } catch (RuntimeException e6) {
                                e = e6;
                                cursor = cursor2;
                                if (f68155e) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                zVar = this;
                                zVar.f68161d.readLock().unlock();
                            } catch (Throwable th6) {
                                th = th6;
                                zVar = this;
                                cursor = cursor2;
                                Closeables.closeSafely(cursor);
                                throw th;
                            }
                        } else if (TextUtils.equals(string2, "1")) {
                            fVar2.f68080d.add(string);
                        }
                        if (i3 == 0) {
                            fVar2.f68078b.add(string);
                        }
                        if (TextUtils.equals(string3, "1")) {
                            fVar2.f68079c.add(string);
                        }
                        if (i2 > 0) {
                            fVar2.f68082f.put(string, String.valueOf(i2));
                        }
                        if (!TextUtils.isEmpty(string4)) {
                            fVar2.f68083g.put(string, string4);
                        }
                        if (i4 != 0 && i5 != 0) {
                            fVar2.f68084h.put(string, new m(string, i5, i4));
                        }
                        if (!TextUtils.isEmpty(string5)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string5);
                                if (jSONObject.has(Constant.ID_TYPE)) {
                                    fVar2.f68085i.add(string);
                                }
                                if (jSONObject.has("ch") && TextUtils.equals(jSONObject.getString("ch"), "1")) {
                                    fVar2.f68081e.add(string);
                                }
                                if (jSONObject.has("gflow")) {
                                    String string7 = jSONObject.getString("gflow");
                                    if (!TextUtils.equals(string7, "0")) {
                                        fVar2.k.put(string, string7);
                                    }
                                }
                                if (jSONObject.has("uploadType")) {
                                    String string8 = jSONObject.getString("uploadType");
                                    if (!TextUtils.isEmpty(string8)) {
                                        fVar2.l.put(string, string8);
                                    }
                                }
                                int optInt = jSONObject.optInt("lcache", 2);
                                if (optInt == 1 || optInt == 0) {
                                    fVar2.m.put(string, Integer.valueOf(optInt));
                                }
                            } catch (JSONException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (TextUtils.equals(string6, "1")) {
                            fVar2.j.add(string);
                        }
                        if (!cursor2.moveToNext()) {
                            break;
                        }
                        cursor = cursor2;
                    }
                    Closeables.closeSafely(cursor2);
                    zVar = this;
                    zVar.f68161d.readLock().unlock();
                }
            }
            cursor2 = cursor;
            Closeables.closeSafely(cursor2);
            zVar = this;
            zVar.f68161d.readLock().unlock();
        }
    }

    public void I(o oVar) {
        ContentValues y;
        String f2;
        String g2;
        int e2;
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, oVar) == null) {
            if (oVar != null && !TextUtils.isEmpty(oVar.g())) {
                this.f68161d.writeLock().lock();
                try {
                    try {
                        y = y(oVar);
                        f2 = oVar.f();
                        g2 = oVar.g();
                        e2 = oVar.e();
                        writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                    } catch (SQLException e3) {
                        if (f68155e) {
                            e3.printStackTrace();
                        }
                        this.f68159b.h(e3);
                    }
                    try {
                        if (g(f2, g2, e2, writableDatabase)) {
                            long insert = writableDatabase.insert("event", null, y);
                            if (f68155e) {
                                Log.d("UBCDatabaseHelper", "saveEvent#performTransaction: rowId=" + insert);
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } finally {
                    this.f68161d.writeLock().unlock();
                }
            } else if (f68155e) {
                Log.d("UBCDatabaseHelper", "saveEvent#event id must not be null");
            }
        }
    }

    public void J(List<o> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            if (list != null && list.size() != 0) {
                for (o oVar : list) {
                    I(oVar);
                }
            } else if (f68155e) {
                Log.d("UBCDatabaseHelper", "saveEvents#data must not be null");
            }
        }
    }

    public void K(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, qVar) == null) {
            if (qVar != null && !TextUtils.isEmpty(qVar.g())) {
                this.f68161d.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("flowid", qVar.g());
                            contentValues.put("flowhandle", Integer.valueOf(qVar.f()));
                            contentValues.put("state", qVar.k());
                            contentValues.put("begintime", Long.valueOf(qVar.a()));
                            if (qVar.h() != null) {
                                contentValues.put("content", qVar.h().toString());
                            } else {
                                contentValues.put("content", qVar.c());
                            }
                            contentValues.put("option", Integer.valueOf(qVar.i()));
                            contentValues.put("reserve1", qVar.e());
                            if (!TextUtils.isEmpty(qVar.b())) {
                                contentValues.put("reserve2", qVar.b());
                            }
                            if (qVar.l()) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("ctr", "1");
                                    contentValues.put("extend", jSONObject.toString());
                                } catch (JSONException e2) {
                                    if (f68155e) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            long insert = writableDatabase.insert("flow", null, contentValues);
                            if (f68155e) {
                                Log.d("UBCDatabaseHelper", "saveFlow#performTransaction: rowId=" + insert);
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e3) {
                        if (f68155e) {
                            e3.printStackTrace();
                        }
                        this.f68159b.h(e3);
                    }
                } finally {
                    this.f68161d.writeLock().unlock();
                }
            } else if (f68155e) {
                Log.d("UBCDatabaseHelper", "saveFlow#event id must not be null");
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f68161d.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "1");
                        int update = writableDatabase.update("file", contentValues, null, null);
                        if (f68155e) {
                            Log.d("UBCDatabaseHelper", "updateAllSentFileFail#performTransaction: update file table:" + update);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                    this.f68159b.h(e2);
                }
            } finally {
                this.f68161d.writeLock().unlock();
            }
        }
    }

    public boolean M(List<k> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048587, this, list)) != null) {
            return invokeL.booleanValue;
        }
        if (list == null || list.size() == 0) {
            return false;
        }
        this.f68161d.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                SQLiteStatement compileStatement = writableDatabase.compileStatement("replace into config(eventid,type,recordrule,uploadrule,cycle," + SetImageWatermarkTypeReqMsg.SWITCH + ",sample,reserve1,reserve2,extend,reallog" + SmallTailInfo.EMOTION_SUFFIX + " values(?,?,?,?,?,?,?,?,?,?,?)");
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        for (k kVar : list) {
                            compileStatement.clearBindings();
                            compileStatement.bindString(1, kVar.b());
                            compileStatement.bindString(2, kVar.getType());
                            if (kVar.d() != 0 && kVar.c() != 0) {
                                compileStatement.bindLong(3, kVar.d());
                                compileStatement.bindLong(4, kVar.c());
                            }
                            if ("1".equals(kVar.getIsReal())) {
                                compileStatement.bindLong(5, 0L);
                            } else {
                                compileStatement.bindLong(5, kVar.g());
                            }
                            compileStatement.bindString(6, kVar.getSwitch());
                            compileStatement.bindLong(7, kVar.f());
                            compileStatement.bindString(8, kVar.getAbtest());
                            if (!TextUtils.isEmpty(kVar.a())) {
                                compileStatement.bindString(9, kVar.a());
                            }
                            JSONObject jSONObject = new JSONObject();
                            if (TextUtils.equals(kVar.getIdType(), "1")) {
                                jSONObject.put(Constant.ID_TYPE, "1");
                            }
                            if (TextUtils.equals(kVar.getNoCache(), "1")) {
                                jSONObject.put("ch", "1");
                            }
                            if (TextUtils.equals(kVar.getIsDefaultConfig(), "1")) {
                                jSONObject.put("dfc", "1");
                            }
                            if (kVar.h() != null) {
                                jSONObject.put("version", kVar.h());
                            }
                            String gFlow = kVar.getGFlow();
                            if (!TextUtils.isEmpty(gFlow) && !TextUtils.equals(gFlow, "0")) {
                                jSONObject.put("gflow", gFlow);
                            }
                            String uploadType = kVar.getUploadType();
                            if (!TextUtils.isEmpty(uploadType)) {
                                jSONObject.put("uploadType", uploadType);
                            }
                            int e2 = kVar.e();
                            if (e2 != 2) {
                                jSONObject.put("lcache", e2);
                            }
                            String jSONObject2 = jSONObject.toString();
                            if (!TextUtils.isEmpty(jSONObject2)) {
                                compileStatement.bindString(10, jSONObject2);
                            }
                            if (TextUtils.equals(kVar.getReallog(), "1")) {
                                compileStatement.bindString(11, kVar.getReallog());
                            } else {
                                compileStatement.bindString(11, "0");
                            }
                            if (compileStatement.executeUpdateDelete() <= 0) {
                                return false;
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        if (f68155e) {
                            Log.d("UBCDatabaseHelper", "updateConfig success count: " + list.size());
                        }
                        return true;
                    } catch (JSONException e3) {
                        if (f68155e) {
                            e3.printStackTrace();
                        }
                        writableDatabase.endTransaction();
                        return false;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e4) {
                if (f68155e) {
                    e4.printStackTrace();
                }
                this.f68159b.h(e4);
            }
        } finally {
            this.f68161d.writeLock().unlock();
        }
    }

    public void N(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048588, this, str, i2, str2) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f68161d.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("content", str2);
                            int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                            if (f68155e && update != 1) {
                                Log.d("UBCDatabaseHelper", "updateFlowValue#performTransaction: updateFlowValue count:" + update);
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f68155e) {
                            e2.printStackTrace();
                        }
                        this.f68159b.h(e2);
                    }
                } finally {
                    this.f68161d.writeLock().unlock();
                }
            } else if (f68155e) {
                Log.d("UBCDatabaseHelper", "updateFlowValue#flowHandle invalid");
            }
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f68161d.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "1");
                        int update = writableDatabase.update("file", contentValues, "filename=\"" + str + "\"", null);
                        if (f68155e) {
                            Log.d("UBCDatabaseHelper", "updateSendedFileFail#performTransaction: update file table:" + update);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                    this.f68159b.h(e2);
                }
            } finally {
                this.f68161d.writeLock().unlock();
            }
        }
    }

    public void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.f68161d.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", str2);
                        writableDatabase.update("file", contentValues, "filename=\"" + str + "\"", null);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                    this.f68159b.h(e2);
                }
            } finally {
                this.f68161d.writeLock().unlock();
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (f68155e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (f68155e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase, q qVar, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, sQLiteDatabase, qVar, i0Var) == null) {
            try {
                if (qVar.f() < 0) {
                    return;
                }
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", qVar.g());
                        jSONObject.put("starttime", Long.toString(qVar.a()));
                        jSONObject.put("endtime", Long.toString(qVar.d()));
                        jSONObject.put("type", "1");
                        g m = g.m();
                        jSONObject.put(Constant.IS_REAL, m.z(qVar.g()) ? "1" : "0");
                        String l = m.l(qVar.g());
                        if (!TextUtils.isEmpty(l) && !TextUtils.equals(l, "0")) {
                            jSONObject.put("gflow", l);
                        }
                        if (!TextUtils.isEmpty(qVar.c())) {
                            jSONObject.put("content", qVar.c());
                        }
                        if (!TextUtils.isEmpty(qVar.e())) {
                            jSONObject.put("abtest", qVar.e());
                            i0Var.q("1");
                        }
                        if (!TextUtils.isEmpty(qVar.b())) {
                            jSONObject.put("c", qVar.b());
                        }
                        if (qVar.j() != null) {
                            jSONObject.put("part", qVar.j());
                        }
                        if (qVar.l()) {
                            jSONObject.put("of", "1");
                        }
                        jSONObject.put(Constant.ID_TYPE, m.r(qVar.g()));
                        JSONArray jSONArray = new JSONArray();
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ");
                        sb.append("eventid");
                        sb.append(" , ");
                        sb.append("begintime");
                        sb.append(" , ");
                        sb.append("content");
                        sb.append(" FROM ");
                        sb.append("event");
                        sb.append(" WHERE ");
                        sb.append("flowhandle");
                        sb.append(" = ");
                        sb.append(qVar.f());
                        Cursor cursor = null;
                        try {
                            cursor = sQLiteDatabase.rawQuery(sb.toString(), null);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                do {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("id", cursor.getString(columnIndex));
                                    jSONObject2.put("timestamp", Long.toString(cursor.getLong(columnIndex2)));
                                    jSONObject2.put("content", cursor.getString(columnIndex3));
                                    jSONArray.put(jSONObject2);
                                } while (cursor.moveToNext());
                                jSONObject.put("eventlist", jSONArray);
                            }
                            Closeables.closeSafely(cursor);
                            i0Var.a(jSONObject);
                        } catch (Throwable th) {
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    } catch (JSONException unused) {
                        if (f68155e) {
                            Log.d("UBCDatabaseHelper", "json exception:");
                        }
                    }
                } catch (RuntimeException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                }
            } catch (SQLException e3) {
                if (f68155e) {
                    e3.printStackTrace();
                }
                this.f68159b.h(e3);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Log.w("UBCDatabaseHelper", "Database is being closed");
        }
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
            } catch (SQLException e2) {
                if (f68155e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
            } catch (SQLException e2) {
                if (f68155e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void f(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, str, i2) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f68161d.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            int delete = writableDatabase.delete("flow", "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                            if (f68155e) {
                                Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow flow count:" + delete);
                            }
                            int delete2 = writableDatabase.delete("event", "flowhandle = " + i2, null);
                            if (f68155e) {
                                Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow event count:" + delete2);
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f68155e) {
                            e2.printStackTrace();
                        }
                        this.f68159b.h(e2);
                    }
                } finally {
                    this.f68161d.writeLock().unlock();
                }
            } else if (f68155e) {
                Log.d("UBCDatabaseHelper", "cancelFlow#flowHandle invalid");
            }
        }
    }

    public final boolean g(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLIL = interceptable.invokeLLIL(1048598, this, str, str2, i2, sQLiteDatabase)) != null) {
            return invokeLLIL.booleanValue;
        }
        this.f68161d.writeLock().lock();
        boolean z = false;
        try {
            try {
                if (str.equals(str2)) {
                    z = true;
                } else {
                    try {
                        Cursor cursor = null;
                        try {
                            try {
                                cursor = sQLiteDatabase.rawQuery("SELECT state FROM flow WHERE flowhandle = " + i2, null);
                                if (cursor != null && cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    String string = cursor.getString(0);
                                    if (!TextUtils.isEmpty(string)) {
                                        if ("1".equals(string)) {
                                            z = true;
                                        }
                                    }
                                }
                            } catch (SQLException e2) {
                                if (f68155e) {
                                    e2.printStackTrace();
                                }
                                this.f68159b.h(e2);
                            } catch (RuntimeException e3) {
                                if (f68155e) {
                                    e3.printStackTrace();
                                }
                            }
                        } finally {
                            Closeables.closeSafely(cursor);
                        }
                    } catch (SQLException e4) {
                        e = e4;
                        if (f68155e) {
                            e.printStackTrace();
                        }
                        this.f68159b.h(e);
                        return z;
                    }
                }
                return z;
            } catch (SQLException e5) {
                e = e5;
                z = true;
            }
        } finally {
            this.f68161d.writeLock().unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x01b2 A[Catch: all -> 0x01dd, TryCatch #9 {all -> 0x01dd, blocks: (B:55:0x01a1, B:56:0x01a4, B:63:0x01ae, B:65:0x01b2, B:66:0x01b5), top: B:83:0x01a1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048599, this) != null) {
            return;
        }
        this.f68161d.writeLock().lock();
        int i4 = 0;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                long currentTimeMillis = System.currentTimeMillis() - g.m().j();
                Cursor cursor = null;
                int delete = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                try {
                    if (f68155e) {
                        Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count:" + delete);
                    }
                    i3 = writableDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                    try {
                        if (f68155e) {
                            Log.d("UBCDatabaseHelper", "clearInvalidData: delete event count:" + i3);
                        }
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ");
                        sb.append("flowhandle");
                        sb.append(" FROM ");
                        sb.append("flow");
                        sb.append(" WHERE ");
                        sb.append("begintime");
                        sb.append(" < ");
                        sb.append(System.currentTimeMillis() - 86400000);
                        sb.append(" AND ");
                        sb.append("endtime");
                        sb.append(" is NULL ");
                        sb.append(" AND ");
                        sb.append("option");
                        sb.append(" = 0");
                        ArrayList arrayList = new ArrayList();
                        try {
                            Cursor rawQuery = writableDatabase.rawQuery(sb.toString(), null);
                            if (rawQuery != null) {
                                try {
                                    if (rawQuery.getCount() > 0) {
                                        rawQuery.moveToFirst();
                                        do {
                                            arrayList.add(Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("flowhandle"))));
                                        } while (rawQuery.moveToNext());
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = rawQuery;
                                    Closeables.closeSafely(cursor);
                                    throw th;
                                }
                            }
                            Closeables.closeSafely(rawQuery);
                            if (arrayList.size() > 0) {
                                if (f68155e) {
                                    Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count2:" + arrayList.size());
                                }
                                i4 = arrayList.size();
                                try {
                                    String C = C(arrayList);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("flowhandle");
                                    sb2.append(" in (");
                                    sb2.append(C);
                                    sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                                    writableDatabase.delete("flow", sb2.toString(), null);
                                    writableDatabase.delete("event", sb2.toString(), null);
                                } catch (Throwable th2) {
                                    th = th2;
                                    i2 = i4;
                                    i4 = delete;
                                    try {
                                        try {
                                            writableDatabase.endTransaction();
                                            throw th;
                                        } catch (SQLException e2) {
                                            e = e2;
                                            if (f68155e) {
                                                e.printStackTrace();
                                            }
                                            this.f68159b.h(e);
                                            this.f68161d.writeLock().unlock();
                                            if (i4 <= 0 || i3 > 0 || i2 > 0) {
                                                b0.a().e(String.valueOf(g.m().j()), i4, i3, i2);
                                            }
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        this.f68161d.writeLock().unlock();
                                        if (i4 <= 0 || i3 > 0 || i2 > 0) {
                                            b0.a().e(String.valueOf(g.m().j()), i4, i3, i2);
                                        }
                                        throw th;
                                    }
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            try {
                                writableDatabase.endTransaction();
                                p("flow");
                                p("event");
                                this.f68161d.writeLock().unlock();
                                if (delete > 0 || i3 > 0 || i4 > 0) {
                                    b0.a().e(String.valueOf(g.m().j()), delete, i3, i4);
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                i2 = i4;
                                i4 = delete;
                                if (f68155e) {
                                }
                                this.f68159b.h(e);
                                this.f68161d.writeLock().unlock();
                                if (i4 <= 0) {
                                }
                                b0.a().e(String.valueOf(g.m().j()), i4, i3, i2);
                            } catch (Throwable th4) {
                                th = th4;
                                i2 = i4;
                                i4 = delete;
                                this.f68161d.writeLock().unlock();
                                if (i4 <= 0) {
                                }
                                b0.a().e(String.valueOf(g.m().j()), i4, i3, i2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        i4 = delete;
                        i2 = 0;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    i4 = delete;
                    i2 = 0;
                    i3 = 0;
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (SQLException e4) {
            e = e4;
            i2 = 0;
            i3 = 0;
        } catch (Throwable th9) {
            th = th9;
            i2 = 0;
            i3 = 0;
        }
    }

    public boolean i(SparseArray<Integer> sparseArray, ArrayList<String> arrayList, boolean z, String str) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{sparseArray, arrayList, Boolean.valueOf(z), str})) != null) {
            return invokeCommon.booleanValue;
        }
        this.f68161d.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                if (sparseArray != null) {
                    try {
                        if (sparseArray.size() > 0) {
                            int size = sparseArray.size();
                            ArrayList arrayList2 = new ArrayList(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                arrayList2.add(Integer.valueOf(sparseArray.keyAt(i2)));
                            }
                            String C = C(arrayList2);
                            if (f68155e) {
                                Log.d("UBCDatabaseHelper", "save file name " + str + " delete flow handle ids = " + C);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("flowhandle");
                            sb.append(" in (");
                            sb.append(C);
                            sb.append(SmallTailInfo.EMOTION_SUFFIX);
                            int delete = writableDatabase.delete("flow", sb.toString(), null);
                            if (f68155e) {
                                Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: flow table delete count:" + delete);
                            }
                            int delete2 = writableDatabase.delete("event", sb.toString(), null);
                            if (f68155e) {
                                Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction:  delete flow -> event table count:" + delete2);
                            }
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    String C2 = C(arrayList);
                    if (f68155e) {
                        Log.d("UBCDatabaseHelper", "delete event ids = " + C2);
                    }
                    int delete3 = writableDatabase.delete("event", "eventid in (" + C2 + SmallTailInfo.EMOTION_SUFFIX + " AND flowhandle = -1", null);
                    if (f68155e) {
                        Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: event table count2:" + delete3);
                    }
                }
                if ((sparseArray != null && sparseArray.size() > 0) || (arrayList != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("filename", str);
                    contentValues.put("state", "0");
                    contentValues.put("reserve1", z ? "1" : "0");
                    long insert = writableDatabase.insert("file", null, contentValues);
                    if (f68155e) {
                        Log.d("UBCDatabaseHelper", "clearUploadedData#save file: rowId=" + insert);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                try {
                    writableDatabase.endTransaction();
                    this.f68161d.writeLock().unlock();
                    return true;
                } catch (SQLException e2) {
                    e = e2;
                    z2 = true;
                    if (f68155e) {
                        e.printStackTrace();
                    }
                    this.f68159b.h(e);
                    return z2;
                }
            } catch (SQLException e3) {
                e = e3;
                z2 = false;
            }
        } finally {
            this.f68161d.writeLock().unlock();
        }
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            } catch (SQLException e2) {
                if (f68155e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            this.f68161d.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        i2 = writableDatabase.delete("event", "reallog =?", new String[]{"1"});
                        try {
                            writableDatabase.setTransactionSuccessful();
                        } catch (SQLException e2) {
                            e = e2;
                            if (f68155e) {
                                e.printStackTrace();
                            }
                            this.f68159b.h(e);
                            return i2 > 0;
                        }
                    } catch (SQLException e3) {
                        e = e3;
                        i2 = 0;
                    }
                    return i2 > 0;
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e4) {
                if (f68155e) {
                    e4.printStackTrace();
                }
                this.f68159b.h(e4);
                return false;
            } finally {
                this.f68161d.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public void l() {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f68161d.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                    this.f68159b.h(e2);
                }
                try {
                    int delete = writableDatabase.delete("file", null, null);
                    if (f68155e) {
                        Log.d("UBCDatabaseHelper", "deleteAllSentFile#performTransaction: delete file table:" + delete);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } finally {
                this.f68161d.writeLock().unlock();
            }
        }
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f68161d.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.rawQuery("SELECT * FROM config WHERE eventid=\"" + str + "\"", null);
                    if (cursor != null && cursor.getCount() != 0) {
                        int delete = writableDatabase.delete("config", "eventid =? ", new String[]{str});
                        writableDatabase.setTransactionSuccessful();
                        return delete > 0;
                    }
                    return true;
                } finally {
                    Closeables.closeSafely(cursor);
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                if (f68155e) {
                    e2.printStackTrace();
                }
                this.f68159b.h(e2);
                return false;
            } finally {
                this.f68161d.writeLock().unlock();
            }
        }
        return invokeL.booleanValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.f68161d.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        int delete = writableDatabase.delete("file", "filename=\"" + str + "\"", null);
                        if (f68155e) {
                            Log.d("UBCDatabaseHelper", "deleteSendedFile#performTransaction: delete file table:" + delete);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                    this.f68159b.h(e2);
                }
            } finally {
                this.f68161d.writeLock().unlock();
            }
        }
    }

    public void o(String str, int i2, long j, JSONArray jSONArray) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), jSONArray}) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f68161d.writeLock().lock();
                try {
                    try {
                        writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                    } catch (SQLException e2) {
                        if (f68155e) {
                            e2.printStackTrace();
                        }
                        this.f68159b.h(e2);
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "2");
                        contentValues.put("endtime", Long.valueOf(j));
                        if (jSONArray != null && jSONArray.length() > 0) {
                            contentValues.put("slot", jSONArray.toString());
                        }
                        int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                        if (f68155e && update != 1) {
                            Log.d("UBCDatabaseHelper", "endFlow#performTransaction: endFlow count:" + update);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } finally {
                    this.f68161d.writeLock().unlock();
                }
            } else if (f68155e) {
                Log.d("UBCDatabaseHelper", "endFlow#flowHandle invalid");
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, sQLiteDatabase) == null) {
            sQLiteDatabase.enableWriteAheadLogging();
            super.onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, sQLiteDatabase) == null) {
            if (f68155e) {
                Log.i("UBCDatabaseHelper", "Creating database bdbehavior.db version 7");
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
                sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
                h0.e().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, "0");
            } catch (Exception e2) {
                Log.w("UBCDatabaseHelper", "Error while creating db: " + e2.toString());
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048609, this, sQLiteDatabase, i2, i3) == null) {
            try {
                sQLiteDatabase.beginTransaction();
                while (i2 < i3) {
                    if (i2 == 1) {
                        j(sQLiteDatabase);
                    } else if (i2 == 2) {
                        e(sQLiteDatabase);
                    } else if (i2 == 3) {
                        a(sQLiteDatabase);
                    } else if (i2 == 4) {
                        b(sQLiteDatabase);
                    } else if (i2 == 6) {
                        d(sQLiteDatabase);
                    }
                    i2++;
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:6:0x0017, B:19:0x0066, B:29:0x007c, B:31:0x0095, B:32:0x00ab, B:28:0x0078, B:38:0x00be, B:39:0x00c1), top: B:61:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(String str) {
        SQLiteDatabase writableDatabase;
        Cursor cursor;
        Throwable th;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.f68161d.writeLock().lock();
            int i3 = 0;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        try {
                            cursor = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id) FROM " + str, null);
                        } catch (RuntimeException e2) {
                            e = e2;
                            cursor = null;
                        } catch (Throwable th2) {
                            cursor = null;
                            th = th2;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e3) {
                    if (f68155e) {
                        e3.printStackTrace();
                    }
                    this.f68159b.h(e3);
                    this.f68161d.writeLock().unlock();
                    if (0 <= 0) {
                        return;
                    }
                }
                if (cursor != null) {
                    try {
                        try {
                        } catch (RuntimeException e4) {
                            e = e4;
                            if (f68155e) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            i2 = 0;
                            i3 = writableDatabase.delete(str, "_id < " + i2, null);
                            if (f68155e) {
                            }
                            writableDatabase.setTransactionSuccessful();
                            this.f68161d.writeLock().unlock();
                            if (i3 <= 0) {
                            }
                            b0.a().b(String.valueOf(g.m().k()), i3, str);
                        }
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            if (cursor.getInt(0) > g.m().k()) {
                                i2 = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                                Closeables.closeSafely(cursor);
                                i3 = writableDatabase.delete(str, "_id < " + i2, null);
                                if (f68155e) {
                                    Log.d("UBCDatabaseHelper", "ensureDataBaseLimit#performTransaction: delete count:" + i3);
                                }
                                writableDatabase.setTransactionSuccessful();
                                this.f68161d.writeLock().unlock();
                                if (i3 <= 0) {
                                    return;
                                }
                                b0.a().b(String.valueOf(g.m().k()), i3, str);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                }
                i2 = 0;
                Closeables.closeSafely(cursor);
                i3 = writableDatabase.delete(str, "_id < " + i2, null);
                if (f68155e) {
                }
                writableDatabase.setTransactionSuccessful();
                this.f68161d.writeLock().unlock();
                if (i3 <= 0) {
                }
                b0.a().b(String.valueOf(g.m().k()), i3, str);
            } catch (Throwable th4) {
                this.f68161d.writeLock().unlock();
                if (0 > 0) {
                    b0.a().b(String.valueOf(g.m().k()), 0, str);
                }
                throw th4;
            }
        }
    }

    public int q(i0 i0Var, i0 i0Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, i0Var, i0Var2)) == null) {
            int s = s(i0Var, i0Var2);
            if (i0Var.k() && i0Var2.k()) {
                return 1;
            }
            return r(i0Var, i0Var2) | s;
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:144:0x022e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:148:0x0234 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:171:0x01fa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:172:0x0026 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0213 A[Catch: all -> 0x022e, TryCatch #11 {all -> 0x022e, blocks: (B:131:0x020f, B:133:0x0213, B:136:0x0219, B:138:0x021d, B:140:0x0222, B:142:0x0226), top: B:172:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x021d A[Catch: all -> 0x022e, TryCatch #11 {all -> 0x022e, blocks: (B:131:0x020f, B:133:0x0213, B:136:0x0219, B:138:0x021d, B:140:0x0222, B:142:0x0226), top: B:172:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0226 A[Catch: all -> 0x022e, TRY_LEAVE, TryCatch #11 {all -> 0x022e, blocks: (B:131:0x020f, B:133:0x0213, B:136:0x0219, B:138:0x021d, B:140:0x0222, B:142:0x0226), top: B:172:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x023e A[Catch: all -> 0x0236, TryCatch #17 {all -> 0x0236, blocks: (B:5:0x0019, B:154:0x023a, B:156:0x023e, B:157:0x0241, B:146:0x0230, B:147:0x0233), top: B:169:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x006a A[EDGE_INSN: B:185:0x006a->B:16:0x006a ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c1 A[LOOP:0: B:177:0x0058->B:94:0x01c1, LOOP_END] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r26v0, types: [d.a.s0.i0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r27v0, types: [d.a.s0.i0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int r(i0 i0Var, i0 i0Var2) {
        InterceptResult invokeLL;
        ?? r6;
        Cursor cursor;
        ReentrantReadWriteLock.ReadLock readLock;
        ReentrantReadWriteLock.ReadLock readLock2;
        ReentrantReadWriteLock.ReadLock readLock3;
        ReentrantReadWriteLock.ReadLock readLock4;
        int i2;
        int i3;
        int i4;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, i0Var, i0Var2)) == null) {
            z zVar = this;
            String str2 = "content";
            ReentrantReadWriteLock.ReadLock readLock5 = zVar.f68161d.readLock();
            readLock5.lock();
            try {
                try {
                    boolean k = i0Var.k();
                    boolean k2 = i0Var2.k();
                    cursor = null;
                    try {
                        try {
                            cursor = getReadableDatabase().rawQuery("SELECT * FROM event WHERE flowhandle = -1 AND reallog = \"0\"", null);
                            if (cursor == null || cursor.getCount() <= 0) {
                                readLock5 = null;
                            } else {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                int columnIndex4 = cursor.getColumnIndex("reserve1");
                                int columnIndex5 = cursor.getColumnIndex("reserve2");
                                int columnIndex6 = cursor.getColumnIndex("extend");
                                ?? r15 = false;
                                while (true) {
                                    try {
                                        String string = cursor.getString(columnIndex);
                                        int i5 = columnIndex;
                                        boolean e2 = g.m().e(string);
                                        if (k && k2) {
                                            break;
                                        }
                                        try {
                                            if ((!k || !e2) && (!k2 || e2)) {
                                                boolean z = k;
                                                JSONObject jSONObject = new JSONObject();
                                                boolean z2 = k2;
                                                jSONObject.put("id", string);
                                                int i6 = columnIndex6;
                                                readLock4 = r15;
                                                try {
                                                    long j = cursor.getLong(columnIndex2);
                                                    i2 = columnIndex2;
                                                    jSONObject.put("timestamp", Long.toString(j));
                                                    i3 = i6;
                                                    if (j > 0) {
                                                        if (e2) {
                                                            if (i0Var.h() == 0 || j < i0Var.h()) {
                                                                i0Var.p(j, 0L);
                                                            }
                                                            if (j > i0Var.g()) {
                                                                i0Var.p(0L, j);
                                                            }
                                                        } else {
                                                            if (i0Var2.h() == 0 || j < i0Var2.h()) {
                                                                i0Var2.p(j, 0L);
                                                            }
                                                            if (j > i0Var2.g()) {
                                                                i0Var2.p(0L, j);
                                                            }
                                                        }
                                                    }
                                                    jSONObject.put("type", "0");
                                                    String string2 = cursor.getString(columnIndex3);
                                                    if (TextUtils.isEmpty(string2)) {
                                                        i4 = 0;
                                                    } else {
                                                        jSONObject.put(str2, string2);
                                                        i4 = string2.getBytes("UTF-8").length + 0;
                                                    }
                                                    String string3 = cursor.getString(columnIndex4);
                                                    String str3 = "1";
                                                    if (TextUtils.isEmpty(string3)) {
                                                        str = str2;
                                                    } else {
                                                        str = str2;
                                                        jSONObject.put("abtest", string3);
                                                        if (e2) {
                                                            i0Var.q("1");
                                                        } else {
                                                            i0Var2.q("1");
                                                        }
                                                        i4 += string3.getBytes("UTF-8").length;
                                                    }
                                                    String string4 = cursor.getString(columnIndex5);
                                                    if (!TextUtils.isEmpty(string4)) {
                                                        jSONObject.put("c", string4);
                                                    }
                                                    String string5 = cursor.getString(i3);
                                                    if (!TextUtils.isEmpty(string5) && new JSONObject(string5).has("ctr")) {
                                                        jSONObject.put("of", "1");
                                                    }
                                                    g m = g.m();
                                                    jSONObject.put(Constant.ID_TYPE, m.r(string));
                                                    if (!m.z(string)) {
                                                        str3 = "0";
                                                    }
                                                    jSONObject.put(Constant.IS_REAL, str3);
                                                    String l = m.l(string);
                                                    if (!TextUtils.isEmpty(l) && !TextUtils.equals(l, "0")) {
                                                        jSONObject.put("gflow", l);
                                                    }
                                                    if (e2) {
                                                        i0Var.a(jSONObject);
                                                        i0Var.n(string);
                                                        i0Var.m(i4);
                                                        if (i0Var.k()) {
                                                            k2 = z2;
                                                            k = true;
                                                            r15 = readLock4 != null ? true : readLock4;
                                                            if (k && k2) {
                                                                break;
                                                            }
                                                            if (!cursor.moveToNext()) {
                                                                break;
                                                            }
                                                            columnIndex6 = i3;
                                                            str2 = str;
                                                            columnIndex = i5;
                                                            columnIndex2 = i2;
                                                        }
                                                        k = z;
                                                        k2 = z2;
                                                        if (readLock4 != null) {
                                                        }
                                                        if (k) {
                                                            break;
                                                            break;
                                                        }
                                                        if (!cursor.moveToNext()) {
                                                        }
                                                    } else {
                                                        i0Var2.a(jSONObject);
                                                        i0Var2.n(string);
                                                        i0Var2.m(i4);
                                                        if (i0Var2.k()) {
                                                            k = z;
                                                            k2 = true;
                                                            if (readLock4 != null) {
                                                            }
                                                            if (k) {
                                                            }
                                                            if (!cursor.moveToNext()) {
                                                            }
                                                        }
                                                        k = z;
                                                        k2 = z2;
                                                        if (readLock4 != null) {
                                                        }
                                                        if (k) {
                                                        }
                                                        if (!cursor.moveToNext()) {
                                                        }
                                                    }
                                                } catch (UnsupportedEncodingException e3) {
                                                    e = e3;
                                                    readLock3 = readLock4;
                                                    readLock5 = readLock3;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    zVar = this;
                                                    r6 = readLock5;
                                                    zVar.f68161d.readLock().unlock();
                                                    return r6;
                                                } catch (RuntimeException e4) {
                                                    e = e4;
                                                    readLock2 = readLock4;
                                                    readLock5 = readLock2;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    zVar = this;
                                                    r6 = readLock5;
                                                    zVar.f68161d.readLock().unlock();
                                                    return r6;
                                                } catch (JSONException unused) {
                                                    readLock = readLock4;
                                                    readLock5 = readLock;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    zVar = this;
                                                    r6 = readLock5;
                                                    zVar.f68161d.readLock().unlock();
                                                    return r6;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zVar = this;
                                                    readLock5 = readLock4;
                                                    try {
                                                        Closeables.closeSafely(cursor);
                                                        throw th;
                                                    } catch (SQLException e5) {
                                                        e = e5;
                                                        if (f68155e) {
                                                            e.printStackTrace();
                                                        }
                                                        zVar.f68159b.h(e);
                                                        r6 = readLock5;
                                                        zVar.f68161d.readLock().unlock();
                                                        return r6;
                                                    }
                                                }
                                            }
                                            if (!cursor.moveToNext()) {
                                            }
                                        } catch (UnsupportedEncodingException e6) {
                                            e = e6;
                                            readLock3 = r15;
                                            readLock5 = readLock3;
                                            if (f68155e) {
                                                e.printStackTrace();
                                                readLock5 = readLock3;
                                            }
                                            Closeables.closeSafely(cursor);
                                            zVar = this;
                                            r6 = readLock5;
                                            zVar.f68161d.readLock().unlock();
                                            return r6;
                                        } catch (RuntimeException e7) {
                                            e = e7;
                                            readLock2 = r15;
                                            readLock5 = readLock2;
                                            if (f68155e) {
                                                e.printStackTrace();
                                                readLock5 = readLock2;
                                            }
                                            Closeables.closeSafely(cursor);
                                            zVar = this;
                                            r6 = readLock5;
                                            zVar.f68161d.readLock().unlock();
                                            return r6;
                                        } catch (JSONException unused2) {
                                            readLock = r15;
                                            readLock5 = readLock;
                                            if (f68155e) {
                                                Log.d("UBCDatabaseHelper", "json exception:");
                                                readLock5 = readLock;
                                            }
                                            Closeables.closeSafely(cursor);
                                            zVar = this;
                                            r6 = readLock5;
                                            zVar.f68161d.readLock().unlock();
                                            return r6;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            zVar = this;
                                            readLock5 = r15;
                                            Closeables.closeSafely(cursor);
                                            throw th;
                                        }
                                        str = str2;
                                        i2 = columnIndex2;
                                        i3 = columnIndex6;
                                    } catch (UnsupportedEncodingException e8) {
                                        e = e8;
                                        readLock4 = r15;
                                    } catch (RuntimeException e9) {
                                        e = e9;
                                        readLock4 = r15;
                                    } catch (JSONException unused3) {
                                        readLock4 = r15;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        readLock4 = r15;
                                    }
                                }
                                readLock5 = r15;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            zVar = this;
                            readLock5 = readLock5;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    } catch (UnsupportedEncodingException e10) {
                        e = e10;
                        readLock3 = null;
                    } catch (RuntimeException e11) {
                        e = e11;
                        readLock2 = null;
                    } catch (JSONException unused4) {
                        readLock = null;
                    } catch (Throwable th5) {
                        th = th5;
                        readLock5 = null;
                        zVar = this;
                        readLock5 = readLock5;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                } catch (SQLException e12) {
                    e = e12;
                    readLock5 = null;
                }
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                Closeables.closeSafely(cursor);
                zVar = this;
                r6 = readLock5;
            } catch (SQLException e13) {
                e = e13;
                zVar = this;
                if (f68155e) {
                }
                zVar.f68159b.h(e);
                r6 = readLock5;
                zVar.f68161d.readLock().unlock();
                return r6;
            } catch (Throwable th7) {
                th = th7;
                zVar = this;
                zVar.f68161d.readLock().unlock();
                throw th;
            }
            zVar.f68161d.readLock().unlock();
            return r6;
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:126:0x028a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:160:0x0286 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v18, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r4v19, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0255 A[LOOP:0: B:168:0x0079->B:101:0x0255, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0295 A[Catch: all -> 0x02a3, TryCatch #2 {all -> 0x02a3, blocks: (B:132:0x0291, B:134:0x0295, B:137:0x029b, B:139:0x029f), top: B:161:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x029f A[Catch: all -> 0x02a3, TRY_LEAVE, TryCatch #2 {all -> 0x02a3, blocks: (B:132:0x0291, B:134:0x0295, B:137:0x029b, B:139:0x029f), top: B:161:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0252 A[EDGE_INSN: B:177:0x0252->B:100:0x0252 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int s(i0 i0Var, i0 i0Var2) {
        InterceptResult invokeLL;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        SQLiteDatabase sQLiteDatabase;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        SQLiteDatabase sQLiteDatabase2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, i0Var, i0Var2)) == null) {
            z zVar = this;
            ReentrantReadWriteLock.ReadLock readLock = zVar.f68161d.readLock();
            readLock.lock();
            try {
                try {
                    boolean k = i0Var.k();
                    boolean k2 = i0Var2.k();
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            try {
                                cursor = readableDatabase.rawQuery(" SELECT * FROM flow", null);
                                if (cursor == null || cursor.getCount() <= 0) {
                                    z3 = false;
                                } else {
                                    cursor.moveToFirst();
                                    int columnIndex = cursor.getColumnIndex("flowid");
                                    int columnIndex2 = cursor.getColumnIndex("flowhandle");
                                    int columnIndex3 = cursor.getColumnIndex("state");
                                    int columnIndex4 = cursor.getColumnIndex("begintime");
                                    int columnIndex5 = cursor.getColumnIndex("endtime");
                                    int columnIndex6 = cursor.getColumnIndex("content");
                                    int columnIndex7 = cursor.getColumnIndex("option");
                                    int columnIndex8 = cursor.getColumnIndex("reserve1");
                                    boolean z4 = k;
                                    int columnIndex9 = cursor.getColumnIndex("reserve2");
                                    boolean z5 = k2;
                                    int columnIndex10 = cursor.getColumnIndex("slot");
                                    try {
                                        int columnIndex11 = cursor.getColumnIndex("extend");
                                        boolean z6 = false;
                                        while (true) {
                                            try {
                                                sQLiteDatabase = readableDatabase;
                                            } catch (UnsupportedEncodingException e2) {
                                                e = e2;
                                                zVar = this;
                                            } catch (RuntimeException e3) {
                                                e = e3;
                                                zVar = this;
                                            } catch (Throwable th) {
                                                th = th;
                                            }
                                            try {
                                                if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                                                    String string = cursor.getString(columnIndex);
                                                    int i9 = cursor.getInt(columnIndex2);
                                                    if (i9 >= 0) {
                                                        i3 = columnIndex2;
                                                        boolean e4 = g.m().e(string);
                                                        if (z4 && z5) {
                                                            zVar = this;
                                                            break;
                                                        }
                                                        if ((!z4 || !e4) && (!z5 || e4)) {
                                                            i4 = columnIndex3;
                                                            q qVar = new q();
                                                            qVar.u(cursor.getString(columnIndex));
                                                            qVar.t(i9);
                                                            i5 = columnIndex11;
                                                            qVar.m(cursor.getLong(columnIndex4));
                                                            qVar.q(cursor.getLong(columnIndex5));
                                                            if (e4) {
                                                                if (qVar.d() <= 0 || qVar.d() <= i0Var.g()) {
                                                                    i6 = columnIndex4;
                                                                    i7 = columnIndex5;
                                                                } else {
                                                                    i6 = columnIndex4;
                                                                    i7 = columnIndex5;
                                                                    i0Var.p(0L, qVar.d());
                                                                }
                                                                if (qVar.a() > 0 && (i0Var.h() == 0 || qVar.a() < i0Var.h())) {
                                                                    i0Var.p(qVar.a(), 0L);
                                                                }
                                                            } else {
                                                                i6 = columnIndex4;
                                                                i7 = columnIndex5;
                                                                if (qVar.d() > 0 && qVar.d() > i0Var2.g()) {
                                                                    i0Var2.p(0L, qVar.d());
                                                                }
                                                                if (qVar.a() > 0 && (i0Var2.h() == 0 || qVar.a() < i0Var2.h())) {
                                                                    i0Var2.p(qVar.a(), 0L);
                                                                }
                                                            }
                                                            String string2 = cursor.getString(columnIndex6);
                                                            if (TextUtils.isEmpty(string2)) {
                                                                i8 = 0;
                                                            } else {
                                                                qVar.o(string2);
                                                                i8 = string2.getBytes("UTF-8").length + 0;
                                                            }
                                                            String string3 = cursor.getString(columnIndex8);
                                                            if (!TextUtils.isEmpty(string3)) {
                                                                qVar.s(string3);
                                                                i8 += string3.getBytes("UTF-8").length;
                                                            }
                                                            if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                                                qVar.n(cursor.getString(columnIndex9));
                                                            }
                                                            String string4 = cursor.getString(columnIndex10);
                                                            if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                                                qVar.v(string4);
                                                                i8 += string4.getBytes("UTF-8").length;
                                                            }
                                                            int i10 = i8;
                                                            if (!TextUtils.isEmpty(cursor.getString(i5))) {
                                                                try {
                                                                    if (new JSONObject(cursor.getString(i5)).has("ctr")) {
                                                                        qVar.p(true);
                                                                    }
                                                                } catch (JSONException e5) {
                                                                    e5.printStackTrace();
                                                                }
                                                            }
                                                            if (e4) {
                                                                zVar = this;
                                                                sQLiteDatabase2 = sQLiteDatabase;
                                                                zVar.c(sQLiteDatabase2, qVar, i0Var);
                                                                i0Var.o(qVar.f(), Integer.parseInt(qVar.g()));
                                                                i0Var.m(i10);
                                                                if (i0Var.k()) {
                                                                    z4 = true;
                                                                }
                                                            } else {
                                                                zVar = this;
                                                                sQLiteDatabase2 = sQLiteDatabase;
                                                                zVar.c(sQLiteDatabase2, qVar, i0Var2);
                                                                i0Var2.o(qVar.f(), Integer.parseInt(qVar.g()));
                                                                i0Var2.m(i10);
                                                                if (i0Var2.k()) {
                                                                    z5 = true;
                                                                }
                                                            }
                                                            if (!z6) {
                                                                z6 = true;
                                                            }
                                                            if (z4 && z5) {
                                                                break;
                                                            }
                                                            if (!cursor.moveToNext()) {
                                                                break;
                                                            }
                                                            columnIndex11 = i5;
                                                            readableDatabase = sQLiteDatabase2;
                                                            columnIndex2 = i3;
                                                            columnIndex3 = i4;
                                                            columnIndex4 = i6;
                                                            columnIndex5 = i7;
                                                        }
                                                        i5 = columnIndex11;
                                                        i4 = columnIndex3;
                                                        i6 = columnIndex4;
                                                        i7 = columnIndex5;
                                                        sQLiteDatabase2 = sQLiteDatabase;
                                                        zVar = this;
                                                        if (!cursor.moveToNext()) {
                                                        }
                                                    }
                                                }
                                                if (!cursor.moveToNext()) {
                                                }
                                            } catch (UnsupportedEncodingException e6) {
                                                e = e6;
                                                z2 = z6;
                                                z3 = z2;
                                                if (f68155e) {
                                                    e.printStackTrace();
                                                    z3 = z2;
                                                }
                                                Closeables.closeSafely(cursor);
                                                i2 = z3;
                                                return i2;
                                            } catch (RuntimeException e7) {
                                                e = e7;
                                                z = z6;
                                                z3 = z;
                                                if (f68155e) {
                                                    e.printStackTrace();
                                                    z3 = z;
                                                }
                                                Closeables.closeSafely(cursor);
                                                i2 = z3;
                                                return i2;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                Closeables.closeSafely(cursor);
                                                throw th;
                                            }
                                            i3 = columnIndex2;
                                            i5 = columnIndex11;
                                            i4 = columnIndex3;
                                            i6 = columnIndex4;
                                            i7 = columnIndex5;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            zVar = this;
                                        }
                                        z3 = z6;
                                    } catch (UnsupportedEncodingException e8) {
                                        e = e8;
                                        zVar = this;
                                        z2 = false;
                                        z3 = z2;
                                        if (f68155e) {
                                        }
                                        Closeables.closeSafely(cursor);
                                        i2 = z3;
                                        return i2;
                                    } catch (RuntimeException e9) {
                                        e = e9;
                                        zVar = this;
                                        z = false;
                                        z3 = z;
                                        if (f68155e) {
                                        }
                                        Closeables.closeSafely(cursor);
                                        i2 = z3;
                                        return i2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        Closeables.closeSafely(cursor);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (UnsupportedEncodingException e10) {
                            e = e10;
                        } catch (RuntimeException e11) {
                            e = e11;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        Closeables.closeSafely(cursor);
                        i2 = z3;
                    } catch (SQLException e12) {
                        e = e12;
                        if (f68155e) {
                            e.printStackTrace();
                        }
                        zVar.f68159b.h(e);
                        i2 = readLock;
                        return i2;
                    }
                } finally {
                    zVar.f68161d.readLock().unlock();
                }
            } catch (SQLException e13) {
                e = e13;
                readLock = null;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public HashMap<String, String> t(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, arrayList)) == null) {
            this.f68161d.readLock().lock();
            HashMap<String, String> hashMap = new HashMap<>();
            String C = C(arrayList);
            try {
                try {
                    cursor = null;
                } catch (SQLException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                }
                try {
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT eventid,extend FROM config WHERE eventid in (" + C + SmallTailInfo.EMOTION_SUFFIX, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                String string2 = cursor.getString(cursor.getColumnIndex("extend"));
                                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                    hashMap.put(string, string2);
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (SQLiteException e3) {
                        if (f68155e) {
                            e3.printStackTrace();
                        }
                    }
                    return hashMap;
                } finally {
                    Closeables.closeSafely(cursor);
                }
            } finally {
                this.f68161d.readLock().unlock();
            }
        }
        return (HashMap) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x00fc */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v7 */
    public k u(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            this.f68161d.readLock().lock();
            try {
                try {
                    try {
                    } catch (SQLException e2) {
                        if (f68155e) {
                            e2.printStackTrace();
                        }
                        this.f68159b.h(e2);
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    cursor = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", "config", str), null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                String string2 = cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH));
                                int i2 = cursor.getInt(cursor.getColumnIndex("cycle"));
                                k kVar = new k(string, string2, i2 == 0 ? "1" : "0", i2, cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("reserve1")));
                                String string3 = cursor.getString(cursor.getColumnIndex("extend"));
                                if (!TextUtils.isEmpty(string3)) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(string3);
                                        String optString = jSONObject.optString("dfc");
                                        if (!TextUtils.isEmpty(optString)) {
                                            kVar.setIsDefaultConfig(optString);
                                        }
                                        String optString2 = jSONObject.optString("version");
                                        if (!TextUtils.isEmpty(optString2)) {
                                            kVar.u(optString2);
                                        }
                                        String optString3 = jSONObject.optString("uploadType");
                                        if (!TextUtils.isEmpty(optString3)) {
                                            kVar.setUploadType(optString3);
                                        }
                                        int optInt = jSONObject.optInt("lcache", 2);
                                        if (optInt == 1 || optInt == 0) {
                                            kVar.p(optInt);
                                        }
                                    } catch (JSONException e3) {
                                        if (f68155e) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                                String string4 = cursor.getString(cursor.getColumnIndex("reallog"));
                                if (!TextUtils.isEmpty(string4)) {
                                    kVar.setReallog(string4);
                                }
                                Closeables.closeSafely(cursor);
                                return kVar;
                            }
                        } catch (RuntimeException e4) {
                            e = e4;
                            if (f68155e) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            return null;
                        }
                    }
                } catch (RuntimeException e5) {
                    e = e5;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                    Closeables.closeSafely((Cursor) str);
                    throw th;
                }
                Closeables.closeSafely(cursor);
                return null;
            } finally {
                this.f68161d.readLock().unlock();
            }
        }
        return (k) invokeL.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            this.f68161d.readLock().lock();
            int i2 = 0;
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = readableDatabase.rawQuery("SELECT COUNT(eventid) FROM config", null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                i2 = cursor.getInt(0);
                            }
                        } catch (SQLException e2) {
                            if (f68155e) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        Closeables.closeSafely(cursor);
                    }
                } finally {
                    this.f68161d.readLock().unlock();
                }
            } catch (SQLException e3) {
                if (f68155e) {
                    e3.printStackTrace();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int w(ArrayList<j> arrayList, i0 i0Var) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, arrayList, i0Var)) == null) {
            this.f68158a = 0L;
            String B = B(arrayList, true);
            if (TextUtils.isEmpty(B)) {
                i2 = 0;
            } else {
                StringBuilder sb = new StringBuilder(256);
                sb.append("SELECT * ");
                sb.append(" FROM ");
                sb.append("flow");
                sb.append(" WHERE ");
                sb.append("flowid");
                sb.append(" in (");
                sb.append(B);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                i2 = z(sb.toString(), i0Var);
            }
            String B2 = B(arrayList, false);
            if (TextUtils.isEmpty(B2)) {
                return i2;
            }
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("SELECT *  FROM ");
            sb2.append("event");
            sb2.append(" WHERE ");
            sb2.append("eventid");
            sb2.append(" in (");
            sb2.append(B2);
            sb2.append(SmallTailInfo.EMOTION_SUFFIX);
            sb2.append(" AND ");
            sb2.append("flowhandle");
            sb2.append(" = ");
            sb2.append(-1);
            sb2.append(" AND ");
            sb2.append("reallog");
            sb2.append(" = \"0\"");
            return i2 | x(sb2.toString(), i0Var);
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d1 A[Catch: all -> 0x01aa, TRY_LEAVE, TryCatch #6 {all -> 0x01aa, blocks: (B:7:0x0021, B:9:0x0027, B:11:0x002d, B:13:0x0054, B:22:0x0083, B:25:0x0096, B:27:0x00af, B:30:0x00bb, B:32:0x00d1, B:34:0x00db, B:35:0x00e4, B:37:0x00ee, B:39:0x00ff, B:40:0x0104, B:41:0x010f, B:45:0x0128, B:47:0x0135, B:49:0x013b, B:51:0x0142, B:54:0x0156, B:87:0x01b1, B:89:0x01b5, B:92:0x01be, B:94:0x01c2, B:98:0x01cd, B:100:0x01d1), top: B:126:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b5 A[Catch: all -> 0x01aa, TryCatch #6 {all -> 0x01aa, blocks: (B:7:0x0021, B:9:0x0027, B:11:0x002d, B:13:0x0054, B:22:0x0083, B:25:0x0096, B:27:0x00af, B:30:0x00bb, B:32:0x00d1, B:34:0x00db, B:35:0x00e4, B:37:0x00ee, B:39:0x00ff, B:40:0x0104, B:41:0x010f, B:45:0x0128, B:47:0x0135, B:49:0x013b, B:51:0x0142, B:54:0x0156, B:87:0x01b1, B:89:0x01b5, B:92:0x01be, B:94:0x01c2, B:98:0x01cd, B:100:0x01d1), top: B:126:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c2 A[Catch: all -> 0x01aa, TRY_LEAVE, TryCatch #6 {all -> 0x01aa, blocks: (B:7:0x0021, B:9:0x0027, B:11:0x002d, B:13:0x0054, B:22:0x0083, B:25:0x0096, B:27:0x00af, B:30:0x00bb, B:32:0x00d1, B:34:0x00db, B:35:0x00e4, B:37:0x00ee, B:39:0x00ff, B:40:0x0104, B:41:0x010f, B:45:0x0128, B:47:0x0135, B:49:0x013b, B:51:0x0142, B:54:0x0156, B:87:0x01b1, B:89:0x01b5, B:92:0x01be, B:94:0x01c2, B:98:0x01cd, B:100:0x01d1), top: B:126:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int x(String str, i0 i0Var) {
        InterceptResult invokeLL;
        int i2;
        long j;
        long j2;
        int i3;
        int i4;
        String str2;
        String str3;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, str, i0Var)) == null) {
            i0 i0Var2 = i0Var;
            String str4 = "0";
            this.f68161d.readLock().lock();
            long j3 = Long.MAX_VALUE;
            try {
                try {
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = getReadableDatabase().rawQuery(str, null);
                            if (cursor == null || cursor.getCount() <= 0) {
                                j = 0;
                                i2 = 0;
                            } else {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                int columnIndex4 = cursor.getColumnIndex("reserve1");
                                int columnIndex5 = cursor.getColumnIndex("reserve2");
                                int columnIndex6 = cursor.getColumnIndex("extend");
                                long j4 = 0;
                                while (true) {
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        String string2 = cursor.getString(columnIndex);
                                        jSONObject.put("id", string2);
                                        long j5 = cursor.getLong(columnIndex2);
                                        int i5 = columnIndex2;
                                        jSONObject.put("timestamp", Long.toString(j5));
                                        if (j5 > 0) {
                                            if (j5 < j3) {
                                                j3 = j5;
                                            }
                                            if (j5 > j4) {
                                                j4 = j5;
                                            }
                                        }
                                        try {
                                            jSONObject.put("type", str4);
                                            String string3 = cursor.getString(columnIndex3);
                                            j2 = j3;
                                            if (TextUtils.isEmpty(string3)) {
                                                i4 = columnIndex;
                                                str2 = string2;
                                                i3 = columnIndex3;
                                            } else {
                                                try {
                                                    jSONObject.put("content", string3);
                                                    i3 = columnIndex3;
                                                    i4 = columnIndex;
                                                    str2 = string2;
                                                    this.f68158a += string3.getBytes("UTF-8").length;
                                                } catch (UnsupportedEncodingException e2) {
                                                    e = e2;
                                                    j = j4;
                                                    j3 = j2;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    i2 = 0;
                                                    i0Var2.p(j3, j);
                                                    return i2;
                                                } catch (RuntimeException e3) {
                                                    e = e3;
                                                    j = j4;
                                                    j3 = j2;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    i2 = 0;
                                                    i0Var2.p(j3, j);
                                                    return i2;
                                                } catch (JSONException unused) {
                                                    j = j4;
                                                    j3 = j2;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    i2 = 0;
                                                    i0Var2.p(j3, j);
                                                    return i2;
                                                }
                                            }
                                            String string4 = cursor.getString(columnIndex4);
                                            String str5 = "1";
                                            if (TextUtils.isEmpty(string4)) {
                                                str3 = str4;
                                            } else {
                                                try {
                                                    jSONObject.put("abtest", string4);
                                                    i0Var2.q("1");
                                                    str3 = str4;
                                                    this.f68158a += string4.getBytes("UTF-8").length;
                                                } catch (UnsupportedEncodingException e4) {
                                                    e = e4;
                                                    i0Var2 = i0Var;
                                                    j = j4;
                                                    j3 = j2;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    i2 = 0;
                                                    i0Var2.p(j3, j);
                                                    return i2;
                                                } catch (RuntimeException e5) {
                                                    e = e5;
                                                    i0Var2 = i0Var;
                                                    j = j4;
                                                    j3 = j2;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    i2 = 0;
                                                    i0Var2.p(j3, j);
                                                    return i2;
                                                } catch (JSONException unused2) {
                                                    i0Var2 = i0Var;
                                                    j = j4;
                                                    j3 = j2;
                                                    if (f68155e) {
                                                    }
                                                    Closeables.closeSafely(cursor);
                                                    i2 = 0;
                                                    i0Var2.p(j3, j);
                                                    return i2;
                                                }
                                            }
                                            if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                                                jSONObject.put("c", cursor.getString(columnIndex5));
                                            }
                                            if (!TextUtils.isEmpty(cursor.getString(columnIndex6))) {
                                                if (new JSONObject(cursor.getString(columnIndex6)).has("ctr")) {
                                                    jSONObject.put("of", "1");
                                                }
                                                this.f68158a += string.getBytes("UTF-8").length;
                                            }
                                            g m = g.m();
                                            String str6 = str2;
                                            jSONObject.put(Constant.ID_TYPE, m.r(str6));
                                            if (!m.z(str6)) {
                                                str5 = str3;
                                            }
                                            jSONObject.put(Constant.IS_REAL, str5);
                                            String l = m.l(str6);
                                            if (!TextUtils.isEmpty(l) && !TextUtils.equals(l, str3)) {
                                                jSONObject.put("gflow", l);
                                            }
                                            i0Var2 = i0Var;
                                            i0Var2.a(jSONObject);
                                            i0Var2.n(cursor.getString(i4));
                                            if (this.f68158a >= Config.FULL_TRACE_LOG_LIMIT || !cursor.moveToNext()) {
                                                break;
                                            }
                                            columnIndex2 = i5;
                                            str4 = str3;
                                            columnIndex = i4;
                                            j3 = j2;
                                            columnIndex3 = i3;
                                        } catch (UnsupportedEncodingException e6) {
                                            e = e6;
                                            j = j4;
                                            if (f68155e) {
                                                e.printStackTrace();
                                            }
                                            Closeables.closeSafely(cursor);
                                            i2 = 0;
                                            i0Var2.p(j3, j);
                                            return i2;
                                        } catch (RuntimeException e7) {
                                            e = e7;
                                            j = j4;
                                            if (f68155e) {
                                                e.printStackTrace();
                                            }
                                            Closeables.closeSafely(cursor);
                                            i2 = 0;
                                            i0Var2.p(j3, j);
                                            return i2;
                                        } catch (JSONException unused3) {
                                            j = j4;
                                            if (f68155e) {
                                                Log.d("UBCDatabaseHelper", "json exception:");
                                            }
                                            Closeables.closeSafely(cursor);
                                            i2 = 0;
                                            i0Var2.p(j3, j);
                                            return i2;
                                        }
                                    } catch (UnsupportedEncodingException e8) {
                                        e = e8;
                                    } catch (RuntimeException e9) {
                                        e = e9;
                                    } catch (JSONException unused4) {
                                    }
                                }
                                j = j4;
                                j3 = j2;
                                i2 = 1;
                            }
                            try {
                            } catch (SQLException e10) {
                                e = e10;
                                if (f68155e) {
                                    e.printStackTrace();
                                }
                                this.f68159b.h(e);
                                return i2;
                            }
                        } finally {
                            Closeables.closeSafely((Cursor) null);
                        }
                    } catch (UnsupportedEncodingException e11) {
                        e = e11;
                        j = 0;
                    } catch (RuntimeException e12) {
                        e = e12;
                        j = 0;
                    } catch (JSONException unused5) {
                        j = 0;
                    }
                    i0Var2.p(j3, j);
                } finally {
                    this.f68161d.readLock().unlock();
                }
            } catch (SQLException e13) {
                e = e13;
                i2 = 0;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public final ContentValues y(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, oVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("flowhandle", Integer.valueOf(oVar.e()));
            contentValues.put("eventid", oVar.g());
            contentValues.put("begintime", Long.valueOf(oVar.k()));
            if (!TextUtils.isEmpty(oVar.b())) {
                contentValues.put("content", oVar.b());
            } else if (oVar.h() != null && !TextUtils.isEmpty(oVar.h().toString())) {
                contentValues.put("content", oVar.h().toString());
            }
            if (!TextUtils.isEmpty(oVar.c())) {
                contentValues.put("reserve1", oVar.c());
            }
            if (!TextUtils.isEmpty(oVar.a())) {
                contentValues.put("reserve2", oVar.a());
            }
            if (oVar.l()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ctr", "1");
                    contentValues.put("extend", jSONObject.toString());
                } catch (JSONException e2) {
                    if (f68155e) {
                        e2.printStackTrace();
                    }
                }
            }
            if (!TextUtils.isEmpty(oVar.j())) {
                contentValues.put("reallog", oVar.j());
            } else {
                contentValues.put("reallog", "0");
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:93:0x020a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int z(java.lang.String r30, d.a.s0.i0 r31) {
        /*
            r29 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = d.a.s0.z.$ic
            if (r0 != 0) goto L289
        L4:
            r1 = r29
            r2 = r31
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f68161d
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L265 android.database.SQLException -> L267
            r4.<init>()     // Catch: java.lang.Throwable -> L265 android.database.SQLException -> L267
            android.database.sqlite.SQLiteDatabase r0 = r29.getReadableDatabase()     // Catch: java.lang.Throwable -> L265 android.database.SQLException -> L267
            r7 = 0
            r10 = r30
            android.database.Cursor r7 = r0.rawQuery(r10, r7)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            if (r7 == 0) goto L218
            int r0 = r7.getCount()     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            if (r0 <= 0) goto L218
            r7.moveToFirst()     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "flowid"
            int r11 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "flowhandle"
            int r12 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "state"
            int r13 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "begintime"
            int r14 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "endtime"
            int r15 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "content"
            int r3 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "option"
            int r5 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "reserve1"
            int r6 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "reserve2"
            int r10 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "slot"
            int r8 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            java.lang.String r0 = "extend"
            int r9 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L229 java.io.UnsupportedEncodingException -> L22b java.lang.RuntimeException -> L23e
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r20 = 0
        L75:
            java.lang.String r0 = "2"
            java.lang.String r2 = r7.getString(r13)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            boolean r0 = r0.equals(r2)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            if (r0 != 0) goto Laf
            long r22 = r7.getLong(r14)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            long r24 = java.lang.System.currentTimeMillis()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            long r22 = r22 - r24
            long r22 = java.lang.Math.abs(r22)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r24 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r0 <= 0) goto L9f
            int r0 = r7.getInt(r5)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r0 = r0 & 4
            if (r0 == 0) goto L9f
            goto Laf
        L9f:
            r26 = r3
            r22 = r11
            r23 = r12
            r11 = r13
            r24 = r14
            r3 = 1
            r18 = 0
            r12 = r31
            goto L1db
        Laf:
            d.a.s0.q r2 = new d.a.s0.q     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r2.<init>()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            java.lang.String r0 = r7.getString(r11)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r2.u(r0)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            int r0 = r7.getInt(r12)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r2.t(r0)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r22 = r11
            r23 = r12
            long r11 = r7.getLong(r14)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r2.m(r11)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            long r11 = r7.getLong(r15)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r2.q(r11)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Lec
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto Lec
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r20 = r11
        Lec:
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto L104
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            int r0 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r0 >= 0) goto L104
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r16 = r11
        L104:
            java.lang.String r0 = r7.getString(r3)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            java.lang.String r12 = "UTF-8"
            if (r11 != 0) goto L126
            r2.o(r0)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r11 = r13
            r24 = r14
            long r13 = r1.f68158a     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r26 = r3
            r25 = r4
            long r3 = (long) r0
            long r13 = r13 + r3
            r1.f68158a = r13     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            goto L12d
        L126:
            r26 = r3
            r25 = r4
            r11 = r13
            r24 = r14
        L12d:
            java.lang.String r0 = r7.getString(r6)     // Catch: java.io.UnsupportedEncodingException -> L1f6 java.lang.RuntimeException -> L1fc java.lang.Throwable -> L229
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1f6 java.lang.RuntimeException -> L1fc java.lang.Throwable -> L229
            if (r3 != 0) goto L15c
            r2.s(r0)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r3 = r1.f68158a     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r13 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r3 = r3 + r13
            r1.f68158a = r3     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            goto L15c
        L146:
            r0 = move-exception
            r12 = r31
            r5 = r16
            r8 = r20
            r4 = r25
            goto L236
        L151:
            r0 = move-exception
            r12 = r31
            r5 = r16
            r8 = r20
            r4 = r25
            goto L249
        L15c:
            java.lang.String r0 = r7.getString(r10)     // Catch: java.io.UnsupportedEncodingException -> L1f6 java.lang.RuntimeException -> L1fc java.lang.Throwable -> L229
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1f6 java.lang.RuntimeException -> L1fc java.lang.Throwable -> L229
            if (r0 != 0) goto L16d
            java.lang.String r0 = r7.getString(r10)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            r2.n(r0)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
        L16d:
            java.lang.String r0 = r7.getString(r8)     // Catch: java.io.UnsupportedEncodingException -> L1f6 java.lang.RuntimeException -> L1fc java.lang.Throwable -> L229
            if (r8 < 0) goto L187
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            if (r3 != 0) goto L187
            r2.v(r0)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r3 = r1.f68158a     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r13 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r3 = r3 + r13
            r1.f68158a = r3     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
        L187:
            java.lang.String r0 = r7.getString(r9)     // Catch: java.io.UnsupportedEncodingException -> L1f6 java.lang.RuntimeException -> L1fc java.lang.Throwable -> L229
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1f6 java.lang.RuntimeException -> L1fc java.lang.Throwable -> L229
            if (r3 != 0) goto L1ba
            long r3 = r1.f68158a     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r12 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            long r3 = r3 + r12
            r1.f68158a = r3     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 org.json.JSONException -> L1b4 java.lang.Throwable -> L229
            java.lang.String r3 = r7.getString(r9)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 org.json.JSONException -> L1b4 java.lang.Throwable -> L229
            r0.<init>(r3)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 org.json.JSONException -> L1b4 java.lang.Throwable -> L229
            java.lang.String r3 = "ctr"
            boolean r0 = r0.has(r3)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 org.json.JSONException -> L1b4 java.lang.Throwable -> L229
            if (r0 == 0) goto L1ba
            r3 = 1
            r2.p(r3)     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 org.json.JSONException -> L1b2 java.lang.Throwable -> L229
            goto L1bb
        L1b2:
            r0 = move-exception
            goto L1b6
        L1b4:
            r0 = move-exception
            r3 = 1
        L1b6:
            r0.printStackTrace()     // Catch: java.io.UnsupportedEncodingException -> L146 java.lang.RuntimeException -> L151 java.lang.Throwable -> L229
            goto L1bb
        L1ba:
            r3 = 1
        L1bb:
            r4 = r25
            r4.add(r2)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            int r0 = r2.f()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            java.lang.String r2 = r2.g()     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.io.UnsupportedEncodingException -> L202 java.lang.RuntimeException -> L206 java.lang.Throwable -> L229
            r12 = r31
            r12.o(r0, r2)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f4 java.lang.Throwable -> L229
            long r13 = r1.f68158a     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f4 java.lang.Throwable -> L229
            r27 = 10485760(0xa00000, double:5.180654E-317)
            int r0 = (r13 > r27 ? 1 : (r13 == r27 ? 0 : -1))
            if (r0 < 0) goto L1db
            goto L1e1
        L1db:
            boolean r0 = r7.moveToNext()     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f4 java.lang.Throwable -> L229
            if (r0 != 0) goto L1e6
        L1e1:
            r5 = r16
            r8 = r20
            goto L223
        L1e6:
            r13 = r11
            r2 = r12
            r11 = r22
            r12 = r23
            r14 = r24
            r3 = r26
            goto L75
        L1f2:
            r0 = move-exception
            goto L20c
        L1f4:
            r0 = move-exception
            goto L213
        L1f6:
            r0 = move-exception
            r12 = r31
            r4 = r25
            goto L20c
        L1fc:
            r0 = move-exception
            r12 = r31
            r4 = r25
            goto L213
        L202:
            r0 = move-exception
            r12 = r31
            goto L20c
        L206:
            r0 = move-exception
            r12 = r31
            goto L213
        L20a:
            r0 = move-exception
            r12 = r2
        L20c:
            r5 = r16
            r8 = r20
            goto L236
        L211:
            r0 = move-exception
            r12 = r2
        L213:
            r5 = r16
            r8 = r20
            goto L249
        L218:
            r12 = r2
            r18 = 0
            r8 = r18
            r3 = 0
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L223:
            com.baidu.android.util.io.Closeables.closeSafely(r7)     // Catch: android.database.SQLException -> L227 java.lang.Throwable -> L265
            goto L254
        L227:
            r0 = move-exception
            goto L269
        L229:
            r0 = move-exception
            goto L261
        L22b:
            r0 = move-exception
            r12 = r2
            r18 = 0
            r8 = r18
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L236:
            boolean r2 = d.a.s0.z.f68155e     // Catch: java.lang.Throwable -> L229
            if (r2 == 0) goto L250
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L229
            goto L250
        L23e:
            r0 = move-exception
            r12 = r2
            r18 = 0
            r8 = r18
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L249:
            boolean r2 = d.a.s0.z.f68155e     // Catch: java.lang.Throwable -> L229
            if (r2 == 0) goto L250
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L229
        L250:
            com.baidu.android.util.io.Closeables.closeSafely(r7)     // Catch: java.lang.Throwable -> L265 android.database.SQLException -> L267
            r3 = 0
        L254:
            int r0 = r4.size()     // Catch: android.database.SQLException -> L227 java.lang.Throwable -> L265
            if (r0 <= 0) goto L25d
            r1.A(r4, r12)     // Catch: android.database.SQLException -> L227 java.lang.Throwable -> L265
        L25d:
            r12.p(r5, r8)     // Catch: android.database.SQLException -> L227 java.lang.Throwable -> L265
            goto L275
        L261:
            com.baidu.android.util.io.Closeables.closeSafely(r7)     // Catch: java.lang.Throwable -> L265 android.database.SQLException -> L267
            throw r0     // Catch: java.lang.Throwable -> L265 android.database.SQLException -> L267
        L265:
            r0 = move-exception
            goto L27f
        L267:
            r0 = move-exception
            r3 = 0
        L269:
            boolean r2 = d.a.s0.z.f68155e     // Catch: java.lang.Throwable -> L265
            if (r2 == 0) goto L270
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L265
        L270:
            d.a.s0.b r2 = r1.f68159b     // Catch: java.lang.Throwable -> L265
            r2.h(r0)     // Catch: java.lang.Throwable -> L265
        L275:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f68161d
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r3
        L27f:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f68161d
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        L289:
            r27 = r0
            r28 = 1048620(0x10002c, float:1.46943E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r27.invokeLL(r28, r29, r30, r31)
            if (r0 == 0) goto L4
            int r1 = r0.intValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.s0.z.z(java.lang.String, d.a.s0.i0):int");
    }
}
