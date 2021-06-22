package d.a.o0.k3.h;

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
    public List<d> f60933e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60934f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60935a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60936b;

        /* renamed from: c  reason: collision with root package name */
        public View f60937c;

        /* renamed from: d  reason: collision with root package name */
        public View f60938d;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60934f = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i2) {
        List<d> list = this.f60933e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60933e.size()) {
            return null;
        }
        return this.f60933e.get(i2);
    }

    public void b(List<d> list) {
        this.f60933e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f60933e;
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
            view = LayoutInflater.from(this.f60934f.getPageActivity()).inflate(R.layout.dressup_item_view, viewGroup, false);
            aVar = new a();
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.dress_icon);
            aVar.f60935a = headImageView;
            headImageView.setDefaultResource(R.drawable.img_default_100);
            aVar.f60935a.setDefaultBgResource(R.color.CAM_X0204);
            aVar.f60936b = (TextView) view.findViewById(R.id.dress_desc_view);
            aVar.f60937c = view.findViewById(R.id.tip_view);
            aVar.f60938d = view.findViewById(R.id.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            aVar.f60935a.U(item.a(), 10, false);
            aVar.f60936b.setText(item.b());
            d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
            if (item.d() - j.l("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), 0L) > 0) {
                aVar.f60937c.setVisibility(0);
            } else {
                aVar.f60937c.setVisibility(4);
            }
            if (i2 == getCount() - 1) {
                aVar.f60938d.setVisibility(8);
            } else {
                aVar.f60938d.setVisibility(0);
            }
        }
        this.f60934f.getLayoutMode().j(view);
        return view;
    }
}
