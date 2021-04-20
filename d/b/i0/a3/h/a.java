package d.b.i0.a3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.a3.j.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d f53110e;

    /* renamed from: f  reason: collision with root package name */
    public int f53111f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1171a f53112g;

    /* renamed from: h  reason: collision with root package name */
    public Context f53113h;

    /* renamed from: d.b.i0.a3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1171a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f53114a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53115b;

        public C1171a(a aVar) {
        }
    }

    public a(Context context) {
        this.f53113h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f53113h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1171a c1171a = new C1171a(this);
        this.f53112g = c1171a;
        c1171a.f53114a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f53112g.f53115b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f53112g);
        return inflate;
    }

    public final void b(C1171a c1171a, d dVar, View view, int i) {
        if (c1171a == null || dVar == null) {
            return;
        }
        c1171a.f53115b.setText("");
        if (i == 0) {
            TextView textView = c1171a.f53115b;
            textView.setText(this.f53113h.getString(R.string.all) + dVar.f53162b);
        } else {
            c1171a.f53115b.setText(dVar.f53162b);
        }
        if (i != this.f53111f) {
            c1171a.f53114a.setVisibility(4);
            SkinManager.setViewTextColor(c1171a.f53115b, R.color.common_color_10200, 1);
            return;
        }
        c1171a.f53114a.setVisibility(0);
        SkinManager.setViewTextColor(c1171a.f53115b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f53110e;
    }

    public void d(int i) {
        this.f53111f = i;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f53110e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f53110e;
        if (dVar == null || (arrayList = dVar.f53165e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<d> arrayList;
        d dVar = this.f53110e;
        if (dVar == null || (arrayList = dVar.f53165e) == null) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a();
        }
        d dVar = this.f53110e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f53165e.get(i);
        C1171a c1171a = (C1171a) view.getTag();
        this.f53112g = c1171a;
        if (dVar2 != null) {
            b(c1171a, dVar2, view, i);
        }
        return view;
    }
}
