package d.b.j0.q0.k2;

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
import d.b.j0.q0.e1;
import d.b.j0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.b.j0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f59876a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1478e f59877b;

    /* renamed from: c  reason: collision with root package name */
    public Context f59878c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f59879d;

    /* renamed from: e  reason: collision with root package name */
    public e f59880e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f59881f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f59882g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i) {
            if (f.this.f59879d == null) {
                return null;
            }
            return (e1) f.this.f59879d.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f59879d == null) {
                return 0;
            }
            return f.this.f59879d.size();
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
                fVar.f59872a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f59873b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f59874c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f59875d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i);
            if (item == null) {
                return view;
            }
            fVar2.f59872a.setText(item.f59522a);
            if (item.f59524c) {
                SkinManager.setViewTextColor(fVar2.f59872a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f59873b, R.drawable.chx_tips_list_ok);
                fVar2.f59873b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f59872a, R.color.CAM_X0108, 1);
                fVar2.f59873b.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                fVar2.f59875d.setVisibility(0);
                fVar2.f59874c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f59875d, R.color.CAM_X0204);
            } else {
                fVar2.f59874c.setVisibility(0);
                fVar2.f59875d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f59874c, R.color.CAM_X0204);
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
            if (f.this.f59880e != null) {
                f.this.f59880e.c();
            }
            if (f.this.f59881f == null || f.this.f59877b == null) {
                return;
            }
            for (e1 e1Var : f.this.f59879d) {
                if (e1Var != null) {
                    e1Var.f59524c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f59881f.getItem(i);
            if (e1Var2 != null) {
                e1Var2.f59524c = true;
                f.this.f59877b.a(e1Var2.f59523b);
            }
        }
    }

    @Override // d.b.j0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f59878c = context;
        this.f59880e = eVar;
        this.f59877b = eVar.d();
        g();
    }

    @Override // d.b.j0.q0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f59878c);
        this.f59876a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f59876a.setDivider(null);
        this.f59876a.setDividerHeight(0);
        this.f59876a.setSelector(17170445);
        this.f59876a.setCacheColorHint(this.f59878c.getResources().getColor(17170445));
        this.f59876a.setOnItemClickListener(this.f59882g);
        this.f59876a.setAdapter((ListAdapter) this.f59881f);
    }

    @Override // d.b.j0.q0.k2.a
    public View getView() {
        return this.f59876a;
    }

    @Override // d.b.j0.q0.k2.a
    public void setData(List<e1> list) {
        this.f59879d = list;
        this.f59881f.notifyDataSetChanged();
    }
}
