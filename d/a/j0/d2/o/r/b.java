package d.a.j0.d2.o.r;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import d.a.c.e.p.j;
import d.a.j0.d2.h.o;
import d.a.j0.d3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f52965a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52966b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52967c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f52968d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f52969e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f52971g;

    /* renamed from: h  reason: collision with root package name */
    public int f52972h;

    /* renamed from: i  reason: collision with root package name */
    public int f52973i;

    /* renamed from: f  reason: collision with root package name */
    public int f52970f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1201b();

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            if (b.this.f52969e != null) {
                return b.this.f52969e.a(i2);
            }
            return true;
        }
    }

    /* renamed from: d.a.j0.d2.o.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1201b implements View.OnClickListener {
        public View$OnClickListenerC1201b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f52971g != null) {
                b.this.f52971g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f52966b) {
                        if (view == b.this.f52967c) {
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
        this.f52965a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f52966b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f52965a.findViewById(R.id.owner_reply);
        this.f52967c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f52965a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f52968d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f52968d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f52052f == o.l) {
            this.f52966b.setClickable(true);
            this.f52966b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f52967c.setVisibility(0);
            f(oVar.f52054h);
        }
        if (oVar.f52055i) {
            this.f52967c.setVisibility(8);
            this.f52968d.setVisibility(8);
        } else if (oVar.j) {
            this.f52967c.setVisibility(8);
        } else {
            this.f52967c.setVisibility(0);
        }
        if (!oVar.f52055i && oVar.k != null) {
            this.f52968d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f52053g == oVar.k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(oVar.k, i2);
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

    public void g(List<PbSortType> list, int i2) {
        if (ListUtils.isEmpty(list)) {
            this.f52968d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f52968d.setVisibility(0);
        this.f52968d.setData(arrayList, i2);
    }

    public void h(int i2) {
        SkinManager.setBackgroundColor(this.f52965a, R.color.CAM_X0205);
        this.f52973i = SkinManager.getColor(R.color.CAM_X0105);
        this.f52972h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f52970f);
        this.f52968d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f52971g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f52969e = fVar;
    }

    public void k(int i2) {
        this.f52970f = i2;
        if (i2 == 0) {
            this.f52966b.setTypeface(Typeface.defaultFromStyle(1));
            this.f52967c.setTypeface(Typeface.defaultFromStyle(0));
            this.f52966b.setTextColor(this.f52973i);
            this.f52967c.setTextColor(this.f52972h);
        } else if (i2 == 1) {
            this.f52966b.setTypeface(Typeface.defaultFromStyle(0));
            this.f52967c.setTypeface(Typeface.defaultFromStyle(1));
            this.f52966b.setTextColor(this.f52972h);
            this.f52967c.setTextColor(this.f52973i);
        }
    }
}
