package d.a.n0.w3.t.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.a.n0.w3.u.e;
import d.a.n0.w3.u.f;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public View f66698c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalListView f66699d;

    /* renamed from: e  reason: collision with root package name */
    public f f66700e;

    public c(d.a.c.a.f fVar) {
        super(fVar);
    }

    @Override // d.a.n0.w3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f66691a.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.f66698c = inflate;
        this.f66699d = (HorizontalListView) inflate.findViewById(R.id.horizontal_list);
        f fVar = new f();
        this.f66700e = fVar;
        this.f66699d.setAdapter((ListAdapter) fVar);
    }

    public View e() {
        return this.f66698c;
    }

    public void f() {
        this.f66700e.notifyDataSetChanged();
    }

    public void g(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f66700e.c(list);
        this.f66700e.notifyDataSetChanged();
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f66698c, R.color.CAM_X0201);
        f();
    }

    public void i(e eVar) {
        this.f66700e.d(eVar);
    }
}
