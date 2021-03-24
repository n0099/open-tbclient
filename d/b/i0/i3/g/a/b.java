package d.b.i0.i3.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f56343e;

    /* renamed from: f  reason: collision with root package name */
    public int f56344f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f56345g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f56346h;
    public PersonalCardItemView.b i;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f56347a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f56348b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f56349c;

        /* renamed from: d  reason: collision with root package name */
        public View f56350d;
    }

    /* renamed from: d.b.i0.i3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1317b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56351a;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f56343e = 0;
        this.f56344f = 0;
        this.f56346h = tbPageContext;
        this.f56343e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f56344f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        this.i = bVar;
    }

    public void b(List<Object> list) {
        this.f56345g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56345g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f56345g;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56345g.size()) {
            return null;
        }
        return this.f56345g.get(i);
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
        C1317b c1317b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C1317b)) {
                c1317b = (C1317b) view.getTag();
            } else {
                c1317b = new C1317b();
                view = LayoutInflater.from(this.f56346h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.group_name);
                c1317b.f56351a = textView;
                textView.setPadding(0, this.f56343e, 0, this.f56344f);
                view.setTag(c1317b);
            }
            if (item != null) {
                c1317b.f56351a.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.f56346h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar2.f56347a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                aVar2.f56348b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                aVar2.f56349c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                aVar2.f56350d = inflate.findViewById(R.id.divider_line);
                aVar2.f56347a.setCardViewController(this.i);
                aVar2.f56348b.setCardViewController(this.i);
                aVar2.f56349c.setCardViewController(this.i);
                inflate.setTag(aVar2);
                aVar = aVar2;
                view = inflate;
            }
            if (item != null) {
                List list = (List) item;
                int size = list.size();
                if (size == 1) {
                    aVar.f56347a.c((d.b.i0.i3.a) list.get(0));
                    aVar.f56347a.setVisibility(0);
                    aVar.f56348b.setVisibility(8);
                    aVar.f56349c.setVisibility(8);
                } else if (size == 2) {
                    aVar.f56347a.c((d.b.i0.i3.a) list.get(0));
                    aVar.f56348b.c((d.b.i0.i3.a) list.get(1));
                    aVar.f56347a.setVisibility(0);
                    aVar.f56348b.setVisibility(0);
                    aVar.f56349c.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    aVar.f56347a.c((d.b.i0.i3.a) list.get(0));
                    aVar.f56348b.c((d.b.i0.i3.a) list.get(1));
                    aVar.f56349c.c((d.b.i0.i3.a) list.get(2));
                    aVar.f56347a.setVisibility(0);
                    aVar.f56348b.setVisibility(0);
                    aVar.f56349c.setVisibility(0);
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.f56350d.setVisibility(8);
                } else {
                    aVar.f56350d.setVisibility(0);
                }
            }
        }
        this.f56346h.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
