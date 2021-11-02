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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.downloadlib.guide.install.ClipImageView;
/* loaded from: classes2.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f68567a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f68568b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f68569c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f68570d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f68571e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f68572f;

    /* renamed from: g  reason: collision with root package name */
    public ClipImageView f68573g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f68574h;

    /* renamed from: i  reason: collision with root package name */
    public Activity f68575i;
    public final long j;
    public long k;
    public final com.ss.android.downloadlib.addownload.b.b l;

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
        this.f68575i = activity;
        this.j = j;
        this.l = c.a().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
            com.ss.android.socialbase.appdownloader.c.a(this.f68575i);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.l == null) {
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
            this.k = this.l.f68488b;
            a();
            e.b("lp_app_dialog_show", this.k);
            setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68576a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68576a = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        e.a("lp_app_dialog_cancel", this.f68576a.k);
                    }
                }
            });
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f68567a = (TextView) findViewById(R.id.tv_app_name);
            this.f68568b = (TextView) findViewById(R.id.tv_app_version);
            this.f68569c = (TextView) findViewById(R.id.tv_app_developer);
            this.f68570d = (TextView) findViewById(R.id.tv_app_detail);
            this.f68571e = (TextView) findViewById(R.id.tv_app_privacy);
            this.f68572f = (TextView) findViewById(R.id.tv_give_up);
            this.f68573g = (ClipImageView) findViewById(R.id.iv_app_icon);
            this.f68574h = (LinearLayout) findViewById(R.id.ll_download);
            this.f68567a.setText(l.a(this.l.f68491e, "--"));
            TextView textView = this.f68568b;
            textView.setText("版本号：" + l.a(this.l.f68492f, "--"));
            TextView textView2 = this.f68569c;
            textView2.setText("开发者：" + l.a(this.l.f68493g, "应用信息正在完善中"));
            this.f68573g.setRoundRadius(l.a(j.getContext(), 8.0f));
            this.f68573g.setBackgroundColor(Color.parseColor("#EBEBEB"));
            d.a().a(this.j, new d.a(this) { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68577a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68577a = this;
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.d.a
                public void a(Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                        if (bitmap != null) {
                            this.f68577a.f68573g.setImageBitmap(bitmap);
                        } else {
                            e.a(8, this.f68577a.k);
                        }
                    }
                }
            });
            this.f68570d.setOnClickListener(new View.OnClickListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68578a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68578a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        b.a().a(this.f68578a.f68575i);
                        AppDetailInfoActivity.a(this.f68578a.f68575i, this.f68578a.j);
                        e.a("lp_app_dialog_click_detail", this.f68578a.k);
                    }
                }
            });
            this.f68571e.setOnClickListener(new View.OnClickListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68579a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68579a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        b.a().a(this.f68579a.f68575i);
                        AppPrivacyPolicyActivity.a(this.f68579a.f68575i, this.f68579a.j);
                        e.a("lp_app_dialog_click_privacy", this.f68579a.k);
                    }
                }
            });
            this.f68572f.setOnClickListener(new View.OnClickListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68580a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68580a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f68580a.dismiss();
                        e.a("lp_app_dialog_click_giveup", this.f68580a.k);
                    }
                }
            });
            this.f68574h.setOnClickListener(new View.OnClickListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68581a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68581a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e.a("lp_app_dialog_click_download", this.f68581a.k);
                        b.a().b(this.f68581a.k);
                        this.f68581a.dismiss();
                    }
                }
            });
        }
    }
}
