package d.b.g0.b.l;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        int i = bundle.getInt("type");
        b bVar = new b();
        String string = bundle.getString("param1");
        Bundle bundle2 = new Bundle();
        if (i == 1) {
            bundle2.putBoolean("result", bVar.shouldAcceptCookie(string, bundle.getString("param2")));
            return bundle2;
        } else if (i == 2) {
            bundle2.putBoolean("result", bVar.shouldSendCookie(string, bundle.getString("param2")));
            return bundle2;
        } else if (i == 3) {
            bVar.storeCookie(string, bundle.getStringArrayList("param2"));
            return bundle2;
        } else if (i != 4) {
            return bundle2;
        } else {
            bundle2.putString("result", bVar.getCookie(string));
            return bundle2;
        }
    }
}
