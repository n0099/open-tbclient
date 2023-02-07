package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class o extends com.kwad.components.core.i.e {
    public static /* synthetic */ Interceptable $ic;
    public static o nu;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public b nv;
    public e nw;

    /* loaded from: classes8.dex */
    public interface a extends com.kwad.components.core.webview.b.d.c {
        void M(int i);

        void fQ();
    }

    /* loaded from: classes8.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o ny;
        public a nz;

        public b(@Nullable o oVar, @Nullable a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.nz = aVar;
            this.ny = oVar;
        }

        private void cY() {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (oVar = this.ny) == null) {
                return;
            }
            oVar.dismiss();
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public void G(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                cY();
                a aVar = this.nz;
                if (aVar != null) {
                    aVar.G(z);
                }
            }
        }

        @Override // com.kwad.components.ad.reward.o.a
        public void M(int i) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (aVar = this.nz) == null) {
                return;
            }
            aVar.M(i);
        }

        public final void destroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.ny = null;
            }
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public final void fH() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.nz) == null) {
                return;
            }
            aVar.fH();
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public final void fI() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.o.a
        public void fQ() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.nz) == null) {
                return;
            }
            aVar.fQ();
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View kP;
        public TextView nA;
        public TextView nB;
        public ImageView nC;
        public TextView nD;
        public TextView nE;
        public a nF;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutInflater, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.nL = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0456, viewGroup, false);
            initView();
        }

        private void a(com.kwad.components.ad.reward.model.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
                this.nD.setText(aVar.gJ());
                this.eQ.setText(aVar.getTitle());
                String gE = aVar.gE();
                if (!TextUtils.isEmpty(gE)) {
                    String format = String.format("当前已经有%s预约", gE);
                    int color = this.nL.getResources().getColor(R.color.obfuscated_res_0x7f060784);
                    int indexOf = format.indexOf(gE);
                    SpannableString spannableString = new SpannableString(format);
                    spannableString.setSpan(new ForegroundColorSpan(color), indexOf, gE.length() + indexOf, 17);
                    this.nE.setText(spannableString);
                }
                this.nA.setText(aVar.gF());
                this.nB.setText(aVar.gG());
                KSImageLoader.loadCircleIcon(this.nC, aVar.eL(), this.nC.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c72));
            }
        }

        private void initView() {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (viewGroup = this.nL) == null) {
                return;
            }
            this.kP = viewGroup.findViewById(R.id.obfuscated_res_0x7f0911d8);
            this.nA = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f0911d9);
            this.nB = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f0911da);
            this.nC = (ImageView) this.nL.findViewById(R.id.obfuscated_res_0x7f0911db);
            this.nD = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f0911dd);
            this.eQ = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f0911df);
            this.nE = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f0911de);
            this.kP.setOnClickListener(this);
            this.nB.setOnClickListener(this);
            this.nA.setOnClickListener(this);
            this.nC.setOnClickListener(this);
            this.nD.setOnClickListener(this);
            this.eQ.setOnClickListener(this);
            this.nE.setOnClickListener(this);
        }

        @Override // com.kwad.components.ad.reward.k.d
        public final void a(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uVar) == null) {
                super.a(uVar);
                AdTemplate adTemplate = uVar.getAdTemplate();
                if (adTemplate != null) {
                    a(com.kwad.components.ad.reward.model.a.x(adTemplate));
                }
            }
        }

        public final void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.nF = aVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.nF == null) {
                return;
            }
            if (view2.equals(this.nB)) {
                this.nF.M(38);
            } else if (view2.equals(this.nA)) {
                this.nF.M(37);
            } else if (view2.equals(this.kP)) {
                this.nF.G(false);
            } else if (view2.equals(this.nC) || view2.equals(this.eQ) || view2.equals(this.nD) || view2.equals(this.nE)) {
                this.nF.fQ();
            }
        }

        @Override // com.kwad.components.ad.reward.o.e
        public final void s(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, adTemplate) == null) {
                super.s(adTemplate);
                com.kwad.sdk.core.report.a.c(adTemplate, 19, (JSONObject) null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup es;
        public a nF;
        public KSCornerImageView nG;
        public TextView nH;
        public KsPriceView nI;
        public KsStyledTextButton nJ;
        public View nK;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ViewGroup viewGroup) {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.es = viewGroup;
            initView();
        }

        private void a(com.kwad.components.ad.reward.model.a aVar, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, aVar, adTemplate) == null) {
                this.nJ.setText(aVar.gx());
                this.eQ.setText(aVar.getTitle());
                this.nH.setText(aVar.fO());
                this.nI.f(aVar.getPrice(), aVar.getOriginPrice());
                KSImageLoader.loadImage(this.nG, aVar.eL(), adTemplate);
            }
        }

        private void initView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.nL = (ViewGroup) this.es.findViewById(R.id.obfuscated_res_0x7f091288);
                this.eQ = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f09128c);
                this.nG = (KSCornerImageView) this.es.findViewById(R.id.obfuscated_res_0x7f09128a);
                this.nH = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f091289);
                this.nI = (KsPriceView) this.es.findViewById(R.id.obfuscated_res_0x7f09128b);
                this.nJ = (KsStyledTextButton) this.es.findViewById(R.id.obfuscated_res_0x7f091285);
                this.nK = this.es.findViewById(R.id.obfuscated_res_0x7f091286);
                this.nJ.setOnClickListener(this);
                this.nK.setOnClickListener(this);
                this.nH.setOnClickListener(this);
                this.nI.setOnClickListener(this);
                this.eQ.setOnClickListener(this);
            }
        }

        @Override // com.kwad.components.ad.reward.k.d
        public final void a(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uVar) == null) {
                super.a(uVar);
                a(com.kwad.components.ad.reward.model.a.v(uVar.getAdTemplate()), uVar.getAdTemplate());
            }
        }

        public final void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.nF = aVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.nF == null) {
                return;
            }
            if (view2.equals(this.nK)) {
                this.nF.G(false);
            } else if (view2.equals(this.nJ)) {
                this.nF.M(15);
            } else if (view2.equals(this.nH) || view2.equals(this.eQ) || view2.equals(this.nI)) {
                this.nF.fQ();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class e extends com.kwad.components.ad.reward.k.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView eQ;
        public ViewGroup nL;

        public e() {
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

        public /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.k.d
        public final ViewGroup fR() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nL : (ViewGroup) invokeV.objValue;
        }

        public void s(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            }
        }
    }

    public o() {
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

    public static void a(Activity activity, AdTemplate adTemplate, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, activity, adTemplate, bVar) == null) || adTemplate == null || activity == null || activity.isFinishing()) {
            return;
        }
        nu = new o();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        bVar.ny = nu;
        nu.setArguments(bundle);
        nu.a(bVar);
        try {
            nu.show(activity.getFragmentManager(), "videoEndDialog");
        } catch (Exception unused) {
        }
    }

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bVar) == null) {
            this.nv = bVar;
        }
    }

    public static int r(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return -1;
            }
            if (com.kwad.components.ad.reward.kwai.b.h(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                return 1;
            }
            return com.kwad.sdk.core.response.a.a.aK(adTemplate) ? 2 : -1;
        }
        return invokeL.intValue;
    }

    @Override // com.kwad.components.core.i.e
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        com.kwad.components.core.widget.f fVar;
        View fR;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            try {
                String string = getArguments().getString("key_template_json");
                AdTemplate adTemplate = new AdTemplate();
                this.mAdTemplate = adTemplate;
                adTemplate.parseJson(new JSONObject(string));
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
            if (r(this.mAdTemplate) != 2) {
                fR = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0476, viewGroup, false);
                d dVar = new d((ViewGroup) fR);
                dVar.a(new b(this, this.nv));
                this.nw = dVar;
                fVar = new com.kwad.components.core.widget.f();
            } else {
                c cVar = new c(layoutInflater, viewGroup);
                cVar.a(new b(this, this.nv));
                this.nw = cVar;
                fVar = null;
                fR = cVar.fR();
            }
            this.nw.b(u.D(this.mAdTemplate));
            com.kwad.components.core.m.j.a(fVar, this.nw.fR());
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.ad.reward.o.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ o nx;

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
                    this.nx = this;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                }
            });
            return fR;
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
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            b bVar = this.nv;
            if (bVar != null) {
                bVar.fH();
            }
            e eVar = this.nw;
            if (eVar != null) {
                eVar.s(this.mAdTemplate);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            nu = null;
            b bVar = this.nv;
            if (bVar != null) {
                bVar.destroy();
            }
        }
    }
}
