package d.b.j0.r1.h.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61634e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.r1.h.c.d f61635f;

    /* renamed from: h  reason: collision with root package name */
    public f f61637h;
    public View.OnClickListener i = new View$OnClickListenerC1574a();
    public View.OnClickListener j = new b();
    public View.OnClickListener k = new c();
    public d.b.j0.r1.h.f.a<Void> l = new d();
    public d.b.j0.r1.h.f.a<Integer> m = new e();

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f61636g = new ArrayList();

    /* renamed from: d.b.j0.r1.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1574a implements View.OnClickListener {
        public View$OnClickListenerC1574a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailData c2;
            if (view == null || view.getTag() == null || (c2 = ((d.b.j0.r1.h.c.c) view.getTag()).c()) == null || a.this.f61635f.g()) {
                return;
            }
            a.this.i(c2.getId(), c2.getContent(), c2.getFontColor());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.j0.r1.h.c.c cVar;
            if (view == null || (cVar = (d.b.j0.r1.h.c.c) view.getTag()) == null || cVar.c() == null) {
                return;
            }
            a.this.f61635f.e(cVar.c().getId());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.j0.r1.h.f.a<Void> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.r1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Void r3) {
            if (z) {
                a.this.f61634e.showToast(str);
                return;
            }
            a aVar = a.this;
            aVar.l(aVar.f61635f.h());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.j0.r1.h.f.a<Integer> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.r1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            if (z) {
                a.this.f61634e.showToast(str);
                return;
            }
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, new d.b.j0.r1.h.a.e(3, tailData)));
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void callback();
    }

    public a(TbPageContext<?> tbPageContext, d.b.j0.r1.h.c.d dVar, f fVar) {
        this.f61634e = tbPageContext;
        this.f61635f = dVar;
        this.f61635f.m(this.l);
        this.f61635f.k(this.m);
        this.f61637h = fVar;
    }

    public final View f(View view) {
        View view2;
        d.b.j0.r1.h.c.b bVar;
        if (view == null) {
            bVar = new d.b.j0.r1.h.c.b();
            view2 = bVar.b(this.f61634e.getPageActivity());
            bVar.c(this.i);
            bVar.a(this.f61634e);
        } else {
            view2 = view;
            bVar = (d.b.j0.r1.h.c.b) view.getTag();
        }
        bVar.d(this.f61635f.f());
        return view2;
    }

    public final View g(Object obj, View view) {
        View view2;
        d.b.j0.r1.h.c.c cVar;
        if (obj == null || !(obj instanceof TailData)) {
            return null;
        }
        TailData tailData = (TailData) obj;
        if (view == null) {
            cVar = new d.b.j0.r1.h.c.c();
            view2 = cVar.b(this.f61634e.getPageActivity());
            cVar.h(this.j);
            cVar.f(this.k);
            cVar.a(this.f61634e);
        } else {
            view2 = view;
            cVar = (d.b.j0.r1.h.c.c) view.getTag();
        }
        cVar.i(tailData);
        cVar.g(Boolean.valueOf(this.f61635f.g()));
        return view2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f61636g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f61636g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.f61636g.get(i);
        if (obj instanceof TailData) {
            return 0;
        }
        return obj instanceof d.b.j0.r1.h.a.a ? 1 : -1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 0) {
            return g(getItem(i), view);
        }
        if (getItemViewType(i) == 1) {
            return f(view);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public final void h() {
        this.f61634e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f61634e.getPageActivity(), this.f61635f.h().isEmpty())));
    }

    public final void i(int i, String str, String str2) {
        this.f61634e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f61634e.getPageActivity(), i, str, str2)));
    }

    public void j() {
        k();
        notifyDataSetChanged();
    }

    public final void k() {
        f fVar = this.f61637h;
        if (fVar != null) {
            fVar.callback();
        }
        this.f61636g.clear();
        this.f61636g.addAll(this.f61635f.h());
        if (this.f61635f.g()) {
            return;
        }
        this.f61636g.add(new d.b.j0.r1.h.a.a(this.f61635f.f()));
    }

    public final void l(List<TailData> list) {
        this.f61635f.n(list);
        j();
    }
}
