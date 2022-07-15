package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.webrtc.CalledByNative;
import org.webrtc.PeerConnection;
import org.webrtc.RtpTransceiver;
/* compiled from: PeerConnection.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class nr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @CalledByNative("Observer")
    public static void $default$onConnectionChange(PeerConnection.Observer observer, PeerConnection.PeerConnectionState peerConnectionState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, observer, peerConnectionState) == null) {
        }
    }

    @CalledByNative("Observer")
    public static void $default$onTrack(PeerConnection.Observer observer, RtpTransceiver rtpTransceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, observer, rtpTransceiver) == null) {
        }
    }
}
