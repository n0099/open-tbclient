package d.b.j0.j3.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f58212e;

    /* renamed from: f  reason: collision with root package name */
    public int f58213f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f58214g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f58215h;
    public PersonalCardItemView.b i;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f58216a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f58217b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f58218c;

        /* renamed from: d  reason: collision with root package name */
        public View f58219d;
    }

    /* renamed from: d.b.j0.j3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1397b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58220a;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f58212e = 0;
        this.f58213f = 0;
        this.f58215h = tbPageContext;
        this.f58212e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f58213f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        this.i = bVar;
    }

    public void b(List<Object> list) {
        this.f58214g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f58214g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f58214g;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f58214g.size()) {
            return null;
        }
        return this.f58214g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof List ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        C1397b c1397b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C1397b)) {
                c1397b = (C1397b) view.getTag();
            } else {
                c1397b = new C1397b();
                view = LayoutInflater.from(this.f58215h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.group_name);
                c1397b.f58220a = textView;
                textView.setPadding(0, this.f58212e, 0, this.f58213f);
                view.setTag(c1397b);
            }
            if (item != null) {
                c1397b.f58220a.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.f58215h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar2.f58216a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                aVar2.f58217b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                aVar2.f58218c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                aVar2.f58219d = inflate.findViewById(R.id.divider_line);
                aVar2.f58216a.setCardViewController(this.i);
                aVar2.f58217b.setCardViewController(this.i);
                aVar2.f58218c.setCardViewController(this.i);
                inflate.setTag(aVar2);
                aVar = aVar2;
                view = inflate;
            }
            if (item != null) {
                List list = (List) item;
                int size = list.size();
                if (size == 1) {
                    aVar.f58216a.c((d.b.j0.j3.a) list.get(0));
                    aVar.f58216a.setVisibility(0);
                    aVar.f58217b.setVisibility(8);
                    aVar.f58218c.setVisibility(8);
                } else if (size == 2) {
                    aVar.f58216a.c((d.b.j0.j3.a) list.get(0));
                    aVar.f58217b.c((d.b.j0.j3.a) list.get(1));
                    aVar.f58216a.setVisibility(0);
                    aVar.f58217b.setVisibility(0);
                    aVar.f58218c.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    aVar.f58216a.c((d.b.j0.j3.a) list.get(0));
                    aVar.f58217b.c((d.b.j0.j3.a) list.get(1));
                    aVar.f58218c.c((d.b.j0.j3.a) list.get(2));
                    aVar.f58216a.setVisibility(0);
                    aVar.f58217b.setVisibility(0);
                    aVar.f58218c.setVisibility(0);
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.f58219d.setVisibility(8);
                } else {
                    aVar.f58219d.setVisibility(0);
                }
            }
        }
        this.f58215h.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
