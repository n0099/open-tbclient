package d.a.k0.d2.k.e.z0;

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
    public PbFragment f53320a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.d2.i.c f53321b;

    /* renamed from: c  reason: collision with root package name */
    public View f53322c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f53323d = null;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53324e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f53325f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f53326g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f53327h = null;

    /* renamed from: i  reason: collision with root package name */
    public Button f53328i = null;

    /* renamed from: d.a.k0.d2.k.e.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnLongClickListenerC1255a implements View.OnLongClickListener {
        public View$OnLongClickListenerC1255a(a aVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public a(PbFragment pbFragment, d.a.k0.d2.i.c cVar) {
        this.f53320a = pbFragment;
        this.f53321b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.f53322c);
    }

    public boolean b(boolean z) {
        boolean z2;
        Button button = this.f53328i;
        if (button != null && button.getVisibility() == 0) {
            View view = this.f53325f;
            if (view != null) {
                view.setVisibility(0);
            }
            z2 = true;
        } else {
            View view2 = this.f53325f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            z2 = false;
        }
        View view3 = this.f53327h;
        if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
            this.f53326g.setVisibility(0);
        } else {
            this.f53326g.setVisibility(8);
        }
        return z2;
    }

    public View c() {
        return this.f53322c;
    }

    public final void d() {
        View inflate = LayoutInflater.from(this.f53320a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.f53322c = inflate;
        inflate.setOnTouchListener(this.f53321b);
        View findViewById = this.f53322c.findViewById(R.id.pb_head_activity_join_number_container);
        this.f53323d = findViewById;
        findViewById.setVisibility(8);
        this.f53324e = (TextView) this.f53322c.findViewById(R.id.pb_head_activity_join_number);
        this.f53325f = this.f53322c.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.f53326g = this.f53322c.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.f53322c.setOnLongClickListener(new View$OnLongClickListenerC1255a(this));
    }

    public void e(int i2) {
        this.f53320a.getBaseFragmentActivity().getLayoutMode().j(this.f53322c);
    }

    public void f(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f53322c);
        }
    }

    public void g(d.a.k0.d2.h.e eVar) {
        ArrayList<d.a.j0.r.q.b> E = eVar.L().E();
        if (E != null && E.size() > 0) {
            this.f53324e.setText(String.valueOf(E.get(0).f()));
            this.f53323d.setVisibility(0);
        } else {
            this.f53323d.setVisibility(8);
        }
        SkinManager.setBackgroundResource(this.f53323d, R.drawable.activity_join_num_bg);
        SkinManager.setViewTextColor(this.f53324e, R.color.CAM_X0305, 1);
    }

    public void h(d.a.k0.d2.h.e eVar, boolean z) {
        boolean b2 = b(z);
        if (eVar == null || eVar.w() == null || eVar.w().c() != 0 || !z) {
            this.f53326g.setVisibility(8);
        } else if (b2) {
            this.f53326g.setVisibility(0);
        } else {
            this.f53326g.setVisibility(8);
        }
    }
}
