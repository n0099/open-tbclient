package d.a.j0.d2.k.e.d1;

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
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
import d.a.i0.r.s.a;
import d.a.j0.b0.f;
import d.a.j0.d2.k.e.s0;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f52318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52319f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f52320g;

        public a(PbModel pbModel, PbFragment pbFragment, s0 s0Var) {
            this.f52318e = pbModel;
            this.f52319f = pbFragment;
            this.f52320g = s0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel = this.f52318e;
            if (pbModel == null || pbModel.y0() == null || !this.f52318e.y0().f0() || TbSingleton.getInstance().isNotchScreen(this.f52319f.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f52319f.getBaseFragmentActivity())) {
                return;
            }
            this.f52320g.T0().setSystemUiVisibility(4);
        }
    }

    /* renamed from: d.a.j0.d2.k.e.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1176b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f52321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52322f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f52323g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f52324h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f52325i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ ShareFromPBMsgData l;

        public C1176b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            this.f52321e = pbModel;
            this.f52322f = pbFragment;
            this.f52323g = thread2GroupShareView;
            this.f52324h = j;
            this.f52325i = str;
            this.j = str2;
            this.k = str3;
            this.l = shareFromPBMsgData;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            PbModel pbModel = this.f52321e;
            if (pbModel != null && pbModel.y0() != null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.f52321e.getForumId()).param("tid", this.f52321e.O0()).param("obj_locate", 1);
                if (b.h(this.f52321e.y0()) != 0) {
                    param.param("obj_type", b.h(this.f52321e.y0()));
                }
                TiebaStatic.log(param);
            }
            this.f52322f.HidenSoftKeyPad((InputMethodManager) this.f52322f.getBaseFragmentActivity().getSystemService("input_method"), this.f52323g.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f52322f.getBaseFragmentActivity(), this.f52324h, this.f52325i, this.j, this.k, 0, this.f52323g.getLeaveMsg(), this.l.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f52327f;

        public c(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            this.f52326e = pbFragment;
            this.f52327f = thread2GroupShareView;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f52326e.HidenSoftKeyPad((InputMethodManager) this.f52326e.getBaseFragmentActivity().getSystemService("input_method"), this.f52327f.getChatMsgView());
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f52329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f52330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f52331h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f52332i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public d(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, long j2, ShareFromPBMsgData shareFromPBMsgData) {
            this.f52328e = pbFragment;
            this.f52329f = thread2GroupShareView;
            this.f52330g = j;
            this.f52331h = str;
            this.f52332i = j2;
            this.j = shareFromPBMsgData;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f52328e.HidenSoftKeyPad((InputMethodManager) this.f52328e.getBaseFragmentActivity().getSystemService("input_method"), this.f52329f.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f52328e.getBaseFragmentActivity(), this.f52330g, this.f52331h, this.f52332i, "from_share", this.f52329f.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f52334f;

        public e(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            this.f52333e = pbFragment;
            this.f52334f = thread2GroupShareView;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f52333e.HidenSoftKeyPad((InputMethodManager) this.f52333e.getBaseFragmentActivity().getSystemService("input_method"), this.f52334f.getChatMsgView());
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
        shareItem.R = a2Var.G1();
        shareItem.D = C;
        shareItem.t = str;
        shareItem.o = 2;
        shareItem.q = w1;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = i0;
        shareItem.K = w1;
        shareItem.f13356f = true;
        shareItem.E = 6;
        shareItem.M = g(a2Var);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(a2Var);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(a2Var, 1, null);
        shareItem.e0 = a2Var.e1();
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

    public static ShareItem c(Context context, int i2, int i3, PbModel pbModel) {
        String O0;
        String str;
        String str2;
        d.a.j0.d2.h.e y0 = pbModel.y0();
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
        if (i2 == 1) {
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
            shareItem.D = cutString2;
            shareItem.R = -1L;
        } else {
            shareItem.R = y0.M();
        }
        shareItem.t = str3;
        shareItem.f13353c = true;
        shareItem.q = pbModel.O0();
        shareItem.F = 3;
        shareItem.E = i3;
        shareItem.G = f(L);
        shareItem.J = pbModel.getForumId();
        shareItem.K = pbModel.O0();
        shareItem.M = h(y0);
        shareItem.N = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.v = parse;
        }
        if (y0.a0()) {
            shareItem.f0 = false;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(L);
        if (y0 != null && y0.D() != null && y0.D().size() > 0) {
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(L, 1, y0.D().get(0));
        } else {
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(L, 1, null);
        }
        if (L != null) {
            shareItem.e0 = L.e1();
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

    public static ShareFromPBMsgData d(PbFragment pbFragment) {
        String str;
        if (pbFragment == null || pbFragment.z() == null || pbFragment.J4() == null) {
            return null;
        }
        PbModel z = pbFragment.z();
        s0 J4 = pbFragment.J4();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] J = z.y0().J(pbFragment.getContext());
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
        String f0 = z.y0().L().f0();
        if (f0 == null || !f0.equals(str)) {
            str2 = str;
        }
        shareFromPBMsgData.setContent(J[1]);
        shareFromPBMsgData.setImageUrl(J[0]);
        shareFromPBMsgData.setForumName(z.y0().l().getName());
        shareFromPBMsgData.setPostId(str2);
        shareFromPBMsgData.setThreadId(z.y0().L().o0());
        shareFromPBMsgData.setTitle(z.y0().L().x1());
        return shareFromPBMsgData;
    }

    public static String e(a2 a2Var) {
        String str = null;
        if (a2Var == null || a2Var.K0() == null) {
            return null;
        }
        ArrayList<MediaData> K0 = a2Var.K0();
        int size = K0.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MediaData mediaData = K0.get(i2);
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

    public static int h(d.a.j0.d2.h.e eVar) {
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
        PbModel z = pbFragment.z();
        ShareFromPBMsgData d2 = d(pbFragment);
        if (z == null || z.y0() == null || z.y0().L() == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(pbFragment.getBaseFragmentActivity());
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
        thread2GroupShareView.c(d2.getImageUrl(), z.y0().s() == 1);
    }

    public static void k(PbFragment pbFragment, long j, String str, String str2, String str3) {
        if (pbFragment == null) {
            return;
        }
        PbModel z = pbFragment.z();
        ShareFromPBMsgData d2 = d(pbFragment);
        if (z == null || z.y0() == null || z.y0().L() == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(d2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new C1176b(z, pbFragment, thread2GroupShareView, j, str, str2, str3, d2));
        aVar.setNegativeButton(R.string.cancel, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(d2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(d2.getImageUrl(), z.y0().s() == 1);
    }

    public static void l(Context context, a2 a2Var, int i2) {
        if (a2Var == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i2, b(context, a2Var), true));
    }

    public static void m(PbFragment pbFragment, int i2, int i3) {
        if (pbFragment == null || pbFragment.z() == null || pbFragment.J4() == null) {
            return;
        }
        PbModel z = pbFragment.z();
        s0 J4 = pbFragment.J4();
        if (z.T0()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem c2 = c(pbFragment.getContext(), i2, i3, z);
            TbadkCoreApplication.getInst().setShareItem(c2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), c2, true, true);
            shareDialogConfig.setOnDismissListener(new a(z, pbFragment, J4));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            f.b().k(shareDialogConfig);
        }
    }
}
