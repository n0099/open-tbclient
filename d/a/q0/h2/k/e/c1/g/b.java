package d.a.q0.h2.k.e.c1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f57745a;

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f57746b;

    /* renamed from: c  reason: collision with root package name */
    public String f57747c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f57748d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f57749e;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57750e;

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
            this.f57750e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f57750e.f57747c) || this.f57750e.f57748d == null) {
                return;
            }
            if (this.f57750e.f57746b == null) {
                this.f57750e.f57746b = new SearchEmotionModel();
            }
            this.f57750e.f57746b.x(this.f57750e.f57747c, 0, 30, this.f57750e.f57748d);
        }
    }

    public b() {
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
        this.f57749e = new a(this);
        this.f57745a = new Handler();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SearchEmotionModel searchEmotionModel = this.f57746b;
            if (searchEmotionModel != null) {
                searchEmotionModel.cancelLoadData();
            }
            this.f57745a.removeCallbacks(this.f57749e);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f57747c = "";
                return;
            }
            this.f57745a.removeCallbacks(this.f57749e);
            this.f57745a.postDelayed(this.f57749e, 300L);
            this.f57747c = str;
        }
    }

    public void g(SearchEmotionModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f57748d = bVar;
        }
    }
}
