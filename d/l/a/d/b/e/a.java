package d.l.a.d.b.e;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.adhost.R;
import com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity;
import com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import d.l.a.d.b.c;
import d.l.a.d.b.l;
import d.l.a.d.h;
/* loaded from: classes10.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74256e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74257f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f74258g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f74259h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f74260i;
    public TextView j;
    public ClipImageView k;
    public LinearLayout l;
    public Activity m;
    public final long n;
    public long o;
    public final c.C2049c p;

    /* renamed from: d.l.a.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class DialogInterface$OnCancelListenerC2052a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f74261e;

        public DialogInterface$OnCancelListenerC2052a(a aVar) {
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
            this.f74261e = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                d.l.a.d.b.e.c.c("lp_app_dialog_cancel", this.f74261e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f74262a;

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
            this.f74262a = aVar;
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.d.c
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                if (bitmap != null) {
                    this.f74262a.k.setImageBitmap(bitmap);
                } else {
                    d.l.a.d.b.e.c.a(8, this.f74262a.o);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f74263e;

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
            this.f74263e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.l.a.d.b.e.b.a().c(this.f74263e.m);
                AppDetailInfoActivity.a(this.f74263e.m, this.f74263e.n);
                d.l.a.d.b.e.c.c("lp_app_dialog_click_detail", this.f74263e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f74264e;

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
            this.f74264e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.l.a.d.b.e.b.a().c(this.f74264e.m);
                AppPrivacyPolicyActivity.a(this.f74264e.m, this.f74264e.n);
                d.l.a.d.b.e.c.c("lp_app_dialog_click_privacy", this.f74264e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f74265e;

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
            this.f74265e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f74265e.dismiss();
                d.l.a.d.b.e.c.c("lp_app_dialog_click_giveup", this.f74265e.o);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f74266e;

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
            this.f74266e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.l.a.d.b.e.c.c("lp_app_dialog_click_download", this.f74266e.o);
                d.l.a.d.b.e.b.a().i(this.f74266e.o);
                this.f74266e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Activity activity, long j) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Long.valueOf(j)};
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
        this.n = j;
        this.p = com.ss.android.downloadlib.addownload.compliance.c.a().get(Long.valueOf(j));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f74256e = (TextView) findViewById(R.id.tv_app_name);
            this.f74257f = (TextView) findViewById(R.id.tv_app_version);
            this.f74258g = (TextView) findViewById(R.id.tv_app_developer);
            this.f74259h = (TextView) findViewById(R.id.tv_app_detail);
            this.f74260i = (TextView) findViewById(R.id.tv_app_privacy);
            this.j = (TextView) findViewById(R.id.tv_give_up);
            this.k = (ClipImageView) findViewById(R.id.iv_app_icon);
            this.l = (LinearLayout) findViewById(R.id.ll_download);
            this.f74256e.setText(h.r.m(this.p.f74205d, "--"));
            TextView textView = this.f74257f;
            textView.setText("版本号：" + h.r.m(this.p.f74206e, "--"));
            TextView textView2 = this.f74258g;
            textView2.setText("开发者：" + h.r.m(this.p.f74207f, "应用信息正在完善中"));
            this.k.setRoundRadius(h.r.b(l.a(), 8.0f));
            this.k.setBackgroundColor(Color.parseColor("#EBEBEB"));
            com.ss.android.downloadlib.addownload.compliance.d.a().a(this.n, new b(this));
            this.f74259h.setOnClickListener(new c(this));
            this.f74260i.setOnClickListener(new d(this));
            this.j.setOnClickListener(new e(this));
            this.l.setOnClickListener(new f(this));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dismiss();
            d.l.a.e.a.d.q(this.m);
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
            this.o = this.p.f74203b;
            b();
            d.l.a.d.b.e.c.f("lp_app_dialog_show", this.o);
            setOnCancelListener(new DialogInterface$OnCancelListenerC2052a(this));
        }
    }
}
