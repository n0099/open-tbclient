package com.googlecode.mp4parser.boxes.ultraviolet;

import com.baidu.mobstat.Config;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class BaseLocationBox extends AbstractFullBox {
    public static final String TYPE = "bloc";
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_6 = null;
    public String baseLocation;
    public String purchaseLocation;

    static {
        ajc$preClinit();
    }

    public BaseLocationBox() {
        super(TYPE);
        this.baseLocation = "";
        this.purchaseLocation = "";
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("BaseLocationBox.java", BaseLocationBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getBaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setBaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "java.lang.String", "baseLocation", "", "void"), 48);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getPurchaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "java.lang.String"), 52);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setPurchaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "java.lang.String", "purchaseLocation", "", "void"), 56);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "equals", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "java.lang.Object", Config.OS, "", "boolean"), 86);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "hashCode", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "int"), 100);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "toString", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "java.lang.String"), 107);
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

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || BaseLocationBox.class != obj.getClass()) {
            return false;
        }
        BaseLocationBox baseLocationBox = (BaseLocationBox) obj;
        String str = this.baseLocation;
        if (str == null ? baseLocationBox.baseLocation == null : str.equals(baseLocationBox.baseLocation)) {
            String str2 = this.purchaseLocation;
            String str3 = baseLocationBox.purchaseLocation;
            return str2 == null ? str3 == null : str2.equals(str3);
        }
        return false;
    }

    public String getBaseLocation() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.baseLocation;
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

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 1028L;
    }

    public String getPurchaseLocation() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.purchaseLocation;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        String str = this.baseLocation;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.purchaseLocation;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setBaseLocation(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.baseLocation = str;
    }

    public void setPurchaseLocation(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.purchaseLocation = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return "BaseLocationBox{baseLocation='" + this.baseLocation + "', purchaseLocation='" + this.purchaseLocation + "'}";
    }

    public BaseLocationBox(String str, String str2) {
        super(TYPE);
        this.baseLocation = "";
        this.purchaseLocation = "";
        this.baseLocation = str;
        this.purchaseLocation = str2;
    }
}
