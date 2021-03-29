package d.b.i0.i3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import d.b.b.e.p.k;
import d.b.i0.i3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {
    public static int i = 16;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f56236e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.i3.d.a> f56237f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i3.d.b f56238g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f56239h;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56240a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f56241b;

        /* renamed from: c  reason: collision with root package name */
        public View f56242c;

        public b(d dVar) {
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.f56236e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.i0.i3.d.a getItem(int i2) {
        List<d.b.i0.i3.d.a> list = this.f56237f;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f56237f.get(i2);
    }

    public void b(c.a aVar) {
        this.f56239h = aVar;
    }

    public void c(List<d.b.i0.i3.d.a> list) {
        this.f56237f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.i3.d.a> list = this.f56237f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56236e.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            bVar = new b();
            bVar.f56240a = (TextView) view.findViewById(R.id.category_name);
            bVar.f56241b = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            bVar.f56242c = view.findViewById(R.id.line_divider);
            view.setTag(bVar);
        }
        d.b.i0.i3.d.a item = getItem(i2);
        if (StringUtils.isNull(item.a())) {
            bVar.f56240a.setVisibility(8);
        } else {
            bVar.f56240a.setVisibility(0);
            bVar.f56240a.setText(k.cutString(item.a(), i));
        }
        if (item != null && !ListUtils.isEmpty(item.b())) {
            d.b.i0.i3.d.b bVar2 = new d.b.i0.i3.d.b(this.f56236e);
            this.f56238g = bVar2;
            bVar2.d(item.b());
            bVar.f56241b.setAdapter((ListAdapter) this.f56238g);
            this.f56238g.c(this.f56239h);
        }
        if (i2 == getCount() - 1) {
            bVar.f56242c.setVisibility(8);
        } else {
            bVar.f56242c.setVisibility(0);
        }
        SkinManager.setBackgroundColor(bVar.f56242c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f56240a, R.color.CAM_X0109);
        return view;
    }
}
