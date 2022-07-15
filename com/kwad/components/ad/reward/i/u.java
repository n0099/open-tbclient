package com.kwad.components.ad.reward.i;

import android.app.DialogFragment;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.m;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class u extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public LayoutInflater b;
    public ViewGroup c;
    public DialogFragment d;
    public ViewGroup e;
    public KSCornerImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public View l;
    public View m;
    public Context n;
    public m.a o;

    public u(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dialogFragment, adTemplate, layoutInflater, viewGroup, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = dialogFragment;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.a = adTemplate;
        this.o = aVar;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0462, viewGroup, false);
        this.e = viewGroup2;
        this.n = viewGroup2.getContext();
        c();
    }

    private SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.n.getResources().getColor(R.color.obfuscated_res_0x7f06075f));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(this.n.getResources().getColor(R.color.obfuscated_res_0x7f06075f));
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableString.length();
            spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
            spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
            spannableString.setSpan(styleSpan, 0, length, 34);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f = (KSCornerImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09117b);
            this.g = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09117d);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091179);
            this.i = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09117c);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09117a);
            this.k = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09116d);
            this.l = this.e.findViewById(R.id.obfuscated_res_0x7f091178);
            this.m = this.e.findViewById(R.id.obfuscated_res_0x7f091177);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (ViewGroup) invokeV.objValue;
    }

    public final void a(m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            KSImageLoader.loadAppIcon(this.f, cVar.g(), this.a, 12);
            this.g.setText(cVar.b());
            this.h.setText(cVar.h());
            this.i.setText(a(cVar.j));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.equals(this.l)) {
                this.d.dismiss();
                m.a aVar2 = this.o;
                if (aVar2 != null) {
                    aVar2.a(false);
                }
            } else if (view2.equals(this.m)) {
                this.d.dismiss();
                m.a aVar3 = this.o;
                if (aVar3 != null) {
                    aVar3.b();
                }
            } else if ((view2.equals(this.j) || view2.equals(this.k)) && (aVar = this.o) != null) {
                aVar.a(131, 2);
            }
        }
    }
}
