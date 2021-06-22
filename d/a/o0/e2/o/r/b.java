package d.a.o0.e2.o.r;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import d.a.c.e.p.j;
import d.a.o0.e2.h.o;
import d.a.o0.e3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f57699a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57700b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57701c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f57702d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f57703e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f57705g;

    /* renamed from: h  reason: collision with root package name */
    public int f57706h;

    /* renamed from: i  reason: collision with root package name */
    public int f57707i;

    /* renamed from: f  reason: collision with root package name */
    public int f57704f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1352b();

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            if (b.this.f57703e != null) {
                return b.this.f57703e.a(i2);
            }
            return true;
        }
    }

    /* renamed from: d.a.o0.e2.o.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1352b implements View.OnClickListener {
        public View$OnClickListenerC1352b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f57705g != null) {
                b.this.f57705g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f57700b) {
                        if (view == b.this.f57701c) {
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
        this.f57699a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f57700b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f57699a.findViewById(R.id.owner_reply);
        this.f57701c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f57699a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f57702d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f57702d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f56770f == o.l) {
            this.f57700b.setClickable(true);
            this.f57700b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f57701c.setVisibility(0);
            f(oVar.f56772h);
        }
        if (oVar.f56773i) {
            this.f57701c.setVisibility(8);
            this.f57702d.setVisibility(8);
        } else if (oVar.j) {
            this.f57701c.setVisibility(8);
        } else {
            this.f57701c.setVisibility(0);
        }
        if (!oVar.f56773i && oVar.k != null) {
            this.f57702d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f56771g == oVar.k.get(i3).sort_type.intValue()) {
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
            this.f57702d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f57702d.setVisibility(0);
        this.f57702d.setData(arrayList, i2);
    }

    public void h(int i2) {
        SkinManager.setBackgroundColor(this.f57699a, R.color.CAM_X0205);
        this.f57707i = SkinManager.getColor(R.color.CAM_X0105);
        this.f57706h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f57704f);
        this.f57702d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f57705g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f57703e = fVar;
    }

    public void k(int i2) {
        this.f57704f = i2;
        if (i2 == 0) {
            this.f57700b.setTypeface(Typeface.defaultFromStyle(1));
            this.f57701c.setTypeface(Typeface.defaultFromStyle(0));
            this.f57700b.setTextColor(this.f57707i);
            this.f57701c.setTextColor(this.f57706h);
        } else if (i2 == 1) {
            this.f57700b.setTypeface(Typeface.defaultFromStyle(0));
            this.f57701c.setTypeface(Typeface.defaultFromStyle(1));
            this.f57700b.setTextColor(this.f57706h);
            this.f57701c.setTextColor(this.f57707i);
        }
    }
}
