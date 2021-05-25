package d.a.n0.k1.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a extends d.a.m0.r.f0.r.b<d.a.m0.r.f0.r.d.a, C1416a> {

    /* renamed from: d  reason: collision with root package name */
    public Context f56800d;

    /* renamed from: d.a.n0.k1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1416a extends BdBaseViewPagerAdapter.a {

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f56801h;

        public C1416a(a aVar, View view) {
            super(view);
            if (view instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view;
                this.f56801h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.f56800d = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.r.f0.r.b
    /* renamed from: g */
    public C1416a c(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.f56800d);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new C1416a(this, tbImageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.r.f0.r.b
    /* renamed from: h */
    public View e(ViewGroup viewGroup, C1416a c1416a, d.a.m0.r.f0.r.d.a aVar) {
        c1416a.f56801h.V(aVar.c(), 17, false);
        return null;
    }
}
