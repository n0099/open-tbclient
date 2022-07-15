package com.kwad.components.ad.reward.e;

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
import com.baidu.location.BDLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.kwad.components.ad.reward.i.q;
import com.kwad.components.core.h.e;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends e implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, b {
    public static /* synthetic */ Interceptable $ic;
    public static a b;
    public transient /* synthetic */ FieldHolder $fh;
    public q a;
    public AdTemplate c;
    @Nullable
    public b d;

    public a() {
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                String string = getArguments().getString("key_template_json", null);
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(string));
                this.c = adTemplate;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }
    }

    public static void a(Activity activity, b bVar, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, activity, bVar, adTemplate) == null) {
            b = new a();
            Bundle bundle = new Bundle();
            bundle.putString("key_template_json", adTemplate.toJson().toString());
            b.setArguments(bundle);
            b.a(bVar);
            b.show(activity.getFragmentManager(), "playAgainDialog");
        }
    }

    private void a(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            this.d = bVar;
        }
    }

    @Override // com.kwad.components.core.h.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            getDialog().setOnKeyListener(this);
            a();
            if (this.a == null) {
                q qVar = new q(layoutInflater, viewGroup);
                this.a = qVar;
                qVar.a(this);
            }
            return this.a.a();
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.components.ad.reward.e.b
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dismiss();
            b bVar = this.d;
            if (bVar != null) {
                bVar.h();
            }
            com.kwad.sdk.core.report.a.k(this.c, MatroskaExtractor.ID_SIMPLE_BLOCK);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Window window = getDialog().getWindow();
            if (window == null) {
                return;
            }
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getDialog().setOnShowListener(this);
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, dialogInterface, i, keyEvent)) == null) {
            if (i == 4 && keyEvent.getAction() == 1) {
                dismiss();
                b bVar = this.d;
                if (bVar != null) {
                    bVar.h();
                }
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.e.c
    public final void onPlayAgainClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
            b bVar = this.d;
            if (bVar != null) {
                bVar.onPlayAgainClick();
            }
            com.kwad.sdk.core.report.a.k(this.c, BDLocation.TypeServerDecryptError);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dialogInterface) == null) {
            u.b bVar = new u.b();
            bVar.I = 205;
            com.kwad.sdk.core.report.a.a(this.c, (int) BDLocation.TypeServerDecryptError, bVar, (JSONObject) null);
        }
    }
}
