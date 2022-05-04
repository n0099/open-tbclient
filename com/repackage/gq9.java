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
/* loaded from: classes6.dex */
public class gq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public es9 b;
    public hq9 c;
    public boolean d;
    public boolean e;
    public et9 f;
    public File g;
    public VideoView h;
    public View i;
    public View j;
    public Handler k;

    public gq9(Context context, String str) {
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
        this.k = new ut9(this, Looper.getMainLooper());
        this.a = context;
        try {
            mr9.c(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = new es9(context, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.b != null) {
                    wp9.o(this.b.b(), 401, "");
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
                File file = new File(wp9.e(this.a) + File.separator + "win" + File.separator + wp9.D(str) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                this.g = file;
                if (file == null || !file.exists()) {
                    if (this.f != null && this.f.getStatus() == AsyncTask.Status.RUNNING) {
                        this.f.cancel(true);
                    }
                    et9 et9Var = new et9(this, System.currentTimeMillis(), str);
                    this.f = et9Var;
                    et9Var.execute(str);
                } else if (this.c == null || this.e || this.c == null || !this.g.exists()) {
                } else {
                    yr9 a = cs9.a(this.a);
                    a.e(new gs9(this.b.b()), 201, 0L);
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
        this.h.setOnPreparedListener(new qt9(this));
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
                        yr9 a = cs9.a(this.a);
                        a.b(new gs9(b));
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
        es9 es9Var;
        Info b;
        ur9 ur9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            es9 es9Var2 = this.b;
            if ((es9Var2 == null || (ur9Var = es9Var2.a) == null || !ur9Var.e()) ? false : true) {
                ur9 ur9Var2 = this.b.a;
                if (((ur9Var2 == null || !ur9Var2.e()) ? "" : ur9Var2.c.getLoad_type()).equals("video")) {
                    View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08d1, (ViewGroup) null);
                    this.i = inflate;
                    VideoView videoView = (VideoView) inflate.findViewById(R.id.obfuscated_res_0x7f092451);
                    this.h = videoView;
                    videoView.setVisibility(0);
                    this.h.setOnErrorListener(new it9(this));
                    f();
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    View view2 = this.i;
                    if (view2 != null) {
                        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092460);
                        this.j = findViewById;
                        arrayList.add(findViewById);
                    }
                    if (this.i != null && (es9Var = this.b) != null && (b = es9Var.b()) != null) {
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092455)).setText(b.getTitle());
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092453)).setText(b.getDesc());
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092457)).setText(b.getBtndesc());
                        ImageView imageView = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f092454);
                        String icon = b.getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            new ft9(new yt9(this, imageView)).a(icon, false);
                        }
                    }
                    es9 es9Var3 = this.b;
                    View view3 = this.i;
                    ur9 ur9Var3 = es9Var3.a;
                    if (ur9Var3 != null) {
                        ur9Var3.b(view3, null, arrayList);
                    }
                    Handler handler = this.k;
                    if (handler != null) {
                        handler.postDelayed(new mt9(this), 3000L);
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
        au9 au9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!wp9.H(this.a)) {
                hq9 hq9Var = this.c;
                if (hq9Var != null) {
                    hq9Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.b == null || (handler = this.k) == null) {
            } else {
                this.d = false;
                this.e = false;
                Message obtain = Message.obtain();
                long u = mr9.u(this.a);
                if (u <= 10000) {
                    u = 10000;
                }
                handler.sendMessageDelayed(obtain, u);
                ur9 ur9Var = this.b.a;
                if (ur9Var == null || (au9Var = ur9Var.b) == null) {
                    return;
                }
                au9Var.g();
            }
        }
    }

    public void k(hq9 hq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hq9Var) == null) {
            this.c = hq9Var;
            this.b.b = new ps9(this);
        }
    }
}
