package d.a.j0.d2.k.e.z0;

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
    public PbFragment f52617a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.d2.i.c f52618b;

    /* renamed from: c  reason: collision with root package name */
    public View f52619c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f52620d = null;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52621e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f52622f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f52623g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f52624h = null;

    /* renamed from: i  reason: collision with root package name */
    public Button f52625i = null;

    /* renamed from: d.a.j0.d2.k.e.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnLongClickListenerC1183a implements View.OnLongClickListener {
        public View$OnLongClickListenerC1183a(a aVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public a(PbFragment pbFragment, d.a.j0.d2.i.c cVar) {
        this.f52617a = pbFragment;
        this.f52618b = cVar;
        c();
    }

    public void a(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.f52619c);
    }

    public boolean b(boolean z) {
        boolean z2;
        Button button = this.f52625i;
        if (button != null && button.getVisibility() == 0) {
            View view = this.f52622f;
            if (view != null) {
                view.setVisibility(0);
            }
            z2 = true;
        } else {
            View view2 = this.f52622f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            z2 = false;
        }
        View view3 = this.f52624h;
        if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
            this.f52623g.setVisibility(0);
        } else {
            this.f52623g.setVisibility(8);
        }
        return z2;
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f52617a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.f52619c = inflate;
        inflate.setOnTouchListener(this.f52618b);
        View findViewById = this.f52619c.findViewById(R.id.pb_head_activity_join_number_container);
        this.f52620d = findViewById;
        findViewById.setVisibility(8);
        this.f52621e = (TextView) this.f52619c.findViewById(R.id.pb_head_activity_join_number);
        this.f52622f = this.f52619c.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.f52623g = this.f52619c.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.f52619c.setOnLongClickListener(new View$OnLongClickListenerC1183a(this));
    }

    public void d(int i2) {
        this.f52617a.getBaseFragmentActivity().getLayoutMode().j(this.f52619c);
    }

    public void e(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f52619c);
        }
    }

    public void f(d.a.j0.d2.h.e eVar) {
        ArrayList<d.a.i0.r.q.b> E = eVar.L().E();
        if (E != null && E.size() > 0) {
            this.f52621e.setText(String.valueOf(E.get(0).f()));
            this.f52620d.setVisibility(0);
        } else {
            this.f52620d.setVisibility(8);
        }
        SkinManager.setBackgroundResource(this.f52620d, R.drawable.activity_join_num_bg);
        SkinManager.setViewTextColor(this.f52621e, R.color.CAM_X0305, 1);
    }

    public void g(d.a.j0.d2.h.e eVar, boolean z) {
        boolean b2 = b(z);
        if (eVar == null || eVar.w() == null || eVar.w().c() != 0 || !z) {
            this.f52623g.setVisibility(8);
        } else if (b2) {
            this.f52623g.setVisibility(0);
        } else {
            this.f52623g.setVisibility(8);
        }
    }
}
