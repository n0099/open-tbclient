package d.a.i0.c1.b;

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
import d.a.c.e.p.l;
import d.a.i0.r.s.a;
import tbclient.FrsPage.TipInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.i0.c1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1034a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f48368e;

        public C1034a(d.a.i0.r.s.a aVar) {
            this.f48368e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f48368e.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48369e;

        public b(TbPageContext tbPageContext) {
            this.f48369e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f48369e.getPageActivity());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f48370e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48371f;

        public c(d.a.i0.r.s.a aVar, TbPageContext tbPageContext) {
            this.f48370e = aVar;
            this.f48371f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486));
            this.f48370e.dismiss();
            this.f48371f.getPageActivity().finish();
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f48372a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48373b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f48374c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2, d.a.i0.r.s.a aVar, TbPageContext tbPageContext, int i3) {
            super(i2);
            this.f48372a = aVar;
            this.f48373b = tbPageContext;
            this.f48374c = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) != 3) {
                return;
            }
            this.f48372a.dismiss();
            BdTopToast bdTopToast = new BdTopToast(this.f48373b.getPageActivity(), 2000);
            bdTopToast.i(true);
            bdTopToast.h(this.f48373b.getPageActivity().getString(R.string.youngster_close_title));
            bdTopToast.j((ViewGroup) this.f48373b.getPageActivity().findViewById(this.f48374c));
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f48375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48376f;

        public e(YoungsterFrsDialogView youngsterFrsDialogView, TbPageContext tbPageContext) {
            this.f48375e = youngsterFrsDialogView;
            this.f48376f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.i0.r.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f48375e.b());
            YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(this.f48376f.getPageActivity());
            youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterIntroduceActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f48377e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48378f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48379g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f48380h;

        public f(YoungsterFrsDialogView youngsterFrsDialogView, TbPageContext tbPageContext, int i2, d.a.i0.r.s.a aVar) {
            this.f48377e = youngsterFrsDialogView;
            this.f48378f = tbPageContext;
            this.f48379g = i2;
            this.f48380h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.i0.r.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f48377e.b());
            BdTopToast bdTopToast = new BdTopToast(this.f48378f.getPageActivity(), 2000);
            bdTopToast.i(true);
            bdTopToast.h(this.f48378f.getPageActivity().getString(R.string.youngster_frs_top_toast));
            bdTopToast.j((ViewGroup) this.f48378f.getPageActivity().findViewById(this.f48379g));
            this.f48380h.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f48381a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48382b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f48383c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2, d.a.i0.r.s.a aVar, TbPageContext tbPageContext, int i3) {
            super(i2);
            this.f48381a = aVar;
            this.f48382b = tbPageContext;
            this.f48383c = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            this.f48381a.dismiss();
            a.d(this.f48382b, this.f48383c);
        }
    }

    public static boolean b(String str) {
        if (d.a.i0.r.d0.b.j().g("key_youngster_frs_dialog_no_tip_again", false) || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        return c(str, null);
    }

    public static boolean c(String str, d.a.i0.c1.b.b bVar) {
        int d2;
        long c2;
        if (StringUtils.isNull(str)) {
            return false;
        }
        String[] split = str.split(",");
        if (bVar == null) {
            d2 = d.a.i0.r.d0.b.j().k("key_youngster_frs_showed_times", 0);
        } else {
            d2 = bVar.d();
        }
        if (bVar == null) {
            c2 = d.a.i0.r.d0.b.j().l("key_youngster_frs_dialog_show_time", 0L);
        } else {
            c2 = bVar.c();
        }
        int min = Math.min(d2, split.length) - 1;
        if (min < 0 || min >= split.length) {
            return true;
        }
        return System.currentTimeMillis() - c2 > ((long) d.a.c.e.m.b.d(split[min], 0)) * 86400000;
    }

    public static void d(TbPageContext<?> tbPageContext, int i2) {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
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
        d dVar = new d(2921484, aVar, tbPageContext, i2);
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            dVar.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
        } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
            dVar.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
        }
        MessageManager.getInstance().registerListener(dVar);
    }

    public static void e(TbPageContext<?> tbPageContext, int i2) {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
        YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
        youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_open_title, new e(youngsterFrsDialogView, tbPageContext));
        youngsterFrsDialogView.setRightOnClickListener(R.string.youngster_dialog_negative_button, new f(youngsterFrsDialogView, tbPageContext, i2, aVar));
        youngsterFrsDialogView.setNoTipAgainViewVisible(true);
        youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_setting);
        youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_message);
        youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.g(tbPageContext.getPageActivity(), R.dimen.tbds65));
        aVar.setContentView(youngsterFrsDialogView);
        aVar.setContentViewSize(5);
        aVar.setCancelable(false);
        aVar.create(tbPageContext).show();
        d.a.i0.r.d0.b.j().w("key_youngster_frs_dialog_show_time", System.currentTimeMillis());
        int k = d.a.i0.r.d0.b.j().k("key_youngster_frs_showed_times", 0) + 1;
        if (k > 2) {
            k = 2;
        }
        d.a.i0.r.d0.b.j().v("key_youngster_frs_showed_times", k);
        g gVar = new g(2921487, aVar, tbPageContext, i2);
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            gVar.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
        } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
            gVar.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
        }
        MessageManager.getInstance().registerListener(gVar);
    }

    public static void f(d.a.c.a.f<?> fVar, TipInfo tipInfo, String str, String str2, String str3) {
        if (fVar == null || tipInfo == null || StringUtils.isNull(tipInfo.tip_pop_title) || StringUtils.isNull(tipInfo.tip_pop)) {
            return;
        }
        d.a.i0.c1.b.b bVar = new d.a.i0.c1.b.b(str, str2);
        if (c(tipInfo.tip_interval, bVar)) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(fVar.getPageActivity());
            aVar.setTitle(tipInfo.tip_pop_title);
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setMessage(tipInfo.tip_pop);
            aVar.setPositiveButton(str3, new C1034a(aVar));
            aVar.create(fVar).show();
            bVar.a(System.currentTimeMillis());
        }
    }

    public static boolean g(TbPageContext<?> tbPageContext, AntiData antiData, int i2) {
        if (antiData != null && antiData.isSexyForum()) {
            if (d.a.i0.c1.b.c.d()) {
                d(tbPageContext, i2);
                return true;
            } else if (b(antiData.getTeenModeInterval())) {
                e(tbPageContext, i2);
                return true;
            }
        }
        return false;
    }
}
