package d.b.g0.g.d.g;

import com.baidu.swan.games.bdtls.model.Bdtls$ClientHello;
import com.baidu.swan.games.bdtls.model.Bdtls$ServerHello;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Bdtls$ClientHello f48043a;

    /* renamed from: b  reason: collision with root package name */
    public Bdtls$ServerHello f48044b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f48045c;

    public d() {
        this(null, null, null, 7, null);
    }

    public d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        this.f48043a = bdtls$ClientHello;
        this.f48044b = bdtls$ServerHello;
        this.f48045c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        this.f48044b = bdtls$ServerHello;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return Intrinsics.areEqual(this.f48043a, dVar.f48043a) && Intrinsics.areEqual(this.f48044b, dVar.f48044b) && Intrinsics.areEqual(this.f48045c, dVar.f48045c);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls$ClientHello bdtls$ClientHello = this.f48043a;
        int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
        Bdtls$ServerHello bdtls$ServerHello = this.f48044b;
        int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
        byte[] bArr = this.f48045c;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.f48043a + ", serverHello=" + this.f48044b + ", encodeDHPublicKey=" + Arrays.toString(this.f48045c) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bdtls$ClientHello, (i & 2) != 0 ? null : bdtls$ServerHello, (i & 4) != 0 ? null : bArr);
    }
}
