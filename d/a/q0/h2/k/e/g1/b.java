package d.a.q0.h2.k.e.g1;

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
import d.a.d.e.p.k;
import d.a.p0.s.q.b2;
import d.a.p0.s.s.a;
import d.a.q0.e0.f;
import d.a.q0.h2.k.e.t0;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f57861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f57862f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ t0 f57863g;

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
            this.f57861e = pbModel;
            this.f57862f = pbFragment;
            this.f57863g = t0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f57861e) == null || pbModel.L0() == null || !this.f57861e.L0().l0() || TbSingleton.getInstance().isNotchScreen(this.f57862f.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f57862f.getBaseFragmentActivity())) {
                return;
            }
            this.f57863g.V0().setSystemUiVisibility(4);
        }
    }

    /* renamed from: d.a.q0.h2.k.e.g1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1432b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f57864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f57865f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f57866g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f57867h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f57868i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ ShareFromPBMsgData l;

        public C1432b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
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
            this.f57864e = pbModel;
            this.f57865f = pbFragment;
            this.f57866g = thread2GroupShareView;
            this.f57867h = j;
            this.f57868i = str;
            this.j = str2;
            this.k = str3;
            this.l = shareFromPBMsgData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                PbModel pbModel = this.f57864e;
                if (pbModel != null && pbModel.L0() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.f57864e.getForumId()).param("tid", this.f57864e.b1()).param("obj_locate", 1);
                    if (b.h(this.f57864e.L0()) != 0) {
                        param.param("obj_type", b.h(this.f57864e.L0()));
                    }
                    TiebaStatic.log(param);
                }
                this.f57865f.HidenSoftKeyPad((InputMethodManager) this.f57865f.getBaseFragmentActivity().getSystemService("input_method"), this.f57866g.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f57865f.getBaseFragmentActivity(), this.f57867h, this.f57868i, this.j, this.k, 0, this.f57866g.getLeaveMsg(), this.l.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f57869e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f57870f;

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
            this.f57869e = pbFragment;
            this.f57870f = thread2GroupShareView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f57869e.HidenSoftKeyPad((InputMethodManager) this.f57869e.getBaseFragmentActivity().getSystemService("input_method"), this.f57870f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f57871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f57872f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f57873g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f57874h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f57875i;
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
            this.f57871e = pbFragment;
            this.f57872f = thread2GroupShareView;
            this.f57873g = j;
            this.f57874h = str;
            this.f57875i = j2;
            this.j = shareFromPBMsgData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f57871e.HidenSoftKeyPad((InputMethodManager) this.f57871e.getBaseFragmentActivity().getSystemService("input_method"), this.f57872f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f57871e.getBaseFragmentActivity(), this.f57873g, this.f57874h, this.f57875i, "from_share", this.f57872f.getLeaveMsg(), this.j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f57876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f57877f;

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
            this.f57876e = pbFragment;
            this.f57877f = thread2GroupShareView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f57876e.HidenSoftKeyPad((InputMethodManager) this.f57876e.getBaseFragmentActivity().getSystemService("input_method"), this.f57877f.getChatMsgView());
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
            String valueOf = String.valueOf(b2Var.R());
            String X = b2Var.X();
            OriginalForumInfo originalForumInfo = b2Var.F1;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                X = originalForumInfo.ori_fname;
            }
            String title = b2Var.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = b2Var.h();
            }
            String o1 = b2Var.o1();
            String str = "http://tieba.baidu.com/p/" + o1 + "?share=9105&fr=sharewise";
            String e2 = e(b2Var);
            Uri parse = e2 == null ? null : Uri.parse(e2);
            String h2 = b2Var.h();
            String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, h2);
            ShareItem shareItem = new ShareItem();
            shareItem.r = title;
            shareItem.s = format;
            shareItem.R = b2Var.x1();
            shareItem.D = h2;
            shareItem.t = str;
            shareItem.o = 2;
            shareItem.q = o1;
            shareItem.F = 3;
            shareItem.J = valueOf;
            shareItem.p = X;
            shareItem.K = o1;
            shareItem.f12892f = true;
            shareItem.E = 6;
            shareItem.M = g(b2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(b2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(b2Var, 1, null);
            shareItem.f0 = b2Var.V0();
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
        String b1;
        String str;
        String str2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), pbModel})) == null) {
            d.a.q0.h2.h.e L0 = pbModel.L0();
            String title = L0.N().getTitle();
            boolean q0 = pbModel.q0();
            if (L0.m() != null) {
                if (L0.m().isLike() == 1) {
                    AddExperiencedModel.B(L0.n());
                }
            }
            b2 N = pbModel.L0().N();
            if (N.r2()) {
                b1 = N.J().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (q0 ? 1 : 0) + "&dtype=" + N.J().oriUgcType + "&dvid=" + N.J().oriUgcVid + "&nid=" + N.J().oriUgcNid;
            } else {
                b1 = pbModel.b1();
                str = "?share=9105&fr=sharewise&see_lz=" + (q0 ? 1 : 0);
            }
            String str3 = "http://tieba.baidu.com/p/" + b1 + (str + "&share_from=post");
            String[] L = L0.L(context);
            String str4 = L[0];
            if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str4 = str4.substring(37);
            }
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = L[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", L0.n()).param("tid", L0.P()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (L0.e0() && N.H() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                    if (TextUtils.isEmpty(title) || N.H1() || N.I1()) {
                        title = L[1];
                    }
                    str2 = MessageFormat.format(string, N.H().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    String cutString = k.cutString(title, 100);
                    String cutString2 = k.cutString(str2, 100);
                    shareItem = new ShareItem();
                    shareItem.r = cutString;
                    shareItem.s = cutString2;
                    if (!L0.e0()) {
                    }
                    shareItem.t = str3;
                    shareItem.f12889c = true;
                    shareItem.q = pbModel.b1();
                    shareItem.F = 3;
                    shareItem.E = i3;
                    shareItem.G = f(N);
                    shareItem.J = pbModel.getForumId();
                    shareItem.K = pbModel.b1();
                    shareItem.M = h(L0);
                    shareItem.N = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (L0.e0()) {
                    }
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                    if (L0 == null) {
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
                if (!L0.e0()) {
                }
                shareItem.t = str3;
                shareItem.f12889c = true;
                shareItem.q = pbModel.b1();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.G = f(N);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.b1();
                shareItem.M = h(L0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (L0.e0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                if (L0 == null) {
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
                if (!L0.e0()) {
                    shareItem.D = cutString222;
                    shareItem.R = -1L;
                } else {
                    shareItem.R = L0.O();
                }
                shareItem.t = str3;
                shareItem.f12889c = true;
                shareItem.q = pbModel.b1();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.G = f(N);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.b1();
                shareItem.M = h(L0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.v = parse;
                }
                if (L0.e0()) {
                    shareItem.g0 = false;
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                if (L0 == null && L0.E() != null && L0.E().size() > 0) {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, L0.E().get(0));
                } else {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                }
                if (N != null) {
                    shareItem.f0 = N.V0();
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
            if (!L0.e0()) {
            }
            shareItem.t = str3;
            shareItem.f12889c = true;
            shareItem.q = pbModel.b1();
            shareItem.F = 3;
            shareItem.E = i3;
            shareItem.G = f(N);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.b1();
            shareItem.M = h(L0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (L0.e0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
            if (L0 == null) {
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
            if (pbFragment == null || pbFragment.y() == null || pbFragment.V4() == null) {
                return null;
            }
            PbModel y = pbFragment.y();
            t0 V4 = pbFragment.V4();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            String[] L = y.L0().L(pbFragment.getContext());
            PostData q0 = V4.q0();
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
            String U = y.L0().N().U();
            if (U == null || !U.equals(str)) {
                str2 = str;
            }
            shareFromPBMsgData.setContent(L[1]);
            shareFromPBMsgData.setImageUrl(L[0]);
            shareFromPBMsgData.setForumName(y.L0().m().getName());
            shareFromPBMsgData.setPostId(str2);
            shareFromPBMsgData.setThreadId(y.L0().N().d0());
            shareFromPBMsgData.setTitle(y.L0().N().getTitle());
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String e(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, b2Var)) == null) {
            String str = null;
            if (b2Var == null || b2Var.A0() == null) {
                return null;
            }
            ArrayList<MediaData> A0 = b2Var.A0();
            int size = A0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = A0.get(i2);
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
            return (str != null || b2Var.m1() == null || TextUtils.isEmpty(b2Var.m1().thumbnail_url)) ? str : b2Var.m1().thumbnail_url;
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
            if (b2Var.F1()) {
                return 10;
            }
            if (b2Var.I1()) {
                return 9;
            }
            if (b2Var.H1()) {
                return 8;
            }
            if (b2Var.G1()) {
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

    public static int h(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        b2 N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, eVar)) == null) {
            if (eVar == null || (N = eVar.N()) == null) {
                return 0;
            }
            if (N.f2()) {
                return 4;
            }
            if (N.h0() == 1) {
                return 3;
            }
            if (N.g2()) {
                return 2;
            }
            if (N.F1()) {
                return 5;
            }
            if (N.I1()) {
                return 6;
            }
            if (N.G1()) {
                return 7;
            }
            return N.H1() ? 8 : 1;
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
        if (y == null || y.L0() == null || y.L0().N() == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(pbFragment.getBaseFragmentActivity());
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
        thread2GroupShareView.c(d2.getImageUrl(), y.L0().t() == 1);
    }

    public static void k(PbFragment pbFragment, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) == null) || pbFragment == null) {
            return;
        }
        PbModel y = pbFragment.y();
        ShareFromPBMsgData d2 = d(pbFragment);
        if (y == null || y.L0() == null || y.L0().N() == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(d2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new C1432b(y, pbFragment, thread2GroupShareView, j, str, str2, str3, d2));
        aVar.setNegativeButton(R.string.cancel, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(d2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(d2.getImageUrl(), y.L0().t() == 1);
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
        if (!(interceptable == null || interceptable.invokeLII(65548, null, pbFragment, i2, i3) == null) || pbFragment == null || pbFragment.y() == null || pbFragment.V4() == null) {
            return;
        }
        PbModel y = pbFragment.y();
        t0 V4 = pbFragment.V4();
        if (y.d()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem c2 = c(pbFragment.getContext(), i2, i3, y);
            TbadkCoreApplication.getInst().setShareItem(c2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), c2, true, true);
            shareDialogConfig.setOnDismissListener(new a(y, pbFragment, V4));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            f.b().k(shareDialogConfig);
        }
    }
}
