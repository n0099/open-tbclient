package d.a.n0.k3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.n0.k3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f56962e;

    /* renamed from: f  reason: collision with root package name */
    public List<DressItemData> f56963f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f56964g;

    /* renamed from: d.a.n0.k3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1422b {

        /* renamed from: a  reason: collision with root package name */
        public AvatarPendantPerItemView f56965a;

        public C1422b(b bVar) {
        }
    }

    public b(AvatarPendantActivity avatarPendantActivity) {
        this.f56962e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public DressItemData getItem(int i2) {
        List<DressItemData> list = this.f56963f;
        if (list == null || list.size() <= 0 || this.f56963f.size() <= i2) {
            return null;
        }
        return this.f56963f.get(i2);
    }

    public final void b(View view) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view != null) {
            this.f56962e.getLayoutMode().k(skinType == 1);
            this.f56962e.getLayoutMode().j(view);
        }
    }

    public void c(c.a aVar) {
        this.f56964g = aVar;
    }

    public void d(List<DressItemData> list) {
        this.f56963f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<DressItemData> list = this.f56963f;
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
        C1422b c1422b;
        if (view != null && (view.getTag() instanceof C1422b)) {
            c1422b = (C1422b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56962e.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
            c1422b = new C1422b();
            AvatarPendantPerItemView avatarPendantPerItemView = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
            c1422b.f56965a = avatarPendantPerItemView;
            avatarPendantPerItemView.setAvatarPendantItemClickListener(this.f56964g);
            view.setTag(c1422b);
        }
        DressItemData item = getItem(i2);
        if (item != null) {
            c1422b.f56965a.c(item);
        }
        b(view);
        return view;
    }
}
