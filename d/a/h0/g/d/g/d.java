package d.a.h0.g.d.g;

import com.baidu.swan.games.bdtls.model.Bdtls$ClientHello;
import com.baidu.swan.games.bdtls.model.Bdtls$ServerHello;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Bdtls$ClientHello f46231a;

    /* renamed from: b  reason: collision with root package name */
    public Bdtls$ServerHello f46232b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f46233c;

    public d() {
        this(null, null, null, 7, null);
    }

    public d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        this.f46231a = bdtls$ClientHello;
        this.f46232b = bdtls$ServerHello;
        this.f46233c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        this.f46232b = bdtls$ServerHello;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return Intrinsics.areEqual(this.f46231a, dVar.f46231a) && Intrinsics.areEqual(this.f46232b, dVar.f46232b) && Intrinsics.areEqual(this.f46233c, dVar.f46233c);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls$ClientHello bdtls$ClientHello = this.f46231a;
        int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
        Bdtls$ServerHello bdtls$ServerHello = this.f46232b;
        int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
        byte[] bArr = this.f46233c;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.f46231a + ", serverHello=" + this.f46232b + ", encodeDHPublicKey=" + Arrays.toString(this.f46233c) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : bdtls$ClientHello, (i2 & 2) != 0 ? null : bdtls$ServerHello, (i2 & 4) != 0 ? null : bArr);
    }
}
