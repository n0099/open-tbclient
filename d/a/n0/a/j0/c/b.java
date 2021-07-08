package d.a.n0.a.j0.c;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import d.a.n0.a.c2.f.h0.a;
import d.a.n0.a.k;
import d.a.n0.a.k2.g.h;
import d.a.n0.a.n0.l.b;
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
/* loaded from: classes7.dex */
public class b implements d.a.n0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45685e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f45686f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public static AtomicLong f45687g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f45688h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements h.n.b<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f45689e;

        public a(a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45689e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cursor) == null) {
                if (cursor == null || !cursor.moveToFirst()) {
                    if (b.f45685e) {
                        Log.d("SwanAppHistoryHelper", "historyList == null || historyList.size() == 0");
                    }
                    d.a.n0.a.i1.e.a.a(cursor);
                    this.f45689e.a(null);
                    return;
                }
                this.f45689e.a(b.j(cursor));
            }
        }
    }

    /* renamed from: d.a.n0.a.j0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0789b implements h.n.f<String, Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0789b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Cursor call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b.l() : (Cursor) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public d.a.n0.a.j0.a f45690b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? Long.compare(dVar2.f45691a.f48143e, dVar.f45691a.f48143e) : invokeLL.intValue;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f45692b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2093057272, "Ld/a/n0/a/j0/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2093057272, "Ld/a/n0/a/j0/c/b;");
                return;
            }
        }
        f45685e = k.f45831a;
        f45686f = Sets.newHashSet();
        f45688h = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable d.a.n0.a.w0.b bVar, b.C0831b c0831b) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, contentResolver, bVar, c0831b)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f48139a)) {
                return false;
            }
            if (f45685e) {
                Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.f48141c + " / " + bVar.f48139a);
            }
            if (k(bVar.f48139a)) {
                if (f45685e) {
                    Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
                }
                return false;
            }
            if (TextUtils.equals(String.valueOf(1), bVar.f48145g)) {
                String str = bVar.f48139a;
                d.a.n0.a.n0.l.c m = d.a.n0.a.n0.l.c.m(c0831b);
                m.i(1);
                g(contentResolver, str, m.k());
            }
            Uri a2 = d.a.n0.a.j0.c.a.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", bVar.f48139a);
            contentValues.put("visit_time", Long.valueOf(bVar.f48143e));
            contentValues.put("app_from", bVar.f48147i);
            contentValues.put("app_name", bVar.f48141c);
            contentValues.put("app_key", bVar.f48140b);
            contentValues.put("version_code", bVar.j);
            contentValues.put("app_icon", bVar.f48142d);
            contentValues.put("frame_type", Integer.valueOf(bVar.f48144f));
            contentValues.put("app_type", bVar.f48145g);
            contentValues.put("pay_protected", Integer.valueOf(bVar.f48146h));
            contentValues.put("sync_state", (Integer) 0);
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a2, contentValues);
                if (f45685e) {
                    String uri = insert == null ? "NULL" : insert.toString();
                    Log.d("SwanAppHistoryHelper", "Add history: newUri - " + uri);
                }
                if (e()) {
                    String str2 = bVar.f48139a;
                    d.a.n0.a.n0.l.c m2 = d.a.n0.a.n0.l.c.m(c0831b);
                    m2.i(2);
                    r(contentResolver, str2, m2.k());
                }
                return insert != null;
            } catch (Exception e2) {
                d.a.n0.a.h0.a.f(a2.toString(), bVar.f48139a, e2.toString());
                if (f45685e) {
                    Log.e("SwanAppHistoryHelper", "encounter error while adding swan history" + e2.toString());
                    throw new RuntimeException("encounter error while adding swan history, only throw in debug mode", e2);
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void d(MatrixCursor matrixCursor, int i2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, matrixCursor, i2, dVar) == null) {
            if (dVar instanceof c) {
                c cVar = (c) dVar;
                matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), cVar.f45690b.f45661a).add(SwanAppDbControl.SwanAppTable.app_key.name(), cVar.f45690b.f45662b).add(SwanAppDbControl.SwanAppTable.version.name(), cVar.f45690b.q).add(SwanAppDbControl.SwanAppTable.description.name(), cVar.f45690b.f45663c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(cVar.f45690b.f45664d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), cVar.f45690b.f45665e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), cVar.f45690b.f45666f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), cVar.f45690b.f45667g).add(SwanAppDbControl.SwanAppTable.icon.name(), cVar.f45690b.f45668h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), cVar.f45690b.f45669i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), cVar.f45690b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), cVar.f45690b.k).add(SwanAppDbControl.SwanAppTable.name.name(), cVar.f45690b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), cVar.f45690b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), cVar.f45690b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), cVar.f45690b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), cVar.f45690b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(cVar.f45690b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(cVar.f45690b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), cVar.f45690b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), cVar.f45690b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), cVar.f45690b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(cVar.f45690b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(cVar.f45690b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), cVar.f45690b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(cVar.f45690b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(cVar.f45690b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(cVar.f45690b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(cVar.f45690b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(cVar.f45690b.D ? 1 : 0)).add("app_from", cVar.f45691a.f48147i).add("visit_time", Long.valueOf(cVar.f45691a.f48143e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(cVar.f45690b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), cVar.f45690b.F);
                return;
            }
            f fVar = (f) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.f45691a.f48139a).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.f45692b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(fVar.f45692b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.f45692b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.f45692b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.f45692b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.f45692b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.f45692b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.f45691a.f48142d).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.f45691a.f48141c).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.f45692b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.f45692b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.f45692b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.f45692b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.f45692b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.f45692b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.f45692b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.f45692b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.f45692b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.f45692b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.f45692b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", fVar.f45691a.f48147i).add("visit_time", Long.valueOf(fVar.f45691a.f48143e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(fVar.f45692b.payProtected)).add("customer_service", Integer.valueOf(fVar.f45692b.customerService)).add("global_notice", Integer.valueOf(fVar.f45692b.globalNotice)).add("global_private", Integer.valueOf(fVar.f45692b.globalPrivate)).add("pa_number", fVar.f45692b.paNumber).add("brand", fVar.f45692b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), fVar.f45692b.quickAppKey);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f45687g != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f45687g.get() > 86400000) {
                    f45687g.set(currentTimeMillis);
                    h.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                    return true;
                }
                return false;
            }
            synchronized (h.class) {
                if (f45687g == null) {
                    f45687g = new AtomicLong(h.a().getLong("key_check_delete_swan_history", 0L));
                    return e();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean f(ContentResolver contentResolver, String str, boolean z, b.C0831b c0831b) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        d.a.n0.a.n0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{contentResolver, str, Boolean.valueOf(z), c0831b})) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Cursor query = contentResolver.query(d.a.n0.a.j0.c.a.a(), null, "app_id=?", new String[]{str}, null);
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
            d.a.n0.t.d.d(query);
            boolean z2 = contentResolver.delete(d.a.n0.a.j0.c.a.a(), "app_id=?", new String[]{str}) > 0;
            if (z && z2 && (d2 = d.a.n0.a.n0.f.c().d()) != null) {
                d.a.n0.a.n0.l.c m = d.a.n0.a.n0.l.c.m(c0831b);
                m.i(4);
                d2.e(str, true, m.k());
            }
            if (f45685e) {
                Log.d("SwanAppHistoryHelper", "deleteHistory: " + str + " isSuccess: " + z2);
            }
            if (z2) {
                d.a.n0.a.w0.c.e("DEL", str, System.currentTimeMillis(), str4, str2, str3, null);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0831b c0831b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, contentResolver, str, c0831b) == null) {
            if (f45685e) {
                Log.d("SwanAppHistoryHelper", "start deleteOtherDevHistory: ");
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String a2 = d.a.n0.a.v.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            List<String> q = q(contentResolver, str);
            if (q != null && q.size() != 0) {
                d.a.n0.a.n0.d d2 = d.a.n0.a.n0.f.c().d();
                if (d2 != null) {
                    if (f45685e) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                    }
                    d2.g(q, false, false, c0831b);
                }
                if (f45685e) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
                }
                contentResolver.delete(d.a.n0.a.j0.c.a.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
            } else if (f45685e) {
                Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
            }
        }
    }

    @NonNull
    public static Set<String> h(@NonNull ContentResolver contentResolver) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, contentResolver)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = contentResolver.query(d.a.n0.a.j0.c.a.a(), null, null, null, null);
                } catch (Exception e2) {
                    if (f45685e) {
                        e2.printStackTrace();
                    }
                    if (f45685e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f45685e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        Log.d("SwanAppHistoryHelper", sb.toString());
                    }
                    d.a.n0.t.d.d(cursor);
                    return hashSet;
                }
                if (f45685e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                d.a.n0.t.d.d(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f45685e && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                d.a.n0.t.d.d(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static void i(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, cVar) == null) || cVar == null) {
            return;
        }
        h.d.i("").D(Schedulers.io()).k(new C0789b()).o(h.l.b.a.b()).B(new a(cVar));
    }

    @NonNull
    public static JSONObject j(Cursor cursor) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cursor)) == null) {
            JSONArray jSONArray = new JSONArray();
            do {
                JSONObject jSONObject = new JSONObject();
                try {
                    String string = cursor.getString(cursor.getColumnIndex("app_id"));
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
                        str = String.format(d.a.n0.a.c2.f.h0.a.f43675d, string);
                    } else {
                        str = d.a.n0.a.c2.f.h0.a.f43674c + string + "\"}";
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
            d.a.n0.a.i1.e.a.a(cursor);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("history", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (f45685e) {
                Log.d("SwanAppHistoryHelper", "historyCursorToJson : " + jSONObject2.toString());
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            return f45686f.contains(str);
        }
        return invokeL.booleanValue;
    }

    public static Cursor l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? m(null, null) : (Cursor) invokeV.objValue;
    }

    public static Cursor m(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, strArr)) == null) {
            return AppRuntime.getAppContext().getContentResolver().query(d.a.n0.a.j0.c.a.a(), null, str, strArr, "visit_time desc  LIMIT 200");
        }
        return (Cursor) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0206 A[LOOP:3: B:50:0x0200->B:52:0x0206, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02ae A[LOOP:5: B:67:0x02a8->B:69:0x02ae, LOOP_END] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor n(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Cursor query;
        List<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, str, i2)) == null) {
            HashMap hashMap = new HashMap();
            Cursor o = o(AppRuntime.getAppContext().getContentResolver(), str);
            if (o != null && o.moveToFirst()) {
                do {
                    d.a.n0.a.j0.a aVar = new d.a.n0.a.j0.a();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(o, aVar);
                    if (!TextUtils.isEmpty(aVar.f45661a)) {
                        c cVar = new c(null);
                        cVar.f45690b = aVar;
                        d.a.n0.a.w0.b bVar = cVar.f45691a;
                        bVar.f48139a = aVar.f45661a;
                        bVar.f48139a = o.getString(o.getColumnIndex("app_from"));
                        cVar.f45691a.f48143e = o.getLong(o.getColumnIndex("visit_time"));
                        hashMap.put(cVar.f45691a.f48139a, cVar);
                        if (f45685e) {
                            Log.v("history_migrate_pms", "Aps&History == " + aVar.f45661a);
                        }
                    }
                } while (o.moveToNext());
                d.a.n0.t.d.d(o);
                if (f45685e) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(d.a.n0.a.j0.c.a.a(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                d.a.n0.t.d.d(query);
                if (f45685e) {
                }
                ArrayList<d> arrayList2 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f45685e) {
                }
                while (r13.hasNext()) {
                }
                if (f45685e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i3 = 0;
                if (i2 > 0) {
                }
                MatrixCursor matrixCursor = new MatrixCursor(f45688h, 50);
                while (r13.hasNext()) {
                }
                return matrixCursor;
            }
            d.a.n0.t.d.d(o);
            if (f45685e) {
                Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
            }
            query = AppRuntime.getAppContext().getContentResolver().query(d.a.n0.a.j0.c.a.a(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    d.a.n0.a.w0.b bVar2 = new d.a.n0.a.w0.b();
                    bVar2.f48139a = query.getString(query.getColumnIndex("app_id"));
                    bVar2.f48147i = query.getString(query.getColumnIndex("app_from"));
                    bVar2.f48143e = query.getLong(query.getColumnIndex("visit_time"));
                    bVar2.f48141c = query.getString(query.getColumnIndex("app_name"));
                    bVar2.f48140b = query.getString(query.getColumnIndex("app_key"));
                    bVar2.j = query.getString(query.getColumnIndex("version_code"));
                    bVar2.f48142d = query.getString(query.getColumnIndex("app_icon"));
                    bVar2.f48144f = query.getInt(query.getColumnIndex("frame_type"));
                    hashMap22.put(bVar2.f48139a, bVar2);
                    if (f45685e) {
                        Log.v("history_migrate_pms", "History == " + bVar2.f48139a);
                    }
                } while (query.moveToNext());
                d.a.n0.t.d.d(query);
                if (f45685e) {
                }
                ArrayList<d> arrayList22 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f45685e) {
                }
                while (r13.hasNext()) {
                }
                if (f45685e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i32 = 0;
                if (i2 > 0) {
                    arrayList = arrayList.subList(0, i2);
                    if (f45685e) {
                    }
                }
                MatrixCursor matrixCursor2 = new MatrixCursor(f45688h, 50);
                while (r13.hasNext()) {
                }
                return matrixCursor2;
            }
            d.a.n0.t.d.d(query);
            if (f45685e) {
                Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
            }
            ArrayList<d> arrayList222 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(d.a.n0.n.g.a.h().t().values())) {
                if (f45685e) {
                    Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
                }
                String str2 = pMSAppInfo.appName;
                if (str2 != null && str2.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                    f fVar = new f(null);
                    fVar.f45691a = (d.a.n0.a.w0.b) hashMap22.get(pMSAppInfo.appId);
                    fVar.f45692b = pMSAppInfo;
                    arrayList222.add(fVar);
                }
            }
            if (f45685e) {
                Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
            }
            for (d dVar : arrayList222) {
                hashMap.put(dVar.f45691a.f48139a, dVar);
            }
            if (f45685e) {
                Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    Log.v("history_migrate_pms", "Migrate == " + ((d) it.next()).f45691a.f48139a);
                }
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new e(null));
            int i322 = 0;
            if (i2 > 0 && i2 < arrayList.size()) {
                arrayList = arrayList.subList(0, i2);
                if (f45685e) {
                    Log.d("history_migrate_pms", "Limit限制 " + i2 + " 条");
                }
            }
            MatrixCursor matrixCursor22 = new MatrixCursor(f45688h, 50);
            for (d dVar2 : arrayList) {
                d(matrixCursor22, i322, dVar2);
                i322++;
            }
            return matrixCursor22;
        }
        return (Cursor) invokeLI.objValue;
    }

    @Nullable
    public static Cursor o(@NonNull ContentResolver contentResolver, @NonNull String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, contentResolver, str)) == null) {
            try {
                cursor = contentResolver.query(d.a.n0.a.j0.c.a.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 200");
            } catch (Exception e2) {
                if (f45685e) {
                    e2.printStackTrace();
                }
                cursor = null;
            }
            if (f45685e && cursor != null) {
                Log.d("SwanAppHistoryHelper", "queryHistoryByKeyword: keyword[" + str + "]  Cursor count: " + cursor.getCount());
            }
            return cursor;
        }
        return (Cursor) invokeLL.objValue;
    }

    public static Set<String> p(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, sQLiteDatabase)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("ai_apps_history", null, null, null, null, null, null);
                } catch (Exception e2) {
                    if (f45685e) {
                        e2.printStackTrace();
                    }
                    if (f45685e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f45685e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        Log.d("SwanAppHistoryHelper", sb.toString());
                    }
                    d.a.n0.a.i1.e.a.a(cursor);
                    return hashSet;
                }
                if (f45685e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                d.a.n0.a.i1.e.a.a(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f45685e && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                d.a.n0.a.i1.e.a.a(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0089 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    @Nullable
    public static List<String> q(@NonNull ContentResolver contentResolver, @Nullable String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65553, null, contentResolver, str)) != null) {
            return (List) invokeLL.objValue;
        }
        ?? r1 = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String a2 = d.a.n0.a.v.a.a(str);
                if (TextUtils.isEmpty(a2)) {
                    d.a.n0.t.d.d(null);
                    return null;
                }
                cursor = contentResolver.query(d.a.n0.a.j0.c.a.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 200");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("app_id"));
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } while (cursor.moveToNext());
                            d.a.n0.t.d.d(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f45685e) {
                            e.printStackTrace();
                        }
                        d.a.n0.t.d.d(cursor);
                        return null;
                    }
                }
                d.a.n0.t.d.d(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                d.a.n0.t.d.d(r1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = contentResolver;
        }
    }

    @WorkerThread
    public static void r(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0831b c0831b) {
        int i2;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, contentResolver, str, c0831b) == null) {
            Cursor cursor = null;
            if (str == null) {
                str = "";
            }
            try {
                try {
                    query = contentResolver.query(d.a.n0.a.j0.c.a.a(), null, "app_id != ?", new String[]{str, String.valueOf(200)}, "visit_time DESC limit ?,-1");
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
                        String string = query.getString(query.getColumnIndex("app_id"));
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    }
                }
                if (f45685e) {
                    Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str);
                }
                if (arrayList.isEmpty()) {
                    d.a.n0.t.d.d(query);
                    return;
                }
                d.a.n0.a.n0.d d2 = d.a.n0.a.n0.f.c().d();
                if (d2 != null) {
                    d2.f(arrayList, false, c0831b);
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
                int delete = contentResolver.delete(d.a.n0.a.j0.c.a.a(), str2, null);
                if (f45685e) {
                    Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
                }
                d.a.n0.t.d.d(query);
            } catch (Exception e3) {
                e = e3;
                cursor = query;
                if (f45685e) {
                    Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
                }
                d.a.n0.t.d.d(cursor);
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                d.a.n0.t.d.d(cursor);
                throw th;
            }
        }
    }

    public static void s(ContentResolver contentResolver, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, null, contentResolver, str, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", Integer.valueOf(i2));
            contentResolver.update(d.a.n0.a.j0.c.a.a(), contentValues, "app_id=?", new String[]{str});
        }
    }

    public static void t(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, sQLiteDatabase) == null) {
            sQLiteDatabase.beginTransaction();
            try {
                for (String str : p(sQLiteDatabase)) {
                    PMSAppInfo s = d.a.n0.n.g.a.h().s(str);
                    if (s != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_name", s.appName);
                        contentValues.put("app_icon", s.iconUrl);
                        contentValues.put("frame_type", Integer.valueOf(s.appCategory));
                        contentValues.put("app_type", String.valueOf(s.type));
                        contentValues.put("sync_state", (Integer) 0);
                        if (sQLiteDatabase.updateWithOnConflict("ai_apps_history", contentValues, "app_id=?", new String[]{str}, 5) <= 0) {
                            if (f45685e) {
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
    }

    /* loaded from: classes7.dex */
    public static abstract class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.a.w0.b f45691a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45691a = new d.a.n0.a.w0.b();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
