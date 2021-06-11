package d.a.n0.r0.k2;

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
import d.a.n0.r0.e1;
import d.a.n0.r0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.a.n0.r0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f62522a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1560e f62523b;

    /* renamed from: c  reason: collision with root package name */
    public Context f62524c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f62525d;

    /* renamed from: e  reason: collision with root package name */
    public e f62526e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f62527f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f62528g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i2) {
            if (f.this.f62525d == null) {
                return null;
            }
            return (e1) f.this.f62525d.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f62525d == null) {
                return 0;
            }
            return f.this.f62525d.size();
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
                fVar.f62518a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f62519b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f62520c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f62521d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i2);
            if (item == null) {
                return view;
            }
            fVar2.f62518a.setText(item.f62139a);
            if (item.f62141c) {
                SkinManager.setViewTextColor(fVar2.f62518a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f62519b, R.drawable.chx_tips_list_ok);
                fVar2.f62519b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f62518a, R.color.CAM_X0108, 1);
                fVar2.f62519b.setVisibility(8);
            }
            if (i2 >= 0 && i2 == getCount() - 1) {
                fVar2.f62521d.setVisibility(0);
                fVar2.f62520c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f62521d, R.color.CAM_X0204);
            } else {
                fVar2.f62520c.setVisibility(0);
                fVar2.f62521d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f62520c, R.color.CAM_X0204);
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
            if (f.this.f62526e != null) {
                f.this.f62526e.c();
            }
            if (f.this.f62527f == null || f.this.f62523b == null) {
                return;
            }
            for (e1 e1Var : f.this.f62525d) {
                if (e1Var != null) {
                    e1Var.f62141c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f62527f.getItem(i2);
            if (e1Var2 != null) {
                e1Var2.f62141c = true;
                f.this.f62523b.a(e1Var2.f62140b);
            }
        }
    }

    @Override // d.a.n0.r0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f62524c = context;
        this.f62526e = eVar;
        this.f62523b = eVar.d();
        g();
    }

    @Override // d.a.n0.r0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f62524c);
        this.f62522a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f62522a.setDivider(null);
        this.f62522a.setDividerHeight(0);
        this.f62522a.setSelector(17170445);
        this.f62522a.setCacheColorHint(this.f62524c.getResources().getColor(17170445));
        this.f62522a.setOnItemClickListener(this.f62528g);
        this.f62522a.setAdapter((ListAdapter) this.f62527f);
    }

    @Override // d.a.n0.r0.k2.a
    public View getView() {
        return this.f62522a;
    }

    @Override // d.a.n0.r0.k2.a
    public void setData(List<e1> list) {
        this.f62525d = list;
        this.f62527f.notifyDataSetChanged();
    }
}
