package d.a.m0.b.g;

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
import d.a.c.e.p.l;
import d.a.m0.b.d;
import d.a.m0.r.q.a2;
/* loaded from: classes3.dex */
public final class b {
    public static int a() {
        return UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
    }

    public static void b(View view, int i2, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (d.V()) {
            marginLayoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), i3);
        } else {
            marginLayoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), i2);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static int c(int i2, int i3) {
        return d.V() ? i3 : i2;
    }

    public static void d(TextView textView) {
        if (textView == null) {
            return;
        }
        if (d.V()) {
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
        if (d.V()) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        }
    }

    public static void f(View view, int i2) {
        if (view == null) {
            return;
        }
        if (d.V()) {
            view.setBackgroundResource(R.drawable.bg_img_mask);
        } else if (i2 > 0) {
            view.setBackgroundResource(i2);
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
        int i2;
        int i3;
        if (iArr == null || iArr.length != 2 || a2Var == null || !d.V()) {
            return;
        }
        int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i4 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
        MediaData mediaData = (MediaData) ListUtils.getItem(a2Var.L0(), 0);
        if (mediaData == null || (i2 = mediaData.picWidth) <= 0 || (i3 = mediaData.picHeight) <= 0) {
            return;
        }
        if (i2 == i3) {
            iArr[0] = i4;
            iArr[1] = i4;
        } else if (i2 > i3) {
            iArr[0] = i4;
            iArr[1] = (i4 * 3) / 4;
        } else {
            iArr[0] = i4;
            iArr[1] = (i4 * 4) / 3;
        }
    }

    public static int[] j(MediaData mediaData) {
        int i2;
        int[] iArr = new int[2];
        if (mediaData != null && d.V()) {
            int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i3 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
            int i4 = mediaData.picWidth;
            if (i4 > 0 && (i2 = mediaData.picHeight) > 0) {
                if (i4 == i2) {
                    iArr[0] = i3;
                    iArr[1] = i3;
                } else if (i4 > i2) {
                    iArr[0] = i3;
                    iArr[1] = (i3 * 3) / 4;
                } else {
                    iArr[0] = i3;
                    iArr[1] = (i3 * 4) / 3;
                }
            }
        }
        return iArr;
    }

    public static void k(TextView textView, int i2, int i3) {
        if (textView != null && Build.VERSION.SDK_INT >= 16) {
            if (d.V()) {
                textView.setLineSpacing(l.g(textView.getContext(), i3), textView.getLineSpacingMultiplier());
            } else {
                textView.setLineSpacing(l.g(textView.getContext(), i2), textView.getLineSpacingMultiplier());
            }
        }
    }

    public static boolean l(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2, int i3, boolean z) {
        if (layoutParams == null || layoutParams2 == null || !d.V()) {
            return z;
        }
        int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i4 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
        layoutParams2.width = (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44) * 2) + i4;
        int g2 = ((i4 * 4) / 3) + l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
        layoutParams2.height = g2;
        layoutParams.height = g2;
        return true;
    }

    public static boolean m(ViewGroup.LayoutParams layoutParams, boolean z, d.a.n0.k2.q.a aVar, int i2, int i3) {
        if (layoutParams == null || !d.V()) {
            return z;
        }
        int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        int i4 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
        layoutParams.width = i4;
        int i5 = (i4 * 4) / 3;
        layoutParams.height = i5;
        boolean z2 = (i4 == i2 && i5 == i3) ? false : true;
        if (aVar != null) {
            aVar.W(0);
        }
        return z2;
    }
}
