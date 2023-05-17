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
/* loaded from: classes9.dex */
public final class DynamiteModule {
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
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static zzq zzj;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static zzr zzk;
    public final Context zzi;
    public static final ThreadLocal<zzn> zzf = new ThreadLocal<>();
    public static final ThreadLocal<Long> zzg = new zzd();
    public static final VersionPolicy.IVersions zzh = new zze();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    @NonNull
    public static final VersionPolicy zza = new zzl();

    @DynamiteApi
    /* loaded from: classes9.dex */
    public static class DynamiteLoaderClassLoader {
        @Nullable
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes9.dex */
    public interface VersionPolicy {

        /* loaded from: classes9.dex */
        public interface IVersions {
            int zza(@NonNull Context context, @NonNull String str);

            int zzb(@NonNull Context context, @NonNull String str, boolean z) throws LoadingException;
        }

        /* loaded from: classes9.dex */
        public static class SelectionResult {
            @KeepForSdk
            public int localVersion = 0;
            @KeepForSdk
            public int remoteVersion = 0;
            @KeepForSdk
            public int selection = 0;
        }

        @NonNull
        @KeepForSdk
        SelectionResult selectModule(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions) throws LoadingException;
    }

    @NonNull
    @KeepForSdk
    public Context getModuleContext() {
        return this.zzi;
    }

    @KeepForSdk
    /* loaded from: classes9.dex */
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    public DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzi = context;
    }

    public static boolean zze(Cursor cursor) {
        zzn zznVar = zzf.get();
        if (zznVar != null && zznVar.zza == null) {
            zznVar.zza = cursor;
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static int getLocalVersion(@NonNull Context context, @NonNull String str) {
        String str2;
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

    @KeepForSdk
    public static int getRemoteVersion(@NonNull Context context, @NonNull String str) {
        return zza(context, str, false);
    }

    public static DynamiteModule zzc(Context context, String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Selected local version of ".concat(valueOf);
        } else {
            str2 = new String("Selected local version of ");
        }
        Log.i("DynamiteModule", str2);
        return new DynamiteModule(context.getApplicationContext());
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x02b2, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b1, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b3, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b6, code lost:
        com.google.android.gms.dynamite.DynamiteModule.zzf.set(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
        return r0;
     */
    @NonNull
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamiteModule load(@NonNull Context context, @NonNull VersionPolicy versionPolicy, @NonNull String str) throws LoadingException {
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
    }

    public static int zza(@NonNull Context context, @NonNull String str, boolean z) {
        Field declaredField;
        String str2;
        Throwable th;
        RemoteException e;
        String str3;
        Cursor cursor;
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c6  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzb(Context context, String str, boolean z) throws LoadingException {
        Throwable th;
        Exception e;
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
    }

    @GuardedBy("DynamiteModule.class")
    public static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
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

    @NonNull
    @KeepForSdk
    public IBinder instantiate(@NonNull String str) throws LoadingException {
        String str2;
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

    @Nullable
    public static zzq zzf(Context context) {
        String str;
        zzq zzqVar;
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
}
