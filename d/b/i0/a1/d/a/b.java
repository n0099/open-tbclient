package d.b.i0.a1.d.a;

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
    public List<d.b.i0.a1.d.c.a> f52457e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f52458f;

    /* renamed from: g  reason: collision with root package name */
    public int f52459g;

    /* renamed from: h  reason: collision with root package name */
    public int f52460h;
    public BdUniqueId i;
    public boolean j = false;

    /* renamed from: d.b.i0.a1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1140b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f52461a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f52462b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f52463c;

        public C1140b(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        this.f52459g = -1;
        this.f52458f = tbPageContext;
        this.i = bdUniqueId;
        this.f52460h = i;
        this.f52459g = d.b.h0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1140b c1140b) {
        if (c1140b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1140b.f52461a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1140b.f52463c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.b.i0.a1.d.c.a> list) {
        this.f52457e = list;
        if (this.j || ListUtils.isEmpty(list)) {
            return;
        }
        for (d.b.i0.a1.d.c.a aVar : list) {
            if (!StringUtils.isNull(aVar.f52516c)) {
                d.b.c.e.l.d.h().m(aVar.f52516c, 10, null, this.i);
            }
        }
        this.j = true;
    }

    public void c(int i) {
        this.f52459g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f52457e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f52457e, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1140b c1140b;
        if (view == null) {
            c1140b = new C1140b();
            view2 = LayoutInflater.from(this.f52458f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            c1140b.f52461a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
            c1140b.f52462b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
            c1140b.f52463c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
            c1140b.f52462b.setShowOval(true);
            c1140b.f52462b.setAutoChangeStyle(true);
            c1140b.f52462b.setBorderColor(this.f52458f.getResources().getColor(R.color.black_alpha8));
            c1140b.f52462b.setBorderWidth(this.f52458f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view2.setTag(c1140b);
        } else {
            view2 = view;
            c1140b = (C1140b) view.getTag();
        }
        a(c1140b);
        d.b.i0.a1.d.c.a aVar = (d.b.i0.a1.d.c.a) ListUtils.getItem(this.f52457e, i);
        if (aVar != null) {
            c1140b.f52461a.setText(StringUtils.isNull(aVar.f52515b) ? "" : aVar.f52515b);
            c1140b.f52462b.W(aVar.f52516c, 10, false);
            if (aVar.f52517d == 1) {
                c1140b.f52462b.setAlpha(1);
                c1140b.f52461a.setAlpha(1.0f);
            } else {
                c1140b.f52462b.setAlpha(0.5f);
                c1140b.f52461a.setAlpha(0.5f);
            }
            if (aVar.f52514a == this.f52459g && this.f52460h != 101) {
                c1140b.f52463c.setVisibility(0);
            } else {
                c1140b.f52463c.setVisibility(8);
            }
        }
        return view2;
    }
}
