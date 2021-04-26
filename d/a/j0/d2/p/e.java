package d.a.j0.d2.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends d.a.c.j.e.b {

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f52996f;

    /* renamed from: g  reason: collision with root package name */
    public b f52997g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f52998h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f52999i = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(e.this.f52996f.getContext());
            if (e.this.f52997g != null) {
                e.this.f52997g.j0(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void j0(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        this.f52996f = baseFragment;
        this.f52997g = bVar;
    }

    @Override // d.a.c.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f52996f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f40324e = inflate;
        this.f52998h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.a.i0.r.f0.m.a aVar = new d.a.i0.r.f0.m.a();
        BaseFragment baseFragment = this.f52996f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f52998h.setText(this.f52996f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f52998h.setTextSize(R.dimen.tbds42);
        this.f52998h.setConfig(aVar);
        this.f52998h.setOnClickListener(this.f52999i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f40324e;
    }

    @Override // d.a.c.j.e.b
    public void c() {
    }

    public void f(int i2) {
        d.a.i0.s0.a.a(this.f52996f.getPageContext(), this.f40324e);
        TBSpecificationBtn tBSpecificationBtn = this.f52998h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f40324e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
