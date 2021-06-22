package d.a.o0.k3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.o0.k3.d.c;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f60776e;

    /* renamed from: f  reason: collision with root package name */
    public List<DressItemData> f60777f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f60778g;

    /* renamed from: d.a.o0.k3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1482b {

        /* renamed from: a  reason: collision with root package name */
        public AvatarPendantPerItemView f60779a;

        public C1482b(b bVar) {
        }
    }

    public b(AvatarPendantActivity avatarPendantActivity) {
        this.f60776e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public DressItemData getItem(int i2) {
        List<DressItemData> list = this.f60777f;
        if (list == null || list.size() <= 0 || this.f60777f.size() <= i2) {
            return null;
        }
        return this.f60777f.get(i2);
    }

    public final void b(View view) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view != null) {
            this.f60776e.getLayoutMode().k(skinType == 1);
            this.f60776e.getLayoutMode().j(view);
        }
    }

    public void c(c.a aVar) {
        this.f60778g = aVar;
    }

    public void d(List<DressItemData> list) {
        this.f60777f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<DressItemData> list = this.f60777f;
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
        C1482b c1482b;
        if (view != null && (view.getTag() instanceof C1482b)) {
            c1482b = (C1482b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60776e.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
            c1482b = new C1482b();
            AvatarPendantPerItemView avatarPendantPerItemView = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
            c1482b.f60779a = avatarPendantPerItemView;
            avatarPendantPerItemView.setAvatarPendantItemClickListener(this.f60778g);
            view.setTag(c1482b);
        }
        DressItemData item = getItem(i2);
        if (item != null) {
            c1482b.f60779a.c(item);
        }
        b(view);
        return view;
    }
}
