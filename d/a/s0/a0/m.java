package d.a.s0.a0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        d.a.s0.h3.n0.d readThreadHistory;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, str) == null) || StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || readThreadHistory.b(str)) {
            return;
        }
        readThreadHistory.a(str);
    }

    public static void b(b2 b2Var, SpannableStringBuilder spannableStringBuilder, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65537, null, b2Var, spannableStringBuilder, z) == null) || spannableStringBuilder == null || d.a.c.e.p.k.isEmptyStringAfterTrim(spannableStringBuilder.toString()) || b2Var == null || b2Var.m0() != 0) {
            return;
        }
        if (z || b2Var.j0() == 1 || StringUtils.isNull(b2Var.getTitle())) {
            ArrayList<d.a.r0.b1.m.b> H0 = b2Var.H0();
            if (ListUtils.isEmpty(H0)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < H0.size(); i2++) {
                if (H0.get(i2) != null && !StringUtils.isNull(H0.get(i2).a())) {
                    sb.append(H0.get(i2).a());
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            int i3 = 0;
            for (int i4 = 0; i4 < H0.size(); i4++) {
                if (H0.get(i4) != null && !StringUtils.isNull(H0.get(i4).a())) {
                    int length = H0.get(i4).a().length();
                    c(spannableString, H0.get(i4), i3, length);
                    i3 += length;
                }
            }
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
        }
    }

    public static void c(SpannableString spannableString, d.a.r0.b1.m.b bVar, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65538, null, spannableString, bVar, i2, i3) == null) || spannableString == null || bVar == null || (i4 = i3 + i2) > spannableString.length()) {
            return;
        }
        spannableString.setSpan(new d.a.r0.b1.m.c(bVar), i2, i4, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(bVar.f55027i), i2, i4, 33);
    }

    public static SpannableStringBuilder d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? String.valueOf(System.currentTimeMillis() / 1000) : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? "frs_page" : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? "personalize_page" : (String) invokeV.objValue;
    }

    public static SpannableStringBuilder h(Context context, String str, ArrayList<a> arrayList, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, str, arrayList, Boolean.valueOf(z)})) == null) ? i(context, str, arrayList, z, true) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static SpannableStringBuilder i(Context context, String str, ArrayList<a> arrayList, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, str, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (str == null || context == null || arrayList == null) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 != arrayList.size(); i2++) {
                a aVar = arrayList.get(i2);
                if (aVar != null) {
                    int i3 = aVar.f57120a;
                    if (i3 > 0) {
                        aVar.f57121b = context.getString(i3);
                    }
                    if (!d.a.c.e.p.k.isEmpty(aVar.f57121b)) {
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) aVar.f57121b);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(aVar.f57122c)), length, spannableStringBuilder.length(), 17);
                        if (i2 == arrayList.size() - 1 && !z2) {
                            break;
                        }
                        Bitmap bitmap = SkinManager.getBitmap(aVar.f57123d);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                        if (bitmap != null) {
                            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        }
                        d.a.r0.r.f0.i iVar = new d.a.r0.r.f0.i(bitmapDrawable);
                        int i4 = aVar.f57124e;
                        if (i4 != 0) {
                            iVar.b(i4);
                        }
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.setSpan(iVar, length2, spannableStringBuilder.length(), 17);
                    } else {
                        continue;
                    }
                }
            }
            if (z) {
                spannableStringBuilder.append((CharSequence) str);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static void j(b2 b2Var, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, b2Var, textView) == null) {
            if ((StringUtils.isNull(b2Var.getTitle()) && (b2Var.R0() == null || b2Var.R0().size() == 0)) || b2Var.j0() == 1) {
                b2Var.J2(false, true);
                if (b2Var.b1() != null && !StringUtils.isNull(b2Var.b1().toString())) {
                    textView.setVisibility(0);
                    textView.setText(b2Var.b1());
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            b2Var.p = 0;
            b2Var.J2(false, true);
            SpannableStringBuilder b1 = b2Var.b1();
            textView.setOnTouchListener(new d.a.s0.z3.i(b1));
            textView.setText(b1);
            l(textView, b2Var.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        d.a.s0.h3.n0.d readThreadHistory;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.d(str)) ? false : true : invokeL.booleanValue;
    }

    public static void l(TextView textView, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(65547, null, textView, str, i2, i3) == null) && (textView instanceof TextView)) {
            if (k(str) && TbSingleton.getInstance().isInFrs) {
                SkinManager.setViewTextColor(textView, i3);
            } else {
                SkinManager.setViewTextColor(textView, i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f57120a;

        /* renamed from: b  reason: collision with root package name */
        public String f57121b;

        /* renamed from: c  reason: collision with root package name */
        public int f57122c;

        /* renamed from: d  reason: collision with root package name */
        public int f57123d;

        /* renamed from: e  reason: collision with root package name */
        public int f57124e;

        public a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f57120a = -1;
            this.f57121b = "";
            this.f57122c = R.color.CAM_X0304;
            this.f57123d = R.drawable.pic_dot_title;
            this.f57124e = 0;
            this.f57120a = i2;
            this.f57122c = i3;
            this.f57123d = i4;
        }

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57120a = -1;
            this.f57121b = "";
            this.f57122c = R.color.CAM_X0304;
            this.f57123d = R.drawable.pic_dot_title;
            this.f57124e = 0;
            this.f57120a = i2;
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f57120a = -1;
            this.f57121b = "";
            this.f57122c = R.color.CAM_X0304;
            this.f57123d = R.drawable.pic_dot_title;
            this.f57124e = 0;
            this.f57121b = str;
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f57120a = -1;
            this.f57121b = "";
            this.f57122c = R.color.CAM_X0304;
            this.f57123d = R.drawable.pic_dot_title;
            this.f57124e = 0;
            this.f57121b = str;
            this.f57123d = i2;
        }
    }
}
