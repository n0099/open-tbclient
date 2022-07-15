package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class cj {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cj a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f882a;

    /* renamed from: a  reason: collision with other field name */
    public ci f883a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f884a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, ch> f885a;

    /* renamed from: a  reason: collision with other field name */
    public ThreadPoolExecutor f886a;

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public ch f887a;

        /* renamed from: a  reason: collision with other field name */
        public a f888a;

        /* renamed from: a  reason: collision with other field name */
        public String f889a;

        /* renamed from: a  reason: collision with other field name */
        public WeakReference<Context> f890a;

        /* renamed from: a  reason: collision with other field name */
        public Random f891a;
        public String b;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f887a = null;
            this.f891a = new Random();
            this.a = 0;
            this.f889a = str;
        }

        public SQLiteDatabase a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f887a.getWritableDatabase() : (SQLiteDatabase) invokeV.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m1176a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m1177a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f889a : (String) invokeV.objValue;
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                a aVar = this.f888a;
                if (aVar != null) {
                    aVar.a(context, m1176a());
                }
                b(context);
            }
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, context, obj) == null) {
                cj.a(context).a(this);
            }
        }

        public void a(ch chVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, chVar, context) == null) {
                this.f887a = chVar;
                this.b = chVar.a();
                this.f890a = new WeakReference<>(context);
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                this.f888a = aVar;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m1178a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f887a == null || TextUtils.isEmpty(this.b) || this.f890a == null : invokeV.booleanValue;
        }

        public void b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<Context> weakReference;
            Context context;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (weakReference = this.f890a) == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f887a == null || TextUtils.isEmpty(this.f889a)) {
                return;
            }
            File file = new File(this.f889a);
            y.a(context, new File(file.getParentFile(), bo.b(file.getAbsolutePath())), new cl(this, context));
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b<T> extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f892a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f893a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f894a;
        public List<T> b;
        public String c;
        public String d;
        public String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, list, str2, strArr, str3, str4, str5, Integer.valueOf(i)};
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
            this.b = new ArrayList();
            this.f893a = list;
            this.f892a = str2;
            this.f894a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.cj.a
        public SQLiteDatabase a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((a) this).f887a.getReadableDatabase() : (SQLiteDatabase) invokeV.objValue;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sQLiteDatabase) == null) {
                this.b.clear();
                List<String> list = this.f893a;
                if (list == null || list.size() <= 0) {
                    strArr = null;
                } else {
                    String[] strArr2 = new String[this.f893a.size()];
                    this.f893a.toArray(strArr2);
                    strArr = strArr2;
                }
                int i = this.a;
                Cursor query = sQLiteDatabase.query(super.b, strArr, this.f892a, this.f894a, this.c, this.d, this.e, i > 0 ? String.valueOf(i) : null);
                if (query != null && query.moveToFirst()) {
                    do {
                        T a = a(context, query);
                        if (a != null) {
                            this.b.add(a);
                        }
                    } while (query.moveToNext());
                    query.close();
                }
                a(context, (List) this.b);
            }
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes8.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<a> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, ArrayList<a> arrayList) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cj.a
        public final void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                super.a(context);
                Iterator<a> it = this.a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.a(context);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sQLiteDatabase) == null) {
                Iterator<a> it = this.a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.a(context, sQLiteDatabase);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f895a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, String[] strArr) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str2;
            this.f895a = strArr;
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, sQLiteDatabase) == null) {
                sQLiteDatabase.delete(this.b, this.a, this.f895a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ContentValues a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, ContentValues contentValues) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, sQLiteDatabase) == null) {
                sQLiteDatabase.insert(this.b, null, this.a);
            }
        }
    }

    public cj(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f885a = new HashMap<>();
        this.f886a = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f884a = new ArrayList<>();
        this.f882a = context;
    }

    private ch a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            ch chVar = this.f885a.get(str);
            if (chVar == null) {
                synchronized (this.f885a) {
                    if (chVar == null) {
                        chVar = this.f883a.a(this.f882a, str);
                        this.f885a.put(str, chVar);
                    }
                }
            }
            return chVar;
        }
        return (ch) invokeL.objValue;
    }

    public static cj a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (cj.class) {
                    if (a == null) {
                        a = new cj(context);
                    }
                }
            }
            return a;
        }
        return (cj) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            al.a(this.f882a).b(new ck(this), com.xiaomi.push.service.ba.a(this.f882a).a(ho.bm.a(), 5));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1175a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? a(str).a() : (String) invokeL.objValue;
    }

    public void a(a aVar) {
        ch chVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f883a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m1177a = aVar.m1177a();
        synchronized (this.f885a) {
            chVar = this.f885a.get(m1177a);
            if (chVar == null) {
                chVar = this.f883a.a(this.f882a, m1177a);
                this.f885a.put(m1177a, chVar);
            }
        }
        if (this.f886a.isShutdown()) {
            return;
        }
        aVar.a(chVar, this.f882a);
        synchronized (this.f884a) {
            this.f884a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || this.f886a.isShutdown()) {
            return;
        }
        this.f886a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            if (this.f883a == null) {
                throw new IllegalStateException("should exec setDbHelperFactory method first!");
            }
            HashMap hashMap = new HashMap();
            if (this.f886a.isShutdown()) {
                return;
            }
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.m1178a()) {
                    next.a(a(next.m1177a()), this.f882a);
                }
                ArrayList arrayList2 = (ArrayList) hashMap.get(next.m1177a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(next.m1177a(), arrayList2);
                }
                arrayList2.add(next);
            }
            for (String str : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f887a, this.f882a);
                    this.f886a.execute(cVar);
                }
            }
        }
    }

    public void b(a aVar) {
        ch chVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f883a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m1177a = aVar.m1177a();
        synchronized (this.f885a) {
            chVar = this.f885a.get(m1177a);
            if (chVar == null) {
                chVar = this.f883a.a(this.f882a, m1177a);
                this.f885a.put(m1177a, chVar);
            }
        }
        if (this.f886a.isShutdown()) {
            return;
        }
        aVar.a(chVar, this.f882a);
        a((Runnable) aVar);
    }
}
