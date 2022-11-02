package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class MediaStreamTrack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_TRACK_KIND = "audio";
    public static final String VIDEO_TRACK_KIND = "video";
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeTrack;

    public static native boolean nativeGetEnabled(long j);

    public static native String nativeGetId(long j);

    public static native String nativeGetKind(long j);

    public static native State nativeGetState(long j);

    public static native boolean nativeSetEnabled(long j, boolean z);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class MediaType {
        public static final /* synthetic */ MediaType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MediaType MEDIA_TYPE_AUDIO;
        public static final MediaType MEDIA_TYPE_VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeIndex;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1222782417, "Lorg/webrtc/MediaStreamTrack$MediaType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1222782417, "Lorg/webrtc/MediaStreamTrack$MediaType;");
                    return;
                }
            }
            MEDIA_TYPE_AUDIO = new MediaType("MEDIA_TYPE_AUDIO", 0, 0);
            MediaType mediaType = new MediaType("MEDIA_TYPE_VIDEO", 1, 1);
            MEDIA_TYPE_VIDEO = mediaType;
            $VALUES = new MediaType[]{MEDIA_TYPE_AUDIO, mediaType};
        }

        public MediaType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeIndex = i2;
        }

        @CalledByNative("MediaType")
        public static MediaType fromNativeIndex(int i) {
            InterceptResult invokeI;
            MediaType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (MediaType mediaType : values()) {
                    if (mediaType.getNative() == i) {
                        return mediaType;
                    }
                }
                throw new IllegalArgumentException("Unknown native media type: " + i);
            }
            return (MediaType) invokeI.objValue;
        }

        public static MediaType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (MediaType) Enum.valueOf(MediaType.class, str);
            }
            return (MediaType) invokeL.objValue;
        }

        public static MediaType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (MediaType[]) $VALUES.clone();
            }
            return (MediaType[]) invokeV.objValue;
        }

        @CalledByNative("MediaType")
        public int getNative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.nativeIndex;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State ENDED;
        public static final State LIVE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-70786500, "Lorg/webrtc/MediaStreamTrack$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-70786500, "Lorg/webrtc/MediaStreamTrack$State;");
                    return;
                }
            }
            LIVE = new State("LIVE", 0);
            State state = new State("ENDED", 1);
            ENDED = state;
            $VALUES = new State[]{LIVE, state};
        }

        public State(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @CalledByNative("State")
        public static State fromNativeIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                return values()[i];
            }
            return (State) invokeI.objValue;
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (State) Enum.valueOf(State.class, str);
            }
            return (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (State[]) $VALUES.clone();
            }
            return (State[]) invokeV.objValue;
        }
    }

    public MediaStreamTrack(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (j != 0) {
            this.nativeTrack = j;
            return;
        }
        throw new IllegalArgumentException("nativeTrack may not be null");
    }

    @Nullable
    public static MediaStreamTrack createMediaStreamTrack(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            if (j == 0) {
                return null;
            }
            String nativeGetKind = nativeGetKind(j);
            if (nativeGetKind.equals("audio")) {
                return new AudioTrack(j);
            }
            if (!nativeGetKind.equals("video")) {
                return null;
            }
            return new VideoTrack(j);
        }
        return (MediaStreamTrack) invokeJ.objValue;
    }

    private void checkMediaStreamTrackExists() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || this.nativeTrack != 0) {
            return;
        }
        throw new IllegalStateException("MediaStreamTrack has been disposed.");
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            checkMediaStreamTrackExists();
            JniCommon.nativeReleaseRef(this.nativeTrack);
            this.nativeTrack = 0L;
        }
    }

    public boolean enabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            checkMediaStreamTrackExists();
            return nativeGetEnabled(this.nativeTrack);
        }
        return invokeV.booleanValue;
    }

    public long getNativeMediaStreamTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            checkMediaStreamTrackExists();
            return this.nativeTrack;
        }
        return invokeV.longValue;
    }

    public String id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            checkMediaStreamTrackExists();
            return nativeGetId(this.nativeTrack);
        }
        return (String) invokeV.objValue;
    }

    public String kind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            checkMediaStreamTrackExists();
            return nativeGetKind(this.nativeTrack);
        }
        return (String) invokeV.objValue;
    }

    public State state() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            checkMediaStreamTrackExists();
            return nativeGetState(this.nativeTrack);
        }
        return (State) invokeV.objValue;
    }

    public boolean setEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            checkMediaStreamTrackExists();
            return nativeSetEnabled(this.nativeTrack, z);
        }
        return invokeZ.booleanValue;
    }
}
