package d.a.q0.a.l1.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a1.e;
import d.a.q0.a.k;
import d.a.q0.a.k2.g.h;
import d.a.q0.n.h.f;
import d.a.q0.n.h.g;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49306a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() && TextUtils.isDigitsOnly(file.getName()) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-10995532, "Ld/a/q0/a/l1/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-10995532, "Ld/a/q0/a/l1/d/c;");
                return;
            }
        }
        f49306a = k.f49133a;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(e.g(), str);
        if (file.exists()) {
            if (f49306a) {
                Log.d("PkgInfoExt", "clear all pkg info's ext ,appId - " + str);
            }
            File[] listFiles = file.listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                b(str, file2.getName());
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            String e2 = e(str, str2);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            h.a().edit().remove(e2).apply();
            if (f49306a) {
                Log.d("PkgInfoExt", "clear pkg info's ext , appId - " + str + ", version code - " + str2);
            }
        }
    }

    public static String c(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pMSAppInfo)) == null) ? d(pMSAppInfo.appId, pMSAppInfo.versionCode) : (String) invokeL.objValue;
    }

    public static String d(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65540, null, str, j)) == null) ? e(str, String.valueOf(j)) : (String) invokeLJ.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return str + "_" + str2 + "_pkg_info_ext";
            } else if (f49306a) {
                Log.e("PkgInfoExt", "appId or version code is empty");
                Log.d("PkgInfoExt", "appId - " + str);
                Log.d("PkgInfoExt", "version code - " + str2);
                return null;
            } else {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String f(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                return "";
            }
            String c2 = c(pMSAppInfo);
            if (TextUtils.isEmpty(c2)) {
                return "";
            }
            String string = h.a().getString(c2, "");
            if (f49306a) {
                Log.d("PkgInfoExt", "appId - " + pMSAppInfo.appId + ", get pkg info' ext - " + string);
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public static void g(String str, JSONObject jSONObject, f fVar, List<g> list) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, str, jSONObject, fVar, list) == null) {
            if (jSONObject == null) {
                if (f49306a) {
                    Log.d("PkgInfoExt", "pkgObject from pms is null");
                }
            } else if (fVar == null && list == null) {
                if (f49306a) {
                    Log.d("PkgInfoExt", "pkg info's ext must has at lest one main or sub pkg");
                }
            } else {
                String str2 = null;
                if (fVar != null) {
                    str = fVar.f53938g;
                    j = fVar.f53940i;
                    str2 = fVar.p;
                } else if (list.size() > 0) {
                    g gVar = list.get(0);
                    j = gVar.f53940i;
                    str2 = gVar.s;
                } else {
                    j = -1;
                }
                if (str2 == null) {
                    if (f49306a) {
                        Log.e("PkgInfoExt", "can not get ext from pkg ");
                    }
                } else if (!TextUtils.isEmpty(str) && j != -1) {
                    h.a().edit().putString(d(str, j), str2).apply();
                } else if (f49306a) {
                    Log.e("PkgInfoExt", "can not get appId and version code from pkg ");
                }
            }
        }
    }
}
