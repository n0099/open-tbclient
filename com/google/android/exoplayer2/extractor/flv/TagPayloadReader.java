package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
/* loaded from: classes6.dex */
abstract class TagPayloadReader {
    protected final m meL;

    protected abstract void a(l lVar, long j) throws ParserException;

    protected abstract boolean a(l lVar) throws ParserException;

    /* loaded from: classes6.dex */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TagPayloadReader(m mVar) {
        this.meL = mVar;
    }

    public final void b(l lVar, long j) throws ParserException {
        if (a(lVar)) {
            a(lVar, j);
        }
    }
}
