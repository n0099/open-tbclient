package d.b.h0.a.g0.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
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
import d.b.h0.a.i2.p;
import d.b.h0.a.j0.j.b;
import d.b.h0.a.k;
import d.b.h0.a.t1.k.h0.a;
import d.b.h0.a.y0.e.b;
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
/* loaded from: classes2.dex */
public class b implements d.b.h0.a.j0.j.b {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public static AtomicLong f45221g;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45219e = k.f45772a;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f45220f = Sets.newHashSet();

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f45222h = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.g0.b f45223e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0740b f45224f;

        public a(d.b.h0.a.g0.b bVar, b.C0740b c0740b) {
            this.f45223e = bVar;
            this.f45224f = c0740b;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean c2 = b.c(AppRuntime.getAppContext().getContentResolver(), this.f45223e, this.f45224f);
            if (!b.f45219e || c2) {
                return;
            }
            Log.e("SwanAppHistoryHelper", "addHistoryAsync Failed!");
        }
    }

    /* renamed from: d.b.h0.a.g0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0725b implements h.n.b<Cursor> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f45225e;

        public C0725b(a.c cVar) {
            this.f45225e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Cursor cursor) {
            if (cursor == null || !cursor.moveToFirst()) {
                if (b.f45219e) {
                    Log.d("SwanAppHistoryHelper", "historyList == null || historyList.size() == 0");
                }
                d.b.h0.a.b1.e.a.a(cursor);
                this.f45225e.a(null);
                return;
            }
            this.f45225e.a(b.k(cursor));
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements h.n.f<String, Cursor> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Cursor call(String str) {
            return b.m(str, 400);
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends f {

        /* renamed from: b  reason: collision with root package name */
        public d.b.h0.a.g0.a f45226b;

        public d() {
            super(null);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f45227a;

        /* renamed from: b  reason: collision with root package name */
        public String f45228b;

        /* renamed from: c  reason: collision with root package name */
        public long f45229c;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements Comparator<f> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return Long.compare(fVar2.f45230a.f45229c, fVar.f45230a.f45229c);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class h extends f {

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f45231b;

        public h() {
            super(null);
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable d.b.h0.a.g0.b bVar, b.C0740b c0740b) {
        if (bVar == null || TextUtils.isEmpty(bVar.a())) {
            return false;
        }
        if (f45219e) {
            Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.c() + " / " + bVar.a());
        }
        if (l(bVar.a())) {
            if (f45219e) {
                Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
            }
            return false;
        }
        if (TextUtils.equals("0", bVar.f45203d)) {
            String a2 = bVar.a();
            d.b.h0.a.j0.j.c l = d.b.h0.a.j0.j.c.l(c0740b);
            l.h(1);
            h(contentResolver, a2, l.j());
        }
        Uri a3 = d.b.h0.a.g0.d.a.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, bVar.a());
        contentValues.put("visit_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_from", bVar.b());
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a3, contentValues);
            if (f45219e) {
                String uri = insert == null ? "NULL" : insert.toString();
                Log.d("SwanAppHistoryHelper", "Add history: newUri - " + uri);
            }
            if (f()) {
                String a4 = bVar.a();
                d.b.h0.a.j0.j.c l2 = d.b.h0.a.j0.j.c.l(c0740b);
                l2.h(2);
                p(contentResolver, a4, l2.j());
            }
            return insert != null;
        } catch (Exception e2) {
            d.b.h0.a.e0.e.f(a3.toString(), bVar.a(), e2.toString());
            if (f45219e) {
                Log.e("SwanAppHistoryHelper", "encounter error while adding swan history" + e2.toString());
                throw new RuntimeException("encounter error while adding swan history, only throw in debug mode", e2);
            }
            return false;
        }
    }

    public static void d(d.b.h0.a.r1.e eVar, b.C0740b c0740b) {
        b.a L;
        if (eVar == null || (L = eVar.L()) == null || TextUtils.equals("1", L.Z())) {
            return;
        }
        String G = L.G();
        if (TextUtils.equals("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u", G) || TextUtils.equals("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D", G) || TextUtils.equals("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", G)) {
            return;
        }
        if (f45219e) {
            Log.d("SwanAppHistoryHelper", "addHistoryAsync: " + L.J() + " / " + G);
        }
        d.b.h0.a.g0.b bVar = new d.b.h0.a.g0.b(G);
        bVar.e(G);
        bVar.f(L.P());
        bVar.h(L.J());
        bVar.g(L.S());
        bVar.d(L.F());
        int m1 = L.m1();
        if (m1 == 0) {
            bVar.i("1");
        } else if (m1 == 1) {
            bVar.i("0");
        } else if (m1 == 2) {
            bVar.i("2");
        } else if (m1 == 3) {
            bVar.i("3");
        }
        p.k(new a(bVar, c0740b), "saveSwanAppInHistoryAsync");
    }

    public static void e(MatrixCursor matrixCursor, int i, f fVar) {
        if (fVar instanceof d) {
            d dVar = (d) fVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), dVar.f45226b.f45192a).add(SwanAppDbControl.SwanAppTable.app_key.name(), dVar.f45226b.f45193b).add(SwanAppDbControl.SwanAppTable.version.name(), dVar.f45226b.q).add(SwanAppDbControl.SwanAppTable.description.name(), dVar.f45226b.f45194c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(dVar.f45226b.f45195d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), dVar.f45226b.f45196e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), dVar.f45226b.f45197f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), dVar.f45226b.f45198g).add(SwanAppDbControl.SwanAppTable.icon.name(), dVar.f45226b.f45199h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), dVar.f45226b.i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), dVar.f45226b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), dVar.f45226b.k).add(SwanAppDbControl.SwanAppTable.name.name(), dVar.f45226b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), dVar.f45226b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), dVar.f45226b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), dVar.f45226b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), dVar.f45226b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(dVar.f45226b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(dVar.f45226b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), dVar.f45226b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), dVar.f45226b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), dVar.f45226b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(dVar.f45226b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(dVar.f45226b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), dVar.f45226b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(dVar.f45226b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(dVar.f45226b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(dVar.f45226b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(dVar.f45226b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(dVar.f45226b.D ? 1 : 0)).add("app_from", dVar.f45230a.f45228b).add("visit_time", Long.valueOf(dVar.f45230a.f45229c)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(dVar.f45226b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), dVar.f45226b.F);
            return;
        }
        h hVar = (h) fVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), hVar.f45231b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), hVar.f45231b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(hVar.f45231b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), hVar.f45231b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(hVar.f45231b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), hVar.f45231b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), hVar.f45231b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), hVar.f45231b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), hVar.f45231b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), hVar.f45231b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), hVar.f45231b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), hVar.f45231b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), hVar.f45231b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(hVar.f45231b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(hVar.f45231b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(hVar.f45231b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), hVar.f45231b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(hVar.f45231b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(hVar.f45231b.i())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(hVar.f45231b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(hVar.f45231b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", hVar.f45230a.f45228b).add("visit_time", Long.valueOf(hVar.f45230a.f45229c)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(hVar.f45231b.payProtected)).add("customer_service", Integer.valueOf(hVar.f45231b.customerService)).add("global_notice", Integer.valueOf(hVar.f45231b.globalNotice)).add("global_private", Integer.valueOf(hVar.f45231b.globalPrivate)).add("pa_number", hVar.f45231b.paNumber).add("brand", hVar.f45231b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), hVar.f45231b.quickAppKey);
    }

    public static boolean f() {
        if (f45221g != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f45221g.get() > 86400000) {
                f45221g.set(currentTimeMillis);
                d.b.h0.a.a2.g.h.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                return true;
            }
            return false;
        }
        synchronized (d.b.h0.a.a2.g.h.class) {
            if (f45221g == null) {
                f45221g = new AtomicLong(d.b.h0.a.a2.g.h.a().getLong("key_check_delete_swan_history", 0L));
                return f();
            }
            return false;
        }
    }

    public static boolean g(ContentResolver contentResolver, String str, boolean z, b.C0740b c0740b) {
        d.b.h0.a.j0.c d2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z2 = contentResolver.delete(d.b.h0.a.g0.d.a.a(), "app_id=?", new String[]{str}) > 0;
        if (z && z2 && (d2 = d.b.h0.a.j0.e.c().d()) != null) {
            d.b.h0.a.j0.j.c l = d.b.h0.a.j0.j.c.l(c0740b);
            l.h(4);
            d2.e(str, true, l.j());
        }
        if (f45219e) {
            Log.d("SwanAppHistoryHelper", "deleteHistory: " + str + " isSuccess: " + z2);
        }
        return z2;
    }

    public static void h(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0740b c0740b) {
        if (f45219e) {
            Log.d("SwanAppHistoryHelper", "start deleteOtherDevHistory: ");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = d.b.h0.a.u.a.a(str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        List<String> o = o(contentResolver, str);
        if (o != null && o.size() != 0) {
            d.b.h0.a.j0.c d2 = d.b.h0.a.j0.e.c().d();
            if (d2 != null) {
                if (f45219e) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                }
                d2.g(o, false, false, c0740b);
            }
            if (f45219e) {
                Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
            }
            contentResolver.delete(d.b.h0.a.g0.d.a.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
        } else if (f45219e) {
            Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
        }
    }

    @NonNull
    public static Set<String> i(@NonNull ContentResolver contentResolver) {
        StringBuilder sb;
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(d.b.h0.a.g0.d.a.a(), null, null, null, null);
            } catch (Exception e2) {
                if (f45219e) {
                    e2.printStackTrace();
                }
                if (f45219e && cursor != null) {
                    sb = new StringBuilder();
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    hashSet.add(cursor.getString(cursor.getColumnIndex(Constants.APP_ID)));
                } while (cursor.moveToNext());
                if (f45219e) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                d.b.h0.p.d.a(cursor);
                return hashSet;
            }
            if (f45219e && cursor != null) {
                sb = new StringBuilder();
                sb.append("getAllHistoryIdsSet: Cursor count: ");
                sb.append(cursor.getCount());
                Log.d("SwanAppHistoryHelper", sb.toString());
            }
            d.b.h0.p.d.a(cursor);
            return hashSet;
        } catch (Throwable th) {
            if (f45219e && cursor != null) {
                Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
            }
            d.b.h0.p.d.a(cursor);
            throw th;
        }
    }

    public static void j(a.c cVar) {
        if (cVar == null) {
            return;
        }
        h.d.j("").F(Schedulers.io()).l(new c()).p(h.l.b.a.b()).D(new C0725b(cVar));
    }

    @NonNull
    public static JSONObject k(Cursor cursor) {
        String str;
        JSONArray jSONArray = new JSONArray();
        do {
            JSONObject jSONObject = new JSONObject();
            try {
                String string = cursor.getString(cursor.getColumnIndex(Constants.APP_ID));
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("appid", string);
                }
                int i = cursor.getInt(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.app_category.name()));
                jSONObject.put("frameType", i);
                int i2 = cursor.getInt(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.type.name()));
                String str2 = "1";
                if (i2 != 0) {
                    if (i2 == 1) {
                        str2 = "0";
                    } else if (i2 == 2) {
                        str2 = "2";
                    } else if (i2 == 3) {
                        str2 = "3";
                    }
                }
                jSONObject.put("type", str2);
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                if (i == 1) {
                    str = String.format(d.b.h0.a.t1.k.h0.a.f47095d, string);
                } else {
                    str = d.b.h0.a.t1.k.h0.a.f47094c + string + "\"}";
                }
                jSONObject.put("scheme", str);
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("visit_time")))) {
                    String string2 = cursor.getString(cursor.getColumnIndex("visit_time"));
                    jSONObject.put("dataStamp", string2);
                    jSONObject.put("dateStamp", string2);
                }
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.icon_url.name())))) {
                    jSONObject.put("iconUrl", cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.icon_url.name())));
                }
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.name.name())))) {
                    jSONObject.put("title", cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.name.name())));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        } while (cursor.moveToNext());
        d.b.h0.a.b1.e.a.a(cursor);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("history", jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        if (f45219e) {
            Log.d("SwanAppHistoryHelper", "historyCursorToJson : " + jSONObject2.toString());
        }
        return jSONObject2;
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return f45220f.contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c7 A[LOOP:3: B:48:0x01c1->B:50:0x01c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0270 A[LOOP:5: B:65:0x026a->B:67:0x0270, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor m(@NonNull String str, int i) {
        Cursor query;
        List<f> arrayList;
        HashMap hashMap = new HashMap();
        Cursor n = n(AppRuntime.getAppContext().getContentResolver(), str);
        if (n != null && n.moveToFirst()) {
            do {
                d.b.h0.a.g0.a aVar = new d.b.h0.a.g0.a();
                SwanAppDbControl.f(AppRuntime.getAppContext()).s(n, aVar);
                if (!TextUtils.isEmpty(aVar.f45192a)) {
                    d dVar = new d(null);
                    dVar.f45226b = aVar;
                    e eVar = dVar.f45230a;
                    eVar.f45227a = aVar.f45192a;
                    eVar.f45228b = n.getString(n.getColumnIndex("app_from"));
                    dVar.f45230a.f45229c = n.getLong(n.getColumnIndex("visit_time"));
                    hashMap.put(dVar.f45230a.f45227a, dVar);
                    if (f45219e) {
                        Log.v("history_migrate_pms", "Aps&History == " + aVar.f45192a);
                    }
                }
            } while (n.moveToNext());
            d.b.h0.p.d.a(n);
            if (f45219e) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(d.b.h0.a.g0.d.a.a(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            d.b.h0.p.d.a(query);
            if (f45219e) {
            }
            ArrayList<f> arrayList2 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f45219e) {
            }
            while (r13.hasNext()) {
            }
            if (f45219e) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new g(null));
            int i2 = 0;
            if (i > 0) {
            }
            MatrixCursor matrixCursor = new MatrixCursor(f45222h, 50);
            while (r13.hasNext()) {
            }
            return matrixCursor;
        }
        d.b.h0.p.d.a(n);
        if (f45219e) {
            Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(d.b.h0.a.g0.d.a.a(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                e eVar2 = new e(null);
                eVar2.f45227a = query.getString(query.getColumnIndex(Constants.APP_ID));
                eVar2.f45228b = query.getString(query.getColumnIndex("app_from"));
                eVar2.f45229c = query.getLong(query.getColumnIndex("visit_time"));
                hashMap22.put(eVar2.f45227a, eVar2);
                if (f45219e) {
                    Log.v("history_migrate_pms", "History == " + eVar2.f45227a);
                }
            } while (query.moveToNext());
            d.b.h0.p.d.a(query);
            if (f45219e) {
            }
            ArrayList<f> arrayList22 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f45219e) {
            }
            while (r13.hasNext()) {
            }
            if (f45219e) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new g(null));
            int i22 = 0;
            if (i > 0) {
                arrayList = arrayList.subList(0, i);
                if (f45219e) {
                }
            }
            MatrixCursor matrixCursor2 = new MatrixCursor(f45222h, 50);
            while (r13.hasNext()) {
            }
            return matrixCursor2;
        }
        d.b.h0.p.d.a(query);
        if (f45219e) {
            Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
        }
        ArrayList<f> arrayList222 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(d.b.h0.l.i.a.h().s().values())) {
            if (f45219e) {
                Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            String str2 = pMSAppInfo.appName;
            if (str2 != null && str2.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                h hVar = new h(null);
                hVar.f45230a = (e) hashMap22.get(pMSAppInfo.appId);
                hVar.f45231b = pMSAppInfo;
                arrayList222.add(hVar);
            }
        }
        if (f45219e) {
            Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
        }
        for (f fVar : arrayList222) {
            hashMap.put(fVar.f45230a.f45227a, fVar);
        }
        if (f45219e) {
            Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("history_migrate_pms", "Migrate == " + ((f) it.next()).f45230a.f45227a);
            }
        }
        arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, new g(null));
        int i222 = 0;
        if (i > 0 && i < arrayList.size()) {
            arrayList = arrayList.subList(0, i);
            if (f45219e) {
                Log.d("history_migrate_pms", "Limit限制 " + i + " 条");
            }
        }
        MatrixCursor matrixCursor22 = new MatrixCursor(f45222h, 50);
        for (f fVar2 : arrayList) {
            e(matrixCursor22, i222, fVar2);
            i222++;
        }
        return matrixCursor22;
    }

    @Nullable
    public static Cursor n(@NonNull ContentResolver contentResolver, @NonNull String str) {
        Cursor cursor;
        try {
            cursor = contentResolver.query(d.b.h0.a.g0.d.a.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 400");
        } catch (Exception e2) {
            if (f45219e) {
                e2.printStackTrace();
            }
            cursor = null;
        }
        if (f45219e && cursor != null) {
            Log.d("SwanAppHistoryHelper", "queryHistoryByKeyword: keyword[" + str + "]  Cursor count: " + cursor.getCount());
        }
        return cursor;
    }

    @Nullable
    public static List<String> o(@NonNull ContentResolver contentResolver, @Nullable String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String a2 = d.b.h0.a.u.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                d.b.h0.p.d.a(null);
                return null;
            }
            cursor = contentResolver.query(d.b.h0.a.g0.d.a.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 400");
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
                            d.b.h0.p.d.a(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f45219e) {
                            e.printStackTrace();
                        }
                        d.b.h0.p.d.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.b.h0.p.d.a(cursor2);
                    throw th;
                }
            }
            d.b.h0.p.d.a(cursor);
            return null;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.h0.p.d.a(cursor2);
            throw th;
        }
    }

    @WorkerThread
    public static void p(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0740b c0740b) {
        int i;
        Cursor query;
        Cursor cursor = null;
        if (str == null) {
            str = "";
        }
        try {
            try {
                query = contentResolver.query(d.b.h0.a.g0.d.a.a(), null, "app_id != ?", new String[]{str, String.valueOf(400)}, "visit_time DESC limit ?,-1");
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
            if (f45219e) {
                Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str);
            }
            if (arrayList.isEmpty()) {
                d.b.h0.p.d.a(query);
                return;
            }
            d.b.h0.a.j0.c d2 = d.b.h0.a.j0.e.c().d();
            if (d2 != null) {
                d2.f(arrayList, false, c0740b);
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                sb.append('\'');
                sb.append((String) arrayList.get(i));
                sb.append('\'');
                if (i < size - 1) {
                    sb.append(",");
                }
            }
            String str2 = "app_id in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
            int delete = contentResolver.delete(d.b.h0.a.g0.d.a.a(), str2, null);
            if (f45219e) {
                Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
            }
            d.b.h0.p.d.a(query);
        } catch (Exception e3) {
            e = e3;
            cursor = query;
            if (f45219e) {
                Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
            }
            d.b.h0.p.d.a(cursor);
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            d.b.h0.p.d.a(cursor);
            throw th;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public e f45230a;

        public f() {
            this.f45230a = new e(null);
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }
}
