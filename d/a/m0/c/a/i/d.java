package d.a.m0.c.a.i;

import com.baidu.swan.bdtls.impl.model.Bdtls$ClientHello;
import com.baidu.swan.bdtls.impl.model.Bdtls$ServerHello;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Bdtls$ClientHello f50251a;

    /* renamed from: b  reason: collision with root package name */
    public Bdtls$ServerHello f50252b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f50253c;

    public d() {
        this(null, null, null, 7, null);
    }

    public d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        this.f50251a = bdtls$ClientHello;
        this.f50252b = bdtls$ServerHello;
        this.f50253c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        this.f50252b = bdtls$ServerHello;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return Intrinsics.areEqual(this.f50251a, dVar.f50251a) && Intrinsics.areEqual(this.f50252b, dVar.f50252b) && Intrinsics.areEqual(this.f50253c, dVar.f50253c);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls$ClientHello bdtls$ClientHello = this.f50251a;
        int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
        Bdtls$ServerHello bdtls$ServerHello = this.f50252b;
        int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
        byte[] bArr = this.f50253c;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.f50251a + ", serverHello=" + this.f50252b + ", encodeDHPublicKey=" + Arrays.toString(this.f50253c) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : bdtls$ClientHello, (i2 & 2) != 0 ? null : bdtls$ServerHello, (i2 & 4) != 0 ? null : bArr);
    }
}
