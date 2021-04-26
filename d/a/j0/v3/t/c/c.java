package d.a.j0.v3.t.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.a.j0.v3.u.e;
import d.a.j0.v3.u.f;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public View f62150c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalListView f62151d;

    /* renamed from: e  reason: collision with root package name */
    public f f62152e;

    public c(d.a.c.a.f fVar) {
        super(fVar);
    }

    @Override // d.a.j0.v3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f62143a.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.f62150c = inflate;
        this.f62151d = (HorizontalListView) inflate.findViewById(R.id.horizontal_list);
        f fVar = new f();
        this.f62152e = fVar;
        this.f62151d.setAdapter((ListAdapter) fVar);
    }

    public View e() {
        return this.f62150c;
    }

    public void f() {
        this.f62152e.notifyDataSetChanged();
    }

    public void g(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f62152e.c(list);
        this.f62152e.notifyDataSetChanged();
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f62150c, R.color.CAM_X0201);
        f();
    }

    public void j(e eVar) {
        this.f62152e.d(eVar);
    }
}
