package d.a.o0.p1;

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
    public final Context f61878e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f61879f;

    /* renamed from: g  reason: collision with root package name */
    public final String f61880g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61881h = true;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61882a;

        /* renamed from: b  reason: collision with root package name */
        public View f61883b;

        public b(d dVar) {
        }
    }

    public d(Context context, ArrayList<String> arrayList) {
        this.f61878e = context;
        this.f61879f = arrayList;
        this.f61880g = context.getText(R.string.forum).toString();
    }

    public void a(ArrayList<String> arrayList) {
        this.f61879f = arrayList;
    }

    public void b(boolean z) {
        this.f61881h = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f61879f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f61879f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ResourceAsColor"})
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f61878e).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
            bVar = new b();
            bVar.f61882a = (TextView) view.findViewById(R.id.home_lv_search_forum);
            bVar.f61883b = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Object item = getItem(i2);
        if (item == null) {
            return view;
        }
        String str = (String) item;
        if (this.f61881h) {
            bVar.f61882a.setText(str.concat(this.f61880g));
        } else {
            bVar.f61882a.setText(str);
        }
        SkinManager.setViewTextColor(bVar.f61882a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(bVar.f61883b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
