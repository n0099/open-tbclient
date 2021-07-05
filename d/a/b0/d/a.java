package d.a.b0.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String[] f43821e;

    /* renamed from: f  reason: collision with root package name */
    public String f43822f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43823g;

    /* renamed from: h  reason: collision with root package name */
    public String f43824h;

    /* renamed from: i  reason: collision with root package name */
    public C0579a f43825i;
    public b j;

    /* renamed from: d.a.b0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0579a implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f43826e;

        /* renamed from: f  reason: collision with root package name */
        public float f43827f;

        /* renamed from: g  reason: collision with root package name */
        public float f43828g;

        public C0579a() {
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
            this.f43826e = 0;
            this.f43827f = 0.0f;
            this.f43828g = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public C0579a clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                C0579a c0579a = (C0579a) super.clone();
                c0579a.f43826e = this.f43826e;
                c0579a.f43827f = this.f43827f;
                c0579a.f43828g = this.f43828g;
                return c0579a;
            }
            return (C0579a) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f43826e;
                if (i2 < 0 || i2 > 1) {
                    return false;
                }
                float f2 = this.f43827f;
                if (f2 < 0.0f || f2 > 16.0f) {
                    return false;
                }
                float f3 = this.f43828g;
                return f3 >= 0.0f && f3 <= 24.0f;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f43829e;

        /* renamed from: f  reason: collision with root package name */
        public int f43830f;

        /* renamed from: g  reason: collision with root package name */
        public int f43831g;

        /* renamed from: h  reason: collision with root package name */
        public int f43832h;

        /* renamed from: i  reason: collision with root package name */
        public float f43833i;
        public float j;

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
            this.f43832h = 0;
            this.f43833i = 0.0f;
            this.j = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.clone();
                bVar.f43829e = this.f43829e;
                bVar.f43830f = this.f43830f;
                bVar.f43831g = this.f43831g;
                bVar.f43832h = this.f43832h;
                bVar.f43833i = this.f43833i;
                bVar.j = this.j;
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43822f = null;
        this.f43823g = false;
        this.f43824h = null;
        this.f43825i = new C0579a();
        this.j = new b();
        this.f43824h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = (a) super.clone();
            String[] strArr = this.f43821e;
            aVar.f43821e = strArr != null ? (String[]) strArr.clone() : null;
            aVar.f43822f = new String(this.f43822f);
            aVar.f43823g = this.f43823g;
            aVar.f43825i = this.f43825i.clone();
            aVar.j = this.j.clone();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C0579a c0579a = this.f43825i;
            return (c0579a != null ? Boolean.valueOf(c0579a.e()) : null).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n======================");
            sb.append(this.f43824h);
            sb.append(" Player Server config information====================== \n");
            sb.append("host : \n");
            int i2 = 0;
            while (true) {
                String[] strArr = this.f43821e;
                if (strArr == null || i2 >= strArr.length) {
                    break;
                }
                sb.append("    " + this.f43821e[i2] + "\n");
                i2++;
            }
            sb.append("cntlId : \n    " + this.f43822f + ";\n");
            sb.append("pcdnSwitch : \n    " + this.f43823g + ";\n");
            sb.append("CdnConfig : \n    ");
            sb.append("sle : " + this.f43825i.f43826e + ", sl_rate : " + this.f43825i.f43827f + ", split_rate : " + this.f43825i.f43828g + ";\n");
            sb.append("PrefetchConfig : \n    ");
            sb.append("duration : " + this.j.f43829e + " pcdnEnable : " + this.j.f43830f + " p2pEnable : " + this.j.f43831g + " sl : " + this.j.f43832h + " sle : " + this.j.f43833i + " split_rate : " + this.j.j + ";\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
