package d.b.j0.b2.b;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f53763a;

    /* renamed from: b  reason: collision with root package name */
    public String f53764b;

    /* renamed from: c  reason: collision with root package name */
    public String f53765c;

    /* renamed from: d  reason: collision with root package name */
    public String f53766d;

    public int a() {
        char c2;
        String str = this.f53764b;
        int hashCode = str.hashCode();
        if (hashCode == 2154) {
            if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 2161) {
            if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            return c2 != 1 ? 3 : 2;
        }
        return 1;
    }
}
