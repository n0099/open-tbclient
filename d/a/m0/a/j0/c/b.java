package d.a.m0.a.j0.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.facebook.common.internal.Sets;
import com.xiaomi.mipush.sdk.Constants;
import d.a.m0.a.c2.f.h0.a;
import d.a.m0.a.k;
import d.a.m0.a.k2.g.h;
import d.a.m0.a.n0.l.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a.n0.l.b {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public static AtomicLong f46839g;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46837e = k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f46838f = Sets.newHashSet();

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f46840h = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};

    /* loaded from: classes3.dex */
    public static class a implements h.n.b<Cursor> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f46841e;

        public a(a.c cVar) {
            this.f46841e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Cursor cursor) {
            if (cursor == null || !cursor.moveToFirst()) {
                if (b.f46837e) {
                    Log.d("SwanAppHistoryHelper", "historyList == null || historyList.size() == 0");
                }
                d.a.m0.a.i1.e.a.a(cursor);
                this.f46841e.a(null);
                return;
            }
            this.f46841e.a(b.j(cursor));
        }
    }

    /* renamed from: d.a.m0.a.j0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0780b implements h.n.f<String, Cursor> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Cursor call(String str) {
            return b.l();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public d.a.m0.a.j0.a f46842b;

        public c() {
            super(null);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Comparator<d> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return Long.compare(dVar2.f46843a.f49299e, dVar.f46843a.f49299e);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f46844b;

        public f() {
            super(null);
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable d.a.m0.a.w0.b bVar, b.C0822b c0822b) {
        if (bVar == null || TextUtils.isEmpty(bVar.f49295a)) {
            return false;
        }
        if (f46837e) {
            Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.f49297c + " / " + bVar.f49295a);
        }
        if (k(bVar.f49295a)) {
            if (f46837e) {
                Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
            }
            return false;
        }
        if (TextUtils.equals(String.valueOf(1), bVar.f49301g)) {
            String str = bVar.f49295a;
            d.a.m0.a.n0.l.c m = d.a.m0.a.n0.l.c.m(c0822b);
            m.i(1);
            g(contentResolver, str, m.k());
        }
        Uri a2 = d.a.m0.a.j0.c.a.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, bVar.f49295a);
        contentValues.put("visit_time", Long.valueOf(bVar.f49299e));
        contentValues.put("app_from", bVar.f49303i);
        contentValues.put("app_name", bVar.f49297c);
        contentValues.put("app_key", bVar.f49296b);
        contentValues.put("version_code", bVar.j);
        contentValues.put("app_icon", bVar.f49298d);
        contentValues.put("frame_type", Integer.valueOf(bVar.f49300f));
        contentValues.put("app_type", bVar.f49301g);
        contentValues.put("pay_protected", Integer.valueOf(bVar.f49302h));
        contentValues.put("sync_state", (Integer) 0);
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a2, contentValues);
            if (f46837e) {
                String uri = insert == null ? "NULL" : insert.toString();
                Log.d("SwanAppHistoryHelper", "Add history: newUri - " + uri);
            }
            if (e()) {
                String str2 = bVar.f49295a;
                d.a.m0.a.n0.l.c m2 = d.a.m0.a.n0.l.c.m(c0822b);
                m2.i(2);
                r(contentResolver, str2, m2.k());
            }
            return insert != null;
        } catch (Exception e2) {
            d.a.m0.a.h0.a.f(a2.toString(), bVar.f49295a, e2.toString());
            if (f46837e) {
                Log.e("SwanAppHistoryHelper", "encounter error while adding swan history" + e2.toString());
                throw new RuntimeException("encounter error while adding swan history, only throw in debug mode", e2);
            }
            return false;
        }
    }

    public static void d(MatrixCursor matrixCursor, int i2, d dVar) {
        if (dVar instanceof c) {
            c cVar = (c) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), cVar.f46842b.f46813a).add(SwanAppDbControl.SwanAppTable.app_key.name(), cVar.f46842b.f46814b).add(SwanAppDbControl.SwanAppTable.version.name(), cVar.f46842b.q).add(SwanAppDbControl.SwanAppTable.description.name(), cVar.f46842b.f46815c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(cVar.f46842b.f46816d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), cVar.f46842b.f46817e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), cVar.f46842b.f46818f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), cVar.f46842b.f46819g).add(SwanAppDbControl.SwanAppTable.icon.name(), cVar.f46842b.f46820h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), cVar.f46842b.f46821i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), cVar.f46842b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), cVar.f46842b.k).add(SwanAppDbControl.SwanAppTable.name.name(), cVar.f46842b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), cVar.f46842b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), cVar.f46842b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), cVar.f46842b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), cVar.f46842b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(cVar.f46842b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(cVar.f46842b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), cVar.f46842b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), cVar.f46842b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), cVar.f46842b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(cVar.f46842b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(cVar.f46842b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), cVar.f46842b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(cVar.f46842b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(cVar.f46842b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(cVar.f46842b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(cVar.f46842b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(cVar.f46842b.D ? 1 : 0)).add("app_from", cVar.f46843a.f49303i).add("visit_time", Long.valueOf(cVar.f46843a.f49299e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(cVar.f46842b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), cVar.f46842b.F);
            return;
        }
        f fVar = (f) dVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.f46843a.f49295a).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.f46844b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(fVar.f46844b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.f46844b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.f46844b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.f46844b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.f46844b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.f46844b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.f46843a.f49298d).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.f46843a.f49297c).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.f46844b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.f46844b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.f46844b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.f46844b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.f46844b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.f46844b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.f46844b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.f46844b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.f46844b.i())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.f46844b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.f46844b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", fVar.f46843a.f49303i).add("visit_time", Long.valueOf(fVar.f46843a.f49299e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(fVar.f46844b.payProtected)).add("customer_service", Integer.valueOf(fVar.f46844b.customerService)).add("global_notice", Integer.valueOf(fVar.f46844b.globalNotice)).add("global_private", Integer.valueOf(fVar.f46844b.globalPrivate)).add("pa_number", fVar.f46844b.paNumber).add("brand", fVar.f46844b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), fVar.f46844b.quickAppKey);
    }

    public static boolean e() {
        if (f46839g != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f46839g.get() > 86400000) {
                f46839g.set(currentTimeMillis);
                h.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                return true;
            }
            return false;
        }
        synchronized (h.class) {
            if (f46839g == null) {
                f46839g = new AtomicLong(h.a().getLong("key_check_delete_swan_history", 0L));
                return e();
            }
            return false;
        }
    }

    public static boolean f(ContentResolver contentResolver, String str, boolean z, b.C0822b c0822b) {
        String str2;
        String str3;
        d.a.m0.a.n0.d d2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor query = contentResolver.query(d.a.m0.a.j0.c.a.a(), null, "app_id=?", new String[]{str}, null);
        String str4 = "";
        if (query == null || !query.moveToFirst()) {
            str2 = "";
            str3 = str2;
        } else {
            int columnIndex = query.getColumnIndex("app_key");
            int columnIndex2 = query.getColumnIndex("version_code");
            int columnIndex3 = query.getColumnIndex("app_type");
            str4 = query.getString(columnIndex);
            String string = query.getString(columnIndex2);
            String string2 = query.getString(columnIndex3);
            str3 = string;
            str2 = string2;
        }
        d.a.m0.t.d.d(query);
        boolean z2 = contentResolver.delete(d.a.m0.a.j0.c.a.a(), "app_id=?", new String[]{str}) > 0;
        if (z && z2 && (d2 = d.a.m0.a.n0.f.c().d()) != null) {
            d.a.m0.a.n0.l.c m = d.a.m0.a.n0.l.c.m(c0822b);
            m.i(4);
            d2.e(str, true, m.k());
        }
        if (f46837e) {
            Log.d("SwanAppHistoryHelper", "deleteHistory: " + str + " isSuccess: " + z2);
        }
        if (z2) {
            d.a.m0.a.w0.c.e("DEL", str, System.currentTimeMillis(), str4, str2, str3, null);
        }
        return z2;
    }

    public static void g(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0822b c0822b) {
        if (f46837e) {
            Log.d("SwanAppHistoryHelper", "start deleteOtherDevHistory: ");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = d.a.m0.a.v.a.a(str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        List<String> q = q(contentResolver, str);
        if (q != null && q.size() != 0) {
            d.a.m0.a.n0.d d2 = d.a.m0.a.n0.f.c().d();
            if (d2 != null) {
                if (f46837e) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                }
                d2.g(q, false, false, c0822b);
            }
            if (f46837e) {
                Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
            }
            contentResolver.delete(d.a.m0.a.j0.c.a.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
        } else if (f46837e) {
            Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
        }
    }

    @NonNull
    public static Set<String> h(@NonNull ContentResolver contentResolver) {
        StringBuilder sb;
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(d.a.m0.a.j0.c.a.a(), null, null, null, null);
            } catch (Exception e2) {
                if (f46837e) {
                    e2.printStackTrace();
                }
                if (f46837e && cursor != null) {
                    sb = new StringBuilder();
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    hashSet.add(cursor.getString(cursor.getColumnIndex(Constants.APP_ID)));
                } while (cursor.moveToNext());
                if (f46837e) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                d.a.m0.t.d.d(cursor);
                return hashSet;
            }
            if (f46837e && cursor != null) {
                sb = new StringBuilder();
                sb.append("getAllHistoryIdsSet: Cursor count: ");
                sb.append(cursor.getCount());
                Log.d("SwanAppHistoryHelper", sb.toString());
            }
            d.a.m0.t.d.d(cursor);
            return hashSet;
        } catch (Throwable th) {
            if (f46837e && cursor != null) {
                Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
            }
            d.a.m0.t.d.d(cursor);
            throw th;
        }
    }

    public static void i(a.c cVar) {
        if (cVar == null) {
            return;
        }
        h.d.i("").D(Schedulers.io()).k(new C0780b()).o(h.l.b.a.b()).B(new a(cVar));
    }

    @NonNull
    public static JSONObject j(Cursor cursor) {
        String str;
        JSONArray jSONArray = new JSONArray();
        do {
            JSONObject jSONObject = new JSONObject();
            try {
                String string = cursor.getString(cursor.getColumnIndex(Constants.APP_ID));
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("appid", string);
                }
                int i2 = cursor.getInt(cursor.getColumnIndex("frame_type"));
                jSONObject.put("frameType", i2);
                int i3 = cursor.getInt(cursor.getColumnIndex("app_type"));
                String str2 = "1";
                if (i3 != 0) {
                    if (i3 == 1) {
                        str2 = "0";
                    } else if (i3 == 2) {
                        str2 = "2";
                    } else if (i3 == 3) {
                        str2 = "3";
                    }
                }
                jSONObject.put("type", str2);
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                if (i2 == 1) {
                    str = String.format(d.a.m0.a.c2.f.h0.a.f44827d, string);
                } else {
                    str = d.a.m0.a.c2.f.h0.a.f44826c + string + "\"}";
                }
                jSONObject.put("scheme", str);
                String string2 = cursor.getString(cursor.getColumnIndex("visit_time"));
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("dataStamp", string2);
                    jSONObject.put("dateStamp", string2);
                }
                String string3 = cursor.getString(cursor.getColumnIndex("app_icon"));
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("iconUrl", string3);
                }
                jSONObject.put("payProtected", cursor.getInt(cursor.getColumnIndex("pay_protected")));
                String string4 = cursor.getString(cursor.getColumnIndex("app_name"));
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("title", string4);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        } while (cursor.moveToNext());
        d.a.m0.a.i1.e.a.a(cursor);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("history", jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        if (f46837e) {
            Log.d("SwanAppHistoryHelper", "historyCursorToJson : " + jSONObject2.toString());
        }
        return jSONObject2;
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return f46838f.contains(str);
    }

    public static Cursor l() {
        return m(null, null);
    }

    public static Cursor m(String str, String[] strArr) {
        return AppRuntime.getAppContext().getContentResolver().query(d.a.m0.a.j0.c.a.a(), null, str, strArr, "visit_time desc  LIMIT 200");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0202 A[LOOP:3: B:48:0x01fc->B:50:0x0202, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02aa A[LOOP:5: B:65:0x02a4->B:67:0x02aa, LOOP_END] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor n(@NonNull String str, int i2) {
        Cursor query;
        List<d> arrayList;
        HashMap hashMap = new HashMap();
        Cursor o = o(AppRuntime.getAppContext().getContentResolver(), str);
        if (o != null && o.moveToFirst()) {
            do {
                d.a.m0.a.j0.a aVar = new d.a.m0.a.j0.a();
                SwanAppDbControl.f(AppRuntime.getAppContext()).s(o, aVar);
                if (!TextUtils.isEmpty(aVar.f46813a)) {
                    c cVar = new c(null);
                    cVar.f46842b = aVar;
                    d.a.m0.a.w0.b bVar = cVar.f46843a;
                    bVar.f49295a = aVar.f46813a;
                    bVar.f49295a = o.getString(o.getColumnIndex("app_from"));
                    cVar.f46843a.f49299e = o.getLong(o.getColumnIndex("visit_time"));
                    hashMap.put(cVar.f46843a.f49295a, cVar);
                    if (f46837e) {
                        Log.v("history_migrate_pms", "Aps&History == " + aVar.f46813a);
                    }
                }
            } while (o.moveToNext());
            d.a.m0.t.d.d(o);
            if (f46837e) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(d.a.m0.a.j0.c.a.a(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            d.a.m0.t.d.d(query);
            if (f46837e) {
            }
            ArrayList<d> arrayList2 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f46837e) {
            }
            while (r13.hasNext()) {
            }
            if (f46837e) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new e(null));
            int i3 = 0;
            if (i2 > 0) {
            }
            MatrixCursor matrixCursor = new MatrixCursor(f46840h, 50);
            while (r13.hasNext()) {
            }
            return matrixCursor;
        }
        d.a.m0.t.d.d(o);
        if (f46837e) {
            Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(d.a.m0.a.j0.c.a.a(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                d.a.m0.a.w0.b bVar2 = new d.a.m0.a.w0.b();
                bVar2.f49295a = query.getString(query.getColumnIndex(Constants.APP_ID));
                bVar2.f49303i = query.getString(query.getColumnIndex("app_from"));
                bVar2.f49299e = query.getLong(query.getColumnIndex("visit_time"));
                bVar2.f49297c = query.getString(query.getColumnIndex("app_name"));
                bVar2.f49296b = query.getString(query.getColumnIndex("app_key"));
                bVar2.j = query.getString(query.getColumnIndex("version_code"));
                bVar2.f49298d = query.getString(query.getColumnIndex("app_icon"));
                bVar2.f49300f = query.getInt(query.getColumnIndex("frame_type"));
                hashMap22.put(bVar2.f49295a, bVar2);
                if (f46837e) {
                    Log.v("history_migrate_pms", "History == " + bVar2.f49295a);
                }
            } while (query.moveToNext());
            d.a.m0.t.d.d(query);
            if (f46837e) {
            }
            ArrayList<d> arrayList22 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f46837e) {
            }
            while (r13.hasNext()) {
            }
            if (f46837e) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new e(null));
            int i32 = 0;
            if (i2 > 0) {
                arrayList = arrayList.subList(0, i2);
                if (f46837e) {
                }
            }
            MatrixCursor matrixCursor2 = new MatrixCursor(f46840h, 50);
            while (r13.hasNext()) {
            }
            return matrixCursor2;
        }
        d.a.m0.t.d.d(query);
        if (f46837e) {
            Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
        }
        ArrayList<d> arrayList222 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(d.a.m0.n.g.a.h().t().values())) {
            if (f46837e) {
                Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            String str2 = pMSAppInfo.appName;
            if (str2 != null && str2.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                f fVar = new f(null);
                fVar.f46843a = (d.a.m0.a.w0.b) hashMap22.get(pMSAppInfo.appId);
                fVar.f46844b = pMSAppInfo;
                arrayList222.add(fVar);
            }
        }
        if (f46837e) {
            Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
        }
        for (d dVar : arrayList222) {
            hashMap.put(dVar.f46843a.f49295a, dVar);
        }
        if (f46837e) {
            Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("history_migrate_pms", "Migrate == " + ((d) it.next()).f46843a.f49295a);
            }
        }
        arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, new e(null));
        int i322 = 0;
        if (i2 > 0 && i2 < arrayList.size()) {
            arrayList = arrayList.subList(0, i2);
            if (f46837e) {
                Log.d("history_migrate_pms", "Limit限制 " + i2 + " 条");
            }
        }
        MatrixCursor matrixCursor22 = new MatrixCursor(f46840h, 50);
        for (d dVar2 : arrayList) {
            d(matrixCursor22, i322, dVar2);
            i322++;
        }
        return matrixCursor22;
    }

    @Nullable
    public static Cursor o(@NonNull ContentResolver contentResolver, @NonNull String str) {
        Cursor cursor;
        try {
            cursor = contentResolver.query(d.a.m0.a.j0.c.a.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 200");
        } catch (Exception e2) {
            if (f46837e) {
                e2.printStackTrace();
            }
            cursor = null;
        }
        if (f46837e && cursor != null) {
            Log.d("SwanAppHistoryHelper", "queryHistoryByKeyword: keyword[" + str + "]  Cursor count: " + cursor.getCount());
        }
        return cursor;
    }

    public static Set<String> p(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb;
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query("ai_apps_history", null, null, null, null, null, null);
            } catch (Exception e2) {
                if (f46837e) {
                    e2.printStackTrace();
                }
                if (f46837e && cursor != null) {
                    sb = new StringBuilder();
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    hashSet.add(cursor.getString(cursor.getColumnIndex(Constants.APP_ID)));
                } while (cursor.moveToNext());
                if (f46837e) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                d.a.m0.a.i1.e.a.a(cursor);
                return hashSet;
            }
            if (f46837e && cursor != null) {
                sb = new StringBuilder();
                sb.append("getAllHistoryIdsSet: Cursor count: ");
                sb.append(cursor.getCount());
                Log.d("SwanAppHistoryHelper", sb.toString());
            }
            d.a.m0.a.i1.e.a.a(cursor);
            return hashSet;
        } catch (Throwable th) {
            if (f46837e && cursor != null) {
                Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
            }
            d.a.m0.a.i1.e.a.a(cursor);
            throw th;
        }
    }

    @Nullable
    public static List<String> q(@NonNull ContentResolver contentResolver, @Nullable String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String a2 = d.a.m0.a.v.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                d.a.m0.t.d.d(null);
                return null;
            }
            cursor = contentResolver.query(d.a.m0.a.j0.c.a.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 200");
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                String string = cursor.getString(cursor.getColumnIndex(Constants.APP_ID));
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } while (cursor.moveToNext());
                            d.a.m0.t.d.d(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f46837e) {
                            e.printStackTrace();
                        }
                        d.a.m0.t.d.d(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.a.m0.t.d.d(cursor2);
                    throw th;
                }
            }
            d.a.m0.t.d.d(cursor);
            return null;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.t.d.d(cursor2);
            throw th;
        }
    }

    @WorkerThread
    public static void r(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0822b c0822b) {
        int i2;
        Cursor query;
        Cursor cursor = null;
        try {
            if (str == null) {
                str = "";
            }
            try {
                query = contentResolver.query(d.a.m0.a.j0.c.a.a(), null, "app_id != ?", new String[]{str, String.valueOf(200)}, "visit_time DESC limit ?,-1");
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(Constants.APP_ID));
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
            }
            if (f46837e) {
                Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str);
            }
            if (arrayList.isEmpty()) {
                d.a.m0.t.d.d(query);
                return;
            }
            d.a.m0.a.n0.d d2 = d.a.m0.a.n0.f.c().d();
            if (d2 != null) {
                d2.f(arrayList, false, c0822b);
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (i2 = 0; i2 < size; i2++) {
                sb.append('\'');
                sb.append((String) arrayList.get(i2));
                sb.append('\'');
                if (i2 < size - 1) {
                    sb.append(",");
                }
            }
            String str2 = "app_id in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
            int delete = contentResolver.delete(d.a.m0.a.j0.c.a.a(), str2, null);
            if (f46837e) {
                Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
            }
            d.a.m0.t.d.d(query);
        } catch (Exception e3) {
            e = e3;
            cursor = query;
            if (f46837e) {
                Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
            }
            d.a.m0.t.d.d(cursor);
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            d.a.m0.t.d.d(cursor);
            throw th;
        }
    }

    public static void s(ContentResolver contentResolver, String str, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_state", Integer.valueOf(i2));
        contentResolver.update(d.a.m0.a.j0.c.a.a(), contentValues, "app_id=?", new String[]{str});
    }

    public static void t(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            for (String str : p(sQLiteDatabase)) {
                PMSAppInfo s = d.a.m0.n.g.a.h().s(str);
                if (s != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_name", s.appName);
                    contentValues.put("app_icon", s.iconUrl);
                    contentValues.put("frame_type", Integer.valueOf(s.appCategory));
                    contentValues.put("app_type", String.valueOf(s.type));
                    contentValues.put("sync_state", (Integer) 0);
                    if (sQLiteDatabase.updateWithOnConflict("ai_apps_history", contentValues, "app_id=?", new String[]{str}, 5) <= 0) {
                        if (f46837e) {
                            Log.e("SwanAppHistoryHelper", "updatePMSDataToHistoryTable: 更新失败");
                        }
                        return;
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.a.w0.b f46843a;

        public d() {
            this.f46843a = new d.a.m0.a.w0.b();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
