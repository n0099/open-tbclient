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
/* loaded from: classes7.dex */
public final class d extends com.kwad.components.core.i.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static boolean iy;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView eQ;
    public com.kwad.components.ad.interstitial.b.c gh;
    public KSCornerImageView it;
    public TextView iu;
    public TextView iv;
    public TextView iw;
    public TextView ix;
    public AdTemplate mAdTemplate;

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
            }
        }
    }

    public static void d(com.kwad.components.ad.interstitial.b.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, cVar) == null) || iy) {
            return;
        }
        iy = true;
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        dVar.setArguments(bundle);
        dVar.e(cVar);
        dVar.show(cVar.gi.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void dT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            KSImageLoader.loadAppIcon(this.it, com.kwad.sdk.core.response.a.a.bn(bQ), this.mAdTemplate, 12);
            this.eQ.setText(com.kwad.sdk.core.response.a.a.bl(bQ));
            this.iu.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
        }
    }

    private void e(com.kwad.components.ad.interstitial.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, cVar) == null) {
            this.gh = cVar;
        }
    }

    private void h(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2) == null) {
            this.it = (KSCornerImageView) view2.findViewById(R.id.obfuscated_res_0x7f091104);
            this.eQ = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091105);
            this.iu = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091108);
            this.iv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091109);
            this.iw = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091106);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091107);
            this.ix = textView;
            com.kwad.sdk.b.kwai.a.a(this, this.it, this.eQ, this.iu, this.iv, this.iw, textView);
        }
    }

    @Override // com.kwad.components.core.i.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            String string = getArguments().getString("KEY_TEMPLATE");
            try {
                AdTemplate adTemplate = new AdTemplate();
                this.mAdTemplate = adTemplate;
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d043d, viewGroup, false);
            h(inflate);
            dT();
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
            com.kwad.components.ad.interstitial.b.c cVar = this.gh;
            if (cVar != null) {
                com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.report.f().aK(149).aM(9));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.components.ad.interstitial.b.c cVar;
        Context context;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (this.gh != null) {
                if (view2.equals(this.it)) {
                    cVar = this.gh;
                    context = cVar.gi.getContext();
                    i = 127;
                } else if (view2.equals(this.eQ)) {
                    cVar = this.gh;
                    context = cVar.gi.getContext();
                    i = 128;
                } else if (view2.equals(this.iu)) {
                    cVar = this.gh;
                    context = cVar.gi.getContext();
                    i = 129;
                } else if (view2.equals(this.iv)) {
                    cVar = this.gh;
                    context = cVar.gi.getContext();
                    i = 131;
                } else if (view2.equals(this.iw)) {
                    com.kwad.sdk.core.report.a.c(this.gh.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.f().aM(9));
                } else if (view2.equals(this.ix)) {
                    this.gh.gi.dismiss();
                    com.kwad.sdk.core.report.a.a(this.gh.mAdTemplate, new com.kwad.sdk.core.report.f().aK(Cea708Decoder.COMMAND_SWA).aM(9));
                }
                cVar.a(context, i, 2, 9);
            }
            dismiss();
            iy = false;
        }
    }
}
