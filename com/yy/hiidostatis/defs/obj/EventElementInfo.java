package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes2.dex */
public class EventElementInfo extends ParamableElem implements Elem {
    public static final transient int CTYPE_CLICK_TIMES_REPORT = 1;
    public static final transient int CTYPE_CUSTOM_REPORT = 0;
    public static final transient int DEFAULT_CVALUE = 0;
    public static final long serialVersionUID = 7740962417443813455L;
    public String cid;
    public String cvalue;
    public Property property = new Property();
    public int ctype = 1;

    public EventElementInfo(String str, int i) {
        this.cid = str;
        this.cvalue = Integer.toString(i);
    }

    public EventElementInfo(String str, String str2) {
        this.cid = str;
        this.cvalue = str2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.cid = (String) objectInputStream.readObject();
        this.ctype = objectInputStream.readInt();
        this.cvalue = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cid);
        objectOutputStream.writeInt(this.ctype);
        objectOutputStream.writeUTF(this.cvalue);
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCtype(int i) {
        this.ctype = i;
    }

    public void setCustomValue(String str) {
        if (this.ctype == 1) {
            try {
                Long.parseLong(str);
            } catch (NumberFormatException e) {
                L.debug(this, "Input arg error %s for %s", str, e);
            }
        }
        this.cvalue = str;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getCustomValue() {
        return this.cvalue;
    }

    public String getEventId() {
        return this.cid;
    }

    public int getEventType() {
        return this.ctype;
    }

    public Property getProperty() {
        return this.property;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("eventId=");
        sb.append(this.cid);
        sb.append(", event type=");
        if (this.ctype == 0) {
            str = "Custom";
        } else {
            str = "Times";
        }
        sb.append(str);
        sb.append(", value=");
        sb.append(this.cvalue);
        return sb.toString();
    }

    @Override // com.yy.hiidostatis.defs.obj.Elem
    public String getStringRep() {
        String connectedPropertys;
        StringBuilder sb = new StringBuilder();
        sb.append(Util.replaceEncode(this.cid, ":"));
        sb.append(":");
        sb.append(this.ctype);
        sb.append(":");
        sb.append(Util.replaceEncode(this.cvalue, ":"));
        sb.append(":");
        String connectedParams = getConnectedParams();
        if (!Util.empty(connectedParams)) {
            sb.append(Util.replaceEncode(connectedParams, ":"));
        }
        sb.append(":");
        Property property = this.property;
        if (property == null) {
            connectedPropertys = null;
        } else {
            connectedPropertys = property.getConnectedPropertys();
        }
        if (!Util.empty(connectedPropertys)) {
            sb.append(Util.replaceEncode(connectedPropertys, ":"));
        }
        return sb.toString();
    }
}
