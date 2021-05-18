package d.a.i0.c.a.i;

import com.baidu.swan.bdtls.impl.model.Bdtls$ClientHello;
import com.baidu.swan.bdtls.impl.model.Bdtls$ServerHello;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Bdtls$ClientHello f46293a;

    /* renamed from: b  reason: collision with root package name */
    public Bdtls$ServerHello f46294b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f46295c;

    public d() {
        this(null, null, null, 7, null);
    }

    public d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        this.f46293a = bdtls$ClientHello;
        this.f46294b = bdtls$ServerHello;
        this.f46295c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        this.f46294b = bdtls$ServerHello;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return Intrinsics.areEqual(this.f46293a, dVar.f46293a) && Intrinsics.areEqual(this.f46294b, dVar.f46294b) && Intrinsics.areEqual(this.f46295c, dVar.f46295c);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls$ClientHello bdtls$ClientHello = this.f46293a;
        int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
        Bdtls$ServerHello bdtls$ServerHello = this.f46294b;
        int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
        byte[] bArr = this.f46295c;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.f46293a + ", serverHello=" + this.f46294b + ", encodeDHPublicKey=" + Arrays.toString(this.f46295c) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : bdtls$ClientHello, (i2 & 2) != 0 ? null : bdtls$ServerHello, (i2 & 4) != 0 ? null : bArr);
    }
}
