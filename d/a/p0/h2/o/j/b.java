package d.a.p0.h2.o.j;

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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.o0.r.q.b2;
import d.a.p0.e0.f;
import d.a.p0.h2.h.e;
import java.text.MessageFormat;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f57851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbActivity f57852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f57853g;

        public a(PbModel pbModel, PbActivity pbActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57851e = pbModel;
            this.f57852f = pbActivity;
            this.f57853g = view;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f57851e) == null || pbModel.D0() == null || !this.f57851e.D0().l0() || TbSingleton.getInstance().isNotchScreen(this.f57852f) || TbSingleton.getInstance().isCutoutScreen(this.f57852f) || (view = this.f57853g) == null) {
                return;
            }
            view.setSystemUiVisibility(4);
        }
    }

    public static int a(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, b2Var)) == null) {
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

    public static int b(e eVar) {
        InterceptResult invokeL;
        b2 N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eVar)) == null) {
            if (eVar == null || (N = eVar.N()) == null) {
                return 0;
            }
            if (N.e2()) {
                return 4;
            }
            if (N.g0() == 1) {
                return 3;
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
            if (N.G1()) {
                return 8;
            }
            return N.f2() ? 2 : 1;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0257  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(PbActivity pbActivity, int i2, int i3) {
        String T0;
        String str;
        String str2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65538, null, pbActivity, i2, i3) == null) || pbActivity == null || pbActivity.getPbModel() == null) {
            return;
        }
        PbModel pbModel = pbActivity.getPbModel();
        View rootView = pbActivity.getRootView();
        if (pbModel.d()) {
            TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            e D0 = pbModel.D0();
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
            String[] L = D0.L(pbActivity);
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
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || N.G1() || N.H1()) {
                    if (TextUtils.isEmpty(title)) {
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
                    shareItem.f12840c = true;
                    shareItem.q = pbModel.T0();
                    shareItem.F = 3;
                    shareItem.E = i3;
                    shareItem.J = pbModel.getForumId();
                    shareItem.K = pbModel.T0();
                    shareItem.M = b(D0);
                    shareItem.N = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (D0.e0()) {
                    }
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                    if (D0 == null) {
                    }
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                    TbadkCoreApplication.getInst().setShareItem(shareItem);
                    if (N != null) {
                    }
                    shareItem.G = a(N);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.F);
                    bundle.putInt("obj_type", shareItem.M);
                    bundle.putString("fid", shareItem.J);
                    bundle.putString("tid", shareItem.K);
                    bundle.putString("uid", shareItem.N);
                    shareItem.k(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                    shareDialogConfig.setOnDismissListener(new a(pbModel, pbActivity, rootView));
                    shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                    f.b().k(shareDialogConfig);
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
                shareItem.f12840c = true;
                shareItem.q = pbModel.T0();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.T0();
                shareItem.M = b(D0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (D0.e0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                if (D0 == null) {
                }
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (N != null) {
                }
                shareItem.G = a(N);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("obj_param1", shareItem.F);
                bundle2.putInt("obj_type", shareItem.M);
                bundle2.putString("fid", shareItem.J);
                bundle2.putString("tid", shareItem.K);
                bundle2.putString("uid", shareItem.N);
                shareItem.k(bundle2);
                ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig2.setOnDismissListener(new a(pbModel, pbActivity, rootView));
                shareDialogConfig2.setFrom(ShareDialogConfig.From.PB);
                f.b().k(shareDialogConfig2);
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
                } else if (D0.N() != null && D0.N().l1() != null && !D0.N().p2()) {
                    shareItem.R = D0.N().l1().play_count.intValue();
                }
                shareItem.t = str3;
                shareItem.f12840c = true;
                shareItem.q = pbModel.T0();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.T0();
                shareItem.M = b(D0);
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
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (N != null) {
                    shareItem.e0 = N.U0();
                }
                shareItem.G = a(N);
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.F);
                bundle22.putInt("obj_type", shareItem.M);
                bundle22.putString("fid", shareItem.J);
                bundle22.putString("tid", shareItem.K);
                bundle22.putString("uid", shareItem.N);
                shareItem.k(bundle22);
                ShareDialogConfig shareDialogConfig22 = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig22.setOnDismissListener(new a(pbModel, pbActivity, rootView));
                shareDialogConfig22.setFrom(ShareDialogConfig.From.PB);
                f.b().k(shareDialogConfig22);
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
            shareItem.f12840c = true;
            shareItem.q = pbModel.T0();
            shareItem.F = 3;
            shareItem.E = i3;
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.T0();
            shareItem.M = b(D0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (D0.e0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
            if (D0 == null) {
            }
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (N != null) {
            }
            shareItem.G = a(N);
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.F);
            bundle222.putInt("obj_type", shareItem.M);
            bundle222.putString("fid", shareItem.J);
            bundle222.putString("tid", shareItem.K);
            bundle222.putString("uid", shareItem.N);
            shareItem.k(bundle222);
            ShareDialogConfig shareDialogConfig222 = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
            shareDialogConfig222.setOnDismissListener(new a(pbModel, pbActivity, rootView));
            shareDialogConfig222.setFrom(ShareDialogConfig.From.PB);
            f.b().k(shareDialogConfig222);
        }
    }
}
