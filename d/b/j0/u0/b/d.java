package d.b.j0.u0.b;

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
    public List<e> f63118e;

    /* renamed from: f  reason: collision with root package name */
    public Context f63119f;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63120a;

        /* renamed from: b  reason: collision with root package name */
        public View f63121b;

        public b(d dVar) {
        }
    }

    public d(Context context) {
        this.f63119f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i) {
        if (this.f63118e == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.f63118e.get(i);
    }

    public void b(List<e> list) {
        this.f63118e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<e> list = this.f63118e;
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
            view = LayoutInflater.from(this.f63119f).inflate(R.layout.gift_num_item, (ViewGroup) null);
            bVar = new b();
            bVar.f63120a = (TextView) view.findViewById(R.id.text);
            bVar.f63121b = view.findViewById(R.id.divider);
            view.setTag(bVar);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setViewTextColor(bVar.f63120a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(bVar.f63121b, R.color.CAM_X0204);
        e item = getItem(i);
        if (getItemViewType(i) == 1) {
            bVar.f63120a.setText(R.string.custom_num);
            bVar.f63121b.setVisibility(4);
        } else {
            if (item != null) {
                int b2 = item.b() > 0 ? item.b() : 1;
                String a2 = item.a() != null ? item.a() : "";
                TextView textView = bVar.f63120a;
                textView.setText(b2 + a2);
                bVar.f63121b.setVisibility(0);
            } else {
                bVar.f63120a.setText("");
                bVar.f63121b.setVisibility(0);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
