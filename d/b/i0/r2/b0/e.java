package d.b.i0.r2.b0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.switchs.AdUploadSwitch;
import d.b.b.e.p.j;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f59767c;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f59769b = new a(2000994);

    /* renamed from: a  reason: collision with root package name */
    public f f59768a = new i();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !j.z() || e.this.f59768a == null) {
                return;
            }
            e.this.f59768a.c();
        }
    }

    public e() {
        MessageManager.getInstance().registerListener(this.f59769b);
    }

    public static e b() {
        if (f59767c == null) {
            synchronized (e.class) {
                if (f59767c == null) {
                    f59767c = new e();
                }
            }
        }
        return f59767c;
    }

    public final boolean c() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    public void d(c cVar) {
        if (c() && this.f59768a != null) {
            if (j.z()) {
                this.f59768a.a(cVar);
            } else {
                this.f59768a.b(cVar);
            }
        }
    }
}
