package d.b.h0.a.g1;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.NetworkBroadcastReceiver;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class j extends d.b.h0.a.r1.f {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45258d = d.b.h0.a.k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f45259a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f45260b;

    /* renamed from: c  reason: collision with root package name */
    public a f45261c;

    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f45262a;

        /* renamed from: b  reason: collision with root package name */
        public String f45263b;

        /* renamed from: c  reason: collision with root package name */
        public String f45264c = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.f45262a = new WeakReference<>(callbackHandler);
            this.f45263b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            this.f45262a = new WeakReference<>(callbackHandler);
            this.f45263b = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.f45258d) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String d2 = SwanAppNetworkUtils.d(i2, null);
                if (TextUtils.isEmpty(d2) || d2.equals(this.f45264c)) {
                    return;
                }
                this.f45264c = d2;
                SwanAppNetworkUtils.j(j.this, this.f45262a.get(), this.f45263b);
            }
        }
    }

    public j(d.b.h0.a.r1.e eVar) {
        super(eVar);
    }

    public void a(CallbackHandler callbackHandler, String str) {
        if (this.f45260b == null) {
            this.f45260b = (TelephonyManager) getSystemService("phone");
            a aVar = new a(callbackHandler, str);
            this.f45261c = aVar;
            this.f45260b.listen(aVar, 64);
            return;
        }
        a aVar2 = this.f45261c;
        if (aVar2 != null) {
            aVar2.a(callbackHandler, str);
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f45259a;
        if (networkBroadcastReceiver == null) {
            this.f45259a = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f45259a, intentFilter);
        } else if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.updateCallback(callbackHandler, str);
        }
        a(callbackHandler, str);
    }
}
