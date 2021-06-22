package d.a.m0.a.u.e.j;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.net.NetRedirectInfo;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
/* loaded from: classes2.dex */
public class i implements NetRequest.RedirectInterceptor {
    @Override // com.baidu.searchbox.v8engine.net.NetRequest.RedirectInterceptor
    public boolean shouldInterceptRedirect(NetRequestParam netRequestParam, NetRedirectInfo netRedirectInfo) {
        if (netRedirectInfo == null) {
            return false;
        }
        String newUrl = netRedirectInfo.getNewUrl();
        return TextUtils.isEmpty(newUrl) || d.a.m0.a.b2.a.b.c("request", newUrl, null) != 0;
    }
}
