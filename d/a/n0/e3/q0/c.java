package d.a.n0.e3.q0;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.m0.s.c.i0;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f57900a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<d.a.m0.r.f0.a> f57901b;

    /* renamed from: c  reason: collision with root package name */
    public static PostWriteCallBackData f57902c;

    /* renamed from: d  reason: collision with root package name */
    public static i0 f57903d;

    /* renamed from: e  reason: collision with root package name */
    public static WriteData f57904e;

    /* renamed from: f  reason: collision with root package name */
    public static AntiData f57905f;

    /* renamed from: g  reason: collision with root package name */
    public static Intent f57906g;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f57907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NavigationBarCoverTip f57908f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f57909g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f57910h;

        public a(Activity activity, NavigationBarCoverTip navigationBarCoverTip, long j, long j2) {
            this.f57907e = activity;
            this.f57908f = navigationBarCoverTip;
            this.f57909g = j;
            this.f57910h = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.e3.q0.b.a("发帖-成功： 开始分享 -- start");
            view.setOnClickListener(null);
            if (!j.z()) {
                l.L(this.f57907e, R.string.neterror);
                this.f57908f.e();
                d.a.n0.e3.q0.b.a("发帖-成功： 开始分享 -- 失败 -- 无网");
                return;
            }
            int k = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float f2 = this.f57907e.getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(c.f57900a);
            requestGetMyPostNetMessage.setParams(this.f57909g, this.f57910h, 0L, k, i2, f2, i3);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            d.a.n0.e3.q0.b.a("发帖-成功： 开始分享 -- 发送GetMyPost");
            c.j(this.f57907e);
            this.f57908f.e();
            d.a.n0.e3.q0.b.a("发帖-成功： 开始分享 -- 关闭成功弹框");
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f57911e;

        public b(Activity activity) {
            this.f57911e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.e3.q0.b.a("发帖-失败： 重新编辑 -- start");
            view.setOnClickListener(null);
            WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f57911e);
            Intent intent = c.f57906g;
            if (intent != null) {
                newInstance.setIntent(intent);
            }
            newInstance.setFromErrorDialog(true);
            newInstance.send();
            d.a();
            d.a.n0.e3.q0.b.a("发帖-失败： 重新编辑 -- end");
        }
    }

    /* renamed from: d.a.n0.e3.q0.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1357c extends d.a.c.c.g.a {
        public C1357c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.n0.e3.q0.b.a("发帖-成功： 分享进行 -- 接受GetMyPost");
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

    public static int f(a2 a2Var) {
        if (a2Var != null) {
            if (a2Var.r2()) {
                return 4;
            }
            if (a2Var.s0() == 1) {
                return 3;
            }
            return a2Var.s2() ? 2 : 1;
        }
        return 0;
    }

    public static void g(int i2, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        d.a.n0.e3.q0.b.a("发帖-成功： 分享进行 -- 处理GetMyPost");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            d.a.n0.e3.q0.b.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- ACT为NULL");
        } else if (i2 == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
            a2 a2Var = new a2();
            a2Var.V2(getMyPostResIdl.data.thread_info);
            k(a2Var, currentActivity);
        } else {
            l.L(currentActivity, R.string.neterror);
            d.a.n0.e3.q0.b.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- 请求数据异常");
        }
    }

    public static void h() {
        d.a.m0.r.f0.a aVar;
        d.a.n0.e3.q0.b.a("发帖-成功： 开始分享 -- 隐藏loading -- start");
        WeakReference<d.a.m0.r.f0.a> weakReference = f57901b;
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            return;
        }
        aVar.h(false);
        d.a.n0.e3.q0.b.a("发帖-成功： 开始分享 -- 隐藏loading -- end");
        f57901b.clear();
    }

    public static void i() {
        C1357c c1357c = new C1357c(CmdConfigHttp.CMD_GET_MY_POST, 303111);
        c1357c.setTag(f57900a);
        c1357c.getHttpMessageListener().setSelfListener(true);
        c1357c.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(c1357c);
    }

    public static void j(Activity activity) {
        d.a.m0.r.f0.a aVar = new d.a.m0.r.f0.a(activity);
        f57901b = new WeakReference<>(aVar);
        aVar.h(true);
        d.a.n0.e3.q0.b.a("发帖-成功： 开始分享 -- 显示loading");
    }

    public static void k(a2 a2Var, Activity activity) {
        d.a.n0.e3.q0.b.a("发帖-成功： 分享弹框 -- start");
        if (a2Var == null || activity == null) {
            return;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = a2Var.i0();
        String A1 = a2Var.A1();
        if (TextUtils.isEmpty(A1)) {
            A1 = a2Var.C();
        }
        String z1 = a2Var.z1();
        String str = "http://tieba.baidu.com/p/" + z1 + "?share=9105&fr=share";
        String e2 = e(a2Var);
        Uri parse = e2 == null ? null : Uri.parse(e2);
        String C = a2Var.C();
        String format = MessageFormat.format(activity.getResources().getString(R.string.share_content_tpl), A1, C);
        ShareItem shareItem = new ShareItem();
        shareItem.r = A1;
        shareItem.s = format;
        shareItem.R = 0L;
        shareItem.D = C;
        shareItem.t = str;
        shareItem.o = 5;
        shareItem.q = z1;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = i0;
        shareItem.K = z1;
        shareItem.f12662f = true;
        shareItem.E = 15;
        shareItem.M = f(a2Var);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(a2Var);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(a2Var);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.e0 = a2Var.g1();
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        d.a.n0.e3.q0.b.a("发帖-成功： 分享弹框 -- 显示 -- end");
        d.a.n0.d0.f.b().k(new ShareDialogConfig((Context) activity, shareItem, true, true));
    }

    public static void l(PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
        if (postWriteCallBackData == null) {
            d.a.n0.e3.q0.b.a("发帖-失败： 失败弹框 -- 无backData");
            return;
        }
        f57902c = postWriteCallBackData;
        f57903d = i0Var;
        f57904e = writeData;
        f57905f = antiData;
        d.a.n0.e3.q0.b.a("发帖-失败： 失败弹框 -- start");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            d.a.n0.e3.q0.b.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity为NULL");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
        if (frameLayout == null) {
            d.a.n0.e3.q0.b.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity的content为NULL");
            return;
        }
        NavigationBarCoverTip navigationBarCoverTip = null;
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            if (frameLayout.getChildAt(i2) instanceof NavigationBarCoverTip) {
                navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i2);
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
        tBSpecificationBtn.setConfig(new d.a.m0.r.f0.m.c());
        SkinManager.setViewTextColor(textView, R.color.CAM_X0301);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0301);
        tBSpecificationBtn.k();
        shadowLinearLayout.b();
        tBSpecificationBtn.setOnClickListener(new b(currentActivity));
        navigationBarCoverTip.setBackgroundColor(0);
        navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
        d.b();
        d.a.n0.e3.q0.b.a("发帖-失败： 失败弹框 -- 成功 -- end");
    }

    public static void m(PostWriteCallBackData postWriteCallBackData) {
        d.a.n0.e3.q0.b.a("发帖-成功： 成功弹框 -- start");
        if (postWriteCallBackData == null) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
        long f3 = d.a.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
        if (f2 != 0 && f3 != 0) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                d.a.n0.e3.q0.b.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                d.a.n0.e3.q0.b.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
                return;
            }
            NavigationBarCoverTip navigationBarCoverTip = null;
            for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                if (frameLayout.getChildAt(i2) instanceof NavigationBarCoverTip) {
                    navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i2);
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
            tBSpecificationBtn.setConfig(new d.a.m0.r.f0.m.c());
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302);
            tBSpecificationBtn.k();
            shadowLinearLayout.b();
            tBSpecificationBtn.setOnClickListener(new a(currentActivity, navigationBarCoverTip2, f3, f2));
            navigationBarCoverTip2.setBackgroundColor(0);
            navigationBarCoverTip2.m(currentActivity, shadowLinearLayout, 5000);
            d.a.n0.e3.q0.b.a("发帖-成功： 成功弹框 -- 成功 -- end");
            return;
        }
        d.a.n0.e3.q0.b.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + f2 + "  threadId = " + f3);
    }

    public static void n(PostWriteCallBackData postWriteCallBackData) {
        d.a.n0.e3.q0.b.a("发帖-成功-视频： 成功弹框 -- start");
        if (postWriteCallBackData == null) {
            return;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            d.a.n0.e3.q0.b.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity为NULL");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
        if (frameLayout == null) {
            d.a.n0.e3.q0.b.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
            return;
        }
        NavigationBarCoverTip navigationBarCoverTip = null;
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            if (frameLayout.getChildAt(i2) instanceof NavigationBarCoverTip) {
                navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i2);
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
        d.a.n0.e3.q0.b.a("发帖-成功-视频： 成功弹框 -- 成功 -- end");
    }
}
