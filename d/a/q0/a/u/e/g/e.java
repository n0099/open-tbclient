package d.a.q0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.q0.a.v2.k;
import d.a.q0.a.v2.q0;
import d.a.q0.a.z1.b.b.d;
import d.a.q0.a.z1.b.b.e;
import d.a.q0.a.z1.b.b.j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.z1.b.b.i f50872d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f50874f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f50875g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f50876h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f50877i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        /* renamed from: d.a.q0.a.u.e.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnCancelListenerC0966a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f50878e;

            public DialogInterface$OnCancelListenerC0966a(a aVar) {
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
                this.f50878e = aVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    a aVar = this.f50878e;
                    aVar.l.d(aVar.k, new d.a.q0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f50879e;

            public b(a aVar) {
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
                this.f50879e = aVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    a aVar = this.f50879e;
                    aVar.l.d(aVar.k, new d.a.q0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f50880e;

            public c(a aVar) {
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
                this.f50880e = aVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    dialogInterface.dismiss();
                    j jVar = (j) dialogInterface;
                    String format = String.format("%02d:%02d", Integer.valueOf(jVar.f()), Integer.valueOf(jVar.g()));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("value", format);
                        if (d.a.q0.a.u.c.d.f50740c) {
                            Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject.toString());
                        }
                        this.f50880e.l.d(this.f50880e.k, new d.a.q0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.q0.a.u.c.d.f50740c) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }

        public a(e eVar, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f50873e = str;
            this.f50874f = date;
            this.f50875g = date2;
            this.f50876h = date3;
            this.f50877i = z;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j.a aVar = new j.a(this.l.i());
                if (!TextUtils.isEmpty(this.f50873e)) {
                    aVar.n(this.f50873e);
                }
                aVar.p(this.f50874f);
                aVar.m(this.f50875g);
                aVar.o(this.f50876h);
                aVar.l(this.f50877i);
                aVar.c(true);
                aVar.g(this.j);
                aVar.h(d.a.q0.a.h.aiapps_confirm, new c(this));
                aVar.d(d.a.q0.a.h.aiapps_cancel, new b(this));
                aVar.f(new DialogInterface$OnCancelListenerC0966a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50881e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f50882f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f50883g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f50884h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f50885i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        /* loaded from: classes8.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f50886e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50886e = bVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    b bVar = this.f50886e;
                    bVar.l.d(bVar.k, new d.a.q0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* renamed from: d.a.q0.a.u.e.g.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnClickListenerC0967b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f50887e;

            public DialogInterface$OnClickListenerC0967b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50887e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    b bVar = this.f50887e;
                    bVar.l.d(bVar.k, new d.a.q0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f50888e;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50888e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    dialogInterface.dismiss();
                    if (dialogInterface instanceof d.a.q0.a.z1.b.b.d) {
                        String h2 = ((d.a.q0.a.z1.b.b.d) dialogInterface).h();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("value", h2);
                            if (d.a.q0.a.u.c.d.f50740c) {
                                Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject.toString());
                            }
                            this.f50888e.l.d(this.f50888e.k, new d.a.q0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (d.a.q0.a.u.c.d.f50740c) {
                                e2.printStackTrace();
                            }
                            b bVar = this.f50888e;
                            bVar.l.d(bVar.k, new d.a.q0.a.u.h.b(202));
                        }
                    }
                }
            }
        }

        public b(e eVar, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f50881e = str;
            this.f50882f = date;
            this.f50883g = date2;
            this.f50884h = date3;
            this.f50885i = z;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a aVar = new d.a(this.l.i());
                if (!TextUtils.isEmpty(this.f50881e)) {
                    aVar.n(this.f50881e);
                }
                aVar.p(this.f50882f);
                aVar.m(this.f50883g);
                aVar.o(this.f50884h);
                aVar.l(this.f50885i);
                aVar.c(true);
                aVar.g(this.j);
                aVar.h(d.a.q0.a.h.aiapps_confirm, new c(this));
                aVar.d(d.a.q0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0967b(this));
                aVar.f(new a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f50890f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50891g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f50892h;

        public c(e eVar, int i2, JSONArray jSONArray, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), jSONArray, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50892h = eVar;
            this.f50889e = i2;
            this.f50890f = jSONArray;
            this.f50891g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50892h.f50872d == null) {
                return;
            }
            ((d.a.q0.a.z1.b.b.e) this.f50892h.f50872d).k(this.f50889e, this.f50890f, this.f50891g);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f50893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f50894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f50895g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50896h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f50897i;
        public final /* synthetic */ String j;
        public final /* synthetic */ e k;

        /* loaded from: classes8.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f50898e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50898e = dVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    d dVar = this.f50898e;
                    dVar.k.E(dialogInterface, dVar.f50895g, dVar.f50897i);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f50899e;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50899e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    d dVar = this.f50899e;
                    dVar.k.E(dialogInterface, dVar.f50895g, dVar.f50897i);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f50900e;

            public c(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50900e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    dialogInterface.dismiss();
                    this.f50900e.k.f50872d = null;
                    try {
                        JSONArray f2 = ((d.a.q0.a.z1.b.b.e) dialogInterface).f();
                        JSONObject jSONObject = new JSONObject();
                        if (f2 != null && f2.length() > 0) {
                            if (this.f50900e.f50895g) {
                                jSONObject.put("value", f2.optInt(0));
                            } else {
                                jSONObject.put("value", f2);
                                jSONObject.put("type", "confirm");
                            }
                        }
                        this.f50900e.k.d(this.f50900e.f50897i, new d.a.q0.a.u.h.b(0, jSONObject));
                        if (d.a.q0.a.u.c.d.f50740c) {
                            Log.i("Api-Base", "handleOpenMultiPicker: output params = " + jSONObject.toString());
                        }
                    } catch (JSONException e2) {
                        if (d.a.q0.a.u.c.d.f50740c) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }

        /* renamed from: d.a.q0.a.u.e.g.e$d$d  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0968d implements BdMultiPicker.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f50901a;

            public C0968d(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50901a = dVar;
            }

            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bdMultiPicker, jSONObject) == null) {
                    if (d.a.q0.a.u.c.d.f50740c) {
                        Log.i("Api-Base", "onMultiSelectedChanged: params=" + this.f50901a.f50896h);
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                        jSONObject2.put("type", "columnChange");
                        this.f50901a.k.d(this.f50901a.f50897i, new d.a.q0.a.u.h.b(0, jSONObject2));
                    } catch (JSONException e2) {
                        if (d.a.q0.a.u.c.d.f50740c) {
                            e2.printStackTrace();
                        }
                        d dVar = this.f50901a;
                        dVar.k.d(dVar.f50897i, new d.a.q0.a.u.h.b(202));
                    }
                }
            }
        }

        public d(e eVar, JSONArray jSONArray, JSONArray jSONArray2, boolean z, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONArray, jSONArray2, Boolean.valueOf(z), jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f50893e = jSONArray;
            this.f50894f = jSONArray2;
            this.f50895g = z;
            this.f50896h = jSONObject;
            this.f50897i = str;
            this.j = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.a aVar = new e.a(this.k.i());
                e eVar = this.k;
                aVar.l(this.f50893e);
                aVar.m(this.f50894f);
                aVar.o(this.f50895g);
                aVar.n(new C0968d(this));
                aVar.c(true);
                aVar.g(this.j);
                aVar.h(d.a.q0.a.h.aiapps_confirm, new c(this));
                aVar.d(d.a.q0.a.h.aiapps_cancel, new b(this));
                aVar.f(new a(this));
                eVar.f50872d = aVar.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.q0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new d.a.q0.a.u.h.b(202);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("showDatePickerView", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.q0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            return y((JSONObject) b2.second, false);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new d.a.q0.a.u.h.b(202);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("showDatePickerView", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.q0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                return new d.a.q0.a.u.h.b(202);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(optJSONArray);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(optInt);
                try {
                    jSONObject.put("array", jSONArray);
                    jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, jSONArray2);
                    return y(jSONObject, true);
                } catch (JSONException unused) {
                    return new d.a.q0.a.u.h.b(1001);
                }
            }
            return new d.a.q0.a.u.h.b(202);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final Date C(String str, String[] strArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, strArr, str2)) == null) {
            Date d2 = !TextUtils.isEmpty(str) ? k.d(str, strArr) : null;
            return (d2 != null || TextUtils.isEmpty(str2)) ? d2 : k.d(str2, strArr);
        }
        return (Date) invokeLLL.objValue;
    }

    public final Date D(String str) {
        InterceptResult invokeL;
        String[] split;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Date();
            }
            Date date2 = null;
            if (str.contains(":") && (split = str.split(":")) != null && split.length == 2) {
                try {
                    date = new Date();
                } catch (NumberFormatException e2) {
                    e = e2;
                }
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    if (parseInt >= 0 && parseInt < 24) {
                        date.setHours(parseInt);
                    }
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt2 >= 0 && parseInt2 < 60) {
                        date.setMinutes(parseInt2);
                    }
                    return date;
                } catch (NumberFormatException e3) {
                    e = e3;
                    date2 = date;
                    if (d.a.q0.a.u.c.d.f50740c) {
                        e.printStackTrace();
                        return date2;
                    }
                    return date2;
                }
            }
            return null;
        }
        return (Date) invokeL.objValue;
    }

    public final void E(DialogInterface dialogInterface, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{dialogInterface, Boolean.valueOf(z), str}) == null) {
            dialogInterface.dismiss();
            this.f50872d = null;
            if (z) {
                d(str, new d.a.q0.a.u.h.b(0));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                d(str, new d.a.q0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    e2.printStackTrace();
                }
                d(str, new d.a.q0.a.u.h.b(202));
            }
        }
    }

    public d.a.q0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new d.a.q0.a.u.h.b(202);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("showDatePickerView", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.q0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                d.a.q0.a.e0.d.b("Api-Base", "paramsJson is null");
                return new d.a.q0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("mode");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.q0.a.u.h.b(202);
            }
            char c2 = 65535;
            int hashCode = optString.hashCode();
            if (hashCode != 3076014) {
                if (hashCode == 3560141 && optString.equals("time")) {
                    c2 = 0;
                }
            } else if (optString.equals("date")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return new d.a.q0.a.u.h.b(202);
                }
                return x(jSONObject);
            }
            return z(jSONObject);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new d.a.q0.a.u.h.b(202);
            }
            if (this.f50872d == null) {
                return new d.a.q0.a.u.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int optInt2 = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    d.a.q0.a.e0.d.b("Api-Base", "callback is null");
                    return new d.a.q0.a.u.h.b(1001, "callback is null");
                }
                if (optJSONArray != null) {
                    q0.b0(new c(this, optInt, optJSONArray, optInt2));
                    d(optString, new d.a.q0.a.u.h.b(0, jSONObject));
                }
                return new d.a.q0.a.u.h.b(0);
            } catch (JSONException e2) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    e2.printStackTrace();
                }
                return new d.a.q0.a.u.h.b(202);
            }
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.q0.a.u.h.b x(JSONObject jSONObject) {
        InterceptResult invokeL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("fields");
            String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
            Date C = C(optString, strArr, "1900-01-01");
            Date C2 = C(optString2, strArr, "2099-12-31");
            if (C != null && C2 != null && !C2.before(C)) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    d.a.q0.a.e0.d.b("Api-Base", "callback is null");
                    return new d.a.q0.a.u.h.b(1001, "callback is null");
                }
                Date C3 = C(optString3, strArr, null);
                if (C3 == null) {
                    C3 = new Date();
                }
                if (C3.before(C)) {
                    date = C;
                } else {
                    date = C3.after(C2) ? C2 : C3;
                }
                q0.b0(new b(this, optString5, C, C2, date, optBoolean, optString4, optString6));
                return new d.a.q0.a.u.h.b(0);
            }
            return new d.a.q0.a.u.h.b(202);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.q0.a.u.h.b y(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, z)) == null) {
            if (this.f50872d != null) {
                return new d.a.q0.a.u.h.b(1001);
            }
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.i("Api-Base", "handleOpenMultiPicker: input params=" + jSONObject);
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            String str2 = null;
            if (jSONObject != null) {
                jSONArray = jSONObject.optJSONArray("array");
                jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                str2 = jSONObject.optString("cb");
                str = jSONObject.optString("title");
            } else {
                str = "";
            }
            String str3 = str;
            String str4 = str2;
            JSONArray jSONArray3 = jSONArray2;
            JSONArray jSONArray4 = jSONArray;
            if (TextUtils.isEmpty(str4)) {
                d.a.q0.a.e0.d.b("Api-Base", "callback is null");
                return new d.a.q0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new d(this, jSONArray4, jSONArray3, z, jSONObject, str4, str3));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeLZ.objValue;
    }

    public final d.a.q0.a.u.h.b z(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("fields");
            if (TextUtils.isEmpty(optString)) {
                optString = "00:00";
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "23:59";
            }
            Date D = D(optString);
            Date D2 = D(optString2);
            Date D3 = D(optString3);
            if (D3 == null) {
                D3 = D(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
            }
            Date date = D3;
            if (D != null && D2 != null && !D2.before(D) && date != null) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    d.a.q0.a.e0.d.b("Api-Base", "callback is null");
                    return new d.a.q0.a.u.h.b(1001, "callback is null");
                }
                q0.b0(new a(this, optString5, D, D2, date, optBoolean, optString4, optString6));
                return new d.a.q0.a.u.h.b(0);
            }
            return new d.a.q0.a.u.h.b(202);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }
}
