package d.a.n0.w3.u;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.r.q.v;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f66715e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<d.a.m0.r.f0.p.a> f66716f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<v> f66717g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public b f66718h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66719e;

        public a(int i2) {
            this.f66719e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.r.f0.p.a g2 = d.this.g(this.f66719e);
            if (g2 == null) {
                return;
            }
            if (d.this.f66718h != null) {
                d.this.f66718h.b(g2.e());
            }
            if (d.this.f66718h != null) {
                d.this.f66718h.a(d.this.f66717g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<v> list);

        void b(int i2);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f66721a;

        /* renamed from: b  reason: collision with root package name */
        public View f66722b;

        /* renamed from: c  reason: collision with root package name */
        public View f66723c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f66724d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66725e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f66726f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f66727g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f66728h;

        /* renamed from: i  reason: collision with root package name */
        public View f66729i;

        public c(d dVar) {
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(TbPageContext tbPageContext) {
        this.f66715e = tbPageContext;
    }

    public final void c() {
        this.f66717g.clear();
        if (ListUtils.isEmpty(this.f66716f)) {
            return;
        }
        Iterator<d.a.m0.r.f0.p.a> it = this.f66716f.iterator();
        while (it.hasNext()) {
            d.a.m0.r.f0.p.a next = it.next();
            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.t() != null) {
                    v t = tbLinkSpanGroup.t();
                    t.t = tbLinkSpanGroup.f();
                    this.f66717g.add(t);
                }
            }
        }
        Collections.sort(this.f66717g);
    }

    public LinkedList<v> d() {
        return this.f66717g;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        if (ListUtils.isEmpty(this.f66717g)) {
            return true;
        }
        Iterator<v> it = this.f66717g.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.f53813f == 2 || !next.m) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    public LinkedList<d.a.m0.r.f0.p.a> f() {
        return this.f66716f;
    }

    public d.a.m0.r.f0.p.a g(int i2) {
        LinkedList<d.a.m0.r.f0.p.a> linkedList;
        long itemId = getItemId(i2);
        if (itemId != 0 && (linkedList = this.f66716f) != null) {
            Iterator<d.a.m0.r.f0.p.a> it = linkedList.iterator();
            while (it.hasNext()) {
                d.a.m0.r.f0.p.a next = it.next();
                if (next.e() == itemId) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<v> linkedList = this.f66717g;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        LinkedList<v> linkedList = this.f66717g;
        if (linkedList == null || linkedList.size() <= i2) {
            return null;
        }
        return this.f66717g.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        LinkedList<v> linkedList = this.f66717g;
        return (linkedList == null || linkedList.size() <= i2 || this.f66717g.get(i2) == null) ? 0 : this.f66717g.get(i2).f53812e;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        View view2;
        v vVar = (v) getItem(i2);
        if (vVar == null) {
            return null;
        }
        if (view == null) {
            view2 = LayoutInflater.from(this.f66715e.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
            cVar = new c(this, null);
            cVar.f66721a = view2.findViewById(R.id.commodity_root_view);
            cVar.f66722b = view2.findViewById(R.id.commodity_main_view);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.commodity_link_icon);
            cVar.f66724d = tbImageView;
            tbImageView.setConrers(15);
            cVar.f66724d.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            cVar.f66724d.setPlaceHolderAutoChangeSkinType(1);
            cVar.f66724d.setGifIconSupport(false);
            cVar.f66724d.setLongIconSupport(false);
            cVar.f66724d.setDrawBorder(true);
            cVar.f66724d.setBorderWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            cVar.f66724d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            cVar.f66725e = (TextView) view2.findViewById(R.id.commodity_link_content);
            cVar.f66726f = (ImageView) view2.findViewById(R.id.commodity_link_close_button);
            cVar.f66723c = view2.findViewById(R.id.extra_info_container);
            cVar.f66727g = (TextView) view2.findViewById(R.id.commodity_price);
            cVar.f66728h = (TextView) view2.findViewById(R.id.commodity_extra_infos);
            cVar.f66729i = view2.findViewById(R.id.commodity_tail_text_mask);
            view2.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            view2 = view;
        }
        cVar.f66724d.U(vVar.f53816i, 10, false);
        if (TextUtils.isEmpty(vVar.j)) {
            cVar.f66723c.setVisibility(8);
            cVar.f66725e.setMaxLines(2);
        } else {
            cVar.f66723c.setVisibility(0);
            cVar.f66725e.setMaxLines(1);
        }
        if (TextUtils.isEmpty(vVar.j)) {
            cVar.f66727g.setVisibility(8);
        } else {
            cVar.f66727g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), vVar.j));
            cVar.f66727g.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(vVar.p)) {
            spannableStringBuilder.append((CharSequence) vVar.p);
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i3 = R.color.CAM_X0305;
            int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g7 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            d.a.m0.r.f0.b bVar = new d.a.m0.r.f0.b(g2, -1, i3, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar.b(g3);
            bVar.h(g6);
            bVar.i(g7);
            spannableStringBuilder.setSpan(bVar, 0, vVar.p.length(), 17);
        }
        if (!vVar.r && vVar.f53813f != 2 && !vVar.m) {
            String str = vVar.k;
            if (str != null) {
                spannableStringBuilder.append((CharSequence) str);
            }
            cVar.f66725e.setMaxLines(1);
        } else {
            String str2 = vVar.f53814g;
            if (str2 != null) {
                spannableStringBuilder.append((CharSequence) str2);
            }
        }
        cVar.f66725e.setText(spannableStringBuilder);
        cVar.f66726f.setOnClickListener(new a(i2));
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        View view3 = cVar.f66721a;
        int i4 = R.color.CAM_X0205;
        SkinManager.setBackgroundShapeDrawable(view3, 0, i4, i4);
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(cVar.f66722b);
        d2.m(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        cVar.f66726f.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(cVar.f66725e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(cVar.f66727g, R.color.CAM_X0305);
        SkinManager.setViewTextColor(cVar.f66728h, R.color.CAM_X0109);
        SkinManager.setBackgroundColorToTransparent(cVar.f66729i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view2;
    }

    public void h() {
        c();
        notifyDataSetChanged();
    }

    public void i(LinkedList<d.a.m0.r.f0.p.a> linkedList) {
        this.f66716f = linkedList;
    }

    public void j(b bVar) {
        this.f66718h = bVar;
    }
}
