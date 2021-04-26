package d.a.j0.j3.g.a;

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
    public int f56202e;

    /* renamed from: f  reason: collision with root package name */
    public int f56203f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f56204g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f56205h;

    /* renamed from: i  reason: collision with root package name */
    public PersonalCardItemView.b f56206i;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f56207a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f56208b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f56209c;

        /* renamed from: d  reason: collision with root package name */
        public View f56210d;
    }

    /* renamed from: d.a.j0.j3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1336b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56211a;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f56202e = 0;
        this.f56203f = 0;
        this.f56205h = tbPageContext;
        this.f56202e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f56203f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        this.f56206i = bVar;
    }

    public void b(List<Object> list) {
        this.f56204g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56204g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f56204g;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56204g.size()) {
            return null;
        }
        return this.f56204g.get(i2);
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
        C1336b c1336b;
        int itemViewType = getItemViewType(i2);
        Object item = getItem(i2);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C1336b)) {
                c1336b = (C1336b) view.getTag();
            } else {
                c1336b = new C1336b();
                view = LayoutInflater.from(this.f56205h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.group_name);
                c1336b.f56211a = textView;
                textView.setPadding(0, this.f56202e, 0, this.f56203f);
                view.setTag(c1336b);
            }
            if (item != null) {
                c1336b.f56211a.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.f56205h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar2.f56207a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                aVar2.f56208b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                aVar2.f56209c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                aVar2.f56210d = inflate.findViewById(R.id.divider_line);
                aVar2.f56207a.setCardViewController(this.f56206i);
                aVar2.f56208b.setCardViewController(this.f56206i);
                aVar2.f56209c.setCardViewController(this.f56206i);
                inflate.setTag(aVar2);
                aVar = aVar2;
                view = inflate;
            }
            if (item != null) {
                List list = (List) item;
                int size = list.size();
                if (size == 1) {
                    aVar.f56207a.c((d.a.j0.j3.a) list.get(0));
                    aVar.f56207a.setVisibility(0);
                    aVar.f56208b.setVisibility(8);
                    aVar.f56209c.setVisibility(8);
                } else if (size == 2) {
                    aVar.f56207a.c((d.a.j0.j3.a) list.get(0));
                    aVar.f56208b.c((d.a.j0.j3.a) list.get(1));
                    aVar.f56207a.setVisibility(0);
                    aVar.f56208b.setVisibility(0);
                    aVar.f56209c.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    aVar.f56207a.c((d.a.j0.j3.a) list.get(0));
                    aVar.f56208b.c((d.a.j0.j3.a) list.get(1));
                    aVar.f56209c.c((d.a.j0.j3.a) list.get(2));
                    aVar.f56207a.setVisibility(0);
                    aVar.f56208b.setVisibility(0);
                    aVar.f56209c.setVisibility(0);
                }
                if (getItem(i2 + 1) instanceof List) {
                    aVar.f56210d.setVisibility(8);
                } else {
                    aVar.f56210d.setVisibility(0);
                }
            }
        }
        this.f56205h.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
