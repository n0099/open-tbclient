package d.a.k0.v3.t.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.a.k0.v3.u.e;
import d.a.k0.v3.u.f;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public View f62874c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalListView f62875d;

    /* renamed from: e  reason: collision with root package name */
    public f f62876e;

    public c(d.a.c.a.f fVar) {
        super(fVar);
    }

    @Override // d.a.k0.v3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f62867a.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.f62874c = inflate;
        this.f62875d = (HorizontalListView) inflate.findViewById(R.id.horizontal_list);
        f fVar = new f();
        this.f62876e = fVar;
        this.f62875d.setAdapter((ListAdapter) fVar);
    }

    public View e() {
        return this.f62874c;
    }

    public void f() {
        this.f62876e.notifyDataSetChanged();
    }

    public void g(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f62876e.c(list);
        this.f62876e.notifyDataSetChanged();
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f62874c, R.color.CAM_X0201);
        f();
    }

    public void j(e eVar) {
        this.f62876e.d(eVar);
    }
}
