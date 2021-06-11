package d.a.n0.k3.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f60778e;

    /* renamed from: f  reason: collision with root package name */
    public int f60779f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f60780g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f60781h;

    /* renamed from: i  reason: collision with root package name */
    public PersonalCardItemView.b f60782i;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f60783a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f60784b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f60785c;

        /* renamed from: d  reason: collision with root package name */
        public View f60786d;
    }

    /* renamed from: d.a.n0.k3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1482b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60787a;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60778e = 0;
        this.f60779f = 0;
        this.f60781h = tbPageContext;
        this.f60778e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f60779f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        this.f60782i = bVar;
    }

    public void b(List<Object> list) {
        this.f60780g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f60780g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f60780g;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60780g.size()) {
            return null;
        }
        return this.f60780g.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (getItem(i2) != null) {
            return i2;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return getItem(i2) instanceof List ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        C1482b c1482b;
        int itemViewType = getItemViewType(i2);
        Object item = getItem(i2);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C1482b)) {
                c1482b = (C1482b) view.getTag();
            } else {
                c1482b = new C1482b();
                view = LayoutInflater.from(this.f60781h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.group_name);
                c1482b.f60787a = textView;
                textView.setPadding(0, this.f60778e, 0, this.f60779f);
                view.setTag(c1482b);
            }
            if (item != null) {
                c1482b.f60787a.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.f60781h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar2.f60783a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                aVar2.f60784b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                aVar2.f60785c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                aVar2.f60786d = inflate.findViewById(R.id.divider_line);
                aVar2.f60783a.setCardViewController(this.f60782i);
                aVar2.f60784b.setCardViewController(this.f60782i);
                aVar2.f60785c.setCardViewController(this.f60782i);
                inflate.setTag(aVar2);
                aVar = aVar2;
                view = inflate;
            }
            if (item != null) {
                List list = (List) item;
                int size = list.size();
                if (size == 1) {
                    aVar.f60783a.c((d.a.n0.k3.a) list.get(0));
                    aVar.f60783a.setVisibility(0);
                    aVar.f60784b.setVisibility(8);
                    aVar.f60785c.setVisibility(8);
                } else if (size == 2) {
                    aVar.f60783a.c((d.a.n0.k3.a) list.get(0));
                    aVar.f60784b.c((d.a.n0.k3.a) list.get(1));
                    aVar.f60783a.setVisibility(0);
                    aVar.f60784b.setVisibility(0);
                    aVar.f60785c.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    aVar.f60783a.c((d.a.n0.k3.a) list.get(0));
                    aVar.f60784b.c((d.a.n0.k3.a) list.get(1));
                    aVar.f60785c.c((d.a.n0.k3.a) list.get(2));
                    aVar.f60783a.setVisibility(0);
                    aVar.f60784b.setVisibility(0);
                    aVar.f60785c.setVisibility(0);
                }
                if (getItem(i2 + 1) instanceof List) {
                    aVar.f60786d.setVisibility(8);
                } else {
                    aVar.f60786d.setVisibility(0);
                }
            }
        }
        this.f60781h.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
