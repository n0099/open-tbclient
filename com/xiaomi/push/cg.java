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
/* loaded from: classes2.dex */
public class cg {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile cg f70741a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f178a;

    /* renamed from: a  reason: collision with other field name */
    public cf f179a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f180a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, ce> f181a;

    /* renamed from: a  reason: collision with other field name */
    public ThreadPoolExecutor f182a;

    /* loaded from: classes2.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f70742a;

        /* renamed from: a  reason: collision with other field name */
        public ce f183a;

        /* renamed from: a  reason: collision with other field name */
        public a f184a;

        /* renamed from: a  reason: collision with other field name */
        public String f185a;

        /* renamed from: a  reason: collision with other field name */
        public WeakReference<Context> f186a;

        /* renamed from: a  reason: collision with other field name */
        public Random f187a;

        /* renamed from: b  reason: collision with root package name */
        public String f70743b;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f183a = null;
            this.f187a = new Random();
            this.f70742a = 0;
            this.f185a = str;
        }

        public SQLiteDatabase a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f183a.getWritableDatabase() : (SQLiteDatabase) invokeV.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m218a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m219a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f185a : (String) invokeV.objValue;
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                a aVar = this.f184a;
                if (aVar != null) {
                    aVar.a(context, m218a());
                }
                b(context);
            }
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, context, obj) == null) {
                cg.a(context).a(this);
            }
        }

        public void a(ce ceVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, ceVar, context) == null) {
                this.f183a = ceVar;
                this.f70743b = ceVar.a();
                this.f186a = new WeakReference<>(context);
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                this.f184a = aVar;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m220a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f183a == null || TextUtils.isEmpty(this.f70743b) || this.f186a == null : invokeV.booleanValue;
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
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (weakReference = this.f186a) == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f183a == null || TextUtils.isEmpty(this.f185a)) {
                return;
            }
            File file = new File(this.f185a);
            v.a(context, new File(file.getParentFile(), bl.b(file.getAbsolutePath())), new ci(this, context));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b<T> extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f70744a;

        /* renamed from: a  reason: collision with other field name */
        public String f188a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f189a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f190a;

        /* renamed from: b  reason: collision with root package name */
        public List<T> f70745b;

        /* renamed from: c  reason: collision with root package name */
        public String f70746c;

        /* renamed from: d  reason: collision with root package name */
        public String f70747d;

        /* renamed from: e  reason: collision with root package name */
        public String f70748e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, list, str2, strArr, str3, str4, str5, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70745b = new ArrayList();
            this.f189a = list;
            this.f188a = str2;
            this.f190a = strArr;
            this.f70746c = str3;
            this.f70747d = str4;
            this.f70748e = str5;
            this.f70744a = i2;
        }

        @Override // com.xiaomi.push.cg.a
        public SQLiteDatabase a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((a) this).f183a.getReadableDatabase() : (SQLiteDatabase) invokeV.objValue;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sQLiteDatabase) == null) {
                this.f70745b.clear();
                List<String> list = this.f189a;
                if (list == null || list.size() <= 0) {
                    strArr = null;
                } else {
                    String[] strArr2 = new String[this.f189a.size()];
                    this.f189a.toArray(strArr2);
                    strArr = strArr2;
                }
                int i2 = this.f70744a;
                Cursor query = sQLiteDatabase.query(super.f70743b, strArr, this.f188a, this.f190a, this.f70746c, this.f70747d, this.f70748e, i2 > 0 ? String.valueOf(i2) : null);
                if (query != null && query.moveToFirst()) {
                    do {
                        T a2 = a(context, query);
                        if (a2 != null) {
                            this.f70745b.add(a2);
                        }
                    } while (query.moveToNext());
                    query.close();
                }
                a(context, (List) this.f70745b);
            }
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes2.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<a> f70749a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, ArrayList<a> arrayList) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, arrayList};
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
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f70749a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cg.a
        public final void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                super.a(context);
                Iterator<a> it = this.f70749a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.a(context);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sQLiteDatabase) == null) {
                Iterator<a> it = this.f70749a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.a(context, sQLiteDatabase);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70750a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f191a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, String[] strArr) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, strArr};
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
            this.f70750a = str2;
            this.f191a = strArr;
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, sQLiteDatabase) == null) {
                sQLiteDatabase.delete(this.f70743b, this.f70750a, this.f191a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ContentValues f70751a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, ContentValues contentValues) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, contentValues};
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
            this.f70751a = contentValues;
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, sQLiteDatabase) == null) {
                sQLiteDatabase.insert(this.f70743b, null, this.f70751a);
            }
        }
    }

    public cg(Context context) {
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
        this.f181a = new HashMap<>();
        this.f182a = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f180a = new ArrayList<>();
        this.f178a = context;
    }

    private ce a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            ce ceVar = this.f181a.get(str);
            if (ceVar == null) {
                synchronized (this.f181a) {
                    if (ceVar == null) {
                        ceVar = this.f179a.a(this.f178a, str);
                        this.f181a.put(str, ceVar);
                    }
                }
            }
            return ceVar;
        }
        return (ce) invokeL.objValue;
    }

    public static cg a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f70741a == null) {
                synchronized (cg.class) {
                    if (f70741a == null) {
                        f70741a = new cg(context);
                    }
                }
            }
            return f70741a;
        }
        return (cg) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ai.a(this.f178a).b(new ch(this), com.xiaomi.push.service.aq.a(this.f178a).a(hk.bh.a(), 5));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m217a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? a(str).a() : (String) invokeL.objValue;
    }

    public void a(a aVar) {
        ce ceVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f179a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m219a = aVar.m219a();
        synchronized (this.f181a) {
            ceVar = this.f181a.get(m219a);
            if (ceVar == null) {
                ceVar = this.f179a.a(this.f178a, m219a);
                this.f181a.put(m219a, ceVar);
            }
        }
        if (this.f182a.isShutdown()) {
            return;
        }
        aVar.a(ceVar, this.f178a);
        synchronized (this.f180a) {
            this.f180a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || this.f182a.isShutdown()) {
            return;
        }
        this.f182a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            if (this.f179a == null) {
                throw new IllegalStateException("should exec setDbHelperFactory method first!");
            }
            HashMap hashMap = new HashMap();
            if (this.f182a.isShutdown()) {
                return;
            }
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.m220a()) {
                    next.a(a(next.m219a()), this.f178a);
                }
                ArrayList arrayList2 = (ArrayList) hashMap.get(next.m219a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(next.m219a(), arrayList2);
                }
                arrayList2.add(next);
            }
            for (String str : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f183a, this.f178a);
                    this.f182a.execute(cVar);
                }
            }
        }
    }

    public void b(a aVar) {
        ce ceVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f179a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m219a = aVar.m219a();
        synchronized (this.f181a) {
            ceVar = this.f181a.get(m219a);
            if (ceVar == null) {
                ceVar = this.f179a.a(this.f178a, m219a);
                this.f181a.put(m219a, ceVar);
            }
        }
        if (this.f182a.isShutdown()) {
            return;
        }
        aVar.a(ceVar, this.f178a);
        a((Runnable) aVar);
    }
}
