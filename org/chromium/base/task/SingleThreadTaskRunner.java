package org.chromium.base.task;
/* loaded from: classes2.dex */
public interface SingleThreadTaskRunner extends SequencedTaskRunner {
    boolean belongsToCurrentThread();
}
