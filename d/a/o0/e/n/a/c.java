package d.a.o0.e.n.a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends d.a.o0.e.n.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f49684a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f49685a;

        /* renamed from: b  reason: collision with root package name */
        public String f49686b;

        /* renamed from: c  reason: collision with root package name */
        public long f49687c;

        public b(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49685a = str;
            this.f49686b = str2;
            this.f49687c = j;
        }
    }

    /* renamed from: d.a.o0.e.n.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1044c implements Comparator<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1044c() {
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
        public int compare(b bVar, b bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) ? Long.compare(bVar2.f49687c, bVar.f49687c) : invokeLL.intValue;
        }

        public /* synthetic */ C1044c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1477516890, "Ld/a/o0/e/n/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1477516890, "Ld/a/o0/e/n/a/c;");
                return;
            }
        }
        f49684a = new String[]{"_id", "app_id", "app_key", "app_sign", "version_code", "version_name", "description", "app_status", "status_detail", "status_desc", "resume_date", "icon_url", "app_name", "service_category", "subject_info", "type", "pkg_size", "app_category", "orientation", "create_time", "app_from", "visit_time"};
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.o0.e.n.a.a
    @Nullable
    public Cursor c(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, uri, strArr, str, strArr2, str2)) == null) {
            List<b> f2 = f();
            if (f2.isEmpty()) {
                return null;
            }
            HashMap<String, PMSAppInfo> a2 = d.a.o0.e.n.b.a.a();
            if (a2.isEmpty()) {
                return null;
            }
            Collections.sort(f2, new C1044c(null));
            MatrixCursor matrixCursor = new MatrixCursor(f49684a, f2.size());
            int i2 = 0;
            for (b bVar : f2) {
                PMSAppInfo pMSAppInfo = a2.get(bVar.f49685a);
                if (pMSAppInfo != null) {
                    e(matrixCursor, i2, bVar, pMSAppInfo);
                    i2++;
                }
            }
            return matrixCursor;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public final void e(MatrixCursor matrixCursor, int i2, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrixCursor, i2, bVar, pMSAppInfo) == null) || matrixCursor == null || i2 < 0 || bVar == null || pMSAppInfo == null) {
            return;
        }
        matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add("app_id", pMSAppInfo.appId).add("app_key", pMSAppInfo.appKey).add("app_sign", Long.valueOf(pMSAppInfo.appSign)).add("version_code", Long.valueOf(pMSAppInfo.versionCode)).add("version_name", pMSAppInfo.versionName).add("description", pMSAppInfo.description).add("app_status", Integer.valueOf(pMSAppInfo.appStatus)).add("status_detail", pMSAppInfo.statusDetail).add("status_desc", pMSAppInfo.statusDesc).add("resume_date", pMSAppInfo.resumeDate).add("icon_url", pMSAppInfo.iconUrl).add("app_name", pMSAppInfo.appName).add("service_category", pMSAppInfo.serviceCategory).add("subject_info", pMSAppInfo.subjectInfo).add("type", Integer.valueOf(pMSAppInfo.type)).add("pkg_size", Long.valueOf(pMSAppInfo.pkgSize)).add("app_category", Integer.valueOf(pMSAppInfo.appCategory)).add("orientation", Integer.valueOf(pMSAppInfo.getOrientation())).add("create_time", Long.valueOf(pMSAppInfo.createTime)).add("app_from", bVar.f49686b).add("visit_time", Long.valueOf(bVar.f49687c));
    }

    public final List<b> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Cursor n = SwanAppDbControl.f(AppRuntime.getAppContext()).n(null, null, null, null);
            ArrayList arrayList = new ArrayList();
            if (n != null && n.moveToFirst()) {
                int columnIndex = n.getColumnIndex("app_id");
                int columnIndex2 = n.getColumnIndex("app_from");
                int columnIndex3 = n.getColumnIndex("visit_time");
                do {
                    arrayList.add(new b(n.getString(columnIndex), n.getString(columnIndex2), n.getLong(columnIndex3)));
                } while (n.moveToNext());
                d.a.o0.t.d.d(n);
                return arrayList;
            }
            d.a.o0.t.d.d(n);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
