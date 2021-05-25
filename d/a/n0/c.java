package d.a.n0;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.LogoActivity;
import d.a.n0.t2.s;
import d.a.n0.t2.x;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f52275h;

    /* renamed from: a  reason: collision with root package name */
    public long f52276a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.k.c f52278c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f52279d = new a(this, 2016522);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f52280e = new b(2016521);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f52281f = new C1228c(2016520);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f52282g = new d(2016523);

    /* renamed from: b  reason: collision with root package name */
    public boolean f52277b = false;

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
            x.p().o().b();
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

    /* renamed from: d.a.n0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1228c extends CustomMessageListener {
        public C1228c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || c.this.f52276a == 0) {
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
                    cVar.f52277b = currentTimeMillis - cVar.f52276a <= 1;
                }
            }
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f52280e);
        MessageManager.getInstance().registerListener(this.f52281f);
        MessageManager.getInstance().registerListener(this.f52279d);
        MessageManager.getInstance().registerListener(this.f52282g);
        if (x.p().o() != null) {
            x.p().o().c();
        }
    }

    public static c g() {
        if (f52275h == null) {
            synchronized (c.class) {
                if (f52275h == null) {
                    f52275h = new c();
                }
            }
        }
        return f52275h;
    }

    public final void e() {
        this.f52276a = System.currentTimeMillis() / 1000;
    }

    public final boolean f() {
        int h2 = h();
        int i2 = i();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.f52277b) {
            this.f52277b = false;
            return false;
        }
        long j = this.f52276a;
        if (currentTimeMillis - j > 2 && currentTimeMillis - j > h2) {
            s o = x.p().o();
            return (o != null ? o.a() : i2) < i2;
        }
        return false;
    }

    public final int h() {
        CustomResponsedMessage runTask;
        if (this.f52278c == null && (runTask = MessageManager.getInstance().runTask(2921564, d.a.m0.k.c.class)) != null) {
            this.f52278c = (d.a.m0.k.c) runTask.getData();
        }
        d.a.m0.k.c cVar = this.f52278c;
        if (cVar != null) {
            return (int) (cVar.a() * 60.0f);
        }
        d.a.m0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            int b2 = adAdSense.b();
            if (b2 <= 0) {
                return 86400;
            }
            return b2;
        }
        return 300;
    }

    public final int i() {
        CustomResponsedMessage runTask;
        if (this.f52278c == null && (runTask = MessageManager.getInstance().runTask(2921564, d.a.m0.k.c.class)) != null) {
            this.f52278c = (d.a.m0.k.c) runTask.getData();
        }
        d.a.m0.k.c cVar = this.f52278c;
        if (cVar != null) {
            return cVar.b();
        }
        return 3;
    }
}
