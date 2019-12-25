package com.google.android.exoplayer2.text.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import java.util.LinkedList;
import java.util.PriorityQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class d implements com.google.android.exoplayer2.text.f {
    private final LinkedList<h> mvB = new LinkedList<>();
    private final LinkedList<i> mvC;
    private final PriorityQueue<h> mvD;
    private h mvE;
    private long playbackPositionUs;

    protected abstract void b(h hVar);

    protected abstract boolean dvq();

    protected abstract com.google.android.exoplayer2.text.e dvr();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.mvB.add(new h());
        }
        this.mvC = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.mvC.add(new e(this));
        }
        this.mvD = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gs(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dvv */
    public h drY() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkState(this.mvE == null);
        if (this.mvB.isEmpty()) {
            return null;
        }
        this.mvE = this.mvB.pollFirst();
        return this.mvE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: c */
    public void bu(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkArgument(hVar == this.mvE);
        if (hVar.drS()) {
            d(hVar);
        } else {
            this.mvD.add(hVar);
        }
        this.mvE = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dvu */
    public i drZ() throws SubtitleDecoderException {
        if (this.mvC.isEmpty()) {
            return null;
        }
        while (!this.mvD.isEmpty() && this.mvD.peek().lYY <= this.playbackPositionUs) {
            h poll = this.mvD.poll();
            if (poll.drT()) {
                i pollFirst = this.mvC.pollFirst();
                pollFirst.aH(4);
                d(poll);
                return pollFirst;
            }
            b(poll);
            if (dvq()) {
                com.google.android.exoplayer2.text.e dvr = dvr();
                if (!poll.drS()) {
                    i pollFirst2 = this.mvC.pollFirst();
                    pollFirst2.a(poll.lYY, dvr, Format.OFFSET_SAMPLE_RELATIVE);
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
        this.mvB.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.mvC.add(iVar);
    }

    @Override // com.google.android.exoplayer2.a.c
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.mvD.isEmpty()) {
            d(this.mvD.poll());
        }
        if (this.mvE != null) {
            d(this.mvE);
            this.mvE = null;
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
    }
}
