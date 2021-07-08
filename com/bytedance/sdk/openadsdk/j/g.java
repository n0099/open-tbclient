package com.bytedance.sdk.openadsdk.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f31354a;

    /* renamed from: b  reason: collision with root package name */
    public f f31355b;

    /* renamed from: c  reason: collision with root package name */
    public a f31356c;

    /* renamed from: d  reason: collision with root package name */
    public Context f31357d;

    /* renamed from: e  reason: collision with root package name */
    public AudioManager f31358e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31359f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31360g;

    /* renamed from: h  reason: collision with root package name */
    public int f31361h;

    /* loaded from: classes5.dex */
    public static class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<g> f31362a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31362a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f e2;
            int d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                try {
                    if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        j.b("VolumeChangeObserver", "媒体音量改变通.......");
                        g gVar = this.f31362a.get();
                        if (gVar == null || (e2 = gVar.e()) == null || (d2 = gVar.d()) == gVar.a()) {
                            return;
                        }
                        gVar.a(d2);
                        if (d2 >= 0) {
                            e2.a(d2);
                        }
                    }
                } catch (Throwable th) {
                    j.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
                }
            }
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31354a = -1;
        this.f31359f = false;
        this.f31360g = false;
        this.f31361h = -1;
        this.f31357d = context;
        this.f31358e = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31361h : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.f31356c = new a(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
                this.f31357d.registerReceiver(this.f31356c, intentFilter);
                this.f31359f = true;
            } catch (Throwable th) {
                j.a("VolumeChangeObserver", "registerReceiverError: ", th);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f31359f) {
            try {
                this.f31357d.unregisterReceiver(this.f31356c);
                this.f31355b = null;
                this.f31359f = false;
            } catch (Throwable th) {
                j.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (this.f31358e != null) {
                    return this.f31358e.getStreamVolume(3);
                }
                return -1;
            } catch (Throwable th) {
                j.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31355b : (f) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f31361h = i2;
        }
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f31355b = fVar;
        }
    }
}
