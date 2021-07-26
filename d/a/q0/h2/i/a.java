package d.a.q0.h2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f57508e;

    /* renamed from: f  reason: collision with root package name */
    public long f57509f;

    /* renamed from: g  reason: collision with root package name */
    public long f57510g;

    /* renamed from: h  reason: collision with root package name */
    public b f57511h;

    /* renamed from: i  reason: collision with root package name */
    public long f57512i;
    public Handler j;

    /* renamed from: d.a.q0.h2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1416a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57513a;

        public HandlerC1416a(a aVar) {
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
            this.f57513a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 2) {
                    this.f57513a.f57508e = 0;
                    this.f57513a.f57509f = 0L;
                    this.f57513a.f57510g = 0L;
                } else if (i2 == 1 && this.f57513a.f57508e == 1) {
                    if (this.f57513a.f57511h != null) {
                        this.f57513a.f57511h.a();
                    }
                    this.f57513a.f57508e = 0;
                    this.f57513a.f57509f = 0L;
                    this.f57513a.f57510g = 0L;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f57508e = 0;
        this.f57509f = 0L;
        this.f57510g = 0L;
        this.f57512i = 500L;
        this.j = new HandlerC1416a(this);
        this.f57511h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f57511h == null) {
                    return false;
                }
                int i2 = this.f57508e + 1;
                this.f57508e = i2;
                if (i2 == 1) {
                    this.f57509f = System.currentTimeMillis();
                    this.j.sendEmptyMessageDelayed(1, this.f57512i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f57510g = currentTimeMillis;
                    if (currentTimeMillis - this.f57509f < this.f57512i) {
                        this.f57511h.b();
                    }
                    this.j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
