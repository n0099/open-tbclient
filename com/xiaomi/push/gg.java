package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class gg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77532a;

    /* renamed from: a  reason: collision with other field name */
    public String f439a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f440a;

    /* renamed from: b  reason: collision with root package name */
    public String f77533b;

    /* renamed from: c  reason: collision with root package name */
    public String f77534c;

    /* renamed from: d  reason: collision with root package name */
    public String f77535d;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f77536a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f77537b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f77538c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f77539d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f77540e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f77541f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f77542g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f77543h;

        /* renamed from: i  reason: collision with root package name */
        public static final a f77544i;

        /* renamed from: j  reason: collision with root package name */
        public static final a f77545j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        public static final a s;
        public static final a t;
        public static final a u;
        public static final a v;
        public static final a w;
        public static final a x;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public String f441a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1659218691, "Lcom/xiaomi/push/gg$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1659218691, "Lcom/xiaomi/push/gg$a;");
                    return;
                }
            }
            f77536a = new a("internal-server-error");
            f77537b = new a("forbidden");
            f77538c = new a("bad-request");
            f77539d = new a("conflict");
            f77540e = new a("feature-not-implemented");
            f77541f = new a("gone");
            f77542g = new a("item-not-found");
            f77543h = new a("jid-malformed");
            f77544i = new a("not-acceptable");
            f77545j = new a("not-allowed");
            k = new a("not-authorized");
            l = new a("payment-required");
            m = new a("recipient-unavailable");
            n = new a("redirect");
            o = new a("registration-required");
            p = new a("remote-server-error");
            q = new a("remote-server-not-found");
            r = new a("remote-server-timeout");
            s = new a("resource-constraint");
            t = new a("service-unavailable");
            u = new a("subscription-required");
            v = new a("undefined-condition");
            w = new a("unexpected-request");
            x = new a("request-timeout");
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f441a = str;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f441a : (String) invokeV.objValue;
        }
    }

    public gg(int i2, String str, String str2, String str3, String str4, List<fz> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, str3, str4, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f440a = null;
        this.f77532a = i2;
        this.f439a = str;
        this.f77534c = str2;
        this.f77533b = str3;
        this.f77535d = str4;
        this.f440a = list;
    }

    public gg(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f440a = null;
        this.f77532a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f439a = bundle.getString("ext_err_type");
        }
        this.f77533b = bundle.getString("ext_err_cond");
        this.f77534c = bundle.getString("ext_err_reason");
        this.f77535d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f440a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fz a2 = fz.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f440a.add(a2);
                }
            }
        }
    }

    public gg(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f440a = null;
        a(aVar);
        this.f77535d = null;
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            this.f77533b = aVar.f441a;
        }
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            String str = this.f439a;
            if (str != null) {
                bundle.putString("ext_err_type", str);
            }
            bundle.putInt("ext_err_code", this.f77532a);
            String str2 = this.f77534c;
            if (str2 != null) {
                bundle.putString("ext_err_reason", str2);
            }
            String str3 = this.f77533b;
            if (str3 != null) {
                bundle.putString("ext_err_cond", str3);
            }
            String str4 = this.f77535d;
            if (str4 != null) {
                bundle.putString("ext_err_msg", str4);
            }
            List<fz> list = this.f440a;
            if (list != null) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int i2 = 0;
                for (fz fzVar : this.f440a) {
                    Bundle a2 = fzVar.a();
                    if (a2 != null) {
                        bundleArr[i2] = a2;
                        i2++;
                    }
                }
                bundle.putParcelableArray("ext_exts", bundleArr);
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m350a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<error code=\"");
            sb.append(this.f77532a);
            sb.append("\"");
            if (this.f439a != null) {
                sb.append(" type=\"");
                sb.append(this.f439a);
                sb.append("\"");
            }
            if (this.f77534c != null) {
                sb.append(" reason=\"");
                sb.append(this.f77534c);
                sb.append("\"");
            }
            sb.append(">");
            if (this.f77533b != null) {
                sb.append("<");
                sb.append(this.f77533b);
                sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
            }
            if (this.f77535d != null) {
                sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
                sb.append(this.f77535d);
                sb.append("</text>");
            }
            for (fz fzVar : m351a()) {
                sb.append(fzVar.d());
            }
            sb.append("</error>");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<fz> m351a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                return this.f440a == null ? Collections.emptyList() : Collections.unmodifiableList(this.f440a);
            }
        }
        return (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String str = this.f77533b;
            if (str != null) {
                sb.append(str);
            }
            sb.append("(");
            sb.append(this.f77532a);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            if (this.f77535d != null) {
                sb.append(" ");
                sb.append(this.f77535d);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
