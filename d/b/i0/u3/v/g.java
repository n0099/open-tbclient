package d.b.i0.u3.v;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61784a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b0.e f61785b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f61785b.H();
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f61784a = tbPageContext;
    }

    public void b() {
        d.b.i0.b0.e eVar = this.f61785b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        if (editorTools == null || (editorBar = editorTools.f13843e) == null || this.f61784a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f61785b == null) {
            d.b.i0.b0.e eVar = new d.b.i0.b0.e(this.f61784a, s);
            this.f61785b = eVar;
            eVar.c0(R.drawable.bg_tip_blue_down);
            this.f61785b.N(32);
            this.f61785b.K(2);
            this.f61785b.L(new a());
            int dimensionPixelSize = this.f61784a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f61784a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f61784a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f61785b.Y(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f61785b.f0(0);
            this.f61785b.g0(-dimensionPixelSize3);
            this.f61785b.M(3000);
        }
        this.f61785b.i0(this.f61784a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
