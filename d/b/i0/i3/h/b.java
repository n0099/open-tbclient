package d.b.i0.i3.h;

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
    public List<d> f56370e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56371f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f56372a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56373b;

        /* renamed from: c  reason: collision with root package name */
        public View f56374c;

        /* renamed from: d  reason: collision with root package name */
        public View f56375d;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f56371f = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i) {
        List<d> list = this.f56370e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56370e.size()) {
            return null;
        }
        return this.f56370e.get(i);
    }

    public void b(List<d> list) {
        this.f56370e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f56370e;
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
        a aVar;
        d item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56371f.getPageActivity()).inflate(R.layout.dressup_item_view, viewGroup, false);
            aVar = new a();
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.dress_icon);
            aVar.f56372a = headImageView;
            headImageView.setDefaultResource(R.drawable.img_default_100);
            aVar.f56372a.setDefaultBgResource(R.color.CAM_X0204);
            aVar.f56373b = (TextView) view.findViewById(R.id.dress_desc_view);
            aVar.f56374c = view.findViewById(R.id.tip_view);
            aVar.f56375d = view.findViewById(R.id.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            aVar.f56372a.W(item.a(), 10, false);
            aVar.f56373b.setText(item.b());
            d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
            if (item.d() - i2.k("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), 0L) > 0) {
                aVar.f56374c.setVisibility(0);
            } else {
                aVar.f56374c.setVisibility(4);
            }
            if (i == getCount() - 1) {
                aVar.f56375d.setVisibility(8);
            } else {
                aVar.f56375d.setVisibility(0);
            }
        }
        this.f56371f.getLayoutMode().j(view);
        return view;
    }
}
