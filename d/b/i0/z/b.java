package d.b.i0.z;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.vivo.push.PushClientConstants;
import d.b.c.a.j;
import d.b.i0.z.a;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1730a f64216a;

        public a(a.C1730a c1730a) {
            this.f64216a = c1730a;
        }

        @Override // d.b.i0.z.c
        public void onFailed(int i) {
            this.f64216a.a(2, i);
        }
    }

    /* renamed from: d.b.i0.z.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1731b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1730a f64217a;

        public C1731b(a.C1730a c1730a) {
            this.f64217a = c1730a;
        }

        @Override // d.b.i0.z.c
        public void onFailed(int i) {
            this.f64217a.a(2, i);
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle, boolean z) {
        return b(context, uri, null, bundle, z);
    }

    public static boolean b(Context context, Uri uri, d.b.i0.z.a aVar, Bundle bundle, boolean z) {
        a.C1730a c1730a = new a.C1730a();
        if (uri == null) {
            if (aVar != null) {
                aVar.b(1, "Uri is empty.", c1730a);
            }
            return false;
        } else if (!"deeplink".equals(uri.getHost())) {
            if (aVar != null) {
                aVar.b(2, "Uri host is not deeplink.", c1730a);
            }
            return false;
        } else {
            String queryParameter = uri.getQueryParameter("appUrl");
            String queryParameter2 = uri.getQueryParameter("marketUrl");
            String queryParameter3 = uri.getQueryParameter(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL);
            String queryParameter4 = uri.getQueryParameter(PushClientConstants.TAG_PKG_NAME);
            String queryParameter5 = uri.getQueryParameter("marketPkgName");
            boolean booleanQueryParameter = uri.getBooleanQueryParameter("isDesignatePkg", true);
            if (e(context, queryParameter, queryParameter4, aVar, booleanQueryParameter, c1730a) || f(context, queryParameter2, queryParameter5, aVar, booleanQueryParameter, c1730a)) {
                return true;
            }
            return g(context, queryParameter3, bundle, aVar, c1730a, z);
        }
    }

    public static boolean c(Context context, String str, String str2, boolean z, c cVar) {
        try {
            Intent b2 = d.b(context, str, str2, z, cVar);
            if (b2 == null) {
                return false;
            }
            context.startActivity(b2);
            return true;
        } catch (Exception unused) {
            if (cVar != null) {
                cVar.onFailed(-101);
            }
            return false;
        }
    }

    public static boolean d(Context context, String str, Bundle bundle, boolean z) {
        TbPageContext<?> tbPageContext;
        String[] strArr = {str};
        UrlManager urlManager = UrlManager.getInstance();
        if (urlManager == null || (tbPageContext = (TbPageContext) j.a(context)) == null) {
            return false;
        }
        if (urlManager.UrlValidated(str)) {
            urlManager.dealOneLink(tbPageContext, strArr, true);
            return true;
        }
        return urlManager.dealOneLink(tbPageContext, strArr);
    }

    public static boolean e(Context context, String str, String str2, d.b.i0.z.a aVar, boolean z, a.C1730a c1730a) {
        if (TextUtils.isEmpty(str)) {
            c1730a.a(1, -4);
            return false;
        } else if (c(context, str, str2, z, new a(c1730a))) {
            c1730a.b(1);
            if (aVar != null) {
                aVar.a(1, c1730a);
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean f(Context context, String str, String str2, d.b.i0.z.a aVar, boolean z, a.C1730a c1730a) {
        if (TextUtils.isEmpty(str)) {
            c1730a.a(2, -5);
            return false;
        } else if (c(context, str, str2, z, new C1731b(c1730a))) {
            c1730a.b(2);
            if (aVar != null) {
                aVar.a(2, c1730a);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean g(Context context, String str, Bundle bundle, d.b.i0.z.a aVar, a.C1730a c1730a, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c1730a.a(3, -6);
            if (aVar != null) {
                aVar.b(-6, "Uri web url is empty", c1730a);
            }
            return false;
        } else if (d(context, str, bundle, z)) {
            c1730a.b(3);
            if (aVar != null) {
                aVar.a(3, c1730a);
                return true;
            }
            return true;
        } else {
            c1730a.a(3, -7);
            if (aVar != null) {
                aVar.b(-7, "Uri web url open failed", c1730a);
            }
            return false;
        }
    }
}
