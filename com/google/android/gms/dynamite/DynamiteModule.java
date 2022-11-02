package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
/* loaded from: classes7.dex */
public final class DynamiteModule {
    public static /* synthetic */ Interceptable $ic = null;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING;
    @NonNull
    public static final VersionPolicy zza;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static Boolean zzb = null;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static String zzc = null;
    @GuardedBy("DynamiteModule.class")
    public static boolean zzd = false;
    @GuardedBy("DynamiteModule.class")
    public static int zze = -1;
    public static final ThreadLocal<zzn> zzf;
    public static final ThreadLocal<Long> zzg;
    public static final VersionPolicy.IVersions zzh;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static zzq zzj;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static zzr zzk;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context zzi;

    @DynamiteApi
    /* loaded from: classes7.dex */
    public static class DynamiteLoaderClassLoader {
        public static /* synthetic */ Interceptable $ic;
        @Nullable
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
        public transient /* synthetic */ FieldHolder $fh;

        public DynamiteLoaderClassLoader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface VersionPolicy {

        /* loaded from: classes7.dex */
        public interface IVersions {
            int zza(@NonNull Context context, @NonNull String str);

            int zzb(@NonNull Context context, @NonNull String str, boolean z) throws LoadingException;
        }

        /* loaded from: classes7.dex */
        public static class SelectionResult {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @KeepForSdk
            public int localVersion;
            @KeepForSdk
            public int remoteVersion;
            @KeepForSdk
            public int selection;

            public SelectionResult() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.localVersion = 0;
                this.remoteVersion = 0;
                this.selection = 0;
            }
        }

        @NonNull
        @KeepForSdk
        SelectionResult selectModule(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions) throws LoadingException;
    }

