package d.a.o0.r.v;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.feedManager.FeedRecModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f52977d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f52978a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f52979b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f52980c;

    /* renamed from: d.a.o0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1220a implements FeedRecModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52981a;

        public C1220a(a aVar) {
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
            this.f52981a = aVar;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f52981a.f52979b = dataRes;
            }
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f52981a.f52979b = null;
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
        this.f52980c = new C1220a(this);
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f52978a = feedRecModel;
        feedRecModel.z(this.f52980c);
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f52977d == null) {
                synchronized (a.class) {
                    if (f52977d == null) {
                        f52977d = new a();
                    }
                }
            }
            return f52977d;
        }
        return (a) invokeV.objValue;
    }

    public DataRes c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52979b : (DataRes) invokeV.objValue;
    }
}
