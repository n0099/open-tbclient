package g.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.java_websocket.WebSocket;
/* loaded from: classes2.dex */
public abstract class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int connectionLostTimeout;
    public Timer connectionLostTimer;
    public TimerTask connectionLostTimerTask;
    public boolean reuseAddr;
    public boolean tcpNoDelay;
    public boolean websocketRunning;

    /* renamed from: g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2043a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<WebSocket> f71744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f71745f;

        public C2043a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71745f = aVar;
            this.f71744e = new ArrayList<>();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f71744e.clear();
                try {
                    this.f71744e.addAll(this.f71745f.getConnections());
                    long currentTimeMillis = System.currentTimeMillis() - (this.f71745f.connectionLostTimeout * 1500);
                    Iterator<WebSocket> it = this.f71744e.iterator();
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
                this.f71744e.clear();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.connectionLostTimeout = 60;
        this.websocketRunning = false;
    }

    private void cancelConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
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
    }

    private void restartConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            cancelConnectionLostTimer();
            this.connectionLostTimer = new Timer("WebSocketTimer");
            C2043a c2043a = new C2043a(this);
            this.connectionLostTimerTask = c2043a;
            Timer timer = this.connectionLostTimer;
            int i2 = this.connectionLostTimeout;
            timer.scheduleAtFixedRate(c2043a, i2 * 1000, i2 * 1000);
        }
    }

    public int getConnectionLostTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.connectionLostTimeout : invokeV.intValue;
    }

    public abstract Collection<WebSocket> getConnections();

    public boolean isReuseAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.reuseAddr : invokeV.booleanValue;
    }

    public boolean isTcpNoDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tcpNoDelay : invokeV.booleanValue;
    }

    public void setConnectionLostTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.connectionLostTimeout = i2;
            if (i2 <= 0) {
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
    }

    public void setReuseAddr(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.reuseAddr = z;
        }
    }

    public void setTcpNoDelay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.tcpNoDelay = z;
        }
    }

    public void startConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
    }

    public void stopConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
}
