package d.b.j0.s2.f0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.switchs.AdUploadSwitch;
import d.b.c.e.p.j;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f62107c;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f62109b = new a(2000994);

    /* renamed from: a  reason: collision with root package name */
    public f f62108a = new i();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !j.z() || e.this.f62108a == null) {
                return;
            }
            e.this.f62108a.c();
        }
    }

    public e() {
        MessageManager.getInstance().registerListener(this.f62109b);
    }

    public static e b() {
        if (f62107c == null) {
            synchronized (e.class) {
                if (f62107c == null) {
                    f62107c = new e();
                }
            }
        }
        return f62107c;
    }

    public final boolean c() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    public void d(c cVar) {
        if (c() && this.f62108a != null) {
            if (j.z()) {
                this.f62108a.a(cVar);
            } else {
                this.f62108a.b(cVar);
            }
        }
    }
}
