package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class SnackbarManager {
    public static final int LONG_DURATION_MS = 2750;
    public static final int MSG_TIMEOUT = 0;
    public static final int SHORT_DURATION_MS = 1500;
    public static SnackbarManager snackbarManager;
    @Nullable
    public SnackbarRecord currentSnackbar;
    @Nullable
    public SnackbarRecord nextSnackbar;
    @NonNull
    public final Object lock = new Object();
    @NonNull
    public final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.handleTimeout((SnackbarRecord) message.obj);
            return true;
        }
    });

    /* loaded from: classes6.dex */
    public interface Callback {
        void dismiss(int i2);

        void show();
    }

    /* loaded from: classes6.dex */
    public static class SnackbarRecord {
        @NonNull
        public final WeakReference<Callback> callback;
        public int duration;
        public boolean paused;

        public SnackbarRecord(int i2, Callback callback) {
            this.callback = new WeakReference<>(callback);
            this.duration = i2;
        }

        public boolean isSnackbar(@Nullable Callback callback) {
            return callback != null && this.callback.get() == callback;
        }
    }

    private boolean cancelSnackbarLocked(@NonNull SnackbarRecord snackbarRecord, int i2) {
        Callback callback = snackbarRecord.callback.get();
        if (callback != null) {
            this.handler.removeCallbacksAndMessages(snackbarRecord);
            callback.dismiss(i2);
            return true;
        }
        return false;
    }

    public static SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new SnackbarManager();
        }
        return snackbarManager;
    }

    private boolean isCurrentSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.currentSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    private boolean isNextSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    private void scheduleTimeoutLocked(@NonNull SnackbarRecord snackbarRecord) {
        int i2 = snackbarRecord.duration;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : LONG_DURATION_MS;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.handler;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i2);
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord != null) {
            this.currentSnackbar = snackbarRecord;
            this.nextSnackbar = null;
            Callback callback = snackbarRecord.callback.get();
            if (callback != null) {
                callback.show();
            } else {
                this.currentSnackbar = null;
            }
        }
    }

    public void dismiss(Callback callback, int i2) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.currentSnackbar, i2);
            } else if (isNextSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.nextSnackbar, i2);
            }
        }
    }

    public void handleTimeout(@NonNull SnackbarRecord snackbarRecord) {
        synchronized (this.lock) {
            if (this.currentSnackbar == snackbarRecord || this.nextSnackbar == snackbarRecord) {
                cancelSnackbarLocked(snackbarRecord, 2);
            }
        }
    }

    public boolean isCurrent(Callback callback) {
        boolean isCurrentSnackbarLocked;
        synchronized (this.lock) {
            isCurrentSnackbarLocked = isCurrentSnackbarLocked(callback);
        }
        return isCurrentSnackbarLocked;
    }

    public boolean isCurrentOrNext(Callback callback) {
        boolean z;
        synchronized (this.lock) {
            z = isCurrentSnackbarLocked(callback) || isNextSnackbarLocked(callback);
        }
        return z;
    }

    public void onDismissed(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar = null;
                if (this.nextSnackbar != null) {
                    showNextSnackbarLocked();
                }
            }
        }
    }

    public void onShown(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                scheduleTimeoutLocked(this.currentSnackbar);
            }
        }
    }

    public void pauseTimeout(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback) && !this.currentSnackbar.paused) {
                this.currentSnackbar.paused = true;
                this.handler.removeCallbacksAndMessages(this.currentSnackbar);
            }
        }
    }

    public void restoreTimeoutIfPaused(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback) && this.currentSnackbar.paused) {
                this.currentSnackbar.paused = false;
                scheduleTimeoutLocked(this.currentSnackbar);
            }
        }
    }

    public void show(int i2, Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar.duration = i2;
                this.handler.removeCallbacksAndMessages(this.currentSnackbar);
                scheduleTimeoutLocked(this.currentSnackbar);
                return;
            }
            if (isNextSnackbarLocked(callback)) {
                this.nextSnackbar.duration = i2;
            } else {
                this.nextSnackbar = new SnackbarRecord(i2, callback);
            }
            if (this.currentSnackbar == null || !cancelSnackbarLocked(this.currentSnackbar, 4)) {
                this.currentSnackbar = null;
                showNextSnackbarLocked();
            }
        }
    }
}
