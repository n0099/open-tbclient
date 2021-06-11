package d.a.n0.b1.e.a;

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
    public List<d.a.n0.b1.e.c.a> f55120e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55121f;

    /* renamed from: g  reason: collision with root package name */
    public int f55122g;

    /* renamed from: h  reason: collision with root package name */
    public int f55123h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f55124i;
    public boolean j = false;

    /* renamed from: d.a.n0.b1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1247b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f55125a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f55126b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f55127c;

        public C1247b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i2, BdUniqueId bdUniqueId) {
        this.f55122g = -1;
        this.f55121f = tbPageContext;
        this.f55124i = bdUniqueId;
        this.f55123h = i2;
        this.f55122g = d.a.m0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1247b c1247b) {
        if (c1247b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1247b.f55125a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1247b.f55127c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.a.n0.b1.e.c.a> list) {
        this.f55120e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.a.n0.b1.e.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f55182c)) {
                d.a.c.e.l.d.h().m(aVar.f55182c, 10, null, this.f55124i);
            }
        }
        this.j = true;
    }

    public void c(int i2) {
        this.f55122g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f55120e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f55120e, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1247b c1247b;
        if (view == null) {
            c1247b = new C1247b();
            view2 = LayoutInflater.from(this.f55121f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1247b.f55125a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1247b.f55126b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1247b.f55127c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1247b.f55126b.setShowOval(true);
            c1247b.f55126b.setAutoChangeStyle(true);
            c1247b.f55126b.setBorderColor(this.f55121f.getResources().getColor(R.color.black_alpha8));
            c1247b.f55126b.setBorderWidth(this.f55121f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1247b);
        } else {
            view2 = view;
            c1247b = (C1247b) view.getTag();
        }
        a(c1247b);
        d.a.n0.b1.e.c.a aVar = (d.a.n0.b1.e.c.a) ListUtils.getItem(this.f55120e, i2);
        if (aVar != null) {
            c1247b.f55125a.setText(StringUtils.isNull(aVar.f55181b) ? "" : aVar.f55181b);
            c1247b.f55126b.U(aVar.f55182c, 10, false);
            if (aVar.f55183d == 1) {
                c1247b.f55126b.setAlpha(1);
                c1247b.f55125a.setAlpha(1.0f);
            } else {
                c1247b.f55126b.setAlpha(0.5f);
                c1247b.f55125a.setAlpha(0.5f);
            }
            if (aVar.f55180a == this.f55122g && this.f55123h != 101) {
                c1247b.f55127c.setVisibility(0);
            } else {
                c1247b.f55127c.setVisibility(8);
            }
        }
        return view2;
    }
}
