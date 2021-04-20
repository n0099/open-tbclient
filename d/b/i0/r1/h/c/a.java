package d.b.i0.r1.h.c;

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
    public TbPageContext<?> f61213e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.r1.h.c.d f61214f;

    /* renamed from: h  reason: collision with root package name */
    public f f61216h;
    public View.OnClickListener i = new View$OnClickListenerC1551a();
    public View.OnClickListener j = new b();
    public View.OnClickListener k = new c();
    public d.b.i0.r1.h.f.a<Void> l = new d();
    public d.b.i0.r1.h.f.a<Integer> m = new e();

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f61215g = new ArrayList();

    /* renamed from: d.b.i0.r1.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1551a implements View.OnClickListener {
        public View$OnClickListenerC1551a() {
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
            if (view == null || view.getTag() == null || (c2 = ((d.b.i0.r1.h.c.c) view.getTag()).c()) == null || a.this.f61214f.g()) {
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
            d.b.i0.r1.h.c.c cVar;
            if (view == null || (cVar = (d.b.i0.r1.h.c.c) view.getTag()) == null || cVar.c() == null) {
                return;
            }
            a.this.f61214f.e(cVar.c().getId());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.i0.r1.h.f.a<Void> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.r1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Void r3) {
            if (z) {
                a.this.f61213e.showToast(str);
                return;
            }
            a aVar = a.this;
            aVar.l(aVar.f61214f.h());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.i0.r1.h.f.a<Integer> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.r1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            if (z) {
                a.this.f61213e.showToast(str);
                return;
            }
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, new d.b.i0.r1.h.a.e(3, tailData)));
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void callback();
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.r1.h.c.d dVar, f fVar) {
        this.f61213e = tbPageContext;
        this.f61214f = dVar;
        this.f61214f.m(this.l);
        this.f61214f.k(this.m);
        this.f61216h = fVar;
    }

    public final View f(View view) {
        View view2;
        d.b.i0.r1.h.c.b bVar;
        if (view == null) {
            bVar = new d.b.i0.r1.h.c.b();
            view2 = bVar.b(this.f61213e.getPageActivity());
            bVar.c(this.i);
            bVar.a(this.f61213e);
        } else {
            view2 = view;
            bVar = (d.b.i0.r1.h.c.b) view.getTag();
        }
        bVar.d(this.f61214f.f());
        return view2;
    }

    public final View g(Object obj, View view) {
        View view2;
        d.b.i0.r1.h.c.c cVar;
        if (obj == null || !(obj instanceof TailData)) {
            return null;
        }
        TailData tailData = (TailData) obj;
        if (view == null) {
            cVar = new d.b.i0.r1.h.c.c();
            view2 = cVar.b(this.f61213e.getPageActivity());
            cVar.h(this.j);
            cVar.f(this.k);
            cVar.a(this.f61213e);
        } else {
            view2 = view;
            cVar = (d.b.i0.r1.h.c.c) view.getTag();
        }
        cVar.i(tailData);
        cVar.g(Boolean.valueOf(this.f61214f.g()));
        return view2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f61215g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f61215g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.f61215g.get(i);
        if (obj instanceof TailData) {
            return 0;
        }
        return obj instanceof d.b.i0.r1.h.a.a ? 1 : -1;
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
        this.f61213e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f61213e.getPageActivity(), this.f61214f.h().isEmpty())));
    }

    public final void i(int i, String str, String str2) {
        this.f61213e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f61213e.getPageActivity(), i, str, str2)));
    }

    public void j() {
        k();
        notifyDataSetChanged();
    }

    public final void k() {
        f fVar = this.f61216h;
        if (fVar != null) {
            fVar.callback();
        }
        this.f61215g.clear();
        this.f61215g.addAll(this.f61214f.h());
        if (this.f61214f.g()) {
            return;
        }
        this.f61215g.add(new d.b.i0.r1.h.a.a(this.f61214f.f()));
    }

    public final void l(List<TailData> list) {
        this.f61214f.n(list);
        j();
    }
}
