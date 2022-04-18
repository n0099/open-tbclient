package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class of8 extends pf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ms7 F;
    public View G;
    public View H;
    public View I;
    public View J;
    public TbImageView K;
    public LinearLayout L;
    public TbImageView M;
    public TextView N;
    public View O;
    public ImageView P;
    public TextView Q;
    public TextView R;
    public TbImageView S;
    public View T;
    public TextView U;
    public TextView V;
    public LinearLayout W;
    public PlayVoiceBntNew X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public of8(Context context, boolean z, int i, ms7 ms7Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), ms7Var};
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
        this.F = ms7Var;
        this.G = this.b.findViewById(R.id.obfuscated_res_0x7f091718);
        this.H = this.b.findViewById(R.id.obfuscated_res_0x7f091716);
        this.I = this.b.findViewById(R.id.obfuscated_res_0x7f091715);
        this.J = this.b.findViewById(R.id.obfuscated_res_0x7f091717);
        this.K = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091719);
        this.L = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091720);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09171f);
        this.M = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.M.setConrers(15);
        this.M.setRadius(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.M.setGifIconSupport(false);
        this.M.setLongIconSupport(false);
        this.N = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091618);
        this.O = this.b.findViewById(R.id.obfuscated_res_0x7f09171e);
        this.P = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09171a);
        this.Q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918bc);
        this.R = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b9);
        this.S = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b8);
        this.T = this.b.findViewById(R.id.obfuscated_res_0x7f0918bb);
        this.U = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918ba);
        this.V = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b2);
        this.W = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0918b1);
        this.X = (PlayVoiceBntNew) this.b.findViewById(R.id.obfuscated_res_0x7f0918b3);
        f0(context, ms7Var.c().P());
        k0();
        R(2);
    }

    @Override // com.repackage.pf8
    public void T(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // com.repackage.pf8
    public void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.F == null) {
            return;
        }
        this.G.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.J, oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.L.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.N, (int) R.color.CAM_X0107);
        this.N.setText(this.F.b());
        g0();
        SkinManager.setBackgroundColor(this.T, R.color.CAM_X0109);
        String name_show = this.F.c().s().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
        }
        this.U.setText(name_show);
        SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.Q, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.R, (int) R.color.CAM_X0105);
        this.S.setImageBitmap(this.F.d());
        SkinManager.setImageResource(this.K, R.drawable.obfuscated_res_0x7f080f49);
        S(false);
        super.V();
    }

    public final void e0(Context context, List<TbRichTextImageInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, list) == null) {
            int i = 0;
            while (i < list.size() && i != 9) {
                this.W.addView(h0(context, i0(list.get(i), this.F.a()), list.get(i), i == 0, this.F.a().r));
                i++;
            }
        }
    }

    public void f0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, tbRichText) == null) || tbRichText == null || tbRichText.A() == null || tbRichText.A().isEmpty()) {
            return;
        }
        Iterator<TbRichTextData> it = tbRichText.A().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                int type = next.getType();
                if (type != 1) {
                    if (type == 512) {
                        this.X.setVoiceModel((VoiceData.VoiceModel) next.O().A());
                        if (this.V.getVisibility() == 0 || this.W.getVisibility() == 0) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.X.getLayoutParams();
                            if (this.V.getVisibility() == 0 && this.W.getVisibility() == 8) {
                                layoutParams.topMargin = oi.f(context, R.dimen.tbds39);
                            } else {
                                layoutParams.topMargin = oi.f(context, R.dimen.tbds42);
                            }
                            this.X.setLayoutParams(layoutParams);
                        }
                        this.X.setVisibility(0);
                    }
                } else if (this.V.getVisibility() == 8) {
                    SkinManager.setViewTextColor(this.V, (int) R.color.CAM_X0105);
                    this.V.setText(next.I());
                    this.V.setVisibility(0);
                }
            }
        }
        if (tbRichText.C().isEmpty()) {
            return;
        }
        if (this.V.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.W.getLayoutParams();
            layoutParams2.topMargin = oi.f(context, R.dimen.tbds37);
            this.W.setLayoutParams(layoutParams2);
        }
        this.W.setVisibility(0);
        e0(context, tbRichText.C());
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int f = this.F.f();
            if (f == 0) {
                if (!StringUtils.isNull(this.F.e())) {
                    this.M.K(this.F.e(), 10, false);
                    return;
                }
                this.M.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080899));
                this.M.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f == 11) {
                this.M.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f08089a));
                this.M.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f != 40) {
            } else {
                this.O.setVisibility(0);
                this.P.setVisibility(0);
                this.P.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f08089b));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.O);
                this.M.K(this.F.e(), 10, false);
            }
        }
    }

    public final TbImageView h0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] l0 = l0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l0[0], l0[1]);
            if (!z) {
                layoutParams.setMargins(0, oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.G()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            tbImageView.K(str, z2 ? 17 : 18, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    public final String i0(TbRichTextImageInfo tbRichTextImageInfo, af5 af5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tbRichTextImageInfo, af5Var)) == null) ? af5Var.c() ? tbRichTextImageInfo.y() : tbRichTextImageInfo.A() : (String) invokeLL.objValue;
    }

    public final Bitmap j0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            createBitmap.eraseColor(SkinManager.getColor(R.color.CAM_X0206));
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final int[] l0(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i3;
            float f = (i * 1.0f) / (i3 * 1.0f);
            iArr[1] = (int) (f <= 1.0f ? i2 / f : i2 * f);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    @Override // com.repackage.pf8
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0696, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // com.repackage.pf8
    public ShareItem t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            ShareItem shareItem = this.u.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.s = "";
            shareItem.b0 = 1;
            shareItem.i(j0(this.H));
            shareItem.g();
            this.u.put(1, shareItem);
            return super.t(i);
        }
        return (ShareItem) invokeI.objValue;
    }
}
