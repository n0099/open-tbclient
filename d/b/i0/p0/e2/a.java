package d.b.i0.p0.e2;

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
import d.b.i0.p0.r;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends j {

    /* renamed from: h  reason: collision with root package name */
    public d f57405h;
    public final CustomMessageListener i;

    /* renamed from: d.b.i0.p0.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1380a extends CustomMessageListener {
        public C1380a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                if (a.this.f57405h != null) {
                    a.this.f57405h.g(postWriteCallBackData);
                }
                if (!a.this.k(postWriteCallBackData)) {
                    a.this.d(postWriteCallBackData);
                } else {
                    d.b.h0.s.h.b.a(a.this.f57478b.q(), postWriteCallBackData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f57407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f57408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f57409g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f57410h;
        public final /* synthetic */ String i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public b(Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            this.f57407e = thread2GroupShareView;
            this.f57408f = j;
            this.f57409g = str;
            this.f57410h = str2;
            this.i = str3;
            this.j = shareFromPBMsgData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            InputMethodManager inputMethodManager = (InputMethodManager) a.this.f57478b.getActivity().getSystemService("input_method");
            d.b.b.e.p.l.w(a.this.f57478b.getActivity(), this.f57407e.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.f57478b.getActivity(), this.f57408f, this.f57409g, this.f57410h, this.i, 0, this.f57407e.getLeaveMsg(), this.j.toChatMessageContent())));
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
        public final /* synthetic */ Thread2GroupShareView f57411e;

        public c(Thread2GroupShareView thread2GroupShareView) {
            this.f57411e = thread2GroupShareView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.b.e.p.l.w(a.this.f57478b.getActivity(), this.f57411e.getChatMsgView());
            aVar.dismiss();
        }
    }

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.i = new C1380a(2001383);
        this.f57405h = this.f57478b.s2();
        this.i.setTag(this.f57478b.getPageContext().getUniqueId());
        this.i.setSelfListener(true);
        this.f57478b.registerListener(this.i);
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
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.b.b.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.b.h0.r.d0.b.i().g(d.b.h0.r.d0.b.m(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f57478b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public final void e() {
        if (this.f57405h == null) {
            this.f57405h = this.f57478b.s2();
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
        ArrayList<d.b.b.j.e.n> e2;
        if (frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.f57481e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.f57481e.q0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if (!(serializableExtra instanceof CardHListViewData) || (e2 = this.f57483g.e()) == null) {
                return;
            }
            CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
            cardHListViewData.threadId = str;
            if (d.b.i0.p0.h2.b.a(e2, str, cardHListViewData, intExtra)) {
                frsViewData.setThreadList(e2);
                this.f57477a.v1(e2, frsViewData);
                p(str, this.f57478b.h());
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
        d.b.i0.p0.n2.h hVar;
        d.b.i0.p0.n2.d W;
        FrsViewData S = this.f57478b.S();
        switch (i) {
            case 11001:
                this.f57478b.Q3(0);
                return;
            case 11002:
                this.f57480d.z0(true);
                return;
            case 11011:
                FrsFragment frsFragment = this.f57478b;
                String B2 = frsFragment.B2();
                FrsFragment frsFragment2 = this.f57478b;
                d.b.i0.p0.m2.m.f(frsFragment, B2, frsFragment2.B, frsFragment2.K2());
                return;
            case 11012:
                FrsFragment frsFragment3 = this.f57478b;
                String B22 = frsFragment3.B2();
                FrsFragment frsFragment4 = this.f57478b;
                d.b.i0.p0.m2.m.g(frsFragment3, B22, frsFragment4.B, frsFragment4.K2());
                return;
            case 11014:
                this.f57480d.A0();
                return;
            case 11016:
                this.f57477a.G1();
                return;
            case 11036:
                this.f57480d.B0();
                return;
            case 18003:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                this.f57477a.U().notifyDataSetChanged();
                d.b.i0.p0.n2.h hVar2 = this.f57480d;
                if (hVar2 != null) {
                    hVar2.Y();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.f57478b.V2(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = S.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                if (intExtra == 2) {
                    threadDataById.K3(intent.getIntExtra("good_data", 0));
                    threadDataById.U2();
                }
                g(S, intent, stringExtra);
                return;
            case 18004:
                d.b.i0.p0.m2.m.d(this.f57478b.getPageContext(), S);
                return;
            case 23003:
                if (intent == null || S == null) {
                    return;
                }
                d.b.i0.p0.m2.i.b(this.f57478b, S, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                if (intExtra2 == d.b.b.e.m.b.d(this.f57478b.h(), 0)) {
                    this.f57480d.C0(intExtra3, intExtra4, intExtra5);
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
                    this.f57478b.S2(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case 25041:
                this.f57479c.c(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case 25050:
                this.f57478b.refresh();
                return;
            case 25052:
                String stringExtra2 = intent.getStringExtra("group_name");
                boolean booleanExtra = intent.getBooleanExtra("from", true);
                this.f57478b.K3(stringExtra2);
                if (booleanExtra || (hVar = this.f57480d) == null) {
                    return;
                }
                hVar.R();
                return;
            case 25054:
                r x0 = this.f57478b.x0();
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
        FrsFragment frsFragment = this.f57478b;
        if (frsFragment == null || frsFragment.z2() == null) {
            return;
        }
        if (i > 0) {
            FrsTabViewController.o F = this.f57478b.z2().F(i);
            if (F == null || !(F.f16654b instanceof FrsCommonTabFragment)) {
                return;
            }
            this.f57479c.c(i);
            return;
        }
        int B = this.f57478b.z2().B();
        if (this.f57478b.z2().F(B) != null) {
            this.f57479c.c(B);
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57478b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.f57478b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new b(thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f57478b.getPageContext()).show();
        if (d.b.b.e.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }
}
