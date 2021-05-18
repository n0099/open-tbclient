package d.a.k0;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.LogoActivity;
import d.a.k0.s2.s;
import d.a.k0.s2.x;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f52253h;

    /* renamed from: a  reason: collision with root package name */
    public long f52254a;

    /* renamed from: c  reason: collision with root package name */
    public int f52256c = -1;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f52257d = new a(this, 2016522);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f52258e = new b(2016521);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f52259f = new C1218c(2016520);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f52260g = new d(2016523);

    /* renamed from: b  reason: collision with root package name */
    public boolean f52255b = false;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(c cVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || x.p().o() == null) {
                return;
            }
            x.p().o().a();
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

    /* renamed from: d.a.k0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1218c extends CustomMessageListener {
        public C1218c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || c.this.f52254a == 0) {
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
                    cVar.f52255b = currentTimeMillis - cVar.f52254a <= 1;
                }
            }
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f52258e);
        MessageManager.getInstance().registerListener(this.f52259f);
        MessageManager.getInstance().registerListener(this.f52257d);
        MessageManager.getInstance().registerListener(this.f52260g);
        if (x.p().o() != null) {
            x.p().o().c();
        }
    }

    public static c g() {
        if (f52253h == null) {
            synchronized (c.class) {
                if (f52253h == null) {
                    f52253h = new c();
                }
            }
        }
        return f52253h;
    }

    public final void e() {
        this.f52254a = System.currentTimeMillis() / 1000;
    }

    public final boolean f() {
        h();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.f52255b) {
            this.f52255b = false;
            return false;
        }
        long j = this.f52254a;
        if (currentTimeMillis - j > 2 && currentTimeMillis - j > this.f52256c) {
            s o = x.p().o();
            return (o != null ? o.b() : 3) < 3;
        }
        return false;
    }

    public final void h() {
        d.a.j0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            int b2 = adAdSense.b();
            this.f52256c = b2;
            if (b2 <= 0) {
                this.f52256c = 86400;
                return;
            }
            return;
        }
        this.f52256c = 300;
    }
}
