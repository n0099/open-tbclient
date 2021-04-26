package com.googlecode.mp4parser.boxes.piff;

import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox;
import g.a.a.a;
import g.a.b.b.b;
/* loaded from: classes6.dex */
public class PiffTrackEncryptionBox extends AbstractTrackEncryptionBox {
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    public PiffTrackEncryptionBox() {
        super("uuid");
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("PiffTrackEncryptionBox.java", PiffTrackEncryptionBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getFlags", "com.googlecode.mp4parser.boxes.piff.PiffTrackEncryptionBox", "", "", "", "int"), 29);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox, com.coremedia.iso.boxes.FullBox
    public int getFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getUserType() {
        return new byte[]{-119, 116, -37, -50, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, -25, 76, 81, -124, -7, 113, 72, -7, -120, 37, 84};
    }
}
