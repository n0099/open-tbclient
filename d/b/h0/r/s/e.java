package d.b.h0.r.s;

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
    public String f50988a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f50989b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f50990c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f50991d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f50992e;

    /* renamed from: f  reason: collision with root package name */
    public m f50993f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50994g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f50995h;
    public AlertDialog j;
    public boolean i = false;
    public AdapterView.OnItemClickListener k = new a();

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (e.this.f50990c != null) {
                e.this.f50990c.onItemClick(adapterView, view, i, j);
            }
            e.this.f();
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f50995h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f50991d = viewGroup;
        this.f50994g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f50992e = (BdListView) this.f50991d.findViewById(R.id.dialog_content_list);
        this.f50993f = new m(this.f50995h);
    }

    public void b(d.b.b.a.f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.f50991d);
        }
        this.f50991d.setBackgroundResource(R.drawable.transparent_bg);
    }

    public e c() {
        if (this.i) {
            return this;
        }
        this.i = true;
        if (!TextUtils.isEmpty(this.f50988a)) {
            this.f50994g.setText(this.f50988a);
            this.f50994g.setVisibility(0);
        } else {
            this.f50994g.setVisibility(8);
        }
        this.f50992e.setAdapter((ListAdapter) this.f50993f);
        this.f50993f.c(this.f50989b);
        b(this.f50995h);
        return this;
    }

    public void d() {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            d.b.b.e.m.g.a(alertDialog, this.f50995h.getPageActivity());
        }
    }

    public View e() {
        return this.f50991d;
    }

    public void f() {
        d();
    }

    public void g() {
        b(this.f50995h);
        m mVar = this.f50993f;
        if (mVar != null) {
            mVar.notifyDataSetChanged();
        }
    }

    public void h(int i) {
        for (int i2 = 0; i2 < this.f50989b.size(); i2++) {
            if (i2 == i) {
                this.f50989b.get(i2).e(true);
            } else {
                this.f50989b.get(i2).e(false);
            }
        }
        this.f50993f.c(this.f50989b);
    }

    public void i(boolean z) {
        this.f50993f.b(z);
    }

    public void j(int i) {
        for (int i2 = 0; i2 < this.f50989b.size(); i2++) {
            if (i2 == i) {
                n nVar = this.f50989b.get(i2);
                nVar.e(!nVar.d());
            }
        }
        this.f50993f.c(this.f50989b);
    }

    public e k(ArrayList<n> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f50989b = arrayList;
            if (onItemClickListener != null) {
                this.f50990c = onItemClickListener;
                this.f50992e.setOnItemClickListener(this.k);
            }
        }
        return this;
    }

    public e l(int i) {
        m(this.f50995h.getResources().getString(i));
        return this;
    }

    public e m(String str) {
        this.f50988a = str;
        return this;
    }

    public e n() {
        if (this.i) {
            AlertDialog alertDialog = this.j;
            if (alertDialog != null) {
                d.b.b.e.m.g.j(alertDialog, this.f50995h);
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f50995h.getPageActivity()).create();
            this.j = create;
            create.setCanceledOnTouchOutside(true);
            if (d.b.b.e.m.g.i(this.j, this.f50995h.getPageActivity())) {
                Window window = this.j.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.f50991d);
                return this;
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
