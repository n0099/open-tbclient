package d.b.j0.d2.o.r;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import d.b.c.e.p.j;
import d.b.j0.d2.h.o;
import d.b.j0.d3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f55133a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f55134b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55135c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f55136d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f55137e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f55139g;

    /* renamed from: h  reason: collision with root package name */
    public int f55140h;
    public int i;

    /* renamed from: f  reason: collision with root package name */
    public int f55138f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1262b();

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            if (b.this.f55137e != null) {
                return b.this.f55137e.a(i);
            }
            return true;
        }
    }

    /* renamed from: d.b.j0.d2.o.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1262b implements View.OnClickListener {
        public View$OnClickListenerC1262b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f55139g != null) {
                b.this.f55139g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f55134b) {
                        if (view == b.this.f55135c) {
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
        this.f55133a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f55134b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f55133a.findViewById(R.id.owner_reply);
        this.f55135c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f55133a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f55136d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f55136d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i = 0;
        if (oVar.f54271f == o.l) {
            this.f55134b.setClickable(true);
            this.f55134b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f55135c.setVisibility(0);
            f(oVar.f54273h);
        }
        if (oVar.i) {
            this.f55135c.setVisibility(8);
            this.f55136d.setVisibility(8);
        } else if (oVar.j) {
            this.f55135c.setVisibility(8);
        } else {
            this.f55135c.setVisibility(0);
        }
        if (!oVar.i && oVar.k != null) {
            this.f55136d.setVisibility(0);
            int i2 = 0;
            while (true) {
                if (i2 < oVar.k.size()) {
                    if (oVar.k.get(i2) != null && oVar.f54272g == oVar.k.get(i2).sort_type.intValue()) {
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
            this.f55136d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f55136d.setVisibility(0);
        this.f55136d.setData(arrayList, i);
    }

    public void h(int i) {
        SkinManager.setBackgroundColor(this.f55133a, R.color.CAM_X0205);
        this.i = SkinManager.getColor(R.color.CAM_X0105);
        this.f55140h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f55138f);
        this.f55136d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f55139g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f55137e = fVar;
    }

    public void k(int i) {
        this.f55138f = i;
        if (i == 0) {
            this.f55134b.setTypeface(Typeface.defaultFromStyle(1));
            this.f55135c.setTypeface(Typeface.defaultFromStyle(0));
            this.f55134b.setTextColor(this.i);
            this.f55135c.setTextColor(this.f55140h);
        } else if (i == 1) {
            this.f55134b.setTypeface(Typeface.defaultFromStyle(0));
            this.f55135c.setTypeface(Typeface.defaultFromStyle(1));
            this.f55134b.setTextColor(this.f55140h);
            this.f55135c.setTextColor(this.i);
        }
    }
}
