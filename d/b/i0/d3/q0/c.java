package d.b.i0.d3.q0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ShadowLinearLayout;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.s.c.h0;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f55026a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<d.b.h0.r.f0.a> f55027b;

    /* renamed from: c  reason: collision with root package name */
    public static PostWriteCallBackData f55028c;

    /* renamed from: d  reason: collision with root package name */
    public static h0 f55029d;

    /* renamed from: e  reason: collision with root package name */
    public static WriteData f55030e;

    /* renamed from: f  reason: collision with root package name */
    public static AntiData f55031f;

    /* renamed from: g  reason: collision with root package name */
    public static Intent f55032g;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f55033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NavigationBarCoverTip f55034f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f55035g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f55036h;

        public a(Activity activity, NavigationBarCoverTip navigationBarCoverTip, long j, long j2) {
            this.f55033e = activity;
            this.f55034f = navigationBarCoverTip;
            this.f55035g = j;
            this.f55036h = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.d3.q0.b.a("发帖-成功： 开始分享 -- start");
            view.setOnClickListener(null);
            if (!j.z()) {
                l.K(this.f55033e, R.string.neterror);
                this.f55034f.e();
                d.b.i0.d3.q0.b.a("发帖-成功： 开始分享 -- 失败 -- 无网");
                return;
            }
            int k = l.k(TbadkCoreApplication.getInst());
            int i = l.i(TbadkCoreApplication.getInst());
            float f2 = this.f55033e.getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(c.f55026a);
            requestGetMyPostNetMessage.setParams(this.f55035g, this.f55036h, 0L, k, i, f2, i2);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            d.b.i0.d3.q0.b.a("发帖-成功： 开始分享 -- 发送GetMyPost");
            c.j(this.f55033e);
            this.f55034f.e();
            d.b.i0.d3.q0.b.a("发帖-成功： 开始分享 -- 关闭成功弹框");
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f55037e;

        public b(Activity activity) {
            this.f55037e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.d3.q0.b.a("发帖-失败： 重新编辑 -- start");
            view.setOnClickListener(null);
            WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f55037e);
            Intent intent = c.f55032g;
            if (intent != null) {
                newInstance.setIntent(intent);
            }
            newInstance.setFromErrorDialog(true);
            newInstance.send();
            d.a();
            d.b.i0.d3.q0.b.a("发帖-失败： 重新编辑 -- end");
        }
    }

    /* renamed from: d.b.i0.d3.q0.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1248c extends d.b.c.c.g.a {
        public C1248c(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.d3.q0.b.a("发帖-成功： 分享进行 -- 接受GetMyPost");
            c.h();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                c.g(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                c.g(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    }

    static {
        i();
    }

    public static String e(a2 a2Var) {
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

    public static int f(a2 a2Var) {
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

    public static void g(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        d.b.i0.d3.q0.b.a("发帖-成功： 分享进行 -- 处理GetMyPost");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            d.b.i0.d3.q0.b.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- ACT为NULL");
        } else if (i == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
            a2 a2Var = new a2();
            a2Var.R2(getMyPostResIdl.data.thread_info);
            k(a2Var, currentActivity);
        } else {
            l.K(currentActivity, R.string.neterror);
            d.b.i0.d3.q0.b.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- 请求数据异常");
        }
    }

    public static void h() {
        d.b.h0.r.f0.a aVar;
        d.b.i0.d3.q0.b.a("发帖-成功： 开始分享 -- 隐藏loading -- start");
        WeakReference<d.b.h0.r.f0.a> weakReference = f55027b;
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            return;
        }
        aVar.h(false);
        d.b.i0.d3.q0.b.a("发帖-成功： 开始分享 -- 隐藏loading -- end");
        f55027b.clear();
    }

    public static void i() {
        C1248c c1248c = new C1248c(CmdConfigHttp.CMD_GET_MY_POST, 303111);
        c1248c.setTag(f55026a);
        c1248c.getHttpMessageListener().setSelfListener(true);
        c1248c.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(c1248c);
    }

    public static void j(Activity activity) {
        d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(activity);
        f55027b = new WeakReference<>(aVar);
        aVar.h(true);
        d.b.i0.d3.q0.b.a("发帖-成功： 开始分享 -- 显示loading");
    }

    public static void k(a2 a2Var, Activity activity) {
        d.b.i0.d3.q0.b.a("发帖-成功： 分享弹框 -- start");
        if (a2Var == null || activity == null) {
            return;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = a2Var.i0();
        String x1 = a2Var.x1();
        if (TextUtils.isEmpty(x1)) {
            x1 = a2Var.C();
        }
        String w1 = a2Var.w1();
        String str = "http://tieba.baidu.com/p/" + w1 + "?share=9105&fr=share";
        String e2 = e(a2Var);
        Uri parse = e2 == null ? null : Uri.parse(e2);
        String C = a2Var.C();
        String format = MessageFormat.format(activity.getResources().getString(R.string.share_content_tpl), x1, C);
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
        shareItem.f13378f = true;
        shareItem.D = 15;
        shareItem.L = f(a2Var);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.S = OriginalThreadInfo.ShareInfo.generateShareInfo(a2Var);
        shareItem.T = ShareItem.ForwardInfo.generateForwardInfo(a2Var);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.c0 = a2Var.e1();
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.E);
        bundle.putInt("obj_type", shareItem.L);
        bundle.putString("fid", shareItem.I);
        bundle.putString("tid", shareItem.J);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.i(bundle);
        d.b.i0.d3.q0.b.a("发帖-成功： 分享弹框 -- 显示 -- end");
        d.b.i0.b0.f.b().k(new ShareDialogConfig((Context) activity, shareItem, true, true));
    }

    public static void l(PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
        if (postWriteCallBackData == null) {
            d.b.i0.d3.q0.b.a("发帖-失败： 失败弹框 -- 无backData");
            return;
        }
        f55028c = postWriteCallBackData;
        f55029d = h0Var;
        f55030e = writeData;
        f55031f = antiData;
        d.b.i0.d3.q0.b.a("发帖-失败： 失败弹框 -- start");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            d.b.i0.d3.q0.b.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity为NULL");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
        if (frameLayout == null) {
            d.b.i0.d3.q0.b.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity的content为NULL");
            return;
        }
        NavigationBarCoverTip navigationBarCoverTip = null;
        for (int i = 0; i < frameLayout.getChildCount(); i++) {
            if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i);
            }
        }
        if (navigationBarCoverTip == null) {
            navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
            frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
        }
        navigationBarCoverTip.setVisibility(8);
        ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
        TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
        TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_content);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.tb_top_toast_btn);
        textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_title));
        String errorString = postWriteCallBackData.getErrorString();
        if (TextUtils.isEmpty(errorString)) {
            textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_content));
        } else {
            textView2.setText(errorString);
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_btn));
        tBSpecificationBtn.setConfig(new d.b.h0.r.f0.m.c());
        SkinManager.setViewTextColor(textView, R.color.CAM_X0301);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0301);
        tBSpecificationBtn.k();
        shadowLinearLayout.b();
        tBSpecificationBtn.setOnClickListener(new b(currentActivity));
        navigationBarCoverTip.setBackgroundColor(0);
        navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
        d.b();
        d.b.i0.d3.q0.b.a("发帖-失败： 失败弹框 -- 成功 -- end");
    }

    public static void m(PostWriteCallBackData postWriteCallBackData) {
        d.b.i0.d3.q0.b.a("发帖-成功： 成功弹框 -- start");
        if (postWriteCallBackData == null) {
            return;
        }
        long f2 = d.b.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
        long f3 = d.b.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
        if (f2 != 0 && f3 != 0) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                d.b.i0.d3.q0.b.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                d.b.i0.d3.q0.b.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
                return;
            }
            NavigationBarCoverTip navigationBarCoverTip = null;
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                    navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i);
                }
            }
            if (navigationBarCoverTip == null) {
                navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
                frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
            }
            NavigationBarCoverTip navigationBarCoverTip2 = navigationBarCoverTip;
            navigationBarCoverTip2.setVisibility(8);
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_content);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.tb_top_toast_btn);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
            textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
            tBSpecificationBtn.setConfig(new d.b.h0.r.f0.m.c());
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302);
            tBSpecificationBtn.k();
            shadowLinearLayout.b();
            tBSpecificationBtn.setOnClickListener(new a(currentActivity, navigationBarCoverTip2, f3, f2));
            navigationBarCoverTip2.setBackgroundColor(0);
            navigationBarCoverTip2.m(currentActivity, shadowLinearLayout, 5000);
            d.b.i0.d3.q0.b.a("发帖-成功： 成功弹框 -- 成功 -- end");
            return;
        }
        d.b.i0.d3.q0.b.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + f2 + "  threadId = " + f3);
    }

    public static void n(PostWriteCallBackData postWriteCallBackData) {
        d.b.i0.d3.q0.b.a("发帖-成功-视频： 成功弹框 -- start");
        if (postWriteCallBackData == null) {
            return;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            d.b.i0.d3.q0.b.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity为NULL");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
        if (frameLayout == null) {
            d.b.i0.d3.q0.b.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
            return;
        }
        NavigationBarCoverTip navigationBarCoverTip = null;
        for (int i = 0; i < frameLayout.getChildCount(); i++) {
            if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i);
            }
        }
        if (navigationBarCoverTip == null) {
            navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
            frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
        }
        navigationBarCoverTip.setVisibility(8);
        ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout_no_tip, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
        TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
        textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_video_title));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
        shadowLinearLayout.b();
        navigationBarCoverTip.setBackgroundColor(0);
        navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
        d.b.i0.d3.q0.b.a("发帖-成功-视频： 成功弹框 -- 成功 -- end");
    }
}
