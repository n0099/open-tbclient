package d.a.p0.t.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1243d f54049a;

    /* renamed from: b  reason: collision with root package name */
    public c f54050b;

    /* renamed from: c  reason: collision with root package name */
    public b f54051c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Process f54052a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f54053b;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54053b = dVar;
            this.f54052a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.onCancelled();
                Process process = this.f54052a;
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (this.f54053b.f54050b != null) {
                    this.f54053b.f54050b.a(false);
                }
                if (this.f54053b.f54049a != null) {
                    this.f54053b.f54049a.removeMessages(0);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                boolean z = false;
                if (strArr != null && strArr.length >= 1) {
                    try {
                        try {
                            try {
                                Process exec = Runtime.getRuntime().exec(strArr[0]);
                                this.f54052a = exec;
                                if (exec.waitFor() == 0) {
                                    z = true;
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    } finally {
                        this.f54052a.destroy();
                    }
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                if (this.f54053b.f54050b != null) {
                    this.f54053b.f54050b.a(bool == null ? false : bool.booleanValue());
                }
                if (this.f54053b.f54049a != null) {
                    this.f54053b.f54049a.removeMessages(0);
                }
            }
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.a.p0.t.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC1243d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f54054a;

        public HandlerC1243d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54054a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 0 || (dVar = this.f54054a.get()) == null) {
                    return;
                }
                dVar.e();
            }
        }
    }

    public d(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54049a = null;
        this.f54050b = null;
        this.f54051c = null;
        HandlerC1243d handlerC1243d = new HandlerC1243d(this);
        this.f54049a = handlerC1243d;
        this.f54050b = cVar;
        handlerC1243d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b(this, null);
        this.f54051c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f54051c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }
        return (String) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.f54051c;
            if (bVar != null) {
                bVar.cancel(true);
            }
            HandlerC1243d handlerC1243d = this.f54049a;
            if (handlerC1243d != null) {
                handlerC1243d.removeMessages(0);
            }
        }
    }
}
