package com.repackage;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oq4;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class r08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public mq4 c;
    public oq4 d;
    public List<kq4> e;
    public kq4 f;
    public b g;
    public SmartApp h;
    public oq4.d i;

    /* loaded from: classes6.dex */
    public class a implements oq4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r08 a;

        public a(r08 r08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r08Var;
        }

        @Override // com.repackage.oq4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", this.a.h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.a.g != null) {
                this.a.g.a(this.a.h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", this.a.h.swan_app_id.longValue());
            statisticItem.param("obj_name", this.a.h.name);
            TiebaStatic.log(statisticItem);
            if (this.a.c != null) {
                this.a.c.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755404041, "Lcom/repackage/r08;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755404041, "Lcom/repackage/r08;");
                return;
            }
        }
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public r08(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.b = pageActivity;
        this.d = new oq4(pageActivity);
        this.e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
            this.h = smartApp;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c == null) {
            kq4 kq4Var = new kq4(this.b.getString(R.string.obfuscated_res_0x7f0f04a4), this.d);
            this.f = kq4Var;
            kq4Var.m(this.i);
            this.e.add(this.f);
            this.d.j(this.e);
            this.c = new mq4(this.a, this.d);
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void g() {
        mq4 mq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (mq4Var = this.c) == null) {
            return;
        }
        mq4Var.m();
    }
}
