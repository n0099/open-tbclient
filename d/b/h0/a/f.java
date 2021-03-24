package d.b.h0.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {
    public static String A = "maintablocate";
    public static String B = "maintab_subtab";
    public static String C = "newgod_from";
    public static String D = "field_id";
    public static String E = "chushou_third_live_type";
    public static String F = "chuchou_third_room_id";
    public static String G = "hotTrend";
    public static String H = "tab_id";
    public static String I = "param_uri";
    public static String J = "forumId";
    public static String K = "item_id";
    public static String L = "from_tb_token";

    /* renamed from: a  reason: collision with root package name */
    public static String f49574a = "com.baidu.tieba";

    /* renamed from: b  reason: collision with root package name */
    public static String f49575b = "unidispatch";

    /* renamed from: c  reason: collision with root package name */
    public static String f49576c = "/homepage";

    /* renamed from: d  reason: collision with root package name */
    public static String f49577d = "/enterforum";

    /* renamed from: e  reason: collision with root package name */
    public static String f49578e = "/recommendforum";

    /* renamed from: f  reason: collision with root package name */
    public static String f49579f = "/frs";

    /* renamed from: g  reason: collision with root package name */
    public static String f49580g = "/pb";

    /* renamed from: h  reason: collision with root package name */
    public static String f49581h = "/tbwebview";
    public static String i = "/usercenter";
    public static String j = "/topicdetail";
    public static String k = "/tiebachushou";
    public static String l = "/activitypage";
    public static String m = "extdata";
    public static String n = "kw";
    public static String o = "tid";
    public static String p = "ori_ugc_nid";
    public static String q = "ori_ugc_tid";
    public static String r = "ori_ugc_type";
    public static String s = "ori_ugc_vid";
    public static String t = "portrait";
    public static String u = "topic_id";
    public static String v = "url";
    public static String w = "schemefrom";
    public static String x = "from";
    public static String y = "token";
    public static String z = "tab_name";

    /* loaded from: classes3.dex */
    public interface b {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final f f49582a = new f();
    }

    public static final f b() {
        return c.f49582a;
    }

    public static boolean c(Uri uri) {
        return uri != null && f49574a.equals(uri.getScheme()) && f49575b.equals(uri.getHost());
    }

    public final void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !StringHelper.equals(str2, L)) {
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

    public void d(Uri uri, b bVar) {
        if (uri != null && c(uri) && f49579f.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = n;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = H;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = o;
            hashMap.put(str3, uri.getQueryParameter(str3));
            l(uri.getQueryParameter(x));
            String queryParameter = uri.getQueryParameter(m);
            String queryParameter2 = uri.getQueryParameter(w);
            k(queryParameter, queryParameter2, uri.getQueryParameter(y), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, b bVar) {
        if (uri == null || !c(uri)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        String queryParameter = uri.getQueryParameter(m);
        String queryParameter2 = uri.getQueryParameter(w);
        String queryParameter3 = uri.getQueryParameter(y);
        String queryParameter4 = uri.getQueryParameter(z);
        k(queryParameter, queryParameter2, queryParameter3, uri);
        l(uri.getQueryParameter(x));
        a("", uri, queryParameter2);
        v.a(uri);
        if (f49576c.equals(uri.getPath())) {
            hashMap.put(A, 2);
            String str = C;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = D;
            hashMap.put(str2, uri.getQueryParameter(str2));
            hashMap.put(z, queryParameter4);
        } else if (f49577d.equals(uri.getPath())) {
            hashMap.put(A, 1);
            hashMap.put(B, queryParameter4);
        } else if (f49578e.equals(uri.getPath())) {
            hashMap.put(A, 1);
            hashMap.put(B, "1_recommend");
        } else if (l.equals(uri.getPath())) {
            hashMap.put(A, 2);
            hashMap.put(z, queryParameter4);
        }
        bVar.onCallBack(hashMap);
    }

    public void f(Uri uri, b bVar) {
        if (uri != null && c(uri) && f49580g.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = o;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = p;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = q;
            hashMap.put(str3, uri.getQueryParameter(str3));
            String str4 = r;
            hashMap.put(str4, uri.getQueryParameter(str4));
            String str5 = s;
            hashMap.put(str5, uri.getQueryParameter(str5));
            l(uri.getQueryParameter(x));
            String queryParameter = uri.getQueryParameter(m);
            String queryParameter2 = uri.getQueryParameter(w);
            k(queryParameter, queryParameter2, uri.getQueryParameter(y), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void g(Uri uri, b bVar) {
        if (uri != null && c(uri) && j.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = u;
            hashMap.put(str, uri.getQueryParameter(str));
            l(uri.getQueryParameter(x));
            k(uri.getQueryParameter(m), uri.getQueryParameter(w), uri.getQueryParameter(y), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void h(Uri uri, b bVar) {
        if (uri != null && c(uri) && i.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = t;
            hashMap.put(str, uri.getQueryParameter(str));
            k(uri.getQueryParameter(m), uri.getQueryParameter(w), uri.getQueryParameter(y), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void i(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
                return;
            }
            UtilHelper.clearClipBoard();
        }
    }

    public void j(String str, Uri uri, b bVar) {
        if (uri != null && c(uri) && f49581h.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str2 = v;
            hashMap.put(str2, uri.getQueryParameter(str2));
            hashMap.put(I, uri);
            l(uri.getQueryParameter(x));
            String queryParameter = uri.getQueryParameter(m);
            String queryParameter2 = uri.getQueryParameter(w);
            k(queryParameter, queryParameter2, uri.getQueryParameter(y), uri);
            a(str, uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public final void k(String str, String str2, String str3, Uri uri) {
        String str4;
        Activity currentActivity;
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        d.b.h0.a.b bVar = new d.b.h0.a.b(str);
        bVar.l0(str3);
        if (bVar.d() == 0 || bVar.q() == 0) {
            return;
        }
        TbSingleton.getInstance().setInvokeSource(bVar.e());
        d.b.b.e.n.f.f(String.valueOf(bVar.d()));
        d.b.b.e.n.f.i(String.valueOf(bVar.q()));
        int i2 = StringHelper.equals(str2, L) ? 2 : 1;
        String str5 = "";
        if (uri != null) {
            str5 = uri.getQueryParameter(n);
            str4 = uri.getQueryParameter(o);
        } else {
            str4 = "";
        }
        if (bVar.d() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
            if (currentActivity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) currentActivity).showFloatingWindow();
            } else if (currentActivity instanceof BaseActivity) {
                ((BaseActivity) currentActivity).showFloatingWindow();
            }
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_NEW_SCHEME_PULL_UP).param("obj_source", bVar.e()).param("obj_type", bVar.d()).param("obj_param1", bVar.q()).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, bVar.s()).param("extra", bVar.v()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fname", str5).param("tid", str4).param("obj_locate", TbadkCoreApplication.getInst().getStartType()).param("obj_name", 1));
        d.b.h0.a.c.y().m(bVar);
    }

    public final void l(String str) {
        if (TextUtils.isEmpty(str) || !"shoubai".equals(str)) {
            return;
        }
        d.b.h0.z0.e.m().v(true);
        d.b.h0.z0.e.m().k();
    }

    public f() {
    }
}
