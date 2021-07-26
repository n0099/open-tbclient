package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public abstract class gc {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f40448a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f426a;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f427a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40449b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40450c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public gg f428a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f429a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Object> f430a;

    /* renamed from: d  reason: collision with root package name */
    public String f40451d;

    /* renamed from: e  reason: collision with root package name */
    public String f40452e;

    /* renamed from: f  reason: collision with root package name */
    public String f40453f;

    /* renamed from: g  reason: collision with root package name */
    public String f40454g;

    /* renamed from: h  reason: collision with root package name */
    public String f40455h;

    /* renamed from: i  reason: collision with root package name */
    public String f40456i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374044, "Lcom/xiaomi/push/gc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374044, "Lcom/xiaomi/push/gc;");
                return;
            }
        }
        f426a = Locale.getDefault().getLanguage().toLowerCase();
        f40449b = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f427a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        f40450c = gn.a(5) + "-";
        f40448a = 0L;
    }

    public gc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40451d = f40449b;
        this.f40452e = null;
        this.f40453f = null;
        this.f40454g = null;
        this.f40455h = null;
        this.f40456i = null;
        this.f429a = new CopyOnWriteArrayList();
        this.f430a = new HashMap();
        this.f428a = null;
    }

    public gc(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f40451d = f40449b;
        this.f40452e = null;
        this.f40453f = null;
        this.f40454g = null;
        this.f40455h = null;
        this.f40456i = null;
        this.f429a = new CopyOnWriteArrayList();
        this.f430a = new HashMap();
        this.f428a = null;
        this.f40453f = bundle.getString("ext_to");
        this.f40454g = bundle.getString("ext_from");
        this.f40455h = bundle.getString("ext_chid");
        this.f40452e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f429a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fz a2 = fz.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f429a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f428a = new gg(bundle2);
        }
    }

    public static synchronized String i() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (gc.class) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f40450c);
                long j = f40448a;
                f40448a = 1 + j;
                sb2.append(Long.toString(j));
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f426a : (String) invokeV.objValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.f40451d)) {
                bundle.putString("ext_ns", this.f40451d);
            }
            if (!TextUtils.isEmpty(this.f40454g)) {
                bundle.putString("ext_from", this.f40454g);
            }
            if (!TextUtils.isEmpty(this.f40453f)) {
                bundle.putString("ext_to", this.f40453f);
            }
            if (!TextUtils.isEmpty(this.f40452e)) {
                bundle.putString("ext_pkt_id", this.f40452e);
            }
            if (!TextUtils.isEmpty(this.f40455h)) {
                bundle.putString("ext_chid", this.f40455h);
            }
            gg ggVar = this.f428a;
            if (ggVar != null) {
                bundle.putBundle("ext_ERROR", ggVar.a());
            }
            List<fz> list = this.f429a;
            if (list != null) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int i2 = 0;
                for (fz fzVar : this.f429a) {
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

    public fz a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? a(str, null) : (fz) invokeL.objValue;
    }

    public fz a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            for (fz fzVar : this.f429a) {
                if (str2 == null || str2.equals(fzVar.b())) {
                    if (str.equals(fzVar.m334a())) {
                        return fzVar;
                    }
                }
            }
            return null;
        }
        return (fz) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gg m343a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f428a : (gg) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m344a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (this.f430a == null) {
                    return null;
                }
                return this.f430a.get(str);
            }
        }
        return invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m345a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<fz> m346a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                return this.f429a == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f429a));
            }
        }
        return (Collection) invokeV.objValue;
    }

    public void a(fz fzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fzVar) == null) {
            this.f429a.add(fzVar);
        }
    }

    public void a(gg ggVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ggVar) == null) {
            this.f428a = ggVar;
        }
    }

    public synchronized Collection<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                return this.f430a == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.f430a.keySet()));
            }
        }
        return (Collection) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            gc gcVar = (gc) obj;
            gg ggVar = this.f428a;
            if (ggVar == null ? gcVar.f428a == null : ggVar.equals(gcVar.f428a)) {
                String str = this.f40454g;
                if (str == null ? gcVar.f40454g == null : str.equals(gcVar.f40454g)) {
                    if (this.f429a.equals(gcVar.f429a)) {
                        String str2 = this.f40452e;
                        if (str2 == null ? gcVar.f40452e == null : str2.equals(gcVar.f40452e)) {
                            String str3 = this.f40455h;
                            if (str3 == null ? gcVar.f40455h == null : str3.equals(gcVar.f40455h)) {
                                Map<String, Object> map = this.f430a;
                                if (map == null ? gcVar.f430a == null : map.equals(gcVar.f430a)) {
                                    String str4 = this.f40453f;
                                    if (str4 == null ? gcVar.f40453f == null : str4.equals(gcVar.f40453f)) {
                                        String str5 = this.f40451d;
                                        String str6 = gcVar.f40451d;
                                        if (str5 != null) {
                                            if (str5.equals(str6)) {
                                                return true;
                                            }
                                        } else if (str6 == null) {
                                            return true;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String str = this.f40451d;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f40452e;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f40453f;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f40454g;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f40455h;
            int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f429a.hashCode()) * 31) + this.f430a.hashCode()) * 31;
            gg ggVar = this.f428a;
            return hashCode5 + (ggVar != null ? ggVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if ("ID_NOT_AVAILABLE".equals(this.f40452e)) {
                return null;
            }
            if (this.f40452e == null) {
                this.f40452e = i();
            }
            return this.f40452e;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40455h : (String) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f40452e = str;
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f40453f : (String) invokeV.objValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f40455h = str;
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f40454g : (String) invokeV.objValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f40453f = str;
        }
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f40456i : (String) invokeV.objValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f40454g = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String o() {
        InterceptResult invokeV;
        String sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this) {
                StringBuilder sb2 = new StringBuilder();
                for (fz fzVar : m346a()) {
                    sb2.append(fzVar.d());
                }
                if (this.f430a != null && !this.f430a.isEmpty()) {
                    sb2.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
                    for (String str2 : b()) {
                        Object m344a = m344a(str2);
                        sb2.append("<property>");
                        sb2.append("<name>");
                        sb2.append(gn.a(str2));
                        sb2.append("</name>");
                        sb2.append("<value type=\"");
                        if (m344a instanceof Integer) {
                            sb2.append("integer\">");
                            sb2.append(m344a);
                            str = "</value>";
                        } else if (m344a instanceof Long) {
                            sb2.append("long\">");
                            sb2.append(m344a);
                            str = "</value>";
                        } else if (m344a instanceof Float) {
                            sb2.append("float\">");
                            sb2.append(m344a);
                            str = "</value>";
                        } else if (m344a instanceof Double) {
                            sb2.append("double\">");
                            sb2.append(m344a);
                            str = "</value>";
                        } else if (m344a instanceof Boolean) {
                            sb2.append("boolean\">");
                            sb2.append(m344a);
                            str = "</value>";
                        } else if (m344a instanceof String) {
                            sb2.append("string\">");
                            sb2.append(gn.a((String) m344a));
                            str = "</value>";
                        } else {
                            ObjectOutputStream objectOutputStream2 = null;
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                    try {
                                        try {
                                            objectOutputStream.writeObject(m344a);
                                            sb2.append("java-object\">");
                                            sb2.append(gn.a(byteArrayOutputStream.toByteArray()));
                                            sb2.append("</value>");
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception unused) {
                                            }
                                        } catch (Exception e3) {
                                            e2 = e3;
                                            e2.printStackTrace();
                                            if (objectOutputStream != null) {
                                                try {
                                                    objectOutputStream.close();
                                                } catch (Exception unused2) {
                                                }
                                            }
                                            if (byteArrayOutputStream == null) {
                                                sb2.append("</property>");
                                            }
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        objectOutputStream2 = objectOutputStream;
                                        if (objectOutputStream2 != null) {
                                            try {
                                                objectOutputStream2.close();
                                            } catch (Exception unused3) {
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused4) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    objectOutputStream = null;
                                    e2 = e;
                                    e2.printStackTrace();
                                    if (objectOutputStream != null) {
                                    }
                                    if (byteArrayOutputStream == null) {
                                    }
                                    byteArrayOutputStream.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                byteArrayOutputStream = null;
                                objectOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = null;
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        sb2.append(str);
                        sb2.append("</property>");
                    }
                    sb2.append("</properties>");
                }
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f40456i = str;
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f40451d : (String) invokeV.objValue;
    }
}
