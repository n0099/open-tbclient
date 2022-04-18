package com.repackage;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public class dn6 extends jn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public final wa j;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dn6 dn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn6Var, Integer.valueOf(i)};
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
            this.a = dn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || this.a.b.g0() == null) {
                    return;
                }
                FrsViewData g0 = this.a.b.g0();
                g0.removeThread(str);
                cn6 cn6Var = this.a.g;
                if (cn6Var != null) {
                    cn6Var.k(str);
                }
                this.a.a.D1(g0.getThreadList(), g0);
                if (ij8.i() != null) {
                    ij8.i().n(this.a.b.a(), false);
                }
                if (this.a.b != null) {
                    if (jd6.g()) {
                        BdTopToast bdTopToast = new BdTopToast(this.a.b.getContext());
                        bdTopToast.i(true);
                        bdTopToast.h(this.a.b.getContext().getString(R.string.obfuscated_res_0x7f0f115d));
                        bdTopToast.j((ViewGroup) this.a.b.H2());
                        return;
                    }
                    BdTopToast bdTopToast2 = new BdTopToast(this.a.b.getContext());
                    bdTopToast2.i(true);
                    bdTopToast2.h(this.a.b.getContext().getString(R.string.obfuscated_res_0x7f0f04a3));
                    bdTopToast2.j((ViewGroup) this.a.b.H2());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dn6 dn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn6Var, Integer.valueOf(i)};
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
            this.a = dn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumManageModel.e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e)) {
                dn6 dn6Var = this.a;
                if (dn6Var.b == null || dn6Var.a == null || dn6Var.d == null || (eVar = (ForumManageModel.e) customResponsedMessage.getData()) == null || TextUtils.isEmpty(eVar.a) || this.a.b.g0() == null) {
                    return;
                }
                String str = eVar.a;
                String str2 = eVar.b;
                String str3 = eVar.c;
                if (eVar.d == 4) {
                    FrsViewData g0 = this.a.b.g0();
                    ThreadData threadDataById = g0.getThreadDataById(str);
                    g0.removeThreadData(threadDataById);
                    List<uo> topThreadList = g0.getTopThreadList();
                    if (topThreadList == null) {
                        topThreadList = new ArrayList<>();
                    }
                    topThreadList.add(0, threadDataById);
                    this.a.a.D1(g0.getThreadList(), g0);
                    this.a.d.U(g0);
                }
                if (TextUtils.equals(this.a.b.a(), str3)) {
                    ij8.i().n(this.a.b.a(), false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dn6 dn6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dn6Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
        @Override // com.repackage.wa
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
                            errorString2 = this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            this.a.d(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), proZone);
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            this.a.d(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), proZone);
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

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ dn6 e;

        public d(dn6 dn6Var, PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn6Var, postWriteCallBackData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dn6Var;
            this.a = postWriteCallBackData;
            this.b = j;
            this.c = j2;
            this.d = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int k = oi.k(TbadkCoreApplication.getInst());
                int i = oi.i(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setProZone(this.a.getProZone());
                requestGetMyPostNetMessage.setParams(this.b, this.c, this.d, k, i, f, i2);
                this.e.b.sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn6(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2921031);
        this.i = new b(this, 2921316);
        c cVar = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = cVar;
        cVar.getSocketMessageListener().setSelfListener(true);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.h.setSelfListener(false);
        this.b.registerListener(this.h);
        this.b.registerListener(this.j);
        this.b.registerListener(this.i);
    }

    public final void b(ThreadData threadData, FrsNewAreaFragment frsNewAreaFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, frsNewAreaFragment) == null) {
            frsNewAreaFragment.c1(threadData);
        }
    }

    public final void c(mp4 mp4Var) {
        FrsViewData g0;
        ArrayList<uo> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mp4Var) == null) || (g0 = this.b.g0()) == null) {
            return;
        }
        this.e.I(mp4Var);
        if (this.e.v0()) {
            ArrayList<uo> arrayList = new ArrayList<>();
            arrayList.add(mp4Var);
            threadList = this.g.c(false, true, arrayList, null, true, -1, null);
        } else {
            threadList = g0.getThreadList();
        }
        if (threadList != null) {
            g0.setThreadList(threadList);
            g0.checkLiveStageInThreadList();
            this.a.D1(threadList, g0);
        }
    }

    public final void d(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        DataRes dataRes;
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, getMyPostResIdl, Integer.valueOf(i2)}) == null) {
            if (i != 0) {
                this.b.showToast(str);
                return;
            }
            FrsViewData g0 = this.b.g0();
            if (g0 == null || g0.getForum() == null || getMyPostResIdl == null || this.a == null || this.e == null || (dataRes = getMyPostResIdl.data) == null || dataRes.thread_info == null) {
                return;
            }
            mp4 mp4Var = new mp4();
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
            builder.fname = g0.getForum().getName();
            builder.fid = Long.valueOf(mg.g(g0.getForum().getId(), 0L));
            mp4Var.parserProtobuf(builder.build(true));
            f(mp4Var, i2);
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

    public final void f(mp4 mp4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, mp4Var, i) == null) {
            if (i == 1) {
                FrsTabViewController.o A = this.b.I2().A();
                if (A != null) {
                    Fragment fragment = A.b;
                    if (fragment instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment).K0(mp4Var);
                    }
                }
            } else if (i == 2) {
                FrsTabViewController.o H = this.b.I2().H(301);
                if (H == null || !(H.b instanceof FrsGoodFragment)) {
                    return;
                }
                this.c.b(301);
                ((FrsGoodFragment) H.b).b1(mp4Var);
            } else if (mp4Var.getTabId() > 0) {
                FrsTabViewController.o H2 = this.b.I2().H(mp4Var.getTabId());
                if (H2 != null) {
                    Fragment fragment2 = H2.b;
                    if (fragment2 instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment2).K0(mp4Var);
                    }
                }
            } else {
                if (!ListUtils.isEmpty(mp4Var.getItemStar())) {
                    mp4Var.insertItemToTitleOrAbstractText();
                }
                FrsTabViewController.o H3 = this.b.I2().H(this.b.I2().D());
                if (H3 != null) {
                    Fragment fragment3 = H3.b;
                    if (fragment3 instanceof FrsNewAreaFragment) {
                        b(mp4Var, (FrsNewAreaFragment) fragment3);
                    } else {
                        c(mp4Var);
                    }
                }
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, postWriteCallBackData) == null) || (frsModelController = this.e) == null) {
            return;
        }
        boolean z = frsModelController.f0() != null && this.e.f0().getIsBrandForum();
        int T = this.e.T();
        if (T == 2 || T == 3 || T == 7 || T == 8 || z) {
            if ((de6.a().b(1) != null ? this.e.X() : 0) != 0 || postWriteCallBackData == null) {
                return;
            }
            long g = mg.g(postWriteCallBackData.getPostId(), 0L);
            long g2 = mg.g(postWriteCallBackData.getThreadId(), 0L);
            long g3 = mg.g(this.b.b(), 0L);
            if (g != 0 && g2 != 0 && g3 != 0) {
                pg.a().postDelayed(new d(this, postWriteCallBackData, g2, g, g3), 1000L);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                mp4 mp4Var = new mp4();
                mp4Var.parseFromWriteData(writeData);
                f(mp4Var, writeData.getProZone());
            }
        }
    }
}
