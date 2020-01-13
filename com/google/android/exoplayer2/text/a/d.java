package com.google.android.exoplayer2.text.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import java.util.LinkedList;
import java.util.PriorityQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class d implements com.google.android.exoplayer2.text.f {
    private final LinkedList<h> mzo = new LinkedList<>();
    private final LinkedList<i> mzp;
    private final PriorityQueue<h> mzq;
    private h mzr;
    private long playbackPositionUs;

    protected abstract void b(h hVar);

    protected abstract boolean dwB();

    protected abstract com.google.android.exoplayer2.text.e dwC();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.mzo.add(new h());
        }
        this.mzp = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.mzp.add(new e(this));
        }
        this.mzq = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gx(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dwG */
    public h dtk() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkState(this.mzr == null);
        if (this.mzo.isEmpty()) {
            return null;
        }
        this.mzr = this.mzo.pollFirst();
        return this.mzr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: c */
    public void bv(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkArgument(hVar == this.mzr);
        if (hVar.dte()) {
            d(hVar);
        } else {
            this.mzq.add(hVar);
        }
        this.mzr = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dwF */
    public i dtl() throws SubtitleDecoderException {
        if (this.mzp.isEmpty()) {
            return null;
        }
        while (!this.mzq.isEmpty() && this.mzq.peek().mcQ <= this.playbackPositionUs) {
            h poll = this.mzq.poll();
            if (poll.dtf()) {
                i pollFirst = this.mzp.pollFirst();
                pollFirst.aH(4);
                d(poll);
                return pollFirst;
            }
            b(poll);
            if (dwB()) {
                com.google.android.exoplayer2.text.e dwC = dwC();
                if (!poll.dte()) {
                    i pollFirst2 = this.mzp.pollFirst();
                    pollFirst2.a(poll.mcQ, dwC, Format.OFFSET_SAMPLE_RELATIVE);
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
        this.mzo.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.mzp.add(iVar);
    }

    @Override // com.google.android.exoplayer2.a.c
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.mzq.isEmpty()) {
            d(this.mzq.poll());
        }
        if (this.mzr != null) {
            d(this.mzr);
            this.mzr = null;
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
    }
}
