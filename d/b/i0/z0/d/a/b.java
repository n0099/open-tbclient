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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.z0.d.c.a> f62838e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f62839f;

    /* renamed from: g  reason: collision with root package name */
    public int f62840g;

    /* renamed from: h  reason: collision with root package name */
    public int f62841h;
    public BdUniqueId i;
    public boolean j = false;

    /* renamed from: d.b.i0.z0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1688b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62842a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f62843b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62844c;

        public C1688b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        this.f62840g = -1;
        this.f62839f = tbPageContext;
        this.i = bdUniqueId;
        this.f62841h = i;
        this.f62840g = d.b.h0.r.d0.b.i().j("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1688b c1688b) {
        if (c1688b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1688b.f62842a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1688b.f62844c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.b.i0.z0.d.c.a> list) {
        this.f62838e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.b.i0.z0.d.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f62897c)) {
                d.b.b.e.l.d.h().m(aVar.f62897c, 10, null, this.i);
            }
        }
        this.j = true;
    }

    public void c(int i) {
        this.f62840g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f62838e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f62838e, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1688b c1688b;
        if (view == null) {
            c1688b = new C1688b();
            view2 = LayoutInflater.from(this.f62839f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1688b.f62842a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1688b.f62843b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1688b.f62844c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1688b.f62843b.setShowOval(true);
            c1688b.f62843b.setAutoChangeStyle(true);
            c1688b.f62843b.setBorderColor(this.f62839f.getResources().getColor(R.color.black_alpha8));
            c1688b.f62843b.setBorderWidth(this.f62839f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1688b);
        } else {
            view2 = view;
            c1688b = (C1688b) view.getTag();
        }
        a(c1688b);
        d.b.i0.z0.d.c.a aVar = (d.b.i0.z0.d.c.a) ListUtils.getItem(this.f62838e, i);
        if (aVar != null) {
            c1688b.f62842a.setText(StringUtils.isNull(aVar.f62896b) ? "" : aVar.f62896b);
            c1688b.f62843b.W(aVar.f62897c, 10, false);
            if (aVar.f62898d == 1) {
                c1688b.f62843b.setAlpha(1);
                c1688b.f62842a.setAlpha(1.0f);
            } else {
                c1688b.f62843b.setAlpha(0.5f);
                c1688b.f62842a.setAlpha(0.5f);
            }
            if (aVar.f62895a == this.f62840g && this.f62841h != 101) {
                c1688b.f62844c.setVisibility(0);
            } else {
                c1688b.f62844c.setVisibility(8);
            }
        }
        return view2;
    }
}
