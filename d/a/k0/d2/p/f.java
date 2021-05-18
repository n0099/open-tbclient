package d.a.k0.d2.p;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static SparseIntArray f53708a = new SparseIntArray();

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo == null || textView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        int b2 = b(R.dimen.ds32);
        if (z2 && z3) {
            layoutParams.setMargins(b2, b(R.dimen.ds8), b2, b(R.dimen.ds18));
        } else if (z) {
            layoutParams.setMargins(0, b(R.dimen.ds8), 0, 0);
        } else if (!z2) {
            layoutParams.setMargins(b(R.dimen.ds102), b(R.dimen.ds8), b(R.dimen.ds34), b(R.dimen.ds14));
        } else {
            layoutParams.setMargins(b2, b(R.dimen.ds8), b2, b(R.dimen.ds14));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "icon");
        spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_pb_tail);
        drawable.setBounds(0, 0, b2, b2);
        d.a.j0.b1.d dVar = new d.a.j0.b1.d(drawable);
        dVar.c(b(R.dimen.ds4));
        spannableStringBuilder.setSpan(dVar, 0, 4, 33);
        textView.setLayoutParams(layoutParams);
        textView.setText(spannableStringBuilder);
        textView.setTextColor(smallTailInfo.showColorId);
        textView.setVisibility(0);
    }

    public static int b(int i2) {
        int i3 = f53708a.get(i2, -1);
        if (i3 == -1) {
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), i2);
            f53708a.put(i2, g2);
            return g2;
        }
        return i3;
    }

    public static void c(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        SpannableString spannableString;
        if (smallTailInfo == null || (spannableString = smallTailInfo.tailSpannable) == null || spannableString.length() == 0 || textView == null) {
            return;
        }
        smallTailInfo.updateShowInfo();
        a(smallTailInfo, textView, z, z2, z3);
    }
}
