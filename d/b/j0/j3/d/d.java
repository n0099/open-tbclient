package d.b.j0.j3.d;

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
import d.b.c.e.p.k;
import d.b.j0.j3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {
    public static int i = 16;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f58104e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.j0.j3.d.a> f58105f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.j3.d.b f58106g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f58107h;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58108a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f58109b;

        /* renamed from: c  reason: collision with root package name */
        public View f58110c;

        public b(d dVar) {
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.f58104e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.j0.j3.d.a getItem(int i2) {
        List<d.b.j0.j3.d.a> list = this.f58105f;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f58105f.get(i2);
    }

    public void b(c.a aVar) {
        this.f58107h = aVar;
    }

    public void c(List<d.b.j0.j3.d.a> list) {
        this.f58105f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.j0.j3.d.a> list = this.f58105f;
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
            view = LayoutInflater.from(this.f58104e.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            bVar = new b();
            bVar.f58108a = (TextView) view.findViewById(R.id.category_name);
            bVar.f58109b = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            bVar.f58110c = view.findViewById(R.id.line_divider);
            view.setTag(bVar);
        }
        d.b.j0.j3.d.a item = getItem(i2);
        if (StringUtils.isNull(item.a())) {
            bVar.f58108a.setVisibility(8);
        } else {
            bVar.f58108a.setVisibility(0);
            bVar.f58108a.setText(k.cutString(item.a(), i));
        }
        if (item != null && !ListUtils.isEmpty(item.b())) {
            d.b.j0.j3.d.b bVar2 = new d.b.j0.j3.d.b(this.f58104e);
            this.f58106g = bVar2;
            bVar2.d(item.b());
            bVar.f58109b.setAdapter((ListAdapter) this.f58106g);
            this.f58106g.c(this.f58107h);
        }
        if (i2 == getCount() - 1) {
            bVar.f58110c.setVisibility(8);
        } else {
            bVar.f58110c.setVisibility(0);
        }
        SkinManager.setBackgroundColor(bVar.f58110c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f58108a, R.color.CAM_X0109);
        return view;
    }
}
