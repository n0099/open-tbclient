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
    public BdListView f58831a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1504e f58832b;

    /* renamed from: c  reason: collision with root package name */
    public Context f58833c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f58834d;

    /* renamed from: e  reason: collision with root package name */
    public e f58835e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f58836f = new a();

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f58837g = new b();

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i2) {
            if (f.this.f58834d == null) {
                return null;
            }
            return (e1) f.this.f58834d.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.f58834d == null) {
                return 0;
            }
            return f.this.f58834d.size();
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
                fVar.f58827a = (TextView) view.findViewById(R.id.tab_menu_name);
                fVar.f58828b = (ImageView) view.findViewById(R.id.tab_menu_check);
                fVar.f58829c = view.findViewById(R.id.tab_menu_line_s);
                fVar.f58830d = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(fVar);
            }
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            e.f fVar2 = (e.f) view.getTag();
            e1 item = getItem(i2);
            if (item == null) {
                return view;
            }
            fVar2.f58827a.setText(item.f58448a);
            if (item.f58450c) {
                SkinManager.setViewTextColor(fVar2.f58827a, R.color.CAM_X0302, 1);
                SkinManager.setImageResource(fVar2.f58828b, R.drawable.chx_tips_list_ok);
                fVar2.f58828b.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(fVar2.f58827a, R.color.CAM_X0108, 1);
                fVar2.f58828b.setVisibility(8);
            }
            if (i2 >= 0 && i2 == getCount() - 1) {
                fVar2.f58830d.setVisibility(0);
                fVar2.f58829c.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f58830d, R.color.CAM_X0204);
            } else {
                fVar2.f58829c.setVisibility(0);
                fVar2.f58830d.setVisibility(8);
                SkinManager.setBackgroundColor(fVar2.f58829c, R.color.CAM_X0204);
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
            if (f.this.f58835e != null) {
                f.this.f58835e.c();
            }
            if (f.this.f58836f == null || f.this.f58832b == null) {
                return;
            }
            for (e1 e1Var : f.this.f58834d) {
                if (e1Var != null) {
                    e1Var.f58450c = false;
                }
            }
            e1 e1Var2 = (e1) f.this.f58836f.getItem(i2);
            if (e1Var2 != null) {
                e1Var2.f58450c = true;
                f.this.f58832b.a(e1Var2.f58449b);
            }
        }
    }

    @Override // d.a.n0.r0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f58833c = context;
        this.f58835e = eVar;
        this.f58832b = eVar.d();
        g();
    }

    @Override // d.a.n0.r0.k2.a
    public int b() {
        return 0;
    }

    public final void g() {
        BdListView bdListView = new BdListView(this.f58833c);
        this.f58831a = bdListView;
        bdListView.setAlwaysDrawnWithCacheEnabled(false);
        this.f58831a.setDivider(null);
        this.f58831a.setDividerHeight(0);
        this.f58831a.setSelector(17170445);
        this.f58831a.setCacheColorHint(this.f58833c.getResources().getColor(17170445));
        this.f58831a.setOnItemClickListener(this.f58837g);
        this.f58831a.setAdapter((ListAdapter) this.f58836f);
    }

    @Override // d.a.n0.r0.k2.a
    public View getView() {
        return this.f58831a;
    }

    @Override // d.a.n0.r0.k2.a
    public void setData(List<e1> list) {
        this.f58834d = list;
        this.f58836f.notifyDataSetChanged();
    }
}
