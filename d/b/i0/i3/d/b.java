package d.b.i0.i3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.b.i0.i3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f56224e;

    /* renamed from: f  reason: collision with root package name */
    public List<DressItemData> f56225f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f56226g;

    /* renamed from: d.b.i0.i3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1314b {

        /* renamed from: a  reason: collision with root package name */
        public AvatarPendantPerItemView f56227a;

        public C1314b(b bVar) {
        }
    }

    public b(AvatarPendantActivity avatarPendantActivity) {
        this.f56224e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public DressItemData getItem(int i) {
        List<DressItemData> list = this.f56225f;
        if (list == null || list.size() <= 0 || this.f56225f.size() <= i) {
            return null;
        }
        return this.f56225f.get(i);
    }

    public final void b(View view) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view != null) {
            this.f56224e.getLayoutMode().k(skinType == 1);
            this.f56224e.getLayoutMode().j(view);
        }
    }

    public void c(c.a aVar) {
        this.f56226g = aVar;
    }

    public void d(List<DressItemData> list) {
        this.f56225f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<DressItemData> list = this.f56225f;
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
        C1314b c1314b;
        if (view != null && (view.getTag() instanceof C1314b)) {
            c1314b = (C1314b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56224e.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
            c1314b = new C1314b();
            AvatarPendantPerItemView avatarPendantPerItemView = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
            c1314b.f56227a = avatarPendantPerItemView;
            avatarPendantPerItemView.setAvatarPendantItemClickListener(this.f56226g);
            view.setTag(c1314b);
        }
        DressItemData item = getItem(i);
        if (item != null) {
            c1314b.f56227a.c(item);
        }
        b(view);
        return view;
    }
}
