package d.a.o0.k1.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a extends d.a.n0.r.f0.r.b<d.a.n0.r.f0.r.d.a, C1476a> {

    /* renamed from: d  reason: collision with root package name */
    public Context f60614d;

    /* renamed from: d.a.o0.k1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1476a extends BdBaseViewPagerAdapter.a {

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f60615h;

        public C1476a(a aVar, View view) {
            super(view);
            if (view instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view;
                this.f60615h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.f60614d = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r.f0.r.b
    /* renamed from: g */
    public C1476a c(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.f60614d);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new C1476a(this, tbImageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r.f0.r.b
    /* renamed from: h */
    public View e(ViewGroup viewGroup, C1476a c1476a, d.a.n0.r.f0.r.d.a aVar) {
        c1476a.f60615h.U(aVar.b(), 17, false);
        return null;
    }
}
