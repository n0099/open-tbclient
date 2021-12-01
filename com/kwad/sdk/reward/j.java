package com.kwad.sdk.reward;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.RewardTaskStepView;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KSCornerImageView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends com.kwad.sdk.h.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static j a = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f58953d = "奖励还差 %s 步到手，\n确认放弃吗？";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f58954b;

    /* renamed from: c  reason: collision with root package name */
    public b f58955c;

    /* loaded from: classes2.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f58966b;

        /* renamed from: c  reason: collision with root package name */
        public String f58967c;

        /* renamed from: d  reason: collision with root package name */
        public String f58968d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.reward.b.a.a f58969e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.reward.b.kwai.a f58970f;

        /* renamed from: g  reason: collision with root package name */
        public String f58971g;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(AdInfo adInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
                a aVar = new a();
                aVar.a = 3;
                aVar.f58966b = com.kwad.sdk.core.response.a.a.aD(adInfo);
                aVar.f58971g = com.kwad.sdk.core.response.a.a.aE(adInfo);
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a a(com.kwad.sdk.reward.b.a.a aVar, AdTemplate adTemplate) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, adTemplate)) == null) {
                a aVar2 = new a();
                aVar2.a = 1;
                aVar2.f58969e = aVar;
                aVar2.f58971g = com.kwad.sdk.core.response.a.a.au(com.kwad.sdk.core.response.a.d.j(adTemplate));
                return aVar2;
            }
            return (a) invokeLL.objValue;
        }

        public static a a(com.kwad.sdk.reward.b.kwai.a aVar, AdTemplate adTemplate) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aVar, adTemplate)) == null) {
                a aVar2 = new a();
                aVar2.a = 2;
                aVar2.f58970f = aVar;
                aVar2.f58971g = com.kwad.sdk.core.response.a.a.au(com.kwad.sdk.core.response.a.d.j(adTemplate));
                return aVar2;
            }
            return (a) invokeLL.objValue;
        }

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
                a aVar = new a();
                aVar.a = 0;
                aVar.f58966b = str;
                aVar.f58967c = "关闭广告";
                aVar.f58968d = "继续观看";
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a b(AdInfo adInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adInfo)) == null) {
                a aVar = new a();
                aVar.a = 4;
                AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(adInfo);
                aVar.f58966b = com.kwad.sdk.core.response.a.a.s(adInfo);
                aVar.f58971g = aK.getIcon();
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
                a aVar = new a();
                aVar.a = 0;
                aVar.f58966b = str;
                aVar.f58967c = "奖励不要了";
                aVar.f58968d = "返回";
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
                a aVar = new a();
                try {
                    aVar.parseJson(new JSONObject(str));
                } catch (JSONException unused) {
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public int a() {
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
                    if (this.f58969e == null) {
                        this.f58969e = new com.kwad.sdk.reward.b.a.a();
                    }
                    this.f58969e.parseJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
                if (optJSONObject2 != null) {
                    if (this.f58970f == null) {
                        this.f58970f = new com.kwad.sdk.reward.b.kwai.a();
                    }
                    this.f58970f.parseJson(optJSONObject2);
                }
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                super.afterToJson(jSONObject);
                com.kwad.sdk.reward.b.a.a aVar = this.f58969e;
                if (aVar != null) {
                    t.a(jSONObject, "mLaunchAppTask", aVar);
                }
                com.kwad.sdk.reward.b.kwai.a aVar2 = this.f58970f;
                if (aVar2 != null) {
                    t.a(jSONObject, "mLandPageOpenTask", aVar2);
                }
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58966b : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.isEmpty(this.f58967c) ? "关闭广告" : this.f58967c : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.isEmpty(this.f58968d) ? "继续观看" : this.f58968d : (String) invokeV.objValue;
        }

        public com.kwad.sdk.reward.b.a.a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58969e : (com.kwad.sdk.reward.b.a.a) invokeV.objValue;
        }

        public com.kwad.sdk.reward.b.kwai.a f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58970f : (com.kwad.sdk.reward.b.kwai.a) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58971g : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* loaded from: classes2.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.reward.j.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.kwad.sdk.reward.j.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.kwad.sdk.reward.j.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.kwad.sdk.reward.j.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.kwad.sdk.reward.j.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(389615478, "Lcom/kwad/sdk/reward/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(389615478, "Lcom/kwad/sdk/reward/j;");
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, AdTemplate adTemplate, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{dialogFragment, layoutInflater, viewGroup, aVar, adTemplate, bVar})) == null) {
            View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
            com.kwad.sdk.reward.b.a.a e2 = aVar.e();
            com.kwad.sdk.reward.b.a.a.a(e2, inflate.getContext(), adTemplate);
            ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(e2.m());
            KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), aVar.g(), adTemplate, 12);
            TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
            TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
            String str = e2.l() + "";
            String format = String.format(f58953d, str);
            int indexOf = format.indexOf(str);
            if (indexOf < 0) {
                textView3.setText(format);
            } else {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
                SpannableString spannableString = new SpannableString(format);
                spannableString.setSpan(foregroundColorSpan, indexOf, indexOf + 1, 17);
                textView3.setText(spannableString);
            }
            textView.setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58964b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58964b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58964b;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58965b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58965b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58965b;
                        if (bVar2 != null) {
                            bVar2.c();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, b bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, dialogFragment, layoutInflater, viewGroup, aVar, bVar)) == null) {
            View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.ksad_title)).setText(aVar.b());
            TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
            textView.setText(aVar.c());
            textView2.setText(aVar.d());
            textView.setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58962b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58962b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58962b;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58963b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58963b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58963b;
                        if (bVar2 != null) {
                            bVar2.c();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeLLLLL.objValue;
    }

    public static a a(AdTemplate adTemplate, @Nullable String str, @Nullable com.kwad.sdk.reward.b.a.a aVar, @Nullable com.kwad.sdk.reward.b.kwai.a aVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate, str, aVar, aVar2)) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            return (!com.kwad.sdk.core.response.a.d.u(adTemplate) || aVar == null) ? (!com.kwad.sdk.core.response.a.d.v(adTemplate) || aVar2 == null) ? (!com.kwad.sdk.core.response.a.a.aH(j2) || com.kwad.sdk.core.response.a.a.aA(j2)) ? com.kwad.sdk.core.response.a.a.aI(j2) ? a.b(j2) : com.kwad.sdk.core.response.a.a.as(j2) ? a.b(str) : a.a(str) : a.a(j2) : a.a(aVar2, adTemplate) : a.a(aVar, adTemplate);
        }
        return (a) invokeLLLL.objValue;
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, activity, adTemplate, aVar, bVar) == null) {
            a = new j();
            Bundle bundle = new Bundle();
            bundle.putString("key_params_json", aVar.toJson().toString());
            bundle.putString("key_template_json", adTemplate.toJson().toString());
            a.setArguments(bundle);
            a.a(bVar);
            a.show(activity.getFragmentManager(), "videoCloseDialog");
        }
    }

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, bVar) == null) {
            this.f58955c = bVar;
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            j jVar = a;
            return jVar != null && jVar.b();
        }
        return invokeV.booleanValue;
    }

    public static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, AdTemplate adTemplate, b bVar) {
        InterceptResult invokeCommon;
        com.kwad.sdk.reward.b.kwai.a f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{dialogFragment, layoutInflater, viewGroup, aVar, adTemplate, bVar})) == null) {
            View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
            ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.f().j());
            KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), aVar.g(), adTemplate, 12);
            TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
            TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
            String str = f2.i() + "";
            String format = String.format(f58953d, str);
            int indexOf = format.indexOf(str);
            if (indexOf < 0) {
                textView3.setText(format);
            } else {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
                SpannableString spannableString = new SpannableString(format);
                spannableString.setSpan(foregroundColorSpan, indexOf, indexOf + 1, 17);
                textView3.setText(spannableString);
            }
            textView.setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58956b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58956b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58956b;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58957b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58957b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58957b;
                        if (bVar2 != null) {
                            bVar2.c();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, b bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65545, null, dialogFragment, layoutInflater, viewGroup, aVar, bVar)) == null) {
            View inflate = layoutInflater.inflate(R.layout.ksad_reward_follow_dialog, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.ksad_reward_follow_dialog_title)).setText(aVar.b());
            inflate.findViewById(R.id.ksad_reward_follow_dialog_btn_close).setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58958b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58958b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58958b;
                        if (bVar2 != null) {
                            bVar2.c();
                        }
                    }
                }
            });
            inflate.findViewById(R.id.ksad_reward_follow_dialog_btn_follow).setOnClickListener(new View.OnClickListener(bVar) { // from class: com.kwad.sdk.reward.j.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (bVar2 = this.a) == null) {
                        return;
                    }
                    bVar2.d();
                }
            });
            inflate.findViewById(R.id.ksad_reward_follow_dialog_btn_deny).setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58959b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58959b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58959b;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }
            });
            KSImageLoader.loadCircleIcon((ImageView) inflate.findViewById(R.id.ksad_reward_follow_dialog_icon), aVar.g(), inflate.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            return inflate;
        }
        return (View) invokeLLLLL.objValue;
    }

    public static View c(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, AdTemplate adTemplate, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{dialogFragment, layoutInflater, viewGroup, aVar, adTemplate, bVar})) == null) {
            View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
            KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), aVar.f58971g, adTemplate);
            ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(aVar.b());
            inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58960b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58960b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58960b;
                        if (bVar2 != null) {
                            bVar2.c();
                        }
                    }
                }
            });
            inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener(bVar) { // from class: com.kwad.sdk.reward.j.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (bVar2 = this.a) == null) {
                        return;
                    }
                    bVar2.e();
                }
            });
            inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener(dialogFragment, bVar) { // from class: com.kwad.sdk.reward.j.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogFragment a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f58961b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogFragment, bVar};
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
                    this.f58961b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        b bVar2 = this.f58961b;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.h.e
    @Nullable
    public View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        View a2;
        com.kwad.sdk.widget.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            Bundle arguments = getArguments();
            String string = arguments.getString("key_params_json");
            try {
                String string2 = arguments.getString("key_template_json");
                AdTemplate adTemplate = new AdTemplate();
                this.f58954b = adTemplate;
                adTemplate.parseJson(new JSONObject(string2));
            } catch (Throwable unused) {
            }
            a c2 = a.c(string);
            int a3 = c2.a();
            if (a3 == 1) {
                a2 = a(this, layoutInflater, viewGroup, c2, this.f58954b, this.f58955c);
            } else if (a3 != 2) {
                if (a3 == 3) {
                    a2 = b(this, layoutInflater, viewGroup, c2, this.f58955c);
                    cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
                } else if (a3 != 4) {
                    a2 = a(this, layoutInflater, viewGroup, c2, this.f58955c);
                } else {
                    a2 = c(this, layoutInflater, viewGroup, c2, this.f58954b, this.f58955c);
                    cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
                }
                w.a(cVar, (ViewGroup) a2);
            } else {
                a2 = b(this, layoutInflater, viewGroup, c2, this.f58954b, this.f58955c);
            }
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.sdk.reward.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) ? i2 == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                }
            });
            return a2;
        }
        return (View) invokeLLL.objValue;
    }

    public boolean b() {
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
    public void onActivityCreated(@Nullable Bundle bundle) {
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
            b bVar = this.f58955c;
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
