package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.i.u;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class m extends com.kwad.components.core.h.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String c = "奖励还差 %s 步到手，\n确认放弃吗？";
    public static String d = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public a b;

    /* loaded from: classes5.dex */
    public interface a extends e {
        void a(int i, int i2);

        void c();

        void d();
    }

    /* loaded from: classes5.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.components.ad.reward.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.m.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.m.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.m.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class c extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public com.kwad.components.ad.reward.g.a.a f;
        public com.kwad.components.ad.reward.g.kwai.a g;
        public String h;
        public String i;
        public String j;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static c a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
                c cVar = new c();
                cVar.a = 6;
                cVar.c = "残忍离开";
                cVar.d = "留下看看";
                cVar.d(j > 0 ? String.valueOf(j) : null);
                return cVar;
            }
            return (c) invokeJ.objValue;
        }

        public static c a(com.kwad.components.ad.reward.g.a.a aVar, AdTemplate adTemplate, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, aVar, adTemplate, str)) == null) {
                c cVar = new c();
                cVar.a = 1;
                cVar.f = aVar;
                cVar.e = str;
                cVar.h = com.kwad.sdk.core.response.a.a.aE(com.kwad.sdk.core.response.a.d.i(adTemplate));
                return cVar;
            }
            return (c) invokeLLL.objValue;
        }

        public static c a(com.kwad.components.ad.reward.g.kwai.a aVar, AdTemplate adTemplate, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, aVar, adTemplate, str)) == null) {
                c cVar = new c();
                cVar.a = 2;
                cVar.g = aVar;
                cVar.e = str;
                cVar.h = com.kwad.sdk.core.response.a.a.aE(com.kwad.sdk.core.response.a.d.i(adTemplate));
                return cVar;
            }
            return (c) invokeLLL.objValue;
        }

        public static c a(AdInfo adInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adInfo)) == null) {
                c cVar = new c();
                cVar.a = 3;
                cVar.b = com.kwad.sdk.core.response.a.a.aY(adInfo);
                cVar.h = com.kwad.sdk.core.response.a.a.aZ(adInfo);
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public static c a(AdInfo adInfo, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, adInfo, j)) == null) {
                c cVar = new c();
                cVar.a = 5;
                AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(adInfo);
                cVar.i = com.kwad.sdk.core.response.a.a.z(adInfo);
                String name = bd.getName();
                cVar.b = name;
                if (TextUtils.isEmpty(name)) {
                    cVar.b = com.kwad.sdk.core.response.a.a.B(adInfo);
                }
                cVar.h = bd.getIcon();
                cVar.d(j > 0 ? String.valueOf(j) : null);
                return cVar;
            }
            return (c) invokeLJ.objValue;
        }

        public static c a(AdTemplate adTemplate, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, adTemplate, j)) == null) {
                AdMatrixInfo.MerchantLiveReservationInfo C = com.kwad.sdk.core.response.a.b.C(adTemplate);
                c cVar = new c();
                cVar.a = 8;
                cVar.h = C.userHeadUrl;
                cVar.b = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
                cVar.i = C.title;
                cVar.c = "放弃奖励";
                cVar.d = "继续观看";
                return cVar;
            }
            return (c) invokeLJ.objValue;
        }

        public static c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
                c cVar = new c();
                cVar.a = 0;
                cVar.b = str;
                cVar.c = "关闭广告";
                cVar.d = "继续观看";
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public static c b(AdInfo adInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adInfo)) == null) {
                c cVar = new c();
                cVar.a = 4;
                AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(adInfo);
                cVar.b = com.kwad.sdk.core.response.a.a.z(adInfo);
                cVar.h = bd.getIcon();
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public static c b(AdInfo adInfo, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65545, null, adInfo, j)) == null) {
                c cVar = new c();
                cVar.a = 7;
                cVar.i = com.kwad.sdk.core.response.a.a.z(adInfo);
                cVar.b = com.kwad.sdk.core.response.a.a.aC(adInfo);
                cVar.h = com.kwad.sdk.core.response.a.a.aE(adInfo);
                cVar.d(j > 0 ? String.valueOf(j) : null);
                return cVar;
            }
            return (c) invokeLJ.objValue;
        }

        public static c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
                c cVar = new c();
                cVar.a = 0;
                cVar.b = str;
                cVar.c = "奖励不要了";
                cVar.d = "返回";
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public static c c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
                c cVar = new c();
                try {
                    cVar.parseJson(new JSONObject(str));
                } catch (JSONException unused) {
                }
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        private void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
                this.j = str;
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                super.afterParseJson(jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
                if (optJSONObject != null) {
                    if (this.f == null) {
                        this.f = new com.kwad.components.ad.reward.g.a.a();
                    }
                    this.f.parseJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
                if (optJSONObject2 != null) {
                    if (this.g == null) {
                        this.g = new com.kwad.components.ad.reward.g.kwai.a();
                    }
                    this.g.parseJson(optJSONObject2);
                }
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                super.afterToJson(jSONObject);
                com.kwad.components.ad.reward.g.a.a aVar = this.f;
                if (aVar != null) {
                    com.kwad.sdk.utils.r.a(jSONObject, "mLaunchAppTask", aVar);
                }
                com.kwad.components.ad.reward.g.kwai.a aVar2 = this.g;
                if (aVar2 != null) {
                    com.kwad.sdk.utils.r.a(jSONObject, "mLandPageOpenTask", aVar2);
                }
            }
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.isEmpty(this.c) ? "关闭广告" : this.c : (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.isEmpty(this.d) ? "继续观看" : this.d : (String) invokeV.objValue;
        }

        public final com.kwad.components.ad.reward.g.a.a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (com.kwad.components.ad.reward.g.a.a) invokeV.objValue;
        }

        public final com.kwad.components.ad.reward.g.kwai.a f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : (com.kwad.components.ad.reward.g.kwai.a) invokeV.objValue;
        }

        public final String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (String) invokeV.objValue;
        }

        public final String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.i : (String) invokeV.objValue;
        }

        public final String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TextUtils.isEmpty(this.j) ? "" : String.format("再看%s秒，可获得优惠", this.j) : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(608672341, "Lcom/kwad/components/ad/reward/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(608672341, "Lcom/kwad/components/ad/reward/m;");
        }
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static SpannableString a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.a(context, (int) R.color.obfuscated_res_0x7f06075f));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.a(context, (int) R.color.obfuscated_res_0x7f06075f));
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableString.length();
            spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
            spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
            spannableString.setSpan(styleSpan, 0, length, 34);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, a aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, dialogFragment, layoutInflater, viewGroup, cVar, aVar)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0472, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911b8)).setText(cVar.b());
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091019);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09101c);
            textView.setText(cVar.c());
            textView2.setText(cVar.d());
            textView.setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.m.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.a(false);
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.m.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeLLLLL.objValue;
    }

    public static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar})) == null) ? a(cVar.e(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar) : (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x005e: INVOKE  (r6v1 int A[REMOVE]) = (r6v0 com.kwad.components.ad.reward.g.a) type: VIRTUAL call: com.kwad.components.ad.reward.g.a.b():int)] */
    public static View a(com.kwad.components.ad.reward.g.a aVar, DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{aVar, dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar2})) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d045f, viewGroup, false);
            if (aVar instanceof com.kwad.components.ad.reward.g.a.a) {
                com.kwad.components.ad.reward.g.a.a.a((com.kwad.components.ad.reward.g.a.a) aVar, inflate.getContext(), adTemplate);
            }
            ((RewardTaskStepView) inflate.findViewById(R.id.obfuscated_res_0x7f091171)).a(aVar.a(), cVar.e);
            KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091170), cVar.g(), adTemplate, 12);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09116e);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09116f);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091172);
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.b());
            String sb2 = sb.toString();
            String str = cVar.e;
            boolean equals = "0".equals(str);
            String format = equals ? String.format(c, sb2) : String.format(d, str);
            int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
            if (indexOf < 0) {
                textView3.setText(format);
            } else {
                int i = equals ? indexOf + 1 : str.length() > 1 ? indexOf + 3 : indexOf + 2;
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06075f));
                SpannableString spannableString = new SpannableString(format);
                spannableString.setSpan(foregroundColorSpan, indexOf, i, 17);
                textView3.setText(spannableString);
            }
            textView.setOnClickListener(new View.OnClickListener(dialogFragment, aVar2) { // from class: com.kwad.components.ad.reward.m.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar3 = this.b;
                        if (aVar3 != null) {
                            aVar3.a(false);
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(dialogFragment, aVar2) { // from class: com.kwad.components.ad.reward.m.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar3 = this.b;
                        if (aVar3 != null) {
                            aVar3.b();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    private View a(m mVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, a aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65542, this, mVar, layoutInflater, viewGroup, cVar, aVar)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0473, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910fa)).setText(a(inflate.getContext(), cVar.j));
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910f8);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910f7);
            textView.setText(cVar.c());
            textView2.setText(cVar.d());
            textView.setOnClickListener(new View.OnClickListener(this, mVar, aVar) { // from class: com.kwad.components.ad.reward.m.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;
                public final /* synthetic */ a b;
                public final /* synthetic */ m c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mVar, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = mVar;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.a(false);
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(this, mVar, aVar) { // from class: com.kwad.components.ad.reward.m.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;
                public final /* synthetic */ a b;
                public final /* synthetic */ m c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mVar, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = mVar;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeLLLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(l lVar, @Nullable String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65543, null, lVar, str)) != null) {
            return (c) invokeLL.objValue;
        }
        AdTemplate adTemplate = lVar.g;
        AdInfo i2 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        com.kwad.components.ad.reward.h.a aVar = lVar.j;
        com.kwad.components.ad.reward.g.a.a aVar2 = lVar.B;
        com.kwad.components.ad.reward.g.kwai.a aVar3 = lVar.C;
        int i3 = lVar.D;
        boolean a2 = com.kwad.sdk.core.response.a.d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(com.kwad.sdk.core.response.a.d.i(adTemplate)));
        boolean a3 = com.kwad.components.ad.reward.kwai.b.a(i2);
        boolean aU = com.kwad.sdk.core.response.a.a.aU(i2);
        if (a2 || com.kwad.sdk.core.response.a.d.q(adTemplate)) {
            int o = (int) com.kwad.sdk.core.response.a.a.o(i2);
            int c2 = com.kwad.sdk.core.response.a.a.c(i2);
            if (o > c2) {
                o = c2;
            }
            if (aVar.i() < (o * 1000) + ErrorCode.CLIENT_CANCEL_REQUEST) {
                i = o - ((int) ((((float) aVar.i()) / 1000.0f) + 0.5f));
                return (a2 || aVar2 == null) ? (com.kwad.sdk.core.response.a.d.q(adTemplate) || aVar3 == null) ? (a3 || aU) ? !com.kwad.components.ad.reward.kwai.b.b(i2) ? c.b(i2) : (com.kwad.sdk.core.response.a.a.aV(i2) && com.kwad.components.ad.reward.kwai.b.l() == 1) ? c.a(i2, i3) : com.kwad.sdk.core.response.a.a.aB(i2) ? c.b(str) : com.kwad.sdk.core.response.a.a.b(adTemplate) ? c.a(adTemplate, i3) : com.kwad.components.ad.reward.kwai.b.f() == 1 ? c.a(i3) : com.kwad.components.ad.reward.kwai.b.f() == 2 ? c.b(i2, i3) : c.a(str) : c.a(i2) : c.a(aVar3, adTemplate, String.valueOf(i)) : c.a(aVar2, adTemplate, String.valueOf(i));
            }
        }
        i = 0;
        if (a2) {
        }
    }

    public static m a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, activity, adTemplate, cVar, aVar)) == null) {
            m mVar = new m();
            Bundle bundle = new Bundle();
            bundle.putString("key_params_json", cVar.toJson().toString());
            bundle.putString("key_template_json", adTemplate.toJson().toString());
            mVar.setArguments(bundle);
            mVar.a(aVar);
            mVar.show(activity.getFragmentManager(), "videoCloseDialog");
            return mVar;
        }
        return (m) invokeLLLL.objValue;
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, a aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65546, null, dialogFragment, layoutInflater, viewGroup, cVar, aVar)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0453, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091105)).setText(cVar.b());
            inflate.findViewById(R.id.obfuscated_res_0x7f091101).setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.m.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    }
                }
            });
            inflate.findViewById(R.id.obfuscated_res_0x7f091103).setOnClickListener(new View.OnClickListener(aVar) { // from class: com.kwad.components.ad.reward.m.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || (aVar2 = this.a) == null) {
                        return;
                    }
                    aVar2.c();
                }
            });
            inflate.findViewById(R.id.obfuscated_res_0x7f091102).setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.a(false);
                        }
                    }
                }
            });
            KSImageLoader.loadCircleIcon((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091104), cVar.g(), inflate.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bc0));
            return inflate;
        }
        return (View) invokeLLLLL.objValue;
    }

    public static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar})) == null) ? a(cVar.f(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar) : (View) invokeCommon.objValue;
    }

    public static View c(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar})) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d045a, viewGroup, false);
            KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091150), cVar.h, adTemplate);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09114f)).setText(cVar.b());
            inflate.findViewById(R.id.obfuscated_res_0x7f09114c).setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.m.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    }
                }
            });
            inflate.findViewById(R.id.obfuscated_res_0x7f09114e).setOnClickListener(new View.OnClickListener(aVar) { // from class: com.kwad.components.ad.reward.m.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || (aVar2 = this.a) == null) {
                        return;
                    }
                    aVar2.d();
                }
            });
            inflate.findViewById(R.id.obfuscated_res_0x7f09114d).setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.m.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogFragment;
                    this.b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        a aVar2 = this.b;
                        if (aVar2 != null) {
                            aVar2.a(false);
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.kwad.components.core.h.e
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        View a2;
        com.kwad.components.core.widget.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            Bundle arguments = getArguments();
            String string = arguments.getString("key_params_json");
            try {
                String string2 = arguments.getString("key_template_json");
                AdTemplate adTemplate = new AdTemplate();
                this.a = adTemplate;
                adTemplate.parseJson(new JSONObject(string2));
            } catch (Throwable unused) {
            }
            c c2 = c.c(string);
            switch (c2.a()) {
                case 1:
                    a2 = a(this, layoutInflater, viewGroup, c2, this.a, this.b);
                    break;
                case 2:
                    a2 = b(this, layoutInflater, viewGroup, c2, this.a, this.b);
                    break;
                case 3:
                    a2 = b(this, layoutInflater, viewGroup, c2, this.b);
                    fVar = new com.kwad.components.core.widget.f();
                    com.kwad.components.core.l.j.a(fVar, (ViewGroup) a2);
                    break;
                case 4:
                    a2 = c(this, layoutInflater, viewGroup, c2, this.a, this.b);
                    fVar = new com.kwad.components.core.widget.f();
                    com.kwad.components.core.l.j.a(fVar, (ViewGroup) a2);
                    break;
                case 5:
                    com.kwad.components.ad.reward.i.k kVar = new com.kwad.components.ad.reward.i.k(this, this.a, layoutInflater, viewGroup, this.b);
                    kVar.a(c2);
                    a2 = kVar.a();
                    break;
                case 6:
                    a2 = a(this, layoutInflater, viewGroup, c2, this.b);
                    break;
                case 7:
                    u uVar = new u(this, this.a, layoutInflater, viewGroup, this.b);
                    uVar.a(c2);
                    a2 = uVar.a();
                    break;
                case 8:
                    com.kwad.components.ad.reward.i.n nVar = new com.kwad.components.ad.reward.i.n(this, layoutInflater, viewGroup, this.b);
                    nVar.a(c2);
                    a2 = nVar.a();
                    break;
                default:
                    a2 = a((DialogFragment) this, layoutInflater, viewGroup, c2, this.b);
                    break;
            }
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.ad.reward.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                }
            });
            return a2;
        }
        return (View) invokeLL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Window window = getDialog().getWindow();
            if (window == null) {
                return;
            }
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
