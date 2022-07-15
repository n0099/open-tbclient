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
import com.kwad.sdk.utils.at;
/* loaded from: classes5.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public View b;
    public TextView c;
    public TextView d;
    public a e;
    public int f;
    public boolean g;
    public Context h;
    public Runnable i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;

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
            this.a = "跳过";
            this.b = "";
            this.c = 5;
            this.d = 5;
            this.e = true;
            this.f = true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public static /* synthetic */ int a(b bVar) {
            int i = bVar.d;
            bVar.d = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.e && this.f : invokeV.booleanValue;
        }

        public final String a() {
            InterceptResult invokeV;
            StringBuilder sb;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.d;
                if (i2 < 0) {
                    return this.b;
                }
                if (i2 == 0) {
                    sb = new StringBuilder();
                    sb.append(this.b);
                    i = 1;
                } else {
                    sb = new StringBuilder();
                    sb.append(this.b);
                    i = this.d;
                }
                sb.append(i);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.c = i;
                this.d = i;
            }
        }

        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.d = -1;
                this.b = str;
            }
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d <= 0 : invokeV.booleanValue;
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
        this.a = new b((byte) 0);
        this.f = -1;
        this.g = false;
        this.i = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.e != null) {
                        this.a.e.b();
                    }
                }
            }
        };
        a(context);
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
        this.a = new b((byte) 0);
        this.f = -1;
        this.g = false;
        this.i = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.e != null) {
                        this.a.e.b();
                    }
                }
            }
        };
        a(context);
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
        this.a = new b((byte) 0);
        this.f = -1;
        this.g = false;
        this.i = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.e != null) {
                        this.a.e.b();
                    }
                }
            }
        };
        a(context);
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
        this.a = new b((byte) 0);
        this.f = -1;
        this.g = false;
        this.i = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.e != null) {
                        this.a.e.b();
                    }
                }
            }
        };
        a(context);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            a(this.a);
            post(this.i);
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0466, this);
            this.h = context;
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09119a);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09119b);
            this.b = findViewById(R.id.obfuscated_res_0x7f091199);
            setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SkipView a;

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

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                        return;
                    }
                    this.a.e.a();
                }
            });
            setSkipBtnVisible(true);
            setTimerBtnVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.c != null) {
            if (bVar.a != null) {
                this.c.setText(bVar.a);
            }
            this.c.setVisibility(this.a.e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.d.setVisibility(this.a.f ? 0 : 8);
        }
        if (this.b != null) {
            boolean c = this.a.c();
            this.b.setVisibility(c ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!c) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i = this.f;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, splashSkipViewModel)) == null) ? splashSkipViewModel.needShowMiniWindow && com.kwad.components.ad.splashscreen.a.b.g() > 0 && !at.a(com.kwad.components.ad.splashscreen.a.b.c()) : invokeL.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    private void b(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, splashSkipViewModel, adInfo) == null) {
            setTimerBtnVisible(a(splashSkipViewModel) ? false : com.kwad.sdk.core.response.a.a.aQ(adInfo));
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.g = true;
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.g = false;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = com.kwad.sdk.b.kwai.a.a(this.h, 35.0f);
            int width = getWidth();
            setLayoutParams(layoutParams);
            return width;
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        String aF;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashSkipViewModel, adInfo) == null) {
            setTimerPrefixText(com.kwad.components.ad.splashscreen.a.b.h());
            setTimerSecond(splashSkipViewModel.skipSecond);
            if (!com.kwad.sdk.core.response.a.a.W(adInfo)) {
                a();
            }
            if (!splashSkipViewModel.needShowMiniWindow || at.a(com.kwad.components.ad.splashscreen.a.b.c())) {
                aF = com.kwad.sdk.core.response.a.a.aF(adInfo);
            } else {
                aF = com.kwad.components.ad.splashscreen.a.b.c() + " " + com.kwad.components.ad.splashscreen.a.b.g();
            }
            setSkipText(aF);
            setVisibility(4);
            b(splashSkipViewModel, adInfo);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adInfo) == null) || com.kwad.sdk.core.response.a.a.W(adInfo)) {
            return;
        }
        d();
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == null) {
            return;
        }
        this.a.a(str);
        a(this.a);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void b(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adInfo) == null) {
            b();
            if (com.kwad.sdk.core.response.a.a.W(adInfo)) {
                return;
            }
            e();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || getHandler() == null) {
            return;
        }
        getHandler().removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            this.f = layoutParams.width;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void setSkipBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a.e = z;
            a(this.a);
        }
    }

    public void setSkipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.a.a = str;
            a(this.a);
        }
    }

    public void setTimerBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a.f = z;
            a(this.a);
        }
    }

    public void setTimerPrefixText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.a.b = str;
            a(this.a);
        }
    }

    public void setTimerSecond(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a.a(i);
            a(this.a);
        }
    }
}