    @NonNull
    @KeepForSdk
    public Context getModuleContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zzi : (Context) invokeV.objValue;
    }

    @KeepForSdk
    /* loaded from: classes7.dex */
    public static class LoadingException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1033383106, "Lcom/google/android/gms/dynamite/DynamiteModule;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1033383106, "Lcom/google/android/gms/dynamite/DynamiteModule;");
                return;
            }
        }
        zzf = new ThreadLocal<>();
        zzg = new zzd();
        zzh = new zze();
        PREFER_REMOTE = new zzf();
        PREFER_LOCAL = new zzg();
        PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
        PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
        PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
        PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
        zza = new zzl();
    }

    public DynamiteModule(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(context);
        this.zzi = context;
    }

    @NonNull
    @KeepForSdk
    public IBinder instantiate(@NonNull String str) throws LoadingException {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return (IBinder) this.zzi.getClassLoader().loadClass(str).newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "Failed to instantiate module class: ".concat(valueOf);
                } else {
                    str2 = new String("Failed to instantiate module class: ");
                }
                throw new LoadingException(str2, e, null);
            }
        }
        return (IBinder) invokeL.objValue;
    }

    @KeepForSdk
    public static int getLocalVersion(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                ClassLoader classLoader = context.getApplicationContext().getClassLoader();
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
                sb.append("com.google.android.gms.dynamite.descriptors.");
                sb.append(str);
                sb.append(".");
                sb.append("ModuleDescriptor");
                Class<?> loadClass = classLoader.loadClass(sb.toString());
                Field declaredField = loadClass.getDeclaredField("MODULE_ID");
                Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
                if (!Objects.equal(declaredField.get(null), str)) {
                    String valueOf = String.valueOf(declaredField.get(null));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
                    sb2.append("Module descriptor id '");
                    sb2.append(valueOf);
                    sb2.append("' didn't match expected id '");
                    sb2.append(str);
                    sb2.append("'");
                    Log.e("DynamiteModule", sb2.toString());
                    return 0;
                }
                return declaredField2.getInt(null);
            } catch (ClassNotFoundException unused) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
                sb3.append("Local module descriptor class for ");
                sb3.append(str);
                sb3.append(" not found.");
                Log.w("DynamiteModule", sb3.toString());
                return 0;
            } catch (Exception e) {
                String valueOf2 = String.valueOf(e.getMessage());
                if (valueOf2.length() != 0) {
                    str2 = "Failed to load module descriptor class: ".concat(valueOf2);
                } else {
                    str2 = new String("Failed to load module descriptor class: ");
                }
                Log.e("DynamiteModule", str2);
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    @KeepForSdk
    public static int getRemoteVersion(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            return zza(context, str, false);
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x02b6, code lost:
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b7, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ba, code lost:
        com.google.android.gms.dynamite.DynamiteModule.zzf.set(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bf, code lost:
        return r0;
     */
    @NonNull
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamiteModule load(@NonNull Context context, @NonNull VersionPolicy versionPolicy, @NonNull String str) throws LoadingException {
        InterceptResult invokeLLL;
        long j;
        String str2;
        DynamiteModule zzc2;
        Cursor cursor;
        Boolean bool;
        IObjectWrapper zzh2;
        DynamiteModule dynamiteModule;
        zzr zzrVar;
        boolean z;
        Boolean valueOf;
        IObjectWrapper zze2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, versionPolicy, str)) == null) {
            zzn zznVar = zzf.get();
            zzn zznVar2 = new zzn(null);
            zzf.set(zznVar2);
            long longValue = zzg.get().longValue();
            try {
                zzg.set(Long.valueOf(SystemClock.elapsedRealtime()));
                VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzh);
                int i = selectModule.localVersion;
                int i2 = selectModule.remoteVersion;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
                sb.append("Considering local module ");
                sb.append(str);
                sb.append(":");
                sb.append(i);
                sb.append(" and remote module ");
                sb.append(str);
                sb.append(":");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                int i3 = selectModule.selection;
                try {
                    if (i3 != 0) {
                        if (i3 == -1) {
                            if (selectModule.localVersion != 0) {
                                i3 = -1;
                            }
                        }
                        if (i3 != 1 || selectModule.remoteVersion != 0) {
                            if (i3 == -1) {
                                zzc2 = zzc(context, str);
                                if (longValue == 0) {
                                    zzg.remove();
                                } else {
                                    zzg.set(Long.valueOf(longValue));
                                }
                                cursor = zznVar2.zza;
                            } else if (i3 == 1) {
                                try {
                                    int i4 = selectModule.remoteVersion;
                                    try {
                                        synchronized (DynamiteModule.class) {
                                            bool = zzb;
                                        }
                                        if (bool != null) {
                                            if (bool.booleanValue()) {
                                                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
                                                sb2.append("Selected remote version of ");
                                                sb2.append(str);
                                                sb2.append(", version >= ");
                                                sb2.append(i4);
                                                Log.i("DynamiteModule", sb2.toString());
                                                synchronized (DynamiteModule.class) {
                                                    zzrVar = zzk;
                                                }
                                                if (zzrVar != null) {
                                                    zzn zznVar3 = zzf.get();
                                                    if (zznVar3 != null && zznVar3.zza != null) {
                                                        Context applicationContext = context.getApplicationContext();
                                                        Cursor cursor2 = zznVar3.zza;
                                                        ObjectWrapper.wrap(null);
                                                        synchronized (DynamiteModule.class) {
                                                            if (zze >= 2) {
                                                                z = true;
                                                            } else {
                                                                z = false;
                                                            }
                                                            valueOf = Boolean.valueOf(z);
                                                        }
                                                        if (valueOf.booleanValue()) {
                                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                            zze2 = zzrVar.zzf(ObjectWrapper.wrap(applicationContext), str, i4, ObjectWrapper.wrap(cursor2));
                                                        } else {
                                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                            zze2 = zzrVar.zze(ObjectWrapper.wrap(applicationContext), str, i4, ObjectWrapper.wrap(cursor2));
                                                        }
                                                        Context context2 = (Context) ObjectWrapper.unwrap(zze2);
                                                        if (context2 != null) {
                                                            dynamiteModule = new DynamiteModule(context2);
                                                        } else {
                                                            throw new LoadingException("Failed to get module context", null);
                                                        }
                                                    } else {
                                                        throw new LoadingException("No result cursor", null);
                                                    }
                                                } else {
                                                    throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                                }
                                            } else {
                                                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 51);
                                                sb3.append("Selected remote version of ");
                                                sb3.append(str);
                                                sb3.append(", version >= ");
                                                sb3.append(i4);
                                                Log.i("DynamiteModule", sb3.toString());
                                                zzq zzf2 = zzf(context);
                                                if (zzf2 != null) {
                                                    int zze3 = zzf2.zze();
                                                    if (zze3 >= 3) {
                                                        zzn zznVar4 = zzf.get();
                                                        if (zznVar4 != null) {
                                                            zzh2 = zzf2.zzi(ObjectWrapper.wrap(context), str, i4, ObjectWrapper.wrap(zznVar4.zza));
                                                        } else {
                                                            throw new LoadingException("No cached result cursor holder", null);
                                                        }
                                                    } else if (zze3 == 2) {
                                                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                        zzh2 = zzf2.zzj(ObjectWrapper.wrap(context), str, i4);
                                                    } else {
                                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                        zzh2 = zzf2.zzh(ObjectWrapper.wrap(context), str, i4);
                                                    }
                                                    if (ObjectWrapper.unwrap(zzh2) != null) {
                                                        dynamiteModule = new DynamiteModule((Context) ObjectWrapper.unwrap(zzh2));
                                                    } else {
                                                        throw new LoadingException("Failed to load remote module.", null);
                                                    }
                                                } else {
                                                    throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                                }
                                            }
                                            if (longValue == 0) {
                                                zzg.remove();
                                            } else {
                                                zzg.set(Long.valueOf(longValue));
                                            }
                                            Cursor cursor3 = zznVar2.zza;
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            zzf.set(zznVar);
                                            return dynamiteModule;
                                        }
                                        throw new LoadingException("Failed to determine which loading route to use.", null);
                                    } catch (RemoteException e) {
                                        throw new LoadingException("Failed to load remote module.", e, null);
                                    } catch (LoadingException e2) {
                                        throw e2;
                                    } catch (Throwable th) {
                                        CrashUtils.addDynamiteErrorToDropBox(context, th);
                                        throw new LoadingException("Failed to load remote module.", th, null);
                                    }
                                } catch (LoadingException e3) {
                                    String valueOf2 = String.valueOf(e3.getMessage());
                                    if (valueOf2.length() != 0) {
                                        str2 = "Failed to load remote module: ".concat(valueOf2);
                                    } else {
                                        str2 = new String("Failed to load remote module: ");
                                    }
                                    Log.w("DynamiteModule", str2);
                                    int i5 = selectModule.localVersion;
                                    if (i5 != 0 && versionPolicy.selectModule(context, str, new zzo(i5, 0)).selection == -1) {
                                        zzc2 = zzc(context, str);
                                        if (longValue == 0) {
                                            zzg.remove();
                                        } else {
                                            zzg.set(Long.valueOf(longValue));
                                        }
                                        cursor = zznVar2.zza;
                                    } else {
                                        throw new LoadingException("Remote load failed. No local fallback found.", e3, null);
                                    }
                                }
                            } else {
                                StringBuilder sb4 = new StringBuilder(47);
                                sb4.append("VersionPolicy returned invalid code:");
                                sb4.append(i3);
                                throw new LoadingException(sb4.toString(), null);
                            }
                        }
                    }
                    int i6 = selectModule.localVersion;
                    int i7 = selectModule.remoteVersion;
                    StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 92);
                    sb5.append("No acceptable module ");
                    sb5.append(str);
                    sb5.append(" found. Local version is ");
                    sb5.append(i6);
                    sb5.append(" and remote version is ");
                    sb5.append(i7);
                    sb5.append(".");
                    throw new LoadingException(sb5.toString(), null);
                } catch (Throwable th2) {
                    th = th2;
                    j = 0;
                    if (longValue == j) {
                        zzg.remove();
                    } else {
                        zzg.set(Long.valueOf(longValue));
                    }
                    Cursor cursor4 = zznVar2.zza;
                    if (cursor4 != null) {
                        cursor4.close();
                    }
                    zzf.set(zznVar);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j = 0;
            }
        } else {
            return (DynamiteModule) invokeLLL.objValue;
        }
    }

    public static int zza(@NonNull Context context, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Field declaredField;
        String str2;
        Throwable th;
        RemoteException e;
        String str3;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, context, str, z)) == null) {
            try {
                synchronized (DynamiteModule.class) {
                    Boolean bool = zzb;
                    Cursor cursor2 = null;
                    if (bool == null) {
                        try {
                            declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                            String obj = e2.toString();
                            StringBuilder sb = new StringBuilder(obj.length() + 30);
                            sb.append("Failed to load module via V2: ");
                            sb.append(obj);
                            Log.w("DynamiteModule", sb.toString());
                            bool = Boolean.FALSE;
                        }
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader != null) {
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        zzd(classLoader);
                                    } catch (LoadingException unused) {
                                    }
                                    bool = Boolean.TRUE;
                                }
                            } else if (!zzd && !Boolean.TRUE.equals(null)) {
                                try {
                                    int zzb2 = zzb(context, str, z);
                                    String str4 = zzc;
                                    if (str4 != null && !str4.isEmpty()) {
                                        ClassLoader zza2 = zzb.zza();
                                        if (zza2 == null) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                String str5 = zzc;
                                                Preconditions.checkNotNull(str5);
                                                zza2 = new DelegateLastClassLoader(str5, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str6 = zzc;
                                                Preconditions.checkNotNull(str6);
                                                zza2 = new zzc(str6, ClassLoader.getSystemClassLoader());
                                            }
                                        }
                                        zzd(zza2);
                                        declaredField.set(null, zza2);
                                        zzb = Boolean.TRUE;
                                        return zzb2;
                                    }
                                    return zzb2;
                                } catch (LoadingException unused2) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                }
                            } else {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                            zzb = bool;
                        }
                    }
                    boolean booleanValue = bool.booleanValue();
                    int i = 0;
                    if (booleanValue) {
                        try {
                            return zzb(context, str, z);
                        } catch (LoadingException e3) {
                            String valueOf = String.valueOf(e3.getMessage());
                            if (valueOf.length() != 0) {
                                str2 = "Failed to retrieve remote module version: ".concat(valueOf);
                            } else {
                                str2 = new String("Failed to retrieve remote module version: ");
                            }
                            Log.w("DynamiteModule", str2);
                            return 0;
                        }
                    }
                    zzq zzf2 = zzf(context);
                    try {
                        if (zzf2 != null) {
                            try {
                                int zze2 = zzf2.zze();
                                if (zze2 >= 3) {
                                    zzn zznVar = zzf.get();
                                    if (zznVar != null && (cursor = zznVar.zza) != null) {
                                        i = cursor.getInt(0);
                                    } else {
                                        Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzf2.zzk(ObjectWrapper.wrap(context), str, z, zzg.get().longValue()));
                                        if (cursor3 != null) {
                                            try {
                                                if (cursor3.moveToFirst()) {
                                                    int i2 = cursor3.getInt(0);
                                                    if (i2 <= 0 || !zze(cursor3)) {
                                                        cursor2 = cursor3;
                                                    }
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    i = i2;
                                                }
                                            } catch (RemoteException e4) {
                                                e = e4;
                                                cursor2 = cursor3;
                                                String valueOf2 = String.valueOf(e.getMessage());
                                                if (valueOf2.length() != 0) {
                                                    str3 = "Failed to retrieve remote module version: ".concat(valueOf2);
                                                } else {
                                                    str3 = new String("Failed to retrieve remote module version: ");
                                                }
                                                Log.w("DynamiteModule", str3);
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                return i;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                cursor2 = cursor3;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    }
                                } else if (zze2 == 2) {
                                    Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                    i = zzf2.zzg(ObjectWrapper.wrap(context), str, z);
                                } else {
                                    Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                    i = zzf2.zzf(ObjectWrapper.wrap(context), str, z);
                                }
                            } catch (RemoteException e5) {
                                e = e5;
                            }
                        }
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Throwable th4) {
                CrashUtils.addDynamiteErrorToDropBox(context, th4);
                throw th4;
            }
        } else {
            return invokeLLZ.intValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ca  */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzb(Context context, String str, boolean z) throws LoadingException {
        InterceptResult invokeLLZ;
        Throwable th;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, context, str, z)) == null) {
            ?? r0 = 0;
            try {
                try {
                    long longValue = zzg.get().longValue();
                    ContentResolver contentResolver = context.getContentResolver();
                    String str2 = "api_force_staging";
                    boolean z2 = true;
                    if (true != z) {
                        str2 = "api";
                    }
                    Cursor query = contentResolver.query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(str2).appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(longValue)).build(), null, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                boolean z3 = false;
                                int i = query.getInt(0);
                                if (i > 0) {
                                    synchronized (DynamiteModule.class) {
                                        zzc = query.getString(2);
                                        int columnIndex = query.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            zze = query.getInt(columnIndex);
                                        }
                                        int columnIndex2 = query.getColumnIndex("disableStandaloneDynamiteLoader");
                                        if (columnIndex2 >= 0) {
                                            if (query.getInt(columnIndex2) == 0) {
                                                z2 = false;
                                            }
                                            zzd = z2;
                                            z3 = z2;
                                        }
                                    }
                                    if (zze(query)) {
                                        query = null;
                                    }
                                }
                                if (!z3) {
                                    if (query != null) {
                                        query.close();
                                    }
                                    return i;
                                }
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", null);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            if (e instanceof LoadingException) {
                                throw e;
                            }
                            throw new LoadingException("V2 version check failed", e, null);
                        }
                    }
                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                    throw new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
                } catch (Throwable th2) {
                    th = th2;
                    r0 = context;
                    if (r0 != 0) {
                        r0.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                if (r0 != 0) {
                }
                throw th;
            }
        } else {
            return invokeLLZ.intValue;
        }
    }

    public static DynamiteModule zzc(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Selected local version of ".concat(valueOf);
            } else {
                str2 = new String("Selected local version of ");
            }
            Log.i("DynamiteModule", str2);
            return new DynamiteModule(context.getApplicationContext());
        }
        return (DynamiteModule) invokeLL.objValue;
    }

    @GuardedBy("DynamiteModule.class")
    public static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, classLoader) == null) {
            try {
                IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
                if (iBinder == null) {
                    zzrVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                    if (queryLocalInterface instanceof zzr) {
                        zzrVar = (zzr) queryLocalInterface;
                    } else {
                        zzrVar = new zzr(iBinder);
                    }
                }
                zzk = zzrVar;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                throw new LoadingException("Failed to instantiate dynamite loader", e, null);
            }
        }
    }

    public static boolean zze(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cursor)) == null) {
            zzn zznVar = zzf.get();
            if (zznVar != null && zznVar.zza == null) {
                zznVar.zza = cursor;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static zzq zzf(Context context) {
        InterceptResult invokeL;
        String str;
        zzq zzqVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            synchronized (DynamiteModule.class) {
                zzq zzqVar2 = zzj;
                if (zzqVar2 != null) {
                    return zzqVar2;
                }
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzqVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        if (queryLocalInterface instanceof zzq) {
                            zzqVar = (zzq) queryLocalInterface;
                        } else {
                            zzqVar = new zzq(iBinder);
                        }
                    }
                    if (zzqVar != null) {
                        zzj = zzqVar;
                        return zzqVar;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        str = "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf);
                    } else {
                        str = new String("Failed to load IDynamiteLoader from GmsCore: ");
                    }
                    Log.e("DynamiteModule", str);
                }
                return null;
            }
        }
        return (zzq) invokeL.objValue;
    }
}
