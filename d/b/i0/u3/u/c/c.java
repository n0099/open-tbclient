package d.b.i0.u3.u.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.b.i0.u3.v.e;
import d.b.i0.u3.v.f;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public View f61749c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalListView f61750d;

    /* renamed from: e  reason: collision with root package name */
    public f f61751e;

    public c(d.b.b.a.f fVar) {
        super(fVar);
    }

    @Override // d.b.i0.u3.u.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f61742a.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.f61749c = inflate;
        this.f61750d = (HorizontalListView) inflate.findViewById(R.id.horizontal_list);
        f fVar = new f();
        this.f61751e = fVar;
        this.f61750d.setAdapter((ListAdapter) fVar);
    }

    public View e() {
        return this.f61749c;
    }

    public void f() {
        this.f61751e.notifyDataSetChanged();
    }

    public void g(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f61751e.c(list);
        this.f61751e.notifyDataSetChanged();
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f61749c, R.color.CAM_X0201);
        f();
    }

    public void i(e eVar) {
        this.f61751e.d(eVar);
    }
}
