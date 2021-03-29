package d.b.i0.u3.v;

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
import d.b.b.e.p.l;
import d.b.h0.r.q.v;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f61765e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<d.b.h0.r.f0.p.a> f61766f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<v> f61767g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public b f61768h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61769e;

        public a(int i) {
            this.f61769e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.f0.p.a g2 = d.this.g(this.f61769e);
            if (g2 == null) {
                return;
            }
            if (d.this.f61768h != null) {
                d.this.f61768h.b(g2.e());
            }
            if (d.this.f61768h != null) {
                d.this.f61768h.a(d.this.f61767g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<v> list);

        void b(int i);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f61771a;

        /* renamed from: b  reason: collision with root package name */
        public View f61772b;

        /* renamed from: c  reason: collision with root package name */
        public View f61773c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f61774d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61775e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f61776f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61777g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61778h;
        public View i;

        public c(d dVar) {
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(TbPageContext tbPageContext) {
        this.f61765e = tbPageContext;
    }

    public final void c() {
        this.f61767g.clear();
        if (ListUtils.isEmpty(this.f61766f)) {
            return;
        }
        Iterator<d.b.h0.r.f0.p.a> it = this.f61766f.iterator();
        while (it.hasNext()) {
            d.b.h0.r.f0.p.a next = it.next();
            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.t() != null) {
                    v t = tbLinkSpanGroup.t();
                    t.t = tbLinkSpanGroup.f();
                    this.f61767g.add(t);
                }
            }
        }
        Collections.sort(this.f61767g);
    }

    public LinkedList<v> d() {
        return this.f61767g;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        if (ListUtils.isEmpty(this.f61767g)) {
            return true;
        }
        Iterator<v> it = this.f61767g.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.f50898f == 2 || !next.m) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    public LinkedList<d.b.h0.r.f0.p.a> f() {
        return this.f61766f;
    }

    public d.b.h0.r.f0.p.a g(int i) {
        LinkedList<d.b.h0.r.f0.p.a> linkedList;
        long itemId = getItemId(i);
        if (itemId != 0 && (linkedList = this.f61766f) != null) {
            Iterator<d.b.h0.r.f0.p.a> it = linkedList.iterator();
            while (it.hasNext()) {
                d.b.h0.r.f0.p.a next = it.next();
                if (next.e() == itemId) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<v> linkedList = this.f61767g;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        LinkedList<v> linkedList = this.f61767g;
        if (linkedList == null || linkedList.size() <= i) {
            return null;
        }
        return this.f61767g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        LinkedList<v> linkedList = this.f61767g;
        return (linkedList == null || linkedList.size() <= i || this.f61767g.get(i) == null) ? 0 : this.f61767g.get(i).f50897e;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        View view2;
        v vVar = (v) getItem(i);
        if (vVar == null) {
            return null;
        }
        if (view == null) {
            view2 = LayoutInflater.from(this.f61765e.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
            cVar = new c(this, null);
            cVar.f61771a = view2.findViewById(R.id.commodity_root_view);
            cVar.f61772b = view2.findViewById(R.id.commodity_main_view);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.commodity_link_icon);
            cVar.f61774d = tbImageView;
            tbImageView.setConrers(15);
            cVar.f61774d.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            cVar.f61774d.setPlaceHolderAutoChangeSkinType(1);
            cVar.f61774d.setGifIconSupport(false);
            cVar.f61774d.setLongIconSupport(false);
            cVar.f61774d.setDrawBorder(true);
            cVar.f61774d.setBorderWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            cVar.f61774d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            cVar.f61775e = (TextView) view2.findViewById(R.id.commodity_link_content);
            cVar.f61776f = (ImageView) view2.findViewById(R.id.commodity_link_close_button);
            cVar.f61773c = view2.findViewById(R.id.extra_info_container);
            cVar.f61777g = (TextView) view2.findViewById(R.id.commodity_price);
            cVar.f61778h = (TextView) view2.findViewById(R.id.commodity_extra_infos);
            cVar.i = view2.findViewById(R.id.commodity_tail_text_mask);
            view2.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            view2 = view;
        }
        cVar.f61774d.W(vVar.i, 10, false);
        if (TextUtils.isEmpty(vVar.j)) {
            cVar.f61773c.setVisibility(8);
            cVar.f61775e.setMaxLines(2);
        } else {
            cVar.f61773c.setVisibility(0);
            cVar.f61775e.setMaxLines(1);
        }
        if (TextUtils.isEmpty(vVar.j)) {
            cVar.f61777g.setVisibility(8);
        } else {
            cVar.f61777g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), vVar.j));
            cVar.f61777g.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(vVar.p)) {
            spannableStringBuilder.append((CharSequence) vVar.p);
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0305;
            int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g7 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            d.b.h0.r.f0.b bVar = new d.b.h0.r.f0.b(g2, -1, i2, g4, i2, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar.b(g3);
            bVar.h(g6);
            bVar.i(g7);
            spannableStringBuilder.setSpan(bVar, 0, vVar.p.length(), 17);
        }
        if (!vVar.r && vVar.f50898f != 2 && !vVar.m) {
            String str = vVar.k;
            if (str != null) {
                spannableStringBuilder.append((CharSequence) str);
            }
            cVar.f61775e.setMaxLines(1);
        } else {
            String str2 = vVar.f50899g;
            if (str2 != null) {
                spannableStringBuilder.append((CharSequence) str2);
            }
        }
        cVar.f61775e.setText(spannableStringBuilder);
        cVar.f61776f.setOnClickListener(new a(i));
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        View view3 = cVar.f61771a;
        int i3 = R.color.CAM_X0205;
        SkinManager.setBackgroundShapeDrawable(view3, 0, i3, i3);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(cVar.f61772b);
        a2.h(R.string.J_X05);
        a2.c(R.color.CAM_X0206);
        cVar.f61776f.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(cVar.f61775e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(cVar.f61777g, R.color.CAM_X0305);
        SkinManager.setViewTextColor(cVar.f61778h, R.color.CAM_X0109);
        SkinManager.setBackgroundColorToTransparent(cVar.i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view2;
    }

    public void h() {
        c();
        notifyDataSetChanged();
    }

    public void i(LinkedList<d.b.h0.r.f0.p.a> linkedList) {
        this.f61766f = linkedList;
    }

    public void j(b bVar) {
        this.f61768h = bVar;
    }
}
