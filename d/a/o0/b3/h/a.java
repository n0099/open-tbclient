package d.a.o0.b3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.o0.b3.j.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d f55944e;

    /* renamed from: f  reason: collision with root package name */
    public int f55945f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1282a f55946g;

    /* renamed from: h  reason: collision with root package name */
    public Context f55947h;

    /* renamed from: d.a.o0.b3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1282a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f55948a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55949b;

        public C1282a(a aVar) {
        }
    }

    public a(Context context) {
        this.f55947h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f55947h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1282a c1282a = new C1282a(this);
        this.f55946g = c1282a;
        c1282a.f55948a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f55946g.f55949b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f55946g);
        return inflate;
    }

    public final void b(C1282a c1282a, d dVar, View view, int i2) {
        if (c1282a == null || dVar == null) {
            return;
        }
        c1282a.f55949b.setText("");
        if (i2 == 0) {
            TextView textView = c1282a.f55949b;
            textView.setText(this.f55947h.getString(R.string.all) + dVar.f55999b);
        } else {
            c1282a.f55949b.setText(dVar.f55999b);
        }
        if (i2 != this.f55945f) {
            c1282a.f55948a.setVisibility(4);
            SkinManager.setViewTextColor(c1282a.f55949b, R.color.common_color_10200, 1);
            return;
        }
        c1282a.f55948a.setVisibility(0);
        SkinManager.setViewTextColor(c1282a.f55949b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f55944e;
    }

    public void d(int i2) {
        this.f55945f = i2;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f55944e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f55944e;
        if (dVar == null || (arrayList = dVar.f56002e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<d> arrayList;
        d dVar = this.f55944e;
        if (dVar == null || (arrayList = dVar.f56002e) == null) {
            return null;
        }
        return arrayList.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a();
        }
        d dVar = this.f55944e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f56002e.get(i2);
        C1282a c1282a = (C1282a) view.getTag();
        this.f55946g = c1282a;
        if (dVar2 != null) {
            b(c1282a, dVar2, view, i2);
        }
        return view;
    }
}
