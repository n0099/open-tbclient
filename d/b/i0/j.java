package d.b.i0;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.R;
import d.b.i0.d3.z;
/* loaded from: classes4.dex */
public class j extends Dialog {
    public TextView A;
    public TextView B;
    public TextView C;
    public View D;
    public LinearLayout E;
    public f F;
    public View.OnClickListener G;
    public View.OnClickListener H;
    public boolean I;
    public boolean J;
    public View.OnClickListener K;

    /* renamed from: e  reason: collision with root package name */
    public Context f57306e;

    /* renamed from: f  reason: collision with root package name */
    public VersionData f57307f;

    /* renamed from: g  reason: collision with root package name */
    public CombineDownload f57308g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57309h;
    public boolean i;
    public boolean j;
    public boolean k;
    public LinearLayout l;
    public TextView m;
    public TextView n;
    public TextView o;
    public String p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public View u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public View y;
    public LinearLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
            j.this.j = true;
            if (j.this.i) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.q.setCompoundDrawables(drawable, null, null, null);
            }
            j.this.F.a(j.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.J) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
            } else {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
            }
            j.this.w.setEnabled(false);
            j.this.F.b(j.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.F.d();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.j) {
                return;
            }
            if (j.this.i) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.q.setCompoundDrawables(drawable, null, null, null);
                j.this.f57309h = false;
                j.this.i = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            j.this.q.setCompoundDrawables(drawable2, null, null, null);
            j.this.f57309h = true;
            j.this.i = true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == j.this.s.getId()) {
                j.this.F.d();
                j jVar = j.this;
                jVar.n(jVar.f57306e);
            } else if (view.getId() == j.this.v.getId()) {
                j.this.F.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d();

        void e();
    }

    public j(Context context, int i) {
        super(context, i);
        this.i = true;
        this.j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e();
        this.f57306e = context;
    }

    public void m(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(i == 1);
            tbPageContext.getLayoutMode().j(findViewById(R.id.app_download_dialog_layout));
        }
        SkinManager.setImageResource(this.v, R.drawable.write_close_selector);
    }

    public void n(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        try {
            intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public final void o() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.j) {
            this.F.c();
            this.l.setVisibility(8);
            if (this.k) {
                this.A.setText(getContext().getString(R.string.download_exit));
            }
            this.z.setVisibility(0);
            return;
        }
        this.F.e();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.l = (LinearLayout) findViewById(R.id.app_info);
        this.m = (TextView) findViewById(R.id.app_version_and_size);
        this.n = (TextView) findViewById(R.id.app_description);
        this.t = (TextView) findViewById(R.id.fullsize_download_button);
        this.r = (TextView) findViewById(R.id.cancel_download_button);
        this.s = (TextView) findViewById(R.id.btn_update_save_flow);
        this.v = (ImageView) findViewById(R.id.img_close);
        this.s.setOnClickListener(this.K);
        this.v.setOnClickListener(this.K);
        this.u = findViewById(R.id.divider_line);
        this.o = (TextView) findViewById(R.id.download_process);
        this.w = (TextView) findViewById(R.id.incremental_download_button);
        this.x = (TextView) findViewById(R.id.not_install_as_tip);
        this.y = findViewById(R.id.incremental_download_layout);
        this.q = (TextView) findViewById(R.id.other_app_recommend);
        this.D = findViewById(R.id.divider_under_button);
        this.E = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.p = this.o.getText().toString();
        this.z = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.B = (TextView) findViewById(R.id.sure_cancel);
        this.C = (TextView) findViewById(R.id.cancel_button);
        this.A = (TextView) findViewById(R.id.cancel_tip);
        this.B.setOnClickListener(this.G);
        this.C.setOnClickListener(this.H);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.I = true;
        } else {
            this.I = false;
        }
        String size = this.f57307f.getSize();
        String newVersion = this.f57307f.getNewVersion();
        String newVersionDesc = this.f57307f.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f57306e.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(d.b.c.e.m.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.m.setText(sb.toString());
        this.n.setText(newVersionDesc);
        if (this.f57307f.forceUpdate()) {
            this.k = true;
            this.r.setText(this.f57306e.getString(R.string.quit));
            this.s.setVisibility(8);
            this.v.setVisibility(8);
        } else if (this.f57307f.isOfficialVersion() && d.b.c.e.p.l.v(this.f57306e, "com.tencent.android.qqdownloader")) {
            this.r.setVisibility(8);
        } else {
            this.r.setText(this.f57306e.getString(R.string.update_after));
            this.s.setVisibility(8);
            this.v.setVisibility(8);
        }
        CombineDownload combineDownload = this.f57308g;
        if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.f57308g.getApkMD5RSA())) {
            this.q.setText(this.f57308g.getAppName());
            if (!z.b(this.f57306e, this.f57308g.getAppProc()) && !TextUtils.isEmpty(this.f57308g.getAppUrl())) {
                this.q.setVisibility(0);
                Drawable drawable = this.f57306e.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.q.setCompoundDrawables(drawable, null, null, null);
            } else {
                this.q.setVisibility(8);
            }
        } else {
            this.q.setVisibility(8);
        }
        s(this.I);
        this.t.setOnClickListener(new a());
        this.w.setOnClickListener(new b());
        this.r.setOnClickListener(new c());
        this.q.setOnClickListener(new d());
        o();
    }

    public void p(View.OnClickListener onClickListener) {
        this.G = onClickListener;
    }

    public void q(VersionData versionData, CombineDownload combineDownload, f fVar) {
        this.f57307f = versionData;
        this.f57308g = combineDownload;
        this.F = fVar;
    }

    public void r() {
        this.z.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void s(boolean z) {
        if (l.c(this.f57306e.getPackageManager())) {
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
        }
        if (z) {
            VersionData versionData = this.f57307f;
            if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.f57307f.getNewVersionCode() >= 0) {
                this.y.setVisibility(0);
                this.w.setText(R.string.incremental_update);
                SkinManager.setBackgroundResource(this.w, R.drawable.dialog_single_button_bg_selector);
                this.D.setVisibility(8);
                this.E.setVisibility(8);
                this.J = true;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                return;
            }
            this.y.setVisibility(0);
            this.w.setText(R.string.super_update);
            SkinManager.setBackgroundResource(this.w, R.drawable.dialog_middle_item_bg_selector);
            this.E.setVisibility(0);
            this.J = false;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
            return;
        }
        VersionData versionData2 = this.f57307f;
        if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.f57307f.getNewVersionCode() >= 0) {
            this.y.setVisibility(0);
            SkinManager.setBackgroundResource(this.w, R.drawable.dialog_middle_item_bg_selector);
            this.w.setText(R.string.incremental_update);
            this.E.setVisibility(0);
            this.J = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
            return;
        }
        this.y.setVisibility(8);
        this.E.setVisibility(0);
        TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
    }

    public void t(boolean z) {
        this.t.setEnabled(z);
    }

    public void u(View.OnClickListener onClickListener) {
        this.H = onClickListener;
    }

    public void v(int i) {
        this.t.setVisibility(8);
        this.y.setVisibility(8);
        this.r.setVisibility(8);
        this.u.setVisibility(8);
        this.j = true;
        this.E.setVisibility(0);
        this.o.setVisibility(0);
        TextView textView = this.o;
        textView.setText(this.p + i + "%");
        this.v.setVisibility(8);
        this.s.setVisibility(8);
    }
}
