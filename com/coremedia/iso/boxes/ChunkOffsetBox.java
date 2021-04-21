package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
/* loaded from: classes5.dex */
public abstract class ChunkOffsetBox extends AbstractFullBox {
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    public ChunkOffsetBox(String str) {
        super(str);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ChunkOffsetBox.java", ChunkOffsetBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 17);
    }

    public abstract long[] getChunkOffsets();

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + getChunkOffsets().length + "]";
    }
}
