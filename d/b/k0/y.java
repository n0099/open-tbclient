package d.b.k0;

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
import com.baidu.android.util.io.Closeables;
import com.baidu.mobstat.Config;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteKey;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
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
/* loaded from: classes5.dex */
public class y extends SQLiteOpenHelper {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f63999e = AppConfig.isDebug();

    /* renamed from: f  reason: collision with root package name */
    public static y f64000f = null;

    /* renamed from: g  reason: collision with root package name */
    public static ReentrantLock f64001g = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    public long f64002a;

    /* renamed from: b  reason: collision with root package name */
    public b f64003b;

    /* renamed from: c  reason: collision with root package name */
    public Context f64004c;

    /* renamed from: d  reason: collision with root package name */
    public ReentrantReadWriteLock f64005d;

    public y(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.f64005d = new ReentrantReadWriteLock(true);
        this.f64003b = new b(context);
        this.f64004c = context;
    }

    public static y D(Context context) {
        if (f64000f == null) {
            f64001g.lock();
            if (f64000f == null) {
                f64000f = new y(context);
            }
            f64001g.unlock();
        }
        return f64000f;
    }

    public final void A(ArrayList<p> arrayList, h0 h0Var) {
        String str;
        String str2;
        String str3;
        String str4 = "begintime";
        String str5 = " , ";
        String str6 = "eventid";
        this.f64005d.readLock().lock();
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                try {
                    Iterator<p> it = arrayList.iterator();
                    Cursor cursor = null;
                    while (it.hasNext()) {
                        p next = it.next();
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
                                h0Var.q("1");
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
                                h0Var.a(jSONObject);
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
                    if (f63999e) {
                        e2.printStackTrace();
                    }
                } catch (JSONException unused) {
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "json exception:");
                    }
                }
            } finally {
                this.f64005d.readLock().unlock();
            }
        } catch (SQLException e3) {
            if (f63999e) {
                e3.printStackTrace();
            }
            this.f64003b.h(e3);
        }
    }

    public final String B(ArrayList<j> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            j jVar = arrayList.get(i2);
            if (z && !"0".equals(jVar.b())) {
                if (i > 0) {
                    sb.append(",");
                } else {
                    i++;
                }
                sb.append(jVar.a());
            } else if (!z && "0".equals(jVar.b())) {
                if (i > 0) {
                    sb.append(",");
                } else {
                    i++;
                }
                sb.append(jVar.a());
            }
        }
        return sb.toString();
    }

    public final String C(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }

    public int E(h0 h0Var) {
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
        return x(sb.toString(), h0Var);
    }

    public o F(String str) {
        Cursor cursor;
        this.f64005d.readLock().lock();
        o oVar = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    cursor = getReadableDatabase().rawQuery("SELECT state , reserve1 FROM file WHERE " + BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                oVar = new o(str, cursor.getString(cursor.getColumnIndex("state")), cursor.isNull(cursor.getColumnIndex("reserve1")) ? "" : cursor.getString(cursor.getColumnIndex("reserve1")));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            if (f63999e) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            return oVar;
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
                if (f63999e) {
                    e4.printStackTrace();
                }
                this.f64003b.h(e4);
            }
            return oVar;
        } finally {
            this.f64005d.readLock().unlock();
        }
    }

    public void G(SparseArray<ArrayList> sparseArray) {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        this.f64005d.readLock().lock();
        try {
            try {
                readableDatabase = getReadableDatabase();
                cursor = null;
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
                this.f64003b.h(e2);
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
                            int i = cursor.getInt(columnIndex3);
                            if (i != 0) {
                                if (i < 6) {
                                    i = 6;
                                } else if (i > 720) {
                                    i = PeerConnectionClient.HD_VIDEO_HEIGHT;
                                }
                            }
                            if (string != null) {
                                ArrayList arrayList = sparseArray.get(i);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    sparseArray.put(i, arrayList);
                                }
                                arrayList.add(new j(string, string2));
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (RuntimeException e3) {
                    if (f63999e) {
                        e3.printStackTrace();
                    }
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
        } finally {
            this.f64005d.readLock().unlock();
        }
    }

    public void H(f fVar) {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        f fVar2;
        Cursor cursor2;
        y yVar = this;
        yVar.f64005d.readLock().lock();
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
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (RuntimeException e3) {
                e = e3;
            }
        } catch (SQLException e4) {
            e = e4;
            yVar = this;
            if (f63999e) {
                e.printStackTrace();
            }
            yVar.f64003b.h(e);
            yVar.f64005d.readLock().unlock();
        } catch (Throwable th4) {
            th = th4;
            yVar = this;
            yVar.f64005d.readLock().unlock();
            throw th;
        }
        if (cursor != null) {
            try {
            } catch (RuntimeException e5) {
                e = e5;
            } catch (Throwable th5) {
                th = th5;
                yVar = this;
                Closeables.closeSafely(cursor);
                throw th;
            }
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (true) {
                    String string = cursor.getString(cursor.getColumnIndex("eventid"));
                    String string2 = cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH));
                    int i = cursor.getInt(cursor.getColumnIndex("sample"));
                    String string3 = cursor.getString(cursor.getColumnIndex("reserve1"));
                    String string4 = cursor.getString(cursor.getColumnIndex("reserve2"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("cycle"));
                    int i3 = cursor.getInt(cursor.getColumnIndex("uploadrule"));
                    int i4 = cursor.getInt(cursor.getColumnIndex("recordrule"));
                    String string5 = cursor.getString(cursor.getColumnIndex("extend"));
                    String string6 = cursor.getString(cursor.getColumnIndex("reallog"));
                    cursor2 = cursor;
                    if (TextUtils.equals(string2, "0")) {
                        try {
                            fVar2.f63927a.add(string);
                        } catch (RuntimeException e6) {
                            e = e6;
                            cursor = cursor2;
                            if (f63999e) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            yVar = this;
                            yVar.f64005d.readLock().unlock();
                        } catch (Throwable th6) {
                            th = th6;
                            yVar = this;
                            cursor = cursor2;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    } else if (TextUtils.equals(string2, "1")) {
                        fVar2.f63930d.add(string);
                    }
                    if (i2 == 0) {
                        fVar2.f63928b.add(string);
                    }
                    if (TextUtils.equals(string3, "1")) {
                        fVar2.f63929c.add(string);
                    }
                    if (i > 0) {
                        fVar2.f63932f.put(string, String.valueOf(i));
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        fVar2.f63933g.put(string, string4);
                    }
                    if (i3 != 0 && i4 != 0) {
                        fVar2.f63934h.put(string, new m(string, i4, i3));
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string5);
                            if (jSONObject.has(Constant.ID_TYPE)) {
                                fVar2.i.add(string);
                            }
                            if (jSONObject.has("ch") && TextUtils.equals(jSONObject.getString("ch"), "1")) {
                                fVar2.f63931e.add(string);
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
                yVar = this;
                yVar.f64005d.readLock().unlock();
            }
        }
        cursor2 = cursor;
        Closeables.closeSafely(cursor2);
        yVar = this;
        yVar.f64005d.readLock().unlock();
    }

    public void I(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.g())) {
            this.f64005d.writeLock().lock();
            try {
                try {
                    ContentValues y = y(nVar);
                    String f2 = nVar.f();
                    String g2 = nVar.g();
                    int e2 = nVar.e();
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        if (g(f2, g2, e2, writableDatabase)) {
                            long insert = writableDatabase.insert("event", null, y);
                            if (f63999e) {
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
                    this.f64005d.writeLock().unlock();
                }
            } catch (SQLException e3) {
                if (f63999e) {
                    e3.printStackTrace();
                }
                this.f64003b.h(e3);
            }
        } else if (f63999e) {
            Log.d("UBCDatabaseHelper", "saveEvent#event id must not be null");
        }
    }

    public void J(List<n> list) {
        if (list != null && list.size() != 0) {
            for (n nVar : list) {
                I(nVar);
            }
        } else if (f63999e) {
            Log.d("UBCDatabaseHelper", "saveEvents#data must not be null");
        }
    }

    public void K(p pVar) {
        SQLiteDatabase writableDatabase;
        if (pVar != null && !TextUtils.isEmpty(pVar.g())) {
            this.f64005d.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (f63999e) {
                        e2.printStackTrace();
                    }
                    this.f64003b.h(e2);
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("flowid", pVar.g());
                    contentValues.put("flowhandle", Integer.valueOf(pVar.f()));
                    contentValues.put("state", pVar.k());
                    contentValues.put("begintime", Long.valueOf(pVar.a()));
                    if (pVar.h() != null) {
                        contentValues.put("content", pVar.h().toString());
                    } else {
                        contentValues.put("content", pVar.c());
                    }
                    contentValues.put("option", Integer.valueOf(pVar.i()));
                    contentValues.put("reserve1", pVar.e());
                    if (!TextUtils.isEmpty(pVar.b())) {
                        contentValues.put("reserve2", pVar.b());
                    }
                    if (pVar.l()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("ctr", "1");
                            contentValues.put("extend", jSONObject.toString());
                        } catch (JSONException e3) {
                            if (f63999e) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    long insert = writableDatabase.insert("flow", null, contentValues);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "saveFlow#performTransaction: rowId=" + insert);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } finally {
                this.f64005d.writeLock().unlock();
            }
        } else if (f63999e) {
            Log.d("UBCDatabaseHelper", "saveFlow#event id must not be null");
        }
    }

    public void L() {
        this.f64005d.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", "1");
                    int update = writableDatabase.update("file", contentValues, null, null);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "updateAllSentFileFail#performTransaction: update file table:" + update);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
                this.f64003b.h(e2);
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public boolean M(List<k> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        this.f64005d.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                SQLiteStatement compileStatement = writableDatabase.compileStatement("replace into config(eventid,type,recordrule,uploadrule,cycle," + SetImageWatermarkTypeReqMsg.SWITCH + ",sample,reserve1,reserve2,extend,reallog" + SmallTailInfo.EMOTION_SUFFIX + " values(?,?,?,?,?,?,?,?,?,?,?)");
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        for (k kVar : list) {
                            compileStatement.clearBindings();
                            compileStatement.bindString(1, kVar.d());
                            compileStatement.bindString(2, kVar.p());
                            if (kVar.i() != 0 && kVar.h() != 0) {
                                compileStatement.bindLong(3, kVar.i());
                                compileStatement.bindLong(4, kVar.h());
                            }
                            if ("1".equals(kVar.g())) {
                                compileStatement.bindLong(5, 0L);
                            } else {
                                compileStatement.bindLong(5, kVar.o());
                            }
                            compileStatement.bindString(6, kVar.n());
                            compileStatement.bindLong(7, kVar.l());
                            compileStatement.bindString(8, kVar.a());
                            if (!TextUtils.isEmpty(kVar.b())) {
                                compileStatement.bindString(9, kVar.b());
                            }
                            JSONObject jSONObject = new JSONObject();
                            if (TextUtils.equals(kVar.e(), "1")) {
                                jSONObject.put(Constant.ID_TYPE, "1");
                            }
                            if (TextUtils.equals(kVar.k(), "1")) {
                                jSONObject.put("ch", "1");
                            }
                            if (TextUtils.equals(kVar.f(), "1")) {
                                jSONObject.put("dfc", "1");
                            }
                            if (kVar.r() != null) {
                                jSONObject.put("version", kVar.r());
                            }
                            String c2 = kVar.c();
                            if (!TextUtils.isEmpty(c2) && !TextUtils.equals(c2, "0")) {
                                jSONObject.put("gflow", c2);
                            }
                            String q = kVar.q();
                            if (!TextUtils.isEmpty(q)) {
                                jSONObject.put("uploadType", q);
                            }
                            int j = kVar.j();
                            if (j != 2) {
                                jSONObject.put("lcache", j);
                            }
                            String jSONObject2 = jSONObject.toString();
                            if (!TextUtils.isEmpty(jSONObject2)) {
                                compileStatement.bindString(10, jSONObject2);
                            }
                            if (TextUtils.equals(kVar.m(), "1")) {
                                compileStatement.bindString(11, kVar.m());
                            } else {
                                compileStatement.bindString(11, "0");
                            }
                            if (compileStatement.executeUpdateDelete() <= 0) {
                                return false;
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        if (f63999e) {
                            Log.d("UBCDatabaseHelper", "updateConfig success count: " + list.size());
                        }
                        return true;
                    } catch (JSONException e2) {
                        if (f63999e) {
                            e2.printStackTrace();
                        }
                        writableDatabase.endTransaction();
                        return false;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e3) {
                if (f63999e) {
                    e3.printStackTrace();
                }
                this.f64003b.h(e3);
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public void N(String str, int i, String str2) {
        SQLiteDatabase writableDatabase;
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            this.f64005d.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (f63999e) {
                        e2.printStackTrace();
                    }
                    this.f64003b.h(e2);
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content", str2);
                    int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i, null);
                    if (f63999e && update != 1) {
                        Log.d("UBCDatabaseHelper", "updateFlowValue#performTransaction: updateFlowValue count:" + update);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } finally {
                this.f64005d.writeLock().unlock();
            }
        } else if (f63999e) {
            Log.d("UBCDatabaseHelper", "updateFlowValue#flowHandle invalid");
        }
    }

    public void O(String str) {
        SQLiteDatabase writableDatabase;
        this.f64005d.writeLock().lock();
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
                this.f64003b.h(e2);
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                int update = writableDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                if (f63999e) {
                    Log.d("UBCDatabaseHelper", "updateSendedFileFail#performTransaction: update file table:" + update);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public void P(String str, String str2) {
        this.f64005d.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", str2);
                    writableDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
                this.f64003b.h(e2);
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e2) {
            if (f63999e) {
                e2.printStackTrace();
            }
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e2) {
            if (f63999e) {
                e2.printStackTrace();
            }
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase, p pVar, h0 h0Var) {
        try {
            if (pVar.f() < 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", pVar.g());
                jSONObject.put("starttime", Long.toString(pVar.a()));
                jSONObject.put("endtime", Long.toString(pVar.d()));
                jSONObject.put("type", "1");
                g m = g.m();
                jSONObject.put(Constant.IS_REAL, m.z(pVar.g()) ? "1" : "0");
                String l = m.l(pVar.g());
                if (!TextUtils.isEmpty(l) && !TextUtils.equals(l, "0")) {
                    jSONObject.put("gflow", l);
                }
                if (!TextUtils.isEmpty(pVar.c())) {
                    jSONObject.put("content", pVar.c());
                }
                if (!TextUtils.isEmpty(pVar.e())) {
                    jSONObject.put("abtest", pVar.e());
                    h0Var.q("1");
                }
                if (!TextUtils.isEmpty(pVar.b())) {
                    jSONObject.put("c", pVar.b());
                }
                if (pVar.j() != null) {
                    jSONObject.put("part", pVar.j());
                }
                if (pVar.l()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put(Constant.ID_TYPE, m.r(pVar.g()));
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
                sb.append(pVar.f());
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
                    h0Var.a(jSONObject);
                } catch (Throwable th) {
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            } catch (RuntimeException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
            } catch (JSONException unused) {
                if (f63999e) {
                    Log.d("UBCDatabaseHelper", "json exception:");
                }
            }
        } catch (SQLException e3) {
            if (f63999e) {
                e3.printStackTrace();
            }
            this.f64003b.h(e3);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        Log.w("UBCDatabaseHelper", "Database is being closed");
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
        } catch (SQLException e2) {
            if (f63999e) {
                e2.printStackTrace();
            }
        }
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
        } catch (SQLException e2) {
            if (f63999e) {
                e2.printStackTrace();
            }
        }
    }

    public void f(String str, int i) {
        SQLiteDatabase writableDatabase;
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            this.f64005d.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (f63999e) {
                        e2.printStackTrace();
                    }
                    this.f64003b.h(e2);
                }
                try {
                    int delete = writableDatabase.delete("flow", "flowid=\"" + str + "\" AND flowhandle = " + i, null);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow flow count:" + delete);
                    }
                    int delete2 = writableDatabase.delete("event", "flowhandle = " + i, null);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow event count:" + delete2);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } finally {
                this.f64005d.writeLock().unlock();
            }
        } else if (f63999e) {
            Log.d("UBCDatabaseHelper", "cancelFlow#flowHandle invalid");
        }
    }

    public final boolean g(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        this.f64005d.writeLock().lock();
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
                                try {
                                    cursor = sQLiteDatabase.rawQuery("SELECT state FROM flow WHERE flowhandle = " + i, null);
                                    if (cursor != null && cursor.getCount() > 0) {
                                        cursor.moveToFirst();
                                        String string = cursor.getString(0);
                                        if (!TextUtils.isEmpty(string)) {
                                            if ("1".equals(string)) {
                                                z = true;
                                            }
                                        }
                                    }
                                } catch (RuntimeException e2) {
                                    if (f63999e) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (SQLException e3) {
                                if (f63999e) {
                                    e3.printStackTrace();
                                }
                                this.f64003b.h(e3);
                            }
                        } finally {
                            Closeables.closeSafely(cursor);
                        }
                    } catch (SQLException e4) {
                        e = e4;
                        if (f63999e) {
                            e.printStackTrace();
                        }
                        this.f64003b.h(e);
                        return z;
                    }
                }
                return z;
            } catch (SQLException e5) {
                e = e5;
                z = true;
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x01d9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ae A[Catch: all -> 0x01d9, TryCatch #6 {all -> 0x01d9, blocks: (B:53:0x019d, B:54:0x01a0, B:61:0x01aa, B:63:0x01ae, B:64:0x01b1), top: B:81:0x0014 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v3, types: [d.b.k0.a0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        int i;
        int i2;
        SQLiteDatabase writableDatabase;
        ?? r2 = "flowhandle";
        this.f64005d.writeLock().lock();
        int i3 = 0;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
            } catch (Throwable th) {
                th = th;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis() - g.m().j();
                Cursor cursor = null;
                int delete = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                try {
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count:" + delete);
                    }
                    i = writableDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                    try {
                        if (f63999e) {
                            Log.d("UBCDatabaseHelper", "clearInvalidData: delete event count:" + i);
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
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor = rawQuery;
                                    Closeables.closeSafely(cursor);
                                    throw th;
                                }
                            }
                            Closeables.closeSafely(rawQuery);
                            if (arrayList.size() > 0) {
                                if (f63999e) {
                                    Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count2:" + arrayList.size());
                                }
                                i3 = arrayList.size();
                                try {
                                    String C = C(arrayList);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("flowhandle");
                                    sb2.append(" in (");
                                    sb2.append(C);
                                    sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                                    writableDatabase.delete("flow", sb2.toString(), null);
                                    writableDatabase.delete("event", sb2.toString(), null);
                                } catch (Throwable th3) {
                                    th = th3;
                                    i2 = i3;
                                    i3 = delete;
                                    try {
                                        writableDatabase.endTransaction();
                                        throw th;
                                    } catch (SQLException e2) {
                                        e = e2;
                                        if (f63999e) {
                                            e.printStackTrace();
                                        }
                                        this.f64003b.h(e);
                                        this.f64005d.writeLock().unlock();
                                        if (i3 <= 0 || i > 0 || i2 > 0) {
                                            a0.a().e(String.valueOf(g.m().j()), i3, i, i2);
                                        }
                                        return;
                                    }
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            try {
                                writableDatabase.endTransaction();
                                p("flow");
                                p("event");
                                this.f64005d.writeLock().unlock();
                                if (delete > 0 || i > 0 || i3 > 0) {
                                    a0.a().e(String.valueOf(g.m().j()), delete, i, i3);
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                i2 = i3;
                                i3 = delete;
                                if (f63999e) {
                                }
                                this.f64003b.h(e);
                                this.f64005d.writeLock().unlock();
                                if (i3 <= 0) {
                                }
                                a0.a().e(String.valueOf(g.m().j()), i3, i, i2);
                            } catch (Throwable th4) {
                                th = th4;
                                r2 = i3;
                                i3 = delete;
                                this.f64005d.writeLock().unlock();
                                if (i3 > 0 || i > 0 || r2 > 0) {
                                    a0.a().e(String.valueOf(g.m().j()), i3, i, r2);
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        i3 = delete;
                        i2 = 0;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    i3 = delete;
                    i2 = 0;
                    i = 0;
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (SQLException e4) {
            e = e4;
            i2 = 0;
            i = 0;
        } catch (Throwable th9) {
            th = th9;
            r2 = 0;
            i = 0;
        }
    }

    public boolean i(SparseArray<Integer> sparseArray, ArrayList<String> arrayList, boolean z, String str) {
        boolean z2;
        SQLiteDatabase writableDatabase;
        this.f64005d.writeLock().lock();
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                if (sparseArray != null) {
                    try {
                        if (sparseArray.size() > 0) {
                            int size = sparseArray.size();
                            ArrayList arrayList2 = new ArrayList(size);
                            for (int i = 0; i < size; i++) {
                                arrayList2.add(Integer.valueOf(sparseArray.keyAt(i)));
                            }
                            String C = C(arrayList2);
                            if (f63999e) {
                                Log.d("UBCDatabaseHelper", "save file name " + str + " delete flow handle ids = " + C);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("flowhandle");
                            sb.append(" in (");
                            sb.append(C);
                            sb.append(SmallTailInfo.EMOTION_SUFFIX);
                            int delete = writableDatabase.delete("flow", sb.toString(), null);
                            if (f63999e) {
                                Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: flow table delete count:" + delete);
                            }
                            int delete2 = writableDatabase.delete("event", sb.toString(), null);
                            if (f63999e) {
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
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "delete event ids = " + C2);
                    }
                    int delete3 = writableDatabase.delete("event", "eventid in (" + C2 + SmallTailInfo.EMOTION_SUFFIX + " AND flowhandle = -1", null);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: event table count2:" + delete3);
                    }
                }
                if ((sparseArray != null && sparseArray.size() > 0) || (arrayList != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(BreakpointSQLiteKey.FILENAME, str);
                    contentValues.put("state", "0");
                    contentValues.put("reserve1", z ? "1" : "0");
                    long insert = writableDatabase.insert("file", null, contentValues);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "clearUploadedData#save file: rowId=" + insert);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (SQLException e2) {
                e = e2;
                z2 = false;
            }
            try {
                writableDatabase.endTransaction();
                this.f64005d.writeLock().unlock();
                return true;
            } catch (SQLException e3) {
                e = e3;
                z2 = true;
                if (f63999e) {
                    e.printStackTrace();
                }
                this.f64003b.h(e);
                return z2;
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        } catch (SQLException e2) {
            if (f63999e) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k() {
        int i;
        this.f64005d.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                try {
                    i = writableDatabase.delete("event", "reallog =?", new String[]{"1"});
                    try {
                        writableDatabase.setTransactionSuccessful();
                    } catch (SQLException e2) {
                        e = e2;
                        if (f63999e) {
                            e.printStackTrace();
                        }
                        this.f64003b.h(e);
                        return i > 0;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    i = 0;
                }
                return i > 0;
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e4) {
            if (f63999e) {
                e4.printStackTrace();
            }
            this.f64003b.h(e4);
            return false;
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public void l() {
        this.f64005d.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int delete = writableDatabase.delete("file", null, null);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "deleteAllSentFile#performTransaction: delete file table:" + delete);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
                this.f64003b.h(e2);
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f64005d.writeLock().lock();
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
            if (f63999e) {
                e2.printStackTrace();
            }
            this.f64003b.h(e2);
            return false;
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public void n(String str) {
        this.f64005d.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int delete = writableDatabase.delete("file", BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                    if (f63999e) {
                        Log.d("UBCDatabaseHelper", "deleteSendedFile#performTransaction: delete file table:" + delete);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
                this.f64003b.h(e2);
            }
        } finally {
            this.f64005d.writeLock().unlock();
        }
    }

    public void o(String str, int i, long j, JSONArray jSONArray) {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            this.f64005d.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "2");
                        contentValues.put("endtime", Long.valueOf(j));
                        if (jSONArray != null && jSONArray.length() > 0) {
                            contentValues.put("slot", jSONArray.toString());
                        }
                        int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i, null);
                        if (f63999e && update != 1) {
                            Log.d("UBCDatabaseHelper", "endFlow#performTransaction: endFlow count:" + update);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f63999e) {
                        e2.printStackTrace();
                    }
                    this.f64003b.h(e2);
                }
            } finally {
                this.f64005d.writeLock().unlock();
            }
        } else if (f63999e) {
            Log.d("UBCDatabaseHelper", "endFlow#flowHandle invalid");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.enableWriteAheadLogging();
        super.onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (f63999e) {
            Log.i("UBCDatabaseHelper", "Creating database bdbehavior.db version 7");
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
            sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            g0.e().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, "0");
        } catch (Exception e2) {
            Log.w("UBCDatabaseHelper", "Error while creating db: " + e2.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.beginTransaction();
            while (i < i2) {
                if (i == 1) {
                    j(sQLiteDatabase);
                } else if (i == 2) {
                    e(sQLiteDatabase);
                } else if (i == 3) {
                    a(sQLiteDatabase);
                } else if (i == 4) {
                    b(sQLiteDatabase);
                } else if (i == 6) {
                    d(sQLiteDatabase);
                }
                i++;
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00b9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[Catch: all -> 0x00be, TryCatch #5 {all -> 0x00be, blocks: (B:4:0x0013, B:17:0x0062, B:27:0x0078, B:29:0x0091, B:30:0x00a7, B:26:0x0074, B:36:0x00ba, B:37:0x00bd), top: B:61:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(String str) {
        SQLiteDatabase writableDatabase;
        Throwable th;
        Cursor cursor;
        int i;
        this.f64005d.writeLock().lock();
        int i2 = 0;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
                this.f64003b.h(e2);
                this.f64005d.writeLock().unlock();
                if (0 <= 0) {
                    return;
                }
            }
            try {
                ?? sb = new StringBuilder();
                sb.append("SELECT COUNT(*), MIN(");
                sb.append("_id");
                sb.append("), MAX(");
                sb.append("_id");
                sb.append(") FROM ");
                sb.append(str);
                try {
                    try {
                        cursor = writableDatabase.rawQuery(sb.toString(), null);
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Cursor) sb);
                        throw th;
                    }
                } catch (RuntimeException e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th3) {
                    sb = 0;
                    th = th3;
                    Closeables.closeSafely((Cursor) sb);
                    throw th;
                }
                if (cursor != null) {
                    try {
                    } catch (RuntimeException e4) {
                        e = e4;
                        if (f63999e) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        i = 0;
                        i2 = writableDatabase.delete(str, "_id < " + i, null);
                        if (f63999e) {
                        }
                        writableDatabase.setTransactionSuccessful();
                        this.f64005d.writeLock().unlock();
                        if (i2 <= 0) {
                        }
                        a0.a().b(String.valueOf(g.m().k()), i2, str);
                    }
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        if (cursor.getInt(0) > g.m().k()) {
                            i = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                            Closeables.closeSafely(cursor);
                            i2 = writableDatabase.delete(str, "_id < " + i, null);
                            if (f63999e) {
                                Log.d("UBCDatabaseHelper", "ensureDataBaseLimit#performTransaction: delete count:" + i2);
                            }
                            writableDatabase.setTransactionSuccessful();
                            this.f64005d.writeLock().unlock();
                            if (i2 <= 0) {
                                return;
                            }
                            a0.a().b(String.valueOf(g.m().k()), i2, str);
                        }
                    }
                }
                i = 0;
                Closeables.closeSafely(cursor);
                i2 = writableDatabase.delete(str, "_id < " + i, null);
                if (f63999e) {
                }
                writableDatabase.setTransactionSuccessful();
                this.f64005d.writeLock().unlock();
                if (i2 <= 0) {
                }
                a0.a().b(String.valueOf(g.m().k()), i2, str);
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (Throwable th4) {
            this.f64005d.writeLock().unlock();
            if (0 > 0) {
                a0.a().b(String.valueOf(g.m().k()), 0, str);
            }
            throw th4;
        }
    }

    public int q(h0 h0Var, h0 h0Var2) {
        int s = s(h0Var, h0Var2);
        if (h0Var.k() && h0Var2.k()) {
            return 1;
        }
        return r(h0Var, h0Var2) | s;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:142:0x022a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:146:0x0230 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:163:0x01f6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:164:0x0022 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x020f A[Catch: all -> 0x022a, TryCatch #6 {all -> 0x022a, blocks: (B:129:0x020b, B:131:0x020f, B:134:0x0215, B:136:0x0219, B:138:0x021e, B:140:0x0222), top: B:164:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0219 A[Catch: all -> 0x022a, TryCatch #6 {all -> 0x022a, blocks: (B:129:0x020b, B:131:0x020f, B:134:0x0215, B:136:0x0219, B:138:0x021e, B:140:0x0222), top: B:164:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0222 A[Catch: all -> 0x022a, TRY_LEAVE, TryCatch #6 {all -> 0x022a, blocks: (B:129:0x020b, B:131:0x020f, B:134:0x0215, B:136:0x0219, B:138:0x021e, B:140:0x0222), top: B:164:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x023a A[Catch: all -> 0x0232, TryCatch #13 {all -> 0x0232, blocks: (B:3:0x0015, B:152:0x0236, B:154:0x023a, B:155:0x023d, B:144:0x022c, B:145:0x022f), top: B:161:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0066 A[EDGE_INSN: B:178:0x0066->B:14:0x0066 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01bd A[LOOP:0: B:170:0x0054->B:92:0x01bd, LOOP_END] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r26v0, types: [d.b.k0.h0] */
    /* JADX WARN: Type inference failed for: r27v0, types: [d.b.k0.h0] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int r(h0 h0Var, h0 h0Var2) {
        ?? r6;
        Cursor cursor;
        ReentrantReadWriteLock.ReadLock readLock;
        ReentrantReadWriteLock.ReadLock readLock2;
        ReentrantReadWriteLock.ReadLock readLock3;
        ReentrantReadWriteLock.ReadLock readLock4;
        int i;
        int i2;
        int i3;
        String str;
        y yVar = this;
        String str2 = "content";
        ReentrantReadWriteLock.ReadLock readLock5 = yVar.f64005d.readLock();
        readLock5.lock();
        try {
            try {
                boolean k = h0Var.k();
                boolean k2 = h0Var2.k();
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
                                    int i4 = columnIndex;
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
                                            int i5 = columnIndex6;
                                            readLock4 = r15;
                                            try {
                                                long j = cursor.getLong(columnIndex2);
                                                i = columnIndex2;
                                                jSONObject.put("timestamp", Long.toString(j));
                                                i2 = i5;
                                                if (j > 0) {
                                                    if (e2) {
                                                        if (h0Var.h() == 0 || j < h0Var.h()) {
                                                            h0Var.p(j, 0L);
                                                        }
                                                        if (j > h0Var.g()) {
                                                            h0Var.p(0L, j);
                                                        }
                                                    } else {
                                                        if (h0Var2.h() == 0 || j < h0Var2.h()) {
                                                            h0Var2.p(j, 0L);
                                                        }
                                                        if (j > h0Var2.g()) {
                                                            h0Var2.p(0L, j);
                                                        }
                                                    }
                                                }
                                                jSONObject.put("type", "0");
                                                String string2 = cursor.getString(columnIndex3);
                                                if (TextUtils.isEmpty(string2)) {
                                                    i3 = 0;
                                                } else {
                                                    jSONObject.put(str2, string2);
                                                    i3 = string2.getBytes("UTF-8").length + 0;
                                                }
                                                String string3 = cursor.getString(columnIndex4);
                                                String str3 = "1";
                                                if (TextUtils.isEmpty(string3)) {
                                                    str = str2;
                                                } else {
                                                    str = str2;
                                                    jSONObject.put("abtest", string3);
                                                    if (e2) {
                                                        h0Var.q("1");
                                                    } else {
                                                        h0Var2.q("1");
                                                    }
                                                    i3 += string3.getBytes("UTF-8").length;
                                                }
                                                String string4 = cursor.getString(columnIndex5);
                                                if (!TextUtils.isEmpty(string4)) {
                                                    jSONObject.put("c", string4);
                                                }
                                                String string5 = cursor.getString(i2);
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
                                                    h0Var.a(jSONObject);
                                                    h0Var.n(string);
                                                    h0Var.m(i3);
                                                    if (h0Var.k()) {
                                                        k2 = z2;
                                                        k = true;
                                                        r15 = readLock4 != null ? true : readLock4;
                                                        if (k && k2) {
                                                            break;
                                                        }
                                                        if (!cursor.moveToNext()) {
                                                            break;
                                                        }
                                                        columnIndex6 = i2;
                                                        str2 = str;
                                                        columnIndex = i4;
                                                        columnIndex2 = i;
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
                                                    h0Var2.a(jSONObject);
                                                    h0Var2.n(string);
                                                    h0Var2.m(i3);
                                                    if (h0Var2.k()) {
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
                                                if (f63999e) {
                                                }
                                                Closeables.closeSafely(cursor);
                                                yVar = this;
                                                r6 = readLock5;
                                                yVar.f64005d.readLock().unlock();
                                                return r6;
                                            } catch (RuntimeException e4) {
                                                e = e4;
                                                readLock2 = readLock4;
                                                readLock5 = readLock2;
                                                if (f63999e) {
                                                }
                                                Closeables.closeSafely(cursor);
                                                yVar = this;
                                                r6 = readLock5;
                                                yVar.f64005d.readLock().unlock();
                                                return r6;
                                            } catch (JSONException unused) {
                                                readLock = readLock4;
                                                readLock5 = readLock;
                                                if (f63999e) {
                                                }
                                                Closeables.closeSafely(cursor);
                                                yVar = this;
                                                r6 = readLock5;
                                                yVar.f64005d.readLock().unlock();
                                                return r6;
                                            } catch (Throwable th) {
                                                th = th;
                                                yVar = this;
                                                readLock5 = readLock4;
                                                try {
                                                    Closeables.closeSafely(cursor);
                                                    throw th;
                                                } catch (SQLException e5) {
                                                    e = e5;
                                                    if (f63999e) {
                                                        e.printStackTrace();
                                                    }
                                                    yVar.f64003b.h(e);
                                                    r6 = readLock5;
                                                    yVar.f64005d.readLock().unlock();
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
                                        if (f63999e) {
                                            e.printStackTrace();
                                            readLock5 = readLock3;
                                        }
                                        Closeables.closeSafely(cursor);
                                        yVar = this;
                                        r6 = readLock5;
                                        yVar.f64005d.readLock().unlock();
                                        return r6;
                                    } catch (RuntimeException e7) {
                                        e = e7;
                                        readLock2 = r15;
                                        readLock5 = readLock2;
                                        if (f63999e) {
                                            e.printStackTrace();
                                            readLock5 = readLock2;
                                        }
                                        Closeables.closeSafely(cursor);
                                        yVar = this;
                                        r6 = readLock5;
                                        yVar.f64005d.readLock().unlock();
                                        return r6;
                                    } catch (JSONException unused2) {
                                        readLock = r15;
                                        readLock5 = readLock;
                                        if (f63999e) {
                                            Log.d("UBCDatabaseHelper", "json exception:");
                                            readLock5 = readLock;
                                        }
                                        Closeables.closeSafely(cursor);
                                        yVar = this;
                                        r6 = readLock5;
                                        yVar.f64005d.readLock().unlock();
                                        return r6;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        yVar = this;
                                        readLock5 = r15;
                                        Closeables.closeSafely(cursor);
                                        throw th;
                                    }
                                    str = str2;
                                    i = columnIndex2;
                                    i2 = columnIndex6;
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
                        yVar = this;
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
                    yVar = this;
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
            yVar = this;
            r6 = readLock5;
        } catch (SQLException e13) {
            e = e13;
            yVar = this;
            if (f63999e) {
            }
            yVar.f64003b.h(e);
            r6 = readLock5;
            yVar.f64005d.readLock().unlock();
            return r6;
        } catch (Throwable th7) {
            th = th7;
            yVar = this;
            yVar.f64005d.readLock().unlock();
            throw th;
        }
        yVar.f64005d.readLock().unlock();
        return r6;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:124:0x0286 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:159:0x0282 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v18, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r4v19, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0291 A[Catch: all -> 0x029f, TryCatch #16 {all -> 0x029f, blocks: (B:130:0x028d, B:132:0x0291, B:135:0x0297, B:137:0x029b), top: B:160:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x029b A[Catch: all -> 0x029f, TRY_LEAVE, TryCatch #16 {all -> 0x029f, blocks: (B:130:0x028d, B:132:0x0291, B:135:0x0297, B:137:0x029b), top: B:160:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x024e A[EDGE_INSN: B:171:0x024e->B:98:0x024e ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0251 A[LOOP:0: B:163:0x0075->B:99:0x0251, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int s(h0 h0Var, h0 h0Var2) {
        int i;
        boolean k;
        boolean k2;
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        boolean z;
        boolean z2;
        boolean z3;
        SQLiteDatabase sQLiteDatabase;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        SQLiteDatabase sQLiteDatabase2;
        y yVar = this;
        ReentrantReadWriteLock.ReadLock readLock = yVar.f64005d.readLock();
        readLock.lock();
        try {
            try {
                k = h0Var.k();
                k2 = h0Var2.k();
                readableDatabase = getReadableDatabase();
                cursor = null;
            } finally {
                yVar.f64005d.readLock().unlock();
            }
        } catch (SQLException e2) {
            e = e2;
            readLock = null;
        }
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
                                } catch (UnsupportedEncodingException e3) {
                                    e = e3;
                                    yVar = this;
                                } catch (RuntimeException e4) {
                                    e = e4;
                                    yVar = this;
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                                        String string = cursor.getString(columnIndex);
                                        int i8 = cursor.getInt(columnIndex2);
                                        if (i8 >= 0) {
                                            i2 = columnIndex2;
                                            boolean e5 = g.m().e(string);
                                            if (z4 && z5) {
                                                yVar = this;
                                                break;
                                            }
                                            if ((!z4 || !e5) && (!z5 || e5)) {
                                                i3 = columnIndex3;
                                                p pVar = new p();
                                                pVar.u(cursor.getString(columnIndex));
                                                pVar.t(i8);
                                                i4 = columnIndex11;
                                                pVar.m(cursor.getLong(columnIndex4));
                                                pVar.q(cursor.getLong(columnIndex5));
                                                if (e5) {
                                                    if (pVar.d() <= 0 || pVar.d() <= h0Var.g()) {
                                                        i5 = columnIndex4;
                                                        i6 = columnIndex5;
                                                    } else {
                                                        i5 = columnIndex4;
                                                        i6 = columnIndex5;
                                                        h0Var.p(0L, pVar.d());
                                                    }
                                                    if (pVar.a() > 0 && (h0Var.h() == 0 || pVar.a() < h0Var.h())) {
                                                        h0Var.p(pVar.a(), 0L);
                                                    }
                                                } else {
                                                    i5 = columnIndex4;
                                                    i6 = columnIndex5;
                                                    if (pVar.d() > 0 && pVar.d() > h0Var2.g()) {
                                                        h0Var2.p(0L, pVar.d());
                                                    }
                                                    if (pVar.a() > 0 && (h0Var2.h() == 0 || pVar.a() < h0Var2.h())) {
                                                        h0Var2.p(pVar.a(), 0L);
                                                    }
                                                }
                                                String string2 = cursor.getString(columnIndex6);
                                                if (TextUtils.isEmpty(string2)) {
                                                    i7 = 0;
                                                } else {
                                                    pVar.o(string2);
                                                    i7 = string2.getBytes("UTF-8").length + 0;
                                                }
                                                String string3 = cursor.getString(columnIndex8);
                                                if (!TextUtils.isEmpty(string3)) {
                                                    pVar.s(string3);
                                                    i7 += string3.getBytes("UTF-8").length;
                                                }
                                                if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                                    pVar.n(cursor.getString(columnIndex9));
                                                }
                                                String string4 = cursor.getString(columnIndex10);
                                                if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                                    pVar.v(string4);
                                                    i7 += string4.getBytes("UTF-8").length;
                                                }
                                                int i9 = i7;
                                                if (!TextUtils.isEmpty(cursor.getString(i4))) {
                                                    try {
                                                        if (new JSONObject(cursor.getString(i4)).has("ctr")) {
                                                            pVar.p(true);
                                                        }
                                                    } catch (JSONException e6) {
                                                        e6.printStackTrace();
                                                    }
                                                }
                                                if (e5) {
                                                    yVar = this;
                                                    sQLiteDatabase2 = sQLiteDatabase;
                                                    yVar.c(sQLiteDatabase2, pVar, h0Var);
                                                    h0Var.o(pVar.f(), Integer.parseInt(pVar.g()));
                                                    h0Var.m(i9);
                                                    if (h0Var.k()) {
                                                        z4 = true;
                                                    }
                                                } else {
                                                    yVar = this;
                                                    sQLiteDatabase2 = sQLiteDatabase;
                                                    yVar.c(sQLiteDatabase2, pVar, h0Var2);
                                                    h0Var2.o(pVar.f(), Integer.parseInt(pVar.g()));
                                                    h0Var2.m(i9);
                                                    if (h0Var2.k()) {
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
                                                columnIndex11 = i4;
                                                readableDatabase = sQLiteDatabase2;
                                                columnIndex2 = i2;
                                                columnIndex3 = i3;
                                                columnIndex4 = i5;
                                                columnIndex5 = i6;
                                            }
                                            i4 = columnIndex11;
                                            i3 = columnIndex3;
                                            i5 = columnIndex4;
                                            i6 = columnIndex5;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            yVar = this;
                                            if (!cursor.moveToNext()) {
                                            }
                                        }
                                    }
                                    if (!cursor.moveToNext()) {
                                    }
                                } catch (UnsupportedEncodingException e7) {
                                    e = e7;
                                    z2 = z6;
                                    z3 = z2;
                                    if (f63999e) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    i = z3;
                                    return i;
                                } catch (RuntimeException e8) {
                                    e = e8;
                                    z = z6;
                                    z3 = z;
                                    if (f63999e) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    i = z3;
                                    return i;
                                } catch (Throwable th2) {
                                    th = th2;
                                    Closeables.closeSafely(cursor);
                                    throw th;
                                }
                                i2 = columnIndex2;
                                i4 = columnIndex11;
                                i3 = columnIndex3;
                                i5 = columnIndex4;
                                i6 = columnIndex5;
                                sQLiteDatabase2 = sQLiteDatabase;
                                yVar = this;
                            }
                            z3 = z6;
                        } catch (UnsupportedEncodingException e9) {
                            e = e9;
                            yVar = this;
                            z2 = false;
                            z3 = z2;
                            if (f63999e) {
                                e.printStackTrace();
                                z3 = z2;
                            }
                            Closeables.closeSafely(cursor);
                            i = z3;
                            return i;
                        } catch (RuntimeException e10) {
                            e = e10;
                            yVar = this;
                            z = false;
                            z3 = z;
                            if (f63999e) {
                                e.printStackTrace();
                                z3 = z;
                            }
                            Closeables.closeSafely(cursor);
                            i = z3;
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    }
                } catch (SQLException e11) {
                    e = e11;
                    if (f63999e) {
                        e.printStackTrace();
                    }
                    yVar.f64003b.h(e);
                    i = readLock;
                    return i;
                }
            } catch (UnsupportedEncodingException e12) {
                e = e12;
            } catch (RuntimeException e13) {
                e = e13;
            } catch (Throwable th4) {
                th = th4;
            }
            Closeables.closeSafely(cursor);
            i = z3;
            return i;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public HashMap<String, String> t(ArrayList<String> arrayList) {
        Cursor cursor;
        this.f64005d.readLock().lock();
        HashMap<String, String> hashMap = new HashMap<>();
        String C = C(arrayList);
        try {
            try {
                cursor = null;
            } catch (SQLException e2) {
                if (f63999e) {
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
                    if (f63999e) {
                        e3.printStackTrace();
                    }
                }
                return hashMap;
            } finally {
                Closeables.closeSafely(cursor);
            }
        } finally {
            this.f64005d.readLock().unlock();
        }
    }

    public k u(String str) {
        Cursor cursor;
        this.f64005d.readLock().lock();
        try {
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", "config", str), null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                    String string2 = cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH));
                                    int i = cursor.getInt(cursor.getColumnIndex("cycle"));
                                    k kVar = new k(string, string2, i == 0 ? "1" : "0", i, cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("reserve1")));
                                    String string3 = cursor.getString(cursor.getColumnIndex("extend"));
                                    if (!TextUtils.isEmpty(string3)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(string3);
                                            String optString = jSONObject.optString("dfc");
                                            if (!TextUtils.isEmpty(optString)) {
                                                kVar.v(optString);
                                            }
                                            String optString2 = jSONObject.optString("version");
                                            if (!TextUtils.isEmpty(optString2)) {
                                                kVar.D(optString2);
                                            }
                                            String optString3 = jSONObject.optString("uploadType");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                kVar.C(optString3);
                                            }
                                            int optInt = jSONObject.optInt("lcache", 2);
                                            if (optInt == 1 || optInt == 0) {
                                                kVar.y(optInt);
                                            }
                                        } catch (JSONException e2) {
                                            if (f63999e) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                    String string4 = cursor.getString(cursor.getColumnIndex("reallog"));
                                    if (!TextUtils.isEmpty(string4)) {
                                        kVar.B(string4);
                                    }
                                    Closeables.closeSafely(cursor);
                                    return kVar;
                                }
                            } catch (RuntimeException e3) {
                                e = e3;
                                if (f63999e) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    }
                } catch (RuntimeException e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
                Closeables.closeSafely(cursor);
            } catch (SQLException e5) {
                if (f63999e) {
                    e5.printStackTrace();
                }
                this.f64003b.h(e5);
            }
            return null;
        } finally {
            this.f64005d.readLock().unlock();
        }
    }

    public int v() {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        this.f64005d.readLock().lock();
        int i = 0;
        try {
            try {
                readableDatabase = getReadableDatabase();
                cursor = null;
            } catch (SQLException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
            }
            try {
                try {
                    cursor = readableDatabase.rawQuery("SELECT COUNT(eventid) FROM config", null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        i = cursor.getInt(0);
                    }
                } catch (SQLException e3) {
                    if (f63999e) {
                        e3.printStackTrace();
                    }
                }
                return i;
            } finally {
                Closeables.closeSafely(cursor);
            }
        } finally {
            this.f64005d.readLock().unlock();
        }
    }

    public int w(ArrayList<j> arrayList, h0 h0Var) {
        int i;
        this.f64002a = 0L;
        String B = B(arrayList, true);
        if (TextUtils.isEmpty(B)) {
            i = 0;
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
            i = z(sb.toString(), h0Var);
        }
        String B2 = B(arrayList, false);
        if (TextUtils.isEmpty(B2)) {
            return i;
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
        return i | x(sb2.toString(), h0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x01b1 A[Catch: all -> 0x01a6, TryCatch #4 {all -> 0x01a6, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0029, B:11:0x0050, B:20:0x007f, B:23:0x0092, B:25:0x00ab, B:28:0x00b7, B:30:0x00cd, B:32:0x00d7, B:33:0x00e0, B:35:0x00ea, B:37:0x00fb, B:38:0x0100, B:39:0x010b, B:43:0x0124, B:45:0x0131, B:47:0x0137, B:49:0x013e, B:52:0x0152, B:85:0x01ad, B:87:0x01b1, B:90:0x01ba, B:92:0x01be, B:96:0x01c9, B:98:0x01cd), top: B:119:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01be A[Catch: all -> 0x01a6, TRY_LEAVE, TryCatch #4 {all -> 0x01a6, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0029, B:11:0x0050, B:20:0x007f, B:23:0x0092, B:25:0x00ab, B:28:0x00b7, B:30:0x00cd, B:32:0x00d7, B:33:0x00e0, B:35:0x00ea, B:37:0x00fb, B:38:0x0100, B:39:0x010b, B:43:0x0124, B:45:0x0131, B:47:0x0137, B:49:0x013e, B:52:0x0152, B:85:0x01ad, B:87:0x01b1, B:90:0x01ba, B:92:0x01be, B:96:0x01c9, B:98:0x01cd), top: B:119:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01cd A[Catch: all -> 0x01a6, TRY_LEAVE, TryCatch #4 {all -> 0x01a6, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0029, B:11:0x0050, B:20:0x007f, B:23:0x0092, B:25:0x00ab, B:28:0x00b7, B:30:0x00cd, B:32:0x00d7, B:33:0x00e0, B:35:0x00ea, B:37:0x00fb, B:38:0x0100, B:39:0x010b, B:43:0x0124, B:45:0x0131, B:47:0x0137, B:49:0x013e, B:52:0x0152, B:85:0x01ad, B:87:0x01b1, B:90:0x01ba, B:92:0x01be, B:96:0x01c9, B:98:0x01cd), top: B:119:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int x(String str, h0 h0Var) {
        int i;
        long j;
        JSONObject jSONObject;
        String string;
        int i2;
        long j2;
        int i3;
        int i4;
        String str2;
        String str3;
        String string2;
        h0 h0Var2 = h0Var;
        String str4 = "0";
        this.f64005d.readLock().lock();
        long j3 = Long.MAX_VALUE;
        try {
            try {
                Cursor cursor = null;
                try {
                    try {
                        cursor = getReadableDatabase().rawQuery(str, null);
                        if (cursor == null || cursor.getCount() <= 0) {
                            j = 0;
                            i = 0;
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
                                    jSONObject = new JSONObject();
                                    string = cursor.getString(columnIndex);
                                    jSONObject.put("id", string);
                                    long j5 = cursor.getLong(columnIndex2);
                                    i2 = columnIndex2;
                                    jSONObject.put("timestamp", Long.toString(j5));
                                    if (j5 > 0) {
                                        if (j5 < j3) {
                                            j3 = j5;
                                        }
                                        if (j5 > j4) {
                                            j4 = j5;
                                        }
                                    }
                                } catch (UnsupportedEncodingException e2) {
                                    e = e2;
                                } catch (RuntimeException e3) {
                                    e = e3;
                                } catch (JSONException unused) {
                                }
                                try {
                                    jSONObject.put("type", str4);
                                    String string3 = cursor.getString(columnIndex3);
                                    j2 = j3;
                                    if (TextUtils.isEmpty(string3)) {
                                        i4 = columnIndex;
                                        str2 = string;
                                        i3 = columnIndex3;
                                    } else {
                                        try {
                                            jSONObject.put("content", string3);
                                            i3 = columnIndex3;
                                            i4 = columnIndex;
                                            str2 = string;
                                            this.f64002a += string3.getBytes("UTF-8").length;
                                        } catch (UnsupportedEncodingException e4) {
                                            e = e4;
                                            j = j4;
                                            j3 = j2;
                                            if (f63999e) {
                                            }
                                            Closeables.closeSafely(cursor);
                                            i = 0;
                                            h0Var2.p(j3, j);
                                            return i;
                                        } catch (RuntimeException e5) {
                                            e = e5;
                                            j = j4;
                                            j3 = j2;
                                            if (f63999e) {
                                            }
                                            Closeables.closeSafely(cursor);
                                            i = 0;
                                            h0Var2.p(j3, j);
                                            return i;
                                        } catch (JSONException unused2) {
                                            j = j4;
                                            j3 = j2;
                                            if (f63999e) {
                                            }
                                            Closeables.closeSafely(cursor);
                                            i = 0;
                                            h0Var2.p(j3, j);
                                            return i;
                                        }
                                    }
                                    String string4 = cursor.getString(columnIndex4);
                                    String str5 = "1";
                                    if (TextUtils.isEmpty(string4)) {
                                        str3 = str4;
                                    } else {
                                        try {
                                            jSONObject.put("abtest", string4);
                                            h0Var2.q("1");
                                            str3 = str4;
                                            this.f64002a += string4.getBytes("UTF-8").length;
                                        } catch (UnsupportedEncodingException e6) {
                                            e = e6;
                                            h0Var2 = h0Var;
                                            j = j4;
                                            j3 = j2;
                                            if (f63999e) {
                                                e.printStackTrace();
                                            }
                                            Closeables.closeSafely(cursor);
                                            i = 0;
                                            h0Var2.p(j3, j);
                                            return i;
                                        } catch (RuntimeException e7) {
                                            e = e7;
                                            h0Var2 = h0Var;
                                            j = j4;
                                            j3 = j2;
                                            if (f63999e) {
                                                e.printStackTrace();
                                            }
                                            Closeables.closeSafely(cursor);
                                            i = 0;
                                            h0Var2.p(j3, j);
                                            return i;
                                        } catch (JSONException unused3) {
                                            h0Var2 = h0Var;
                                            j = j4;
                                            j3 = j2;
                                            if (f63999e) {
                                                Log.d("UBCDatabaseHelper", "json exception:");
                                            }
                                            Closeables.closeSafely(cursor);
                                            i = 0;
                                            h0Var2.p(j3, j);
                                            return i;
                                        }
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                                        jSONObject.put("c", cursor.getString(columnIndex5));
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex6))) {
                                        if (new JSONObject(cursor.getString(columnIndex6)).has("ctr")) {
                                            jSONObject.put("of", "1");
                                        }
                                        this.f64002a += string2.getBytes("UTF-8").length;
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
                                    h0Var2 = h0Var;
                                    h0Var2.a(jSONObject);
                                    h0Var2.n(cursor.getString(i4));
                                    if (this.f64002a >= Config.FULL_TRACE_LOG_LIMIT || !cursor.moveToNext()) {
                                        break;
                                    }
                                    columnIndex2 = i2;
                                    str4 = str3;
                                    columnIndex = i4;
                                    j3 = j2;
                                    columnIndex3 = i3;
                                } catch (UnsupportedEncodingException e8) {
                                    e = e8;
                                    j = j4;
                                    if (f63999e) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    i = 0;
                                    h0Var2.p(j3, j);
                                    return i;
                                } catch (RuntimeException e9) {
                                    e = e9;
                                    j = j4;
                                    if (f63999e) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    i = 0;
                                    h0Var2.p(j3, j);
                                    return i;
                                } catch (JSONException unused4) {
                                    j = j4;
                                    if (f63999e) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    i = 0;
                                    h0Var2.p(j3, j);
                                    return i;
                                }
                            }
                            j = j4;
                            j3 = j2;
                            i = 1;
                        }
                        try {
                        } catch (SQLException e10) {
                            e = e10;
                            if (f63999e) {
                                e.printStackTrace();
                            }
                            this.f64003b.h(e);
                            return i;
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
                h0Var2.p(j3, j);
            } catch (SQLException e13) {
                e = e13;
                i = 0;
            }
            return i;
        } finally {
            this.f64005d.readLock().unlock();
        }
    }

    public final ContentValues y(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(nVar.e()));
        contentValues.put("eventid", nVar.g());
        contentValues.put("begintime", Long.valueOf(nVar.k()));
        if (!TextUtils.isEmpty(nVar.b())) {
            contentValues.put("content", nVar.b());
        } else if (nVar.h() != null && !TextUtils.isEmpty(nVar.h().toString())) {
            contentValues.put("content", nVar.h().toString());
        }
        if (!TextUtils.isEmpty(nVar.c())) {
            contentValues.put("reserve1", nVar.c());
        }
        if (!TextUtils.isEmpty(nVar.a())) {
            contentValues.put("reserve2", nVar.a());
        }
        if (nVar.l()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ctr", "1");
                contentValues.put("extend", jSONObject.toString());
            } catch (JSONException e2) {
                if (f63999e) {
                    e2.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(nVar.j())) {
            contentValues.put("reallog", nVar.j());
        } else {
            contentValues.put("reallog", "0");
        }
        return contentValues;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:91:0x0206
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int z(java.lang.String r30, d.b.k0.h0 r31) {
        /*
            r29 = this;
            r1 = r29
            r2 = r31
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f64005d
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L261 android.database.SQLException -> L263
            r4.<init>()     // Catch: java.lang.Throwable -> L261 android.database.SQLException -> L263
            android.database.sqlite.SQLiteDatabase r0 = r29.getReadableDatabase()     // Catch: java.lang.Throwable -> L261 android.database.SQLException -> L263
            r7 = 0
            r10 = r30
            android.database.Cursor r7 = r0.rawQuery(r10, r7)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            if (r7 == 0) goto L214
            int r0 = r7.getCount()     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            if (r0 <= 0) goto L214
            r7.moveToFirst()     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "flowid"
            int r11 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "flowhandle"
            int r12 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "state"
            int r13 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "begintime"
            int r14 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "endtime"
            int r15 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "content"
            int r3 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "option"
            int r5 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "reserve1"
            int r6 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "reserve2"
            int r10 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "slot"
            int r8 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            java.lang.String r0 = "extend"
            int r9 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L225 java.io.UnsupportedEncodingException -> L227 java.lang.RuntimeException -> L23a
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r20 = 0
        L71:
            java.lang.String r0 = "2"
            java.lang.String r2 = r7.getString(r13)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            boolean r0 = r0.equals(r2)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            if (r0 != 0) goto Lab
            long r22 = r7.getLong(r14)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            long r24 = java.lang.System.currentTimeMillis()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            long r22 = r22 - r24
            long r22 = java.lang.Math.abs(r22)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r24 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r0 <= 0) goto L9b
            int r0 = r7.getInt(r5)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r0 = r0 & 4
            if (r0 == 0) goto L9b
            goto Lab
        L9b:
            r26 = r3
            r22 = r11
            r23 = r12
            r11 = r13
            r24 = r14
            r3 = 1
            r18 = 0
            r12 = r31
            goto L1d7
        Lab:
            d.b.k0.p r2 = new d.b.k0.p     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r2.<init>()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            java.lang.String r0 = r7.getString(r11)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r2.u(r0)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            int r0 = r7.getInt(r12)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r2.t(r0)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r22 = r11
            r23 = r12
            long r11 = r7.getLong(r14)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r2.m(r11)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            long r11 = r7.getLong(r15)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r2.q(r11)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Le8
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto Le8
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r20 = r11
        Le8:
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto L100
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            int r0 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r0 >= 0) goto L100
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r16 = r11
        L100:
            java.lang.String r0 = r7.getString(r3)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            java.lang.String r12 = "UTF-8"
            if (r11 != 0) goto L122
            r2.o(r0)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r11 = r13
            r24 = r14
            long r13 = r1.f64002a     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r26 = r3
            r25 = r4
            long r3 = (long) r0
            long r13 = r13 + r3
            r1.f64002a = r13     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            goto L129
        L122:
            r26 = r3
            r25 = r4
            r11 = r13
            r24 = r14
        L129:
            java.lang.String r0 = r7.getString(r6)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L225
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L225
            if (r3 != 0) goto L158
            r2.s(r0)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r3 = r1.f64002a     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r13 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r3 = r3 + r13
            r1.f64002a = r3     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            goto L158
        L142:
            r0 = move-exception
            r12 = r31
            r5 = r16
            r8 = r20
            r4 = r25
            goto L232
        L14d:
            r0 = move-exception
            r12 = r31
            r5 = r16
            r8 = r20
            r4 = r25
            goto L245
        L158:
            java.lang.String r0 = r7.getString(r10)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L225
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L225
            if (r0 != 0) goto L169
            java.lang.String r0 = r7.getString(r10)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            r2.n(r0)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
        L169:
            java.lang.String r0 = r7.getString(r8)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L225
            if (r8 < 0) goto L183
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            if (r3 != 0) goto L183
            r2.v(r0)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r3 = r1.f64002a     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r13 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r3 = r3 + r13
            r1.f64002a = r3     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
        L183:
            java.lang.String r0 = r7.getString(r9)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L225
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1f2 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L225
            if (r3 != 0) goto L1b6
            long r3 = r1.f64002a     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r12 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            long r3 = r3 + r12
            r1.f64002a = r3     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d org.json.JSONException -> L1b0 java.lang.Throwable -> L225
            java.lang.String r3 = r7.getString(r9)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d org.json.JSONException -> L1b0 java.lang.Throwable -> L225
            r0.<init>(r3)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d org.json.JSONException -> L1b0 java.lang.Throwable -> L225
            java.lang.String r3 = "ctr"
            boolean r0 = r0.has(r3)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d org.json.JSONException -> L1b0 java.lang.Throwable -> L225
            if (r0 == 0) goto L1b6
            r3 = 1
            r2.p(r3)     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d org.json.JSONException -> L1ae java.lang.Throwable -> L225
            goto L1b7
        L1ae:
            r0 = move-exception
            goto L1b2
        L1b0:
            r0 = move-exception
            r3 = 1
        L1b2:
            r0.printStackTrace()     // Catch: java.io.UnsupportedEncodingException -> L142 java.lang.RuntimeException -> L14d java.lang.Throwable -> L225
            goto L1b7
        L1b6:
            r3 = 1
        L1b7:
            r4 = r25
            r4.add(r2)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            int r0 = r2.f()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            java.lang.String r2 = r2.g()     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.io.UnsupportedEncodingException -> L1fe java.lang.RuntimeException -> L202 java.lang.Throwable -> L225
            r12 = r31
            r12.o(r0, r2)     // Catch: java.io.UnsupportedEncodingException -> L1ee java.lang.RuntimeException -> L1f0 java.lang.Throwable -> L225
            long r13 = r1.f64002a     // Catch: java.io.UnsupportedEncodingException -> L1ee java.lang.RuntimeException -> L1f0 java.lang.Throwable -> L225
            r27 = 10485760(0xa00000, double:5.180654E-317)
            int r0 = (r13 > r27 ? 1 : (r13 == r27 ? 0 : -1))
            if (r0 < 0) goto L1d7
            goto L1dd
        L1d7:
            boolean r0 = r7.moveToNext()     // Catch: java.io.UnsupportedEncodingException -> L1ee java.lang.RuntimeException -> L1f0 java.lang.Throwable -> L225
            if (r0 != 0) goto L1e2
        L1dd:
            r5 = r16
            r8 = r20
            goto L21f
        L1e2:
            r13 = r11
            r2 = r12
            r11 = r22
            r12 = r23
            r14 = r24
            r3 = r26
            goto L71
        L1ee:
            r0 = move-exception
            goto L208
        L1f0:
            r0 = move-exception
            goto L20f
        L1f2:
            r0 = move-exception
            r12 = r31
            r4 = r25
            goto L208
        L1f8:
            r0 = move-exception
            r12 = r31
            r4 = r25
            goto L20f
        L1fe:
            r0 = move-exception
            r12 = r31
            goto L208
        L202:
            r0 = move-exception
            r12 = r31
            goto L20f
        L206:
            r0 = move-exception
            r12 = r2
        L208:
            r5 = r16
            r8 = r20
            goto L232
        L20d:
            r0 = move-exception
            r12 = r2
        L20f:
            r5 = r16
            r8 = r20
            goto L245
        L214:
            r12 = r2
            r18 = 0
            r8 = r18
            r3 = 0
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L21f:
            com.baidu.android.util.io.Closeables.closeSafely(r7)     // Catch: android.database.SQLException -> L223 java.lang.Throwable -> L261
            goto L250
        L223:
            r0 = move-exception
            goto L265
        L225:
            r0 = move-exception
            goto L25d
        L227:
            r0 = move-exception
            r12 = r2
            r18 = 0
            r8 = r18
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L232:
            boolean r2 = d.b.k0.y.f63999e     // Catch: java.lang.Throwable -> L225
            if (r2 == 0) goto L24c
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L225
            goto L24c
        L23a:
            r0 = move-exception
            r12 = r2
            r18 = 0
            r8 = r18
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L245:
            boolean r2 = d.b.k0.y.f63999e     // Catch: java.lang.Throwable -> L225
            if (r2 == 0) goto L24c
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L225
        L24c:
            com.baidu.android.util.io.Closeables.closeSafely(r7)     // Catch: java.lang.Throwable -> L261 android.database.SQLException -> L263
            r3 = 0
        L250:
            int r0 = r4.size()     // Catch: android.database.SQLException -> L223 java.lang.Throwable -> L261
            if (r0 <= 0) goto L259
            r1.A(r4, r12)     // Catch: android.database.SQLException -> L223 java.lang.Throwable -> L261
        L259:
            r12.p(r5, r8)     // Catch: android.database.SQLException -> L223 java.lang.Throwable -> L261
            goto L271
        L25d:
            com.baidu.android.util.io.Closeables.closeSafely(r7)     // Catch: java.lang.Throwable -> L261 android.database.SQLException -> L263
            throw r0     // Catch: java.lang.Throwable -> L261 android.database.SQLException -> L263
        L261:
            r0 = move-exception
            goto L27b
        L263:
            r0 = move-exception
            r3 = 0
        L265:
            boolean r2 = d.b.k0.y.f63999e     // Catch: java.lang.Throwable -> L261
            if (r2 == 0) goto L26c
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L261
        L26c:
            d.b.k0.b r2 = r1.f64003b     // Catch: java.lang.Throwable -> L261
            r2.h(r0)     // Catch: java.lang.Throwable -> L261
        L271:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f64005d
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r3
        L27b:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f64005d
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.k0.y.z(java.lang.String, d.b.k0.h0):int");
    }
}
