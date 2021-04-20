package d.b.i0.d2.o.r;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import d.b.c.e.p.j;
import d.b.i0.d2.h.o;
import d.b.i0.d3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f54712a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54713b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54714c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f54715d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f54716e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f54718g;

    /* renamed from: h  reason: collision with root package name */
    public int f54719h;
    public int i;

    /* renamed from: f  reason: collision with root package name */
    public int f54717f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1239b();

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            if (b.this.f54716e != null) {
                return b.this.f54716e.a(i);
            }
            return true;
        }
    }

    /* renamed from: d.b.i0.d2.o.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1239b implements View.OnClickListener {
        public View$OnClickListenerC1239b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f54718g != null) {
                b.this.f54718g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f54713b) {
                        if (view == b.this.f54714c) {
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
        this.f54712a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f54713b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f54712a.findViewById(R.id.owner_reply);
        this.f54714c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f54712a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f54715d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f54715d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i = 0;
        if (oVar.f53850f == o.l) {
            this.f54713b.setClickable(true);
            this.f54713b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f54714c.setVisibility(0);
            f(oVar.f53852h);
        }
        if (oVar.i) {
            this.f54714c.setVisibility(8);
            this.f54715d.setVisibility(8);
        } else if (oVar.j) {
            this.f54714c.setVisibility(8);
        } else {
            this.f54714c.setVisibility(0);
        }
        if (!oVar.i && oVar.k != null) {
            this.f54715d.setVisibility(0);
            int i2 = 0;
            while (true) {
                if (i2 < oVar.k.size()) {
                    if (oVar.k.get(i2) != null && oVar.f53851g == oVar.k.get(i2).sort_type.intValue()) {
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
            this.f54715d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f54715d.setVisibility(0);
        this.f54715d.setData(arrayList, i);
    }

    public void h(int i) {
        SkinManager.setBackgroundColor(this.f54712a, R.color.CAM_X0205);
        this.i = SkinManager.getColor(R.color.CAM_X0105);
        this.f54719h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f54717f);
        this.f54715d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f54718g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f54716e = fVar;
    }

    public void k(int i) {
        this.f54717f = i;
        if (i == 0) {
            this.f54713b.setTypeface(Typeface.defaultFromStyle(1));
            this.f54714c.setTypeface(Typeface.defaultFromStyle(0));
            this.f54713b.setTextColor(this.i);
            this.f54714c.setTextColor(this.f54719h);
        } else if (i == 1) {
            this.f54713b.setTypeface(Typeface.defaultFromStyle(0));
            this.f54714c.setTypeface(Typeface.defaultFromStyle(1));
            this.f54713b.setTextColor(this.f54719h);
            this.f54714c.setTextColor(this.i);
        }
    }
}
