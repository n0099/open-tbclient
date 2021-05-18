package d.a.k0.u0.a;

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
@Deprecated
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<GiftCommonList.NumInfo> f62035e;

    /* renamed from: f  reason: collision with root package name */
    public Context f62036f;

    /* renamed from: d.a.k0.u0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1668b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62037a;

        /* renamed from: b  reason: collision with root package name */
        public View f62038b;

        public C1668b(b bVar) {
        }
    }

    public b(Context context) {
        this.f62036f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.NumInfo getItem(int i2) {
        if (this.f62035e == null || i2 < 0 || i2 >= getCount() - 1) {
            return null;
        }
        return this.f62035e.get(i2);
    }

    public void b(List<GiftCommonList.NumInfo> list) {
        this.f62035e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<GiftCommonList.NumInfo> list = this.f62035e;
        if (list == null) {
            return 1;
        }
        return list.size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return i2 == getCount() - 1 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1668b c1668b;
        if (view != null && view.getTag() != null) {
            c1668b = (C1668b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f62036f).inflate(R.layout.gift_num_item, (ViewGroup) null);
            c1668b = new C1668b();
            c1668b.f62037a = (TextView) view.findViewById(R.id.text);
            c1668b.f62038b = view.findViewById(R.id.divider);
            view.setTag(c1668b);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setViewTextColor(c1668b.f62037a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(c1668b.f62038b, R.color.CAM_X0204);
        GiftCommonList.NumInfo item = getItem(i2);
        if (getItemViewType(i2) == 1) {
            c1668b.f62037a.setText(R.string.custom_num);
            c1668b.f62038b.setVisibility(4);
        } else {
            if (item != null) {
                int num = item.getNum() > 0 ? item.getNum() : 1;
                String name = item.getName() != null ? item.getName() : "";
                TextView textView = c1668b.f62037a;
                textView.setText(num + name);
                c1668b.f62038b.setVisibility(0);
            } else {
                c1668b.f62037a.setText("");
                c1668b.f62038b.setVisibility(0);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
