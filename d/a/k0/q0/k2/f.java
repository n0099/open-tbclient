package d.a.k0.q0.k2;

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
import d.a.k0.q0.e1;
import d.a.k0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.a.k0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f58690a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1491e f58691b;

    /* renamed from: c  reason: collision with root package name */
    public Context f58692c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f58693d;

    /* renamed from: e  reason: collision with root package name */
    public e f58694e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f58695f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f58696g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i2) {
            if (f.this.f58693d == null) {
                return null;
            }
            return (e1) f.this.f58693d.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f58693d == null) {
                return 0;
            }
            return f.this.f58693d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.f fVar = new e.f();
                fVar.f58686a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f58687b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f58688c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f58689d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i2);
            if (item == null) {
                return view;
            }
            fVar2.f58686a.setText(item.f58307a);
            if (item.f58309c) {
                SkinManager.setViewTextColor(fVar2.f58686a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f58687b, R.drawable.chx_tips_list_ok);
                fVar2.f58687b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f58686a, R.color.CAM_X0108, 1);
                fVar2.f58687b.setVisibility(8);
            }
            if (i2 >= 0 && i2 == getCount() - 1) {
                fVar2.f58689d.setVisibility(0);
                fVar2.f58688c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f58689d, R.color.CAM_X0204);
            } else {
                fVar2.f58688c.setVisibility(0);
                fVar2.f58689d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f58688c, R.color.CAM_X0204);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (f.this.f58694e != null) {
                f.this.f58694e.c();
            }
            if (f.this.f58695f == null || f.this.f58691b == null) {
                return;
            }
            for (e1 e1Var : f.this.f58693d) {
                if (e1Var != null) {
                    e1Var.f58309c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f58695f.getItem(i2);
            if (e1Var2 != null) {
                e1Var2.f58309c = true;
                f.this.f58691b.a(e1Var2.f58308b);
            }
        }
    }

    @Override // d.a.k0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f58692c = context;
        this.f58694e = eVar;
        this.f58691b = eVar.d();
        g();
    }

    @Override // d.a.k0.q0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f58692c);
        this.f58690a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f58690a.setDivider(null);
        this.f58690a.setDividerHeight(0);
        this.f58690a.setSelector(17170445);
        this.f58690a.setCacheColorHint(this.f58692c.getResources().getColor(17170445));
        this.f58690a.setOnItemClickListener(this.f58696g);
        this.f58690a.setAdapter((ListAdapter) this.f58695f);
    }

    @Override // d.a.k0.q0.k2.a
    public View getView() {
        return this.f58690a;
    }

    @Override // d.a.k0.q0.k2.a
    public void setData(List<e1> list) {
        this.f58693d = list;
        this.f58695f.notifyDataSetChanged();
    }
}
