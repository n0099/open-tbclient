package d.b.c.b.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends FileObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f68905a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f68906b;

    /* renamed from: d.b.c.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C1963a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f68907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f68908f;

        public C1963a(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68908f = aVar;
            this.f68907e = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SystemClock.sleep(this.f68907e);
                this.f68908f.f68906b = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, String str, int i2) {
        super(str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68906b = true;
        if (cVar != null && !TextUtils.isEmpty(str)) {
            this.f68905a = cVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && this.f68906b && i2 == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.f68905a != null) {
            this.f68906b = false;
            c cVar = this.f68905a;
            cVar.e(200, "/data/anr/" + str, 80);
            getClass();
            new C1963a(this, 5000).start();
        }
    }
}
