package com.googlecode.mp4parser;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.FullBox;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes9.dex */
public abstract class AbstractFullBox extends AbstractBox implements FullBox {
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public int flags;
    public int version;

    static {
        ajc$preClinit();
    }

    @Override // com.coremedia.iso.boxes.FullBox
    @DoNotParseDetail
    public int getFlags() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.flags;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    @DoNotParseDetail
    public int getVersion() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.version;
    }

    public AbstractFullBox(String str) {
        super(str);
    }

    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = IsoTypeReader.readUInt8(byteBuffer);
        this.flags = IsoTypeReader.readUInt24(byteBuffer);
        return 4L;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setFlags(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
        this.flags = i;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setVersion(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this, Conversions.intObject(i)));
        this.version = i;
    }

    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt8(byteBuffer, this.version);
        IsoTypeWriter.writeUInt24(byteBuffer, this.flags);
    }

    public AbstractFullBox(String str, byte[] bArr) {
        super(str, bArr);
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("AbstractFullBox.java", AbstractFullBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "version", "", "void"), 51);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "flags", "", "void"), 64);
    }
}
