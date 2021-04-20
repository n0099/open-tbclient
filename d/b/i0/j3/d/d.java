package d.b.i0.j3.d;

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
import d.b.i0.j3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {
    public static int i = 16;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f57683e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.j3.d.a> f57684f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.j3.d.b f57685g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f57686h;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57687a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f57688b;

        /* renamed from: c  reason: collision with root package name */
        public View f57689c;

        public b(d dVar) {
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.f57683e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.i0.j3.d.a getItem(int i2) {
        List<d.b.i0.j3.d.a> list = this.f57684f;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f57684f.get(i2);
    }

    public void b(c.a aVar) {
        this.f57686h = aVar;
    }

    public void c(List<d.b.i0.j3.d.a> list) {
        this.f57684f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.j3.d.a> list = this.f57684f;
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
            view = LayoutInflater.from(this.f57683e.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            bVar = new b();
            bVar.f57687a = (TextView) view.findViewById(R.id.category_name);
            bVar.f57688b = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            bVar.f57689c = view.findViewById(R.id.line_divider);
            view.setTag(bVar);
        }
        d.b.i0.j3.d.a item = getItem(i2);
        if (StringUtils.isNull(item.a())) {
            bVar.f57687a.setVisibility(8);
        } else {
            bVar.f57687a.setVisibility(0);
            bVar.f57687a.setText(k.cutString(item.a(), i));
        }
        if (item != null && !ListUtils.isEmpty(item.b())) {
            d.b.i0.j3.d.b bVar2 = new d.b.i0.j3.d.b(this.f57683e);
            this.f57685g = bVar2;
            bVar2.d(item.b());
            bVar.f57688b.setAdapter((ListAdapter) this.f57685g);
            this.f57685g.c(this.f57686h);
        }
        if (i2 == getCount() - 1) {
            bVar.f57689c.setVisibility(8);
        } else {
            bVar.f57689c.setVisibility(0);
        }
        SkinManager.setBackgroundColor(bVar.f57689c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f57687a, R.color.CAM_X0109);
        return view;
    }
}
