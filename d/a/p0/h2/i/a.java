package d.a.p0.h2.i;

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
    public int f56959e;

    /* renamed from: f  reason: collision with root package name */
    public long f56960f;

    /* renamed from: g  reason: collision with root package name */
    public long f56961g;

    /* renamed from: h  reason: collision with root package name */
    public b f56962h;

    /* renamed from: i  reason: collision with root package name */
    public long f56963i;
    public Handler j;

    /* renamed from: d.a.p0.h2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1407a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f56964a;

        public HandlerC1407a(a aVar) {
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
            this.f56964a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 2) {
                    this.f56964a.f56959e = 0;
                    this.f56964a.f56960f = 0L;
                    this.f56964a.f56961g = 0L;
                } else if (i2 == 1 && this.f56964a.f56959e == 1) {
                    if (this.f56964a.f56962h != null) {
                        this.f56964a.f56962h.a();
                    }
                    this.f56964a.f56959e = 0;
                    this.f56964a.f56960f = 0L;
                    this.f56964a.f56961g = 0L;
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
        this.f56959e = 0;
        this.f56960f = 0L;
        this.f56961g = 0L;
        this.f56963i = 500L;
        this.j = new HandlerC1407a(this);
        this.f56962h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f56962h == null) {
                    return false;
                }
                int i2 = this.f56959e + 1;
                this.f56959e = i2;
                if (i2 == 1) {
                    this.f56960f = System.currentTimeMillis();
                    this.j.sendEmptyMessageDelayed(1, this.f56963i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f56961g = currentTimeMillis;
                    if (currentTimeMillis - this.f56960f < this.f56963i) {
                        this.f56962h.b();
                    }
                    this.j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
