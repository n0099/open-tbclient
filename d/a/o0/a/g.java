package d.a.o0.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static String A = "tab_name";
    public static String B = "maintablocate";
    public static String C = "maintab_subtab";
    public static String D = "newgod_from";
    public static String E = "field_id";
    public static String F = "chushou_third_live_type";
    public static String G = "chuchou_third_room_id";
    public static String H = "yy_url";
    public static String I = "hotTrend";
    public static String J = "tab_id";
    public static String K = "param_uri";
    public static String L = "forumId";
    public static String M = "item_id";
    public static String N = "itemId";
    public static String O = "sortType";
    public static String P = "rankType";
    public static String Q = "rankCode";
    public static String R = "homeTabName";
    public static String S = "tabId";
    public static String T = "from_tb_token";

    /* renamed from: a  reason: collision with root package name */
    public static String f51334a = "com.baidu.tieba";

    /* renamed from: b  reason: collision with root package name */
    public static String f51335b = "unidispatch";

    /* renamed from: c  reason: collision with root package name */
    public static String f51336c = "/homepage";

    /* renamed from: d  reason: collision with root package name */
    public static String f51337d = "/enterforum";

    /* renamed from: e  reason: collision with root package name */
    public static String f51338e = "/recommendforum";

    /* renamed from: f  reason: collision with root package name */
    public static String f51339f = "/frs";

    /* renamed from: g  reason: collision with root package name */
    public static String f51340g = "/pb";

    /* renamed from: h  reason: collision with root package name */
    public static String f51341h = "/tbwebview";

    /* renamed from: i  reason: collision with root package name */
    public static String f51342i = "/usercenter";
    public static String j = "/topicdetail";
    public static String k = "/tiebachushou";
    public static String l = "/tiebayy";
    public static String m = "/activitypage";
    public static String n = "extdata";
    public static String o = "kw";
    public static String p = "tid";
    public static String q = "ori_ugc_nid";
    public static String r = "ori_ugc_tid";
    public static String s = "ori_ugc_type";
    public static String t = "ori_ugc_vid";
    public static String u = "portrait";
    public static String v = "topic_id";
    public static String w = "url";
    public static String x = "schemefrom";
    public static String y = "from";
    public static String z = "token";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f51343a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(154957964, "Ld/a/o0/a/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(154957964, "Ld/a/o0/a/g$c;");
                    return;
                }
            }
            f51343a = new g(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-799837845, "Ld/a/o0/a/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-799837845, "Ld/a/o0/a/g;");
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static final g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f51343a : (g) invokeV.objValue;
    }

    public static boolean c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) ? uri != null && f51334a.equals(uri.getScheme()) && f51335b.equals(uri.getHost()) : invokeL.booleanValue;
    }

    public final void a(String str, Uri uri, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, uri, str2) == null) {
            if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !StringHelper.equals(str2, T)) {
                TiebaStatic.log(new StatisticItem("c13391").param("obj_type", uri.getQueryParameter("obj_type")).param("obj_source", uri.getQueryParameter("obj_source")));
            }
            if (str == null || str.contains("tbwebview") || uri == null) {
                return;
            }
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
                return;
            }
            UtilHelper.clearClipBoard();
        }
    }

    public void d(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, bVar) == null) && uri != null && c(uri) && f51339f.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = o;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = J;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = p;
            hashMap.put(str3, uri.getQueryParameter(str3));
            l(uri.getQueryParameter(y));
            String queryParameter = uri.getQueryParameter(n);
            String queryParameter2 = uri.getQueryParameter(x);
            k(queryParameter, queryParameter2, uri.getQueryParameter(z), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, bVar) == null) && uri != null && c(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(n);
            String queryParameter2 = uri.getQueryParameter(x);
            String queryParameter3 = uri.getQueryParameter(z);
            String queryParameter4 = uri.getQueryParameter(A);
            k(queryParameter, queryParameter2, queryParameter3, uri);
            l(uri.getQueryParameter(y));
            a("", uri, queryParameter2);
            x.c(uri);
            if (f51336c.equals(uri.getPath())) {
                hashMap.put(B, 2);
                String str = D;
                hashMap.put(str, uri.getQueryParameter(str));
                String str2 = E;
                hashMap.put(str2, uri.getQueryParameter(str2));
                hashMap.put(A, queryParameter4);
            } else if (f51337d.equals(uri.getPath())) {
                hashMap.put(B, 1);
                hashMap.put(C, queryParameter4);
            } else if (f51338e.equals(uri.getPath())) {
                hashMap.put(B, 1);
                hashMap.put(C, "1_recommend");
            } else if (m.equals(uri.getPath())) {
                hashMap.put(B, 2);
                hashMap.put(A, queryParameter4);
            }
            bVar.onCallBack(hashMap);
        }
    }

    public void f(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, uri, bVar) == null) && uri != null && c(uri) && f51340g.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = p;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = q;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = r;
            hashMap.put(str3, uri.getQueryParameter(str3));
            String str4 = s;
            hashMap.put(str4, uri.getQueryParameter(str4));
            String str5 = t;
            hashMap.put(str5, uri.getQueryParameter(str5));
            l(uri.getQueryParameter(y));
            String queryParameter = uri.getQueryParameter(n);
            String queryParameter2 = uri.getQueryParameter(x);
            k(queryParameter, queryParameter2, uri.getQueryParameter(z), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void g(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, uri, bVar) == null) && uri != null && c(uri) && j.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = v;
            hashMap.put(str, uri.getQueryParameter(str));
            l(uri.getQueryParameter(y));
            k(uri.getQueryParameter(n), uri.getQueryParameter(x), uri.getQueryParameter(z), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void h(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, uri, bVar) == null) && uri != null && c(uri) && f51342i.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = u;
            hashMap.put(str, uri.getQueryParameter(str));
            k(uri.getQueryParameter(n), uri.getQueryParameter(x), uri.getQueryParameter(z), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void i(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, uri) == null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("is_new_schema");
        if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
            return;
        }
        UtilHelper.clearClipBoard();
    }

    public void j(String str, Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, uri, bVar) == null) && uri != null && c(uri) && f51341h.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str2 = w;
            hashMap.put(str2, uri.getQueryParameter(str2));
            hashMap.put(K, uri);
            l(uri.getQueryParameter(y));
            String queryParameter = uri.getQueryParameter(n);
            String queryParameter2 = uri.getQueryParameter(x);
            k(queryParameter, queryParameter2, uri.getQueryParameter(z), uri);
            a(str, uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public final void k(String str, String str2, String str3, Uri uri) {
        String str4;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, uri) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        d.a.o0.a.c cVar = new d.a.o0.a.c(str);
        cVar.l0(str3);
        if (cVar.d() == 0 || cVar.q() == 0) {
            return;
        }
        TbSingleton.getInstance().setInvokeSource(cVar.e());
        d.a.c.e.n.f.f(String.valueOf(cVar.d()));
        d.a.c.e.n.f.i(String.valueOf(cVar.q()));
        int i2 = StringHelper.equals(str2, T) ? 2 : 1;
        String str5 = "";
        if (uri != null) {
            str5 = uri.getQueryParameter(o);
            str4 = uri.getQueryParameter(p);
        } else {
            str4 = "";
        }
        if (cVar.d() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
            if (currentActivity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) currentActivity).showFloatingWindow();
            } else if (currentActivity instanceof BaseActivity) {
                ((BaseActivity) currentActivity).showFloatingWindow();
            }
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_NEW_SCHEME_PULL_UP).param("obj_source", cVar.e()).param("obj_type", cVar.d()).param("obj_param1", cVar.q()).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, cVar.s()).param("extra", cVar.v()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fname", str5).param("tid", str4).param("obj_locate", TbadkCoreApplication.getInst().getStartType()).param("obj_name", 1));
        d.y().m(cVar);
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            d.a.o0.z0.e.m().v(true);
            d.a.o0.z0.e.m().k();
        }
    }

    public g() {
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
}
