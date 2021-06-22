package d.a.o0.e2.p;

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
    public BaseFragment f57730f;

    /* renamed from: g  reason: collision with root package name */
    public b f57731g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f57732h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f57733i = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(e.this.f57730f.getContext());
            if (e.this.f57731g != null) {
                e.this.f57731g.m0(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void m0(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        this.f57730f = baseFragment;
        this.f57731g = bVar;
    }

    @Override // d.a.c.k.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f57730f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f43017e = inflate;
        this.f57732h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.a.n0.r.f0.m.a aVar = new d.a.n0.r.f0.m.a();
        BaseFragment baseFragment = this.f57730f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f57732h.setText(this.f57730f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f57732h.setTextSize(R.dimen.tbds42);
        this.f57732h.setConfig(aVar);
        this.f57732h.setOnClickListener(this.f57733i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f43017e;
    }

    @Override // d.a.c.k.e.b
    public void c() {
    }

    public void f(int i2) {
        d.a.n0.s0.a.a(this.f57730f.getPageContext(), this.f43017e);
        TBSpecificationBtn tBSpecificationBtn = this.f57732h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f43017e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
