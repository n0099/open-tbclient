package com.repackage;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.report.UEGReportResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nz7 implements lr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BdUniqueId b;
    public oz7 c;
    public uu4 d;
    public wu4 e;
    public HttpMessageListener f;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public a(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(this.a.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(nz7 nz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof UEGReportResponsedMessage)) {
                if (this.a.d != null) {
                    this.a.d.h(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    this.a.h(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c3d);
                }
                this.a.e.c(errorString);
            }
        }
    }

    public nz7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
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
        this.f = new b(this, CmdConfigHttp.CMD_UEG_REPORT);
        this.a = context;
        this.c = new oz7();
        wu4 wu4Var = new wu4();
        this.e = wu4Var;
        wu4Var.a = 1000L;
    }

    @Override // com.repackage.lr8
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            j();
            this.c.a(str);
        }
    }

    @Override // com.repackage.lr8
    public void b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
            this.c.c(bdUniqueId);
            this.f.setTag(bdUniqueId);
            this.f.setSelfListener(true);
            MessageManager.getInstance().registerListener(this.f);
        }
    }

    @Override // com.repackage.lr8
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            j();
            this.c.b(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e08), str, true)));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = null;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                d9<?> a2 = h9.a(this.a);
                TbPageContext tbPageContext = a2 instanceof TbPageContext ? (TbPageContext) a2 : null;
                if (tbPageContext == null) {
                    return;
                }
                uu4 uu4Var = new uu4(tbPageContext);
                this.d = uu4Var;
                uu4Var.e(new a(this));
            }
            this.d.h(true);
        }
    }
}
