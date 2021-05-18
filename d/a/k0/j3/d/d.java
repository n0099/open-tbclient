package d.a.k0.j3.d;

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
import d.a.k0.j3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {

    /* renamed from: i  reason: collision with root package name */
    public static int f56795i = 16;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f56796e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.k0.j3.d.a> f56797f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.j3.d.b f56798g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f56799h;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56800a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f56801b;

        /* renamed from: c  reason: collision with root package name */
        public View f56802c;

        public b(d dVar) {
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.f56796e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.k0.j3.d.a getItem(int i2) {
        List<d.a.k0.j3.d.a> list = this.f56797f;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f56797f.get(i2);
    }

    public void b(c.a aVar) {
        this.f56799h = aVar;
    }

    public void c(List<d.a.k0.j3.d.a> list) {
        this.f56797f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.k0.j3.d.a> list = this.f56797f;
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
            view = LayoutInflater.from(this.f56796e.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            bVar = new b();
            bVar.f56800a = (TextView) view.findViewById(R.id.category_name);
            bVar.f56801b = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            bVar.f56802c = view.findViewById(R.id.line_divider);
            view.setTag(bVar);
        }
        d.a.k0.j3.d.a item = getItem(i2);
        if (StringUtils.isNull(item.a())) {
            bVar.f56800a.setVisibility(8);
        } else {
            bVar.f56800a.setVisibility(0);
            bVar.f56800a.setText(k.cutString(item.a(), f56795i));
        }
        if (item != null && !ListUtils.isEmpty(item.b())) {
            d.a.k0.j3.d.b bVar2 = new d.a.k0.j3.d.b(this.f56796e);
            this.f56798g = bVar2;
            bVar2.d(item.b());
            bVar.f56801b.setAdapter((ListAdapter) this.f56798g);
            this.f56798g.c(this.f56799h);
        }
        if (i2 == getCount() - 1) {
            bVar.f56802c.setVisibility(8);
        } else {
            bVar.f56802c.setVisibility(0);
        }
        SkinManager.setBackgroundColor(bVar.f56802c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f56800a, R.color.CAM_X0109);
        return view;
    }
}
