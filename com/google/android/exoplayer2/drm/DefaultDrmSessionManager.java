package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
public class DefaultDrmSessionManager<T extends ExoMediaCrypto> implements DrmSessionManager<T>, DefaultDrmSession.ProvisioningManager<T> {
    public static final String CENC_SCHEME_MIME_TYPE = "cenc";
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
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

    /* loaded from: classes9.dex */
    public interface EventListener {
        void onDrmKeysLoaded();

        void onDrmKeysRemoved();

        void onDrmKeysRestored();

        void onDrmSessionManagerError(Exception exc);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface Mode {
    }

    /* loaded from: classes9.dex */
    public class MediaDrmEventListener implements ExoMediaDrm.OnEventListener<T> {
        public MediaDrmEventListener() {
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(ExoMediaDrm<? extends T> exoMediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
            if (DefaultDrmSessionManager.this.mode == 0) {
                DefaultDrmSessionManager.this.mediaDrmHandler.obtainMessage(i, bArr).sendToTarget();
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes9.dex */
    public class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.sessions) {
                if (defaultDrmSession.hasSessionId(bArr)) {
                    defaultDrmSession.onMediaDrmEvent(message.what);
                    return;
                }
            }
        }
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, false, 3);
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener, boolean z) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, z, 3);
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener, boolean z, int i) {
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
        this.initialDrmRequestRetryCount = i;
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
        if (z) {
            exoMediaDrm.setPropertyString("sessionSharing", "enable");
        }
        exoMediaDrm.setOnEventListener(new MediaDrmEventListener());
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionError(Exception exc) {
        for (DefaultDrmSession<T> defaultDrmSession : this.provisioningSessions) {
            defaultDrmSession.onProvisionError(exc);
        }
        this.provisioningSessions.clear();
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void provisionRequired(DefaultDrmSession<T> defaultDrmSession) {
        this.provisioningSessions.add(defaultDrmSession);
        if (this.provisioningSessions.size() == 1) {
            defaultDrmSession.provision();
        }
    }

    public static DrmInitData.SchemeData getSchemeData(DrmInitData drmInitData, UUID uuid, boolean z) {
        int i;
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
                if (schemeData2.hasData()) {
                    i = PsshAtomUtil.parseVersion(schemeData2.data);
                } else {
                    i = -1;
                }
                if (Util.SDK_INT < 23 && i == 0) {
                    return schemeData2;
                }
                if (Util.SDK_INT >= 23 && i == 1) {
                    return schemeData2;
                }
            }
        }
        return (DrmInitData.SchemeData) arrayList.get(0);
    }

    public static byte[] getSchemeInitData(DrmInitData.SchemeData schemeData, UUID uuid) {
        byte[] parseSchemeSpecificData;
        byte[] bArr = schemeData.data;
        if (Util.SDK_INT < 21 && (parseSchemeSpecificData = PsshAtomUtil.parseSchemeSpecificData(bArr, uuid)) != null) {
            return parseSchemeSpecificData;
        }
        return bArr;
    }

    public static String getSchemeMimeType(DrmInitData.SchemeData schemeData, UUID uuid) {
        String str = schemeData.mimeType;
        if (Util.SDK_INT < 26 && C.CLEARKEY_UUID.equals(uuid)) {
            if ("video/mp4".equals(str) || MimeTypes.AUDIO_MP4.equals(str)) {
                return "cenc";
            }
            return str;
        }
        return str;
    }

    public void setMode(int i, byte[] bArr) {
        Assertions.checkState(this.sessions.isEmpty());
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.mode = i;
        this.offlineLicenseKeySetId = bArr;
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID uuid, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        return new DefaultDrmSessionManager<>(uuid, FrameworkMediaDrm.newInstance(uuid), mediaDrmCallback, hashMap, handler, eventListener, false, 3);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback mediaDrmCallback, String str, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str)) {
            hashMap = new HashMap();
            hashMap.put(PLAYREADY_CUSTOM_DATA_KEY, str);
        } else {
            hashMap = null;
        }
        return newFrameworkInstance(C.PLAYREADY_UUID, mediaDrmCallback, hashMap, handler, eventListener);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        return newFrameworkInstance(C.WIDEVINE_UUID, mediaDrmCallback, hashMap, handler, eventListener);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData) {
        boolean z;
        byte[] bArr;
        String str;
        Looper looper2 = this.playbackLooper;
        if (looper2 != null && looper2 != looper) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkState(z);
        if (this.sessions.isEmpty()) {
            this.playbackLooper = looper;
            if (this.mediaDrmHandler == null) {
                this.mediaDrmHandler = new MediaDrmHandler(looper);
            }
        }
        DefaultDrmSession<T> defaultDrmSession = null;
        if (this.offlineLicenseKeySetId == null) {
            DrmInitData.SchemeData schemeData = getSchemeData(drmInitData, this.uuid, false);
            if (schemeData == null) {
                final IllegalStateException illegalStateException = new IllegalStateException("Media does not support uuid: " + this.uuid);
                Handler handler = this.eventHandler;
                if (handler != null && this.eventListener != null) {
                    handler.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DefaultDrmSessionManager.this.eventListener.onDrmSessionManagerError(illegalStateException);
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

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public boolean canAcquireSession(@NonNull DrmInitData drmInitData) {
        if (getSchemeData(drmInitData, this.uuid, true) == null) {
            return false;
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ((!C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cbcs.equals(str) && !C.CENC_TYPE_cens.equals(str)) || Util.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void releaseSession(DrmSession<T> drmSession) {
        if (drmSession instanceof ErrorStateDrmSession) {
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

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionCompleted() {
        for (DefaultDrmSession<T> defaultDrmSession : this.provisioningSessions) {
            defaultDrmSession.onProvisionCompleted();
        }
        this.provisioningSessions.clear();
    }
}
