package d.b.j0.m1.i;

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
import d.b.c.e.p.j;
import d.b.j0.m1.i.a;
/* loaded from: classes3.dex */
public class b implements IConnectListener {
    public static String i = "imlog";

    /* renamed from: f  reason: collision with root package name */
    public c f58776f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58775e = false;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f58777g = new a(2005016);

    /* renamed from: h  reason: collision with root package name */
    public boolean f58778h = false;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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

    /* renamed from: d.b.j0.m1.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1414b implements a.b {
        public C1414b() {
        }

        @Override // d.b.j0.m1.i.a.b
        public void a(int i, String str) {
            Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i + ", errMsg=" + str);
            StringBuilder sb = new StringBuilder();
            sb.append(b.i);
            sb.append("LiveIMManager");
            String sb2 = sb.toString();
            LogUtils.d(sb2, "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + b.this.f58775e);
            if (i != 0 || b.this.f58775e) {
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
        if (this.f58778h) {
            return;
        }
        this.f58778h = true;
        d.b.j0.m1.i.a.a().b(TbadkCoreApplication.getInst());
        d();
        c();
        if (this.f58776f == null) {
            this.f58776f = new c(this, null);
        }
        this.f58776f.register();
        MessageManager.getInstance().registerListener(this.f58777g);
    }

    public void c() {
        d.b.j0.m1.i.a.a().d(new C1414b());
    }

    public final void d() {
        LogUtils.d(i + "LiveIMManager", "registerIMConnectListener");
        this.f58775e = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i2) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i2);
        LogUtils.d(i + "LiveIMManager", "IConnectListener onResult statusCode=" + i2);
        this.f58775e = true;
        if (i2 == 0) {
            LogUtils.d(i + "LiveIMManager", "IConnectListener net connect");
        } else if (i2 == 1) {
            LogUtils.d(i + "LiveIMManager", "IConnectListener net disconnect");
        }
    }
}
