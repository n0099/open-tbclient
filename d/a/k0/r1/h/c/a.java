package d.a.k0.r1.h.c;

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
    public TbPageContext<?> f60534e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.r1.h.c.d f60535f;

    /* renamed from: h  reason: collision with root package name */
    public f f60537h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f60538i = new View$OnClickListenerC1587a();
    public View.OnClickListener j = new b();
    public View.OnClickListener k = new c();
    public d.a.k0.r1.h.f.a<Void> l = new d();
    public d.a.k0.r1.h.f.a<Integer> m = new e();

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f60536g = new ArrayList();

    /* renamed from: d.a.k0.r1.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1587a implements View.OnClickListener {
        public View$OnClickListenerC1587a() {
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
            if (view == null || view.getTag() == null || (c2 = ((d.a.k0.r1.h.c.c) view.getTag()).c()) == null || a.this.f60535f.g()) {
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
            d.a.k0.r1.h.c.c cVar;
            if (view == null || (cVar = (d.a.k0.r1.h.c.c) view.getTag()) == null || cVar.c() == null) {
                return;
            }
            a.this.f60535f.e(cVar.c().getId());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.k0.r1.h.f.a<Void> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.r1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Void r3) {
            if (z) {
                a.this.f60534e.showToast(str);
                return;
            }
            a aVar = a.this;
            aVar.l(aVar.f60535f.h());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.k0.r1.h.f.a<Integer> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.r1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            if (z) {
                a.this.f60534e.showToast(str);
                return;
            }
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, new d.a.k0.r1.h.a.e(3, tailData)));
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void callback();
    }

    public a(TbPageContext<?> tbPageContext, d.a.k0.r1.h.c.d dVar, f fVar) {
        this.f60534e = tbPageContext;
        this.f60535f = dVar;
        this.f60535f.m(this.l);
        this.f60535f.k(this.m);
        this.f60537h = fVar;
    }

    public final View f(View view) {
        View view2;
        d.a.k0.r1.h.c.b bVar;
        if (view == null) {
            bVar = new d.a.k0.r1.h.c.b();
            view2 = bVar.b(this.f60534e.getPageActivity());
            bVar.c(this.f60538i);
            bVar.a(this.f60534e);
        } else {
            view2 = view;
            bVar = (d.a.k0.r1.h.c.b) view.getTag();
        }
        bVar.d(this.f60535f.f());
        return view2;
    }

    public final View g(Object obj, View view) {
        View view2;
        d.a.k0.r1.h.c.c cVar;
        if (obj == null || !(obj instanceof TailData)) {
            return null;
        }
        TailData tailData = (TailData) obj;
        if (view == null) {
            cVar = new d.a.k0.r1.h.c.c();
            view2 = cVar.b(this.f60534e.getPageActivity());
            cVar.h(this.j);
            cVar.f(this.k);
            cVar.a(this.f60534e);
        } else {
            view2 = view;
            cVar = (d.a.k0.r1.h.c.c) view.getTag();
        }
        cVar.i(tailData);
        cVar.g(Boolean.valueOf(this.f60535f.g()));
        return view2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60536g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f60536g.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        Object obj = this.f60536g.get(i2);
        if (obj instanceof TailData) {
            return 0;
        }
        return obj instanceof d.a.k0.r1.h.a.a ? 1 : -1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (getItemViewType(i2) == 0) {
            return g(getItem(i2), view);
        }
        if (getItemViewType(i2) == 1) {
            return f(view);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public final void h() {
        this.f60534e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f60534e.getPageActivity(), this.f60535f.h().isEmpty())));
    }

    public final void i(int i2, String str, String str2) {
        this.f60534e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f60534e.getPageActivity(), i2, str, str2)));
    }

    public void j() {
        k();
        notifyDataSetChanged();
    }

    public final void k() {
        f fVar = this.f60537h;
        if (fVar != null) {
            fVar.callback();
        }
        this.f60536g.clear();
        this.f60536g.addAll(this.f60535f.h());
        if (this.f60535f.g()) {
            return;
        }
        this.f60536g.add(new d.a.k0.r1.h.a.a(this.f60535f.f()));
    }

    public final void l(List<TailData> list) {
        this.f60535f.n(list);
        j();
    }
}
