package com.repackage;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class hx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ AbsPbActivity b;
        public final /* synthetic */ View c;

        public a(PbModel pbModel, AbsPbActivity absPbActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, absPbActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = absPbActivity;
            this.c = view2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.a) == null || pbModel.P1() == null || !this.a.P1().r0() || TbSingleton.getInstance().isNotchScreen(this.b) || TbSingleton.getInstance().isCutoutScreen(this.b) || (view2 = this.c) == null) {
                return;
            }
            view2.setSystemUiVisibility(4);
        }
    }

    public static int a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isVideoWorksInfo()) {
                return 11;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 10;
            }
            if (threadData.isBJHVideoThreadType()) {
                return 9;
            }
            if (threadData.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 7;
            }
            if (threadData.isShareThread) {
                return 6;
            }
            int i = threadData.threadType;
            if (i == 0) {
                return 1;
            }
            if (i == 40) {
                return 2;
            }
            if (i == 49) {
                return 3;
            }
            return i == 54 ? 4 : 5;
        }
        return invokeL.intValue;
    }

    public static int b(kp7 kp7Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kp7Var)) == null) {
            if (kp7Var == null || (O = kp7Var.O()) == null) {
                return 0;
            }
            if (O.isRealGod()) {
                return 4;
            }
            if (O.getIsLive() == 1) {
                return 3;
            }
            if (O.isBJHArticleThreadType()) {
                return 5;
            }
            if (O.isBJHVideoThreadType()) {
                return 6;
            }
            if (O.isBJHNormalThreadType()) {
                return 7;
            }
            if (O.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            return O.isRealVideoThread() ? 2 : 1;
        }
        return invokeL.intValue;
    }

    public static void c(AbsPbActivity absPbActivity, int i, int i2) {
        String h2;
        String str;
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65538, null, absPbActivity, i, i2) == null) || absPbActivity == null || absPbActivity.getPbModel() == null) {
            return;
        }
        PbModel pbModel = absPbActivity.getPbModel();
        View rootView = absPbActivity.getRootView();
        if (pbModel.a()) {
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            kp7 P1 = pbModel.P1();
            String title = P1.O().getTitle();
            boolean s1 = pbModel.s1();
            if (P1.l() != null) {
                if (P1.l().isLike() == 1) {
                    AddExperiencedModel.D(P1.m());
                }
            }
            ThreadData O = pbModel.P1().O();
            if (O.isUgcThreadType()) {
                h2 = O.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (s1 ? 1 : 0) + "&dtype=" + O.getBaijiahaoData().oriUgcType + "&dvid=" + O.getBaijiahaoData().oriUgcVid + "&nid=" + O.getBaijiahaoData().oriUgcNid;
            } else {
                h2 = pbModel.h2();
                str = "?share=9105&fr=sharewise&see_lz=" + (s1 ? 1 : 0);
            }
            String str2 = "http://tieba.baidu.com/p/" + h2 + (str + "&share_from=post");
            String[] M = P1.M();
            String str3 = M[0];
            if (!StringUtils.isNull(str3) && str3.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str3 = str3.substring(37);
            }
            Uri parse = str3 == null ? null : Uri.parse(str3);
            String str4 = M[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", P1.m()).param("tid", P1.Q()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0490);
            if (P1.g0() && O.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4) || O.isBJHVideoDynamicThreadType() || O.isBJHVideoThreadType()) {
                    if (TextUtils.isEmpty(title)) {
                        c = 1;
                        title = M[1];
                    } else {
                        c = 1;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = O.getAuthor().getName_show();
                    objArr[c] = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0491);
                    str4 = MessageFormat.format(string, objArr);
                }
            } else if (ki.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = ki.cutString(title, 100);
            String cutString2 = ki.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.u = cutString;
            shareItem.v = cutString2;
            if (P1.g0()) {
                shareItem.G = cutString2;
                shareItem.U = -1L;
            } else if (P1.O() != null && P1.O().getThreadVideoInfo() != null && !P1.O().isUgcThreadType()) {
                shareItem.U = P1.O().getThreadVideoInfo().play_count.intValue();
            }
            shareItem.w = str2;
            shareItem.c = true;
            shareItem.t = pbModel.h2();
            shareItem.I = 3;
            shareItem.H = i2;
            shareItem.M = pbModel.getForumId();
            shareItem.N = pbModel.h2();
            shareItem.P = b(P1);
            shareItem.Q = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.y = parse;
            }
            if (i2 == 2) {
                shareItem.I = pbModel.t1();
            }
            if (P1.g0()) {
                shareItem.r0 = false;
            }
            shareItem.W = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (P1 != null && P1.F() != null && P1.F().size() > 0) {
                shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(O, 1, P1.F().get(0));
            } else {
                shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (O != null) {
                shareItem.p0 = O.getShareImageUrl();
            }
            shareItem.J = a(O);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.I);
            bundle.putInt("obj_type", shareItem.P);
            bundle.putString("fid", shareItem.M);
            bundle.putString("tid", shareItem.N);
            bundle.putString("uid", shareItem.Q);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
            shareDialogConfig.setOnDismissListener(new a(pbModel, absPbActivity, rootView));
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            ay5.c().l(shareDialogConfig);
        }
    }
}
