package d.a.i0.r.w.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b implements d.a.i0.r.w.a {
    @Override // d.a.i0.r.w.a
    public c a() {
        c cVar = new c();
        cVar.c(R.drawable.icon_banner_n);
        cVar.g(R.drawable.icon_banner_s);
        cVar.h(R.dimen.ds22);
        cVar.d(81);
        cVar.e(R.dimen.ds22);
        return cVar;
    }

    @Override // d.a.i0.r.w.a
    public View b() {
        return null;
    }

    @Override // d.a.i0.r.w.a
    public e c() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.getInst().getResources();
        if (resources != null) {
            eVar.a(resources.getDimensionPixelSize(R.dimen.ds330));
        }
        return eVar;
    }

    @Override // d.a.i0.r.w.a
    public TbImageView d(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }
}
