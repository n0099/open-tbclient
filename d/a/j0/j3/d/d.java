package d.a.j0.j3.d;

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
import d.a.c.e.p.k;
import d.a.j0.j3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {

    /* renamed from: i  reason: collision with root package name */
    public static int f56088i = 16;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f56089e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.j0.j3.d.a> f56090f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.j3.d.b f56091g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f56092h;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56093a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f56094b;

        /* renamed from: c  reason: collision with root package name */
        public View f56095c;

        public b(d dVar) {
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.f56089e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.j0.j3.d.a getItem(int i2) {
        List<d.a.j0.j3.d.a> list = this.f56090f;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f56090f.get(i2);
    }

    public void b(c.a aVar) {
        this.f56092h = aVar;
    }

    public void c(List<d.a.j0.j3.d.a> list) {
        this.f56090f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.j0.j3.d.a> list = this.f56090f;
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
            view = LayoutInflater.from(this.f56089e.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            bVar = new b();
            bVar.f56093a = (TextView) view.findViewById(R.id.category_name);
            bVar.f56094b = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            bVar.f56095c = view.findViewById(R.id.line_divider);
            view.setTag(bVar);
        }
        d.a.j0.j3.d.a item = getItem(i2);
        if (StringUtils.isNull(item.a())) {
            bVar.f56093a.setVisibility(8);
        } else {
            bVar.f56093a.setVisibility(0);
            bVar.f56093a.setText(k.cutString(item.a(), f56088i));
        }
        if (item != null && !ListUtils.isEmpty(item.b())) {
            d.a.j0.j3.d.b bVar2 = new d.a.j0.j3.d.b(this.f56089e);
            this.f56091g = bVar2;
            bVar2.d(item.b());
            bVar.f56094b.setAdapter((ListAdapter) this.f56091g);
            this.f56091g.c(this.f56092h);
        }
        if (i2 == getCount() - 1) {
            bVar.f56095c.setVisibility(8);
        } else {
            bVar.f56095c.setVisibility(0);
        }
        SkinManager.setBackgroundColor(bVar.f56095c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f56093a, R.color.CAM_X0109);
        return view;
    }
}
