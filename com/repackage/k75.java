package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.novel.NovelPayResponse;
import com.baidu.tbadk.novel.NovelResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes6.dex */
public class k75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public final HttpMessageListener b;
    public final TbHttpMessageTask c;
    public final BdUniqueId d;
    public final BdUniqueId e;
    public int f;
    public long g;
    public String h;
    public boolean i;
    public AlertDialog j;
    public final TbPageContext<?> k;
    public final CustomMessageListener l;
    public boolean m;
    public String n;
    public String o;
    public a85 p;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k75 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k75 k75Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k75Var, Integer.valueOf(i)};
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
            this.a = k75Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (!(httpResponsedMessage instanceof NovelPayResponse) || httpResponsedMessage.getOrginalMessage() == null) {
                    this.a.i = false;
                    return;
                }
                NovelPayResponse novelPayResponse = (NovelPayResponse) httpResponsedMessage;
                if (this.a.a == null) {
                    this.a.i = false;
                    return;
                }
                BdUniqueId tag = novelPayResponse.getOrginalMessage().getTag();
                if (tag != this.a.d) {
                    if (tag == this.a.e) {
                        this.a.i = false;
                        this.a.a.a(novelPayResponse.isSuccessful() ? NovelResult.PAY_NOVEL_SUCC : NovelResult.PAY_NOVEL_FAIL);
                        return;
                    }
                    this.a.i = false;
                } else if (!novelPayResponse.isSuccessful() || novelPayResponse.getYYCoin() < 0) {
                    this.a.i = false;
                    this.a.a.a(NovelResult.PAY_NOVEL_FAIL);
                } else {
                    this.a.p(novelPayResponse.getYYCoin());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k75 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k75 k75Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k75Var, Integer.valueOf(i)};
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
            this.a = k75Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null) {
                return;
            }
            this.a.a.a(NovelResult.DEPOSIT_SUCC);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends a85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k75 a;

        public c(k75 k75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k75Var;
        }

        @Override // com.repackage.c85
        public void a(h85 h85Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h85Var) == null) {
                this.a.m = true;
            }
        }

        @Override // com.repackage.a85
        public void b(byte b) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b) == null) && b == 6) {
                if (!this.a.m) {
                    this.a.i = false;
                    if (this.a.a != null) {
                        this.a.a.a(NovelResult.DEPOSIT_CANCEL);
                        return;
                    }
                    return;
                }
                k75 k75Var = this.a;
                k75Var.r(k75Var.g, this.a.h, this.a.f, true);
                this.a.m = false;
            }
        }

        @Override // com.repackage.c85
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
                this.a.i = false;
                if (this.a.a != null) {
                    this.a.a.a(NovelResult.DEPOSIT_FAIL);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(NovelResult novelResult);
    }

    public k75(@NonNull TbPageContext<?> tbPageContext) {
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
        this.d = BdUniqueId.gen();
        this.e = BdUniqueId.gen();
        this.f = -1;
        this.g = -1L;
        this.i = false;
        this.m = false;
        this.p = null;
        this.k = tbPageContext;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NOVEL_PAY, TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS + TbConfig.NOVEL_PAY);
        this.c = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(NovelPayResponse.class);
        this.b = new a(this, CmdConfigHttp.CMD_NOVEL_PAY);
        this.l = new b(this, 2001227);
    }

    public void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.a = dVar;
            MessageManager.getInstance().registerTask(this.c);
            this.k.registerListener(this.b);
            this.k.registerListener(this.l);
        }
    }

    public /* synthetic */ void m(View view2) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.i = false;
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(NovelResult.PAY_NOVEL_CANCEL);
        }
        m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 1, String.valueOf(this.g), this.n, this.o);
    }

    public /* synthetic */ void n(View view2) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        int i = this.f;
        if (i == 0) {
            this.a.a(NovelResult.PAY_NOVEL_SUCC);
        } else if (i > 0) {
            r(this.g, this.h, i, false);
        }
        m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 2, String.valueOf(this.g), this.n, this.o);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = null;
            MessageManager.getInstance().unRegisterTask(this.c.getCmd());
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().sendMessage(new CustomMessage(2921661, this.p));
        }
    }

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i >= this.f) {
                t(i);
            } else if (!oi.C()) {
                this.i = false;
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a(NovelResult.DEPOSIT_FAIL);
                }
            } else {
                this.p = new c(this);
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.k.getPageActivity(), this.p, this.k.getString(R.string.obfuscated_res_0x7f0f0c9c), Long.valueOf(this.f), false, 1);
                m75.b("c10291", "31", this.n, this.o);
            }
        }
    }

    public void q(long j, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i)}) == null) && !this.i && ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
            this.i = true;
            this.f = i;
            this.g = j;
            this.h = str;
            r(j, str, i, true);
        }
    }

    public final void r(long j, String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NOVEL_PAY);
            httpMessage.addParam("goods_id", j);
            httpMessage.addParam("goods_name", str);
            httpMessage.addParam("cost", i);
            httpMessage.addParam("tid", this.n);
            httpMessage.addParam("only_check_yycoin", z ? 1 : 0);
            httpMessage.setTag(z ? this.d : this.e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.n = str;
            this.o = str2;
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            AlertDialog alertDialog = this.j;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.j.dismiss();
            }
            qr4 qr4Var = new qr4(this.k.getPageActivity());
            qr4Var.w(String.format(Locale.CHINA, this.k.getString(R.string.obfuscated_res_0x7f0f0c94), Double.valueOf((this.f * 1.0d) / 100.0d)));
            qr4Var.u(R.string.obfuscated_res_0x7f0f0c8f);
            qr4Var.p(String.format(Locale.CHINA, this.k.getString(R.string.obfuscated_res_0x7f0f0c90), Double.valueOf((i * 1.0d) / 100.0d)));
            qr4Var.n(true);
            qr4Var.i(false);
            qr4Var.r(new TBAlertConfig.a(this.k.getString(R.string.obfuscated_res_0x7f0f0eee), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: com.repackage.h75
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        k75.this.m(view2);
                    }
                }
            }), new TBAlertConfig.a(this.k.getString(R.string.obfuscated_res_0x7f0f0c8e), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: com.repackage.i75
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        k75.this.n(view2);
                    }
                }
            }));
            this.j = qr4Var.y();
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(NovelResult.PAY_NOVEL_CONFIRM_DIALOG);
            }
            m75.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_SHOW, String.valueOf(this.g), this.n, this.o);
        }
    }
}
