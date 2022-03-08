package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.b.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@TargetApi(18)
/* loaded from: classes7.dex */
public class DefaultDrmSessionManager<T extends ExoMediaCrypto> implements DrmSessionManager<T>, DefaultDrmSession.ProvisioningManager<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CENC_SCHEME_MIME_TYPE = "cenc";
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaDrmCallback callback;
    public final Handler eventHandler;
    public final EventListener eventListener;
    public final int initialDrmRequestRetryCount;
    public final ExoMediaDrm<T> mediaDrm;
    public volatile DefaultDrmSessionManager<T>.MediaDrmHandler mediaDrmHandler;
    public int mode;
    public final boolean multiSession;
    public byte[] offlineLicenseKeySetId;
    public final HashMap<String, String> optionalKeyRequestParameters;
    public Looper playbackLooper;
    public final List<DefaultDrmSession<T>> provisioningSessions;
    public final List<DefaultDrmSession<T>> sessions;
    public final UUID uuid;

    /* loaded from: classes7.dex */
    public interface EventListener {
        void onDrmKeysLoaded();

        void onDrmKeysRemoved();

        void onDrmKeysRestored();

        void onDrmSessionManagerError(Exception exc);
    }

    /* loaded from: classes7.dex */
    public class MediaDrmEventListener implements ExoMediaDrm.OnEventListener<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultDrmSessionManager this$0;

        public MediaDrmEventListener(DefaultDrmSessionManager defaultDrmSessionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultDrmSessionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultDrmSessionManager;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(ExoMediaDrm<? extends T> exoMediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{exoMediaDrm, bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2}) == null) && this.this$0.mode == 0) {
                this.this$0.mediaDrmHandler.obtainMessage(i2, bArr).sendToTarget();
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class MediaDrmHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultDrmSessionManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaDrmHandler(DefaultDrmSessionManager defaultDrmSessionManager, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultDrmSessionManager, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultDrmSessionManager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                byte[] bArr = (byte[]) message.obj;
                for (DefaultDrmSession defaultDrmSession : this.this$0.sessions) {
                    if (defaultDrmSession.hasSessionId(bArr)) {
                        defaultDrmSession.onMediaDrmEvent(message.what);
                        return;
                    }
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Mode {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, false, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((UUID) objArr2[0], (ExoMediaDrm) objArr2[1], (MediaDrmCallback) objArr2[2], (HashMap) objArr2[3], (Handler) objArr2[4], (EventListener) objArr2[5], ((Boolean) objArr2[6]).booleanValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static DrmInitData.SchemeData getSchemeData(DrmInitData drmInitData, UUID uuid, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, drmInitData, uuid, z)) == null) {
            ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= drmInitData.schemeDataCount) {
                    break;
                }
                DrmInitData.SchemeData schemeData = drmInitData.get(i2);
                if (!schemeData.matches(uuid) && (!C.CLEARKEY_UUID.equals(uuid) || !schemeData.matches(C.COMMON_PSSH_UUID))) {
                    z2 = false;
                }
                if (z2 && (schemeData.data != null || z)) {
                    arrayList.add(schemeData);
                }
                i2++;
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            if (C.WIDEVINE_UUID.equals(uuid)) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) arrayList.get(i3);
                    int parseVersion = schemeData2.hasData() ? PsshAtomUtil.parseVersion(schemeData2.data) : -1;
                    if (Util.SDK_INT < 23 && parseVersion == 0) {
                        return schemeData2;
                    }
                    if (Util.SDK_INT >= 23 && parseVersion == 1) {
                        return schemeData2;
                    }
                }
            }
            return (DrmInitData.SchemeData) arrayList.get(0);
        }
        return (DrmInitData.SchemeData) invokeLLZ.objValue;
    }

    public static byte[] getSchemeInitData(DrmInitData.SchemeData schemeData, UUID uuid) {
        InterceptResult invokeLL;
        byte[] parseSchemeSpecificData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, schemeData, uuid)) == null) {
            byte[] bArr = schemeData.data;
            return (Util.SDK_INT >= 21 || (parseSchemeSpecificData = PsshAtomUtil.parseSchemeSpecificData(bArr, uuid)) == null) ? bArr : parseSchemeSpecificData;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String getSchemeMimeType(DrmInitData.SchemeData schemeData, UUID uuid) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, schemeData, uuid)) == null) {
            String str = schemeData.mimeType;
            return (Util.SDK_INT >= 26 || !C.CLEARKEY_UUID.equals(uuid)) ? str : (MimeTypes.VIDEO_MP4.equals(str) || MimeTypes.AUDIO_MP4.equals(str)) ? "cenc" : str;
        }
        return (String) invokeLL.objValue;
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID uuid, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65545, null, uuid, mediaDrmCallback, hashMap, handler, eventListener)) == null) ? new DefaultDrmSessionManager<>(uuid, FrameworkMediaDrm.newInstance(uuid), mediaDrmCallback, hashMap, handler, eventListener, false, 3) : (DefaultDrmSessionManager) invokeLLLLL.objValue;
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback mediaDrmCallback, String str, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        InterceptResult invokeLLLL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, mediaDrmCallback, str, handler, eventListener)) == null) {
            if (TextUtils.isEmpty(str)) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                hashMap.put(PLAYREADY_CUSTOM_DATA_KEY, str);
            }
            return newFrameworkInstance(C.PLAYREADY_UUID, mediaDrmCallback, hashMap, handler, eventListener);
        }
        return (DefaultDrmSessionManager) invokeLLLL.objValue;
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, mediaDrmCallback, hashMap, handler, eventListener)) == null) ? newFrameworkInstance(C.WIDEVINE_UUID, mediaDrmCallback, hashMap, handler, eventListener) : (DefaultDrmSessionManager) invokeLLLL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData) {
        InterceptResult invokeLL;
        byte[] bArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, looper, drmInitData)) == null) {
            Looper looper2 = this.playbackLooper;
            Assertions.checkState(looper2 == null || looper2 == looper);
            if (this.sessions.isEmpty()) {
                this.playbackLooper = looper;
                if (this.mediaDrmHandler == null) {
                    this.mediaDrmHandler = new MediaDrmHandler(this, looper);
                }
            }
            DefaultDrmSession<T> defaultDrmSession = null;
            if (this.offlineLicenseKeySetId == null) {
                DrmInitData.SchemeData schemeData = getSchemeData(drmInitData, this.uuid, false);
                if (schemeData == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("Media does not support uuid: " + this.uuid);
                    Handler handler = this.eventHandler;
                    if (handler != null && this.eventListener != null) {
                        handler.post(new Runnable(this, illegalStateException) { // from class: com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ DefaultDrmSessionManager this$0;
                            public final /* synthetic */ IllegalStateException val$error;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, illegalStateException};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$error = illegalStateException;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.this$0.eventListener.onDrmSessionManagerError(this.val$error);
                                }
                            }
                        });
                    }
                    return new ErrorStateDrmSession(new DrmSession.DrmSessionException(illegalStateException));
                }
                byte[] schemeInitData = getSchemeInitData(schemeData, this.uuid);
                str = getSchemeMimeType(schemeData, this.uuid);
                bArr = schemeInitData;
            } else {
                bArr = null;
                str = null;
            }
            if (!this.multiSession) {
                if (!this.sessions.isEmpty()) {
                    defaultDrmSession = this.sessions.get(0);
                }
            } else {
                Iterator<DefaultDrmSession<T>> it = this.sessions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DefaultDrmSession<T> next = it.next();
                    if (next.hasInitData(bArr)) {
                        defaultDrmSession = next;
                        break;
                    }
                }
            }
            if (defaultDrmSession == null) {
                DefaultDrmSession<T> defaultDrmSession2 = new DefaultDrmSession<>(this.uuid, this.mediaDrm, this, bArr, str, this.mode, this.offlineLicenseKeySetId, this.optionalKeyRequestParameters, this.callback, looper, this.eventHandler, this.eventListener, this.initialDrmRequestRetryCount);
                this.sessions.add(defaultDrmSession2);
                defaultDrmSession = defaultDrmSession2;
            }
            defaultDrmSession.acquire();
            return defaultDrmSession;
        }
        return (DrmSession) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public boolean canAcquireSession(@NonNull DrmInitData drmInitData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drmInitData)) == null) {
            if (getSchemeData(drmInitData, this.uuid, true) == null) {
                return false;
            }
            String str = drmInitData.schemeType;
            if (str == null || "cenc".equals(str)) {
                return true;
            }
            return !(C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cbcs.equals(str) || C.CENC_TYPE_cens.equals(str)) || Util.SDK_INT >= 24;
        }
        return invokeL.booleanValue;
    }

    public final byte[] getPropertyByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.mediaDrm.getPropertyByteArray(str) : (byte[]) invokeL.objValue;
    }

    public final String getPropertyString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mediaDrm.getPropertyString(str) : (String) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (DefaultDrmSession<T> defaultDrmSession : this.provisioningSessions) {
                defaultDrmSession.onProvisionCompleted();
            }
            this.provisioningSessions.clear();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            for (DefaultDrmSession<T> defaultDrmSession : this.provisioningSessions) {
                defaultDrmSession.onProvisionError(exc);
            }
            this.provisioningSessions.clear();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void provisionRequired(DefaultDrmSession<T> defaultDrmSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, defaultDrmSession) == null) {
            this.provisioningSessions.add(defaultDrmSession);
            if (this.provisioningSessions.size() == 1) {
                defaultDrmSession.provision();
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void releaseSession(DrmSession<T> drmSession) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, drmSession) == null) || (drmSession instanceof ErrorStateDrmSession)) {
            return;
        }
        DefaultDrmSession<T> defaultDrmSession = (DefaultDrmSession) drmSession;
        if (defaultDrmSession.release()) {
            this.sessions.remove(defaultDrmSession);
            if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession) {
                this.provisioningSessions.get(1).provision();
            }
            this.provisioningSessions.remove(defaultDrmSession);
        }
    }

    public void setMode(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, bArr) == null) {
            Assertions.checkState(this.sessions.isEmpty());
            if (i2 == 1 || i2 == 3) {
                Assertions.checkNotNull(bArr);
            }
            this.mode = i2;
            this.offlineLicenseKeySetId = bArr;
        }
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, bArr) == null) {
            this.mediaDrm.setPropertyByteArray(str, bArr);
        }
    }

    public final void setPropertyString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.mediaDrm.setPropertyString(str, str2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener, boolean z) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, z, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((UUID) objArr2[0], (ExoMediaDrm) objArr2[1], (MediaDrmCallback) objArr2[2], (HashMap) objArr2[3], (Handler) objArr2[4], (EventListener) objArr2[5], ((Boolean) objArr2[6]).booleanValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Assertions.checkNotNull(uuid);
        Assertions.checkNotNull(exoMediaDrm);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid;
        this.mediaDrm = exoMediaDrm;
        this.callback = mediaDrmCallback;
        this.optionalKeyRequestParameters = hashMap;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.multiSession = z;
        this.initialDrmRequestRetryCount = i2;
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
        if (z) {
            exoMediaDrm.setPropertyString("sessionSharing", c.l);
        }
        exoMediaDrm.setOnEventListener(new MediaDrmEventListener());
    }
}
