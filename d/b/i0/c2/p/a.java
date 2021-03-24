package d.b.i0.c2.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends d.b.b.j.e.b {

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f53297f;

    /* renamed from: g  reason: collision with root package name */
    public b f53298g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f53299h;
    public View.OnClickListener i = new View$OnClickListenerC1182a();

    /* renamed from: d.b.i0.c2.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1182a implements View.OnClickListener {
        public View$OnClickListenerC1182a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(a.this.f53297f.getContext());
            if (a.this.f53298g != null) {
                a.this.f53298g.Y(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void Y(boolean z);
    }

    public a(BaseFragment baseFragment, b bVar) {
        this.f53297f = baseFragment;
        this.f53298g = bVar;
    }

    @Override // d.b.b.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f53297f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f42361e = inflate;
        this.f53299h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        BaseFragment baseFragment = this.f53297f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f53299h.setText(this.f53297f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f53299h.setTextSize(R.dimen.tbds42);
        this.f53299h.setConfig(aVar);
        this.f53299h.setOnClickListener(this.i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f42361e;
    }

    @Override // d.b.b.j.e.b
    public void c() {
    }

    public void f(int i) {
        d.b.h0.s0.a.a(this.f53297f.getPageContext(), this.f42361e);
        TBSpecificationBtn tBSpecificationBtn = this.f53299h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f42361e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
