package de.simolus3.fluttie;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import com.airbnb.lottie.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.i;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.example.flutter_lottie.LottieNameTransform;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@RequiresApi(api = 15)
/* loaded from: classes20.dex */
public class FluttiePlugin implements Application.ActivityLifecycleCallbacks, MethodChannel.MethodCallHandler {
    private PluginRegistry.Registrar registrar;
    private RenderingThreads renderingThreads;
    private SparseArray<FluttieAnimation> managedAnimations = new SparseArray<>();
    private SparseArray<e> loadedCompositions = new SparseArray<>();
    private AtomicInteger compositionRequestCounter = new AtomicInteger();

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new FluttiePlugin(registrar).setUp();
    }

    private FluttiePlugin(PluginRegistry.Registrar registrar) {
        this.registrar = registrar;
    }

    private void setUp() {
        new MethodChannel(this.registrar.messenger(), "fluttie/methods").setMethodCallHandler(this);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this);
        this.renderingThreads = new RenderingThreads(1);
        this.renderingThreads.start();
    }

    private List<FluttieAnimation> getAllManagedAnimations() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.managedAnimations.size(); i++) {
            arrayList.add(this.managedAnimations.get(this.managedAnimations.keyAt(i)));
        }
        return arrayList;
    }

    private FluttieAnimation getManagedAnimation(MethodCall methodCall) {
        return this.managedAnimations.get(((Integer) methodCall.argument("id")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderingThreads getRenderingThreads() {
        return this.renderingThreads;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -2034067138:
                if (str.equals("loadAnimation")) {
                    c = 1;
                    break;
                }
                break;
            case -1296995794:
                if (str.equals("pauseAnimation")) {
                    c = 5;
                    break;
                }
                break;
            case 444517567:
                if (str.equals("isAvailable")) {
                    c = 0;
                    break;
                }
                break;
            case 466061349:
                if (str.equals("disposeAnimation")) {
                    c = 7;
                    break;
                }
                break;
            case 707295465:
                if (str.equals("endAnimation")) {
                    c = 6;
                    break;
                }
                break;
            case 764167490:
                if (str.equals("startAnimation")) {
                    c = 3;
                    break;
                }
                break;
            case 1236882903:
                if (str.equals("resumeAnimation")) {
                    c = 4;
                    break;
                }
                break;
            case 2090329661:
                if (str.equals("prepareAnimation")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                result.success(Boolean.valueOf(Build.VERSION.SDK_INT >= 21));
                return;
            case 1:
                loadComposition(this.compositionRequestCounter.getAndIncrement(), (String) methodCall.argument(UgcConstant.SOURCE_TYPE), (String) methodCall.argument("source"), result);
                return;
            case 2:
                int intValue = ((Integer) methodCall.argument("composition")).intValue();
                e eVar = this.loadedCompositions.get(intValue);
                if (eVar == null) {
                    result.error("invalid", "There is no prepared animation for that request id: " + intValue, null);
                    return;
                }
                int intValue2 = ((Integer) methodCall.argument("repeat_count")).intValue();
                int i = ((Boolean) methodCall.argument("repeat_reverse")).booleanValue() ? 2 : 1;
                int intValue3 = ((Integer) methodCall.argument("duration")).intValue();
                double doubleValue = ((Double) methodCall.argument("pref_size_h")).doubleValue();
                double doubleValue2 = ((Double) methodCall.argument("pref_size_h")).doubleValue();
                float f = 1.0f;
                if (doubleValue > 0.0d && doubleValue2 > 0.0d) {
                    f = (float) Math.min(doubleValue / eVar.iu().height(), doubleValue2 / eVar.iu().width());
                }
                TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.registrar.textures().createSurfaceTexture();
                FluttieAnimation fluttieAnimation = new FluttieAnimation(this, createSurfaceTexture, eVar, f, (String) methodCall.argument("img_assets_path"));
                fluttieAnimation.setRepeatOptions(intValue2, i);
                if (intValue3 > 0) {
                    fluttieAnimation.setDuration(intValue3);
                }
                this.managedAnimations.put((int) createSurfaceTexture.id(), fluttieAnimation);
                result.success(Long.valueOf(createSurfaceTexture.id()));
                return;
            case 3:
                getManagedAnimation(methodCall).startAnimation();
                result.success(null);
                return;
            case 4:
                getManagedAnimation(methodCall).resumeAnimation();
                result.success(null);
                return;
            case 5:
                getManagedAnimation(methodCall).pauseAnimation();
                result.success(null);
                return;
            case 6:
                getManagedAnimation(methodCall).stopAnimation(((Boolean) methodCall.argument("reset_start")).booleanValue());
                result.success(null);
                return;
            case 7:
                FluttieAnimation managedAnimation = getManagedAnimation(methodCall);
                managedAnimation.stopAndRelease();
                this.managedAnimations.remove(managedAnimation.getId());
                this.renderingThreads.getQueue().removeAnimation(managedAnimation);
                result.success(null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    private void loadComposition(final int i, String str, String str2, final MethodChannel.Result result) {
        i<e> iVar = new i<e>() { // from class: de.simolus3.fluttie.FluttiePlugin.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(@Nullable e eVar) {
                try {
                    if (eVar == null) {
                        result.error("Could not load composition", "CompositionLoadError", null);
                        return;
                    }
                    if (!eVar.it().isEmpty()) {
                        Iterator<String> it = eVar.it().iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                    FluttiePlugin.this.loadedCompositions.append(i, eVar);
                    try {
                        result.success(Integer.valueOf(i));
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                } catch (Throwable th) {
                    result.error(th.getMessage(), "CompositionLoadError", null);
                }
            }
        };
        i<Throwable> iVar2 = new i<Throwable>() { // from class: de.simolus3.fluttie.FluttiePlugin.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(Throwable th) {
            }
        };
        char c = 65535;
        switch (str.hashCode()) {
            case -1183997287:
                if (str.equals("inline")) {
                    c = 0;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    c = 2;
                    break;
                }
                break;
            case 93121264:
                if (str.equals("asset")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                f.n(str2, null).a(iVar).c(iVar2);
                return;
            case 1:
                f.t(this.registrar.context(), this.registrar.lookupKeyForAsset(str2)).a(iVar).c(iVar2);
                return;
            case 2:
                if (str2.endsWith(".json")) {
                    str2 = str2.substring(0, str2.length() - 5);
                }
                int identifier = g.li().getResources().getIdentifier(LottieNameTransform.getAndroidNameFromIos(str2), "raw", BdBaseApplication.getInst().getPackageName());
                if (identifier != 0) {
                    f.d(this.registrar.context(), identifier).a(iVar).c(iVar2);
                    return;
                } else {
                    BdLog.e("flutter lottie resource in package not found :" + str2);
                    return;
                }
            default:
                result.error("Unknown source type: " + str, "UnknownSourceType", null);
                return;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity == this.registrar.activity() && this.renderingThreads != null) {
            this.renderingThreads.start();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == this.registrar.activity()) {
            for (FluttieAnimation fluttieAnimation : getAllManagedAnimations()) {
                if (fluttieAnimation.isPausedButNotByUser()) {
                    fluttieAnimation.setPausedButNotByUser(false);
                    fluttieAnimation.resumeAnimation();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity == this.registrar.activity()) {
            for (FluttieAnimation fluttieAnimation : getAllManagedAnimations()) {
                if (fluttieAnimation.isPlaying()) {
                    fluttieAnimation.pauseAnimation();
                    fluttieAnimation.setPausedButNotByUser(true);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity == this.registrar.activity()) {
            this.renderingThreads.stop();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
