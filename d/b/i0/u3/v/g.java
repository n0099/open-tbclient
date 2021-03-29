package d.b.i0.u3.v;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61785a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b0.e f61786b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f61786b.H();
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f61785a = tbPageContext;
    }

    public void b() {
        d.b.i0.b0.e eVar = this.f61786b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        if (editorTools == null || (editorBar = editorTools.f13844e) == null || this.f61785a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f61786b == null) {
            d.b.i0.b0.e eVar = new d.b.i0.b0.e(this.f61785a, s);
            this.f61786b = eVar;
            eVar.c0(R.drawable.bg_tip_blue_down);
            this.f61786b.N(32);
            this.f61786b.K(2);
            this.f61786b.L(new a());
            int dimensionPixelSize = this.f61785a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f61785a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f61785a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f61786b.Y(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f61786b.f0(0);
            this.f61786b.g0(-dimensionPixelSize3);
            this.f61786b.M(3000);
        }
        this.f61786b.i0(this.f61785a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
