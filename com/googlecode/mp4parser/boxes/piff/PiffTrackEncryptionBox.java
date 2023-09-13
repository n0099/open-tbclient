package com.googlecode.mp4parser.boxes.piff;

import androidx.exifinterface.media.ExifInterface;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public class PiffTrackEncryptionBox extends AbstractTrackEncryptionBox {
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    public PiffTrackEncryptionBox() {
        super("uuid");
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("PiffTrackEncryptionBox.java", PiffTrackEncryptionBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getFlags", "com.googlecode.mp4parser.boxes.piff.PiffTrackEncryptionBox", "", "", "", "int"), 29);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox, com.coremedia.iso.boxes.FullBox
    public int getFlags() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getUserType() {
        return new byte[]{-119, 116, -37, ExifInterface.MARKER_SOF14, 123, -25, 76, 81, -124, -7, 113, 72, -7, -120, 37, 84};
    }
}
