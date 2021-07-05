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
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AudioManager f39389a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f39390b;

    /* renamed from: c  reason: collision with root package name */
    public a f39391c;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
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
        this.f39389a = (AudioManager) context.getSystemService("audio");
        this.f39390b = new AudioManager.OnAudioFocusChangeListener(this) { // from class: com.kwad.sdk.utils.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39392a;

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
                this.f39392a = this;
            }

            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.f39392a.f39391c == null) {
                    return;
                }
                if (i4 < 0) {
                    this.f39392a.f39391c.a();
                } else {
                    this.f39392a.f39391c.b();
                }
            }
        };
    }

    @TargetApi(26)
    private AudioFocusRequest c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.f39390b).build() : (AudioFocusRequest) invokeV.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f39391c = aVar;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f39390b;
            if (onAudioFocusChangeListener == null || (audioManager = this.f39389a) == null) {
                return false;
            }
            return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.requestAudioFocus(c()) : 1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f39390b;
            if (onAudioFocusChangeListener == null || (audioManager = this.f39389a) == null) {
                return false;
            }
            return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.abandonAudioFocusRequest(c()) : 1 == audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
        return invokeV.booleanValue;
    }
}
