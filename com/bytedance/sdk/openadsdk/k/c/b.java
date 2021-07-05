package com.bytedance.sdk.openadsdk.k.c;

import android.content.Context;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.k.c.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f31275a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f31276b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f31277c;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31277c = new AtomicBoolean(false);
        b();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31275a == null) {
                synchronized (b.class) {
                    if (f31275a == null) {
                        f31275a = new b();
                    }
                }
            }
            return f31275a;
        }
        return (b) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31277c.get() || o.a() == null) {
            return;
        }
        this.f31276b = o.a();
        this.f31277c.set(true);
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.f31277c.get()) {
                    b();
                } else {
                    try {
                        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f31276b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r1 != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<c.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                LinkedList linkedList = new LinkedList();
                if (!this.f31277c.get()) {
                    b();
                    return linkedList;
                }
                Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f31276b, "logstats", new String[]{"id", "value"}, "retry <?", new String[]{String.valueOf(5)}, null, null, null);
                if (a2 != null) {
                    while (a2.moveToNext()) {
                        try {
                            try {
                                linkedList.add(new c.a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
                return linkedList;
            }
        }
        return (List) invokeV.objValue;
    }
}
