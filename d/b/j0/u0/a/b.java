package d.b.j0.u0.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<GiftCommonList.NumInfo> f63101e;

    /* renamed from: f  reason: collision with root package name */
    public Context f63102f;

    /* renamed from: d.b.j0.u0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1663b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63103a;

        /* renamed from: b  reason: collision with root package name */
        public View f63104b;

        public C1663b(b bVar) {
        }
    }

    public b(Context context) {
        this.f63102f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.f63101e == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.f63101e.get(i);
    }

    public void b(List<GiftCommonList.NumInfo> list) {
        this.f63101e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<GiftCommonList.NumInfo> list = this.f63101e;
        if (list == null) {
            return 1;
        }
        return list.size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == getCount() - 1 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1663b c1663b;
        if (view != null && view.getTag() != null) {
            c1663b = (C1663b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f63102f).inflate(R.layout.gift_num_item, (ViewGroup) null);
            c1663b = new C1663b();
            c1663b.f63103a = (TextView) view.findViewById(R.id.text);
            c1663b.f63104b = view.findViewById(R.id.divider);
            view.setTag(c1663b);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setViewTextColor(c1663b.f63103a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(c1663b.f63104b, R.color.CAM_X0204);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            c1663b.f63103a.setText(R.string.custom_num);
            c1663b.f63104b.setVisibility(4);
        } else {
            if (item != null) {
                int num = item.getNum() > 0 ? item.getNum() : 1;
                String name = item.getName() != null ? item.getName() : "";
                TextView textView = c1663b.f63103a;
                textView.setText(num + name);
                c1663b.f63104b.setVisibility(0);
            } else {
                c1663b.f63103a.setText("");
                c1663b.f63104b.setVisibility(0);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
