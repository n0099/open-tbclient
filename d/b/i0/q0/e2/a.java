package d.b.i0.q0.e2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import d.b.h0.r.q.a2;
import d.b.h0.r.s.a;
import d.b.i0.q0.r;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends j {

    /* renamed from: h  reason: collision with root package name */
    public d f59104h;
    public final CustomMessageListener i;

    /* renamed from: d.b.i0.q0.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1442a extends CustomMessageListener {
        public C1442a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                if (a.this.f59104h != null) {
                    a.this.f59104h.g(postWriteCallBackData);
                }
                if (!a.this.k(postWriteCallBackData)) {
                    a.this.d(postWriteCallBackData);
                } else {
                    d.b.h0.s.h.b.a(a.this.f59177b.q(), postWriteCallBackData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f59106e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f59107f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f59108g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f59109h;
        public final /* synthetic */ String i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public b(Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            this.f59106e = thread2GroupShareView;
            this.f59107f = j;
            this.f59108g = str;
            this.f59109h = str2;
            this.i = str3;
            this.j = shareFromPBMsgData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            InputMethodManager inputMethodManager = (InputMethodManager) a.this.f59177b.getActivity().getSystemService("input_method");
            d.b.c.e.p.l.w(a.this.f59177b.getActivity(), this.f59106e.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.f59177b.getActivity(), this.f59107f, this.f59108g, this.f59109h, this.i, 0, this.f59106e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null || shareItem.d() == null) {
                return;
            }
            Bundle d2 = shareItem.d();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", d2.getInt("obj_type")).param("obj_param1", 3).param("fid", d2.getString("fid")).param("tid", d2.getString("tid")));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f59110e;

        public c(Thread2GroupShareView thread2GroupShareView) {
            this.f59110e = thread2GroupShareView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.c.e.p.l.w(a.this.f59177b.getActivity(), this.f59110e.getChatMsgView());
            aVar.dismiss();
        }
    }

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.i = new C1442a(2001383);
        this.f59104h = this.f59177b.s2();
        this.i.setTag(this.f59177b.getPageContext().getUniqueId());
        this.i.setSelfListener(true);
        this.f59177b.registerListener(this.i);
    }

    public static void p(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11959");
        statisticItem.param("tid", str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
    }

    public final boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.b.c.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.b.h0.r.d0.b.j().g(d.b.h0.r.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f59177b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public final void e() {
        if (this.f59104h == null) {
            this.f59104h = this.f59177b.s2();
        }
    }

    public final ShareFromPBMsgData f() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        Uri uri = shareItem.v;
        String uri2 = uri == null ? "https://tb5.bdstatic.com/yunying/tieba_logo.jpg" : uri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.r);
        shareFromPBMsgData.setContent(shareItem.C);
        shareFromPBMsgData.setImageUrl(uri2);
        shareFromPBMsgData.setForumName(shareItem.p);
        shareFromPBMsgData.setThreadId(shareItem.J);
        return shareFromPBMsgData;
    }

    public final void g(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<d.b.c.j.e.n> e2;
        if (frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.f59180e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.f59180e.q0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if (!(serializableExtra instanceof CardHListViewData) || (e2 = this.f59182g.e()) == null) {
                return;
            }
            CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
            cardHListViewData.threadId = str;
            if (d.b.i0.q0.h2.b.a(e2, str, cardHListViewData, intExtra)) {
                frsViewData.setThreadList(e2);
                this.f59176a.v1(e2, frsViewData);
                p(str, this.f59177b.h());
            }
        }
    }

    public final void h(int i, Intent intent) {
        if (i != 18003) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
    }

    public final void i(int i, Intent intent) {
        a2 threadDataById;
        ShareItem shareItem;
        d.b.i0.q0.o2.h hVar;
        d.b.i0.q0.o2.d W;
        FrsViewData S = this.f59177b.S();
        switch (i) {
            case 11001:
                this.f59177b.Q3(0);
                return;
            case 11002:
                this.f59179d.z0(true);
                return;
            case 11011:
                FrsFragment frsFragment = this.f59177b;
                String B2 = frsFragment.B2();
                FrsFragment frsFragment2 = this.f59177b;
                d.b.i0.q0.n2.m.f(frsFragment, B2, frsFragment2.B, frsFragment2.K2());
                return;
            case 11012:
                FrsFragment frsFragment3 = this.f59177b;
                String B22 = frsFragment3.B2();
                FrsFragment frsFragment4 = this.f59177b;
                d.b.i0.q0.n2.m.g(frsFragment3, B22, frsFragment4.B, frsFragment4.K2());
                return;
            case 11014:
                this.f59179d.A0();
                return;
            case 11016:
                this.f59176a.G1();
                return;
            case 11036:
                this.f59179d.B0();
                return;
            case 18003:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                this.f59176a.U().notifyDataSetChanged();
                d.b.i0.q0.o2.h hVar2 = this.f59179d;
                if (hVar2 != null) {
                    hVar2.Y();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.f59177b.V2(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = S.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                if (intExtra == 2) {
                    threadDataById.L3(intent.getIntExtra("good_data", 0));
                    threadDataById.V2();
                }
                g(S, intent, stringExtra);
                return;
            case 18004:
                d.b.i0.q0.n2.m.d(this.f59177b.getPageContext(), S);
                return;
            case 23003:
                if (intent == null || S == null) {
                    return;
                }
                d.b.i0.q0.n2.i.b(this.f59177b, S, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                return;
            case 23007:
                j(intent);
                return;
            case 24002:
                if (intent == null) {
                    return;
                }
                int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                if (intExtra2 == d.b.c.e.m.b.d(this.f59177b.h(), 0)) {
                    this.f59179d.C0(intExtra3, intExtra4, intExtra5);
                    return;
                }
                return;
            case 24007:
                int intExtra6 = intent.getIntExtra("extra_share_status", 2);
                if (intExtra6 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", shareItem.J);
                    statisticItem.param("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(statisticItem);
                }
                if (intExtra6 == 1) {
                    this.f59177b.S2(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case 25041:
                this.f59178c.c(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case 25050:
                this.f59177b.refresh();
                return;
            case 25052:
                String stringExtra2 = intent.getStringExtra("group_name");
                boolean booleanExtra = intent.getBooleanExtra("from", true);
                this.f59177b.K3(stringExtra2);
                if (booleanExtra || (hVar = this.f59179d) == null) {
                    return;
                }
                hVar.R();
                return;
            case 25054:
                r x0 = this.f59177b.x0();
                if (x0 == null || (W = x0.W()) == null) {
                    return;
                }
                W.C();
                return;
            default:
                return;
        }
    }

    public final void j(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        o(f(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    public final boolean k(PostWriteCallBackData postWriteCallBackData) {
        return (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true;
    }

    public void l(int i) {
        FrsFragment frsFragment = this.f59177b;
        if (frsFragment == null || frsFragment.z2() == null) {
            return;
        }
        if (i > 0) {
            FrsTabViewController.o F = this.f59177b.z2().F(i);
            if (F == null || !(F.f16315b instanceof FrsCommonTabFragment)) {
                return;
            }
            this.f59178c.c(i);
            return;
        }
        int B = this.f59177b.z2().B();
        if (this.f59177b.z2().F(B) != null) {
            this.f59178c.c(B);
        }
    }

    public void m(int i, int i2, Intent intent) {
        e();
        if (i2 == -1) {
            i(i, intent);
        } else if (i2 == 0) {
            h(i, intent);
        }
    }

    public void n() {
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public final void o(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        if (shareFromPBMsgData == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f59177b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.f59177b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new b(thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f59177b.getPageContext()).show();
        if (d.b.c.e.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }
}
