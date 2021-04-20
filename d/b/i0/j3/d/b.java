package d.b.i0.j3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.b.i0.j3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f57671e;

    /* renamed from: f  reason: collision with root package name */
    public List<DressItemData> f57672f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f57673g;

    /* renamed from: d.b.i0.j3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1370b {

        /* renamed from: a  reason: collision with root package name */
        public AvatarPendantPerItemView f57674a;

        public C1370b(b bVar) {
        }
    }

    public b(AvatarPendantActivity avatarPendantActivity) {
        this.f57671e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public DressItemData getItem(int i) {
        List<DressItemData> list = this.f57672f;
        if (list == null || list.size() <= 0 || this.f57672f.size() <= i) {
            return null;
        }
        return this.f57672f.get(i);
    }

    public final void b(View view) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view != null) {
            this.f57671e.getLayoutMode().k(skinType == 1);
            this.f57671e.getLayoutMode().j(view);
        }
    }

    public void c(c.a aVar) {
        this.f57673g = aVar;
    }

    public void d(List<DressItemData> list) {
        this.f57672f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<DressItemData> list = this.f57672f;
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
        C1370b c1370b;
        if (view != null && (view.getTag() instanceof C1370b)) {
            c1370b = (C1370b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f57671e.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
            c1370b = new C1370b();
            AvatarPendantPerItemView avatarPendantPerItemView = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
            c1370b.f57674a = avatarPendantPerItemView;
            avatarPendantPerItemView.setAvatarPendantItemClickListener(this.f57673g);
            view.setTag(c1370b);
        }
        DressItemData item = getItem(i);
        if (item != null) {
            c1370b.f57674a.c(item);
        }
        b(view);
        return view;
    }
}
