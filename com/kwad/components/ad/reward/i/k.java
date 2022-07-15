package com.kwad.components.ad.reward.i;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
public final class k extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public DialogFragment b;
    public ViewGroup c;
    public KSCornerImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public View i;
    public View j;
    public View k;
    public m.a l;

    public k(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, m.a aVar) {
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
        this.b = dialogFragment;
        this.a = adTemplate;
        this.l = aVar;
        this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0456, viewGroup, false);
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.d = (KSCornerImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091121);
            this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091123);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09111f);
            this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091122);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f091120);
            this.i = this.c.findViewById(R.id.obfuscated_res_0x7f09111c);
            this.j = this.c.findViewById(R.id.obfuscated_res_0x7f09111e);
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f09111d);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.h.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (ViewGroup) invokeV.objValue;
    }

    public final void a(m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            KSImageLoader.loadAppIcon(this.d, cVar.g(), this.a, 4);
            this.e.setText(cVar.b());
            this.f.setText(cVar.h());
            this.g.setText(cVar.i());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.equals(this.i)) {
                this.b.dismiss();
                m.a aVar2 = this.l;
                if (aVar2 != null) {
                    aVar2.b();
                }
            } else if (view2.equals(this.j)) {
                this.b.dismiss();
                m.a aVar3 = this.l;
                if (aVar3 != null) {
                    aVar3.a(false);
                }
            } else if (view2.equals(this.k)) {
                this.b.dismiss();
                m.a aVar4 = this.l;
                if (aVar4 != null) {
                    aVar4.b();
                }
            } else if (view2.equals(this.d)) {
                m.a aVar5 = this.l;
                if (aVar5 != null) {
                    aVar5.a(127, 2);
                }
            } else if (view2.equals(this.e)) {
                m.a aVar6 = this.l;
                if (aVar6 != null) {
                    aVar6.a(128, 2);
                }
            } else if (view2.equals(this.f)) {
                m.a aVar7 = this.l;
                if (aVar7 != null) {
                    aVar7.a(129, 2);
                }
            } else if (!view2.equals(this.h) || (aVar = this.l) == null) {
            } else {
                aVar.a(131, 2);
            }
        }
    }
}
