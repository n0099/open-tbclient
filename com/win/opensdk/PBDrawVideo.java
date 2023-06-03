package com.win.opensdk;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.win.opensdk.core.Info;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class PBDrawVideo implements g {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isdpl;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public e c;
    public PBDrawVideoListener d;
    public boolean e;
    public boolean f;
    public l g;
    public File h;
    public VideoView i;
    public View j;
    public View k;
    public Handler l;

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.c != null) {
                    M.a(this.c.b(), 401, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(M.a(this.a) + File.separator + "win" + File.separator + M.c(str) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                this.h = file;
                if (file == null || !file.exists()) {
                    if (this.g != null && this.g.getStatus() == AsyncTask.Status.RUNNING) {
                        this.g.cancel(true);
                    }
                    l lVar = new l(this, System.currentTimeMillis(), str);
                    this.g = lVar;
                    lVar.execute(str);
                } else if (this.d == null || this.f || this.d == null || !this.h.exists()) {
                } else {
                    e1.a(this.a).a(new f1(this.c.b()), 201, 0L).a();
                    this.d.onLoaded();
                    this.e = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void playVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
        }
    }

    public void stopVideo() {
        VideoView videoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoView = this.i) == null) {
            return;
        }
        try {
            videoView.stopPlayback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PBDrawVideo(Context context, String str) {
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
        this.e = false;
        this.f = false;
        this.l = new p(this, Looper.getMainLooper());
        this.a = context;
        this.b = str;
        try {
            Z1.a(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c = new e(context, str);
    }

    public final void b() {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (file = this.h) != null && !TextUtils.isEmpty(file.getPath()) && this.i != null && !TextUtils.isEmpty(this.h.getPath())) {
            this.i.setOnPreparedListener(new o(this));
            this.i.setVideoPath(this.h.getPath());
            this.i.seekTo(0);
            this.i.requestFocus();
            this.i.start();
            a();
        }
    }

    public void load() {
        Handler handler;
        r1 r1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!M.e(this.a)) {
                PBDrawVideoListener pBDrawVideoListener = this.d;
                if (pBDrawVideoListener != null) {
                    pBDrawVideoListener.onFail(PBError.NO_NETWORK);
                }
            } else if (this.c != null && (handler = this.l) != null) {
                this.e = false;
                this.f = false;
                isdpl = false;
                Message obtain = Message.obtain();
                long e = Z1.e(this.a);
                if (e <= 10000) {
                    e = 10000;
                }
                handler.sendMessageDelayed(obtain, e);
                c0 c0Var = this.c.a;
                if (c0Var != null && (r1Var = c0Var.b) != null) {
                    r1Var.b();
                }
            }
        }
    }

    public void destroy() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.h != null && !TextUtils.isEmpty(this.h.getPath()) && (file = this.h) != null) {
                    try {
                        File file2 = new File(file.getPath());
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (this.i != null) {
                    this.i.stopPlayback();
                    this.i.setOnCompletionListener(null);
                    this.i.setOnPreparedListener(null);
                    this.i = null;
                }
                if (this.l != null) {
                    this.l.removeCallbacksAndMessages(null);
                    this.l = null;
                }
                if (this.g != null && this.g.getStatus() == AsyncTask.Status.RUNNING) {
                    this.g.cancel(false);
                    this.g = null;
                }
                if (this.c != null) {
                    Info b = this.c.b();
                    if (b != null) {
                        e1.a(this.a).a(new f1(b)).a();
                    }
                    this.c.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public View getDrawVideoView() {
        InterceptResult invokeV;
        boolean z;
        String str;
        e eVar;
        Info b;
        c0 c0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar2 = this.c;
            if (eVar2 != null && (c0Var = eVar2.a) != null && c0Var.b()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return null;
            }
            c0 c0Var2 = this.c.a;
            if (c0Var2 != null && c0Var2.b()) {
                str = c0Var2.c.getLoad_type();
            } else {
                str = "";
            }
            if (str.equals("video")) {
                View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d09fb, (ViewGroup) null);
                this.j = inflate;
                VideoView videoView = (VideoView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092953);
                this.i = videoView;
                videoView.setVisibility(0);
                this.i.setOnErrorListener(new m(this));
                b();
                ArrayList arrayList = new ArrayList();
                arrayList.clear();
                View view2 = this.j;
                if (view2 != null) {
                    View findViewById = view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092962);
                    this.k = findViewById;
                    arrayList.add(findViewById);
                }
                if (this.j != null && (eVar = this.c) != null && (b = eVar.b()) != null) {
                    ((TextView) this.j.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092957)).setText(b.getTitle());
                    ((TextView) this.j.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092955)).setText(b.getDesc());
                    ((TextView) this.j.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092959)).setText(b.getBtndesc());
                    ImageView imageView = (ImageView) this.j.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092956);
                    String icon = b.getIcon();
                    if (!TextUtils.isEmpty(icon)) {
                        new m0(new q(this, imageView)).a(icon, false);
                    }
                }
                e eVar3 = this.c;
                View view3 = this.j;
                c0 c0Var3 = eVar3.a;
                if (c0Var3 != null) {
                    c0Var3.a(view3, null, arrayList);
                }
                Handler handler = this.l;
                if (handler != null) {
                    handler.postDelayed(new n(this), 3000L);
                }
            }
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public void setDrawVideoListener(PBDrawVideoListener pBDrawVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pBDrawVideoListener) == null) {
            this.d = pBDrawVideoListener;
            this.c.b = new h(this);
        }
    }
}
