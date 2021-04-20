package d.b.h0.b.g;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.b.d;
import d.b.h0.r.q.a2;
/* loaded from: classes3.dex */
public final class b {
    public static int a() {
        return UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
    }

    public static void b(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (d.T()) {
            marginLayoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), i2);
        } else {
            marginLayoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), i);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static int c(int i, int i2) {
        return d.T() ? i2 : i;
    }

    public static void d(TextView textView) {
        if (textView == null) {
            return;
        }
        if (d.T()) {
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds39));
            return;
        }
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds42));
    }

    public static void e(TextView textView) {
        if (textView == null) {
            return;
        }
        if (d.T()) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        }
    }

    public static void f(View view, int i) {
        if (view == null) {
            return;
        }
        if (d.T()) {
            view.setBackgroundResource(R.drawable.bg_img_mask);
        } else if (i > 0) {
            view.setBackgroundResource(i);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public static void g(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        marginLayoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        view.setLayoutParams(marginLayoutParams);
    }

    public static void h(View view) {
        if (view == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0202);
    }

    public static void i(a2 a2Var, int[] iArr) {
        int i;
        int i2;
        if (iArr == null || iArr.length != 2 || a2Var == null || !d.T()) {
            return;
        }
        int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i3 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
        MediaData mediaData = (MediaData) ListUtils.getItem(a2Var.K0(), 0);
        if (mediaData == null || (i = mediaData.picWidth) <= 0 || (i2 = mediaData.picHeight) <= 0) {
            return;
        }
        if (i == i2) {
            iArr[0] = i3;
            iArr[1] = i3;
        } else if (i > i2) {
            iArr[0] = i3;
            iArr[1] = (i3 * 3) / 4;
        } else {
            iArr[0] = i3;
            iArr[1] = (i3 * 4) / 3;
        }
    }

    public static int[] j(MediaData mediaData) {
        int i;
        int[] iArr = new int[2];
        if (mediaData != null && d.T()) {
            int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i2 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
            int i3 = mediaData.picWidth;
            if (i3 > 0 && (i = mediaData.picHeight) > 0) {
                if (i3 == i) {
                    iArr[0] = i2;
                    iArr[1] = i2;
                } else if (i3 > i) {
                    iArr[0] = i2;
                    iArr[1] = (i2 * 3) / 4;
                } else {
                    iArr[0] = i2;
                    iArr[1] = (i2 * 4) / 3;
                }
            }
        }
        return iArr;
    }

    public static void k(TextView textView, int i, int i2) {
        if (textView != null && Build.VERSION.SDK_INT >= 16) {
            if (d.T()) {
                textView.setLineSpacing(l.g(textView.getContext(), i2), textView.getLineSpacingMultiplier());
            } else {
                textView.setLineSpacing(l.g(textView.getContext(), i), textView.getLineSpacingMultiplier());
            }
        }
    }

    public static boolean l(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i, int i2, boolean z) {
        if (layoutParams == null || layoutParams2 == null || !d.T()) {
            return z;
        }
        int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i3 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
        layoutParams2.width = (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44) * 2) + i3;
        int g2 = ((i3 * 4) / 3) + l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
        layoutParams2.height = g2;
        layoutParams.height = g2;
        return true;
    }

    public static boolean m(ViewGroup.LayoutParams layoutParams, boolean z, d.b.i0.j2.q.a aVar, int i, int i2) {
        if (layoutParams == null || !d.T()) {
            return z;
        }
        int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        int i3 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
        layoutParams.width = i3;
        int i4 = (i3 * 4) / 3;
        layoutParams.height = i4;
        boolean z2 = (i3 == i && i4 == i2) ? false : true;
        if (aVar != null) {
            aVar.t(0);
        }
        return z2;
    }
}
