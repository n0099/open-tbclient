package d.a.k0.z0.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.k0.i3.c;
/* loaded from: classes4.dex */
public class a implements c.a {
    public a() {
        String version = TbConfig.getVersion();
        if (TextUtils.isEmpty(version)) {
            return;
        }
        StatService.setAppVersionName(TbadkCoreApplication.getInst(), version);
    }

    @Override // d.a.k0.i3.c.a
    public void a(Context context) {
        StatService.setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_NONE);
        StatService.autoTrace(context);
    }

    @Override // d.a.k0.i3.c.a
    public void b(Context context, WebView webView, WebChromeClient webChromeClient) {
        StatService.trackWebView(context, webView, webChromeClient);
    }

    @Override // d.a.k0.i3.c.a
    public void c(Context context, String str, boolean z) {
        StatService.setAppChannel(context, str, z);
    }
}
