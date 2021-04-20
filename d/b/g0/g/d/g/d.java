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
    public Bdtls$ClientHello f48435a;

    /* renamed from: b  reason: collision with root package name */
    public Bdtls$ServerHello f48436b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f48437c;

    public d() {
        this(null, null, null, 7, null);
    }

    public d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        this.f48435a = bdtls$ClientHello;
        this.f48436b = bdtls$ServerHello;
        this.f48437c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        this.f48436b = bdtls$ServerHello;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return Intrinsics.areEqual(this.f48435a, dVar.f48435a) && Intrinsics.areEqual(this.f48436b, dVar.f48436b) && Intrinsics.areEqual(this.f48437c, dVar.f48437c);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls$ClientHello bdtls$ClientHello = this.f48435a;
        int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
        Bdtls$ServerHello bdtls$ServerHello = this.f48436b;
        int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
        byte[] bArr = this.f48437c;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.f48435a + ", serverHello=" + this.f48436b + ", encodeDHPublicKey=" + Arrays.toString(this.f48437c) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bdtls$ClientHello, (i & 2) != 0 ? null : bdtls$ServerHello, (i & 4) != 0 ? null : bArr);
    }
}
