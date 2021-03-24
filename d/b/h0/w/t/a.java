package d.b.h0.w.t;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class a extends m {
    public boolean q;
    public boolean r;

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.q = true;
        this.r = true;
        this.f51532d = R.drawable.icon_pure_post_link24;
        this.f51535g = false;
        this.f51536h = true;
        this.i = false;
        this.n = new int[]{21};
    }

    @Override // d.b.h0.w.m
    public boolean a() {
        return this.q;
    }

    @Override // d.b.h0.w.m
    public boolean d() {
        return this.r;
    }

    public void g(boolean z) {
        this.q = z;
    }

    public void h(boolean z) {
        this.r = z;
    }
}
