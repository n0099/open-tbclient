package d.a.n0.s1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f60696e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.s1.h.e.g f60697f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f60698g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f60699h = new a();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f60700i = new View$OnClickListenerC1601b();
    public View.OnClickListener j = new c();
    public d.a.n0.s1.h.f.a<Integer> k = new f();
    public d.a.n0.s1.h.f.a<Void> l = new g();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailManagementActivityConfig tailManagementActivityConfig = new TailManagementActivityConfig(view.getContext());
            tailManagementActivityConfig.getIntent().putExtra("list", new TailDataList(b.this.f60697f.i()));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tailManagementActivityConfig));
        }
    }

    /* renamed from: d.a.n0.s1.h.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1601b implements View.OnClickListener {
        public View$OnClickListenerC1601b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.f60696e, 1, false, 6);
            memberPayActivityConfig.setSceneId("4009001001");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null) {
                return;
            }
            if (!b.this.f60697f.g()) {
                b bVar = b.this;
                bVar.i(bVar.f60696e.getString(R.string.become_member_to_use));
                return;
            }
            TailData b2 = ((d.a.n0.s1.h.e.e) view.getTag()).b();
            b.this.f60697f.o(b2.getId(), !b2.isSelected());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.f60696e, 1, false, 6);
            memberPayActivityConfig.setSceneId("4009001001");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e(b bVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.n0.s1.h.f.a<Integer> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.s1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            if (z) {
                l.M(b.this.f60696e, str);
            } else if (num != null && b.this.f60697f.i() != null && b.this.f60697f.i().size() != 0) {
                for (TailData tailData : b.this.f60697f.i()) {
                    if (tailData.getId() == num.intValue()) {
                        tailData.setSelected(!tailData.isSelected());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(tailData.isSelected())));
                    } else {
                        tailData.setSelected(false);
                    }
                }
                b.this.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.n0.s1.h.f.a<Void> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.s1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Void r3) {
            if (z) {
                l.M(b.this.f60696e, str);
            } else {
                b.this.notifyDataSetChanged();
            }
        }
    }

    public b(Context context, d.a.n0.s1.h.e.g gVar, View.OnClickListener onClickListener) {
        this.f60696e = context;
        this.f60698g = onClickListener;
        this.f60697f = gVar;
        gVar.n(this.k);
        this.f60697f.p(this.l);
    }

    public final View d(View view) {
        d.a.n0.s1.h.e.c cVar;
        if (view != null && (view.getTag() instanceof d.a.n0.s1.h.e.c)) {
            cVar = (d.a.n0.s1.h.e.c) view.getTag();
        } else {
            cVar = new d.a.n0.s1.h.e.c();
            view = cVar.a(this.f60696e);
            cVar.c(this.f60698g);
            cVar.b();
        }
        cVar.d(3);
        return view;
    }

    public final View e(View view) {
        if (view == null || !(view.getTag() instanceof d.a.n0.s1.h.e.d)) {
            d.a.n0.s1.h.e.d dVar = new d.a.n0.s1.h.e.d();
            View a2 = dVar.a(this.f60696e);
            dVar.c(this.f60699h);
            dVar.b();
            return a2;
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public TailData getItem(int i2) {
        if (i2 >= this.f60697f.i().size()) {
            return null;
        }
        return this.f60697f.i().get(i2);
    }

    public final View g(TailData tailData, View view) {
        d.a.n0.s1.h.e.e eVar;
        if (tailData == null) {
            return null;
        }
        if (view != null && (view.getTag() instanceof d.a.n0.s1.h.e.e)) {
            eVar = (d.a.n0.s1.h.e.e) view.getTag();
        } else {
            eVar = new d.a.n0.s1.h.e.e();
            view = eVar.a(this.f60696e);
            eVar.e(this.j);
            eVar.c();
        }
        eVar.f(tailData);
        eVar.h(tailData);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60697f.i().size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f60697f.i().size() == 0) {
            return 2;
        }
        return i2 == this.f60697f.i().size() ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (getItemViewType(i2) == 0) {
            return g(getItem(i2), view);
        }
        if (getItemViewType(i2) == 1) {
            return e(view);
        }
        if (getItemViewType(i2) == 2) {
            return d(view);
        }
        if (getItemViewType(i2) == 3) {
            return h(view);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public final View h(View view) {
        if (view == null || !(view.getTag() instanceof d.a.n0.s1.h.e.f)) {
            d.a.n0.s1.h.e.f fVar = new d.a.n0.s1.h.e.f();
            View a2 = fVar.a(this.f60696e);
            fVar.c(this.f60700i);
            fVar.b();
            return a2;
        }
        return view;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void i(String str) {
        d.a.c.a.f<?> a2 = j.a(this.f60696e);
        if (a2 == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(a2.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setMessage(str).setNegativeButton(this.f60696e.getString(R.string.cancel), new e(this)).setPositiveButton(this.f60696e.getString(R.string.open_now), new d()).create(a2).show();
    }
}
