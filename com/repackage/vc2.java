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
/* loaded from: classes7.dex */
public class vc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wc2 a;
    public c82 b;
    public zc2 c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ gd2 e;
        public final /* synthetic */ vc2 f;

        /* renamed from: com.repackage.vc2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0535a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ a b;

            public RunnableC0535a(a aVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    sc2 v = ed2.v(this.a, "mkdir:", this.b.d);
                    a aVar = this.b;
                    if (ed2.a(v, aVar.e, hashMap, aVar.f.b)) {
                        gd2 gd2Var = this.b.e;
                        gd2Var.errMsg = "mkdir:" + this.a.b;
                        a aVar2 = this.b;
                        ed2.b(aVar2.e, aVar2.d);
                    }
                }
            }
        }

        public a(vc2 vc2Var, String str, Boolean bool, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, bool, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vc2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new RunnableC0535a(this, this.f.a.o(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ gd2 f;
        public final /* synthetic */ vc2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ b b;

            public a(b bVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "srcPath");
                    hashMap.put(Integer.valueOf(this.b.d), "destPath");
                    sc2 v = ed2.v(this.a, "copyFile:", this.b.e);
                    b bVar = this.b;
                    if (ed2.a(v, bVar.f, hashMap, bVar.g.b)) {
                        b bVar2 = this.b;
                        ed2.b(bVar2.f, bVar2.e);
                    }
                }
            }
        }

        public b(vc2 vc2Var, String str, String str2, int i, int i2, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vc2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.c(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public final /* synthetic */ gd2 h;
        public final /* synthetic */ vc2 i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ c b;

            public a(c cVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    sc2 v = ed2.v(this.a, "appendFile:", this.b.d);
                    c cVar = this.b;
                    if (ed2.a(v, cVar.h, hashMap, cVar.i.b)) {
                        c cVar2 = this.b;
                        ed2.b(cVar2.h, cVar2.d);
                    }
                }
            }
        }

        public c(vc2 vc2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = vc2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tc2 b = this.i.a.b(this.a, TextUtils.isEmpty(this.b) ? this.c : this.b, ed2.I("encoding", this.d), false);
                if (!TextUtils.isEmpty(this.e)) {
                    b.b = this.e;
                    b.a = -2;
                    ed2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        b.b = "fail encoding must be a string";
                        b.a = -2;
                        ed2.d(this.i.b, b.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ gd2 d;
        public final /* synthetic */ vc2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ d b;

            public a(d dVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    sc2 v = ed2.v(this.a, "access:", this.b.c);
                    d dVar = this.b;
                    if (ed2.a(v, dVar.d, hashMap, dVar.e.b)) {
                        d dVar2 = this.b;
                        ed2.b(dVar2.d, dVar2.c);
                    }
                }
            }
        }

        public d(vc2 vc2Var, String str, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vc2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.a(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ gd2 d;
        public final /* synthetic */ vc2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ e b;

            public a(e eVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    sc2 v = ed2.v(this.a, "stat:", this.b.c);
                    e eVar = this.b;
                    if (ed2.a(v, eVar.d, hashMap, eVar.e.b)) {
                        md2 md2Var = new md2();
                        tc2 tc2Var = this.a;
                        md2Var.stats = tc2Var.d;
                        md2Var.errMsg = tc2Var.b;
                        ed2.b(md2Var, this.b.c);
                    }
                }
            }
        }

        public e(vc2 vc2Var, String str, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vc2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.y(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ gd2 d;
        public final /* synthetic */ vc2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ f b;

            public a(f fVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    sc2 v = ed2.v(this.a, "getFileInfo:", this.b.c);
                    f fVar = this.b;
                    if (ed2.a(v, fVar.d, hashMap, fVar.e.b)) {
                        hd2 hd2Var = new hd2();
                        hd2Var.errMsg = "getFileInfo:" + this.a.b;
                        tc2 tc2Var = this.a;
                        hd2Var.digest = tc2Var.g;
                        hd2Var.size = (int) tc2Var.e;
                        ed2.b(hd2Var, this.b.c);
                    }
                }
            }
        }

        public f(vc2 vc2Var, String str, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vc2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.e(this.a)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ gd2 b;
        public final /* synthetic */ vc2 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ g b;

            public a(g gVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    sc2 v = ed2.v(this.a, "getSavedFileList:", this.b.a);
                    g gVar = this.b;
                    if (ed2.a(v, gVar.b, null, gVar.c.b)) {
                        id2 id2Var = new id2();
                        List<uc2> list = this.a.f;
                        int size = list == null ? 0 : list.size();
                        id2Var.fileList = size == 0 ? new uc2[0] : (uc2[]) this.a.f.toArray(new uc2[size]);
                        g gVar2 = this.b;
                        id2Var.errMsg = gVar2.b.errMsg;
                        ed2.b(id2Var, gVar2.a);
                    }
                }
            }
        }

        public g(vc2 vc2Var, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vc2Var;
            this.a = map;
            this.b = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.runOnJSThread(new a(this, this.c.a.i()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ gd2 d;
        public final /* synthetic */ vc2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ h b;

            public a(h hVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    sc2 v = ed2.v(this.a, "removeSavedFile:", this.b.c);
                    h hVar = this.b;
                    if (ed2.a(v, hVar.d, hashMap, hVar.e.b)) {
                        h hVar2 = this.b;
                        ed2.b(hVar2.d, hVar2.c);
                    }
                }
            }
        }

        public h(vc2 vc2Var, String str, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vc2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.t(this.a)));
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public final /* synthetic */ gd2 h;
        public final /* synthetic */ vc2 i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ i b;

            public a(i iVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    sc2 v = ed2.v(this.a, "writeFile:", this.b.d);
                    i iVar = this.b;
                    if (ed2.a(v, iVar.h, hashMap, iVar.i.b)) {
                        gd2 gd2Var = this.b.h;
                        gd2Var.errMsg = "writeFile:" + this.a.b;
                        i iVar2 = this.b;
                        ed2.b(iVar2.h, iVar2.d);
                    }
                }
            }
        }

        public i(vc2 vc2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = vc2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tc2 C = this.i.a.C(false, this.a, TextUtils.isEmpty(this.b) ? this.c : this.b, ed2.I("encoding", this.d));
                if (!TextUtils.isEmpty(this.e)) {
                    C.b = this.e;
                    C.a = -2;
                    ed2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        C.b = "fail encoding must be a string";
                        C.a = -2;
                        ed2.d(this.i.b, C.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ gd2 d;
        public final /* synthetic */ vc2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ j b;

            public a(j jVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    sc2 v = ed2.v(this.a, "unlink:", this.b.c);
                    j jVar = this.b;
                    if (ed2.a(v, jVar.d, hashMap, jVar.e.b)) {
                        gd2 gd2Var = this.b.d;
                        gd2Var.errMsg = "unlink:" + this.a.b;
                        j jVar2 = this.b;
                        ed2.b(jVar2.d, jVar2.c);
                    }
                }
            }
        }

        public j(vc2 vc2Var, String str, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vc2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.z(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ gd2 f;
        public final /* synthetic */ vc2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ k b;

            public a(k kVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "targetPath");
                    sc2 v = ed2.v(this.a, "unzip:", this.b.e);
                    k kVar = this.b;
                    if (ed2.a(v, kVar.f, hashMap, kVar.g.b)) {
                        gd2 gd2Var = this.b.f;
                        gd2Var.errMsg = "unzip:" + this.a.b;
                        k kVar2 = this.b;
                        ed2.b(kVar2.f, kVar2.e);
                    }
                }
            }
        }

        public k(vc2 vc2Var, String str, String str2, int i, int i2, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vc2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.A(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ gd2 f;
        public final /* synthetic */ vc2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ l b;

            public a(l lVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    sc2 v = ed2.v(this.a, "saveFile:", this.b.e);
                    l lVar = this.b;
                    if (ed2.a(v, lVar.f, hashMap, lVar.g.b)) {
                        ld2 ld2Var = new ld2();
                        List<String> list = this.a.c;
                        ld2Var.savedFilePath = list != null ? list.get(0) : null;
                        ld2Var.errMsg = this.a.b;
                        ed2.b(ld2Var, this.b.e);
                    }
                }
            }
        }

        public l(vc2 vc2Var, String str, String str2, int i, int i2, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vc2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.x(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ gd2 d;
        public final /* synthetic */ vc2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ m b;

            public a(m mVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "dirPath");
                    sc2 v = ed2.v(this.a, "readdir:", this.b.c);
                    m mVar = this.b;
                    if (ed2.a(v, mVar.d, hashMap, mVar.e.b)) {
                        jd2 jd2Var = new jd2();
                        List<String> list = this.a.c;
                        int size = list == null ? 0 : list.size();
                        jd2Var.files = size == 0 ? new String[0] : (String[]) this.a.c.toArray(new String[size]);
                        jd2Var.errMsg = this.a.b;
                        ed2.b(jd2Var, this.b.c);
                    }
                }
            }
        }

        public m(vc2 vc2Var, String str, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vc2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.s(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ gd2 e;
        public final /* synthetic */ vc2 f;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ n b;

            public a(n nVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    sc2 v = ed2.v(this.a, "rmdir:", this.b.d);
                    n nVar = this.b;
                    if (ed2.a(v, nVar.e, hashMap, nVar.f.b)) {
                        n nVar2 = this.b;
                        ed2.b(nVar2.e, nVar2.d);
                    }
                }
            }
        }

        public n(vc2 vc2Var, String str, Boolean bool, int i, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, bool, Integer.valueOf(i), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vc2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new a(this, this.f.a.v(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ gd2 f;
        public final /* synthetic */ vc2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ o b;

            public a(o oVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    sc2 v = ed2.v(this.a, "readFile:", this.b.e);
                    o oVar = this.b;
                    if (ed2.a(v, oVar.f, hashMap, oVar.g.b)) {
                        if (TextUtils.isEmpty(this.b.b)) {
                            fd2 fd2Var = new fd2();
                            tc2 tc2Var = this.a;
                            if (tc2Var.h == null) {
                                tc2Var.h = new byte[0];
                            }
                            byte[] bArr = this.a.h;
                            fd2Var.data = new JsArrayBuffer(bArr, bArr.length);
                            fd2Var.errMsg = this.a.b;
                            ed2.b(fd2Var, this.b.e);
                            return;
                        }
                        List<String> list = this.a.c;
                        String str = list != null ? list.get(0) : null;
                        kd2 kd2Var = new kd2();
                        kd2Var.data = str;
                        kd2Var.errMsg = this.a.b;
                        ed2.b(kd2Var, this.b.e);
                    }
                }
            }
        }

        public o(vc2 vc2Var, String str, String str2, int i, int i2, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vc2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tc2 q = this.g.a.q(this.a, this.b, false);
                int i = this.c;
                if (i != 7 && i != 12) {
                    q.b = "fail encoding must be a string";
                    q.a = -2;
                    ed2.d(this.g.b, q.b);
                }
                this.g.b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ gd2 f;
        public final /* synthetic */ vc2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tc2 a;
            public final /* synthetic */ p b;

            public a(p pVar, tc2 tc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, tc2Var};
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
                this.a = tc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "oldPath");
                    hashMap.put(Integer.valueOf(this.b.d), "newPath");
                    sc2 v = ed2.v(this.a, "rename:", this.b.e);
                    p pVar = this.b;
                    if (ed2.a(v, pVar.f, hashMap, pVar.g.b)) {
                        p pVar2 = this.b;
                        ed2.b(pVar2.f, pVar2.e);
                    }
                }
            }
        }

        public p(vc2 vc2Var, String str, String str2, int i, int i2, Map map, gd2 gd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, gd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vc2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = gd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.u(this.a, this.b, false)));
            }
        }
    }

    public vc2(c82 c82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = c82Var;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = ed2.O("path", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("path", J);
            this.c.h(new d(this, I, O, J, gd2Var), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            ed2.d0(this.b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = ed2.O("encoding", jsObject);
            int O2 = ed2.O("filePath", jsObject);
            int O3 = ed2.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : ed2.w(O3);
            byte[] r = ed2.r(jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("data", J);
            String I2 = ed2.I("filePath", J);
            this.c.h(new c(this, I2, I, r, J, w, O, O2, gd2Var), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            ed2.d0(this.b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        x83 cd2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            u03 a0 = u03.a0();
            if (a0 != null) {
                cd2Var = a0.g0();
            } else {
                cd2Var = new cd2();
            }
            this.a = new wc2(AppRuntime.getAppContext(), hm2.U().z(), cd2Var);
            this.c = zc2.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = ed2.O("srcPath", jsObject);
            int O2 = ed2.O("destPath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("srcPath", J);
            String I2 = ed2.I("destPath", J);
            this.c.h(new b(this, I, I2, O, O2, J, gd2Var), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str, str2);
            ed2.d0(this.b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = ed2.O("filePath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("filePath", J);
            this.c.h(new f(this, I, O, J, gd2Var), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        gd2 gd2Var;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = ed2.J(this.a, jsObject, (gd2Var = new gd2()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.c.h(new g(this, J, gd2Var), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = ed2.O("dirPath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("dirPath", J);
            this.c.h(new a(this, I, (Boolean) ed2.H("recursive", J, Boolean.FALSE), O, J, gd2Var), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = ed2.O("filePath", jsObject);
            int O2 = ed2.O("encoding", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("encoding", J);
            String I2 = ed2.I("filePath", J);
            this.c.h(new o(this, I2, I, O2, O, J, gd2Var), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (ed2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                tc2 q = this.a.q(str, str2, true);
                ed2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = ed2.O("dirPath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("dirPath", J);
            this.c.h(new m(this, I, O, J, gd2Var), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (ed2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                tc2 s = this.a.s(str, true);
                ed2.d0(this.b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
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
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = ed2.O("filePath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.c.h(new h(this, ed2.I("filePath", J), O, J, gd2Var), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = ed2.O("oldPath", jsObject);
            int O2 = ed2.O("newPath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("oldPath", J);
            String I2 = ed2.I("newPath", J);
            this.c.h(new p(this, I, I2, O, O2, J, gd2Var), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str, str2);
            ed2.d0(this.b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = ed2.O("dirPath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("dirPath", J);
            this.c.h(new n(this, I, (Boolean) ed2.H("recursive", J, Boolean.FALSE), O, J, gd2Var), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = ed2.O("tempFilePath", jsObject);
            int O2 = ed2.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("tempFilePath", J);
            String I2 = ed2.I("filePath", J);
            this.c.h(new l(this, I, I2, O, i2, J, gd2Var), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, rc2.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = ed2.O("path", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("path", J);
            this.c.h(new e(this, I, O, J, gd2Var), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public ad2 statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (ed2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                tc2 y = this.a.y(str, true);
                ed2.d0(this.b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.d;
            }
            return null;
        }
        return (ad2) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = ed2.O("filePath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("filePath", J);
            this.c.h(new j(this, I, O, J, gd2Var), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            ed2.d0(this.b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = ed2.O("zipFilePath", jsObject);
            int O2 = ed2.O("targetPath", jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("zipFilePath", J);
            String I2 = ed2.I("targetPath", J);
            this.c.h(new k(this, I, I2, O, O2, J, gd2Var), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && ed2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = ed2.O("filePath", jsObject);
            String w = ed2.w(ed2.O("data", jsObject));
            int O2 = ed2.O("encoding", jsObject);
            byte[] r = ed2.r(jsObject);
            gd2 gd2Var = new gd2();
            Map<String, Object> J = ed2.J(this.a, jsObject, gd2Var, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = ed2.I("data", J);
            String I2 = ed2.I("filePath", J);
            this.c.h(new i(this, I2, I, r, J, w, O2, O, gd2Var), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            ed2.d0(this.b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            ed2.d0(this.b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            ed2.d0(this.b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (ed2.T(this.a, this.b, null, null)) {
                this.c.k(str, str2);
                tc2 x = this.a.x(str, str2, true);
                ed2.d0(this.b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && ed2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            ed2.d0(this.b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (ed2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                tc2 q = this.a.q(str, null, true);
                ed2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
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
