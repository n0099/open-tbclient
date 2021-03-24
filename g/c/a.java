package g.c;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.java_websocket.WebSocket;
/* loaded from: classes7.dex */
public abstract class a extends b {
    public Timer connectionLostTimer;
    public TimerTask connectionLostTimerTask;
    public boolean reuseAddr;
    public boolean tcpNoDelay;
    public int connectionLostTimeout = 60;
    public boolean websocketRunning = false;

    /* renamed from: g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1859a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<WebSocket> f67616e = new ArrayList<>();

        public C1859a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f67616e.clear();
            try {
                this.f67616e.addAll(a.this.getConnections());
                long currentTimeMillis = System.currentTimeMillis() - (a.this.connectionLostTimeout * 1500);
                Iterator<WebSocket> it = this.f67616e.iterator();
                while (it.hasNext()) {
                    WebSocket next = it.next();
                    if (next instanceof c) {
                        c cVar = (c) next;
                        if (cVar.r() < currentTimeMillis) {
                            if (c.y) {
                                PrintStream printStream = System.out;
                                printStream.println("Closing connection due to no pong received: " + next.toString());
                            }
                            cVar.f(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
                        } else if (cVar.B()) {
                            cVar.J();
                        } else if (c.y) {
                            PrintStream printStream2 = System.out;
                            printStream2.println("Trying to ping a non open connection: " + next.toString());
                        }
                    }
                }
            } catch (Exception e2) {
                if (c.y) {
                    PrintStream printStream3 = System.out;
                    printStream3.println("Exception during connection lost ping: " + e2.getMessage());
                }
            }
            this.f67616e.clear();
        }
    }

    private void cancelConnectionLostTimer() {
        Timer timer = this.connectionLostTimer;
        if (timer != null) {
            timer.cancel();
            this.connectionLostTimer = null;
        }
        TimerTask timerTask = this.connectionLostTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.connectionLostTimerTask = null;
        }
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostTimer = new Timer("WebSocketTimer");
        C1859a c1859a = new C1859a();
        this.connectionLostTimerTask = c1859a;
        Timer timer = this.connectionLostTimer;
        int i = this.connectionLostTimeout;
        timer.scheduleAtFixedRate(c1859a, i * 1000, i * 1000);
    }

    public int getConnectionLostTimeout() {
        return this.connectionLostTimeout;
    }

    public abstract Collection<WebSocket> getConnections();

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setConnectionLostTimeout(int i) {
        this.connectionLostTimeout = i;
        if (i <= 0) {
            if (c.y) {
                System.out.println("Connection lost timer stopped");
            }
            cancelConnectionLostTimer();
        } else if (this.websocketRunning) {
            if (c.y) {
                System.out.println("Connection lost timer restarted");
            }
            try {
                Iterator it = new ArrayList(getConnections()).iterator();
                while (it.hasNext()) {
                    WebSocket webSocket = (WebSocket) it.next();
                    if (webSocket instanceof c) {
                        ((c) webSocket).N();
                    }
                }
            } catch (Exception e2) {
                if (c.y) {
                    PrintStream printStream = System.out;
                    printStream.println("Exception during connection lost restart: " + e2.getMessage());
                }
            }
            restartConnectionLostTimer();
        }
    }

    public void setReuseAddr(boolean z) {
        this.reuseAddr = z;
    }

    public void setTcpNoDelay(boolean z) {
        this.tcpNoDelay = z;
    }

    public void startConnectionLostTimer() {
        if (this.connectionLostTimeout <= 0) {
            if (c.y) {
                System.out.println("Connection lost timer deactivated");
                return;
            }
            return;
        }
        if (c.y) {
            System.out.println("Connection lost timer started");
        }
        this.websocketRunning = true;
        restartConnectionLostTimer();
    }

    public void stopConnectionLostTimer() {
        if (this.connectionLostTimer == null && this.connectionLostTimerTask == null) {
            return;
        }
        this.websocketRunning = false;
        if (c.y) {
            System.out.println("Connection lost timer stopped");
        }
        cancelConnectionLostTimer();
    }
}
