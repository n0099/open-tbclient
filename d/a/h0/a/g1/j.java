package d.a.h0.a.g1;

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
public class j extends d.a.h0.a.r1.f {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42571d = d.a.h0.a.k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f42572a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f42573b;

    /* renamed from: c  reason: collision with root package name */
    public a f42574c;

    /* loaded from: classes3.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f42575a;

        /* renamed from: b  reason: collision with root package name */
        public String f42576b;

        /* renamed from: c  reason: collision with root package name */
        public String f42577c = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.f42575a = new WeakReference<>(callbackHandler);
            this.f42576b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            this.f42575a = new WeakReference<>(callbackHandler);
            this.f42576b = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i2, int i3) {
            if (j.f42571d) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i2 + " networkType " + i3);
            }
            if (2 == i2) {
                String d2 = SwanAppNetworkUtils.d(i3, null);
                if (TextUtils.isEmpty(d2) || d2.equals(this.f42577c)) {
                    return;
                }
                this.f42577c = d2;
                SwanAppNetworkUtils.j(j.this, this.f42575a.get(), this.f42576b);
            }
        }
    }

    public j(d.a.h0.a.r1.e eVar) {
        super(eVar);
    }

    public void a(CallbackHandler callbackHandler, String str) {
        if (this.f42573b == null) {
            this.f42573b = (TelephonyManager) getSystemService("phone");
            a aVar = new a(callbackHandler, str);
            this.f42574c = aVar;
            this.f42573b.listen(aVar, 64);
            return;
        }
        a aVar2 = this.f42574c;
        if (aVar2 != null) {
            aVar2.a(callbackHandler, str);
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f42572a;
        if (networkBroadcastReceiver == null) {
            this.f42572a = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f42572a, intentFilter);
        } else if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.updateCallback(callbackHandler, str);
        }
        a(callbackHandler, str);
    }
}
