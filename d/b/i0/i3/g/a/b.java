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
    public int f56344e;

    /* renamed from: f  reason: collision with root package name */
    public int f56345f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f56346g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f56347h;
    public PersonalCardItemView.b i;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f56348a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f56349b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f56350c;

        /* renamed from: d  reason: collision with root package name */
        public View f56351d;
    }

    /* renamed from: d.b.i0.i3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1318b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56352a;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f56344e = 0;
        this.f56345f = 0;
        this.f56347h = tbPageContext;
        this.f56344e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f56345f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        this.i = bVar;
    }

    public void b(List<Object> list) {
        this.f56346g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56346g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f56346g;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56346g.size()) {
            return null;
        }
        return this.f56346g.get(i);
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
        C1318b c1318b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C1318b)) {
                c1318b = (C1318b) view.getTag();
            } else {
                c1318b = new C1318b();
                view = LayoutInflater.from(this.f56347h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.group_name);
                c1318b.f56352a = textView;
                textView.setPadding(0, this.f56344e, 0, this.f56345f);
                view.setTag(c1318b);
            }
            if (item != null) {
                c1318b.f56352a.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.f56347h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar2.f56348a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                aVar2.f56349b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                aVar2.f56350c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                aVar2.f56351d = inflate.findViewById(R.id.divider_line);
                aVar2.f56348a.setCardViewController(this.i);
                aVar2.f56349b.setCardViewController(this.i);
                aVar2.f56350c.setCardViewController(this.i);
                inflate.setTag(aVar2);
                aVar = aVar2;
                view = inflate;
            }
            if (item != null) {
                List list = (List) item;
                int size = list.size();
                if (size == 1) {
                    aVar.f56348a.c((d.b.i0.i3.a) list.get(0));
                    aVar.f56348a.setVisibility(0);
                    aVar.f56349b.setVisibility(8);
                    aVar.f56350c.setVisibility(8);
                } else if (size == 2) {
                    aVar.f56348a.c((d.b.i0.i3.a) list.get(0));
                    aVar.f56349b.c((d.b.i0.i3.a) list.get(1));
                    aVar.f56348a.setVisibility(0);
                    aVar.f56349b.setVisibility(0);
                    aVar.f56350c.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    aVar.f56348a.c((d.b.i0.i3.a) list.get(0));
                    aVar.f56349b.c((d.b.i0.i3.a) list.get(1));
                    aVar.f56350c.c((d.b.i0.i3.a) list.get(2));
                    aVar.f56348a.setVisibility(0);
                    aVar.f56349b.setVisibility(0);
                    aVar.f56350c.setVisibility(0);
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.f56351d.setVisibility(8);
                } else {
                    aVar.f56351d.setVisibility(0);
                }
            }
        }
        this.f56347h.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
