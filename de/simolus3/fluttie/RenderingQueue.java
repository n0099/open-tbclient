package de.simolus3.fluttie;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class RenderingQueue {
    private LinkedList<FluttieAnimation> backlog = new LinkedList<>();
    private Set<FluttieAnimation> currentlyHandling = new HashSet();
    private final ReentrantLock lock = new ReentrantLock();
    private final Object idleLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public FluttieAnimation waitAndObtain() throws InterruptedException {
        while (true) {
            FluttieAnimation obtain = obtain();
            if (obtain == null) {
                synchronized (this.idleLock) {
                    this.idleLock.wait();
                }
            } else {
                return obtain;
            }
        }
    }

    @Nullable
    FluttieAnimation obtain() {
        try {
            this.lock.lock();
            FluttieAnimation poll = this.backlog.poll();
            this.currentlyHandling.add(poll);
            return poll;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markCompleted(FluttieAnimation fluttieAnimation) {
        try {
            this.lock.lock();
            this.currentlyHandling.remove(fluttieAnimation);
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [107=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleDrawing(FluttieAnimation fluttieAnimation) {
        try {
            this.lock.lock();
            if (this.backlog.contains(fluttieAnimation)) {
                return;
            }
            if (this.currentlyHandling.contains(fluttieAnimation)) {
                return;
            }
            this.backlog.add(fluttieAnimation);
            synchronized (this.idleLock) {
                this.idleLock.notify();
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAnimation(FluttieAnimation fluttieAnimation) {
        try {
            this.lock.lock();
            this.backlog.remove(fluttieAnimation);
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearBacklog() {
        try {
            this.lock.lock();
            this.backlog.clear();
        } finally {
            this.lock.unlock();
        }
    }
}
