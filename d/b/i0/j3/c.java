package d.b.i0.j3;

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
import d.b.b.a.j;
import d.b.b.e.m.g;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.s.c.c0;
/* loaded from: classes5.dex */
public class c implements View.OnClickListener, d.b.i0.j3.a {
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;

    /* renamed from: e  reason: collision with root package name */
    public Context f56411e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f56412f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f56413g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.j3.b f56414h;
    public EMTextView i;
    public View j;
    public AlertDialog k;
    public DialogInterface.OnDismissListener l;
    public boolean m;
    public ShareDialogConfig n;
    public float o = 0.33f;
    public CustomMessageListener p = new a(2001304);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.h();
                c cVar = c.this;
                cVar.m(cVar.n);
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
            if (c.this.f56414h != null) {
                c.this.f56414h.k();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* renamed from: d.b.i0.j3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1320c implements CustomMessageTask.CustomRunnable<Object> {
        public C1320c() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (c.this.k == null || !c.this.k.isShowing()) {
                return null;
            }
            c.this.i();
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
        this.f56411e = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f56412f = linearLayout;
        linearLayout.setOrientation(1);
        EMTextView eMTextView = new EMTextView(context);
        this.f56413g = eMTextView;
        eMTextView.setTextSize(0, u);
        EMTextView eMTextView2 = this.f56413g;
        int i = q;
        eMTextView2.setPadding(i, r, i, s);
        this.f56413g.setGravity(1);
        this.f56413g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f56412f.addView(this.f56413g);
        this.f56414h = new d.b.i0.j3.b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = ShareGridLayout.j;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        this.f56412f.addView(this.f56414h.d(), layoutParams);
        EMTextView eMTextView3 = new EMTextView(context);
        this.i = eMTextView3;
        eMTextView3.setGravity(1);
        this.i.setTextSize(0, v);
        this.i.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = w;
        this.i.setLayoutParams(layoutParams2);
        EMTextView eMTextView4 = this.i;
        int i3 = t;
        eMTextView4.setPadding(0, i3, 0, i3);
        this.i.setOnClickListener(this);
        this.f56412f.addView(this.i);
        this.j = new View(context);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.f56412f.addView(this.j);
        this.f56414h.l(this);
    }

    @Override // d.b.i0.j3.a
    public void a(View view) {
        i();
    }

    public final void h() {
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f56412f);
        a2.h(R.string.J_X14);
        a2.c(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f56413g, R.color.CAM_X0109);
        SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0107);
    }

    public void i() {
        AlertDialog alertDialog = this.k;
        if (alertDialog != null) {
            Context context = this.f56411e;
            if (context instanceof Activity) {
                g.a(alertDialog, (Activity) context);
                MessageManager.getInstance().unRegisterListener(this.p);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public void j(ShareDialogConfig.From from) {
        c0 sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !k.isEmpty(sharePanelConfData.b())) {
            this.f56413g.setText(sharePanelConfData.b());
        }
    }

    public final void k() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new C1320c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void l(DialogInterface.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void m(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.C)) {
            ShareItem shareItem = shareDialogConfig.shareItem;
            shareItem.s = shareItem.C;
        }
        if (!shareDialogConfig.shareItem.Y) {
            this.f56413g.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.f56413g.setText(sharePanelText);
            } else {
                this.f56413g.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.f56414h.m(shareDialogConfig, this.m);
        this.n = shareDialogConfig;
    }

    public void n(boolean z) {
        this.m = z;
    }

    public void o() {
        h();
        AlertDialog create = new AlertDialog.Builder(this.f56411e, R.style.DialogTheme).create();
        this.k = create;
        create.setCanceledOnTouchOutside(true);
        this.k.setOnDismissListener(new b());
        Context context = this.f56411e;
        if (context instanceof Activity) {
            g.i(this.k, (Activity) context);
        }
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f56412f);
        a2.h(R.string.J_X14);
        a2.c(R.color.CAM_X0204);
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
        window.setContentView(this.f56412f);
        window.setDimAmount(this.o);
        k();
        j.a(this.f56411e).registerListener(this.p);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.i) {
            p("share_cancel", new Object[0]);
            i();
        }
    }

    public final void p(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f56411e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }
}
