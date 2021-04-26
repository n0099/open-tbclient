package d.a.j0.v3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62188a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b0.e f62189b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f62189b.H();
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f62188a = tbPageContext;
    }

    public void b() {
        d.a.j0.b0.e eVar = this.f62189b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        if (editorTools == null || (editorBar = editorTools.f13500e) == null || this.f62188a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f62189b == null) {
            d.a.j0.b0.e eVar = new d.a.j0.b0.e(this.f62188a, s);
            this.f62189b = eVar;
            eVar.c0(R.drawable.bg_tip_blue_down);
            this.f62189b.N(32);
            this.f62189b.K(2);
            this.f62189b.L(new a());
            int dimensionPixelSize = this.f62188a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f62188a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f62188a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f62189b.Y(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f62189b.f0(0);
            this.f62189b.g0(-dimensionPixelSize3);
            this.f62189b.M(3000);
        }
        this.f62189b.i0(this.f62188a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
