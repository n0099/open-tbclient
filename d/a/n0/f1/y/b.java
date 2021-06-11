package d.a.n0.f1.y;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import d.a.m0.s.e.f;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import d.a.n0.f1.h.l;
import d.a.n0.f1.h.m;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: d.a.n0.f1.y.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1387a extends f0<Integer> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f58494a;

            public C1387a(a aVar, boolean z) {
                this.f58494a = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.m0.z0.f0
            public Integer doInBackground() {
                if (!this.f58494a) {
                    d.a.n0.f1.h.b.a().b();
                }
                return 0;
            }
        }

        /* renamed from: d.a.n0.f1.y.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1388b implements n<Integer> {
            public C1388b(a aVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Integer num) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005018, null));
            }
        }

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null) {
                return;
            }
            boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
            if (!isNull) {
                d.a.m0.s.d.b.g0().f0(new f());
                d.a.m0.s.d.b.g0().b0(0);
                d.a.m0.s.d.b.g0().Z(0);
                d.a.m0.s.d.b.g0().Y(0);
                d.a.m0.s.d.b.g0().c0(0);
                d.a.m0.s.d.b.g0().d0(0);
                d.a.m0.s.d.b.g0().a();
                h0.a();
                m.t().p();
                l.t().p();
            }
            h0.c(new C1387a(this, isNull), new C1388b(this));
        }
    }

    public static void a() {
        MessageManager.getInstance().registerListener(2005016, new a(0));
    }
}
