package d.a.n0.l3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import d.a.c.a.j;
import d.a.c.e.m.g;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.s.c.f0;
/* loaded from: classes5.dex */
public class c implements View.OnClickListener, d.a.n0.l3.a {
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;

    /* renamed from: e  reason: collision with root package name */
    public Context f57193e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57194f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f57195g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.l3.b f57196h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f57197i;
    public View j;
    public AlertDialog k;
    public DialogInterface.OnDismissListener l;
    public boolean m;
    public ShareDialogConfig n;
    public float o = 0.33f;
    public CustomMessageListener p = new a(2001304);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.g();
                c cVar = c.this;
                cVar.l(cVar.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.l != null) {
                c.this.l.onDismiss(dialogInterface);
            }
            MessageManager.getInstance().unRegisterTask(2001450);
            if (c.this.f57196h != null) {
                c.this.f57196h.j();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* renamed from: d.a.n0.l3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1430c implements CustomMessageTask.CustomRunnable<Object> {
        public C1430c() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (c.this.k == null || !c.this.k.isShowing()) {
                return null;
            }
            c.this.h();
            return null;
        }
    }

    static {
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds130);
        q = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        r = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        t = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        u = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        v = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        w = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public c(Context context) {
        this.f57193e = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f57194f = linearLayout;
        linearLayout.setOrientation(1);
        EMTextView eMTextView = new EMTextView(context);
        this.f57195g = eMTextView;
        eMTextView.setTextSize(0, u);
        EMTextView eMTextView2 = this.f57195g;
        int i2 = q;
        eMTextView2.setPadding(i2, r, i2, s);
        this.f57195g.setGravity(1);
        this.f57195g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f57194f.addView(this.f57195g);
        this.f57196h = new d.a.n0.l3.b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i3 = ShareGridLayout.j;
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.f57194f.addView(this.f57196h.d(), layoutParams);
        EMTextView eMTextView3 = new EMTextView(context);
        this.f57197i = eMTextView3;
        eMTextView3.setGravity(1);
        this.f57197i.setTextSize(0, v);
        this.f57197i.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = w;
        this.f57197i.setLayoutParams(layoutParams2);
        EMTextView eMTextView4 = this.f57197i;
        int i4 = t;
        eMTextView4.setPadding(0, i4, 0, i4);
        this.f57197i.setOnClickListener(this);
        this.f57194f.addView(this.f57197i);
        this.j = new View(context);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.f57194f.addView(this.j);
        this.f57196h.k(this);
    }

    @Override // d.a.n0.l3.a
    public void a(View view) {
        h();
    }

    public final void g() {
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f57194f);
        d2.m(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f57195g, R.color.CAM_X0109);
        SkinManager.setViewTextColorSelector(this.f57197i, R.color.CAM_X0107);
    }

    public void h() {
        AlertDialog alertDialog = this.k;
        if (alertDialog != null) {
            Context context = this.f57193e;
            if (context instanceof Activity) {
                g.a(alertDialog, (Activity) context);
                MessageManager.getInstance().unRegisterListener(this.p);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public void i(ShareDialogConfig.From from) {
        f0 sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !k.isEmpty(sharePanelConfData.b())) {
            this.f57195g.setText(sharePanelConfData.b());
        }
    }

    public final void j() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new C1430c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void l(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.D)) {
            ShareItem shareItem = shareDialogConfig.shareItem;
            shareItem.s = shareItem.D;
        }
        if (!shareDialogConfig.shareItem.a0) {
            this.f57195g.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.f57195g.setText(sharePanelText);
            } else {
                this.f57195g.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.f57196h.l(shareDialogConfig, this.m);
        this.n = shareDialogConfig;
    }

    public void m(boolean z) {
        this.m = z;
    }

    public void n() {
        g();
        AlertDialog create = new AlertDialog.Builder(this.f57193e, R.style.DialogTheme).create();
        this.k = create;
        create.setCanceledOnTouchOutside(true);
        this.k.setOnDismissListener(new b());
        Context context = this.f57193e;
        if (context instanceof Activity) {
            g.i(this.k, (Activity) context);
        }
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f57194f);
        d2.m(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        Window window = this.k.getWindow();
        if (window == null) {
            return;
        }
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.f57194f);
        window.setDimAmount(this.o);
        j();
        j.a(this.f57193e).registerListener(this.p);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public final void o(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f57193e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57197i) {
            o("share_cancel", new Object[0]);
            h();
        }
    }
}
