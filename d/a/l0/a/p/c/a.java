package d.a.l0.a.p.c;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
/* loaded from: classes2.dex */
public class a implements d.a.l0.a.p.d.b {

    /* renamed from: d.a.l0.a.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0785a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("baidu_cookie", a.b());
            return bundle2;
        }
    }

    public static String b() {
        return CookieManager.getInstance().getCookie(Domains.BAIDU);
    }
}
