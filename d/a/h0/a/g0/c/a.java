package d.a.h0.a.g0.c;

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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.facebook.common.internal.Sets;
import com.xiaomi.mipush.sdk.Constants;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.j0.j.b;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42517a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f42518b = Sets.newHashSet("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f42519c = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};

    /* loaded from: classes2.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public d.a.h0.a.g0.a f42520b;

        public b() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f42521a;

        /* renamed from: b  reason: collision with root package name */
        public long f42522b;

        public c() {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public c f42523a;

        public d() {
            this.f42523a = new c();
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements Comparator<d> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return Long.compare(dVar2.f42523a.f42522b, dVar.f42523a.f42522b);
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            SharedPreferences sharedPreferences = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0);
            int i2 = sharedPreferences.getInt("aiapps_user_fav_count", 0);
            if (a.f42517a) {
                Log.v("SwanAppFavoriteHelper", "delegate当前收藏次数：" + i2);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i3 = i2 + 1;
            edit.putInt("aiapps_user_fav_count", i3);
            edit.commit();
            if (a.f42517a) {
                Log.v("SwanAppFavoriteHelper", "delegate写入新收藏次数" + i3);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fav_count", i3);
            return bundle2;
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f42524b;

        public g() {
            super();
        }
    }

    public static boolean b(@NonNull SwanFavorItemData swanFavorItemData, int i2, d.a.h0.a.m0.b.a aVar) {
        if (i2 < 0) {
            if (aVar != null) {
                aVar.a();
            }
            return false;
        }
        List<SwanFavorItemData> j = j();
        if (j.size() == 0) {
            if (!h(swanFavorItemData, 1)) {
                if (aVar != null) {
                    aVar.a();
                }
                return false;
            }
            if (aVar != null) {
                aVar.b();
            }
            p();
            return true;
        } else if (j.size() + 1 == i2) {
            if (!h(swanFavorItemData, j.get(j.size() - 1).getIndex() + 1)) {
                if (aVar != null) {
                    aVar.a();
                }
                return false;
            }
            if (aVar != null) {
                aVar.b();
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
                            aVar.a();
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
                    aVar.a();
                }
                return false;
            }
            if (aVar != null) {
                aVar.b();
            }
            p();
            return w;
        }
    }

    public static void c(MatrixCursor matrixCursor, int i2, d dVar) {
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), bVar.f42520b.f42504a).add(SwanAppDbControl.SwanAppTable.app_key.name(), bVar.f42520b.f42505b).add(SwanAppDbControl.SwanAppTable.version.name(), bVar.f42520b.q).add(SwanAppDbControl.SwanAppTable.description.name(), bVar.f42520b.f42506c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(bVar.f42520b.f42507d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), bVar.f42520b.f42508e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), bVar.f42520b.f42509f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), bVar.f42520b.f42510g).add(SwanAppDbControl.SwanAppTable.icon.name(), bVar.f42520b.f42511h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), bVar.f42520b.f42512i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), bVar.f42520b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), bVar.f42520b.k).add(SwanAppDbControl.SwanAppTable.name.name(), bVar.f42520b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), bVar.f42520b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), bVar.f42520b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), bVar.f42520b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), bVar.f42520b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(bVar.f42520b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(bVar.f42520b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), bVar.f42520b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), bVar.f42520b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), bVar.f42520b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(bVar.f42520b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(bVar.f42520b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), bVar.f42520b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(bVar.f42520b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(bVar.f42520b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(bVar.f42520b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(bVar.f42520b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(bVar.f42520b.D ? 1 : 0)).add("favorite_time", Long.valueOf(bVar.f42523a.f42522b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(bVar.f42520b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), bVar.f42520b.F);
            return;
        }
        g gVar = (g) dVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), gVar.f42524b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), gVar.f42524b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(gVar.f42524b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), gVar.f42524b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(gVar.f42524b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), gVar.f42524b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), gVar.f42524b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), gVar.f42524b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), gVar.f42524b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), gVar.f42524b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), gVar.f42524b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), gVar.f42524b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), gVar.f42524b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(gVar.f42524b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(gVar.f42524b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(gVar.f42524b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), gVar.f42524b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(gVar.f42524b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(gVar.f42524b.i())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(gVar.f42524b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(gVar.f42524b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(gVar.f42523a.f42522b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(gVar.f42524b.payProtected)).add("customer_service", Integer.valueOf(gVar.f42524b.customerService)).add("global_notice", Integer.valueOf(gVar.f42524b.globalNotice)).add("global_private", Integer.valueOf(gVar.f42524b.globalPrivate)).add("pa_number", gVar.f42524b.paNumber).add("brand", gVar.f42524b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), gVar.f42524b.quickAppKey);
    }

    public static Uri d() {
        return d.a.h0.a.g0.c.b.f42526c.buildUpon().appendPath("favorite_and_aps").build();
    }

    public static Uri e() {
        return d.a.h0.a.g0.c.b.f42526c.buildUpon().appendPath("favorite").build();
    }

    public static Uri f() {
        return d.a.h0.a.g0.c.b.f42526c.buildUpon().appendPath("favorite_with_aps_pms").build();
    }

    public static boolean g(@NonNull String str, d.a.h0.a.m0.b.b bVar, b.C0679b c0679b) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.a();
            }
            return false;
        }
        d.a.h0.a.j0.j.c l = d.a.h0.a.j0.j.c.l(c0679b);
        l.h(3);
        b.C0679b j = l.j();
        if (AppRuntime.getAppContext().getContentResolver().delete(e(), "app_id = ?", new String[]{str}) > 0) {
            if (f42517a) {
                Log.d("SwanAppFavoriteHelper", "删除收藏，检查是否需要清理包");
            }
            if (!TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                if (ProcessUtils.isMainProcess()) {
                    d.a.h0.a.j0.c d2 = d.a.h0.a.j0.e.c().d();
                    if (d2 != null) {
                        d2.e(str, true, j);
                    }
                } else if (d.a.h0.a.g0.d.b.i(AppRuntime.getAppContext().getContentResolver()).contains(str) || !TextUtils.equals(d.a.h0.a.r1.e.T(), str)) {
                    d.a.h0.a.n1.c.e.a C = d.a.h0.a.n1.c.e.a.C();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(str);
                    swanAppDeleteInfo.b(d.a.h0.a.j0.j.c.l(j).c());
                    C.M(8, swanAppDeleteInfo);
                }
            }
            if (f42517a) {
                Log.d("SwanAppFavoriteHelper", "取消收藏成功： " + str);
            }
            p();
            if (bVar != null) {
                bVar.b();
            }
        } else if (bVar != null) {
            bVar.a();
        }
        return true;
    }

    public static boolean h(@NonNull SwanFavorItemData swanFavorItemData, int i2) {
        Uri e2 = e();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, swanFavorItemData.getAppKey());
        contentValues.put("sort_index", Integer.valueOf(i2));
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(DpStatConstants.KEY_APP_NAME, swanFavorItemData.getAppName());
        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
        if (AppRuntime.getAppContext().getContentResolver().insert(e2, contentValues) != null) {
            if (f42517a) {
                Log.d("SwanAppFavoriteHelper", "数据库收藏成功： " + swanFavorItemData.getAppKey());
            }
            d.a.h0.a.a2.g.b a2 = h.a();
            a2.putString("favorite_guide_count_" + swanFavorItemData.getAppKey(), "-1");
            return true;
        }
        return false;
    }

    public static boolean i(List<SwanFavorItemData> list) {
        if (list != null && list.size() > 0) {
            SQLiteDatabase writableDatabase = SwanAppDbControl.f(d.a.h0.a.w0.a.c()).h().getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                int i2 = 0;
                while (i2 < list.size()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.APP_ID, list.get(i2).getAppKey());
                    int i3 = i2 + 1;
                    contentValues.put("sort_index", Integer.valueOf(i3));
                    contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(DpStatConstants.KEY_APP_NAME, list.get(i2).getAppName());
                    contentValues.put("app_icon", list.get(i2).getIconUrl());
                    contentValues.put("app_type", Integer.valueOf(list.get(i2).getAppType()));
                    contentValues.put("frame_type", Integer.valueOf(list.get(i2).getAppFrameType()));
                    if (writableDatabase.insertWithOnConflict("ai_apps_favorites", null, contentValues, 5) < 0) {
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception unused) {
                            }
                        }
                        return false;
                    }
                    i2 = i3;
                }
                if (f42517a) {
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
                if (f42517a) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        } finally {
            d.a.h0.p.d.a(k);
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
        swanFavorItemData.setAppName(cursor.getString(cursor.getColumnIndex(DpStatConstants.KEY_APP_NAME)));
        swanFavorItemData.setIconUrl(cursor.getString(cursor.getColumnIndex("app_icon")));
        swanFavorItemData.setAppType(cursor.getInt(cursor.getColumnIndex("app_type")));
        swanFavorItemData.setAppFrameType(cursor.getInt(cursor.getColumnIndex("frame_type")));
        if (f42517a) {
            Log.v("favorite_migrate_pms", "Favotite == " + swanFavorItemData.getAppKey());
        }
        if (TextUtils.isEmpty(swanFavorItemData.getAppName()) || TextUtils.isEmpty(swanFavorItemData.getIconUrl())) {
            List<d.a.h0.a.g0.a> r = r();
            if (r.size() > 0) {
                Iterator<d.a.h0.a.g0.a> it = r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.a.h0.a.g0.a next = it.next();
                    if (TextUtils.equals(swanFavorItemData.getAppKey(), next.f42504a)) {
                        swanFavorItemData.setAppKey(next.f42504a);
                        swanFavorItemData.setAppName(next.l);
                        swanFavorItemData.setIconUrl(next.f42512i);
                        swanFavorItemData.setAppFrameType(next.y);
                        swanFavorItemData.setAppType(next.r);
                        v(swanFavorItemData);
                        break;
                    }
                }
            }
        }
        return swanFavorItemData;
    }

    public static boolean m(List<SwanFavorItemData> list, String str, String str2, String str3) {
        if (list != null && list.size() > 0) {
            for (SwanFavorItemData swanFavorItemData : list) {
                if (TextUtils.equals(str, swanFavorItemData.getAppKey()) && TextUtils.equals(str2, swanFavorItemData.getAppName()) && TextUtils.equals(str3, swanFavorItemData.getIconUrl())) {
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
                    if (f42517a) {
                        e.printStackTrace();
                    }
                    z = z2;
                    if (f42517a) {
                    }
                    return z;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (f42517a) {
            Log.d("SwanAppFavoriteHelper", "小程序： " + str + "是否在收藏列表中：" + z);
        }
        return z;
    }

    public static boolean o(String str, int i2, d.a.h0.a.m0.b.a aVar) {
        if (TextUtils.isEmpty(str) || i2 < 1) {
            if (aVar != null) {
                aVar.a();
            }
            return false;
        }
        List<SwanFavorItemData> j = j();
        if (j.size() < i2) {
            if (aVar != null) {
                aVar.a();
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
                        aVar.a();
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
                aVar.a();
            }
            return false;
        }
        if (aVar != null) {
            aVar.b();
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
                    while (true) {
                        z = true;
                        if (!k.moveToNext()) {
                            break;
                        }
                        if (!m(list, k.getString(k.getColumnIndex(Constants.APP_ID)), k.getString(k.getColumnIndex(DpStatConstants.KEY_APP_NAME)), k.getString(k.getColumnIndex("app_icon")))) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2 || k.getCount() == list.size()) {
                        z = z2;
                    }
                    if (z) {
                        AppRuntime.getAppContext().getContentResolver().delete(e(), null, null);
                        i(list);
                        p();
                    }
                } catch (Exception e2) {
                    if (f42517a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                d.a.h0.p.d.a(k);
            }
        }
    }

    @NonNull
    public static List<d.a.h0.a.g0.a> r() {
        ArrayList arrayList = new ArrayList();
        Cursor s = s();
        try {
            if (s != null) {
                try {
                    if (s.getCount() > 0) {
                        s.moveToFirst();
                        do {
                            d.a.h0.a.g0.a aVar = new d.a.h0.a.g0.a();
                            SwanAppDbControl.f(AppRuntime.getAppContext()).s(s, aVar);
                            if (!TextUtils.isEmpty(aVar.f42504a)) {
                                arrayList.add(aVar);
                            }
                        } while (s.moveToNext());
                    }
                } catch (Exception e2) {
                    if (f42517a) {
                        e2.printStackTrace();
                    }
                }
            }
            return arrayList;
        } finally {
            d.a.h0.p.d.a(s);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ac A[LOOP:3: B:43:0x01a6->B:45:0x01ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022c A[LOOP:5: B:53:0x0226->B:55:0x022c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor s() {
        Cursor query;
        HashMap hashMap = new HashMap();
        Cursor query2 = AppRuntime.getAppContext().getContentResolver().query(d(), null, null, null, "favorite_time DESC");
        if (query2 != null && query2.moveToFirst()) {
            do {
                d.a.h0.a.g0.a aVar = new d.a.h0.a.g0.a();
                SwanAppDbControl.f(AppRuntime.getAppContext()).s(query2, aVar);
                if (!TextUtils.isEmpty(aVar.f42504a)) {
                    b bVar = new b();
                    bVar.f42520b = aVar;
                    c cVar = bVar.f42523a;
                    cVar.f42521a = aVar.f42504a;
                    cVar.f42522b = query2.getLong(query2.getColumnIndex("favorite_time"));
                    hashMap.put(bVar.f42523a.f42521a, bVar);
                    if (f42517a) {
                        Log.v("favorite_migrate_pms", "Aps&Favotite == " + aVar.f42504a);
                    }
                }
            } while (query2.moveToNext());
            d.a.h0.p.d.a(query2);
            if (f42517a) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            d.a.h0.p.d.a(query);
            if (f42517a) {
            }
            ArrayList<d> arrayList = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f42517a) {
            }
            while (r1.hasNext()) {
            }
            if (f42517a) {
            }
            ArrayList<d> arrayList2 = new ArrayList(hashMap.values());
            Collections.sort(arrayList2, new e());
            MatrixCursor matrixCursor = new MatrixCursor(f42519c, 50);
            int i2 = 0;
            while (r1.hasNext()) {
            }
            return matrixCursor;
        }
        d.a.h0.p.d.a(query2);
        if (f42517a) {
            Log.d("favorite_migrate_pms", "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                c cVar2 = new c();
                cVar2.f42521a = query.getString(query.getColumnIndex(Constants.APP_ID));
                cVar2.f42522b = query.getLong(query.getColumnIndex("favorite_time"));
                hashMap22.put(cVar2.f42521a, cVar2);
                if (f42517a) {
                    Log.v("favorite_migrate_pms", "Favotite == " + cVar2.f42521a);
                }
            } while (query.moveToNext());
            d.a.h0.p.d.a(query);
            if (f42517a) {
            }
            ArrayList<d> arrayList3 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f42517a) {
            }
            while (r1.hasNext()) {
            }
            if (f42517a) {
            }
            ArrayList<d> arrayList22 = new ArrayList(hashMap.values());
            Collections.sort(arrayList22, new e());
            MatrixCursor matrixCursor2 = new MatrixCursor(f42519c, 50);
            int i22 = 0;
            while (r1.hasNext()) {
            }
            return matrixCursor2;
        }
        d.a.h0.p.d.a(query);
        if (f42517a) {
            Log.d("favorite_migrate_pms", "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏");
        }
        ArrayList<d> arrayList32 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(d.a.h0.l.i.a.h().s().values())) {
            if (f42517a) {
                Log.v("favorite_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            if (hashMap22.containsKey(pMSAppInfo.appId)) {
                g gVar = new g();
                gVar.f42523a = (c) hashMap22.get(pMSAppInfo.appId);
                gVar.f42524b = pMSAppInfo;
                arrayList32.add(gVar);
            }
        }
        if (f42517a) {
            Log.d("favorite_migrate_pms", "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏");
        }
        for (d dVar : arrayList32) {
            hashMap.put(dVar.f42523a.f42521a, dVar);
        }
        if (f42517a) {
            Log.d("favorite_migrate_pms", "合并后有 " + hashMap.size() + " 条收藏");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("favorite_migrate_pms", "Migrate == " + ((d) it.next()).f42523a.f42521a);
            }
        }
        ArrayList<d> arrayList222 = new ArrayList(hashMap.values());
        Collections.sort(arrayList222, new e());
        MatrixCursor matrixCursor22 = new MatrixCursor(f42519c, 50);
        int i222 = 0;
        for (d dVar2 : arrayList222) {
            c(matrixCursor22, i222, dVar2);
            i222++;
        }
        return matrixCursor22;
    }

    public static void t() {
        if (f42517a) {
            Log.d("SwanAppFavoriteHelper", "记录用户在小程序框架菜单中点击收藏");
        }
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, null);
    }

    public static void u() {
        int i2 = 1;
        if (h.a().getBoolean("key_first_sort", true)) {
            h.a().putBoolean("key_first_sort", false);
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
                        if (f42517a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.a.h0.p.d.a(query);
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
        contentValues.put(DpStatConstants.KEY_APP_NAME, swanFavorItemData.getAppName());
        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
        if (AppRuntime.getAppContext().getContentResolver().update(e2, contentValues, "app_id = ?", strArr) <= 0 || !f42517a) {
            return;
        }
        Log.d("SwanAppFavoriteHelper", "更新收藏");
    }

    public static boolean w(List<String> list, List<Integer> list2) {
        if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
            SQLiteDatabase writableDatabase = SwanAppDbControl.f(d.a.h0.a.w0.a.c()).h().getWritableDatabase();
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
