package d.b.i0.c2.k.e;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import java.util.Random;
/* loaded from: classes4.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f52750a = {R.string.reply_hint_text_1, R.string.reply_hint_text_2, R.string.reply_hint_text_3};

    /* renamed from: b  reason: collision with root package name */
    public static TextView f52751b;

    public static int a() {
        return f52750a[new Random().nextInt(f52750a.length)];
    }

    public static SpannableString b(a2 a2Var) {
        String string;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.U() == 1) {
            string = TbadkCoreApplication.getInst().getString(R.string.yuanchuang);
        } else {
            string = a2Var.U() == 2 ? TbadkCoreApplication.getInst().getString(R.string.shoufa) : "";
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(new StringBuilder(string).toString());
        spannableString.setSpan(new d.b.h0.r.f0.o.a(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
        return spannableString;
    }

    public static String c(String str) {
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)});
    }

    public static Intent d(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        intent.putExtra("key_start_from", 5);
        return intent;
    }

    public static int e() {
        return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
    }

    public static String f(int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    public static int g(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().k2()) {
            return (ListUtils.isEmpty(eVar.p()) && (eVar.h() == null || StringUtils.isNull(eVar.h().i()))) ? 0 : 2;
        }
        return 1;
    }

    public static Layout h(SpannableStringBuilder spannableStringBuilder) {
        Context context = TbadkCoreApplication.getInst().getContext();
        int k = d.b.b.e.p.l.k(context) - (d.b.b.e.p.l.g(context, R.dimen.tbds44) * 2);
        int contentSize = TbConfig.getContentSize();
        try {
            if (f52751b == null) {
                f52751b = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = f52751b;
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            textView.setText(spannableStringBuilder);
            textView.setTextSize(0, contentSize);
            textView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            textView.getPaint().setFakeBoldText(true);
            textView.measure(View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            return textView.getLayout();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void i(TextView textView) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
    }
}
