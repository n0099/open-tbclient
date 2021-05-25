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
    public View f53885a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f53886b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53887c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f53888d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f53889e;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f53891g;

    /* renamed from: h  reason: collision with root package name */
    public int f53892h;

    /* renamed from: i  reason: collision with root package name */
    public int f53893i;

    /* renamed from: f  reason: collision with root package name */
    public int f53890f = 0;
    public SortSwitchButton.f j = new a();
    public View.OnClickListener k = new View$OnClickListenerC1292b();

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            if (b.this.f53889e != null) {
                return b.this.f53889e.a(i2);
            }
            return true;
        }
    }

    /* renamed from: d.a.n0.e2.o.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1292b implements View.OnClickListener {
        public View$OnClickListenerC1292b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f53891g != null) {
                b.this.f53891g.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.f53886b) {
                        if (view == b.this.f53887c) {
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
        this.f53885a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f53886b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f53885a.findViewById(R.id.owner_reply);
        this.f53887c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f53885a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f53888d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f53888d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        if (oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f52956f == o.l) {
            this.f53886b.setClickable(true);
            this.f53886b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f53887c.setVisibility(0);
            f(oVar.f52958h);
        }
        if (oVar.f52959i) {
            this.f53887c.setVisibility(8);
            this.f53888d.setVisibility(8);
        } else if (oVar.j) {
            this.f53887c.setVisibility(8);
        } else {
            this.f53887c.setVisibility(0);
        }
        if (!oVar.f52959i && oVar.k != null) {
            this.f53888d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f52957g == oVar.k.get(i3).sort_type.intValue()) {
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
            this.f53888d.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f53888d.setVisibility(0);
        this.f53888d.setData(arrayList, i2);
    }

    public void h(int i2) {
        SkinManager.setBackgroundColor(this.f53885a, R.color.CAM_X0205);
        this.f53893i = SkinManager.getColor(R.color.CAM_X0105);
        this.f53892h = SkinManager.getColor(R.color.CAM_X0107);
        k(this.f53890f);
        this.f53888d.F();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f53891g = onClickListener;
    }

    public void j(SortSwitchButton.f fVar) {
        this.f53889e = fVar;
    }

    public void k(int i2) {
        this.f53890f = i2;
        if (i2 == 0) {
            this.f53886b.setTypeface(Typeface.defaultFromStyle(1));
            this.f53887c.setTypeface(Typeface.defaultFromStyle(0));
            this.f53886b.setTextColor(this.f53893i);
            this.f53887c.setTextColor(this.f53892h);
        } else if (i2 == 1) {
            this.f53886b.setTypeface(Typeface.defaultFromStyle(0));
            this.f53887c.setTypeface(Typeface.defaultFromStyle(1));
            this.f53886b.setTextColor(this.f53892h);
            this.f53887c.setTextColor(this.f53893i);
        }
    }
}
