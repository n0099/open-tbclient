package d.b.j0.v3.u.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.b.j0.v3.v.e;
import d.b.j0.v3.v.f;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public View f63908c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalListView f63909d;

    /* renamed from: e  reason: collision with root package name */
    public f f63910e;

    public c(d.b.c.a.f fVar) {
        super(fVar);
    }

    @Override // d.b.j0.v3.u.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f63901a.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.f63908c = inflate;
        this.f63909d = (HorizontalListView) inflate.findViewById(R.id.horizontal_list);
        f fVar = new f();
        this.f63910e = fVar;
        this.f63909d.setAdapter((ListAdapter) fVar);
    }

    public View e() {
        return this.f63908c;
    }

    public void f() {
        this.f63910e.notifyDataSetChanged();
    }

    public void g(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f63910e.c(list);
        this.f63910e.notifyDataSetChanged();
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f63908c, R.color.CAM_X0201);
        f();
    }

    public void i(e eVar) {
        this.f63910e.d(eVar);
    }
}
