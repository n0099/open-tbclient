package d.a.k0.q0.w1;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
import d.a.c.e.p.l;
import d.a.k0.f0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f59602g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: h  reason: collision with root package name */
    public static final int f59603h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f59604a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f59605b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.f0.b f59606c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59607d;

    /* renamed from: e  reason: collision with root package name */
    public e f59608e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59609f = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f59606c.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.k0.f0.a.b
        public void a(int i2, int i3) {
            c.this.i();
        }

        @Override // d.a.k0.f0.a.b
        public void b(int i2, int i3) {
            if (c.this.f59608e == null || !c.this.f59608e.c() || Math.abs(i3) <= c.f59603h) {
                return;
            }
            if (c.this.f59605b != null) {
                c.this.f59605b.setBackgroundResource(R.color.transparent);
            }
            c.this.f59604a.finish();
        }

        @Override // d.a.k0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.k0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* renamed from: d.a.k0.q0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1544c implements View.OnClickListener {
        public View$OnClickListenerC1544c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f59604a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            if (c.this.f59605b != null) {
                c.this.f59605b.setVisibility(8);
            }
            c.this.f59609f = false;
            if (c.this.f59608e != null) {
                c.this.f59608e.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();

        boolean c();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.f59604a = baseActivity;
        this.f59606c = new d.a.k0.f0.b(baseActivity.getPageContext().getPageActivity());
        this.f59607d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a());
        this.f59606c.d(new b());
    }

    public void g() {
        ViewGroup viewGroup;
        if (this.f59609f || (viewGroup = (ViewGroup) this.f59604a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f59604a.getPageContext().getPageActivity());
        this.f59605b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f59605b, 0, new LinearLayout.LayoutParams(-1, f59602g));
        this.f59605b.setVisibility(0);
        this.f59605b.setOnClickListener(new View$OnClickListenerC1544c());
        this.f59605b.setScrollCallBack(new d());
        this.f59604a.setExcludeHeight(f59602g);
        this.f59609f = true;
    }

    public boolean h() {
        return this.f59609f;
    }

    public void i() {
        BlankView blankView;
        if (this.f59609f && this.f59607d != null && (blankView = this.f59605b) != null && blankView.getVisibility() == 0) {
            this.f59607d.setStatusBarVisibility(0);
            this.f59604a.setExcludeHeight(0);
            e eVar = this.f59608e;
            if (eVar != null) {
                eVar.a();
            }
            this.f59605b.a();
        }
    }

    public void j(e eVar) {
        this.f59608e = eVar;
    }

    public void k(int i2) {
        BlankView blankView = this.f59605b;
        if (blankView != null) {
            SkinManager.setBackgroundResource(blankView, i2);
        }
    }
}
