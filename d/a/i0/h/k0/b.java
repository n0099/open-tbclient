package d.a.i0.h.k0;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public DatagramPacket f47245a;

    /* renamed from: b  reason: collision with root package name */
    public g f47246b;

    public b(DatagramPacket datagramPacket, g udpsocket) {
        Intrinsics.checkNotNullParameter(udpsocket, "udpsocket");
        this.f47245a = datagramPacket;
        this.f47246b = udpsocket;
    }

    public final void a() {
        DatagramSocket E;
        try {
            g gVar = this.f47246b;
            if (gVar == null || (E = gVar.E()) == null) {
                return;
            }
            E.send(this.f47245a);
        } catch (Throwable unused) {
            g gVar2 = this.f47246b;
            if (gVar2 != null) {
                gVar2.F("send", "send failed");
            }
        }
    }
}
