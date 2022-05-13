package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public RelativeLayout b;
    public LinearGradientView c;
    public BarImageView d;
    public TextView e;
    public FrsHeaderBannerView f;
    public LinearLayout g;
    public ImageView h;
    public View i;
    public TbImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public int o;
    public int p;
    public int q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(zo6 zo6Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo6Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(zo6 zo6Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo6Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public zo6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds42) + UtilHelper.getStatusBarHeight();
        this.p = UtilHelper.getDimenPixelSize(R.dimen.tbds50) + UtilHelper.getStatusBarHeight();
        this.q = UtilHelper.getDimenPixelSize(R.dimen.tbds51) + UtilHelper.getStatusBarHeight();
        if (context == null) {
            return;
        }
        if (UbsABTestHelper.isFrsModifyABTestA()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ec, (ViewGroup) null);
            this.a = inflate;
            this.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d1e);
            this.c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090d21);
            TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d1f);
            this.j = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b32);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a5e);
            this.e = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            ViewCommonUtil.setViewMargin(this.e, -1, this.q, -1, -1);
            this.f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090b21);
            this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090965);
            this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090964);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090967);
            this.k = imageView;
            ViewCommonUtil.setViewMargin(imageView, -1, this.p, -1, -1);
            this.k.setOnClickListener(new a(this, context));
            this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02d7));
            this.d.setStrokeWith(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.d.setShowOval(true);
            this.d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.d.setStrokeColorResId(R.color.CAM_X0201);
            ViewCommonUtil.setViewMargin(this.d, -1, this.o, -1, -1);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080611);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0802d7, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0305, (ViewGroup) null);
        this.a = inflate2;
        this.b = (RelativeLayout) inflate2.findViewById(R.id.obfuscated_res_0x7f090d1e);
        this.c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090d21);
        TbImageView tbImageView2 = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d1f);
        this.j = tbImageView2;
        tbImageView2.setDefaultBgResource(R.color.transparent);
        this.j.setDefaultResource(R.drawable.obfuscated_res_0x7f080f25);
        this.d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b32);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a5e);
        this.e = textView2;
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0101);
        this.f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090b21);
        this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090965);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090964);
        this.i = this.a.findViewById(R.id.obfuscated_res_0x7f090d35);
        this.k = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090967);
        this.l = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090969);
        this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090966);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090968);
        this.k.setOnClickListener(new b(this, context));
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02d7));
        this.d.setStrokeWith(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.d.setShowOval(true);
        this.d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.i, R.drawable.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080611);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f080613, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d9, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.obfuscated_res_0x7f080612, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0802d7, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
