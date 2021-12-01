package com.kwad.sdk.splashscreen.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.widget.KsShakeView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ax;
/* loaded from: classes2.dex */
public class g extends Presenter implements View.OnClickListener, com.kwad.sdk.core.g.a, com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 400;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f59481b;

    /* renamed from: c  reason: collision with root package name */
    public View f59482c;

    /* renamed from: d  reason: collision with root package name */
    public KsShakeView f59483d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59484e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.g.b f59485f;

    /* renamed from: g  reason: collision with root package name */
    public Vibrator f59486g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59487h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f59488i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.a f59489j;

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.e f59490k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1381681501, "Lcom/kwad/sdk/splashscreen/a/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1381681501, "Lcom/kwad/sdk/splashscreen/a/g;");
        }
    }

    public g() {
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

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TextView textView = this.f59484e;
            if (textView != null) {
                textView.setText(this.f59490k.a());
            }
            KsShakeView ksShakeView = this.f59483d;
            if (ksShakeView != null) {
                ksShakeView.a(this.f59490k.b());
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f59488i == null) {
            return;
        }
        com.kwad.sdk.splashscreen.a aVar = this.f59489j;
        if (aVar == null) {
            this.f59489j = new com.kwad.sdk.splashscreen.a(this, this.f59481b) { // from class: com.kwad.sdk.splashscreen.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f59491b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((AdTemplate) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59491b = this;
                }

                @Override // com.kwad.sdk.splashscreen.a
                @SuppressLint({"SetTextI18n"})
                public void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.f59491b.f59484e == null) {
                        return;
                    }
                    TextView textView = this.f59491b.f59484e;
                    textView.setText("或点击" + str);
                }
            };
        } else {
            aVar.a(this.f59481b);
        }
        com.kwad.sdk.core.download.a.b bVar = this.f59488i.f59580g;
        if (bVar != null) {
            bVar.a(this.f59489j);
        }
    }

    private void g() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (view = this.f59482c) == null || this.f59488i == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.f59481b, 19, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            Object p = p();
            if (p instanceof com.kwad.sdk.splashscreen.g) {
                this.f59488i = (com.kwad.sdk.splashscreen.g) p;
            }
            com.kwad.sdk.splashscreen.g gVar = this.f59488i;
            if (gVar == null) {
                return;
            }
            AdTemplate adTemplate = gVar.f59577d;
            this.f59481b = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f59490k = com.kwad.sdk.splashscreen.e.a(this.f59481b, j2, this.f59488i.f59580g);
            float o = com.kwad.sdk.core.response.a.b.o(this.f59481b);
            com.kwad.sdk.core.g.b bVar = this.f59485f;
            if (bVar == null) {
                com.kwad.sdk.core.g.b bVar2 = new com.kwad.sdk.core.g.b(o);
                this.f59485f = bVar2;
                bVar2.a(this);
            } else {
                bVar.a(o);
            }
            e();
            if (com.kwad.sdk.core.response.a.a.B(j2)) {
                f();
            }
            g();
            this.f59485f.a(q());
            this.f59483d.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.f59483d.a();
                    }
                }
            });
            com.kwad.sdk.splashscreen.kwai.a.a(q());
            this.f59487h = com.kwad.sdk.core.response.a.c.g(this.f59488i.f59577d);
            new com.kwad.sdk.widget.f(this.f59483d.getContext(), this.f59483d, this);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public void a(double d2) {
        Runnable runnable;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            boolean isShown = this.f59483d.isShown();
            boolean a2 = com.kwad.sdk.core.download.kwai.b.a();
            com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onShakeEvent called isShakeViewShown: " + isShown + ", isDialogShown: " + a2);
            if (!isShown || a2) {
                runnable = new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.g.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g a;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f59485f.a();
                        }
                    }
                };
                j2 = 500;
            } else {
                this.f59483d.a(new AnimatorListenerAdapter(this, d2) { // from class: com.kwad.sdk.splashscreen.a.g.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ double a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ g f59492b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Double.valueOf(d2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59492b = this;
                        this.a = d2;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            super.onAnimationEnd(animator);
                            if (this.f59492b.f59488i != null) {
                                this.f59492b.f59488i.a(this.f59492b.q(), w0.p0, 2, this.a);
                            }
                        }
                    }
                });
                Vibrator vibrator = this.f59486g;
                if (vibrator != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(a, -1));
                    } else {
                        vibrator.vibrate(a);
                    }
                }
                runnable = new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.g.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g a;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f59485f.a();
                        }
                    }
                };
                j2 = 700;
            }
            ax.a(runnable, null, j2);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSingleTap: " + view);
            if (com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(this.f59481b)) && (gVar = this.f59488i) != null) {
                gVar.a(q(), 158, 1);
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSlide: enableSlickClick: " + this.f59487h);
            if (this.f59487h && (gVar = this.f59488i) != null) {
                gVar.a(view.getContext(), 153, 1);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onUnbind");
            com.kwad.sdk.core.g.b bVar = this.f59485f;
            if (bVar != null) {
                bVar.b(q());
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.c_();
            Context q = q();
            if (q != null) {
                this.f59486g = (Vibrator) q.getSystemService("vibrator");
            }
            this.f59482c = a(R.id.ksad_shake_layout);
            this.f59484e = (TextView) a(R.id.ksad_shake_action);
            KsShakeView ksShakeView = (KsShakeView) a(R.id.ksad_shake_view);
            this.f59483d = ksShakeView;
            ksShakeView.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onClick: " + view);
            if (!view.equals(this.f59483d) || this.f59488i == null || (adTemplate = this.f59481b) == null || !com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
                return;
            }
            this.f59488i.a(q(), 158, 1);
        }
    }
}
