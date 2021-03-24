package d.b.i0.p0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.p0.e1;
import d.b.i0.p0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.b.i0.p0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f57755a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1392e f57756b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57757c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f57758d;

    /* renamed from: e  reason: collision with root package name */
    public e f57759e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f57760f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f57761g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i) {
            if (f.this.f57758d == null) {
                return null;
            }
            return (e1) f.this.f57758d.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f57758d == null) {
                return 0;
            }
            return f.this.f57758d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.f fVar = new e.f();
                fVar.f57751a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f57752b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f57753c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f57754d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i);
            if (item == null) {
                return view;
            }
            fVar2.f57751a.setText(item.f57401a);
            if (item.f57403c) {
                SkinManager.setViewTextColor(fVar2.f57751a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f57752b, R.drawable.chx_tips_list_ok);
                fVar2.f57752b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f57751a, R.color.CAM_X0108, 1);
                fVar2.f57752b.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                fVar2.f57754d.setVisibility(0);
                fVar2.f57753c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f57754d, R.color.CAM_X0204);
            } else {
                fVar2.f57753c.setVisibility(0);
                fVar2.f57754d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f57753c, R.color.CAM_X0204);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (f.this.f57759e != null) {
                f.this.f57759e.c();
            }
            if (f.this.f57760f == null || f.this.f57756b == null) {
                return;
            }
            for (e1 e1Var : f.this.f57758d) {
                if (e1Var != null) {
                    e1Var.f57403c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f57760f.getItem(i);
            if (e1Var2 != null) {
                e1Var2.f57403c = true;
                f.this.f57756b.a(e1Var2.f57402b);
            }
        }
    }

    @Override // d.b.i0.p0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f57757c = context;
        this.f57759e = eVar;
        this.f57756b = eVar.d();
        g();
    }

    @Override // d.b.i0.p0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f57757c);
        this.f57755a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f57755a.setDivider(null);
        this.f57755a.setDividerHeight(0);
        this.f57755a.setSelector(17170445);
        this.f57755a.setCacheColorHint(this.f57757c.getResources().getColor(17170445));
        this.f57755a.setOnItemClickListener(this.f57761g);
        this.f57755a.setAdapter((ListAdapter) this.f57760f);
    }

    @Override // d.b.i0.p0.k2.a
    public View getView() {
        return this.f57755a;
    }

    @Override // d.b.i0.p0.k2.a
    public void setData(List<e1> list) {
        this.f57758d = list;
        this.f57760f.notifyDataSetChanged();
    }
}
