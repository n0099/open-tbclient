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
    private final LinkedList<h> mBU = new LinkedList<>();
    private final LinkedList<i> mBV;
    private final PriorityQueue<h> mBW;
    private h mBX;
    private long playbackPositionUs;

    protected abstract void b(h hVar);

    protected abstract boolean dyn();

    protected abstract com.google.android.exoplayer2.text.e dyo();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.mBU.add(new h());
        }
        this.mBV = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.mBV.add(new e(this));
        }
        this.mBW = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gw(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dys */
    public h duX() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkState(this.mBX == null);
        if (this.mBU.isEmpty()) {
            return null;
        }
        this.mBX = this.mBU.pollFirst();
        return this.mBX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: c */
    public void bx(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.checkArgument(hVar == this.mBX);
        if (hVar.duR()) {
            d(hVar);
        } else {
            this.mBW.add(hVar);
        }
        this.mBX = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dyr */
    public i duY() throws SubtitleDecoderException {
        if (this.mBV.isEmpty()) {
            return null;
        }
        while (!this.mBW.isEmpty() && this.mBW.peek().mfu <= this.playbackPositionUs) {
            h poll = this.mBW.poll();
            if (poll.duS()) {
                i pollFirst = this.mBV.pollFirst();
                pollFirst.aK(4);
                d(poll);
                return pollFirst;
            }
            b(poll);
            if (dyn()) {
                com.google.android.exoplayer2.text.e dyo = dyo();
                if (!poll.duR()) {
                    i pollFirst2 = this.mBV.pollFirst();
                    pollFirst2.a(poll.mfu, dyo, Format.OFFSET_SAMPLE_RELATIVE);
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
        this.mBU.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.mBV.add(iVar);
    }

    @Override // com.google.android.exoplayer2.a.c
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.mBW.isEmpty()) {
            d(this.mBW.poll());
        }
        if (this.mBX != null) {
            d(this.mBX);
            this.mBX = null;
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
    }
}
