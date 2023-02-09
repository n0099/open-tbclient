package com.ta.utdid2.b.a;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f26a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<File, a> f27a;

    /* loaded from: classes8.dex */
    public static final class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public static final Object c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map a;

        /* renamed from: a  reason: collision with other field name */
        public WeakHashMap<b.InterfaceC0728b, Object> f28a;
        public final File b;

        /* renamed from: c  reason: collision with other field name */
        public final int f29c;

        /* renamed from: c  reason: collision with other field name */
        public final File f30c;
        public boolean j;

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public final class C0729a implements b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;
            public final Map<String, Object> b;
            public boolean k;

            public C0729a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
                this.b = new HashMap();
                this.k = false;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    synchronized (this) {
                        this.b.put(str, this);
                    }
                    return this;
                }
                return (b.a) invokeL.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, float f) {
                InterceptResult invokeLF;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f)) == null) {
                    synchronized (this) {
                        this.b.put(str, Float.valueOf(f));
                    }
                    return this;
                }
                return (b.a) invokeLF.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, int i) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
                    synchronized (this) {
                        this.b.put(str, Integer.valueOf(i));
                    }
                    return this;
                }
                return (b.a) invokeLI.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, long j) {
                InterceptResult invokeLJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) {
                    synchronized (this) {
                        this.b.put(str, Long.valueOf(j));
                    }
                    return this;
                }
                return (b.a) invokeLJ.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                    synchronized (this) {
                        this.b.put(str, str2);
                    }
                    return this;
                }
                return (b.a) invokeLL.objValue;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, boolean z) {
                InterceptResult invokeLZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
                    synchronized (this) {
                        this.b.put(str, Boolean.valueOf(z));
                    }
                    return this;
                }
                return (b.a) invokeLZ.objValue;
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
                HashSet<b.InterfaceC0728b> hashSet;
                boolean e;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    synchronized (d.b) {
                        if (this.a.f28a.size() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        arrayList = null;
                        if (z) {
                            arrayList = new ArrayList();
                            hashSet = new HashSet(this.a.f28a.keySet());
                        } else {
                            hashSet = null;
                        }
                        synchronized (this) {
                            if (this.k) {
                                this.a.a.clear();
                                this.k = false;
                            }
                            for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (value == this) {
                                    this.a.a.remove(key);
                                } else {
                                    this.a.a.put(key, value);
                                }
                                if (z) {
                                    arrayList.add(key);
                                }
                            }
                            this.b.clear();
                        }
                        e = this.a.e();
                        if (e) {
                            this.a.a(true);
                        }
                    }
                    if (z) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            String str = (String) arrayList.get(size);
                            for (b.InterfaceC0728b interfaceC0728b : hashSet) {
                                if (interfaceC0728b != null) {
                                    interfaceC0728b.a(this.a, str);
                                }
                            }
                        }
                    }
                    return e;
                }
                return invokeV.booleanValue;
            }
        }

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
            c = new Object();
        }

        @Override // com.ta.utdid2.b.a.b
        public b.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new C0729a(this);
            }
            return (b.a) invokeV.objValue;
        }

        @Override // com.ta.utdid2.b.a.b
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.b != null && new File(this.b.getAbsolutePath()).exists()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    z = this.j;
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
                    hashMap = new HashMap(this.a);
                }
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        public a(File file, int i, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Integer.valueOf(i), map};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.j = false;
            this.b = file;
            this.f30c = d.a(file);
            this.f29c = i;
            this.a = map == null ? new HashMap() : map;
            this.f28a = new WeakHashMap<>();
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

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                if (this.b.exists()) {
                    if (!this.f30c.exists()) {
                        if (!this.b.renameTo(this.f30c)) {
                            return false;
                        }
                    } else {
                        this.b.delete();
                    }
                }
                try {
                    FileOutputStream a = a(this.b);
                    if (a == null) {
                        return false;
                    }
                    e.a(this.a, a);
                    a.close();
                    this.f30c.delete();
                    return true;
                } catch (Exception unused) {
                    if (this.b.exists()) {
                        this.b.delete();
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public void a(Map map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) && map != null) {
                synchronized (this) {
                    this.a = map;
                }
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                synchronized (this) {
                    this.j = z;
                }
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public long getLong(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
                synchronized (this) {
                    Long l = (Long) this.a.get(str);
                    if (l != null) {
                        j = l.longValue();
                    }
                }
                return j;
            }
            return invokeLJ.longValue;
        }

        @Override // com.ta.utdid2.b.a.b
        public String getString(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                synchronized (this) {
                    String str3 = (String) this.a.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                }
                return str2;
            }
            return (String) invokeLL.objValue;
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
        b = new Object();
    }

    private File a() {
        InterceptResult invokeV;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this.f26a) {
                file = this.a;
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26a = new Object();
        this.f27a = new HashMap<>();
        if (str != null && str.length() > 0) {
            this.a = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    public static File a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            return new File(file.getPath() + ".bak");
        }
        return (File) invokeL.objValue;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0060 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x0039 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0093 A[Catch: all -> 0x0060, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0060, blocks: (B:33:0x005d, B:57:0x0093), top: B:83:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(String str, int i) {
        InterceptResult invokeLI;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            File b2 = b(str);
            synchronized (b) {
                a aVar = this.f27a.get(b2);
                if (aVar != null && !aVar.d()) {
                    return aVar;
                }
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
                if (b2.exists()) {
                    HashMap canRead = b2.canRead();
                    try {
                        try {
                            if (canRead != 0) {
                                try {
                                    fileInputStream = new FileInputStream(b2);
                                    try {
                                        hashMap = e.a(fileInputStream);
                                        fileInputStream.close();
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable unused) {
                                        }
                                    } catch (XmlPullParserException unused2) {
                                        HashMap hashMap2 = hashMap;
                                        fileInputStream3 = fileInputStream;
                                        canRead = hashMap2;
                                        try {
                                            fileInputStream2 = new FileInputStream(b2);
                                        } catch (Exception unused3) {
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                        try {
                                            fileInputStream2.read(new byte[fileInputStream2.available()]);
                                            try {
                                                fileInputStream2.close();
                                            } catch (Throwable unused4) {
                                            }
                                        } catch (Exception unused5) {
                                            fileInputStream3 = fileInputStream2;
                                            if (fileInputStream3 != null) {
                                                try {
                                                    fileInputStream3.close();
                                                } catch (Throwable unused6) {
                                                }
                                            }
                                            fileInputStream2 = fileInputStream3;
                                            if (fileInputStream2 != null) {
                                            }
                                            hashMap = canRead;
                                            synchronized (b) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileInputStream3 = fileInputStream2;
                                            if (fileInputStream3 != null) {
                                                try {
                                                    fileInputStream3.close();
                                                } catch (Throwable unused7) {
                                                }
                                            }
                                            throw th;
                                        }
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                            canRead = canRead;
                                        }
                                        hashMap = canRead;
                                        synchronized (b) {
                                        }
                                    } catch (Exception unused8) {
                                        HashMap hashMap3 = hashMap;
                                        fileInputStream4 = fileInputStream;
                                        canRead = hashMap3;
                                        if (fileInputStream4 != null) {
                                            fileInputStream4.close();
                                            canRead = canRead;
                                        }
                                        hashMap = canRead;
                                        synchronized (b) {
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Throwable unused9) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (XmlPullParserException unused10) {
                                    canRead = 0;
                                } catch (Exception unused11) {
                                    canRead = null;
                                }
                            }
                        } catch (Throwable unused12) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                    }
                }
                synchronized (b) {
                    if (aVar != null) {
                        aVar.a(hashMap);
                    } else {
                        aVar = this.f27a.get(b2);
                        if (aVar == null) {
                            aVar = new a(b2, i, hashMap);
                            this.f27a.put(b2, aVar);
                        }
                    }
                }
                return aVar;
            }
        }
        return (b) invokeLI.objValue;
    }
}
