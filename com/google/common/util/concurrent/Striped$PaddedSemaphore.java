package com.google.common.util.concurrent;

import java.util.concurrent.Semaphore;
/* loaded from: classes6.dex */
public class Striped$PaddedSemaphore extends Semaphore {
    public long unused1;
    public long unused2;
    public long unused3;

    public Striped$PaddedSemaphore(int i2) {
        super(i2, false);
    }
}
