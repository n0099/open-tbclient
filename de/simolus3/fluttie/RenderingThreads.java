package de.simolus3.fluttie;

import android.graphics.Canvas;
import android.support.annotation.RequiresApi;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class RenderingThreads implements Runnable {
    private List<Thread> threads = new ArrayList();
    private RenderingQueue queue = new RenderingQueue();
    private boolean threadsStarted = false;
    private volatile boolean dontAcceptTasks = false;

    public RenderingThreads(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.threads.add(new Thread(this, "Fluttie Rendering Thread #" + i2));
        }
    }

    public RenderingQueue getQueue() {
        return this.queue;
    }

    public void start() {
        this.dontAcceptTasks = false;
        BdLog.d("RenderingThreads now accepting tasks again");
        if (!this.threadsStarted) {
            for (Thread thread : this.threads) {
                thread.start();
            }
            this.threadsStarted = true;
        }
    }

    public void stop() {
        BdLog.d("Stopped rendering threads");
        this.queue.clearBacklog();
        this.dontAcceptTasks = true;
    }

    public void markDirty(FluttieAnimation fluttieAnimation) {
        if (!this.dontAcceptTasks) {
            this.queue.scheduleDrawing(fluttieAnimation);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=5, 90=4] */
    @Override // java.lang.Runnable
    @RequiresApi(api = 15)
    public void run() {
        FluttieAnimation fluttieAnimation;
        Throwable th;
        FluttieAnimation waitAndObtain;
        while (true) {
            try {
                try {
                    waitAndObtain = this.queue.waitAndObtain();
                } catch (InterruptedException e) {
                    if (0 != 0) {
                        this.queue.markCompleted(null);
                    }
                }
                try {
                    Canvas lockCanvas = waitAndObtain.lockCanvas();
                    if (lockCanvas != null) {
                        waitAndObtain.drawFrame(lockCanvas);
                        waitAndObtain.unlockCanvasAndPost(lockCanvas);
                        if (waitAndObtain != null) {
                            this.queue.markCompleted(waitAndObtain);
                        }
                    } else if (waitAndObtain != null) {
                        this.queue.markCompleted(waitAndObtain);
                    }
                } catch (Throwable th2) {
                    fluttieAnimation = waitAndObtain;
                    th = th2;
                    if (fluttieAnimation != null) {
                        this.queue.markCompleted(fluttieAnimation);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                fluttieAnimation = null;
                th = th3;
            }
        }
    }
}
