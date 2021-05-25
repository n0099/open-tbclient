package d.a.n0.r0.e2;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.w0;
import d.a.n0.r0.d0;
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
    public final CustomMessageListener f58472h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f58473i;
    public final d.a.c.c.g.a j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str) || d.this.f58538b.g0() == null) {
                return;
            }
            FrsViewData g0 = d.this.f58538b.g0();
            g0.removeThread(str);
            d.this.f58537a.v1(g0.getThreadList(), g0);
            if (d.a.n0.e3.e.i() != null) {
                d.a.n0.e3.e.i().n(d.this.f58538b.g(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
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
            if (dVar.f58538b == null || dVar.f58537a == null || dVar.f58540d == null || (eVar = (ForumManageModel.e) customResponsedMessage.getData()) == null || TextUtils.isEmpty(eVar.f20834a) || d.this.f58538b.g0() == null) {
                return;
            }
            String str = eVar.f20834a;
            String str2 = eVar.f20835b;
            String str3 = eVar.f20836c;
            if (eVar.f20837d == 4) {
                FrsViewData g0 = d.this.f58538b.g0();
                a2 threadDataById = g0.getThreadDataById(str);
                g0.removeThreadData(threadDataById);
                List<d.a.c.j.e.n> topThreadList = g0.getTopThreadList();
                if (topThreadList == null) {
                    topThreadList = new ArrayList<>();
                }
                topThreadList.add(0, threadDataById);
                d.this.f58537a.v1(g0.getThreadList(), g0);
                d.this.f58540d.R(g0);
            }
            if (TextUtils.equals(d.this.f58538b.g(), str3)) {
                d.a.n0.e3.e.i().n(d.this.f58538b.g(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
        @Override // d.a.c.c.g.a
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
                            errorString2 = d.this.f58538b.getResources().getString(R.string.neterror);
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
                            errorString = d.this.f58538b.getResources().getString(R.string.neterror);
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

    /* renamed from: d.a.n0.r0.e2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1493d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostWriteCallBackData f58477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f58478f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f58479g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f58480h;

        public RunnableC1493d(PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
            this.f58477e = postWriteCallBackData;
            this.f58478f = j;
            this.f58479g = j2;
            this.f58480h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
            int i2 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setProZone(this.f58477e.getProZone());
            requestGetMyPostNetMessage.setParams(this.f58478f, this.f58479g, this.f58480h, k, i2, f2, i3);
            d.this.f58538b.sendMessage(requestGetMyPostNetMessage);
        }
    }

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.f58472h = new a(2921031);
        this.f58473i = new b(2921316);
        c cVar = new c(CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = cVar;
        cVar.getSocketMessageListener().setSelfListener(true);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.f58472h.setSelfListener(false);
        this.f58538b.registerListener(this.f58472h);
        this.f58538b.registerListener(this.j);
        this.f58538b.registerListener(this.f58473i);
    }

    public final void b(a2 a2Var, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.e1(a2Var);
    }

    public final void c(w0 w0Var) {
        ArrayList<d.a.c.j.e.n> threadList;
        FrsViewData g0 = this.f58538b.g0();
        if (g0 == null) {
            return;
        }
        this.f58541e.C(w0Var);
        if (this.f58541e.q0()) {
            ArrayList<d.a.c.j.e.n> arrayList = new ArrayList<>();
            arrayList.add(w0Var);
            threadList = this.f58543g.c(false, true, arrayList, null, true);
        } else {
            threadList = g0.getThreadList();
        }
        if (threadList != null) {
            g0.setThreadList(threadList);
            g0.checkLiveStageInThreadList();
            this.f58537a.v1(threadList, g0);
        }
    }

    public final void d(int i2, String str, GetMyPostResIdl getMyPostResIdl, int i3) {
        DataRes dataRes;
        User_Info user_Info;
        if (i2 != 0) {
            this.f58538b.showToast(str);
            return;
        }
        FrsViewData g0 = this.f58538b.g0();
        if (g0 == null || g0.getForum() == null || getMyPostResIdl == null || this.f58537a == null || this.f58541e == null || (dataRes = getMyPostResIdl.data) == null || dataRes.thread_info == null) {
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
        builder.fname = g0.getForum().getName();
        builder.fid = Long.valueOf(d.a.c.e.m.b.f(g0.getForum().getId(), 0L));
        w0Var.U2(builder.build(true));
        f(w0Var, i3);
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

    public final void f(w0 w0Var, int i2) {
        if (i2 == 1) {
            FrsTabViewController.o y = this.f58538b.y2().y();
            if (y != null) {
                Fragment fragment = y.f15761b;
                if (fragment instanceof FrsCommonTabFragment) {
                    ((FrsCommonTabFragment) fragment).J0(w0Var);
                }
            }
        } else if (i2 == 2) {
            FrsTabViewController.o F = this.f58538b.y2().F(301);
            if (F == null || !(F.f15761b instanceof FrsGoodFragment)) {
                return;
            }
            this.f58539c.b(301);
            ((FrsGoodFragment) F.f15761b).d1(w0Var);
        } else if (w0Var.n1() > 0) {
            FrsTabViewController.o F2 = this.f58538b.y2().F(w0Var.n1());
            if (F2 != null) {
                Fragment fragment2 = F2.f15761b;
                if (fragment2 instanceof FrsCommonTabFragment) {
                    ((FrsCommonTabFragment) fragment2).J0(w0Var);
                }
            }
        } else {
            if (!ListUtils.isEmpty(w0Var.A0())) {
                w0Var.L1();
            }
            FrsTabViewController.o F3 = this.f58538b.y2().F(this.f58538b.y2().B());
            if (F3 != null) {
                Fragment fragment3 = F3.f15761b;
                if (fragment3 instanceof FrsNewAreaFragment) {
                    b(w0Var, (FrsNewAreaFragment) fragment3);
                } else {
                    c(w0Var);
                }
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        FrsModelController frsModelController = this.f58541e;
        if (frsModelController == null) {
            return;
        }
        boolean z = frsModelController.Z() != null && this.f58541e.Z().getIsBrandForum();
        int N = this.f58541e.N();
        if (N == 2 || N == 3 || N == 7 || N == 8 || z) {
            if ((d0.a().b(1) != null ? this.f58541e.R() : 0) != 0 || postWriteCallBackData == null) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.a.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            long f4 = d.a.c.e.m.b.f(this.f58538b.h(), 0L);
            if (f2 != 0 && f3 != 0 && f4 != 0) {
                d.a.c.e.m.e.a().postDelayed(new RunnableC1493d(postWriteCallBackData, f3, f2, f4), 1000L);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                w0 w0Var = new w0();
                w0Var.K2(writeData);
                f(w0Var, writeData.getProZone());
            }
        }
    }
}
