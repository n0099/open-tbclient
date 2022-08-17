package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes5.dex */
public final class l extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView eQ;
    public ImageView nC;
    public ViewGroup nL;
    public l.a nf;
    public View vA;
    public View vB;
    public DialogFragment vf;
    public View vj;
    public View vy;
    public TextView vz;

    public l(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dialogFragment, layoutInflater, viewGroup, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vf = dialogFragment;
        this.nf = aVar;
        this.nL = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0439, viewGroup, false);
        initView();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.vy = this.nL.findViewById(R.id.obfuscated_res_0x7f0910d1);
            this.eQ = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f0910d6);
            this.nC = (ImageView) this.nL.findViewById(R.id.obfuscated_res_0x7f0910d5);
            this.vz = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f0910d4);
            this.vj = this.nL.findViewById(R.id.obfuscated_res_0x7f0910d2);
            this.vB = this.nL.findViewById(R.id.obfuscated_res_0x7f0910d3);
            this.vA = this.nL.findViewById(R.id.obfuscated_res_0x7f0910d7);
            this.vy.setOnClickListener(this);
            this.vj.setOnClickListener(this);
            this.vB.setOnClickListener(this);
            this.vA.setOnClickListener(this);
        }
    }

    public final void a(l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            KSImageLoader.loadCircleIcon(this.nC, cVar.eL(), this.nL.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bf8));
            String title = cVar.getTitle();
            if (this.eQ != null && title != null) {
                SpannableString spannableString = new SpannableString(title);
                int color = fR().getResources().getColor(R.color.obfuscated_res_0x7f06076e);
                spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                int length = title.length();
                spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
                this.eQ.setText(spannableString);
            }
            this.vz.setText(cVar.fO());
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.nL : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        l.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.equals(this.vy)) {
                this.vf.dismiss();
                l.a aVar2 = this.nf;
                if (aVar2 != null) {
                    aVar2.fI();
                }
            } else if (view2.equals(this.vj)) {
                this.vf.dismiss();
                l.a aVar3 = this.nf;
                if (aVar3 != null) {
                    aVar3.fI();
                }
            } else if (!view2.equals(this.vB)) {
                if (!view2.equals(this.vA) || (aVar = this.nf) == null) {
                    return;
                }
                aVar.g(131, 2);
            } else {
                this.vf.dismiss();
                l.a aVar4 = this.nf;
                if (aVar4 != null) {
                    aVar4.G(false);
                }
            }
        }
    }
}
