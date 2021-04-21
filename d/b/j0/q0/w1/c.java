package d.b.j0.q0.w1;

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
import d.b.c.e.p.l;
import d.b.j0.f0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f60749g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: h  reason: collision with root package name */
    public static final int f60750h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f60751a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f60752b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.f0.b f60753c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60754d;

    /* renamed from: e  reason: collision with root package name */
    public e f60755e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60756f = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f60753c.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.j0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.j0.f0.a.b
        public void b(int i, int i2) {
            c.this.i();
        }

        @Override // d.b.j0.f0.a.b
        public void c(int i, int i2) {
            if (c.this.f60755e == null || !c.this.f60755e.c() || Math.abs(i2) <= c.f60750h) {
                return;
            }
            if (c.this.f60752b != null) {
                c.this.f60752b.setBackgroundResource(R.color.transparent);
            }
            c.this.f60751a.finish();
        }

        @Override // d.b.j0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* renamed from: d.b.j0.q0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1531c implements View.OnClickListener {
        public View$OnClickListenerC1531c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f60751a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            if (c.this.f60752b != null) {
                c.this.f60752b.setVisibility(8);
            }
            c.this.f60756f = false;
            if (c.this.f60755e != null) {
                c.this.f60755e.b();
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
        this.f60751a = baseActivity;
        this.f60753c = new d.b.j0.f0.b(baseActivity.getPageContext().getPageActivity());
        this.f60754d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a());
        this.f60753c.d(new b());
    }

    public void g() {
        ViewGroup viewGroup;
        if (this.f60756f || (viewGroup = (ViewGroup) this.f60751a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f60751a.getPageContext().getPageActivity());
        this.f60752b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f60752b, 0, new LinearLayout.LayoutParams(-1, f60749g));
        this.f60752b.setVisibility(0);
        this.f60752b.setOnClickListener(new View$OnClickListenerC1531c());
        this.f60752b.setScrollCallBack(new d());
        this.f60751a.setExcludeHeight(f60749g);
        this.f60756f = true;
    }

    public boolean h() {
        return this.f60756f;
    }

    public void i() {
        BlankView blankView;
        if (this.f60756f && this.f60754d != null && (blankView = this.f60752b) != null && blankView.getVisibility() == 0) {
            this.f60754d.setStatusBarVisibility(0);
            this.f60751a.setExcludeHeight(0);
            e eVar = this.f60755e;
            if (eVar != null) {
                eVar.a();
            }
            this.f60752b.a();
        }
    }

    public void j(e eVar) {
        this.f60755e = eVar;
    }

    public void k(int i) {
        BlankView blankView = this.f60752b;
        if (blankView != null) {
            SkinManager.setBackgroundResource(blankView, i);
        }
    }
}
