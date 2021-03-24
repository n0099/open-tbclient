package d.b.i0.l1.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.s.a.g.e;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a implements ILoginListener {

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f56719h = null;
    public static boolean i = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56720e;

    /* renamed from: f  reason: collision with root package name */
    public b f56721f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f56722g = new C1332a();

    /* renamed from: d.b.i0.l1.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1332a extends BroadcastReceiver {

        /* renamed from: d.b.i0.l1.i.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1333a extends f0<Object> {
            public C1333a() {
            }

            @Override // d.b.h0.z0.f0
            public Object doInBackground() {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive doInBackground");
                a.this.d(null);
                return null;
            }
        }

        public C1332a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive context=" + context + ", intent=" + intent);
            if (intent == null || !"com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                return;
            }
            boolean z = intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0;
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive connect=" + z);
            Log.d("ImSdkManager", "registerConnectListener connect ：" + intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1));
            if (z) {
                h0.b(new C1333a(), null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, String str);
    }

    public static a a() {
        if (f56719h == null) {
            synchronized (a.class) {
                if (f56719h == null) {
                    f56719h = new a();
                }
            }
        }
        return f56719h;
    }

    public static boolean c() {
        HashMap hashMap = new HashMap();
        hashMap.put("test_checkoutImEnvRD", Boolean.FALSE);
        if (hashMap.containsKey("test_checkoutImEnvRD")) {
            return ((Boolean) hashMap.get("test_checkoutImEnvRD")).booleanValue();
        }
        return false;
    }

    public void b(Context context) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init context=" + context);
        int i2 = 0;
        this.f56720e = false;
        String version = TbConfig.getVersion();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(context).registerReceiver(this.f56722g, intentFilter);
        e.y(context, true);
        BIMManager.setProductLine(context, 3, version);
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        BIMManager.enableDebugMode(true);
        if (c()) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init debug");
            BIMManager.init(context, Constants.APPID_TIEBA, 1, cuidGalaxy2);
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
            i2 = 1;
        } else {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init online");
            BIMManager.init(context, Constants.APPID_TIEBA, 0, cuidGalaxy2);
            BIMRtcClient.setRtcDebugAndLogEnable(context, false, false);
        }
        LogUtils.d("imlog", "BIMManager init env:" + i2);
        e(context);
    }

    public void d(b bVar) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM listener=" + bVar);
        this.f56721f = bVar;
        String from = TbConfig.getFrom();
        String currentFrom = TbConfig.getCurrentFrom();
        if (TbadkCoreApplication.isLogin()) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM login");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentBduss = TbadkCoreApplication.getCurrentBduss();
            BIMManager.login(currentAccount, currentBduss, 1, from, currentFrom, this);
            LogUtils.d("imlog", "IMSdkManager PassIsLogin loginToIM uid = " + currentAccount + ", bduss = " + currentBduss + ", from = " + from + ", cfrom = " + currentFrom);
            return;
        }
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM cuid");
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        BIMManager.login(null, cuidGalaxy2, 6, from, currentFrom, this);
        LogUtils.d("imlog", "IMSdkManager 匿名使用cuid登录 loginToIM , cuid = " + cuidGalaxy2 + ", from = " + from + ", cfrom = " + currentFrom);
    }

    public final void e(Context context) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP context=" + context);
        int i2 = i ? 1 : 2;
        i = false;
        d.b.s.a.b.a.a(context, "10773430", TbadkCoreApplication.getInst().getCuidGalaxy2(), i2);
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP connect end");
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i2, String str) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLoginResult errno=" + i2 + ", errMsg=" + str);
        b bVar = this.f56721f;
        if (bVar != null) {
            bVar.a(i2, str);
            this.f56721f = null;
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLogoutResult(int i2, String str, int i3) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLogoutResult errno=" + i2 + ", errMsg=" + str + ", type=" + i3);
        if (this.f56720e) {
            return;
        }
        d(null);
    }
}
