package d.a.j0.q0.w1;

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
import d.a.j0.f0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f58860g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: h  reason: collision with root package name */
    public static final int f58861h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58862a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f58863b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.f0.b f58864c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58865d;

    /* renamed from: e  reason: collision with root package name */
    public e f58866e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58867f = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f58864c.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.j0.f0.a.b
        public void a(int i2, int i3) {
            c.this.i();
        }

        @Override // d.a.j0.f0.a.b
        public void b(int i2, int i3) {
            if (c.this.f58866e == null || !c.this.f58866e.c() || Math.abs(i3) <= c.f58861h) {
                return;
            }
            if (c.this.f58863b != null) {
                c.this.f58863b.setBackgroundResource(R.color.transparent);
            }
            c.this.f58862a.finish();
        }

        @Override // d.a.j0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.j0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* renamed from: d.a.j0.q0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1470c implements View.OnClickListener {
        public View$OnClickListenerC1470c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f58862a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            if (c.this.f58863b != null) {
                c.this.f58863b.setVisibility(8);
            }
            c.this.f58867f = false;
            if (c.this.f58866e != null) {
                c.this.f58866e.b();
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
        this.f58862a = baseActivity;
        this.f58864c = new d.a.j0.f0.b(baseActivity.getPageContext().getPageActivity());
        this.f58865d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a());
        this.f58864c.d(new b());
    }

    public void g() {
        ViewGroup viewGroup;
        if (this.f58867f || (viewGroup = (ViewGroup) this.f58862a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f58862a.getPageContext().getPageActivity());
        this.f58863b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f58863b, 0, new LinearLayout.LayoutParams(-1, f58860g));
        this.f58863b.setVisibility(0);
        this.f58863b.setOnClickListener(new View$OnClickListenerC1470c());
        this.f58863b.setScrollCallBack(new d());
        this.f58862a.setExcludeHeight(f58860g);
        this.f58867f = true;
    }

    public boolean h() {
        return this.f58867f;
    }

    public void i() {
        BlankView blankView;
        if (this.f58867f && this.f58865d != null && (blankView = this.f58863b) != null && blankView.getVisibility() == 0) {
            this.f58865d.setStatusBarVisibility(0);
            this.f58862a.setExcludeHeight(0);
            e eVar = this.f58866e;
            if (eVar != null) {
                eVar.a();
            }
            this.f58863b.a();
        }
    }

    public void j(e eVar) {
        this.f58866e = eVar;
    }

    public void k(int i2) {
        BlankView blankView = this.f58863b;
        if (blankView != null) {
            SkinManager.setBackgroundResource(blankView, i2);
        }
    }
}
