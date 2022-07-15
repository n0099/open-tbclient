package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ng6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public String c;
    public String d;
    public String e;
    public HttpMessageListener f;

    /* loaded from: classes6.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ng6 c;

        /* renamed from: com.repackage.ng6$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0688a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0688a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.c.c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.c.a.getPageActivity(), "ForumGradePage", hashMap)));
                }
            }
        }

        public a(ng6 ng6Var, cr4 cr4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng6Var, cr4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ng6Var;
            this.a = cr4Var;
            this.b = i;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                xt4.k().u("key_forum_broadcast_no_tip_again", this.a.isNoTipAgainChecked());
                this.a.dismiss();
                if (this.b == 0) {
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.c.a.getPageActivity());
                    screenTopToast.m(this.c.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06d3));
                    screenTopToast.k(this.c.a.getString(R.string.obfuscated_res_0x7f0f0733));
                    screenTopToast.j(new View$OnClickListenerC0688a(this));
                    screenTopToast.n((ViewGroup) this.c.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090a90));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.c.a.getPageActivity());
                if (this.c.b == 1) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.c.c, this.c.d, "3");
                } else if (this.c.b == 2) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.c.c, this.c.d, "4");
                } else {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.c.c, this.c.d, "0");
                }
                forumBroadcastHelper.clipCopy(this.c.e);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public b(ng6 ng6Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng6Var, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                xt4.k().u("key_call_fans_no_tip_again", false);
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ng6 ng6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng6Var, Integer.valueOf(i)};
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
            this.a = ng6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg)) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean h = xt4.k().h("key_forum_broadcast_no_tip_again", false);
                int i = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!h) {
                    this.a.j(i);
                } else if (this.a.b == 1) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f1447);
                } else if (this.a.b == 2) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f1121);
                }
            }
        }
    }

    public ng6(TbPageContext tbPageContext) {
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
        this.f = new c(this, CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        this.a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f);
    }

    public void g(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            h(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", str);
            this.a.sendMessage(httpMessage);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
            tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            cr4 cr4Var = new cr4(this.a.getPageActivity());
            cr4Var.setUseNoTipAgainStyle(true);
            cr4Var.setNegativeTextColor(R.color.CAM_X0105);
            int i2 = this.b;
            if (i2 == 1) {
                cr4Var.setTitle(R.string.obfuscated_res_0x7f0f1447);
            } else if (i2 == 2) {
                cr4Var.setTitle(R.string.obfuscated_res_0x7f0f1121);
            }
            cr4Var.setMessage(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0655), Integer.valueOf(i)));
            cr4Var.setContentViewSize(1);
            cr4Var.setPositiveButton(this.a.getString(R.string.obfuscated_res_0x7f0f110f), new a(this, cr4Var, i));
            cr4Var.setNegativeButton(this.a.getString(R.string.obfuscated_res_0x7f0f0c37), new b(this, cr4Var));
            cr4Var.create(this.a).show();
        }
    }
}
