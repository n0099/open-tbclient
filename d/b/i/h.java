package d.b.i;

import android.content.Context;
/* loaded from: classes2.dex */
public abstract class h extends a<d.b.h0.r.q.a> {
    public int j;
    public int k;

    public h(Context context) {
        super(context);
        this.j = 0;
        this.k = 0;
    }

    public int o() {
        return this.k;
    }

    public int p() {
        return this.j;
    }

    public void q(int i) {
        this.k = i;
    }

    public void r(int i) {
        this.j = i;
    }
}
