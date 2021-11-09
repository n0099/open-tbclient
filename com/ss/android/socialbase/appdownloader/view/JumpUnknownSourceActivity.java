package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.appdownloader.i;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class JumpUnknownSourceActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public k f69063a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f69064b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Intent f69065c;

    /* renamed from: d  reason: collision with root package name */
    public int f69066d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f69067e;

    public JumpUnknownSourceActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            a();
            h.a().a(this);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            h.a().a(this);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            Intent intent = getIntent();
            this.f69064b = intent;
            if (intent != null) {
                this.f69065c = (Intent) intent.getParcelableExtra("intent");
                this.f69066d = intent.getIntExtra("id", -1);
                try {
                    this.f69067e = new JSONObject(intent.getStringExtra(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f69067e == null) {
                c.a((Activity) this);
                return;
            }
            b();
            k kVar = this.f69063a;
            if (kVar != null && !kVar.b()) {
                this.f69063a.a();
            } else if (this.f69063a == null) {
                finish();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f69063a == null && this.f69064b != null) {
            try {
                com.ss.android.socialbase.appdownloader.c.c a2 = d.j().a();
                l a3 = a2 != null ? a2.a(this) : null;
                if (a3 == null) {
                    a3 = new com.ss.android.socialbase.appdownloader.d.a(this);
                }
                int a4 = i.a(this, "tt_appdownloader_tip");
                int a5 = i.a(this, "tt_appdownloader_label_ok");
                int a6 = i.a(this, "tt_appdownloader_label_cancel");
                String optString = this.f69067e.optString("jump_unknown_source_tips");
                if (TextUtils.isEmpty(optString)) {
                    optString = getString(i.a(this, "tt_appdownloader_jump_unknown_source_tips"));
                }
                a3.a(a4).a(optString).a(a5, new DialogInterface.OnClickListener(this) { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JumpUnknownSourceActivity f69070a;

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
                        this.f69070a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            JumpUnknownSourceActivity jumpUnknownSourceActivity = this.f69070a;
                            if (b.a(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f69065c, this.f69070a.f69066d, this.f69070a.f69067e)) {
                                b.c(this.f69070a.f69066d, this.f69070a.f69067e);
                            } else {
                                JumpUnknownSourceActivity jumpUnknownSourceActivity2 = this.f69070a;
                                b.a((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f69065c, true);
                            }
                            b.a(this.f69070a.f69066d, this.f69070a.f69067e);
                            this.f69070a.finish();
                        }
                    }
                }).b(a6, new DialogInterface.OnClickListener(this) { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JumpUnknownSourceActivity f69069a;

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
                        this.f69069a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            if (this.f69069a.f69065c != null) {
                                JumpUnknownSourceActivity jumpUnknownSourceActivity = this.f69069a;
                                b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f69065c, true);
                            }
                            b.b(this.f69069a.f69066d, this.f69069a.f69067e);
                            this.f69069a.finish();
                        }
                    }
                }).a(new DialogInterface.OnCancelListener(this) { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JumpUnknownSourceActivity f69068a;

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
                        this.f69068a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            if (this.f69068a.f69065c != null) {
                                JumpUnknownSourceActivity jumpUnknownSourceActivity = this.f69068a;
                                b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f69065c, true);
                            }
                            b.b(this.f69068a.f69066d, this.f69068a.f69067e);
                            this.f69068a.finish();
                        }
                    }
                }).a(false);
                this.f69063a = a3.a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
