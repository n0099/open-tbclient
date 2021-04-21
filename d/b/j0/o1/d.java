package d.b.j0.o1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f59217e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f59218f;

    /* renamed from: g  reason: collision with root package name */
    public final String f59219g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59220h = true;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59221a;

        /* renamed from: b  reason: collision with root package name */
        public View f59222b;

        public b(d dVar) {
        }
    }

    public d(Context context, ArrayList<String> arrayList) {
        this.f59217e = context;
        this.f59218f = arrayList;
        this.f59219g = context.getText(R.string.forum).toString();
    }

    public void a(ArrayList<String> arrayList) {
        this.f59218f = arrayList;
    }

    public void b(boolean z) {
        this.f59220h = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f59218f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f59218f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ResourceAsColor"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f59217e).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
            bVar = new b();
            bVar.f59221a = (TextView) view.findViewById(R.id.home_lv_search_forum);
            bVar.f59222b = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Object item = getItem(i);
        if (item == null) {
            return view;
        }
        String str = (String) item;
        if (this.f59220h) {
            bVar.f59221a.setText(str.concat(this.f59219g));
        } else {
            bVar.f59221a.setText(str);
        }
        SkinManager.setViewTextColor(bVar.f59221a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(bVar.f59222b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
