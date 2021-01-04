package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes6.dex */
public abstract class ChunkOffsetBox extends AbstractFullBox {
    private static final /* synthetic */ a.InterfaceC1274a ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ChunkOffsetBox.java", ChunkOffsetBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", FieldUtil.TYPE_STRING), 17);
    }

    public abstract long[] getChunkOffsets();

    public ChunkOffsetBox(String str) {
        super(str);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + getChunkOffsets().length + "]";
    }
}
