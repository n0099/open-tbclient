package d.b.i0.a2.b;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f51921a;

    /* renamed from: b  reason: collision with root package name */
    public String f51922b;

    /* renamed from: c  reason: collision with root package name */
    public String f51923c;

    /* renamed from: d  reason: collision with root package name */
    public String f51924d;

    public int a() {
        char c2;
        String str = this.f51922b;
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
