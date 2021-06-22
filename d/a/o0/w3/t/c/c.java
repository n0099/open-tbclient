package d.a.o0.w3.t.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.a.o0.w3.u.e;
import d.a.o0.w3.u.f;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public View f66823c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalListView f66824d;

    /* renamed from: e  reason: collision with root package name */
    public f f66825e;

    public c(d.a.c.a.f fVar) {
        super(fVar);
    }

    @Override // d.a.o0.w3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f66816a.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.f66823c = inflate;
        this.f66824d = (HorizontalListView) inflate.findViewById(R.id.horizontal_list);
        f fVar = new f();
        this.f66825e = fVar;
        this.f66824d.setAdapter((ListAdapter) fVar);
    }

    public View e() {
        return this.f66823c;
    }

    public void f() {
        this.f66825e.notifyDataSetChanged();
    }

    public void g(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f66825e.c(list);
        this.f66825e.notifyDataSetChanged();
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f66823c, R.color.CAM_X0201);
        f();
    }

    public void i(e eVar) {
        this.f66825e.d(eVar);
    }
}
