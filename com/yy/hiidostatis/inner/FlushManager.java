package com.yy.hiidostatis.inner;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.yy.hiidostatis.inner.util.Counter;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes10.dex */
public class FlushManager {
    public static final Object OBJ_KEY = new Object();
    public static Handler mHandler = new Handler(Looper.getMainLooper());
    public FlushListener l;
    public ConnectionChangeReceiver mReceiver;
    public ReportTimer mReportTimer = new ReportTimer();

    /* loaded from: classes10.dex */
    public interface FlushListener {
        void fluch(Context context);
    }

    /* loaded from: classes10.dex */
    public class ConnectionChangeReceiver extends BroadcastReceiver {
        public ConnectionChangeReceiver() {
        }

        public void registerReceiver(Context context) {
            try {
                L.debug(this, "ConnectionChangeReceiver registerReceiver", new Object[0]);
                context.registerReceiver(this, new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION));
            } catch (Throwable unused) {
                L.debug(this, "ConnectionChangeReceiver registerReceiver failure", new Object[0]);
            }
        }

        public void unregisterReceiver(Context context) {
            try {
                L.debug(this, "ConnectionChangeReceiver unregisterReceiver", new Object[0]);
                context.unregisterReceiver(this);
            } catch (Throwable unused) {
                L.debug(this, "ConnectionChangeReceiver unregisterReceiver failure", new Object[0]);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(NetworkMonitor.NET_CHANGE_ACTION) && FlushManager.this.l != null) {
                L.verbose(this, "ConnectionChangeReceiver onReceive .flush cache", new Object[0]);
                FlushManager.this.l.fluch(context);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class ReportTimer {
        public static final long DEFAULT_INTERVAL = 1800000;
        public static final long MAX_INTERVAL = 3600000;
        public static final long MIN_INTERVAL = 60000;
        public long mInterval;
        public Counter.Callback mReportExecutor;
        public Counter mReportInvoker;

        public ReportTimer() {
            this.mInterval = 1800000L;
        }

        public void stop(Context context) {
            if (this.mReportInvoker == null) {
                return;
            }
            try {
                L.brief("ReportTimer stop.", new Object[0]);
                this.mReportInvoker.stop();
                this.mReportInvoker = null;
                this.mReportExecutor = null;
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }

        public void start(Handler handler, final Context context, Long l) {
            try {
                if (this.mReportInvoker != null) {
                    return;
                }
                if (l != null && l.longValue() >= 60000 && l.longValue() <= 3600000) {
                    this.mInterval = l.longValue();
                }
                this.mReportInvoker = new Counter(handler, 0, this.mInterval, true);
                Counter.Callback callback = new Counter.Callback() { // from class: com.yy.hiidostatis.inner.FlushManager.ReportTimer.1
                    @Override // com.yy.hiidostatis.inner.util.Counter.Callback
                    public void onCount(int i) {
                        if (FlushManager.this.l != null) {
                            L.debug(this, "ReportTimer. flush cache. %d times", Integer.valueOf(i + 1));
                            FlushManager.this.l.fluch(context);
                        }
                    }
                };
                this.mReportExecutor = callback;
                this.mReportInvoker.setCallback(callback);
                this.mReportInvoker.start(this.mInterval);
                L.brief("ReportTimer start. interval:%d ms", Long.valueOf(this.mInterval));
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
    }

    public void regConnectionChangeReceiver(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (this.mReceiver == null) {
            synchronized (OBJ_KEY) {
                if (this.mReceiver == null) {
                    ConnectionChangeReceiver connectionChangeReceiver = new ConnectionChangeReceiver();
                    this.mReceiver = connectionChangeReceiver;
                    connectionChangeReceiver.registerReceiver(context);
                }
            }
        }
    }

    public void setFlushListener(FlushListener flushListener) {
        this.l = flushListener;
    }

    public void stopTimer(Context context) {
        this.mReportTimer.stop(context);
    }

    public void unRegConnectionChangeReceiver(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (this.mReceiver != null) {
            synchronized (OBJ_KEY) {
                if (this.mReceiver != null) {
                    this.mReceiver.unregisterReceiver(context);
                    this.mReceiver = null;
                }
            }
        }
    }

    public void startTimer(Context context, Long l) {
        this.mReportTimer.start(mHandler, context, l);
    }
}
