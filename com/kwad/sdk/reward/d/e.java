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
/* loaded from: classes2.dex */
public class e extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f58918b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f58919c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58920d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58921e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58922f;

    /* renamed from: g  reason: collision with root package name */
    public KSCornerImageView f58923g;

    /* renamed from: h  reason: collision with root package name */
    public View f58924h;

    /* renamed from: i  reason: collision with root package name */
    public b f58925i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58926j;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58927b;

        /* renamed from: c  reason: collision with root package name */
        public String f58928c;

        /* renamed from: d  reason: collision with root package name */
        public String f58929d;

        /* renamed from: e  reason: collision with root package name */
        public SpannableString f58930e;

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
                aVar.f58929d = com.kwad.sdk.core.config.b.aG();
                aVar.f58927b = com.kwad.sdk.core.response.a.a.aC(j2);
                aVar.a = com.kwad.sdk.core.response.a.a.aD(j2);
                aVar.f58928c = com.kwad.sdk.core.response.a.a.aE(j2);
                aVar.f58930e = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
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
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? (z || (spannableString = this.f58930e) == null) ? this.f58927b : spannableString : (CharSequence) invokeZ.objValue;
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
        this.f58926j = z;
        this.f58925i = bVar;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f58918b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_root);
            this.f58919c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_icon);
            this.f58920d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_name);
            this.f58921e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_desc);
            this.f58922f = (TextView) this.a.findViewById(R.id.ksad_reward_follow_btn_follow);
            this.f58923g = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_kwai_logo);
            this.f58924h = this.a.findViewById(R.id.ksad_reward_text_aera);
            this.f58922f.setOnClickListener(this);
            this.f58919c.setOnClickListener(this);
            this.f58924h.setOnClickListener(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58918b : (ViewGroup) invokeV.objValue;
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
            this.f58919c.setVisibility(this.f58926j ? 8 : 0);
            KSImageLoader.loadImage(this.f58919c, a2.f58928c, adTemplate);
            String aF = com.kwad.sdk.core.config.b.aF();
            if (!at.a(aF)) {
                KSImageLoader.loadImage(this.f58923g, aF, adTemplate);
            }
            this.f58920d.setText(a2.a(this.f58926j));
            this.f58921e.setText(a2.b(this.f58926j));
            this.f58922f.setText(a2.f58929d);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || this.f58925i == null) {
            return;
        }
        if (view.equals(this.f58922f)) {
            this.f58925i.c();
        } else if (view.equals(this.f58919c)) {
            this.f58925i.a();
        } else if (view.equals(this.f58924h)) {
            this.f58925i.b();
        }
    }
}
