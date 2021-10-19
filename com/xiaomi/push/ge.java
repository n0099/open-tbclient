package com.xiaomi.push;

import android.os.Bundle;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ge extends gc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f78050a;

    /* renamed from: a  reason: collision with other field name */
    public a f435a;

    /* renamed from: a  reason: collision with other field name */
    public b f436a;

    /* renamed from: b  reason: collision with root package name */
    public String f78051b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f78052a;

        /* renamed from: a  reason: collision with other field name */
        public static final /* synthetic */ a[] f437a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f78053b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f78054c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f78055d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f78056e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1659159109, "Lcom/xiaomi/push/ge$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1659159109, "Lcom/xiaomi/push/ge$a;");
                    return;
                }
            }
            f78052a = new a("chat", 0);
            f78053b = new a("available", 1);
            f78054c = new a("away", 2);
            f78055d = new a("xa", 3);
            a aVar = new a("dnd", 4);
            f78056e = aVar;
            f437a = new a[]{f78052a, f78053b, f78054c, f78055d, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f437a.clone() : (a[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f78057a;

        /* renamed from: a  reason: collision with other field name */
        public static final /* synthetic */ b[] f438a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f78058b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f78059c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f78060d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f78061e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f78062f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f78063g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f78064h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1659159140, "Lcom/xiaomi/push/ge$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1659159140, "Lcom/xiaomi/push/ge$b;");
                    return;
                }
            }
            f78057a = new b("available", 0);
            f78058b = new b("unavailable", 1);
            f78059c = new b(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, 2);
            f78060d = new b("subscribed", 3);
            f78061e = new b("unsubscribe", 4);
            f78062f = new b("unsubscribed", 5);
            f78063g = new b("error", 6);
            b bVar = new b("probe", 7);
            f78064h = bVar;
            f438a = new b[]{f78057a, f78058b, f78059c, f78060d, f78061e, f78062f, f78063g, bVar};
        }

        public b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) f438a.clone() : (b[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge(Bundle bundle) {
        super(bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Bundle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f436a = b.f78057a;
        this.f78051b = null;
        this.f78050a = Integer.MIN_VALUE;
        this.f435a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f436a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f78051b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f78050a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f435a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public ge(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f436a = b.f78057a;
        this.f78051b = null;
        this.f78050a = Integer.MIN_VALUE;
        this.f435a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle a2 = super.a();
            b bVar = this.f436a;
            if (bVar != null) {
                a2.putString("ext_pres_type", bVar.toString());
            }
            String str = this.f78051b;
            if (str != null) {
                a2.putString("ext_pres_status", str);
            }
            int i2 = this.f78050a;
            if (i2 != Integer.MIN_VALUE) {
                a2.putInt("ext_pres_prio", i2);
            }
            a aVar = this.f435a;
            if (aVar != null && aVar != a.f78053b) {
                a2.putString("ext_pres_mode", aVar.toString());
            }
            return a2;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gc
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<presence");
            if (p() != null) {
                sb.append(" xmlns=\"");
                sb.append(p());
                sb.append("\"");
            }
            if (j() != null) {
                sb.append(" id=\"");
                sb.append(j());
                sb.append("\"");
            }
            if (l() != null) {
                sb.append(" to=\"");
                sb.append(gn.a(l()));
                sb.append("\"");
            }
            if (m() != null) {
                sb.append(" from=\"");
                sb.append(gn.a(m()));
                sb.append("\"");
            }
            if (k() != null) {
                sb.append(" chid=\"");
                sb.append(gn.a(k()));
                sb.append("\"");
            }
            if (this.f436a != null) {
                sb.append(" type=\"");
                sb.append(this.f436a);
                sb.append("\"");
            }
            sb.append(">");
            if (this.f78051b != null) {
                sb.append("<status>");
                sb.append(gn.a(this.f78051b));
                sb.append("</status>");
            }
            if (this.f78050a != Integer.MIN_VALUE) {
                sb.append("<priority>");
                sb.append(this.f78050a);
                sb.append("</priority>");
            }
            a aVar = this.f435a;
            if (aVar != null && aVar != a.f78053b) {
                sb.append("<show>");
                sb.append(this.f435a);
                sb.append("</show>");
            }
            sb.append(o());
            gg m346a = m346a();
            if (m346a != null) {
                sb.append(m346a.m350a());
            }
            sb.append("</presence>");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 >= -128 && i2 <= 128) {
                this.f78050a = i2;
                return;
            }
            throw new IllegalArgumentException("Priority value " + i2 + " is not valid. Valid range is -128 through 128.");
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f435a = aVar;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            if (bVar == null) {
                throw new NullPointerException("Type cannot be null");
            }
            this.f436a = bVar;
        }
    }

    @Override // com.xiaomi.push.gc
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f78051b = str;
        }
    }
}
