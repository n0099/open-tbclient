package d.a.k0.n1.d;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.location.editortool.PbLocationInfoContainer;
import d.a.c.e.p.l;
import d.a.j0.w.m;
/* loaded from: classes3.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 8);
        this.m = false;
        this.l = 3;
        this.k = new PbLocationInfoContainer(context);
        this.n = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.m = false;
        this.l = 3;
        this.k = new PbLocationInfoContainer(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.g(b(), R.dimen.ds48));
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = l.g(b(), R.dimen.ds32);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = l.g(b(), R.dimen.ds32);
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = l.g(b(), R.dimen.ds21);
        ((LinearLayout.LayoutParams) layoutParams).topMargin = l.g(b(), R.dimen.ds21);
        ((PbLocationInfoContainer) this.k).setLayoutParams(layoutParams);
        this.n = new int[]{20, 19};
    }
}
