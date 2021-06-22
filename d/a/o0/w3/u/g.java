package d.a.o0.w3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66861a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.d0.e f66862b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f66862b.I();
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f66861a = tbPageContext;
    }

    public void b() {
        d.a.o0.d0.e eVar = this.f66862b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        if (editorTools == null || (editorBar = editorTools.f12891e) == null || this.f66861a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f66862b == null) {
            d.a.o0.d0.e eVar = new d.a.o0.d0.e(this.f66861a, s);
            this.f66862b = eVar;
            eVar.g0(R.drawable.bg_tip_blue_down);
            this.f66862b.O(32);
            this.f66862b.L(2);
            this.f66862b.M(new a());
            int dimensionPixelSize = this.f66861a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f66861a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f66861a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f66862b.Z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f66862b.j0(0);
            this.f66862b.k0(-dimensionPixelSize3);
            this.f66862b.N(3000);
        }
        this.f66862b.m0(this.f66861a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
