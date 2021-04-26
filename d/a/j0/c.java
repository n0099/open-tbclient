package d.a.j0;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.LogoActivity;
import d.a.j0.s2.r;
import d.a.j0.s2.w;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f51554h;

    /* renamed from: a  reason: collision with root package name */
    public long f51555a;

    /* renamed from: c  reason: collision with root package name */
    public int f51557c = -1;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f51558d = new a(this, 2016522);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f51559e = new b(2016521);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f51560f = new C1146c(2016520);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f51561g = new d(2016523);

    /* renamed from: b  reason: collision with root package name */
    public boolean f51556b = false;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(c cVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || w.p().o() == null) {
                return;
            }
            w.p().o().a();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016521) {
                return;
            }
            c.this.e();
        }
    }

    /* renamed from: d.a.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1146c extends CustomMessageListener {
        public C1146c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || c.this.f51555a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.D)) {
                return;
            }
            if (c.this.f()) {
                if (data instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) data;
                    Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                    intent.putExtra("splash", true);
                    intent.setFlags(65536);
                    baseActivity.startActivity(intent);
                } else if (data instanceof BaseFragmentActivity) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
                TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                return;
            }
            TbadkCoreApplication.getInst().setCanShowHotSplash(1);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016523) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (((Boolean) data).booleanValue()) {
                    c cVar = c.this;
                    cVar.f51556b = currentTimeMillis - cVar.f51555a <= 1;
                }
            }
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f51559e);
        MessageManager.getInstance().registerListener(this.f51560f);
        MessageManager.getInstance().registerListener(this.f51558d);
        MessageManager.getInstance().registerListener(this.f51561g);
        if (w.p().o() != null) {
            w.p().o().c();
        }
    }

    public static c g() {
        if (f51554h == null) {
            synchronized (c.class) {
                if (f51554h == null) {
                    f51554h = new c();
                }
            }
        }
        return f51554h;
    }

    public final void e() {
        this.f51555a = System.currentTimeMillis() / 1000;
    }

    public final boolean f() {
        h();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.f51556b) {
            this.f51556b = false;
            return false;
        }
        long j = this.f51555a;
        if (currentTimeMillis - j > 2 && currentTimeMillis - j > this.f51557c) {
            r o = w.p().o();
            return (o != null ? o.b() : 3) < 3;
        }
        return false;
    }

    public final void h() {
        d.a.i0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            int b2 = adAdSense.b();
            this.f51557c = b2;
            if (b2 <= 0) {
                this.f51557c = 86400;
                return;
            }
            return;
        }
        this.f51557c = 300;
    }
}
