package d.a.k0.j3.g.a;

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
    public int f56909e;

    /* renamed from: f  reason: collision with root package name */
    public int f56910f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f56911g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f56912h;

    /* renamed from: i  reason: collision with root package name */
    public PersonalCardItemView.b f56913i;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f56914a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f56915b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f56916c;

        /* renamed from: d  reason: collision with root package name */
        public View f56917d;
    }

    /* renamed from: d.a.k0.j3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1408b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56918a;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f56909e = 0;
        this.f56910f = 0;
        this.f56912h = tbPageContext;
        this.f56909e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f56910f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        this.f56913i = bVar;
    }

    public void b(List<Object> list) {
        this.f56911g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56911g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f56911g;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56911g.size()) {
            return null;
        }
        return this.f56911g.get(i2);
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
        C1408b c1408b;
        int itemViewType = getItemViewType(i2);
        Object item = getItem(i2);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C1408b)) {
                c1408b = (C1408b) view.getTag();
            } else {
                c1408b = new C1408b();
                view = LayoutInflater.from(this.f56912h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.group_name);
                c1408b.f56918a = textView;
                textView.setPadding(0, this.f56909e, 0, this.f56910f);
                view.setTag(c1408b);
            }
            if (item != null) {
                c1408b.f56918a.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.f56912h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar2.f56914a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                aVar2.f56915b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                aVar2.f56916c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                aVar2.f56917d = inflate.findViewById(R.id.divider_line);
                aVar2.f56914a.setCardViewController(this.f56913i);
                aVar2.f56915b.setCardViewController(this.f56913i);
                aVar2.f56916c.setCardViewController(this.f56913i);
                inflate.setTag(aVar2);
                aVar = aVar2;
                view = inflate;
            }
            if (item != null) {
                List list = (List) item;
                int size = list.size();
                if (size == 1) {
                    aVar.f56914a.c((d.a.k0.j3.a) list.get(0));
                    aVar.f56914a.setVisibility(0);
                    aVar.f56915b.setVisibility(8);
                    aVar.f56916c.setVisibility(8);
                } else if (size == 2) {
                    aVar.f56914a.c((d.a.k0.j3.a) list.get(0));
                    aVar.f56915b.c((d.a.k0.j3.a) list.get(1));
                    aVar.f56914a.setVisibility(0);
                    aVar.f56915b.setVisibility(0);
                    aVar.f56916c.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    aVar.f56914a.c((d.a.k0.j3.a) list.get(0));
                    aVar.f56915b.c((d.a.k0.j3.a) list.get(1));
                    aVar.f56916c.c((d.a.k0.j3.a) list.get(2));
                    aVar.f56914a.setVisibility(0);
                    aVar.f56915b.setVisibility(0);
                    aVar.f56916c.setVisibility(0);
                }
                if (getItem(i2 + 1) instanceof List) {
                    aVar.f56917d.setVisibility(8);
                } else {
                    aVar.f56917d.setVisibility(0);
                }
            }
        }
        this.f56912h.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
