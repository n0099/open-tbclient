package d.b.i0.p0.e2;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w0;
import d.b.i0.p0.d0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class d extends j {

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f57422h;
    public final CustomMessageListener i;
    public final d.b.b.c.g.a j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str) || d.this.f57477b.S() == null) {
                return;
            }
            FrsViewData S = d.this.f57477b.S();
            S.removeThread(str);
            d.this.f57476a.v1(S.getThreadList(), S);
            if (d.b.i0.c3.e.i() != null) {
                d.b.i0.c3.e.i().n(d.this.f57477b.i(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumManageModel.e eVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ForumManageModel.e)) {
                return;
            }
            d dVar = d.this;
            if (dVar.f57477b == null || dVar.f57476a == null || dVar.f57479d == null || (eVar = (ForumManageModel.e) customResponsedMessage.getData()) == null || TextUtils.isEmpty(eVar.f21388a) || d.this.f57477b.S() == null) {
                return;
            }
            String str = eVar.f21388a;
            String str2 = eVar.f21389b;
            String str3 = eVar.f21390c;
            if (eVar.f21391d == 4) {
                FrsViewData S = d.this.f57477b.S();
                a2 threadDataById = S.getThreadDataById(str);
                S.removeThreadData(threadDataById);
                List<d.b.b.j.e.n> topThreadList = S.getTopThreadList();
                if (topThreadList == null) {
                    topThreadList = new ArrayList<>();
                }
                topThreadList.add(0, threadDataById);
                d.this.f57476a.v1(S.getThreadList(), S);
                d.this.f57479d.T(S);
            }
            if (TextUtils.equals(d.this.f57477b.i(), str3)) {
                d.b.i0.c3.e.i().n(d.this.f57477b.i(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.b.c.g.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
        @Override // d.b.b.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            int proZone;
            String errorString2;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestGetMyPostNetMessage) {
                    z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                    if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                            errorString2 = d.this.f57477b.getResources().getString(R.string.neterror);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            d.this.d(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), proZone);
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = d.this.f57477b.getResources().getString(R.string.neterror);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            d.this.d(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), proZone);
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

    /* renamed from: d.b.i0.p0.e2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1381d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostWriteCallBackData f57426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f57427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f57428g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f57429h;

        public RunnableC1381d(PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
            this.f57426e = postWriteCallBackData;
            this.f57427f = j;
            this.f57428g = j2;
            this.f57429h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
            int i = d.b.b.e.p.l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setProZone(this.f57426e.getProZone());
            requestGetMyPostNetMessage.setParams(this.f57427f, this.f57428g, this.f57429h, k, i, f2, i2);
            d.this.f57477b.sendMessage(requestGetMyPostNetMessage);
        }
    }

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.f57422h = new a(2921031);
        this.i = new b(2921316);
        c cVar = new c(CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = cVar;
        cVar.getSocketMessageListener().setSelfListener(true);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.f57422h.setSelfListener(false);
        this.f57477b.registerListener(this.f57422h);
        this.f57477b.registerListener(this.j);
        this.f57477b.registerListener(this.i);
    }

    public final void b(a2 a2Var, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.f1(a2Var);
    }

    public final void c(w0 w0Var) {
        ArrayList<d.b.b.j.e.n> threadList;
        FrsViewData S = this.f57477b.S();
        if (S == null) {
            return;
        }
        this.f57480e.C(w0Var);
        if (this.f57480e.q0()) {
            ArrayList<d.b.b.j.e.n> arrayList = new ArrayList<>();
            arrayList.add(w0Var);
            threadList = this.f57482g.c(false, true, arrayList, null, true);
        } else {
            threadList = S.getThreadList();
        }
        if (threadList != null) {
            S.setThreadList(threadList);
            S.checkLiveStageInThreadList();
            this.f57476a.v1(threadList, S);
        }
    }

    public final void d(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        DataRes dataRes;
        User_Info user_Info;
        if (i != 0) {
            this.f57477b.showToast(str);
            return;
        }
        FrsViewData S = this.f57477b.S();
        if (S == null || S.getForum() == null || getMyPostResIdl == null || this.f57476a == null || this.f57480e == null || (dataRes = getMyPostResIdl.data) == null || dataRes.thread_info == null) {
            return;
        }
        w0 w0Var = new w0();
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
        builder.fname = S.getForum().getName();
        builder.fid = Long.valueOf(d.b.b.e.m.b.f(S.getForum().getId(), 0L));
        w0Var.Q2(builder.build(true));
        f(w0Var, i2);
    }

    public final void e(User.Builder builder, User_Info user_Info) {
        if (user_Info == null) {
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

    public final void f(w0 w0Var, int i) {
        if (i == 1) {
            FrsTabViewController.o y = this.f57477b.z2().y();
            if (y != null) {
                Fragment fragment = y.f16653b;
                if (fragment instanceof FrsCommonTabFragment) {
                    ((FrsCommonTabFragment) fragment).K0(w0Var);
                }
            }
        } else if (i == 2) {
            FrsTabViewController.o F = this.f57477b.z2().F(301);
            if (F == null || !(F.f16653b instanceof FrsGoodFragment)) {
                return;
            }
            this.f57478c.c(301);
            ((FrsGoodFragment) F.f16653b).e1(w0Var);
        } else if (w0Var.m1() > 0) {
            FrsTabViewController.o F2 = this.f57477b.z2().F(w0Var.m1());
            if (F2 != null) {
                Fragment fragment2 = F2.f16653b;
                if (fragment2 instanceof FrsCommonTabFragment) {
                    ((FrsCommonTabFragment) fragment2).K0(w0Var);
                }
            }
        } else {
            if (!ListUtils.isEmpty(w0Var.z0())) {
                w0Var.J1();
            }
            FrsTabViewController.o F3 = this.f57477b.z2().F(this.f57477b.z2().B());
            if (F3 != null) {
                Fragment fragment3 = F3.f16653b;
                if (fragment3 instanceof FrsNewAreaFragment) {
                    b(w0Var, (FrsNewAreaFragment) fragment3);
                } else {
                    c(w0Var);
                }
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        FrsModelController frsModelController = this.f57480e;
        if (frsModelController == null) {
            return;
        }
        boolean z = frsModelController.Z() != null && this.f57480e.Z().getIsBrandForum();
        int N = this.f57480e.N();
        if (N == 2 || N == 3 || N == 7 || N == 8 || z) {
            if ((d0.a().b(1) != null ? this.f57480e.R() : 0) != 0 || postWriteCallBackData == null) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.b.b.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            long f4 = d.b.b.e.m.b.f(this.f57477b.h(), 0L);
            if (f2 != 0 && f3 != 0 && f4 != 0) {
                d.b.b.e.m.e.a().postDelayed(new RunnableC1381d(postWriteCallBackData, f3, f2, f4), 1000L);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                w0 w0Var = new w0();
                w0Var.G2(writeData);
                f(w0Var, writeData.getProZone());
            }
        }
    }
}
