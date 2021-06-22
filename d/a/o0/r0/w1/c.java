package d.a.o0.r0.w1;

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
import d.a.o0.g0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f63559g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: h  reason: collision with root package name */
    public static final int f63560h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f63561a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f63562b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.g0.b f63563c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f63564d;

    /* renamed from: e  reason: collision with root package name */
    public e f63565e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63566f = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f63563c.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.o0.g0.a.b
        public void a(int i2, int i3) {
            c.this.i();
        }

        @Override // d.a.o0.g0.a.b
        public void b(int i2, int i3) {
            if (c.this.f63565e == null || !c.this.f63565e.c() || Math.abs(i3) <= c.f63560h) {
                return;
            }
            if (c.this.f63562b != null) {
                c.this.f63562b.setBackgroundResource(R.color.transparent);
            }
            c.this.f63561a.finish();
        }

        @Override // d.a.o0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.o0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* renamed from: d.a.o0.r0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1617c implements View.OnClickListener {
        public View$OnClickListenerC1617c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f63561a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            if (c.this.f63562b != null) {
                c.this.f63562b.setVisibility(8);
            }
            c.this.f63566f = false;
            if (c.this.f63565e != null) {
                c.this.f63565e.b();
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
        this.f63561a = baseActivity;
        this.f63563c = new d.a.o0.g0.b(baseActivity.getPageContext().getPageActivity());
        this.f63564d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a());
        this.f63563c.d(new b());
    }

    public void g() {
        ViewGroup viewGroup;
        if (this.f63566f || (viewGroup = (ViewGroup) this.f63561a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f63561a.getPageContext().getPageActivity());
        this.f63562b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f63562b, 0, new LinearLayout.LayoutParams(-1, f63559g));
        this.f63562b.setVisibility(0);
        this.f63562b.setOnClickListener(new View$OnClickListenerC1617c());
        this.f63562b.setScrollCallBack(new d());
        this.f63561a.setExcludeHeight(f63559g);
        this.f63566f = true;
    }

    public boolean h() {
        return this.f63566f;
    }

    public void i() {
        BlankView blankView;
        if (this.f63566f && this.f63564d != null && (blankView = this.f63562b) != null && blankView.getVisibility() == 0) {
            this.f63564d.setStatusBarVisibility(0);
            this.f63561a.setExcludeHeight(0);
            e eVar = this.f63565e;
            if (eVar != null) {
                eVar.a();
            }
            this.f63562b.a();
        }
    }

    public void j(e eVar) {
        this.f63565e = eVar;
    }

    public void k(int i2) {
        BlankView blankView = this.f63562b;
        if (blankView != null) {
            SkinManager.setBackgroundResource(blankView, i2);
        }
    }
}
