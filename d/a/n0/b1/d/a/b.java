package d.a.n0.b1.d.a;

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
    public List<d.a.n0.b1.d.c.a> f51437e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f51438f;

    /* renamed from: g  reason: collision with root package name */
    public int f51439g;

    /* renamed from: h  reason: collision with root package name */
    public int f51440h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f51441i;
    public boolean j = false;

    /* renamed from: d.a.n0.b1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1191b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f51442a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f51443b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f51444c;

        public C1191b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i2, BdUniqueId bdUniqueId) {
        this.f51439g = -1;
        this.f51438f = tbPageContext;
        this.f51441i = bdUniqueId;
        this.f51440h = i2;
        this.f51439g = d.a.m0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1191b c1191b) {
        if (c1191b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1191b.f51442a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1191b.f51444c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.a.n0.b1.d.c.a> list) {
        this.f51437e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.a.n0.b1.d.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f51499c)) {
                d.a.c.e.l.d.h().m(aVar.f51499c, 10, null, this.f51441i);
            }
        }
        this.j = true;
    }

    public void c(int i2) {
        this.f51439g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f51437e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f51437e, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1191b c1191b;
        if (view == null) {
            c1191b = new C1191b();
            view2 = LayoutInflater.from(this.f51438f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1191b.f51442a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1191b.f51443b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1191b.f51444c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1191b.f51443b.setShowOval(true);
            c1191b.f51443b.setAutoChangeStyle(true);
            c1191b.f51443b.setBorderColor(this.f51438f.getResources().getColor(R.color.black_alpha8));
            c1191b.f51443b.setBorderWidth(this.f51438f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1191b);
        } else {
            view2 = view;
            c1191b = (C1191b) view.getTag();
        }
        a(c1191b);
        d.a.n0.b1.d.c.a aVar = (d.a.n0.b1.d.c.a) ListUtils.getItem(this.f51437e, i2);
        if (aVar != null) {
            c1191b.f51442a.setText(StringUtils.isNull(aVar.f51498b) ? "" : aVar.f51498b);
            c1191b.f51443b.V(aVar.f51499c, 10, false);
            if (aVar.f51500d == 1) {
                c1191b.f51443b.setAlpha(1);
                c1191b.f51442a.setAlpha(1.0f);
            } else {
                c1191b.f51443b.setAlpha(0.5f);
                c1191b.f51442a.setAlpha(0.5f);
            }
            if (aVar.f51497a == this.f51439g && this.f51440h != 101) {
                c1191b.f51444c.setVisibility(0);
            } else {
                c1191b.f51444c.setVisibility(8);
            }
        }
        return view2;
    }
}
