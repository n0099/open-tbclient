package d.a.n0.e2.o.q;

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
import d.a.c.e.p.k;
import d.a.m0.r.q.a2;
import d.a.n0.d0.f;
import d.a.n0.e2.h.e;
import java.text.MessageFormat;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.a.n0.e2.o.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class DialogInterface$OnDismissListenerC1288a implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f53876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbActivity f53877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f53878g;

        public DialogInterface$OnDismissListenerC1288a(PbModel pbModel, PbActivity pbActivity, View view) {
            this.f53876e = pbModel;
            this.f53877f = pbActivity;
            this.f53878g = view;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            View view;
            PbModel pbModel = this.f53876e;
            if (pbModel == null || pbModel.y0() == null || !this.f53876e.y0().f0() || TbSingleton.getInstance().isNotchScreen(this.f53877f) || TbSingleton.getInstance().isCutoutScreen(this.f53877f) || (view = this.f53878g) == null) {
                return;
            }
            view.setSystemUiVisibility(4);
        }
    }

    public static int a(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.Q1()) {
            return 10;
        }
        if (a2Var.T1()) {
            return 9;
        }
        if (a2Var.S1()) {
            return 8;
        }
        if (a2Var.R1()) {
            return 7;
        }
        if (a2Var.t1) {
            return 6;
        }
        int i2 = a2Var.Z;
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

    public static int b(e eVar) {
        a2 L;
        if (eVar == null || (L = eVar.L()) == null) {
            return 0;
        }
        if (L.q2()) {
            return 4;
        }
        if (L.s0() == 1) {
            return 3;
        }
        if (L.Q1()) {
            return 5;
        }
        if (L.T1()) {
            return 6;
        }
        if (L.R1()) {
            return 7;
        }
        if (L.S1()) {
            return 8;
        }
        return L.r2() ? 2 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(PbActivity pbActivity, int i2, int i3) {
        String O0;
        String str;
        String str2;
        ShareItem shareItem;
        if (pbActivity == null || pbActivity.getPbModel() == null) {
            return;
        }
        PbModel pbModel = pbActivity.getPbModel();
        View rootView = pbActivity.getRootView();
        if (pbModel.T0()) {
            TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            e y0 = pbModel.y0();
            String z1 = y0.L().z1();
            boolean d0 = pbModel.d0();
            if (y0.l() != null) {
                if (y0.l().isLike() == 1) {
                    AddExperiencedModel.x(y0.m());
                }
            }
            a2 L = pbModel.y0().L();
            if (L.B2()) {
                O0 = L.V().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (d0 ? 1 : 0) + "&dtype=" + L.V().oriUgcType + "&dvid=" + L.V().oriUgcVid + "&nid=" + L.V().oriUgcNid;
            } else {
                O0 = pbModel.O0();
                str = "?share=9105&fr=share&see_lz=" + (d0 ? 1 : 0);
            }
            String str3 = "http://tieba.baidu.com/p/" + O0 + (str + "&share_from=post");
            String[] J = y0.J(pbActivity);
            String str4 = J[0];
            if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str4 = str4.substring(37);
            }
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = J[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", y0.m()).param("tid", y0.N()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (y0.a0() && L.T() != null) {
                if (TextUtils.isEmpty(z1) || TextUtils.isEmpty(str5) || L.S1() || L.T1()) {
                    if (TextUtils.isEmpty(z1)) {
                        z1 = J[1];
                    }
                    str2 = MessageFormat.format(string, L.T().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    String cutString = k.cutString(z1, 100);
                    String cutString2 = k.cutString(str2, 100);
                    shareItem = new ShareItem();
                    shareItem.r = cutString;
                    shareItem.s = cutString2;
                    if (!y0.a0()) {
                    }
                    shareItem.t = str3;
                    shareItem.f12597c = true;
                    shareItem.q = pbModel.O0();
                    shareItem.F = 3;
                    shareItem.E = i3;
                    shareItem.J = pbModel.getForumId();
                    shareItem.K = pbModel.O0();
                    shareItem.M = b(y0);
                    shareItem.N = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (y0.a0()) {
                    }
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(L);
                    if (y0 == null) {
                    }
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(L, 1, null);
                    TbadkCoreApplication.getInst().setShareItem(shareItem);
                    if (L != null) {
                    }
                    shareItem.G = a(L);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.F);
                    bundle.putInt("obj_type", shareItem.M);
                    bundle.putString("fid", shareItem.J);
                    bundle.putString("tid", shareItem.K);
                    bundle.putString("uid", shareItem.N);
                    shareItem.k(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1288a(pbModel, pbActivity, rootView));
                    shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                    f.b().k(shareDialogConfig);
                }
                str2 = str5;
                String cutString3 = k.cutString(z1, 100);
                String cutString22 = k.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString3;
                shareItem.s = cutString22;
                if (!y0.a0()) {
                }
                shareItem.t = str3;
                shareItem.f12597c = true;
                shareItem.q = pbModel.O0();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.O0();
                shareItem.M = b(y0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (y0.a0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(L);
                if (y0 == null) {
                }
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(L, 1, null);
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (L != null) {
                }
                shareItem.G = a(L);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("obj_param1", shareItem.F);
                bundle2.putInt("obj_type", shareItem.M);
                bundle2.putString("fid", shareItem.J);
                bundle2.putString("tid", shareItem.K);
                bundle2.putString("uid", shareItem.N);
                shareItem.k(bundle2);
                ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig2.setOnDismissListener(new DialogInterface$OnDismissListenerC1288a(pbModel, pbActivity, rootView));
                shareDialogConfig2.setFrom(ShareDialogConfig.From.PB);
                f.b().k(shareDialogConfig2);
            }
            if (k.isEmpty(str5)) {
                str2 = z1;
                String cutString32 = k.cutString(z1, 100);
                String cutString222 = k.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString32;
                shareItem.s = cutString222;
                if (!y0.a0()) {
                    shareItem.D = cutString222;
                    shareItem.R = -1L;
                } else if (y0.L() != null && y0.L().w1() != null && !y0.L().B2()) {
                    shareItem.R = y0.L().w1().play_count.intValue();
                }
                shareItem.t = str3;
                shareItem.f12597c = true;
                shareItem.q = pbModel.O0();
                shareItem.F = 3;
                shareItem.E = i3;
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.O0();
                shareItem.M = b(y0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.v = parse;
                }
                if (y0.a0()) {
                    shareItem.f0 = false;
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(L);
                if (y0 == null && y0.D() != null && y0.D().size() > 0) {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(L, 1, y0.D().get(0));
                } else {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(L, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (L != null) {
                    shareItem.e0 = L.f1();
                }
                shareItem.G = a(L);
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.F);
                bundle22.putInt("obj_type", shareItem.M);
                bundle22.putString("fid", shareItem.J);
                bundle22.putString("tid", shareItem.K);
                bundle22.putString("uid", shareItem.N);
                shareItem.k(bundle22);
                ShareDialogConfig shareDialogConfig22 = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig22.setOnDismissListener(new DialogInterface$OnDismissListenerC1288a(pbModel, pbActivity, rootView));
                shareDialogConfig22.setFrom(ShareDialogConfig.From.PB);
                f.b().k(shareDialogConfig22);
            }
            str2 = str5;
            String cutString322 = k.cutString(z1, 100);
            String cutString2222 = k.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString322;
            shareItem.s = cutString2222;
            if (!y0.a0()) {
            }
            shareItem.t = str3;
            shareItem.f12597c = true;
            shareItem.q = pbModel.O0();
            shareItem.F = 3;
            shareItem.E = i3;
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.O0();
            shareItem.M = b(y0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (y0.a0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(L);
            if (y0 == null) {
            }
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(L, 1, null);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (L != null) {
            }
            shareItem.G = a(L);
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.F);
            bundle222.putInt("obj_type", shareItem.M);
            bundle222.putString("fid", shareItem.J);
            bundle222.putString("tid", shareItem.K);
            bundle222.putString("uid", shareItem.N);
            shareItem.k(bundle222);
            ShareDialogConfig shareDialogConfig222 = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
            shareDialogConfig222.setOnDismissListener(new DialogInterface$OnDismissListenerC1288a(pbModel, pbActivity, rootView));
            shareDialogConfig222.setFrom(ShareDialogConfig.From.PB);
            f.b().k(shareDialogConfig222);
        }
    }
}
