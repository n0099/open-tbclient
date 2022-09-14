package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
@SafeParcelable.Class(creator = "GoogleCertificatesLookupQueryCreator")
/* loaded from: classes7.dex */
public final class zzn extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<zzn> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(getter = "getCallingContextBinder", id = 4, type = "android.os.IBinder")
    public final Context zzd;
    @SafeParcelable.Field(getter = "getIsChimeraPackage", id = 5)
    public final boolean zze;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936195117, "Lcom/google/android/gms/common/zzn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1936195117, "Lcom/google/android/gms/common/zzn;");
                return;
            }
        }
        CREATOR = new zzo();
    }

    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) IBinder iBinder, @SafeParcelable.Param(id = 5) boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2), iBinder, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zze = z3;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, this.zza, false);
            SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
            SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
            SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzd), false);
            SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }
}
