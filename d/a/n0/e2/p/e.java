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
public class e extends d.a.c.k.e.b {

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f57605f;

    /* renamed from: g  reason: collision with root package name */
    public b f57606g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f57607h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f57608i = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(e.this.f57605f.getContext());
            if (e.this.f57606g != null) {
                e.this.f57606g.m0(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void m0(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        this.f57605f = baseFragment;
        this.f57606g = bVar;
    }

    @Override // d.a.c.k.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f57605f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f42914e = inflate;
        this.f57607h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.a.m0.r.f0.m.a aVar = new d.a.m0.r.f0.m.a();
        BaseFragment baseFragment = this.f57605f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f57607h.setText(this.f57605f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f57607h.setTextSize(R.dimen.tbds42);
        this.f57607h.setConfig(aVar);
        this.f57607h.setOnClickListener(this.f57608i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f42914e;
    }

    @Override // d.a.c.k.e.b
    public void c() {
    }

    public void f(int i2) {
        d.a.m0.s0.a.a(this.f57605f.getPageContext(), this.f42914e);
        TBSpecificationBtn tBSpecificationBtn = this.f57607h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f42914e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
