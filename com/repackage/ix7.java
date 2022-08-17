package com.repackage;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hf;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class ix7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gf a;
    public final WeakReference<Activity> b;
    public final ViewGroup c;
    public ff d;
    public ThreadRecommendInfoData e;
    public final Handler f;
    public Runnable g;
    public String h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        public a(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.e(this.a.c);
            this.a.c.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        public b(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // com.repackage.hf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
                this.a.f.removeCallbacks(this.a.g);
            }
        }

        @Override // com.repackage.hf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ff {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (activity = (Activity) this.a.a.b.get()) == null) {
                    return;
                }
                if (this.a.a.e != null) {
                    if (TextUtils.isEmpty(this.a.a.e.jumpLink)) {
                        long j = this.a.a.e.recommendTopicId;
                        if (j == 0) {
                            return;
                        }
                        new HotTopicActivityConfig(activity).createNormalConfig(String.valueOf(j), null, null, "2").start();
                    } else {
                        UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(view2.getContext()), new String[]{this.a.a.e.jumpLink});
                    }
                }
                this.a.a.j();
                this.a.a.m();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.j();
                }
            }
        }

        public c(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // com.repackage.ff
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06d0, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0917e5);
                if (this.a.e != null) {
                    BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0917e4);
                    barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    barImageView.setStrokeWith(qi.f(inflate.getContext(), R.dimen.tbds1));
                    barImageView.setShowOval(false);
                    barImageView.setDrawCorner(true);
                    barImageView.setRadiusById(R.string.J_X06);
                    barImageView.setConrers(15);
                    barImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    barImageView.setPlaceHolder(1);
                    barImageView.setShowOuterBorder(false);
                    barImageView.setShowInnerBorder(true);
                    barImageView.setStrokeColorResId(R.color.CAM_X0602);
                    if (!StringUtils.isNull(this.a.e.recommendIcon)) {
                        barImageView.L(this.a.e.recommendIcon, 10, false, false);
                    }
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0917e9);
                    textView.setText(this.a.e.recommendReason);
                    ms4 d = ms4.d(textView);
                    d.v(R.color.CAM_X0105);
                    d.z(R.dimen.T_X06);
                    d.A(R.string.F_X02);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0917e6);
                    textView2.setText(this.a.e.recommendType);
                    ms4 d2 = ms4.d(textView2);
                    d2.v(R.color.CAM_X0107);
                    d2.z(R.dimen.T_X08);
                    d2.A(R.string.F_X01);
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f0917e7);
                    pv4 pv4Var = new pv4();
                    pv4Var.r(R.color.CAM_X0319);
                    tBSpecificationBtn.setConfig(pv4Var);
                    tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03b3));
                    inflate.setOnClickListener(new a(this));
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090644);
                    WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
                    imageView.setOnClickListener(new b(this));
                    TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).setOffsetX(0).setOffsetY(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into(findViewById);
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.repackage.ff
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public ix7(Activity activity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new Handler();
        this.b = new WeakReference<>(activity);
        this.c = viewGroup;
    }

    public final ff i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (ff) invokeV.objValue;
    }

    public void j() {
        gf gfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gfVar = this.a) == null) {
            return;
        }
        gfVar.e(this.c);
        this.c.setVisibility(8);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_RECOMMEND_GUIDE_VIEW_SHOW);
            if (!TextUtils.isEmpty(this.h)) {
                statisticItem.addParam("tid", this.h);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                statisticItem.addParam("uid", currentAccount);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.a == null || (viewGroup = this.c) == null || viewGroup.getVisibility() != 0) ? false : true : invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_RECOMMEND_GUIDE_VIEW_JUMP);
            if (!TextUtils.isEmpty(this.h)) {
                statisticItem.addParam("tid", this.h);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                statisticItem.addParam("uid", currentAccount);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void n() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (viewGroup = this.c) == null || this.a == null) {
            return;
        }
        ms4 d = ms4.d((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0917e9));
        d.v(R.color.CAM_X0105);
        d.z(R.dimen.T_X06);
        d.A(R.string.F_X02);
        ms4 d2 = ms4.d((TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0917e6));
        d2.v(R.color.CAM_X0107);
        d2.z(R.dimen.T_X08);
        d2.A(R.string.F_X01);
        ((TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f0917e7)).k();
        WebPManager.setPureDrawable((ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090644), R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).setOffsetX(0).setOffsetY(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into(this.c.findViewById(R.id.obfuscated_res_0x7f0917e5));
        this.c.findViewById(R.id.obfuscated_res_0x7f0917e4).postInvalidate();
    }

    public void o() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (runnable = this.g) == null) {
            return;
        }
        this.f.removeCallbacks(runnable);
    }

    public void p(ThreadRecommendInfoData threadRecommendInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadRecommendInfoData) == null) {
            this.e = threadRecommendInfoData;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.h = str;
        }
    }

    public void r() {
        Activity activity;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (activity = this.b.get()) == null || (viewGroup = this.c) == null || this.e == null) {
            return;
        }
        viewGroup.setVisibility(0);
        gf gfVar = this.a;
        if (gfVar != null) {
            gfVar.e(this.c);
        }
        this.g = new a(this);
        hf hfVar = new hf();
        hfVar.d(true);
        hfVar.h(new b(this));
        if (this.d == null) {
            this.d = i();
        }
        hfVar.a(this.d);
        hfVar.e(R.anim.obfuscated_res_0x7f0100ea);
        hfVar.f(R.anim.obfuscated_res_0x7f0100eb);
        gf b2 = hfVar.b();
        this.a = b2;
        b2.q(activity, this.c, false);
        k();
    }
}
