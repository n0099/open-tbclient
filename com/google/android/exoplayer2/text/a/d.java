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
    private final LinkedList<h> mAb = new LinkedList<>();
    private final LinkedList<i> mAc;
    private final PriorityQueue<h> mAd;
    private h mAe;
    private long playbackPositionUs;

    protected abstract void b(h hVar);

    protected abstract boolean dxP();

    protected abstract com.google.android.exoplayer2.text.e dxQ();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.mAb.add(new h());
        }
        this.mAc = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.mAc.add(new e(this));
        }
        this.mAd = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gv(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dxU */
    public h duz() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkState(this.mAe == null);
        if (this.mAb.isEmpty()) {
            return null;
        }
        this.mAe = this.mAb.pollFirst();
        return this.mAe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: c */
    public void bx(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkArgument(hVar == this.mAe);
        if (hVar.dut()) {
            d(hVar);
        } else {
            this.mAd.add(hVar);
        }
        this.mAe = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dxT */
    public i duA() throws SubtitleDecoderException {
        if (this.mAc.isEmpty()) {
            return null;
        }
        while (!this.mAd.isEmpty() && this.mAd.peek().mdD <= this.playbackPositionUs) {
            h poll = this.mAd.poll();
            if (poll.duu()) {
                i pollFirst = this.mAc.pollFirst();
                pollFirst.aK(4);
                d(poll);
                return pollFirst;
            }
            b(poll);
            if (dxP()) {
                com.google.android.exoplayer2.text.e dxQ = dxQ();
                if (!poll.dut()) {
                    i pollFirst2 = this.mAc.pollFirst();
                    pollFirst2.a(poll.mdD, dxQ, Format.OFFSET_SAMPLE_RELATIVE);
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
        this.mAb.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.mAc.add(iVar);
    }

    @Override // com.google.android.exoplayer2.a.c
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.mAd.isEmpty()) {
            d(this.mAd.poll());
        }
        if (this.mAe != null) {
            d(this.mAe);
            this.mAe = null;
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
    }
}
