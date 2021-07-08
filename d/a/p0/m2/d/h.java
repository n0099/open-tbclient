package d.a.p0.m2.d;

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
import d.a.c.e.p.l;
import d.a.o0.r.s.a;
/* loaded from: classes8.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.j2.f f60187e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.m2.d.d f60188f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.p3.a f60189g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f60190h;

    /* renamed from: i  reason: collision with root package name */
    public BlackListModel f60191i;
    public boolean j;
    public String k;
    public long l;
    public String m;
    public d.a.p0.m2.e.a n;
    public BdUniqueId o;
    public boolean p;
    public RemoveFansController q;
    public d.a.p0.j2.e r;
    public final d.a.c.c.g.c s;
    public final d.a.c.c.g.c t;
    public final CustomMessageListener u;
    public final CustomMessageListener v;
    public final d.a.c.c.g.c w;

    /* loaded from: classes8.dex */
    public class a extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f60192a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60192a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                this.f60192a.f60190h.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.f60192a.f60190h.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f60193a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60193a = hVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                if (z && i2 != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.M(this.f60193a.f60190h.getPageActivity(), this.f60193a.f60190h.getString(i2 == 0 ? R.string.remove_fans_success : R.string.remove_fans_fail));
                    } else {
                        l.M(this.f60193a.f60190h.getPageActivity(), str);
                    }
                }
                h hVar = this.f60193a;
                if (j == hVar.l && i2 == 0) {
                    hVar.p = false;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f60194e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60194e = hVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f60194e.q.removeFans(this.f60194e.l);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f60195e;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60195e = hVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                h hVar = this.f60195e;
                if (hVar.l > 0) {
                    if (hVar.f60191i.getMaskType() == 1) {
                        this.f60195e.f60191i.removeFromBlackList(this.f60195e.l);
                    } else {
                        this.f60195e.f60191i.addToBlackList(this.f60195e.l);
                    }
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f60196a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60196a = hVar;
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
                    this.f60196a.f60191i.setMaskType(1);
                } else {
                    this.f60196a.f60191i.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (this.f60196a.f60191i.getMaskType() == 1) {
                        TbPageContext tbPageContext = this.f60196a.f60190h;
                        tbPageContext.showToast(tbPageContext.getString(R.string.chat_message_blocked));
                        return;
                    }
                    TbPageContext tbPageContext2 = this.f60196a.f60190h;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.remove_succ));
                    return;
                }
                this.f60196a.f60190h.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? this.f60196a.f60190h.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* renamed from: d.a.p0.m2.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1542h extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f60197a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1542h(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60197a = hVar;
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
                    this.f60197a.f(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.f60197a.f60190h.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                this.f60197a.f60190h.showToast(errorString);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f60198a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60198a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                this.f60198a.f(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f60199a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60199a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    this.f60199a.f(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    this.f60199a.f(true);
                }
            }
        }
    }

    public h(TbPageContext tbPageContext, d.a.p0.m2.d.d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar, blackListModel, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new g(this, 104102);
        this.t = new C1542h(this, 304102);
        this.u = new i(this, 2001174);
        this.v = new j(this, 2001174);
        this.w = new a(this, 304103);
        this.f60190h = tbPageContext;
        this.f60188f = dVar;
        this.f60191i = blackListModel;
        this.o = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, d.a.p0.p3.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            d.a.p0.p3.a aVar = (d.a.p0.p3.a) runTask.getData();
            this.f60189g = aVar;
            aVar.a(bdUniqueId);
        }
        g();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.o);
        this.q = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void e() {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60188f == null || (blackListModel = this.f60191i) == null) {
            return;
        }
        j(this.j, blackListModel.getMaskType() == 1, this.f60188f.e(), this.p);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.j = z;
            d.a.p0.m2.e.a aVar = this.n;
            if (aVar != null) {
                aVar.x(z);
            }
            d.a.p0.j2.f fVar = this.f60187e;
            if (fVar == null || (blackListModel = this.f60191i) == null) {
                return;
            }
            fVar.n(this.j, blackListModel.getMaskType() == 1, this.p);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s.setTag(this.o);
            this.t.setTag(this.o);
            this.w.setTag(this.o);
            this.v.setTag(this.o);
            this.u.setTag(this.o);
            this.f60190h.registerListener(this.s);
            this.f60190h.registerListener(this.t);
            this.f60190h.registerListener(this.w);
            this.f60190h.registerListener(this.v);
            this.f60190h.registerListener(this.u);
        }
    }

    public void h(d.a.p0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || this.f60191i == null || aVar == null || aVar.j() == null) {
            return;
        }
        this.n = aVar;
        UserData j2 = aVar.j();
        this.j = aVar.l();
        this.f60191i.setMaskType(j2.isMask() ? 1 : 0);
        this.k = j2.getName_show();
        this.l = j2.getUserIdLong();
        this.m = j2.getPortrait();
        this.p = j2.getIsMyFans() == 1;
    }

    public void i() {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k == null) {
            return;
        }
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f60190h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new e(this));
        aVar.setNegativeButton(R.string.cancel, new f(this));
        if (this.f60191i.getMaskType() == 1) {
            format = String.format(this.f60190h.getString(R.string.block_chat_ensure_toremove_text), this.k);
        } else {
            format = String.format(this.f60190h.getString(R.string.block_chat_message_alert), this.k);
        }
        aVar.setMessage(format);
        aVar.create(this.f60190h);
        aVar.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            d.a.p0.j2.f fVar = new d.a.p0.j2.f(this.f60190h, this);
            this.f60187e = fVar;
            fVar.n(z, z2, z3);
            if (i2 != -1) {
                this.f60187e.m(i2);
            }
            d.a.p0.m2.e.a aVar = this.n;
            if (aVar != null && aVar.j() != null) {
                if (this.n.j().getBaijiahaoInfo() != null && !StringUtils.isNull(this.n.j().getBaijiahaoInfo().name)) {
                    this.f60187e.o(this.n.j().getBaijiahaoInfo().name);
                } else {
                    this.f60187e.o(this.n.j().getUserName());
                }
            }
            this.f60187e.l();
            d.a.p0.j2.e eVar = new d.a.p0.j2.e(this.f60190h.getPageActivity(), this.f60187e.j());
            this.r = eVar;
            eVar.show();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.l == 0) {
            return;
        }
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f60190h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new c(this));
        aVar.setNegativeButton(R.string.cancel, new d(this));
        aVar.setMessage(String.format(this.f60190h.getString(R.string.remove_fans_alert_text), this.k));
        aVar.create(this.f60190h);
        aVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        d.a.c.e.m.g.a(this.r, this.f60190h.getPageActivity());
        if (this.f60187e.d() != null && view.getId() == this.f60187e.d().getId()) {
            i();
        } else if (this.f60187e.e() != null && view.getId() == this.f60187e.e().getId()) {
            if (this.j) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.l);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f60190h.getPageActivity(), String.valueOf(this.l), this.k, this.m, null, false, null)));
        } else if (this.f60187e.f() != null && view.getId() == this.f60187e.f().getId()) {
            if (!d.a.c.e.p.j.z()) {
                this.f60190h.showToast(R.string.neterror);
                return;
            }
            d.a.p0.m2.d.d dVar = this.f60188f;
            if (dVar == null) {
                return;
            }
            if (dVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.l), this.k, null, null, 0, this.f60188f.d(), this.f60188f.f());
                userMuteAddAndDelCustomMessage.mId = this.f60188f.f();
                d.a.p0.m2.d.d dVar2 = this.f60188f;
                dVar2.j(false, userMuteAddAndDelCustomMessage, dVar2.d(), this.k);
            } else if (this.f60188f.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.l), this.k, null, null, 0, this.f60188f.d(), this.f60188f.f());
                userMuteAddAndDelCustomMessage2.mId = this.f60188f.f();
                this.f60188f.j(true, userMuteAddAndDelCustomMessage2, null, this.k);
            }
        } else if (this.f60187e.h() != null && view.getId() == this.f60187e.h().getId()) {
            if (this.f60189g != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.f60189g.b(String.valueOf(this.l));
            }
        } else if (this.f60187e.g() == null || view.getId() != this.f60187e.g().getId()) {
        } else {
            if (!d.a.c.e.p.j.z()) {
                l.L(this.f60190h.getPageActivity(), R.string.neterror);
            } else {
                k();
            }
        }
    }
}
