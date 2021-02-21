package com.googlecode.mp4parser.boxes.ultraviolet;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.baidu.mobstat.Config;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes6.dex */
public class BaseLocationBox extends AbstractFullBox {
    public static final String TYPE = "bloc";
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_6 = null;
    String baseLocation;
    String purchaseLocation;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("BaseLocationBox.java", BaseLocationBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getBaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", FieldUtil.TYPE_STRING), 44);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setBaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", FieldUtil.TYPE_STRING, "baseLocation", "", "void"), 48);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getPurchaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", FieldUtil.TYPE_STRING), 52);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setPurchaseLocation", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", FieldUtil.TYPE_STRING, "purchaseLocation", "", "void"), 56);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "equals", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "java.lang.Object", Config.OS, "", "boolean"), 86);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "hashCode", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", "int"), 100);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "toString", "com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox", "", "", "", FieldUtil.TYPE_STRING), 107);
    }

    public BaseLocationBox() {
        super(TYPE);
        this.baseLocation = "";
        this.purchaseLocation = "";
    }

    public BaseLocationBox(String str, String str2) {
        super(TYPE);
        this.baseLocation = "";
        this.purchaseLocation = "";
        this.baseLocation = str;
        this.purchaseLocation = str2;
    }

    public String getBaseLocation() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.baseLocation;
    }

    public void setBaseLocation(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.baseLocation = str;
    }

    public String getPurchaseLocation() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.purchaseLocation;
    }

    public void setPurchaseLocation(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        this.purchaseLocation = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 1028L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.baseLocation = IsoTypeReader.readString(byteBuffer);
        byteBuffer.get(new byte[(256 - Utf8.utf8StringLengthInBytes(this.baseLocation)) - 1]);
        this.purchaseLocation = IsoTypeReader.readString(byteBuffer);
        byteBuffer.get(new byte[(256 - Utf8.utf8StringLengthInBytes(this.purchaseLocation)) - 1]);
        byteBuffer.get(new byte[512]);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.convert(this.baseLocation));
        byteBuffer.put(new byte[256 - Utf8.utf8StringLengthInBytes(this.baseLocation)]);
        byteBuffer.put(Utf8.convert(this.purchaseLocation));
        byteBuffer.put(new byte[256 - Utf8.utf8StringLengthInBytes(this.purchaseLocation)]);
        byteBuffer.put(new byte[512]);
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseLocationBox baseLocationBox = (BaseLocationBox) obj;
        if (this.baseLocation == null ? baseLocationBox.baseLocation != null : !this.baseLocation.equals(baseLocationBox.baseLocation)) {
            return false;
        }
        if (this.purchaseLocation != null) {
            if (this.purchaseLocation.equals(baseLocationBox.purchaseLocation)) {
                return true;
            }
        } else if (baseLocationBox.purchaseLocation == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return ((this.baseLocation != null ? this.baseLocation.hashCode() : 0) * 31) + (this.purchaseLocation != null ? this.purchaseLocation.hashCode() : 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return "BaseLocationBox{baseLocation='" + this.baseLocation + "', purchaseLocation='" + this.purchaseLocation + "'}";
    }
}
