package com.kwad.sdk.reward.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.KSCornerImageView;
/* loaded from: classes3.dex */
public class e extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59499b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f59500c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59501d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59502e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59503f;

    /* renamed from: g  reason: collision with root package name */
    public KSCornerImageView f59504g;

    /* renamed from: h  reason: collision with root package name */
    public View f59505h;

    /* renamed from: i  reason: collision with root package name */
    public b f59506i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59507j;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59508b;

        /* renamed from: c  reason: collision with root package name */
        public String f59509c;

        /* renamed from: d  reason: collision with root package name */
        public String f59510d;

        /* renamed from: e  reason: collision with root package name */
        public SpannableString f59511e;

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

        @Nullable
        public static a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                if (adTemplate == null) {
                    return null;
                }
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                a aVar = new a();
                aVar.f59510d = com.kwad.sdk.core.config.b.aG();
                aVar.f59508b = com.kwad.sdk.core.response.a.a.aC(j2);
                aVar.a = com.kwad.sdk.core.response.a.a.aD(j2);
                aVar.f59509c = com.kwad.sdk.core.response.a.a.aE(j2);
                aVar.f59511e = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public String a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? this.a : (String) invokeZ.objValue;
        }

        public CharSequence b(boolean z) {
            InterceptResult invokeZ;
            SpannableString spannableString;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? (z || (spannableString = this.f59511e) == null) ? this.f59508b : spannableString : (CharSequence) invokeZ.objValue;
        }
    }

    public e(ViewGroup viewGroup, boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, Boolean.valueOf(z), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewGroup;
        this.f59507j = z;
        this.f59506i = bVar;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f59499b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_root);
            this.f59500c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_icon);
            this.f59501d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_name);
            this.f59502e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_desc);
            this.f59503f = (TextView) this.a.findViewById(R.id.ksad_reward_follow_btn_follow);
            this.f59504g = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_kwai_logo);
            this.f59505h = this.a.findViewById(R.id.ksad_reward_text_aera);
            this.f59503f.setOnClickListener(this);
            this.f59500c.setOnClickListener(this);
            this.f59505h.setOnClickListener(this);
            Context context = this.a.getContext();
            if (af.e(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
                this.a.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59499b : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            super.a(adTemplate);
            a a2 = a.a(adTemplate);
            if (a2 == null) {
                return;
            }
            this.f59500c.setVisibility(this.f59507j ? 8 : 0);
            KSImageLoader.loadImage(this.f59500c, a2.f59509c, adTemplate);
            String aF = com.kwad.sdk.core.config.b.aF();
            if (!at.a(aF)) {
                KSImageLoader.loadImage(this.f59504g, aF, adTemplate);
            }
            this.f59501d.setText(a2.a(this.f59507j));
            this.f59502e.setText(a2.b(this.f59507j));
            this.f59503f.setText(a2.f59510d);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || this.f59506i == null) {
            return;
        }
        if (view.equals(this.f59503f)) {
            this.f59506i.c();
        } else if (view.equals(this.f59500c)) {
            this.f59506i.a();
        } else if (view.equals(this.f59505h)) {
            this.f59506i.b();
        }
    }
}
