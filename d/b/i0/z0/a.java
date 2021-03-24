package d.b.i0.z0;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes4.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.b.b.j.e.a<T, V> {
    public FollowUserButton.a m;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void h0(FollowUserButton.a aVar) {
        this.m = aVar;
    }
}
