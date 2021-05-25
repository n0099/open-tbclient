package d.a.l0.h.k0;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public DatagramPacket f47421a;

    /* renamed from: b  reason: collision with root package name */
    public g f47422b;

    public b(DatagramPacket datagramPacket, g udpsocket) {
        Intrinsics.checkNotNullParameter(udpsocket, "udpsocket");
        this.f47421a = datagramPacket;
        this.f47422b = udpsocket;
    }

    public final void a() {
        DatagramSocket E;
        try {
            g gVar = this.f47422b;
            if (gVar == null || (E = gVar.E()) == null) {
                return;
            }
            E.send(this.f47421a);
        } catch (Throwable unused) {
            g gVar2 = this.f47422b;
            if (gVar2 != null) {
                gVar2.F("send", "send failed");
            }
        }
    }
}
