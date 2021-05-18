package d.a.k0.j3.h;

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
    public List<d> f56939e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56940f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f56941a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56942b;

        /* renamed from: c  reason: collision with root package name */
        public View f56943c;

        /* renamed from: d  reason: collision with root package name */
        public View f56944d;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f56940f = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i2) {
        List<d> list = this.f56939e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56939e.size()) {
            return null;
        }
        return this.f56939e.get(i2);
    }

    public void b(List<d> list) {
        this.f56939e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f56939e;
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
            view = LayoutInflater.from(this.f56940f.getPageActivity()).inflate(R.layout.dressup_item_view, viewGroup, false);
            aVar = new a();
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.dress_icon);
            aVar.f56941a = headImageView;
            headImageView.setDefaultResource(R.drawable.img_default_100);
            aVar.f56941a.setDefaultBgResource(R.color.CAM_X0204);
            aVar.f56942b = (TextView) view.findViewById(R.id.dress_desc_view);
            aVar.f56943c = view.findViewById(R.id.tip_view);
            aVar.f56944d = view.findViewById(R.id.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            aVar.f56941a.V(item.a(), 10, false);
            aVar.f56942b.setText(item.b());
            d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
            if (item.d() - j.l("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), 0L) > 0) {
                aVar.f56943c.setVisibility(0);
            } else {
                aVar.f56943c.setVisibility(4);
            }
            if (i2 == getCount() - 1) {
                aVar.f56944d.setVisibility(8);
            } else {
                aVar.f56944d.setVisibility(0);
            }
        }
        this.f56940f.getLayoutMode().j(view);
        return view;
    }
}
