package d.a.n0.w3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63021a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.d0.e f63022b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f63022b.I();
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f63021a = tbPageContext;
    }

    public void b() {
        d.a.n0.d0.e eVar = this.f63022b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        if (editorTools == null || (editorBar = editorTools.f12744e) == null || this.f63021a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f63022b == null) {
            d.a.n0.d0.e eVar = new d.a.n0.d0.e(this.f63021a, s);
            this.f63022b = eVar;
            eVar.g0(R.drawable.bg_tip_blue_down);
            this.f63022b.O(32);
            this.f63022b.L(2);
            this.f63022b.M(new a());
            int dimensionPixelSize = this.f63021a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f63021a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f63021a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f63022b.Z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f63022b.j0(0);
            this.f63022b.k0(-dimensionPixelSize3);
            this.f63022b.N(3000);
        }
        this.f63022b.m0(this.f63021a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
