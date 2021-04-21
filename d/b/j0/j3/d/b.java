package d.b.j0.j3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.b.j0.j3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f58092e;

    /* renamed from: f  reason: collision with root package name */
    public List<DressItemData> f58093f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f58094g;

    /* renamed from: d.b.j0.j3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1393b {

        /* renamed from: a  reason: collision with root package name */
        public AvatarPendantPerItemView f58095a;

        public C1393b(b bVar) {
        }
    }

    public b(AvatarPendantActivity avatarPendantActivity) {
        this.f58092e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public DressItemData getItem(int i) {
        List<DressItemData> list = this.f58093f;
        if (list == null || list.size() <= 0 || this.f58093f.size() <= i) {
            return null;
        }
        return this.f58093f.get(i);
    }

    public final void b(View view) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view != null) {
            this.f58092e.getLayoutMode().k(skinType == 1);
            this.f58092e.getLayoutMode().j(view);
        }
    }

    public void c(c.a aVar) {
        this.f58094g = aVar;
    }

    public void d(List<DressItemData> list) {
        this.f58093f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<DressItemData> list = this.f58093f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1393b c1393b;
        if (view != null && (view.getTag() instanceof C1393b)) {
            c1393b = (C1393b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f58092e.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
            c1393b = new C1393b();
            AvatarPendantPerItemView avatarPendantPerItemView = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
            c1393b.f58095a = avatarPendantPerItemView;
            avatarPendantPerItemView.setAvatarPendantItemClickListener(this.f58094g);
            view.setTag(c1393b);
        }
        DressItemData item = getItem(i);
        if (item != null) {
            c1393b.f58095a.c(item);
        }
        b(view);
        return view;
    }
}
