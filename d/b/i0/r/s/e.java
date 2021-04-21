package d.b.i0.r.s;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f51731a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f51732b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f51733c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f51734d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f51735e;

    /* renamed from: f  reason: collision with root package name */
    public m f51736f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51737g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f51738h;
    public AlertDialog j;
    public boolean i = false;
    public AdapterView.OnItemClickListener k = new a();

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (e.this.f51733c != null) {
                e.this.f51733c.onItemClick(adapterView, view, i, j);
            }
            e.this.f();
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f51738h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f51734d = viewGroup;
        this.f51737g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f51735e = (BdListView) this.f51734d.findViewById(R.id.dialog_content_list);
        this.f51736f = new m(this.f51738h);
    }

    public void b(d.b.c.a.f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.f51734d);
        }
        this.f51734d.setBackgroundResource(R.drawable.transparent_bg);
    }

    public e c() {
        if (this.i) {
            return this;
        }
        this.i = true;
        if (!TextUtils.isEmpty(this.f51731a)) {
            this.f51737g.setText(this.f51731a);
            this.f51737g.setVisibility(0);
        } else {
            this.f51737g.setVisibility(8);
        }
        this.f51735e.setAdapter((ListAdapter) this.f51736f);
        this.f51736f.c(this.f51732b);
        b(this.f51738h);
        return this;
    }

    public void d() {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            d.b.c.e.m.g.a(alertDialog, this.f51738h.getPageActivity());
        }
    }

    public View e() {
        return this.f51734d;
    }

    public void f() {
        d();
    }

    public void g() {
        b(this.f51738h);
        m mVar = this.f51736f;
        if (mVar != null) {
            mVar.notifyDataSetChanged();
        }
    }

    public void h(int i) {
        for (int i2 = 0; i2 < this.f51732b.size(); i2++) {
            if (i2 == i) {
                this.f51732b.get(i2).e(true);
            } else {
                this.f51732b.get(i2).e(false);
            }
        }
        this.f51736f.c(this.f51732b);
    }

    public void i(boolean z) {
        this.f51736f.b(z);
    }

    public void j(int i) {
        for (int i2 = 0; i2 < this.f51732b.size(); i2++) {
            if (i2 == i) {
                n nVar = this.f51732b.get(i2);
                nVar.e(!nVar.d());
            }
        }
        this.f51736f.c(this.f51732b);
    }

    public e k(ArrayList<n> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f51732b = arrayList;
            if (onItemClickListener != null) {
                this.f51733c = onItemClickListener;
                this.f51735e.setOnItemClickListener(this.k);
            }
        }
        return this;
    }

    public e l(int i) {
        m(this.f51738h.getResources().getString(i));
        return this;
    }

    public e m(String str) {
        this.f51731a = str;
        return this;
    }

    public e n() {
        if (this.i) {
            AlertDialog alertDialog = this.j;
            if (alertDialog != null) {
                d.b.c.e.m.g.j(alertDialog, this.f51738h);
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f51738h.getPageActivity()).create();
            this.j = create;
            create.setCanceledOnTouchOutside(true);
            if (d.b.c.e.m.g.i(this.j, this.f51738h.getPageActivity())) {
                Window window = this.j.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.f51734d);
                return this;
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
