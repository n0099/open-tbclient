package d.a.k0.a1.d.a;

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
    public List<d.a.k0.a1.d.c.a> f51272e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f51273f;

    /* renamed from: g  reason: collision with root package name */
    public int f51274g;

    /* renamed from: h  reason: collision with root package name */
    public int f51275h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f51276i;
    public boolean j = false;

    /* renamed from: d.a.k0.a1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1174b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f51277a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f51278b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f51279c;

        public C1174b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i2, BdUniqueId bdUniqueId) {
        this.f51274g = -1;
        this.f51273f = tbPageContext;
        this.f51276i = bdUniqueId;
        this.f51275h = i2;
        this.f51274g = d.a.j0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1174b c1174b) {
        if (c1174b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1174b.f51277a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1174b.f51279c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.a.k0.a1.d.c.a> list) {
        this.f51272e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.a.k0.a1.d.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f51334c)) {
                d.a.c.e.l.d.h().m(aVar.f51334c, 10, null, this.f51276i);
            }
        }
        this.j = true;
    }

    public void c(int i2) {
        this.f51274g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f51272e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f51272e, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1174b c1174b;
        if (view == null) {
            c1174b = new C1174b();
            view2 = LayoutInflater.from(this.f51273f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1174b.f51277a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1174b.f51278b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1174b.f51279c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1174b.f51278b.setShowOval(true);
            c1174b.f51278b.setAutoChangeStyle(true);
            c1174b.f51278b.setBorderColor(this.f51273f.getResources().getColor(R.color.black_alpha8));
            c1174b.f51278b.setBorderWidth(this.f51273f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1174b);
        } else {
            view2 = view;
            c1174b = (C1174b) view.getTag();
        }
        a(c1174b);
        d.a.k0.a1.d.c.a aVar = (d.a.k0.a1.d.c.a) ListUtils.getItem(this.f51272e, i2);
        if (aVar != null) {
            c1174b.f51277a.setText(StringUtils.isNull(aVar.f51333b) ? "" : aVar.f51333b);
            c1174b.f51278b.V(aVar.f51334c, 10, false);
            if (aVar.f51335d == 1) {
                c1174b.f51278b.setAlpha(1);
                c1174b.f51277a.setAlpha(1.0f);
            } else {
                c1174b.f51278b.setAlpha(0.5f);
                c1174b.f51277a.setAlpha(0.5f);
            }
            if (aVar.f51332a == this.f51274g && this.f51275h != 101) {
                c1174b.f51279c.setVisibility(0);
            } else {
                c1174b.f51279c.setVisibility(8);
            }
        }
        return view2;
    }
}
