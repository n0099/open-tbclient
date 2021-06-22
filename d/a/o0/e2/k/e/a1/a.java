package d.a.o0.e2.k.e.a1;

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
    public PbFragment f56895a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.e2.i.c f56896b;

    /* renamed from: c  reason: collision with root package name */
    public View f56897c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f56898d = null;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56899e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f56900f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f56901g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f56902h = null;

    /* renamed from: i  reason: collision with root package name */
    public Button f56903i = null;

    /* renamed from: d.a.o0.e2.k.e.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnLongClickListenerC1318a implements View.OnLongClickListener {
        public View$OnLongClickListenerC1318a(a aVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public a(PbFragment pbFragment, d.a.o0.e2.i.c cVar) {
        this.f56895a = pbFragment;
        this.f56896b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.f56897c);
    }

    public boolean b(boolean z) {
        boolean z2;
        Button button = this.f56903i;
        if (button != null && button.getVisibility() == 0) {
            View view = this.f56900f;
            if (view != null) {
                view.setVisibility(0);
            }
            z2 = true;
        } else {
            View view2 = this.f56900f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            z2 = false;
        }
        View view3 = this.f56902h;
        if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
            this.f56901g.setVisibility(0);
        } else {
            this.f56901g.setVisibility(8);
        }
        return z2;
    }

    public View c() {
        return this.f56897c;
    }

    public final void d() {
        View inflate = LayoutInflater.from(this.f56895a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.f56897c = inflate;
        inflate.setOnTouchListener(this.f56896b);
        View findViewById = this.f56897c.findViewById(R.id.pb_head_activity_join_number_container);
        this.f56898d = findViewById;
        findViewById.setVisibility(8);
        this.f56899e = (TextView) this.f56897c.findViewById(R.id.pb_head_activity_join_number);
        this.f56900f = this.f56897c.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.f56901g = this.f56897c.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.f56897c.setOnLongClickListener(new View$OnLongClickListenerC1318a(this));
    }

    public void e(int i2) {
        this.f56895a.getBaseFragmentActivity().getLayoutMode().j(this.f56897c);
    }

    public void f(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f56897c);
        }
    }

    public void g(d.a.o0.e2.h.e eVar) {
        ArrayList<d.a.n0.r.q.b> E = eVar.L().E();
        if (E != null && E.size() > 0) {
            this.f56899e.setText(String.valueOf(E.get(0).f()));
            this.f56898d.setVisibility(0);
        } else {
            this.f56898d.setVisibility(8);
        }
        SkinManager.setBackgroundResource(this.f56898d, R.drawable.activity_join_num_bg);
        SkinManager.setViewTextColor(this.f56899e, R.color.CAM_X0305, 1);
    }

    public void h(d.a.o0.e2.h.e eVar, boolean z) {
        boolean b2 = b(z);
        if (eVar == null || eVar.w() == null || eVar.w().c() != 0 || !z) {
            this.f56901g.setVisibility(8);
        } else if (b2) {
            this.f56901g.setVisibility(0);
        } else {
            this.f56901g.setVisibility(8);
        }
    }
}
