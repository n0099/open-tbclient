package d.b.j0.b0;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ShadowLinearLayout;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes4.dex */
public class h implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarCoverTip f53703e;

    /* renamed from: f  reason: collision with root package name */
    public ShadowLinearLayout f53704f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53705g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53706h;
    public TBSpecificationBtn i;
    public d.b.i0.r.f0.a j;
    public long k;
    public long l;
    public a2 m;
    public Activity n;
    public TbPageContext o;
    public boolean p = false;
    public boolean q = false;
    public final d.b.c.c.g.a r = new a(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.h();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                h.this.f(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                h.this.f(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    }

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.n = tbPageContext.getPageActivity();
        this.o = tbPageContext;
        this.f53703e = navigationBarCoverTip;
        this.r.setTag(tbPageContext.getUniqueId());
        this.r.getHttpMessageListener().setSelfListener(true);
        this.r.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.r);
    }

    public final String c(a2 a2Var) {
        if (a2Var == null || a2Var.K0() == null) {
            return null;
        }
        ArrayList<MediaData> K0 = a2Var.K0();
        int size = K0.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = K0.get(i);
            if (mediaData != null && mediaData.getType() == 3) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    return mediaData.getThumbnails_url();
                }
                if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    return mediaData.getPicUrl();
                }
            }
        }
        return null;
    }

    public final int d() {
        return 15;
    }

    public final int e(a2 a2Var) {
        if (a2Var != null) {
            if (a2Var.o2()) {
                return 4;
            }
            if (a2Var.s0() == 1) {
                return 3;
            }
            return a2Var.p2() ? 2 : 1;
        }
        return 0;
    }

    public final void f(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        if (i == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
            a2 a2Var = new a2();
            this.m = a2Var;
            a2Var.R2(getMyPostResIdl.data.thread_info);
            l();
            return;
        }
        this.o.showToast(R.string.neterror);
    }

    public final void h() {
        d.b.i0.r.f0.a aVar = this.j;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void i() {
        NavigationBarCoverTip navigationBarCoverTip = this.f53703e;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }

    public final void j() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", this.l);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", 7);
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
    }

    public final void k() {
        if (this.j == null) {
            this.j = new d.b.i0.r.f0.a(this.o);
        }
        this.j.h(true);
    }

    public final void l() {
        a2 a2Var = this.m;
        if (a2Var == null || this.n == null) {
            return;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = this.m.i0();
        String x1 = this.m.x1();
        if (TextUtils.isEmpty(x1)) {
            x1 = this.m.C();
        }
        String w1 = this.m.w1();
        String str = "http://tieba.baidu.com/p/" + w1 + "?share=9105&fr=share";
        String c2 = c(this.m);
        Uri parse = c2 == null ? null : Uri.parse(c2);
        String C = this.m.C();
        String format = MessageFormat.format(this.n.getResources().getString(R.string.share_content_tpl), x1, C);
        ShareItem shareItem = new ShareItem();
        shareItem.r = x1;
        shareItem.s = format;
        shareItem.Q = 0L;
        shareItem.C = C;
        shareItem.t = str;
        shareItem.o = 5;
        shareItem.q = w1;
        shareItem.E = 3;
        shareItem.I = valueOf;
        shareItem.p = i0;
        shareItem.J = w1;
        shareItem.f13386f = true;
        shareItem.D = d();
        shareItem.L = e(this.m);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.S = OriginalThreadInfo.ShareInfo.generateShareInfo(this.m);
        shareItem.T = ShareItem.ForwardInfo.generateForwardInfo(this.m);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.c0 = this.m.e1();
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.E);
        bundle.putInt("obj_type", shareItem.L);
        bundle.putString("fid", shareItem.I);
        bundle.putString("tid", shareItem.J);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.i(bundle);
        f.b().k(new ShareDialogConfig((Context) this.n, shareItem, true, true));
    }

    public void m(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || this.f53703e == null) {
            return;
        }
        this.k = d.b.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
        long f2 = d.b.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
        this.l = f2;
        if (this.k == 0 || f2 == 0) {
            return;
        }
        this.q = false;
        if (this.f53704f == null) {
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(this.n).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            this.f53704f = shadowLinearLayout;
            this.f53705g = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            this.f53706h = (TextView) this.f53704f.findViewById(R.id.tb_top_toast_content);
            this.i = (TBSpecificationBtn) this.f53704f.findViewById(R.id.tb_top_toast_btn);
            this.f53705g.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
            this.f53706h.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
            this.i.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
            this.i.setConfig(new d.b.i0.r.f0.m.a());
        }
        SkinManager.setViewTextColor(this.f53705g, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f53706h, R.color.CAM_X0302);
        this.i.k();
        this.f53704f.b();
        this.i.setOnClickListener(this);
        this.f53703e.setBackgroundColor(0);
        this.f53703e.m(this.n, this.f53704f, 5000);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.q) {
            return;
        }
        this.q = true;
        if (!j.z()) {
            this.o.showToast(R.string.neterror);
            this.f53703e.e();
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i = l.i(TbadkCoreApplication.getInst());
        float f2 = this.n.getResources().getDisplayMetrics().density;
        int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.o.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.l, this.k, 0L, k, i, f2, i2);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        k();
        this.f53703e.e();
        j();
    }
}
