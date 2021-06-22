package d.a.o0.b1.e.a;

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
    public List<d.a.o0.b1.e.c.a> f55245e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55246f;

    /* renamed from: g  reason: collision with root package name */
    public int f55247g;

    /* renamed from: h  reason: collision with root package name */
    public int f55248h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f55249i;
    public boolean j = false;

    /* renamed from: d.a.o0.b1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1251b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f55250a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f55251b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f55252c;

        public C1251b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i2, BdUniqueId bdUniqueId) {
        this.f55247g = -1;
        this.f55246f = tbPageContext;
        this.f55249i = bdUniqueId;
        this.f55248h = i2;
        this.f55247g = d.a.n0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1251b c1251b) {
        if (c1251b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1251b.f55250a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1251b.f55252c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.a.o0.b1.e.c.a> list) {
        this.f55245e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.a.o0.b1.e.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f55307c)) {
                d.a.c.e.l.d.h().m(aVar.f55307c, 10, null, this.f55249i);
            }
        }
        this.j = true;
    }

    public void c(int i2) {
        this.f55247g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f55245e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f55245e, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1251b c1251b;
        if (view == null) {
            c1251b = new C1251b();
            view2 = LayoutInflater.from(this.f55246f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1251b.f55250a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1251b.f55251b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1251b.f55252c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1251b.f55251b.setShowOval(true);
            c1251b.f55251b.setAutoChangeStyle(true);
            c1251b.f55251b.setBorderColor(this.f55246f.getResources().getColor(R.color.black_alpha8));
            c1251b.f55251b.setBorderWidth(this.f55246f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1251b);
        } else {
            view2 = view;
            c1251b = (C1251b) view.getTag();
        }
        a(c1251b);
        d.a.o0.b1.e.c.a aVar = (d.a.o0.b1.e.c.a) ListUtils.getItem(this.f55245e, i2);
        if (aVar != null) {
            c1251b.f55250a.setText(StringUtils.isNull(aVar.f55306b) ? "" : aVar.f55306b);
            c1251b.f55251b.U(aVar.f55307c, 10, false);
            if (aVar.f55308d == 1) {
                c1251b.f55251b.setAlpha(1);
                c1251b.f55250a.setAlpha(1.0f);
            } else {
                c1251b.f55251b.setAlpha(0.5f);
                c1251b.f55250a.setAlpha(0.5f);
            }
            if (aVar.f55305a == this.f55247g && this.f55248h != 101) {
                c1251b.f55252c.setVisibility(0);
            } else {
                c1251b.f55252c.setVisibility(8);
            }
        }
        return view2;
    }
}
