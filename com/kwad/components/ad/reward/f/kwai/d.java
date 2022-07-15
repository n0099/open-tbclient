package com.kwad.components.ad.reward.f.kwai;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.h.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public final class d extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Presenter a;
    public com.kwad.components.ad.reward.f.kwai.b b;
    public KSFrameLayout c;
    public AdTemplate d;
    public String e;
    public long f;
    public boolean g;
    public com.kwad.components.ad.reward.e h;
    public a i;
    public boolean j;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdTemplate a;
        public String b;
        public boolean c;
        public boolean d;

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
                }
            }
        }

        public final AdTemplate a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (AdTemplate) invokeV.objValue;
        }

        public final void a(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
                this.a = adTemplate;
            }
        }

        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.b = str;
            }
        }

        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.c = z;
            }
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public final void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.d = true;
            }
        }
    }

    public d() {
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
        this.j = false;
    }

    public static d a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            d dVar = new d();
            dVar.d = bVar.a();
            dVar.e = bVar.b();
            dVar.g = bVar.c;
            dVar.j = bVar.d;
            Bundle bundle = new Bundle();
            bundle.putString("templateId", bVar.b());
            dVar.setArguments(bundle);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public static d a(d dVar, Activity activity, long j, com.kwad.components.ad.reward.e eVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{dVar, activity, Long.valueOf(j), eVar, aVar})) == null) {
            dVar.h = eVar;
            dVar.i = aVar;
            dVar.show(activity.getFragmentManager(), "tkCloseDialog");
            if (j > 0) {
                dVar.a(j);
            }
            return dVar;
        }
        return (d) invokeCommon.objValue;
    }

    private Presenter a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Presenter presenter = new Presenter();
            this.a = presenter;
            presenter.a((Presenter) new c());
            return this.a;
        }
        return (Presenter) invokeV.objValue;
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j) == null) {
            this.f = j;
            com.kwad.components.ad.reward.f.kwai.b bVar = this.b;
            if (bVar != null) {
                bVar.f = j;
            }
        }
    }

    private void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, view2) == null) {
            if (this.a == null) {
                Presenter a2 = a();
                this.a = a2;
                a2.c(view2);
                this.b = new com.kwad.components.ad.reward.f.kwai.b();
            }
            b();
            this.a.a(this.b);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.b.e = getActivity2();
            com.kwad.components.ad.reward.f.kwai.b bVar = this.b;
            bVar.a = this;
            bVar.b = this.c;
            bVar.c = this.d;
            bVar.d = this.e;
            bVar.f = this.f;
            bVar.g = this.g;
            bVar.i = this.i;
            bVar.h = this.h;
        }
    }

    @Override // com.kwad.components.core.h.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            if (this.c == null) {
                this.c = (KSFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d047f, viewGroup, false);
            }
            return this.c;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Window window = getDialog().getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
            getDialog().setCanceledOnTouchOutside(false);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            window.setSoftInputMode(16);
            window.setFlags(1024, 1024);
            if (this.j) {
                getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.ad.reward.f.kwai.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d a;

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

                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        InterceptResult invokeLIL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                    }
                });
            }
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.e = getArguments().getString("templateId");
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            Presenter presenter = this.a;
            if (presenter != null) {
                presenter.p();
                this.a = null;
            }
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroyView();
            KSFrameLayout kSFrameLayout = this.c;
            if (kSFrameLayout == null || !(kSFrameLayout.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) this.c.getParent()).removeView(this.c);
            this.c = null;
        }
    }

    @Override // android.app.Fragment
    public final void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            a(view2);
            com.kwad.components.ad.reward.e eVar = this.h;
            if (eVar != null) {
                eVar.a();
            }
        }
    }
}
