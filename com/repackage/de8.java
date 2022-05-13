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
/* loaded from: classes5.dex */
public class de8 extends ee8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ms7 R;
    public View S;
    public View T;
    public View U;
    public View V;
    public TbImageView W;
    public LinearLayout X;
    public TbImageView Y;
    public TextView Z;
    public View g0;
    public ImageView h0;
    public TextView i0;
    public TextView j0;
    public TbImageView k0;
    public View l0;
    public TextView m0;
    public TextView n0;
    public LinearLayout o0;
    public PlayVoiceBntNew p0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de8(Context context, boolean z, int i, ms7 ms7Var) {
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
        this.R = ms7Var;
        this.S = this.b.findViewById(R.id.obfuscated_res_0x7f091740);
        this.T = this.b.findViewById(R.id.obfuscated_res_0x7f09173e);
        this.U = this.b.findViewById(R.id.obfuscated_res_0x7f09173d);
        this.V = this.b.findViewById(R.id.obfuscated_res_0x7f09173f);
        this.W = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091741);
        this.X = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091748);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091747);
        this.Y = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.Y.setConrers(15);
        this.Y.setRadius(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.Y.setGifIconSupport(false);
        this.Y.setLongIconSupport(false);
        this.Z = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09162f);
        this.g0 = this.b.findViewById(R.id.obfuscated_res_0x7f091746);
        this.h0 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091742);
        this.i0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091914);
        this.j0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091911);
        this.k0 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091910);
        this.l0 = this.b.findViewById(R.id.obfuscated_res_0x7f091913);
        this.m0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091912);
        this.n0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09190a);
        this.o0 = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091909);
        this.p0 = (PlayVoiceBntNew) this.b.findViewById(R.id.obfuscated_res_0x7f09190b);
        y0(context, ms7Var.c().P());
        D0();
        g0(2);
    }

    public final TbImageView A0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] E0 = E0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(E0[0], E0[1]);
            if (!z) {
                layoutParams.setMargins(0, mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.G()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            tbImageView.K(str, z2 ? 17 : 18, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    @Override // com.repackage.ee8
    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0688, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final String B0(TbRichTextImageInfo tbRichTextImageInfo, tf5 tf5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextImageInfo, tf5Var)) == null) ? tf5Var.c() ? tbRichTextImageInfo.y() : tbRichTextImageInfo.A() : (String) invokeLL.objValue;
    }

    public final Bitmap C0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
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

    @Override // com.repackage.ee8
    public ShareItem D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ShareItem shareItem = this.B.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.m0 = false;
            shareItem.l0 = false;
            shareItem.u = "";
            shareItem.f0 = 1;
            shareItem.i(C0(this.T));
            shareItem.g();
            this.B.put(1, shareItem);
            return super.D(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final int[] E0(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048582, this, i, i2, i3)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i3;
            float f = (i * 1.0f) / (i3 * 1.0f);
            iArr[1] = (int) (f <= 1.0f ? i2 / f : i2 * f);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    @Override // com.repackage.ee8
    public void j0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // com.repackage.ee8
    public void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.R == null) {
            return;
        }
        this.S.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.V, mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.X.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.Z, (int) R.color.CAM_X0107);
        this.Z.setText(this.R.b());
        z0();
        SkinManager.setBackgroundColor(this.l0, R.color.CAM_X0109);
        String name_show = this.R.c().s().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
        }
        this.m0.setText(name_show);
        SkinManager.setViewTextColor(this.m0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i0, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.j0, (int) R.color.CAM_X0105);
        this.k0.setImageBitmap(this.R.d());
        SkinManager.setImageResource(this.W, R.drawable.obfuscated_res_0x7f080f5f);
        i0(false);
        super.l0();
    }

    public final void x0(Context context, List<TbRichTextImageInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, list) == null) {
            int i = 0;
            while (i < list.size() && i != 9) {
                this.o0.addView(A0(context, B0(list.get(i), this.R.a()), list.get(i), i == 0, this.R.a().s));
                i++;
            }
        }
    }

    public void y0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, context, tbRichText) == null) || tbRichText == null || tbRichText.A() == null || tbRichText.A().isEmpty()) {
            return;
        }
        Iterator<TbRichTextData> it = tbRichText.A().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                int type = next.getType();
                if (type != 1) {
                    if (type == 512) {
                        this.p0.setVoiceModel((VoiceData.VoiceModel) next.O().A());
                        if (this.n0.getVisibility() == 0 || this.o0.getVisibility() == 0) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p0.getLayoutParams();
                            if (this.n0.getVisibility() == 0 && this.o0.getVisibility() == 8) {
                                layoutParams.topMargin = mi.f(context, R.dimen.tbds39);
                            } else {
                                layoutParams.topMargin = mi.f(context, R.dimen.tbds42);
                            }
                            this.p0.setLayoutParams(layoutParams);
                        }
                        this.p0.setVisibility(0);
                    }
                } else if (this.n0.getVisibility() == 8) {
                    SkinManager.setViewTextColor(this.n0, (int) R.color.CAM_X0105);
                    this.n0.setText(next.I());
                    this.n0.setVisibility(0);
                }
            }
        }
        if (tbRichText.C().isEmpty()) {
            return;
        }
        if (this.n0.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o0.getLayoutParams();
            layoutParams2.topMargin = mi.f(context, R.dimen.tbds37);
            this.o0.setLayoutParams(layoutParams2);
        }
        this.o0.setVisibility(0);
        x0(context, tbRichText.C());
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int f = this.R.f();
            if (f == 0) {
                if (!StringUtils.isNull(this.R.e())) {
                    this.Y.K(this.R.e(), 10, false);
                    return;
                }
                this.Y.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f08089b));
                this.Y.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f == 11) {
                this.Y.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f08089c));
                this.Y.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f != 40) {
            } else {
                this.g0.setVisibility(0);
                this.h0.setVisibility(0);
                this.h0.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f08089d));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.g0);
                this.Y.K(this.R.e(), 10, false);
            }
        }
    }
}
