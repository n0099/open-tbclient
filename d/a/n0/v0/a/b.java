package d.a.n0.v0.a;

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
    public List<GiftCommonList.NumInfo> f62192e;

    /* renamed from: f  reason: collision with root package name */
    public Context f62193f;

    /* renamed from: d.a.n0.v0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1681b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62194a;

        /* renamed from: b  reason: collision with root package name */
        public View f62195b;

        public C1681b(b bVar) {
        }
    }

    public b(Context context) {
        this.f62193f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.NumInfo getItem(int i2) {
        if (this.f62192e == null || i2 < 0 || i2 >= getCount() - 1) {
            return null;
        }
        return this.f62192e.get(i2);
    }

    public void b(List<GiftCommonList.NumInfo> list) {
        this.f62192e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<GiftCommonList.NumInfo> list = this.f62192e;
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
        C1681b c1681b;
        if (view != null && view.getTag() != null) {
            c1681b = (C1681b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f62193f).inflate(R.layout.gift_num_item, (ViewGroup) null);
            c1681b = new C1681b();
            c1681b.f62194a = (TextView) view.findViewById(R.id.text);
            c1681b.f62195b = view.findViewById(R.id.divider);
            view.setTag(c1681b);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setViewTextColor(c1681b.f62194a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(c1681b.f62195b, R.color.CAM_X0204);
        GiftCommonList.NumInfo item = getItem(i2);
        if (getItemViewType(i2) == 1) {
            c1681b.f62194a.setText(R.string.custom_num);
            c1681b.f62195b.setVisibility(4);
        } else {
            if (item != null) {
                int num = item.getNum() > 0 ? item.getNum() : 1;
                String name = item.getName() != null ? item.getName() : "";
                TextView textView = c1681b.f62194a;
                textView.setText(num + name);
                c1681b.f62195b.setVisibility(0);
            } else {
                c1681b.f62194a.setText("");
                c1681b.f62195b.setVisibility(0);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
