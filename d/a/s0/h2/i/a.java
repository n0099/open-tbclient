package d.a.s0.h2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f60203e;

    /* renamed from: f  reason: collision with root package name */
    public long f60204f;

    /* renamed from: g  reason: collision with root package name */
    public long f60205g;

    /* renamed from: h  reason: collision with root package name */
    public b f60206h;

    /* renamed from: i  reason: collision with root package name */
    public long f60207i;
    public Handler j;

    /* renamed from: d.a.s0.h2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC1452a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60208a;

        public HandlerC1452a(a aVar) {
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
            this.f60208a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 2) {
                    this.f60208a.f60203e = 0;
                    this.f60208a.f60204f = 0L;
                    this.f60208a.f60205g = 0L;
                } else if (i2 == 1 && this.f60208a.f60203e == 1) {
                    if (this.f60208a.f60206h != null) {
                        this.f60208a.f60206h.a();
                    }
                    this.f60208a.f60203e = 0;
                    this.f60208a.f60204f = 0L;
                    this.f60208a.f60205g = 0L;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60203e = 0;
        this.f60204f = 0L;
        this.f60205g = 0L;
        this.f60207i = 500L;
        this.j = new HandlerC1452a(this);
        this.f60206h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f60206h == null) {
                    return false;
                }
                int i2 = this.f60203e + 1;
                this.f60203e = i2;
                if (i2 == 1) {
                    this.f60204f = System.currentTimeMillis();
                    this.j.sendEmptyMessageDelayed(1, this.f60207i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f60205g = currentTimeMillis;
                    if (currentTimeMillis - this.f60204f < this.f60207i) {
                        this.f60206h.b();
                    }
                    this.j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
