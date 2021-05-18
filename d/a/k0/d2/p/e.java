package d.a.k0.d2.p;

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
    public BaseFragment f53703f;

    /* renamed from: g  reason: collision with root package name */
    public b f53704g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f53705h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53706i = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(e.this.f53703f.getContext());
            if (e.this.f53704g != null) {
                e.this.f53704g.j0(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void j0(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        this.f53703f = baseFragment;
        this.f53704g = bVar;
    }

    @Override // d.a.c.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f53703f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f39569e = inflate;
        this.f53705h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.a.j0.r.f0.m.a aVar = new d.a.j0.r.f0.m.a();
        BaseFragment baseFragment = this.f53703f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f53705h.setText(this.f53703f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f53705h.setTextSize(R.dimen.tbds42);
        this.f53705h.setConfig(aVar);
        this.f53705h.setOnClickListener(this.f53706i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f39569e;
    }

    @Override // d.a.c.j.e.b
    public void c() {
    }

    public void f(int i2) {
        d.a.j0.s0.a.a(this.f53703f.getPageContext(), this.f39569e);
        TBSpecificationBtn tBSpecificationBtn = this.f53705h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f39569e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
