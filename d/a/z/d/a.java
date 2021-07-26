package d.a.z.d;

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
    public String[] f69161e;

    /* renamed from: f  reason: collision with root package name */
    public String f69162f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f69163g;

    /* renamed from: h  reason: collision with root package name */
    public String f69164h;

    /* renamed from: i  reason: collision with root package name */
    public C1956a f69165i;
    public b j;

    /* renamed from: d.a.z.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1956a implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f69166e;

        /* renamed from: f  reason: collision with root package name */
        public float f69167f;

        /* renamed from: g  reason: collision with root package name */
        public float f69168g;

        public C1956a() {
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
            this.f69166e = 0;
            this.f69167f = 0.0f;
            this.f69168g = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public C1956a clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                C1956a c1956a = (C1956a) super.clone();
                c1956a.f69166e = this.f69166e;
                c1956a.f69167f = this.f69167f;
                c1956a.f69168g = this.f69168g;
                return c1956a;
            }
            return (C1956a) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f69166e;
                if (i2 < 0 || i2 > 1) {
                    return false;
                }
                float f2 = this.f69167f;
                if (f2 < 0.0f || f2 > 16.0f) {
                    return false;
                }
                float f3 = this.f69168g;
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
        public int f69169e;

        /* renamed from: f  reason: collision with root package name */
        public int f69170f;

        /* renamed from: g  reason: collision with root package name */
        public int f69171g;

        /* renamed from: h  reason: collision with root package name */
        public int f69172h;

        /* renamed from: i  reason: collision with root package name */
        public float f69173i;
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
            this.f69172h = 0;
            this.f69173i = 0.0f;
            this.j = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.clone();
                bVar.f69169e = this.f69169e;
                bVar.f69170f = this.f69170f;
                bVar.f69171g = this.f69171g;
                bVar.f69172h = this.f69172h;
                bVar.f69173i = this.f69173i;
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
        this.f69162f = null;
        this.f69163g = false;
        this.f69164h = null;
        this.f69165i = new C1956a();
        this.j = new b();
        this.f69164h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = (a) super.clone();
            String[] strArr = this.f69161e;
            aVar.f69161e = strArr != null ? (String[]) strArr.clone() : null;
            aVar.f69162f = new String(this.f69162f);
            aVar.f69163g = this.f69163g;
            aVar.f69165i = this.f69165i.clone();
            aVar.j = this.j.clone();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C1956a c1956a = this.f69165i;
            return (c1956a != null ? Boolean.valueOf(c1956a.e()) : null).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n======================");
            sb.append(this.f69164h);
            sb.append(" Player Server config information====================== \n");
            sb.append("host : \n");
            int i2 = 0;
            while (true) {
                String[] strArr = this.f69161e;
                if (strArr == null || i2 >= strArr.length) {
                    break;
                }
                sb.append("    " + this.f69161e[i2] + "\n");
                i2++;
            }
            sb.append("cntlId : \n    " + this.f69162f + ";\n");
            sb.append("pcdnSwitch : \n    " + this.f69163g + ";\n");
            sb.append("CdnConfig : \n    ");
            sb.append("sle : " + this.f69165i.f69166e + ", sl_rate : " + this.f69165i.f69167f + ", split_rate : " + this.f69165i.f69168g + ";\n");
            sb.append("PrefetchConfig : \n    ");
            sb.append("duration : " + this.j.f69169e + " pcdnEnable : " + this.j.f69170f + " p2pEnable : " + this.j.f69171g + " sl : " + this.j.f69172h + " sle : " + this.j.f69173i + " split_rate : " + this.j.j + ";\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
