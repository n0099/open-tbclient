package com.repackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f68 extends e68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public NoDataView c;
    public View d;
    public h65 e;
    public e f;
    public PbListView g;
    public NoNetworkView h;
    public ImageView i;
    public g65 j;
    public int k;
    public LinearLayout l;
    public FrameLayout m;
    public NoNetworkView n;
    public RelativeLayout o;
    public z78 p;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public a(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.a.b.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.a.b.getPageActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public b(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && oi.A()) {
                this.a.n();
                this.a.A(true);
                if (this.a.f != null) {
                    this.a.f.a(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public c(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.b.getPageActivity(), null, gs7.a(), true)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d78 a;
        public UserData b;
        public ow8 c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new d78();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UserData userData = this.b;
                if (userData == null || !userData.isBaijiahaoUser()) {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                    d78 d78Var = this.a;
                    d78Var.a = 10;
                    d78Var.b = new Bundle();
                    this.a.b.putSerializable(UserData.TYPE_USER, this.b);
                    ow8 ow8Var = this.c;
                    if (ow8Var != null) {
                        ow8Var.a(view2, this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(View view2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f68(TbPageContext tbPageContext, View view2, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new d();
        this.k = 3;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = tbPageContext;
        this.d = view2;
        this.h = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f0918c3);
        this.l = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0918a0);
        z78 z78Var = new z78(this.b, this.d.findViewById(R.id.obfuscated_res_0x7f0918a2), this.d.findViewById(R.id.obfuscated_res_0x7f0918a4), z);
        this.p = z78Var;
        z78Var.k(PersonStatus.GUEST_DEFAULT);
        this.m = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0918a1);
        this.n = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f0918a3);
        this.o = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0918c4);
        PbListView pbListView = new PbListView(this.b.getPageActivity());
        this.g = pbListView;
        pbListView.b();
        this.g.E(SkinManager.getColor(R.color.CAM_X0109));
        this.g.A(R.color.CAM_X0110);
        this.g.p(R.color.CAM_X0201);
        this.g.t(qi.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070247));
        this.g.r(qi.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07023b));
        this.g.z();
        this.g.w(R.color.CAM_X0205);
        q(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
            x();
        }
    }

    public void j(l68 l68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l68Var) == null) {
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g65 g65Var = this.j;
            if (g65Var != null) {
                g65Var.dettachView(this.d);
                this.j = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        }
    }

    public void n() {
        h65 h65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (h65Var = this.e) == null) {
            return;
        }
        h65Var.dettachView(this.m);
        this.e = null;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h65 h65Var = this.e;
            if (h65Var != null) {
                return h65Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.k == i) {
            return;
        }
        NoDataView noDataView = this.c;
        if (noDataView != null) {
            noDataView.f(this.b, i);
        }
        NoNetworkView noNetworkView = this.n;
        if (noNetworkView != null) {
            noNetworkView.d(this.b, i);
        }
        z78 z78Var = this.p;
        if (z78Var != null) {
            z78Var.g(i);
        }
        SkinManager.setBackgroundResource(this.d, R.color.CAM_X0201);
        h65 h65Var = this.e;
        if (h65Var != null) {
            h65Var.onChangeSkinType();
        }
        this.k = i;
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o.setVisibility(8);
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070283);
            if (this.c == null) {
                this.c = NoDataViewFactory.a(this.b.getPageActivity(), this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.b.getString(R.string.obfuscated_res_0x7f0f14ee)), null);
            }
            SkinManager.setViewTextColor(this.c.getSuTextView(), (int) R.color.CAM_X0106);
            this.c.f(this.b, TbadkCoreApplication.getInst().getSkinType());
            this.c.setVisibility(0);
        }
    }

    public void u(List<on> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void v(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (this.j == null) {
                if (i < 0) {
                    this.j = new g65(this.b.getContext());
                } else {
                    this.j = new g65(this.b.getContext(), i);
                }
                this.j.onChangeSkinType();
            }
            this.j.attachView(this.d, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        }
    }

    public void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) || p()) {
            return;
        }
        this.l.setVisibility(0);
        if (this.e == null) {
            this.e = new h65(this.b.getPageActivity(), new b(this));
        }
        this.e.h(R.drawable.new_pic_emotion_08);
        this.e.attachView(this.m, z);
        this.e.p();
        this.e.onChangeSkinType();
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (NickNameActivitySwitch.isOn()) {
                if (this.i == null) {
                    ImageView imageView = new ImageView(this.b.getPageActivity());
                    this.i = imageView;
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08088e);
                    this.i.setOnClickListener(new c(this));
                }
                if (this.i.getParent() != null) {
                    ((ViewGroup) this.i.getParent()).removeView(this.i);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.topMargin = qi.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0702d4);
                layoutParams.rightMargin = qi.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
                View view2 = this.d;
                if (view2 instanceof RelativeLayout) {
                    ((RelativeLayout) view2).addView(this.i, layoutParams);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.i;
            if (imageView2 == null || imageView2.getParent() == null) {
                return;
            }
            ViewParent parent = this.i.getParent();
            View view3 = this.d;
            if (parent == view3) {
                ((RelativeLayout) view3).removeView(this.i);
            }
        }
    }

    public void y(boolean z, List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z, list) == null) {
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.m == null) {
            return;
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.l.setVisibility(0);
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027a);
        int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cc);
        int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa);
        int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
        int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
        NoDataView a2 = NoDataViewFactory.a(this.b.getPageActivity(), this.m, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(R.string.obfuscated_res_0x7f0f14bc, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.b.getString(R.string.obfuscated_res_0x7f0f14bb), new a(this)), dimensionPixelSize5));
        this.c = a2;
        a2.setVisibility(0);
        this.c.f(this.b, TbadkCoreApplication.getInst().getSkinType());
    }
}
