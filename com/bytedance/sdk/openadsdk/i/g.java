package com.bytedance.sdk.openadsdk.i;

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
import com.bytedance.sdk.component.utils.k;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67916a;

    /* renamed from: b  reason: collision with root package name */
    public f f67917b;

    /* renamed from: c  reason: collision with root package name */
    public a f67918c;

    /* renamed from: d  reason: collision with root package name */
    public Context f67919d;

    /* renamed from: e  reason: collision with root package name */
    public AudioManager f67920e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67921f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67922g;

    /* renamed from: h  reason: collision with root package name */
    public int f67923h;

    /* loaded from: classes9.dex */
    public static class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<g> f67924a;

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
            this.f67924a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f e2;
            int d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                try {
                    if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        k.b("VolumeChangeObserver", "媒体音量改变通.......");
                        g gVar = this.f67924a.get();
                        if (gVar == null || (e2 = gVar.e()) == null || (d2 = gVar.d()) == gVar.a()) {
                            return;
                        }
                        gVar.a(d2);
                        if (d2 >= 0) {
                            e2.a(d2);
                        }
                    }
                } catch (Throwable th) {
                    k.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
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
        this.f67916a = -1;
        this.f67921f = false;
        this.f67922g = false;
        this.f67923h = -1;
        this.f67919d = context;
        this.f67920e = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67923h : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.f67918c = new a(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
                this.f67919d.registerReceiver(this.f67918c, intentFilter);
                this.f67921f = true;
            } catch (Throwable th) {
                k.a("VolumeChangeObserver", "registerReceiverError: ", th);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f67921f) {
            try {
                this.f67919d.unregisterReceiver(this.f67918c);
                this.f67917b = null;
                this.f67921f = false;
            } catch (Throwable th) {
                k.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (this.f67920e != null) {
                    return this.f67920e.getStreamVolume(3);
                }
                return -1;
            } catch (Throwable th) {
                k.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67917b : (f) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f67923h = i2;
        }
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f67917b = fVar;
        }
    }
}
