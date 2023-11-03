package com.google.zxing.oned.rss.expanded.decoders;
/* loaded from: classes10.dex */
public final class BlockParsedResult {
    public final DecodedInformation decodedInformation;
    public final boolean finished;

    public BlockParsedResult(DecodedInformation decodedInformation, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation;
    }

    public BlockParsedResult(boolean z) {
        this(null, z);
    }

    public DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    public boolean isFinished() {
        return this.finished;
    }
}
