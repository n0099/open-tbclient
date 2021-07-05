package d.a.s0.h2.k.e.f1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.r0.r.q.b2;
import d.a.r0.r.s.a;
import d.a.s0.e0.f;
import d.a.s0.h2.k.e.t0;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f60513e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f60514f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ t0 f60515g;

        public a(PbModel pbModel, PbFragment pbFragment, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60513e = pbModel;
            this.f60514f = pbFragment;
            this.f60515g = t0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f60513e) == null || pbModel.D0() == null || !this.f60513e.D0().l0() || TbSingleton.getInstance().isNotchScreen(this.f60514f.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f60514f.getBaseFragmentActivity())) {
                return;
            }
            this.f60515g.V0().setSystemUiVisibility(4);
        }
    }

    /* renamed from: d.a.s0.h2.k.e.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1466b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f60516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f60517f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f60518g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f60519h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f60520i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ ShareFromPBMsgData l;

        public C1466b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60516e = pbModel;
            this.f60517f = pbFragment;
            this.f60518g = thread2GroupShareView;
            this.f60519h = j;
            this.f60520i = str;
            this.j = str2;
            this.k = str3;
            this.l = shareFromPBMsgData;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                PbModel pbModel = this.f60516e;
                if (pbModel != null && pbModel.D0() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.f60516e.getForumId()).param("tid", this.f60516e.T0()).param("obj_locate", 1);
                    if (b.h(this.f60516e.D0()) != 0) {
                        param.param("obj_type", b.h(this.f60516e.D0()));
                    }
                    TiebaStatic.log(param);
                }
                this.f60517f.HidenSoftKeyPad((InputMethodManager) this.f60517f.getBaseFragmentActivity().getSystemService("input_method"), this.f60518g.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f60517f.getBaseFragmentActivity(), this.f60519h, this.f60520i, this.j, this.k, 0, this.f60518g.getLeaveMsg(), this.l.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f60521e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f60522f;

        public c(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60521e = pbFragment;
            this.f60522f = thread2GroupShareView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f60521e.HidenSoftKeyPad((InputMethodManager) this.f60521e.getBaseFragmentActivity().getSystemService("input_method"), this.f60522f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f60523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f60524f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f60525g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f60526h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f60527i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public d(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, long j2, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView, Long.valueOf(j), str, Long.valueOf(j2), shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60523e = pbFragment;
            this.f60524f = thread2GroupShareView;
            this.f60525g = j;
            this.f60526h = str;
            this.f60527i = j2;
            this.j = shareFromPBMsgData;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f60523e.HidenSoftKeyPad((InputMethodManager) this.f60523e.getBaseFragmentActivity().getSystemService("input_method"), this.f60524f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f60523e.getBaseFragmentActivity(), this.f60525g, this.f60526h, this.f60527i, "from_share", this.f60524f.getLeaveMsg(), this.j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f60528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f60529f;

        public e(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60528e = pbFragment;
            this.f60529f = thread2GroupShareView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f60528e.HidenSoftKeyPad((InputMethodManager) this.f60528e.getBaseFragmentActivity().getSystemService("input_method"), this.f60529f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    public static ShareItem b(Context context, b2 b2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, b2Var)) == null) {
            if (b2Var == null || context == null) {
                return null;
            }
            String valueOf = String.valueOf(b2Var.Q());
            String W = b2Var.W();
            OriginalForumInfo originalForumInfo = b2Var.F1;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                W = originalForumInfo.ori_fname;
            }
            String title = b2Var.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = b2Var.h();
            }
            String n1 = b2Var.n1();
            String str = "http://tieba.baidu.com/p/" + n1 + "?share=9105&fr=share";
            String e2 = e(b2Var);
            Uri parse = e2 == null ? null : Uri.parse(e2);
            String h2 = b2Var.h();
            String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, h2);
            ShareItem shareItem = new ShareItem();
            shareItem.r = title;
            shareItem.s = format;
            shareItem.R = b2Var.w1();
            shareItem.D = h2;
            shareItem.t = str;
            shareItem.o = 2;
            shareItem.q = n1;
            shareItem.F = 3;
            shareItem.J = valueOf;
            shareItem.p = W;
            shareItem.K = n1;
            shareItem.f12826f = true;
            shareItem.E = 6;
            shareItem.M = g(b2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(b2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(b2Var, 1, null);
            shareItem.e0 = b2Var.U0();
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem c(Context context, int i2, int i3, PbModel pbModel) {
        InterceptResult invokeCommon;
        String T0;
        String str;
        String str2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), pbModel})) == null) {
            d.a.s0.h2.h.e D0 = pbModel.D0();
            String title = D0.N().getTitle();
            boolean i0 = pbModel.i0();
            if (D0.m() != null) {
                if (D0.m().isLike() == 1) {
                    AddExperiencedModel.B(D0.n());
                }
            }
            b2 N = pbModel.D0().N();
            if (N.p2()) {
                T0 = N.J().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (i0 ? 1 : 0) + "&dtype=" + N.J().oriUgcType + "&dvid=" + N.J().oriUgcVid + "&nid=" + N.J().oriUgcNid;
            } else {
                T0 = pbModel.T0();
                str = "?share=9105&fr=share&see_lz=" + (i0 ? 1 : 0);
            }
            String str3 = "http://tieba.baidu.com/p/" + T0 + (str + "&share_from=post");
            String[] L = D0.L(context);
            String str4 = L[0];
            if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str4 = str4.substring(37);
            }
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = L[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", D0.n()).param("tid", D0.P()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (D0.e0() && N.H() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                    if (TextUtils.isEmpty(title) || N.G1() || N.H1()) {
                        title = L[1];
                    }
                    str2 = MessageFormat.format(string, N.H().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    String cutString = k.cutString(title, 100);
                    String cutString2 = k.cutString(str2, 100);
                    shareItem = new ShareItem();
                    shareItem.r = cutString;
                    shareItem.s = cutString2;
                    if (!D0.e0()) {
                    }
                    shareItem.t = str3;
                    shareItem.f12823c = true;
                    shareItem.q = pbModel.T0();
                    shareItem.F = 3;
                    shareItem.E = i3;
                    shareItem.G = f(N);
                    shareItem.J = pbModel.getForumId();
                    shareItem.K = pbModel.T0();
                    shareItem.M = h(D0);
                    shareItem.N = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (D0.e0()) {
                    }
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                    if (D0 == null) {
                    }
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                    if (N != null) {
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.F);
                    bundle.putInt("obj_type", shareItem.M);
                    bundle.putString("fid", shareItem.J);
                    bundle.putString("tid", shareItem.K);
                    bundle.putString("uid", shareItem.N);
                    shareItem.k(bundle);
                    return shareItem;
                }
                str2 = str5;
                String cutString3 = k.cutString(title, 100);
                String cutString22 = k.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString3;
                shareItem.s = cutString22;
                if (!D0.e0()) {
                }
                shareItem.t = str3;
                shareItem.f12823c = true;
                shareItem.q = pbModel.T0();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.G = f(N);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.T0();
                shareItem.M = h(D0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (D0.e0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                if (D0 == null) {
                }
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                if (N != null) {
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("obj_param1", shareItem.F);
                bundle2.putInt("obj_type", shareItem.M);
                bundle2.putString("fid", shareItem.J);
                bundle2.putString("tid", shareItem.K);
                bundle2.putString("uid", shareItem.N);
                shareItem.k(bundle2);
                return shareItem;
            }
            if (k.isEmpty(str5)) {
                str2 = title;
                String cutString32 = k.cutString(title, 100);
                String cutString222 = k.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString32;
                shareItem.s = cutString222;
                if (!D0.e0()) {
                    shareItem.D = cutString222;
                    shareItem.R = -1L;
                } else {
                    shareItem.R = D0.O();
                }
                shareItem.t = str3;
                shareItem.f12823c = true;
                shareItem.q = pbModel.T0();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.G = f(N);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.T0();
                shareItem.M = h(D0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.v = parse;
                }
                if (D0.e0()) {
                    shareItem.f0 = false;
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                if (D0 == null && D0.E() != null && D0.E().size() > 0) {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, D0.E().get(0));
                } else {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                }
                if (N != null) {
                    shareItem.e0 = N.U0();
                }
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.F);
                bundle22.putInt("obj_type", shareItem.M);
                bundle22.putString("fid", shareItem.J);
                bundle22.putString("tid", shareItem.K);
                bundle22.putString("uid", shareItem.N);
                shareItem.k(bundle22);
                return shareItem;
            }
            str2 = str5;
            String cutString322 = k.cutString(title, 100);
            String cutString2222 = k.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString322;
            shareItem.s = cutString2222;
            if (!D0.e0()) {
            }
            shareItem.t = str3;
            shareItem.f12823c = true;
            shareItem.q = pbModel.T0();
            shareItem.F = 3;
            shareItem.E = i3;
            shareItem.G = f(N);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.T0();
            shareItem.M = h(D0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (D0.e0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
            if (D0 == null) {
            }
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
            if (N != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.F);
            bundle222.putInt("obj_type", shareItem.M);
            bundle222.putString("fid", shareItem.J);
            bundle222.putString("tid", shareItem.K);
            bundle222.putString("uid", shareItem.N);
            shareItem.k(bundle222);
            return shareItem;
        }
        return (ShareItem) invokeCommon.objValue;
    }

    public static ShareFromPBMsgData d(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.y() == null || pbFragment.P4() == null) {
                return null;
            }
            PbModel y = pbFragment.y();
            t0 P4 = pbFragment.P4();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            String[] L = y.D0().L(pbFragment.getContext());
            PostData q0 = P4.q0();
            String str2 = "";
            if (q0 != null) {
                str = q0.E();
                String o = q0.o(pbFragment.getContext());
                if (!k.isEmpty(o)) {
                    L[1] = o;
                }
            } else {
                str = "";
            }
            String T = y.D0().N().T();
            if (T == null || !T.equals(str)) {
                str2 = str;
            }
            shareFromPBMsgData.setContent(L[1]);
            shareFromPBMsgData.setImageUrl(L[0]);
            shareFromPBMsgData.setForumName(y.D0().m().getName());
            shareFromPBMsgData.setPostId(str2);
            shareFromPBMsgData.setThreadId(y.D0().N().c0());
            shareFromPBMsgData.setTitle(y.D0().N().getTitle());
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String e(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, b2Var)) == null) {
            String str = null;
            if (b2Var == null || b2Var.z0() == null) {
                return null;
            }
            ArrayList<MediaData> z0 = b2Var.z0();
            int size = z0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = z0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i2++;
            }
            return (str != null || b2Var.l1() == null || TextUtils.isEmpty(b2Var.l1().thumbnail_url)) ? str : b2Var.l1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    public static int f(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, b2Var)) == null) {
            if (b2Var == null) {
                return 0;
            }
            if (b2Var.E1()) {
                return 10;
            }
            if (b2Var.H1()) {
                return 9;
            }
            if (b2Var.G1()) {
                return 8;
            }
            if (b2Var.F1()) {
                return 7;
            }
            if (b2Var.v1) {
                return 6;
            }
            int i2 = b2Var.Z;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 40) {
                return 2;
            }
            if (i2 == 49) {
                return 3;
            }
            return i2 == 54 ? 4 : 5;
        }
        return invokeL.intValue;
    }

    public static int g(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, b2Var)) == null) {
            if (b2Var != null) {
                if (b2Var.e2()) {
                    return 4;
                }
                if (b2Var.g0() == 1) {
                    return 3;
                }
                return b2Var.f2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int h(d.a.s0.h2.h.e eVar) {
        InterceptResult invokeL;
        b2 N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, eVar)) == null) {
            if (eVar == null || (N = eVar.N()) == null) {
                return 0;
            }
            if (N.e2()) {
                return 4;
            }
            if (N.g0() == 1) {
                return 3;
            }
            if (N.f2()) {
                return 2;
            }
            if (N.E1()) {
                return 5;
            }
            if (N.H1()) {
                return 6;
            }
            if (N.F1()) {
                return 7;
            }
            return N.G1() ? 8 : 1;
        }
        return invokeL.intValue;
    }

    public static void i(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, pbFragment, intent) == null) {
            k(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static void j(PbFragment pbFragment, long j, String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{pbFragment, Long.valueOf(j), str, Long.valueOf(j2)}) == null) || pbFragment == null) {
            return;
        }
        PbModel y = pbFragment.y();
        ShareFromPBMsgData d2 = d(pbFragment);
        if (y == null || y.D0() == null || y.D0().N() == null) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(d2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new d(pbFragment, thread2GroupShareView, j, str, j2, d2));
        aVar.setNegativeButton(R.string.cancel, new e(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(d2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(d2.getImageUrl(), y.D0().t() == 1);
    }

    public static void k(PbFragment pbFragment, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) == null) || pbFragment == null) {
            return;
        }
        PbModel y = pbFragment.y();
        ShareFromPBMsgData d2 = d(pbFragment);
        if (y == null || y.D0() == null || y.D0().N() == null) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(d2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new C1466b(y, pbFragment, thread2GroupShareView, j, str, str2, str3, d2));
        aVar.setNegativeButton(R.string.cancel, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(d2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(d2.getImageUrl(), y.D0().t() == 1);
    }

    public static void l(Context context, b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65547, null, context, b2Var, i2) == null) || b2Var == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i2, b(context, b2Var), true));
    }

    public static void m(PbFragment pbFragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65548, null, pbFragment, i2, i3) == null) || pbFragment == null || pbFragment.y() == null || pbFragment.P4() == null) {
            return;
        }
        PbModel y = pbFragment.y();
        t0 P4 = pbFragment.P4();
        if (y.d()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem c2 = c(pbFragment.getContext(), i2, i3, y);
            TbadkCoreApplication.getInst().setShareItem(c2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), c2, true, true);
            shareDialogConfig.setOnDismissListener(new a(y, pbFragment, P4));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            f.b().k(shareDialogConfig);
        }
    }
}
