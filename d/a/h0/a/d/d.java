package d.a.h0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.player.AdVideoView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.h0.a.i.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.h0.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean U;
    public static boolean V;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoView N;
    public AtomicInteger O;
    public f P;
    public volatile boolean Q;
    public d.a.h0.a.i.a R;
    public a.InterfaceC0603a S;
    public a.b T;

    /* loaded from: classes7.dex */
    public class a implements d.a.h0.a.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42475a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42475a = dVar;
        }

        @Override // d.a.h0.a.i.a
        public void playCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42475a.W("time_end");
            }
        }

        @Override // d.a.h0.a.i.a
        public void playFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f42475a.W("video_onError");
            }
        }

        @Override // d.a.h0.a.i.a
        public void playPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f42475a.Z();
            }
        }

        @Override // d.a.h0.a.i.a
        public void playResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f42475a.a0();
            }
        }

        @Override // d.a.h0.a.i.a
        public void renderingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    this.f42475a.b0();
                    AdVideoView adVideoView = this.f42475a.N;
                    adVideoView.getLayoutParams().width = -1;
                    adVideoView.getLayoutParams().height = -1;
                    d.super.y();
                    this.f42475a.G();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.InterfaceC0603a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42476a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42476a = dVar;
        }

        @Override // d.a.h0.a.i.a.InterfaceC0603a
        public void onDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f42476a.N != null) {
                        AdVideoView adVideoView = this.f42476a.N;
                        adVideoView.getLayoutParams().width = 1;
                        adVideoView.getLayoutParams().height = 1;
                    }
                    if (this.f42476a.n != null) {
                        this.f42476a.n.setVisibility(8);
                    }
                    if (this.f42476a.f42445c != null) {
                        this.f42476a.f42445c.setVisibility(8);
                    }
                    if (this.f42476a.f42446d != null) {
                        this.f42476a.f42446d.setVisibility(8);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42477a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42477a = dVar;
        }

        @Override // d.a.h0.a.i.a.b
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42477a.V();
            }
        }
    }

    /* renamed from: d.a.h0.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC0601d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f42478e;

        public View$OnClickListenerC0601d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42478e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42478e.C();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f42479e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42479e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42479e.E();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends d.a.h0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final WeakReference<d> f42480g;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42480g = new WeakReference<>(dVar);
        }

        @Override // d.a.h0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d dVar = this.f42480g.get();
                if (!d.U.get() || dVar == null || dVar.N == null || dVar.f42447e == null) {
                    return null;
                }
                int currentPosition = dVar.N.getCurrentPosition();
                int duration = dVar.N.getDuration();
                dVar.f42447e.e(duration, duration - currentPosition);
                return null;
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-77841454, "Ld/a/h0/a/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-77841454, "Ld/a/h0/a/d/d;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.O = new AtomicInteger(0);
        this.Q = false;
        this.R = new a(this);
        this.S = new b(this);
        this.T = new c(this);
        this.s = "video";
        try {
            AdVideoView adVideoView = new AdVideoView(this.f42443a);
            this.N = adVideoView;
            if (this.G == 17) {
                adVideoView.setDisplayMode(7);
            } else {
                adVideoView.setDisplayMode(2);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
            layoutParams.addRule(13);
            j(this.N, layoutParams);
            this.N.setAdVideoViewListener(this.R);
            this.N.setDestroyedListener(this.S);
            this.N.setPreparedListener(this.T);
            this.N.B();
            this.N.n();
            this.N.setVideoMute(true);
            this.N.setVideoUrl(Y());
        } catch (Exception e2) {
            W("video_container_excepiton_constructor_" + e2.toString());
        }
    }

    @Override // d.a.h0.a.d.a
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.M();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.O.incrementAndGet() == 2) {
                    d.a.h0.a.k.a.a(new e(this));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            c0();
            V = false;
            super.u(str);
        }
    }

    public Bitmap X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdVideoView adVideoView = this.N;
            long currentPosition = adVideoView != null ? adVideoView.getCurrentPosition() : 1L;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(this.f42443a, Uri.parse(Y()));
                            long j = currentPosition * 1000;
                            r3 = j > 0 ? mediaMetadataRetriever.getFrameAtTime(j, 3) : null;
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e2) {
                            e2.fillInStackTrace();
                        }
                    } catch (RuntimeException e3) {
                        this.f42448f.d(e3);
                        mediaMetadataRetriever.release();
                    }
                } catch (IllegalArgumentException e4) {
                    this.f42448f.d(e4);
                    mediaMetadataRetriever.release();
                }
                return r3;
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e5) {
                    e5.fillInStackTrace();
                }
                throw th;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String b2 = this.f42451i.b(this.u, MaterialLoader.MaterialCacheType.VIDEO);
            return TextUtils.isEmpty(b2) ? this.u : b2;
        }
        return (String) invokeV.objValue;
    }

    public final void Z() {
        AtomicBoolean atomicBoolean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (atomicBoolean = U) == null) {
            return;
        }
        atomicBoolean.compareAndSet(true, false);
    }

    @Override // d.a.h0.a.d.a, d.a.h0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.a();
            this.N.setOnClickListener(new View$OnClickListenerC0601d(this));
            M();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (U == null) {
                U = new AtomicBoolean(true);
            }
            U.compareAndSet(false, true);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.P = new f(this);
            if (U == null) {
                U = new AtomicBoolean(true);
            }
            d.a.h0.a.l.c.a().d(this.P, 0L, 200L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AtomicBoolean atomicBoolean = U;
            if (atomicBoolean != null) {
                atomicBoolean.set(false);
            }
            f fVar = this.P;
            if (fVar != null) {
                fVar.cancel();
                this.P = null;
            }
        }
    }

    @Override // d.a.h0.a.d.a, d.a.h0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            String str = d.a.h0.a.d.a.M;
            Log.d(str, "onWindowFocusChanged: " + z);
            AdVideoView adVideoView = this.N;
            if (adVideoView == null) {
                return;
            }
            if (!z) {
                adVideoView.r();
            } else {
                adVideoView.s();
            }
            if (this.N != null && this.Q && z && !V) {
                W("onWindowFocusChanged");
            }
            this.Q = !z;
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    @Override // d.a.h0.a.d.a, d.a.h0.a.g.b
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.N == null) {
            return;
        }
        V = true;
    }

    @Override // d.a.h0.a.d.a, d.a.h0.a.g.b
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // d.a.h0.a.d.a
    public void v() {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (adVideoView = this.N) == null) {
            return;
        }
        adVideoView.setOnClickListener(null);
    }

    @Override // d.a.h0.a.d.a
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            try {
                this.N.A(Y());
                V();
            } catch (Exception e2) {
                W("video_container_excepiton_doStartOnUIThread_" + e2.toString());
            }
        }
    }
}
