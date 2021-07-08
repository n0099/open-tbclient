package d.a.n0.a.n2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static d f46415e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f46416a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f46417b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46418c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f46419d;

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d this$0;

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
            this.this$0 = dVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (this.this$0.f46417b == null) {
                    this.this$0.f46417b = (AudioManager) d.a.n0.a.c1.a.b().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : this.this$0.f46416a.entrySet()) {
                    ((b) entry.getValue()).a(this.this$0.f46417b != null ? this.this$0.f46417b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2);
    }

    public d() {
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
        this.f46416a = new ConcurrentHashMap<>();
        this.f46419d = new a(this);
    }

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f46415e == null) {
                synchronized (d.class) {
                    if (f46415e == null) {
                        f46415e = new d();
                    }
                }
            }
            return f46415e;
        }
        return (d) invokeV.objValue;
    }

    public static void i() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || (dVar = f46415e) == null) {
            return;
        }
        dVar.g();
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f46416a.put(str, bVar);
            if (!this.f46418c) {
                h();
            }
            if (k.f45831a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f46416a.size());
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f46417b == null) {
                this.f46417b = (AudioManager) d.a.n0.a.c1.a.b().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f46417b;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return 100;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f46416a.clear();
                this.f46417b = null;
                this.f46418c = false;
            }
            f46415e = null;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            d.a.n0.a.c1.a.b().registerReceiver(this.f46419d, intentFilter);
            this.f46418c = true;
        }
    }

    public boolean j(@NonNull String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            synchronized (this) {
                b remove = this.f46416a.remove(str);
                if (this.f46416a.size() == 0 && this.f46418c) {
                    k();
                }
                if (k.f45831a && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f46416a.size());
                }
                z = remove != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                d.a.n0.a.c1.a.b().unregisterReceiver(this.f46419d);
                this.f46418c = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
