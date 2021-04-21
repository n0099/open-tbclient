package d.b.j0.r1.h.b.c;

import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public GridView f61633a;

    public e(ViewGroup viewGroup) {
        this.f61633a = (GridView) viewGroup.findViewById(R.id.tail_edit_color_gridview);
    }

    public void a(a aVar) {
        this.f61633a.setAdapter((ListAdapter) aVar);
    }
}
