package d.a.n0.d0;

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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes4.dex */
public class h implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarCoverTip f52450e;

    /* renamed from: f  reason: collision with root package name */
    public ShadowLinearLayout f52451f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52452g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52453h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f52454i;
    public d.a.m0.r.f0.a j;
    public long k;
    public long l;
    public a2 m;
    public Activity n;
    public TbPageContext o;
    public boolean p = false;
    public boolean q = false;
    public final d.a.c.c.g.a r = new a(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.g();
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
        this.f52450e = navigationBarCoverTip;
        this.r.setTag(tbPageContext.getUniqueId());
        this.r.getHttpMessageListener().setSelfListener(true);
        this.r.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.r);
    }

    public final String c(a2 a2Var) {
        if (a2Var == null || a2Var.L0() == null) {
            return null;
        }
        ArrayList<MediaData> L0 = a2Var.L0();
        int size = L0.size();
        for (int i2 = 0; i2 < size; i2++) {
            MediaData mediaData = L0.get(i2);
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
            if (a2Var.q2()) {
                return 4;
            }
            if (a2Var.s0() == 1) {
                return 3;
            }
            return a2Var.r2() ? 2 : 1;
        }
        return 0;
    }

    public final void f(int i2, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        if (i2 == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
            a2 a2Var = new a2();
            this.m = a2Var;
            a2Var.U2(getMyPostResIdl.data.thread_info);
            k();
            return;
        }
        this.o.showToast(R.string.neterror);
    }

    public final void g() {
        d.a.m0.r.f0.a aVar = this.j;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void h() {
        NavigationBarCoverTip navigationBarCoverTip = this.f52450e;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }

    public final void i() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", this.l);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", 7);
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
    }

    public final void j() {
        if (this.j == null) {
            this.j = new d.a.m0.r.f0.a(this.o);
        }
        this.j.h(true);
    }

    public final void k() {
        a2 a2Var = this.m;
        if (a2Var == null || this.n == null) {
            return;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = this.m.i0();
        String z1 = this.m.z1();
        if (TextUtils.isEmpty(z1)) {
            z1 = this.m.C();
        }
        String y1 = this.m.y1();
        String str = "http://tieba.baidu.com/p/" + y1 + "?share=9105&fr=share";
        String c2 = c(this.m);
        Uri parse = c2 == null ? null : Uri.parse(c2);
        String C = this.m.C();
        String format = MessageFormat.format(this.n.getResources().getString(R.string.share_content_tpl), z1, C);
        ShareItem shareItem = new ShareItem();
        shareItem.r = z1;
        shareItem.s = format;
        shareItem.R = 0L;
        shareItem.D = C;
        shareItem.t = str;
        shareItem.o = 5;
        shareItem.q = y1;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = i0;
        shareItem.K = y1;
        shareItem.f12600f = true;
        shareItem.E = d();
        shareItem.M = e(this.m);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.m);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.m);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.e0 = this.m.f1();
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        f.b().k(new ShareDialogConfig((Context) this.n, shareItem, true, true));
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || this.f52450e == null) {
            return;
        }
        this.k = d.a.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
        long f2 = d.a.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
        this.l = f2;
        if (this.k == 0 || f2 == 0) {
            return;
        }
        this.q = false;
        if (this.f52451f == null) {
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(this.n).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            this.f52451f = shadowLinearLayout;
            this.f52452g = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            this.f52453h = (TextView) this.f52451f.findViewById(R.id.tb_top_toast_content);
            this.f52454i = (TBSpecificationBtn) this.f52451f.findViewById(R.id.tb_top_toast_btn);
            this.f52452g.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
            this.f52453h.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
            this.f52454i.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
            this.f52454i.setConfig(new d.a.m0.r.f0.m.a());
        }
        SkinManager.setViewTextColor(this.f52452g, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f52453h, R.color.CAM_X0302);
        this.f52454i.k();
        this.f52451f.b();
        this.f52454i.setOnClickListener(this);
        this.f52450e.setBackgroundColor(0);
        this.f52450e.m(this.n, this.f52451f, 5000);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.q) {
            return;
        }
        this.q = true;
        if (!j.z()) {
            this.o.showToast(R.string.neterror);
            this.f52450e.e();
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        float f2 = this.n.getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.o.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.l, this.k, 0L, k, i2, f2, i3);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        j();
        this.f52450e.e();
        i();
    }
}
