package d.a.j0.s2.h0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.switchs.AdUploadSwitch;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f60308c;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f60310b = new a(2000994);

    /* renamed from: a  reason: collision with root package name */
    public f f60309a = new i();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !j.z() || e.this.f60309a == null) {
                return;
            }
            e.this.f60309a.c();
        }
    }

    public e() {
        MessageManager.getInstance().registerListener(this.f60310b);
    }

    public static e b() {
        if (f60308c == null) {
            synchronized (e.class) {
                if (f60308c == null) {
                    f60308c = new e();
                }
            }
        }
        return f60308c;
    }

    public final boolean c() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    public void d(c cVar) {
        if (c() && this.f60309a != null) {
            if (j.z()) {
                this.f60309a.a(cVar);
            } else {
                this.f60309a.b(cVar);
            }
        }
    }
}
