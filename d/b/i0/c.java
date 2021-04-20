package d.b.i0;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.LogoActivity;
import d.b.i0.s2.r;
import d.b.i0.s2.v;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f53380h;

    /* renamed from: a  reason: collision with root package name */
    public long f53381a;

    /* renamed from: c  reason: collision with root package name */
    public int f53383c = -1;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f53384d = new a(this, 2016522);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f53385e = new b(2016521);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f53386f = new C1184c(2016520);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f53387g = new d(2016523);

    /* renamed from: b  reason: collision with root package name */
    public boolean f53382b = false;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(c cVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || v.p().m() == null) {
                return;
            }
            v.p().m().a();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
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

    /* renamed from: d.b.i0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1184c extends CustomMessageListener {
        public C1184c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || c.this.f53381a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.z)) {
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
        public d(int i) {
            super(i);
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
                    cVar.f53382b = currentTimeMillis - cVar.f53381a <= 1;
                }
            }
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f53385e);
        MessageManager.getInstance().registerListener(this.f53386f);
        MessageManager.getInstance().registerListener(this.f53384d);
        MessageManager.getInstance().registerListener(this.f53387g);
        if (v.p().m() != null) {
            v.p().m().c();
        }
    }

    public static c g() {
        if (f53380h == null) {
            synchronized (c.class) {
                if (f53380h == null) {
                    f53380h = new c();
                }
            }
        }
        return f53380h;
    }

    public final void e() {
        this.f53381a = System.currentTimeMillis() / 1000;
    }

    public final boolean f() {
        h();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.f53382b) {
            this.f53382b = false;
            return false;
        }
        long j = this.f53381a;
        if (currentTimeMillis - j > 2 && currentTimeMillis - j > this.f53383c) {
            r m = v.p().m();
            return (m != null ? m.b() : 3) < 3;
        }
        return false;
    }

    public final void h() {
        d.b.h0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            int b2 = adAdSense.b();
            this.f53383c = b2;
            if (b2 <= 0) {
                this.f53383c = 86400;
                return;
            }
            return;
        }
        this.f53383c = 300;
    }
}
