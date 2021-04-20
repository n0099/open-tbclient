package d.b.h0.c1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.YoungsterIntroduceActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.view.YoungsterFrsDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import d.b.c.e.p.l;
import d.b.h0.r.s.a;
import tbclient.FrsPage.TipInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.h0.c1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1073a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f50460e;

        public C1073a(d.b.h0.r.s.a aVar) {
            this.f50460e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f50460e.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50461e;

        public b(TbPageContext tbPageContext) {
            this.f50461e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f50461e.getPageActivity());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f50462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50463f;

        public c(d.b.h0.r.s.a aVar, TbPageContext tbPageContext) {
            this.f50462e = aVar;
            this.f50463f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486));
            this.f50462e.dismiss();
            this.f50463f.getPageActivity().finish();
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f50464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50465b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f50466c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, d.b.h0.r.s.a aVar, TbPageContext tbPageContext, int i2) {
            super(i);
            this.f50464a = aVar;
            this.f50465b = tbPageContext;
            this.f50466c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) != 3) {
                return;
            }
            this.f50464a.dismiss();
            BdTopToast bdTopToast = new BdTopToast(this.f50465b.getPageActivity(), 2000);
            bdTopToast.i(true);
            bdTopToast.h(this.f50465b.getPageActivity().getString(R.string.youngster_close_title));
            bdTopToast.j((ViewGroup) this.f50465b.getPageActivity().findViewById(this.f50466c));
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f50467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50468f;

        public e(YoungsterFrsDialogView youngsterFrsDialogView, TbPageContext tbPageContext) {
            this.f50467e = youngsterFrsDialogView;
            this.f50468f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f50467e.b());
            YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(this.f50468f.getPageActivity());
            youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterIntroduceActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f50469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50470f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50471g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f50472h;

        public f(YoungsterFrsDialogView youngsterFrsDialogView, TbPageContext tbPageContext, int i, d.b.h0.r.s.a aVar) {
            this.f50469e = youngsterFrsDialogView;
            this.f50470f = tbPageContext;
            this.f50471g = i;
            this.f50472h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f50469e.b());
            BdTopToast bdTopToast = new BdTopToast(this.f50470f.getPageActivity(), 2000);
            bdTopToast.i(true);
            bdTopToast.h(this.f50470f.getPageActivity().getString(R.string.youngster_frs_top_toast));
            bdTopToast.j((ViewGroup) this.f50470f.getPageActivity().findViewById(this.f50471g));
            this.f50472h.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f50473a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50474b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f50475c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i, d.b.h0.r.s.a aVar, TbPageContext tbPageContext, int i2) {
            super(i);
            this.f50473a = aVar;
            this.f50474b = tbPageContext;
            this.f50475c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            this.f50473a.dismiss();
            a.d(this.f50474b, this.f50475c);
        }
    }

    public static boolean b(String str) {
        if (d.b.h0.r.d0.b.j().g("key_youngster_frs_dialog_no_tip_again", false) || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        return c(str, null);
    }

    public static boolean c(String str, d.b.h0.c1.b.b bVar) {
        int d2;
        long c2;
        if (StringUtils.isNull(str)) {
            return false;
        }
        String[] split = str.split(",");
        if (bVar == null) {
            d2 = d.b.h0.r.d0.b.j().k("key_youngster_frs_showed_times", 0);
        } else {
            d2 = bVar.d();
        }
        if (bVar == null) {
            c2 = d.b.h0.r.d0.b.j().l("key_youngster_frs_dialog_show_time", 0L);
        } else {
            c2 = bVar.c();
        }
        int min = Math.min(d2, split.length) - 1;
        if (min < 0 || min >= split.length) {
            return true;
        }
        return System.currentTimeMillis() - c2 > ((long) d.b.c.e.m.b.d(split[min], 0)) * 86400000;
    }

    public static void d(TbPageContext<?> tbPageContext, int i) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
        youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_close_title, new b(tbPageContext));
        youngsterFrsDialogView.setRightOnClickListener(R.string.back, new c(aVar, tbPageContext));
        youngsterFrsDialogView.setNoTipAgainViewVisible(false);
        youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_open_title);
        youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_close_message);
        youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.g(tbPageContext.getPageActivity(), R.dimen.tbds95));
        aVar.setContentView(youngsterFrsDialogView);
        aVar.setContentViewSize(5);
        aVar.setCancelable(false);
        aVar.create(tbPageContext).show();
        d dVar = new d(2921484, aVar, tbPageContext, i);
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            dVar.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
        } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
            dVar.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
        }
        MessageManager.getInstance().registerListener(dVar);
    }

    public static void e(TbPageContext<?> tbPageContext, int i) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
        youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_open_title, new e(youngsterFrsDialogView, tbPageContext));
        youngsterFrsDialogView.setRightOnClickListener(R.string.youngster_dialog_negative_button, new f(youngsterFrsDialogView, tbPageContext, i, aVar));
        youngsterFrsDialogView.setNoTipAgainViewVisible(true);
        youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_setting);
        youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_message);
        youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.g(tbPageContext.getPageActivity(), R.dimen.tbds65));
        aVar.setContentView(youngsterFrsDialogView);
        aVar.setContentViewSize(5);
        aVar.setCancelable(false);
        aVar.create(tbPageContext).show();
        d.b.h0.r.d0.b.j().w("key_youngster_frs_dialog_show_time", System.currentTimeMillis());
        int k = d.b.h0.r.d0.b.j().k("key_youngster_frs_showed_times", 0) + 1;
        if (k > 2) {
            k = 2;
        }
        d.b.h0.r.d0.b.j().v("key_youngster_frs_showed_times", k);
        g gVar = new g(2921487, aVar, tbPageContext, i);
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            gVar.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
        } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
            gVar.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
        }
        MessageManager.getInstance().registerListener(gVar);
    }

    public static void f(d.b.c.a.f<?> fVar, TipInfo tipInfo, String str, String str2, String str3) {
        if (fVar == null || tipInfo == null || StringUtils.isNull(tipInfo.tip_pop_title) || StringUtils.isNull(tipInfo.tip_pop)) {
            return;
        }
        d.b.h0.c1.b.b bVar = new d.b.h0.c1.b.b(str, str2);
        if (c(tipInfo.tip_interval, bVar)) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(fVar.getPageActivity());
            aVar.setTitle(tipInfo.tip_pop_title);
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setMessage(tipInfo.tip_pop);
            aVar.setPositiveButton(str3, new C1073a(aVar));
            aVar.create(fVar).show();
            bVar.a(System.currentTimeMillis());
        }
    }

    public static boolean g(TbPageContext<?> tbPageContext, AntiData antiData, int i) {
        if (antiData != null && antiData.isSexyForum()) {
            if (d.b.h0.c1.b.c.d()) {
                d(tbPageContext, i);
                return true;
            } else if (b(antiData.getTeenModeInterval())) {
                e(tbPageContext, i);
                return true;
            }
        }
        return false;
    }
}
