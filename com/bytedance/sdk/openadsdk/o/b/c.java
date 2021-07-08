package com.bytedance.sdk.openadsdk.o.b;

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
import com.bytedance.sdk.component.e.h;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f31669b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Map<String, a>> f31670a;

    /* renamed from: c  reason: collision with root package name */
    public final d f31671c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f31672d;

    /* renamed from: e  reason: collision with root package name */
    public volatile SQLiteStatement f31673e;

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
        this.f31670a = new SparseArray<>(2);
        this.f31672d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new h(5, "video_proxy_db"));
        this.f31671c = new d(context.getApplicationContext());
        this.f31670a.put(0, new ConcurrentHashMap());
        this.f31670a.put(1, new ConcurrentHashMap());
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
            if (f31669b == null) {
                synchronized (c.class) {
                    if (f31669b == null) {
                        f31669b = new c(context);
                    }
                }
            }
            return f31669b;
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
            Map<String, a> map = this.f31670a.get(i2);
            a aVar = map == null ? null : map.get(str);
            if (aVar != null) {
                return aVar;
            }
            try {
                Cursor query = this.f31671c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i2)}, null, null, null, "1");
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
        Map<String, a> map = this.f31670a.get(aVar.f31667d);
        if (map != null) {
            map.put(aVar.f31664a, aVar);
        }
        this.f31672d.execute(new Runnable(this, aVar) { // from class: com.bytedance.sdk.openadsdk.o.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f31674a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f31675b;

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
                this.f31675b = this;
                this.f31674a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (this.f31675b.f31673e != null) {
                            this.f31675b.f31673e.clearBindings();
                        } else {
                            this.f31675b.f31673e = this.f31675b.f31671c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        this.f31675b.f31673e.bindString(1, this.f31674a.f31664a);
                        this.f31675b.f31673e.bindString(2, this.f31674a.f31665b);
                        this.f31675b.f31673e.bindLong(3, this.f31674a.f31666c);
                        this.f31675b.f31673e.bindLong(4, this.f31674a.f31667d);
                        this.f31675b.f31673e.bindString(5, this.f31674a.f31668e);
                        this.f31675b.f31673e.executeInsert();
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
        Map<String, a> map = this.f31670a.get(i2);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i3++;
            strArr[i3] = str;
        }
        strArr[i3 + 1] = String.valueOf(i2);
        try {
            SQLiteDatabase writableDatabase = this.f31671c.getWritableDatabase();
            writableDatabase.delete("video_http_header_t", "key IN(" + b(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            Map<String, a> map = this.f31670a.get(i2);
            if (map != null) {
                map.clear();
            }
            this.f31672d.execute(new Runnable(this, i2) { // from class: com.bytedance.sdk.openadsdk.o.b.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f31676a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f31677b;

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
                    this.f31677b = this;
                    this.f31676a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f31677b.f31671c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(this.f31676a)});
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }
}
