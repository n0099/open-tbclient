package com.kwad.sdk;

import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class DownloadTask implements Serializable {
    public static final long serialVersionUID = -7092669850073266500L;
    public int mAllowedNetworkTypes;
    public transient com.kwad.framework.filedownloader.a mBaseDownloadTask;
    public String mDestinationDir;
    public String mDestinationFileName;
    public int mNotificationVisibility;
    public Map<String, String> mRequestHeaders;
    public Serializable mTag;
    public String mUrl;
    public boolean mUserPause;
    public boolean mWakeInstallApk;
    public transient List<a> mDownloadListeners = new ArrayList();
    public boolean mIsCanceled = false;
    public boolean downloadEnablePause = false;
    public boolean notificationRemoved = false;

    /* loaded from: classes10.dex */
    public static class DownloadRequest implements Serializable {
        public static final long serialVersionUID = -3638290207248829674L;
        public int mAllowedNetworkTypes;
        public String mDestinationFileName;
        public String mDownloadUrl;
        public Serializable mTag;
        public final Map<String, String> mRequestHeaders = new HashMap();
        public boolean mInstallAfterDownload = true;
        @Deprecated
        public boolean mIsPhotoAdDownloadRequest = false;
        public int mNotificationVisibility = 0;
        public boolean downloadEnablePause = false;
        public String mDestinationDir = c.xA().xB().getPath();

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            this.mDownloadUrl = str;
            NetworkInfo cj = ag.cj(c.xA().getContext());
            if (cj != null && cj.getType() == 0) {
                this.mAllowedNetworkTypes = 3;
            } else {
                this.mAllowedNetworkTypes = 2;
            }
        }

        public DownloadRequest setAllowedNetworkTypes(int i) {
            this.mAllowedNetworkTypes = i;
            return this;
        }

        public DownloadRequest setDestinationDir(String str) {
            this.mDestinationDir = str;
            return this;
        }

        public DownloadRequest setDestinationFileName(String str) {
            this.mDestinationFileName = str;
            return this;
        }

        public void setDownloadEnablePause(boolean z) {
            this.downloadEnablePause = z;
        }

        public DownloadRequest setInstallAfterDownload(boolean z) {
            this.mInstallAfterDownload = z;
            return this;
        }

        public DownloadRequest setNotificationVisibility(int i) {
            this.mNotificationVisibility = i;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            ap.fZ(str);
            if (!str.contains(":")) {
                if (str2 == null) {
                    str2 = "";
                }
                this.mRequestHeaders.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("header may not contain ':'");
        }

        public int getAllowedNetworkTypes() {
            return this.mAllowedNetworkTypes;
        }

        public String getDestinationDir() {
            return this.mDestinationDir;
        }

        public String getDestinationFileName() {
            return this.mDestinationFileName;
        }

        public String getDownloadUrl() {
            return this.mDownloadUrl;
        }

        public Serializable getTag() {
            return this.mTag;
        }

        public boolean isDownloadEnablePause() {
            return this.downloadEnablePause;
        }

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    private void notifyDownloadCompleted(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.k(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadError(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.j(DownloadTask.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.a(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                installApk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onLowStorage(com.kwad.framework.filedownloader.a aVar) {
        try {
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.f(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(com.kwad.framework.filedownloader.a aVar) {
        try {
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.b(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    public void addListener(a aVar) {
        if (aVar != null && !this.mDownloadListeners.contains(aVar)) {
            this.mDownloadListeners.add(aVar);
        }
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            this.mDownloadListeners.remove(aVar);
        }
    }

    public void setAllowedNetworkTypes(int i) {
        boolean z;
        this.mAllowedNetworkTypes = i;
        com.kwad.framework.filedownloader.a aVar = this.mBaseDownloadTask;
        if ((i ^ 2) == 0) {
            z = true;
        } else {
            z = false;
        }
        aVar.bb(z);
    }

    public void setNotificationRemoved(boolean z) {
        this.notificationRemoved = z;
    }

    private void notify(DownloadTask downloadTask, com.kwad.sdk.g.a<d> aVar) {
        d xC = c.xA().xC();
        if (xC == null) {
            return;
        }
        if (downloadTask.isCanceled()) {
            xC.bO(downloadTask.getId());
        } else {
            aVar.accept(xC);
        }
    }

    private void notifyDownloadProgress(com.kwad.framework.filedownloader.a aVar, final boolean z) {
        if ((aVar.getSmallFileTotalBytes() != 0 || aVar.getSmallFileSoFarBytes() != 0) && !TextUtils.isEmpty(aVar.getFilename()) && (this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.a(DownloadTask.this, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.kwad.framework.filedownloader.a aVar, Throwable th) {
        try {
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.a(this, th);
            }
            notifyDownloadError(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.a(this, i, i2);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.c(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadPending();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onResume(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.e(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
        this.mUrl = downloadRequest.mDownloadUrl;
        this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
        this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
        this.mDestinationDir = downloadRequest.mDestinationDir;
        this.mDestinationFileName = downloadRequest.mDestinationFileName;
        this.mRequestHeaders = downloadRequest.mRequestHeaders;
        this.mTag = downloadRequest.mTag;
        this.downloadEnablePause = downloadRequest.isDownloadEnablePause();
    }

    private void onCanceled(com.kwad.framework.filedownloader.a aVar) {
        try {
            this.mIsCanceled = true;
            for (a aVar2 : this.mDownloadListeners) {
                aVar2.d(this);
            }
            aVar.cancel();
            notifyDownloadCanceled();
            r.uK().n(getId(), this.mBaseDownloadTask.getTargetFilePath());
            releaseDownloadTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initDownloadTaskParams() {
        boolean z;
        this.mBaseDownloadTask.e(this.mTag);
        com.kwad.framework.filedownloader.a aVar = this.mBaseDownloadTask;
        if ((this.mAllowedNetworkTypes ^ 2) == 0) {
            z = true;
        } else {
            z = false;
        }
        aVar.bb(z);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.aT(entry.getKey());
            this.mBaseDownloadTask.q(entry.getKey(), entry.getValue());
        }
    }

    private void notifyDownloadCanceled() {
        d xC = c.xA().xC();
        if (xC == null) {
            return;
        }
        xC.bO(getId());
    }

    private void notifyDownloadPending() {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.i(DownloadTask.this);
                }
            });
        }
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.a(null);
        clearListener();
    }

    public void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    public String getFilename() {
        return this.mBaseDownloadTask.getFilename();
    }

    public int getId() {
        return this.mBaseDownloadTask.getId();
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getPath() {
        return this.mBaseDownloadTask.getPath();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.getSmallFileSoFarBytes();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.getSmallFileTotalBytes();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.getSpeed();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.tL();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.getStatusUpdateTime();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.getTag();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.getTargetFilePath();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void installApk() {
        try {
            c.xA().g(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        if (this.mBaseDownloadTask.tL() == -3) {
            return true;
        }
        return false;
    }

    public boolean isError() {
        if (this.mBaseDownloadTask.tL() == -1) {
            return true;
        }
        return false;
    }

    public boolean isErrorBecauseWifiRequired() {
        if (this.mBaseDownloadTask.tS() && isError() && (this.mBaseDownloadTask.tN() instanceof FileDownloadNetworkPolicyException)) {
            return true;
        }
        return false;
    }

    public boolean isInvalid() {
        if (this.mBaseDownloadTask.tL() == 0) {
            return true;
        }
        return false;
    }

    public boolean isNotificationRemoved() {
        return this.notificationRemoved;
    }

    public boolean isPaused() {
        if (this.mBaseDownloadTask.tL() == -2) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.isRunning();
    }

    public boolean isUserPause() {
        return this.mUserPause;
    }

    public void pause() {
        this.mBaseDownloadTask.pause();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void submit() {
        try {
            if (!this.mBaseDownloadTask.isRunning()) {
                this.mBaseDownloadTask.start();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public com.kwad.framework.filedownloader.a unwrap() {
        return this.mBaseDownloadTask;
    }

    public void userPause() {
        this.mUserPause = true;
        pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected(com.kwad.framework.filedownloader.a aVar, String str, boolean z, int i, int i2) {
        long j;
        long j2 = i2;
        try {
            if (new File(this.mDestinationDir).exists()) {
                j = com.kwad.sdk.crash.utils.h.getAvailableBytes(this.mDestinationDir);
            } else {
                j = com.kwad.sdk.crash.utils.h.getAvailableBytes(Environment.getExternalStorageDirectory().getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
            j = j2;
        }
        if (j < j2) {
            c.xA().cancel(aVar.getId());
            notifyDownloadCanceled();
            onLowStorage(aVar);
            return;
        }
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadProgress(aVar, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int downLoadProgress() {
        int i;
        long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
        if (smallFileTotalBytes != 0) {
            i = (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / ((float) smallFileTotalBytes));
        } else {
            i = 0;
        }
        if (i == 100 && !q.M(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
            return 0;
        }
        return i;
    }

    public void instantiateDownloadTask() {
        String path;
        r.uK();
        com.kwad.framework.filedownloader.a aS = r.aV(this.mUrl).aZ(true).aS(3);
        if (TextUtils.isEmpty(this.mDestinationFileName)) {
            path = this.mDestinationDir;
        } else {
            path = new File(this.mDestinationDir, this.mDestinationFileName).getPath();
        }
        this.mBaseDownloadTask = aS.c(path, TextUtils.isEmpty(this.mDestinationFileName)).a(new com.kwad.framework.filedownloader.i() { // from class: com.kwad.sdk.DownloadTask.1
            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void d(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onWarn(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onPending(aVar, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onDownloading(aVar, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onPause(aVar, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, String str, boolean z, int i, int i2) {
                DownloadTask.this.onConnected(aVar, str, z, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                DownloadTask.this.onError(aVar, th);
            }
        });
    }

    public void resume(DownloadRequest downloadRequest) {
        if (!ag.isNetworkConnected(c.xA().getContext())) {
            return;
        }
        if (downloadRequest != null) {
            initDownloadRequestParams(downloadRequest);
            initDownloadTaskParams();
        }
        this.mUserPause = false;
        if (!this.mBaseDownloadTask.isRunning()) {
            try {
                if (com.kwad.framework.filedownloader.d.d.bA(this.mBaseDownloadTask.tL())) {
                    this.mBaseDownloadTask.tD();
                }
                submit();
                onResume(this.mBaseDownloadTask, this.mBaseDownloadTask.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        com.kwad.framework.filedownloader.a aVar = this.mBaseDownloadTask;
        onResume(aVar, aVar.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
    }
}
