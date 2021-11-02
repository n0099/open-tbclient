package com.kwad.sdk.collector.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.n;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static com.kwad.sdk.collector.a.d f64124a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f64125b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends com.kwad.sdk.collector.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
            b();
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                ArrayList arrayList = new ArrayList();
                this.f64123b = arrayList;
                arrayList.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f64126c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64126c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                            int i2 = (Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("Andy") || Build.PRODUCT.contains("ttVM_Hdragon") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("Droid4X") || Build.PRODUCT.contains("nox") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("aries")) ? 1 : 0;
                            if (Build.MANUFACTURER.equals("unknown") || Build.MANUFACTURER.equals("Genymotion") || Build.MANUFACTURER.contains("Andy") || Build.MANUFACTURER.contains("MIT") || Build.MANUFACTURER.contains("nox") || Build.MANUFACTURER.contains("TiantianVM")) {
                                i2++;
                            }
                            if (Build.BRAND.equals("generic") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("TTVM") || Build.BRAND.contains("Andy")) {
                                i2++;
                            }
                            if (Build.DEVICE.contains("generic") || Build.DEVICE.contains("generic_x86") || Build.DEVICE.contains("Andy") || Build.DEVICE.contains("ttVM_Hdragon") || Build.DEVICE.contains("Droid4X") || Build.DEVICE.contains("nox") || Build.DEVICE.contains("generic_x86_64") || Build.DEVICE.contains("vbox86p") || Build.DEVICE.contains("aries")) {
                                i2++;
                            }
                            if (Build.MODEL.equals("sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.equals("google_sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || Build.MODEL.equals("Android SDK built for x86_64") || Build.MODEL.equals("Android SDK built for x86")) {
                                i2++;
                            }
                            if (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.HARDWARE.contains("nox") || Build.HARDWARE.contains("ttVM_x86")) {
                                i2++;
                            }
                            if (Build.FINGERPRINT.contains("generic/sdk/generic") || Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("generic_x86_64") || Build.FINGERPRINT.contains("generic/google_sdk/generic") || Build.FINGERPRINT.contains("vbox86p") || Build.FINGERPRINT.contains("generic/vbox86p/vbox86p")) {
                                i2++;
                            }
                            try {
                                if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                                    i2 += 10;
                                }
                            } catch (Exception unused) {
                            }
                            return i2 > 3;
                        }
                        return invokeL.booleanValue;
                    }
                });
                this.f64123b.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f64127c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64127c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) ? "1".equals(ao.a("ro.kernel.qemu")) : invokeL.booleanValue;
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends com.kwad.sdk.collector.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.collector.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1891c extends com.kwad.sdk.collector.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1891c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends com.kwad.sdk.collector.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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
            b();
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                ArrayList arrayList = new ArrayList();
                this.f64123b = arrayList;
                arrayList.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f64128c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64128c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) ? new File("/system/app/Superuser.apk").exists() : invokeL.booleanValue;
                    }
                });
                this.f64123b.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f64129c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64129c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                            String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                            for (int i2 = 0; i2 < 5; i2++) {
                                if (new File(strArr[i2] + "su").exists()) {
                                    return true;
                                }
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                });
                this.f64123b.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f64130c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64130c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) ? c.a(new String[]{"/system/xbin/which", "su"}) != null : invokeL.booleanValue;
                    }
                });
                this.f64123b.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f64131c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64131c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                            Charset forName = Charset.forName("UTF-8");
                            File file = new File("/data/su_test");
                            try {
                                n.a(file, NewBindCardEntry.BING_CARD_SUCCESS_MSG, forName, false);
                                return n.a(file, forName).equals(NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                            } catch (Throwable unused) {
                                return false;
                            }
                        }
                        return invokeL.booleanValue;
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends com.kwad.sdk.collector.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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
            b();
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                ArrayList arrayList = new ArrayList();
                this.f64123b = arrayList;
                arrayList.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f64132c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64132c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                            boolean z = false;
                            for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(128)) {
                                if (applicationInfo.packageName.equals("de.robv.android.xposed.installer")) {
                                    z = true;
                                }
                                if (applicationInfo.packageName.equals("com.saurik.substrate")) {
                                    z = true;
                                }
                            }
                            return z;
                        }
                        return invokeL.booleanValue;
                    }
                });
                this.f64123b.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f64133c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64133c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        StackTraceElement[] stackTrace;
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                            try {
                                throw new Exception("empty");
                            } catch (Exception e2) {
                                boolean z = false;
                                int i2 = 0;
                                for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                                    String className = stackTraceElement.getClassName();
                                    String methodName = stackTraceElement.getMethodName();
                                    if (className.equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                                        z = true;
                                    }
                                    if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                        Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                        z = true;
                                    }
                                    if (className.equals("de.robv.android.xposed.XposedBridge") && methodName.equals(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                                        z = true;
                                    }
                                    if (className.equals("de.robv.android.xposed.XposedBridge") && methodName.equals("handleHookedMethod")) {
                                        z = true;
                                    }
                                }
                                return z;
                            }
                        }
                        return invokeL.booleanValue;
                    }
                });
                this.f64123b.add(new com.kwad.sdk.collector.a.a(this, this.f64122a) { // from class: com.kwad.sdk.collector.a.c.e.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f64134c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64134c = this;
                    }

                    @Override // com.kwad.sdk.collector.a.a
                    public boolean b(Context context) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                            boolean z = false;
                            try {
                                HashSet<String> hashSet = new HashSet();
                                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                    }
                                }
                                for (String str : hashSet) {
                                    if (str.contains("com.saurik.substrate")) {
                                        Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                        z = true;
                                    }
                                    if (str.contains("XposedBridge.jar")) {
                                        Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                        z = true;
                                    }
                                }
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                            return z;
                        }
                        return invokeL.booleanValue;
                    }
                });
            }
        }
    }

    @WorkerThread
    public static com.kwad.sdk.collector.a.d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (com.kwad.sdk.core.config.c.L()) {
                com.kwad.sdk.collector.a.d dVar = f64124a;
                if (dVar != null) {
                    return dVar;
                }
                com.kwad.sdk.collector.a.d dVar2 = new com.kwad.sdk.collector.a.d(f64125b);
                boolean a2 = new d().a(f64125b);
                boolean a3 = new e().a(f64125b);
                boolean a4 = new b().a(f64125b);
                boolean a5 = new a().a(f64125b);
                boolean a6 = new C1891c().a(f64125b);
                dVar2.a(a2);
                dVar2.b(a3);
                dVar2.c(a4);
                dVar2.e(a5);
                dVar2.f(a6);
                f64124a = dVar2;
                return dVar2;
            }
            return null;
        }
        return (com.kwad.sdk.collector.a.d) invokeV.objValue;
    }

    public static ArrayList<String> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, strArr)) != null) {
            return (ArrayList) invokeL.objValue;
        }
        ArrayList<String> arrayList = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            try {
                try {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                return arrayList2;
                            }
                            arrayList2.add(readLine);
                        } catch (Exception unused) {
                            arrayList = arrayList2;
                            com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                            return arrayList;
                        }
                    }
                } finally {
                    com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null) {
            return;
        }
        f64125b = context.getApplicationContext();
    }
}
