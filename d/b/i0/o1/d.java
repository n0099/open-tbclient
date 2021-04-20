package d.b.i0.o1;

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
    public final Context f58796e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f58797f;

    /* renamed from: g  reason: collision with root package name */
    public final String f58798g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58799h = true;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58800a;

        /* renamed from: b  reason: collision with root package name */
        public View f58801b;

        public b(d dVar) {
        }
    }

    public d(Context context, ArrayList<String> arrayList) {
        this.f58796e = context;
        this.f58797f = arrayList;
        this.f58798g = context.getText(R.string.forum).toString();
    }

    public void a(ArrayList<String> arrayList) {
        this.f58797f = arrayList;
    }

    public void b(boolean z) {
        this.f58799h = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f58797f;
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
        return this.f58797f.get(i);
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
            view = LayoutInflater.from(this.f58796e).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
            bVar = new b();
            bVar.f58800a = (TextView) view.findViewById(R.id.home_lv_search_forum);
            bVar.f58801b = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Object item = getItem(i);
        if (item == null) {
            return view;
        }
        String str = (String) item;
        if (this.f58799h) {
            bVar.f58800a.setText(str.concat(this.f58798g));
        } else {
            bVar.f58800a.setText(str);
        }
        SkinManager.setViewTextColor(bVar.f58800a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(bVar.f58801b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
