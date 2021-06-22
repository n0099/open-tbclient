package d.a.m0.a.g0;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class a extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        int i2 = bundle.getInt("type");
        c cVar = new c();
        String string = bundle.getString("param1");
        Bundle bundle2 = new Bundle();
        if (i2 == 1) {
            bundle2.putBoolean("result", cVar.shouldAcceptCookie(string, bundle.getString("param2")));
            return bundle2;
        } else if (i2 == 2) {
            bundle2.putBoolean("result", cVar.shouldSendCookie(string, bundle.getString("param2")));
            return bundle2;
        } else if (i2 == 3) {
            cVar.storeCookie(string, bundle.getStringArrayList("param2"));
            return bundle2;
        } else if (i2 != 4) {
            return bundle2;
        } else {
            bundle2.putString("result", cVar.getCookie(string));
            return bundle2;
        }
    }
}
