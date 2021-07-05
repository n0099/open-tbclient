package d.a.s0.h2.k.e.b1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f60404a;

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f60405b;

    /* renamed from: c  reason: collision with root package name */
    public String f60406c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f60407d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f60408e;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60409e;

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
            this.f60409e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f60409e.f60406c) || this.f60409e.f60407d == null) {
                return;
            }
            if (this.f60409e.f60405b == null) {
                this.f60409e.f60405b = new SearchEmotionModel();
            }
            this.f60409e.f60405b.x(this.f60409e.f60406c, 0, 30, this.f60409e.f60407d);
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
        this.f60408e = new a(this);
        this.f60404a = new Handler();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SearchEmotionModel searchEmotionModel = this.f60405b;
            if (searchEmotionModel != null) {
                searchEmotionModel.cancelLoadData();
            }
            this.f60404a.removeCallbacks(this.f60408e);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f60406c = "";
                return;
            }
            this.f60404a.removeCallbacks(this.f60408e);
            this.f60404a.postDelayed(this.f60408e, 300L);
            this.f60406c = str;
        }
    }

    public void g(SearchEmotionModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f60407d = bVar;
        }
    }
}
