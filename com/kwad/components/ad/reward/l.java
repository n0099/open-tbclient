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
import com.kwad.components.ad.reward.k.s;
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
/* loaded from: classes7.dex */
public final class l extends com.kwad.components.core.i.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ng = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    public static String nh = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public a nf;

    /* loaded from: classes7.dex */
    public interface a extends com.kwad.components.core.webview.b.d.c {
        void fJ();

        void g(int i, int i2);
    }

    /* loaded from: classes7.dex */
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

        @Override // com.kwad.components.core.webview.b.d.c
        public void G(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public void fH() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public void fI() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.l.a
        public void fJ() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.l.a
        public void g(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            }
        }
    }

    @KsJson
    /* loaded from: classes7.dex */
    public static class c extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String kY;
        public com.kwad.components.ad.reward.i.a.a mK;
        public com.kwad.components.ad.reward.i.kwai.a mL;
        public String nm;
        public String nn;
        public String no;
        public String np;
        public String nq;
        public int style;
        public String title;

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

        public static c M(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                c cVar = new c();
                cVar.style = 0;
                cVar.title = str;
                cVar.nm = "关闭广告";
                cVar.nn = "继续观看";
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public static c N(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                c cVar = new c();
                cVar.style = 0;
                cVar.title = str;
                cVar.nm = "奖励不要了";
                cVar.nn = "返回";
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public static c O(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                c cVar = new c();
                try {
                    cVar.parseJson(new JSONObject(str));
                } catch (JSONException unused) {
                }
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        private void P(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
                this.nq = str;
            }
        }

        public static c a(com.kwad.components.ad.reward.i.a.a aVar, AdTemplate adTemplate, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, aVar, adTemplate, str)) == null) {
                c cVar = new c();
                cVar.style = 1;
                cVar.mK = aVar;
                cVar.no = str;
                cVar.kY = com.kwad.sdk.core.response.a.a.bn(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
                return cVar;
            }
            return (c) invokeLLL.objValue;
        }

        public static c a(com.kwad.components.ad.reward.i.kwai.a aVar, AdTemplate adTemplate, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, aVar, adTemplate, str)) == null) {
                c cVar = new c();
                cVar.style = 2;
                cVar.mL = aVar;
                cVar.no = str;
                cVar.kY = com.kwad.sdk.core.response.a.a.bn(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
                return cVar;
            }
            return (c) invokeLLL.objValue;
        }

        public static c a(AdInfo adInfo, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, adInfo, j)) == null) {
                c cVar = new c();
                cVar.style = 5;
                AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
                cVar.np = com.kwad.sdk.core.response.a.a.ad(adInfo);
                String name = bN.getName();
                cVar.title = name;
                if (TextUtils.isEmpty(name)) {
                    cVar.title = com.kwad.sdk.core.response.a.a.af(adInfo);
                }
                cVar.kY = bN.getIcon();
                cVar.P(j > 0 ? String.valueOf(j) : null);
                return cVar;
            }
            return (c) invokeLJ.objValue;
        }

        public static c a(AdTemplate adTemplate, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65544, null, adTemplate, j)) == null) {
                AdMatrixInfo.MerchantLiveReservationInfo bA = com.kwad.sdk.core.response.a.b.bA(adTemplate);
                c cVar = new c();
                cVar.style = 8;
                cVar.kY = bA.userHeadUrl;
                cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
                cVar.np = bA.title;
                cVar.nm = "放弃奖励";
                cVar.nn = "继续观看";
                return cVar;
            }
            return (c) invokeLJ.objValue;
        }

        public static c b(AdInfo adInfo, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65545, null, adInfo, j)) == null) {
                c cVar = new c();
                cVar.style = 7;
                cVar.np = com.kwad.sdk.core.response.a.a.ad(adInfo);
                cVar.title = com.kwad.sdk.core.response.a.a.bl(adInfo);
                cVar.kY = com.kwad.sdk.core.response.a.a.bn(adInfo);
                cVar.P(j > 0 ? String.valueOf(j) : null);
                return cVar;
            }
            return (c) invokeLJ.objValue;
        }

        public static c f(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
                c cVar = new c();
                cVar.style = 6;
                cVar.nm = "残忍离开";
                cVar.nn = "留下看看";
                cVar.P(j > 0 ? String.valueOf(j) : null);
                return cVar;
            }
            return (c) invokeJ.objValue;
        }

        public static c g(AdInfo adInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adInfo)) == null) {
                c cVar = new c();
                cVar.style = 4;
                AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
                cVar.title = com.kwad.sdk.core.response.a.a.ad(adInfo);
                cVar.kY = bN.getIcon();
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                super.afterParseJson(jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
                if (optJSONObject != null) {
                    if (this.mK == null) {
                        this.mK = new com.kwad.components.ad.reward.i.a.a();
                    }
                    this.mK.parseJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
                if (optJSONObject2 != null) {
                    if (this.mL == null) {
                        this.mL = new com.kwad.components.ad.reward.i.kwai.a();
                    }
                    this.mL.parseJson(optJSONObject2);
                }
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                super.afterToJson(jSONObject);
                com.kwad.components.ad.reward.i.a.a aVar = this.mK;
                if (aVar != null) {
                    com.kwad.sdk.utils.r.a(jSONObject, "mLaunchAppTask", aVar);
                }
                com.kwad.components.ad.reward.i.kwai.a aVar2 = this.mL;
                if (aVar2 != null) {
                    com.kwad.sdk.utils.r.a(jSONObject, "mLandPageOpenTask", aVar2);
                }
            }
        }

        public final String eL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.kY : (String) invokeV.objValue;
        }

        public final String fK() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.nm) ? "关闭广告" : this.nm : (String) invokeV.objValue;
        }

        public final String fL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.isEmpty(this.nn) ? "继续观看" : this.nn : (String) invokeV.objValue;
        }

        public final com.kwad.components.ad.reward.i.a.a fM() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mK : (com.kwad.components.ad.reward.i.a.a) invokeV.objValue;
        }

        public final com.kwad.components.ad.reward.i.kwai.a fN() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mL : (com.kwad.components.ad.reward.i.kwai.a) invokeV.objValue;
        }

        public final String fO() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.np : (String) invokeV.objValue;
        }

        public final String fP() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TextUtils.isEmpty(this.nq) ? "" : String.format("再看%s秒，可获得优惠", this.nq) : (String) invokeV.objValue;
        }

        public final int getStyle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.style : invokeV.intValue;
        }

        public final String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.title : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(608672310, "Lcom/kwad/components/ad/reward/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(608672310, "Lcom/kwad/components/ad/reward/l;");
        }
    }

    public l() {
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

    public static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, a aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, dialogFragment, layoutInflater, viewGroup, cVar, aVar)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0475, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911eb)).setText(cVar.getTitle());
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091068);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09106b);
            textView.setText(cVar.fK());
            textView2.setText(cVar.fL());
            textView.setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.l.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment nj;
                public final /* synthetic */ a nk;

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
                    this.nj = dialogFragment;
                    this.nk = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nj.dismiss();
                        a aVar2 = this.nk;
                        if (aVar2 != null) {
                            aVar2.G(false);
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment nj;
                public final /* synthetic */ a nk;

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
                    this.nj = dialogFragment;
                    this.nk = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nj.dismiss();
                        a aVar2 = this.nk;
                        if (aVar2 != null) {
                            aVar2.fI();
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar})) == null) ? a(cVar.fM(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar) : (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x005e: INVOKE  (r6v1 int A[REMOVE]) = (r6v0 com.kwad.components.ad.reward.i.a) type: VIRTUAL call: com.kwad.components.ad.reward.i.a.is():int)] */
    public static View a(com.kwad.components.ad.reward.i.a aVar, DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{aVar, dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar2})) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d045f, viewGroup, false);
            if (aVar instanceof com.kwad.components.ad.reward.i.a.a) {
                com.kwad.components.ad.reward.i.a.a.a((com.kwad.components.ad.reward.i.a.a) aVar, inflate.getContext(), adTemplate);
            }
            ((RewardTaskStepView) inflate.findViewById(R.id.obfuscated_res_0x7f0911a7)).a(aVar.ir(), cVar.no);
            KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0911a6), cVar.eL(), adTemplate, 12);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911a4);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911a5);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911a8);
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.is());
            String sb2 = sb.toString();
            String str = cVar.no;
            boolean equals = "0".equals(str);
            String format = equals ? String.format(ng, sb2) : String.format(nh, str);
            int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
            if (indexOf < 0) {
                textView3.setText(format);
            } else {
                int i = equals ? indexOf + 1 : str.length() > 1 ? indexOf + 3 : indexOf + 2;
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060771));
                SpannableString spannableString = new SpannableString(format);
                spannableString.setSpan(foregroundColorSpan, indexOf, i, 17);
                textView3.setText(spannableString);
            }
            textView.setOnClickListener(new View.OnClickListener(dialogFragment, aVar2) { // from class: com.kwad.components.ad.reward.l.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment nj;
                public final /* synthetic */ a nk;

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
                    this.nj = dialogFragment;
                    this.nk = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nj.dismiss();
                        a aVar3 = this.nk;
                        if (aVar3 != null) {
                            aVar3.G(false);
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(dialogFragment, aVar2) { // from class: com.kwad.components.ad.reward.l.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment nj;
                public final /* synthetic */ a nk;

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
                    this.nj = dialogFragment;
                    this.nk = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nj.dismiss();
                        a aVar3 = this.nk;
                        if (aVar3 != null) {
                            aVar3.fI();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    private View a(l lVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, a aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65541, this, lVar, layoutInflater, viewGroup, cVar, aVar)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0476, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091148)).setText(g(inflate.getContext(), cVar.nq));
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091146);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091145);
            textView.setText(cVar.fK());
            textView2.setText(cVar.fL());
            textView.setOnClickListener(new View.OnClickListener(this, lVar, aVar) { // from class: com.kwad.components.ad.reward.l.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a nd;
                public final /* synthetic */ l ni;
                public final /* synthetic */ l nl;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, lVar, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ni = this;
                    this.nl = lVar;
                    this.nd = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nl.dismiss();
                        a aVar2 = this.nd;
                        if (aVar2 != null) {
                            aVar2.G(false);
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(this, lVar, aVar) { // from class: com.kwad.components.ad.reward.l.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a nd;
                public final /* synthetic */ l ni;
                public final /* synthetic */ l nl;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, lVar, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ni = this;
                    this.nl = lVar;
                    this.nd = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nl.dismiss();
                        a aVar2 = this.nd;
                        if (aVar2 != null) {
                            aVar2.fI();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeLLLLL.objValue;
    }

    public static c a(k kVar, @Nullable String str) {
        InterceptResult invokeLL;
        int playDuration;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, kVar, str)) == null) {
            AdTemplate adTemplate = kVar.mAdTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            com.kwad.components.ad.reward.j.a aVar = kVar.eF;
            com.kwad.components.ad.reward.i.a.a aVar2 = kVar.mK;
            com.kwad.components.ad.reward.i.kwai.a aVar3 = kVar.mL;
            int i = kVar.mM;
            boolean e = com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
            int i2 = 0;
            if (e || com.kwad.sdk.core.response.a.d.p(adTemplate)) {
                int Q = (int) com.kwad.sdk.core.response.a.a.Q(bQ);
                int B = com.kwad.sdk.core.response.a.a.B(bQ);
                if (Q > B) {
                    Q = B;
                }
                if (aVar.getPlayDuration() < (Q * 1000) + ErrorCode.CLIENT_CANCEL_REQUEST && (playDuration = (int) (Q - ((((float) aVar.getPlayDuration()) / 1000.0f) + 0.5f))) >= 0) {
                    i2 = playDuration;
                }
            }
            return (!e || aVar2 == null) ? (!com.kwad.sdk.core.response.a.d.p(adTemplate) || aVar3 == null) ? com.kwad.components.ad.reward.kwai.b.h(bQ) ? c.g(bQ) : (com.kwad.sdk.core.response.a.a.bF(bQ) && com.kwad.components.ad.reward.kwai.b.gf() == 1) ? c.a(bQ, i) : com.kwad.sdk.core.response.a.a.bk(bQ) ? c.N(str) : com.kwad.sdk.core.response.a.a.aK(adTemplate) ? c.a(adTemplate, i) : com.kwad.components.ad.reward.kwai.b.fZ() == 1 ? c.f(i) : com.kwad.components.ad.reward.kwai.b.fZ() == 2 ? c.b(bQ, i) : c.M(str) : c.a(aVar3, adTemplate, String.valueOf(i2)) : c.a(aVar2, adTemplate, String.valueOf(i2));
        }
        return (c) invokeLL.objValue;
    }

    public static l a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, activity, adTemplate, cVar, aVar)) == null) {
            l lVar = new l();
            Bundle bundle = new Bundle();
            bundle.putString("key_params_json", cVar.toJson().toString());
            bundle.putString("key_template_json", adTemplate.toJson().toString());
            lVar.setArguments(bundle);
            lVar.a(aVar);
            lVar.show(activity.getFragmentManager(), "videoCloseDialog");
            return lVar;
        }
        return (l) invokeLLLL.objValue;
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, aVar) == null) {
            this.nf = aVar;
        }
    }

    public static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar})) == null) ? a(cVar.fN(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar) : (View) invokeCommon.objValue;
    }

    public static View c(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar})) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d045a, viewGroup, false);
            KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091186), cVar.kY, adTemplate);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091185)).setText(cVar.getTitle());
            inflate.findViewById(R.id.obfuscated_res_0x7f091182).setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.l.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment nj;
                public final /* synthetic */ a nk;

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
                    this.nj = dialogFragment;
                    this.nk = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nj.dismiss();
                        a aVar2 = this.nk;
                        if (aVar2 != null) {
                            aVar2.fI();
                        }
                    }
                }
            });
            inflate.findViewById(R.id.obfuscated_res_0x7f091184).setOnClickListener(new View.OnClickListener(aVar) { // from class: com.kwad.components.ad.reward.l.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a nk;

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
                    this.nk = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || (aVar2 = this.nk) == null) {
                        return;
                    }
                    aVar2.fJ();
                }
            });
            inflate.findViewById(R.id.obfuscated_res_0x7f091183).setOnClickListener(new View.OnClickListener(dialogFragment, aVar) { // from class: com.kwad.components.ad.reward.l.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment nj;
                public final /* synthetic */ a nk;

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
                    this.nj = dialogFragment;
                    this.nk = aVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.nj.dismiss();
                        a aVar2 = this.nk;
                        if (aVar2 != null) {
                            aVar2.G(false);
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public static SpannableString g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.getColor(context, R.color.obfuscated_res_0x7f060771));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.getColor(context, R.color.obfuscated_res_0x7f060771));
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableString.length();
            spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
            spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
            spannableString.setSpan(styleSpan, 0, length, 34);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    @Override // com.kwad.components.core.i.e
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        View a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            Bundle arguments = getArguments();
            String string = arguments.getString("key_params_json");
            try {
                String string2 = arguments.getString("key_template_json");
                AdTemplate adTemplate = new AdTemplate();
                this.mAdTemplate = adTemplate;
                adTemplate.parseJson(new JSONObject(string2));
            } catch (Throwable unused) {
            }
            c O = c.O(string);
            switch (O.getStyle()) {
                case 1:
                    a2 = a(this, layoutInflater, viewGroup, O, this.mAdTemplate, this.nf);
                    break;
                case 2:
                    a2 = b(this, layoutInflater, viewGroup, O, this.mAdTemplate, this.nf);
                    break;
                case 3:
                default:
                    a2 = a((DialogFragment) this, layoutInflater, viewGroup, O, this.nf);
                    break;
                case 4:
                    a2 = c(this, layoutInflater, viewGroup, O, this.mAdTemplate, this.nf);
                    com.kwad.components.core.m.j.a(new com.kwad.components.core.widget.f(), (ViewGroup) a2);
                    break;
                case 5:
                    com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i(this, this.mAdTemplate, layoutInflater, viewGroup, this.nf);
                    iVar.a(O);
                    a2 = iVar.fR();
                    break;
                case 6:
                    a2 = a(this, layoutInflater, viewGroup, O, this.nf);
                    break;
                case 7:
                    s sVar = new s(this, this.mAdTemplate, layoutInflater, viewGroup, this.nf);
                    sVar.a(O);
                    a2 = sVar.fR();
                    break;
                case 8:
                    com.kwad.components.ad.reward.k.l lVar = new com.kwad.components.ad.reward.k.l(this, layoutInflater, viewGroup, this.nf);
                    lVar.a(O);
                    a2 = lVar.fR();
                    break;
            }
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.ad.reward.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l ni;

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
                    this.ni = this;
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

    public final boolean isShowing() {
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
            a aVar = this.nf;
            if (aVar != null) {
                aVar.fH();
            }
        }
    }
}
