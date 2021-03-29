package d.b.g0.a.g0.c;

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
import d.b.g0.a.a2.g.h;
import d.b.g0.a.j0.j.b;
import d.b.g0.a.k;
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
    public static final boolean f44483a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f44484b = Sets.newHashSet("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f44485c = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};

    /* loaded from: classes2.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public d.b.g0.a.g0.a f44486b;

        public b() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f44487a;

        /* renamed from: b  reason: collision with root package name */
        public long f44488b;

        public c() {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public c f44489a;

        public d() {
            this.f44489a = new c();
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
            return Long.compare(dVar2.f44489a.f44488b, dVar.f44489a.f44488b);
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            SharedPreferences sharedPreferences = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0);
            int i = sharedPreferences.getInt("aiapps_user_fav_count", 0);
            if (a.f44483a) {
                Log.v("SwanAppFavoriteHelper", "delegate当前收藏次数：" + i);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i2 = i + 1;
            edit.putInt("aiapps_user_fav_count", i2);
            edit.commit();
            if (a.f44483a) {
                Log.v("SwanAppFavoriteHelper", "delegate写入新收藏次数" + i2);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fav_count", i2);
            return bundle2;
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f44490b;

        public g() {
            super();
        }
    }

    public static boolean b(@NonNull SwanFavorItemData swanFavorItemData, int i, d.b.g0.a.m0.b.a aVar) {
        if (i < 0) {
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
                aVar.a();
            }
            p();
            return true;
        } else if (j.size() + 1 == i) {
            if (!h(swanFavorItemData, j.get(j.size() - 1).getIndex() + 1)) {
                if (aVar != null) {
                    aVar.b();
                }
                return false;
            }
            if (aVar != null) {
                aVar.a();
            }
            p();
            return true;
        } else {
            int i2 = 0;
            while (i2 < j.size()) {
                int i3 = i2 + 1;
                if (i3 == i) {
                    swanFavorItemData.setIndex(j.get(i2).getIndex());
                    if (!h(swanFavorItemData, swanFavorItemData.getIndex())) {
                        if (aVar != null) {
                            aVar.b();
                        }
                        return false;
                    }
                }
                i2 = i3;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (i4 < j.size()) {
                int i5 = i4 + 1;
                if (i5 >= i) {
                    int index = j.get(i4).getIndex() + 1;
                    j.get(i4).setIndex(index);
                    arrayList.add(j.get(i4).getAppKey());
                    arrayList2.add(Integer.valueOf(index));
                }
                i4 = i5;
            }
            boolean w = w(arrayList, arrayList2);
            if (!w) {
                if (aVar != null) {
                    aVar.b();
                }
                return false;
            }
            if (aVar != null) {
                aVar.a();
            }
            p();
            return w;
        }
    }

    public static void c(MatrixCursor matrixCursor, int i, d dVar) {
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), bVar.f44486b.f44471a).add(SwanAppDbControl.SwanAppTable.app_key.name(), bVar.f44486b.f44472b).add(SwanAppDbControl.SwanAppTable.version.name(), bVar.f44486b.q).add(SwanAppDbControl.SwanAppTable.description.name(), bVar.f44486b.f44473c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(bVar.f44486b.f44474d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), bVar.f44486b.f44475e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), bVar.f44486b.f44476f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), bVar.f44486b.f44477g).add(SwanAppDbControl.SwanAppTable.icon.name(), bVar.f44486b.f44478h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), bVar.f44486b.i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), bVar.f44486b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), bVar.f44486b.k).add(SwanAppDbControl.SwanAppTable.name.name(), bVar.f44486b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), bVar.f44486b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), bVar.f44486b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), bVar.f44486b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), bVar.f44486b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(bVar.f44486b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(bVar.f44486b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), bVar.f44486b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), bVar.f44486b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), bVar.f44486b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(bVar.f44486b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(bVar.f44486b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), bVar.f44486b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(bVar.f44486b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(bVar.f44486b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(bVar.f44486b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(bVar.f44486b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(bVar.f44486b.D ? 1 : 0)).add("favorite_time", Long.valueOf(bVar.f44489a.f44488b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(bVar.f44486b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), bVar.f44486b.F);
            return;
        }
        g gVar = (g) dVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), gVar.f44490b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), gVar.f44490b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(gVar.f44490b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), gVar.f44490b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(gVar.f44490b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), gVar.f44490b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), gVar.f44490b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), gVar.f44490b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), gVar.f44490b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), gVar.f44490b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), gVar.f44490b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), gVar.f44490b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), gVar.f44490b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(gVar.f44490b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(gVar.f44490b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(gVar.f44490b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), gVar.f44490b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(gVar.f44490b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(gVar.f44490b.i())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(gVar.f44490b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(gVar.f44490b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(gVar.f44489a.f44488b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(gVar.f44490b.payProtected)).add("customer_service", Integer.valueOf(gVar.f44490b.customerService)).add("global_notice", Integer.valueOf(gVar.f44490b.globalNotice)).add("global_private", Integer.valueOf(gVar.f44490b.globalPrivate)).add("pa_number", gVar.f44490b.paNumber).add("brand", gVar.f44490b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), gVar.f44490b.quickAppKey);
    }

    public static Uri d() {
        return d.b.g0.a.g0.c.b.f44492c.buildUpon().appendPath("favorite_and_aps").build();
    }

    public static Uri e() {
        return d.b.g0.a.g0.c.b.f44492c.buildUpon().appendPath("favorite").build();
    }

    public static Uri f() {
        return d.b.g0.a.g0.c.b.f44492c.buildUpon().appendPath("favorite_with_aps_pms").build();
    }

    public static boolean g(@NonNull String str, d.b.g0.a.m0.b.b bVar, b.C0708b c0708b) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.a();
            }
            return false;
        }
        d.b.g0.a.j0.j.c l = d.b.g0.a.j0.j.c.l(c0708b);
        l.h(3);
        b.C0708b j = l.j();
        if (AppRuntime.getAppContext().getContentResolver().delete(e(), "app_id = ?", new String[]{str}) > 0) {
            if (f44483a) {
                Log.d("SwanAppFavoriteHelper", "删除收藏，检查是否需要清理包");
            }
            if (!TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                if (ProcessUtils.isMainProcess()) {
                    d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
                    if (d2 != null) {
                        d2.e(str, true, j);
                    }
                } else if (d.b.g0.a.g0.d.b.i(AppRuntime.getAppContext().getContentResolver()).contains(str) || !TextUtils.equals(d.b.g0.a.r1.e.T(), str)) {
                    d.b.g0.a.n1.c.e.a C = d.b.g0.a.n1.c.e.a.C();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(str);
                    swanAppDeleteInfo.b(d.b.g0.a.j0.j.c.l(j).c());
                    C.M(8, swanAppDeleteInfo);
                }
            }
            if (f44483a) {
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

    public static boolean h(@NonNull SwanFavorItemData swanFavorItemData, int i) {
        Uri e2 = e();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, swanFavorItemData.getAppKey());
        contentValues.put("sort_index", Integer.valueOf(i));
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(DpStatConstants.KEY_APP_NAME, swanFavorItemData.getAppName());
        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
        if (AppRuntime.getAppContext().getContentResolver().insert(e2, contentValues) != null) {
            if (f44483a) {
                Log.d("SwanAppFavoriteHelper", "数据库收藏成功： " + swanFavorItemData.getAppKey());
            }
            d.b.g0.a.a2.g.b a2 = h.a();
            a2.putString("favorite_guide_count_" + swanFavorItemData.getAppKey(), "-1");
            return true;
        }
        return false;
    }

    public static boolean i(List<SwanFavorItemData> list) {
        if (list != null && list.size() > 0) {
            SQLiteDatabase writableDatabase = SwanAppDbControl.f(d.b.g0.a.w0.a.c()).h().getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                int i = 0;
                while (i < list.size()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.APP_ID, list.get(i).getAppKey());
                    int i2 = i + 1;
                    contentValues.put("sort_index", Integer.valueOf(i2));
                    contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(DpStatConstants.KEY_APP_NAME, list.get(i).getAppName());
                    contentValues.put("app_icon", list.get(i).getIconUrl());
                    contentValues.put("app_type", Integer.valueOf(list.get(i).getAppType()));
                    contentValues.put("frame_type", Integer.valueOf(list.get(i).getAppFrameType()));
                    if (writableDatabase.insertWithOnConflict("ai_apps_favorites", null, contentValues, 5) < 0) {
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception unused) {
                            }
                        }
                        return false;
                    }
                    i = i2;
                }
                if (f44483a) {
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
                if (f44483a) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        } finally {
            d.b.g0.p.d.a(k);
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
        if (f44483a) {
            Log.v("favorite_migrate_pms", "Favotite == " + swanFavorItemData.getAppKey());
        }
        if (TextUtils.isEmpty(swanFavorItemData.getAppName()) || TextUtils.isEmpty(swanFavorItemData.getIconUrl())) {
            List<d.b.g0.a.g0.a> r = r();
            if (r.size() > 0) {
                Iterator<d.b.g0.a.g0.a> it = r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.b.g0.a.g0.a next = it.next();
                    if (TextUtils.equals(swanFavorItemData.getAppKey(), next.f44471a)) {
                        swanFavorItemData.setAppKey(next.f44471a);
                        swanFavorItemData.setAppName(next.l);
                        swanFavorItemData.setIconUrl(next.i);
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
                    if (f44483a) {
                        e.printStackTrace();
                    }
                    z = z2;
                    if (f44483a) {
                    }
                    return z;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (f44483a) {
            Log.d("SwanAppFavoriteHelper", "小程序： " + str + "是否在收藏列表中：" + z);
        }
        return z;
    }

    public static boolean o(String str, int i, d.b.g0.a.m0.b.a aVar) {
        if (TextUtils.isEmpty(str) || i < 1) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        List<SwanFavorItemData> j = j();
        if (j.size() < i) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < j.size()) {
            int i3 = i2 + 1;
            if (i3 == i) {
                arrayList.add(str);
                arrayList2.add(Integer.valueOf(j.get(i2).getIndex()));
                if (!w(arrayList, arrayList2)) {
                    if (aVar != null) {
                        aVar.b();
                    }
                    return false;
                }
            }
            i2 = i3;
        }
        arrayList.clear();
        arrayList2.clear();
        int i4 = 0;
        while (i4 < j.size()) {
            int i5 = i4 + 1;
            if (i5 >= i && !TextUtils.equals(j.get(i4).getAppKey(), str)) {
                arrayList2.add(Integer.valueOf(j.get(i4).getIndex() + 1));
                arrayList.add(j.get(i4).getAppKey());
            }
            i4 = i5;
        }
        boolean w = w(arrayList, arrayList2);
        if (!w) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        if (aVar != null) {
            aVar.a();
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
                    if (f44483a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                d.b.g0.p.d.a(k);
            }
        }
    }

    @NonNull
    public static List<d.b.g0.a.g0.a> r() {
        ArrayList arrayList = new ArrayList();
        Cursor s = s();
        try {
            if (s != null) {
                try {
                    if (s.getCount() > 0) {
                        s.moveToFirst();
                        do {
                            d.b.g0.a.g0.a aVar = new d.b.g0.a.g0.a();
                            SwanAppDbControl.f(AppRuntime.getAppContext()).s(s, aVar);
                            if (!TextUtils.isEmpty(aVar.f44471a)) {
                                arrayList.add(aVar);
                            }
                        } while (s.moveToNext());
                    }
                } catch (Exception e2) {
                    if (f44483a) {
                        e2.printStackTrace();
                    }
                }
            }
            return arrayList;
        } finally {
            d.b.g0.p.d.a(s);
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
                d.b.g0.a.g0.a aVar = new d.b.g0.a.g0.a();
                SwanAppDbControl.f(AppRuntime.getAppContext()).s(query2, aVar);
                if (!TextUtils.isEmpty(aVar.f44471a)) {
                    b bVar = new b();
                    bVar.f44486b = aVar;
                    c cVar = bVar.f44489a;
                    cVar.f44487a = aVar.f44471a;
                    cVar.f44488b = query2.getLong(query2.getColumnIndex("favorite_time"));
                    hashMap.put(bVar.f44489a.f44487a, bVar);
                    if (f44483a) {
                        Log.v("favorite_migrate_pms", "Aps&Favotite == " + aVar.f44471a);
                    }
                }
            } while (query2.moveToNext());
            d.b.g0.p.d.a(query2);
            if (f44483a) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            d.b.g0.p.d.a(query);
            if (f44483a) {
            }
            ArrayList<d> arrayList = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f44483a) {
            }
            while (r1.hasNext()) {
            }
            if (f44483a) {
            }
            ArrayList<d> arrayList2 = new ArrayList(hashMap.values());
            Collections.sort(arrayList2, new e());
            MatrixCursor matrixCursor = new MatrixCursor(f44485c, 50);
            int i = 0;
            while (r1.hasNext()) {
            }
            return matrixCursor;
        }
        d.b.g0.p.d.a(query2);
        if (f44483a) {
            Log.d("favorite_migrate_pms", "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                c cVar2 = new c();
                cVar2.f44487a = query.getString(query.getColumnIndex(Constants.APP_ID));
                cVar2.f44488b = query.getLong(query.getColumnIndex("favorite_time"));
                hashMap22.put(cVar2.f44487a, cVar2);
                if (f44483a) {
                    Log.v("favorite_migrate_pms", "Favotite == " + cVar2.f44487a);
                }
            } while (query.moveToNext());
            d.b.g0.p.d.a(query);
            if (f44483a) {
            }
            ArrayList<d> arrayList3 = new ArrayList();
            while (r2.hasNext()) {
            }
            if (f44483a) {
            }
            while (r1.hasNext()) {
            }
            if (f44483a) {
            }
            ArrayList<d> arrayList22 = new ArrayList(hashMap.values());
            Collections.sort(arrayList22, new e());
            MatrixCursor matrixCursor2 = new MatrixCursor(f44485c, 50);
            int i2 = 0;
            while (r1.hasNext()) {
            }
            return matrixCursor2;
        }
        d.b.g0.p.d.a(query);
        if (f44483a) {
            Log.d("favorite_migrate_pms", "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏");
        }
        ArrayList<d> arrayList32 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(d.b.g0.l.i.a.h().s().values())) {
            if (f44483a) {
                Log.v("favorite_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            if (hashMap22.containsKey(pMSAppInfo.appId)) {
                g gVar = new g();
                gVar.f44489a = (c) hashMap22.get(pMSAppInfo.appId);
                gVar.f44490b = pMSAppInfo;
                arrayList32.add(gVar);
            }
        }
        if (f44483a) {
            Log.d("favorite_migrate_pms", "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏");
        }
        for (d dVar : arrayList32) {
            hashMap.put(dVar.f44489a.f44487a, dVar);
        }
        if (f44483a) {
            Log.d("favorite_migrate_pms", "合并后有 " + hashMap.size() + " 条收藏");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("favorite_migrate_pms", "Migrate == " + ((d) it.next()).f44489a.f44487a);
            }
        }
        ArrayList<d> arrayList222 = new ArrayList(hashMap.values());
        Collections.sort(arrayList222, new e());
        MatrixCursor matrixCursor22 = new MatrixCursor(f44485c, 50);
        int i22 = 0;
        for (d dVar2 : arrayList222) {
            c(matrixCursor22, i22, dVar2);
            i22++;
        }
        return matrixCursor22;
    }

    public static void t() {
        if (f44483a) {
            Log.d("SwanAppFavoriteHelper", "记录用户在小程序框架菜单中点击收藏");
        }
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, null);
    }

    public static void u() {
        int i = 1;
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
                            arrayList2.add(Integer.valueOf(i));
                            i++;
                        } while (query.moveToNext());
                        w(arrayList, arrayList2);
                    } catch (Exception e2) {
                        if (f44483a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.b.g0.p.d.a(query);
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
        if (AppRuntime.getAppContext().getContentResolver().update(e2, contentValues, "app_id = ?", strArr) <= 0 || !f44483a) {
            return;
        }
        Log.d("SwanAppFavoriteHelper", "更新收藏");
    }

    public static boolean w(List<String> list, List<Integer> list2) {
        if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
            SQLiteDatabase writableDatabase = SwanAppDbControl.f(d.b.g0.a.w0.a.c()).h().getWritableDatabase();
            writableDatabase.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                try {
                    String[] strArr = {list.get(i)};
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("sort_index", list2.get(i));
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
