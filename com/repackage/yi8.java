package com.repackage;

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
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes7.dex */
public class yi8 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId a;
    public static WeakReference<at4> b;
    public static PostWriteCallBackData c;
    public static ww4 d;
    public static WriteData e;
    public static AntiData f;
    public static Intent g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ NavigationBarCoverTip b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public a(Activity activity, NavigationBarCoverTip navigationBarCoverTip, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, navigationBarCoverTip, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = navigationBarCoverTip;
            this.c = j;
            this.d = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xi8.a("发帖-成功： 开始分享 -- start");
                view2.setOnClickListener(null);
                if (!ji.z()) {
                    li.N(this.a, R.string.obfuscated_res_0x7f0f0c33);
                    this.b.e();
                    xi8.a("发帖-成功： 开始分享 -- 失败 -- 无网");
                    return;
                }
                int k = li.k(TbadkCoreApplication.getInst());
                int i = li.i(TbadkCoreApplication.getInst());
                float f = this.a.getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(yi8.a);
                requestGetMyPostNetMessage.setParams(this.c, this.d, 0L, k, i, f, i2);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                xi8.a("发帖-成功： 开始分享 -- 发送GetMyPost");
                yi8.j(this.a);
                this.b.e();
                xi8.a("发帖-成功： 开始分享 -- 关闭成功弹框");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ Activity b;

        public b(WriteData writeData, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xi8.a("发帖-失败： 重新编辑 -- start");
                view2.setOnClickListener(null);
                WriteData writeData = this.a;
                if (writeData != null && writeData.isWork()) {
                    WorkPublishOpenHelper.Companion.d(this.a, this.b);
                    return;
                }
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.b);
                Intent intent = yi8.g;
                if (intent != null) {
                    newInstance.setIntent(intent);
                }
                newInstance.setFromErrorDialog(true);
                newInstance.send();
                zi8.a();
                xi8.a("发帖-失败： 重新编辑 -- end");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
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
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                xi8.a("发帖-成功： 分享进行 -- 接受GetMyPost");
                yi8.h();
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    yi8.g(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    yi8.g(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755140727, "Lcom/repackage/yi8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755140727, "Lcom/repackage/yi8;");
                return;
            }
        }
        a = BdUniqueId.gen();
        i();
    }

    public static String e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, threadData)) == null) {
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            for (int i = 0; i < size; i++) {
                MediaData mediaData = medias.get(i);
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

    public static int f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                return threadData.isRealVideoThread() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void g(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, null, i, getMyPostResIdl) == null) {
            xi8.a("发帖-成功： 分享进行 -- 处理GetMyPost");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                xi8.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- ACT为NULL");
            } else if (i == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(getMyPostResIdl.data.thread_info);
                k(threadData, currentActivity);
            } else {
                li.N(currentActivity, R.string.obfuscated_res_0x7f0f0c33);
                xi8.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- 请求数据异常");
            }
        }
    }

    public static void h() {
        at4 at4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            xi8.a("发帖-成功： 开始分享 -- 隐藏loading -- start");
            WeakReference<at4> weakReference = b;
            if (weakReference == null || (at4Var = weakReference.get()) == null) {
                return;
            }
            at4Var.h(false);
            xi8.a("发帖-成功： 开始分享 -- 隐藏loading -- end");
            b.clear();
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            c cVar = new c(CmdConfigHttp.CMD_GET_MY_POST, 303111);
            cVar.setTag(a);
            cVar.getHttpMessageListener().setSelfListener(true);
            cVar.getSocketMessageListener().setSelfListener(true);
            MessageManager.getInstance().registerListener(cVar);
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, activity) == null) {
            at4 at4Var = new at4(activity);
            b = new WeakReference<>(at4Var);
            at4Var.h(true);
            xi8.a("发帖-成功： 开始分享 -- 显示loading");
        }
    }

    public static void k(ThreadData threadData, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, threadData, activity) == null) {
            xi8.a("发帖-成功： 分享弹框 -- start");
            if (threadData == null || activity == null) {
                return;
            }
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = threadData.getForum_name();
            String title = threadData.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = threadData.getAbstract();
            }
            String tid = threadData.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String e2 = e(threadData);
            Uri parse = e2 == null ? null : Uri.parse(e2);
            String str2 = threadData.getAbstract();
            String format = MessageFormat.format(activity.getResources().getString(R.string.obfuscated_res_0x7f0f1142), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.u = title;
            shareItem.v = format;
            shareItem.U = 0L;
            shareItem.G = str2;
            shareItem.w = str;
            shareItem.r = 5;
            shareItem.t = tid;
            shareItem.I = 3;
            shareItem.M = valueOf;
            shareItem.s = forum_name;
            shareItem.N = tid;
            shareItem.f = true;
            shareItem.H = 15;
            shareItem.P = f(threadData);
            if (parse != null) {
                shareItem.y = parse;
            }
            shareItem.W = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(threadData);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.p0 = threadData.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.I);
            bundle.putInt("obj_type", shareItem.P);
            bundle.putString("fid", shareItem.M);
            bundle.putString("tid", shareItem.N);
            bundle.putInt("obj_source", shareItem.r);
            shareItem.k(bundle);
            xi8.a("发帖-成功： 分享弹框 -- 显示 -- end");
            ay5.c().l(new ShareDialogConfig((Context) activity, shareItem, true, true));
        }
    }

    public static void l(PostWriteCallBackData postWriteCallBackData, ww4 ww4Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, postWriteCallBackData, ww4Var, writeData, antiData) == null) {
            if (postWriteCallBackData == null) {
                xi8.a("发帖-失败： 失败弹框 -- 无backData");
                return;
            }
            c = postWriteCallBackData;
            d = ww4Var;
            e = writeData;
            f = antiData;
            xi8.a("发帖-失败： 失败弹框 -- start");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                xi8.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                xi8.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity的content为NULL");
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
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d07f8, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f091ef0);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091ef1);
            TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091eef);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091eee);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15d9));
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15d8));
            } else {
                textView2.setText(errorString);
            }
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15d7));
            tBSpecificationBtn.setConfig(new pt4());
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0301);
            tBSpecificationBtn.k();
            shadowLinearLayout.b();
            tBSpecificationBtn.setOnClickListener(new b(writeData, currentActivity));
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
            zi8.b();
            xi8.a("发帖-失败： 失败弹框 -- 成功 -- end");
        }
    }

    public static void m(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, postWriteCallBackData) == null) {
            xi8.a("发帖-成功： 成功弹框 -- start");
            if (postWriteCallBackData == null) {
                return;
            }
            long g2 = jg.g(postWriteCallBackData.getPostId(), 0L);
            long g3 = jg.g(postWriteCallBackData.getThreadId(), 0L);
            if (g2 != 0 && g3 != 0) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity == null) {
                    xi8.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
                if (frameLayout == null) {
                    xi8.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
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
                ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d07f8, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f091ef0);
                TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091ef1);
                TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091eef);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091eee);
                textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15dc));
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15da));
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f113d));
                tBSpecificationBtn.setConfig(new pt4());
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0302);
                tBSpecificationBtn.k();
                shadowLinearLayout.b();
                tBSpecificationBtn.setOnClickListener(new a(currentActivity, navigationBarCoverTip2, g3, g2));
                navigationBarCoverTip2.setBackgroundColor(0);
                navigationBarCoverTip2.m(currentActivity, shadowLinearLayout, 5000);
                xi8.a("发帖-成功： 成功弹框 -- 成功 -- end");
                return;
            }
            xi8.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + g2 + "  threadId = " + g3);
        }
    }

    public static void n(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, postWriteCallBackData) == null) {
            xi8.a("发帖-成功-视频： 成功弹框 -- start");
            if (postWriteCallBackData == null) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                xi8.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                xi8.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
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
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d07f9, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f091ef0);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091ef1);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15dd));
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
            shadowLinearLayout.b();
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
            xi8.a("发帖-成功-视频： 成功弹框 -- 成功 -- end");
        }
    }
}
