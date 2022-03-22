package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes6.dex */
public final class AudioCapabilitiesReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioCapabilities audioCapabilities;
    public final Context context;
    public final Listener listener;
    public final BroadcastReceiver receiver;

    /* renamed from: com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AudioCapabilitiesReceiver this$0;

        public HdmiAudioPlugBroadcastReceiver(AudioCapabilitiesReceiver audioCapabilitiesReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioCapabilitiesReceiver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = audioCapabilitiesReceiver;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || isInitialStickyBroadcast()) {
                return;
            }
            AudioCapabilities capabilities = AudioCapabilities.getCapabilities(intent);
            if (capabilities.equals(this.this$0.audioCapabilities)) {
                return;
            }
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.this$0;
            audioCapabilitiesReceiver.audioCapabilities = capabilities;
            audioCapabilitiesReceiver.listener.onAudioCapabilitiesChanged(capabilities);
        }

        public /* synthetic */ HdmiAudioPlugBroadcastReceiver(AudioCapabilitiesReceiver audioCapabilitiesReceiver, AnonymousClass1 anonymousClass1) {
            this(audioCapabilitiesReceiver);
        }
    }

    /* loaded from: classes6.dex */
    public interface Listener {
        void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities);
    }

    public AudioCapabilitiesReceiver(Context context, Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, listener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = (Context) Assertions.checkNotNull(context);
        this.listener = (Listener) Assertions.checkNotNull(listener);
        this.receiver = Util.SDK_INT >= 21 ? new HdmiAudioPlugBroadcastReceiver(this, null) : null;
    }

    public AudioCapabilities register() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BroadcastReceiver broadcastReceiver = this.receiver;
            AudioCapabilities capabilities = AudioCapabilities.getCapabilities(broadcastReceiver == null ? null : this.context.registerReceiver(broadcastReceiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
            this.audioCapabilities = capabilities;
            return capabilities;
        }
        return (AudioCapabilities) invokeV.objValue;
    }

    public void unregister() {
        BroadcastReceiver broadcastReceiver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (broadcastReceiver = this.receiver) == null) {
            return;
        }
        this.context.unregisterReceiver(broadcastReceiver);
    }
}
