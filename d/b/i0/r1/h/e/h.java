package d.b.i0.r1.h.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f61287a;

    public h(ViewGroup viewGroup) {
        this.f61287a = (BdListView) viewGroup.findViewById(R.id.tail_tool_listview);
        View view = new View(viewGroup.getContext());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) viewGroup.getContext().getResources().getDimension(R.dimen.ds30)));
        this.f61287a.addHeaderView(view);
    }

    public void a(b bVar) {
        this.f61287a.setAdapter((ListAdapter) bVar);
    }
}
