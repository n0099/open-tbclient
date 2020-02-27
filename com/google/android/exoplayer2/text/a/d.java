package com.google.android.exoplayer2.text.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import java.util.LinkedList;
import java.util.PriorityQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class d implements com.google.android.exoplayer2.text.f {
    private final LinkedList<i> mAa;
    private final PriorityQueue<h> mAb;
    private h mAc;
    private final LinkedList<h> mzZ = new LinkedList<>();
    private long playbackPositionUs;

    protected abstract void b(h hVar);

    protected abstract boolean dxN();

    protected abstract com.google.android.exoplayer2.text.e dxO();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.mzZ.add(new h());
        }
        this.mAa = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.mAa.add(new e(this));
        }
        this.mAb = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gv(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dxS */
    public h dux() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkState(this.mAc == null);
        if (this.mzZ.isEmpty()) {
            return null;
        }
        this.mAc = this.mzZ.pollFirst();
        return this.mAc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: c */
    public void bx(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkArgument(hVar == this.mAc);
        if (hVar.dur()) {
            d(hVar);
        } else {
            this.mAb.add(hVar);
        }
        this.mAc = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dxR */
    public i duy() throws SubtitleDecoderException {
        if (this.mAa.isEmpty()) {
            return null;
        }
        while (!this.mAb.isEmpty() && this.mAb.peek().mdB <= this.playbackPositionUs) {
            h poll = this.mAb.poll();
            if (poll.dus()) {
                i pollFirst = this.mAa.pollFirst();
                pollFirst.aK(4);
                d(poll);
                return pollFirst;
            }
            b(poll);
            if (dxN()) {
                com.google.android.exoplayer2.text.e dxO = dxO();
                if (!poll.dur()) {
                    i pollFirst2 = this.mAa.pollFirst();
                    pollFirst2.a(poll.mdB, dxO, Format.OFFSET_SAMPLE_RELATIVE);
                    d(poll);
                    return pollFirst2;
                }
            }
            d(poll);
        }
        return null;
    }

    private void d(h hVar) {
        hVar.clear();
        this.mzZ.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.mAa.add(iVar);
    }

    @Override // com.google.android.exoplayer2.a.c
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.mAb.isEmpty()) {
            d(this.mAb.poll());
        }
        if (this.mAc != null) {
            d(this.mAc);
            this.mAc = null;
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
    }
}
