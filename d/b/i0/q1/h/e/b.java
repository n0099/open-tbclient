package d.b.i0.q1.h.e;

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
import d.b.b.a.j;
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f59556e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q1.h.e.g f59557f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f59558g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59559h = new a();
    public View.OnClickListener i = new View$OnClickListenerC1488b();
    public View.OnClickListener j = new c();
    public d.b.i0.q1.h.f.a<Integer> k = new f();
    public d.b.i0.q1.h.f.a<Void> l = new g();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailManagementActivityConfig tailManagementActivityConfig = new TailManagementActivityConfig(view.getContext());
            tailManagementActivityConfig.getIntent().putExtra("list", new TailDataList(b.this.f59557f.i()));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tailManagementActivityConfig));
        }
    }

    /* renamed from: d.b.i0.q1.h.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1488b implements View.OnClickListener {
        public View$OnClickListenerC1488b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.f59556e, 1, false, 6);
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
            if (!b.this.f59557f.g()) {
                b bVar = b.this;
                bVar.i(bVar.f59556e.getString(R.string.become_member_to_use));
                return;
            }
            TailData b2 = ((d.b.i0.q1.h.e.e) view.getTag()).b();
            b.this.f59557f.o(b2.getId(), !b2.isSelected());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.f59556e, 1, false, 6);
            memberPayActivityConfig.setSceneId("4009001001");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e(b bVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.i0.q1.h.f.a<Integer> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.q1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            if (z) {
                l.L(b.this.f59556e, str);
            } else if (num != null && b.this.f59557f.i() != null && b.this.f59557f.i().size() != 0) {
                for (TailData tailData : b.this.f59557f.i()) {
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
    public class g implements d.b.i0.q1.h.f.a<Void> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.q1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Void r3) {
            if (z) {
                l.L(b.this.f59556e, str);
            } else {
                b.this.notifyDataSetChanged();
            }
        }
    }

    public b(Context context, d.b.i0.q1.h.e.g gVar, View.OnClickListener onClickListener) {
        this.f59556e = context;
        this.f59558g = onClickListener;
        this.f59557f = gVar;
        gVar.n(this.k);
        this.f59557f.p(this.l);
    }

    public final View d(View view) {
        d.b.i0.q1.h.e.c cVar;
        if (view != null && (view.getTag() instanceof d.b.i0.q1.h.e.c)) {
            cVar = (d.b.i0.q1.h.e.c) view.getTag();
        } else {
            cVar = new d.b.i0.q1.h.e.c();
            view = cVar.a(this.f59556e);
            cVar.c(this.f59558g);
            cVar.b();
        }
        cVar.d(3);
        return view;
    }

    public final View e(View view) {
        if (view == null || !(view.getTag() instanceof d.b.i0.q1.h.e.d)) {
            d.b.i0.q1.h.e.d dVar = new d.b.i0.q1.h.e.d();
            View a2 = dVar.a(this.f59556e);
            dVar.c(this.f59559h);
            dVar.b();
            return a2;
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public TailData getItem(int i) {
        if (i >= this.f59557f.i().size()) {
            return null;
        }
        return this.f59557f.i().get(i);
    }

    public final View g(TailData tailData, View view) {
        d.b.i0.q1.h.e.e eVar;
        if (tailData == null) {
            return null;
        }
        if (view != null && (view.getTag() instanceof d.b.i0.q1.h.e.e)) {
            eVar = (d.b.i0.q1.h.e.e) view.getTag();
        } else {
            eVar = new d.b.i0.q1.h.e.e();
            view = eVar.a(this.f59556e);
            eVar.e(this.j);
            eVar.c();
        }
        eVar.f(tailData);
        eVar.h(tailData);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f59557f.i().size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f59557f.i().size() == 0) {
            return 2;
        }
        return i == this.f59557f.i().size() ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 0) {
            return g(getItem(i), view);
        }
        if (getItemViewType(i) == 1) {
            return e(view);
        }
        if (getItemViewType(i) == 2) {
            return d(view);
        }
        if (getItemViewType(i) == 3) {
            return h(view);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public final View h(View view) {
        if (view == null || !(view.getTag() instanceof d.b.i0.q1.h.e.f)) {
            d.b.i0.q1.h.e.f fVar = new d.b.i0.q1.h.e.f();
            View a2 = fVar.a(this.f59556e);
            fVar.c(this.i);
            fVar.b();
            return a2;
        }
        return view;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void i(String str) {
        d.b.b.a.f<?> a2 = j.a(this.f59556e);
        if (a2 == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(a2.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setMessage(str).setNegativeButton(this.f59556e.getString(R.string.cancel), new e(this)).setPositiveButton(this.f59556e.getString(R.string.open_now), new d()).create(a2).show();
    }
}
