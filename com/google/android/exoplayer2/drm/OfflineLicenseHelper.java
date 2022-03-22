package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
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
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class OfflineLicenseHelper<T extends ExoMediaCrypto> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConditionVariable conditionVariable;
    public final DefaultDrmSessionManager<T> drmSessionManager;
    public final HandlerThread handlerThread;

    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uuid, exoMediaDrm, mediaDrmCallback, hashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("OfflineLicenseHelper");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.conditionVariable = new ConditionVariable();
        this.drmSessionManager = new DefaultDrmSessionManager<>(uuid, exoMediaDrm, mediaDrmCallback, hashMap, new Handler(this.handlerThread.getLooper()), new DefaultDrmSessionManager.EventListener(this) { // from class: com.google.android.exoplayer2.drm.OfflineLicenseHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfflineLicenseHelper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmKeysLoaded() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.conditionVariable.open();
                }
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmKeysRemoved() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.conditionVariable.open();
                }
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmKeysRestored() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.conditionVariable.open();
                }
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmSessionManagerError(Exception exc) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, exc) == null) {
                    this.this$0.conditionVariable.open();
                }
            }
        });
    }

    private byte[] blockingKeyRequest(int i, byte[] bArr, DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, this, i, bArr, drmInitData)) == null) {
            DrmSession<T> openBlockingKeyRequest = openBlockingKeyRequest(i, bArr, drmInitData);
            DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
            byte[] offlineLicenseKeySetId = openBlockingKeyRequest.getOfflineLicenseKeySetId();
            this.drmSessionManager.releaseSession(openBlockingKeyRequest);
            if (error == null) {
                return offlineLicenseKeySetId;
            }
            throw error;
        }
        return (byte[]) invokeILL.objValue;
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, factory)) == null) ? newWidevineInstance(str, false, factory, null) : (OfflineLicenseHelper) invokeLL.objValue;
    }

    private DrmSession<T> openBlockingKeyRequest(int i, byte[] bArr, DrmInitData drmInitData) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65542, this, i, bArr, drmInitData)) == null) {
            this.drmSessionManager.setMode(i, bArr);
            this.conditionVariable.close();
            DrmSession<T> acquireSession = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), drmInitData);
            this.conditionVariable.block();
            return acquireSession;
        }
        return (DrmSession) invokeILL.objValue;
    }

    public synchronized byte[] downloadLicense(DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        InterceptResult invokeL;
        byte[] blockingKeyRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, drmInitData)) == null) {
            synchronized (this) {
                Assertions.checkArgument(drmInitData != null);
                blockingKeyRequest = blockingKeyRequest(2, null, drmInitData);
            }
            return blockingKeyRequest;
        }
        return (byte[]) invokeL.objValue;
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            synchronized (this) {
                Assertions.checkNotNull(bArr);
                DrmSession<T> openBlockingKeyRequest = openBlockingKeyRequest(1, bArr, null);
                DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
                Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(openBlockingKeyRequest);
                this.drmSessionManager.releaseSession(openBlockingKeyRequest);
                if (error != null) {
                    if (error.getCause() instanceof KeysExpiredException) {
                        return Pair.create(0L, 0L);
                    }
                    throw error;
                }
                return licenseDurationRemainingSec;
            }
        }
        return (Pair) invokeL.objValue;
    }

    public synchronized byte[] getPropertyByteArray(String str) {
        InterceptResult invokeL;
        byte[] propertyByteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                propertyByteArray = this.drmSessionManager.getPropertyByteArray(str);
            }
            return propertyByteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    public synchronized String getPropertyString(String str) {
        InterceptResult invokeL;
        String propertyString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                propertyString = this.drmSessionManager.getPropertyString(str);
            }
            return propertyString;
        }
        return (String) invokeL.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.handlerThread.quit();
        }
    }

    public synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            synchronized (this) {
                Assertions.checkNotNull(bArr);
                blockingKeyRequest(3, bArr, null);
            }
        }
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        InterceptResult invokeL;
        byte[] blockingKeyRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            synchronized (this) {
                Assertions.checkNotNull(bArr);
                blockingKeyRequest = blockingKeyRequest(2, bArr, null);
            }
            return blockingKeyRequest;
        }
        return (byte[]) invokeL.objValue;
    }

    public synchronized void setPropertyByteArray(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, bArr) == null) {
            synchronized (this) {
                this.drmSessionManager.setPropertyByteArray(str, bArr);
            }
        }
    }

    public synchronized void setPropertyString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            synchronized (this) {
                this.drmSessionManager.setPropertyString(str, str2);
            }
        }
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Boolean.valueOf(z), factory})) == null) ? newWidevineInstance(str, z, factory, null) : (OfflineLicenseHelper) invokeCommon.objValue;
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory, HashMap<String, String> hashMap) throws UnsupportedDrmException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, Boolean.valueOf(z), factory, hashMap})) == null) {
            UUID uuid = C.WIDEVINE_UUID;
            return new OfflineLicenseHelper<>(uuid, FrameworkMediaDrm.newInstance(uuid), new HttpMediaDrmCallback(str, z, factory), hashMap);
        }
        return (OfflineLicenseHelper) invokeCommon.objValue;
    }
}
