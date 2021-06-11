package d.a.n0.e2.o.r;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import d.a.c.e.p.j;
import d.a.n0.e2.h.o;
import d.a.n0.e3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f57574a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57575b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57576c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f57577d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f57578e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f57580g;

    /* renamed from: h  reason: collision with root package name */
    public int f57581h;

    /* renamed from: i  reason: collision with root package name */
    public int f57582i;

    /* renamed from: f  reason: collision with root package name */
    public int f57579f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1348b();

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            if (b.this.f57578e != null) {
                return b.this.f57578e.a(i2);
            }
            return true;
        }
    }

    /* renamed from: d.a.n0.e2.o.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1348b implements View.OnClickListener {
        public View$OnClickListenerC1348b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f57580g != null) {
                b.this.f57580g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f57575b) {
                        if (view == b.this.f57576c) {
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
        this.f57574a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f57575b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f57574a.findViewById(R.id.owner_reply);
        this.f57576c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f57574a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f57577d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f57577d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f56645f == o.l) {
            this.f57575b.setClickable(true);
            this.f57575b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f57576c.setVisibility(0);
            f(oVar.f56647h);
        }
        if (oVar.f56648i) {
            this.f57576c.setVisibility(8);
            this.f57577d.setVisibility(8);
        } else if (oVar.j) {
            this.f57576c.setVisibility(8);
        } else {
            this.f57576c.setVisibility(0);
        }
        if (!oVar.f56648i && oVar.k != null) {
            this.f57577d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f56646g == oVar.k.get(i3).sort_type.intValue()) {
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
            this.f57577d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f57577d.setVisibility(0);
        this.f57577d.setData(arrayList, i2);
    }

    public void h(int i2) {
        SkinManager.setBackgroundColor(this.f57574a, R.color.CAM_X0205);
        this.f57582i = SkinManager.getColor(R.color.CAM_X0105);
        this.f57581h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f57579f);
        this.f57577d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f57580g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f57578e = fVar;
    }

    public void k(int i2) {
        this.f57579f = i2;
        if (i2 == 0) {
            this.f57575b.setTypeface(Typeface.defaultFromStyle(1));
            this.f57576c.setTypeface(Typeface.defaultFromStyle(0));
            this.f57575b.setTextColor(this.f57582i);
            this.f57576c.setTextColor(this.f57581h);
        } else if (i2 == 1) {
            this.f57575b.setTypeface(Typeface.defaultFromStyle(0));
            this.f57576c.setTypeface(Typeface.defaultFromStyle(1));
            this.f57575b.setTextColor(this.f57581h);
            this.f57576c.setTextColor(this.f57582i);
        }
    }
}
