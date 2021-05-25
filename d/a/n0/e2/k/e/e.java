package d.a.n0.e2.k.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class e extends d.a.m0.b1.m.a {
    public static double H = 0.5d;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.g {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            if (tbImageView == null || tbImageView.getImageMatrix() == null || tbImageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                return;
            }
            Matrix imageMatrix = tbImageView.getImageMatrix();
            d.a.c.j.d.a m = d.a.m0.a0.c.k().m(d.a.c.e.l.d.h().g(tbImageView.getUrl(), e.this.r ? 17 : 18));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            if (i3 * height > width * i2) {
                f2 = height;
                f3 = i2;
            } else {
                f2 = width;
                f3 = i3;
            }
            float f4 = f2 / f3;
            imageMatrix.setScale(f4, f4);
            imageMatrix.postTranslate(0.0f, 0.0f);
        }
    }

    public e(d.a.m0.b1.m.a aVar) {
        super(aVar);
        k(true);
        t();
        o(TbConfig.getPostLineSpace(), 1.0f);
        y(0);
        l(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        i(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        r(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        j(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        this.D = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.E = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.F = new a();
    }

    @Override // d.a.m0.b1.m.a
    public int[] e(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || i2 <= 0 || i4 <= 0 || i5 <= 0) {
            return null;
        }
        if (this.s) {
            float f2 = d.a.m0.b1.m.a.G;
            if (f2 > 1.0f) {
                float f3 = i2;
                if (f3 * f2 <= i4 * H) {
                    i4 = (int) (f3 * f2);
                }
                i3 = (i3 * i4) / i2;
                if (i3 > 4096) {
                    this.p = ImageView.ScaleType.MATRIX;
                    i2 = i4;
                    i3 = 4096;
                } else {
                    this.p = ImageView.ScaleType.CENTER_CROP;
                    i2 = i4;
                }
            }
        }
        return new int[]{i2, i3};
    }
}
