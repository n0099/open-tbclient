package com.ksad.download;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.q;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    private int mAllowedNetworkTypes;
    protected transient com.kwai.filedownloader.a mBaseDownloadTask;
    private String mDestinationDir;
    private String mDestinationFileName;
    private transient List<c> mDownloadListeners = new ArrayList();
    private boolean mIsCanceled = false;
    private int mNotificationVisibility;
    private Map<String, String> mRequestHeaders;
    private Serializable mTag;
    private String mUrl;
    private boolean mUserPause;
    private boolean mWakeInstallApk;

    /* loaded from: classes4.dex */
    public static class DownloadRequest implements Serializable {
        private static final long serialVersionUID = -3638290207248829674L;
        private int mAllowedNetworkTypes;
        private String mDestinationDir;
        private String mDestinationFileName;
        private String mDownloadUrl;
        private Serializable mTag;
        private final Map<String, String> mRequestHeaders = new HashMap();
        private boolean mInstallAfterDownload = true;
        @Deprecated
        private boolean mIsPhotoAdDownloadRequest = false;
        private int mNotificationVisibility = 0;

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            if (!b.b().exists()) {
                b.b().mkdirs();
            }
            this.mDestinationDir = b.b().getPath();
            this.mDownloadUrl = str;
            NetworkInfo c = com.ksad.download.d.b.c(b.a());
            if (c == null || c.getType() != 0) {
                this.mAllowedNetworkTypes = 2;
            } else {
                this.mAllowedNetworkTypes = 3;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("header cannot be null");
            }
            if (str.contains(":")) {
                throw new IllegalArgumentException("header may not contain ':'");
            }
            if (str2 == null) {
                str2 = "";
            }
            this.mRequestHeaders.put(str, str2);
            return this;
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

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
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

        public DownloadRequest setInstallAfterDownload(boolean z) {
            this.mInstallAfterDownload = z;
            return this;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public DownloadRequest setNotificationVisibility(int i) {
            this.mNotificationVisibility = i;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
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
    }

    private void initDownloadTaskParams() {
        this.mBaseDownloadTask.a(this.mTag);
        this.mBaseDownloadTask.b((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.b(entry.getKey());
            this.mBaseDownloadTask.a(entry.getKey(), entry.getValue());
        }
    }

    private void notifyDownloadCompleted(com.kwai.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            e.a().b(this);
        }
    }

    private void notifyDownloadPending(com.kwai.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            e.a().a(this);
        }
    }

    private void notifyDownloadProgress(com.kwai.filedownloader.a aVar, boolean z) {
        if ((aVar.s() == 0 && aVar.q() == 0) || TextUtils.isEmpty(aVar.n()) || (this.mNotificationVisibility & 1) == 0) {
            return;
        }
        e.a().a(this, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(com.kwai.filedownloader.a aVar) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.a(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onCanceled(com.kwai.filedownloader.a aVar) {
        try {
            this.mIsCanceled = true;
            for (c cVar : this.mDownloadListeners) {
                cVar.e(this);
            }
            aVar.g();
            e.a().a(getId());
            q.a().a(getId(), this.mBaseDownloadTask.o());
            releaseDownloadTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(com.kwai.filedownloader.a aVar) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.b(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                wakeInstallApk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected(com.kwai.filedownloader.a aVar, String str, boolean z, int i, int i2) {
        long j;
        long j2 = i2;
        try {
            j = new File(this.mDestinationDir).exists() ? com.ksad.download.d.a.a(this.mDestinationDir) : com.ksad.download.d.a.a(Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e) {
            e.printStackTrace();
            j = j2;
        }
        if (j < i2) {
            Intent intent = new Intent(com.kwad.sdk.core.download.a.n);
            intent.putExtra("download.intent.action.EXTRA_TASK_ID", aVar.h());
            b.a().sendBroadcast(intent);
            onLowStorage(aVar);
            return;
        }
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.a(this, str, z, i, i2);
            }
            notifyDownloadProgress(aVar, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(com.kwai.filedownloader.a aVar, int i, int i2) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.b(this, i, i2);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.kwai.filedownloader.a aVar, Throwable th) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.a(this, th);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onLowStorage(com.kwai.filedownloader.a aVar) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.f(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(com.kwai.filedownloader.a aVar, int i, int i2) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.c(this, i, i2);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(com.kwai.filedownloader.a aVar, int i, int i2) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.a(this, i, i2);
            }
            notifyDownloadPending(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onResume(com.kwai.filedownloader.a aVar, int i, int i2) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.d(this, i, i2);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(com.kwai.filedownloader.a aVar) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.c(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(com.kwai.filedownloader.a aVar) {
        try {
            for (c cVar : this.mDownloadListeners) {
                cVar.d(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.a((i) null);
        clearListener();
    }

    private void wakeInstallApk() {
        b.a(this.mBaseDownloadTask.o());
    }

    public void addListener(c cVar) {
        if (cVar == null || this.mDownloadListeners.contains(cVar)) {
            return;
        }
        this.mDownloadListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    int downLoadProgress() {
        long s = this.mBaseDownloadTask.s();
        int q = s != 0 ? (int) ((100.0f * this.mBaseDownloadTask.q()) / ((float) s)) : 0;
        if (q != 100 || com.ksad.download.d.a.a(new File(this.mBaseDownloadTask.o()))) {
            return q;
        }
        return 0;
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    public String getFilename() {
        return this.mBaseDownloadTask.n();
    }

    public int getId() {
        return this.mBaseDownloadTask.h();
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getPath() {
        return this.mBaseDownloadTask.l();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.q();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.s();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.u();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.v();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.w();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.z();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.o();
    }

    public String getUrl() {
        return this.mUrl;
    }

    void installApk() {
        try {
            wakeInstallApk();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void instantiateDownloadTask() {
        this.mBaseDownloadTask = q.a().a(this.mUrl).a(true).a(3).a(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).a(new i() { // from class: com.ksad.download.DownloadTask.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void a(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void a(com.kwai.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onPending(aVar, i, i2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void a(com.kwai.filedownloader.a aVar, String str, boolean z, int i, int i2) {
                DownloadTask.this.onConnected(aVar, str, z, i, i2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void a(com.kwai.filedownloader.a aVar, Throwable th) {
                DownloadTask.this.onError(aVar, th);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void b(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void b(com.kwai.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onDownloading(aVar, i, i2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void c(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void c(com.kwai.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onPause(aVar, i, i2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwai.filedownloader.i
            public void d(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onWarn(aVar);
            }
        });
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.v() == -3;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.v() == -1;
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.E() && isError() && (this.mBaseDownloadTask.y() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.v() == 0;
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.v() == -2;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.c();
    }

    boolean isUserPause() {
        return this.mUserPause;
    }

    void pause() {
        this.mBaseDownloadTask.f();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void removeListener(c cVar) {
        if (cVar != null) {
            this.mDownloadListeners.remove(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume(DownloadRequest downloadRequest) {
        if (com.ksad.download.d.b.a(b.a())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (this.mBaseDownloadTask.c()) {
                return;
            }
            try {
                if (com.kwai.filedownloader.d.d.a(this.mBaseDownloadTask.v())) {
                    this.mBaseDownloadTask.b();
                }
                submit();
                onResume(this.mBaseDownloadTask, this.mBaseDownloadTask.q(), this.mBaseDownloadTask.s());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setAllowedNetworkTypes(int i) {
        this.mAllowedNetworkTypes = i;
        this.mBaseDownloadTask.b((this.mAllowedNetworkTypes ^ 2) == 0);
    }

    public void submit() {
        try {
            if (this.mBaseDownloadTask.c()) {
                return;
            }
            this.mBaseDownloadTask.e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    com.kwai.filedownloader.a unwrap() {
        return this.mBaseDownloadTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void userPause() {
        this.mUserPause = true;
        pause();
    }
}
