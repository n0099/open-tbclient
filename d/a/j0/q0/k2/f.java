package d.a.j0.q0.k2;

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
import d.a.j0.q0.e1;
import d.a.j0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.a.j0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f57948a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1417e f57949b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57950c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f57951d;

    /* renamed from: e  reason: collision with root package name */
    public e f57952e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f57953f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f57954g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i2) {
            if (f.this.f57951d == null) {
                return null;
            }
            return (e1) f.this.f57951d.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f57951d == null) {
                return 0;
            }
            return f.this.f57951d.size();
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
                fVar.f57944a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f57945b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f57946c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f57947d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i2);
            if (item == null) {
                return view;
            }
            fVar2.f57944a.setText(item.f57565a);
            if (item.f57567c) {
                SkinManager.setViewTextColor(fVar2.f57944a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f57945b, R.drawable.chx_tips_list_ok);
                fVar2.f57945b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f57944a, R.color.CAM_X0108, 1);
                fVar2.f57945b.setVisibility(8);
            }
            if (i2 >= 0 && i2 == getCount() - 1) {
                fVar2.f57947d.setVisibility(0);
                fVar2.f57946c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f57947d, R.color.CAM_X0204);
            } else {
                fVar2.f57946c.setVisibility(0);
                fVar2.f57947d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f57946c, R.color.CAM_X0204);
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
            if (f.this.f57952e != null) {
                f.this.f57952e.c();
            }
            if (f.this.f57953f == null || f.this.f57949b == null) {
                return;
            }
            for (e1 e1Var : f.this.f57951d) {
                if (e1Var != null) {
                    e1Var.f57567c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f57953f.getItem(i2);
            if (e1Var2 != null) {
                e1Var2.f57567c = true;
                f.this.f57949b.a(e1Var2.f57566b);
            }
        }
    }

    @Override // d.a.j0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f57950c = context;
        this.f57952e = eVar;
        this.f57949b = eVar.d();
        g();
    }

    @Override // d.a.j0.q0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f57950c);
        this.f57948a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f57948a.setDivider(null);
        this.f57948a.setDividerHeight(0);
        this.f57948a.setSelector(17170445);
        this.f57948a.setCacheColorHint(this.f57950c.getResources().getColor(17170445));
        this.f57948a.setOnItemClickListener(this.f57954g);
        this.f57948a.setAdapter((ListAdapter) this.f57953f);
    }

    @Override // d.a.j0.q0.k2.a
    public View getView() {
        return this.f57948a;
    }

    @Override // d.a.j0.q0.k2.a
    public void setData(List<e1> list) {
        this.f57951d = list;
        this.f57953f.notifyDataSetChanged();
    }
}
