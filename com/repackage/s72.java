package com.repackage;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import com.repackage.oa2;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class s72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Set<String> b;
    public static final String[] c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r72 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public long b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? Long.compare(dVar2.a.b, dVar.a.b) : invokeLL.intValue;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                int i = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0).getInt("aiapps_user_fav_count", 0);
                if (s72.a) {
                    Log.v("SwanAppFavoriteHelper", "delegate读取到的收藏次数：" + i);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fav_count", i);
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                SharedPreferences sharedPreferences = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0);
                int i = sharedPreferences.getInt("aiapps_user_fav_count", 0);
                if (s72.a) {
                    Log.v("SwanAppFavoriteHelper", "delegate当前收藏次数：" + i);
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                int i2 = i + 1;
                edit.putInt("aiapps_user_fav_count", i2);
                edit.commit();
                if (s72.a) {
                    Log.v("SwanAppFavoriteHelper", "delegate写入新收藏次数" + i2);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fav_count", i2);
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PMSAppInfo b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755367709, "Lcom/repackage/s72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755367709, "Lcom/repackage/s72;");
                return;
            }
        }
        a = eh1.a;
        b = Sets.newHashSet("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
        c = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", Constants.PHONE_BRAND, SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    public static boolean b(@NonNull SwanFavorItemData swanFavorItemData, int i, nc2 nc2Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, swanFavorItemData, i, nc2Var)) == null) {
            if (i < 0) {
                if (nc2Var != null) {
                    nc2Var.b(false);
                }
                return false;
            }
            List<SwanFavorItemData> j = j();
            if (j.size() == 0) {
                if (!h(swanFavorItemData, 1)) {
                    if (nc2Var != null) {
                        nc2Var.b(false);
                    }
                    return false;
                }
                if (nc2Var != null) {
                    nc2Var.c();
                }
                p();
                return true;
            } else if (j.size() + 1 == i) {
                if (!h(swanFavorItemData, j.get(j.size() - 1).getIndex() + 1)) {
                    if (nc2Var != null) {
                        nc2Var.b(false);
                    }
                    return false;
                }
                if (nc2Var != null) {
                    nc2Var.c();
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
                            if (nc2Var != null) {
                                nc2Var.b(false);
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
                    if (nc2Var != null) {
                        nc2Var.b(false);
                    }
                    return false;
                }
                if (nc2Var != null) {
                    nc2Var.c();
                }
                p();
                return w;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static void c(MatrixCursor matrixCursor, int i, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, null, matrixCursor, i, dVar) == null) {
            if (dVar instanceof b) {
                b bVar = (b) dVar;
                matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), bVar.b.a).add(SwanAppDbControl.SwanAppTable.app_key.name(), bVar.b.b).add(SwanAppDbControl.SwanAppTable.version.name(), bVar.b.q).add(SwanAppDbControl.SwanAppTable.description.name(), bVar.b.c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(bVar.b.d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), bVar.b.e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), bVar.b.f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), bVar.b.g).add(SwanAppDbControl.SwanAppTable.icon.name(), bVar.b.h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), bVar.b.i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), bVar.b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), bVar.b.k).add(SwanAppDbControl.SwanAppTable.name.name(), bVar.b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), bVar.b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), bVar.b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), bVar.b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), bVar.b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(bVar.b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(bVar.b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), bVar.b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), bVar.b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), bVar.b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(bVar.b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(bVar.b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), bVar.b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(bVar.b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(bVar.b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(bVar.b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(bVar.b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(bVar.b.D ? 1 : 0)).add("favorite_time", Long.valueOf(bVar.a.b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(bVar.b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), bVar.b.F);
                return;
            }
            h hVar = (h) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), hVar.b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), hVar.b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(hVar.b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), hVar.b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(hVar.b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), hVar.b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), hVar.b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), hVar.b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), hVar.b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), hVar.b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), hVar.b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), hVar.b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), hVar.b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(hVar.b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(hVar.b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(hVar.b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), hVar.b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(hVar.b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(hVar.b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(hVar.b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(hVar.b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(hVar.a.b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(hVar.b.payProtected)).add("customer_service", Integer.valueOf(hVar.b.customerService)).add("global_notice", Integer.valueOf(hVar.b.globalNotice)).add("global_private", Integer.valueOf(hVar.b.globalPrivate)).add("pa_number", hVar.b.paNumber).add(Constants.PHONE_BRAND, hVar.b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), hVar.b.quickAppKey);
        }
    }

    public static Uri d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? t72.c.buildUpon().appendPath("favorite_and_aps").build() : (Uri) invokeV.objValue;
    }

    public static Uri e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? t72.c.buildUpon().appendPath("favorite").build() : (Uri) invokeV.objValue;
    }

    public static Uri f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? t72.c.buildUpon().appendPath("favorite_with_aps_pms").build() : (Uri) invokeV.objValue;
    }

    public static boolean g(@NonNull String str, oc2 oc2Var, oa2.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, oc2Var, bVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (oc2Var != null) {
                    oc2Var.c(false);
                }
                return false;
            }
            pa2 m = pa2.m(bVar);
            m.i(3);
            oa2.b k = m.k();
            if (AppRuntime.getAppContext().getContentResolver().delete(e(), "app_id = ?", new String[]{str}) > 0) {
                if (a) {
                    Log.d("SwanAppFavoriteHelper", "删除收藏，检查是否需要清理包");
                }
                if (!TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                    if (ProcessUtils.isMainProcess()) {
                        e92 d2 = g92.c().d();
                        if (d2 != null) {
                            d2.e(str, true, k);
                        }
                    } else if (x72.i(AppRuntime.getAppContext().getContentResolver()).contains(str) || !TextUtils.equals(t03.J().r().N(), str)) {
                        px2.P().Z(8, new SwanAppDeleteInfo(str).setPurgerScenes(pa2.m(k).c()));
                    }
                }
                if (a) {
                    Log.d("SwanAppFavoriteHelper", "取消收藏成功： " + str);
                }
                p();
                if (oc2Var != null) {
                    oc2Var.b();
                }
            } else if (oc2Var != null) {
                oc2Var.c(false);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean h(@NonNull SwanFavorItemData swanFavorItemData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, swanFavorItemData, i)) == null) {
            Uri e2 = e();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", swanFavorItemData.getAppKey());
            contentValues.put("sort_index", Integer.valueOf(i));
            contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("app_name", swanFavorItemData.getAppName());
            contentValues.put("app_icon", swanFavorItemData.getIconUrl());
            contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
            contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
            contentValues.put("pay_protected", Integer.valueOf(swanFavorItemData.getPayProtected()));
            contentValues.put("is_new_favor", Integer.valueOf(swanFavorItemData.getIsNewFavor()));
            if (AppRuntime.getAppContext().getContentResolver().insert(e2, contentValues) != null) {
                if (a) {
                    Log.d("SwanAppFavoriteHelper", "数据库收藏成功： " + swanFavorItemData.getAppKey());
                }
                c93 a2 = i93.a();
                a2.putString("favorite_guide_count_" + swanFavorItemData.getAppKey(), "-1");
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static boolean i(List<SwanFavorItemData> list, HashMap<String, Integer> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, hashMap)) == null) {
            if (list != null && list.size() > 0) {
                SQLiteDatabase writableDatabase = SwanAppDbControl.f(bk2.c()).h().getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    int i = 0;
                    while (i < list.size()) {
                        ContentValues contentValues = new ContentValues();
                        SwanFavorItemData swanFavorItemData = list.get(i);
                        contentValues.put("app_id", swanFavorItemData.getAppKey());
                        i++;
                        contentValues.put("sort_index", Integer.valueOf(i));
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
                    if (a) {
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
        return invokeLL.booleanValue;
    }

    @NonNull
    public static List<SwanFavorItemData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
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
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                return arrayList;
            } finally {
                xg4.d(k);
            }
        }
        return (List) invokeV.objValue;
    }

    public static Cursor k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            u();
            return AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, "sort_index");
        }
        return (Cursor) invokeV.objValue;
    }

    public static SwanFavorItemData l(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cursor)) == null) {
            SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
            swanFavorItemData.setIndex(cursor.getInt(cursor.getColumnIndex("sort_index")));
            swanFavorItemData.setAppKey(cursor.getString(cursor.getColumnIndex("app_id")));
            swanFavorItemData.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
            swanFavorItemData.setIconUrl(cursor.getString(cursor.getColumnIndex("app_icon")));
            swanFavorItemData.setAppType(cursor.getInt(cursor.getColumnIndex("app_type")));
            swanFavorItemData.setAppFrameType(cursor.getInt(cursor.getColumnIndex("frame_type")));
            swanFavorItemData.setPayProtected(cursor.getInt(cursor.getColumnIndex("pay_protected")));
            swanFavorItemData.setIsNewFavor(cursor.getInt(cursor.getColumnIndex("is_new_favor")));
            if (a) {
                Log.v("favorite_migrate_pms", "Favotite == " + swanFavorItemData.getAppKey());
            }
            if (TextUtils.isEmpty(swanFavorItemData.getAppName()) || TextUtils.isEmpty(swanFavorItemData.getIconUrl())) {
                List<r72> r = r();
                if (r.size() > 0) {
                    Iterator<r72> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        r72 next = it.next();
                        if (TextUtils.equals(swanFavorItemData.getAppKey(), next.a)) {
                            swanFavorItemData.setAppKey(next.a);
                            swanFavorItemData.setAppName(next.l);
                            swanFavorItemData.setIconUrl(next.i);
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
        return (SwanFavorItemData) invokeL.objValue;
    }

    public static boolean m(List<SwanFavorItemData> list, String str, String str2, String str3, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{list, str, str2, str3, Integer.valueOf(i)})) == null) {
            if (list != null && list.size() > 0) {
                for (SwanFavorItemData swanFavorItemData : list) {
                    if (TextUtils.equals(str, swanFavorItemData.getAppKey()) && TextUtils.equals(str2, swanFavorItemData.getAppName()) && TextUtils.equals(str3, swanFavorItemData.getIconUrl()) && i == swanFavorItemData.getPayProtected()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r0.getCount() > 0) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
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
                        if (a) {
                            e.printStackTrace();
                        }
                        z = z2;
                        if (a) {
                        }
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (a) {
                Log.d("SwanAppFavoriteHelper", "小程序： " + str + "是否在收藏列表中：" + z);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str, int i, nc2 nc2Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, str, i, nc2Var)) == null) {
            if (TextUtils.isEmpty(str) || i < 1) {
                if (nc2Var != null) {
                    nc2Var.b(false);
                }
                return false;
            }
            List<SwanFavorItemData> j = j();
            if (j.size() < i) {
                if (nc2Var != null) {
                    nc2Var.b(false);
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
                        if (nc2Var != null) {
                            nc2Var.b(false);
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
                if (nc2Var != null) {
                    nc2Var.b(false);
                }
                return false;
            }
            if (nc2Var != null) {
                nc2Var.c();
            }
            p();
            return w;
        }
        return invokeLIL.booleanValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            AppRuntime.getAppContext().getContentResolver().notifyChange(e(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(d(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(f(), (ContentObserver) null, false);
        }
    }

    public static void q(List<SwanFavorItemData> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, list) == null) {
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
                        boolean moveToFirst = k.moveToFirst();
                        HashMap hashMap = new HashMap();
                        do {
                            z = true;
                            if (!moveToFirst) {
                                break;
                            }
                            String string = k.getString(k.getColumnIndex("app_id"));
                            String string2 = k.getString(k.getColumnIndex("app_icon"));
                            String string3 = k.getString(k.getColumnIndex("app_name"));
                            int i = k.getInt(k.getColumnIndex("pay_protected"));
                            hashMap.put(string, Integer.valueOf(k.getInt(k.getColumnIndex("is_new_favor"))));
                            if (!m(list, string, string3, string2, i)) {
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
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    xg4.d(k);
                }
            }
        }
    }

    @NonNull
    public static List<r72> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor s = s();
            if (s != null) {
                try {
                    try {
                        if (s.getCount() > 0) {
                            s.moveToFirst();
                            do {
                                r72 r72Var = new r72();
                                SwanAppDbControl.f(AppRuntime.getAppContext()).s(s, r72Var);
                                if (!TextUtils.isEmpty(r72Var.a)) {
                                    arrayList.add(r72Var);
                                }
                            } while (s.moveToNext());
                        }
                    } catch (Exception e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    xg4.d(s);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b0 A[LOOP:3: B:45:0x01aa->B:47:0x01b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x022f A[LOOP:5: B:55:0x0229->B:57:0x022f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor s() {
        InterceptResult invokeV;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            HashMap hashMap = new HashMap();
            Cursor query2 = AppRuntime.getAppContext().getContentResolver().query(d(), null, null, null, "favorite_time DESC");
            if (query2 != null && query2.moveToFirst()) {
                do {
                    r72 r72Var = new r72();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(query2, r72Var);
                    if (!TextUtils.isEmpty(r72Var.a)) {
                        b bVar = new b(null);
                        bVar.b = r72Var;
                        c cVar = bVar.a;
                        cVar.a = r72Var.a;
                        cVar.b = query2.getLong(query2.getColumnIndex("favorite_time"));
                        hashMap.put(bVar.a.a, bVar);
                        if (a) {
                            Log.v("favorite_migrate_pms", "Aps&Favotite == " + r72Var.a);
                        }
                    }
                } while (query2.moveToNext());
                xg4.d(query2);
                if (a) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                xg4.d(query);
                if (a) {
                }
                ArrayList<d> arrayList = new ArrayList();
                while (r2.hasNext()) {
                }
                if (a) {
                }
                while (r1.hasNext()) {
                }
                if (a) {
                }
                ArrayList<d> arrayList2 = new ArrayList(hashMap.values());
                Collections.sort(arrayList2, new e(null));
                MatrixCursor matrixCursor = new MatrixCursor(c, 50);
                int i = 0;
                while (r1.hasNext()) {
                }
                return matrixCursor;
            }
            xg4.d(query2);
            if (a) {
                Log.d("favorite_migrate_pms", "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏");
            }
            query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    c cVar2 = new c(null);
                    cVar2.a = query.getString(query.getColumnIndex("app_id"));
                    cVar2.b = query.getLong(query.getColumnIndex("favorite_time"));
                    hashMap22.put(cVar2.a, cVar2);
                    if (a) {
                        Log.v("favorite_migrate_pms", "Favotite == " + cVar2.a);
                    }
                } while (query.moveToNext());
                xg4.d(query);
                if (a) {
                }
                ArrayList<d> arrayList3 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (a) {
                }
                while (r1.hasNext()) {
                }
                if (a) {
                }
                ArrayList<d> arrayList22 = new ArrayList(hashMap.values());
                Collections.sort(arrayList22, new e(null));
                MatrixCursor matrixCursor2 = new MatrixCursor(c, 50);
                int i2 = 0;
                while (r1.hasNext()) {
                }
                return matrixCursor2;
            }
            xg4.d(query);
            if (a) {
                Log.d("favorite_migrate_pms", "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏");
            }
            ArrayList<d> arrayList32 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(p84.i().v().values())) {
                if (a) {
                    Log.v("favorite_migrate_pms", "Pms == " + pMSAppInfo.appId);
                }
                if (hashMap22.containsKey(pMSAppInfo.appId)) {
                    h hVar = new h(null);
                    hVar.a = (c) hashMap22.get(pMSAppInfo.appId);
                    hVar.b = pMSAppInfo;
                    arrayList32.add(hVar);
                }
            }
            if (a) {
                Log.d("favorite_migrate_pms", "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏");
            }
            for (d dVar : arrayList32) {
                hashMap.put(dVar.a.a, dVar);
            }
            if (a) {
                Log.d("favorite_migrate_pms", "合并后有 " + hashMap.size() + " 条收藏");
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    Log.v("favorite_migrate_pms", "Migrate == " + ((d) it.next()).a.a);
                }
            }
            ArrayList<d> arrayList222 = new ArrayList(hashMap.values());
            Collections.sort(arrayList222, new e(null));
            MatrixCursor matrixCursor22 = new MatrixCursor(c, 50);
            int i22 = 0;
            for (d dVar2 : arrayList222) {
                c(matrixCursor22, i22, dVar2);
                i22++;
            }
            return matrixCursor22;
        }
        return (Cursor) invokeV.objValue;
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            if (a) {
                Log.d("SwanAppFavoriteHelper", "记录用户在小程序框架菜单中点击收藏");
            }
            hx2.c(g.class, null);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            int i = 1;
            if (i93.a().getBoolean("key_first_sort", true)) {
                i93.a().putBoolean("key_first_sort", false);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, "favorite_time DESC");
                if (query != null) {
                    try {
                        try {
                            query.moveToFirst();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            do {
                                arrayList.add(query.getString(query.getColumnIndex("app_id")));
                                arrayList2.add(Integer.valueOf(i));
                                i++;
                            } while (query.moveToNext());
                            w(arrayList, arrayList2);
                        } catch (Exception e2) {
                            if (a) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        xg4.d(query);
                    }
                }
            }
        }
    }

    public static void v(@NonNull SwanFavorItemData swanFavorItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, swanFavorItemData) == null) || TextUtils.isEmpty(swanFavorItemData.getAppKey())) {
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
        if (AppRuntime.getAppContext().getContentResolver().update(e2, contentValues, "app_id = ?", strArr) <= 0 || !a) {
            return;
        }
        Log.d("SwanAppFavoriteHelper", "更新收藏");
    }

    public static boolean w(List<String> list, List<Integer> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, list, list2)) == null) {
            if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
                SQLiteDatabase writableDatabase = SwanAppDbControl.f(bk2.c()).h().getWritableDatabase();
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
        return invokeLL.booleanValue;
    }

    /* loaded from: classes7.dex */
    public static abstract class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new c(null);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
