package com.bytedance.sdk.openadsdk.o;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f31788a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f31789b;

    /* renamed from: c  reason: collision with root package name */
    public final a f31790c;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f31791a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31792b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31793c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31794d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31795e;

        /* renamed from: f  reason: collision with root package name */
        public final String f31796f;

        /* renamed from: g  reason: collision with root package name */
        public final List<String> f31797g;

        public a(int i2, String str, String str2, int i3, int i4, String str3, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31791a = i2;
            this.f31792b = str;
            this.f31793c = str2;
            this.f31794d = i3;
            this.f31795e = i4;
            this.f31796f = str3;
            this.f31797g = list;
        }

        public static a a(c cVar, List<b> list) throws d {
            InterceptResult invokeLL;
            String str;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cVar, list)) == null) {
                int indexOf = cVar.f31801b.indexOf("?");
                if (indexOf != -1) {
                    ArrayList arrayList = new ArrayList();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    int i4 = 0;
                    for (String str5 : cVar.f31801b.substring(indexOf + 1).split("&")) {
                        String[] split = str5.split("=");
                        if (split.length == 2) {
                            if ("rk".equals(split[0])) {
                                str3 = Uri.decode(split[1]);
                            } else if (Config.APP_KEY.equals(split[0])) {
                                str4 = Uri.decode(split[1]);
                            } else if (split[0].startsWith("u")) {
                                arrayList.add(Uri.decode(split[1]));
                            } else if ("f".equals(split[0]) && com.bytedance.sdk.openadsdk.o.g.d.b(split[1]) == 1) {
                                i4 = 1;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (list != null) {
                            i3 = 0;
                            int i5 = 0;
                            for (b bVar : list) {
                                if (bVar != null && "Range".equalsIgnoreCase(bVar.f31798a)) {
                                    int indexOf2 = bVar.f31799b.indexOf("=");
                                    if (indexOf2 != -1) {
                                        if ("bytes".equalsIgnoreCase(bVar.f31799b.substring(0, indexOf2).trim())) {
                                            String substring = bVar.f31799b.substring(indexOf2 + 1);
                                            if (!substring.contains(",")) {
                                                int indexOf3 = substring.indexOf("-");
                                                if (indexOf3 != -1) {
                                                    String trim = substring.substring(0, indexOf3).trim();
                                                    String trim2 = substring.substring(indexOf3 + 1).trim();
                                                    try {
                                                        if (trim.length() > 0) {
                                                            i3 = Integer.parseInt(trim);
                                                        }
                                                        if (trim2.length() > 0 && i3 > (i5 = Integer.parseInt(trim2))) {
                                                            throw new d("Range format error, Range: " + bVar.f31799b);
                                                        }
                                                        str2 = bVar.f31799b;
                                                    } catch (NumberFormatException unused) {
                                                        throw new d("Range format error, Range: " + bVar.f31799b);
                                                    }
                                                } else {
                                                    throw new d("Range format error, Range: " + bVar.f31799b);
                                                }
                                            } else {
                                                throw new d("Range format error, Range: " + bVar.f31799b);
                                            }
                                        } else {
                                            throw new d("Range format error, Range: " + bVar.f31799b);
                                        }
                                    } else {
                                        throw new d("Range format error, Range: " + bVar.f31799b);
                                    }
                                }
                            }
                            i2 = i5;
                            str = str2;
                        } else {
                            str = null;
                            i2 = 0;
                            i3 = 0;
                        }
                        if (!arrayList.isEmpty()) {
                            return new a(i4, str3, str4, i3, i2, str, arrayList);
                        }
                        throw new d("no url found: path: " + cVar.f31801b);
                    }
                    throw new d("rawKey or key is empty, path: " + cVar.f31801b);
                }
                throw new d("path format error, path: " + cVar.f31801b);
            }
            return (a) invokeLL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Extra{flag=" + this.f31791a + ", rawKey='" + this.f31792b + "', key='" + this.f31793c + "', from=" + this.f31794d + ", to=" + this.f31795e + ", urls=" + this.f31797g + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f31798a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31799b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31798a = str;
            this.f31799b = str2;
        }

        public static b a(String str) throws d {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    String trim = str.substring(0, indexOf).trim();
                    String trim2 = str.substring(indexOf + 1).trim();
                    if (trim.length() != 0 && trim2.length() != 0) {
                        return new b(trim, trim2);
                    }
                    throw new d("request header format error, header: " + str);
                }
                throw new d("request header format error, header: " + str);
            }
            return (b) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Header{name='" + this.f31798a + "', value='" + this.f31799b + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f31800a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31801b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31802c;

        public c(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31800a = str;
            this.f31801b = str2;
            this.f31802c = str3;
        }

        public static c a(String str) throws d {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                int indexOf = str.indexOf(32);
                if (indexOf != -1) {
                    int lastIndexOf = str.lastIndexOf(32);
                    if (lastIndexOf > indexOf) {
                        String trim = str.substring(0, indexOf).trim();
                        String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
                        String trim3 = str.substring(lastIndexOf + 1).trim();
                        if (trim.length() != 0 && trim2.length() != 0 && trim3.length() != 0) {
                            return new c(trim, trim2, trim3);
                        }
                        throw new d("request line format error, line: " + str);
                    }
                    throw new d("request line format error, line: " + str);
                }
                throw new d("request line format error, line: " + str);
            }
            return (c) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "RequestLine{method='" + this.f31800a + "', path='" + this.f31801b + "', version='" + this.f31802c + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public i(c cVar, List<b> list, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, list, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31788a = cVar;
        this.f31789b = list;
        this.f31790c = aVar;
    }

    public static i a(InputStream inputStream) throws IOException, d {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bytedance.sdk.openadsdk.o.g.d.f31784a));
            ArrayList arrayList = new ArrayList();
            c cVar = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    break;
                }
                String trim = readLine.trim();
                if (cVar == null) {
                    cVar = c.a(trim);
                } else {
                    arrayList.add(b.a(trim));
                }
            }
            if (cVar != null) {
                return new i(cVar, arrayList, a.a(cVar, arrayList));
            }
            throw new d("request line is null");
        }
        return (i) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "Request{requestLine=" + this.f31788a + ", headers=" + this.f31789b + ", extra=" + this.f31790c + '}';
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str, String str2, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, list)) == null) {
            StringBuilder sb = new StringBuilder(512);
            String str3 = null;
            do {
                if (str3 != null) {
                    if (list.size() == 1) {
                        return null;
                    }
                    list.remove(list.size() - 1);
                }
                str3 = a(sb, str, str2, list);
            } while (str3.length() > 3072);
            return str3;
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(StringBuilder sb, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, sb, str, str2, list)) == null) {
            sb.delete(0, sb.length());
            sb.append("rk");
            sb.append("=");
            sb.append(Uri.encode(str));
            sb.append("&");
            sb.append(Config.APP_KEY);
            sb.append("=");
            sb.append(Uri.encode(str2));
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("&");
                sb.append("u");
                sb.append(i2);
                sb.append("=");
                sb.append(Uri.encode(list.get(i2)));
            }
            return sb.toString();
        }
        return (String) invokeLLLL.objValue;
    }
}
