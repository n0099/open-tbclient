package d.b.i0.q0.w1;

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
import d.b.i0.f0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f60328g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: h  reason: collision with root package name */
    public static final int f60329h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f60330a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f60331b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.f0.b f60332c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60333d;

    /* renamed from: e  reason: collision with root package name */
    public e f60334e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60335f = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f60332c.c(motionEvent);
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
            if (c.this.f60334e == null || !c.this.f60334e.c() || Math.abs(i2) <= c.f60329h) {
                return;
            }
            if (c.this.f60331b != null) {
                c.this.f60331b.setBackgroundResource(R.color.transparent);
            }
            c.this.f60330a.finish();
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* renamed from: d.b.i0.q0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1508c implements View.OnClickListener {
        public View$OnClickListenerC1508c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f60330a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            if (c.this.f60331b != null) {
                c.this.f60331b.setVisibility(8);
            }
            c.this.f60335f = false;
            if (c.this.f60334e != null) {
                c.this.f60334e.b();
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
        this.f60330a = baseActivity;
        this.f60332c = new d.b.i0.f0.b(baseActivity.getPageContext().getPageActivity());
        this.f60333d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a());
        this.f60332c.d(new b());
    }

    public void g() {
        ViewGroup viewGroup;
        if (this.f60335f || (viewGroup = (ViewGroup) this.f60330a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f60330a.getPageContext().getPageActivity());
        this.f60331b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f60331b, 0, new LinearLayout.LayoutParams(-1, f60328g));
        this.f60331b.setVisibility(0);
        this.f60331b.setOnClickListener(new View$OnClickListenerC1508c());
        this.f60331b.setScrollCallBack(new d());
        this.f60330a.setExcludeHeight(f60328g);
        this.f60335f = true;
    }

    public boolean h() {
        return this.f60335f;
    }

    public void i() {
        BlankView blankView;
        if (this.f60335f && this.f60333d != null && (blankView = this.f60331b) != null && blankView.getVisibility() == 0) {
            this.f60333d.setStatusBarVisibility(0);
            this.f60330a.setExcludeHeight(0);
            e eVar = this.f60334e;
            if (eVar != null) {
                eVar.a();
            }
            this.f60331b.a();
        }
    }

    public void j(e eVar) {
        this.f60334e = eVar;
    }

    public void k(int i) {
        BlankView blankView = this.f60331b;
        if (blankView != null) {
            SkinManager.setBackgroundResource(blankView, i);
        }
    }
}
