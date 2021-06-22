package d.a.o0.r1.e;

import com.baidu.searchbox.live.interfaces.browser.IBrowserView;
import com.baidu.searchbox.live.interfaces.service.BrowserProxyService;
/* loaded from: classes3.dex */
public class c implements BrowserProxyService {
    @Override // com.baidu.searchbox.live.interfaces.service.BrowserProxyService
    public IBrowserView buildLightBrowserViewInstance() {
        return new a();
    }
}
