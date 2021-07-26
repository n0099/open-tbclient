package d.a.o0.a.s0;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.s0.c;
import d.a.o0.a.v2.q;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f47730c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.a2.e f47731d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f47732e;

    /* renamed from: d.a.o0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0893a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f47733a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f47734b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47735c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f47736d;

        public C0893a(a aVar, l lVar, String[] strArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lVar, strArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47736d = aVar;
            this.f47733a = lVar;
            this.f47734b = strArr;
            this.f47735c = str;
        }

        @Override // d.a.o0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, list) == null) {
                if (linkedHashMap == null || linkedHashMap.size() == 0) {
                    this.f47736d.B(this.f47733a, Arrays.asList(this.f47734b), this.f47735c);
                    return;
                }
                this.f47736d.C(this.f47733a, this.f47735c, linkedHashMap, list);
                if (a0.f44085b) {
                    Iterator<String> it = linkedHashMap.keySet().iterator();
                    while (it.hasNext()) {
                        Log.i("GetFormIdAction", "querySubscribeInfo unallowedTemplateId=" + it.next());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f47738f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f47739g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47740h;

        public b(a aVar, String str, String[] strArr, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, strArr, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47740h = aVar;
            this.f47737e = str;
            this.f47738f = strArr;
            this.f47739g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                if (this.f47740h.w()) {
                    Cursor query = this.f47740h.f47730c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f47737e}, null);
                    if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                        do {
                            hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                        } while (query.moveToNext());
                        d.a.o0.t.d.d(query);
                    }
                }
                LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
                ArrayList arrayList = new ArrayList();
                for (String str : this.f47738f) {
                    Integer num = (Integer) hashMap.get(str);
                    if (num == null) {
                        linkedHashMap.put(str, Boolean.FALSE);
                    } else if (num.intValue() != 1) {
                        linkedHashMap.put(str, Boolean.TRUE);
                    } else {
                        arrayList.add(str);
                    }
                }
                this.f47739g.a(linkedHashMap, arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47741a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f47742b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f47743c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f47744d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47745e;

        /* renamed from: d.a.o0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0894a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f47746e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f47747f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f47748g;

            public RunnableC0894a(c cVar, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47748g = cVar;
                this.f47746e = list;
                this.f47747f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ContentResolver contentResolver = this.f47748g.f47745e.f47730c.getContentResolver();
                    for (d.a.o0.a.s0.d dVar : this.f47746e) {
                        String str = dVar.f47794a;
                        Boolean bool = (Boolean) this.f47748g.f47742b.get(str);
                        if (bool != null && !bool.booleanValue()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", this.f47748g.f47743c.f47774a);
                            contentValues.put("templateId", str);
                            contentValues.put("result", (Integer) 0);
                            contentValues.put("title", dVar.f47795b);
                            contentValues.put("tips", this.f47747f);
                            contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                        }
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47749e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f47750f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f47751g;

            public b(c cVar, String str, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47751g = cVar;
                this.f47749e = str;
                this.f47750f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f47751g;
                    cVar.f47745e.D(cVar.f47743c, this.f47749e, cVar.f47741a, this.f47750f, cVar.f47744d);
                }
            }
        }

        public c(a aVar, String str, LinkedHashMap linkedHashMap, l lVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, linkedHashMap, lVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47745e = aVar;
            this.f47741a = str;
            this.f47742b = linkedHashMap;
            this.f47743c = lVar;
            this.f47744d = list;
        }

        @Override // d.a.o0.a.s0.a.j
        public void a(@Nullable String str, List<d.a.o0.a.s0.d> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, list, z) == null) {
                if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                    q.j(new RunnableC0894a(this, list, str), "createFormDataBase");
                    if (z && this.f47743c.f47778e) {
                        this.f47745e.x(this.f47743c, this.f47741a, str, list, this.f47744d);
                        return;
                    } else {
                        q0.X(new b(this, str, list));
                        return;
                    }
                }
                this.f47745e.f47732e.handleSchemeDispatchCallback(this.f47741a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f47752a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f47753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47754c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47755d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47757f;

        public d(a aVar, l lVar, List list, String str, String str2, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lVar, list, str, str2, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47757f = aVar;
            this.f47752a = lVar;
            this.f47753b = list;
            this.f47754c = str;
            this.f47755d = str2;
            this.f47756e = list2;
        }

        @Override // d.a.o0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<d.a.o0.a.s0.d> list) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, list)) == null) {
                boolean z = i2 == -1;
                if (a0.f44085b) {
                    Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
                }
                if (z && list.size() == 0) {
                    return false;
                }
                this.f47757f.z(z ? "permit_click" : "reject_click", this.f47752a.f47777d, this.f47753b, list);
                if (z) {
                    this.f47757f.x(this.f47752a, this.f47754c, this.f47755d, list, this.f47756e);
                    return true;
                }
                if (this.f47757f.w()) {
                    this.f47757f.F(this.f47752a.f47774a, list, this.f47755d, false);
                }
                this.f47757f.f47732e.handleSchemeDispatchCallback(this.f47754c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47758e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47759f;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47759f = aVar;
            this.f47758e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f47759f.f47732e.handleSchemeDispatchCallback(this.f47758e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f47761f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47762g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47763h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f47764i;
        public final /* synthetic */ List j;
        public final /* synthetic */ a k;

        public f(a aVar, boolean z, l lVar, String str, String str2, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), lVar, str, str2, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = aVar;
            this.f47760e = z;
            this.f47761f = lVar;
            this.f47762g = str;
            this.f47763h = str2;
            this.f47764i = list;
            this.j = list2;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f47760e && this.k.w()) {
                        d.a.o0.a.j2.k.M("success", 12, "component");
                    }
                    this.k.E(this.f47761f, this.f47762g, this.f47763h, this.f47764i, this.j);
                    return;
                }
                if (!this.f47760e && !this.k.w()) {
                    d.a.o0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 12, "component");
                }
                this.k.f47732e.handleSchemeDispatchCallback(this.f47762g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f47767g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47768h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f47769i;

        public g(a aVar, List list, String str, boolean z, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list, str, Boolean.valueOf(z), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47769i = aVar;
            this.f47765e = list;
            this.f47766f = str;
            this.f47767g = z;
            this.f47768h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ContentResolver contentResolver = this.f47769i.f47730c.getContentResolver();
                for (d.a.o0.a.s0.d dVar : this.f47765e) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", dVar.f47795b);
                    contentValues.put("tips", this.f47766f);
                    contentValues.put("result", Integer.valueOf(this.f47767g ? 1 : -1));
                    contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f47768h, dVar.f47794a});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.a.o0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47770a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47771b;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47771b = aVar;
            this.f47770a = str;
        }

        @Override // d.a.o0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f47771b.f47732e.handleSchemeDispatchCallback(this.f47770a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (d.a.o0.a.x1.c.f48892c.c()) {
                    return;
                }
                if (d.a.o0.a.c1.a.a0().e(this.f47771b.f47730c)) {
                    d.a.o0.a.x1.c.f48892c.e();
                } else {
                    d.a.o0.a.x1.c.f48892c.f();
                }
            }
        }

        @Override // d.a.o0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f47771b.f47732e.handleSchemeDispatchCallback(this.f47770a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.o0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47772a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47773b;

        public i(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47773b = aVar;
            this.f47772a = str;
        }

        @Override // d.a.o0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f47773b.f47732e.handleSchemeDispatchCallback(this.f47772a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (d.a.o0.a.c1.a.a0().e(this.f47773b.f47730c)) {
                    d.a.o0.a.x1.c.f48892c.e();
                } else {
                    d.a.o0.a.x1.c.f48892c.f();
                }
            }
        }

        @Override // d.a.o0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f47773b.f47732e.handleSchemeDispatchCallback(this.f47772a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a(@Nullable String str, @Nullable List<d.a.o0.a.s0.d> list, boolean z);
    }

    /* loaded from: classes7.dex */
    public interface k {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes7.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f47774a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f47775b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f47776c;

        /* renamed from: d  reason: collision with root package name */
        public String f47777d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f47778e;

        public l(@NonNull String str, @NonNull String str2) {
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
            this.f47774a = str;
            this.f47775b = str2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getFormId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (!w()) {
                this.f47732e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
                return;
            }
            d.a.o0.a.c1.a.R().c(str, new h(this, str2));
        }
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, list, str) == null) {
            d.a.o0.a.c1.a.R().d(lVar.f47774a, list, lVar.f47775b, lVar.f47776c, new i(this, str));
        }
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, str, linkedHashMap, list) == null) {
            d.a.o0.a.c1.a.R().a(lVar.f47774a, linkedHashMap.keySet(), new c(this, str, linkedHashMap, lVar, list));
        }
    }

    public final void D(@NonNull l lVar, String str, String str2, List<d.a.o0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, lVar, str, str2, list, list2) == null) {
            d.a.o0.a.s0.c.a((Activity) this.f47730c, this.f47731d, str, list, new d(this, lVar, list, str2, str, list2), new e(this, str2)).show();
            z("show", lVar.f47777d, list, list);
        }
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.o0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, lVar, str, str2, list, list2) == null) {
            F(lVar.f47774a, list, str2, true);
            for (d.a.o0.a.s0.d dVar : list) {
                list2.add(dVar.f47794a);
            }
            B(lVar, list2, str);
        }
    }

    public final void F(String str, List<d.a.o0.a.s0.d> list, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, list, str2, Boolean.valueOf(z)}) == null) {
            q.f().execute(new g(this, list, str2, z, str));
        }
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (unitedSchemeEntity == null) {
                if (a0.f44085b) {
                    Log.w("GetFormIdAction", "entity is null");
                }
                return false;
            } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
                this.f47730c = context;
                this.f47731d = eVar;
                this.f47732e = callbackHandler;
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.length() != 0) {
                    String optString = a2.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        if (a0.f44085b) {
                            Log.w("GetFormIdAction", "cb is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String D = eVar.D();
                    if (TextUtils.isEmpty(D)) {
                        if (a0.f44085b) {
                            Log.w("GetFormIdAction", "appKey is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                        return false;
                    }
                    if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a2.optString("reportType"))) {
                        JSONArray optJSONArray = a2.optJSONArray("templateId");
                        String optString2 = a2.optString("templateId");
                        String optString3 = a2.optString("subscribeId");
                        if (TextUtils.isEmpty(optString3)) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "subscribeId is empty");
                            return false;
                        }
                        l lVar = new l(D, optString3);
                        lVar.f47777d = a2.optString("invokeFrom", "form");
                        lVar.f47778e = a2.optBoolean("skipSubscribeAuthorize");
                        lVar.f47776c = optJSONArray == null;
                        if (lVar.f47776c) {
                            if (TextUtils.isEmpty(optString2)) {
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "templateId is empty");
                                return false;
                            }
                            strArr = new String[]{optString2};
                        } else {
                            int length = optJSONArray.length();
                            if (length >= 1 && length <= 3) {
                                String[] strArr2 = new String[length];
                                for (int i2 = 0; i2 < length; i2++) {
                                    strArr2[i2] = optJSONArray.optString(i2);
                                }
                                strArr = strArr2;
                            } else {
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                                return false;
                            }
                        }
                        y(D, strArr, new C0893a(this, lVar, strArr, optString));
                    } else {
                        A(D, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                if (a0.f44085b) {
                    Log.d("GetFormIdAction", "runtime parameter error");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONArray v(List<d.a.o0.a.s0.d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (d.a.o0.a.s0.d dVar : list) {
                    jSONArray.put(dVar.f47795b);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? d.a.o0.a.a2.d.g().r().j().e(d.a.o0.a.c1.a.b()) : invokeV.booleanValue;
    }

    public final void x(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.o0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, lVar, str, str2, list, list2) == null) {
            boolean w = w();
            if (w()) {
                E(lVar, str, str2, list, list2);
                return;
            }
            if (!w) {
                d.a.o0.a.j2.k.M("show", 12, "component");
            }
            d.a.o0.a.a2.d.g().r().j().f(d.a.o0.a.g1.f.V().getActivity(), null, new f(this, w, lVar, str, str2, list, list2));
        }
    }

    @AnyThread
    public final void y(String str, String[] strArr, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, strArr, kVar) == null) {
            q.j(new b(this, str, strArr, kVar), "querySubscribeInfo");
        }
    }

    public final void z(String str, String str2, List<d.a.o0.a.s0.d> list, List<d.a.o0.a.s0.d> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, list, list2) == null) {
            d.a.o0.a.j2.p.e eVar = new d.a.o0.a.j2.p.e();
            eVar.f46321a = "swan";
            eVar.f46322b = str;
            eVar.f46327g = str2;
            if (list2 != null) {
                eVar.f46325e = String.valueOf(list2.size());
            }
            eVar.a("appkey", this.f47731d.getAppId());
            eVar.a("tpl", v(list));
            eVar.a("selected_tpl", v(list2));
            if (a0.f44085b) {
                Log.d("GetFormIdAction", "event: " + eVar.f());
            }
            d.a.o0.a.j2.k.v("1311", "92", eVar);
        }
    }
}
