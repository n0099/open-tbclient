package d.a.q0.a.s0;

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
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.s0.c;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f50528c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.a2.e f50529d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f50530e;

    /* renamed from: d.a.q0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0935a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f50531a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f50532b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50533c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f50534d;

        public C0935a(a aVar, l lVar, String[] strArr, String str) {
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
            this.f50534d = aVar;
            this.f50531a = lVar;
            this.f50532b = strArr;
            this.f50533c = str;
        }

        @Override // d.a.q0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, list) == null) {
                if (linkedHashMap == null || linkedHashMap.size() == 0) {
                    this.f50534d.B(this.f50531a, Arrays.asList(this.f50532b), this.f50533c);
                    return;
                }
                this.f50534d.C(this.f50531a, this.f50533c, linkedHashMap, list);
                if (a0.f46883b) {
                    Iterator<String> it = linkedHashMap.keySet().iterator();
                    while (it.hasNext()) {
                        Log.i("GetFormIdAction", "querySubscribeInfo unallowedTemplateId=" + it.next());
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50535e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f50536f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f50537g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f50538h;

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
            this.f50538h = aVar;
            this.f50535e = str;
            this.f50536f = strArr;
            this.f50537g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                if (this.f50538h.w()) {
                    Cursor query = this.f50538h.f50528c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f50535e}, null);
                    if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                        do {
                            hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                        } while (query.moveToNext());
                        d.a.q0.t.d.d(query);
                    }
                }
                LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
                ArrayList arrayList = new ArrayList();
                for (String str : this.f50536f) {
                    Integer num = (Integer) hashMap.get(str);
                    if (num == null) {
                        linkedHashMap.put(str, Boolean.FALSE);
                    } else if (num.intValue() != 1) {
                        linkedHashMap.put(str, Boolean.TRUE);
                    } else {
                        arrayList.add(str);
                    }
                }
                this.f50537g.a(linkedHashMap, arrayList);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50539a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f50540b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f50541c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f50542d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50543e;

        /* renamed from: d.a.q0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0936a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f50544e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f50545f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f50546g;

            public RunnableC0936a(c cVar, List list, String str) {
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
                this.f50546g = cVar;
                this.f50544e = list;
                this.f50545f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ContentResolver contentResolver = this.f50546g.f50543e.f50528c.getContentResolver();
                    for (d.a.q0.a.s0.d dVar : this.f50544e) {
                        String str = dVar.f50592a;
                        Boolean bool = (Boolean) this.f50546g.f50540b.get(str);
                        if (bool != null && !bool.booleanValue()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", this.f50546g.f50541c.f50572a);
                            contentValues.put("templateId", str);
                            contentValues.put("result", (Integer) 0);
                            contentValues.put("title", dVar.f50593b);
                            contentValues.put("tips", this.f50545f);
                            contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                        }
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f50547e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f50548f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f50549g;

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
                this.f50549g = cVar;
                this.f50547e = str;
                this.f50548f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f50549g;
                    cVar.f50543e.D(cVar.f50541c, this.f50547e, cVar.f50539a, this.f50548f, cVar.f50542d);
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
            this.f50543e = aVar;
            this.f50539a = str;
            this.f50540b = linkedHashMap;
            this.f50541c = lVar;
            this.f50542d = list;
        }

        @Override // d.a.q0.a.s0.a.j
        public void a(@Nullable String str, List<d.a.q0.a.s0.d> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, list, z) == null) {
                if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                    q.j(new RunnableC0936a(this, list, str), "createFormDataBase");
                    if (z && this.f50541c.f50576e) {
                        this.f50543e.x(this.f50541c, this.f50539a, str, list, this.f50542d);
                        return;
                    } else {
                        q0.X(new b(this, str, list));
                        return;
                    }
                }
                this.f50543e.f50530e.handleSchemeDispatchCallback(this.f50539a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f50550a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f50551b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50552c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f50553d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f50554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50555f;

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
            this.f50555f = aVar;
            this.f50550a = lVar;
            this.f50551b = list;
            this.f50552c = str;
            this.f50553d = str2;
            this.f50554e = list2;
        }

        @Override // d.a.q0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<d.a.q0.a.s0.d> list) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, list)) == null) {
                boolean z = i2 == -1;
                if (a0.f46883b) {
                    Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
                }
                if (z && list.size() == 0) {
                    return false;
                }
                this.f50555f.z(z ? "permit_click" : "reject_click", this.f50550a.f50575d, this.f50551b, list);
                if (z) {
                    this.f50555f.x(this.f50550a, this.f50552c, this.f50553d, list, this.f50554e);
                    return true;
                }
                if (this.f50555f.w()) {
                    this.f50555f.F(this.f50550a.f50572a, list, this.f50553d, false);
                }
                this.f50555f.f50530e.handleSchemeDispatchCallback(this.f50552c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50556e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50557f;

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
            this.f50557f = aVar;
            this.f50556e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f50557f.f50530e.handleSchemeDispatchCallback(this.f50556e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50558e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f50559f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50560g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50561h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f50562i;
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
            this.f50558e = z;
            this.f50559f = lVar;
            this.f50560g = str;
            this.f50561h = str2;
            this.f50562i = list;
            this.j = list2;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f50558e && this.k.w()) {
                        d.a.q0.a.j2.k.M("success", 12, "component");
                    }
                    this.k.E(this.f50559f, this.f50560g, this.f50561h, this.f50562i, this.j);
                    return;
                }
                if (!this.f50558e && !this.k.w()) {
                    d.a.q0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 12, "component");
                }
                this.k.f50530e.handleSchemeDispatchCallback(this.f50560g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f50563e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50564f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f50565g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50566h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f50567i;

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
            this.f50567i = aVar;
            this.f50563e = list;
            this.f50564f = str;
            this.f50565g = z;
            this.f50566h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ContentResolver contentResolver = this.f50567i.f50528c.getContentResolver();
                for (d.a.q0.a.s0.d dVar : this.f50563e) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", dVar.f50593b);
                    contentValues.put("tips", this.f50564f);
                    contentValues.put("result", Integer.valueOf(this.f50565g ? 1 : -1));
                    contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f50566h, dVar.f50592a});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.a.q0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50568a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f50569b;

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
            this.f50569b = aVar;
            this.f50568a = str;
        }

        @Override // d.a.q0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f50569b.f50530e.handleSchemeDispatchCallback(this.f50568a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (d.a.q0.a.x1.c.f51690c.c()) {
                    return;
                }
                if (d.a.q0.a.c1.a.a0().e(this.f50569b.f50528c)) {
                    d.a.q0.a.x1.c.f51690c.e();
                } else {
                    d.a.q0.a.x1.c.f51690c.f();
                }
            }
        }

        @Override // d.a.q0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f50569b.f50530e.handleSchemeDispatchCallback(this.f50568a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.a.q0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50570a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f50571b;

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
            this.f50571b = aVar;
            this.f50570a = str;
        }

        @Override // d.a.q0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f50571b.f50530e.handleSchemeDispatchCallback(this.f50570a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (d.a.q0.a.c1.a.a0().e(this.f50571b.f50528c)) {
                    d.a.q0.a.x1.c.f51690c.e();
                } else {
                    d.a.q0.a.x1.c.f51690c.f();
                }
            }
        }

        @Override // d.a.q0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f50571b.f50530e.handleSchemeDispatchCallback(this.f50570a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a(@Nullable String str, @Nullable List<d.a.q0.a.s0.d> list, boolean z);
    }

    /* loaded from: classes8.dex */
    public interface k {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes8.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f50572a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f50573b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50574c;

        /* renamed from: d  reason: collision with root package name */
        public String f50575d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50576e;

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
            this.f50572a = str;
            this.f50573b = str2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.q0.a.c2.e eVar) {
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
                this.f50530e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
                return;
            }
            d.a.q0.a.c1.a.R().c(str, new h(this, str2));
        }
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, list, str) == null) {
            d.a.q0.a.c1.a.R().d(lVar.f50572a, list, lVar.f50573b, lVar.f50574c, new i(this, str));
        }
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, str, linkedHashMap, list) == null) {
            d.a.q0.a.c1.a.R().a(lVar.f50572a, linkedHashMap.keySet(), new c(this, str, linkedHashMap, lVar, list));
        }
    }

    public final void D(@NonNull l lVar, String str, String str2, List<d.a.q0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, lVar, str, str2, list, list2) == null) {
            d.a.q0.a.s0.c.a((Activity) this.f50528c, this.f50529d, str, list, new d(this, lVar, list, str2, str, list2), new e(this, str2)).show();
            z("show", lVar.f50575d, list, list);
        }
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.q0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, lVar, str, str2, list, list2) == null) {
            F(lVar.f50572a, list, str2, true);
            for (d.a.q0.a.s0.d dVar : list) {
                list2.add(dVar.f50592a);
            }
            B(lVar, list2, str);
        }
    }

    public final void F(String str, List<d.a.q0.a.s0.d> list, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, list, str2, Boolean.valueOf(z)}) == null) {
            q.f().execute(new g(this, list, str2, z, str));
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (unitedSchemeEntity == null) {
                if (a0.f46883b) {
                    Log.w("GetFormIdAction", "entity is null");
                }
                return false;
            } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
                this.f50528c = context;
                this.f50529d = eVar;
                this.f50530e = callbackHandler;
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.length() != 0) {
                    String optString = a2.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        if (a0.f46883b) {
                            Log.w("GetFormIdAction", "cb is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String D = eVar.D();
                    if (TextUtils.isEmpty(D)) {
                        if (a0.f46883b) {
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
                        lVar.f50575d = a2.optString("invokeFrom", "form");
                        lVar.f50576e = a2.optBoolean("skipSubscribeAuthorize");
                        lVar.f50574c = optJSONArray == null;
                        if (lVar.f50574c) {
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
                        y(D, strArr, new C0935a(this, lVar, strArr, optString));
                    } else {
                        A(D, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                if (a0.f46883b) {
                    Log.d("GetFormIdAction", "runtime parameter error");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONArray v(List<d.a.q0.a.s0.d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (d.a.q0.a.s0.d dVar : list) {
                    jSONArray.put(dVar.f50593b);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? d.a.q0.a.a2.d.g().r().j().e(d.a.q0.a.c1.a.b()) : invokeV.booleanValue;
    }

    public final void x(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.q0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, lVar, str, str2, list, list2) == null) {
            boolean w = w();
            if (w()) {
                E(lVar, str, str2, list, list2);
                return;
            }
            if (!w) {
                d.a.q0.a.j2.k.M("show", 12, "component");
            }
            d.a.q0.a.a2.d.g().r().j().f(d.a.q0.a.g1.f.V().getActivity(), null, new f(this, w, lVar, str, str2, list, list2));
        }
    }

    @AnyThread
    public final void y(String str, String[] strArr, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, strArr, kVar) == null) {
            q.j(new b(this, str, strArr, kVar), "querySubscribeInfo");
        }
    }

    public final void z(String str, String str2, List<d.a.q0.a.s0.d> list, List<d.a.q0.a.s0.d> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, list, list2) == null) {
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49119a = "swan";
            eVar.f49120b = str;
            eVar.f49125g = str2;
            if (list2 != null) {
                eVar.f49123e = String.valueOf(list2.size());
            }
            eVar.a("appkey", this.f50529d.getAppId());
            eVar.a("tpl", v(list));
            eVar.a("selected_tpl", v(list2));
            if (a0.f46883b) {
                Log.d("GetFormIdAction", "event: " + eVar.f());
            }
            d.a.q0.a.j2.k.v("1311", "92", eVar);
        }
    }
}
