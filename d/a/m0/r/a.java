package d.a.m0.r;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.tencent.connect.common.Constants;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f52108a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.m0.r.o f52109b;

    /* renamed from: d.a.m0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1145a extends q {

        /* renamed from: c  reason: collision with root package name */
        public long f52110c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SparseIntArray f52111d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f52113f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f52114g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1145a(SparseIntArray sparseIntArray, String str, ArrayList arrayList, boolean z) {
            super(a.this, null);
            this.f52111d = sparseIntArray;
            this.f52112e = str;
            this.f52113f = arrayList;
            this.f52114g = z;
            this.f52110c = System.currentTimeMillis();
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ArrayList arrayList;
            SparseIntArray sparseIntArray = this.f52111d;
            if (sparseIntArray != null && sparseIntArray.size() > 0) {
                int size = this.f52111d.size();
                ArrayList arrayList2 = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList2.add(Integer.valueOf(this.f52111d.keyAt(i2)));
                }
                String str = "flowhandle in (" + a.this.t(arrayList2) + SmallTailInfo.EMOTION_SUFFIX;
                s.a("delete flow table flow count:" + sQLiteDatabase.delete("flow", str, null));
                s.a("delete flow table event count:" + sQLiteDatabase.delete("event", str, null));
            }
            ArrayList arrayList3 = this.f52113f;
            if (arrayList3 != null && arrayList3.size() > 0) {
                int delete = sQLiteDatabase.delete("event", "eventid in (" + a.this.t(this.f52113f) + ") AND flowhandle = -1", null);
                StringBuilder sb = new StringBuilder();
                sb.append("delete event table event count:");
                sb.append(delete);
                s.a(sb.toString());
            }
            SparseIntArray sparseIntArray2 = this.f52111d;
            if ((sparseIntArray2 != null && sparseIntArray2.size() > 0) || ((arrayList = this.f52113f) != null && arrayList.size() > 0)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("filename", this.f52112e);
                contentValues.put("state", "0");
                contentValues.put("reserve1", this.f52114g ? "1" : "0");
                sQLiteDatabase.replace("file", null, contentValues);
            }
            s.a("delete total time:" + (System.currentTimeMillis() - this.f52110c));
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52116c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f52117d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, boolean z) {
            super(aVar, null);
            this.f52116c = str;
            this.f52117d = z;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "1");
            contentValues.put("filename", this.f52116c);
            contentValues.put("reserve1", this.f52117d ? "1" : "0");
            sQLiteDatabase.replace("file", null, contentValues);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52118c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str) {
            super(aVar, null);
            this.f52118c = str;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete("file", "filename=\"" + this.f52118c + "\"", null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends q {
        public d(a aVar) {
            super(aVar, null);
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete("file", null, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52119c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, String str) {
            super(aVar, null);
            this.f52119c = str;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "1");
            sQLiteDatabase.update("file", contentValues, "filename=\"" + this.f52119c + "\"", null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52120c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f52121d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, String str, String str2) {
            super(aVar, null);
            this.f52120c = str;
            this.f52121d = str2;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", this.f52121d);
            sQLiteDatabase.update("file", contentValues, "filename=\"" + this.f52120c + "\"", null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends q {
        public g(a aVar) {
            super(aVar, null);
        }

        @Override // d.a.m0.r.a.q
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
        public final /* synthetic */ String f52122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f52123d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContentValues f52125f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, int i2, ContentValues contentValues) {
            super(a.this, null);
            this.f52122c = str;
            this.f52123d = str2;
            this.f52124e = i2;
            this.f52125f = contentValues;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return a.this.e(this.f52122c, this.f52123d, this.f52124e, sQLiteDatabase) && sQLiteDatabase.insert("event", null, this.f52125f) != -1;
        }
    }

    /* loaded from: classes3.dex */
    public class i extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f52127c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(List list) {
            super(a.this, null);
            this.f52127c = list;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            boolean z = true;
            for (d.a.m0.r.i iVar : this.f52127c) {
                if (!TextUtils.isEmpty(iVar.f52180a) && a.this.e(iVar.f52181b, iVar.f52180a, iVar.f52182c, sQLiteDatabase)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("flowhandle", Integer.valueOf(iVar.f52182c));
                    contentValues.put("eventid", iVar.f52180a);
                    contentValues.put("begintime", Long.valueOf(iVar.f52185f));
                    if (!TextUtils.isEmpty(iVar.f52183d)) {
                        contentValues.put("content", iVar.f52183d);
                    } else {
                        JSONObject jSONObject = iVar.f52184e;
                        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                            contentValues.put("content", iVar.f52184e.toString());
                        }
                    }
                    contentValues.put("reserve1", iVar.f52187h);
                    if (!TextUtils.isEmpty(iVar.f52188i)) {
                        contentValues.put("reserve2", iVar.f52188i);
                    }
                    if (iVar.j) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("ctr", "1");
                            contentValues.put("extend", jSONObject2.toString());
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
        public final /* synthetic */ ContentValues f52129c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(a aVar, ContentValues contentValues) {
            super(aVar, null);
            this.f52129c = contentValues;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.insert("flow", null, this.f52129c) != -1;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f52130c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f52131d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a aVar, ContentValues contentValues, String str) {
            super(aVar, null);
            this.f52130c = contentValues;
            this.f52131d = str;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.update("flow", this.f52130c, this.f52131d, null) == 1;
        }
    }

    /* loaded from: classes3.dex */
    public class l extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContentValues f52132c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f52133d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(a aVar, ContentValues contentValues, String str) {
            super(aVar, null);
            this.f52132c = contentValues;
            this.f52133d = str;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.update("flow", this.f52132c, this.f52133d, null) == 1;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52134c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f52135d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(a aVar, String str, int i2) {
            super(aVar, null);
            this.f52134c = str;
            this.f52135d = i2;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete("flow", this.f52134c, null);
            sQLiteDatabase.delete("event", "flowhandle = " + this.f52135d, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class n extends q {
        public n() {
            super(a.this, null);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x00a1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00b2 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x007a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00bc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r0v19, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r9v0, types: [android.database.sqlite.SQLiteDatabase] */
        @Override // d.a.m0.r.a.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            boolean moveToNext;
            long currentTimeMillis = System.currentTimeMillis() - d.a.m0.r.d.g().e();
            Closeable closeable = null;
            a.x(currentTimeMillis, sQLiteDatabase.delete("flow", "endtime < " + currentTimeMillis, null), "flow");
            a.x(currentTimeMillis, sQLiteDatabase.delete("event", "begintime < " + currentTimeMillis, null), "event");
            String str = "SELECT flowhandle FROM flow WHERE begintime < " + (System.currentTimeMillis() - 86400000) + " AND endtime is NULL  AND option = 0";
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    str = sQLiteDatabase.rawQuery(str, null);
                } catch (Throwable th) {
                    th = th;
                    closeable = str;
                    d.a.m0.t.d.d(closeable);
                    throw th;
                }
            } catch (SQLiteFullException unused) {
                str = 0;
            } catch (RuntimeException e2) {
                e = e2;
                str = 0;
            } catch (Throwable th2) {
                th = th2;
                d.a.m0.t.d.d(closeable);
                throw th;
            }
            if (str != 0) {
                try {
                    int count = str.getCount();
                    str = str;
                    if (count > 0) {
                        str.moveToFirst();
                        do {
                            arrayList.add(Integer.valueOf(str.getInt(str.getColumnIndex("flowhandle"))));
                            moveToNext = str.moveToNext();
                            str = str;
                        } while (moveToNext);
                    }
                } catch (SQLiteFullException unused2) {
                } catch (RuntimeException e3) {
                    e = e3;
                    e.printStackTrace();
                    str = str;
                    d.a.m0.t.d.d(str);
                    if (arrayList.size() != 0) {
                    }
                }
            }
            d.a.m0.t.d.d(str);
            if (arrayList.size() != 0) {
                return true;
            }
            String str2 = "flowhandle in (" + a.this.t(arrayList) + SmallTailInfo.EMOTION_SUFFIX;
            sQLiteDatabase.delete("flow", str2, null);
            sQLiteDatabase.delete("event", str2, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52137c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f52138d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(a aVar, String str, int i2) {
            super(aVar, null);
            this.f52137c = str;
            this.f52138d = i2;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            String str = this.f52137c;
            int delete = sQLiteDatabase.delete(str, "_id < " + this.f52138d, null);
            d.a.m0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delLimit");
            return delete > 0;
        }
    }

    /* loaded from: classes3.dex */
    public class p extends q {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f52139c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(a aVar, List list) {
            super(aVar, null);
            this.f52139c = list;
        }

        @Override // d.a.m0.r.a.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            for (d.a.m0.r.g gVar : this.f52139c) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("eventid", gVar.f52166a);
                contentValues.put("type", gVar.f52170e);
                contentValues.put("cycle", Integer.valueOf("1".equals(gVar.f52168c) ? 0 : gVar.f52169d));
                contentValues.put(SetImageWatermarkTypeReqMsg.SWITCH, gVar.f52167b);
                contentValues.put("reserve1", gVar.f52171f);
                if (!TextUtils.isEmpty(gVar.f52173h)) {
                    contentValues.put("reserve2", gVar.f52173h);
                }
                contentValues.put("sample", Integer.valueOf(gVar.f52172g));
                int i2 = gVar.f52174i;
                if (i2 != 0 && gVar.j != 0) {
                    contentValues.put("recordrule", Integer.valueOf(i2));
                    contentValues.put("uploadrule", Integer.valueOf(gVar.j));
                }
                if (TextUtils.equals(gVar.k, "1")) {
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
        this.f52109b = new d.a.m0.r.o(context);
    }

    public static void x(long j2, int i2, String str) {
        if (i2 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", ContentUtil.RESULT_KEY_EXPIRE);
                jSONObject.put("ubc_type", str);
                jSONObject.put("expire_time", j2);
                jSONObject.put("count", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d.a.m0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
        }
    }

    public void A(String str, boolean z) {
        new b(this, str, z).c(this.f52109b.getWritableDatabase());
    }

    public void B(d.a.m0.r.k kVar) {
        if (kVar == null || TextUtils.isEmpty(kVar.f52190a)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowid", kVar.f52190a);
        contentValues.put("flowhandle", Integer.valueOf(kVar.f52191b));
        contentValues.put("state", kVar.f52197h);
        contentValues.put("begintime", Long.valueOf(kVar.f52194e));
        JSONObject jSONObject = kVar.f52193d;
        if (jSONObject != null) {
            contentValues.put("content", jSONObject.toString());
        } else {
            contentValues.put("content", kVar.f52192c);
        }
        contentValues.put("option", Integer.valueOf(kVar.f52196g));
        contentValues.put("reserve1", kVar.f52198i);
        if (!TextUtils.isEmpty(kVar.j)) {
            contentValues.put("reserve2", kVar.j);
        }
        if (kVar.l) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ctr", "1");
                contentValues.put("extend", jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        new j(this, contentValues).c(this.f52109b.getWritableDatabase());
    }

    public void C() {
        new g(this).c(this.f52109b.getWritableDatabase());
    }

    public void D(List<d.a.m0.r.g> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new p(this, list).c(this.f52109b.getWritableDatabase());
    }

    public void E(String str, int i2, String str2) {
        if (i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", str2);
        new k(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.f52109b.getWritableDatabase());
    }

    public void F(String str) {
        new e(this, str).c(this.f52109b.getWritableDatabase());
    }

    public void G(String str, String str2) {
        new f(this, str, str2).c(this.f52109b.getWritableDatabase());
    }

    public void d(String str, int i2) {
        if (i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        new m(this, "flowid=\"" + str + "\" AND flowhandle = " + i2, i2).c(this.f52109b.getWritableDatabase());
    }

    public final boolean e(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
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
            d.a.m0.t.d.d(cursor);
        }
    }

    public void f() {
        new n().c(this.f52109b.getWritableDatabase());
        k("flow");
        k("event");
    }

    public boolean g(SparseIntArray sparseIntArray, ArrayList<String> arrayList, boolean z, String str) {
        C1145a c1145a = new C1145a(sparseIntArray, str, arrayList, z);
        c1145a.c(this.f52109b.getWritableDatabase());
        return c1145a.a();
    }

    public void h() {
        new d(this).c(this.f52109b.getWritableDatabase());
    }

    public void i(String str) {
        new c(this, str).c(this.f52109b.getWritableDatabase());
    }

    public void j(String str, int i2, long j2, JSONArray jSONArray) {
        if (i2 < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", "2");
        contentValues.put("endtime", Long.valueOf(j2));
        if (jSONArray != null && jSONArray.length() > 0) {
            contentValues.put("slot", jSONArray.toString());
        }
        new l(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.f52109b.getWritableDatabase());
    }

    public final void k(String str) {
        SQLiteDatabase writableDatabase = this.f52109b.getWritableDatabase();
        int i2 = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id)  FROM " + str, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    if (cursor.getInt(0) > d.a.m0.r.d.g().f()) {
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
            d.a.m0.t.d.d(cursor);
        }
    }

    public int l(u uVar) {
        this.f52108a = 0L;
        int q2 = q(" SELECT * FROM flow", uVar);
        if (this.f52108a >= 2097152) {
            return 1;
        }
        return p("SELECT * FROM event WHERE flowhandle = -1", uVar) | q2;
    }

    public int m(ArrayList<d.a.m0.r.f> arrayList, u uVar) {
        int i2;
        this.f52108a = 0L;
        String s = s(arrayList, true);
        if (TextUtils.isEmpty(s)) {
            i2 = 0;
        } else {
            i2 = q("SELECT *  FROM flow WHERE flowid in (" + s + SmallTailInfo.EMOTION_SUFFIX, uVar);
        }
        String s2 = s(arrayList, false);
        if (TextUtils.isEmpty(s2)) {
            return i2;
        }
        return i2 | p("SELECT *  FROM event WHERE eventid in (" + s2 + ") AND flowhandle = -1", uVar);
    }

    public final long n() {
        return this.f52109b.e();
    }

    public final long o() {
        return this.f52109b.f();
    }

    public final int p(String str, u uVar) {
        u uVar2;
        long j2;
        long j3;
        int i2;
        int i3;
        String str2;
        long j4;
        int i4;
        String string;
        int i5;
        u uVar3 = uVar;
        String str3 = "content";
        Cursor cursor = null;
        long j5 = Long.MAX_VALUE;
        try {
            try {
                cursor = this.f52109b.getReadableDatabase().rawQuery(str, null);
                if (cursor == null || cursor.getCount() <= 0) {
                    uVar2 = uVar3;
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
                    j2 = 0;
                    while (true) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            String string2 = cursor.getString(columnIndex3);
                            int i6 = columnIndex3;
                            int i7 = columnIndex6;
                            if (TextUtils.isEmpty(string2)) {
                                i3 = columnIndex5;
                                str2 = str3;
                            } else {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(string2);
                                    if (jSONObject2.has("bizId")) {
                                        JSONObject jSONObject3 = jSONObject2.getJSONObject(str3);
                                        i3 = columnIndex5;
                                        JSONObject jSONObject4 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                                        if (jSONObject3 != null && jSONObject4 != null) {
                                            jSONObject3.put(DI.APP_INFO_NAME, jSONObject4);
                                            jSONObject2.remove(DI.APP_INFO_NAME);
                                        }
                                        jSONObject = jSONObject2;
                                    } else {
                                        i3 = columnIndex5;
                                        jSONObject.put(str3, jSONObject2);
                                    }
                                    str2 = str3;
                                    this.f52108a += string2.getBytes("UTF-8").length;
                                } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused) {
                                    uVar2 = uVar;
                                    d.a.m0.t.d.d(cursor);
                                    j3 = j2;
                                    i2 = 0;
                                    uVar2.g(j5, j3);
                                    return i2;
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    uVar2 = uVar;
                                    e.printStackTrace();
                                    d.a.m0.t.d.d(cursor);
                                    j3 = j2;
                                    i2 = 0;
                                    uVar2.g(j5, j3);
                                    return i2;
                                }
                            }
                            String string3 = cursor.getString(columnIndex);
                            jSONObject.put("bizId", string3);
                            long j6 = cursor.getLong(columnIndex2);
                            jSONObject.put("timestamp", Long.toString(j6));
                            if (j6 > 0) {
                                if (j6 < j5) {
                                    j5 = j6;
                                }
                                if (j6 > j2) {
                                    j2 = j6;
                                }
                            }
                            try {
                                try {
                                    jSONObject.put("eventType", "0");
                                    String string4 = cursor.getString(columnIndex4);
                                    if (TextUtils.isEmpty(string4)) {
                                        uVar2 = uVar;
                                        j4 = j5;
                                        i4 = columnIndex2;
                                    } else {
                                        jSONObject.put("abtest", string4);
                                        uVar2 = uVar;
                                        try {
                                            uVar2.f52268f = "1";
                                            j4 = j5;
                                            try {
                                                i4 = columnIndex2;
                                                this.f52108a += string4.getBytes("UTF-8").length;
                                            } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused2) {
                                                j5 = j4;
                                                d.a.m0.t.d.d(cursor);
                                                j3 = j2;
                                                i2 = 0;
                                                uVar2.g(j5, j3);
                                                return i2;
                                            } catch (RuntimeException e3) {
                                                e = e3;
                                                j5 = j4;
                                                e.printStackTrace();
                                                d.a.m0.t.d.d(cursor);
                                                j3 = j2;
                                                i2 = 0;
                                                uVar2.g(j5, j3);
                                                return i2;
                                            }
                                        } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused3) {
                                            d.a.m0.t.d.d(cursor);
                                            j3 = j2;
                                            i2 = 0;
                                            uVar2.g(j5, j3);
                                            return i2;
                                        } catch (RuntimeException e4) {
                                            e = e4;
                                            e.printStackTrace();
                                            d.a.m0.t.d.d(cursor);
                                            j3 = j2;
                                            i2 = 0;
                                            uVar2.g(j5, j3);
                                            return i2;
                                        }
                                    }
                                    int i8 = i3;
                                    if (!TextUtils.isEmpty(cursor.getString(i8))) {
                                        jSONObject.put("c", cursor.getString(i8));
                                    }
                                    if (TextUtils.isEmpty(cursor.getString(i7))) {
                                        i5 = i7;
                                    } else {
                                        if (new JSONObject(cursor.getString(i7)).has("ctr")) {
                                            jSONObject.put("of", "1");
                                        }
                                        i5 = i7;
                                        this.f52108a += string.getBytes("UTF-8").length;
                                    }
                                    jSONObject.put(Constant.ID_TYPE, d.a.m0.r.d.g().j(string3));
                                    r.a(jSONObject);
                                    uVar2.a(jSONObject);
                                    uVar2.e(cursor.getString(columnIndex));
                                    if (this.f52108a >= 2097152 || !cursor.moveToNext()) {
                                        break;
                                    }
                                    columnIndex3 = i6;
                                    uVar3 = uVar2;
                                    columnIndex6 = i5;
                                    j5 = j4;
                                    columnIndex2 = i4;
                                    String str4 = str2;
                                    columnIndex5 = i8;
                                    str3 = str4;
                                } catch (SQLiteFullException | UnsupportedEncodingException unused4) {
                                    uVar2 = uVar;
                                }
                            } catch (RuntimeException e5) {
                                e = e5;
                                uVar2 = uVar;
                            } catch (JSONException unused5) {
                                uVar2 = uVar;
                            }
                        } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused6) {
                            uVar2 = uVar3;
                        } catch (RuntimeException e6) {
                            e = e6;
                            uVar2 = uVar3;
                        }
                    }
                    i2 = 1;
                    j5 = j4;
                }
                d.a.m0.t.d.d(cursor);
                j3 = j2;
            } catch (Throwable th) {
                d.a.m0.t.d.d(null);
                throw th;
            }
        } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused7) {
            uVar2 = uVar3;
            j2 = 0;
        } catch (RuntimeException e7) {
            e = e7;
            uVar2 = uVar3;
            j2 = 0;
        }
        uVar2.g(j5, j3);
        return i2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:73:0x01b9
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int q(java.lang.String r30, d.a.m0.r.u r31) {
        /*
            r29 = this;
            r1 = r29
            r2 = r31
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            d.a.m0.r.o r0 = r1.f52109b
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()
            r4 = 0
            r10 = r30
            android.database.Cursor r4 = r0.rawQuery(r10, r4)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            if (r4 == 0) goto L1c2
            int r0 = r4.getCount()     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            if (r0 <= 0) goto L1c2
            r4.moveToFirst()     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "flowid"
            int r11 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "flowhandle"
            int r12 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "state"
            int r13 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "begintime"
            int r14 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "endtime"
            int r15 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "content"
            int r7 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "option"
            int r8 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "reserve1"
            int r9 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "reserve2"
            int r10 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "slot"
            int r5 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            java.lang.String r0 = "extend"
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3 java.lang.RuntimeException -> L1d5 java.lang.Throwable -> L1e8
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r20 = 0
        L6a:
            java.lang.String r0 = "2"
            java.lang.String r2 = r4.getString(r13)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            boolean r0 = r0.equals(r2)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            if (r0 != 0) goto La6
            long r22 = r4.getLong(r14)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r24 = java.lang.System.currentTimeMillis()     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r22 = r22 - r24
            long r22 = java.lang.Math.abs(r22)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r24 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r0 <= 0) goto L94
            int r0 = r4.getInt(r8)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
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
            goto L199
        La6:
            d.a.m0.r.k r2 = new d.a.m0.r.k     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r2.<init>()     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            java.lang.String r0 = r4.getString(r11)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r2.f52190a = r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r0 = r4.getInt(r12)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r2.f52191b = r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r22 = r11
            r23 = r12
            long r11 = r4.getLong(r14)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r2.f52194e = r11     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r11 = r4.getLong(r15)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r2.f52195f = r11     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Ld3
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto Ld3
            r20 = r11
        Ld3:
            long r11 = r2.f52194e     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Le5
            long r11 = r2.f52194e     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r0 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r0 >= 0) goto Le5
            long r11 = r2.f52194e     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r16 = r11
        Le5:
            java.lang.String r0 = r4.getString(r7)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            java.lang.String r12 = "UTF-8"
            if (r11 != 0) goto Lff
            r2.f52192c = r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r11 = r7
            r24 = r8
            long r7 = (long) r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r1.f52108a = r7     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            goto L102
        Lff:
            r11 = r7
            r24 = r8
        L102:
            java.lang.String r0 = r4.getString(r9)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            if (r7 != 0) goto L11e
            r2.f52198i = r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r7 = r1.f52108a     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r25 = r13
            r26 = r14
            long r13 = (long) r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r7 = r7 + r13
            r1.f52108a = r7     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            goto L122
        L11e:
            r25 = r13
            r26 = r14
        L122:
            java.lang.String r0 = r4.getString(r10)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            if (r0 != 0) goto L132
            java.lang.String r0 = r4.getString(r10)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r2.j = r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
        L132:
            java.lang.String r0 = r4.getString(r5)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            if (r5 < 0) goto L14c
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            if (r7 != 0) goto L14c
            r2.b(r0)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r7 = r1.f52108a     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r13 = (long) r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r7 = r7 + r13
            r1.f52108a = r7     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
        L14c:
            java.lang.String r0 = r4.getString(r6)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            if (r7 != 0) goto L17e
            long r7 = r1.f52108a     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r12 = (long) r0     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            long r7 = r7 + r12
            r1.f52108a = r7     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L178 java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            java.lang.String r7 = r4.getString(r6)     // Catch: org.json.JSONException -> L178 java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r0.<init>(r7)     // Catch: org.json.JSONException -> L178 java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            java.lang.String r7 = "ctr"
            boolean r0 = r0.has(r7)     // Catch: org.json.JSONException -> L178 java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            if (r0 == 0) goto L17e
            r7 = 1
            r2.l = r7     // Catch: org.json.JSONException -> L176 java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            goto L17f
        L176:
            r0 = move-exception
            goto L17a
        L178:
            r0 = move-exception
            r7 = 1
        L17a:
            r0.printStackTrace()     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            goto L17f
        L17e:
            r7 = 1
        L17f:
            r3.add(r2)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r0 = r2.f52191b     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            java.lang.String r2 = r2.f52190a     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.RuntimeException -> L1b2 java.lang.Throwable -> L1b6 java.lang.Throwable -> L1d3
            r8 = r31
            r8.f(r0, r2)     // Catch: java.lang.RuntimeException -> L1b0 java.lang.Throwable -> L1bf java.lang.Throwable -> L1d3
            long r12 = r1.f52108a     // Catch: java.lang.RuntimeException -> L1b0 java.lang.Throwable -> L1bf java.lang.Throwable -> L1d3
            r27 = 2097152(0x200000, double:1.036131E-317)
            int r0 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            if (r0 < 0) goto L199
            goto L19f
        L199:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.RuntimeException -> L1b0 java.lang.Throwable -> L1bf java.lang.Throwable -> L1d3
            if (r0 != 0) goto L1a2
        L19f:
            r5 = r20
            goto L1cd
        L1a2:
            r2 = r8
            r7 = r11
            r11 = r22
            r12 = r23
            r8 = r24
            r13 = r25
            r14 = r26
            goto L6a
        L1b0:
            r0 = move-exception
            goto L1bb
        L1b2:
            r0 = move-exception
            r8 = r31
            goto L1bb
        L1b6:
            r8 = r31
            goto L1bf
        L1b9:
            r0 = move-exception
            r8 = r2
        L1bb:
            r5 = r20
            goto L1e0
        L1be:
            r8 = r2
        L1bf:
            r5 = r20
            goto L1f2
        L1c2:
            r8 = r2
            r18 = 0
            r5 = r18
            r7 = 0
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1cd:
            d.a.m0.t.d.d(r4)
            r9 = r16
            goto L1f8
        L1d3:
            r0 = move-exception
            goto L1e4
        L1d5:
            r0 = move-exception
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1e0:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1d3
            goto L1f2
        L1e4:
            d.a.m0.t.d.d(r4)
            throw r0
        L1e8:
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1f2:
            d.a.m0.t.d.d(r4)
            r9 = r16
            r7 = 0
        L1f8:
            int r0 = r3.size()
            if (r0 <= 0) goto L201
            r1.r(r3, r8)
        L201:
            r8.g(r9, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.m0.r.a.q(java.lang.String, d.a.m0.r.u):int");
    }

    public final void r(ArrayList<d.a.m0.r.k> arrayList, u uVar) {
        JSONObject jSONObject = new JSONObject();
        SQLiteDatabase readableDatabase = this.f52109b.getReadableDatabase();
        try {
            Iterator<d.a.m0.r.k> it = arrayList.iterator();
            String[] strArr = null;
            Cursor cursor = null;
            while (it.hasNext()) {
                d.a.m0.r.k next = it.next();
                if (next.f52191b >= 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bizId", next.f52190a);
                    jSONObject2.put("starttime", Long.toString(next.f52194e));
                    jSONObject2.put("endtime", Long.toString(next.f52195f));
                    jSONObject2.put("eventType", "1");
                    if (!TextUtils.isEmpty(next.f52192c)) {
                        jSONObject = new JSONObject(next.f52192c);
                    }
                    if (!TextUtils.isEmpty(next.f52198i)) {
                        jSONObject2.put("abtest", next.f52198i);
                        uVar.f52268f = "1";
                    }
                    if (!TextUtils.isEmpty(next.j)) {
                        jSONObject2.put("c", next.j);
                    }
                    if (next.k != null) {
                        jSONObject2.put("part", next.k);
                    }
                    if (next.l) {
                        jSONObject2.put("of", "1");
                    }
                    jSONObject2.put(Constant.ID_TYPE, d.a.m0.r.d.g().j(next.f52190a));
                    JSONArray jSONArray = new JSONArray();
                    try {
                        cursor = readableDatabase.rawQuery("SELECT eventid , begintime , content FROM event WHERE flowhandle = " + next.f52191b, strArr);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("eventid");
                            int columnIndex2 = cursor.getColumnIndex("begintime");
                            int columnIndex3 = cursor.getColumnIndex("content");
                            while (true) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("id", cursor.getString(columnIndex));
                                jSONObject3.put("timestamp", Long.toString(cursor.getLong(columnIndex2)));
                                jSONObject3.put("content", cursor.getString(columnIndex3));
                                jSONArray.put(jSONObject3);
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                            }
                            jSONObject.put("eventlist", jSONArray);
                        }
                    } catch (SQLiteFullException unused) {
                    } catch (Throwable th) {
                        d.a.m0.t.d.d(cursor);
                        throw th;
                    }
                    d.a.m0.t.d.d(cursor);
                    jSONObject2.put("content", jSONObject);
                    r.a(jSONObject2);
                    uVar.a(jSONObject2);
                }
                strArr = null;
            }
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } catch (JSONException unused2) {
        }
    }

    public final String s(ArrayList<d.a.m0.r.f> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        Iterator<d.a.m0.r.f> it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            d.a.m0.r.f next = it.next();
            if ((z && !"0".equals(next.f52165b)) || (!z && "0".equals(next.f52165b))) {
                sb.append(str);
                sb.append(next.f52164a);
                str = ",";
            }
        }
        return sb.toString();
    }

    public final String t(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            Object next = it.next();
            sb.append(str);
            sb.append(next);
            str = ",";
        }
        return sb.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x001f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    public d.a.m0.r.j u(String str) {
        Closeable closeable;
        String str2 = "SELECT state , reserve1 FROM file WHERE filename=\"" + str + "\"";
        Closeable closeable2 = null;
        r3 = null;
        r3 = null;
        d.a.m0.r.j jVar = null;
        try {
            try {
                str2 = this.f52109b.getReadableDatabase().rawQuery(str2, null);
                closeable = str2;
                if (str2 != 0) {
                    try {
                        int count = str2.getCount();
                        closeable = str2;
                        if (count > 0) {
                            str2.moveToFirst();
                            jVar = new d.a.m0.r.j(str, str2.getString(str2.getColumnIndex("state")), str2.isNull(str2.getColumnIndex("reserve1")) ? "" : str2.getString(str2.getColumnIndex("reserve1")));
                            closeable = str2;
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
                        d.a.m0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                        closeable = str2;
                        d.a.m0.t.d.d(closeable);
                        return jVar;
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = str2;
                d.a.m0.t.d.d(closeable2);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            str2 = 0;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.t.d.d(closeable2);
            throw th;
        }
        d.a.m0.t.d.d(closeable);
        return jVar;
    }

    public void v(SparseArray<ArrayList> sparseArray) {
        Cursor cursor = null;
        try {
            try {
                cursor = this.f52109b.getReadableDatabase().rawQuery("SELECT eventid , type , cycle FROM config WHERE switch=\"1\"", null);
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
                            arrayList.add(new d.a.m0.r.f(string, string2));
                        }
                    } while (cursor.moveToNext());
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        } finally {
            d.a.m0.t.d.d(cursor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0093 A[Catch: all -> 0x0101, RuntimeException -> 0x0103, SQLiteFullException -> 0x010c, TryCatch #5 {SQLiteFullException -> 0x010c, RuntimeException -> 0x0103, blocks: (B:6:0x000d, B:8:0x0013, B:10:0x0019, B:11:0x001c, B:15:0x0081, B:21:0x0093, B:23:0x009b, B:25:0x00a1, B:28:0x00ab, B:30:0x00b7, B:32:0x00bd, B:36:0x00c9, B:38:0x00d6, B:40:0x00dc, B:43:0x00eb, B:51:0x00fa, B:49:0x00f4, B:17:0x0086, B:19:0x008d), top: B:66:0x000d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1 A[Catch: all -> 0x0101, RuntimeException -> 0x0103, SQLiteFullException -> 0x010c, TryCatch #5 {SQLiteFullException -> 0x010c, RuntimeException -> 0x0103, blocks: (B:6:0x000d, B:8:0x0013, B:10:0x0019, B:11:0x001c, B:15:0x0081, B:21:0x0093, B:23:0x009b, B:25:0x00a1, B:28:0x00ab, B:30:0x00b7, B:32:0x00bd, B:36:0x00c9, B:38:0x00d6, B:40:0x00dc, B:43:0x00eb, B:51:0x00fa, B:49:0x00f4, B:17:0x0086, B:19:0x008d), top: B:66:0x000d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab A[Catch: all -> 0x0101, RuntimeException -> 0x0103, SQLiteFullException -> 0x010c, TryCatch #5 {SQLiteFullException -> 0x010c, RuntimeException -> 0x0103, blocks: (B:6:0x000d, B:8:0x0013, B:10:0x0019, B:11:0x001c, B:15:0x0081, B:21:0x0093, B:23:0x009b, B:25:0x00a1, B:28:0x00ab, B:30:0x00b7, B:32:0x00bd, B:36:0x00c9, B:38:0x00d6, B:40:0x00dc, B:43:0x00eb, B:51:0x00fa, B:49:0x00f4, B:17:0x0086, B:19:0x008d), top: B:66:0x000d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd A[Catch: all -> 0x0101, RuntimeException -> 0x0103, SQLiteFullException -> 0x010c, TryCatch #5 {SQLiteFullException -> 0x010c, RuntimeException -> 0x0103, blocks: (B:6:0x000d, B:8:0x0013, B:10:0x0019, B:11:0x001c, B:15:0x0081, B:21:0x0093, B:23:0x009b, B:25:0x00a1, B:28:0x00ab, B:30:0x00b7, B:32:0x00bd, B:36:0x00c9, B:38:0x00d6, B:40:0x00dc, B:43:0x00eb, B:51:0x00fa, B:49:0x00f4, B:17:0x0086, B:19:0x008d), top: B:66:0x000d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, d.a.m0.r.h> hashMap3, HashSet<String> hashSet5) {
        SQLiteDatabase readableDatabase = this.f52109b.getReadableDatabase();
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
                                hashMap3.put(string, new d.a.m0.r.h(string, i5, i4));
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
                d.a.m0.t.d.d(cursor);
            }
        } catch (SQLiteFullException unused) {
        } catch (RuntimeException e4) {
            e4.printStackTrace();
        }
    }

    public void y(d.a.m0.r.i iVar) {
        if (iVar == null || TextUtils.isEmpty(iVar.f52180a)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(iVar.f52182c));
        contentValues.put("eventid", iVar.f52180a);
        contentValues.put("begintime", Long.valueOf(iVar.f52185f));
        JSONObject jSONObject = iVar.f52184e;
        if (jSONObject != null) {
            contentValues.put("content", jSONObject.toString());
        } else {
            contentValues.put("content", iVar.f52183d);
        }
        contentValues.put("reserve1", iVar.f52187h);
        if (!TextUtils.isEmpty(iVar.f52188i)) {
            contentValues.put("reserve2", iVar.f52188i);
        }
        if (iVar.j) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ctr", "1");
                contentValues.put("extend", jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        new h(iVar.f52181b, iVar.f52180a, iVar.f52182c, contentValues).c(this.f52109b.getWritableDatabase());
    }

    public void z(List<d.a.m0.r.i> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new i(list).c(this.f52109b.getWritableDatabase());
    }

    /* loaded from: classes3.dex */
    public abstract class q {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52140a;

        public q() {
            this.f52140a = false;
        }

        public boolean a() {
            return this.f52140a;
        }

        public abstract boolean b(SQLiteDatabase sQLiteDatabase);

        public void c(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase == null) {
                return;
            }
            this.f52140a = false;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    if (b(sQLiteDatabase)) {
                        sQLiteDatabase.setTransactionSuccessful();
                        this.f52140a = true;
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
                    jSONObject.put("db_size", a.this.o());
                    jSONObject.put("db_log_size", a.this.n());
                    jSONObject.put("exception", Log.getStackTraceString(e2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                d.a.m0.r.e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
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
