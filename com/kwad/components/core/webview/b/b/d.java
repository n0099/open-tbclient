package com.kwad.components.core.webview.b.b;

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
import com.kwad.components.core.i.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public class d extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.webview.b.b.b Ob;
    public String Od;
    public boolean Oe;
    public com.kwad.components.core.webview.b.d.c Of;
    public a Og;
    public com.kwad.components.core.webview.b.d.d Ok;
    public KSFrameLayout Om;
    public DialogInterface.OnDismissListener On;
    public boolean Oo;
    public AdTemplate mAdTemplate;
    public Presenter mPresenter;

    /* loaded from: classes8.dex */
    public interface a {
        boolean fG();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean Oe;
        public boolean Oo;
        public AdTemplate mAdTemplate;
        public String templateId;

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

        public final void aE(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.Oe = z;
            }
        }

        public final void aF(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.Oo = true;
            }
        }

        public final void aI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.templateId = str;
            }
        }

        public final AdTemplate getAdTemplate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
        }

        public final String getTemplateId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.templateId : (String) invokeV.objValue;
        }

        public final boolean pP() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.Oe : invokeV.booleanValue;
        }

        public final boolean pQ() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Oo : invokeV.booleanValue;
        }

        public final void setAdTemplate(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adTemplate) == null) {
                this.mAdTemplate = adTemplate;
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
        this.Oo = false;
    }

    private Presenter ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Presenter presenter = new Presenter();
            this.mPresenter = presenter;
            presenter.a(in());
            return this.mPresenter;
        }
        return (Presenter) invokeV.objValue;
    }

    public static d b(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            d dVar = new d();
            dVar.mAdTemplate = bVar.getAdTemplate();
            dVar.Od = bVar.getTemplateId();
            dVar.Oe = bVar.Oe;
            dVar.Oo = bVar.Oo;
            Bundle bundle = new Bundle();
            bundle.putString("templateId", bVar.getTemplateId());
            dVar.setArguments(bundle);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    private void v(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, view2) == null) {
            if (this.mPresenter == null) {
                Presenter ap = ap();
                this.mPresenter = ap;
                ap.B(view2);
                this.Ob = im();
            }
            io();
            this.mPresenter.e(this.Ob);
        }
    }

    @Override // com.kwad.components.core.i.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            if (this.Om == null) {
                this.Om = (KSFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d049d, viewGroup, false);
            }
            return this.Om;
        }
        return (View) invokeLL.objValue;
    }

    public final void a(com.kwad.components.core.webview.b.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.Ok = dVar;
        }
    }

    public com.kwad.components.core.webview.b.b.b im() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new com.kwad.components.core.webview.b.b.b() : (com.kwad.components.core.webview.b.b.b) invokeV.objValue;
    }

    public c in() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c() : (c) invokeV.objValue;
    }

    public void io() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.Ob.mActivity = getActivity2();
            com.kwad.components.core.webview.b.b.b bVar = this.Ob;
            bVar.Ne = this;
            bVar.Oc = this.Om;
            bVar.mAdTemplate = this.mAdTemplate;
            bVar.Od = this.Od;
            bVar.Oe = this.Oe;
            bVar.Og = this.Og;
            bVar.Of = this.Of;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            try {
                super.onActivityCreated(bundle);
            } catch (Throwable unused) {
            }
            if (getDialog() == null || (window = getDialog().getWindow()) == null) {
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
            if (this.Oo) {
                getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.core.webview.b.b.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d Op;

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
                        this.Op = this;
                    }

                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        InterceptResult invokeLIL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                    }
                });
            }
            window.setFlags(1024, 1024);
            if (this.Oo) {
                getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.core.webview.b.b.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d Op;

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
                        this.Op = this;
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
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.Od = getArguments().getString("templateId");
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
                this.mPresenter = null;
            }
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroyView();
            KSFrameLayout kSFrameLayout = this.Om;
            if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.Om.getParent()).removeView(this.Om);
                this.Om = null;
            }
            com.kwad.components.core.webview.b.d.d dVar = this.Ok;
            if (dVar != null) {
                dVar.pO();
            }
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
            DialogInterface.OnDismissListener onDismissListener = this.On;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            v(view2);
            com.kwad.components.core.webview.b.d.c cVar = this.Of;
            if (cVar != null) {
                cVar.fH();
            }
            com.kwad.components.core.webview.b.d.d dVar = this.Ok;
            if (dVar != null) {
                dVar.fH();
            }
        }
    }
}
