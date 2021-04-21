package d.b.j0.v3.v;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63944a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.b0.e f63945b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f63945b.H();
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f63944a = tbPageContext;
    }

    public void b() {
        d.b.j0.b0.e eVar = this.f63945b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        if (editorTools == null || (editorBar = editorTools.f13513e) == null || this.f63944a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f63945b == null) {
            d.b.j0.b0.e eVar = new d.b.j0.b0.e(this.f63944a, s);
            this.f63945b = eVar;
            eVar.c0(R.drawable.bg_tip_blue_down);
            this.f63945b.N(32);
            this.f63945b.K(2);
            this.f63945b.L(new a());
            int dimensionPixelSize = this.f63944a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f63944a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f63944a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f63945b.Y(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f63945b.f0(0);
            this.f63945b.g0(-dimensionPixelSize3);
            this.f63945b.M(3000);
        }
        this.f63945b.i0(this.f63944a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
