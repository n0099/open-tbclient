package d.b.i0.q0.k2;

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
import d.b.i0.q0.e1;
import d.b.i0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.b.i0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f59455a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1455e f59456b;

    /* renamed from: c  reason: collision with root package name */
    public Context f59457c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f59458d;

    /* renamed from: e  reason: collision with root package name */
    public e f59459e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f59460f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f59461g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i) {
            if (f.this.f59458d == null) {
                return null;
            }
            return (e1) f.this.f59458d.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f59458d == null) {
                return 0;
            }
            return f.this.f59458d.size();
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
                fVar.f59451a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f59452b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f59453c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f59454d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i);
            if (item == null) {
                return view;
            }
            fVar2.f59451a.setText(item.f59101a);
            if (item.f59103c) {
                SkinManager.setViewTextColor(fVar2.f59451a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f59452b, R.drawable.chx_tips_list_ok);
                fVar2.f59452b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f59451a, R.color.CAM_X0108, 1);
                fVar2.f59452b.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                fVar2.f59454d.setVisibility(0);
                fVar2.f59453c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f59454d, R.color.CAM_X0204);
            } else {
                fVar2.f59453c.setVisibility(0);
                fVar2.f59454d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f59453c, R.color.CAM_X0204);
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
            if (f.this.f59459e != null) {
                f.this.f59459e.c();
            }
            if (f.this.f59460f == null || f.this.f59456b == null) {
                return;
            }
            for (e1 e1Var : f.this.f59458d) {
                if (e1Var != null) {
                    e1Var.f59103c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f59460f.getItem(i);
            if (e1Var2 != null) {
                e1Var2.f59103c = true;
                f.this.f59456b.a(e1Var2.f59102b);
            }
        }
    }

    @Override // d.b.i0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f59457c = context;
        this.f59459e = eVar;
        this.f59456b = eVar.d();
        g();
    }

    @Override // d.b.i0.q0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f59457c);
        this.f59455a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f59455a.setDivider(null);
        this.f59455a.setDividerHeight(0);
        this.f59455a.setSelector(17170445);
        this.f59455a.setCacheColorHint(this.f59457c.getResources().getColor(17170445));
        this.f59455a.setOnItemClickListener(this.f59461g);
        this.f59455a.setAdapter((ListAdapter) this.f59460f);
    }

    @Override // d.b.i0.q0.k2.a
    public View getView() {
        return this.f59455a;
    }

    @Override // d.b.i0.q0.k2.a
    public void setData(List<e1> list) {
        this.f59458d = list;
        this.f59460f.notifyDataSetChanged();
    }
}
