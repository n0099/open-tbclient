package d.a.m0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f54758b = new byte[1];

    /* renamed from: c  reason: collision with root package name */
    public static x f54759c;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f54760a;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
        d.a.c.e.p.j.r();
    }

    public static x b() {
        if (f54759c == null) {
            synchronized (f54758b) {
                if (f54759c == null) {
                    f54759c = new x();
                }
            }
        }
        return f54759c;
    }

    public final CustomMessageListener c() {
        return new a(2000994);
    }

    public final void d() {
        try {
            boolean z = d.a.c.e.p.j.z();
            if (z) {
                if (d.a.c.e.p.j.H()) {
                    TbImageHelper.getInstance().setNetworkIsWifi(true);
                    d.a.n0.t2.g0.a.e().f();
                } else if (d.a.c.e.p.j.x()) {
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
            if (this.f54760a == null) {
                this.f54760a = c();
                MessageManager.getInstance().registerListener(this.f54760a);
            }
        } catch (Exception e2) {
            this.f54760a = null;
            BdLog.e(e2.getMessage());
        }
    }
}
