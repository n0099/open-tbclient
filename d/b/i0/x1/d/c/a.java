package d.b.i0.x1.d.c;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes3.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.b.c.j.e.a<T, V> {
    public boolean m;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public boolean h0() {
        return this.m;
    }

    public void i0(boolean z) {
        this.m = z;
    }
}
