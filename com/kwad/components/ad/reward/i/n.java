package com.kwad.components.ad.reward.i;

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
import com.kwad.components.ad.reward.m;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes5.dex */
public final class n extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public View b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public DialogFragment i;
    public m.a j;

    public n(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, m.a aVar) {
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
        this.i = dialogFragment;
        this.j = aVar;
        this.a = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0436, viewGroup, false);
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091081);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091086);
            this.d = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091085);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091084);
            this.f = this.a.findViewById(R.id.obfuscated_res_0x7f091082);
            this.h = this.a.findViewById(R.id.obfuscated_res_0x7f091083);
            this.g = this.a.findViewById(R.id.obfuscated_res_0x7f091087);
            this.b.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.g.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ViewGroup) invokeV.objValue;
    }

    public final void a(m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            KSImageLoader.loadCircleIcon(this.d, cVar.g(), this.a.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bd1));
            String b = cVar.b();
            if (this.c != null && b != null) {
                SpannableString spannableString = new SpannableString(b);
                int color = a().getResources().getColor(R.color.obfuscated_res_0x7f06075f);
                spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                int length = b.length();
                spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
                this.c.setText(spannableString);
            }
            this.e.setText(cVar.h());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.equals(this.b)) {
                this.i.dismiss();
                m.a aVar2 = this.j;
                if (aVar2 != null) {
                    aVar2.b();
                }
            } else if (view2.equals(this.f)) {
                this.i.dismiss();
                m.a aVar3 = this.j;
                if (aVar3 != null) {
                    aVar3.b();
                }
            } else if (!view2.equals(this.h)) {
                if (!view2.equals(this.g) || (aVar = this.j) == null) {
                    return;
                }
                aVar.a(131, 2);
            } else {
                this.i.dismiss();
                m.a aVar4 = this.j;
                if (aVar4 != null) {
                    aVar4.a(false);
                }
            }
        }
    }
}
