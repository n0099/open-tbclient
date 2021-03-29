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
    public BaseFragment f53298f;

    /* renamed from: g  reason: collision with root package name */
    public b f53299g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f53300h;
    public View.OnClickListener i = new View$OnClickListenerC1183a();

    /* renamed from: d.b.i0.c2.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1183a implements View.OnClickListener {
        public View$OnClickListenerC1183a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(a.this.f53298f.getContext());
            if (a.this.f53299g != null) {
                a.this.f53299g.Y(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void Y(boolean z);
    }

    public a(BaseFragment baseFragment, b bVar) {
        this.f53298f = baseFragment;
        this.f53299g = bVar;
    }

    @Override // d.b.b.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f53298f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f42362e = inflate;
        this.f53300h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        BaseFragment baseFragment = this.f53298f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f53300h.setText(this.f53298f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f53300h.setTextSize(R.dimen.tbds42);
        this.f53300h.setConfig(aVar);
        this.f53300h.setOnClickListener(this.i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f42362e;
    }

    @Override // d.b.b.j.e.b
    public void c() {
    }

    public void f(int i) {
        d.b.h0.s0.a.a(this.f53298f.getPageContext(), this.f42362e);
        TBSpecificationBtn tBSpecificationBtn = this.f53300h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f42362e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
