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
    public static final boolean f43715d = d.a.l0.a.k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f43716a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f43717b;

    /* renamed from: c  reason: collision with root package name */
    public a f43718c;

    /* loaded from: classes3.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f43719a;

        /* renamed from: b  reason: collision with root package name */
        public String f43720b;

        /* renamed from: c  reason: collision with root package name */
        public String f43721c = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.f43719a = new WeakReference<>(callbackHandler);
            this.f43720b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            this.f43719a = new WeakReference<>(callbackHandler);
            this.f43720b = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i2, int i3) {
            if (j.f43715d) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i2 + " networkType " + i3);
            }
            if (2 == i2) {
                String d2 = SwanAppNetworkUtils.d(i3, null);
                if (TextUtils.isEmpty(d2) || d2.equals(this.f43721c)) {
                    return;
                }
                this.f43721c = d2;
                SwanAppNetworkUtils.k(j.this, this.f43719a.get(), this.f43720b);
            }
        }
    }

    public j(d.a.l0.a.a2.e eVar) {
        super(eVar);
    }

    public void a(CallbackHandler callbackHandler, String str) {
        if (this.f43717b == null) {
            this.f43717b = (TelephonyManager) getSystemService("phone");
            a aVar = new a(callbackHandler, str);
            this.f43718c = aVar;
            this.f43717b.listen(aVar, 64);
            return;
        }
        a aVar2 = this.f43718c;
        if (aVar2 != null) {
            aVar2.a(callbackHandler, str);
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f43716a;
        if (networkBroadcastReceiver == null) {
            this.f43716a = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f43716a, intentFilter);
        } else if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.updateCallback(callbackHandler, str);
        }
        a(callbackHandler, str);
    }
}
