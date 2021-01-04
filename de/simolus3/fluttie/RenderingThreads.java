package de.simolus3.fluttie;

import android.graphics.Canvas;
import androidx.annotation.RequiresApi;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4, 90=4] */
    @Override // java.lang.Runnable
    @RequiresApi(api = 15)
    public void run() {
        while (true) {
            FluttieAnimation fluttieAnimation = null;
            try {
                fluttieAnimation = this.queue.waitAndObtain();
                Canvas lockCanvas = fluttieAnimation.lockCanvas();
                if (lockCanvas != null) {
                    fluttieAnimation.drawFrame(lockCanvas);
                    fluttieAnimation.unlockCanvasAndPost(lockCanvas);
                    if (fluttieAnimation != null) {
                        this.queue.markCompleted(fluttieAnimation);
                    }
                } else if (fluttieAnimation != null) {
                    this.queue.markCompleted(fluttieAnimation);
                }
            } catch (InterruptedException e) {
                if (fluttieAnimation != null) {
                    this.queue.markCompleted(fluttieAnimation);
                }
            } catch (Throwable th) {
                if (fluttieAnimation != null) {
                    this.queue.markCompleted(fluttieAnimation);
                }
                throw th;
            }
        }
    }
}
