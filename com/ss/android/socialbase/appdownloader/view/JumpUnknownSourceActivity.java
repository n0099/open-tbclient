package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.e.a.d;
import d.l.a.e.a.e;
import d.l.a.e.a.k;
import d.l.a.e.a.l;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class JumpUnknownSourceActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.m f38565a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f38566b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Intent f38567c;

    /* renamed from: d  reason: collision with root package name */
    public int f38568d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f38569e;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JumpUnknownSourceActivity f38570e;

        public a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jumpUnknownSourceActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38570e = jumpUnknownSourceActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f38570e.f38567c != null) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = this.f38570e;
                    d.l.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f38567c, true);
                }
                d.l.a.e.a.c.w(this.f38570e.f38568d, this.f38570e.f38569e);
                this.f38570e.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JumpUnknownSourceActivity f38571e;

        public b(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jumpUnknownSourceActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38571e = jumpUnknownSourceActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (this.f38571e.f38567c != null) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = this.f38571e;
                    d.l.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f38567c, true);
                }
                d.l.a.e.a.c.w(this.f38571e.f38568d, this.f38571e.f38569e);
                this.f38571e.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JumpUnknownSourceActivity f38572e;

        public c(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jumpUnknownSourceActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38572e = jumpUnknownSourceActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = this.f38572e;
                if (d.l.a.e.a.c.n(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f38567c, this.f38572e.f38568d, this.f38572e.f38569e)) {
                    d.l.a.e.a.c.B(this.f38572e.f38568d, this.f38572e.f38569e);
                } else {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity2 = this.f38572e;
                    d.l.a.e.a.c.p(jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f38567c, true);
                }
                d.l.a.e.a.c.f(this.f38572e.f38568d, this.f38572e.f38569e);
                this.f38572e.finish();
            }
        }
    }

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
            k.d().f(this);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            k.d().f(this);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            Intent intent = getIntent();
            this.f38566b = intent;
            if (intent != null) {
                this.f38567c = (Intent) intent.getParcelableExtra("intent");
                this.f38568d = intent.getIntExtra("id", -1);
                try {
                    this.f38569e = new JSONObject(intent.getStringExtra("config"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f38569e == null) {
                d.q(this);
                return;
            }
            b();
            d.m mVar = this.f38565a;
            if (mVar != null && !mVar.b()) {
                this.f38565a.a();
            } else if (this.f38565a == null) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f38565a == null && this.f38566b != null) {
            try {
                d.e b2 = e.G().b();
                d.n a2 = b2 != null ? b2.a(this) : null;
                if (a2 == null) {
                    a2 = new e.C2036e(this);
                }
                int a3 = l.a(this, "tt_appdownloader_tip");
                int a4 = l.a(this, "tt_appdownloader_label_ok");
                int a5 = l.a(this, "tt_appdownloader_label_cancel");
                String optString = this.f38569e.optString("jump_unknown_source_tips");
                if (TextUtils.isEmpty(optString)) {
                    optString = getString(l.a(this, "tt_appdownloader_jump_unknown_source_tips"));
                }
                a2.a(a3).a(optString).b(a4, new c(this)).a(a5, new b(this)).c(new a(this)).a(false);
                this.f38565a = a2.a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
