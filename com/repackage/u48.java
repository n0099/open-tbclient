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
import com.repackage.nr4;
/* loaded from: classes7.dex */
public class u48 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x08 a;
    public q48 b;
    public oq8 c;
    public TbPageContext d;
    public BlackListModel e;
    public boolean f;
    public String g;
    public long h;
    public String i;
    public y48 j;
    public BdUniqueId k;
    public boolean l;
    public RemoveFansController m;
    public w08 n;
    public final ya o;
    public final ya p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final ya s;

    /* loaded from: classes7.dex */
    public class a extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u48 u48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var, Integer.valueOf(i)};
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
            this.a = u48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                this.a.d.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        public b(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u48Var;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        mi.N(this.a.d.getPageActivity(), this.a.d.getString(i == 0 ? R.string.obfuscated_res_0x7f0f0f9a : R.string.obfuscated_res_0x7f0f0f98));
                    } else {
                        mi.N(this.a.d.getPageActivity(), str);
                    }
                }
                u48 u48Var = this.a;
                if (j == u48Var.h && i == 0) {
                    u48Var.l = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        public c(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u48Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.m.removeFans(this.a.h);
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        public e(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u48Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                u48 u48Var = this.a;
                if (u48Var.h > 0) {
                    if (u48Var.e.getMaskType() == 1) {
                        this.a.e.removeFromBlackList(this.a.h);
                    } else {
                        this.a.e.addToBlackList(this.a.h);
                    }
                }
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(u48 u48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var, Integer.valueOf(i)};
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
            this.a = u48Var;
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
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.obfuscated_res_0x7f0f0f9f));
                    return;
                }
                this.a.d.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(u48 u48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var, Integer.valueOf(i)};
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
            this.a = u48Var;
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
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : responseDeleteFriendMessage.getErrorString();
                }
                this.a.d.showToast(errorString);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(u48 u48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var, Integer.valueOf(i)};
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
            this.a = u48Var;
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

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(u48 u48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var, Integer.valueOf(i)};
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
            this.a = u48Var;
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

    public u48(TbPageContext tbPageContext, q48 q48Var, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, q48Var, blackListModel, bdUniqueId};
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
        this.b = q48Var;
        this.e = blackListModel;
        this.k = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, oq8.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            oq8 oq8Var = (oq8) runTask.getData();
            this.c = oq8Var;
            oq8Var.b(bdUniqueId);
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
            y48 y48Var = this.j;
            if (y48Var != null) {
                y48Var.x(z);
            }
            x08 x08Var = this.a;
            if (x08Var == null || (blackListModel = this.e) == null) {
                return;
            }
            x08Var.o(this.f, blackListModel.getMaskType() == 1, this.l);
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

    public void h(y48 y48Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, y48Var) == null) || this.e == null || y48Var == null || y48Var.j() == null) {
            return;
        }
        this.j = y48Var;
        UserData j2 = y48Var.j();
        this.f = y48Var.l();
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
        nr4 nr4Var = new nr4(this.d.getPageActivity());
        nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new e(this));
        nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new f(this));
        if (this.e.getMaskType() == 1) {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f030f), this.g);
        } else {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f0311), this.g);
        }
        nr4Var.setMessage(format);
        nr4Var.create(this.d);
        nr4Var.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            x08 x08Var = new x08(this.d, this);
            this.a = x08Var;
            x08Var.o(z, z2, z3);
            if (i2 != -1) {
                this.a.n(i2);
            }
            y48 y48Var = this.j;
            if (y48Var != null && y48Var.j() != null) {
                this.a.q(this.j.j().getUserName());
            }
            this.a.m();
            w08 w08Var = new w08(this.d.getPageActivity(), this.a.k());
            this.n = w08Var;
            w08Var.show();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.h == 0) {
            return;
        }
        nr4 nr4Var = new nr4(this.d.getPageActivity());
        nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new c(this));
        nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new d(this));
        nr4Var.setMessage(String.format(this.d.getString(R.string.obfuscated_res_0x7f0f0f97), this.g));
        nr4Var.create(this.d);
        nr4Var.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view2) == null) || view2 == null) {
            return;
        }
        pg.a(this.n, this.d.getPageActivity());
        if (this.a.e() != null && view2.getId() == this.a.e().getId()) {
            i();
        } else if (this.a.g() != null && view2.getId() == this.a.g().getId()) {
            if (this.f) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.h);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.d.getPageActivity(), String.valueOf(this.h), this.g, this.i, null, false, null)));
        } else if (this.a.h() != null && view2.getId() == this.a.h().getId()) {
            if (!ki.z()) {
                this.d.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                return;
            }
            q48 q48Var = this.b;
            if (q48Var == null) {
                return;
            }
            if (q48Var.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage.mId = this.b.f();
                q48 q48Var2 = this.b;
                q48Var2.j(false, userMuteAddAndDelCustomMessage, q48Var2.d(), this.g);
            } else if (this.b.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage2.mId = this.b.f();
                this.b.j(true, userMuteAddAndDelCustomMessage2, null, this.g);
            }
        } else if (this.a.j() != null && view2.getId() == this.a.j().getId()) {
            if (this.c != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.c.c(String.valueOf(this.h));
            }
        } else if (this.a.i() == null || view2.getId() != this.a.i().getId()) {
        } else {
            if (!ki.z()) {
                mi.M(this.d.getPageActivity(), R.string.obfuscated_res_0x7f0f0c2d);
            } else {
                k();
            }
        }
    }
}
