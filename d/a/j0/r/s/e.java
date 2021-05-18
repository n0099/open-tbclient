package d.a.j0.r.s;

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
    public String f50191a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f50192b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f50193c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f50194d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f50195e;

    /* renamed from: f  reason: collision with root package name */
    public m f50196f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50197g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f50198h;
    public AlertDialog j;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50199i = false;
    public AdapterView.OnItemClickListener k = new a();

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (e.this.f50193c != null) {
                e.this.f50193c.onItemClick(adapterView, view, i2, j);
            }
            e.this.f();
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f50198h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f50194d = viewGroup;
        this.f50197g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f50195e = (BdListView) this.f50194d.findViewById(R.id.dialog_content_list);
        this.f50196f = new m(this.f50198h);
    }

    public void b(d.a.c.a.f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.f50194d);
        }
        this.f50194d.setBackgroundResource(R.drawable.transparent_bg);
    }

    public e c() {
        if (this.f50199i) {
            return this;
        }
        this.f50199i = true;
        if (!TextUtils.isEmpty(this.f50191a)) {
            this.f50197g.setText(this.f50191a);
            this.f50197g.setVisibility(0);
        } else {
            this.f50197g.setVisibility(8);
        }
        this.f50195e.setAdapter((ListAdapter) this.f50196f);
        this.f50196f.c(this.f50192b);
        b(this.f50198h);
        return this;
    }

    public void d() {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f50198h.getPageActivity());
        }
    }

    public View e() {
        return this.f50194d;
    }

    public void f() {
        d();
    }

    public void g() {
        b(this.f50198h);
        m mVar = this.f50196f;
        if (mVar != null) {
            mVar.notifyDataSetChanged();
        }
    }

    public void h(int i2) {
        for (int i3 = 0; i3 < this.f50192b.size(); i3++) {
            if (i3 == i2) {
                this.f50192b.get(i3).e(true);
            } else {
                this.f50192b.get(i3).e(false);
            }
        }
        this.f50196f.c(this.f50192b);
    }

    public void i(boolean z) {
        this.f50196f.b(z);
    }

    public void j(int i2) {
        for (int i3 = 0; i3 < this.f50192b.size(); i3++) {
            if (i3 == i2) {
                n nVar = this.f50192b.get(i3);
                nVar.e(!nVar.d());
            }
        }
        this.f50196f.c(this.f50192b);
    }

    public e k(ArrayList<n> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f50192b = arrayList;
            if (onItemClickListener != null) {
                this.f50193c = onItemClickListener;
                this.f50195e.setOnItemClickListener(this.k);
            }
        }
        return this;
    }

    public e l(int i2) {
        m(this.f50198h.getResources().getString(i2));
        return this;
    }

    public e m(String str) {
        this.f50191a = str;
        return this;
    }

    public e n() {
        if (this.f50199i) {
            AlertDialog alertDialog = this.j;
            if (alertDialog != null) {
                d.a.c.e.m.g.j(alertDialog, this.f50198h);
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f50198h.getPageActivity()).create();
            this.j = create;
            create.setCanceledOnTouchOutside(true);
            if (d.a.c.e.m.g.i(this.j, this.f50198h.getPageActivity())) {
                Window window = this.j.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.f50194d);
                return this;
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
