package d.a.s0.u0.e2;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.x0;
import d.a.s0.u0.c0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f65859h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f65860i;
    public final d.a.c.c.g.a j;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f65861a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || this.f65861a.f65925b.i0() == null) {
                    return;
                }
                FrsViewData i0 = this.f65861a.f65925b.i0();
                i0.removeThread(str);
                this.f65861a.f65924a.x1(i0.getThreadList(), i0);
                if (d.a.s0.h3.e.i() != null) {
                    d.a.s0.h3.e.i().n(this.f65861a.f65925b.h(), false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65862a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f65862a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumManageModel.e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e)) {
                d dVar = this.f65862a;
                if (dVar.f65925b == null || dVar.f65924a == null || dVar.f65927d == null || (eVar = (ForumManageModel.e) customResponsedMessage.getData()) == null || TextUtils.isEmpty(eVar.f21142a) || this.f65862a.f65925b.i0() == null) {
                    return;
                }
                String str = eVar.f21142a;
                String str2 = eVar.f21143b;
                String str3 = eVar.f21144c;
                if (eVar.f21145d == 4) {
                    FrsViewData i0 = this.f65862a.f65925b.i0();
                    b2 threadDataById = i0.getThreadDataById(str);
                    i0.removeThreadData(threadDataById);
                    List<d.a.c.k.e.n> topThreadList = i0.getTopThreadList();
                    if (topThreadList == null) {
                        topThreadList = new ArrayList<>();
                    }
                    topThreadList.add(0, threadDataById);
                    this.f65862a.f65924a.x1(i0.getThreadList(), i0);
                    this.f65862a.f65927d.R(i0);
                }
                if (TextUtils.equals(this.f65862a.f65925b.h(), str3)) {
                    d.a.s0.h3.e.i().n(this.f65862a.f65925b.h(), false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65863a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65863a = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            int proZone;
            String errorString2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestGetMyPostNetMessage) {
                    z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                    if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                            errorString2 = this.f65863a.f65925b.getResources().getString(R.string.neterror);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            this.f65863a.d(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), proZone);
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = this.f65863a.f65925b.getResources().getString(R.string.neterror);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            this.f65863a.d(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), proZone);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            z = true;
            if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
            }
        }
    }

    /* renamed from: d.a.s0.u0.e2.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1711d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostWriteCallBackData f65864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f65865f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f65866g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f65867h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f65868i;

        public RunnableC1711d(d dVar, PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, postWriteCallBackData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65868i = dVar;
            this.f65864e = postWriteCallBackData;
            this.f65865f = j;
            this.f65866g = j2;
            this.f65867h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
                int i2 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setProZone(this.f65864e.getProZone());
                requestGetMyPostNetMessage.setParams(this.f65865f, this.f65866g, this.f65867h, k, i2, f2, i3);
                this.f65868i.f65925b.sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65859h = new a(this, 2921031);
        this.f65860i = new b(this, 2921316);
        c cVar = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = cVar;
        cVar.getSocketMessageListener().setSelfListener(true);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.f65859h.setSelfListener(false);
        this.f65925b.registerListener(this.f65859h);
        this.f65925b.registerListener(this.j);
        this.f65925b.registerListener(this.f65860i);
    }

    public final void b(b2 b2Var, FrsNewAreaFragment frsNewAreaFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, b2Var, frsNewAreaFragment) == null) {
            frsNewAreaFragment.h1(b2Var);
        }
    }

    public final void c(x0 x0Var) {
        FrsViewData i0;
        ArrayList<d.a.c.k.e.n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x0Var) == null) || (i0 = this.f65925b.i0()) == null) {
            return;
        }
        this.f65928e.G(x0Var);
        if (this.f65928e.u0()) {
            ArrayList<d.a.c.k.e.n> arrayList = new ArrayList<>();
            arrayList.add(x0Var);
            threadList = this.f65930g.c(false, true, arrayList, null, true);
        } else {
            threadList = i0.getThreadList();
        }
        if (threadList != null) {
            i0.setThreadList(threadList);
            i0.checkLiveStageInThreadList();
            this.f65924a.x1(threadList, i0);
        }
    }

    public final void d(int i2, String str, GetMyPostResIdl getMyPostResIdl, int i3) {
        DataRes dataRes;
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, getMyPostResIdl, Integer.valueOf(i3)}) == null) {
            if (i2 != 0) {
                this.f65925b.showToast(str);
                return;
            }
            FrsViewData i0 = this.f65925b.i0();
            if (i0 == null || i0.getForum() == null || getMyPostResIdl == null || this.f65924a == null || this.f65928e == null || (dataRes = getMyPostResIdl.data) == null || dataRes.thread_info == null) {
                return;
            }
            x0 x0Var = new x0();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            e(builder2, getMyPostResIdl.data.user_info);
            User user = builder.author;
            if (user == null || TextUtils.isEmpty(user.name)) {
                builder.author = builder2.build(true);
            }
            User user2 = builder.author;
            if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                builder.author = builder2.build(true);
            }
            builder.cheak_repeat = 1;
            builder.fname = i0.getForum().getName();
            builder.fid = Long.valueOf(d.a.c.e.m.b.f(i0.getForum().getId(), 0L));
            x0Var.I2(builder.build(true));
            f(x0Var, i3);
        }
    }

    public final void e(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, builder, user_Info) == null) || user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        if (l.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        } else {
            builder.portrait = user_Info.portrait;
        }
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
        builder.new_god_data = user_Info.new_god_data;
        builder.business_account_info = user_Info.business_account_info;
    }

    public final void f(x0 x0Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, x0Var, i2) == null) {
            if (i2 == 1) {
                FrsTabViewController.o z = this.f65925b.E2().z();
                if (z != null) {
                    Fragment fragment = z.f16044b;
                    if (fragment instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment).M0(x0Var);
                    }
                }
            } else if (i2 == 2) {
                FrsTabViewController.o G = this.f65925b.E2().G(301);
                if (G == null || !(G.f16044b instanceof FrsGoodFragment)) {
                    return;
                }
                this.f65926c.b(301);
                ((FrsGoodFragment) G.f16044b).g1(x0Var);
            } else if (x0Var.c1() > 0) {
                FrsTabViewController.o G2 = this.f65925b.E2().G(x0Var.c1());
                if (G2 != null) {
                    Fragment fragment2 = G2.f16044b;
                    if (fragment2 instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment2).M0(x0Var);
                    }
                }
            } else {
                if (!ListUtils.isEmpty(x0Var.o0())) {
                    x0Var.z1();
                }
                FrsTabViewController.o G3 = this.f65925b.E2().G(this.f65925b.E2().C());
                if (G3 != null) {
                    Fragment fragment3 = G3.f16044b;
                    if (fragment3 instanceof FrsNewAreaFragment) {
                        b(x0Var, (FrsNewAreaFragment) fragment3);
                    } else {
                        c(x0Var);
                    }
                }
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, postWriteCallBackData) == null) || (frsModelController = this.f65928e) == null) {
            return;
        }
        boolean z = frsModelController.d0() != null && this.f65928e.d0().getIsBrandForum();
        int R = this.f65928e.R();
        if (R == 2 || R == 3 || R == 7 || R == 8 || z) {
            if ((c0.a().b(1) != null ? this.f65928e.V() : 0) != 0 || postWriteCallBackData == null) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.a.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            long f4 = d.a.c.e.m.b.f(this.f65925b.i(), 0L);
            if (f2 != 0 && f3 != 0 && f4 != 0) {
                d.a.c.e.m.e.a().postDelayed(new RunnableC1711d(this, postWriteCallBackData, f3, f2, f4), 1000L);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                x0 x0Var = new x0();
                x0Var.y2(writeData);
                f(x0Var, writeData.getProZone());
            }
        }
    }
}
