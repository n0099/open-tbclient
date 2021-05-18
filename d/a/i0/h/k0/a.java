package d.a.i0.h.k0;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/* loaded from: classes3.dex */
public final class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public g f47243e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f47244f;

    public final boolean a() {
        return this.f47244f;
    }

    public final void b(boolean z) {
        this.f47244f = z;
    }

    public final void c(g gVar) {
        this.f47243e = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        DatagramSocket E;
        while (this.f47244f) {
            try {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[4096], 4096);
                g gVar = this.f47243e;
                if (gVar != null && (E = gVar.E()) != null) {
                    E.receive(datagramPacket);
                }
                g gVar2 = this.f47243e;
                if (gVar2 != null) {
                    gVar2.B(datagramPacket);
                }
            } catch (InterruptedException unused) {
                return;
            } catch (Throwable unused2) {
                g gVar3 = this.f47243e;
                if (gVar3 != null) {
                    gVar3.F("receive", "receive failed");
                }
            }
        }
    }
}
