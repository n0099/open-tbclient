package d.a.i0.n.h;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes3.dex */
public class i extends e {
    public long o;
    public String p;
    public AbiType q;

    @Override // d.a.i0.n.h.e
    public boolean a() {
        return (TextUtils.isEmpty(this.f47836g) || this.f47838i <= 0 || this.k <= 0 || TextUtils.isEmpty(this.p) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.n) || this.q == null) ? false : true;
    }

    @Override // d.a.i0.n.h.e
    public String toString() {
        return "libName=" + this.p + ", abi=" + this.q + ", maxAge=" + this.o + " " + super.toString();
    }
}
