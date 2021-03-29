package d.b.i0.p0.w1;

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
import d.b.b.e.p.l;
import d.b.i0.f0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f58660g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: h  reason: collision with root package name */
    public static final int f58661h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58662a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f58663b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.f0.b f58664c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58665d;

    /* renamed from: e  reason: collision with root package name */
    public e f58666e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58667f = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f58664c.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            c.this.i();
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            if (c.this.f58666e == null || !c.this.f58666e.c() || Math.abs(i2) <= c.f58661h) {
                return;
            }
            if (c.this.f58663b != null) {
                c.this.f58663b.setBackgroundResource(R.color.transparent);
            }
            c.this.f58662a.finish();
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* renamed from: d.b.i0.p0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1445c implements View.OnClickListener {
        public View$OnClickListenerC1445c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f58662a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            if (c.this.f58663b != null) {
                c.this.f58663b.setVisibility(8);
            }
            c.this.f58667f = false;
            if (c.this.f58666e != null) {
                c.this.f58666e.b();
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
        this.f58662a = baseActivity;
        this.f58664c = new d.b.i0.f0.b(baseActivity.getPageContext().getPageActivity());
        this.f58665d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a());
        this.f58664c.d(new b());
    }

    public void g() {
        ViewGroup viewGroup;
        if (this.f58667f || (viewGroup = (ViewGroup) this.f58662a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f58662a.getPageContext().getPageActivity());
        this.f58663b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f58663b, 0, new LinearLayout.LayoutParams(-1, f58660g));
        this.f58663b.setVisibility(0);
        this.f58663b.setOnClickListener(new View$OnClickListenerC1445c());
        this.f58663b.setScrollCallBack(new d());
        this.f58662a.setExcludeHeight(f58660g);
        this.f58667f = true;
    }

    public boolean h() {
        return this.f58667f;
    }

    public void i() {
        BlankView blankView;
        if (this.f58667f && this.f58665d != null && (blankView = this.f58663b) != null && blankView.getVisibility() == 0) {
            this.f58665d.setStatusBarVisibility(0);
            this.f58662a.setExcludeHeight(0);
            e eVar = this.f58666e;
            if (eVar != null) {
                eVar.a();
            }
            this.f58663b.a();
        }
    }

    public void j(e eVar) {
        this.f58666e = eVar;
    }

    public void k(int i) {
        BlankView blankView = this.f58663b;
        if (blankView != null) {
            SkinManager.setBackgroundResource(blankView, i);
        }
    }
}
