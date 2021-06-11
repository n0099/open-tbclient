package d.a.n0.b1;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tbadk.core.view.FollowUserButton;
/* loaded from: classes4.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.a.c.k.e.a<T, V> {
    public FollowUserButton.a m;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void e0(FollowUserButton.a aVar) {
        this.m = aVar;
    }
}
