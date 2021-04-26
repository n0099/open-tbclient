package d.a.j0.t.j.g.c;

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
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61085e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.j0.t.j.g.c.c.a> f61086f;

    /* renamed from: g  reason: collision with root package name */
    public d f61087g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.j.g.c.c.a f61088e;

        public a(d.a.j0.t.j.g.c.c.a aVar) {
            this.f61088e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f61087g != null) {
                b.this.f61087g.a(this.f61088e.b(0));
            }
        }
    }

    /* renamed from: d.a.j0.t.j.g.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1588b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.j.g.c.c.a f61090e;

        public View$OnClickListenerC1588b(d.a.j0.t.j.g.c.c.a aVar) {
            this.f61090e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f61087g != null) {
                b.this.f61087g.a(this.f61090e.b(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.j.g.c.c.a f61092e;

        public c(d.a.j0.t.j.g.c.c.a aVar) {
            this.f61092e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f61087g != null) {
                b.this.f61087g.a(this.f61092e.b(2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(d.a.j0.t.j.g.c.c.b bVar);
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61094a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61095b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61096c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f61097d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61098e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61099f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f61100g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61101h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f61102i;
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
        this.f61085e = null;
        this.f61085e = tbPageContext;
        this.f61087g = dVar;
    }

    public final List<d.a.j0.t.j.g.c.c.a> b(List<d.a.j0.t.j.g.c.c.c> list) {
        int i2;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            List<d.a.j0.t.j.g.c.c.b> a2 = list.get(i3).a();
            int size = a2.size();
            if (size % 3 == 0) {
                i2 = size / 3;
            } else {
                i2 = (size / 3) + 1;
            }
            d.a.j0.t.j.g.c.c.b[][] bVarArr = (d.a.j0.t.j.g.c.c.b[][]) Array.newInstance(d.a.j0.t.j.g.c.c.b.class, i2, 3);
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = i4 / 3;
                int i6 = i4 % 3;
                bVarArr[i5][i6] = a2.get(i4);
                bVarArr[i5][i6].o(list.get(i3).b());
            }
            arrayList2.add(bVarArr);
        }
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            for (int i8 = 0; i8 < ((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7)).length; i8++) {
                d.a.j0.t.j.g.c.c.a aVar = new d.a.j0.t.j.g.c.c.a();
                if (((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7)).length == 1) {
                    aVar.f(1);
                } else if (((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7)).length > 1 && i8 == 0) {
                    aVar.f(2);
                } else if (((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7)).length > 1 && i8 == ((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7)).length - 1) {
                    aVar.f(3);
                } else {
                    aVar.f(4);
                }
                if (i7 == arrayList2.size() - 1) {
                    if (aVar.d() == 1) {
                        aVar.f(2);
                    } else if (aVar.d() == 3) {
                        aVar.f(4);
                    }
                }
                for (int i9 = 0; i9 < 3; i9++) {
                    if (((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7))[i8][i9] != null) {
                        aVar.a(((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7))[i8][i9]);
                    }
                }
                if (((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7))[0][0] != null) {
                    aVar.e(((d.a.j0.t.j.g.c.c.b[][]) arrayList2.get(i7))[0][0].h());
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
        SkinManager.setViewTextColor(eVar.f61094a, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f61099f, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.k, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f61098e, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.j, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.o, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        if (TbadkApplication.getInst().getSkinType() == 1) {
            eVar.f61095b.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.f61100g.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor_1);
        } else {
            eVar.f61095b.setDefaultResource(R.drawable.pic_live_honor);
            eVar.f61100g.setDefaultResource(R.drawable.pic_live_honor);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor);
        }
        SkinManager.setBackgroundColor(eVar.p, R.color.CAM_X0204);
    }

    public void d(List<d.a.j0.t.j.g.c.c.c> list) {
        if (list == null) {
            return;
        }
        List<d.a.j0.t.j.g.c.c.a> list2 = this.f61086f;
        if (list2 != null && list2.size() > 0) {
            this.f61086f.clear();
        }
        this.f61086f = b(list);
        notifyDataSetChanged();
    }

    public final void e(TbImageView tbImageView, int i2) {
        if (tbImageView == null) {
            return;
        }
        if (i2 == 0) {
            tbImageView.setAlpha(0.5f);
        } else if (i2 == 3) {
            tbImageView.setAlpha(0.2f);
        } else {
            tbImageView.setAlpha(1);
        }
    }

    public final void f(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
            int dimensionPixelSize = this.f61085e.getResources().getDimensionPixelSize(R.dimen.ds24);
            normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.f61085e.getResources().getDimensionPixelSize(R.dimen.ds4));
            textView.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            textView.setText(AlaStringHelper.formatLowercasekDou((float) j));
            return;
        }
        textView.setVisibility(8);
    }

    public final void g(TextView textView, int i2) {
        if (textView == null) {
            return;
        }
        if (i2 == 0) {
            textView.setText(R.string.ala_achievement_mark_status_unlock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else if (i2 == 1) {
            textView.setText(R.string.ala_achievement_mark_status_wear);
            SkinManager.setViewTextColor(textView, R.color.live_cp_other_b);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
        } else if (i2 == 2) {
            textView.setText(R.string.ala_achievement_mark_status_lock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
        } else if (i2 == 3) {
            textView.setText(R.string.ala_achievement_mark_status_expired);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else {
            textView.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.j0.t.j.g.c.c.a> list = this.f61086f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<d.a.j0.t.j.g.c.c.a> list = this.f61086f;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f61086f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        e eVar;
        d.a.j0.t.j.g.c.c.a aVar = this.f61086f.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f61085e.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            eVar = new e(this, null);
            eVar.f61094a = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            eVar.f61095b = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            eVar.f61096c = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            eVar.f61097d = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            eVar.f61098e = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            eVar.f61099f = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            eVar.f61100g = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            eVar.f61101h = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            eVar.f61102i = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
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
                d.a.j0.t.j.g.c.c.b b2 = aVar.b(0);
                eVar.f61097d.setVisibility(0);
                eVar.f61094a.setText(b2.e() == null ? "" : b2.e());
                if (b2.f() != null) {
                    eVar.f61095b.setDefaultBgResource(R.color.transparent);
                    eVar.f61095b.V(b2.f(), 10, false);
                }
                g(eVar.f61096c, b2.j());
                e(eVar.f61095b, b2.j());
                f(eVar.f61098e, b2.m(), b2.n);
                eVar.f61097d.setOnClickListener(new a(aVar));
            } else {
                eVar.f61097d.setVisibility(4);
                eVar.f61097d.setOnClickListener(null);
            }
            if (aVar.b(1) != null) {
                d.a.j0.t.j.g.c.c.b b3 = aVar.b(1);
                eVar.f61102i.setVisibility(0);
                eVar.f61099f.setText(b3.e() == null ? "" : b3.e());
                if (b3.f() != null) {
                    eVar.f61100g.setDefaultBgResource(R.color.transparent);
                    eVar.f61100g.V(b3.f(), 10, false);
                }
                g(eVar.f61101h, b3.j());
                e(eVar.f61100g, b3.j());
                f(eVar.j, b3.m(), b3.n);
                eVar.f61102i.setOnClickListener(new View$OnClickListenerC1588b(aVar));
            } else {
                eVar.f61102i.setVisibility(4);
                eVar.f61102i.setOnClickListener(null);
            }
            if (aVar.b(2) != null) {
                d.a.j0.t.j.g.c.c.b b4 = aVar.b(2);
                eVar.n.setVisibility(0);
                eVar.k.setText(b4.e() != null ? b4.e() : "");
                if (b4.f() != null) {
                    eVar.l.setDefaultBgResource(R.color.transparent);
                    eVar.l.V(b4.f(), 10, false);
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
