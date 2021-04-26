package d.a.j0.m1.j;

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
import d.a.j0.m1.j.a;
/* loaded from: classes3.dex */
public class b implements IConnectListener {

    /* renamed from: i  reason: collision with root package name */
    public static String f56786i = "imlog";

    /* renamed from: f  reason: collision with root package name */
    public c f56788f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56787e = false;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f56789g = new a(2005016);

    /* renamed from: h  reason: collision with root package name */
    public boolean f56790h = false;

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

    /* renamed from: d.a.j0.m1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1353b implements a.b {
        public C1353b() {
        }

        @Override // d.a.j0.m1.j.a.b
        public void a(int i2, String str) {
            Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i2 + ", errMsg=" + str);
            StringBuilder sb = new StringBuilder();
            sb.append(b.f56786i);
            sb.append("LiveIMManager");
            String sb2 = sb.toString();
            LogUtils.d(sb2, "LiveIMManager onLoginResult errno = " + i2 + ", errMsg = " + str + ", isConnected = " + b.this.f56787e);
            if (i2 != 0 || b.this.f56787e) {
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
        if (this.f56790h) {
            return;
        }
        this.f56790h = true;
        d.a.j0.m1.j.a.a().b(TbadkCoreApplication.getInst());
        d();
        c();
        if (this.f56788f == null) {
            this.f56788f = new c(this, null);
        }
        this.f56788f.register();
        MessageManager.getInstance().registerListener(this.f56789g);
    }

    public void c() {
        d.a.j0.m1.j.a.a().d(new C1353b());
    }

    public final void d() {
        LogUtils.d(f56786i + "LiveIMManager", "registerIMConnectListener");
        this.f56787e = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i2) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i2);
        LogUtils.d(f56786i + "LiveIMManager", "IConnectListener onResult statusCode=" + i2);
        this.f56787e = true;
        if (i2 == 0) {
            LogUtils.d(f56786i + "LiveIMManager", "IConnectListener net connect");
        } else if (i2 == 1) {
            LogUtils.d(f56786i + "LiveIMManager", "IConnectListener net disconnect");
        }
    }
}
