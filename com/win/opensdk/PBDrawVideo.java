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
    public Context f76835a;

    /* renamed from: b  reason: collision with root package name */
    public e f76836b;

    /* renamed from: c  reason: collision with root package name */
    public PBDrawVideoListener f76837c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76838d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f76839e;

    /* renamed from: f  reason: collision with root package name */
    public l f76840f;

    /* renamed from: g  reason: collision with root package name */
    public File f76841g;

    /* renamed from: h  reason: collision with root package name */
    public VideoView f76842h;

    /* renamed from: i  reason: collision with root package name */
    public View f76843i;

    /* renamed from: j  reason: collision with root package name */
    public View f76844j;
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
        this.f76838d = false;
        this.f76839e = false;
        this.k = new p(this, Looper.getMainLooper());
        this.f76835a = context;
        try {
            U1.a(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f76836b = new e(context, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f76836b != null) {
                    N.a(this.f76836b.b(), 401, "");
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
                File file = new File(N.a(this.f76835a) + File.separator + "win" + File.separator + N.c(str) + ".mp4");
                this.f76841g = file;
                if (file == null || !file.exists()) {
                    if (this.f76840f != null && this.f76840f.getStatus() == AsyncTask.Status.RUNNING) {
                        this.f76840f.cancel(true);
                    }
                    l lVar = new l(this, str);
                    this.f76840f = lVar;
                    lVar.execute(str);
                } else if (this.f76837c == null || this.f76839e || this.f76837c == null || !this.f76841g.exists()) {
                } else {
                    this.f76837c.onLoaded();
                    this.f76838d = true;
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
                if (this.f76841g != null && !TextUtils.isEmpty(this.f76841g.getPath()) && (file = this.f76841g) != null) {
                    try {
                        File file2 = new File(file.getPath());
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.f76842h != null) {
                    this.f76842h.stopPlayback();
                    this.f76842h.setOnCompletionListener(null);
                    this.f76842h.setOnPreparedListener(null);
                    this.f76842h = null;
                }
                if (this.k != null) {
                    this.k.removeCallbacksAndMessages(null);
                    this.k = null;
                }
                if (this.f76840f != null && this.f76840f.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f76840f.cancel(false);
                    this.f76840f = null;
                }
                if (this.f76836b != null) {
                    Info b2 = this.f76836b.b();
                    if (b2 != null) {
                        Z0.a(this.f76835a).a(new a1(b2)).a();
                    }
                    this.f76836b.a();
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
            e eVar2 = this.f76836b;
            if ((eVar2 == null || (d0Var = eVar2.f77014a) == null || !d0Var.b()) ? false : true) {
                d0 d0Var2 = this.f76836b.f77014a;
                if (((d0Var2 == null || !d0Var2.b()) ? "" : d0Var2.f77000c.getLoad_type()).equals("video")) {
                    View inflate = LayoutInflater.from(this.f76835a).inflate(R.layout.win_layout_win_draw_video, (ViewGroup) null);
                    this.f76843i = inflate;
                    VideoView videoView = (VideoView) inflate.findViewById(R.id.win_ad_video_view);
                    this.f76842h = videoView;
                    videoView.setVisibility(0);
                    this.f76842h.setOnErrorListener(new m(this));
                    File file = this.f76841g;
                    if (file != null && !TextUtils.isEmpty(file.getPath()) && this.f76842h != null && !TextUtils.isEmpty(this.f76841g.getPath())) {
                        this.f76842h.setOnPreparedListener(new o(this));
                        this.f76842h.setVideoPath(this.f76841g.getPath());
                        this.f76842h.seekTo(0);
                        this.f76842h.requestFocus();
                        this.f76842h.start();
                        try {
                            if (this.f76836b != null) {
                                N.a(this.f76836b.b(), 401, "");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    View view = this.f76843i;
                    if (view != null) {
                        View findViewById = view.findViewById(R.id.win_layout_draw_ad_card);
                        this.f76844j = findViewById;
                        arrayList.add(findViewById);
                    }
                    if (this.f76843i != null && (eVar = this.f76836b) != null && (b2 = eVar.b()) != null) {
                        ((TextView) this.f76843i.findViewById(R.id.win_card_app_name)).setText(b2.getTitle());
                        ((TextView) this.f76843i.findViewById(R.id.win_card_app_desc)).setText(b2.getDesc());
                        ((TextView) this.f76843i.findViewById(R.id.win_card_h5_open_btn)).setText(b2.getBtndesc());
                        ImageView imageView = (ImageView) this.f76843i.findViewById(R.id.win_card_app_icon);
                        String icon = b2.getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            new n0(new q(this, imageView)).a(icon, false);
                        }
                    }
                    e eVar3 = this.f76836b;
                    View view2 = this.f76843i;
                    d0 d0Var3 = eVar3.f77014a;
                    if (d0Var3 != null) {
                        d0Var3.a(view2, null, arrayList);
                    }
                    Handler handler = this.k;
                    if (handler != null) {
                        handler.postDelayed(new n(this), 3000L);
                    }
                }
                return this.f76843i;
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
            if (!N.e(this.f76835a)) {
                PBDrawVideoListener pBDrawVideoListener = this.f76837c;
                if (pBDrawVideoListener != null) {
                    pBDrawVideoListener.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f76836b == null || (handler = this.k) == null) {
            } else {
                this.f76838d = false;
                this.f76839e = false;
                isdpl = false;
                Message obtain = Message.obtain();
                long e2 = U1.e(this.f76835a);
                if (e2 <= 10000) {
                    e2 = 10000;
                }
                handler.sendMessageDelayed(obtain, e2);
                d0 d0Var = this.f76836b.f77014a;
                if (d0Var == null || (m1Var = d0Var.f76999b) == null) {
                    return;
                }
                m1Var.b();
            }
        }
    }

    public void setDrawVideoListener(PBDrawVideoListener pBDrawVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pBDrawVideoListener) == null) {
            this.f76837c = pBDrawVideoListener;
            this.f76836b.f77015b = new h(this);
        }
    }
}
