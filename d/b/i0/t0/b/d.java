package d.b.i0.t0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<e> f61007e;

    /* renamed from: f  reason: collision with root package name */
    public Context f61008f;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61009a;

        /* renamed from: b  reason: collision with root package name */
        public View f61010b;

        public b(d dVar) {
        }
    }

    public d(Context context) {
        this.f61008f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i) {
        if (this.f61007e == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.f61007e.get(i);
    }

    public void b(List<e> list) {
        this.f61007e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<e> list = this.f61007e;
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
        b bVar;
        if (view != null && view.getTag() != null) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61008f).inflate(R.layout.gift_num_item, (ViewGroup) null);
            bVar = new b();
            bVar.f61009a = (TextView) view.findViewById(R.id.text);
            bVar.f61010b = view.findViewById(R.id.divider);
            view.setTag(bVar);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setViewTextColor(bVar.f61009a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(bVar.f61010b, R.color.CAM_X0204);
        e item = getItem(i);
        if (getItemViewType(i) == 1) {
            bVar.f61009a.setText(R.string.custom_num);
            bVar.f61010b.setVisibility(4);
        } else {
            if (item != null) {
                int b2 = item.b() > 0 ? item.b() : 1;
                String a2 = item.a() != null ? item.a() : "";
                TextView textView = bVar.f61009a;
                textView.setText(b2 + a2);
                bVar.f61010b.setVisibility(0);
            } else {
                bVar.f61009a.setText("");
                bVar.f61010b.setVisibility(0);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
