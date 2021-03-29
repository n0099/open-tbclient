package d.b.i0.t.j.g.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f60900e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.t.j.g.c.c.a> f60901f;

    /* renamed from: g  reason: collision with root package name */
    public d f60902g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.j.g.c.c.a f60903e;

        public a(d.b.i0.t.j.g.c.c.a aVar) {
            this.f60903e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f60902g != null) {
                b.this.f60902g.a(this.f60903e.b(0));
            }
        }
    }

    /* renamed from: d.b.i0.t.j.g.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1572b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.j.g.c.c.a f60905e;

        public View$OnClickListenerC1572b(d.b.i0.t.j.g.c.c.a aVar) {
            this.f60905e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f60902g != null) {
                b.this.f60902g.a(this.f60905e.b(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.j.g.c.c.a f60907e;

        public c(d.b.i0.t.j.g.c.c.a aVar) {
            this.f60907e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f60902g != null) {
                b.this.f60902g.a(this.f60907e.b(2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(d.b.i0.t.j.g.c.c.b bVar);
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60909a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60910b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60911c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f60912d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60913e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60914f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f60915g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60916h;
        public RelativeLayout i;
        public TextView j;
        public TextView k;
        public TbImageView l;
        public TextView m;
        public RelativeLayout n;
        public TextView o;
        public View p;
        public TextView q;

        public e(b bVar) {
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(TbPageContext<?> tbPageContext, d dVar) {
        this.f60900e = null;
        this.f60900e = tbPageContext;
        this.f60902g = dVar;
    }

    public final List<d.b.i0.t.j.g.c.c.a> b(List<d.b.i0.t.j.g.c.c.c> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            List<d.b.i0.t.j.g.c.c.b> a2 = list.get(i2).a();
            int size = a2.size();
            if (size % 3 == 0) {
                i = size / 3;
            } else {
                i = (size / 3) + 1;
            }
            d.b.i0.t.j.g.c.c.b[][] bVarArr = (d.b.i0.t.j.g.c.c.b[][]) Array.newInstance(d.b.i0.t.j.g.c.c.b.class, i, 3);
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = i3 / 3;
                int i5 = i3 % 3;
                bVarArr[i4][i5] = a2.get(i3);
                bVarArr[i4][i5].o(list.get(i2).b());
            }
            arrayList2.add(bVarArr);
        }
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            for (int i7 = 0; i7 < ((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6)).length; i7++) {
                d.b.i0.t.j.g.c.c.a aVar = new d.b.i0.t.j.g.c.c.a();
                if (((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6)).length == 1) {
                    aVar.f(1);
                } else if (((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6)).length > 1 && i7 == 0) {
                    aVar.f(2);
                } else if (((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6)).length > 1 && i7 == ((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6)).length - 1) {
                    aVar.f(3);
                } else {
                    aVar.f(4);
                }
                if (i6 == arrayList2.size() - 1) {
                    if (aVar.d() == 1) {
                        aVar.f(2);
                    } else if (aVar.d() == 3) {
                        aVar.f(4);
                    }
                }
                for (int i8 = 0; i8 < 3; i8++) {
                    if (((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6))[i7][i8] != null) {
                        aVar.a(((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6))[i7][i8]);
                    }
                }
                if (((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6))[0][0] != null) {
                    aVar.e(((d.b.i0.t.j.g.c.c.b[][]) arrayList2.get(i6))[0][0].h());
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public final void c(e eVar) {
        if (eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.q, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f60909a, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f60914f, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.k, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f60913e, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.j, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.o, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        if (TbadkApplication.getInst().getSkinType() == 1) {
            eVar.f60910b.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.f60915g.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor_1);
        } else {
            eVar.f60910b.setDefaultResource(R.drawable.pic_live_honor);
            eVar.f60915g.setDefaultResource(R.drawable.pic_live_honor);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor);
        }
        SkinManager.setBackgroundColor(eVar.p, R.color.CAM_X0204);
    }

    public void d(List<d.b.i0.t.j.g.c.c.c> list) {
        if (list == null) {
            return;
        }
        List<d.b.i0.t.j.g.c.c.a> list2 = this.f60901f;
        if (list2 != null && list2.size() > 0) {
            this.f60901f.clear();
        }
        this.f60901f = b(list);
        notifyDataSetChanged();
    }

    public final void e(TbImageView tbImageView, int i) {
        if (tbImageView == null) {
            return;
        }
        if (i == 0) {
            tbImageView.setAlpha(0.5f);
        } else if (i == 3) {
            tbImageView.setAlpha(0.2f);
        } else {
            tbImageView.setAlpha(1);
        }
    }

    public final void f(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.f60900e.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.f60900e.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.f60900e.getResources().getDimensionPixelSize(R.dimen.ds4));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setText(AlaStringHelper.formatLowercasekDou(j));
            return;
        }
        textView.setVisibility(8);
    }

    public final void g(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        if (i == 0) {
            textView.setText(R.string.ala_achievement_mark_status_unlock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else if (i == 1) {
            textView.setText(R.string.ala_achievement_mark_status_wear);
            SkinManager.setViewTextColor(textView, R.color.live_cp_other_b);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
        } else if (i == 2) {
            textView.setText(R.string.ala_achievement_mark_status_lock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
        } else if (i == 3) {
            textView.setText(R.string.ala_achievement_mark_status_expired);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else {
            textView.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.t.j.g.c.c.a> list = this.f60901f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<d.b.i0.t.j.g.c.c.a> list = this.f60901f;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f60901f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        d.b.i0.t.j.g.c.c.a aVar = this.f60901f.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f60900e.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            eVar = new e(this, null);
            eVar.f60909a = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            eVar.f60910b = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            eVar.f60911c = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            eVar.f60912d = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            eVar.f60913e = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            eVar.f60914f = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            eVar.f60915g = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            eVar.f60916h = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            eVar.i = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            eVar.j = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            eVar.k = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            eVar.l = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            eVar.m = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            eVar.n = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            eVar.o = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            eVar.p = view.findViewById(R.id.ala_achievement_mark_item_line);
            eVar.q = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
        } else {
            eVar = (e) view.getTag();
        }
        c(eVar);
        if (aVar != null) {
            if (aVar.b(0) != null) {
                d.b.i0.t.j.g.c.c.b b2 = aVar.b(0);
                eVar.f60912d.setVisibility(0);
                eVar.f60909a.setText(b2.e() == null ? "" : b2.e());
                if (b2.f() != null) {
                    eVar.f60910b.setDefaultBgResource(R.color.transparent);
                    eVar.f60910b.W(b2.f(), 10, false);
                }
                g(eVar.f60911c, b2.j());
                e(eVar.f60910b, b2.j());
                f(eVar.f60913e, b2.m(), b2.n);
                eVar.f60912d.setOnClickListener(new a(aVar));
            } else {
                eVar.f60912d.setVisibility(4);
                eVar.f60912d.setOnClickListener(null);
            }
            if (aVar.b(1) != null) {
                d.b.i0.t.j.g.c.c.b b3 = aVar.b(1);
                eVar.i.setVisibility(0);
                eVar.f60914f.setText(b3.e() == null ? "" : b3.e());
                if (b3.f() != null) {
                    eVar.f60915g.setDefaultBgResource(R.color.transparent);
                    eVar.f60915g.W(b3.f(), 10, false);
                }
                g(eVar.f60916h, b3.j());
                e(eVar.f60915g, b3.j());
                f(eVar.j, b3.m(), b3.n);
                eVar.i.setOnClickListener(new View$OnClickListenerC1572b(aVar));
            } else {
                eVar.i.setVisibility(4);
                eVar.i.setOnClickListener(null);
            }
            if (aVar.b(2) != null) {
                d.b.i0.t.j.g.c.c.b b4 = aVar.b(2);
                eVar.n.setVisibility(0);
                eVar.k.setText(b4.e() != null ? b4.e() : "");
                if (b4.f() != null) {
                    eVar.l.setDefaultBgResource(R.color.transparent);
                    eVar.l.W(b4.f(), 10, false);
                }
                g(eVar.m, b4.j());
                e(eVar.l, b4.j());
                f(eVar.o, b4.m(), b4.n);
                eVar.n.setOnClickListener(new c(aVar));
            } else {
                eVar.n.setVisibility(4);
                eVar.n.setOnClickListener(null);
            }
            if (aVar.d() != 3 && aVar.d() != 1) {
                eVar.p.setVisibility(8);
            } else {
                eVar.p.setVisibility(0);
            }
            if ((aVar.d() == 1 || aVar.d() == 2) && aVar.c() != null) {
                eVar.q.setVisibility(0);
                eVar.q.setText(aVar.c());
            } else {
                eVar.q.setVisibility(8);
            }
        }
        view.setTag(eVar);
        return view;
    }
}
