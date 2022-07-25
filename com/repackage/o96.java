package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s96;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class o96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Pattern a;
    public TbPageContext<?> b;
    public View c;
    public CoverFlowView<as4> d;
    public s96 e;
    public ds4<as4> f;

    /* loaded from: classes6.dex */
    public class a extends bs4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o96 a;

        public a(o96 o96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o96Var;
        }

        @Override // com.repackage.bs4, com.repackage.zr4
        public cs4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                cs4 a = super.a();
                if (a != null) {
                    a.d(81);
                    a.e(R.dimen.obfuscated_res_0x7f0701d5);
                }
                return a;
            }
            return (cs4) invokeV.objValue;
        }

        @Override // com.repackage.bs4, com.repackage.zr4
        public es4 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                es4 es4Var = new es4();
                es4Var.a((int) (pi.k(this.a.b.getPageActivity()) / 2.5714285f));
                return es4Var;
            }
            return (es4) invokeV.objValue;
        }

        @Override // com.repackage.bs4, com.repackage.zr4
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ds4<as4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o96 a;

        public b(o96 o96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o96Var;
        }

        @Override // com.repackage.ds4
        public void a(int i, as4 as4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, as4Var) != null) || as4Var == null) {
            }
        }

        @Override // com.repackage.ds4
        public void b(int i, String str) {
            s96.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (aVar = (s96.a) this.a.d.n(i)) == null) {
                return;
            }
            Matcher matcher = this.a.a.matcher(aVar.b());
            if (matcher.find()) {
                this.a.b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public o96(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = new b(this);
        this.b = tbPageContext;
        d();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public final void d() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a2, (ViewGroup) null);
        this.c = inflate;
        if (inflate == null) {
            return;
        }
        this.d = (CoverFlowView) inflate.findViewById(R.id.obfuscated_res_0x7f091dfb);
        a aVar = new a(this);
        this.d.setDisableParentEvent(false);
        this.d.setCoverFlowFactory(aVar);
        this.d.setCallback(this.f);
    }

    public void e(s96 s96Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s96Var) == null) || s96Var == null || s96Var == this.e) {
            return;
        }
        this.d.setData(s96Var.a());
        this.e = s96Var;
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<as4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (coverFlowView = this.d) == null) {
            return;
        }
        coverFlowView.v();
    }
}
