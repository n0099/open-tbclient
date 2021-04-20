package d.b.i0.d2.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends d.b.c.j.e.b {

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f54740f;

    /* renamed from: g  reason: collision with root package name */
    public b f54741g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f54742h;
    public View.OnClickListener i = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(e.this.f54740f.getContext());
            if (e.this.f54741g != null) {
                e.this.f54741g.Y(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Y(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        this.f54740f = baseFragment;
        this.f54741g = bVar;
    }

    @Override // d.b.c.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f54740f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f42859e = inflate;
        this.f54742h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        BaseFragment baseFragment = this.f54740f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f54742h.setText(this.f54740f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f54742h.setTextSize(R.dimen.tbds42);
        this.f54742h.setConfig(aVar);
        this.f54742h.setOnClickListener(this.i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f42859e;
    }

    @Override // d.b.c.j.e.b
    public void c() {
    }

    public void f(int i) {
        d.b.h0.s0.a.a(this.f54740f.getPageContext(), this.f42859e);
        TBSpecificationBtn tBSpecificationBtn = this.f54742h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f42859e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
