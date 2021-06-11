package d.a.n0.t2.i0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.switchs.AdUploadSwitch;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f64845c;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f64847b = new a(2000994);

    /* renamed from: a  reason: collision with root package name */
    public f f64846a = new h();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !j.z() || e.this.f64846a == null) {
                return;
            }
            e.this.f64846a.c();
        }
    }

    public e() {
        MessageManager.getInstance().registerListener(this.f64847b);
    }

    public static e b() {
        if (f64845c == null) {
            synchronized (e.class) {
                if (f64845c == null) {
                    f64845c = new e();
                }
            }
        }
        return f64845c;
    }

    public final boolean c() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    public void d(c cVar) {
        if (c() && this.f64846a != null) {
            if (j.z()) {
                this.f64846a.a(cVar);
            } else {
                this.f64846a.b(cVar);
            }
        }
    }
}
