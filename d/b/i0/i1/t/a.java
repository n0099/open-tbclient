package d.b.i0.i1.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a extends d.b.h0.r.f0.r.b<d.b.h0.r.f0.r.d.a, C1307a> {

    /* renamed from: d  reason: collision with root package name */
    public Context f56070d;

    /* renamed from: d.b.i0.i1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1307a extends BdBaseViewPagerAdapter.a {

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f56071h;

        public C1307a(a aVar, View view) {
            super(view);
            if (view instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view;
                this.f56071h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.f56070d = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.r.f0.r.b
    /* renamed from: g */
    public C1307a c(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.f56070d);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new C1307a(this, tbImageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.r.f0.r.b
    /* renamed from: h */
    public View e(ViewGroup viewGroup, C1307a c1307a, d.b.h0.r.f0.r.d.a aVar) {
        c1307a.f56071h.W(aVar.a(), 17, false);
        return null;
    }
}
