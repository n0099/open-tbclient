package d.b.h0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class x {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f51746b = new byte[1];

    /* renamed from: c  reason: collision with root package name */
    public static x f51747c;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f51748a;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                x.this.d();
            }
        }
    }

    public x() {
        d.b.b.e.p.j.r();
    }

    public static x b() {
        if (f51747c == null) {
            synchronized (f51746b) {
                if (f51747c == null) {
                    f51747c = new x();
                }
            }
        }
        return f51747c;
    }

    public final CustomMessageListener c() {
        return new a(2000994);
    }

    public final void d() {
        try {
            boolean z = d.b.b.e.p.j.z();
            if (z) {
                if (d.b.b.e.p.j.H()) {
                    TbImageHelper.getInstance().setNetworkIsWifi(true);
                    d.b.i0.r2.a0.a.e().f();
                } else if (d.b.b.e.p.j.x()) {
                    TbImageHelper.getInstance().setNetworkIsWifi(false);
                }
            }
            NoNetworkView.setIsHasNetwork(z);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public void e() {
        try {
            if (this.f51748a == null) {
                this.f51748a = c();
                MessageManager.getInstance().registerListener(this.f51748a);
            }
        } catch (Exception e2) {
            this.f51748a = null;
            BdLog.e(e2.getMessage());
        }
    }
}
