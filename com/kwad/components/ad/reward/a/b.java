package com.kwad.components.ad.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.a.a;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.core.h.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b extends e implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.a.a a;
    public int[] b;
    public AdTemplate c;
    public a d;

    /* loaded from: classes5.dex */
    public interface a {
        void b();
    }

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

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, activity, adTemplate, aVar, iArr) == null) || adTemplate == null || activity == null) {
            return;
        }
        String jSONObject = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", jSONObject);
        bundle.putIntArray("key_end_location", iArr);
        b bVar = new b();
        bVar.a(aVar);
        bVar.setArguments(bundle);
        bVar.show(activity.getFragmentManager(), "rewardCoupon");
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, aVar) == null) {
            this.d = aVar;
        }
    }

    @Override // com.kwad.components.core.h.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            com.kwad.components.ad.reward.a.a aVar = new com.kwad.components.ad.reward.a.a(layoutInflater.getContext(), viewGroup, this.b);
            this.a = aVar;
            aVar.a(this);
            Window window = getDialog().getWindow();
            if (window != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
                getDialog().setCanceledOnTouchOutside(false);
                window.setLayout(-1, -1);
                window.setDimAmount(0.0f);
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            this.a.b(w.a(this.c));
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.ad.reward.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
            return this.a.a();
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.components.ad.reward.a.a.b
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dismiss();
            a aVar = this.d;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.a.a.b
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dismiss();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                if (arguments.containsKey("key_template_json")) {
                    try {
                        String string = arguments.getString("key_template_json");
                        AdTemplate adTemplate = new AdTemplate();
                        this.c = adTemplate;
                        adTemplate.parseJson(new JSONObject(string));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.b(e);
                    }
                }
                if (arguments.containsKey("key_end_location")) {
                    this.b = arguments.getIntArray("key_end_location");
                }
            }
        }
    }
}
