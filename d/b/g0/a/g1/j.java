package d.b.g0.a.g1;

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
public class j extends d.b.g0.a.r1.f {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44536d = d.b.g0.a.k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f44537a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f44538b;

    /* renamed from: c  reason: collision with root package name */
    public a f44539c;

    /* loaded from: classes3.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f44540a;

        /* renamed from: b  reason: collision with root package name */
        public String f44541b;

        /* renamed from: c  reason: collision with root package name */
        public String f44542c = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.f44540a = new WeakReference<>(callbackHandler);
            this.f44541b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            this.f44540a = new WeakReference<>(callbackHandler);
            this.f44541b = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.f44536d) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String d2 = SwanAppNetworkUtils.d(i2, null);
                if (TextUtils.isEmpty(d2) || d2.equals(this.f44542c)) {
                    return;
                }
                this.f44542c = d2;
                SwanAppNetworkUtils.j(j.this, this.f44540a.get(), this.f44541b);
            }
        }
    }

    public j(d.b.g0.a.r1.e eVar) {
        super(eVar);
    }

    public void a(CallbackHandler callbackHandler, String str) {
        if (this.f44538b == null) {
            this.f44538b = (TelephonyManager) getSystemService("phone");
            a aVar = new a(callbackHandler, str);
            this.f44539c = aVar;
            this.f44538b.listen(aVar, 64);
            return;
        }
        a aVar2 = this.f44539c;
        if (aVar2 != null) {
            aVar2.a(callbackHandler, str);
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f44537a;
        if (networkBroadcastReceiver == null) {
            this.f44537a = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f44537a, intentFilter);
        } else if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.updateCallback(callbackHandler, str);
        }
        a(callbackHandler, str);
    }
}
