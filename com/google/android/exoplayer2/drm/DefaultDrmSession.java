package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@TargetApi(18)
/* loaded from: classes7.dex */
public class DefaultDrmSession<T extends ExoMediaCrypto> implements DrmSession<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_LICENSE_DURATION_TO_RENEW = 60;
    public static final int MSG_KEYS = 1;
    public static final int MSG_PROVISION = 0;
    public static final String TAG = "DefaultDrmSession";
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaDrmCallback callback;
    public final Handler eventHandler;
    public final DefaultDrmSessionManager.EventListener eventListener;
    public final byte[] initData;
    public final int initialDrmRequestRetryCount;
    public DrmSession.DrmSessionException lastException;
    public T mediaCrypto;
    public final ExoMediaDrm<T> mediaDrm;
    public final String mimeType;
    public final int mode;
    public byte[] offlineLicenseKeySetId;
    public int openCount;
    public final HashMap<String, String> optionalKeyRequestParameters;
    public DefaultDrmSession<T>.PostRequestHandler postRequestHandler;
    public final DefaultDrmSession<T>.PostResponseHandler postResponseHandler;
    public final ProvisioningManager<T> provisioningManager;
    public HandlerThread requestHandlerThread;
    public byte[] sessionId;
    public int state;
    public final UUID uuid;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class PostRequestHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultDrmSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostRequestHandler(DefaultDrmSession defaultDrmSession, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultDrmSession, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultDrmSession;
        }

        private long getRetryDelayMillis(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) ? Math.min((i - 1) * 1000, 5000) : invokeI.longValue;
        }

        private boolean maybeRetryRequest(Message message) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, message)) == null) {
                if ((message.arg1 == 1) && (i = message.arg2 + 1) <= this.this$0.initialDrmRequestRetryCount) {
                    Message obtain = Message.obtain(message);
                    obtain.arg2 = i;
                    sendMessageDelayed(obtain, getRetryDelayMillis(i));
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    int i = message.what;
                    if (i == 0) {
                        e = this.this$0.callback.executeProvisionRequest(this.this$0.uuid, (ExoMediaDrm.ProvisionRequest) message.obj);
                    } else if (i == 1) {
                        e = this.this$0.callback.executeKeyRequest(this.this$0.uuid, (ExoMediaDrm.KeyRequest) message.obj);
                    } else {
                        throw new RuntimeException();
                    }
                } catch (Exception e) {
                    e = e;
                    if (maybeRetryRequest(message)) {
                        return;
                    }
                }
                this.this$0.postResponseHandler.obtainMessage(message.what, e).sendToTarget();
            }
        }

        public Message obtainMessage(int i, Object obj, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), obj, Boolean.valueOf(z)})) == null) {
                return obtainMessage(i, z ? 1 : 0, 0, obj);
            }
            return (Message) invokeCommon.objValue;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class PostResponseHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultDrmSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostResponseHandler(DefaultDrmSession defaultDrmSession, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultDrmSession, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultDrmSession;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 0) {
                    this.this$0.onProvisionResponse(message.obj);
                } else if (i != 1) {
                } else {
                    this.this$0.onKeyResponse(message.obj);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface ProvisioningManager<T extends ExoMediaCrypto> {
        void onProvisionCompleted();

        void onProvisionError(Exception exc);

        void provisionRequired(DefaultDrmSession<T> defaultDrmSession);
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm<T> exoMediaDrm, ProvisioningManager<T> provisioningManager, byte[] bArr, String str, int i, byte[] bArr2, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, Handler handler, DefaultDrmSessionManager.EventListener eventListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uuid, exoMediaDrm, provisioningManager, bArr, str, Integer.valueOf(i), bArr2, hashMap, mediaDrmCallback, looper, handler, eventListener, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uuid = uuid;
        this.provisioningManager = provisioningManager;
        this.mediaDrm = exoMediaDrm;
        this.mode = i;
        this.offlineLicenseKeySetId = bArr2;
        this.optionalKeyRequestParameters = hashMap;
        this.callback = mediaDrmCallback;
        this.initialDrmRequestRetryCount = i2;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.state = 2;
        this.postResponseHandler = new PostResponseHandler(this, looper);
        HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
        this.requestHandlerThread = handlerThread;
        handlerThread.start();
        this.postRequestHandler = new PostRequestHandler(this, this.requestHandlerThread.getLooper());
        if (bArr2 == null) {
            this.initData = bArr;
            this.mimeType = str;
            return;
        }
        this.initData = null;
        this.mimeType = null;
    }

    private void doLicense(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            int i = this.mode;
            if (i != 0 && i != 1) {
                if (i != 2) {
                    if (i == 3 && restoreKeys()) {
                        postKeyRequest(3, z);
                    }
                } else if (this.offlineLicenseKeySetId == null) {
                    postKeyRequest(2, z);
                } else if (restoreKeys()) {
                    postKeyRequest(2, z);
                }
            } else if (this.offlineLicenseKeySetId == null) {
                postKeyRequest(1, z);
            } else if (this.state == 4 || restoreKeys()) {
                long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
                if (this.mode == 0 && licenseDurationRemainingSec <= 60) {
                    Log.d(TAG, "Offline license has expired or will expire soon. Remaining seconds: " + licenseDurationRemainingSec);
                    postKeyRequest(2, z);
                } else if (licenseDurationRemainingSec <= 0) {
                    onError(new KeysExpiredException());
                } else {
                    this.state = 4;
                    Handler handler = this.eventHandler;
                    if (handler == null || this.eventListener == null) {
                        return;
                    }
                    handler.post(new Runnable(this) { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultDrmSession this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
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
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.eventListener.onDrmKeysRestored();
                            }
                        }
                    });
                }
            }
        }
    }

    private long getLicenseDurationRemainingSec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (C.WIDEVINE_UUID.equals(this.uuid)) {
                Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(this);
                return Math.min(((Long) licenseDurationRemainingSec.first).longValue(), ((Long) licenseDurationRemainingSec.second).longValue());
            }
            return Long.MAX_VALUE;
        }
        return invokeV.longValue;
    }

    private boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i = this.state;
            return i == 3 || i == 4;
        }
        return invokeV.booleanValue;
    }

    private void onError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, exc) == null) {
            this.lastException = new DrmSession.DrmSessionException(exc);
            Handler handler = this.eventHandler;
            if (handler != null && this.eventListener != null) {
                handler.post(new Runnable(this, exc) { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DefaultDrmSession this$0;
                    public final /* synthetic */ Exception val$e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, exc};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$e = exc;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.eventListener.onDrmSessionManagerError(this.val$e);
                        }
                    }
                });
            }
            if (this.state != 4) {
                this.state = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyResponse(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, obj) == null) && isOpen()) {
            if (obj instanceof Exception) {
                onKeysError((Exception) obj);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj;
                if (C.CLEARKEY_UUID.equals(this.uuid)) {
                    bArr = ClearKeyUtil.adjustResponseData(bArr);
                }
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse(this.offlineLicenseKeySetId, bArr);
                    if (this.eventHandler == null || this.eventListener == null) {
                        return;
                    }
                    this.eventHandler.post(new Runnable(this) { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultDrmSession this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.eventListener.onDrmKeysRemoved();
                            }
                        }
                    });
                    return;
                }
                byte[] provideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                if ((this.mode == 2 || (this.mode == 0 && this.offlineLicenseKeySetId != null)) && provideKeyResponse != null && provideKeyResponse.length != 0) {
                    this.offlineLicenseKeySetId = provideKeyResponse;
                }
                this.state = 4;
                if (this.eventHandler == null || this.eventListener == null) {
                    return;
                }
                this.eventHandler.post(new Runnable(this) { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DefaultDrmSession this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.eventListener.onDrmKeysLoaded();
                        }
                    }
                });
            } catch (Exception e) {
                onKeysError(e);
            }
        }
    }

    private void onKeysError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, exc) == null) {
            if (exc instanceof NotProvisionedException) {
                this.provisioningManager.provisionRequired(this);
            } else {
                onError(exc);
            }
        }
    }

    private void onKeysExpired() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.state == 4) {
            this.state = 3;
            onError(new KeysExpiredException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProvisionResponse(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, obj) == null) {
            if (this.state == 2 || isOpen()) {
                if (obj instanceof Exception) {
                    this.provisioningManager.onProvisionError((Exception) obj);
                    return;
                }
                try {
                    this.mediaDrm.provideProvisionResponse((byte[]) obj);
                    this.provisioningManager.onProvisionCompleted();
                } catch (Exception e) {
                    this.provisioningManager.onProvisionError(e);
                }
            }
        }
    }

    private boolean openInternal(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65549, this, z)) == null) {
            if (isOpen()) {
                return true;
            }
            try {
                byte[] openSession = this.mediaDrm.openSession();
                this.sessionId = openSession;
                this.mediaCrypto = this.mediaDrm.createMediaCrypto(openSession);
                this.state = 3;
                return true;
            } catch (NotProvisionedException e) {
                if (z) {
                    this.provisioningManager.provisionRequired(this);
                    return false;
                }
                onError(e);
                return false;
            } catch (Exception e2) {
                onError(e2);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    private void postKeyRequest(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                ExoMediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(i == 3 ? this.offlineLicenseKeySetId : this.sessionId, this.initData, this.mimeType, i, this.optionalKeyRequestParameters);
                if (C.CLEARKEY_UUID.equals(this.uuid)) {
                    keyRequest = new ExoMediaDrm.DefaultKeyRequest(ClearKeyUtil.adjustRequestData(keyRequest.getData()), keyRequest.getDefaultUrl());
                }
                this.postRequestHandler.obtainMessage(1, keyRequest, z).sendToTarget();
            } catch (Exception e) {
                onKeysError(e);
            }
        }
    }

    private boolean restoreKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            try {
                this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "Error trying to restore Widevine keys.", e);
                onError(e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void acquire() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.openCount + 1;
            this.openCount = i;
            if (i == 1 && this.state != 1 && openInternal(true)) {
                doLicense(true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.state == 1) {
                return this.lastException;
            }
            return null;
        }
        return (DrmSession.DrmSessionException) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final T getMediaCrypto() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mediaCrypto : (T) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.offlineLicenseKeySetId : (byte[]) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.state : invokeV.intValue;
    }

    public boolean hasInitData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) ? Arrays.equals(this.initData, bArr) : invokeL.booleanValue;
    }

    public boolean hasSessionId(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) ? Arrays.equals(this.sessionId, bArr) : invokeL.booleanValue;
    }

    public void onMediaDrmEvent(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && isOpen()) {
            if (i == 1) {
                this.state = 3;
                this.provisioningManager.provisionRequired(this);
            } else if (i == 2) {
                doLicense(false);
            } else if (i != 3) {
            } else {
                onKeysExpired();
            }
        }
    }

    public void onProvisionCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && openInternal(false)) {
            doLicense(true);
        }
    }

    public void onProvisionError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            onError(exc);
        }
    }

    public void provision() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.postRequestHandler.obtainMessage(0, (Object) this.mediaDrm.getProvisionRequest(), true).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            byte[] bArr = this.sessionId;
            if (bArr == null) {
                return null;
            }
            return this.mediaDrm.queryKeyStatus(bArr);
        }
        return (Map) invokeV.objValue;
    }

    public boolean release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.openCount - 1;
            this.openCount = i;
            if (i == 0) {
                this.state = 0;
                this.postResponseHandler.removeCallbacksAndMessages(null);
                this.postRequestHandler.removeCallbacksAndMessages(null);
                this.postRequestHandler = null;
                this.requestHandlerThread.quit();
                this.requestHandlerThread = null;
                this.mediaCrypto = null;
                this.lastException = null;
                byte[] bArr = this.sessionId;
                if (bArr != null) {
                    this.mediaDrm.closeSession(bArr);
                    this.sessionId = null;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
