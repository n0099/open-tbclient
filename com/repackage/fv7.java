package com.repackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class fv7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ ot7 c;

        public a(PbModel pbModel, PbFragment pbFragment, ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, ot7Var};
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
            this.b = pbFragment;
            this.c = ot7Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.a) == null || pbModel.P1() == null || !this.a.P1().r0() || TbSingleton.getInstance().isNotchScreen(this.b.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.b.getBaseFragmentActivity())) {
                return;
            }
            this.c.m1().setSystemUiVisibility(4);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ Thread2GroupShareView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ShareFromPBMsgData h;

        public b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
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
            this.b = pbFragment;
            this.c = thread2GroupShareView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = shareFromPBMsgData;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.P1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.h2()).param("obj_locate", 1);
                    if (fv7.i(this.a.P1()) != 0) {
                        param.param("obj_type", fv7.i(this.a.P1()));
                    }
                    TiebaStatic.log(param);
                }
                this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;

        public c(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.b = thread2GroupShareView;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ ShareFromPBMsgData f;

        public d(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, long j2, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView, Long.valueOf(j), str, Long.valueOf(j2), shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.b = thread2GroupShareView;
            this.c = j;
            this.d = str;
            this.e = j2;
            this.f = shareFromPBMsgData;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.getBaseFragmentActivity(), this.c, this.d, this.e, "from_share", this.b.getLeaveMsg(), this.f.toChatMessageContent())));
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;

        public e(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.b = thread2GroupShareView;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                dq4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755694294, "Lcom/repackage/fv7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755694294, "Lcom/repackage/fv7;");
                return;
            }
        }
        a = new HashSet();
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.add(str);
        }
    }

    public static ShareItem c(Context context, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, threadData)) == null) {
            if (threadData == null || context == null) {
                return null;
            }
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = threadData.getForum_name();
            OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                forum_name = originalForumInfo.ori_fname;
            }
            String title = threadData.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = threadData.getAbstract();
            }
            String tid = threadData.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=sharewise";
            String f = f(threadData);
            Uri parse = f == null ? null : Uri.parse(f);
            String str2 = threadData.getAbstract();
            String format = MessageFormat.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f1142), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.u = title;
            shareItem.v = format;
            shareItem.U = threadData.getView_num();
            shareItem.G = str2;
            shareItem.w = str;
            shareItem.r = 2;
            shareItem.t = tid;
            shareItem.I = 3;
            shareItem.M = valueOf;
            shareItem.s = forum_name;
            shareItem.N = tid;
            shareItem.f = true;
            shareItem.H = 6;
            shareItem.P = h(threadData);
            if (parse != null) {
                shareItem.y = parse;
            }
            shareItem.W = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            shareItem.p0 = threadData.getShareImageUrl();
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.I);
            bundle.putInt("obj_type", shareItem.P);
            bundle.putString("fid", shareItem.M);
            bundle.putString("tid", shareItem.N);
            bundle.putInt("obj_source", shareItem.r);
            shareItem.k(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem d(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        String h2;
        String str;
        String str2;
        ShareItem shareItem;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, pbModel)) != null) {
            return (ShareItem) invokeIIL.objValue;
        }
        kp7 P1 = pbModel.P1();
        String title = P1.O().getTitle();
        boolean s1 = pbModel.s1();
        if (P1.l() != null) {
            if (P1.l().isLike() == 1) {
                AddExperiencedModel.D(P1.m());
            }
        }
        ThreadData O = pbModel.P1().O();
        O.setImShareFromPb(true);
        if (pbModel != null && pbModel.P1() != null) {
            O.setPbFirstShareData(pbModel.P1().i());
        }
        if (O.isUgcThreadType()) {
            h2 = O.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + (s1 ? 1 : 0) + "&dtype=" + O.getBaijiahaoData().oriUgcType + "&dvid=" + O.getBaijiahaoData().oriUgcVid + "&nid=" + O.getBaijiahaoData().oriUgcNid;
        } else {
            h2 = pbModel.h2();
            str = "?share=9105&fr=sharewise&see_lz=" + (s1 ? 1 : 0);
        }
        String str3 = "http://tieba.baidu.com/p/" + h2 + (str + "&share_from=post");
        String[] M = P1.M();
        String str4 = M[0];
        if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str4 = str4.substring(37);
        }
        Uri parse = str4 == null ? null : Uri.parse(str4);
        String str5 = M[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new StatisticItem("c10399").param("fid", P1.m()).param("tid", P1.Q()).param("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0490);
        if (P1.g0() && O.getAuthor() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                if (TextUtils.isEmpty(title) || O.isBJHVideoDynamicThreadType() || O.isBJHVideoThreadType()) {
                    title = M[1];
                }
                str2 = MessageFormat.format(string, O.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0491));
                String cutString = ki.cutString(title, 100);
                String cutString2 = ki.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.u = cutString;
                shareItem.v = cutString2;
                if (!P1.g0()) {
                }
                shareItem.w = str3;
                shareItem.c = true;
                shareItem.t = pbModel.h2();
                if (i2 == 2) {
                }
                shareItem.H = i2;
                shareItem.J = g(threadData);
                shareItem.M = pbModel.getForumId();
                shareItem.N = pbModel.h2();
                shareItem.P = i(P1);
                shareItem.Q = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (P1.g0()) {
                }
                shareItem.W = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                if (P1 == null) {
                }
                shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
                threadData2 = shareItem.W.threadData;
                if (threadData2 != null) {
                }
                if (threadData != null) {
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.I);
                bundle.putInt("obj_type", shareItem.P);
                bundle.putString("fid", shareItem.M);
                bundle.putString("tid", shareItem.N);
                bundle.putString("uid", shareItem.Q);
                shareItem.k(bundle);
                if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
                }
            }
            str2 = str5;
            String cutString3 = ki.cutString(title, 100);
            String cutString22 = ki.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.u = cutString3;
            shareItem.v = cutString22;
            if (!P1.g0()) {
            }
            shareItem.w = str3;
            shareItem.c = true;
            shareItem.t = pbModel.h2();
            if (i2 == 2) {
            }
            shareItem.H = i2;
            shareItem.J = g(threadData);
            shareItem.M = pbModel.getForumId();
            shareItem.N = pbModel.h2();
            shareItem.P = i(P1);
            shareItem.Q = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (P1.g0()) {
            }
            shareItem.W = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            if (P1 == null) {
            }
            shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            threadData2 = shareItem.W.threadData;
            if (threadData2 != null) {
            }
            if (threadData != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.I);
            bundle2.putInt("obj_type", shareItem.P);
            bundle2.putString("fid", shareItem.M);
            bundle2.putString("tid", shareItem.N);
            bundle2.putString("uid", shareItem.Q);
            shareItem.k(bundle2);
            if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
            }
        } else {
            if (ki.isEmpty(str5)) {
                str2 = title;
                String cutString32 = ki.cutString(title, 100);
                String cutString222 = ki.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.u = cutString32;
                shareItem.v = cutString222;
                if (!P1.g0()) {
                    shareItem.G = cutString222;
                    threadData = O;
                    shareItem.U = -1L;
                } else {
                    threadData = O;
                    shareItem.U = P1.P();
                }
                shareItem.w = str3;
                shareItem.c = true;
                shareItem.t = pbModel.h2();
                if (i2 == 2) {
                    shareItem.I = pbModel.t1();
                }
                shareItem.H = i2;
                shareItem.J = g(threadData);
                shareItem.M = pbModel.getForumId();
                shareItem.N = pbModel.h2();
                shareItem.P = i(P1);
                shareItem.Q = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.y = parse;
                }
                if (P1.g0()) {
                    shareItem.r0 = false;
                }
                shareItem.W = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                if (P1 == null && P1.F() != null && P1.F().size() > 0) {
                    shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, P1.F().get(0));
                } else {
                    shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
                }
                threadData2 = shareItem.W.threadData;
                if (threadData2 != null && threadData2.getForumData() == null && P1 != null && P1.l() != null) {
                    np4 np4Var = new np4();
                    np4Var.k(P1.l().getName());
                    np4Var.a = P1.l().getId();
                    np4Var.c = P1.l().getImage_url();
                    shareItem.W.threadData.setForumData(np4Var);
                }
                if (threadData != null) {
                    shareItem.p0 = threadData.getShareImageUrl();
                }
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.I);
                bundle22.putInt("obj_type", shareItem.P);
                bundle22.putString("fid", shareItem.M);
                bundle22.putString("tid", shareItem.N);
                bundle22.putString("uid", shareItem.Q);
                shareItem.k(bundle22);
                if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
                    return shareItem;
                }
                int k = yx4.k(threadData);
                String forum_name = threadData.getForum_name();
                OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
                if (originalForumInfo != null) {
                    forum_name = originalForumInfo.ori_fname;
                }
                shareItem.D0 = yx4.j(threadData, k);
                shareItem.E0 = yx4.i(threadData, k, forum_name, shareItem.U, "", M[1]);
                return shareItem;
            }
            str2 = str5;
            String cutString322 = ki.cutString(title, 100);
            String cutString2222 = ki.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.u = cutString322;
            shareItem.v = cutString2222;
            if (!P1.g0()) {
            }
            shareItem.w = str3;
            shareItem.c = true;
            shareItem.t = pbModel.h2();
            if (i2 == 2) {
            }
            shareItem.H = i2;
            shareItem.J = g(threadData);
            shareItem.M = pbModel.getForumId();
            shareItem.N = pbModel.h2();
            shareItem.P = i(P1);
            shareItem.Q = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (P1.g0()) {
            }
            shareItem.W = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            if (P1 == null) {
            }
            shareItem.Z = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            threadData2 = shareItem.W.threadData;
            if (threadData2 != null) {
                np4 np4Var2 = new np4();
                np4Var2.k(P1.l().getName());
                np4Var2.a = P1.l().getId();
                np4Var2.c = P1.l().getImage_url();
                shareItem.W.threadData.setForumData(np4Var2);
            }
            if (threadData != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.I);
            bundle222.putInt("obj_type", shareItem.P);
            bundle222.putString("fid", shareItem.M);
            bundle222.putString("tid", shareItem.N);
            bundle222.putString("uid", shareItem.Q);
            shareItem.k(bundle222);
            if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
            }
        }
    }

    public static ShareFromPBMsgData e(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.v() == null || pbFragment.Z4() == null) {
                return null;
            }
            PbModel v = pbFragment.v();
            ot7 Z4 = pbFragment.Z4();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            String[] M = v.P1().M();
            PostData F0 = Z4.F0();
            String str2 = "";
            if (F0 != null) {
                str = F0.I();
                String n = F0.n();
                if (!ki.isEmpty(n)) {
                    M[1] = n;
                }
            } else {
                str = "";
            }
            String firstPostId = v.P1().O().getFirstPostId();
            if (firstPostId == null || !firstPostId.equals(str)) {
                str2 = str;
            }
            shareFromPBMsgData.setContent(M[1]);
            shareFromPBMsgData.setImageUrl(M[0]);
            shareFromPBMsgData.setForumName(v.P1().l().getName());
            shareFromPBMsgData.setPostId(str2);
            shareFromPBMsgData.setThreadId(v.P1().O().getId());
            shareFromPBMsgData.setTitle(v.P1().O().getTitle());
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, threadData)) == null) {
            String str = null;
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MediaData mediaData = medias.get(i);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i++;
            }
            return (str != null || threadData.getThreadVideoInfo() == null || TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) ? str : threadData.getThreadVideoInfo().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    public static int g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadData)) == null) {
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

    public static int h(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadData)) == null) {
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

    public static int i(kp7 kp7Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, kp7Var)) == null) {
            if (kp7Var == null || (O = kp7Var.O()) == null) {
                return 0;
            }
            if (O.isRealGod()) {
                return 4;
            }
            if (O.getIsLive() == 1) {
                return 3;
            }
            if (O.isRealVideoThread()) {
                return 2;
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
            return O.isBJHVideoDynamicThreadType() ? 8 : 1;
        }
        return invokeL.intValue;
    }

    public static void j(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, pbFragment, intent) == null) {
            m(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? a.contains(str) : invokeL.booleanValue;
    }

    public static void l(PbFragment pbFragment, long j, String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbFragment, Long.valueOf(j), str, Long.valueOf(j2)}) == null) || pbFragment == null) {
            return;
        }
        PbModel v = pbFragment.v();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (v == null || v.P1() == null || v.P1().O() == null) {
            return;
        }
        dq4 dq4Var = new dq4(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        dq4Var.setContentViewSize(1);
        dq4Var.setContentView(thread2GroupShareView);
        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f113a, new d(pbFragment, thread2GroupShareView, j, str, j2, e2));
        dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new e(pbFragment, thread2GroupShareView));
        dq4Var.setCanceledOnTouchOutside(true);
        dq4Var.create(pbFragment.getPageContext()).show();
        if (ki.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(e2.getImageUrl(), v.P1().s() == 1);
    }

    public static void m(PbFragment pbFragment, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) == null) || pbFragment == null) {
            return;
        }
        PbModel v = pbFragment.v();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (v == null || v.P1() == null || v.P1().O() == null) {
            return;
        }
        dq4 dq4Var = new dq4(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        dq4Var.setContentViewSize(1);
        dq4Var.setContentView(thread2GroupShareView);
        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f113a, new b(v, pbFragment, thread2GroupShareView, j, str, str2, str3, e2));
        dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new c(pbFragment, thread2GroupShareView));
        dq4Var.setCanceledOnTouchOutside(true);
        dq4Var.create(pbFragment.getPageContext()).show();
        if (ki.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(e2.getImageUrl(), v.P1().s() == 1);
    }

    public static void n(Context context, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, null, context, threadData, i) == null) || threadData == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, threadData), true));
    }

    public static void o(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65551, null, pbFragment, i, i2) == null) || pbFragment == null || pbFragment.v() == null || pbFragment.Z4() == null) {
            return;
        }
        PbModel v = pbFragment.v();
        ot7 Z4 = pbFragment.Z4();
        if (v.a()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d2 = d(i, i2, v);
            TbadkCoreApplication.getInst().setShareItem(d2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d2, true, true);
            shareDialogConfig.setOnDismissListener(new a(v, pbFragment, Z4));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(v.getTopicId());
            if (v.P1() != null) {
                shareDialogConfig.setShowNovelMask(v.P1().j0());
            }
            ay5.c().l(shareDialogConfig);
        }
    }
}
