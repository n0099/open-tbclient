package d.a.n0.r0.w1;

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
import d.a.n0.g0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f59743g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: h  reason: collision with root package name */
    public static final int f59744h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f59745a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f59746b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.g0.b f59747c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59748d;

    /* renamed from: e  reason: collision with root package name */
    public e f59749e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59750f = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f59747c.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            c.this.i();
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            if (c.this.f59749e == null || !c.this.f59749e.c() || Math.abs(i3) <= c.f59744h) {
                return;
            }
            if (c.this.f59746b != null) {
                c.this.f59746b.setBackgroundResource(R.color.transparent);
            }
            c.this.f59745a.finish();
        }

        @Override // d.a.n0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.n0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* renamed from: d.a.n0.r0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1557c implements View.OnClickListener {
        public View$OnClickListenerC1557c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f59745a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            if (c.this.f59746b != null) {
                c.this.f59746b.setVisibility(8);
            }
            c.this.f59750f = false;
            if (c.this.f59749e != null) {
                c.this.f59749e.b();
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
        this.f59745a = baseActivity;
        this.f59747c = new d.a.n0.g0.b(baseActivity.getPageContext().getPageActivity());
        this.f59748d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a());
        this.f59747c.d(new b());
    }

    public void g() {
        ViewGroup viewGroup;
        if (this.f59750f || (viewGroup = (ViewGroup) this.f59745a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f59745a.getPageContext().getPageActivity());
        this.f59746b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f59746b, 0, new LinearLayout.LayoutParams(-1, f59743g));
        this.f59746b.setVisibility(0);
        this.f59746b.setOnClickListener(new View$OnClickListenerC1557c());
        this.f59746b.setScrollCallBack(new d());
        this.f59745a.setExcludeHeight(f59743g);
        this.f59750f = true;
    }

    public boolean h() {
        return this.f59750f;
    }

    public void i() {
        BlankView blankView;
        if (this.f59750f && this.f59748d != null && (blankView = this.f59746b) != null && blankView.getVisibility() == 0) {
            this.f59748d.setStatusBarVisibility(0);
            this.f59745a.setExcludeHeight(0);
            e eVar = this.f59749e;
            if (eVar != null) {
                eVar.a();
            }
            this.f59746b.a();
        }
    }

    public void j(e eVar) {
        this.f59749e = eVar;
    }

    public void k(int i2) {
        BlankView blankView = this.f59746b;
        if (blankView != null) {
            SkinManager.setBackgroundResource(blankView, i2);
        }
    }
}
