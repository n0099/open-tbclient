package com.repackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class cm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ao9 b;
    public dm9 c;
    public boolean d;
    public boolean e;
    public ap9 f;
    public File g;
    public VideoView h;
    public View i;
    public View j;
    public Handler k;

    public cm9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.k = new qp9(this, Looper.getMainLooper());
        this.a = context;
        try {
            in9.c(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = new ao9(context, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.b != null) {
                    sl9.o(this.b.b(), 401, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(sl9.e(this.a) + File.separator + "win" + File.separator + sl9.D(str) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                this.g = file;
                if (file == null || !file.exists()) {
                    if (this.f != null && this.f.getStatus() == AsyncTask.Status.RUNNING) {
                        this.f.cancel(true);
                    }
                    ap9 ap9Var = new ap9(this, System.currentTimeMillis(), str);
                    this.f = ap9Var;
                    ap9Var.execute(str);
                } else if (this.c == null || this.e || this.c == null || !this.g.exists()) {
                } else {
                    un9 a = yn9.a(this.a);
                    a.e(new co9(this.b.b()), 201, 0L);
                    a.m();
                    this.c.onLoaded();
                    this.d = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void f() {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (file = this.g) == null || TextUtils.isEmpty(file.getPath()) || this.h == null || TextUtils.isEmpty(this.g.getPath())) {
            return;
        }
        this.h.setOnPreparedListener(new mp9(this));
        this.h.setVideoPath(this.g.getPath());
        this.h.seekTo(0);
        this.h.requestFocus();
        this.h.start();
        a();
    }

    public void h() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.g != null && !TextUtils.isEmpty(this.g.getPath()) && (file = this.g) != null) {
                    try {
                        File file2 = new File(file.getPath());
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (this.h != null) {
                    this.h.stopPlayback();
                    this.h.setOnCompletionListener(null);
                    this.h.setOnPreparedListener(null);
                    this.h = null;
                }
                if (this.k != null) {
                    this.k.removeCallbacksAndMessages(null);
                    this.k = null;
                }
                if (this.f != null && this.f.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f.cancel(false);
                    this.f = null;
                }
                if (this.b != null) {
                    Info b = this.b.b();
                    if (b != null) {
                        un9 a = yn9.a(this.a);
                        a.b(new co9(b));
                        a.m();
                    }
                    this.b.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public View i() {
        InterceptResult invokeV;
        ao9 ao9Var;
        Info b;
        qn9 qn9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ao9 ao9Var2 = this.b;
            if ((ao9Var2 == null || (qn9Var = ao9Var2.a) == null || !qn9Var.e()) ? false : true) {
                qn9 qn9Var2 = this.b.a;
                if (((qn9Var2 == null || !qn9Var2.e()) ? "" : qn9Var2.c.getLoad_type()).equals("video")) {
                    View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08b8, (ViewGroup) null);
                    this.i = inflate;
                    VideoView videoView = (VideoView) inflate.findViewById(R.id.obfuscated_res_0x7f092434);
                    this.h = videoView;
                    videoView.setVisibility(0);
                    this.h.setOnErrorListener(new ep9(this));
                    f();
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    View view2 = this.i;
                    if (view2 != null) {
                        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092443);
                        this.j = findViewById;
                        arrayList.add(findViewById);
                    }
                    if (this.i != null && (ao9Var = this.b) != null && (b = ao9Var.b()) != null) {
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092438)).setText(b.getTitle());
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092436)).setText(b.getDesc());
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09243a)).setText(b.getBtndesc());
                        ImageView imageView = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f092437);
                        String icon = b.getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            new bp9(new up9(this, imageView)).a(icon, false);
                        }
                    }
                    ao9 ao9Var3 = this.b;
                    View view3 = this.i;
                    qn9 qn9Var3 = ao9Var3.a;
                    if (qn9Var3 != null) {
                        qn9Var3.b(view3, null, arrayList);
                    }
                    Handler handler = this.k;
                    if (handler != null) {
                        handler.postDelayed(new ip9(this), 3000L);
                    }
                }
                return this.i;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void j() {
        Handler handler;
        wp9 wp9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!sl9.H(this.a)) {
                dm9 dm9Var = this.c;
                if (dm9Var != null) {
                    dm9Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.b == null || (handler = this.k) == null) {
            } else {
                this.d = false;
                this.e = false;
                Message obtain = Message.obtain();
                long u = in9.u(this.a);
                if (u <= 10000) {
                    u = 10000;
                }
                handler.sendMessageDelayed(obtain, u);
                qn9 qn9Var = this.b.a;
                if (qn9Var == null || (wp9Var = qn9Var.b) == null) {
                    return;
                }
                wp9Var.g();
            }
        }
    }

    public void k(dm9 dm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dm9Var) == null) {
            this.c = dm9Var;
            this.b.b = new lo9(this);
        }
    }
}
