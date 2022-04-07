package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jf8 extends if8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context F;
    public xh8 G;
    public RoundRelativeLayout H;
    public TbImageView I;
    public TextView J;
    public TextView K;
    public RoundRelativeLayout L;
    public TbImageView M;
    public TextView N;
    public TextView O;
    public ImageView P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jf8(Context context, boolean z, int i, xh8 xh8Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), xh8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = context;
        this.G = xh8Var;
        f0();
        R(2);
    }

    @Override // com.repackage.if8
    public void T(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // com.repackage.if8
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.G != null) {
                g0(this.I);
                this.M.setImageBitmap(this.G.a());
                this.J.setText(this.G.d());
            }
            WebPManager.setPureDrawable(this.P, R.drawable.obfuscated_res_0x7f080984, R.color.CAM_X0101, null);
            wr4.d(this.N).v(R.color.CAM_X0101);
            wr4.d(this.O).v(R.color.CAM_X0101);
            wr4 d = wr4.d(this.J);
            d.A(R.string.F_X02);
            d.v(R.color.CAM_X0102);
            wr4.d(this.K).v(R.color.CAM_X0103);
            super.V();
        }
    }

    public final Bitmap e0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.H = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091d80);
            this.I = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091d7f);
            this.L = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0911ed);
            this.M = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091d83);
            this.J = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d82);
            this.K = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d81);
            this.N = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0921f5);
            this.O = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0921f4);
            this.P = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090ed3);
            h0();
            this.H.setRoundLayoutRadius(ur4.y(R.string.J_X06));
            this.L.setRoundLayoutRadius(ur4.y(R.string.J_X04));
        }
    }

    public final void g0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        if (this.G.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a1f);
        } else if (this.G.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080b8b);
        } else if (this.G.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a20);
        } else if (this.G.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a23);
        } else {
            tbImageView.K(this.G.c(), 10, false);
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int k = (oi.k(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i = (k * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = i;
            }
            this.H.setLayoutParams(layoutParams);
            int i2 = (k * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.I.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
            this.I.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.repackage.if8
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d07aa, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // com.repackage.if8
    public ShareItem t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ShareItem shareItem = this.u.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.s = "";
            shareItem.b0 = 1;
            shareItem.i(e0(this.H));
            shareItem.g();
            this.u.put(1, shareItem);
            return super.t(i);
        }
        return (ShareItem) invokeI.objValue;
    }
}
