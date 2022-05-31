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
/* loaded from: classes8.dex */
public abstract class gc {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f407a;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f408a;
    public static String b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public gg f409a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f410a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Object> f411a;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

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
        f407a = Locale.getDefault().getLanguage().toLowerCase();
        b = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f408a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = gn.a(5) + "-";
        a = 0L;
    }

    public gc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f410a = new CopyOnWriteArrayList();
        this.f411a = new HashMap();
        this.f409a = null;
    }

    public gc(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f410a = new CopyOnWriteArrayList();
        this.f411a = new HashMap();
        this.f409a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f410a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fz a2 = fz.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f410a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f409a = new gg(bundle2);
        }
    }

    public static synchronized String i() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (gc.class) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c);
                long j = a;
                a = 1 + j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f407a : (String) invokeV.objValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.d)) {
                bundle.putString("ext_ns", this.d);
            }
            if (!TextUtils.isEmpty(this.g)) {
                bundle.putString("ext_from", this.g);
            }
            if (!TextUtils.isEmpty(this.f)) {
                bundle.putString("ext_to", this.f);
            }
            if (!TextUtils.isEmpty(this.e)) {
                bundle.putString("ext_pkt_id", this.e);
            }
            if (!TextUtils.isEmpty(this.h)) {
                bundle.putString("ext_chid", this.h);
            }
            gg ggVar = this.f409a;
            if (ggVar != null) {
                bundle.putBundle("ext_ERROR", ggVar.a());
            }
            List<fz> list = this.f410a;
            if (list != null) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int i = 0;
                for (fz fzVar : this.f410a) {
                    Bundle a2 = fzVar.a();
                    if (a2 != null) {
                        bundleArr[i] = a2;
                        i++;
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
            for (fz fzVar : this.f410a) {
                if (str2 == null || str2.equals(fzVar.b())) {
                    if (str.equals(fzVar.m372a())) {
                        return fzVar;
                    }
                }
            }
            return null;
        }
        return (fz) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gg m381a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f409a : (gg) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m382a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (this.f411a == null) {
                    return null;
                }
                return this.f411a.get(str);
            }
        }
        return invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m383a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<fz> m384a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                return this.f410a == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f410a));
            }
        }
        return (Collection) invokeV.objValue;
    }

    public void a(fz fzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fzVar) == null) {
            this.f410a.add(fzVar);
        }
    }

    public void a(gg ggVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ggVar) == null) {
            this.f409a = ggVar;
        }
    }

    public synchronized Collection<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                return this.f411a == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.f411a.keySet()));
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
            gg ggVar = this.f409a;
            if (ggVar == null ? gcVar.f409a == null : ggVar.equals(gcVar.f409a)) {
                String str = this.g;
                if (str == null ? gcVar.g == null : str.equals(gcVar.g)) {
                    if (this.f410a.equals(gcVar.f410a)) {
                        String str2 = this.e;
                        if (str2 == null ? gcVar.e == null : str2.equals(gcVar.e)) {
                            String str3 = this.h;
                            if (str3 == null ? gcVar.h == null : str3.equals(gcVar.h)) {
                                Map<String, Object> map = this.f411a;
                                if (map == null ? gcVar.f411a == null : map.equals(gcVar.f411a)) {
                                    String str4 = this.f;
                                    if (str4 == null ? gcVar.f == null : str4.equals(gcVar.f)) {
                                        String str5 = this.d;
                                        String str6 = gcVar.d;
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
            String str = this.d;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.e;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.g;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.h;
            int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f410a.hashCode()) * 31) + this.f411a.hashCode()) * 31;
            gg ggVar = this.f409a;
            return hashCode5 + (ggVar != null ? ggVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if ("ID_NOT_AVAILABLE".equals(this.e)) {
                return null;
            }
            if (this.e == null) {
                this.e = i();
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.e = str;
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.h = str;
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f = str;
        }
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.g = str;
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
        Exception e;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this) {
                StringBuilder sb2 = new StringBuilder();
                for (fz fzVar : m384a()) {
                    sb2.append(fzVar.d());
                }
                if (this.f411a != null && !this.f411a.isEmpty()) {
                    sb2.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
                    for (String str2 : b()) {
                        Object m382a = m382a(str2);
                        sb2.append("<property>");
                        sb2.append("<name>");
                        sb2.append(gn.a(str2));
                        sb2.append("</name>");
                        sb2.append("<value type=\"");
                        if (m382a instanceof Integer) {
                            sb2.append("integer\">");
                            sb2.append(m382a);
                            str = "</value>";
                        } else if (m382a instanceof Long) {
                            sb2.append("long\">");
                            sb2.append(m382a);
                            str = "</value>";
                        } else if (m382a instanceof Float) {
                            sb2.append("float\">");
                            sb2.append(m382a);
                            str = "</value>";
                        } else if (m382a instanceof Double) {
                            sb2.append("double\">");
                            sb2.append(m382a);
                            str = "</value>";
                        } else if (m382a instanceof Boolean) {
                            sb2.append("boolean\">");
                            sb2.append(m382a);
                            str = "</value>";
                        } else if (m382a instanceof String) {
                            sb2.append("string\">");
                            sb2.append(gn.a((String) m382a));
                            str = "</value>";
                        } else {
                            ObjectOutputStream objectOutputStream2 = null;
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                    try {
                                        try {
                                            objectOutputStream.writeObject(m382a);
                                            sb2.append("java-object\">");
                                            sb2.append(gn.a(byteArrayOutputStream.toByteArray()));
                                            sb2.append("</value>");
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception unused) {
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            e.printStackTrace();
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
                                } catch (Exception e3) {
                                    e = e3;
                                    objectOutputStream = null;
                                    e = e;
                                    e.printStackTrace();
                                    if (objectOutputStream != null) {
                                    }
                                    if (byteArrayOutputStream == null) {
                                    }
                                    byteArrayOutputStream.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Exception e4) {
                                e = e4;
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
            this.i = str;
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.d : (String) invokeV.objValue;
    }
}
