package com.ta.utdid2.b.a;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f76055b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f76056a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f19a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<File, a> f20a;

    /* loaded from: classes10.dex */
    public static final class a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final Object f76057c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map f76058a;

        /* renamed from: a  reason: collision with other field name */
        public WeakHashMap<b.InterfaceC2080b, Object> f21a;

        /* renamed from: b  reason: collision with root package name */
        public final File f76059b;

        /* renamed from: c  reason: collision with other field name */
        public final int f22c;

        /* renamed from: c  reason: collision with other field name */
        public final File f23c;

        /* renamed from: j  reason: collision with root package name */
        public boolean f76060j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-385500886, "Lcom/ta/utdid2/b/a/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-385500886, "Lcom/ta/utdid2/b/a/d$a;");
                    return;
                }
            }
            f76057c = new Object();
        }

        public a(File file, int i2, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Integer.valueOf(i2), map};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f76060j = false;
            this.f76059b = file;
            this.f23c = d.a(file);
            this.f22c = i2;
            this.f76058a = map == null ? new HashMap() : map;
            this.f21a = new WeakHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
                if (this.f76059b.exists()) {
                    if (!this.f23c.exists()) {
                        if (!this.f76059b.renameTo(this.f23c)) {
                            return false;
                        }
                    } else {
                        this.f76059b.delete();
                    }
                }
                try {
                    FileOutputStream a2 = a(this.f76059b);
                    if (a2 == null) {
                        return false;
                    }
                    e.a(this.f76058a, a2);
                    a2.close();
                    this.f23c.delete();
                    return true;
                } catch (Exception unused) {
                    if (this.f76059b.exists()) {
                        this.f76059b.delete();
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.ta.utdid2.b.a.b
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f76059b != null && new File(this.f76059b.getAbsolutePath()).exists() : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    z = this.f76060j;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // com.ta.utdid2.b.a.b
        public Map<String, ?> getAll() {
            InterceptResult invokeV;
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this) {
                    hashMap = new HashMap(this.f76058a);
                }
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        @Override // com.ta.utdid2.b.a.b
        public long getLong(String str, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j2)) == null) {
                synchronized (this) {
                    Long l = (Long) this.f76058a.get(str);
                    if (l != null) {
                        j2 = l.longValue();
                    }
                }
                return j2;
            }
            return invokeLJ.longValue;
        }

        @Override // com.ta.utdid2.b.a.b
        public String getString(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                synchronized (this) {
                    String str3 = (String) this.f76058a.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                }
                return str2;
            }
            return (String) invokeLL.objValue;
        }

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public final class C2081a implements b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f76061a;

            /* renamed from: b  reason: collision with root package name */
            public final Map<String, Object> f76062b;
            public boolean k;

            public C2081a(a aVar) {
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
                this.f76061a = aVar;
                this.f76062b = new HashMap();
                this.k = false;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                    synchronized (this) {
                        this.f76062b.put(str, str2);
                    }
                    return this;
                }
                return (b.a) invokeLL.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    synchronized (this) {
                        this.k = true;
                    }
                    return this;
                }
                return (b.a) invokeV.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public boolean commit() {
                InterceptResult invokeV;
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC2080b> hashSet;
                boolean e2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    synchronized (d.f76055b) {
                        z = this.f76061a.f21a.size() > 0;
                        arrayList = null;
                        if (z) {
                            arrayList = new ArrayList();
                            hashSet = new HashSet(this.f76061a.f21a.keySet());
                        } else {
                            hashSet = null;
                        }
                        synchronized (this) {
                            if (this.k) {
                                this.f76061a.f76058a.clear();
                                this.k = false;
                            }
                            for (Map.Entry<String, Object> entry : this.f76062b.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (value == this) {
                                    this.f76061a.f76058a.remove(key);
                                } else {
                                    this.f76061a.f76058a.put(key, value);
                                }
                                if (z) {
                                    arrayList.add(key);
                                }
                            }
                            this.f76062b.clear();
                        }
                        e2 = this.f76061a.e();
                        if (e2) {
                            this.f76061a.a(true);
                        }
                    }
                    if (z) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            String str = (String) arrayList.get(size);
                            for (b.InterfaceC2080b interfaceC2080b : hashSet) {
                                if (interfaceC2080b != null) {
                                    interfaceC2080b.a(this.f76061a, str);
                                }
                            }
                        }
                    }
                    return e2;
                }
                return invokeV.booleanValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
                    synchronized (this) {
                        this.f76062b.put(str, Integer.valueOf(i2));
                    }
                    return this;
                }
                return (b.a) invokeLI.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, long j2) {
                InterceptResult invokeLJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j2)) == null) {
                    synchronized (this) {
                        this.f76062b.put(str, Long.valueOf(j2));
                    }
                    return this;
                }
                return (b.a) invokeLJ.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, float f2) {
                InterceptResult invokeLF;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f2)) == null) {
                    synchronized (this) {
                        this.f76062b.put(str, Float.valueOf(f2));
                    }
                    return this;
                }
                return (b.a) invokeLF.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, boolean z) {
                InterceptResult invokeLZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
                    synchronized (this) {
                        this.f76062b.put(str, Boolean.valueOf(z));
                    }
                    return this;
                }
                return (b.a) invokeLZ.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    synchronized (this) {
                        this.f76062b.put(str, this);
                    }
                    return this;
                }
                return (b.a) invokeL.objValue;
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                synchronized (this) {
                    this.f76060j = z;
                }
            }
        }

        public void a(Map map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) || map == null) {
                return;
            }
            synchronized (this) {
                this.f76058a = map;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public b.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C2081a(this) : (b.a) invokeV.objValue;
        }

        private FileOutputStream a(File file) {
            InterceptResult invokeL;
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, file)) == null) {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused) {
                    if (!file.getParentFile().mkdir()) {
                        return null;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (FileNotFoundException unused2) {
                        return null;
                    }
                }
                return fileOutputStream;
            }
            return (FileOutputStream) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(669989191, "Lcom/ta/utdid2/b/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(669989191, "Lcom/ta/utdid2/b/a/d;");
                return;
            }
        }
        f76055b = new Object();
    }

    public d(String str) {
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
        this.f19a = new Object();
        this.f20a = new HashMap<>();
        if (str != null && str.length() > 0) {
            this.f76056a = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    private File a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, file, str)) == null) {
            if (str.indexOf(File.separatorChar) < 0) {
                return new File(file, str);
            }
            throw new IllegalArgumentException("File " + str + " contains a path separator");
        }
        return (File) invokeLL.objValue;
    }

    private File b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            File a2 = a();
            return a(a2, str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        }
        return (File) invokeL.objValue;
    }

    private File a() {
        InterceptResult invokeV;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this.f19a) {
                file = this.f76056a;
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x005e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x0039 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090 A[Catch: all -> 0x005e, TRY_ENTER, TRY_LEAVE, TryCatch #17 {all -> 0x005e, blocks: (B:32:0x005b, B:55:0x0090), top: B:93:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(String str, int i2) {
        InterceptResult invokeLI;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            File b2 = b(str);
            synchronized (f76055b) {
                a aVar = this.f20a.get(b2);
                if (aVar == null || aVar.d()) {
                    File a2 = a(b2);
                    if (a2.exists()) {
                        b2.delete();
                        a2.renameTo(b2);
                    }
                    HashMap hashMap = null;
                    hashMap = null;
                    hashMap = null;
                    FileInputStream fileInputStream3 = null;
                    FileInputStream fileInputStream4 = null;
                    hashMap = null;
                    FileInputStream fileInputStream5 = null;
                    if (b2.exists()) {
                        HashMap canRead = b2.canRead();
                        try {
                            try {
                                if (canRead != 0) {
                                    try {
                                        fileInputStream2 = new FileInputStream(b2);
                                    } catch (XmlPullParserException unused) {
                                        canRead = 0;
                                    } catch (Exception unused2) {
                                        canRead = null;
                                    }
                                    try {
                                        hashMap = e.a(fileInputStream2);
                                        fileInputStream2.close();
                                        try {
                                            fileInputStream2.close();
                                        } catch (Throwable unused3) {
                                        }
                                    } catch (XmlPullParserException unused4) {
                                        HashMap hashMap2 = hashMap;
                                        fileInputStream3 = fileInputStream2;
                                        canRead = hashMap2;
                                        try {
                                            fileInputStream = new FileInputStream(b2);
                                            try {
                                                fileInputStream.read(new byte[fileInputStream.available()]);
                                                try {
                                                    fileInputStream.close();
                                                } catch (Throwable unused5) {
                                                }
                                            } catch (Exception unused6) {
                                                fileInputStream3 = fileInputStream;
                                                if (fileInputStream3 != null) {
                                                    try {
                                                        fileInputStream3.close();
                                                    } catch (Throwable unused7) {
                                                    }
                                                }
                                                fileInputStream = fileInputStream3;
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                    canRead = canRead;
                                                }
                                                hashMap = canRead;
                                                synchronized (f76055b) {
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                fileInputStream3 = fileInputStream;
                                                if (fileInputStream3 != null) {
                                                    try {
                                                        fileInputStream3.close();
                                                    } catch (Throwable unused8) {
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Exception unused9) {
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        hashMap = canRead;
                                        synchronized (f76055b) {
                                        }
                                    } catch (Exception unused10) {
                                        HashMap hashMap3 = hashMap;
                                        fileInputStream4 = fileInputStream2;
                                        canRead = hashMap3;
                                        if (fileInputStream4 != null) {
                                            fileInputStream4.close();
                                            canRead = canRead;
                                        }
                                        hashMap = canRead;
                                        synchronized (f76055b) {
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileInputStream5 = fileInputStream2;
                                        if (fileInputStream5 != null) {
                                            try {
                                                fileInputStream5.close();
                                            } catch (Throwable unused11) {
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable unused12) {
                        }
                    }
                    synchronized (f76055b) {
                        if (aVar != null) {
                            aVar.a(hashMap);
                        } else {
                            aVar = this.f20a.get(b2);
                            if (aVar == null) {
                                aVar = new a(b2, i2, hashMap);
                                this.f20a.put(b2, aVar);
                            }
                        }
                    }
                    return aVar;
                }
                return aVar;
            }
        }
        return (b) invokeLI.objValue;
    }

    public static File a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            return new File(file.getPath() + ".bak");
        }
        return (File) invokeL.objValue;
    }
}
