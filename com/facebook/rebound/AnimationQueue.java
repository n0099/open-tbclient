package com.facebook.rebound;

import com.facebook.rebound.ChoreographerCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes11.dex */
public class AnimationQueue {
    private boolean mRunning;
    private final Queue<Double> mPendingQueue = new LinkedList();
    private final Queue<Double> mAnimationQueue = new LinkedList();
    private final List<Callback> mCallbacks = new ArrayList();
    private final ArrayList<Double> mTempValues = new ArrayList<>();
    private final ChoreographerCompat mChoreographer = ChoreographerCompat.getInstance();
    private final ChoreographerCompat.FrameCallback mChoreographerCallback = new ChoreographerCompat.FrameCallback() { // from class: com.facebook.rebound.AnimationQueue.1
        @Override // com.facebook.rebound.ChoreographerCompat.FrameCallback
        public void doFrame(long j) {
            AnimationQueue.this.onFrame(j);
        }
    };

    /* loaded from: classes11.dex */
    public interface Callback {
        void onFrame(Double d);
    }

    public void addValue(Double d) {
        this.mPendingQueue.add(d);
        runIfIdle();
    }

    public void addAllValues(Collection<Double> collection) {
        this.mPendingQueue.addAll(collection);
        runIfIdle();
    }

    public void clearValues() {
        this.mPendingQueue.clear();
    }

    public void addCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    public void clearCallbacks() {
        this.mCallbacks.clear();
    }

    private void runIfIdle() {
        if (!this.mRunning) {
            this.mRunning = true;
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFrame(long j) {
        int max;
        Double poll = this.mPendingQueue.poll();
        if (poll != null) {
            this.mAnimationQueue.offer(poll);
            max = 0;
        } else {
            max = Math.max(this.mCallbacks.size() - this.mAnimationQueue.size(), 0);
        }
        this.mTempValues.addAll(this.mAnimationQueue);
        int size = this.mTempValues.size() - 1;
        while (true) {
            int i = size;
            if (i <= -1) {
                break;
            }
            Double d = this.mTempValues.get(i);
            int size2 = ((this.mTempValues.size() - 1) - i) + max;
            if (this.mCallbacks.size() > size2) {
                this.mCallbacks.get(size2).onFrame(d);
            }
            size = i - 1;
        }
        this.mTempValues.clear();
        while (this.mAnimationQueue.size() + max >= this.mCallbacks.size()) {
            this.mAnimationQueue.poll();
        }
        if (this.mAnimationQueue.isEmpty() && this.mPendingQueue.isEmpty()) {
            this.mRunning = false;
        } else {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }
}
