package com.bytedance.sdk.openadsdk.n.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.h;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f68183b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Map<String, a>> f68184a;

    /* renamed from: c  reason: collision with root package name */
    public final d f68185c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f68186d;

    /* renamed from: e  reason: collision with root package name */
    public volatile SQLiteStatement f68187e;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68184a = new SparseArray<>(2);
        this.f68186d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new h(5, "video_proxy_db"));
        this.f68185c = new d(context.getApplicationContext());
        this.f68184a.put(0, new ConcurrentHashMap());
        this.f68184a.put(1, new ConcurrentHashMap());
    }

    private String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            if (i2 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i2 << 1);
            sb.append("?");
            for (int i3 = 1; i3 < i2; i3++) {
                sb.append(",?");
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f68183b == null) {
                synchronized (c.class) {
                    if (f68183b == null) {
                        f68183b = new c(context);
                    }
                }
            }
            return f68183b;
        }
        return (c) invokeL.objValue;
    }

    public a a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Map<String, a> map = this.f68184a.get(i2);
            a aVar = map == null ? null : map.get(str);
            if (aVar != null) {
                return aVar;
            }
            try {
                Cursor query = this.f68185c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i2)}, null, null, null, "1");
                if (query != null) {
                    if (query.getCount() > 0 && query.moveToNext()) {
                        aVar = new a(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex("mime")), query.getInt(query.getColumnIndex(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH)), i2, query.getString(query.getColumnIndex("extra")));
                    }
                    query.close();
                }
                if (aVar != null && map != null) {
                    map.put(str, aVar);
                }
                return aVar;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (a) invokeLI.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        Map<String, a> map = this.f68184a.get(aVar.f68171d);
        if (map != null) {
            map.put(aVar.f68168a, aVar);
        }
        this.f68186d.execute(new Runnable(this, aVar) { // from class: com.bytedance.sdk.openadsdk.n.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f68188a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f68189b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68189b = this;
                this.f68188a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (this.f68189b.f68187e != null) {
                            this.f68189b.f68187e.clearBindings();
                        } else {
                            this.f68189b.f68187e = this.f68189b.f68185c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        this.f68189b.f68187e.bindString(1, this.f68188a.f68168a);
                        this.f68189b.f68187e.bindString(2, this.f68188a.f68169b);
                        this.f68189b.f68187e.bindLong(3, this.f68188a.f68170c);
                        this.f68189b.f68187e.bindLong(4, this.f68188a.f68171d);
                        this.f68189b.f68187e.bindString(5, this.f68188a.f68172e);
                        this.f68189b.f68187e.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public void a(Collection<String> collection, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, collection, i2) == null) || collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        int i3 = -1;
        Map<String, a> map = this.f68184a.get(i2);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i3++;
            strArr[i3] = str;
        }
        strArr[i3 + 1] = String.valueOf(i2);
        try {
            SQLiteDatabase writableDatabase = this.f68185c.getWritableDatabase();
            writableDatabase.delete("video_http_header_t", "key IN(" + b(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            Map<String, a> map = this.f68184a.get(i2);
            if (map != null) {
                map.clear();
            }
            this.f68186d.execute(new Runnable(this, i2) { // from class: com.bytedance.sdk.openadsdk.n.b.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f68190a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f68191b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68191b = this;
                    this.f68190a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f68191b.f68185c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(this.f68190a)});
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }
}
