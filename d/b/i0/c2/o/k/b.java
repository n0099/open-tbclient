package d.b.i0.c2.o.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import d.b.b.e.p.j;
import d.b.i0.c2.h.o;
import d.b.i0.c3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f53287a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f53288b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53289c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f53290d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f53291e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f53293g;

    /* renamed from: h  reason: collision with root package name */
    public int f53294h;
    public int i;

    /* renamed from: f  reason: collision with root package name */
    public int f53292f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1181b();

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            if (b.this.f53291e != null) {
                return b.this.f53291e.a(i);
            }
            return true;
        }
    }

    /* renamed from: d.b.i0.c2.o.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1181b implements View.OnClickListener {
        public View$OnClickListenerC1181b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f53293g != null) {
                b.this.f53293g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f53288b) {
                        if (view == b.this.f53289c) {
                            b.this.k(1);
                            return;
                        }
                        return;
                    }
                    b.this.k(0);
                }
            }
        }
    }

    public b(View view) {
        if (view == null) {
            return;
        }
        this.f53287a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f53288b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f53287a.findViewById(R.id.owner_reply);
        this.f53289c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f53287a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f53290d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f53290d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i = 0;
        if (oVar.f52454f == o.l) {
            this.f53288b.setClickable(true);
            this.f53288b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f53289c.setVisibility(0);
            f(oVar.f52456h);
        }
        if (oVar.i) {
            this.f53289c.setVisibility(8);
            this.f53290d.setVisibility(8);
        } else if (oVar.j) {
            this.f53289c.setVisibility(8);
        } else {
            this.f53289c.setVisibility(0);
        }
        if (!oVar.i && oVar.k != null) {
            this.f53290d.setVisibility(0);
            int i2 = 0;
            while (true) {
                if (i2 < oVar.k.size()) {
                    if (oVar.k.get(i2) != null && oVar.f52455g == oVar.k.get(i2).sort_type.intValue()) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            g(oVar.k, i);
        }
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z) {
        if (z) {
            k(1);
        } else {
            k(0);
        }
    }

    public void g(List<PbSortType> list, int i) {
        if (ListUtils.isEmpty(list)) {
            this.f53290d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f53290d.setVisibility(0);
        this.f53290d.setData(arrayList, i);
    }

    public void h(int i) {
        SkinManager.setBackgroundColor(this.f53287a, R.color.CAM_X0205);
        this.i = SkinManager.getColor(R.color.CAM_X0105);
        this.f53294h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f53292f);
        this.f53290d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f53293g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f53291e = fVar;
    }

    public void k(int i) {
        this.f53292f = i;
        if (i == 0) {
            this.f53288b.setTypeface(Typeface.defaultFromStyle(1));
            this.f53289c.setTypeface(Typeface.defaultFromStyle(0));
            this.f53288b.setTextColor(this.i);
            this.f53289c.setTextColor(this.f53294h);
        } else if (i == 1) {
            this.f53288b.setTypeface(Typeface.defaultFromStyle(0));
            this.f53289c.setTypeface(Typeface.defaultFromStyle(1));
            this.f53288b.setTextColor(this.f53294h);
            this.f53289c.setTextColor(this.i);
        }
    }
}
