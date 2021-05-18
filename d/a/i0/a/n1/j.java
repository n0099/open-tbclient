package d.a.i0.a.n1;

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
public class j extends d.a.i0.a.a2.f {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43541d = d.a.i0.a.k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f43542a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f43543b;

    /* renamed from: c  reason: collision with root package name */
    public a f43544c;

    /* loaded from: classes3.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f43545a;

        /* renamed from: b  reason: collision with root package name */
        public String f43546b;

        /* renamed from: c  reason: collision with root package name */
        public String f43547c = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.f43545a = new WeakReference<>(callbackHandler);
            this.f43546b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            this.f43545a = new WeakReference<>(callbackHandler);
            this.f43546b = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i2, int i3) {
            if (j.f43541d) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i2 + " networkType " + i3);
            }
            if (2 == i2) {
                String d2 = SwanAppNetworkUtils.d(i3, null);
                if (TextUtils.isEmpty(d2) || d2.equals(this.f43547c)) {
                    return;
                }
                this.f43547c = d2;
                SwanAppNetworkUtils.k(j.this, this.f43545a.get(), this.f43546b);
            }
        }
    }

    public j(d.a.i0.a.a2.e eVar) {
        super(eVar);
    }

    public void a(CallbackHandler callbackHandler, String str) {
        if (this.f43543b == null) {
            this.f43543b = (TelephonyManager) getSystemService("phone");
            a aVar = new a(callbackHandler, str);
            this.f43544c = aVar;
            this.f43543b.listen(aVar, 64);
            return;
        }
        a aVar2 = this.f43544c;
        if (aVar2 != null) {
            aVar2.a(callbackHandler, str);
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f43542a;
        if (networkBroadcastReceiver == null) {
            this.f43542a = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f43542a, intentFilter);
        } else if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.updateCallback(callbackHandler, str);
        }
        a(callbackHandler, str);
    }
}
