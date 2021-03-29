package d.b.i0.i1.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes3.dex */
public class a extends d.b.h0.r.f0.r.b<d.b.h0.r.f0.r.d.a, C1308a> {

    /* renamed from: d  reason: collision with root package name */
    public Context f56071d;

    /* renamed from: d.b.i0.i1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1308a extends BdBaseViewPagerAdapter.a {

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f56072h;

        public C1308a(a aVar, View view) {
            super(view);
            if (view instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view;
                this.f56072h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.f56071d = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.r.f0.r.b
    /* renamed from: g */
    public C1308a c(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.f56071d);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new C1308a(this, tbImageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.r.f0.r.b
    /* renamed from: h */
    public View e(ViewGroup viewGroup, C1308a c1308a, d.b.h0.r.f0.r.d.a aVar) {
        c1308a.f56072h.W(aVar.a(), 17, false);
        return null;
    }
}
