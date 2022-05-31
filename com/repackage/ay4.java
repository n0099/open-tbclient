package com.repackage;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.df;
import java.util.Map;
/* loaded from: classes5.dex */
public class ay4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cf a;
    public final Activity b;
    public final TbPageContext c;
    public ViewGroup d;
    public View.OnClickListener e;
    public bf f;
    public final Handler g;
    public Runnable h;
    public String i;
    public String j;
    public String k;
    public String l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public View p;
    public ImageView q;
    public TBSpecificationBtn r;
    public FrameLayout s;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay4 a;

        public a(ay4 ay4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.e(this.a.d);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements df.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay4 a;

        public b(ay4 ay4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay4Var;
        }

        @Override // com.repackage.df.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
                this.a.g.removeCallbacks(this.a.h);
            }
        }

        @Override // com.repackage.df.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay4 a;

        public c(ay4 ay4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay4Var;
        }

        @Override // com.repackage.bf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.bf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.bf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) ? this.a.o(layoutInflater) : (View) invokeL.objValue;
        }

        @Override // com.repackage.bf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.bf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay4 a;

        public d(ay4 ay4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e != null) {
                    this.a.e.onClick(view2);
                }
                String str = this.a.i;
                char c = 65535;
                if (str.hashCode() == -429621401 && str.equals("reply_pb")) {
                    c = 0;
                }
                if (c != 0) {
                    zx4.d(this.a.b);
                } else {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.b).areNotificationsEnabled();
                    if (!ex4.d().x()) {
                        new MsgRemindModel(this.a.c).D(1, true, null);
                    }
                    if (areNotificationsEnabled) {
                        by4.k(this.a.b);
                    } else {
                        zx4.d(this.a.b);
                    }
                }
                this.a.r.setClickable(false);
                if (this.a.h != null) {
                    this.a.g.removeCallbacks(this.a.h);
                    this.a.g.postDelayed(this.a.h, 1000L);
                }
                this.a.d = null;
                ay4.s(this.a.i, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay4 a;

        public e(ay4 ay4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q();
                this.a.d = null;
                ay4.s(this.a.i, false);
            }
        }
    }

    public ay4(TbPageContext<?> tbPageContext, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new Handler();
        this.c = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        this.k = map.get("view_params_key_title");
        this.l = map.get("view_params_key_desc");
        this.i = map.get("view_params_key_source");
        this.j = map.get("view_params_key_style");
        this.d = r(this.b);
    }

    public static void s(String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, str, z) == null) {
            if ("reply_pb".equals(str)) {
                i = 10;
            } else {
                i = "sign".equals(str) ? 5 : 0;
            }
            TiebaStatic.log(new StatisticItem("c13673").param("obj_type", z ? 1 : 2).param("obj_source", i));
        }
    }

    public static void t(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            if ("reply_pb".equals(str)) {
                i = 10;
            } else {
                i = "sign".equals(str) ? 5 : 0;
            }
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", i));
        }
    }

    public final bf n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (bf) invokeV.objValue;
    }

    @NonNull
    public final View o(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06f5, (ViewGroup) null);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f090afc);
            this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b03);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b05);
            this.o = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090afb);
            this.q = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090afd);
            this.r = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f090afe);
            this.s = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090aff);
            this.n.setText(this.k);
            this.m.setText(this.l);
            this.r.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f34));
            FrameLayout frameLayout = this.s;
            if (frameLayout != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if ((layoutParams instanceof RelativeLayout.LayoutParams) && "short".equals(this.j)) {
                    layoutParams.width = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds156);
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds88);
                }
            }
            this.r.setOnClickListener(new d(this));
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setOnClickListener(new e(this));
            }
            u();
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = null;
        }
    }

    public void q() {
        cf cfVar;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cfVar = this.a) == null || (viewGroup = this.d) == null) {
            return;
        }
        cfVar.e(viewGroup);
        this.d.setVisibility(8);
    }

    public final ViewGroup r(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
            char c2 = 65535;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds146) + UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            String str = this.i;
            switch (str.hashCode()) {
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3364:
                    if (str.equals("im")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds128);
                if ("short".equals(this.j)) {
                    dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds200);
                    dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                }
            }
            layoutParams.bottomMargin = dimenPixelSize;
            layoutParams.leftMargin = dimenPixelSize2;
            layoutParams.rightMargin = dimenPixelSize3;
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout.addView(frameLayout2, layoutParams);
            return frameLayout2;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            this.o.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a92, (WebPManager.ResourceStateType) null));
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(li.f(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(li.f(this.b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(li.f(this.b, R.dimen.tbds5)).into(this.p);
            View view2 = this.p;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = -li.f(this.b, R.dimen.tbds10);
                    layoutParams2.rightMargin = -li.f(this.b, R.dimen.tbds10);
                }
            }
            nt4 nt4Var = new nt4();
            nt4Var.p(R.color.CAM_X0302);
            this.r.setConfig(nt4Var);
            ImageView imageView = this.q;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            }
        }
    }

    public void v() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (viewGroup = this.d) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        cf cfVar = this.a;
        if (cfVar != null) {
            cfVar.e(this.d);
        }
        this.h = new a(this);
        df dfVar = new df();
        dfVar.d(true);
        dfVar.g(new b(this));
        if (this.f == null) {
            this.f = n();
        }
        dfVar.a(this.f);
        dfVar.e(R.anim.obfuscated_res_0x7f0100f6);
        dfVar.f(R.anim.obfuscated_res_0x7f0100f7);
        cf b2 = dfVar.b();
        this.a = b2;
        b2.s(this.b, this.d, false);
        t(this.i);
    }
}
