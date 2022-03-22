package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.db;
import java.io.File;
import java.util.Date;
/* loaded from: classes7.dex */
public class dc extends db.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ db f205a;

    /* renamed from: a  reason: collision with other field name */
    public File f206a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f207a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f208a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f209a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f44150b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Date f210b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(db dbVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super(dbVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dbVar, Integer.valueOf(i), date, date2, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((db) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f205a = dbVar;
        this.a = i;
        this.f208a = date;
        this.f210b = date2;
        this.f207a = str;
        this.f44150b = str2;
        this.f209a = z;
    }

    @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && aa.d()) {
            try {
                File file = new File(this.f205a.f198a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    da daVar = new da();
                    daVar.a(this.a);
                    this.f206a = daVar.a(this.f205a.f198a, this.f208a, this.f210b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo284c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            File file = this.f206a;
            if (file != null && file.exists()) {
                this.f205a.f199a.add(new db.c(this.f205a, this.f207a, this.f44150b, this.f206a, this.f209a));
            }
            this.f205a.a(0L);
        }
    }
}
