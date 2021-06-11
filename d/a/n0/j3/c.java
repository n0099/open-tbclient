package d.a.n0.j3;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.PermissionUtil;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f60267b;

    /* renamed from: a  reason: collision with root package name */
    public a f60268a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Context context);

        void b(Context context, WebView webView, WebChromeClient webChromeClient);

        void c(Context context, String str, boolean z);
    }

    public static c b() {
        if (f60267b == null) {
            synchronized (c.class) {
                if (f60267b == null) {
                    f60267b = new c();
                }
            }
        }
        return f60267b;
    }

    public void a(Context context) {
        a aVar;
        if (PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.f60268a) != null) {
            aVar.a(context);
        }
    }

    public final a c() {
        CustomResponsedMessage runTask;
        if (!d() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public final boolean d() {
        return d.a.m0.r.d0.b.j().k("pref_key_stat_sdk_enable", 1) != 0;
    }

    public void e(Context context, String str, boolean z) {
        a aVar;
        if (PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.f60268a) != null) {
            aVar.c(context, str, z);
        }
    }

    public void f(Context context, WebView webView, WebChromeClient webChromeClient) {
        a aVar;
        if (PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.f60268a) != null) {
            aVar.b(context, webView, webChromeClient);
        }
    }
}
