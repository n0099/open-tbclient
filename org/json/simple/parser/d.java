package org.json.simple.parser;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f2888a;
    public Object b;

    public d(int i, Object obj) {
        this.f2888a = 0;
        this.b = null;
        this.f2888a = i;
        this.b = obj;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.f2888a) {
            case -1:
                stringBuffer.append("END OF FILE");
                break;
            case 0:
                stringBuffer.append("VALUE(").append(this.b).append(")");
                break;
            case 1:
                stringBuffer.append("LEFT BRACE({)");
                break;
            case 2:
                stringBuffer.append("RIGHT BRACE(})");
                break;
            case 3:
                stringBuffer.append("LEFT SQUARE([)");
                break;
            case 4:
                stringBuffer.append("RIGHT SQUARE(])");
                break;
            case 5:
                stringBuffer.append("COMMA(,)");
                break;
            case 6:
                stringBuffer.append("COLON(:)");
                break;
        }
        return stringBuffer.toString();
    }
}
