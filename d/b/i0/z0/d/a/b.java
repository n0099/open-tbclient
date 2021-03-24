package d.b.i0.z0.d.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.z0.d.c.a> f62837e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f62838f;

    /* renamed from: g  reason: collision with root package name */
    public int f62839g;

    /* renamed from: h  reason: collision with root package name */
    public int f62840h;
    public BdUniqueId i;
    public boolean j = false;

    /* renamed from: d.b.i0.z0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1687b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62841a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f62842b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62843c;

        public C1687b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        this.f62839g = -1;
        this.f62838f = tbPageContext;
        this.i = bdUniqueId;
        this.f62840h = i;
        this.f62839g = d.b.h0.r.d0.b.i().j("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1687b c1687b) {
        if (c1687b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1687b.f62841a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1687b.f62843c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.b.i0.z0.d.c.a> list) {
        this.f62837e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.b.i0.z0.d.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f62896c)) {
                d.b.b.e.l.d.h().m(aVar.f62896c, 10, null, this.i);
            }
        }
        this.j = true;
    }

    public void c(int i) {
        this.f62839g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f62837e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f62837e, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1687b c1687b;
        if (view == null) {
            c1687b = new C1687b();
            view2 = LayoutInflater.from(this.f62838f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1687b.f62841a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1687b.f62842b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1687b.f62843c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1687b.f62842b.setShowOval(true);
            c1687b.f62842b.setAutoChangeStyle(true);
            c1687b.f62842b.setBorderColor(this.f62838f.getResources().getColor(R.color.black_alpha8));
            c1687b.f62842b.setBorderWidth(this.f62838f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1687b);
        } else {
            view2 = view;
            c1687b = (C1687b) view.getTag();
        }
        a(c1687b);
        d.b.i0.z0.d.c.a aVar = (d.b.i0.z0.d.c.a) ListUtils.getItem(this.f62837e, i);
        if (aVar != null) {
            c1687b.f62841a.setText(StringUtils.isNull(aVar.f62895b) ? "" : aVar.f62895b);
            c1687b.f62842b.W(aVar.f62896c, 10, false);
            if (aVar.f62897d == 1) {
                c1687b.f62842b.setAlpha(1);
                c1687b.f62841a.setAlpha(1.0f);
            } else {
                c1687b.f62842b.setAlpha(0.5f);
                c1687b.f62841a.setAlpha(0.5f);
            }
            if (aVar.f62894a == this.f62839g && this.f62840h != 101) {
                c1687b.f62843c.setVisibility(0);
            } else {
                c1687b.f62843c.setVisibility(8);
            }
        }
        return view2;
    }
}
