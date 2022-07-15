package com.kwad.components.ad.reward.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.KsStyledTextButton;
/* loaded from: classes5.dex */
public final class q extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public KsStyledTextButton b;
    public View c;
    @Nullable
    public com.kwad.components.ad.reward.e.b d;

    public q(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {layoutInflater, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d043e, viewGroup, false);
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = (KsStyledTextButton) this.a.findViewById(R.id.obfuscated_res_0x7f09109f);
            this.c = this.a.findViewById(R.id.obfuscated_res_0x7f0910a0);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ViewGroup) invokeV.objValue;
    }

    public final void a(@Nullable com.kwad.components.ad.reward.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.d == null) {
            return;
        }
        if (view2.equals(this.b)) {
            this.d.onPlayAgainClick();
        } else if (view2.equals(this.c)) {
            this.d.h();
        }
    }
}
