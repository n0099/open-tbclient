package d.b.i0.u0.a;

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
    public List<GiftCommonList.NumInfo> f62680e;

    /* renamed from: f  reason: collision with root package name */
    public Context f62681f;

    /* renamed from: d.b.i0.u0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1640b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62682a;

        /* renamed from: b  reason: collision with root package name */
        public View f62683b;

        public C1640b(b bVar) {
        }
    }

    public b(Context context) {
        this.f62681f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.f62680e == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.f62680e.get(i);
    }

    public void b(List<GiftCommonList.NumInfo> list) {
        this.f62680e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<GiftCommonList.NumInfo> list = this.f62680e;
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
        C1640b c1640b;
        if (view != null && view.getTag() != null) {
            c1640b = (C1640b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f62681f).inflate(R.layout.gift_num_item, (ViewGroup) null);
            c1640b = new C1640b();
            c1640b.f62682a = (TextView) view.findViewById(R.id.text);
            c1640b.f62683b = view.findViewById(R.id.divider);
            view.setTag(c1640b);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setViewTextColor(c1640b.f62682a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(c1640b.f62683b, R.color.CAM_X0204);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            c1640b.f62682a.setText(R.string.custom_num);
            c1640b.f62683b.setVisibility(4);
        } else {
            if (item != null) {
                int num = item.getNum() > 0 ? item.getNum() : 1;
                String name = item.getName() != null ? item.getName() : "";
                TextView textView = c1640b.f62682a;
                textView.setText(num + name);
                c1640b.f62683b.setVisibility(0);
            } else {
                c1640b.f62682a.setText("");
                c1640b.f62683b.setVisibility(0);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
