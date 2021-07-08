package d.a.y.d;

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
    public String[] f68483e;

    /* renamed from: f  reason: collision with root package name */
    public String f68484f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68485g;

    /* renamed from: h  reason: collision with root package name */
    public String f68486h;

    /* renamed from: i  reason: collision with root package name */
    public C1951a f68487i;
    public b j;

    /* renamed from: d.a.y.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1951a implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f68488e;

        /* renamed from: f  reason: collision with root package name */
        public float f68489f;

        /* renamed from: g  reason: collision with root package name */
        public float f68490g;

        public C1951a() {
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
            this.f68488e = 0;
            this.f68489f = 0.0f;
            this.f68490g = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public C1951a clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                C1951a c1951a = (C1951a) super.clone();
                c1951a.f68488e = this.f68488e;
                c1951a.f68489f = this.f68489f;
                c1951a.f68490g = this.f68490g;
                return c1951a;
            }
            return (C1951a) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f68488e;
                if (i2 < 0 || i2 > 1) {
                    return false;
                }
                float f2 = this.f68489f;
                if (f2 < 0.0f || f2 > 16.0f) {
                    return false;
                }
                float f3 = this.f68490g;
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
        public int f68491e;

        /* renamed from: f  reason: collision with root package name */
        public int f68492f;

        /* renamed from: g  reason: collision with root package name */
        public int f68493g;

        /* renamed from: h  reason: collision with root package name */
        public int f68494h;

        /* renamed from: i  reason: collision with root package name */
        public float f68495i;
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
            this.f68494h = 0;
            this.f68495i = 0.0f;
            this.j = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.clone();
                bVar.f68491e = this.f68491e;
                bVar.f68492f = this.f68492f;
                bVar.f68493g = this.f68493g;
                bVar.f68494h = this.f68494h;
                bVar.f68495i = this.f68495i;
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
        this.f68484f = null;
        this.f68485g = false;
        this.f68486h = null;
        this.f68487i = new C1951a();
        this.j = new b();
        this.f68486h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = (a) super.clone();
            String[] strArr = this.f68483e;
            aVar.f68483e = strArr != null ? (String[]) strArr.clone() : null;
            aVar.f68484f = new String(this.f68484f);
            aVar.f68485g = this.f68485g;
            aVar.f68487i = this.f68487i.clone();
            aVar.j = this.j.clone();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C1951a c1951a = this.f68487i;
            return (c1951a != null ? Boolean.valueOf(c1951a.e()) : null).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n======================");
            sb.append(this.f68486h);
            sb.append(" Player Server config information====================== \n");
            sb.append("host : \n");
            int i2 = 0;
            while (true) {
                String[] strArr = this.f68483e;
                if (strArr == null || i2 >= strArr.length) {
                    break;
                }
                sb.append("    " + this.f68483e[i2] + "\n");
                i2++;
            }
            sb.append("cntlId : \n    " + this.f68484f + ";\n");
            sb.append("pcdnSwitch : \n    " + this.f68485g + ";\n");
            sb.append("CdnConfig : \n    ");
            sb.append("sle : " + this.f68487i.f68488e + ", sl_rate : " + this.f68487i.f68489f + ", split_rate : " + this.f68487i.f68490g + ";\n");
            sb.append("PrefetchConfig : \n    ");
            sb.append("duration : " + this.j.f68491e + " pcdnEnable : " + this.j.f68492f + " p2pEnable : " + this.j.f68493g + " sl : " + this.j.f68494h + " sle : " + this.j.f68495i + " split_rate : " + this.j.j + ";\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
