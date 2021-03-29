package d.b.g0.l.k;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes3.dex */
public class i extends e {
    public long o;
    public String p;
    public AbiType q;

    @Override // d.b.g0.l.k.e
    public boolean a() {
        return (TextUtils.isEmpty(this.f48923g) || this.i <= 0 || this.k <= 0 || TextUtils.isEmpty(this.p) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.n) || this.q == null) ? false : true;
    }

    @Override // d.b.g0.l.k.e
    public String toString() {
        return "libName=" + this.p + ", abi=" + this.q + ", maxAge=" + this.o + " " + super.toString();
    }
}
