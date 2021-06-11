package d.a.l0.a.j0.b;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.facebook.common.internal.Sets;
import com.xiaomi.mipush.sdk.Constants;
import d.a.l0.a.k;
import d.a.l0.a.n0.l.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46714a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f46715b = Sets.newHashSet("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f46716c = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};

    /* loaded from: classes3.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public d.a.l0.a.j0.a f46717b;

        public b() {
            super();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f46718a;

        /* renamed from: b  reason: collision with root package name */
        public long f46719b;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public c f46720a;

        public d() {
            this.f46720a = new c();
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
            return Long.compare(dVar2.f46720a.f46719b, dVar.f46720a.f46719b);
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            int i2 = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0).getInt("aiapps_user_fav_count", 0);
            if (a.f46714a) {
                Log.v("SwanAppFavoriteHelper", "delegate读取到的收藏次数：" + i2);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fav_count", i2);
            return bundle2;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            SharedPreferences sharedPreferences = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0);
            int i2 = sharedPreferences.getInt("aiapps_user_fav_count", 0);
            if (a.f46714a) {
                Log.v("SwanAppFavoriteHelper", "delegate当前收藏次数：" + i2);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i3 = i2 + 1;
            edit.putInt("aiapps_user_fav_count", i3);
            edit.commit();
            if (a.f46714a) {
                Log.v("SwanAppFavoriteHelper", "delegate写入新收藏次数" + i3);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fav_count", i3);
            return bundle2;
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends d {

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f46721b;

        public h() {
            super();
        }
    }

    public static boolean b(@NonNull SwanFavorItemData swanFavorItemData, int i2, d.a.l0.a.q0.b.a aVar) {
        if (i2 < 0) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        List<SwanFavorItemData> j = j();
        if (j.size() == 0) {
            if (!h(swanFavorItemData, 1)) {
                if (aVar != null) {
                    aVar.b();
                }
                return false;
            }
            if (aVar != null) {
                aVar.c();
            }
            p();
            return true;
        } else if (j.size() + 1 == i2) {
            if (!h(swanFavorItemData, j.get(j.size() - 1).getIndex() + 1)) {
                if (aVar != null) {
                    aVar.b();
                }
                return false;
            }
            if (aVar != null) {
                aVar.c();
            }
            p();
            return true;
        } else {
            int i3 = 0;
            while (i3 < j.size()) {
                int i4 = i3 + 1;
                if (i4 == i2) {
                    swanFavorItemData.setIndex(j.get(i3).getIndex());
                    if (!h(swanFavorItemData, swanFavorItemData.getIndex())) {
                        if (aVar != null) {
                            aVar.b();
                        }
                        return false;
                    }
                }
                i3 = i4;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            while (i5 < j.size()) {
                int i6 = i5 + 1;
                if (i6 >= i2) {
                    int index = j.get(i5).getIndex() + 1;
                    j.get(i5).setIndex(index);
                    arrayList.add(j.get(i5).getAppKey());
                    arrayList2.add(Integer.valueOf(index));
                }
                i5 = i6;
            }
            boolean w = w(arrayList, arrayList2);
            if (!w) {
                if (aVar != null) {
                    aVar.b();
                }
                return false;
            }
            if (aVar != null) {
                aVar.c();
            }
            p();
            return w;
        }
    }

    public static void c(MatrixCursor matrixCursor, int i2, d dVar) {
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), bVar.f46717b.f46705a).add(SwanAppDbControl.SwanAppTable.app_key.name(), bVar.f46717b.f46706b).add(SwanAppDbControl.SwanAppTable.version.name(), bVar.f46717b.q).add(SwanAppDbControl.SwanAppTable.description.name(), bVar.f46717b.f46707c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(bVar.f46717b.f46708d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), bVar.f46717b.f46709e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), bVar.f46717b.f46710f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), bVar.f46717b.f46711g).add(SwanAppDbControl.SwanAppTable.icon.name(), bVar.f46717b.f46712h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), bVar.f46717b.f46713i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), bVar.f46717b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), bVar.f46717b.k).add(SwanAppDbControl.SwanAppTable.name.name(), bVar.f46717b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), bVar.f46717b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), bVar.f46717b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), bVar.f46717b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), bVar.f46717b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(bVar.f46717b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(bVar.f46717b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), bVar.f46717b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), bVar.f46717b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), bVar.f46717b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(bVar.f46717b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(bVar.f46717b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), bVar.f46717b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(bVar.f46717b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(bVar.f46717b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(bVar.f46717b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(bVar.f46717b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(bVar.f46717b.D ? 1 : 0)).add("favorite_time", Long.valueOf(bVar.f46720a.f46719b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(bVar.f46717b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), bVar.f46717b.F);
            return;
        }
        h hVar = (h) dVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), hVar.f46721b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), hVar.f46721b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(hVar.f46721b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), hVar.f46721b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(hVar.f46721b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), hVar.f46721b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), hVar.f46721b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), hVar.f46721b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), hVar.f46721b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), hVar.f46721b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), hVar.f46721b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), hVar.f46721b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), hVar.f46721b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(hVar.f46721b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(hVar.f46721b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(hVar.f46721b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), hVar.f46721b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(hVar.f46721b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(hVar.f46721b.i())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(hVar.f46721b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(hVar.f46721b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(hVar.f46720a.f46719b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(hVar.f46721b.payProtected)).add("customer_service", Integer.valueOf(hVar.f46721b.customerService)).add("global_notice", Integer.valueOf(hVar.f46721b.globalNotice)).add("global_private", Integer.valueOf(hVar.f46721b.globalPrivate)).add("pa_number", hVar.f46721b.paNumber).add("brand", hVar.f46721b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), hVar.f46721b.quickAppKey);
    }

    public static Uri d() {
        return d.a.l0.a.j0.b.b.f46723c.buildUpon().appendPath("favorite_and_aps").build();
    }

    public static Uri e() {
        return d.a.l0.a.j0.b.b.f46723c.buildUpon().appendPath("favorite").build();
    }

    public static Uri f() {
        return d.a.l0.a.j0.b.b.f46723c.buildUpon().appendPath("favorite_with_aps_pms").build();
    }

    public static boolean g(@NonNull String str, d.a.l0.a.q0.b.b bVar, b.C0819b c0819b) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.b();
            }
            return false;
        }
        d.a.l0.a.n0.l.c m = d.a.l0.a.n0.l.c.m(c0819b);
        m.i(3);
        b.C0819b k = m.k();
        if (AppRuntime.getAppContext().getContentResolver().delete(e(), "app_id = ?", new String[]{str}) > 0) {
            if (f46714a) {
                Log.d("SwanAppFavoriteHelper", "删除收藏，检查是否需要清理包");
            }
            if (!TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                if (ProcessUtils.isMainProcess()) {
                    d.a.l0.a.n0.d d2 = d.a.l0.a.n0.f.c().d();
                    if (d2 != null) {
                        d2.e(str, true, k);
                    }
                } else if (d.a.l0.a.j0.c.b.h(AppRuntime.getAppContext().getContentResolver()).contains(str) || !TextUtils.equals(d.a.l0.a.a2.d.g().r().D(), str)) {
                    d.a.l0.a.v1.c.e.a E = d.a.l0.a.v1.c.e.a.E();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(str);
                    swanAppDeleteInfo.b(d.a.l0.a.n0.l.c.m(k).c());
                    E.O(8, swanAppDeleteInfo);
                }
            }
            if (f46714a) {
                Log.d("SwanAppFavoriteHelper", "取消收藏成功： " + str);
            }
            p();
            if (bVar != null) {
                bVar.c();
            }
        } else if (bVar != null) {
            bVar.b();
        }
        return true;
    }

    public static boolean h(@NonNull SwanFavorItemData swanFavorItemData, int i2) {
        Uri e2 = e();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, swanFavorItemData.getAppKey());
        contentValues.put("sort_index", Integer.valueOf(i2));
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_name", swanFavorItemData.getAppName());
        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
        contentValues.put("pay_protected", Integer.valueOf(swanFavorItemData.getPayProtected()));
        contentValues.put("is_new_favor", Integer.valueOf(swanFavorItemData.getIsNewFavor()));
        if (AppRuntime.getAppContext().getContentResolver().insert(e2, contentValues) != null) {
            if (f46714a) {
                Log.d("SwanAppFavoriteHelper", "数据库收藏成功： " + swanFavorItemData.getAppKey());
            }
            d.a.l0.a.k2.g.b a2 = d.a.l0.a.k2.g.h.a();
            a2.putString("favorite_guide_count_" + swanFavorItemData.getAppKey(), "-1");
            return true;
        }
        return false;
    }

    public static boolean i(List<SwanFavorItemData> list, HashMap<String, Integer> hashMap) {
        if (list != null && list.size() > 0) {
            SQLiteDatabase writableDatabase = SwanAppDbControl.f(d.a.l0.a.c1.a.b()).h().getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                int i2 = 0;
                while (i2 < list.size()) {
                    ContentValues contentValues = new ContentValues();
                    SwanFavorItemData swanFavorItemData = list.get(i2);
                    contentValues.put(Constants.APP_ID, swanFavorItemData.getAppKey());
                    i2++;
                    contentValues.put("sort_index", Integer.valueOf(i2));
                    contentValues.put("favorite_time", Long.valueOf(swanFavorItemData.getCreateTime()));
                    contentValues.put("app_name", swanFavorItemData.getAppName());
                    contentValues.put("app_icon", swanFavorItemData.getIconUrl());
                    contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
                    contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
                    contentValues.put("pay_protected", Integer.valueOf(swanFavorItemData.getPayProtected()));
                    contentValues.put("is_new_favor", hashMap.get(swanFavorItemData.getAppKey()));
                    if (writableDatabase.insertWithOnConflict("ai_apps_favorites", null, contentValues, 5) < 0) {
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception unused) {
                            }
                        }
                        return false;
                    }
                }
                if (f46714a) {
                    Log.d("SwanAppFavoriteHelper", "批量数据库收藏成功");
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                        return true;
                    } catch (Exception unused2) {
                        return true;
                    }
                }
                return true;
            } catch (Exception unused3) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused4) {
                    }
                }
            } catch (Throwable th) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    @NonNull
    public static List<SwanFavorItemData> j() {
        Cursor k = k();
        if (k == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(k.getCount());
        try {
            try {
                if (k.getCount() > 0) {
                    k.moveToFirst();
                    do {
                        SwanFavorItemData l = l(k);
                        if (!TextUtils.isEmpty(l.getAppKey()) && !TextUtils.isEmpty(l.getAppName())) {
                            arrayList.add(l);
                        }
                    } while (k.moveToNext());
                }
            } catch (Exception e2) {
                if (f46714a) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        } finally {
            d.a.l0.t.d.d(k);
        }
    }

    public static Cursor k() {
        u();
        return AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, "sort_index");
    }

    public static SwanFavorItemData l(@NonNull Cursor cursor) {
        SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
        swanFavorItemData.setIndex(cursor.getInt(cursor.getColumnIndex("sort_index")));
        swanFavorItemData.setAppKey(cursor.getString(cursor.getColumnIndex(Constants.APP_ID)));
        swanFavorItemData.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
        swanFavorItemData.setIconUrl(cursor.getString(cursor.getColumnIndex("app_icon")));
        swanFavorItemData.setAppType(cursor.getInt(cursor.getColumnIndex("app_type")));
        swanFavorItemData.setAppFrameType(cursor.getInt(cursor.getColumnIndex("frame_type")));
        swanFavorItemData.setPayProtected(cursor.getInt(cursor.getColumnIndex("pay_protected")));
        swanFavorItemData.setIsNewFavor(cursor.getInt(cursor.getColumnIndex("is_new_favor")));
        if (f46714a) {
            Log.v("favorite_migrate_pms", "Favotite == " + swanFavorItemData.getAppKey());
        }
        if (TextUtils.isEmpty(swanFavorItemData.getAppName()) || TextUtils.isEmpty(swanFavorItemData.getIconUrl())) {
            List<d.a.l0.a.j0.a> r = r();
            if (r.size() > 0) {
                Iterator<d.a.l0.a.j0.a> it = r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.a.l0.a.j0.a next = it.next();
                    if (TextUtils.equals(swanFavorItemData.getAppKey(), next.f46705a)) {
                        swanFavorItemData.setAppKey(next.f46705a);
                        swanFavorItemData.setAppName(next.l);
                        swanFavorItemData.setIconUrl(next.f46713i);
                        swanFavorItemData.setAppFrameType(next.y);
                        swanFavorItemData.setAppType(next.r);
                        swanFavorItemData.setPayProtected(next.E);
                        v(swanFavorItemData);
                        break;
                    }
                }
            }
        }
        return swanFavorItemData;
    }

    public static boolean m(List<SwanFavorItemData> list, String str, String str2, String str3, int i2) {
        if (list != null && list.size() > 0) {
            for (SwanFavorItemData swanFavorItemData : list) {
                if (TextUtils.equals(str, swanFavorItemData.getAppKey()) && TextUtils.equals(str2, swanFavorItemData.getAppName()) && TextUtils.equals(str3, swanFavorItemData.getIconUrl()) && i2 == swanFavorItemData.getPayProtected()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r0.getCount() > 0) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean n(@NonNull String str) {
        boolean z = true;
        boolean z2 = false;
        try {
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(e(), null, "app_id = ?", new String[]{str}, null);
            if (query != null) {
            }
            z = false;
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e2) {
                    e = e2;
                    z2 = z;
                    if (f46714a) {
                        e.printStackTrace();
                    }
                    z = z2;
                    if (f46714a) {
                    }
                    return z;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (f46714a) {
            Log.d("SwanAppFavoriteHelper", "小程序： " + str + "是否在收藏列表中：" + z);
        }
        return z;
    }

    public static boolean o(String str, int i2, d.a.l0.a.q0.b.a aVar) {
        if (TextUtils.isEmpty(str) || i2 < 1) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        List<SwanFavorItemData> j = j();
        if (j.size() < i2) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < j.size()) {
            int i4 = i3 + 1;
            if (i4 == i2) {
                arrayList.add(str);
                arrayList2.add(Integer.valueOf(j.get(i3).getIndex()));
                if (!w(arrayList, arrayList2)) {
                    if (aVar != null) {
                        aVar.b();
                    }
                    return false;
                }
            }
            i3 = i4;
        }
        arrayList.clear();
        arrayList2.clear();
        int i5 = 0;
        while (i5 < j.size()) {
            int i6 = i5 + 1;
            if (i6 >= i2 && !TextUtils.equals(j.get(i5).getAppKey(), str)) {
                arrayList2.add(Integer.valueOf(j.get(i5).getIndex() + 1));
                arrayList.add(j.get(i5).getAppKey());
            }
            i5 = i6;
        }
        boolean w = w(arrayList, arrayList2);
        if (!w) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        if (aVar != null) {
            aVar.c();
        }
        p();
        return w;
    }

    public static void p() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(e(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(d(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(f(), (ContentObserver) null, false);
    }

    public static void q(List<SwanFavorItemData> list) {
        boolean z;
        Cursor k = k();
        if (list == null || list.size() <= 0) {
            if (k == null || k.getCount() <= 0) {
                return;
            }
            AppRuntime.getAppContext().getContentResolver().delete(e(), null, null);
            p();
        } else if (k == null) {
        } else {
            boolean z2 = false;
            try {
                try {
                    k.moveToFirst();
                    HashMap hashMap = new HashMap();
                    do {
                        String string = k.getString(k.getColumnIndex(Constants.APP_ID));
                        String string2 = k.getString(k.getColumnIndex("app_icon"));
                        String string3 = k.getString(k.getColumnIndex("app_name"));
                        int i2 = k.getInt(k.getColumnIndex("pay_protected"));
                        hashMap.put(string, Integer.valueOf(k.getInt(k.getColumnIndex("is_new_favor"))));
                        boolean m = m(list, string, string3, string2, i2);
                        z = true;
                        if (!m) {
                            z2 = true;
                        }
                    } while (k.moveToNext());
                    if (z2 || k.getCount() == list.size()) {
                        z = z2;
                    }
                    if (z) {
                        AppRuntime.getAppContext().getContentResolver().delete(e(), null, null);
                        i(list, hashMap);
                        p();
                    }
                } catch (Exception e2) {
                    if (f46714a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                d.a.l0.t.d.d(k);
            }
        }
    }

    @NonNull
    public static List<d.a.l0.a.j0.a> r() {
        ArrayList arrayList = new ArrayList();
        Cursor s = s();
        try {
            if (s != null) {
                try {
                    if (s.getCount() > 0) {
                        s.moveToFirst();
                        do {
                            d.a.l0.a.j0.a aVar = new d.a.l0.a.j0.a();
                            SwanAppDbControl.f(AppRuntime.getAppContext()).s(s, aVar);
                            if (!TextUtils.isEmpty(aVar.f46705a)) {
                                arrayList.add(aVar);
                            }
                        } while (s.moveToNext());
                    }
                } catch (Exception e2) {
                    if (f46714a) {
                        e2.printStackTrace();
                    }
                }
            }
            return arrayList;
        } finally {
            d.a.l0.t.d.d(s);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ac A[LOOP:3: B:43:0x01a6->B:45:0x01ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022b A[LOOP:5: B:53:0x0225->B:55:0x022b, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor s() {
        Cursor query;
        HashMap hashMap = new HashMap();
        Cursor query2 = AppRuntime.getAppContext().getContentResolver().query(d(), null, null, null, "favorite_time DESC");
        if (query2 != null && query2.moveToFirst()) {
            do {
                d.a.l0.a.j0.a aVar = new d.a.l0.a.j0.a();
                SwanAppDbControl.f(AppRuntime.getAppContext()).s(query2, aVar);
                if (!TextUtils.isEmpty(aVar.f46705a)) {
                    b bVar = new b();
                    bVar.f46717b = aVar;
                    c cVar = bVar.f46720a;
                    cVar.f46718a = aVar.f46705a;
                    cVar.f46719b = query2.getLong(query2.getColumnIndex("favorite_time"));
                    hashMap.put(bVar.f46720a.f46718a, bVar);
                    if (f46714a) {
                        Log.v("favorite_migrate_pms", "Aps&Favotite == " + aVar.f46705a);
                    }
                }
            } while (query2.moveToNext());
            d.a.l0.t.d.d(query2);
            if (f46714a) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            d.a.l0.t.d.d(query);
            if (f46714a) {
            }
            ArrayList<d> arrayList = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f46714a) {
            }
            while (r1.hasNext()) {
            }
            if (f46714a) {
            }
            ArrayList<d> arrayList2 = new ArrayList(hashMap.values());
            Collections.sort(arrayList2, new e());
            MatrixCursor matrixCursor = new MatrixCursor(f46716c, 50);
            int i2 = 0;
            while (r1.hasNext()) {
            }
            return matrixCursor;
        }
        d.a.l0.t.d.d(query2);
        if (f46714a) {
            Log.d("favorite_migrate_pms", "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                c cVar2 = new c();
                cVar2.f46718a = query.getString(query.getColumnIndex(Constants.APP_ID));
                cVar2.f46719b = query.getLong(query.getColumnIndex("favorite_time"));
                hashMap22.put(cVar2.f46718a, cVar2);
                if (f46714a) {
                    Log.v("favorite_migrate_pms", "Favotite == " + cVar2.f46718a);
                }
            } while (query.moveToNext());
            d.a.l0.t.d.d(query);
            if (f46714a) {
            }
            ArrayList<d> arrayList3 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f46714a) {
            }
            while (r1.hasNext()) {
            }
            if (f46714a) {
            }
            ArrayList<d> arrayList22 = new ArrayList(hashMap.values());
            Collections.sort(arrayList22, new e());
            MatrixCursor matrixCursor2 = new MatrixCursor(f46716c, 50);
            int i22 = 0;
            while (r1.hasNext()) {
            }
            return matrixCursor2;
        }
        d.a.l0.t.d.d(query);
        if (f46714a) {
            Log.d("favorite_migrate_pms", "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏");
        }
        ArrayList<d> arrayList32 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(d.a.l0.n.g.a.h().t().values())) {
            if (f46714a) {
                Log.v("favorite_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            if (hashMap22.containsKey(pMSAppInfo.appId)) {
                h hVar = new h();
                hVar.f46720a = (c) hashMap22.get(pMSAppInfo.appId);
                hVar.f46721b = pMSAppInfo;
                arrayList32.add(hVar);
            }
        }
        if (f46714a) {
            Log.d("favorite_migrate_pms", "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏");
        }
        for (d dVar : arrayList32) {
            hashMap.put(dVar.f46720a.f46718a, dVar);
        }
        if (f46714a) {
            Log.d("favorite_migrate_pms", "合并后有 " + hashMap.size() + " 条收藏");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("favorite_migrate_pms", "Migrate == " + ((d) it.next()).f46720a.f46718a);
            }
        }
        ArrayList<d> arrayList222 = new ArrayList(hashMap.values());
        Collections.sort(arrayList222, new e());
        MatrixCursor matrixCursor22 = new MatrixCursor(f46716c, 50);
        int i222 = 0;
        for (d dVar2 : arrayList222) {
            c(matrixCursor22, i222, dVar2);
            i222++;
        }
        return matrixCursor22;
    }

    public static void t() {
        if (f46714a) {
            Log.d("SwanAppFavoriteHelper", "记录用户在小程序框架菜单中点击收藏");
        }
        d.a.l0.a.v1.b.d.b(g.class, null);
    }

    public static void u() {
        int i2 = 1;
        if (d.a.l0.a.k2.g.h.a().getBoolean("key_first_sort", true)) {
            d.a.l0.a.k2.g.h.a().putBoolean("key_first_sort", false);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, "favorite_time DESC");
            if (query != null) {
                try {
                    try {
                        query.moveToFirst();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        do {
                            arrayList.add(query.getString(query.getColumnIndex(Constants.APP_ID)));
                            arrayList2.add(Integer.valueOf(i2));
                            i2++;
                        } while (query.moveToNext());
                        w(arrayList, arrayList2);
                    } catch (Exception e2) {
                        if (f46714a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.a.l0.t.d.d(query);
                }
            }
        }
    }

    public static void v(@NonNull SwanFavorItemData swanFavorItemData) {
        if (TextUtils.isEmpty(swanFavorItemData.getAppKey())) {
            return;
        }
        Uri e2 = e();
        String[] strArr = {swanFavorItemData.getAppKey()};
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_name", swanFavorItemData.getAppName());
        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
        contentValues.put("pay_protected", Integer.valueOf(swanFavorItemData.getPayProtected()));
        if (AppRuntime.getAppContext().getContentResolver().update(e2, contentValues, "app_id = ?", strArr) <= 0 || !f46714a) {
            return;
        }
        Log.d("SwanAppFavoriteHelper", "更新收藏");
    }

    public static boolean w(List<String> list, List<Integer> list2) {
        if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
            SQLiteDatabase writableDatabase = SwanAppDbControl.f(d.a.l0.a.c1.a.b()).h().getWritableDatabase();
            writableDatabase.beginTransaction();
            for (int i2 = 0; i2 < list.size(); i2++) {
                try {
                    String[] strArr = {list.get(i2)};
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("sort_index", list2.get(i2));
                    if (writableDatabase.update("ai_apps_favorites", contentValues, "app_id = ?", strArr) <= 0) {
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception unused) {
                            }
                        }
                        return false;
                    }
                } catch (Exception unused2) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception unused5) {
                }
            }
            return true;
        }
        return false;
    }
}
