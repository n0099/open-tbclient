package d.a.o0.e2.k.e;

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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f57236a = {R.string.reply_hint_text_1, R.string.reply_hint_text_2, R.string.reply_hint_text_3};

    /* renamed from: b  reason: collision with root package name */
    public static TextView f57237b;

    public static boolean a(d.a.n0.t.a aVar, int i2) {
        if (aVar == null) {
            return false;
        }
        try {
            if (i2 == 2) {
                int k = d.a.n0.r.d0.b.j().k("key_pb_commont_egg_limlit_a", 0);
                if (TbSingleton.getInstance().getAdVertiSementData() != null && k < TbSingleton.getInstance().getAdVertiSementData().a()) {
                    d.a.n0.r.d0.b.j().v("key_pb_commont_egg_limlit_a", k + 1);
                    return true;
                }
            } else {
                String p = d.a.n0.r.d0.b.j().p("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
                if (!TextUtils.isEmpty(aVar.b())) {
                    JSONObject jSONObject = new JSONObject(p);
                    JSONArray jSONArray = new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray(aVar.b());
                    if (optJSONArray != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            long optLong = optJSONArray.optLong(i3);
                            if (StringHelper.isTaday(optLong)) {
                                jSONArray.put(optLong);
                            }
                        }
                    }
                    if (jSONArray.length() < TbSingleton.getInstance().getAdVertiSementData().b()) {
                        jSONArray.put(System.currentTimeMillis());
                        jSONObject.remove(aVar.b());
                        jSONObject.put(aVar.b(), jSONArray);
                        d.a.n0.r.d0.b.j().x("key_pb_commont_egg_limlit_bc", jSONObject.toString());
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int b() {
        return f57236a[new Random().nextInt(f57236a.length)];
    }

    public static SpannableString c(a2 a2Var) {
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
        spannableString.setSpan(new d.a.n0.r.f0.o.a(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
        return spannableString;
    }

    public static String d(String str) {
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)});
    }

    public static Intent e(Context context, String str) {
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

    public static int f() {
        return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
    }

    public static String g(int i2, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i2, objArr);
    }

    public static int h(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().o2()) {
            return (ListUtils.isEmpty(eVar.p()) && (eVar.h() == null || StringUtils.isNull(eVar.h().h()))) ? 0 : 2;
        }
        return 1;
    }

    public static Layout i(SpannableStringBuilder spannableStringBuilder) {
        Context context = TbadkCoreApplication.getInst().getContext();
        int k = d.a.c.e.p.l.k(context) - (d.a.c.e.p.l.g(context, R.dimen.tbds44) * 2);
        int contentSize = TbConfig.getContentSize();
        try {
            if (f57237b == null) {
                f57237b = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = f57237b;
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

    public static void j(TextView textView) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
    }
}
