package d.a.q0.h3.q0;

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
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.t.c.k0;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f58805a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<d.a.p0.s.f0.a> f58806b;

    /* renamed from: c  reason: collision with root package name */
    public static PostWriteCallBackData f58807c;

    /* renamed from: d  reason: collision with root package name */
    public static k0 f58808d;

    /* renamed from: e  reason: collision with root package name */
    public static WriteData f58809e;

    /* renamed from: f  reason: collision with root package name */
    public static AntiData f58810f;

    /* renamed from: g  reason: collision with root package name */
    public static Intent f58811g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f58812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NavigationBarCoverTip f58813f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f58814g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f58815h;

        public a(Activity activity, NavigationBarCoverTip navigationBarCoverTip, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, navigationBarCoverTip, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58812e = activity;
            this.f58813f = navigationBarCoverTip;
            this.f58814g = j;
            this.f58815h = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                h.a("发帖-成功： 开始分享 -- start");
                view.setOnClickListener(null);
                if (!d.a.d.e.p.j.z()) {
                    d.a.d.e.p.l.L(this.f58812e, R.string.neterror);
                    this.f58813f.e();
                    h.a("发帖-成功： 开始分享 -- 失败 -- 无网");
                    return;
                }
                int k = d.a.d.e.p.l.k(TbadkCoreApplication.getInst());
                int i2 = d.a.d.e.p.l.i(TbadkCoreApplication.getInst());
                float f2 = this.f58812e.getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(i.f58805a);
                requestGetMyPostNetMessage.setParams(this.f58814g, this.f58815h, 0L, k, i2, f2, i3);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                h.a("发帖-成功： 开始分享 -- 发送GetMyPost");
                i.j(this.f58812e);
                this.f58813f.e();
                h.a("发帖-成功： 开始分享 -- 关闭成功弹框");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteData f58816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f58817f;

        public b(WriteData writeData, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58816e = writeData;
            this.f58817f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                h.a("发帖-失败： 重新编辑 -- start");
                view.setOnClickListener(null);
                WriteData writeData = this.f58816e;
                if (writeData != null && writeData.isWork()) {
                    d.a.p0.s.m.c.f53179c.d(this.f58816e, this.f58817f);
                    return;
                }
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f58817f);
                Intent intent = i.f58811g;
                if (intent != null) {
                    newInstance.setIntent(intent);
                }
                newInstance.setFromErrorDialog(true);
                newInstance.send();
                j.a();
                h.a("发帖-失败： 重新编辑 -- end");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
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
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                h.a("发帖-成功： 分享进行 -- 接受GetMyPost");
                i.h();
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    i.g(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    i.g(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(622948905, "Ld/a/q0/h3/q0/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(622948905, "Ld/a/q0/h3/q0/i;");
                return;
            }
        }
        f58805a = BdUniqueId.gen();
        i();
    }

    public static String e(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, b2Var)) == null) {
            if (b2Var == null || b2Var.A0() == null) {
                return null;
            }
            ArrayList<MediaData> A0 = b2Var.A0();
            int size = A0.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaData mediaData = A0.get(i2);
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
        return (String) invokeL.objValue;
    }

    public static int f(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, b2Var)) == null) {
            if (b2Var != null) {
                if (b2Var.f2()) {
                    return 4;
                }
                if (b2Var.h0() == 1) {
                    return 3;
                }
                return b2Var.g2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void g(int i2, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, null, i2, getMyPostResIdl) == null) {
            h.a("发帖-成功： 分享进行 -- 处理GetMyPost");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                h.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- ACT为NULL");
            } else if (i2 == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                b2 b2Var = new b2();
                b2Var.K2(getMyPostResIdl.data.thread_info);
                k(b2Var, currentActivity);
            } else {
                d.a.d.e.p.l.L(currentActivity, R.string.neterror);
                h.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- 请求数据异常");
            }
        }
    }

    public static void h() {
        d.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            h.a("发帖-成功： 开始分享 -- 隐藏loading -- start");
            WeakReference<d.a.p0.s.f0.a> weakReference = f58806b;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.h(false);
            h.a("发帖-成功： 开始分享 -- 隐藏loading -- end");
            f58806b.clear();
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            c cVar = new c(CmdConfigHttp.CMD_GET_MY_POST, 303111);
            cVar.setTag(f58805a);
            cVar.getHttpMessageListener().setSelfListener(true);
            cVar.getSocketMessageListener().setSelfListener(true);
            MessageManager.getInstance().registerListener(cVar);
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, activity) == null) {
            d.a.p0.s.f0.a aVar = new d.a.p0.s.f0.a(activity);
            f58806b = new WeakReference<>(aVar);
            aVar.h(true);
            h.a("发帖-成功： 开始分享 -- 显示loading");
        }
    }

    public static void k(b2 b2Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, b2Var, activity) == null) {
            h.a("发帖-成功： 分享弹框 -- start");
            if (b2Var == null || activity == null) {
                return;
            }
            String valueOf = String.valueOf(b2Var.R());
            String X = b2Var.X();
            String title = b2Var.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = b2Var.h();
            }
            String o1 = b2Var.o1();
            String str = "http://tieba.baidu.com/p/" + o1 + "?share=9105&fr=share";
            String e2 = e(b2Var);
            Uri parse = e2 == null ? null : Uri.parse(e2);
            String h2 = b2Var.h();
            String format = MessageFormat.format(activity.getResources().getString(R.string.share_content_tpl), title, h2);
            ShareItem shareItem = new ShareItem();
            shareItem.r = title;
            shareItem.s = format;
            shareItem.R = 0L;
            shareItem.D = h2;
            shareItem.t = str;
            shareItem.o = 5;
            shareItem.q = o1;
            shareItem.F = 3;
            shareItem.J = valueOf;
            shareItem.p = X;
            shareItem.K = o1;
            shareItem.f12892f = true;
            shareItem.E = 15;
            shareItem.M = f(b2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(b2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(b2Var);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.f0 = b2Var.V0();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            h.a("发帖-成功： 分享弹框 -- 显示 -- end");
            d.a.q0.e0.f.b().k(new ShareDialogConfig((Context) activity, shareItem, true, true));
        }
    }

    public static void l(PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, postWriteCallBackData, k0Var, writeData, antiData) == null) {
            if (postWriteCallBackData == null) {
                h.a("发帖-失败： 失败弹框 -- 无backData");
                return;
            }
            f58807c = postWriteCallBackData;
            f58808d = k0Var;
            f58809e = writeData;
            f58810f = antiData;
            h.a("发帖-失败： 失败弹框 -- start");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                h.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                h.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity的content为NULL");
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
            tBSpecificationBtn.setConfig(new d.a.p0.s.f0.n.c());
            SkinManager.setViewTextColor(textView, R.color.CAM_X0301);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0301);
            tBSpecificationBtn.k();
            shadowLinearLayout.b();
            tBSpecificationBtn.setOnClickListener(new b(writeData, currentActivity));
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
            j.b();
            h.a("发帖-失败： 失败弹框 -- 成功 -- end");
        }
    }

    public static void m(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, postWriteCallBackData) == null) {
            h.a("发帖-成功： 成功弹框 -- start");
            if (postWriteCallBackData == null) {
                return;
            }
            long f2 = d.a.d.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.a.d.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            if (f2 != 0 && f3 != 0) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity == null) {
                    h.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
                if (frameLayout == null) {
                    h.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
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
                tBSpecificationBtn.setConfig(new d.a.p0.s.f0.n.c());
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302);
                tBSpecificationBtn.k();
                shadowLinearLayout.b();
                tBSpecificationBtn.setOnClickListener(new a(currentActivity, navigationBarCoverTip2, f3, f2));
                navigationBarCoverTip2.setBackgroundColor(0);
                navigationBarCoverTip2.m(currentActivity, shadowLinearLayout, 5000);
                h.a("发帖-成功： 成功弹框 -- 成功 -- end");
                return;
            }
            h.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + f2 + "  threadId = " + f3);
        }
    }

    public static void n(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, postWriteCallBackData) == null) {
            h.a("发帖-成功-视频： 成功弹框 -- start");
            if (postWriteCallBackData == null) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                h.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                h.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
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
            h.a("发帖-成功-视频： 成功弹框 -- 成功 -- end");
        }
    }
}
