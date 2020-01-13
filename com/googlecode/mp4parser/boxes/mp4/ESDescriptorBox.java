package com.googlecode.mp4parser.boxes.mp4;

import com.baidu.mobstat.Config;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public class ESDescriptorBox extends AbstractDescriptorBox {
    public static final String TYPE = "esds";
    private static final /* synthetic */ a.InterfaceC0773a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0773a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0773a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0773a ajc$tjp_3 = null;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ESDescriptorBox.java", ESDescriptorBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 33);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 37);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", Config.OS, "", "boolean"), 42);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 53);
    }

    public ESDescriptorBox() {
        super(TYPE);
    }

    public ESDescriptor getEsDescriptor() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return (ESDescriptor) super.getDescriptor();
    }

    public void setEsDescriptor(ESDescriptor eSDescriptor) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, eSDescriptor));
        super.setDescriptor(eSDescriptor);
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ESDescriptorBox eSDescriptorBox = (ESDescriptorBox) obj;
        if (this.data != null) {
            if (this.data.equals(eSDescriptorBox.data)) {
                return true;
            }
        } else if (eSDescriptorBox.data == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        if (this.data != null) {
            return this.data.hashCode();
        }
        return 0;
    }
}
