package d.a.n0.r1.q;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.service.RouterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.util.UrlManager;
import d.a.c.a.j;
/* loaded from: classes3.dex */
public class b implements RouterService {
    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invoke(Context context, String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        Activity b2 = d.a.c.a.b.f().b();
        if (b2 != null) {
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(b2), new String[]{sb.toString()}, true);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invokeScheme(Context context, String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        Activity b2 = d.a.c.a.b.f().b();
        if (b2 != null) {
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(b2), new String[]{sb.toString()}, true);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void openScheme(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        Activity b2 = d.a.c.a.b.f().b();
        if (b2 != null) {
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(b2), new String[]{sb.toString()}, true);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public boolean invokeScheme(Uri uri, String str, RouterService.LiveShowSchemeCallBack liveShowSchemeCallBack) {
        openScheme(uri.toString());
        return true;
    }
}
