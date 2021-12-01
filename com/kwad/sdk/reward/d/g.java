package com.kwad.sdk.reward.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KSCornerImageView;
import com.kwad.sdk.widget.KSCouponLabelTextView;
import com.kwad.sdk.widget.KsPriceView;
/* loaded from: classes2.dex */
public class g extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f58937b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f58938c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58939d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f58940e;

    /* renamed from: f  reason: collision with root package name */
    public KsPriceView f58941f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58942g;

    /* renamed from: h  reason: collision with root package name */
    public View f58943h;

    /* renamed from: i  reason: collision with root package name */
    public KSCornerImageView f58944i;

    /* renamed from: j  reason: collision with root package name */
    public b f58945j;

    /* renamed from: k  reason: collision with root package name */
    public a f58946k;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public g(ViewGroup viewGroup, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, bVar};
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
        this.f58945j = bVar;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, context, couponInfo, viewGroup)) == null) {
            KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.ksad_reward_order_card_coupon, viewGroup, false);
            kSCouponLabelTextView.setText(couponInfo.getDisplayName());
            return kSCouponLabelTextView;
        }
        return (View) invokeLLL.objValue;
    }

    private void a(AdProductInfo adProductInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, adProductInfo, adTemplate) == null) {
            KSImageLoader.loadImage(this.f58938c, adProductInfo.getIcon(), adTemplate);
            this.f58939d.setText(adProductInfo.getName());
            if (adProductInfo.isCouponListEmpty()) {
                this.f58940e.setVisibility(8);
                this.f58946k.a();
            } else {
                this.f58940e.setVisibility(0);
                this.f58940e.post(new Runnable(this, adProductInfo) { // from class: com.kwad.sdk.reward.d.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdProductInfo a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ g f58947b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adProductInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58947b = this;
                        this.a = adProductInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (CouponInfo couponInfo : this.a.getCouponList()) {
                                g gVar = this.f58947b;
                                View a2 = gVar.a(gVar.f58940e.getContext(), couponInfo, this.f58947b.f58940e);
                                ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new ViewGroup.LayoutParams(-2, -1);
                                } else {
                                    layoutParams.width = -2;
                                    layoutParams.height = -1;
                                }
                                this.f58947b.f58940e.addView(a2, layoutParams);
                                w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.f58947b.f58940e);
                            }
                            if (this.f58947b.f58946k != null) {
                                if (this.f58947b.f58940e.getChildCount() > 0) {
                                    this.f58947b.f58940e.getChildAt(0).post(new Runnable(this) { // from class: com.kwad.sdk.reward.d.g.1.1
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
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.a.f58947b.f58946k.a();
                                            }
                                        }
                                    });
                                } else {
                                    this.f58947b.f58946k.a();
                                }
                            }
                        }
                    }
                });
            }
            this.f58941f.a(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
            String aF = com.kwad.sdk.core.config.b.aF();
            if (at.a(aF)) {
                return;
            }
            KSImageLoader.loadImage(this.f58944i, aF, adTemplate);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.f58937b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_root);
            this.f58938c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_icon);
            this.f58939d = (TextView) this.a.findViewById(R.id.ksad_reward_order_title);
            this.f58940e = (LinearLayout) this.a.findViewById(R.id.ksad_reward_order_coupon_list);
            this.f58941f = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_price);
            this.f58942g = (TextView) this.a.findViewById(R.id.ksad_reward_order_btn_buy);
            this.f58943h = this.a.findViewById(R.id.ksad_reward_order_text_area);
            this.f58944i = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_kwai_logo);
            this.f58942g.setText(com.kwad.sdk.core.config.b.aE());
            this.f58942g.setOnClickListener(this);
            this.f58938c.setOnClickListener(this);
            this.f58943h.setOnClickListener(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58937b : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            super.a(adTemplate);
            a(com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.j(adTemplate)), adTemplate);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f58946k = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.f58945j == null) {
            return;
        }
        if (view.equals(this.f58942g)) {
            this.f58945j.c();
        } else if (view.equals(this.f58938c)) {
            this.f58945j.a();
        } else if (view.equals(this.f58943h)) {
            this.f58945j.b();
        }
    }
}
