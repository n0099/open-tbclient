package d.a.n0.n1.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.j;
import d.a.n0.n1.j.a;
/* loaded from: classes3.dex */
public class b implements IConnectListener {

    /* renamed from: i  reason: collision with root package name */
    public static String f57673i = "imlog";

    /* renamed from: f  reason: collision with root package name */
    public c f57675f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57674e = false;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f57676g = new a(2005016);

    /* renamed from: h  reason: collision with root package name */
    public boolean f57677h = false;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            b.this.c();
        }
    }

    /* renamed from: d.a.n0.n1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1443b implements a.b {
        public C1443b() {
        }

        @Override // d.a.n0.n1.j.a.b
        public void a(int i2, String str) {
            Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i2 + ", errMsg=" + str);
            StringBuilder sb = new StringBuilder();
            sb.append(b.f57673i);
            sb.append("LiveIMManager");
            String sb2 = sb.toString();
            LogUtils.d(sb2, "LiveIMManager onLoginResult errno = " + i2 + ", errMsg = " + str + ", isConnected = " + b.this.f57674e);
            if (i2 != 0 || b.this.f57674e) {
                return;
            }
            b.this.onResult(0);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        public boolean mIsDestroy;
        public boolean mIsInit;

        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.mIsDestroy = true;
            try {
                TbadkCoreApplication.getInst().unregisterReceiver(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        private void init() {
            this.mIsInit = true;
            this.mIsDestroy = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (this.mIsInit) {
                    this.mIsInit = false;
                } else if (!j.z() || this.mIsDestroy) {
                } else {
                    BIMManager.tryConnection(context);
                }
            }
        }

        public void register() {
            init();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkCoreApplication.getInst().registerReceiver(this, intentFilter);
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    public void b(String str) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.init id =" + str);
        if (this.f57677h) {
            return;
        }
        this.f57677h = true;
        d.a.n0.n1.j.a.a().b(TbadkCoreApplication.getInst());
        d();
        c();
        if (this.f57675f == null) {
            this.f57675f = new c(this, null);
        }
        this.f57675f.register();
        MessageManager.getInstance().registerListener(this.f57676g);
    }

    public void c() {
        d.a.n0.n1.j.a.a().d(new C1443b());
    }

    public final void d() {
        LogUtils.d(f57673i + "LiveIMManager", "registerIMConnectListener");
        this.f57674e = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i2) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i2);
        LogUtils.d(f57673i + "LiveIMManager", "IConnectListener onResult statusCode=" + i2);
        this.f57674e = true;
        if (i2 == 0) {
            LogUtils.d(f57673i + "LiveIMManager", "IConnectListener net connect");
        } else if (i2 == 1) {
            LogUtils.d(f57673i + "LiveIMManager", "IConnectListener net disconnect");
        }
    }
}
