package d.b.g0.a.g0.d;

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
import d.b.g0.a.i2.p;
import d.b.g0.a.j0.j.b;
import d.b.g0.a.k;
import d.b.g0.a.t1.k.h0.a;
import d.b.g0.a.y0.e.b;
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
public class b implements d.b.g0.a.j0.j.b {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public static AtomicLong f44499g;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44497e = k.f45050a;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f44498f = Sets.newHashSet();

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f44500h = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.g0.b f44501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0707b f44502f;

        public a(d.b.g0.a.g0.b bVar, b.C0707b c0707b) {
            this.f44501e = bVar;
            this.f44502f = c0707b;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean c2 = b.c(AppRuntime.getAppContext().getContentResolver(), this.f44501e, this.f44502f);
            if (!b.f44497e || c2) {
                return;
            }
            Log.e("SwanAppHistoryHelper", "addHistoryAsync Failed!");
        }
    }

    /* renamed from: d.b.g0.a.g0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0692b implements h.n.b<Cursor> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f44503e;

        public C0692b(a.c cVar) {
            this.f44503e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Cursor cursor) {
            if (cursor == null || !cursor.moveToFirst()) {
                if (b.f44497e) {
                    Log.d("SwanAppHistoryHelper", "historyList == null || historyList.size() == 0");
                }
                d.b.g0.a.b1.e.a.a(cursor);
                this.f44503e.a(null);
                return;
            }
            this.f44503e.a(b.k(cursor));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements h.n.f<String, Cursor> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Cursor call(String str) {
            return b.m(str, 400);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends f {

        /* renamed from: b  reason: collision with root package name */
        public d.b.g0.a.g0.a f44504b;

        public d() {
            super(null);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f44505a;

        /* renamed from: b  reason: collision with root package name */
        public String f44506b;

        /* renamed from: c  reason: collision with root package name */
        public long f44507c;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Comparator<f> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return Long.compare(fVar2.f44508a.f44507c, fVar.f44508a.f44507c);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends f {

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f44509b;

        public h() {
            super(null);
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable d.b.g0.a.g0.b bVar, b.C0707b c0707b) {
        if (bVar == null || TextUtils.isEmpty(bVar.a())) {
            return false;
        }
        if (f44497e) {
            Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.c() + " / " + bVar.a());
        }
        if (l(bVar.a())) {
            if (f44497e) {
                Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
            }
            return false;
        }
        if (TextUtils.equals("0", bVar.f44481d)) {
            String a2 = bVar.a();
            d.b.g0.a.j0.j.c l = d.b.g0.a.j0.j.c.l(c0707b);
            l.h(1);
            h(contentResolver, a2, l.j());
        }
        Uri a3 = d.b.g0.a.g0.d.a.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, bVar.a());
        contentValues.put("visit_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_from", bVar.b());
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a3, contentValues);
            if (f44497e) {
                String uri = insert == null ? "NULL" : insert.toString();
                Log.d("SwanAppHistoryHelper", "Add history: newUri - " + uri);
            }
            if (f()) {
                String a4 = bVar.a();
                d.b.g0.a.j0.j.c l2 = d.b.g0.a.j0.j.c.l(c0707b);
                l2.h(2);
                p(contentResolver, a4, l2.j());
            }
            return insert != null;
        } catch (Exception e2) {
            d.b.g0.a.e0.e.f(a3.toString(), bVar.a(), e2.toString());
            if (f44497e) {
                Log.e("SwanAppHistoryHelper", "encounter error while adding swan history" + e2.toString());
                throw new RuntimeException("encounter error while adding swan history, only throw in debug mode", e2);
            }
            return false;
        }
    }

    public static void d(d.b.g0.a.r1.e eVar, b.C0707b c0707b) {
        b.a L;
        if (eVar == null || (L = eVar.L()) == null || TextUtils.equals("1", L.Z())) {
            return;
        }
        String G = L.G();
        if (TextUtils.equals("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u", G) || TextUtils.equals("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D", G) || TextUtils.equals("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", G)) {
            return;
        }
        if (f44497e) {
            Log.d("SwanAppHistoryHelper", "addHistoryAsync: " + L.J() + " / " + G);
        }
        d.b.g0.a.g0.b bVar = new d.b.g0.a.g0.b(G);
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
        p.k(new a(bVar, c0707b), "saveSwanAppInHistoryAsync");
    }

    public static void e(MatrixCursor matrixCursor, int i, f fVar) {
        if (fVar instanceof d) {
            d dVar = (d) fVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), dVar.f44504b.f44470a).add(SwanAppDbControl.SwanAppTable.app_key.name(), dVar.f44504b.f44471b).add(SwanAppDbControl.SwanAppTable.version.name(), dVar.f44504b.q).add(SwanAppDbControl.SwanAppTable.description.name(), dVar.f44504b.f44472c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(dVar.f44504b.f44473d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), dVar.f44504b.f44474e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), dVar.f44504b.f44475f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), dVar.f44504b.f44476g).add(SwanAppDbControl.SwanAppTable.icon.name(), dVar.f44504b.f44477h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), dVar.f44504b.i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), dVar.f44504b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), dVar.f44504b.k).add(SwanAppDbControl.SwanAppTable.name.name(), dVar.f44504b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), dVar.f44504b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), dVar.f44504b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), dVar.f44504b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), dVar.f44504b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(dVar.f44504b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(dVar.f44504b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), dVar.f44504b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), dVar.f44504b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), dVar.f44504b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(dVar.f44504b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(dVar.f44504b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), dVar.f44504b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(dVar.f44504b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(dVar.f44504b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(dVar.f44504b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(dVar.f44504b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(dVar.f44504b.D ? 1 : 0)).add("app_from", dVar.f44508a.f44506b).add("visit_time", Long.valueOf(dVar.f44508a.f44507c)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(dVar.f44504b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), dVar.f44504b.F);
            return;
        }
        h hVar = (h) fVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), hVar.f44509b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), hVar.f44509b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(hVar.f44509b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), hVar.f44509b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(hVar.f44509b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), hVar.f44509b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), hVar.f44509b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), hVar.f44509b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), hVar.f44509b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), hVar.f44509b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), hVar.f44509b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), hVar.f44509b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), hVar.f44509b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(hVar.f44509b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(hVar.f44509b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(hVar.f44509b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), hVar.f44509b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(hVar.f44509b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(hVar.f44509b.i())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(hVar.f44509b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(hVar.f44509b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", hVar.f44508a.f44506b).add("visit_time", Long.valueOf(hVar.f44508a.f44507c)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(hVar.f44509b.payProtected)).add("customer_service", Integer.valueOf(hVar.f44509b.customerService)).add("global_notice", Integer.valueOf(hVar.f44509b.globalNotice)).add("global_private", Integer.valueOf(hVar.f44509b.globalPrivate)).add("pa_number", hVar.f44509b.paNumber).add("brand", hVar.f44509b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), hVar.f44509b.quickAppKey);
    }

    public static boolean f() {
        if (f44499g != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f44499g.get() > 86400000) {
                f44499g.set(currentTimeMillis);
                d.b.g0.a.a2.g.h.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                return true;
            }
            return false;
        }
        synchronized (d.b.g0.a.a2.g.h.class) {
            if (f44499g == null) {
                f44499g = new AtomicLong(d.b.g0.a.a2.g.h.a().getLong("key_check_delete_swan_history", 0L));
                return f();
            }
            return false;
        }
    }

    public static boolean g(ContentResolver contentResolver, String str, boolean z, b.C0707b c0707b) {
        d.b.g0.a.j0.c d2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z2 = contentResolver.delete(d.b.g0.a.g0.d.a.a(), "app_id=?", new String[]{str}) > 0;
        if (z && z2 && (d2 = d.b.g0.a.j0.e.c().d()) != null) {
            d.b.g0.a.j0.j.c l = d.b.g0.a.j0.j.c.l(c0707b);
            l.h(4);
            d2.e(str, true, l.j());
        }
        if (f44497e) {
            Log.d("SwanAppHistoryHelper", "deleteHistory: " + str + " isSuccess: " + z2);
        }
        return z2;
    }

    public static void h(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0707b c0707b) {
        if (f44497e) {
            Log.d("SwanAppHistoryHelper", "start deleteOtherDevHistory: ");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = d.b.g0.a.u.a.a(str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        List<String> o = o(contentResolver, str);
        if (o != null && o.size() != 0) {
            d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
            if (d2 != null) {
                if (f44497e) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                }
                d2.g(o, false, false, c0707b);
            }
            if (f44497e) {
                Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
            }
            contentResolver.delete(d.b.g0.a.g0.d.a.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
        } else if (f44497e) {
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
                cursor = contentResolver.query(d.b.g0.a.g0.d.a.a(), null, null, null, null);
            } catch (Exception e2) {
                if (f44497e) {
                    e2.printStackTrace();
                }
                if (f44497e && cursor != null) {
                    sb = new StringBuilder();
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    hashSet.add(cursor.getString(cursor.getColumnIndex(Constants.APP_ID)));
                } while (cursor.moveToNext());
                if (f44497e) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                d.b.g0.p.d.a(cursor);
                return hashSet;
            }
            if (f44497e && cursor != null) {
                sb = new StringBuilder();
                sb.append("getAllHistoryIdsSet: Cursor count: ");
                sb.append(cursor.getCount());
                Log.d("SwanAppHistoryHelper", sb.toString());
            }
            d.b.g0.p.d.a(cursor);
            return hashSet;
        } catch (Throwable th) {
            if (f44497e && cursor != null) {
                Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
            }
            d.b.g0.p.d.a(cursor);
            throw th;
        }
    }

    public static void j(a.c cVar) {
        if (cVar == null) {
            return;
        }
        h.d.j("").F(Schedulers.io()).l(new c()).p(h.l.b.a.b()).D(new C0692b(cVar));
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
                    str = String.format(d.b.g0.a.t1.k.h0.a.f46373d, string);
                } else {
                    str = d.b.g0.a.t1.k.h0.a.f46372c + string + "\"}";
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
        d.b.g0.a.b1.e.a.a(cursor);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("history", jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        if (f44497e) {
            Log.d("SwanAppHistoryHelper", "historyCursorToJson : " + jSONObject2.toString());
        }
        return jSONObject2;
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return f44498f.contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c6 A[LOOP:3: B:48:0x01c0->B:50:0x01c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x026e A[LOOP:5: B:65:0x0268->B:67:0x026e, LOOP_END] */
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
                d.b.g0.a.g0.a aVar = new d.b.g0.a.g0.a();
                SwanAppDbControl.f(AppRuntime.getAppContext()).s(n, aVar);
                if (!TextUtils.isEmpty(aVar.f44470a)) {
                    d dVar = new d(null);
                    dVar.f44504b = aVar;
                    e eVar = dVar.f44508a;
                    eVar.f44505a = aVar.f44470a;
                    eVar.f44506b = n.getString(n.getColumnIndex("app_from"));
                    dVar.f44508a.f44507c = n.getLong(n.getColumnIndex("visit_time"));
                    hashMap.put(dVar.f44508a.f44505a, dVar);
                    if (f44497e) {
                        Log.v("history_migrate_pms", "Aps&History == " + aVar.f44470a);
                    }
                }
            } while (n.moveToNext());
            d.b.g0.p.d.a(n);
            if (f44497e) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(d.b.g0.a.g0.d.a.a(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            d.b.g0.p.d.a(query);
            if (f44497e) {
            }
            ArrayList<f> arrayList2 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f44497e) {
            }
            while (r13.hasNext()) {
            }
            if (f44497e) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new g(null));
            int i2 = 0;
            if (i > 0) {
            }
            MatrixCursor matrixCursor = new MatrixCursor(f44500h, 50);
            while (r13.hasNext()) {
            }
            return matrixCursor;
        }
        d.b.g0.p.d.a(n);
        if (f44497e) {
            Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(d.b.g0.a.g0.d.a.a(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                e eVar2 = new e(null);
                eVar2.f44505a = query.getString(query.getColumnIndex(Constants.APP_ID));
                eVar2.f44506b = query.getString(query.getColumnIndex("app_from"));
                eVar2.f44507c = query.getLong(query.getColumnIndex("visit_time"));
                hashMap22.put(eVar2.f44505a, eVar2);
                if (f44497e) {
                    Log.v("history_migrate_pms", "History == " + eVar2.f44505a);
                }
            } while (query.moveToNext());
            d.b.g0.p.d.a(query);
            if (f44497e) {
            }
            ArrayList<f> arrayList22 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f44497e) {
            }
            while (r13.hasNext()) {
            }
            if (f44497e) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new g(null));
            int i22 = 0;
            if (i > 0) {
                arrayList = arrayList.subList(0, i);
                if (f44497e) {
                }
            }
            MatrixCursor matrixCursor2 = new MatrixCursor(f44500h, 50);
            while (r13.hasNext()) {
            }
            return matrixCursor2;
        }
        d.b.g0.p.d.a(query);
        if (f44497e) {
            Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
        }
        ArrayList<f> arrayList222 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(d.b.g0.l.i.a.h().s().values())) {
            if (f44497e) {
                Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            String str2 = pMSAppInfo.appName;
            if (str2 != null && str2.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                h hVar = new h(null);
                hVar.f44508a = (e) hashMap22.get(pMSAppInfo.appId);
                hVar.f44509b = pMSAppInfo;
                arrayList222.add(hVar);
            }
        }
        if (f44497e) {
            Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
        }
        for (f fVar : arrayList222) {
            hashMap.put(fVar.f44508a.f44505a, fVar);
        }
        if (f44497e) {
            Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("history_migrate_pms", "Migrate == " + ((f) it.next()).f44508a.f44505a);
            }
        }
        arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, new g(null));
        int i222 = 0;
        if (i > 0 && i < arrayList.size()) {
            arrayList = arrayList.subList(0, i);
            if (f44497e) {
                Log.d("history_migrate_pms", "Limit限制 " + i + " 条");
            }
        }
        MatrixCursor matrixCursor22 = new MatrixCursor(f44500h, 50);
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
            cursor = contentResolver.query(d.b.g0.a.g0.d.a.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 400");
        } catch (Exception e2) {
            if (f44497e) {
                e2.printStackTrace();
            }
            cursor = null;
        }
        if (f44497e && cursor != null) {
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
            String a2 = d.b.g0.a.u.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                d.b.g0.p.d.a(null);
                return null;
            }
            cursor = contentResolver.query(d.b.g0.a.g0.d.a.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 400");
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
                            d.b.g0.p.d.a(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f44497e) {
                            e.printStackTrace();
                        }
                        d.b.g0.p.d.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.b.g0.p.d.a(cursor2);
                    throw th;
                }
            }
            d.b.g0.p.d.a(cursor);
            return null;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.p.d.a(cursor2);
            throw th;
        }
    }

    @WorkerThread
    public static void p(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0707b c0707b) {
        int i;
        Cursor query;
        Cursor cursor = null;
        try {
            if (str == null) {
                str = "";
            }
            try {
                query = contentResolver.query(d.b.g0.a.g0.d.a.a(), null, "app_id != ?", new String[]{str, String.valueOf(400)}, "visit_time DESC limit ?,-1");
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
            if (f44497e) {
                Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str);
            }
            if (arrayList.isEmpty()) {
                d.b.g0.p.d.a(query);
                return;
            }
            d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
            if (d2 != null) {
                d2.f(arrayList, false, c0707b);
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
            int delete = contentResolver.delete(d.b.g0.a.g0.d.a.a(), str2, null);
            if (f44497e) {
                Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
            }
            d.b.g0.p.d.a(query);
        } catch (Exception e3) {
            e = e3;
            cursor = query;
            if (f44497e) {
                Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
            }
            d.b.g0.p.d.a(cursor);
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            d.b.g0.p.d.a(cursor);
            throw th;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public e f44508a;

        public f() {
            this.f44508a = new e(null);
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }
}
