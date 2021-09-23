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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class PBDrawVideo implements r {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isdpl;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f77154a;

    /* renamed from: b  reason: collision with root package name */
    public e f77155b;

    /* renamed from: c  reason: collision with root package name */
    public PBDrawVideoListener f77156c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f77157d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f77158e;

    /* renamed from: f  reason: collision with root package name */
    public l f77159f;

    /* renamed from: g  reason: collision with root package name */
    public File f77160g;

    /* renamed from: h  reason: collision with root package name */
    public VideoView f77161h;

    /* renamed from: i  reason: collision with root package name */
    public View f77162i;

    /* renamed from: j  reason: collision with root package name */
    public View f77163j;
    public Handler k;

    public PBDrawVideo(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77157d = false;
        this.f77158e = false;
        this.k = new p(this, Looper.getMainLooper());
        this.f77154a = context;
        try {
            U1.a(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f77155b = new e(context, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f77155b != null) {
                    N.a(this.f77155b.b(), 401, "");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(N.a(this.f77154a) + File.separator + "win" + File.separator + N.c(str) + ".mp4");
                this.f77160g = file;
                if (file == null || !file.exists()) {
                    if (this.f77159f != null && this.f77159f.getStatus() == AsyncTask.Status.RUNNING) {
                        this.f77159f.cancel(true);
                    }
                    l lVar = new l(this, str);
                    this.f77159f = lVar;
                    lVar.execute(str);
                } else if (this.f77156c == null || this.f77158e || this.f77156c == null || !this.f77160g.exists()) {
                } else {
                    this.f77156c.onLoaded();
                    this.f77157d = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void destroy() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.f77160g != null && !TextUtils.isEmpty(this.f77160g.getPath()) && (file = this.f77160g) != null) {
                    try {
                        File file2 = new File(file.getPath());
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.f77161h != null) {
                    this.f77161h.stopPlayback();
                    this.f77161h.setOnCompletionListener(null);
                    this.f77161h.setOnPreparedListener(null);
                    this.f77161h = null;
                }
                if (this.k != null) {
                    this.k.removeCallbacksAndMessages(null);
                    this.k = null;
                }
                if (this.f77159f != null && this.f77159f.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f77159f.cancel(false);
                    this.f77159f = null;
                }
                if (this.f77155b != null) {
                    Info b2 = this.f77155b.b();
                    if (b2 != null) {
                        Z0.a(this.f77154a).a(new a1(b2)).a();
                    }
                    this.f77155b.a();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public View getDrawVideoView() {
        InterceptResult invokeV;
        e eVar;
        Info b2;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            e eVar2 = this.f77155b;
            if ((eVar2 == null || (d0Var = eVar2.f77333a) == null || !d0Var.b()) ? false : true) {
                d0 d0Var2 = this.f77155b.f77333a;
                if (((d0Var2 == null || !d0Var2.b()) ? "" : d0Var2.f77319c.getLoad_type()).equals("video")) {
                    View inflate = LayoutInflater.from(this.f77154a).inflate(R.layout.win_layout_win_draw_video, (ViewGroup) null);
                    this.f77162i = inflate;
                    VideoView videoView = (VideoView) inflate.findViewById(R.id.win_ad_video_view);
                    this.f77161h = videoView;
                    videoView.setVisibility(0);
                    this.f77161h.setOnErrorListener(new m(this));
                    File file = this.f77160g;
                    if (file != null && !TextUtils.isEmpty(file.getPath()) && this.f77161h != null && !TextUtils.isEmpty(this.f77160g.getPath())) {
                        this.f77161h.setOnPreparedListener(new o(this));
                        this.f77161h.setVideoPath(this.f77160g.getPath());
                        this.f77161h.seekTo(0);
                        this.f77161h.requestFocus();
                        this.f77161h.start();
                        try {
                            if (this.f77155b != null) {
                                N.a(this.f77155b.b(), 401, "");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    View view = this.f77162i;
                    if (view != null) {
                        View findViewById = view.findViewById(R.id.win_layout_draw_ad_card);
                        this.f77163j = findViewById;
                        arrayList.add(findViewById);
                    }
                    if (this.f77162i != null && (eVar = this.f77155b) != null && (b2 = eVar.b()) != null) {
                        ((TextView) this.f77162i.findViewById(R.id.win_card_app_name)).setText(b2.getTitle());
                        ((TextView) this.f77162i.findViewById(R.id.win_card_app_desc)).setText(b2.getDesc());
                        ((TextView) this.f77162i.findViewById(R.id.win_card_h5_open_btn)).setText(b2.getBtndesc());
                        ImageView imageView = (ImageView) this.f77162i.findViewById(R.id.win_card_app_icon);
                        String icon = b2.getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            new n0(new q(this, imageView)).a(icon, false);
                        }
                    }
                    e eVar3 = this.f77155b;
                    View view2 = this.f77162i;
                    d0 d0Var3 = eVar3.f77333a;
                    if (d0Var3 != null) {
                        d0Var3.a(view2, null, arrayList);
                    }
                    Handler handler = this.k;
                    if (handler != null) {
                        handler.postDelayed(new n(this), 3000L);
                    }
                }
                return this.f77162i;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void load() {
        Handler handler;
        m1 m1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!N.e(this.f77154a)) {
                PBDrawVideoListener pBDrawVideoListener = this.f77156c;
                if (pBDrawVideoListener != null) {
                    pBDrawVideoListener.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f77155b == null || (handler = this.k) == null) {
            } else {
                this.f77157d = false;
                this.f77158e = false;
                isdpl = false;
                Message obtain = Message.obtain();
                long e2 = U1.e(this.f77154a);
                if (e2 <= 10000) {
                    e2 = 10000;
                }
                handler.sendMessageDelayed(obtain, e2);
                d0 d0Var = this.f77155b.f77333a;
                if (d0Var == null || (m1Var = d0Var.f77318b) == null) {
                    return;
                }
                m1Var.b();
            }
        }
    }

    public void setDrawVideoListener(PBDrawVideoListener pBDrawVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pBDrawVideoListener) == null) {
            this.f77156c = pBDrawVideoListener;
            this.f77155b.f77334b = new h(this);
        }
    }
}
