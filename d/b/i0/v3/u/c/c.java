package d.b.i0.v3.u.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.b.i0.v3.v.e;
import d.b.i0.v3.v.f;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public View f63487c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalListView f63488d;

    /* renamed from: e  reason: collision with root package name */
    public f f63489e;

    public c(d.b.c.a.f fVar) {
        super(fVar);
    }

    @Override // d.b.i0.v3.u.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f63480a.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.f63487c = inflate;
        this.f63488d = (HorizontalListView) inflate.findViewById(R.id.horizontal_list);
        f fVar = new f();
        this.f63489e = fVar;
        this.f63488d.setAdapter((ListAdapter) fVar);
    }

    public View e() {
        return this.f63487c;
    }

    public void f() {
        this.f63489e.notifyDataSetChanged();
    }

    public void g(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f63489e.c(list);
        this.f63489e.notifyDataSetChanged();
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f63487c, R.color.CAM_X0201);
        f();
    }

    public void i(e eVar) {
        this.f63489e.d(eVar);
    }
}
