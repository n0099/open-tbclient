package com.googlecode.mp4parser.boxes.ultraviolet;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public class BaseLocationBox extends AbstractFullBox {
    public static final String TYPE = "bloc";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public String baseLocation;
    public String purchaseLocation;

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 1028L;
    }

    static {
        ajc$preClinit();
    }

    public BaseLocationBox() {
        super(TYPE);
        this.baseLocation = "";
        this.purchaseLocation = "";
    }

    public String getBaseLocation() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.baseLocation;
    }

    public String getPurchaseLocation() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.purchaseLocation;
    }

    public int hashCode() {
        int i;
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
        String str = this.baseLocation;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * 31;
        String str2 = this.purchaseLocation;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public BaseLocationBox(String str, String str2) {
        super(TYPE);
        this.baseLocation = "";
        this.purchaseLocation = "";
        this.baseLocation = str;
        this.purchaseLocation = str2;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("BaseLocationBox.java", BaseLocationBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "java.lang.String", "baseLocation", "", "void"), 48);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPurchaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "java.lang.String"), 52);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPurchaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "java.lang.String", "purchaseLocation", "", "void"), 56);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "equals", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "java.lang.Object", "o", "", "boolean"), 86);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", TTDownloadField.TT_HASHCODE, "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "int"), 100);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "java.lang.String"), 107);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        String readString = IsoTypeReader.readString(byteBuffer);
        this.baseLocation = readString;
        byteBuffer.get(new byte[(256 - Utf8.utf8StringLengthInBytes(readString)) - 1]);
        String readString2 = IsoTypeReader.readString(byteBuffer);
        this.purchaseLocation = readString2;
        byteBuffer.get(new byte[(256 - Utf8.utf8StringLengthInBytes(readString2)) - 1]);
        byteBuffer.get(new byte[512]);
    }

    public void setBaseLocation(String str) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, str));
        this.baseLocation = str;
    }

    public void setPurchaseLocation(String str) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, str));
        this.purchaseLocation = str;
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || BaseLocationBox.class != obj.getClass()) {
            return false;
        }
        BaseLocationBox baseLocationBox = (BaseLocationBox) obj;
        String str = this.baseLocation;
        if (str == null ? baseLocationBox.baseLocation != null : !str.equals(baseLocationBox.baseLocation)) {
            return false;
        }
        String str2 = this.purchaseLocation;
        String str3 = baseLocationBox.purchaseLocation;
        if (str2 == null ? str3 == null : str2.equals(str3)) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.convert(this.baseLocation));
        byteBuffer.put(new byte[256 - Utf8.utf8StringLengthInBytes(this.baseLocation)]);
        byteBuffer.put(Utf8.convert(this.purchaseLocation));
        byteBuffer.put(new byte[256 - Utf8.utf8StringLengthInBytes(this.purchaseLocation)]);
        byteBuffer.put(new byte[512]);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
        return "BaseLocationBox{baseLocation='" + this.baseLocation + "', purchaseLocation='" + this.purchaseLocation + "'}";
    }
}
