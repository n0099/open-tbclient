package d.b.j0.j1.o.g;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.j0.j1.f;
/* loaded from: classes4.dex */
public abstract class a<T extends TypeAdapter.ViewHolder> extends d.b.c.j.e.a<ICardInfo, T> implements f {
    public int m;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void h0(int i) {
        this.m = i;
    }
}
