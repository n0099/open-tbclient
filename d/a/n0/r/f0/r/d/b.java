package d.a.n0.r.f0.r.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes3.dex */
public class b extends d.a.n0.r.f0.r.b<d.a.n0.r.f0.r.d.a, a> {

    /* renamed from: d  reason: collision with root package name */
    public Context f53600d;

    /* loaded from: classes3.dex */
    public class a extends BdBaseViewPagerAdapter.a {

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f53601h;

        public a(b bVar, View view) {
            super(view);
            if (view instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view;
                this.f53601h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.f53600d = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r.f0.r.b
    /* renamed from: g */
    public a c(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.f53600d);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new a(this, tbImageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r.f0.r.b
    /* renamed from: h */
    public View e(ViewGroup viewGroup, a aVar, d.a.n0.r.f0.r.d.a aVar2) {
        aVar.f53601h.U(aVar2.b(), 10, false);
        return null;
    }
}
