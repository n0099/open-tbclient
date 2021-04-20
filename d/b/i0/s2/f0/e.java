package d.b.i0.s2.f0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.switchs.AdUploadSwitch;
import d.b.c.e.p.j;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f61686c;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f61688b = new a(2000994);

    /* renamed from: a  reason: collision with root package name */
    public f f61687a = new i();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !j.z() || e.this.f61687a == null) {
                return;
            }
            e.this.f61687a.c();
        }
    }

    public e() {
        MessageManager.getInstance().registerListener(this.f61688b);
    }

    public static e b() {
        if (f61686c == null) {
            synchronized (e.class) {
                if (f61686c == null) {
                    f61686c = new e();
                }
            }
        }
        return f61686c;
    }

    public final boolean c() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    public void d(c cVar) {
        if (c() && this.f61687a != null) {
            if (j.z()) {
                this.f61687a.a(cVar);
            } else {
                this.f61687a.b(cVar);
            }
        }
    }
}
