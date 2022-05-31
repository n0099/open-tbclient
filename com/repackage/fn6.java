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
/* loaded from: classes5.dex */
public class fn6 {
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(fn6 fn6Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn6Var, context};
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(fn6 fn6Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn6Var, context};
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

    public fn6(Context context) {
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05e2, (ViewGroup) null);
            this.a = inflate;
            this.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090ce2);
            this.c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090ce5);
            TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090ce3);
            this.j = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b1b);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a48);
            this.e = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            ViewCommonUtil.setViewMargin(this.e, -1, this.q, -1, -1);
            this.f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090b0a);
            this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09094f);
            this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09094e);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090951);
            this.k = imageView;
            ViewCommonUtil.setViewMargin(imageView, -1, this.p, -1, -1);
            this.k.setOnClickListener(new a(this, context));
            this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02d9));
            this.d.setStrokeWith(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.d.setShowOval(true);
            this.d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.d.setStrokeColorResId(R.color.CAM_X0201);
            ViewCommonUtil.setViewMargin(this.d, -1, this.o, -1, -1);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f08060f);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0802d6, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0300, (ViewGroup) null);
        this.a = inflate2;
        this.b = (RelativeLayout) inflate2.findViewById(R.id.obfuscated_res_0x7f090ce2);
        this.c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090ce5);
        TbImageView tbImageView2 = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090ce3);
        this.j = tbImageView2;
        tbImageView2.setDefaultBgResource(R.color.transparent);
        this.j.setDefaultResource(R.drawable.obfuscated_res_0x7f080f36);
        this.d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b1b);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a48);
        this.e = textView2;
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0101);
        this.f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090b0a);
        this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09094f);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09094e);
        this.i = this.a.findViewById(R.id.obfuscated_res_0x7f090cfa);
        this.k = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090951);
        this.l = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090953);
        this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090950);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090952);
        this.k.setOnClickListener(new b(this, context));
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02d9));
        this.d.setStrokeWith(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.d.setShowOval(true);
        this.d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        wq4 d = wq4.d(this.i);
        d.m(1);
        d.n(R.string.J_X14);
        d.f(R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f08060f);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f080611, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e5, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.obfuscated_res_0x7f080610, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0802d6, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
