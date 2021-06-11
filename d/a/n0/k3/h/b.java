package d.a.n0.k3.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d> f60808e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60809f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60810a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60811b;

        /* renamed from: c  reason: collision with root package name */
        public View f60812c;

        /* renamed from: d  reason: collision with root package name */
        public View f60813d;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60809f = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i2) {
        List<d> list = this.f60808e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60808e.size()) {
            return null;
        }
        return this.f60808e.get(i2);
    }

    public void b(List<d> list) {
        this.f60808e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f60808e;
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
        a aVar;
        d item = getItem(i2);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60809f.getPageActivity()).inflate(R.layout.dressup_item_view, viewGroup, false);
            aVar = new a();
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.dress_icon);
            aVar.f60810a = headImageView;
            headImageView.setDefaultResource(R.drawable.img_default_100);
            aVar.f60810a.setDefaultBgResource(R.color.CAM_X0204);
            aVar.f60811b = (TextView) view.findViewById(R.id.dress_desc_view);
            aVar.f60812c = view.findViewById(R.id.tip_view);
            aVar.f60813d = view.findViewById(R.id.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            aVar.f60810a.U(item.a(), 10, false);
            aVar.f60811b.setText(item.b());
            d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
            if (item.d() - j.l("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), 0L) > 0) {
                aVar.f60812c.setVisibility(0);
            } else {
                aVar.f60812c.setVisibility(4);
            }
            if (i2 == getCount() - 1) {
                aVar.f60813d.setVisibility(8);
            } else {
                aVar.f60813d.setVisibility(0);
            }
        }
        this.f60809f.getLayoutMode().j(view);
        return view;
    }
}
