package d.a.n0.e2.k.e.a1;

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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f53081a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.i.c f53082b;

    /* renamed from: c  reason: collision with root package name */
    public View f53083c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f53084d = null;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53085e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f53086f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f53087g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f53088h = null;

    /* renamed from: i  reason: collision with root package name */
    public Button f53089i = null;

    /* renamed from: d.a.n0.e2.k.e.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnLongClickListenerC1258a implements View.OnLongClickListener {
        public View$OnLongClickListenerC1258a(a aVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public a(PbFragment pbFragment, d.a.n0.e2.i.c cVar) {
        this.f53081a = pbFragment;
        this.f53082b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.f53083c);
    }

    public boolean b(boolean z) {
        boolean z2;
        Button button = this.f53089i;
        if (button != null && button.getVisibility() == 0) {
            View view = this.f53086f;
            if (view != null) {
                view.setVisibility(0);
            }
            z2 = true;
        } else {
            View view2 = this.f53086f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            z2 = false;
        }
        View view3 = this.f53088h;
        if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
            this.f53087g.setVisibility(0);
        } else {
            this.f53087g.setVisibility(8);
        }
        return z2;
    }

    public View c() {
        return this.f53083c;
    }

    public final void d() {
        View inflate = LayoutInflater.from(this.f53081a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.f53083c = inflate;
        inflate.setOnTouchListener(this.f53082b);
        View findViewById = this.f53083c.findViewById(R.id.pb_head_activity_join_number_container);
        this.f53084d = findViewById;
        findViewById.setVisibility(8);
        this.f53085e = (TextView) this.f53083c.findViewById(R.id.pb_head_activity_join_number);
        this.f53086f = this.f53083c.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.f53087g = this.f53083c.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.f53083c.setOnLongClickListener(new View$OnLongClickListenerC1258a(this));
    }

    public void e(int i2) {
        this.f53081a.getBaseFragmentActivity().getLayoutMode().j(this.f53083c);
    }

    public void f(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f53083c);
        }
    }

    public void g(d.a.n0.e2.h.e eVar) {
        ArrayList<d.a.m0.r.q.b> E = eVar.L().E();
        if (E != null && E.size() > 0) {
            this.f53085e.setText(String.valueOf(E.get(0).f()));
            this.f53084d.setVisibility(0);
        } else {
            this.f53084d.setVisibility(8);
        }
        SkinManager.setBackgroundResource(this.f53084d, R.drawable.activity_join_num_bg);
        SkinManager.setViewTextColor(this.f53085e, R.color.CAM_X0305, 1);
    }

    public void h(d.a.n0.e2.h.e eVar, boolean z) {
        boolean b2 = b(z);
        if (eVar == null || eVar.w() == null || eVar.w().c() != 0 || !z) {
            this.f53087g.setVisibility(8);
        } else if (b2) {
            this.f53087g.setVisibility(0);
        } else {
            this.f53087g.setVisibility(8);
        }
    }
}
