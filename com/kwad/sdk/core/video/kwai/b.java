package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.video.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public final a f57843b;

    /* renamed from: c  reason: collision with root package name */
    public String f57844c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f57845d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f57846e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57847f;

    /* loaded from: classes2.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<b> a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.a(i2);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.c();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                b bVar = this.a.get();
                return bVar != null && bVar.b(i2, i3);
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i2, i3)) == null) {
                b bVar = this.a.get();
                return bVar != null && bVar.c(i2, i3);
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, mediaPlayer) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.b();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.d();
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048582, this, mediaPlayer, timedText) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.a(timedText);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048583, this, mediaPlayer, i2, i3) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.a(i2, i3);
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
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
        Object obj = new Object();
        this.f57846e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.f57843b = new a(this);
        q();
        a(false);
    }

    private void p() {
        MediaDataSource mediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (mediaDataSource = this.f57845d) == null) {
            return;
        }
        try {
            mediaDataSource.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f57845d = null;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.a.setOnPreparedListener(this.f57843b);
            this.a.setOnBufferingUpdateListener(this.f57843b);
            this.a.setOnCompletionListener(this.f57843b);
            this.a.setOnSeekCompleteListener(this.f57843b);
            this.a.setOnVideoSizeChangedListener(this.f57843b);
            this.a.setOnErrorListener(this.f57843b);
            this.a.setOnInfoListener(this.f57843b);
            this.a.setOnTimedTextListener(this.f57843b);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.a.setOnPreparedListener(null);
            this.a.setOnBufferingUpdateListener(null);
            this.a.setOnCompletionListener(null);
            this.a.setOnSeekCompleteListener(null);
            this.a.setOnVideoSizeChangedListener(null);
            this.a.setOnErrorListener(null);
            this.a.setOnInfoListener(null);
            this.a.setOnTimedTextListener(null);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.a.setVolume(f2, f3);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.a.seekTo((int) j2, 3);
            } else {
                this.a.seekTo((int) j2);
            }
        }
    }

    @TargetApi(14)
    public void a(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, uri, map) == null) {
            this.a.setDataSource(context, uri, map);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.a.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (!cVar.f57191f) {
                a(cVar.f57187b);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "video/mp4");
            hashMap.put(Util.ACCEPT_RANGES, "bytes");
            hashMap.put("Status", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206);
            hashMap.put("Cache-control", "no-cache");
            a(KsAdSDKImpl.get().getContext(), Uri.parse(cVar.f57187b), hashMap);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f57844c = str;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
                this.a.setDataSource(str);
            } else {
                this.a.setDataSource(parse.getPath());
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.a.setAudioStreamType(i2);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.a.prepareAsync();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.start();
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                return this.a.getCurrentPosition();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                return this.a.getDuration();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            try {
                this.f57847f = true;
                this.a.release();
                p();
                a();
                r();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            try {
                this.a.reset();
            } catch (IllegalStateException unused) {
            }
            p();
            a();
            q();
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a.isLooping() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}
