package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImageActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public QQToken f62770b;

    /* renamed from: c  reason: collision with root package name */
    public String f62771c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f62772d;

    /* renamed from: e  reason: collision with root package name */
    public c f62773e;

    /* renamed from: f  reason: collision with root package name */
    public Button f62774f;

    /* renamed from: g  reason: collision with root package name */
    public Button f62775g;

    /* renamed from: h  reason: collision with root package name */
    public b f62776h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62777i;

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f62778j;

    /* renamed from: k  reason: collision with root package name */
    public int f62779k;
    public boolean l;
    public long m;
    public int n;
    public final int o;
    public final int p;
    public Rect q;
    public String r;
    public Bitmap s;
    public final View.OnClickListener t;
    public final View.OnClickListener u;
    public final IUiListener v;
    public final IUiListener w;

    /* loaded from: classes4.dex */
    public class QQAvatarImp extends BaseApi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QQAvatarImp(ImageActivity imageActivity, QQToken qQToken) {
            super(qQToken);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageActivity, qQToken};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((QQToken) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageActivity;
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bitmap, iUiListener) == null) {
                Bundle a = a();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bitmap.recycle();
                BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, iUiListener);
                a.putByteArray("picture", byteArray);
                HttpUtils.requestAsync(this.f62800c, f.a(), "user/set_user_face", a, "POST", tempRequestListener);
                d.a().a(this.f62800c.getOpenId(), this.f62800c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", "19", "0");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageActivity imageActivity, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageActivity, context};
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
            this.a = imageActivity;
        }

        public void a(Button button) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, button) == null) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                Drawable b2 = this.a.b("com.tencent.plus.blue_normal.png");
                Drawable b3 = this.a.b("com.tencent.plus.blue_down.png");
                Drawable b4 = this.a.b("com.tencent.plus.blue_disable.png");
                stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b3);
                stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b2);
                stateListDrawable.addState(View.ENABLED_STATE_SET, b2);
                stateListDrawable.addState(View.FOCUSED_STATE_SET, b2);
                stateListDrawable.addState(View.EMPTY_STATE_SET, b4);
                button.setBackgroundDrawable(stateListDrawable);
            }
        }

        public void b(Button button) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, button) == null) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                Drawable b2 = this.a.b("com.tencent.plus.gray_normal.png");
                Drawable b3 = this.a.b("com.tencent.plus.gray_down.png");
                Drawable b4 = this.a.b("com.tencent.plus.gray_disable.png");
                stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b3);
                stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b2);
                stateListDrawable.addState(View.ENABLED_STATE_SET, b2);
                stateListDrawable.addState(View.FOCUSED_STATE_SET, b2);
                stateListDrawable.addState(View.EMPTY_STATE_SET, b4);
                button.setBackgroundDrawable(stateListDrawable);
            }
        }
    }

    public ImageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62779k = 0;
        this.l = false;
        this.m = 0L;
        this.n = 0;
        this.o = 640;
        this.p = 640;
        this.q = new Rect();
        this.t = new View.OnClickListener(this) { // from class: com.tencent.connect.avatar.ImageActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.a.f62778j.setVisibility(0);
                    this.a.f62775g.setEnabled(false);
                    this.a.f62775g.setTextColor(Color.rgb(21, 21, 21));
                    this.a.f62774f.setEnabled(false);
                    this.a.f62774f.setTextColor(Color.rgb(36, 94, 134));
                    new Thread(new Runnable(this) { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.a.a.c();
                            }
                        }
                    }).start();
                    if (this.a.l) {
                        this.a.a("10657", 0L);
                        return;
                    }
                    this.a.a("10655", System.currentTimeMillis() - this.a.m);
                    if (this.a.f62773e.f62784b) {
                        this.a.a("10654", 0L);
                    }
                }
            }
        };
        this.u = new View.OnClickListener(this) { // from class: com.tencent.connect.avatar.ImageActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.a.a("10656", System.currentTimeMillis() - this.a.m);
                    this.a.setResult(0);
                    this.a.d();
                }
            }
        };
        this.v = new DefaultUiListener(this) { // from class: com.tencent.connect.avatar.ImageActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
            public void onCancel() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    this.a.f62775g.setEnabled(true);
                    int i4 = -1;
                    this.a.f62775g.setTextColor(-1);
                    this.a.f62774f.setEnabled(true);
                    this.a.f62774f.setTextColor(-1);
                    this.a.f62778j.setVisibility(8);
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        i4 = jSONObject.getInt(Constants.KEYS.RET);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (i4 == 0) {
                        this.a.a("设置成功", 0);
                        this.a.a("10658", 0L);
                        d.a().a(this.a.f62770b.getOpenId(), this.a.f62770b.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, "12", "3", "0");
                        ImageActivity imageActivity = this.a;
                        if (imageActivity.f62771c != null && !"".equals(this.a.f62771c)) {
                            Intent intent = new Intent();
                            intent.setClassName(imageActivity, this.a.f62771c);
                            if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                                imageActivity.startActivity(intent);
                            }
                        }
                        this.a.a(0, jSONObject.toString(), null, null);
                        this.a.d();
                        return;
                    }
                    this.a.a("设置出错了，请重新登录再尝试下呢：）", 1);
                    d.a().a(this.a.f62770b.getOpenId(), this.a.f62770b.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, "12", "19", "1");
                }
            }

            @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                    this.a.f62775g.setEnabled(true);
                    this.a.f62775g.setTextColor(-1);
                    this.a.f62774f.setEnabled(true);
                    this.a.f62774f.setTextColor(-1);
                    this.a.f62774f.setText("重试");
                    this.a.f62778j.setVisibility(8);
                    this.a.l = true;
                    this.a.a(uiError.errorMessage, 1);
                    this.a.a("10660", 0L);
                }
            }
        };
        this.w = new DefaultUiListener(this) { // from class: com.tencent.connect.avatar.ImageActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            private void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(65537, this, i4) == null) || this.a.f62779k >= 2) {
                    return;
                }
                this.a.e();
            }

            @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
            public void onCancel() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    JSONObject jSONObject = (JSONObject) obj;
                    int i4 = -1;
                    try {
                        i4 = jSONObject.getInt(Constants.KEYS.RET);
                        if (i4 == 0) {
                            this.a.f62772d.post(new Runnable(this, jSONObject.getString("nickname")) { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ String a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass6 f62782b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr = {this, r7};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i5 = newInitContext2.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.f62782b = this;
                                    this.a = r7;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f62782b.a.c(this.a);
                                    }
                                }
                            });
                            this.a.a("10659", 0L);
                        } else {
                            this.a.a("10661", 0L);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (i4 != 0) {
                        a(i4);
                    }
                }
            }

            @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                    a(0);
                }
            }
        };
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setResult(0);
            d();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setRequestedOrientation(1);
            setContentView(a());
            this.f62772d = new Handler();
            Bundle bundleExtra = getIntent().getBundleExtra(com.tencent.connect.common.Constants.KEY_PARAMS);
            this.r = bundleExtra.getString("picture");
            this.f62771c = bundleExtra.getString("return_activity");
            String string = bundleExtra.getString("appid");
            String string2 = bundleExtra.getString("access_token");
            long j2 = bundleExtra.getLong("expires_in");
            String string3 = bundleExtra.getString("openid");
            this.n = bundleExtra.getInt("exitAnim");
            QQToken qQToken = new QQToken(string);
            this.f62770b = qQToken;
            qQToken.setAccessToken(string2, ((j2 - System.currentTimeMillis()) / 1000) + "");
            this.f62770b.setOpenId(string3);
            b();
            e();
            this.m = System.currentTimeMillis();
            a("10653", 0L);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.f62773e.setImageBitmap(null);
            Bitmap bitmap = this.s;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.s.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            Matrix imageMatrix = this.f62773e.getImageMatrix();
            float[] fArr = new float[9];
            imageMatrix.getValues(fArr);
            float f2 = fArr[2];
            float f3 = fArr[5];
            float f4 = fArr[0];
            float width = 640.0f / this.q.width();
            int i2 = (int) ((this.q.left - f2) / f4);
            int i3 = i2 < 0 ? 0 : i2;
            int i4 = (int) ((this.q.top - f3) / f4);
            int i5 = i4 < 0 ? 0 : i4;
            Matrix matrix = new Matrix();
            matrix.set(imageMatrix);
            matrix.postScale(width, width);
            int i6 = (int) (650.0f / f4);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.s, i3, i5, Math.min(this.s.getWidth() - i3, i6), Math.min(this.s.getHeight() - i5, i6), matrix, true);
                Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
                createBitmap.recycle();
                a(createBitmap2);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                a(com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, 1);
                a(-5, null, com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, e2.getMessage());
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            finish();
            int i2 = this.n;
            if (i2 != 0) {
                overridePendingTransition(0, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.f62779k++;
            new UserInfo(this, this.f62770b).getUserInfo(this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? l.a(str, this) : (Drawable) invokeL.objValue;
    }

    private void b() {
        Bitmap a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            try {
                a2 = a(this.r);
                this.s = a2;
            } catch (IOException e2) {
                e2.printStackTrace();
                a(com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, 1);
                a(-5, null, com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, e2.getMessage());
                d();
            }
            if (a2 != null) {
                this.f62773e.setImageBitmap(a2);
                this.f62774f.setOnClickListener(this.t);
                this.f62775g.setOnClickListener(this.u);
                this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.tencent.connect.avatar.ImageActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ImageActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            ImageActivity imageActivity = this.a;
                            imageActivity.q = imageActivity.f62776h.a();
                            this.a.f62773e.a(this.a.q);
                        }
                    }
                });
                return;
            }
            throw new IOException("cannot read picture: '" + this.r + "'!");
        }
    }

    private String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, this, str)) == null) ? str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&") : (String) invokeL.objValue;
    }

    private Bitmap a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            Uri parse = Uri.parse(str);
            InputStream openInputStream = getContentResolver().openInputStream(parse);
            if (openInputStream == null) {
                return null;
            }
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
            openInputStream.close();
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            while (i3 * i4 > 4194304) {
                i3 /= 2;
                i4 /= 2;
                i2 *= 2;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i2;
            try {
                return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, this, str, i2) == null) {
            Toast makeText = Toast.makeText(this, str, 1);
            LinearLayout linearLayout = (LinearLayout) makeText.getView();
            ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
            if (i2 == 0) {
                imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
            } else {
                imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
            }
            linearLayout.addView(imageView, 0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            makeText.setView(linearLayout);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    private View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.a = relativeLayout;
            relativeLayout.setLayoutParams(layoutParams);
            this.a.setBackgroundColor(-16777216);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setLayoutParams(layoutParams3);
            this.a.addView(relativeLayout2);
            c cVar = new c(this);
            this.f62773e = cVar;
            cVar.setLayoutParams(layoutParams2);
            this.f62773e.setScaleType(ImageView.ScaleType.MATRIX);
            relativeLayout2.addView(this.f62773e);
            this.f62776h = new b(this);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
            layoutParams4.addRule(14, -1);
            layoutParams4.addRule(15, -1);
            this.f62776h.setLayoutParams(layoutParams4);
            relativeLayout2.addView(this.f62776h);
            LinearLayout linearLayout = new LinearLayout(this);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
            layoutParams5.addRule(14, -1);
            linearLayout.setLayoutParams(layoutParams5);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            this.a.addView(linearLayout);
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
            imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
            linearLayout.addView(imageView);
            this.f62777i = new TextView(this);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
            layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
            this.f62777i.setLayoutParams(layoutParams6);
            this.f62777i.setEllipsize(TextUtils.TruncateAt.END);
            this.f62777i.setSingleLine();
            this.f62777i.setTextColor(-1);
            this.f62777i.setTextSize(24.0f);
            this.f62777i.setVisibility(8);
            linearLayout.addView(this.f62777i);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
            layoutParams7.addRule(12, -1);
            layoutParams7.addRule(9, -1);
            relativeLayout3.setLayoutParams(layoutParams7);
            relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
            int a2 = com.tencent.connect.avatar.a.a(this, 10.0f);
            relativeLayout3.setPadding(a2, a2, a2, 0);
            this.a.addView(relativeLayout3);
            a aVar = new a(this, this);
            int a3 = com.tencent.connect.avatar.a.a(this, 14.0f);
            int a4 = com.tencent.connect.avatar.a.a(this, 7.0f);
            this.f62775g = new Button(this);
            this.f62775g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
            this.f62775g.setText("取消");
            this.f62775g.setTextColor(-1);
            this.f62775g.setTextSize(18.0f);
            this.f62775g.setPadding(a3, a4, a3, a4);
            aVar.b(this.f62775g);
            relativeLayout3.addView(this.f62775g);
            this.f62774f = new Button(this);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
            layoutParams8.addRule(11, -1);
            this.f62774f.setLayoutParams(layoutParams8);
            this.f62774f.setTextColor(-1);
            this.f62774f.setTextSize(18.0f);
            this.f62774f.setPadding(a3, a4, a3, a4);
            this.f62774f.setText("选取");
            aVar.a(this.f62774f);
            relativeLayout3.addView(this.f62774f);
            TextView textView = new TextView(this);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
            layoutParams9.addRule(13, -1);
            textView.setLayoutParams(layoutParams9);
            textView.setText("移动和缩放");
            textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
            textView.setTextSize(18.0f);
            textView.setTextColor(-1);
            relativeLayout3.addView(textView);
            this.f62778j = new ProgressBar(this);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
            layoutParams10.addRule(14, -1);
            layoutParams10.addRule(15, -1);
            this.f62778j.setLayoutParams(layoutParams10);
            this.f62778j.setVisibility(8);
            this.a.addView(this.f62778j);
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            String d2 = d(str);
            if ("".equals(d2)) {
                return;
            }
            this.f62777i.setText(d2);
            this.f62777i.setVisibility(0);
        }
    }

    private void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bitmap) == null) {
            new QQAvatarImp(this, this.f62770b).setAvator(bitmap, this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, str, i2) == null) {
            this.f62772d.post(new Runnable(this, str, i2) { // from class: com.tencent.connect.avatar.ImageActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f62780b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ImageActivity f62781c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62781c = this;
                    this.a = str;
                    this.f62780b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62781c.b(this.a, this.f62780b);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            Intent intent = new Intent();
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_CODE, i2);
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_MSG, str2);
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_DETAIL, str3);
            intent.putExtra(com.tencent.connect.common.Constants.KEY_RESPONSE, str);
            setResult(-1, intent);
        }
    }

    public void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            l.a(this, str, j2, this.f62770b.getAppId());
        }
    }
}
