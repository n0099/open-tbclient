package d.a.k0.q0.e2;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.s.a;
import d.a.k0.q0.r;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends j {

    /* renamed from: h  reason: collision with root package name */
    public d f58310h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f58311i;

    /* renamed from: d.a.k0.q0.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1478a extends CustomMessageListener {
        public C1478a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                if (a.this.f58310h != null) {
                    a.this.f58310h.g(postWriteCallBackData);
                }
                if (!a.this.k(postWriteCallBackData)) {
                    a.this.d(postWriteCallBackData);
                } else {
                    d.a.j0.s.h.b.a(a.this.f58397b.o(), postWriteCallBackData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f58313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f58314f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f58315g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f58316h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f58317i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public b(Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            this.f58313e = thread2GroupShareView;
            this.f58314f = j;
            this.f58315g = str;
            this.f58316h = str2;
            this.f58317i = str3;
            this.j = shareFromPBMsgData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            InputMethodManager inputMethodManager = (InputMethodManager) a.this.f58397b.getActivity().getSystemService("input_method");
            d.a.c.e.p.l.x(a.this.f58397b.getActivity(), this.f58313e.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.f58397b.getActivity(), this.f58314f, this.f58315g, this.f58316h, this.f58317i, 0, this.f58313e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null || shareItem.e() == null) {
                return;
            }
            Bundle e2 = shareItem.e();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e2.getInt("obj_type")).param("obj_param1", 3).param("fid", e2.getString("fid")).param("tid", e2.getString("tid")));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f58318e;

        public c(Thread2GroupShareView thread2GroupShareView) {
            this.f58318e = thread2GroupShareView;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            d.a.c.e.p.l.x(a.this.f58397b.getActivity(), this.f58318e.getChatMsgView());
            aVar.dismiss();
        }
    }

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.f58311i = new C1478a(2001383);
        this.f58310h = this.f58397b.r2();
        this.f58311i.setTag(this.f58397b.getPageContext().getUniqueId());
        this.f58311i.setSelfListener(true);
        this.f58397b.registerListener(this.f58311i);
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
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.a.c.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.a.j0.r.d0.b.j().g(d.a.j0.r.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f58397b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public final void e() {
        if (this.f58310h == null) {
            this.f58310h = this.f58397b.r2();
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
        shareFromPBMsgData.setContent(shareItem.D);
        shareFromPBMsgData.setImageUrl(uri2);
        shareFromPBMsgData.setForumName(shareItem.p);
        shareFromPBMsgData.setThreadId(shareItem.K);
        return shareFromPBMsgData;
    }

    public final void g(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<d.a.c.j.e.n> e2;
        if (frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.f58400e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.f58400e.q0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if (!(serializableExtra instanceof CardHListViewData) || (e2 = this.f58402g.e()) == null) {
                return;
            }
            CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
            cardHListViewData.threadId = str;
            if (d.a.k0.q0.h2.b.a(e2, str, cardHListViewData, intExtra)) {
                frsViewData.setThreadList(e2);
                this.f58396a.v1(e2, frsViewData);
                p(str, this.f58397b.h());
            }
        }
    }

    public final void h(int i2, Intent intent) {
        if (i2 != 18003) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
    }

    public final void i(int i2, Intent intent) {
        a2 threadDataById;
        ShareItem shareItem;
        d.a.k0.q0.o2.h hVar;
        d.a.k0.q0.o2.d W;
        FrsViewData g0 = this.f58397b.g0();
        switch (i2) {
            case 11001:
                this.f58397b.P3(0);
                return;
            case 11002:
                this.f58399d.z0(true);
                return;
            case 11011:
                FrsFragment frsFragment = this.f58397b;
                String A2 = frsFragment.A2();
                FrsFragment frsFragment2 = this.f58397b;
                d.a.k0.q0.n2.m.f(frsFragment, A2, frsFragment2.B, frsFragment2.J2());
                return;
            case 11012:
                FrsFragment frsFragment3 = this.f58397b;
                String A22 = frsFragment3.A2();
                FrsFragment frsFragment4 = this.f58397b;
                d.a.k0.q0.n2.m.g(frsFragment3, A22, frsFragment4.B, frsFragment4.J2());
                return;
            case 11014:
                this.f58399d.A0();
                return;
            case 11016:
                this.f58396a.G1();
                return;
            case 11036:
                this.f58399d.B0();
                return;
            case 18003:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                this.f58396a.U().notifyDataSetChanged();
                d.a.k0.q0.o2.h hVar2 = this.f58399d;
                if (hVar2 != null) {
                    hVar2.Y();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.f58397b.U2(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = g0.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                if (intExtra == 2) {
                    threadDataById.N3(intent.getIntExtra("good_data", 0));
                    threadDataById.X2();
                }
                g(g0, intent, stringExtra);
                return;
            case 18004:
                d.a.k0.q0.n2.m.d(this.f58397b.getPageContext(), g0);
                return;
            case 23003:
                if (intent == null || g0 == null) {
                    return;
                }
                d.a.k0.q0.n2.i.b(this.f58397b, g0, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                if (intExtra2 == d.a.c.e.m.b.d(this.f58397b.h(), 0)) {
                    this.f58399d.C0(intExtra3, intExtra4, intExtra5);
                    return;
                }
                return;
            case 24007:
                int intExtra6 = intent.getIntExtra("extra_share_status", 2);
                if (intExtra6 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", shareItem.K);
                    statisticItem.param("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(statisticItem);
                }
                if (intExtra6 == 1) {
                    this.f58397b.R2(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case 25041:
                this.f58398c.b(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case 25050:
                this.f58397b.refresh();
                return;
            case 25052:
                String stringExtra2 = intent.getStringExtra("group_name");
                boolean booleanExtra = intent.getBooleanExtra("from", true);
                this.f58397b.J3(stringExtra2);
                if (booleanExtra || (hVar = this.f58399d) == null) {
                    return;
                }
                hVar.P();
                return;
            case 25054:
                r y0 = this.f58397b.y0();
                if (y0 == null || (W = y0.W()) == null) {
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

    public void l(int i2) {
        FrsFragment frsFragment = this.f58397b;
        if (frsFragment == null || frsFragment.y2() == null) {
            return;
        }
        if (i2 > 0) {
            FrsTabViewController.o F = this.f58397b.y2().F(i2);
            if (F == null || !(F.f15858b instanceof FrsCommonTabFragment)) {
                return;
            }
            this.f58398c.b(i2);
            return;
        }
        int B = this.f58397b.y2().B();
        if (this.f58397b.y2().F(B) != null) {
            this.f58398c.b(B);
        }
    }

    public void m(int i2, int i3, Intent intent) {
        e();
        if (i3 == -1) {
            i(i2, intent);
        } else if (i3 == 0) {
            h(i2, intent);
        }
    }

    public void n() {
        MessageManager.getInstance().unRegisterListener(this.f58311i);
    }

    public final void o(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        if (shareFromPBMsgData == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f58397b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.f58397b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new b(thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f58397b.getPageContext()).show();
        if (d.a.c.e.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }
}
