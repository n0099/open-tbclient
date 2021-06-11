package d.a.l0.a.n1;

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
public class j extends d.a.l0.a.a2.f {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47391d = d.a.l0.a.k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f47392a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f47393b;

    /* renamed from: c  reason: collision with root package name */
    public a f47394c;

    /* loaded from: classes3.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f47395a;

        /* renamed from: b  reason: collision with root package name */
        public String f47396b;

        /* renamed from: c  reason: collision with root package name */
        public String f47397c = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.f47395a = new WeakReference<>(callbackHandler);
            this.f47396b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            this.f47395a = new WeakReference<>(callbackHandler);
            this.f47396b = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i2, int i3) {
            if (j.f47391d) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i2 + " networkType " + i3);
            }
            if (2 == i2) {
                String d2 = SwanAppNetworkUtils.d(i3, null);
                if (TextUtils.isEmpty(d2) || d2.equals(this.f47397c)) {
                    return;
                }
                this.f47397c = d2;
                SwanAppNetworkUtils.k(j.this, this.f47395a.get(), this.f47396b);
            }
        }
    }

    public j(d.a.l0.a.a2.e eVar) {
        super(eVar);
    }

    public void a(CallbackHandler callbackHandler, String str) {
        if (this.f47393b == null) {
            this.f47393b = (TelephonyManager) getSystemService("phone");
            a aVar = new a(callbackHandler, str);
            this.f47394c = aVar;
            this.f47393b.listen(aVar, 64);
            return;
        }
        a aVar2 = this.f47394c;
        if (aVar2 != null) {
            aVar2.a(callbackHandler, str);
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f47392a;
        if (networkBroadcastReceiver == null) {
            this.f47392a = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f47392a, intentFilter);
        } else if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.updateCallback(callbackHandler, str);
        }
        a(callbackHandler, str);
    }
}
