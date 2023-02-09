package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.j;
/* loaded from: classes8.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public ValueAnimator cm;
    public a co;
    public ImageView cp;
    public TextView cq;
    public TextView cr;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public int mHeight;

    /* loaded from: classes8.dex */
    public interface a {
        void aC();

        void aD();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardH5(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        E(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        E(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        E(context);
    }

    private void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.mContext = context;
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0434, this);
            this.cp = (ImageView) findViewById(R.id.obfuscated_res_0x7f091174);
            this.cq = (TextView) findViewById(R.id.obfuscated_res_0x7f09116a);
            this.cr = (TextView) findViewById(R.id.obfuscated_res_0x7f091176);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09119f);
        }
    }

    private void aL() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (valueAnimator = this.cm) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.cm.cancel();
    }

    private void aV() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            d(this.mHeight, 0);
        }
    }

    private void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, this, i, i2) == null) {
            aL();
            ValueAnimator b = n.b(this, i, i2);
            this.cm = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.cm.setDuration(300L);
            this.cm.start();
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adTemplate, aVar) == null) {
            this.mAdTemplate = adTemplate;
            AdInfo bQ = d.bQ(adTemplate);
            this.co = aVar;
            this.cq.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
            this.cr.setText(com.kwad.sdk.core.response.a.a.al(bQ));
            this.cp.setOnClickListener(this);
            this.cr.setOnClickListener(this);
            this.bq.T(adTemplate);
            setOnClickListener(this);
            this.cq.measure(View.MeasureSpec.makeMeasureSpec((j.getScreenWidth(this.mContext) - (com.kwad.sdk.b.kwai.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.b.kwai.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mHeight = com.kwad.sdk.b.kwai.a.a(this.mContext, 100.0f) + this.cq.getMeasuredHeight();
        }
    }

    public final void aT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(0, this.mHeight);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 != this.cp) {
                com.kwad.components.core.c.a.a.a(new a.C0598a(getContext()).L(this.mAdTemplate).a(new a.b(this) { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DrawCardH5 cs;

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
                        this.cs = this;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.cs.co == null) {
                            return;
                        }
                        this.cs.co.aD();
                    }
                }));
                return;
            }
            aV();
            a aVar = this.co;
            if (aVar != null) {
                aVar.aC();
            }
        }
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            aL();
        }
    }
}
