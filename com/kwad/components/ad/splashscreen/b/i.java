package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.az;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class i extends h implements com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public KsRotateView c;
    public TextView d;
    public TextView e;
    public com.kwad.sdk.core.f.c f;
    public com.kwad.components.ad.splashscreen.e g;
    public Runnable h;

    public i() {
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
        this.h = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.i.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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
                    this.a.f.a();
                }
            }
        };
    }

    @Override // com.kwad.components.ad.splashscreen.b.h, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar != null) {
                hVar.a(this);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void a(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (textView = this.e) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.kwad.sdk.core.f.a
    public final void b(String str) {
        Runnable runnable;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            boolean e = ((e) this).a.h.e();
            boolean a = com.kwad.components.core.c.kwai.b.a();
            if (!e || a) {
                runnable = this.h;
                j = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
            } else {
                this.c.g();
                com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
                if (hVar != null) {
                    hVar.a(u(), 161, 2, new h.a(this, str) { // from class: com.kwad.components.ad.splashscreen.b.i.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;
                        public final /* synthetic */ i b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
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
                            this.a = str;
                        }

                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void a(@NonNull com.kwad.sdk.core.report.f fVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, fVar) == null) {
                                fVar.b(this.a);
                            }
                        }
                    });
                }
                m();
                runnable = this.h;
                j = 2000;
            }
            az.a(runnable, null, j);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = ((ViewStub) b(R.id.obfuscated_res_0x7f091184)).inflate();
            this.d = (TextView) b(R.id.obfuscated_res_0x7f091185);
            this.e = (TextView) b(R.id.obfuscated_res_0x7f091183);
            this.c = (KsRotateView) b(R.id.obfuscated_res_0x7f091186);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void e() {
        com.kwad.sdk.core.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f) == null) {
            return;
        }
        cVar.b(u());
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(((e) this).a.c);
            u();
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            com.kwad.components.ad.splashscreen.e a = com.kwad.components.ad.splashscreen.e.a(hVar.c, i, hVar.f, 1);
            this.g = a;
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(a.b());
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setText(this.g.a());
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void h() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (view2 = this.b) == null || ((e) this).a == null) {
            return;
        }
        view2.setVisibility(0);
        com.kwad.sdk.core.report.a.c(((e) this).a.c, (int) H262Reader.START_GROUP, (JSONObject) null);
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.kwad.components.ad.splashscreen.local.b.c(u());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdMatrixInfo.RotateInfo v = com.kwad.sdk.core.response.a.b.v(((e) this).a.c);
            com.kwad.sdk.core.f.c cVar = this.f;
            if (cVar != null) {
                cVar.a(v);
                return;
            }
            com.kwad.sdk.core.f.c cVar2 = new com.kwad.sdk.core.f.c(v);
            this.f = cVar2;
            cVar2.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.a(u());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h, com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.k_();
            com.kwad.sdk.core.d.b.a("SplashRotatePresenter", "onUnbind");
            com.kwad.sdk.core.f.c cVar = this.f;
            if (cVar != null) {
                cVar.b(u());
            }
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar != null) {
                hVar.b(this);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i a;

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

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.c.c();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.f.a
    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.kwad.sdk.core.report.a.k(((e) this).a.c);
        }
    }
}
