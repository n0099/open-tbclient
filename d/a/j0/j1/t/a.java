package d.a.j0.j1.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a extends d.a.i0.r.f0.r.b<d.a.i0.r.f0.r.d.a, C1326a> {

    /* renamed from: d  reason: collision with root package name */
    public Context f55913d;

    /* renamed from: d.a.j0.j1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1326a extends BdBaseViewPagerAdapter.a {

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f55914h;

        public C1326a(a aVar, View view) {
            super(view);
            if (view instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view;
                this.f55914h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.f55913d = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.r.f0.r.b
    /* renamed from: g */
    public C1326a c(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.f55913d);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new C1326a(this, tbImageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.r.f0.r.b
    /* renamed from: h */
    public View e(ViewGroup viewGroup, C1326a c1326a, d.a.i0.r.f0.r.d.a aVar) {
        c1326a.f55914h.V(aVar.c(), 17, false);
        return null;
    }
}
