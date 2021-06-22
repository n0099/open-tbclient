package d.a.o0.k3.g.a;

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
    public int f60903e;

    /* renamed from: f  reason: collision with root package name */
    public int f60904f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f60905g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f60906h;

    /* renamed from: i  reason: collision with root package name */
    public PersonalCardItemView.b f60907i;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f60908a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f60909b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f60910c;

        /* renamed from: d  reason: collision with root package name */
        public View f60911d;
    }

    /* renamed from: d.a.o0.k3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1486b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60912a;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60903e = 0;
        this.f60904f = 0;
        this.f60906h = tbPageContext;
        this.f60903e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f60904f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        this.f60907i = bVar;
    }

    public void b(List<Object> list) {
        this.f60905g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f60905g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f60905g;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60905g.size()) {
            return null;
        }
        return this.f60905g.get(i2);
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
        C1486b c1486b;
        int itemViewType = getItemViewType(i2);
        Object item = getItem(i2);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C1486b)) {
                c1486b = (C1486b) view.getTag();
            } else {
                c1486b = new C1486b();
                view = LayoutInflater.from(this.f60906h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.group_name);
                c1486b.f60912a = textView;
                textView.setPadding(0, this.f60903e, 0, this.f60904f);
                view.setTag(c1486b);
            }
            if (item != null) {
                c1486b.f60912a.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.f60906h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar2.f60908a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                aVar2.f60909b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                aVar2.f60910c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                aVar2.f60911d = inflate.findViewById(R.id.divider_line);
                aVar2.f60908a.setCardViewController(this.f60907i);
                aVar2.f60909b.setCardViewController(this.f60907i);
                aVar2.f60910c.setCardViewController(this.f60907i);
                inflate.setTag(aVar2);
                aVar = aVar2;
                view = inflate;
            }
            if (item != null) {
                List list = (List) item;
                int size = list.size();
                if (size == 1) {
                    aVar.f60908a.c((d.a.o0.k3.a) list.get(0));
                    aVar.f60908a.setVisibility(0);
                    aVar.f60909b.setVisibility(8);
                    aVar.f60910c.setVisibility(8);
                } else if (size == 2) {
                    aVar.f60908a.c((d.a.o0.k3.a) list.get(0));
                    aVar.f60909b.c((d.a.o0.k3.a) list.get(1));
                    aVar.f60908a.setVisibility(0);
                    aVar.f60909b.setVisibility(0);
                    aVar.f60910c.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    aVar.f60908a.c((d.a.o0.k3.a) list.get(0));
                    aVar.f60909b.c((d.a.o0.k3.a) list.get(1));
                    aVar.f60910c.c((d.a.o0.k3.a) list.get(2));
                    aVar.f60908a.setVisibility(0);
                    aVar.f60909b.setVisibility(0);
                    aVar.f60910c.setVisibility(0);
                }
                if (getItem(i2 + 1) instanceof List) {
                    aVar.f60911d.setVisibility(8);
                } else {
                    aVar.f60911d.setVisibility(0);
                }
            }
        }
        this.f60906h.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
