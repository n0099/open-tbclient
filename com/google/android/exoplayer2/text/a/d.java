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
    private final LinkedList<h> mzt = new LinkedList<>();
    private final LinkedList<i> mzu;
    private final PriorityQueue<h> mzv;
    private h mzw;
    private long playbackPositionUs;

    protected abstract void b(h hVar);

    protected abstract boolean dwD();

    protected abstract com.google.android.exoplayer2.text.e dwE();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.mzt.add(new h());
        }
        this.mzu = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.mzu.add(new e(this));
        }
        this.mzv = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gx(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dwI */
    public h dtm() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkState(this.mzw == null);
        if (this.mzt.isEmpty()) {
            return null;
        }
        this.mzw = this.mzt.pollFirst();
        return this.mzw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: c */
    public void bv(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkArgument(hVar == this.mzw);
        if (hVar.dtg()) {
            d(hVar);
        } else {
            this.mzv.add(hVar);
        }
        this.mzw = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dwH */
    public i dtn() throws SubtitleDecoderException {
        if (this.mzu.isEmpty()) {
            return null;
        }
        while (!this.mzv.isEmpty() && this.mzv.peek().mcV <= this.playbackPositionUs) {
            h poll = this.mzv.poll();
            if (poll.dth()) {
                i pollFirst = this.mzu.pollFirst();
                pollFirst.aH(4);
                d(poll);
                return pollFirst;
            }
            b(poll);
            if (dwD()) {
                com.google.android.exoplayer2.text.e dwE = dwE();
                if (!poll.dtg()) {
                    i pollFirst2 = this.mzu.pollFirst();
                    pollFirst2.a(poll.mcV, dwE, Format.OFFSET_SAMPLE_RELATIVE);
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
        this.mzt.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.mzu.add(iVar);
    }

    @Override // com.google.android.exoplayer2.a.c
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.mzv.isEmpty()) {
            d(this.mzv.poll());
        }
        if (this.mzw != null) {
            d(this.mzw);
            this.mzw = null;
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
    }
}
