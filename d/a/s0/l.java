package d.a.s0;

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
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.z;
/* loaded from: classes9.dex */
public class l extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public Context f62745e;

    /* renamed from: f  reason: collision with root package name */
    public VersionData f62746f;

    /* renamed from: g  reason: collision with root package name */
    public CombineDownload f62747g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62748h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62749i;
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f62750e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62750e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                this.f62750e.j = true;
                if (this.f62750e.f62749i) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f62750e.q.setCompoundDrawables(drawable, null, null, null);
                }
                this.f62750e.F.a(this.f62750e.f62749i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f62751e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62751e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f62751e.J) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                this.f62751e.w.setEnabled(false);
                this.f62751e.F.b(this.f62751e.f62749i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f62752e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62752e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62752e.F.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f62753e;

        public d(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62753e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f62753e.j) {
                return;
            }
            if (this.f62753e.f62749i) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f62753e.q.setCompoundDrawables(drawable, null, null, null);
                this.f62753e.f62748h = false;
                this.f62753e.f62749i = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f62753e.q.setCompoundDrawables(drawable2, null, null, null);
            this.f62753e.f62748h = true;
            this.f62753e.f62749i = true;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f62754e;

        public e(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62754e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f62754e.s.getId()) {
                    this.f62754e.F.d();
                    l lVar = this.f62754e;
                    lVar.n(lVar.f62745e);
                } else if (view.getId() == this.f62754e.v.getId()) {
                    this.f62754e.F.d();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d();

        void e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62749i = true;
        this.j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e(this);
        this.f62745e = context;
    }

    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i2) == null) {
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(findViewById(R.id.app_download_dialog_layout));
            }
            SkinManager.setImageResource(this.v, R.drawable.write_close_selector);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
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
    }

    public final void o() {
        Window window;
        WindowManager.LayoutParams attributes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (window = getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
            String size = this.f62746f.getSize();
            String newVersion = this.f62746f.getNewVersion();
            String newVersionDesc = this.f62746f.getNewVersionDesc();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f62745e.getString(R.string.new_version_format));
            if (!TextUtils.isEmpty(newVersion)) {
                sb.append(newVersion);
            }
            if (!TextUtils.isEmpty(size)) {
                sb.append(" / " + String.format("%.2f", Float.valueOf(d.a.c.e.m.b.c(size, 0.0f) / 1048576.0f)) + "MB");
            }
            this.m.setText(sb.toString());
            this.n.setText(newVersionDesc);
            if (this.f62746f.forceUpdate()) {
                this.k = true;
                this.r.setText(this.f62745e.getString(R.string.quit));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            } else if (this.f62746f.isOfficialVersion() && d.a.c.e.p.l.w(this.f62745e, "com.tencent.android.qqdownloader")) {
                this.r.setVisibility(8);
            } else {
                this.r.setText(this.f62745e.getString(R.string.update_after));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            }
            CombineDownload combineDownload = this.f62747g;
            if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.f62747g.getApkMD5RSA())) {
                this.q.setText(this.f62747g.getAppName());
                if (!z.b(this.f62745e, this.f62747g.getAppProc()) && !TextUtils.isEmpty(this.f62747g.getAppUrl())) {
                    this.q.setVisibility(0);
                    Drawable drawable = this.f62745e.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.q.setCompoundDrawables(drawable, null, null, null);
                } else {
                    this.q.setVisibility(8);
                }
            } else {
                this.q.setVisibility(8);
            }
            s(this.I);
            this.t.setOnClickListener(new a(this));
            this.w.setOnClickListener(new b(this));
            this.r.setOnClickListener(new c(this));
            this.q.setOnClickListener(new d(this));
            o();
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.G = onClickListener;
        }
    }

    public void q(VersionData versionData, CombineDownload combineDownload, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, versionData, combineDownload, fVar) == null) {
            this.f62746f = versionData;
            this.f62747g = combineDownload;
            this.F = fVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.z.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (n.c(this.f62745e.getPackageManager())) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
            if (z) {
                VersionData versionData = this.f62746f;
                if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.f62746f.getNewVersionCode() >= 0) {
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
            VersionData versionData2 = this.f62746f;
            if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.f62746f.getNewVersionCode() >= 0) {
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
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.t.setEnabled(z);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.H = onClickListener;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.t.setVisibility(8);
            this.y.setVisibility(8);
            this.r.setVisibility(8);
            this.u.setVisibility(8);
            this.j = true;
            this.E.setVisibility(0);
            this.o.setVisibility(0);
            TextView textView = this.o;
            textView.setText(this.p + i2 + "%");
            this.v.setVisibility(8);
            this.s.setVisibility(8);
        }
    }
}
