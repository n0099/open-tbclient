package d.b.i0.i1.o.g;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.i0.i1.f;
/* loaded from: classes3.dex */
public abstract class a<T extends TypeAdapter.ViewHolder> extends d.b.b.j.e.a<ICardInfo, T> implements f {
    public int m;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void h0(int i) {
        this.m = i;
    }
}
