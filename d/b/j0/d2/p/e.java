package d.b.j0.d2.p;

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
    public BaseFragment f55161f;

    /* renamed from: g  reason: collision with root package name */
    public b f55162g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f55163h;
    public View.OnClickListener i = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.skipToLoginActivity(e.this.f55161f.getContext());
            if (e.this.f55162g != null) {
                e.this.f55162g.Y(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Y(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        this.f55161f = baseFragment;
        this.f55162g = bVar;
    }

    @Override // d.b.c.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f55161f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.f43099e = inflate;
        this.f55163h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
        d.b.i0.r.f0.m.a aVar = new d.b.i0.r.f0.m.a();
        BaseFragment baseFragment = this.f55161f;
        if (baseFragment != null && baseFragment.getContext() != null) {
            this.f55163h.setText(this.f55161f.getContext().getResources().getString(R.string.login_see_more));
        }
        this.f55163h.setTextSize(R.dimen.tbds42);
        this.f55163h.setConfig(aVar);
        this.f55163h.setOnClickListener(this.i);
        f(TbadkCoreApplication.getInst().getSkinType());
        return this.f43099e;
    }

    @Override // d.b.c.j.e.b
    public void c() {
    }

    public void f(int i) {
        d.b.i0.s0.a.a(this.f55161f.getPageContext(), this.f43099e);
        TBSpecificationBtn tBSpecificationBtn = this.f55163h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    public void g() {
        this.f43099e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
