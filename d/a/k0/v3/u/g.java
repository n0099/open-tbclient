package d.a.k0.v3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62912a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.b0.e f62913b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f62913b.I();
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f62912a = tbPageContext;
    }

    public void b() {
        d.a.k0.b0.e eVar = this.f62913b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        if (editorTools == null || (editorBar = editorTools.f12836e) == null || this.f62912a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f62913b == null) {
            d.a.k0.b0.e eVar = new d.a.k0.b0.e(this.f62912a, s);
            this.f62913b = eVar;
            eVar.g0(R.drawable.bg_tip_blue_down);
            this.f62913b.O(32);
            this.f62913b.L(2);
            this.f62913b.M(new a());
            int dimensionPixelSize = this.f62912a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f62912a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f62912a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f62913b.Z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f62913b.j0(0);
            this.f62913b.k0(-dimensionPixelSize3);
            this.f62913b.N(3000);
        }
        this.f62913b.m0(this.f62912a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
