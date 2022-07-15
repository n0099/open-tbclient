package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.df;
import java.io.File;
import java.util.Date;
/* loaded from: classes8.dex */
public class dg extends df.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ df f933a;

    /* renamed from: a  reason: collision with other field name */
    public File f934a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f935a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f936a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f937a;
    public final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Date f938b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(df dfVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super(dfVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dfVar, Integer.valueOf(i), date, date2, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((df) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f933a = dfVar;
        this.a = i;
        this.f936a = date;
        this.f938b = date2;
        this.f935a = str;
        this.b = str2;
        this.f937a = z;
    }

    @Override // com.xiaomi.push.df.b, com.xiaomi.push.ao.b
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ad.d()) {
            try {
                File file = new File(this.f933a.f926a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    de deVar = new de();
                    deVar.a(this.a);
                    this.f934a = deVar.a(this.f933a.f926a, this.f936a, this.f938b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.ao.b
    /* renamed from: c */
    public void mo1203c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            File file = this.f934a;
            if (file != null && file.exists()) {
                this.f933a.f927a.add(new df.c(this.f933a, this.f935a, this.b, this.f934a, this.f937a));
            }
            this.f933a.a(0L);
        }
    }
}
