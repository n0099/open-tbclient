package io.flutter.embedding.engine.deferredcomponents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes4.dex */
public class PlayStoreDeferredComponentManager implements DeferredComponentManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MAPPING_KEY;
    public static final String TAG = "PlayStoreDeferredComponentManager";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public DeferredComponentChannel channel;
    @NonNull
    public Context context;
    @NonNull
    public FlutterApplicationInfo flutterApplicationInfo;
    @Nullable
    public FlutterJNI flutterJNI;
    public FeatureInstallStateUpdatedListener listener;
    @NonNull
    public SparseArray<String> loadingUnitIdToComponentNames;
    @NonNull
    public SparseArray<String> loadingUnitIdToSharedLibraryNames;
    @NonNull
    public Map<String, Integer> nameToSessionId;
    @NonNull
    public SparseIntArray sessionIdToLoadingUnitId;
    @NonNull
    public SparseArray<String> sessionIdToName;
    @NonNull
    public SparseArray<String> sessionIdToState;
    @NonNull
    public SplitInstallManager splitInstallManager;

    /* renamed from: io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class FeatureInstallStateUpdatedListener implements SplitInstallStateUpdatedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayStoreDeferredComponentManager this$0;

        public FeatureInstallStateUpdatedListener(PlayStoreDeferredComponentManager playStoreDeferredComponentManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playStoreDeferredComponentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = playStoreDeferredComponentManager;
        }

        public /* synthetic */ FeatureInstallStateUpdatedListener(PlayStoreDeferredComponentManager playStoreDeferredComponentManager, AnonymousClass1 anonymousClass1) {
            this(playStoreDeferredComponentManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @SuppressLint({"DefaultLocale"})
        public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, splitInstallSessionState) == null) {
                int sessionId = splitInstallSessionState.sessionId();
                if (this.this$0.sessionIdToName.get(sessionId) != null) {
                    switch (splitInstallSessionState.status()) {
                        case 1:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install pending.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            this.this$0.sessionIdToState.put(sessionId, "pending");
                            return;
                        case 2:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) downloading.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            this.this$0.sessionIdToState.put(sessionId, "downloading");
                            return;
                        case 3:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) downloaded.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            this.this$0.sessionIdToState.put(sessionId, "downloaded");
                            return;
                        case 4:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) installing.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            this.this$0.sessionIdToState.put(sessionId, "installing");
                            return;
                        case 5:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install successfully.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            PlayStoreDeferredComponentManager playStoreDeferredComponentManager = this.this$0;
                            playStoreDeferredComponentManager.loadAssets(playStoreDeferredComponentManager.sessionIdToLoadingUnitId.get(sessionId), (String) this.this$0.sessionIdToName.get(sessionId));
                            if (this.this$0.sessionIdToLoadingUnitId.get(sessionId) > 0) {
                                PlayStoreDeferredComponentManager playStoreDeferredComponentManager2 = this.this$0;
                                playStoreDeferredComponentManager2.loadDartLibrary(playStoreDeferredComponentManager2.sessionIdToLoadingUnitId.get(sessionId), (String) this.this$0.sessionIdToName.get(sessionId));
                            }
                            if (this.this$0.channel != null) {
                                this.this$0.channel.completeInstallSuccess((String) this.this$0.sessionIdToName.get(sessionId));
                            }
                            this.this$0.sessionIdToName.delete(sessionId);
                            this.this$0.sessionIdToLoadingUnitId.delete(sessionId);
                            this.this$0.sessionIdToState.put(sessionId, "installed");
                            return;
                        case 6:
                            Log.e(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install failed with: %s", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId), Integer.valueOf(splitInstallSessionState.errorCode())));
                            FlutterJNI flutterJNI = this.this$0.flutterJNI;
                            int i2 = this.this$0.sessionIdToLoadingUnitId.get(sessionId);
                            flutterJNI.deferredComponentInstallFailure(i2, "Module install failed with " + splitInstallSessionState.errorCode(), true);
                            if (this.this$0.channel != null) {
                                this.this$0.channel.completeInstallError((String) this.this$0.sessionIdToName.get(sessionId), "Android Deferred Component failed to install.");
                            }
                            this.this$0.sessionIdToName.delete(sessionId);
                            this.this$0.sessionIdToLoadingUnitId.delete(sessionId);
                            this.this$0.sessionIdToState.put(sessionId, f.f31931j);
                            return;
                        case 7:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install canceled.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            if (this.this$0.channel != null) {
                                this.this$0.channel.completeInstallError((String) this.this$0.sessionIdToName.get(sessionId), "Android Deferred Component installation canceled.");
                            }
                            this.this$0.sessionIdToName.delete(sessionId);
                            this.this$0.sessionIdToLoadingUnitId.delete(sessionId);
                            this.this$0.sessionIdToState.put(sessionId, "cancelled");
                            return;
                        case 8:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install requires user confirmation.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            this.this$0.sessionIdToState.put(sessionId, "requiresUserConfirmation");
                            return;
                        case 9:
                            Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install canceling.", this.this$0.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)));
                            this.this$0.sessionIdToState.put(sessionId, "canceling");
                            return;
                        default:
                            Log.d(PlayStoreDeferredComponentManager.TAG, "Unknown status: " + splitInstallSessionState.status());
                            return;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1096756500, "Lio/flutter/embedding/engine/deferredcomponents/PlayStoreDeferredComponentManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1096756500, "Lio/flutter/embedding/engine/deferredcomponents/PlayStoreDeferredComponentManager;");
                return;
            }
        }
        MAPPING_KEY = DeferredComponentManager.class.getName() + ".loadingUnitMapping";
    }

    public PlayStoreDeferredComponentManager(@NonNull Context context, @Nullable FlutterJNI flutterJNI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterJNI};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = context;
        this.flutterJNI = flutterJNI;
        this.flutterApplicationInfo = ApplicationInfoLoader.load(context);
        this.splitInstallManager = SplitInstallManagerFactory.create(context);
        FeatureInstallStateUpdatedListener featureInstallStateUpdatedListener = new FeatureInstallStateUpdatedListener(this, null);
        this.listener = featureInstallStateUpdatedListener;
        this.splitInstallManager.registerListener(featureInstallStateUpdatedListener);
        this.sessionIdToName = new SparseArray<>();
        this.sessionIdToLoadingUnitId = new SparseIntArray();
        this.sessionIdToState = new SparseArray<>();
        this.nameToSessionId = new HashMap();
        this.loadingUnitIdToComponentNames = new SparseArray<>();
        this.loadingUnitIdToSharedLibraryNames = new SparseArray<>();
        initLoadingUnitMappingToComponentNames();
    }

    @NonNull
    private ApplicationInfo getApplicationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            try {
                return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ApplicationInfo) invokeV.objValue;
    }

    private void initLoadingUnitMappingToComponentNames() {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            r0 = DeferredComponentManager.class.getName() + ".loadingUnitMapping";
            ApplicationInfo applicationInfo = getApplicationInfo();
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return;
            }
            String string = bundle.getString(MAPPING_KEY, null);
            if (string == null) {
                Log.e(TAG, "No loading unit to dynamic feature module name found. Ensure '" + MAPPING_KEY + "' is defined in the base module's AndroidManifest.");
            } else if (!string.equals("")) {
                for (String str : string.split(",")) {
                    String[] split = str.split(":", -1);
                    int parseInt = Integer.parseInt(split[0]);
                    this.loadingUnitIdToComponentNames.put(parseInt, split[1]);
                    if (split.length > 2) {
                        this.loadingUnitIdToSharedLibraryNames.put(parseInt, split[2]);
                    }
                }
            }
        }
    }

    private boolean verifyJNI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.flutterJNI == null) {
                Log.e(TAG, "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.splitInstallManager.unregisterListener(this.listener);
            this.channel = null;
            this.flutterJNI = null;
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public String getDeferredComponentInstallState(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (str == null) {
                str = this.loadingUnitIdToComponentNames.get(i2);
            }
            if (str == null) {
                Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
                return "unknown";
            } else if (this.nameToSessionId.containsKey(str)) {
                return this.sessionIdToState.get(this.nameToSessionId.get(str).intValue());
            } else {
                return this.splitInstallManager.getInstalledModules().contains(str) ? "installedPendingLoad" : "unknown";
            }
        }
        return (String) invokeIL.objValue;
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void installDeferredComponent(final int i2, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            final String str2 = str != null ? str : this.loadingUnitIdToComponentNames.get(i2);
            if (str2 == null) {
                Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
            } else if (str2.equals("") && i2 > 0) {
                loadDartLibrary(i2, str2);
            } else {
                this.splitInstallManager.startInstall(SplitInstallRequest.newBuilder().addModule(str2).build()).addOnSuccessListener(new OnSuccessListener() { // from class: g.a.a.b.b.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                }).addOnFailureListener(new OnFailureListener() { // from class: g.a.a.b.b.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                });
            }
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void loadAssets(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) && verifyJNI()) {
            try {
                Context createPackageContext = this.context.createPackageContext(this.context.getPackageName(), 0);
                this.context = createPackageContext;
                this.flutterJNI.updateJavaAssetManager(createPackageContext.getAssets(), this.flutterApplicationInfo.flutterAssetsDir);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void loadDartLibrary(int i2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) && verifyJNI() && i2 >= 0) {
            String str3 = this.loadingUnitIdToSharedLibraryNames.get(i2);
            if (str3 == null) {
                str3 = this.flutterApplicationInfo.aotSharedLibraryName + "-" + i2 + ".part.so";
            }
            if (Build.VERSION.SDK_INT >= 21) {
                str2 = Build.SUPPORTED_ABIS[0];
            } else {
                str2 = Build.CPU_ABI;
            }
            String replace = str2.replace("-", "_");
            ArrayList arrayList = new ArrayList();
            ArrayList<String> arrayList2 = new ArrayList();
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.context.getFilesDir());
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str4 : this.context.getApplicationInfo().splitSourceDirs) {
                    linkedList.add(new File(str4));
                }
            }
            while (!linkedList.isEmpty()) {
                File file = (File) linkedList.remove();
                if (file != null && file.isDirectory() && file.listFiles() != null) {
                    for (File file2 : file.listFiles()) {
                        linkedList.add(file2);
                    }
                } else {
                    String name = file.getName();
                    if (name.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && ((name.startsWith(str) || name.startsWith("split_config")) && name.contains(replace))) {
                        arrayList.add(file.getAbsolutePath());
                    } else if (name.equals(str3)) {
                        arrayList2.add(file.getAbsolutePath());
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(str3);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.add(((String) it.next()) + "!lib/" + str2 + "/" + str3);
            }
            for (String str5 : arrayList2) {
                arrayList3.add(str5);
            }
            this.flutterJNI.loadDartDeferredLibrary(i2, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, deferredComponentChannel) == null) {
            this.channel = deferredComponentChannel;
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void setJNI(@NonNull FlutterJNI flutterJNI) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, flutterJNI) == null) {
            this.flutterJNI = flutterJNI;
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public boolean uninstallDeferredComponent(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, str)) == null) {
            if (str == null) {
                str = this.loadingUnitIdToComponentNames.get(i2);
            }
            if (str == null) {
                Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.splitInstallManager.deferredUninstall(arrayList);
            if (this.nameToSessionId.get(str) != null) {
                this.sessionIdToState.delete(this.nameToSessionId.get(str).intValue());
                return true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }
}
