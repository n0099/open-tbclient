package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class MediaStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaStream";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<AudioTrack> audioTracks;
    public long nativeStream;
    public final List<VideoTrack> preservedVideoTracks;
    public final List<VideoTrack> videoTracks;

    @CalledByNative
    public MediaStream(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.audioTracks = new ArrayList();
        this.videoTracks = new ArrayList();
        this.preservedVideoTracks = new ArrayList();
        this.nativeStream = j2;
    }

    private void checkMediaStreamExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.nativeStream == 0) {
            throw new IllegalStateException("MediaStream has been disposed.");
        }
    }

    public static native boolean nativeAddAudioTrackToNativeStream(long j2, long j3);

    public static native boolean nativeAddVideoTrackToNativeStream(long j2, long j3);

    public static native String nativeGetId(long j2);

    public static native boolean nativeRemoveAudioTrack(long j2, long j3);

    public static native boolean nativeRemoveVideoTrack(long j2, long j3);

    public static void removeMediaStreamTrack(List<? extends MediaStreamTrack> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, list, j2) == null) {
            Iterator<? extends MediaStreamTrack> it = list.iterator();
            while (it.hasNext()) {
                MediaStreamTrack next = it.next();
                if (next.getNativeMediaStreamTrack() == j2) {
                    next.dispose();
                    it.remove();
                    return;
                }
            }
            Logging.e(TAG, "Couldn't not find track");
        }
    }

    @CalledByNative
    public void addNativeAudioTrack(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.audioTracks.add(new AudioTrack(j2));
        }
    }

    @CalledByNative
    public void addNativeVideoTrack(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.videoTracks.add(new VideoTrack(j2));
        }
    }

    public boolean addPreservedTrack(VideoTrack videoTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoTrack)) == null) {
            checkMediaStreamExists();
            if (nativeAddVideoTrackToNativeStream(this.nativeStream, videoTrack.getNativeVideoTrack())) {
                this.preservedVideoTracks.add(videoTrack);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean addTrack(AudioTrack audioTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, audioTrack)) == null) {
            checkMediaStreamExists();
            if (nativeAddAudioTrackToNativeStream(this.nativeStream, audioTrack.getNativeAudioTrack())) {
                this.audioTracks.add(audioTrack);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean addTrack(VideoTrack videoTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, videoTrack)) == null) {
            checkMediaStreamExists();
            if (nativeAddVideoTrackToNativeStream(this.nativeStream, videoTrack.getNativeVideoTrack())) {
                this.videoTracks.add(videoTrack);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @CalledByNative
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            checkMediaStreamExists();
            while (!this.audioTracks.isEmpty()) {
                AudioTrack audioTrack = this.audioTracks.get(0);
                removeTrack(audioTrack);
                audioTrack.dispose();
            }
            while (!this.videoTracks.isEmpty()) {
                VideoTrack videoTrack = this.videoTracks.get(0);
                removeTrack(videoTrack);
                videoTrack.dispose();
            }
            while (!this.preservedVideoTracks.isEmpty()) {
                removeTrack(this.preservedVideoTracks.get(0));
            }
            JniCommon.nativeReleaseRef(this.nativeStream);
            this.nativeStream = 0L;
        }
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            checkMediaStreamExists();
            return nativeGetId(this.nativeStream);
        }
        return (String) invokeV.objValue;
    }

    public long getNativeMediaStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            checkMediaStreamExists();
            return this.nativeStream;
        }
        return invokeV.longValue;
    }

    @CalledByNative
    public void removeAudioTrack(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            removeMediaStreamTrack(this.audioTracks, j2);
        }
    }

    public boolean removeTrack(AudioTrack audioTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, audioTrack)) == null) {
            checkMediaStreamExists();
            this.audioTracks.remove(audioTrack);
            return nativeRemoveAudioTrack(this.nativeStream, audioTrack.getNativeAudioTrack());
        }
        return invokeL.booleanValue;
    }

    public boolean removeTrack(VideoTrack videoTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, videoTrack)) == null) {
            checkMediaStreamExists();
            this.videoTracks.remove(videoTrack);
            this.preservedVideoTracks.remove(videoTrack);
            return nativeRemoveVideoTrack(this.nativeStream, videoTrack.getNativeVideoTrack());
        }
        return invokeL.booleanValue;
    }

    @CalledByNative
    public void removeVideoTrack(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            removeMediaStreamTrack(this.videoTracks, j2);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + getId() + ":A=" + this.audioTracks.size() + ":V=" + this.videoTracks.size() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
