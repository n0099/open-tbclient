package com.repackage;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BarImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public EntelechyUserLikeButton f;
    public View g;
    public int h;
    public int i;

    public nj6(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.a = view2;
        this.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090af2);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090af5);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090af3);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090af4);
        this.f = (EntelechyUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090af0);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f090af1);
    }
}
