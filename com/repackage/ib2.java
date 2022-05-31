package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes6.dex */
public class ib2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jb2 a;
    public p62 b;
    public mb2 c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ tb2 e;
        public final /* synthetic */ ib2 f;

        /* renamed from: com.repackage.ib2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0442a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ a b;

            public RunnableC0442a(a aVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    fb2 v = rb2.v(this.a, "mkdir:", this.b.d);
                    a aVar = this.b;
                    if (rb2.a(v, aVar.e, hashMap, aVar.f.b)) {
                        tb2 tb2Var = this.b.e;
                        tb2Var.errMsg = "mkdir:" + this.a.b;
                        a aVar2 = this.b;
                        rb2.b(aVar2.e, aVar2.d);
                    }
                }
            }
        }

        public a(ib2 ib2Var, String str, Boolean bool, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, bool, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ib2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new RunnableC0442a(this, this.f.a.o(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ tb2 f;
        public final /* synthetic */ ib2 g;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ b b;

            public a(b bVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "srcPath");
                    hashMap.put(Integer.valueOf(this.b.d), "destPath");
                    fb2 v = rb2.v(this.a, "copyFile:", this.b.e);
                    b bVar = this.b;
                    if (rb2.a(v, bVar.f, hashMap, bVar.g.b)) {
                        b bVar2 = this.b;
                        rb2.b(bVar2.f, bVar2.e);
                    }
                }
            }
        }

        public b(ib2 ib2Var, String str, String str2, int i, int i2, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ib2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.c(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ tb2 h;
        public final /* synthetic */ ib2 i;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ c b;

            public a(c cVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    fb2 v = rb2.v(this.a, "appendFile:", this.b.d);
                    c cVar = this.b;
                    if (rb2.a(v, cVar.h, hashMap, cVar.i.b)) {
                        c cVar2 = this.b;
                        rb2.b(cVar2.h, cVar2.d);
                    }
                }
            }
        }

        public c(ib2 ib2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = ib2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gb2 b = this.i.a.b(this.a, TextUtils.isEmpty(this.b) ? this.c : this.b, rb2.I("encoding", this.d), false);
                if (!TextUtils.isEmpty(this.e)) {
                    b.b = this.e;
                    b.a = -2;
                    rb2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        b.b = "fail encoding must be a string";
                        b.a = -2;
                        rb2.d(this.i.b, b.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ tb2 d;
        public final /* synthetic */ ib2 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ d b;

            public a(d dVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    fb2 v = rb2.v(this.a, "access:", this.b.c);
                    d dVar = this.b;
                    if (rb2.a(v, dVar.d, hashMap, dVar.e.b)) {
                        d dVar2 = this.b;
                        rb2.b(dVar2.d, dVar2.c);
                    }
                }
            }
        }

        public d(ib2 ib2Var, String str, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ib2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.a(this.a, false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ tb2 d;
        public final /* synthetic */ ib2 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ e b;

            public a(e eVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    fb2 v = rb2.v(this.a, "stat:", this.b.c);
                    e eVar = this.b;
                    if (rb2.a(v, eVar.d, hashMap, eVar.e.b)) {
                        zb2 zb2Var = new zb2();
                        gb2 gb2Var = this.a;
                        zb2Var.stats = gb2Var.d;
                        zb2Var.errMsg = gb2Var.b;
                        rb2.b(zb2Var, this.b.c);
                    }
                }
            }
        }

        public e(ib2 ib2Var, String str, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ib2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.y(this.a, false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ tb2 d;
        public final /* synthetic */ ib2 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ f b;

            public a(f fVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    fb2 v = rb2.v(this.a, "getFileInfo:", this.b.c);
                    f fVar = this.b;
                    if (rb2.a(v, fVar.d, hashMap, fVar.e.b)) {
                        ub2 ub2Var = new ub2();
                        ub2Var.errMsg = "getFileInfo:" + this.a.b;
                        gb2 gb2Var = this.a;
                        ub2Var.digest = gb2Var.g;
                        ub2Var.size = (int) gb2Var.e;
                        rb2.b(ub2Var, this.b.c);
                    }
                }
            }
        }

        public f(ib2 ib2Var, String str, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ib2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.e(this.a)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ tb2 b;
        public final /* synthetic */ ib2 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ g b;

            public a(g gVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    fb2 v = rb2.v(this.a, "getSavedFileList:", this.b.a);
                    g gVar = this.b;
                    if (rb2.a(v, gVar.b, null, gVar.c.b)) {
                        vb2 vb2Var = new vb2();
                        List<hb2> list = this.a.f;
                        int size = list == null ? 0 : list.size();
                        vb2Var.fileList = size == 0 ? new hb2[0] : (hb2[]) this.a.f.toArray(new hb2[size]);
                        g gVar2 = this.b;
                        vb2Var.errMsg = gVar2.b.errMsg;
                        rb2.b(vb2Var, gVar2.a);
                    }
                }
            }
        }

        public g(ib2 ib2Var, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ib2Var;
            this.a = map;
            this.b = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.runOnJSThread(new a(this, this.c.a.i()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ tb2 d;
        public final /* synthetic */ ib2 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ h b;

            public a(h hVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    fb2 v = rb2.v(this.a, "removeSavedFile:", this.b.c);
                    h hVar = this.b;
                    if (rb2.a(v, hVar.d, hashMap, hVar.e.b)) {
                        h hVar2 = this.b;
                        rb2.b(hVar2.d, hVar2.c);
                    }
                }
            }
        }

        public h(ib2 ib2Var, String str, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ib2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.t(this.a)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ tb2 h;
        public final /* synthetic */ ib2 i;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ i b;

            public a(i iVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    fb2 v = rb2.v(this.a, "writeFile:", this.b.d);
                    i iVar = this.b;
                    if (rb2.a(v, iVar.h, hashMap, iVar.i.b)) {
                        tb2 tb2Var = this.b.h;
                        tb2Var.errMsg = "writeFile:" + this.a.b;
                        i iVar2 = this.b;
                        rb2.b(iVar2.h, iVar2.d);
                    }
                }
            }
        }

        public i(ib2 ib2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = ib2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gb2 C = this.i.a.C(false, this.a, TextUtils.isEmpty(this.b) ? this.c : this.b, rb2.I("encoding", this.d));
                if (!TextUtils.isEmpty(this.e)) {
                    C.b = this.e;
                    C.a = -2;
                    rb2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        C.b = "fail encoding must be a string";
                        C.a = -2;
                        rb2.d(this.i.b, C.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ tb2 d;
        public final /* synthetic */ ib2 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ j b;

            public a(j jVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    fb2 v = rb2.v(this.a, "unlink:", this.b.c);
                    j jVar = this.b;
                    if (rb2.a(v, jVar.d, hashMap, jVar.e.b)) {
                        tb2 tb2Var = this.b.d;
                        tb2Var.errMsg = "unlink:" + this.a.b;
                        j jVar2 = this.b;
                        rb2.b(jVar2.d, jVar2.c);
                    }
                }
            }
        }

        public j(ib2 ib2Var, String str, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ib2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.z(this.a, false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ tb2 f;
        public final /* synthetic */ ib2 g;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ k b;

            public a(k kVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = kVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "targetPath");
                    fb2 v = rb2.v(this.a, "unzip:", this.b.e);
                    k kVar = this.b;
                    if (rb2.a(v, kVar.f, hashMap, kVar.g.b)) {
                        tb2 tb2Var = this.b.f;
                        tb2Var.errMsg = "unzip:" + this.a.b;
                        k kVar2 = this.b;
                        rb2.b(kVar2.f, kVar2.e);
                    }
                }
            }
        }

        public k(ib2 ib2Var, String str, String str2, int i, int i2, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ib2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.A(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ tb2 f;
        public final /* synthetic */ ib2 g;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ l b;

            public a(l lVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    fb2 v = rb2.v(this.a, "saveFile:", this.b.e);
                    l lVar = this.b;
                    if (rb2.a(v, lVar.f, hashMap, lVar.g.b)) {
                        yb2 yb2Var = new yb2();
                        List<String> list = this.a.c;
                        yb2Var.savedFilePath = list != null ? list.get(0) : null;
                        yb2Var.errMsg = this.a.b;
                        rb2.b(yb2Var, this.b.e);
                    }
                }
            }
        }

        public l(ib2 ib2Var, String str, String str2, int i, int i2, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ib2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.x(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ tb2 d;
        public final /* synthetic */ ib2 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ m b;

            public a(m mVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "dirPath");
                    fb2 v = rb2.v(this.a, "readdir:", this.b.c);
                    m mVar = this.b;
                    if (rb2.a(v, mVar.d, hashMap, mVar.e.b)) {
                        wb2 wb2Var = new wb2();
                        List<String> list = this.a.c;
                        int size = list == null ? 0 : list.size();
                        wb2Var.files = size == 0 ? new String[0] : (String[]) this.a.c.toArray(new String[size]);
                        wb2Var.errMsg = this.a.b;
                        rb2.b(wb2Var, this.b.c);
                    }
                }
            }
        }

        public m(ib2 ib2Var, String str, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ib2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.s(this.a, false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ tb2 e;
        public final /* synthetic */ ib2 f;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ n b;

            public a(n nVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    fb2 v = rb2.v(this.a, "rmdir:", this.b.d);
                    n nVar = this.b;
                    if (rb2.a(v, nVar.e, hashMap, nVar.f.b)) {
                        n nVar2 = this.b;
                        rb2.b(nVar2.e, nVar2.d);
                    }
                }
            }
        }

        public n(ib2 ib2Var, String str, Boolean bool, int i, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, bool, Integer.valueOf(i), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ib2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new a(this, this.f.a.v(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ tb2 f;
        public final /* synthetic */ ib2 g;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ o b;

            public a(o oVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = oVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    fb2 v = rb2.v(this.a, "readFile:", this.b.e);
                    o oVar = this.b;
                    if (rb2.a(v, oVar.f, hashMap, oVar.g.b)) {
                        if (TextUtils.isEmpty(this.b.b)) {
                            sb2 sb2Var = new sb2();
                            gb2 gb2Var = this.a;
                            if (gb2Var.h == null) {
                                gb2Var.h = new byte[0];
                            }
                            byte[] bArr = this.a.h;
                            sb2Var.data = new JsArrayBuffer(bArr, bArr.length);
                            sb2Var.errMsg = this.a.b;
                            rb2.b(sb2Var, this.b.e);
                            return;
                        }
                        List<String> list = this.a.c;
                        String str = list != null ? list.get(0) : null;
                        xb2 xb2Var = new xb2();
                        xb2Var.data = str;
                        xb2Var.errMsg = this.a.b;
                        rb2.b(xb2Var, this.b.e);
                    }
                }
            }
        }

        public o(ib2 ib2Var, String str, String str2, int i, int i2, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ib2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gb2 q = this.g.a.q(this.a, this.b, false);
                int i = this.c;
                if (i != 7 && i != 12) {
                    q.b = "fail encoding must be a string";
                    q.a = -2;
                    rb2.d(this.g.b, q.b);
                }
                this.g.b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ tb2 f;
        public final /* synthetic */ ib2 g;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb2 a;
            public final /* synthetic */ p b;

            public a(p pVar, gb2 gb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, gb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = pVar;
                this.a = gb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "oldPath");
                    hashMap.put(Integer.valueOf(this.b.d), "newPath");
                    fb2 v = rb2.v(this.a, "rename:", this.b.e);
                    p pVar = this.b;
                    if (rb2.a(v, pVar.f, hashMap, pVar.g.b)) {
                        p pVar2 = this.b;
                        rb2.b(pVar2.f, pVar2.e);
                    }
                }
            }
        }

        public p(ib2 ib2Var, String str, String str2, int i, int i2, Map map, tb2 tb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, tb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ib2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = tb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.u(this.a, this.b, false)));
            }
        }
    }

    public ib2(p62 p62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p62Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = p62Var;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = rb2.O("path", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("path", J);
            this.c.h(new d(this, I, O, J, tb2Var), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            rb2.d0(this.b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = rb2.O("encoding", jsObject);
            int O2 = rb2.O("filePath", jsObject);
            int O3 = rb2.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : rb2.w(O3);
            byte[] r = rb2.r(jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("data", J);
            String I2 = rb2.I("filePath", J);
            this.c.h(new c(this, I2, I, r, J, w, O, O2, tb2Var), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            rb2.d0(this.b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        k73 pb2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hz2 a0 = hz2.a0();
            if (a0 != null) {
                pb2Var = a0.g0();
            } else {
                pb2Var = new pb2();
            }
            this.a = new jb2(AppRuntime.getAppContext(), uk2.U().z(), pb2Var);
            this.c = mb2.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = rb2.O("srcPath", jsObject);
            int O2 = rb2.O("destPath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("srcPath", J);
            String I2 = rb2.I("destPath", J);
            this.c.h(new b(this, I, I2, O, O2, J, tb2Var), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str, str2);
            rb2.d0(this.b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = rb2.O("filePath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("filePath", J);
            this.c.h(new f(this, I, O, J, tb2Var), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        tb2 tb2Var;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = rb2.J(this.a, jsObject, (tb2Var = new tb2()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.c.h(new g(this, J, tb2Var), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = rb2.O("dirPath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("dirPath", J);
            this.c.h(new a(this, I, (Boolean) rb2.H("recursive", J, Boolean.FALSE), O, J, tb2Var), "aigamesmkdir:", I);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            mkdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = rb2.O("filePath", jsObject);
            int O2 = rb2.O("encoding", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("encoding", J);
            String I2 = rb2.I("filePath", J);
            this.c.h(new o(this, I2, I, O2, O, J, tb2Var), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (rb2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                gb2 q = this.a.q(str, str2, true);
                rb2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = rb2.O("dirPath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("dirPath", J);
            this.c.h(new m(this, I, O, J, tb2Var), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (rb2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                gb2 s = this.a.s(str, true);
                rb2.d0(this.b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = rb2.O("filePath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.c.h(new h(this, rb2.I("filePath", J), O, J, tb2Var), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = rb2.O("oldPath", jsObject);
            int O2 = rb2.O("newPath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("oldPath", J);
            String I2 = rb2.I("newPath", J);
            this.c.h(new p(this, I, I2, O, O2, J, tb2Var), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str, str2);
            rb2.d0(this.b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = rb2.O("dirPath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("dirPath", J);
            this.c.h(new n(this, I, (Boolean) rb2.H("recursive", J, Boolean.FALSE), O, J, tb2Var), "aigamesrmdir:", I);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            rmdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = rb2.O("tempFilePath", jsObject);
            int O2 = rb2.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("tempFilePath", J);
            String I2 = rb2.I("filePath", J);
            this.c.h(new l(this, I, I2, O, i2, J, tb2Var), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, eb2.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = rb2.O("path", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("path", J);
            this.c.h(new e(this, I, O, J, tb2Var), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public nb2 statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (rb2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                gb2 y = this.a.y(str, true);
                rb2.d0(this.b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.d;
            }
            return null;
        }
        return (nb2) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = rb2.O("filePath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("filePath", J);
            this.c.h(new j(this, I, O, J, tb2Var), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            rb2.d0(this.b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = rb2.O("zipFilePath", jsObject);
            int O2 = rb2.O("targetPath", jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("zipFilePath", J);
            String I2 = rb2.I("targetPath", J);
            this.c.h(new k(this, I, I2, O, O2, J, tb2Var), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && rb2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = rb2.O("filePath", jsObject);
            String w = rb2.w(rb2.O("data", jsObject));
            int O2 = rb2.O("encoding", jsObject);
            byte[] r = rb2.r(jsObject);
            tb2 tb2Var = new tb2();
            Map<String, Object> J = rb2.J(this.a, jsObject, tb2Var, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = rb2.I("data", J);
            String I2 = rb2.I("filePath", J);
            this.c.h(new i(this, I2, I, r, J, w, O2, O, tb2Var), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            rb2.d0(this.b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            rb2.d0(this.b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            rb2.d0(this.b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (rb2.T(this.a, this.b, null, null)) {
                this.c.k(str, str2);
                gb2 x = this.a.x(str, str2, true);
                rb2.d0(this.b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            appendFileSync(str, str2, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            writeFileSync(str, str2, "");
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, jsArrayBuffer, str2) == null) {
            appendFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && rb2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            rb2.d0(this.b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (rb2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                gb2 q = this.a.q(str, null, true);
                rb2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.h == null) {
                    q.h = new byte[0];
                }
                byte[] bArr = q.h;
                return new JsArrayBuffer(bArr, bArr.length);
            }
            return null;
        }
        return (JsArrayBuffer) invokeL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jsArrayBuffer) == null) {
            appendFileSync(str, jsArrayBuffer, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, str, jsArrayBuffer, str2) == null) {
            writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }
}
