package d.b.i0.c2.k.e.x0;

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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52886a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.c2.i.c f52887b;

    /* renamed from: c  reason: collision with root package name */
    public View f52888c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f52889d = null;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52890e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f52891f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f52892g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f52893h = null;
    public Button i = null;

    /* renamed from: d.b.i0.c2.k.e.x0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnLongClickListenerC1158a implements View.OnLongClickListener {
        public View$OnLongClickListenerC1158a(a aVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public a(PbFragment pbFragment, d.b.i0.c2.i.c cVar) {
        this.f52886a = pbFragment;
        this.f52887b = cVar;
        c();
    }

    public void a(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.f52888c);
    }

    public boolean b(boolean z) {
        boolean z2;
        Button button = this.i;
        if (button != null && button.getVisibility() == 0) {
            View view = this.f52891f;
            if (view != null) {
                view.setVisibility(0);
            }
            z2 = true;
        } else {
            View view2 = this.f52891f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            z2 = false;
        }
        View view3 = this.f52893h;
        if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
            this.f52892g.setVisibility(0);
        } else {
            this.f52892g.setVisibility(8);
        }
        return z2;
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f52886a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.f52888c = inflate;
        inflate.setOnTouchListener(this.f52887b);
        View findViewById = this.f52888c.findViewById(R.id.pb_head_activity_join_number_container);
        this.f52889d = findViewById;
        findViewById.setVisibility(8);
        this.f52890e = (TextView) this.f52888c.findViewById(R.id.pb_head_activity_join_number);
        this.f52891f = this.f52888c.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.f52892g = this.f52888c.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.f52888c.setOnLongClickListener(new View$OnLongClickListenerC1158a(this));
    }

    public void d(int i) {
        this.f52886a.getBaseFragmentActivity().getLayoutMode().j(this.f52888c);
    }

    public void e(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f52888c);
        }
    }

    public void f(d.b.i0.c2.h.e eVar) {
        ArrayList<d.b.h0.r.q.b> E = eVar.L().E();
        if (E != null && E.size() > 0) {
            this.f52890e.setText(String.valueOf(E.get(0).f()));
            this.f52889d.setVisibility(0);
        } else {
            this.f52889d.setVisibility(8);
        }
        SkinManager.setBackgroundResource(this.f52889d, R.drawable.activity_join_num_bg);
        SkinManager.setViewTextColor(this.f52890e, R.color.CAM_X0305, 1);
    }

    public void g(d.b.i0.c2.h.e eVar, boolean z) {
        boolean b2 = b(z);
        if (eVar == null || eVar.w() == null || eVar.w().c() != 0 || !z) {
            this.f52892g.setVisibility(8);
        } else if (b2) {
            this.f52892g.setVisibility(0);
        } else {
            this.f52892g.setVisibility(8);
        }
    }
}
