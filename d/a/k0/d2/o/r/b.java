package d.a.k0.d2.o.r;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import d.a.c.e.p.j;
import d.a.k0.d2.h.o;
import d.a.k0.d3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f53672a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f53673b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53674c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f53675d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f53676e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f53678g;

    /* renamed from: h  reason: collision with root package name */
    public int f53679h;

    /* renamed from: i  reason: collision with root package name */
    public int f53680i;

    /* renamed from: f  reason: collision with root package name */
    public int f53677f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1273b();

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            if (b.this.f53676e != null) {
                return b.this.f53676e.a(i2);
            }
            return true;
        }
    }

    /* renamed from: d.a.k0.d2.o.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1273b implements View.OnClickListener {
        public View$OnClickListenerC1273b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f53678g != null) {
                b.this.f53678g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f53673b) {
                        if (view == b.this.f53674c) {
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
        this.f53672a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f53673b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f53672a.findViewById(R.id.owner_reply);
        this.f53674c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f53672a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f53675d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f53675d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f52751f == o.l) {
            this.f53673b.setClickable(true);
            this.f53673b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f53674c.setVisibility(0);
            f(oVar.f52753h);
        }
        if (oVar.f52754i) {
            this.f53674c.setVisibility(8);
            this.f53675d.setVisibility(8);
        } else if (oVar.j) {
            this.f53674c.setVisibility(8);
        } else {
            this.f53674c.setVisibility(0);
        }
        if (!oVar.f52754i && oVar.k != null) {
            this.f53675d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f52752g == oVar.k.get(i3).sort_type.intValue()) {
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
            this.f53675d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f53675d.setVisibility(0);
        this.f53675d.setData(arrayList, i2);
    }

    public void h(int i2) {
        SkinManager.setBackgroundColor(this.f53672a, R.color.CAM_X0205);
        this.f53680i = SkinManager.getColor(R.color.CAM_X0105);
        this.f53679h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f53677f);
        this.f53675d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f53678g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f53676e = fVar;
    }

    public void k(int i2) {
        this.f53677f = i2;
        if (i2 == 0) {
            this.f53673b.setTypeface(Typeface.defaultFromStyle(1));
            this.f53674c.setTypeface(Typeface.defaultFromStyle(0));
            this.f53673b.setTextColor(this.f53680i);
            this.f53674c.setTextColor(this.f53679h);
        } else if (i2 == 1) {
            this.f53673b.setTypeface(Typeface.defaultFromStyle(0));
            this.f53674c.setTypeface(Typeface.defaultFromStyle(1));
            this.f53673b.setTextColor(this.f53679h);
            this.f53674c.setTextColor(this.f53680i);
        }
    }
}
