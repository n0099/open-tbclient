package d.a.o0.y1.d.c;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes5.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.a.c.k.e.a<T, V> {
    public boolean m;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public boolean e0() {
        return this.m;
    }

    public void g0(boolean z) {
        this.m = z;
    }
}
