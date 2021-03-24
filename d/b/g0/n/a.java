package d.b.g0.n;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteKey;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.tencent.connect.common.Constants;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f49176a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.n.o f49177b;

    /* renamed from: d.b.g0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1029a extends q {

        /* renamed from: c  reason: collision with root package name */
        public long f49178c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SparseArray f49179d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49180e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f49181f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f49182g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1029a(SparseArray sparseArray, String str, ArrayList arrayList, boolean z) {
            super(a.this, null);
            this.f49179d = sparseArray;
            this.f49180e = str;
            this.f49181f = arrayList;
            this.f49182g = z;
            this.f49178c = System.currentTimeMillis();
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ArrayList arrayList;
            SparseArray sparseArray = this.f49179d;
            if (sparseArray != null && sparseArray.size() > 0) {
                int size = this.f49179d.size();
                ArrayList arrayList2 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList2.add(Integer.valueOf(this.f49179d.keyAt(i)));
                }
                String s = a.this.s(arrayList2);
                StringBuilder sb = new StringBuilder();
                sb.append("flowhandle");
                sb.append(" in (");
                sb.append(s);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                int delete = sQLiteDatabase.delete("flow", sb.toString(), null);
                s.a("delete flow table flow count:" + delete);
                int delete2 = sQLiteDatabase.delete("event", sb.toString(), null);
                s.a("delete flow table event count:" + delete2);
            }
            ArrayList arrayList3 = this.f49181f;
            if (arrayList3 != null && arrayList3.size() > 0) {
                String s2 = a.this.s(this.f49181f);
                int delete3 = sQLiteDatabase.delete("event", "eventid in (" + s2 + SmallTailInfo.EMOTION_SUFFIX + " AND flowhandle = -1", null);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("delete event table event count:");
                sb2.append(delete3);
                s.a(sb2.toString());
            }
            SparseArray sparseArray2 = this.f49179d;
            if ((sparseArray2 != null && sparseArray2.size() > 0) || ((arrayList = this.f49181f) != null && arrayList.size() > 0)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(BreakpointSQLiteKey.FILENAME, this.f49180e);
                contentValues.put("state", "0");
                contentValues.put("reserve1", this.f49182g ? "1" : "0");
                sQLiteDatabase.replace("file", null, contentValues);
            }
            s.a("delete total time:" + (System.currentTimeMillis() - this.f49178c));
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49184c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f49185d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, boolean z) {
            super(aVar, null);
            this.f49184c = str;
            this.f49185d = z;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "1");
            contentValues.put(BreakpointSQLiteKey.FILENAME, this.f49184c);
            contentValues.put("reserve1", this.f49185d ? "1" : "0");
            sQLiteDatabase.replace("file", null, contentValues);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49186c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str) {
            super(aVar, null);
            this.f49186c = str;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete("file", BreakpointSQLiteKey.FILENAME + "=\"" + this.f49186c + "\"", null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends q {
        public d(a aVar) {
            super(aVar, null);
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete("file", null, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49187c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, String str) {
            super(aVar, null);
            this.f49187c = str;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "1");
            sQLiteDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + this.f49187c + "\"", null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49188c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f49189d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, String str, String str2) {
            super(aVar, null);
            this.f49188c = str;
            this.f49189d = str2;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", this.f49189d);
            sQLiteDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + this.f49188c + "\"", null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends q {
        public g(a aVar) {
            super(aVar, null);
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "1");
            sQLiteDatabase.update("file", contentValues, null, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49190c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f49191d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContentValues f49193f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, int i, ContentValues contentValues) {
            super(a.this, null);
            this.f49190c = str;
            this.f49191d = str2;
            this.f49192e = i;
            this.f49193f = contentValues;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return a.this.d(this.f49190c, this.f49191d, this.f49192e, sQLiteDatabase) && sQLiteDatabase.insert("event", null, this.f49193f) != -1;
        }
    }

    /* loaded from: classes3.dex */
    public class i extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f49195c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(List list) {
            super(a.this, null);
            this.f49195c = list;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            boolean z = true;
            for (d.b.g0.n.i iVar : this.f49195c) {
                if (!TextUtils.isEmpty(iVar.h()) && a.this.d(iVar.g(), iVar.h(), iVar.f(), sQLiteDatabase)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("flowhandle", Integer.valueOf(iVar.f()));
                    contentValues.put("eventid", iVar.h());
                    contentValues.put("begintime", Long.valueOf(iVar.k()));
                    if (!TextUtils.isEmpty(iVar.c())) {
                        contentValues.put("content", iVar.c());
                    } else if (iVar.i() != null && !TextUtils.isEmpty(iVar.i().toString())) {
                        contentValues.put("content", iVar.i().toString());
                    }
                    contentValues.put("reserve1", iVar.d());
                    if (!TextUtils.isEmpty(iVar.b())) {
                        contentValues.put("reserve2", iVar.b());
                    }
                    if (iVar.l()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("ctr", "1");
                            contentValues.put("extend", jSONObject.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (sQLiteDatabase.insert("event", null, contentValues) < 0) {
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    /* loaded from: classes3.dex */
    public class j extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f49197c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(a aVar, ContentValues contentValues) {
            super(aVar, null);
            this.f49197c = contentValues;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.insert("flow", null, this.f49197c) != -1;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f49198c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f49199d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a aVar, ContentValues contentValues, String str) {
            super(aVar, null);
            this.f49198c = contentValues;
            this.f49199d = str;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.update("flow", this.f49198c, this.f49199d, null) == 1;
        }
    }

    /* loaded from: classes3.dex */
    public class l extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f49200c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f49201d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(a aVar, ContentValues contentValues, String str) {
            super(aVar, null);
            this.f49200c = contentValues;
            this.f49201d = str;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.update("flow", this.f49200c, this.f49201d, null) == 1;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49202c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f49203d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(a aVar, String str, int i) {
            super(aVar, null);
            this.f49202c = str;
            this.f49203d = i;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete("flow", this.f49202c, null);
            sQLiteDatabase.delete("event", "flowhandle = " + this.f49203d, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class n extends q {
        public n() {
            super(a.this, null);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0104 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0115 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x00db */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:42:0x011f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0120  */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v12, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
        @Override // d.b.g0.n.a.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            boolean moveToNext;
            long currentTimeMillis = System.currentTimeMillis() - d.b.g0.n.d.g().e();
            Closeable closeable = null;
            int delete = sQLiteDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
            if (delete > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", ContentUtil.RESULT_KEY_EXPIRE);
                    jSONObject.put("ubc_type", "flow");
                    jSONObject.put("expire_time", currentTimeMillis);
                    jSONObject.put("count", delete);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                d.b.g0.n.e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
            }
            int delete2 = sQLiteDatabase.delete("event", "begintime < " + currentTimeMillis, null);
            if (delete2 > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("type", ContentUtil.RESULT_KEY_EXPIRE);
                    jSONObject2.put("ubc_type", "event");
                    jSONObject2.put("expire_time", currentTimeMillis);
                    jSONObject2.put("count", delete2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                d.b.g0.n.e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject2.toString());
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
            ?? r1 = " is NULL ";
            sb.append(" is NULL ");
            sb.append(" AND ");
            sb.append("option");
            sb.append(" = 0");
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    r1 = sQLiteDatabase.rawQuery(sb.toString(), null);
                } catch (Throwable th) {
                    th = th;
                    closeable = r1;
                    d.b.g0.p.d.a(closeable);
                    throw th;
                }
            } catch (SQLiteFullException unused) {
                r1 = 0;
            } catch (RuntimeException e4) {
                e = e4;
                r1 = 0;
            } catch (Throwable th2) {
                th = th2;
                d.b.g0.p.d.a(closeable);
                throw th;
            }
            if (r1 != 0) {
                try {
                    int count = r1.getCount();
                    r1 = r1;
                    if (count > 0) {
                        r1.moveToFirst();
                        do {
                            arrayList.add(Integer.valueOf(r1.getInt(r1.getColumnIndex("flowhandle"))));
                            moveToNext = r1.moveToNext();
                            r1 = r1;
                        } while (moveToNext);
                    }
                } catch (SQLiteFullException unused2) {
                } catch (RuntimeException e5) {
                    e = e5;
                    e.printStackTrace();
                    r1 = r1;
                    d.b.g0.p.d.a(r1);
                    if (arrayList.size() != 0) {
                    }
                }
            }
            d.b.g0.p.d.a(r1);
            if (arrayList.size() != 0) {
                return true;
            }
            String s = a.this.s(arrayList);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("flowhandle");
            sb2.append(" in (");
            sb2.append(s);
            sb2.append(SmallTailInfo.EMOTION_SUFFIX);
            sQLiteDatabase.delete("flow", sb2.toString(), null);
            sQLiteDatabase.delete("event", sb2.toString(), null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49205c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f49206d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(a aVar, String str, int i) {
            super(aVar, null);
            this.f49205c = str;
            this.f49206d = i;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            String str = this.f49205c;
            int delete = sQLiteDatabase.delete(str, "_id < " + this.f49206d, null);
            d.b.g0.n.e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delLimit");
            return delete > 0;
        }
    }

    /* loaded from: classes3.dex */
    public class p extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f49207c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(a aVar, List list) {
            super(aVar, null);
            this.f49207c = list;
        }

        @Override // d.b.g0.n.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            for (d.b.g0.n.g gVar : this.f49207c) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("eventid", gVar.c());
                contentValues.put("type", gVar.k());
                if ("1".equals(gVar.e())) {
                    contentValues.put("cycle", (Integer) 0);
                } else {
                    contentValues.put("cycle", Integer.valueOf(gVar.j()));
                }
                contentValues.put(SetImageWatermarkTypeReqMsg.SWITCH, gVar.i());
                contentValues.put("reserve1", gVar.a());
                if (!TextUtils.isEmpty(gVar.b())) {
                    contentValues.put("reserve2", gVar.b());
                }
                contentValues.put("sample", Integer.valueOf(gVar.h()));
                if (gVar.g() != 0 && gVar.f() != 0) {
                    contentValues.put("recordrule", Integer.valueOf(gVar.g()));
                    contentValues.put("uploadrule", Integer.valueOf(gVar.f()));
                }
                if (TextUtils.equals(gVar.d(), "1")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(Constant.ID_TYPE, "1");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    contentValues.put("extend", jSONObject.toString());
                }
                sQLiteDatabase.replace("config", null, contentValues);
            }
            return true;
        }
    }

    public a(Context context) {
        this.f49177b = new d.b.g0.n.o(context);
    }

    public void A() {
        new g(this).c(this.f49177b.getWritableDatabase());
    }

    public void B(List<d.b.g0.n.g> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new p(this, list).c(this.f49177b.getWritableDatabase());
    }

    public void C(String str, int i2, String str2) {
        if (i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", str2);
        new k(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.f49177b.getWritableDatabase());
    }

    public void D(String str) {
        new e(this, str).c(this.f49177b.getWritableDatabase());
    }

    public void E(String str, String str2) {
        new f(this, str, str2).c(this.f49177b.getWritableDatabase());
    }

    public void c(String str, int i2) {
        if (i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        new m(this, "flowid=\"" + str + "\" AND flowhandle = " + i2, i2).c(this.f49177b.getWritableDatabase());
    }

    public final boolean d(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
        boolean equals = str.equals(str2);
        boolean z = false;
        if (equals) {
            return true;
        }
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
            } catch (SQLiteFullException unused) {
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            return z;
        } finally {
            d.b.g0.p.d.a(cursor);
        }
    }

    public void e() {
        new n().c(this.f49177b.getWritableDatabase());
        j("flow");
        j("event");
    }

    public boolean f(SparseArray<Integer> sparseArray, ArrayList<String> arrayList, boolean z, String str) {
        C1029a c1029a = new C1029a(sparseArray, str, arrayList, z);
        c1029a.c(this.f49177b.getWritableDatabase());
        return c1029a.a();
    }

    public void g() {
        new d(this).c(this.f49177b.getWritableDatabase());
    }

    public void h(String str) {
        new c(this, str).c(this.f49177b.getWritableDatabase());
    }

    public void i(String str, int i2, long j2, JSONArray jSONArray) {
        if (i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", "2");
        contentValues.put("endtime", Long.valueOf(j2));
        if (jSONArray != null && jSONArray.length() > 0) {
            contentValues.put("slot", jSONArray.toString());
        }
        new l(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.f49177b.getWritableDatabase());
    }

    public final void j(String str) {
        SQLiteDatabase writableDatabase = this.f49177b.getWritableDatabase();
        int i2 = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id) FROM " + str, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    if (cursor.getInt(0) > d.b.g0.n.d.g().f()) {
                        i2 = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                    }
                }
            } catch (SQLiteFullException unused) {
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            if (i2 > 0) {
                new o(this, str, i2).c(writableDatabase);
            }
        } finally {
            d.b.g0.p.d.a(cursor);
        }
    }

    public int k(u uVar) {
        this.f49176a = 0L;
        StringBuilder sb = new StringBuilder(256);
        sb.append(" SELECT * FROM ");
        sb.append("flow");
        int p2 = p(sb.toString(), uVar);
        if (this.f49176a >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            return 1;
        }
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("SELECT * FROM ");
        sb2.append("event");
        sb2.append(" WHERE ");
        sb2.append("flowhandle");
        sb2.append(" = ");
        sb2.append(-1);
        return o(sb2.toString(), uVar) | p2;
    }

    public int l(ArrayList<d.b.g0.n.f> arrayList, u uVar) {
        int i2;
        this.f49176a = 0L;
        String r = r(arrayList, true);
        if (TextUtils.isEmpty(r)) {
            i2 = 0;
        } else {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * ");
            sb.append(" FROM ");
            sb.append("flow");
            sb.append(" WHERE ");
            sb.append("flowid");
            sb.append(" in (");
            sb.append(r);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            i2 = p(sb.toString(), uVar);
        }
        String r2 = r(arrayList, false);
        if (TextUtils.isEmpty(r2)) {
            return i2;
        }
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("SELECT *  FROM ");
        sb2.append("event");
        sb2.append(" WHERE ");
        sb2.append("eventid");
        sb2.append(" in (");
        sb2.append(r2);
        sb2.append(SmallTailInfo.EMOTION_SUFFIX);
        sb2.append(" AND ");
        sb2.append("flowhandle");
        sb2.append(" = ");
        sb2.append(-1);
        return i2 | o(sb2.toString(), uVar);
    }

    public final long m() {
        return this.f49177b.e();
    }

    public final long n() {
        return this.f49177b.f();
    }

    public final int o(String str, u uVar) {
        long j2;
        int i2;
        JSONObject jSONObject;
        Object string;
        int i3;
        long j3;
        int i4;
        Object obj;
        String string2;
        Cursor cursor = null;
        long j4 = Long.MAX_VALUE;
        try {
            try {
                cursor = this.f49177b.getReadableDatabase().rawQuery(str, null);
                if (cursor == null || cursor.getCount() <= 0) {
                    j2 = 0;
                    i2 = 0;
                } else {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("eventid");
                    int columnIndex2 = cursor.getColumnIndex("begintime");
                    int columnIndex3 = cursor.getColumnIndex("content");
                    int columnIndex4 = cursor.getColumnIndex("reserve1");
                    int columnIndex5 = cursor.getColumnIndex("reserve2");
                    int columnIndex6 = cursor.getColumnIndex("extend");
                    long j5 = 0;
                    while (true) {
                        try {
                            jSONObject = new JSONObject();
                            string = cursor.getString(columnIndex);
                            jSONObject.put("bizId", string);
                            long j6 = cursor.getLong(columnIndex2);
                            i3 = columnIndex2;
                            jSONObject.put("timestamp", Long.toString(j6));
                            if (j6 > 0) {
                                if (j6 < j4) {
                                    j4 = j6;
                                }
                                if (j6 > j5) {
                                    j5 = j6;
                                }
                            }
                        } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused) {
                        } catch (RuntimeException e2) {
                            e = e2;
                        }
                        try {
                            jSONObject.put("eventType", "0");
                            String string3 = cursor.getString(columnIndex3);
                            j3 = j4;
                            if (TextUtils.isEmpty(string3)) {
                                i4 = columnIndex;
                                obj = string;
                            } else {
                                try {
                                    jSONObject.put("content", string3);
                                    i4 = columnIndex;
                                    obj = string;
                                    this.f49176a += string3.getBytes("UTF-8").length;
                                } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused2) {
                                    j2 = j5;
                                    j4 = j3;
                                    d.b.g0.p.d.a(cursor);
                                    i2 = 0;
                                    uVar.o(j4, j2);
                                    return i2;
                                } catch (RuntimeException e3) {
                                    e = e3;
                                    j2 = j5;
                                    j4 = j3;
                                    e.printStackTrace();
                                    d.b.g0.p.d.a(cursor);
                                    i2 = 0;
                                    uVar.o(j4, j2);
                                    return i2;
                                }
                            }
                            String string4 = cursor.getString(columnIndex4);
                            if (!TextUtils.isEmpty(string4)) {
                                jSONObject.put("abtest", string4);
                                uVar.p("1");
                                this.f49176a += string4.getBytes("UTF-8").length;
                            }
                            if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                                jSONObject.put("c", cursor.getString(columnIndex5));
                            }
                            if (!TextUtils.isEmpty(cursor.getString(columnIndex6))) {
                                if (new JSONObject(cursor.getString(columnIndex6)).has("ctr")) {
                                    jSONObject.put("of", "1");
                                }
                                this.f49176a += string2.getBytes("UTF-8").length;
                            }
                            jSONObject.put(Constant.ID_TYPE, d.b.g0.n.d.g().j(obj));
                            r.a(jSONObject);
                            uVar.a(jSONObject);
                            columnIndex = i4;
                            uVar.m(cursor.getString(columnIndex));
                            if (this.f49176a >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE || !cursor.moveToNext()) {
                                break;
                            }
                            columnIndex2 = i3;
                            j4 = j3;
                        } catch (SQLiteFullException unused3) {
                            j2 = j5;
                            d.b.g0.p.d.a(cursor);
                            i2 = 0;
                            uVar.o(j4, j2);
                            return i2;
                        } catch (UnsupportedEncodingException unused4) {
                            j2 = j5;
                            d.b.g0.p.d.a(cursor);
                            i2 = 0;
                            uVar.o(j4, j2);
                            return i2;
                        } catch (RuntimeException e4) {
                            e = e4;
                            j2 = j5;
                            e.printStackTrace();
                            d.b.g0.p.d.a(cursor);
                            i2 = 0;
                            uVar.o(j4, j2);
                            return i2;
                        } catch (JSONException unused5) {
                            j2 = j5;
                            d.b.g0.p.d.a(cursor);
                            i2 = 0;
                            uVar.o(j4, j2);
                            return i2;
                        }
                    }
                    i2 = 1;
                    j2 = j5;
                    j4 = j3;
                }
            } finally {
                d.b.g0.p.d.a(null);
            }
        } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused6) {
            j2 = 0;
        } catch (RuntimeException e5) {
            e = e5;
            j2 = 0;
        }
        uVar.o(j4, j2);
        return i2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:74:0x01da
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int p(java.lang.String r30, d.b.g0.n.u r31) {
        /*
            r29 = this;
            r1 = r29
            r2 = r31
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            d.b.g0.n.o r0 = r1.f49177b
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()
            r4 = 0
            r10 = r30
            android.database.Cursor r4 = r0.rawQuery(r10, r4)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            if (r4 == 0) goto L1e5
            int r0 = r4.getCount()     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            if (r0 <= 0) goto L1e5
            r4.moveToFirst()     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "flowid"
            int r11 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "flowhandle"
            int r12 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "state"
            int r13 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "begintime"
            int r14 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "endtime"
            int r15 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "content"
            int r7 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "option"
            int r8 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "reserve1"
            int r9 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "reserve2"
            int r10 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "slot"
            int r5 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            java.lang.String r0 = "extend"
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1f6 java.lang.RuntimeException -> L1f8 java.lang.Throwable -> L20b
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r20 = 0
        L6a:
            java.lang.String r0 = "2"
            java.lang.String r2 = r4.getString(r13)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            boolean r0 = r0.equals(r2)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            if (r0 != 0) goto La6
            long r22 = r4.getLong(r14)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r24 = java.lang.System.currentTimeMillis()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r22 = r22 - r24
            long r22 = java.lang.Math.abs(r22)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r24 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r0 <= 0) goto L94
            int r0 = r4.getInt(r8)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r0 = r0 & 4
            if (r0 == 0) goto L94
            goto La6
        L94:
            r24 = r8
            r22 = r11
            r23 = r12
            r25 = r13
            r26 = r14
            r18 = 0
            r8 = r31
            r11 = r7
            r7 = 1
            goto L1b7
        La6:
            d.b.g0.n.k r2 = new d.b.g0.n.k     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r2.<init>()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            java.lang.String r0 = r4.getString(r11)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r2.u(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = r4.getInt(r12)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r2.t(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r22 = r11
            r23 = r12
            long r11 = r4.getLong(r14)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r2.m(r11)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r11 = r4.getLong(r15)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r2.q(r11)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Le3
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto Le3
            long r11 = r2.d()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r20 = r11
        Le3:
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Lfb
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r0 >= 0) goto Lfb
            long r11 = r2.a()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r16 = r11
        Lfb:
            java.lang.String r0 = r4.getString(r7)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            java.lang.String r12 = "UTF-8"
            if (r11 != 0) goto L116
            r2.o(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r11 = r7
            r24 = r8
            long r7 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r1.f49176a = r7     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            goto L119
        L116:
            r11 = r7
            r24 = r8
        L119:
            java.lang.String r0 = r4.getString(r9)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            if (r7 != 0) goto L136
            r2.s(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r7 = r1.f49176a     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r25 = r13
            r26 = r14
            long r13 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r7 = r7 + r13
            r1.f49176a = r7     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            goto L13a
        L136:
            r25 = r13
            r26 = r14
        L13a:
            java.lang.String r0 = r4.getString(r10)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            if (r0 != 0) goto L14b
            java.lang.String r0 = r4.getString(r10)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r2.n(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
        L14b:
            java.lang.String r0 = r4.getString(r5)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            if (r5 < 0) goto L165
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            if (r7 != 0) goto L165
            r2.v(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r7 = r1.f49176a     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r13 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r7 = r7 + r13
            r1.f49176a = r7     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
        L165:
            java.lang.String r0 = r4.getString(r6)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            if (r7 != 0) goto L198
            long r7 = r1.f49176a     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            byte[] r0 = r0.getBytes(r12)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r12 = (long) r0     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            long r7 = r7 + r12
            r1.f49176a = r7     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L192 java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            java.lang.String r7 = r4.getString(r6)     // Catch: org.json.JSONException -> L192 java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r0.<init>(r7)     // Catch: org.json.JSONException -> L192 java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            java.lang.String r7 = "ctr"
            boolean r0 = r0.has(r7)     // Catch: org.json.JSONException -> L192 java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            if (r0 == 0) goto L198
            r7 = 1
            r2.p(r7)     // Catch: org.json.JSONException -> L190 java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            goto L199
        L190:
            r0 = move-exception
            goto L194
        L192:
            r0 = move-exception
            r7 = 1
        L194:
            r0.printStackTrace()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            goto L199
        L198:
            r7 = 1
        L199:
            r3.add(r2)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r0 = r2.f()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            java.lang.String r2 = r2.g()     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.io.UnsupportedEncodingException -> L1d0 java.lang.RuntimeException -> L1d3 android.database.sqlite.SQLiteFullException -> L1d7 java.lang.Throwable -> L1f6
            r8 = r31
            r8.n(r0, r2)     // Catch: java.lang.RuntimeException -> L1ce java.lang.Throwable -> L1e2 java.lang.Throwable -> L1f6
            long r12 = r1.f49176a     // Catch: java.lang.RuntimeException -> L1ce java.lang.Throwable -> L1e2 java.lang.Throwable -> L1f6
            r27 = 2097152(0x200000, double:1.036131E-317)
            int r0 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            if (r0 < 0) goto L1b7
            goto L1bd
        L1b7:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.RuntimeException -> L1ce java.lang.Throwable -> L1e2 java.lang.Throwable -> L1f6
            if (r0 != 0) goto L1c0
        L1bd:
            r5 = r20
            goto L1f0
        L1c0:
            r2 = r8
            r7 = r11
            r11 = r22
            r12 = r23
            r8 = r24
            r13 = r25
            r14 = r26
            goto L6a
        L1ce:
            r0 = move-exception
            goto L1de
        L1d0:
            r8 = r31
            goto L1e2
        L1d3:
            r0 = move-exception
            r8 = r31
            goto L1de
        L1d7:
            r8 = r31
            goto L1e2
        L1da:
            r8 = r2
            goto L1e2
        L1dc:
            r0 = move-exception
            r8 = r2
        L1de:
            r5 = r20
            goto L203
        L1e1:
            r8 = r2
        L1e2:
            r5 = r20
            goto L215
        L1e5:
            r8 = r2
            r18 = 0
            r5 = r18
            r7 = 0
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1f0:
            d.b.g0.p.d.a(r4)
            r9 = r16
            goto L21b
        L1f6:
            r0 = move-exception
            goto L207
        L1f8:
            r0 = move-exception
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L203:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1f6
            goto L215
        L207:
            d.b.g0.p.d.a(r4)
            throw r0
        L20b:
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L215:
            d.b.g0.p.d.a(r4)
            r9 = r16
            r7 = 0
        L21b:
            int r0 = r3.size()
            if (r0 <= 0) goto L224
            r1.q(r3, r8)
        L224:
            r8.o(r9, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.g0.n.a.p(java.lang.String, d.b.g0.n.u):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:55:0x0173
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final void q(java.util.ArrayList<d.b.g0.n.k> r22, d.b.g0.n.u r23) {
        /*
            r21 = this;
            r0 = r23
            java.lang.String r1 = "begintime"
            java.lang.String r2 = " , "
            java.lang.String r3 = "eventid"
            java.lang.String r4 = "1"
            java.lang.String r5 = "content"
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            r7 = r21
            d.b.g0.n.o r8 = r7.f49177b
            android.database.sqlite.SQLiteDatabase r8 = r8.getReadableDatabase()
            java.util.Iterator r9 = r22.iterator()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r11 = 0
        L1e:
            boolean r12 = r9.hasNext()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            if (r12 == 0) goto L192
            java.lang.Object r12 = r9.next()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            d.b.g0.n.k r12 = (d.b.g0.n.k) r12     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            int r13 = r12.f()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            if (r13 < 0) goto L180
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.<init>()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r14 = "bizId"
            java.lang.String r15 = r12.g()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.put(r14, r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r14 = "starttime"
            long r15 = r12.a()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = java.lang.Long.toString(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.put(r14, r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r14 = "endtime"
            long r15 = r12.d()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = java.lang.Long.toString(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.put(r14, r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r14 = "eventType"
            r13.put(r14, r4)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r14 = r12.c()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            if (r14 != 0) goto L70
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r14 = r12.c()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r6.<init>(r14)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
        L70:
            java.lang.String r14 = r12.e()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            if (r14 != 0) goto L86
            java.lang.String r14 = "abtest"
            java.lang.String r15 = r12.e()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.put(r14, r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r0.p(r4)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
        L86:
            java.lang.String r14 = r12.b()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            if (r14 != 0) goto L99
            java.lang.String r14 = "c"
            java.lang.String r15 = r12.b()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.put(r14, r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
        L99:
            org.json.JSONArray r14 = r12.j()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            if (r14 == 0) goto La8
            java.lang.String r14 = "part"
            org.json.JSONArray r15 = r12.j()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.put(r14, r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
        La8:
            boolean r14 = r12.l()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            if (r14 == 0) goto Lb3
            java.lang.String r14 = "of"
            r13.put(r14, r4)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
        Lb3:
            java.lang.String r14 = "idtype"
            d.b.g0.n.d r15 = d.b.g0.n.d.g()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r10 = r12.g()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r10 = r15.j(r10)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r13.put(r14, r10)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r10.<init>()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r15 = 256(0x100, float:3.59E-43)
            r14.<init>(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = "SELECT "
            r14.append(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r14.append(r3)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r14.append(r2)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r14.append(r1)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r14.append(r2)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r14.append(r5)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = " FROM "
            r14.append(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = "event"
            r14.append(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = " WHERE "
            r14.append(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = "flowhandle"
            r14.append(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r15 = " = "
            r14.append(r15)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            int r12 = r12.f()     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r14.append(r12)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            java.lang.String r12 = r14.toString()     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L16f
            r14 = 0
            android.database.Cursor r11 = r8.rawQuery(r12, r14)     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L16f
            if (r11 == 0) goto L160
            int r12 = r11.getCount()     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L16f
            if (r12 <= 0) goto L160
            r11.moveToFirst()     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L16f
            int r12 = r11.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L16f
            int r15 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L16f
            int r14 = r11.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L16f
            r16 = r1
        L126:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L171
            r1.<init>()     // Catch: java.lang.Throwable -> L16a android.database.sqlite.SQLiteFullException -> L171
            r17 = r2
            java.lang.String r2 = "id"
            r18 = r3
            java.lang.String r3 = r11.getString(r12)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            java.lang.String r2 = "timestamp"
            long r19 = r11.getLong(r15)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            java.lang.String r3 = java.lang.Long.toString(r19)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            java.lang.String r2 = r11.getString(r14)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            r1.put(r5, r2)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            r10.put(r1)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            boolean r1 = r11.moveToNext()     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            if (r1 != 0) goto L15b
            java.lang.String r1 = "eventlist"
            r6.put(r1, r10)     // Catch: android.database.sqlite.SQLiteFullException -> L166 java.lang.Throwable -> L16a
            goto L166
        L15b:
            r2 = r17
            r3 = r18
            goto L126
        L160:
            r16 = r1
            r17 = r2
            r18 = r3
        L166:
            d.b.g0.p.d.a(r11)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            goto L176
        L16a:
            r0 = move-exception
            d.b.g0.p.d.a(r11)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            throw r0     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
        L16f:
            r16 = r1
        L171:
            r17 = r2
        L173:
            r18 = r3
            goto L166
        L176:
            r13.put(r5, r6)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            d.b.g0.n.r.a(r13)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            r0.a(r13)     // Catch: java.lang.RuntimeException -> L18e org.json.JSONException -> L192
            goto L186
        L180:
            r16 = r1
            r17 = r2
            r18 = r3
        L186:
            r1 = r16
            r2 = r17
            r3 = r18
            goto L1e
        L18e:
            r0 = move-exception
            r0.printStackTrace()
        L192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.g0.n.a.q(java.util.ArrayList, d.b.g0.n.u):void");
    }

    public final String r(ArrayList<d.b.g0.n.f> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            d.b.g0.n.f fVar = arrayList.get(i3);
            if (z && !"0".equals(fVar.b())) {
                if (i2 > 0) {
                    sb.append(",");
                } else {
                    i2++;
                }
                sb.append(fVar.a());
            } else if (!z && "0".equals(fVar.b())) {
                if (i2 > 0) {
                    sb.append(",");
                } else {
                    i2++;
                }
                sb.append(fVar.a());
            }
        }
        return sb.toString();
    }

    public final String s(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i2));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.database.Cursor] */
    public d.b.g0.n.j t(String str) {
        Closeable closeable;
        ?? sb = new StringBuilder();
        SQLiteDatabase readableDatabase = this.f49177b.getReadableDatabase();
        sb.append("SELECT ");
        sb.append("state");
        sb.append(" , ");
        sb.append("reserve1");
        sb.append(" FROM ");
        sb.append("file");
        sb.append(" WHERE ");
        sb.append(BreakpointSQLiteKey.FILENAME);
        sb.append("=\"");
        sb.append(str);
        sb.append("\"");
        Closeable closeable2 = null;
        r4 = null;
        r4 = null;
        d.b.g0.n.j jVar = null;
        try {
            try {
                sb = readableDatabase.rawQuery(sb.toString(), null);
                closeable = sb;
                if (sb != 0) {
                    try {
                        int count = sb.getCount();
                        closeable = sb;
                        if (count > 0) {
                            sb.moveToFirst();
                            jVar = new d.b.g0.n.j(str, sb.getString(sb.getColumnIndex("state")), sb.isNull(sb.getColumnIndex("reserve1")) ? "" : sb.getString(sb.getColumnIndex("reserve1")));
                            closeable = sb;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "DBError");
                            jSONObject.put("exception", Log.getStackTraceString(e));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        d.b.g0.n.e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                        closeable = sb;
                        d.b.g0.p.d.a(closeable);
                        return jVar;
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = sb;
                d.b.g0.p.d.a(closeable2);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            sb = 0;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.p.d.a(closeable2);
            throw th;
        }
        d.b.g0.p.d.a(closeable);
        return jVar;
    }

    public void u(SparseArray<ArrayList> sparseArray) {
        SQLiteDatabase readableDatabase = this.f49177b.getReadableDatabase();
        Cursor cursor = null;
        try {
            try {
                cursor = readableDatabase.rawQuery("SELECT eventid , type , cycle FROM config WHERE " + SetImageWatermarkTypeReqMsg.SWITCH + "=\"1\"", null);
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
                                i2 = PeerConnectionClient.HD_VIDEO_HEIGHT;
                            }
                        }
                        if (string != null) {
                            ArrayList arrayList = sparseArray.get(i2);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                sparseArray.put(i2, arrayList);
                            }
                            arrayList.add(new d.b.g0.n.f(string, string2));
                        }
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteFullException e2) {
                e2.printStackTrace();
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            }
        } finally {
            d.b.g0.p.d.a(cursor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4 A[Catch: all -> 0x0112, RuntimeException -> 0x0114, SQLiteFullException -> 0x011d, TryCatch #5 {SQLiteFullException -> 0x011d, RuntimeException -> 0x0114, blocks: (B:6:0x001a, B:8:0x0024, B:10:0x002a, B:11:0x002d, B:15:0x0092, B:21:0x00a4, B:23:0x00ac, B:25:0x00b2, B:28:0x00bc, B:30:0x00c8, B:32:0x00ce, B:36:0x00da, B:38:0x00e7, B:40:0x00ed, B:43:0x00fc, B:51:0x010b, B:49:0x0105, B:17:0x0097, B:19:0x009e), top: B:66:0x001a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2 A[Catch: all -> 0x0112, RuntimeException -> 0x0114, SQLiteFullException -> 0x011d, TryCatch #5 {SQLiteFullException -> 0x011d, RuntimeException -> 0x0114, blocks: (B:6:0x001a, B:8:0x0024, B:10:0x002a, B:11:0x002d, B:15:0x0092, B:21:0x00a4, B:23:0x00ac, B:25:0x00b2, B:28:0x00bc, B:30:0x00c8, B:32:0x00ce, B:36:0x00da, B:38:0x00e7, B:40:0x00ed, B:43:0x00fc, B:51:0x010b, B:49:0x0105, B:17:0x0097, B:19:0x009e), top: B:66:0x001a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bc A[Catch: all -> 0x0112, RuntimeException -> 0x0114, SQLiteFullException -> 0x011d, TryCatch #5 {SQLiteFullException -> 0x011d, RuntimeException -> 0x0114, blocks: (B:6:0x001a, B:8:0x0024, B:10:0x002a, B:11:0x002d, B:15:0x0092, B:21:0x00a4, B:23:0x00ac, B:25:0x00b2, B:28:0x00bc, B:30:0x00c8, B:32:0x00ce, B:36:0x00da, B:38:0x00e7, B:40:0x00ed, B:43:0x00fc, B:51:0x010b, B:49:0x0105, B:17:0x0097, B:19:0x009e), top: B:66:0x001a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce A[Catch: all -> 0x0112, RuntimeException -> 0x0114, SQLiteFullException -> 0x011d, TryCatch #5 {SQLiteFullException -> 0x011d, RuntimeException -> 0x0114, blocks: (B:6:0x001a, B:8:0x0024, B:10:0x002a, B:11:0x002d, B:15:0x0092, B:21:0x00a4, B:23:0x00ac, B:25:0x00b2, B:28:0x00bc, B:30:0x00c8, B:32:0x00ce, B:36:0x00da, B:38:0x00e7, B:40:0x00ed, B:43:0x00fc, B:51:0x010b, B:49:0x0105, B:17:0x0097, B:19:0x009e), top: B:66:0x001a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, d.b.g0.n.h> hashMap3, HashSet<String> hashSet5) {
        SQLiteDatabase readableDatabase = this.f49177b.getReadableDatabase();
        if (readableDatabase == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = readableDatabase.rawQuery("SELECT * FROM config", null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        String string = cursor.getString(cursor.getColumnIndex("eventid"));
                        String string2 = cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH));
                        int i2 = cursor.getInt(cursor.getColumnIndex("sample"));
                        String string3 = cursor.getString(cursor.getColumnIndex("reserve1"));
                        String string4 = cursor.getString(cursor.getColumnIndex("reserve2"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("cycle"));
                        int i4 = cursor.getInt(cursor.getColumnIndex("uploadrule"));
                        int i5 = cursor.getInt(cursor.getColumnIndex("recordrule"));
                        String string5 = cursor.getString(cursor.getColumnIndex("extend"));
                        if (TextUtils.equals(string2, "0")) {
                            hashSet.add(string);
                        } else if (TextUtils.equals(string2, "1")) {
                            hashSet2.add(string);
                            if (i3 != 0) {
                                hashSet3.add(string);
                            }
                            if (!TextUtils.equals(string3, "1")) {
                                hashSet4.add(string);
                            }
                            if (i2 <= 0) {
                                hashMap.put(string, String.valueOf(i2));
                            }
                            if (TextUtils.isEmpty(string4)) {
                                hashMap2.put(string, string4);
                            }
                            if (i4 == 0 && i5 != 0) {
                                hashMap3.put(string, new d.b.g0.n.h(string, i5, i4));
                            }
                            if (!TextUtils.isEmpty(string5)) {
                                try {
                                } catch (JSONException e2) {
                                    e = e2;
                                }
                                if (new JSONObject(string5).has(Constant.ID_TYPE)) {
                                    try {
                                        hashSet5.add(string);
                                    } catch (JSONException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        if (!cursor.moveToNext()) {
                                        }
                                    }
                                }
                            }
                        }
                        if (i3 != 0) {
                        }
                        if (!TextUtils.equals(string3, "1")) {
                        }
                        if (i2 <= 0) {
                        }
                        if (TextUtils.isEmpty(string4)) {
                        }
                        if (i4 == 0) {
                        }
                        if (!TextUtils.isEmpty(string5)) {
                        }
                    } while (!cursor.moveToNext());
                }
            } finally {
                d.b.g0.p.d.a(cursor);
            }
        } catch (SQLiteFullException unused) {
        } catch (RuntimeException e4) {
            e4.printStackTrace();
        }
    }

    public void w(d.b.g0.n.i iVar) {
        if (iVar == null || TextUtils.isEmpty(iVar.h())) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(iVar.f()));
        contentValues.put("eventid", iVar.h());
        contentValues.put("begintime", Long.valueOf(iVar.k()));
        if (iVar.i() != null) {
            contentValues.put("content", iVar.i().toString());
        } else {
            contentValues.put("content", iVar.c());
        }
        contentValues.put("reserve1", iVar.d());
        if (!TextUtils.isEmpty(iVar.b())) {
            contentValues.put("reserve2", iVar.b());
        }
        if (iVar.l()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ctr", "1");
                contentValues.put("extend", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        new h(iVar.g(), iVar.h(), iVar.f(), contentValues).c(this.f49177b.getWritableDatabase());
    }

    public void x(List<d.b.g0.n.i> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new i(list).c(this.f49177b.getWritableDatabase());
    }

    public void y(String str, boolean z) {
        new b(this, str, z).c(this.f49177b.getWritableDatabase());
    }

    public void z(d.b.g0.n.k kVar) {
        if (kVar == null || TextUtils.isEmpty(kVar.g())) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowid", kVar.g());
        contentValues.put("flowhandle", Integer.valueOf(kVar.f()));
        contentValues.put("state", kVar.k());
        contentValues.put("begintime", Long.valueOf(kVar.a()));
        if (kVar.h() != null) {
            contentValues.put("content", kVar.h().toString());
        } else {
            contentValues.put("content", kVar.c());
        }
        contentValues.put("option", Integer.valueOf(kVar.i()));
        contentValues.put("reserve1", kVar.e());
        if (!TextUtils.isEmpty(kVar.b())) {
            contentValues.put("reserve2", kVar.b());
        }
        if (kVar.l()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ctr", "1");
                contentValues.put("extend", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        new j(this, contentValues).c(this.f49177b.getWritableDatabase());
    }

    /* loaded from: classes3.dex */
    public abstract class q {

        /* renamed from: a  reason: collision with root package name */
        public boolean f49208a;

        public q() {
            this.f49208a = false;
        }

        public boolean a() {
            return this.f49208a;
        }

        public abstract boolean b(SQLiteDatabase sQLiteDatabase);

        public void c(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase == null) {
                return;
            }
            this.f49208a = false;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    if (b(sQLiteDatabase)) {
                        sQLiteDatabase.setTransactionSuccessful();
                        this.f49208a = true;
                    }
                } catch (Throwable th) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (RuntimeException unused) {
                    }
                    throw th;
                }
            } catch (RuntimeException e2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "DBError");
                    jSONObject.put("db_size", a.this.n());
                    jSONObject.put("db_log_size", a.this.m());
                    jSONObject.put("exception", Log.getStackTraceString(e2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                d.b.g0.n.e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (RuntimeException unused2) {
            }
        }

        public /* synthetic */ q(a aVar, h hVar) {
            this();
        }
    }
}
