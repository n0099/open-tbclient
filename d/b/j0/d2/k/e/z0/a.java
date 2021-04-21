package d.b.j0.d2.k.e.z0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f54802a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.d2.i.c f54803b;

    /* renamed from: c  reason: collision with root package name */
    public View f54804c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f54805d = null;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54806e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f54807f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f54808g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f54809h = null;
    public Button i = null;

    /* renamed from: d.b.j0.d2.k.e.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnLongClickListenerC1244a implements View.OnLongClickListener {
        public View$OnLongClickListenerC1244a(a aVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public a(PbFragment pbFragment, d.b.j0.d2.i.c cVar) {
        this.f54802a = pbFragment;
        this.f54803b = cVar;
        c();
    }

    public void a(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.f54804c);
    }

    public boolean b(boolean z) {
        boolean z2;
        Button button = this.i;
        if (button != null && button.getVisibility() == 0) {
            View view = this.f54807f;
            if (view != null) {
                view.setVisibility(0);
            }
            z2 = true;
        } else {
            View view2 = this.f54807f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            z2 = false;
        }
        View view3 = this.f54809h;
        if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
            this.f54808g.setVisibility(0);
        } else {
            this.f54808g.setVisibility(8);
        }
        return z2;
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f54802a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.f54804c = inflate;
        inflate.setOnTouchListener(this.f54803b);
        View findViewById = this.f54804c.findViewById(R.id.pb_head_activity_join_number_container);
        this.f54805d = findViewById;
        findViewById.setVisibility(8);
        this.f54806e = (TextView) this.f54804c.findViewById(R.id.pb_head_activity_join_number);
        this.f54807f = this.f54804c.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.f54808g = this.f54804c.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.f54804c.setOnLongClickListener(new View$OnLongClickListenerC1244a(this));
    }

    public void d(int i) {
        this.f54802a.getBaseFragmentActivity().getLayoutMode().j(this.f54804c);
    }

    public void e(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f54804c);
        }
    }

    public void f(d.b.j0.d2.h.e eVar) {
        ArrayList<d.b.i0.r.q.b> E = eVar.L().E();
        if (E != null && E.size() > 0) {
            this.f54806e.setText(String.valueOf(E.get(0).f()));
            this.f54805d.setVisibility(0);
        } else {
            this.f54805d.setVisibility(8);
        }
        SkinManager.setBackgroundResource(this.f54805d, R.drawable.activity_join_num_bg);
        SkinManager.setViewTextColor(this.f54806e, R.color.CAM_X0305, 1);
    }

    public void g(d.b.j0.d2.h.e eVar, boolean z) {
        boolean b2 = b(z);
        if (eVar == null || eVar.w() == null || eVar.w().c() != 0 || !z) {
            this.f54808g.setVisibility(8);
        } else if (b2) {
            this.f54808g.setVisibility(0);
        } else {
            this.f54808g.setVisibility(8);
        }
    }
}
