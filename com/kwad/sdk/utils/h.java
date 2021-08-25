package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AudioManager f73785a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f73786b;

    /* renamed from: c  reason: collision with root package name */
    public a f73787c;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b();
    }

    public h(Context context) {
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
        this.f73785a = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.f73786b = new AudioManager.OnAudioFocusChangeListener(this) { // from class: com.kwad.sdk.utils.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f73788a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f73788a = this;
            }

            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.f73788a.f73787c == null) {
                    return;
                }
                if (i4 < 0) {
                    this.f73788a.f73787c.a();
                } else {
                    this.f73788a.f73787c.b();
                }
            }
        };
    }

    @TargetApi(26)
    private AudioFocusRequest b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.f73786b).build() : (AudioFocusRequest) invokeV.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f73787c = aVar;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f73786b;
            if (onAudioFocusChangeListener == null || (audioManager = this.f73785a) == null) {
                return false;
            }
            return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.requestAudioFocus(b()) : 1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
        }
        return invokeV.booleanValue;
    }
}
