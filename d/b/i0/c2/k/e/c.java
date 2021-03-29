package d.b.i0.c2.k.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends d.b.h0.b1.m.a {
    public static double H = 0.5d;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.g {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            float f2;
            float f3;
            if (tbImageView == null || tbImageView.getImageMatrix() == null || tbImageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                return;
            }
            Matrix imageMatrix = tbImageView.getImageMatrix();
            d.b.b.j.d.a l = d.b.h0.a0.c.j().l(d.b.b.e.l.d.h().g(tbImageView.getUrl(), c.this.r ? 17 : 18));
            int i2 = 0;
            if (l != null) {
                i2 = l.r();
                i = l.m();
            } else {
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            if (i2 * height > width * i) {
                f2 = height;
                f3 = i;
            } else {
                f2 = width;
                f3 = i2;
            }
            float f4 = f2 / f3;
            imageMatrix.setScale(f4, f4);
            imageMatrix.postTranslate(0.0f, 0.0f);
        }
    }

    public c(d.b.h0.b1.m.a aVar) {
        super(aVar);
        k(true);
        t();
        o(TbConfig.getPostLineSpace(), 1.0f);
        y(0);
        l(d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        m(d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        i(d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        r(d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        j(d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        this.D = d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.E = d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.F = new a();
    }

    @Override // d.b.h0.b1.m.a
    public int[] e(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
            return null;
        }
        if (this.s) {
            float f2 = d.b.h0.b1.m.a.G;
            if (f2 > 1.0f) {
                float f3 = i;
                if (f3 * f2 <= i3 * H) {
                    i3 = (int) (f3 * f2);
                }
                i2 = (i2 * i3) / i;
                if (i2 > 4096) {
                    this.p = ImageView.ScaleType.MATRIX;
                    i = i3;
                    i2 = 4096;
                } else {
                    this.p = ImageView.ScaleType.CENTER_CROP;
                    i = i3;
                }
            }
        }
        return new int[]{i, i2};
    }
}
