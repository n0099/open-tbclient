package d.b.j0.a1.d.a;

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
    public List<d.b.j0.a1.d.c.a> f52878e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f52879f;

    /* renamed from: g  reason: collision with root package name */
    public int f52880g;

    /* renamed from: h  reason: collision with root package name */
    public int f52881h;
    public BdUniqueId i;
    public boolean j = false;

    /* renamed from: d.b.j0.a1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1163b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f52882a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f52883b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f52884c;

        public C1163b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        this.f52880g = -1;
        this.f52879f = tbPageContext;
        this.i = bdUniqueId;
        this.f52881h = i;
        this.f52880g = d.b.i0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1163b c1163b) {
        if (c1163b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1163b.f52882a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1163b.f52884c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.b.j0.a1.d.c.a> list) {
        this.f52878e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.b.j0.a1.d.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f52937c)) {
                d.b.c.e.l.d.h().m(aVar.f52937c, 10, null, this.i);
            }
        }
        this.j = true;
    }

    public void c(int i) {
        this.f52880g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f52878e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f52878e, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1163b c1163b;
        if (view == null) {
            c1163b = new C1163b();
            view2 = LayoutInflater.from(this.f52879f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1163b.f52882a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1163b.f52883b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1163b.f52884c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1163b.f52883b.setShowOval(true);
            c1163b.f52883b.setAutoChangeStyle(true);
            c1163b.f52883b.setBorderColor(this.f52879f.getResources().getColor(R.color.black_alpha8));
            c1163b.f52883b.setBorderWidth(this.f52879f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1163b);
        } else {
            view2 = view;
            c1163b = (C1163b) view.getTag();
        }
        a(c1163b);
        d.b.j0.a1.d.c.a aVar = (d.b.j0.a1.d.c.a) ListUtils.getItem(this.f52878e, i);
        if (aVar != null) {
            c1163b.f52882a.setText(StringUtils.isNull(aVar.f52936b) ? "" : aVar.f52936b);
            c1163b.f52883b.W(aVar.f52937c, 10, false);
            if (aVar.f52938d == 1) {
                c1163b.f52883b.setAlpha(1);
                c1163b.f52882a.setAlpha(1.0f);
            } else {
                c1163b.f52883b.setAlpha(0.5f);
                c1163b.f52882a.setAlpha(0.5f);
            }
            if (aVar.f52935a == this.f52880g && this.f52881h != 101) {
                c1163b.f52884c.setVisibility(0);
            } else {
                c1163b.f52884c.setVisibility(8);
            }
        }
        return view2;
    }
}
