package d.b.h0.x;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {
    public static d m;

    /* renamed from: a  reason: collision with root package name */
    public Activity f52044a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f52045b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f52046c;

    /* renamed from: d  reason: collision with root package name */
    public View f52047d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.x.c f52048e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52049f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f52050g;

    /* renamed from: h  reason: collision with root package name */
    public int f52051h = 85;
    public int i = 0;
    public CustomMessageListener j = new a(2001011);
    public CustomMessageListener k = new b(2921478);
    public CustomMessageListener l = new c(2001304);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    d.this.f52049f = true;
                    if (d.this.f52044a != null) {
                        d dVar = d.this;
                        dVar.f52045b = dVar.f52044a;
                    }
                    d.this.i(true);
                    return;
                }
                d.this.f52049f = false;
                if (d.this.f52045b != null) {
                    d dVar2 = d.this;
                    dVar2.f52044a = dVar2.f52045b;
                    d.this.f52045b = null;
                    if (d.b.c.a.b.f().i(d.this.f52044a) != -1) {
                        d.this.j();
                        d.this.o(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || (map = (Map) customResponsedMessage.getData()) == null) {
                return;
            }
            String str = (String) map.get("lifeCycle");
            if ("BarBroadcastEdit".equals((String) map.get("name"))) {
                if (("0".equals(str) || "1".equals(str)) && (d.this.f52048e instanceof d.b.h0.x.a)) {
                    d.this.i(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || d.this.f52047d == null || d.this.f52048e == null) {
                return;
            }
            d.this.f52048e.d();
        }
    }

    /* renamed from: d.b.h0.x.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1126d implements View.OnClickListener {
        public View$OnClickListenerC1126d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            int g2;
            if (d.this.f52044a != null && (i = d.b.c.a.b.f().i(d.this.f52044a)) != -1 && i < d.b.c.a.b.f().g() && (g2 = d.b.c.a.b.f().g() - i) >= 0) {
                d.b.c.a.b.f().m(g2);
            }
            if (d.this.f52048e != null) {
                d.this.f52048e.onClick();
            }
            d.this.i(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 1));
        }
    }

    public static d h() {
        if (m == null) {
            m = new d();
        }
        return m;
    }

    public void i(boolean z) {
        if (this.f52046c == null) {
            this.f52046c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        View view = this.f52047d;
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                if (this.f52046c != null && this.f52047d != null) {
                    this.f52046c.removeView(this.f52047d);
                }
                this.f52046c = null;
                this.f52047d = null;
                return;
            }
            this.f52046c.removeView(this.f52047d);
            this.f52047d = null;
            this.f52046c = null;
            if (z || this.f52049f) {
                return;
            }
            this.f52050g = new e(this);
            d.b.c.e.m.e.a().postDelayed(this.f52050g, 300L);
        } catch (SecurityException unused) {
            this.f52046c = null;
            this.f52047d = null;
        }
    }

    public boolean j() {
        d.b.h0.x.c cVar = this.f52048e;
        if (cVar == null) {
            return false;
        }
        View view = this.f52047d;
        if (view != null) {
            return view.getParent() == null;
        }
        View view2 = cVar.getView();
        this.f52047d = view2;
        view2.setOnClickListener(new View$OnClickListenerC1126d());
        return true;
    }

    public boolean k() {
        View view;
        return (this.f52046c == null || (view = this.f52047d) == null || view.getParent() == null) ? false : true;
    }

    public void l() {
        i(false);
        this.f52045b = null;
        this.f52044a = null;
        this.f52048e = null;
        this.f52047d = null;
        m = null;
        if (this.f52050g != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f52050g);
        }
    }

    public void m(d.b.h0.x.c cVar) {
        this.f52048e = cVar;
    }

    public void n(int i, int i2, int i3) {
        this.f52051h = i;
        this.i = i2;
    }

    public void o(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = d.b.i0.p3.c.a(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        int i = this.i;
        layoutParams.x = i;
        layoutParams.y = i;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = this.f52051h;
        if (this.f52046c == null) {
            this.f52046c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.f52046c = null;
                this.f52047d = null;
            } else if (j()) {
                if (this.f52047d != null && this.f52047d.getParent() == null) {
                    this.f52046c.addView(this.f52047d, layoutParams);
                    if (z) {
                        this.f52044a = d.b.c.a.b.f().b();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.j);
                MessageManager.getInstance().registerListener(this.l);
                MessageManager.getInstance().registerListener(this.k);
            }
        } catch (SecurityException unused) {
            this.f52046c = null;
            this.f52047d = null;
        }
    }
}
