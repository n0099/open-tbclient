package d.a.j0.u0.b;

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
    public List<e> f61328e;

    /* renamed from: f  reason: collision with root package name */
    public Context f61329f;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61330a;

        /* renamed from: b  reason: collision with root package name */
        public View f61331b;

        public b(d dVar) {
        }
    }

    public d(Context context) {
        this.f61329f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        if (this.f61328e == null || i2 < 0 || i2 >= getCount() - 1) {
            return null;
        }
        return this.f61328e.get(i2);
    }

    public void b(List<e> list) {
        this.f61328e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<e> list = this.f61328e;
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
        b bVar;
        if (view != null && view.getTag() != null) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61329f).inflate(R.layout.gift_num_item, (ViewGroup) null);
            bVar = new b();
            bVar.f61330a = (TextView) view.findViewById(R.id.text);
            bVar.f61331b = view.findViewById(R.id.divider);
            view.setTag(bVar);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setViewTextColor(bVar.f61330a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(bVar.f61331b, R.color.CAM_X0204);
        e item = getItem(i2);
        if (getItemViewType(i2) == 1) {
            bVar.f61330a.setText(R.string.custom_num);
            bVar.f61331b.setVisibility(4);
        } else {
            if (item != null) {
                int b2 = item.b() > 0 ? item.b() : 1;
                String a2 = item.a() != null ? item.a() : "";
                TextView textView = bVar.f61330a;
                textView.setText(b2 + a2);
                bVar.f61331b.setVisibility(0);
            } else {
                bVar.f61330a.setText("");
                bVar.f61331b.setVisibility(0);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
