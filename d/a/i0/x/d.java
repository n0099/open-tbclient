package d.a.i0.x;

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
    public Activity f50056a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f50057b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f50058c;

    /* renamed from: d  reason: collision with root package name */
    public View f50059d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.x.c f50060e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50061f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f50062g;

    /* renamed from: h  reason: collision with root package name */
    public int f50063h = 85;

    /* renamed from: i  reason: collision with root package name */
    public int f50064i = 0;
    public CustomMessageListener j = new a(2001011);
    public CustomMessageListener k = new b(2921478);
    public CustomMessageListener l = new c(2001304);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    d.this.f50061f = true;
                    if (d.this.f50056a != null) {
                        d dVar = d.this;
                        dVar.f50057b = dVar.f50056a;
                    }
                    d.this.i(true);
                    return;
                }
                d.this.f50061f = false;
                if (d.this.f50057b != null) {
                    d dVar2 = d.this;
                    dVar2.f50056a = dVar2.f50057b;
                    d.this.f50057b = null;
                    if (d.a.c.a.b.f().i(d.this.f50056a) != -1) {
                        d.this.j();
                        d.this.o(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
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
                if (("0".equals(str) || "1".equals(str)) && (d.this.f50060e instanceof d.a.i0.x.a)) {
                    d.this.i(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || d.this.f50059d == null || d.this.f50060e == null) {
                return;
            }
            d.this.f50060e.d();
        }
    }

    /* renamed from: d.a.i0.x.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1087d implements View.OnClickListener {
        public View$OnClickListenerC1087d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            int g2;
            if (d.this.f50056a != null && (i2 = d.a.c.a.b.f().i(d.this.f50056a)) != -1 && i2 < d.a.c.a.b.f().g() && (g2 = d.a.c.a.b.f().g() - i2) >= 0) {
                d.a.c.a.b.f().m(g2);
            }
            if (d.this.f50060e != null) {
                d.this.f50060e.onClick();
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
        if (this.f50058c == null) {
            this.f50058c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        View view = this.f50059d;
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                if (this.f50058c != null && this.f50059d != null) {
                    this.f50058c.removeView(this.f50059d);
                }
                this.f50058c = null;
                this.f50059d = null;
                return;
            }
            this.f50058c.removeView(this.f50059d);
            this.f50059d = null;
            this.f50058c = null;
            if (z || this.f50061f) {
                return;
            }
            this.f50062g = new e(this);
            d.a.c.e.m.e.a().postDelayed(this.f50062g, 300L);
        } catch (SecurityException unused) {
            this.f50058c = null;
            this.f50059d = null;
        }
    }

    public boolean j() {
        d.a.i0.x.c cVar = this.f50060e;
        if (cVar == null) {
            return false;
        }
        View view = this.f50059d;
        if (view != null) {
            return view.getParent() == null;
        }
        View view2 = cVar.getView();
        this.f50059d = view2;
        view2.setOnClickListener(new View$OnClickListenerC1087d());
        return true;
    }

    public boolean k() {
        View view;
        return (this.f50058c == null || (view = this.f50059d) == null || view.getParent() == null) ? false : true;
    }

    public void l() {
        i(false);
        this.f50057b = null;
        this.f50056a = null;
        this.f50060e = null;
        this.f50059d = null;
        m = null;
        if (this.f50062g != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f50062g);
        }
    }

    public void m(d.a.i0.x.c cVar) {
        this.f50060e = cVar;
    }

    public void n(int i2, int i3, int i4) {
        this.f50063h = i2;
        this.f50064i = i3;
    }

    public void o(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = d.a.j0.p3.c.a(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        int i2 = this.f50064i;
        layoutParams.x = i2;
        layoutParams.y = i2;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = this.f50063h;
        if (this.f50058c == null) {
            this.f50058c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.f50058c = null;
                this.f50059d = null;
            } else if (j()) {
                if (this.f50059d != null && this.f50059d.getParent() == null) {
                    this.f50058c.addView(this.f50059d, layoutParams);
                    if (z) {
                        this.f50056a = d.a.c.a.b.f().b();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.j);
                MessageManager.getInstance().registerListener(this.l);
                MessageManager.getInstance().registerListener(this.k);
            }
        } catch (SecurityException unused) {
            this.f50058c = null;
            this.f50059d = null;
        }
    }
}
