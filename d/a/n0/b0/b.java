package d.a.n0.b0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.vivo.push.PushClientConstants;
import d.a.c.a.j;
import d.a.n0.b0.a;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1182a f51253a;

        public a(a.C1182a c1182a) {
            this.f51253a = c1182a;
        }

        @Override // d.a.n0.b0.c
        public void onFailed(int i2) {
            this.f51253a.a(2, i2);
        }
    }

    /* renamed from: d.a.n0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1183b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1182a f51254a;

        public C1183b(a.C1182a c1182a) {
            this.f51254a = c1182a;
        }

        @Override // d.a.n0.b0.c
        public void onFailed(int i2) {
            this.f51254a.a(2, i2);
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle, boolean z) {
        return b(context, uri, null, bundle, z);
    }

    public static boolean b(Context context, Uri uri, d.a.n0.b0.a aVar, Bundle bundle, boolean z) {
        a.C1182a c1182a = new a.C1182a();
        if (uri == null) {
            if (aVar != null) {
                aVar.b(1, "Uri is empty.", c1182a);
            }
            return false;
        } else if (!"deeplink".equals(uri.getHost())) {
            if (aVar != null) {
                aVar.b(2, "Uri host is not deeplink.", c1182a);
            }
            return false;
        } else {
            String queryParameter = uri.getQueryParameter("appUrl");
            String queryParameter2 = uri.getQueryParameter("marketUrl");
            String queryParameter3 = uri.getQueryParameter(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL);
            String queryParameter4 = uri.getQueryParameter(PushClientConstants.TAG_PKG_NAME);
            String queryParameter5 = uri.getQueryParameter("marketPkgName");
            boolean booleanQueryParameter = uri.getBooleanQueryParameter("isDesignatePkg", true);
            if (e(context, queryParameter, queryParameter4, aVar, booleanQueryParameter, c1182a) || f(context, queryParameter2, queryParameter5, aVar, booleanQueryParameter, c1182a)) {
                return true;
            }
            return g(context, queryParameter3, bundle, aVar, c1182a, z);
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

    public static boolean e(Context context, String str, String str2, d.a.n0.b0.a aVar, boolean z, a.C1182a c1182a) {
        if (TextUtils.isEmpty(str)) {
            c1182a.a(1, -4);
            return false;
        } else if (c(context, str, str2, z, new a(c1182a))) {
            c1182a.b(1);
            if (aVar != null) {
                aVar.a(1, c1182a);
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean f(Context context, String str, String str2, d.a.n0.b0.a aVar, boolean z, a.C1182a c1182a) {
        if (TextUtils.isEmpty(str)) {
            c1182a.a(2, -5);
            return false;
        } else if (c(context, str, str2, z, new C1183b(c1182a))) {
            c1182a.b(2);
            if (aVar != null) {
                aVar.a(2, c1182a);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean g(Context context, String str, Bundle bundle, d.a.n0.b0.a aVar, a.C1182a c1182a, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c1182a.a(3, -6);
            if (aVar != null) {
                aVar.b(-6, "Uri web url is empty", c1182a);
            }
            return false;
        } else if (d(context, str, bundle, z)) {
            c1182a.b(3);
            if (aVar != null) {
                aVar.a(3, c1182a);
                return true;
            }
            return true;
        } else {
            c1182a.a(3, -7);
            if (aVar != null) {
                aVar.b(-7, "Uri web url open failed", c1182a);
            }
            return false;
        }
    }
}
