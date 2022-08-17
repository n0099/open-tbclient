package com.repackage;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur4;
/* loaded from: classes6.dex */
public class g68 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j28 a;
    public c68 b;
    public lr8 c;
    public TbPageContext d;
    public BlackListModel e;
    public boolean f;
    public String g;
    public long h;
    public String i;
    public k68 j;
    public BdUniqueId k;
    public boolean l;
    public RemoveFansController m;
    public i28 n;
    public final cb o;
    public final cb p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final cb s;

    /* loaded from: classes6.dex */
    public class a extends cb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g68 g68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var, Integer.valueOf(i)};
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
            this.a = g68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                this.a.d.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        public b(g68 g68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g68Var;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        qi.N(this.a.d.getPageActivity(), this.a.d.getString(i == 0 ? R.string.obfuscated_res_0x7f0f0fd0 : R.string.obfuscated_res_0x7f0f0fce));
                    } else {
                        qi.N(this.a.d.getPageActivity(), str);
                    }
                }
                g68 g68Var = this.a;
                if (j == g68Var.h && i == 0) {
                    g68Var.l = false;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        public c(g68 g68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g68Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.m.removeFans(this.a.h);
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g68 g68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        public e(g68 g68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g68Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                g68 g68Var = this.a;
                if (g68Var.h > 0) {
                    if (g68Var.e.getMaskType() == 1) {
                        this.a.e.removeFromBlackList(this.a.h);
                    } else {
                        this.a.e.addToBlackList(this.a.h);
                    }
                }
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(g68 g68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends cb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(g68 g68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var, Integer.valueOf(i)};
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
            this.a = g68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() != 10) {
                    return;
                }
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    this.a.e.setMaskType(1);
                } else {
                    this.a.e.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (this.a.e.getMaskType() == 1) {
                        TbPageContext tbPageContext = this.a.d;
                        tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f03aa));
                        return;
                    }
                    TbPageContext tbPageContext2 = this.a.d;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.obfuscated_res_0x7f0f0fd5));
                    return;
                }
                this.a.d.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends cb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(g68 g68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var, Integer.valueOf(i)};
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
            this.a = g68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    this.a.f(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d) : responseDeleteFriendMessage.getErrorString();
                }
                this.a.d.showToast(errorString);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(g68 g68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var, Integer.valueOf(i)};
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
            this.a = g68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                this.a.f(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(g68 g68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var, Integer.valueOf(i)};
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
            this.a = g68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    this.a.f(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    this.a.f(true);
                }
            }
        }
    }

    public g68(TbPageContext tbPageContext, c68 c68Var, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, c68Var, blackListModel, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new g(this, 104102);
        this.p = new h(this, 304102);
        this.q = new i(this, 2001174);
        this.r = new j(this, 2001174);
        this.s = new a(this, 304103);
        this.d = tbPageContext;
        this.b = c68Var;
        this.e = blackListModel;
        this.k = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, lr8.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            lr8 lr8Var = (lr8) runTask.getData();
            this.c = lr8Var;
            lr8Var.b(bdUniqueId);
        }
        g();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.k);
        this.m = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void e() {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b == null || (blackListModel = this.e) == null) {
            return;
        }
        j(this.f, blackListModel.getMaskType() == 1, this.b.e(), this.l);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f = z;
            k68 k68Var = this.j;
            if (k68Var != null) {
                k68Var.x(z);
            }
            j28 j28Var = this.a;
            if (j28Var == null || (blackListModel = this.e) == null) {
                return;
            }
            j28Var.s(this.f, blackListModel.getMaskType() == 1, this.l);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o.setTag(this.k);
            this.p.setTag(this.k);
            this.s.setTag(this.k);
            this.r.setTag(this.k);
            this.q.setTag(this.k);
            this.d.registerListener(this.o);
            this.d.registerListener(this.p);
            this.d.registerListener(this.s);
            this.d.registerListener(this.r);
            this.d.registerListener(this.q);
        }
    }

    public void h(k68 k68Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, k68Var) == null) || this.e == null || k68Var == null || k68Var.j() == null) {
            return;
        }
        this.j = k68Var;
        UserData j2 = k68Var.j();
        this.f = k68Var.l();
        this.e.setMaskType(j2.isMask() ? 1 : 0);
        this.g = j2.getName_show();
        this.h = j2.getUserIdLong();
        this.i = j2.getPortrait();
        this.l = j2.getIsMyFans() == 1;
    }

    public void i() {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.g == null) {
            return;
        }
        ur4 ur4Var = new ur4(this.d.getPageActivity());
        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new e(this));
        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new f(this));
        if (this.e.getMaskType() == 1) {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f0318), this.g);
        } else {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f031a), this.g);
        }
        ur4Var.setMessage(format);
        ur4Var.create(this.d);
        ur4Var.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            j28 j28Var = new j28(this.d, this);
            this.a = j28Var;
            j28Var.s(z, z2, z3);
            if (i2 != -1) {
                this.a.r(i2);
            }
            k68 k68Var = this.j;
            if (k68Var != null && k68Var.j() != null) {
                this.a.t(this.j.j().getUserName());
            }
            this.a.q();
            i28 i28Var = new i28(this.d.getPageActivity(), this.a.o());
            this.n = i28Var;
            i28Var.show();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.h == 0) {
            return;
        }
        ur4 ur4Var = new ur4(this.d.getPageActivity());
        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new c(this));
        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new d(this));
        ur4Var.setMessage(String.format(this.d.getString(R.string.obfuscated_res_0x7f0f0fcd), this.g));
        ur4Var.create(this.d);
        ur4Var.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view2) == null) || view2 == null) {
            return;
        }
        tg.a(this.n, this.d.getPageActivity());
        if (this.a.j() != null && view2.getId() == this.a.j().getId()) {
            i();
        } else if (this.a.k() != null && view2.getId() == this.a.k().getId()) {
            if (this.f) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.h);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.d.getPageActivity(), String.valueOf(this.h), this.g, this.i, null, false, null)));
        } else if (this.a.l() != null && view2.getId() == this.a.l().getId()) {
            if (!oi.z()) {
                this.d.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                return;
            }
            c68 c68Var = this.b;
            if (c68Var == null) {
                return;
            }
            if (c68Var.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage.mId = this.b.f();
                c68 c68Var2 = this.b;
                c68Var2.j(false, userMuteAddAndDelCustomMessage, c68Var2.d(), this.g);
            } else if (this.b.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage2.mId = this.b.f();
                this.b.j(true, userMuteAddAndDelCustomMessage2, null, this.g);
            }
        } else if (this.a.n() != null && view2.getId() == this.a.n().getId()) {
            if (this.c != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.c.c(String.valueOf(this.h));
            }
        } else if (this.a.m() == null || view2.getId() != this.a.m().getId()) {
        } else {
            if (!oi.z()) {
                qi.M(this.d.getPageActivity(), R.string.obfuscated_res_0x7f0f0c3d);
            } else {
                k();
            }
        }
    }
}
