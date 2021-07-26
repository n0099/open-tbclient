package com.bytedance.sdk.openadsdk.preload.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class a extends v<Date> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends Date> f32020a;

    /* renamed from: b  reason: collision with root package name */
    public final List<DateFormat> f32021b;

    public a(Class<? extends Date> cls, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32021b = new ArrayList();
        this.f32020a = a(cls);
        this.f32021b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f32021b.add(new SimpleDateFormat(str));
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DateFormat dateFormat = this.f32021b.get(0);
            if (dateFormat instanceof SimpleDateFormat) {
                return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
            }
            return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
        }
        return (String) invokeV.objValue;
    }

    public static Class<? extends Date> a(Class<? extends Date> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
                return cls;
            }
            throw new IllegalArgumentException("Date type must be one of " + Date.class + StringUtil.ARRAY_ELEMENT_SEPARATOR + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
        }
        return (Class) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Date date) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, date) == null) {
            if (date == null) {
                cVar.f();
                return;
            }
            synchronized (this.f32021b) {
                cVar.b(this.f32021b.get(0).format(date));
            }
        }
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32021b = new ArrayList();
        this.f32020a = a(cls);
        this.f32021b.add(DateFormat.getDateTimeInstance(i2, i3, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f32021b.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (com.bytedance.sdk.openadsdk.preload.a.b.e.b()) {
            this.f32021b.add(com.bytedance.sdk.openadsdk.preload.a.b.j.a(i2, i3));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    /* renamed from: a */
    public Date b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f32229i) {
                aVar.j();
                return null;
            }
            Date a2 = a(aVar.h());
            Class<? extends Date> cls = this.f32020a;
            if (cls == Date.class) {
                return a2;
            }
            if (cls == Timestamp.class) {
                return new Timestamp(a2.getTime());
            }
            if (cls == java.sql.Date.class) {
                return new java.sql.Date(a2.getTime());
            }
            throw new AssertionError();
        }
        return (Date) invokeL.objValue;
    }

    private Date a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            synchronized (this.f32021b) {
                for (DateFormat dateFormat : this.f32021b) {
                    try {
                        return dateFormat.parse(str);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return com.bytedance.sdk.openadsdk.preload.a.b.a.a.a.a(str, new ParsePosition(0));
                } catch (ParseException e2) {
                    throw new t(str, e2);
                }
            }
        }
        return (Date) invokeL.objValue;
    }
}
