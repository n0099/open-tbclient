package d.a.o0.r0.k2;

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
import d.a.o0.r0.e1;
import d.a.o0.r0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.a.o0.r0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f62647a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1564e f62648b;

    /* renamed from: c  reason: collision with root package name */
    public Context f62649c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f62650d;

    /* renamed from: e  reason: collision with root package name */
    public e f62651e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f62652f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f62653g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i2) {
            if (f.this.f62650d == null) {
                return null;
            }
            return (e1) f.this.f62650d.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f62650d == null) {
                return 0;
            }
            return f.this.f62650d.size();
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
                fVar.f62643a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f62644b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f62645c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f62646d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i2);
            if (item == null) {
                return view;
            }
            fVar2.f62643a.setText(item.f62264a);
            if (item.f62266c) {
                SkinManager.setViewTextColor(fVar2.f62643a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f62644b, R.drawable.chx_tips_list_ok);
                fVar2.f62644b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f62643a, R.color.CAM_X0108, 1);
                fVar2.f62644b.setVisibility(8);
            }
            if (i2 >= 0 && i2 == getCount() - 1) {
                fVar2.f62646d.setVisibility(0);
                fVar2.f62645c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f62646d, R.color.CAM_X0204);
            } else {
                fVar2.f62645c.setVisibility(0);
                fVar2.f62646d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f62645c, R.color.CAM_X0204);
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
            if (f.this.f62651e != null) {
                f.this.f62651e.c();
            }
            if (f.this.f62652f == null || f.this.f62648b == null) {
                return;
            }
            for (e1 e1Var : f.this.f62650d) {
                if (e1Var != null) {
                    e1Var.f62266c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f62652f.getItem(i2);
            if (e1Var2 != null) {
                e1Var2.f62266c = true;
                f.this.f62648b.a(e1Var2.f62265b);
            }
        }
    }

    @Override // d.a.o0.r0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f62649c = context;
        this.f62651e = eVar;
        this.f62648b = eVar.d();
        g();
    }

    @Override // d.a.o0.r0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f62649c);
        this.f62647a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f62647a.setDivider(null);
        this.f62647a.setDividerHeight(0);
        this.f62647a.setSelector(17170445);
        this.f62647a.setCacheColorHint(this.f62649c.getResources().getColor(17170445));
        this.f62647a.setOnItemClickListener(this.f62653g);
        this.f62647a.setAdapter((ListAdapter) this.f62652f);
    }

    @Override // d.a.o0.r0.k2.a
    public View getView() {
        return this.f62647a;
    }

    @Override // d.a.o0.r0.k2.a
    public void setData(List<e1> list) {
        this.f62650d = list;
        this.f62652f.notifyDataSetChanged();
    }
}
