package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.core.h.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.interstitial.b.c a;
    public AdTemplate b;
    public KSCornerImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.a.d.i(this.b);
            KSImageLoader.loadAppIcon(this.c, com.kwad.sdk.core.response.a.a.aE(i2), this.b, 12);
            this.d.setText(com.kwad.sdk.core.response.a.a.aC(i2));
            this.e.setText(com.kwad.sdk.core.response.a.a.z(i2));
        }
    }

    private void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, view2) == null) {
            this.c = (KSCornerImageView) view2.findViewById(R.id.obfuscated_res_0x7f091061);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091062);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091065);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091066);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091063);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091064);
            this.h = textView;
            com.kwad.sdk.b.kwai.a.a(this, this.c, this.d, this.e, this.f, this.g, textView);
        }
    }

    public static void a(com.kwad.components.ad.interstitial.b.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, cVar) == null) || i) {
            return;
        }
        i = true;
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.a.toJson().toString());
        dVar.setArguments(bundle);
        dVar.b(cVar);
        dVar.show(cVar.c.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void b(com.kwad.components.ad.interstitial.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) {
            this.a = cVar;
        }
    }

    @Override // com.kwad.components.core.h.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            String string = getArguments().getString("KEY_TEMPLATE");
            try {
                AdTemplate adTemplate = new AdTemplate();
                this.b = adTemplate;
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d042c, viewGroup, false);
            a(inflate);
            a();
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Window window = getDialog().getWindow();
            if (window == null) {
                return;
            }
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            setCancelable(false);
            com.kwad.components.ad.interstitial.b.c cVar = this.a;
            if (cVar != null) {
                com.kwad.sdk.core.report.a.c(cVar.a, new JSONObject(), new com.kwad.sdk.core.report.f().c(149).e(9));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.components.ad.interstitial.b.c cVar;
        Context context;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (this.a != null) {
                if (view2.equals(this.c)) {
                    cVar = this.a;
                    context = cVar.c.getContext();
                    i2 = 127;
                } else if (view2.equals(this.d)) {
                    cVar = this.a;
                    context = cVar.c.getContext();
                    i2 = 128;
                } else if (view2.equals(this.e)) {
                    cVar = this.a;
                    context = cVar.c.getContext();
                    i2 = 129;
                } else if (view2.equals(this.f)) {
                    cVar = this.a;
                    context = cVar.c.getContext();
                    i2 = 131;
                } else if (view2.equals(this.g)) {
                    com.kwad.sdk.core.report.a.b(this.a.a, (JSONObject) null, new com.kwad.sdk.core.report.f().e(9));
                } else if (view2.equals(this.h)) {
                    this.a.c.dismiss();
                    com.kwad.sdk.core.report.a.a(this.a.a, new com.kwad.sdk.core.report.f().c(Cea708Decoder.COMMAND_SWA).e(9));
                }
                cVar.a(context, i2, 2, 9);
            }
            dismiss();
            i = false;
        }
    }
}
