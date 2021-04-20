package d.b.i0.d2.k.e.d1;

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
import d.b.c.e.p.k;
import d.b.h0.r.q.a2;
import d.b.h0.r.s.a;
import d.b.i0.b0.f;
import d.b.i0.d2.k.e.s0;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f54096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f54097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f54098g;

        public a(PbModel pbModel, PbFragment pbFragment, s0 s0Var) {
            this.f54096e = pbModel;
            this.f54097f = pbFragment;
            this.f54098g = s0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel = this.f54096e;
            if (pbModel == null || pbModel.y0() == null || !this.f54096e.y0().f0() || TbSingleton.getInstance().isNotchScreen(this.f54097f.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f54097f.getBaseFragmentActivity())) {
                return;
            }
            this.f54098g.T0().setSystemUiVisibility(4);
        }
    }

    /* renamed from: d.b.i0.d2.k.e.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1214b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f54099e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f54100f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f54101g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f54102h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ ShareFromPBMsgData l;

        public C1214b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            this.f54099e = pbModel;
            this.f54100f = pbFragment;
            this.f54101g = thread2GroupShareView;
            this.f54102h = j;
            this.i = str;
            this.j = str2;
            this.k = str3;
            this.l = shareFromPBMsgData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            PbModel pbModel = this.f54099e;
            if (pbModel != null && pbModel.y0() != null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.f54099e.getForumId()).param("tid", this.f54099e.O0()).param("obj_locate", 1);
                if (b.h(this.f54099e.y0()) != 0) {
                    param.param("obj_type", b.h(this.f54099e.y0()));
                }
                TiebaStatic.log(param);
            }
            this.f54100f.HidenSoftKeyPad((InputMethodManager) this.f54100f.getBaseFragmentActivity().getSystemService("input_method"), this.f54101g.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f54100f.getBaseFragmentActivity(), this.f54102h, this.i, this.j, this.k, 0, this.f54101g.getLeaveMsg(), this.l.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f54103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f54104f;

        public c(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            this.f54103e = pbFragment;
            this.f54104f = thread2GroupShareView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f54103e.HidenSoftKeyPad((InputMethodManager) this.f54103e.getBaseFragmentActivity().getSystemService("input_method"), this.f54104f.getChatMsgView());
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f54105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f54106f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f54107g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f54108h;
        public final /* synthetic */ long i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public d(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, long j2, ShareFromPBMsgData shareFromPBMsgData) {
            this.f54105e = pbFragment;
            this.f54106f = thread2GroupShareView;
            this.f54107g = j;
            this.f54108h = str;
            this.i = j2;
            this.j = shareFromPBMsgData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f54105e.HidenSoftKeyPad((InputMethodManager) this.f54105e.getBaseFragmentActivity().getSystemService("input_method"), this.f54106f.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f54105e.getBaseFragmentActivity(), this.f54107g, this.f54108h, this.i, "from_share", this.f54106f.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f54109e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f54110f;

        public e(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            this.f54109e = pbFragment;
            this.f54110f = thread2GroupShareView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f54109e.HidenSoftKeyPad((InputMethodManager) this.f54109e.getBaseFragmentActivity().getSystemService("input_method"), this.f54110f.getChatMsgView());
            aVar.dismiss();
        }
    }

    public static ShareItem b(Context context, a2 a2Var) {
        if (a2Var == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = a2Var.i0();
        OriginalForumInfo originalForumInfo = a2Var.C1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            i0 = originalForumInfo.ori_fname;
        }
        String x1 = a2Var.x1();
        if (TextUtils.isEmpty(x1)) {
            x1 = a2Var.C();
        }
        String w1 = a2Var.w1();
        String str = "http://tieba.baidu.com/p/" + w1 + "?share=9105&fr=share";
        String e2 = e(a2Var);
        Uri parse = e2 == null ? null : Uri.parse(e2);
        String C = a2Var.C();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), x1, C);
        ShareItem shareItem = new ShareItem();
        shareItem.r = x1;
        shareItem.s = format;
        shareItem.Q = a2Var.G1();
        shareItem.C = C;
        shareItem.t = str;
        shareItem.o = 2;
        shareItem.q = w1;
        shareItem.E = 3;
        shareItem.I = valueOf;
        shareItem.p = i0;
        shareItem.J = w1;
        shareItem.f13378f = true;
        shareItem.D = 6;
        shareItem.L = g(a2Var);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.S = OriginalThreadInfo.ShareInfo.generateShareInfo(a2Var);
        shareItem.T = ShareItem.ForwardInfo.generateForwardInfo(a2Var, 1, null);
        shareItem.c0 = a2Var.e1();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.E);
        bundle.putInt("obj_type", shareItem.L);
        bundle.putString("fid", shareItem.I);
        bundle.putString("tid", shareItem.J);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.i(bundle);
        return shareItem;
    }

    public static ShareItem c(Context context, int i, int i2, PbModel pbModel) {
        String O0;
        String str;
        String str2;
        d.b.i0.d2.h.e y0 = pbModel.y0();
        String x1 = y0.L().x1();
        boolean d0 = pbModel.d0();
        if (y0.l() != null) {
            if (y0.l().isLike() == 1) {
                AddExperiencedModel.x(y0.m());
            }
        }
        a2 L = pbModel.y0().L();
        if (L.y2()) {
            O0 = L.V().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + (d0 ? 1 : 0) + "&dtype=" + L.V().oriUgcType + "&dvid=" + L.V().oriUgcVid + "&nid=" + L.V().oriUgcNid;
        } else {
            O0 = pbModel.O0();
            str = "?share=9105&fr=share&see_lz=" + (d0 ? 1 : 0);
        }
        String str3 = "http://tieba.baidu.com/p/" + O0 + (str + "&share_from=post");
        String[] J = y0.J(context);
        String str4 = J[0];
        if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str4 = str4.substring(37);
        }
        Uri parse = str4 == null ? null : Uri.parse(str4);
        String str5 = J[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new StatisticItem("c10399").param("fid", y0.m()).param("tid", y0.N()).param("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (y0.a0() && L.T() != null) {
            if (TextUtils.isEmpty(x1) || TextUtils.isEmpty(str5)) {
                if (TextUtils.isEmpty(x1) || L.Q1() || L.R1()) {
                    x1 = J[1];
                }
                str2 = MessageFormat.format(string, L.T().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
            }
            str2 = str5;
        } else {
            if (k.isEmpty(str5)) {
                str2 = x1;
            }
            str2 = str5;
        }
        String cutString = k.cutString(x1, 100);
        String cutString2 = k.cutString(str2, 100);
        ShareItem shareItem = new ShareItem();
        shareItem.r = cutString;
        shareItem.s = cutString2;
        if (y0.a0()) {
            shareItem.C = cutString2;
            shareItem.Q = -1L;
        } else {
            shareItem.Q = y0.M();
        }
        shareItem.t = str3;
        shareItem.f13375c = true;
        shareItem.q = pbModel.O0();
        shareItem.E = 3;
        shareItem.D = i2;
        shareItem.F = f(L);
        shareItem.I = pbModel.getForumId();
        shareItem.J = pbModel.O0();
        shareItem.L = h(y0);
        shareItem.M = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.v = parse;
        }
        if (y0.a0()) {
            shareItem.d0 = false;
        }
        shareItem.S = OriginalThreadInfo.ShareInfo.generateShareInfo(L);
        if (y0 != null && y0.D() != null && y0.D().size() > 0) {
            shareItem.T = ShareItem.ForwardInfo.generateForwardInfo(L, 1, y0.D().get(0));
        } else {
            shareItem.T = ShareItem.ForwardInfo.generateForwardInfo(L, 1, null);
        }
        if (L != null) {
            shareItem.c0 = L.e1();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.E);
        bundle.putInt("obj_type", shareItem.L);
        bundle.putString("fid", shareItem.I);
        bundle.putString("tid", shareItem.J);
        bundle.putString("uid", shareItem.M);
        shareItem.i(bundle);
        return shareItem;
    }

    public static ShareFromPBMsgData d(PbFragment pbFragment) {
        String str;
        if (pbFragment == null || pbFragment.L() == null || pbFragment.J4() == null) {
            return null;
        }
        PbModel L = pbFragment.L();
        s0 J4 = pbFragment.J4();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] J = L.y0().J(pbFragment.getContext());
        PostData p0 = J4.p0();
        String str2 = "";
        if (p0 != null) {
            str = p0.E();
            String p = p0.p(pbFragment.getContext());
            if (!k.isEmpty(p)) {
                J[1] = p;
            }
        } else {
            str = "";
        }
        String f0 = L.y0().L().f0();
        if (f0 == null || !f0.equals(str)) {
            str2 = str;
        }
        shareFromPBMsgData.setContent(J[1]);
        shareFromPBMsgData.setImageUrl(J[0]);
        shareFromPBMsgData.setForumName(L.y0().l().getName());
        shareFromPBMsgData.setPostId(str2);
        shareFromPBMsgData.setThreadId(L.y0().L().o0());
        shareFromPBMsgData.setTitle(L.y0().L().x1());
        return shareFromPBMsgData;
    }

    public static String e(a2 a2Var) {
        String str = null;
        if (a2Var == null || a2Var.K0() == null) {
            return null;
        }
        ArrayList<MediaData> K0 = a2Var.K0();
        int size = K0.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MediaData mediaData = K0.get(i);
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
        return (str != null || a2Var.u1() == null || TextUtils.isEmpty(a2Var.u1().thumbnail_url)) ? str : a2Var.u1().thumbnail_url;
    }

    public static int f(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.O1()) {
            return 10;
        }
        if (a2Var.R1()) {
            return 9;
        }
        if (a2Var.Q1()) {
            return 8;
        }
        if (a2Var.P1()) {
            return 7;
        }
        if (a2Var.s1) {
            return 6;
        }
        int i = a2Var.Z;
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

    public static int g(a2 a2Var) {
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

    public static int h(d.b.i0.d2.h.e eVar) {
        a2 L;
        if (eVar == null || (L = eVar.L()) == null) {
            return 0;
        }
        if (L.o2()) {
            return 4;
        }
        if (L.s0() == 1) {
            return 3;
        }
        if (L.p2()) {
            return 2;
        }
        if (L.O1()) {
            return 5;
        }
        if (L.R1()) {
            return 6;
        }
        if (L.P1()) {
            return 7;
        }
        return L.Q1() ? 8 : 1;
    }

    public static void i(PbFragment pbFragment, Intent intent) {
        k(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void j(PbFragment pbFragment, long j, String str, long j2) {
        if (pbFragment == null) {
            return;
        }
        PbModel L = pbFragment.L();
        ShareFromPBMsgData d2 = d(pbFragment);
        if (L == null || L.y0() == null || L.y0().L() == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(pbFragment.getBaseFragmentActivity());
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
        thread2GroupShareView.c(d2.getImageUrl(), L.y0().s() == 1);
    }

    public static void k(PbFragment pbFragment, long j, String str, String str2, String str3) {
        if (pbFragment == null) {
            return;
        }
        PbModel L = pbFragment.L();
        ShareFromPBMsgData d2 = d(pbFragment);
        if (L == null || L.y0() == null || L.y0().L() == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(d2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new C1214b(L, pbFragment, thread2GroupShareView, j, str, str2, str3, d2));
        aVar.setNegativeButton(R.string.cancel, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(d2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(d2.getImageUrl(), L.y0().s() == 1);
    }

    public static void l(Context context, a2 a2Var, int i) {
        if (a2Var == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, b(context, a2Var), true));
    }

    public static void m(PbFragment pbFragment, int i, int i2) {
        if (pbFragment == null || pbFragment.L() == null || pbFragment.J4() == null) {
            return;
        }
        PbModel L = pbFragment.L();
        s0 J4 = pbFragment.J4();
        if (L.T0()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem c2 = c(pbFragment.getContext(), i, i2, L);
            TbadkCoreApplication.getInst().setShareItem(c2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), c2, true, true);
            shareDialogConfig.setOnDismissListener(new a(L, pbFragment, J4));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            shareDialogConfig.shareItem.i(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            f.b().k(shareDialogConfig);
        }
    }
}
