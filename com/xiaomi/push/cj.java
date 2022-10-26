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
    public Context f163a;

    /* renamed from: a  reason: collision with other field name */
    public ci f164a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f165a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f166a;

    /* renamed from: a  reason: collision with other field name */
    public ThreadPoolExecutor f167a;

    /* loaded from: classes8.dex */
    public abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public ch f168a;

        /* renamed from: a  reason: collision with other field name */
        public a f169a;

        /* renamed from: a  reason: collision with other field name */
        public String f170a;

        /* renamed from: a  reason: collision with other field name */
        public WeakReference f171a;

        /* renamed from: a  reason: collision with other field name */
        public Random f172a;
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
            this.f168a = null;
            this.f172a = new Random();
            this.a = 0;
            this.f170a = str;
        }

        public SQLiteDatabase a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f168a.getWritableDatabase() : (SQLiteDatabase) invokeV.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m238a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m239a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f170a : (String) invokeV.objValue;
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                a aVar = this.f169a;
                if (aVar != null) {
                    aVar.a(context, m238a());
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
                this.f168a = chVar;
                this.b = chVar.a();
                this.f171a = new WeakReference(context);
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                this.f169a = aVar;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m240a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f168a == null || TextUtils.isEmpty(this.b) || this.f171a == null : invokeV.booleanValue;
        }

        public void b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference weakReference;
            Context context;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (weakReference = this.f171a) == null || (context = (Context) weakReference.get()) == null || context.getFilesDir() == null || this.f168a == null || TextUtils.isEmpty(this.f170a)) {
                return;
            }
            File file = new File(this.f170a);
            y.a(context, new File(file.getParentFile(), bo.b(file.getAbsolutePath())), new cl(this, context));
        }
    }

    /* loaded from: classes8.dex */
    public abstract class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f173a;

        /* renamed from: a  reason: collision with other field name */
        public List f174a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f175a;
        public List b;
        public String c;
        public String d;
        public String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, List list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
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
            this.f174a = list;
            this.f173a = str2;
            this.f175a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.cj.a
        public SQLiteDatabase a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((a) this).f168a.getReadableDatabase() : (SQLiteDatabase) invokeV.objValue;
        }

        public abstract Object a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sQLiteDatabase) == null) {
                this.b.clear();
                List list = this.f174a;
                if (list == null || list.size() <= 0) {
                    strArr = null;
                } else {
                    String[] strArr2 = new String[this.f174a.size()];
                    this.f174a.toArray(strArr2);
                    strArr = strArr2;
                }
                int i = this.a;
                Cursor query = sQLiteDatabase.query(super.b, strArr, this.f173a, this.f175a, this.c, this.d, this.e, i > 0 ? String.valueOf(i) : null);
                if (query != null && query.moveToFirst()) {
                    do {
                        Object a = a(context, query);
                        if (a != null) {
                            this.b.add(a);
                        }
                    } while (query.moveToNext());
                    query.close();
                }
                a(context, this.b);
            }
        }

        public abstract void a(Context context, List list);
    }

    /* loaded from: classes8.dex */
    public class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, ArrayList arrayList) {
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
            ArrayList arrayList2 = new ArrayList();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cj.a
        public final void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                super.a(context);
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        aVar.a(context);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sQLiteDatabase) == null) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        aVar.a(context, sQLiteDatabase);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f176a;

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
            this.f176a = strArr;
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, sQLiteDatabase) == null) {
                sQLiteDatabase.delete(this.b, this.a, this.f176a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends a {
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
        this.f166a = new HashMap();
        this.f167a = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f165a = new ArrayList();
        this.f163a = context;
    }

    private ch a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            ch chVar = (ch) this.f166a.get(str);
            if (chVar == null) {
                synchronized (this.f166a) {
                    if (chVar == null) {
                        chVar = this.f164a.a(this.f163a, str);
                        this.f166a.put(str, chVar);
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
            al.a(this.f163a).b(new ck(this), com.xiaomi.push.service.ba.a(this.f163a).a(ho.bm.a(), 5));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m237a(String str) {
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
        if (this.f164a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m239a = aVar.m239a();
        synchronized (this.f166a) {
            chVar = (ch) this.f166a.get(m239a);
            if (chVar == null) {
                chVar = this.f164a.a(this.f163a, m239a);
                this.f166a.put(m239a, chVar);
            }
        }
        if (this.f167a.isShutdown()) {
            return;
        }
        aVar.a(chVar, this.f163a);
        synchronized (this.f165a) {
            this.f165a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || this.f167a.isShutdown()) {
            return;
        }
        this.f167a.execute(runnable);
    }

    public void a(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            if (this.f164a == null) {
                throw new IllegalStateException("should exec setDbHelperFactory method first!");
            }
            HashMap hashMap = new HashMap();
            if (this.f167a.isShutdown()) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.m240a()) {
                    aVar.a(a(aVar.m239a()), this.f163a);
                }
                ArrayList arrayList2 = (ArrayList) hashMap.get(aVar.m239a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(aVar.m239a(), arrayList2);
                }
                arrayList2.add(aVar);
            }
            for (String str : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f168a, this.f163a);
                    this.f167a.execute(cVar);
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
        if (this.f164a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m239a = aVar.m239a();
        synchronized (this.f166a) {
            chVar = (ch) this.f166a.get(m239a);
            if (chVar == null) {
                chVar = this.f164a.a(this.f163a, m239a);
                this.f166a.put(m239a, chVar);
            }
        }
        if (this.f167a.isShutdown()) {
            return;
        }
        aVar.a(chVar, this.f163a);
        a((Runnable) aVar);
    }
}
