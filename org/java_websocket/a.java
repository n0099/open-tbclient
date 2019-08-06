package org.java_websocket;

import android.support.v4.view.PointerIconCompat;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public abstract class a extends b {
    private Timer connectionLostTimer;
    private TimerTask connectionLostTimerTask;
    private boolean reuseAddr;
    private boolean tcpNoDelay;
    private int connectionLostTimeout = 60;
    private boolean websocketRunning = false;

    protected abstract Collection<WebSocket> getConnections();

    public int getConnectionLostTimeout() {
        return this.connectionLostTimeout;
    }

    public void setConnectionLostTimeout(int i) {
        this.connectionLostTimeout = i;
        if (this.connectionLostTimeout <= 0) {
            if (c.DEBUG) {
                System.out.println("Connection lost timer stopped");
            }
            cancelConnectionLostTimer();
        } else if (this.websocketRunning) {
            if (c.DEBUG) {
                System.out.println("Connection lost timer restarted");
            }
            try {
                Iterator it = new ArrayList(getConnections()).iterator();
                while (it.hasNext()) {
                    WebSocket webSocket = (WebSocket) it.next();
                    if (webSocket instanceof c) {
                        ((c) webSocket).cOG();
                    }
                }
            } catch (Exception e) {
                if (c.DEBUG) {
                    System.out.println("Exception during connection lost restart: " + e.getMessage());
                }
            }
            restartConnectionLostTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopConnectionLostTimer() {
        if (this.connectionLostTimer != null || this.connectionLostTimerTask != null) {
            this.websocketRunning = false;
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
        this.websocketRunning = true;
        restartConnectionLostTimer();
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostTimer = new Timer("WebSocketTimer");
        this.connectionLostTimerTask = new TimerTask() { // from class: org.java_websocket.a.1
            private ArrayList<WebSocket> kul = new ArrayList<>();

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.kul.clear();
                try {
                    this.kul.addAll(a.this.getConnections());
                    long currentTimeMillis = System.currentTimeMillis() - (a.this.connectionLostTimeout * TbConfig.POST_IMAGE_SMALL);
                    Iterator<WebSocket> it = this.kul.iterator();
                    while (it.hasNext()) {
                        WebSocket next = it.next();
                        if (next instanceof c) {
                            c cVar = (c) next;
                            if (cVar.cOF() < currentTimeMillis) {
                                if (c.DEBUG) {
                                    System.out.println("Closing connection due to no pong received: " + next.toString());
                                }
                                cVar.closeConnection(PointerIconCompat.TYPE_CELL, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
                            } else if (cVar.isOpen()) {
                                cVar.sendPing();
                            } else if (c.DEBUG) {
                                System.out.println("Trying to ping a non open connection: " + next.toString());
                            }
                        }
                    }
                } catch (Exception e) {
                    if (c.DEBUG) {
                        System.out.println("Exception during connection lost ping: " + e.getMessage());
                    }
                }
                this.kul.clear();
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
