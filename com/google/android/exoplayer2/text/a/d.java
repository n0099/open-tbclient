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
    private final LinkedList<h> mAn = new LinkedList<>();
    private final LinkedList<i> mAo;
    private final PriorityQueue<h> mAp;
    private h mAq;
    private long playbackPositionUs;

    protected abstract void b(h hVar);

    protected abstract boolean dxQ();

    protected abstract com.google.android.exoplayer2.text.e dxR();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.mAn.add(new h());
        }
        this.mAo = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.mAo.add(new e(this));
        }
        this.mAp = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gv(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dxV */
    public h duA() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkState(this.mAq == null);
        if (this.mAn.isEmpty()) {
            return null;
        }
        this.mAq = this.mAn.pollFirst();
        return this.mAq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: c */
    public void bx(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkArgument(hVar == this.mAq);
        if (hVar.duu()) {
            d(hVar);
        } else {
            this.mAp.add(hVar);
        }
        this.mAq = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dxU */
    public i duB() throws SubtitleDecoderException {
        if (this.mAo.isEmpty()) {
            return null;
        }
        while (!this.mAp.isEmpty() && this.mAp.peek().mdO <= this.playbackPositionUs) {
            h poll = this.mAp.poll();
            if (poll.duv()) {
                i pollFirst = this.mAo.pollFirst();
                pollFirst.aK(4);
                d(poll);
                return pollFirst;
            }
            b(poll);
            if (dxQ()) {
                com.google.android.exoplayer2.text.e dxR = dxR();
                if (!poll.duu()) {
                    i pollFirst2 = this.mAo.pollFirst();
                    pollFirst2.a(poll.mdO, dxR, Format.OFFSET_SAMPLE_RELATIVE);
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
        this.mAn.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.mAo.add(iVar);
    }

    @Override // com.google.android.exoplayer2.a.c
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.mAp.isEmpty()) {
            d(this.mAp.poll());
        }
        if (this.mAq != null) {
            d(this.mAq);
            this.mAq = null;
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
    }
}
