package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes7.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaDrm mediaDrm;
    public final UUID uuid;

    public FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uuid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Assertions.checkNotNull(uuid);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        if (Util.SDK_INT < 27 && C.CLEARKEY_UUID.equals(uuid)) {
            uuid = C.COMMON_PSSH_UUID;
        }
        this.uuid = uuid;
        this.mediaDrm = new MediaDrm(uuid);
    }

    public static FrameworkMediaDrm newInstance(UUID uuid) throws UnsupportedDrmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uuid)) == null) {
            try {
                return new FrameworkMediaDrm(uuid);
            } catch (UnsupportedSchemeException e) {
                throw new UnsupportedDrmException(1, e);
            } catch (Exception e2) {
                throw new UnsupportedDrmException(2, e2);
            }
        }
        return (FrameworkMediaDrm) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            this.mediaDrm.closeSession(bArr);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.mediaDrm.getPropertyByteArray(str);
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.mediaDrm.getPropertyString(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            this.mediaDrm.provideProvisionResponse(bArr);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Map queryKeyStatus(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bArr)) == null) {
            return this.mediaDrm.queryKeyStatus(bArr);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(ExoMediaDrm.OnEventListener onEventListener) {
        MediaDrm.OnEventListener onEventListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onEventListener) == null) {
            MediaDrm mediaDrm = this.mediaDrm;
            if (onEventListener == null) {
                onEventListener2 = null;
            } else {
                onEventListener2 = new MediaDrm.OnEventListener(this, onEventListener) { // from class: com.google.android.exoplayer2.drm.FrameworkMediaDrm.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FrameworkMediaDrm this$0;
                    public final /* synthetic */ ExoMediaDrm.OnEventListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onEventListener};
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
                        this.val$listener = onEventListener;
                    }

                    @Override // android.media.MediaDrm.OnEventListener
                    public void onEvent(MediaDrm mediaDrm2, byte[] bArr, int i, int i2, byte[] bArr2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{mediaDrm2, bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2}) == null) {
                            this.val$listener.onEvent(this.this$0, bArr, i, i2, bArr2);
                        }
                    }
                };
            }
            mediaDrm.setOnEventListener(onEventListener2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnKeyStatusChangeListener(ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        MediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onKeyStatusChangeListener) == null) {
            if (Util.SDK_INT >= 23) {
                MediaDrm mediaDrm = this.mediaDrm;
                if (onKeyStatusChangeListener == null) {
                    onKeyStatusChangeListener2 = null;
                } else {
                    onKeyStatusChangeListener2 = new MediaDrm.OnKeyStatusChangeListener(this, onKeyStatusChangeListener) { // from class: com.google.android.exoplayer2.drm.FrameworkMediaDrm.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FrameworkMediaDrm this$0;
                        public final /* synthetic */ ExoMediaDrm.OnKeyStatusChangeListener val$listener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, onKeyStatusChangeListener};
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
                            this.val$listener = onKeyStatusChangeListener;
                        }

                        @Override // android.media.MediaDrm.OnKeyStatusChangeListener
                        public void onKeyStatusChange(MediaDrm mediaDrm2, byte[] bArr, List list, boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{mediaDrm2, bArr, list, Boolean.valueOf(z)}) == null) {
                                ArrayList arrayList = new ArrayList();
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    MediaDrm.KeyStatus keyStatus = (MediaDrm.KeyStatus) it.next();
                                    arrayList.add(new ExoMediaDrm.DefaultKeyStatus(keyStatus.getStatusCode(), keyStatus.getKeyId()));
                                }
                                this.val$listener.onKeyStatusChange(this.this$0, bArr, arrayList, z);
                            }
                        }
                    };
                }
                mediaDrm.setOnKeyStatusChangeListener(onKeyStatusChangeListener2, (Handler) null);
                return;
            }
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws MediaCryptoException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            if (Util.SDK_INT < 21 && C.WIDEVINE_UUID.equals(this.uuid) && "L3".equals(getPropertyString("securityLevel"))) {
                z = true;
            } else {
                z = false;
            }
            return new FrameworkMediaCrypto(new MediaCrypto(this.uuid, bArr), z);
        }
        return (FrameworkMediaCrypto) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i, HashMap hashMap) throws NotProvisionedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bArr, bArr2, str, Integer.valueOf(i), hashMap})) == null) {
            MediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(bArr, bArr2, str, i, hashMap);
            return new ExoMediaDrm.DefaultKeyRequest(keyRequest.getData(), keyRequest.getDefaultUrl());
        }
        return (ExoMediaDrm.KeyRequest) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
            return new ExoMediaDrm.DefaultProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
        }
        return (ExoMediaDrm.ProvisionRequest) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws MediaDrmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mediaDrm.openSession();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mediaDrm.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, bArr2)) == null) {
            return this.mediaDrm.provideKeyResponse(bArr, bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bArr, bArr2) == null) {
            this.mediaDrm.restoreKeys(bArr, bArr2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, bArr) == null) {
            this.mediaDrm.setPropertyByteArray(str, bArr);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.mediaDrm.setPropertyString(str, str2);
        }
    }
}
