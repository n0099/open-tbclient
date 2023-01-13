package com.kwad.components.ad.reward.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
/* loaded from: classes8.dex */
public final class m extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup es;
    public TextView li;
    public KSCornerImageView nG;
    public ViewGroup nL;
    public LinearLayout vC;
    public KsPriceView vD;
    public TextView vE;
    public View vF;
    public KSCornerImageView vG;
    public b vH;
    public a vI;

    /* loaded from: classes8.dex */
    public interface a {
        void gV();
    }

    public m(ViewGroup viewGroup, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.es = viewGroup;
        this.vH = bVar;
        initView();
    }

    public static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, couponInfo, viewGroup)) == null) {
            KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0474, viewGroup, false);
            kSCouponLabelTextView.setText(couponInfo.getDisplayName());
            return kSCouponLabelTextView;
        }
        return (View) invokeLLL.objValue;
    }

    public static /* synthetic */ View a(m mVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void a(AdProductInfo adProductInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, adProductInfo, adTemplate) == null) {
            KSImageLoader.loadImage(this.nG, adProductInfo.getIcon(), adTemplate);
            this.li.setText(adProductInfo.getName());
            if (adProductInfo.isCouponListEmpty()) {
                this.vC.setVisibility(8);
                this.vI.gV();
            } else {
                this.vC.setVisibility(0);
                this.vC.post(new Runnable(this, adProductInfo) { // from class: com.kwad.components.ad.reward.k.m.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdProductInfo vJ;
                    public final /* synthetic */ m vK;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adProductInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.vK = this;
                        this.vJ = adProductInfo;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (CouponInfo couponInfo : this.vJ.getCouponList()) {
                                m mVar = this.vK;
                                View a2 = m.a(mVar, mVar.vC.getContext(), couponInfo, this.vK.vC);
                                ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new ViewGroup.LayoutParams(-2, -1);
                                } else {
                                    layoutParams.width = -2;
                                    layoutParams.height = -1;
                                }
                                this.vK.vC.addView(a2, layoutParams);
                                com.kwad.components.core.m.j.a(new com.kwad.components.core.widget.f(), this.vK.vC);
                            }
                            if (this.vK.vI != null) {
                                if (this.vK.vC.getChildCount() > 0) {
                                    this.vK.vC.getChildAt(0).post(new Runnable(this) { // from class: com.kwad.components.ad.reward.k.m.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 vL;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.vL = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.vL.vK.vI.gV();
                                            }
                                        }
                                    });
                                } else {
                                    this.vK.vI.gV();
                                }
                            }
                        }
                    }
                });
            }
            this.vD.f(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
            String aj = com.kwad.components.ad.c.b.aj();
            if (ax.dT(aj)) {
                return;
            }
            KSImageLoader.loadImage(this.vG, aj, adTemplate);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.nL = (ViewGroup) this.es.findViewById(R.id.obfuscated_res_0x7f09124d);
            this.nG = (KSCornerImageView) this.es.findViewById(R.id.obfuscated_res_0x7f09124a);
            this.li = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f09124f);
            this.vC = (LinearLayout) this.es.findViewById(R.id.obfuscated_res_0x7f09123c);
            this.vD = (KsPriceView) this.es.findViewById(R.id.obfuscated_res_0x7f09124c);
            this.vE = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f091239);
            this.vF = this.es.findViewById(R.id.obfuscated_res_0x7f09124e);
            this.vG = (KSCornerImageView) this.es.findViewById(R.id.obfuscated_res_0x7f09124b);
            this.vE.setText(com.kwad.components.ad.c.b.ai());
            this.vE.setOnClickListener(this);
            this.nG.setOnClickListener(this);
            this.vF.setOnClickListener(this);
            Context context = this.es.getContext();
            if (ag.cB(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.es.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b5);
                this.es.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.vI = aVar;
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar) == null) {
            super.a(uVar);
            a(com.kwad.sdk.core.response.a.a.bN(com.kwad.sdk.core.response.a.d.bQ(uVar.getAdTemplate())), uVar.getAdTemplate());
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nL : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.vH == null) {
            return;
        }
        if (view2.equals(this.vE)) {
            this.vH.gn();
        } else if (view2.equals(this.nG)) {
            this.vH.hz();
        } else if (view2.equals(this.vF)) {
            this.vH.hA();
        }
    }
}
