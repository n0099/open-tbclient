package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.db;
import java.io.File;
import java.util.Date;
/* loaded from: classes3.dex */
public class dc extends db.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ db f229a;

    /* renamed from: a  reason: collision with other field name */
    public File f230a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f231a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f232a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f233a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62777b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Date f234b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(db dbVar, int i2, Date date, Date date2, String str, String str2, boolean z) {
        super(dbVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dbVar, Integer.valueOf(i2), date, date2, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((db) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f229a = dbVar;
        this.a = i2;
        this.f232a = date;
        this.f234b = date2;
        this.f231a = str;
        this.f62777b = str2;
        this.f233a = z;
    }

    @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && aa.d()) {
            try {
                File file = new File(this.f229a.f222a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    da daVar = new da();
                    daVar.a(this.a);
                    this.f230a = daVar.a(this.f229a.f222a, this.f232a, this.f234b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo294c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            File file = this.f230a;
            if (file != null && file.exists()) {
                this.f229a.f223a.add(new db.c(this.f229a, this.f231a, this.f62777b, this.f230a, this.f233a));
            }
            this.f229a.a(0L);
        }
    }
}
