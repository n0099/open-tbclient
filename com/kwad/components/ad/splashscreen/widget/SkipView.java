package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ax;
/* loaded from: classes5.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a Ab;
    public final b Bn;
    public View Bo;
    public TextView Bp;
    public TextView Bq;
    public int Br;
    public Runnable Bs;
    public boolean kC;
    public Context mContext;
    public boolean pX;

    /* loaded from: classes5.dex */
    public interface a {
        void kb();

        void kc();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String Bu;
        public String Bv;
        public int Bw;
        public int Bx;
        public boolean By;
        public boolean Bz;

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
                    return;
                }
            }
            this.Bu = "跳过";
            this.Bv = "";
            this.Bw = 5;
            this.Bx = 5;
            this.By = true;
            this.Bz = true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public static /* synthetic */ int b(b bVar) {
            int i = bVar.Bx;
            bVar.Bx = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean kK() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.By && this.Bz : invokeV.booleanValue;
        }

        public final void aa(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.Bw = i;
                this.Bx = i;
            }
        }

        public final void ac(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.Bx = -1;
                this.Bv = str;
            }
        }

        public final String kI() {
            InterceptResult invokeV;
            StringBuilder sb;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.Bx;
                if (i2 < 0) {
                    return this.Bv;
                }
                if (i2 == 0) {
                    sb = new StringBuilder();
                    sb.append(this.Bv);
                    i = 1;
                } else {
                    sb = new StringBuilder();
                    sb.append(this.Bv);
                    i = this.Bx;
                }
                sb.append(i);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public final boolean kJ() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Bx <= 0 : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipView(Context context) {
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
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView Bt;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Bt = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.Bt.kC) {
                        this.Bt.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.Bt;
                    skipView.a(skipView.Bn);
                    if (!this.Bt.Bn.kJ()) {
                        this.Bt.postDelayed(this, 1000L);
                        b.b(this.Bt.Bn);
                    } else if (this.Bt.Ab != null) {
                        this.Bt.Ab.kc();
                    }
                }
            }
        };
        ae(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView Bt;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Bt = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.Bt.kC) {
                        this.Bt.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.Bt;
                    skipView.a(skipView.Bn);
                    if (!this.Bt.Bn.kJ()) {
                        this.Bt.postDelayed(this, 1000L);
                        b.b(this.Bt.Bn);
                    } else if (this.Bt.Ab != null) {
                        this.Bt.Ab.kc();
                    }
                }
            }
        };
        ae(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView Bt;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Bt = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.Bt.kC) {
                        this.Bt.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.Bt;
                    skipView.a(skipView.Bn);
                    if (!this.Bt.Bn.kJ()) {
                        this.Bt.postDelayed(this, 1000L);
                        b.b(this.Bt.Bn);
                    } else if (this.Bt.Ab != null) {
                        this.Bt.Ab.kc();
                    }
                }
            }
        };
        ae(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView Bt;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i42 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Bt = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.Bt.kC) {
                        this.Bt.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.Bt;
                    skipView.a(skipView.Bn);
                    if (!this.Bt.Bn.kJ()) {
                        this.Bt.postDelayed(this, 1000L);
                        b.b(this.Bt.Bn);
                    } else if (this.Bt.Ab != null) {
                        this.Bt.Ab.kc();
                    }
                }
            }
        };
        ae(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.Bp != null) {
            if (bVar.Bu != null) {
                this.Bp.setText(bVar.Bu);
            }
            this.Bp.setVisibility(this.Bn.By ? 0 : 8);
        }
        String kI = bVar.kI();
        TextView textView = this.Bq;
        if (textView != null) {
            if (kI != null) {
                textView.setText(kI);
            }
            this.Bq.setVisibility(this.Bn.Bz ? 0 : 8);
        }
        if (this.Bo != null) {
            boolean kK = this.Bn.kK();
            this.Bo.setVisibility(kK ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!kK) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i = this.Br;
                if (i > 0) {
                    layoutParams.width = i;
                    invalidate();
                }
            }
        }
    }

    public static boolean a(SplashSkipViewModel splashSkipViewModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, splashSkipViewModel)) == null) ? splashSkipViewModel.needShowMiniWindow && com.kwad.components.ad.splashscreen.a.b.jP() > 0 && !ax.dT(com.kwad.components.ad.splashscreen.a.b.jL()) : invokeL.booleanValue;
    }

    private void ae(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0465, this);
            this.mContext = context;
            this.Bp = (TextView) findViewById(R.id.obfuscated_res_0x7f0911cb);
            this.Bq = (TextView) findViewById(R.id.obfuscated_res_0x7f0911cc);
            this.Bo = findViewById(R.id.obfuscated_res_0x7f0911ca);
            setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SkipView Bt;

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
                    this.Bt = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.Bt.Ab == null) {
                        return;
                    }
                    this.Bt.Ab.kb();
                }
            });
            setSkipBtnVisible(true);
            setTimerBtnVisible(true);
        }
    }

    private void b(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, splashSkipViewModel, adInfo) == null) {
            setTimerBtnVisible(a(splashSkipViewModel) ? false : com.kwad.sdk.core.response.a.a.bA(adInfo));
        }
    }

    private void eA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.kC = true;
        }
    }

    private void eB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.kC = false;
        }
    }

    private void ez() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            a(this.Bn);
            post(this.Bs);
        }
    }

    private void kH() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int Y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = com.kwad.sdk.b.kwai.a.a(this.mContext, 35.0f);
            int width = getWidth();
            setLayoutParams(layoutParams);
            return width;
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        String bo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashSkipViewModel, adInfo) == null) {
            this.pX = com.kwad.sdk.core.response.a.a.bz(adInfo);
            setTimerPrefixText(com.kwad.components.ad.splashscreen.a.b.jQ());
            setTimerSecond(splashSkipViewModel.skipSecond);
            if (!com.kwad.sdk.core.response.a.a.aB(adInfo)) {
                ez();
            }
            if (!splashSkipViewModel.needShowMiniWindow || ax.dT(com.kwad.components.ad.splashscreen.a.b.jL())) {
                bo = com.kwad.sdk.core.response.a.a.bo(adInfo);
            } else {
                bo = com.kwad.components.ad.splashscreen.a.b.jL() + " " + com.kwad.components.ad.splashscreen.a.b.jP();
            }
            setSkipText(bo);
            setVisibility(8);
            b(splashSkipViewModel, adInfo);
        }
    }

    public final void ac(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null) {
            return;
        }
        this.Bn.ac(str);
        a(this.Bn);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bj() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || getHandler() == null) {
            return;
        }
        getHandler().removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void s(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, adInfo) == null) || com.kwad.sdk.core.response.a.a.aB(adInfo)) {
            return;
        }
        eA();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            this.Br = layoutParams.width;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.Ab = aVar;
        }
    }

    public void setSkipBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.Bn.By = z;
            a(this.Bn);
        }
    }

    public void setSkipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.Bn.Bu = str;
            a(this.Bn);
        }
    }

    public void setTimerBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.Bn.Bz = z;
            a(this.Bn);
        }
    }

    public void setTimerPrefixText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.Bn.Bv = str;
            a(this.Bn);
        }
    }

    public void setTimerSecond(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.Bn.aa(i);
            a(this.Bn);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void t(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adInfo) == null) {
            if (this.pX) {
                kH();
            }
            if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
                return;
            }
            eB();
        }
    }
}
