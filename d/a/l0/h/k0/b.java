package d.a.l0.h.k0;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public DatagramPacket f51095a;

    /* renamed from: b  reason: collision with root package name */
    public g f51096b;

    public b(DatagramPacket datagramPacket, g udpsocket) {
        Intrinsics.checkNotNullParameter(udpsocket, "udpsocket");
        this.f51095a = datagramPacket;
        this.f51096b = udpsocket;
    }

    public final void a() {
        DatagramSocket E;
        try {
            g gVar = this.f51096b;
            if (gVar == null || (E = gVar.E()) == null) {
                return;
            }
            E.send(this.f51095a);
        } catch (Throwable unused) {
            g gVar2 = this.f51096b;
            if (gVar2 != null) {
                gVar2.F("send", "send failed");
            }
        }
    }
}
