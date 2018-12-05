package org.java_websocket;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public abstract class a extends b {
    private int connectionLostTimeout = 60;
    private Timer connectionLostTimer;
    private TimerTask connectionLostTimerTask;
    private boolean reuseAddr;
    private boolean tcpNoDelay;

    protected abstract Collection<WebSocket> getConnections();

    public int getConnectionLostTimeout() {
        return this.connectionLostTimeout;
    }

    public void setConnectionLostTimeout(int i) {
        this.connectionLostTimeout = i;
        if (this.connectionLostTimeout <= 0) {
            stopConnectionLostTimer();
        }
        if (this.connectionLostTimer != null || this.connectionLostTimerTask != null) {
            if (c.DEBUG) {
                System.out.println("Connection lost timer restarted");
            }
            restartConnectionLostTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopConnectionLostTimer() {
        if (this.connectionLostTimer != null || this.connectionLostTimerTask != null) {
            if (c.DEBUG) {
                System.out.println("Connection lost timer stopped");
            }
            cancelConnectionLostTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startConnectionLostTimer() {
        if (this.connectionLostTimeout <= 0) {
            if (c.DEBUG) {
                System.out.println("Connection lost timer deactivated");
                return;
            }
            return;
        }
        if (c.DEBUG) {
            System.out.println("Connection lost timer started");
        }
        restartConnectionLostTimer();
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostTimer = new Timer("WebSocketTimer");
        this.connectionLostTimerTask = new TimerTask() { // from class: org.java_websocket.a.1
            private ArrayList<WebSocket> izF = new ArrayList<>();

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.izF.clear();
                this.izF.addAll(a.this.getConnections());
                long currentTimeMillis = System.currentTimeMillis() - (a.this.connectionLostTimeout * TbConfig.POST_IMAGE_SMALL);
                Iterator<WebSocket> it = this.izF.iterator();
                while (it.hasNext()) {
                    WebSocket next = it.next();
                    if (next instanceof c) {
                        c cVar = (c) next;
                        if (cVar.cck() < currentTimeMillis) {
                            if (c.DEBUG) {
                                System.out.println("Closing connection due to no pong received: " + next.toString());
                            }
                            cVar.closeConnection(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
                        } else if (cVar.isOpen()) {
                            cVar.sendPing();
                        } else if (c.DEBUG) {
                            System.out.println("Trying to ping a non open connection: " + next.toString());
                        }
                    }
                }
                this.izF.clear();
            }
        };
        this.connectionLostTimer.scheduleAtFixedRate(this.connectionLostTimerTask, this.connectionLostTimeout * 1000, this.connectionLostTimeout * 1000);
    }

    private void cancelConnectionLostTimer() {
        if (this.connectionLostTimer != null) {
            this.connectionLostTimer.cancel();
            this.connectionLostTimer = null;
        }
        if (this.connectionLostTimerTask != null) {
            this.connectionLostTimerTask.cancel();
            this.connectionLostTimerTask = null;
        }
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setTcpNoDelay(boolean z) {
        this.tcpNoDelay = z;
    }

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public void setReuseAddr(boolean z) {
        this.reuseAddr = z;
    }
}
