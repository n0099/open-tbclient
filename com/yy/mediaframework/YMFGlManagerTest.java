package com.yy.mediaframework;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.IMConnection;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.YMFLog;
import java.text.MessageFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class YMFGlManagerTest implements Runnable {
    GlManager mGlManager;
    boolean mContinueTest = true;
    public Thread mLooperThread = new Thread(this, "YY_yyvideolib_GlManagerTest_Thread");

    public YMFGlManagerTest(GlManager glManager) {
        this.mGlManager = null;
        this.mGlManager = glManager;
        this.mLooperThread.start();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.mContinueTest) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mGlManager.post(new Runnable() { // from class: com.yy.mediaframework.YMFGlManagerTest.1
                @Override // java.lang.Runnable
                public void run() {
                    countDownLatch.countDown();
                }
            });
            if (!awaitUninterruptibly(countDownLatch, IMConnection.RETRY_DELAY_TIMES)) {
                StackTraceElement[] stackTrace = this.mGlManager.getHandler().getLooper().getThread().getStackTrace();
                if (stackTrace == null) {
                    YMFLog.error(this, "[Procedur]", "GlManager PostRunnable exeception:null");
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stringBuffer.length() > 0) {
                        stringBuffer.append(" <- ");
                        stringBuffer.append(System.getProperty("line.separator"));
                    }
                    stringBuffer.append(MessageFormat.format("{0}.{1}() {2}", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
                }
                YMFLog.error(this, "[Procedur]", "GlManager PostRunnable " + stringBuffer.toString());
                YMFLiveUsrBehaviorStat.getInstance().notifyGlManagerCheck(((Object) stringBuffer) + "");
            }
            try {
                Thread.sleep(IMConnection.RETRY_DELAY_TIMES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j) {
        boolean z = false;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z2 = false;
        long j2 = j;
        do {
            try {
                z = countDownLatch.await(j2, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e) {
                z2 = true;
                j2 = j - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (j2 <= 0) {
                }
            }
        } while (j2 <= 0);
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return z;
    }

    public void quit() {
        this.mContinueTest = false;
    }
}
