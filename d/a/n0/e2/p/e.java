package d.a.n0.e2.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class e extends d.a.c.j.e.b {

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f53916f;

    /* renamed from: g  reason: collision with root package name */
    public b f53917g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f53918h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53919i = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(e.this.f53916f.getContext());
            if (e.this.f53917g != null) {
                e.this.f53917g.j0(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void j0(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        this.f53916f = baseFragment;
        this.f53917g = bVar;
    }

    @Override // d.a.c.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f53916f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f39233e = inflate;
        this.f53918h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.a.m0.r.f0.m.a aVar = new d.a.m0.r.f0.m.a();
        BaseFragment baseFragment = this.f53916f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f53918h.setText(this.f53916f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f53918h.setTextSize(R.dimen.tbds42);
        this.f53918h.setConfig(aVar);
        this.f53918h.setOnClickListener(this.f53919i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f39233e;
    }

    @Override // d.a.c.j.e.b
    public void c() {
    }

    public void f(int i2) {
        d.a.m0.s0.a.a(this.f53916f.getPageContext(), this.f39233e);
        TBSpecificationBtn tBSpecificationBtn = this.f53918h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f39233e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
