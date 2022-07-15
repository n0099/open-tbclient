package com.kwad.components.ad.reward.i;

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
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.at;
/* loaded from: classes5.dex */
public final class o extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ViewGroup b;
    public KSCornerImageView c;
    public TextView d;
    public LinearLayout e;
    public KsPriceView f;
    public TextView g;
    public View h;
    public KSCornerImageView i;
    public b j;
    public a k;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public o(ViewGroup viewGroup, b bVar) {
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
        this.a = viewGroup;
        this.j = bVar;
        c();
    }

    public static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, couponInfo, viewGroup)) == null) {
            KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0459, viewGroup, false);
            kSCouponLabelTextView.setText(couponInfo.getDisplayName());
            return kSCouponLabelTextView;
        }
        return (View) invokeLLL.objValue;
    }

    private void a(AdProductInfo adProductInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, adProductInfo, adTemplate) == null) {
            KSImageLoader.loadImage(this.c, adProductInfo.getIcon(), adTemplate);
            this.d.setText(adProductInfo.getName());
            if (adProductInfo.isCouponListEmpty()) {
                this.e.setVisibility(8);
                this.k.a();
            } else {
                this.e.setVisibility(0);
                this.e.post(new Runnable(this, adProductInfo) { // from class: com.kwad.components.ad.reward.i.o.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdProductInfo a;
                    public final /* synthetic */ o b;

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
                        this.b = this;
                        this.a = adProductInfo;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (CouponInfo couponInfo : this.a.getCouponList()) {
                                View a2 = o.a(this.b.e.getContext(), couponInfo, this.b.e);
                                ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new ViewGroup.LayoutParams(-2, -1);
                                } else {
                                    layoutParams.width = -2;
                                    layoutParams.height = -1;
                                }
                                this.b.e.addView(a2, layoutParams);
                                com.kwad.components.core.l.j.a(new com.kwad.components.core.widget.f(), this.b.e);
                            }
                            if (this.b.k != null) {
                                if (this.b.e.getChildCount() > 0) {
                                    this.b.e.getChildAt(0).post(new Runnable(this) { // from class: com.kwad.components.ad.reward.i.o.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 a;

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
                                            this.a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.a.b.k.a();
                                            }
                                        }
                                    });
                                } else {
                                    this.b.k.a();
                                }
                            }
                        }
                    }
                });
            }
            this.f.a(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
            String c = com.kwad.components.ad.c.b.c();
            if (at.a(c)) {
                return;
            }
            KSImageLoader.loadImage(this.i, c, adTemplate);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09115c);
            this.c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091159);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09115e);
            this.e = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09114b);
            this.f = (KsPriceView) this.a.findViewById(R.id.obfuscated_res_0x7f09115b);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091148);
            this.h = this.a.findViewById(R.id.obfuscated_res_0x7f09115d);
            this.i = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09115a);
            this.g.setText(com.kwad.components.ad.c.b.b());
            this.g.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.h.setOnClickListener(this);
            Context context = this.a.getContext();
            if (ae.e(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b7);
                this.a.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (ViewGroup) invokeV.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.k = aVar;
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            super.a(wVar);
            a(com.kwad.sdk.core.response.a.a.bd(com.kwad.sdk.core.response.a.d.i(wVar.a())), wVar.a());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.j == null) {
            return;
        }
        if (view2.equals(this.g)) {
            this.j.d();
        } else if (view2.equals(this.c)) {
            this.j.e();
        } else if (view2.equals(this.h)) {
            this.j.g();
        }
    }
}
