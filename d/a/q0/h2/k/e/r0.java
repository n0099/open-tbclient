package d.a.q0.h2.k.e;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.s.q.b2;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f57991a;

    /* renamed from: b  reason: collision with root package name */
    public static TextView f57992b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1844556555, "Ld/a/q0/h2/k/e/r0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1844556555, "Ld/a/q0/h2/k/e/r0;");
                return;
            }
        }
        f57991a = new int[]{R.string.reply_hint_text_1, R.string.reply_hint_text_2, R.string.reply_hint_text_3};
    }

    public static boolean a(d.a.p0.u.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, aVar, i2)) == null) {
            if (aVar == null) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int k = d.a.p0.s.d0.b.j().k("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && k < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        d.a.p0.s.d0.b.j().v("key_pb_commont_egg_limlit_a", k + 1);
                        return true;
                    }
                } else {
                    String p = d.a.p0.s.d0.b.j().p("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
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
                            d.a.p0.s.d0.b.j().x("key_pb_commont_egg_limlit_bc", jSONObject.toString());
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f57991a[new Random().nextInt(f57991a.length)] : invokeV.intValue;
    }

    public static SpannableString c(b2 b2Var) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            if (b2Var.I() == 1) {
                string = TbadkCoreApplication.getInst().getString(R.string.yuanchuang);
            } else {
                string = b2Var.I() == 2 ? TbadkCoreApplication.getInst().getString(R.string.shoufa) : "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(string).toString());
            spannableString.setSpan(new d.a.p0.s.f0.r.a(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)}) : (String) invokeL.objValue;
    }

    public static Intent e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
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
        return (Intent) invokeLL.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.tbds88) : invokeV.intValue;
    }

    public static String g(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i2, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public static int h(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return 0;
            }
            if (eVar.N().c2()) {
                return (ListUtils.isEmpty(eVar.q()) && (eVar.h() == null || StringUtils.isNull(eVar.h().g()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static Layout i(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, spannableStringBuilder)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int k = d.a.d.e.p.l.k(context) - (d.a.d.e.p.l.g(context, R.dimen.tbds44) * 2);
            int contentSize = TbConfig.getContentSize();
            try {
                if (f57992b == null) {
                    f57992b = new TextView(TbadkCoreApplication.getInst().getContext());
                }
                TextView textView = f57992b;
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
        return (Layout) invokeL.objValue;
    }

    public static void j(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, textView) == null) || textView == null) {
            return;
        }
        textView.getPaint().setFakeBoldText(true);
    }
}
