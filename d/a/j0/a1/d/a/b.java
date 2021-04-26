package d.a.j0.a1.d.a;

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
    public List<d.a.j0.a1.d.c.a> f50575e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f50576f;

    /* renamed from: g  reason: collision with root package name */
    public int f50577g;

    /* renamed from: h  reason: collision with root package name */
    public int f50578h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f50579i;
    public boolean j = false;

    /* renamed from: d.a.j0.a1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1102b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f50580a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f50581b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f50582c;

        public C1102b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i2, BdUniqueId bdUniqueId) {
        this.f50577g = -1;
        this.f50576f = tbPageContext;
        this.f50579i = bdUniqueId;
        this.f50578h = i2;
        this.f50577g = d.a.i0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1102b c1102b) {
        if (c1102b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1102b.f50580a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1102b.f50582c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.a.j0.a1.d.c.a> list) {
        this.f50575e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.a.j0.a1.d.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f50637c)) {
                d.a.c.e.l.d.h().m(aVar.f50637c, 10, null, this.f50579i);
            }
        }
        this.j = true;
    }

    public void c(int i2) {
        this.f50577g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f50575e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f50575e, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1102b c1102b;
        if (view == null) {
            c1102b = new C1102b();
            view2 = LayoutInflater.from(this.f50576f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1102b.f50580a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1102b.f50581b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1102b.f50582c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1102b.f50581b.setShowOval(true);
            c1102b.f50581b.setAutoChangeStyle(true);
            c1102b.f50581b.setBorderColor(this.f50576f.getResources().getColor(R.color.black_alpha8));
            c1102b.f50581b.setBorderWidth(this.f50576f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1102b);
        } else {
            view2 = view;
            c1102b = (C1102b) view.getTag();
        }
        a(c1102b);
        d.a.j0.a1.d.c.a aVar = (d.a.j0.a1.d.c.a) ListUtils.getItem(this.f50575e, i2);
        if (aVar != null) {
            c1102b.f50580a.setText(StringUtils.isNull(aVar.f50636b) ? "" : aVar.f50636b);
            c1102b.f50581b.V(aVar.f50637c, 10, false);
            if (aVar.f50638d == 1) {
                c1102b.f50581b.setAlpha(1);
                c1102b.f50580a.setAlpha(1.0f);
            } else {
                c1102b.f50581b.setAlpha(0.5f);
                c1102b.f50580a.setAlpha(0.5f);
            }
            if (aVar.f50635a == this.f50577g && this.f50578h != 101) {
                c1102b.f50582c.setVisibility(0);
            } else {
                c1102b.f50582c.setVisibility(8);
            }
        }
        return view2;
    }
}
