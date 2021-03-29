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
    public Activity f51626a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f51627b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f51628c;

    /* renamed from: d  reason: collision with root package name */
    public View f51629d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.x.c f51630e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51631f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f51632g;

    /* renamed from: h  reason: collision with root package name */
    public int f51633h = 85;
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
                    d.this.f51631f = true;
                    if (d.this.f51626a != null) {
                        d dVar = d.this;
                        dVar.f51627b = dVar.f51626a;
                    }
                    d.this.i(true);
                    return;
                }
                d.this.f51631f = false;
                if (d.this.f51627b != null) {
                    d dVar2 = d.this;
                    dVar2.f51626a = dVar2.f51627b;
                    d.this.f51627b = null;
                    if (d.b.b.a.b.f().i(d.this.f51626a) != -1) {
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
                if (("0".equals(str) || "1".equals(str)) && (d.this.f51630e instanceof d.b.h0.x.a)) {
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || d.this.f51629d == null || d.this.f51630e == null) {
                return;
            }
            d.this.f51630e.d();
        }
    }

    /* renamed from: d.b.h0.x.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1113d implements View.OnClickListener {
        public View$OnClickListenerC1113d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            int g2;
            if (d.this.f51626a != null && (i = d.b.b.a.b.f().i(d.this.f51626a)) != -1 && i < d.b.b.a.b.f().g() && (g2 = d.b.b.a.b.f().g() - i) >= 0) {
                d.b.b.a.b.f().m(g2);
            }
            if (d.this.f51630e != null) {
                d.this.f51630e.onClick();
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
        if (this.f51628c == null) {
            this.f51628c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        View view = this.f51629d;
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                if (this.f51628c != null && this.f51629d != null) {
                    this.f51628c.removeView(this.f51629d);
                }
                this.f51628c = null;
                this.f51629d = null;
                return;
            }
            this.f51628c.removeView(this.f51629d);
            this.f51629d = null;
            this.f51628c = null;
            if (z || this.f51631f) {
                return;
            }
            this.f51632g = new e(this);
            d.b.b.e.m.e.a().postDelayed(this.f51632g, 300L);
        } catch (SecurityException unused) {
            this.f51628c = null;
            this.f51629d = null;
        }
    }

    public boolean j() {
        d.b.h0.x.c cVar = this.f51630e;
        if (cVar == null) {
            return false;
        }
        View view = this.f51629d;
        if (view != null) {
            return view.getParent() == null;
        }
        View view2 = cVar.getView();
        this.f51629d = view2;
        view2.setOnClickListener(new View$OnClickListenerC1113d());
        return true;
    }

    public boolean k() {
        View view;
        return (this.f51628c == null || (view = this.f51629d) == null || view.getParent() == null) ? false : true;
    }

    public void l() {
        i(false);
        this.f51627b = null;
        this.f51626a = null;
        this.f51630e = null;
        this.f51629d = null;
        m = null;
        if (this.f51632g != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.f51632g);
        }
    }

    public void m(d.b.h0.x.c cVar) {
        this.f51630e = cVar;
    }

    public void n(int i, int i2, int i3) {
        this.f51633h = i;
        this.i = i2;
    }

    public void o(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = d.b.i0.o3.c.a(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        int i = this.i;
        layoutParams.x = i;
        layoutParams.y = i;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = this.f51633h;
        if (this.f51628c == null) {
            this.f51628c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.f51628c = null;
                this.f51629d = null;
            } else if (j()) {
                if (this.f51629d != null && this.f51629d.getParent() == null) {
                    this.f51628c.addView(this.f51629d, layoutParams);
                    if (z) {
                        this.f51626a = d.b.b.a.b.f().b();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.j);
                MessageManager.getInstance().registerListener(this.l);
                MessageManager.getInstance().registerListener(this.k);
            }
        } catch (SecurityException unused) {
            this.f51628c = null;
            this.f51629d = null;
        }
    }
}
