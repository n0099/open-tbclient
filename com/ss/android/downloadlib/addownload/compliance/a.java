package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.p.a.d.b.c;
import c.p.a.d.b.l;
import c.p.a.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.adhost.R;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.guide.install.ClipImageView;
/* loaded from: classes10.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75516e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f75517f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f75518g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f75519h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f75520i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f75521j;
    public ClipImageView k;
    public LinearLayout l;
    public Activity m;
    public final long n;
    public long o;
    public final c.C1524c p;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class DialogInterface$OnCancelListenerC2050a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f75522e;

        public DialogInterface$OnCancelListenerC2050a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75522e = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                c.p.a.d.b.e.b.c("lp_app_dialog_cancel", this.f75522e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f75523a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75523a = aVar;
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.d.c
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                if (bitmap != null) {
                    this.f75523a.k.setImageBitmap(bitmap);
                } else {
                    c.p.a.d.b.e.b.a(8, this.f75523a.o);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f75524e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75524e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.p.a.d.b.e.a.a().c(this.f75524e.m);
                AppDetailInfoActivity.a(this.f75524e.m, this.f75524e.n);
                c.p.a.d.b.e.b.c("lp_app_dialog_click_detail", this.f75524e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f75525e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75525e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.p.a.d.b.e.a.a().c(this.f75525e.m);
                AppPrivacyPolicyActivity.a(this.f75525e.m, this.f75525e.n);
                c.p.a.d.b.e.b.c("lp_app_dialog_click_privacy", this.f75525e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f75526e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75526e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f75526e.dismiss();
                c.p.a.d.b.e.b.c("lp_app_dialog_click_giveup", this.f75526e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f75527e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75527e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.p.a.d.b.e.b.c("lp_app_dialog_click_download", this.f75527e.o);
                c.p.a.d.b.e.a.a().i(this.f75527e.o);
                this.f75527e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Activity activity, long j2) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = activity;
        this.n = j2;
        this.p = com.ss.android.downloadlib.addownload.compliance.c.a().get(Long.valueOf(j2));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f75516e = (TextView) findViewById(R.id.tv_app_name);
            this.f75517f = (TextView) findViewById(R.id.tv_app_version);
            this.f75518g = (TextView) findViewById(R.id.tv_app_developer);
            this.f75519h = (TextView) findViewById(R.id.tv_app_detail);
            this.f75520i = (TextView) findViewById(R.id.tv_app_privacy);
            this.f75521j = (TextView) findViewById(R.id.tv_give_up);
            this.k = (ClipImageView) findViewById(R.id.iv_app_icon);
            this.l = (LinearLayout) findViewById(R.id.ll_download);
            this.f75516e.setText(h.r.m(this.p.f34493d, "--"));
            TextView textView = this.f75517f;
            textView.setText("版本号：" + h.r.m(this.p.f34494e, "--"));
            TextView textView2 = this.f75518g;
            textView2.setText("开发者：" + h.r.m(this.p.f34495f, "应用信息正在完善中"));
            this.k.setRoundRadius(h.r.b(l.a(), 8.0f));
            this.k.setBackgroundColor(Color.parseColor("#EBEBEB"));
            com.ss.android.downloadlib.addownload.compliance.d.a().a(this.n, new b(this));
            this.f75519h.setOnClickListener(new c(this));
            this.f75520i.setOnClickListener(new d(this));
            this.f75521j.setOnClickListener(new e(this));
            this.l.setOnClickListener(new f(this));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dismiss();
            c.p.a.e.a.d.q(this.m);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.p == null) {
                dismiss();
                return;
            }
            requestWindowFeature(1);
            setContentView(R.layout.ttdownloader_dialog_appinfo);
            Window window = getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
            }
            setCancelable(true);
            setCanceledOnTouchOutside(true);
            this.o = this.p.f34491b;
            b();
            c.p.a.d.b.e.b.f("lp_app_dialog_show", this.o);
            setOnCancelListener(new DialogInterface$OnCancelListenerC2050a(this));
        }
    }
}
