package d.a.m0.a.n1;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.NetworkBroadcastReceiver;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class j extends d.a.m0.a.a2.f {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47499d = d.a.m0.a.k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f47500a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f47501b;

    /* renamed from: c  reason: collision with root package name */
    public a f47502c;

    /* loaded from: classes3.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f47503a;

        /* renamed from: b  reason: collision with root package name */
        public String f47504b;

        /* renamed from: c  reason: collision with root package name */
        public String f47505c = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.f47503a = new WeakReference<>(callbackHandler);
            this.f47504b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            this.f47503a = new WeakReference<>(callbackHandler);
            this.f47504b = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i2, int i3) {
            if (j.f47499d) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i2 + " networkType " + i3);
            }
            if (2 == i2) {
                String d2 = SwanAppNetworkUtils.d(i3, null);
                if (TextUtils.isEmpty(d2) || d2.equals(this.f47505c)) {
                    return;
                }
                this.f47505c = d2;
                SwanAppNetworkUtils.k(j.this, this.f47503a.get(), this.f47504b);
            }
        }
    }

    public j(d.a.m0.a.a2.e eVar) {
        super(eVar);
    }

    public void a(CallbackHandler callbackHandler, String str) {
        if (this.f47501b == null) {
            this.f47501b = (TelephonyManager) getSystemService("phone");
            a aVar = new a(callbackHandler, str);
            this.f47502c = aVar;
            this.f47501b.listen(aVar, 64);
            return;
        }
        a aVar2 = this.f47502c;
        if (aVar2 != null) {
            aVar2.a(callbackHandler, str);
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f47500a;
        if (networkBroadcastReceiver == null) {
            this.f47500a = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f47500a, intentFilter);
        } else if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.updateCallback(callbackHandler, str);
        }
        a(callbackHandler, str);
    }
}
